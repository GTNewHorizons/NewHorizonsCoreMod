package com.dreammaster.gthandler.recipes;

import static com.dreammaster.gthandler.GT_CoreModSupport.*;
import static gregtech.api.enums.Materials.Silver;
import static gregtech.api.recipe.RecipeMaps.crackingRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_Utility;

public class CrackingRecipes implements Runnable {

    public void run() {
        GT_Values.RA.stdBuilder().itemInputs(GT_Utility.getIntegratedCircuit(24))
                .fluidInputs(RadoxLight.getGas(100L), Silver.getPlasma(1)).fluidOutputs(RadoxSuperLight.getGas(50L))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_UV).addTo(crackingRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_Utility.getIntegratedCircuit(24))
                .fluidInputs(RadoxHeavy.getFluid(100L), Silver.getPlasma(1)).fluidOutputs(RadoxLight.getGas(20L))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_UV).addTo(crackingRecipes);
    }
}
