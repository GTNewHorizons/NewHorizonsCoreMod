package com.dreammaster.modhazardousitems.cause;

import net.minecraft.item.ItemStack;

public class InventoryItemHazardCause extends HazardCause {
    private final ItemStack stack;

    InventoryItemHazardCause(ItemStack stack) {
        super(Type.INVENTORY);
        this.stack = stack;
    }

    public ItemStack getStack() {
        return stack;
    }
}
