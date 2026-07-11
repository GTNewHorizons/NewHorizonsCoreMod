package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.sifterRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;

public class SifterRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI
                        .getStack(Materials2Materials.Cinnabar, Materials2Shapes.shapeCrushedPurified, (int) (1L)))
                .itemOutputs(
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        MaterialLibAPI.getStack(Materials2Materials.Cinnabar, Materials2Shapes.shapeDust, (int) (1)))
                .outputChances(100, 300, 500, 1000, 1000, 1500, 2300, 2500, 3500).duration(6 * MINUTES)
                .eut(TierEU.RECIPE_LV).addTo(sifterRecipes);
    }
}
