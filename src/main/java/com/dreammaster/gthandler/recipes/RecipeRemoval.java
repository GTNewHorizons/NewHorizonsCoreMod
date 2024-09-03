package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.IndustrialCraft2;

import gregtech.api.enums.GTValues;
import gregtech.api.util.GTModHandler;

public class RecipeRemoval implements Runnable {

    @Override
    public void run() {

        if (IndustrialCraft2.isModLoaded()) {
            GTModHandler.removeRecipeByOutput(GTModHandler.getIC2Item("quantumHelmet", 1, GTValues.W));
            GTModHandler.removeRecipeByOutput(GTModHandler.getIC2Item("quantumBodyarmor", 1, GTValues.W));
            GTModHandler.removeRecipeByOutput(GTModHandler.getIC2Item("quantumLeggings", 1, GTValues.W));
            GTModHandler.removeRecipeByOutput(GTModHandler.getIC2Item("quantumBoots", 1, GTValues.W));
        }
        if (GraviSuite.isModLoaded()) {
            GTModHandler.removeRecipeByOutput(GTModHandler.getModItem(GraviSuite.ID, "graviChestPlate", 1, GTValues.W));
            GTModHandler.removeRecipeByOutput(GTModHandler.getModItem(GraviSuite.ID, "relocator", 1, GTValues.W));
        }
    }

}
