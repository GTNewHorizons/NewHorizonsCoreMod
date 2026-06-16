package com.dreammaster.sgcalc.source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.main.MainRegistry;
import com.dreammaster.sgcalc.RecipeCandidate;
import com.dreammaster.sgcalc.RecipeCandidate.Ingredient;
import com.dreammaster.sgcalc.RecipeCandidate.Output;
import com.dreammaster.sgcalc.RecipeSource;
import com.dreammaster.sgcalc.SGItem;

import gregtech.api.util.GTRecipe.RecipeAssemblyLine;

/**
 * GregTech Assembly Line recipes, which live in their own static list rather than a
 * {@link gregtech.api.recipe.RecipeMap} and produce a single output. Per-slot ore-dictionary alternatives are carried
 * through via {@code mOreDictAlt}.
 */
public final class AssemblyLineSource implements RecipeSource {

    @Override
    public void collect(Consumer<RecipeCandidate> sink) {
        for (RecipeAssemblyLine recipe : RecipeAssemblyLine.sAssemblylineRecipes) {
            if (!GridInputs.isValid(recipe.mOutput)) continue;
            try {
                collect(recipe, sink);
            } catch (Throwable t) {
                MainRegistry.LOGGER.warn("sgcalc: skipped an assembly line recipe: " + t);
            }
        }
    }

    private static void collect(RecipeAssemblyLine recipe, Consumer<RecipeCandidate> sink) {
        List<Output> outputs = Collections.singletonList(GridInputs.stackOutput(recipe.mOutput));

        List<Ingredient> inputs = new ArrayList<>();
        if (recipe.mInputs != null) {
            for (int i = 0; i < recipe.mInputs.length; i++) {
                ItemStack in = recipe.mInputs[i];
                if (!GridInputs.isValid(in)) continue;

                List<SGItem> alts = new ArrayList<>();
                if (recipe.mOreDictAlt != null && i < recipe.mOreDictAlt.length && recipe.mOreDictAlt[i] != null) {
                    for (ItemStack alt : recipe.mOreDictAlt[i]) {
                        if (GridInputs.isValid(alt)) alts.add(SGItem.of(alt));
                    }
                }
                if (alts.isEmpty()) alts.add(SGItem.of(in));
                inputs.add(new Ingredient(alts, in.stackSize));
            }
        }
        if (recipe.mFluidInputs != null) {
            for (FluidStack in : recipe.mFluidInputs) {
                if (GridInputs.isValid(in)) inputs.add(GridInputs.fluidIngredient(in));
            }
        }
        sink.accept(new RecipeCandidate("assemblyline", inputs, outputs));
    }
}
