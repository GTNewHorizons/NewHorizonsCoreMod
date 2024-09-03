package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeConstants.UniversalArcFurnace;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;

public class ArcFurnaceRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(IndustrialCraft2.ID, "blockMiningPipe", 1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.nugget, Materials.Steel, 2L))
                .duration(2 * SECONDS + 10 * TICKS).eut(90).addTo(UniversalArcFurnace);
    }
}
