package com.dreammaster.gthandler;

import gregtech.api.util.GT_PCBFactoryManager;

public class CoreMod_PCBFactory_MaterialLoader {

    public static void init() {
        GT_PCBFactoryManager.addPlasticTier(GT_CoreModSupport.RadoxPolymer, 8);
    }
}
