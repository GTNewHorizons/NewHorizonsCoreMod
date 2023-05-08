package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;
import static gregtech.api.util.GT_RecipeConstants.UniversalArcFurnace;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class ArcFurnaceRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockMiningPipe", 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Steel, 2L)).noFluidInputs()
                .noFluidOutputs().duration(2 * SECONDS + 10 * TICKS).eut(90).addTo(UniversalArcFurnace);
    }
}
