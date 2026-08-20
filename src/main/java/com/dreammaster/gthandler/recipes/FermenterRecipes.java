package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.fermentingRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import net.minecraftforge.fluids.FluidRegistry;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.material.MaterialUtils;

public class FermenterRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder().fluidInputs(FluidRegistry.getFluidStack("concrete", 1000))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Concrete, FluidShapes.fluidMolten, 1000))
                .duration(1 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(fermentingRecipes);

        GTValues.RA.stdBuilder()
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Concrete, FluidShapes.fluidMolten, 1000))
                .fluidOutputs(MaterialUtils.fluid(Materials.ConstructionFoam, 1000)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(fermentingRecipes);

        GTValues.RA.stdBuilder().fluidInputs(MaterialUtils.fluid(Materials.ConstructionFoam, 1000))
                .fluidOutputs(FluidRegistry.getFluidStack("concrete", 1000)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(fermentingRecipes);

    }
}
