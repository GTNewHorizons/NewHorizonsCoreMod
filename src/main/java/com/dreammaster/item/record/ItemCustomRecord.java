package com.dreammaster.item.record;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;

public class ItemCustomRecord extends ItemRecord {
    private final String name;

    public ItemCustomRecord(String name) {
        super("dreamcraft:" + name);
        this.name = name;
    }

    @Override
    public ResourceLocation getRecordResource(String name) {
        return new ResourceLocation("dreamcraft", "record." + this.name);
    }
}
