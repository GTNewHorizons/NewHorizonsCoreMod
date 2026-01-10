package com.dreammaster.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WoodenBrickForm extends Item {

    private static final int maxDurability = 300;

    public WoodenBrickForm() {
        super.setMaxDamage(maxDurability);
        super.setMaxStackSize(1);
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
        return false;
    }

    @Deprecated
    @Override
    public boolean hasContainerItem() {
        return true;
    }

    @Override
    public boolean isRepairable() {
        return false;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        ItemStack ret = stack.copy().splitStack(1);
        if (ret.getItemDamage() < getMaxDamage()) {
            ret.setItemDamage(ret.getItemDamage() + 1);
            return ret;
        } else return null;
    }
}
