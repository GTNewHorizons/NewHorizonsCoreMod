package com.dreammaster.recipes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.collect.ImmutableList;

class ResolvedIngredientsFlattenerTest {

    ItemStack ITEM = new ItemStack(new Item());

    private IngredientsFlattener fixture;

    @BeforeEach
    void setUp() {
        fixture = new ResolvedIngredientsFlattener();
    }

    @Test
    void flattenValidIngredients() {
        Object[] ingedients = new Object[] { ImmutableList.of(ITEM, ITEM), ITEM, null };
        Object[] expectedIngredients = new Object[] { ITEM, ITEM, null };

        ItemStack[] flattenedIngredients = fixture.flatten(ingedients);

        assertThat(flattenedIngredients).isEqualTo(expectedIngredients);
    }

    @Test
    void flattenEmptyList() {
        Object[] ingedients = new Object[] { ImmutableList.of() };

        ThrowingCallable code = () -> fixture.flatten(ingedients);

        assertThatThrownBy(code).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void flattenUnresolvedIngredients() {
        Object[] ingedients = new Object[] { "ingot" };

        ThrowingCallable code = () -> fixture.flatten(ingedients);

        assertThatThrownBy(code).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void flattenListStartingWithNull() {
        List<ItemStack> list = new ArrayList<>();
        list.add(null);
        list.add(ITEM);
        Object[] ingedients = new Object[] { list };

        ThrowingCallable code = () -> fixture.flatten(ingedients);

        assertThatThrownBy(code).isInstanceOf(IllegalArgumentException.class);
    }

}
