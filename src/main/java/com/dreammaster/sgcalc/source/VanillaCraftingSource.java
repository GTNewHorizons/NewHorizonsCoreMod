package com.dreammaster.sgcalc.source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.dreammaster.sgcalc.RecipeCandidate;
import com.dreammaster.sgcalc.RecipeCandidate.Output;
import com.dreammaster.sgcalc.RecipeSource;
import com.dreammaster.sgcalc.SGItem;

/** Vanilla/Forge crafting-table recipes, covering the four common {@link IRecipe} implementations. */
public final class VanillaCraftingSource implements RecipeSource {

    @Override
    @SuppressWarnings("unchecked")
    public void collect(Consumer<RecipeCandidate> sink) {
        for (Object obj : CraftingManager.getInstance().getRecipeList()) {
            if (!(obj instanceof IRecipe recipe)) continue;
            ItemStack out = recipe.getRecipeOutput();
            if (out == null || out.getItem() == null || out.stackSize <= 0) continue;

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
                continue;
            }

            List<RecipeCandidate.Ingredient> inputs = GridInputs.collapse(elements);
            if (inputs.isEmpty()) continue;
            List<Output> outputs = new ArrayList<>();
            outputs.add(new Output(SGItem.of(out), out.stackSize));
            sink.accept(new RecipeCandidate("vanilla", inputs, outputs));
        }
    }
}
