package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Automagy;
import static gregtech.api.recipe.RecipeMaps.distillationTowerRecipes;
import static gregtech.api.recipe.RecipeMaps.distilleryRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

public class DistillationRecipes implements Runnable {

    @Override
    public void run() {
        distilleryRecipes();
        distillationTowerRecipes();
    }

    public static void distillationTowerRecipes() {
        GTValues.RA.stdBuilder().itemInputs(GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("pollution"), 1000))
                .fluidOutputs(
                        Materials.SulfuricAcid.getFluid(150),
                        Materials.NitrogenDioxide.getGas(150),
                        Materials.Methane.getGas(150),
                        Materials.Mercury.getFluid(10))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(distillationTowerRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTUtility.getIntegratedCircuit(2))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 10))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("pollution"), 10000))
                .fluidOutputs(
                        Materials.SulfuricAcid.getFluid(3000),
                        Materials.NitrogenDioxide.getGas(3000),
                        Materials.Methane.getGas(3000),
                        Materials.Mercury.getFluid(200))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(distillationTowerRecipes);
    }

    public static void distilleryRecipes() {
        // Sodium Potassium
        GTValues.RA.stdBuilder().itemInputs(Materials.RockSalt.getDust(1)).fluidInputs(Materials.Sodium.getFluid(1000))
                .fluidOutputs(FluidRegistry.getFluidStack("sodiumpotassium", 1000)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(distilleryRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTUtility.getIntegratedCircuit(1))
                .fluidInputs(Materials.Biomass.getFluid(40)).fluidOutputs(Materials.Ethanol.getFluid(20))
                .duration(16 * TICKS).eut(24).addTo(distilleryRecipes);

        // unify milk from Automagy

        if (Automagy.isModLoaded()) {
            FluidStack fluidMilk = FluidRegistry.getFluidStack("fluidmilk", 1000);

            GTValues.RA.stdBuilder().itemInputs(GTUtility.getIntegratedCircuit(1))
                    .fluidInputs(Materials.Milk.getFluid(1000)).fluidOutputs(fluidMilk.copy()).duration(5 * SECONDS)
                    .eut(2).addTo(distilleryRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTUtility.getIntegratedCircuit(1)).fluidInputs(fluidMilk.copy())
                    .fluidOutputs(Materials.Milk.getFluid(1000)).duration(5 * SECONDS).eut(2).addTo(distilleryRecipes);
        }
    }
}
