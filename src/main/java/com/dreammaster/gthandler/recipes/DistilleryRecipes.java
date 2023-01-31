package com.dreammaster.gthandler.recipes;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_Utility;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class DistilleryRecipes implements Runnable{
    @Override
    public void run() {
        // Sodium Potassium
        GT_Values.RA.addDistilleryRecipe(
                Materials.RockSalt.getDust(1),
                Materials.Sodium.getFluid(1000),
                new FluidStack(FluidRegistry.getFluid("sodiumpotassium"), 1000),
                400,
                30,
                false);

        GT_Values.RA.addDistilleryRecipe(
                GT_Utility.getIntegratedCircuit(1),
                Materials.Biomass.getFluid(40L),
                Materials.Ethanol.getFluid(20L),
                16,
                24,
                false);

        GT_Values.RA.addDistilleryRecipe(
                GT_Utility.getIntegratedCircuit(1),
                Materials.Milk.getFluid(1000L),
                FluidRegistry.getFluidStack("fluidmilk", 1000),
                100,
                2,
                false);

        GT_Values.RA.addDistilleryRecipe(
                GT_Utility.getIntegratedCircuit(1),
                FluidRegistry.getFluidStack("fluidmilk", 1000),
                Materials.Milk.getFluid(1000L),
                100,
                2,
                false);
    }
}
