package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.fermentingRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;

public class FermenterRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.stdBuilder().fluidInputs(FluidRegistry.getFluidStack("concrete", 1000))
                .fluidOutputs(Materials.Concrete.getMolten(1000)).duration(1 * SECONDS).eut(16)
                .addTo(fermentingRecipes);

        GT_Values.RA.stdBuilder().fluidInputs(Materials.Concrete.getMolten(1000))
                .fluidOutputs(Materials.ConstructionFoam.getFluid(1000)).duration(1 * SECONDS).eut(16)
                .addTo(fermentingRecipes);

        GT_Values.RA.stdBuilder().fluidInputs(Materials.ConstructionFoam.getFluid(1000))
                .fluidOutputs(FluidRegistry.getFluidStack("concrete", 1000)).duration(1 * SECONDS).eut(16)
                .addTo(fermentingRecipes);

    }
}
