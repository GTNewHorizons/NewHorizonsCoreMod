package com.dreammaster.sgcalc.source;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.dreammaster.main.MainRegistry;
import com.dreammaster.sgcalc.RecipeCandidate;
import com.dreammaster.sgcalc.RecipeCandidate.Ingredient;
import com.dreammaster.sgcalc.RecipeSource;

/** Vanilla/Forge crafting-table recipes, covering the four common {@link IRecipe} implementations. */
public final class VanillaCraftingSource implements RecipeSource {

    @Override
    public void collect(Consumer<RecipeCandidate> sink) {
        for (Object obj : CraftingManager.getInstance().getRecipeList()) {
            if (!(obj instanceof IRecipe recipe)) continue;
            try {
                collect(recipe, sink);
            } catch (Throwable t) {
                MainRegistry.LOGGER.warn("sgcalc: skipped a vanilla recipe: " + t);
            }
        }
    }

    private static void collect(IRecipe recipe, Consumer<RecipeCandidate> sink) {
        ItemStack out = recipe.getRecipeOutput();
        if (!GridInputs.isValid(out)) return;

        List<?> elements;
        if (recipe instanceof ShapedRecipes shaped) {
            elements = Arrays.asList(shaped.recipeItems);
        } else if (recipe instanceof ShapelessRecipes shapeless) {
            elements = shapeless.recipeItems;
        } else if (recipe instanceof ShapedOreRecipe shapedOre) {
            elements = Arrays.asList(shapedOre.getInput());
        } else if (recipe instanceof ShapelessOreRecipe shapelessOre) {
            elements = shapelessOre.getInput();
        } else {
            return;
        }

        List<Ingredient> inputs = GridInputs.collapse(elements);
        if (inputs.isEmpty()) return;
        sink.accept(new RecipeCandidate("vanilla", inputs, Collections.singletonList(GridInputs.stackOutput(out))));
    }
}
