package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Automagy;
import static gregtech.api.recipe.RecipeMaps.distillationTowerRecipes;
import static gregtech.api.recipe.RecipeMaps.distilleryRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;

public class DistillationRecipes implements Runnable {

    @Override
    public void run() {
        distilleryRecipes();
        distillationTowerRecipes();
    }

    public static void distillationTowerRecipes() {
        GTValues.RA.stdBuilder().circuit(1).itemOutputs(MaterialLibAPI.getStack(Materials.Ash, Shapes.dust, (int) (1)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Pollution, FluidShapes.fluidLiquid, (int) (1000)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(Materials.SulfuricAcid, FluidShapes.fluidLiquid, (int) (150)),
                        MaterialLibAPI.getFluidStack(Materials.NitrogenDioxide, FluidShapes.fluidGas, (int) (150)),
                        MaterialLibAPI.getFluidStack(Materials.Methane, FluidShapes.fluidGas, (int) (150)),
                        MaterialLibAPI.getFluidStack(Materials.Mercury, FluidShapes.fluidLiquid, (int) (10)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(distillationTowerRecipes);

        GTValues.RA.stdBuilder().circuit(2).itemOutputs(MaterialLibAPI.getStack(Materials.Ash, Shapes.dust, (int) (10)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Pollution, FluidShapes.fluidLiquid, (int) (10000)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(Materials.SulfuricAcid, FluidShapes.fluidLiquid, (int) (3000)),
                        MaterialLibAPI.getFluidStack(Materials.NitrogenDioxide, FluidShapes.fluidGas, (int) (3000)),
                        MaterialLibAPI.getFluidStack(Materials.Methane, FluidShapes.fluidGas, (int) (3000)),
                        MaterialLibAPI.getFluidStack(Materials.Mercury, FluidShapes.fluidLiquid, (int) (200)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(distillationTowerRecipes);
    }

    public static void distilleryRecipes() {
        // Sodium Potassium
        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.RockSalt, Shapes.dust, (int) (1)))
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Sodium, FluidShapes.fluidLiquid, (int) (1000)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(Materials.SodiumPotassium, FluidShapes.fluidLiquid, (int) (1000)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(distilleryRecipes);

        GTValues.RA.stdBuilder().circuit(1)
                .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Biomass, FluidShapes.fluidLiquid, (int) (40)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Ethanol, FluidShapes.fluidLiquid, (int) (20)))
                .duration(16 * TICKS).eut(24).addTo(distilleryRecipes);

        // unify milk from Automagy

        if (Automagy.isModLoaded()) {
            FluidStack fluidMilk = FluidRegistry.getFluidStack("fluidmilk", 1000);

            GTValues.RA.stdBuilder().circuit(1)
                    .fluidInputs(MaterialLibAPI.getFluidStack(Materials.Milk, FluidShapes.fluidLiquid, (int) (1000)))
                    .fluidOutputs(fluidMilk.copy()).duration(5 * SECONDS).eut(2).addTo(distilleryRecipes);

            GTValues.RA.stdBuilder().circuit(1).fluidInputs(fluidMilk.copy())
                    .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Milk, FluidShapes.fluidLiquid, (int) (1000)))
                    .duration(5 * SECONDS).eut(2).addTo(distilleryRecipes);
        }
    }
}
