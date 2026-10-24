package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.vacuumFreezerRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import com.dreammaster.item.NHItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;

public class VacuumFreezerRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder().itemInputs(NHItemList.GlowingMarshmallow.get())
                .itemOutputs(NHItemList.Marshmallow.get()).duration(40 * MINUTES).eut(TierEU.RECIPE_EV)
                .addTo(vacuumFreezerRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.HotNetherrackBrick.get())
                .itemOutputs(NHItemList.InfernalBrick.get()).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(vacuumFreezerRecipes);

    }
}
