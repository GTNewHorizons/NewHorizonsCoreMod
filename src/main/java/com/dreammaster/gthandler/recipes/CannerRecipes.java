package com.dreammaster.gthandler.recipes;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;

public class CannerRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addCannerRecipe(
                CustomItemList.AdsorptionFilterCasing.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 32L),
                CustomItemList.AdsorptionFilter.get(1L),
                GT_Values.NI,
                100,
                120);
    }
}
