package com.dreammaster.gthandler;

import gregtech.api.enums.Materials;
import gregtech.api.util.GT_PCBFactoryManager;

public class CoreMod_PCBFactory_MaterialLoader {

    public static void init() {
        GT_PCBFactoryManager.addPlasticTier(Materials.RadoxPolymer, 8);
    }
}
