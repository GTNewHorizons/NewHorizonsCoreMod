package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.polarizerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.TierEU;

public class PolarizerRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder().itemInputs(ItemList.Neutronium_Casing.get(1))
                .itemOutputs(ItemList.Neutronium_Active_Casing.get(1)).duration(20 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(polarizerRecipes);
    }
}
