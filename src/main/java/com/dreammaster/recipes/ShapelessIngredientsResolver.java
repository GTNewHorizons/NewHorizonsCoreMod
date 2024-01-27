package com.dreammaster.recipes;

import java.util.function.UnaryOperator;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ShapelessIngredientsResolver implements UnaryOperator<Object[]> {

    @Override
    public Object[] apply(Object[] ingredients) {
        return new ShapelessUniversalRecipe(new ItemStack(new Item()), ingredients).getInput().toArray();
    }
}
