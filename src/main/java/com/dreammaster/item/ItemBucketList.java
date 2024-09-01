package com.dreammaster.item;

import net.minecraft.item.ItemStack;

import gregtech.api.util.GT_Utility;

public enum ItemBucketList {

    SodiumPotassium,
    NitricAcid,
    RadioactiveBacterialSludge,
    FermentedBacterialSludge,
    Concrete,
    Pollution;

    private ItemStack stack;
    private boolean hasNotBeenSet = true;

    public void set(ItemStack stack) {
        hasNotBeenSet = false;
        this.stack = GT_Utility.copyAmount(1, stack);
    }

    public ItemStack get(int amount) {
        if (hasNotBeenSet) {
            throw new IllegalAccessError("The Enum '" + name() + "' has not been set to an Item at this time!");
        }

        return GT_Utility.copyAmount(amount, stack);
    }
}
