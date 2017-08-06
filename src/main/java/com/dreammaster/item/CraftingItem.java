package com.dreammaster.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CraftingItem extends Item
{
    public CraftingItem()
    {
        super();
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
    {
        return false;
    }
}