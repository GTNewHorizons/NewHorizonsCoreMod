package com.dreammaster.gthandler.recipes;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.*;
import gregtech.api.util.GT_OreDictUnificator;

public class BendingMachineRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addBenderRecipe(
                CustomItemList.MicaInsulatorSheet.get(1L),
                CustomItemList.MicaInsulatorFoil.get(4L),
                100,
                (int) TierEU.RECIPE_LV);

        GT_Values.RA.addBenderRecipe(
                GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Steel, 1L),
                ItemList.Shape_Empty.get(1L),
                200,
                (int) TierEU.RECIPE_MV);
    }
}
