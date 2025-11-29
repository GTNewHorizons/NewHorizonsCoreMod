package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Materials.*;
import static gregtech.api.recipe.RecipeMaps.crackingRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;

public class CrackingRecipes implements Runnable {

    public void run() {
        GTValues.RA.stdBuilder().circuit(24).fluidInputs(RadoxLight.getGas(100L), Silver.getPlasma(1))
                .fluidOutputs(RadoxSuperLight.getGas(50L)).duration(25 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(crackingRecipes);

        GTValues.RA.stdBuilder().circuit(24).fluidInputs(RadoxHeavy.getFluid(100L), Silver.getPlasma(1))
                .fluidOutputs(RadoxLight.getGas(20L)).duration(25 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(crackingRecipes);
    }
}
