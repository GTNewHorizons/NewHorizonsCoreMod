package com.dreammaster.gthandler;

import gregtech.api.enums.Materials;
import gregtech.api.util.PCBFactoryManager;

public class CoreMod_PCBFactory_MaterialLoader {

    public static void init() {
        PCBFactoryManager.addPlasticTier(Materials.RadoxPolymer, 8);
    }
}
