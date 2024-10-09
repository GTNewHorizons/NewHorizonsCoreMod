package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.sifterRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;

public class SifterRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(OrePrefixes.crushedPurified, Materials.Cinnabar, 1L))
                .itemOutputs(
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Cinnabar.getDust(1))
                .outputChances(100, 300, 500, 1000, 1000, 1500, 2300, 2500, 3500).duration(6 * MINUTES)
                .eut(TierEU.RECIPE_LV).addTo(sifterRecipes);
    }
}
