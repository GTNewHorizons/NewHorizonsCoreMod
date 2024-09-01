package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.latheRecipes;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gtPlusPlus.core.material.MaterialsElements.STANDALONE.CHRONOMATIC_GLASS;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_OreDictUnificator;

public class LatheRecipes implements Runnable {

    @Override
    public void run() {

        GT_Values.RA.stdBuilder().itemInputs(CHRONOMATIC_GLASS.getPlate(1))
                .itemOutputs(CustomItemList.ChromaticLens.get(1)).duration(60 * SECONDS).eut(TierEU.RECIPE_UHV)
                .addTo(latheRecipes);

        GT_Values.RA.stdBuilder().itemInputs(Materials.RadoxPolymer.getPlates(1))
                .itemOutputs(CustomItemList.RadoxPolymerLens.get(1)).duration(1 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_UEV).addTo(latheRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.ReinforcedGlassPLate.get(1L))
                .itemOutputs(
                        CustomItemList.ReinforcedGlassLense.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Glass, 1L))
                .duration(20 * SECONDS).eut(16).addTo(latheRecipes);
    }
}
