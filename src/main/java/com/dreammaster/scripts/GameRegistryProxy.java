package com.dreammaster.scripts;

import java.util.function.Consumer;

import javax.annotation.Nonnull;

import net.minecraft.item.crafting.IRecipe;

import com.dreammaster.recipes.Recipe;
import com.dreammaster.recipes.ShapedUniversalRecipe;
import com.dreammaster.recipes.ShapelessUniversalRecipe;

import cpw.mods.fml.common.registry.GameRegistry;

class GameRegistryProxy {

    private static final GameRegistryProxy INSTANCE = new GameRegistryProxy();

    static Consumer<Recipe> shapedRecipes() {
        return INSTANCE::addShapedRecipe;
    }

    static Consumer<Recipe> shapelessRecipes() {
        return INSTANCE::addShapelessRecipe;
    }

    private void addShapedRecipe(Recipe recipe) {
        GameRegistry.addRecipe(processIntoShapedRecipe(recipe));
    }

    @Nonnull
    private IRecipe processIntoShapedRecipe(Recipe recipe) {
        return new ShapedUniversalRecipe(recipe.getResult(), recipe.getIngredients());
    }

    private void addShapelessRecipe(Recipe recipe) {
        GameRegistry.addRecipe(proceessIntoShapelessRecipe(recipe));
    }

    @Nonnull
    private IRecipe proceessIntoShapelessRecipe(Recipe recipe) {
        return new ShapelessUniversalRecipe(recipe.getResult(), recipe.getIngredients());
    }
}
