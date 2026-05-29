package com.dreammaster.item.record;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;

public class NHMusicRecord extends ItemRecord {

    private final String soundResourceMod;
    private final String soundResourceName;

    /**
     * For use with musics registered in Dreamcraft's sounds.json
     */
    public NHMusicRecord(String soundName) {
        super("dreamcraft:" + soundName);
        this.soundResourceMod = "dreamcraft";
        this.soundResourceName = "record." + soundName;
    }

    /**
     * For use with music registered in other mods' sounds.json
     */
    public NHMusicRecord(String itemName, String soundResourceMod, String soundResourceName) {
        super("dreamcraft:" + itemName);
        this.soundResourceMod = soundResourceMod;
        this.soundResourceName = soundResourceName;
    }

    @Override
    public ResourceLocation getRecordResource(String name) {
        return new ResourceLocation(soundResourceMod, soundResourceName);
    }
}
