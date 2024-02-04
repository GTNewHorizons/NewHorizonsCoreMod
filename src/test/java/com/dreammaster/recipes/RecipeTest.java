package com.dreammaster.recipes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

class RecipeTest {

    ItemStack ITEM = new ItemStack(new Item());

    @Test
    void instanciateWithNullResult() {
        ItemStack result = null;
        Object[] ingredients = new Object[] { ITEM };

        ThrowableAssert.ThrowingCallable code = () -> Recipe.of(result, ingredients);

        assertThatThrownBy(code).isInstanceOf(NullPointerException.class);
    }

    @Test
    void instanciateWithNullIngredients() {
        ItemStack result = ITEM;
        Object[] ingredients = null;

        ThrowableAssert.ThrowingCallable code = () -> Recipe.of(result, ingredients);

        assertThatThrownBy(code).isInstanceOf(NullPointerException.class);
    }

    @Test
    void instanciateWithEmptyIngredients() {
        ItemStack result = ITEM;
        Object[] ingredients = new Object[] {};

        ThrowableAssert.ThrowingCallable code = () -> Recipe.of(result, ingredients);

        assertThatThrownBy(code).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void instanciate() {
        Object[] expectedIngredients = { "A string", new ItemStack[] { ITEM, ITEM }, ITEM };
        Recipe recipe = Recipe.of(ITEM, expectedIngredients);

        ItemStack result = recipe.getResult();
        Object[] ingredients = recipe.getIngredients();

        // Also test that defensive copies were made.
        assertTrue(ITEM.isItemEqual(result));
        assertThat(result).isNotSameAs(ITEM);
        assertThat(ingredients).isEqualTo(expectedIngredients).isNotSameAs(expectedIngredients);
    }

    @Test
    void provideTo() {
        AtomicReference<Recipe> providedRecipe = new AtomicReference<>();
        Consumer<Recipe> hungryHungryRegistry = providedRecipe::set;
        Recipe recipe = Recipe.of(ITEM, ITEM);

        recipe.provideTo(hungryHungryRegistry);

        assertThat(providedRecipe.get()).isEqualTo(Recipe.of(ITEM, ITEM));
    }
}
