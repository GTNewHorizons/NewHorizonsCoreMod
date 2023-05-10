package com.dreammaster.gthandler.recipes;

import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCannerRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_OreDictUnificator;

public class CannerRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.AdsorptionFilterCasing.get(1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 32))
                .itemOutputs(CustomItemList.AdsorptionFilter.get(1)).noFluidInputs().noFluidOutputs()
                .duration(5 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sCannerRecipes);
    }
}
