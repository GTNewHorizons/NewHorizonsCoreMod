package com.dreammaster.gthandler.recipes;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_ModHandler;

public class RecipeRemoval implements Runnable {
    @Override
    public void run() {
        if (Loader.isModLoaded("GraviSuite")) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "graviChestPlate", 1, GT_Values.W));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "relocator", 1, GT_Values.W));



        }
    }
}
