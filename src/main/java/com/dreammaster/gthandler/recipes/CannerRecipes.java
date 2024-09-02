package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.cannerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;

public class CannerRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.AdsorptionFilterCasing.get(1),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 32))
                .itemOutputs(CustomItemList.AdsorptionFilter.get(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(cannerRecipes);
    }
}
