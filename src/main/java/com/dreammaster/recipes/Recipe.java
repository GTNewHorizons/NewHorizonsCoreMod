package com.dreammaster.recipes;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;

public interface Recipe {

    @Nonnull
    static Recipe of(@Nonnull ItemStack result, @Nonnull Object... ingredients) {
        return new RecipeArgs(result, ingredients);
    }

    @Nonnull
    ItemStack getResult();

    @Nonnull
    Object[] getIngredients();

    @Nonnull
    Recipe provideTo(@Nonnull Consumer<Recipe> recipeUser);

    @Nonnull
    ItemStack[] flatten();

    @Nonnull
    ItemStack[] flattenWith(UnaryOperator<Object[]> ingredientsResolver);

}
