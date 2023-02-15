package com.dreammaster.gthandler;

import cpw.mods.fml.common.Loader;

public enum ModIDs {

    EnderIO("EnderIO"),
    TinkerConstruct("TConstruct");

    public final String modID;
    private final Boolean modLoaded;

    ModIDs(String modID) {
        this.modID = modID;
        this.modLoaded = Loader.isModLoaded(modID);
    }

    public boolean isModLoaded() {
        return this.modLoaded;
    }
}
