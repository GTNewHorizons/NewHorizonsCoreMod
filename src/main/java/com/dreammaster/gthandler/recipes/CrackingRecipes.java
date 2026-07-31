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
                        MaterialLibAPI.getFluidStack(Materials.LightRadox, FluidShapes.fluidGas, (int) (100L)),
                        MaterialLibAPI.getFluidStack(Materials.Silver, FluidShapes.fluidPlasma, (int) (1)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(Materials.SuperLightRadox, FluidShapes.fluidGas, (int) (50L)))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_UV).addTo(crackingRecipes);

        GTValues.RA.stdBuilder().circuit(24)
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(Materials.HeavyRadox, FluidShapes.fluidLiquid, (int) (100L)),
                        MaterialLibAPI.getFluidStack(Materials.Silver, FluidShapes.fluidPlasma, (int) (1)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.LightRadox, FluidShapes.fluidGas, (int) (20L)))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_UV).addTo(crackingRecipes);
    }
}
