package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.IndustrialCraft2;

import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_ModHandler;

public class RecipeRemoval implements Runnable {

    @Override
    public void run() {

        if (IndustrialCraft2.isModLoaded()) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumHelmet", 1, GT_Values.W));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumBodyarmor", 1, GT_Values.W));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumLeggings", 1, GT_Values.W));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumBoots", 1, GT_Values.W));
        }
        if (GraviSuite.isModLoaded()) {
            GT_ModHandler
                    .removeRecipeByOutput(GT_ModHandler.getModItem(GraviSuite.ID, "graviChestPlate", 1, GT_Values.W));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem(GraviSuite.ID, "relocator", 1, GT_Values.W));
        }
    }

}
