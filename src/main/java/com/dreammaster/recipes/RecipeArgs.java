package com.dreammaster.recipes;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;

/**
 * Implementation class. Access it through Recipe::of
 */
class RecipeArgs implements Recipe {

    // Hardcoded dependency for now
    private final UnaryOperator<Object[]> defaultIngredientsResolver = new ShapedIngredientsResolver();
    // Hardcoded dependency for now
    private final IngredientsFlattener ingredientsFlattener = new ResolvedIngredientsFlattener();

    protected final ItemStack result;
    protected final Object[] ingredients;
    private Object[] resolvedIngredients;

    RecipeArgs(ItemStack result, Object... ingredients) {
        if (Objects.isNull(result)) throw new NullPointerException("Craft created with null result!");
        if (Objects.isNull(ingredients)) throw new NullPointerException("Craft created with null ingredients!");
        if (ingredients.length == 0) throw new IllegalArgumentException("Craft created with no ingredients!");
        this.result = result.copy();
        this.ingredients = Arrays.copyOf(ingredients, ingredients.length);
    }

    /**
     * Flattens the recipe to only have up to one ItemStack per slot.
     *
     * @return A non-empty array of ItemStack or null values.
     */
    @Nonnull
    @Override
    public ItemStack[] flatten() {
        return ingredientsFlattener.flatten(getResolvedIngredients());
    }

    /**
     * Flattens the recipe to only have up to one ItemStack per slot.
     * 
     * @param ingredientsResolver Transforms the ingredients to only contain null, ItemStack or List&lt;ItemStack&gt;
     * @return A non-empty array of ItemStack or null values.
     */
    @Nonnull
    @Override
    public ItemStack[] flattenWith(@Nonnull UnaryOperator<Object[]> ingredientsResolver) {
        return ingredientsFlattener.flatten(ingredientsResolver.apply(ingredients));
    }

    private Object[] getResolvedIngredients() {
        if (resolvedIngredients == null) {
            resolvedIngredients = defaultIngredientsResolver.apply(ingredients);
        }
        return resolvedIngredients;
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
