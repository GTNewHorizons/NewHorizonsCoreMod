package com.dreammaster.recipes;

import java.util.function.UnaryOperator;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ShapedIngredientsResolver implements UnaryOperator<Object[]> {

    @Override
    public Object[] apply(Object[] ingredients) {
        return new ShapedUniversalRecipe(new ItemStack(new Item()), ingredients).getInput();
    }
}
