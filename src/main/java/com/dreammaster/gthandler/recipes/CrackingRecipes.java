package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.crackingRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;

public class CrackingRecipes implements Runnable {

    public void run() {
        GTValues.RA.stdBuilder().circuit(24)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.LightRadox, FluidShapes.fluidGas, 100),
                        MaterialLibAPI.getFluidStack(Materials.Silver, FluidShapes.fluidPlasma, 1))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.SuperLightRadox, FluidShapes.fluidGas, 50))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_UV).addTo(crackingRecipes);

        GTValues.RA.stdBuilder().circuit(24)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.HeavyRadox, FluidShapes.fluidLiquid, 100),
                        MaterialLibAPI.getFluidStack(Materials.Silver, FluidShapes.fluidPlasma, 1))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.LightRadox, FluidShapes.fluidGas, 20))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_UV).addTo(crackingRecipes);
    }
}
