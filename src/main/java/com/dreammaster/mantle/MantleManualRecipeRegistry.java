package com.dreammaster.mantle;

import java.util.function.Consumer;

import javax.annotation.Nonnull;

import com.dreammaster.recipes.Recipe;

public interface MantleManualRecipeRegistry {

    @Nonnull
    static MantleManualRecipeRegistry getInstance() {
        return new MantleClientRegistryProxy();
    }

    @Nonnull
    Consumer<Recipe> manualCraftingRecipeNamed(String manualRecipeName);

    @Nonnull
    Consumer<Recipe> manualSmeltingRecipeNamed(String manualRecipeName);
}
