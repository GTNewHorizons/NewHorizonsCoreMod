package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.fermentingRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;

public class FermenterRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder().fluidInputs(FluidRegistry.getFluidStack("concrete", 1000))
                .fluidOutputs(Materials.Concrete.getMolten(1000)).duration(1 * SECONDS).eut(16)
                .addTo(fermentingRecipes);

        GTValues.RA.stdBuilder().fluidInputs(Materials.Concrete.getMolten(1000))
                .fluidOutputs(Materials.ConstructionFoam.getFluid(1000)).duration(1 * SECONDS).eut(16)
                .addTo(fermentingRecipes);

        GTValues.RA.stdBuilder().fluidInputs(Materials.ConstructionFoam.getFluid(1000))
                .fluidOutputs(FluidRegistry.getFluidStack("concrete", 1000)).duration(1 * SECONDS).eut(16)
                .addTo(fermentingRecipes);

    }
}
