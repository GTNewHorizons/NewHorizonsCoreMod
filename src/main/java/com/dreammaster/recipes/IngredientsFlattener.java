package com.dreammaster.recipes;

import net.minecraft.item.ItemStack;

interface IngredientsFlattener {

    ItemStack[] flatten(Object[] ingredients);
}
