package com.dreammaster.recipes;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;

class RecipeArgs implements Recipe {

    protected final ItemStack result;
    protected final Object[] ingredients;

    RecipeArgs(ItemStack result, Object... ingredients) {
        if (Objects.isNull(result)) throw new NullPointerException("Craft created with null result!");
        if (Objects.isNull(ingredients)) throw new NullPointerException("Craft created with null input!");
        if (ingredients.length == 0) throw new IllegalArgumentException("Craft created with no input!");
        this.result = result.copy();
        this.ingredients = Arrays.copyOf(ingredients, ingredients.length);
    }

    @Nonnull
    @Override
    public ItemStack getResult() {
        return result;
    }

    @Nonnull
    @Override
    public Object[] getIngredients() {
        return ingredients;
    }

    @Override
    public @Nonnull Recipe provideTo(@Nonnull Consumer<Recipe> recipeUser) {
        recipeUser.accept(this);
        return this;
    }

    @Override
    public String toString() {
        return "Recipe{result=" + result + ", ingredients=" + Arrays.toString(ingredients) + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeArgs that = (RecipeArgs) o;
        return result.isItemEqual(that.result) && Arrays.equals(ingredients, that.ingredients);
    }

    @Override
    public int hashCode() {
        int result1 = Objects.hash(result);
        result1 = 31 * result1 + Arrays.hashCode(ingredients);
        return result1;
    }
}
