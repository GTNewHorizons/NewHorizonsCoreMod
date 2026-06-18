package com.dreammaster.sgcalc.source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

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
 * Reversal recipes -- the macerator, arc furnace and fluid extractor melting or grinding a finished part back into its
 * material -- are not filtered here: the cost selector already rejects them because the finished part has no producer
 * and so costs infinity, which makes the real forward recipe win. A melt step that is the only way to make a fluid
 * (e.g. Molten Reinforced Glass from solid Reinforced Glass) therefore still works.
 */
public final class GTRecipeMapSource implements RecipeSource {

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
        List<Output> outputs = new ArrayList<>();
        if (recipe.mOutputs != null) {
            for (int i = 0; i < recipe.mOutputs.length; i++) {
                ItemStack out = recipe.mOutputs[i];
                if (!GridInputs.isValid(out)) continue;
                outputs.add(new Output(SGItem.of(out), out.stackSize, recipe.getOutputChance(i)));
            }
        }
        if (recipe.mFluidOutputs != null) {
            for (FluidStack out : recipe.mFluidOutputs) {
                if (GridInputs.isValid(out)) outputs.add(new Output(SGItem.of(out), out.amount));
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
}
