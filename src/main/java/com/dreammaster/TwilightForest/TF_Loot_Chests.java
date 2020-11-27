package com.dreammaster.TwilightForest;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import gregtech.api.util.GT_ModHandler;
import twilightforest.TFTreasure;

public class TF_Loot_Chests {

    public static void init(FMLPreInitializationEvent event) {

        TFTreasure.hill1.useless.add(GT_ModHandler.getModItem("harvestcraft", "crayfishrawItem", 10, 0), 100);
        TFTreasure.hill1.common.add(GT_ModHandler.getModItem("harvestcraft", "crayfishrawItem", 10, 0), 70);
        TFTreasure.hill1.uncommon.add(GT_ModHandler.getModItem("harvestcraft", "crayfishrawItem", 10, 0), 50);
        TFTreasure.hill1.rare.add(GT_ModHandler.getModItem("harvestcraft", "crayfishrawItem", 10, 0), 20);
        TFTreasure.hill1.ultrarare.add(GT_ModHandler.getModItem("harvestcraft", "crayfishrawItem", 10, 0), 10);

        TFTreasure.hill1.useless.add(GT_ModHandler.getModItem("harvestcraft", "frograwItem", 10, 0), 100);
        TFTreasure.hill2.common.add(GT_ModHandler.getModItem("harvestcraft", "frograwItem", 10, 0), 70);
        TFTreasure.hill2.uncommon.add(GT_ModHandler.getModItem("harvestcraft", "frograwItem", 10, 0), 50);
        TFTreasure.hill2.rare.add(GT_ModHandler.getModItem("harvestcraft", "frograwItem", 10, 0), 20);
        TFTreasure.hill2.ultrarare.add(GT_ModHandler.getModItem("harvestcraft", "frograwItem", 10, 0), 10);

        TFTreasure.hill3.useless.add(GT_ModHandler.getModItem("harvestcraft", "shrimprawItem", 10, 0), 100);
        TFTreasure.hill3.common.add(GT_ModHandler.getModItem("harvestcraft", "shrimprawItem", 10, 0), 70);
        TFTreasure.hill3.uncommon.add(GT_ModHandler.getModItem("harvestcraft", "shrimprawItem", 10, 0), 50);
        TFTreasure.hill3.rare.add(GT_ModHandler.getModItem("harvestcraft", "shrimprawItem", 10, 0), 20);
        TFTreasure.hill3.ultrarare.add(GT_ModHandler.getModItem("harvestcraft", "shrimprawItem", 10, 0), 10);

    }
}
