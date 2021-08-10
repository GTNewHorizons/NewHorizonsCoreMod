package com.dreammaster.modhazardousitems.cause;

import net.minecraft.item.ItemStack;

public class HazardCause {
    private final Type type;

    protected HazardCause(Type type) {
        this.type = type;
    }

    public static HazardCause stepOn() {
        return new HazardCause(Type.STEP_ON);
    }

    public static HazardCause inventoryItem(ItemStack cause) {
        return new InventoryItemHazardCause(cause);
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        STEP_ON,
        INVENTORY
    }
}
