package com.dreammaster.sgcalc.source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

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
 */
public final class GTRecipeMapSource implements RecipeSource {

    @Override
    public void collect(Consumer<RecipeCandidate> sink) {
        for (Map.Entry<String, RecipeMap<?>> entry : RecipeMap.ALL_RECIPE_MAPS.entrySet()) {
            String sourceId = "gt:" + entry.getKey();
            for (GTRecipe recipe : entry.getValue().getAllRecipes()) {
                if (!recipe.mEnabled || recipe.mFakeRecipe || recipe.mHidden) continue;

                List<Output> outputs = new ArrayList<>();
                if (recipe.mOutputs != null) {
                    for (ItemStack out : recipe.mOutputs) {
                        if (out != null && out.getItem() != null && out.stackSize > 0) {
                            outputs.add(new Output(SGItem.of(out), out.stackSize));
                        }
                    }
                }
                if (recipe.mFluidOutputs != null) {
                    for (FluidStack out : recipe.mFluidOutputs) {
                        if (out != null && out.getFluid() != null && out.amount > 0) {
                            outputs.add(new Output(SGItem.of(out), out.amount));
                        }
                    }
                }
                if (outputs.isEmpty()) continue;

                List<Ingredient> inputs = new ArrayList<>();
                if (recipe.mInputs != null) {
                    for (ItemStack in : recipe.mInputs) {
                        if (in == null || in.getItem() == null || in.stackSize <= 0) continue;
                        if (GridInputs.isIgnored(in)) continue;
                        inputs.add(new Ingredient(Collections.singletonList(SGItem.of(in)), in.stackSize));
                    }
                }
                if (recipe.mFluidInputs != null) {
                    for (FluidStack in : recipe.mFluidInputs) {
                        if (in == null || in.getFluid() == null || in.amount <= 0) continue;
                        inputs.add(new Ingredient(Collections.singletonList(SGItem.of(in)), in.amount));
                    }
                }
                sink.accept(new RecipeCandidate(sourceId, inputs, outputs));
            }
        }
    }
}
