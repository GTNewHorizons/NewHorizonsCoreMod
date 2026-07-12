package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.fermentingRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import net.minecraftforge.fluids.FluidRegistry;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;

public class FermenterRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder().fluidInputs(FluidRegistry.getFluidStack("concrete", 1000)).fluidOutputs(
                MaterialLibAPI
                        .getFluidStack(Materials2Materials.Concrete, Materials2FluidShapes.fluidMolten, (int) (1000)))
                .duration(1 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(fermentingRecipes);

        GTValues.RA.stdBuilder().fluidInputs(
                MaterialLibAPI
                        .getFluidStack(Materials2Materials.Concrete, Materials2FluidShapes.fluidMolten, (int) (1000)))
                .fluidOutputs(Materials.ConstructionFoam.getFluid(1000)).duration(1 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(fermentingRecipes);

        GTValues.RA.stdBuilder().fluidInputs(Materials.ConstructionFoam.getFluid(1000))
                .fluidOutputs(FluidRegistry.getFluidStack("concrete", 1000)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(fermentingRecipes);

    }
}
