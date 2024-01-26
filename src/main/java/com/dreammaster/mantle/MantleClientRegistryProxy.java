package com.dreammaster.mantle;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;

import com.dreammaster.recipes.Recipe;

import mantle.lib.client.MantleClientRegistry;

class MantleClientRegistryProxy implements MantleManualRecipeRegistry {

    @Override
    @Nonnull
    public Consumer<Recipe> manualCraftingRecipeNamed(String manualRecipeName) {
        Objects.requireNonNull(manualRecipeName);
        return (recipe) -> setTicoManualRecipe(manualRecipeName, recipe.getResult(), recipe.flatten());
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
