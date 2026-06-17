package com.dreammaster.sgcalc.source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.main.MainRegistry;
import com.dreammaster.sgcalc.RecipeCandidate;
import com.dreammaster.sgcalc.RecipeCandidate.Ingredient;
import com.dreammaster.sgcalc.RecipeCandidate.Output;
import com.dreammaster.sgcalc.RecipeSource;
import com.dreammaster.sgcalc.SGItem;

import gregtech.api.enums.Materials;
import gregtech.api.objects.ItemData;
import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTRecipe;

/**
 * Every GregTech machine recipe, across all of {@link RecipeMap#ALL_RECIPE_MAPS}. The map key is the recipe map's
 * unlocalized name and becomes the candidate source id (e.g. `gt:gt.recipe.plasmaforge`). This already covers the
 * Component Assembly Line and Precise Assembler, which register normal recipe maps.
 *
 * In the recycling maps (macerator, arc furnace, fluid extractor) material recycling outputs are dropped: an output
 * that is a base form (dust, ingot, nugget or molten fluid) of a material the recipe consumes as a manufactured
 * component (a plate, gear, wire, rod, tool head, etc.) is a recycling by-product, not a production path, and would
 * otherwise let a material be "made" by melting down a finished part that can never decompose to raws. A recipe left
 * with no other output is skipped entirely. The filter is scoped to those maps so production maps that legitimately
 * turn a material into its molten form (e.g. the plasma forge) are never affected.
 */
public final class GTRecipeMapSource implements RecipeSource {

    private static final Set<String> RECYCLING_MAPS = new HashSet<>(
            Arrays.asList("gt:gt.recipe.macerator", "gt:gt.recipe.arcfurnace", "gt:gt.recipe.fluidextractor"));

    @Override
    public void collect(Consumer<RecipeCandidate> sink) {
        for (Map.Entry<String, RecipeMap<?>> entry : RecipeMap.ALL_RECIPE_MAPS.entrySet()) {
            String sourceId = "gt:" + entry.getKey();
            for (GTRecipe recipe : entry.getValue().getAllRecipes()) {
                if (!recipe.mEnabled || recipe.mFakeRecipe || recipe.mHidden) continue;
                try {
                    collect(sourceId, recipe, sink);
                } catch (Throwable t) {
                    MainRegistry.LOGGER.warn("sgcalc: skipped a recipe in " + sourceId + ": " + t);
                }
            }
        }
    }

    private static void collect(String sourceId, GTRecipe recipe, Consumer<RecipeCandidate> sink) {
        Set<String> recycled = RECYCLING_MAPS.contains(sourceId) ? componentInputMaterials(recipe)
                : Collections.emptySet();

        List<Output> outputs = new ArrayList<>();
        if (recipe.mOutputs != null) {
            for (int i = 0; i < recipe.mOutputs.length; i++) {
                ItemStack out = recipe.mOutputs[i];
                if (!GridInputs.isValid(out) || isRecyclingOutput(out, recycled)) continue;
                outputs.add(new Output(SGItem.of(out), out.stackSize, recipe.getOutputChance(i)));
            }
        }
        if (recipe.mFluidOutputs != null) {
            for (FluidStack out : recipe.mFluidOutputs) {
                if (!GridInputs.isValid(out) || isRecyclingFluid(out, recycled)) continue;
                outputs.add(new Output(SGItem.of(out), out.amount));
            }
        }
        if (outputs.isEmpty()) return;

        List<Ingredient> inputs = new ArrayList<>();
        if (recipe.mInputs != null) {
            for (ItemStack in : recipe.mInputs) {
                if (!GridInputs.isValid(in) || GridInputs.isIgnored(in)) continue;
                inputs.add(new Ingredient(Collections.singletonList(SGItem.of(in)), in.stackSize));
            }
        }
        if (recipe.mFluidInputs != null) {
            for (FluidStack in : recipe.mFluidInputs) {
                if (GridInputs.isValid(in)) inputs.add(GridInputs.fluidIngredient(in));
            }
        }
        sink.accept(new RecipeCandidate(sourceId, inputs, outputs, recipe.mEUt, recipe.mDuration));
    }

    /** Names of the materials this recipe consumes as a manufactured component (anything past dust/ingot/gem). */
    private static Set<String> componentInputMaterials(GTRecipe recipe) {
        Set<String> materials = new HashSet<>();
        if (recipe.mInputs == null) return materials;
        for (ItemStack in : recipe.mInputs) {
            if (!GridInputs.isValid(in)) continue;
            ItemData data = GTOreDictUnificator.getAssociation(in);
            if (data != null && data.mPrefix != null
                    && data.mMaterial != null
                    && data.mMaterial.mMaterial != null
                    && !isRawForm(data.mPrefix.toString())) {
                materials.add(data.mMaterial.mMaterial.mName);
            }
        }
        return materials;
    }

    private static boolean isRecyclingOutput(ItemStack out, Set<String> recycled) {
        if (recycled.isEmpty()) return false;
        ItemData data = GTOreDictUnificator.getAssociation(out);
        return data != null && data.mPrefix != null
                && data.mMaterial != null
                && data.mMaterial.mMaterial != null
                && isBaseForm(data.mPrefix.toString())
                && recycled.contains(data.mMaterial.mMaterial.mName);
    }

    private static boolean isRecyclingFluid(FluidStack out, Set<String> recycled) {
        if (recycled.isEmpty()) return false;
        Materials material = Materials.getGtMaterialFromFluid(out.getFluid());
        return material != null && recycled.contains(material.mName);
    }

    /** Ore, crushed, dust, gem, ingot, nugget and block forms are raw material processing stages, not components. */
    private static boolean isRawForm(String prefix) {
        return prefix.startsWith("ore") || prefix.startsWith("crushed")
                || prefix.startsWith("dust")
                || prefix.startsWith("gem")
                || prefix.equals("ingot")
                || prefix.equals("ingotHot")
                || prefix.equals("nugget")
                || prefix.equals("block")
                || prefix.equals("rawOre");
    }

    /** The base forms a component is recycled back into. */
    private static boolean isBaseForm(String prefix) {
        return prefix.startsWith("dust") || prefix.equals("ingot")
                || prefix.equals("ingotHot")
                || prefix.equals("nugget");
    }
}
