package com.dreammaster.recipes;

import net.minecraft.item.ItemStack;

public interface IngredientsFlattener {

    ItemStack[] flatten(Object[] ingredients);
}
