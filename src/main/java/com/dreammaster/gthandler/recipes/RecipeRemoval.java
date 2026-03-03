package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;

import gregtech.api.util.GTModHandler;

public class RecipeRemoval implements Runnable {

    @Override
    public void run() {

        if (IndustrialCraft2.isModLoaded()) {
            GTModHandler.removeRecipeByOutput(GTModHandler.getIC2Item("quantumHelmet", 1, WILDCARD));
            GTModHandler.removeRecipeByOutput(GTModHandler.getIC2Item("quantumBodyarmor", 1, WILDCARD));
            GTModHandler.removeRecipeByOutput(GTModHandler.getIC2Item("quantumLeggings", 1, WILDCARD));
            GTModHandler.removeRecipeByOutput(GTModHandler.getIC2Item("quantumBoots", 1, WILDCARD));
        }
        if (GraviSuite.isModLoaded()) {
            GTModHandler.removeRecipeByOutput(GTModHandler.getModItem(GraviSuite.ID, "graviChestPlate", 1, WILDCARD));
            GTModHandler.removeRecipeByOutput(GTModHandler.getModItem(GraviSuite.ID, "relocator", 1, WILDCARD));
        }
    }

}
