package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.fluidHeaterRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;
import gtPlusPlus.core.util.minecraft.FluidUtils;

public class FluidHeaterRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder().fluidInputs(FluidUtils.getSteam(3840))
                .fluidOutputs(FluidUtils.getSuperHeatedSteam(3840)).duration(5 * SECONDS).eut(TierEU.RECIPE_LuV)
                .noOptimize().addTo(fluidHeaterRecipes);

    }
}
