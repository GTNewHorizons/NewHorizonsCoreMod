package com.dreammaster.item.record;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;

public class NHMusicRecord extends ItemRecord {
    private final String sound;

    public NHMusicRecord(String sound) {
        super("dreamcraft:" + sound);
        this.sound = sound;
    }

    @Override
    public ResourceLocation getRecordResource(String name) {
        return new ResourceLocation("dreamcraft", "record." + this.sound);
    }
}
