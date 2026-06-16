package com.dreammaster.sgcalc.source;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import com.dreammaster.main.MainRegistry;
import com.dreammaster.sgcalc.RecipeCandidate;
import com.dreammaster.sgcalc.RecipeCandidate.Ingredient;
import com.dreammaster.sgcalc.RecipeSource;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import fox.spiteful.avaritia.crafting.ExtremeShapedOreRecipe;
import fox.spiteful.avaritia.crafting.ExtremeShapedRecipe;
import fox.spiteful.avaritia.crafting.ExtremeShapelessRecipe;

/**
 * Avaritia Extreme Crafting Table recipes -- where every Stargate block/item is defined. Isolated in its own class so
 * the rest of the calculator loads even when Avaritia is absent; callers must guard construction behind a mod-loaded
 * check.
 */
public final class AvaritiaSource implements RecipeSource {

    @Override
    public void collect(Consumer<RecipeCandidate> sink) {
        for (Object obj : ExtremeCraftingManager.getInstance().getRecipeList()) {
            if (!(obj instanceof IRecipe recipe)) continue;
            try {
                collect(recipe, sink);
            } catch (Throwable t) {
                MainRegistry.LOGGER.warn("sgcalc: skipped an Avaritia recipe: " + t);
            }
        }
    }

    private static void collect(IRecipe recipe, Consumer<RecipeCandidate> sink) {
        ItemStack out = recipe.getRecipeOutput();
        if (!GridInputs.isValid(out)) return;

        List<?> elements;
        if (recipe instanceof ExtremeShapedOreRecipe shapedOre) {
            elements = Arrays.asList(shapedOre.getInput());
        } else if (recipe instanceof ExtremeShapedRecipe shaped) {
            elements = Arrays.asList(shaped.recipeItems);
        } else if (recipe instanceof ExtremeShapelessRecipe shapeless) {
            elements = shapeless.recipeItems;
        } else {
            return;
        }

        List<Ingredient> inputs = GridInputs.collapse(elements);
        if (inputs.isEmpty()) return;
        sink.accept(new RecipeCandidate("avaritia", inputs, Collections.singletonList(GridInputs.stackOutput(out))));
    }
}
