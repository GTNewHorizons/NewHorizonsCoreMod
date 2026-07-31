package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.crackingRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;

public class CrackingRecipes implements Runnable {

    public void run() {
        GTValues.RA.stdBuilder().circuit(24).fluidInputs(
                MaterialLibAPI
                        .getFluidStack(Materials2Materials.LightRadox, Materials2FluidShapes.fluidGas, (int) (100L)),
                MaterialLibAPI.getFluidStack(Materials2Materials.Silver, Materials2FluidShapes.fluidPlasma, (int) (1)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SuperLightRadox,
                                Materials2FluidShapes.fluidGas,
                                (int) (50L)))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_UV).addTo(crackingRecipes);

        GTValues.RA.stdBuilder().circuit(24).fluidInputs(
                MaterialLibAPI
                        .getFluidStack(Materials2Materials.HeavyRadox, Materials2FluidShapes.fluidLiquid, (int) (100L)),
                MaterialLibAPI.getFluidStack(Materials2Materials.Silver, Materials2FluidShapes.fluidPlasma, (int) (1)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.LightRadox,
                                Materials2FluidShapes.fluidGas,
                                (int) (20L)))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_UV).addTo(crackingRecipes);
    }
}
