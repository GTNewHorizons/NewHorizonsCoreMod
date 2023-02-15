package com.dreammaster.gthandler;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.common.Loader;

public enum ModIDs {

    EnderIO("EnderIO"),
    TinkerConstruct("TConstruct");

    public final String modID;

    private final Map<String, Boolean> modsLoaded = new HashMap<>();

    ModIDs(String modID) {
        this.modID = modID;
    }

    public boolean isModLoaded() {
        boolean loaded = modsLoaded.getOrDefault(this.modID, Loader.isModLoaded(this.modID));
        modsLoaded.putIfAbsent(this.modID, loaded);
        return loaded;
    }
}
