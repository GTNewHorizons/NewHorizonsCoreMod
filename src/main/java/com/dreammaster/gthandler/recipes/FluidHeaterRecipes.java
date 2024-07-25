package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.recipe.RecipeMaps.fluidHeaterRecipes;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_Utility;

public class FluidHeaterRecipes implements Runnable {

    @Override
    public void run() {
        if (BartWorks.isModLoaded()) {
            GT_Values.RA.stdBuilder().itemInputs(GT_Utility.getIntegratedCircuit(1))
                    .fluidInputs(Materials.Grade1PurifiedWater.getFluid(1000))
                    .fluidOutputs(Materials.Grade2PurifiedWater.getFluid(900)).duration(4 * MINUTES + 10 * SECONDS)
                    .eut(61_440).addTo(fluidHeaterRecipes);
        }
    }
}
