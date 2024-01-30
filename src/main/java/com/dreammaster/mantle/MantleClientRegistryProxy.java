package com.dreammaster.mantle;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;

import com.dreammaster.recipes.Recipe;
import com.dreammaster.recipes.ShapedIngredientsResolver;
import com.dreammaster.recipes.ShapelessIngredientsResolver;

import mantle.lib.client.MantleClientRegistry;

/**
 * Implementation class. Access it through MantleManualRecipeRegistry::getInstance
 */
class MantleClientRegistryProxy implements MantleManualRecipeRegistry {

    private static final UnaryOperator<Object[]> SHAPED_INGREDIENTS_RESOLVER = new ShapedIngredientsResolver();
    private static final UnaryOperator<Object[]> SHAPELESS_INGREDIENTS_RESOLVER = new ShapelessIngredientsResolver();

    @Override
    @Nonnull
    public Consumer<Recipe> manualShapedCraftingRecipeNamed(String manualRecipeName) {
        Objects.requireNonNull(manualRecipeName);
        return (recipe) -> setTicoManualRecipe(
                manualRecipeName,
                recipe.getResult(),
                recipe.flattenWith(SHAPED_INGREDIENTS_RESOLVER));
    }

    @Nonnull
    @Override
    public Consumer<Recipe> manualShapelessCraftingRecipeNamed(String manualRecipeName) {
        Objects.requireNonNull(manualRecipeName);
        return (recipe) -> setTicoManualRecipe(
                manualRecipeName,
                recipe.getResult(),
                recipe.flattenWith(SHAPELESS_INGREDIENTS_RESOLVER));
    }

    private void setTicoManualRecipe(String name, ItemStack result, ItemStack[] recipe) {
        if (recipe.length <= 4) {
            MantleClientRegistry.registerManualSmallRecipe(name, result, Arrays.copyOf(recipe, 4));
        } else if (recipe.length <= 9) {
            MantleClientRegistry.registerManualLargeRecipe(name, result, Arrays.copyOf(recipe, 9));
        } else {
            throw new IllegalArgumentException("Recipe has too many ingredients: " + Arrays.toString(recipe));
        }
    }

    @Override
    @Nonnull
    public Consumer<Recipe> manualSmeltingRecipeNamed(String manualRecipeName) {
        Objects.requireNonNull(manualRecipeName);
        return (recipe) -> MantleClientRegistry
                .registerManualFurnaceRecipe(manualRecipeName, recipe.getResult(), recipe.flatten()[0]);
    }

}
