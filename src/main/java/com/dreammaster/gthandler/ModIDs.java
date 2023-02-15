package com.dreammaster.gthandler;

import cpw.mods.fml.common.Loader;

public enum ModIDs {

    EnderIO("EnderIO"),
    TinkerConstruct("TConstruct"),
    IndustrialCraft2("IC2");

    public final String modID;
    private Boolean modLoaded;

    ModIDs(String modID) {
        this.modID = modID;
    }

    public boolean isModLoaded() {
        if (this.modLoaded == null) {
            this.modLoaded = Loader.isModLoaded(modID);
        }
        return this.modLoaded;
    }
}
