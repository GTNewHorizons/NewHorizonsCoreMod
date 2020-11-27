package com.dreammaster.TwilightForest;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import gregtech.api.util.GT_ModHandler;
import twilightforest.TFTreasure;

public class TF_Loot_Chests {

    public static void init(FMLPreInitializationEvent event) {

        TFTreasure.hill1.common.add(GT_ModHandler.getModItem("harvestcraft", "crayfishrawItem", 1, 0), 10);
        //TFTreasure.hill1.common.add(null, 10);;

    }
}
