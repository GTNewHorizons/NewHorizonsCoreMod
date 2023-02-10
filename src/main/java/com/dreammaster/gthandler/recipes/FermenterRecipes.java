package com.dreammaster.gthandler.recipes;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;

public class FermenterRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addFermentingRecipe(
                FluidRegistry.getFluidStack("concrete", 1000),
                Materials.Concrete.getMolten(1000L),
                20,
                16,
                false);
        GT_Values.RA.addFermentingRecipe(
                Materials.Concrete.getMolten(1000L),
                Materials.ConstructionFoam.getFluid(1000),
                20,
                16,
                false);
        GT_Values.RA.addFermentingRecipe(
                Materials.ConstructionFoam.getFluid(1000),
                FluidRegistry.getFluidStack("concrete", 1000),
                20,
                16,
                false);

    }
}
