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
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.main.MainRegistry;
import com.dreammaster.sgcalc.RecipeCandidate;
import com.dreammaster.sgcalc.RecipeCandidate.Ingredient;
import com.dreammaster.sgcalc.RecipeCandidate.Output;
import com.dreammaster.sgcalc.RecipeSource;
import com.dreammaster.sgcalc.SGItem;

import gregtech.api.recipe.RecipeMap;
import gregtech.api.util.GTRecipe;

/**
 * Every GregTech machine recipe, across all of {@link RecipeMap#ALL_RECIPE_MAPS}. The map key is the recipe map's
 * unlocalized name and becomes the candidate source id (e.g. `gt:gt.recipe.plasmaforge`). This already covers the
 * Component Assembly Line and Precise Assembler, which register normal recipe maps.
 *
 * In the recycling maps (macerator, arc furnace, fluid extractor) production starts from a raw material form -- an ore,
 * crushed ore, dust, gem, ingot or nugget. A recipe that outputs a base material form (dust, ingot, nugget or molten
 * fluid) without consuming any such raw form is recycling: it melts or grinds a finished part, block or machine back
 * into its material. Such an output is dropped (a recipe left with no other output is skipped) only when the material
 * has a real forward producer elsewhere -- otherwise the reversal is the only way to make it (e.g. Molten Reinforced
 * Glass, cast only from solid Reinforced Glass) and is kept. Dropping the redundant reversals keeps them out of the
 * cost graph entirely, which both avoids the wrong path and stops the material-form cycles they create from blowing up
 * the cost walk.
 */
public final class GTRecipeMapSource implements RecipeSource {

    private static final Set<String> RECYCLING_MAPS = new HashSet<>(
            Arrays.asList("gt:gt.recipe.macerator", "gt:gt.recipe.arcfurnace", "gt:gt.recipe.fluidextractor"));

    /** Ore-dictionary prefixes of raw material forms -- the legitimate starting point of production in these maps. */
    private static final String[] RAW_PREFIXES = { "ore", "crushed", "dust", "gem", "ingot", "nugget" };

    /** Base material forms a finished item is recycled back into. */
    private static final String[] BASE_PREFIXES = { "dust", "ingot", "nugget" };

    @Override
    public void collect(Consumer<RecipeCandidate> sink) {
        Set<String> forwardOutputs = collectForwardOutputs();
        for (Map.Entry<String, RecipeMap<?>> entry : RecipeMap.ALL_RECIPE_MAPS.entrySet()) {
            String sourceId = "gt:" + entry.getKey();
            boolean recyclingMap = RECYCLING_MAPS.contains(sourceId);
            for (GTRecipe recipe : entry.getValue().getAllRecipes()) {
                if (!recipe.mEnabled || recipe.mFakeRecipe || recipe.mHidden) continue;
                try {
                    collect(sourceId, recipe, recyclingMap, forwardOutputs, sink);
                } catch (Throwable t) {
                    MainRegistry.LOGGER.warn("sgcalc: skipped a recipe in " + sourceId + ": " + t);
                }
            }
        }
    }

    /**
     * Output keys produced by a recipe other than a recycling reversal: every non-recycling recipe, plus the recycling
     * recipes that do start from a raw form. A recycled base output is only dropped when its key is in here, i.e. when
     * something else already makes it.
     */
    private static Set<String> collectForwardOutputs() {
        Set<String> keys = new HashSet<>();
        for (Map.Entry<String, RecipeMap<?>> entry : RecipeMap.ALL_RECIPE_MAPS.entrySet()) {
            boolean recyclingMap = RECYCLING_MAPS.contains("gt:" + entry.getKey());
            for (GTRecipe recipe : entry.getValue().getAllRecipes()) {
                if (!recipe.mEnabled || recipe.mFakeRecipe || recipe.mHidden) continue;
                if (recyclingMap && !hasRawMaterialInput(recipe)) continue;
                try {
                    addOutputKeys(recipe, keys);
                } catch (Throwable ignored) {}
            }
        }
        return keys;
    }

    private static void addOutputKeys(GTRecipe recipe, Set<String> keys) {
        if (recipe.mOutputs != null) {
            for (ItemStack out : recipe.mOutputs) {
                if (GridInputs.isValid(out)) keys.add(SGItem.of(out).key);
            }
        }
        if (recipe.mFluidOutputs != null) {
            for (FluidStack out : recipe.mFluidOutputs) {
                if (GridInputs.isValid(out)) keys.add(SGItem.of(out).key);
            }
        }
    }

    private static void collect(String sourceId, GTRecipe recipe, boolean recyclingMap, Set<String> forwardOutputs,
            Consumer<RecipeCandidate> sink) {
        boolean dropRecycled = recyclingMap && !hasRawMaterialInput(recipe);

        List<Output> outputs = new ArrayList<>();
        if (recipe.mOutputs != null) {
            for (int i = 0; i < recipe.mOutputs.length; i++) {
                ItemStack out = recipe.mOutputs[i];
                if (!GridInputs.isValid(out)) continue;
                SGItem item = SGItem.of(out);
                if (dropRecycled && oreNameHasPrefix(out, BASE_PREFIXES) && forwardOutputs.contains(item.key)) continue;
                outputs.add(new Output(item, out.stackSize, recipe.getOutputChance(i)));
            }
        }
        if (recipe.mFluidOutputs != null) {
            for (FluidStack out : recipe.mFluidOutputs) {
                if (!GridInputs.isValid(out)) continue;
                SGItem item = SGItem.of(out);
                if (dropRecycled && isMolten(out) && forwardOutputs.contains(item.key)) continue;
                outputs.add(new Output(item, out.amount));
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

    private static boolean hasRawMaterialInput(GTRecipe recipe) {
        if (recipe.mInputs == null) return false;
        for (ItemStack in : recipe.mInputs) {
            if (GridInputs.isValid(in) && oreNameHasPrefix(in, RAW_PREFIXES)) return true;
        }
        return false;
    }

    private static boolean isMolten(FluidStack fluid) {
        return fluid.getFluid() != null && fluid.getFluid().getName() != null
                && fluid.getFluid().getName().startsWith("molten.");
    }

    /**
     * Whether any of the stack's ore-dictionary names is one of {@code prefixes} followed by a capitalised material
     * name (e.g. `plateRuridit`), which both classifies the form and identifies its material across material systems.
     */
    private static boolean oreNameHasPrefix(ItemStack stack, String[] prefixes) {
        for (int id : OreDictionary.getOreIDs(stack)) {
            String name = OreDictionary.getOreName(id);
            if (name == null) continue;
            for (String prefix : prefixes) {
                if (name.length() > prefix.length() && name.startsWith(prefix)
                        && Character.isUpperCase(name.charAt(prefix.length()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
