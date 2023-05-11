package com.dreammaster.gthandler.recipes;

import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFermentingRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;

public class FermenterRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                .fluidInputs(FluidRegistry.getFluidStack("concrete", 1000))
                .fluidOutputs(Materials.Concrete.getMolten(1000)).duration(1 * SECONDS).eut(16)
                .addTo(sFermentingRecipes);

        GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs().fluidInputs(Materials.Concrete.getMolten(1000))
                .fluidOutputs(Materials.ConstructionFoam.getFluid(1000)).duration(1 * SECONDS).eut(16)
                .addTo(sFermentingRecipes);

        GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs().fluidInputs(Materials.ConstructionFoam.getFluid(1000))
                .fluidOutputs(FluidRegistry.getFluidStack("concrete", 1000)).duration(1 * SECONDS).eut(16)
                .addTo(sFermentingRecipes);

    }
}
