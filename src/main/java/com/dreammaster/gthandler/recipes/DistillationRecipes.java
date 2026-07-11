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
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;

public class DistillationRecipes implements Runnable {

    @Override
    public void run() {
        distilleryRecipes();
        distillationTowerRecipes();
    }

    public static void distillationTowerRecipes() {
        GTValues.RA.stdBuilder().circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Ash, Materials2Shapes.shapeDust, (int) (1)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Pollution,
                                Materials2FluidShapes.shapeFluidLiquid,
                                (int) (1000)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SulfuricAcid,
                                Materials2FluidShapes.shapeFluidLiquid,
                                (int) (150)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.NitrogenDioxide,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (150)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Methane,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (150)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Mercury,
                                Materials2FluidShapes.shapeFluidLiquid,
                                (int) (10)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(distillationTowerRecipes);

        GTValues.RA.stdBuilder().circuit(2)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Ash, Materials2Shapes.shapeDust, (int) (10)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Pollution,
                                Materials2FluidShapes.shapeFluidLiquid,
                                (int) (10000)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SulfuricAcid,
                                Materials2FluidShapes.shapeFluidLiquid,
                                (int) (3000)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.NitrogenDioxide,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (3000)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Methane,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (3000)),
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Mercury,
                                Materials2FluidShapes.shapeFluidLiquid,
                                (int) (200)))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(distillationTowerRecipes);
    }

    public static void distilleryRecipes() {
        // Sodium Potassium
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.RockSalt, Materials2Shapes.shapeDust, (int) (1)))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Sodium,
                                Materials2FluidShapes.shapeFluidLiquid,
                                (int) (1000)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.SodiumPotassium,
                                Materials2FluidShapes.shapeFluidLiquid,
                                (int) (1000)))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(distilleryRecipes);

        GTValues.RA.stdBuilder().circuit(1).fluidInputs(
                MaterialLibAPI
                        .getFluidStack(Materials2Materials.Biomass, Materials2FluidShapes.shapeFluidLiquid, (int) (40)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Ethanol,
                                Materials2FluidShapes.shapeFluidLiquid,
                                (int) (20)))
                .duration(16 * TICKS).eut(24).addTo(distilleryRecipes);

        // unify milk from Automagy

        if (Automagy.isModLoaded()) {
            FluidStack fluidMilk = FluidRegistry.getFluidStack("fluidmilk", 1000);

            GTValues.RA.stdBuilder().circuit(1)
                    .fluidInputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Milk,
                                    Materials2FluidShapes.shapeFluidLiquid,
                                    (int) (1000)))
                    .fluidOutputs(fluidMilk.copy()).duration(5 * SECONDS).eut(2).addTo(distilleryRecipes);

            GTValues.RA.stdBuilder().circuit(1).fluidInputs(fluidMilk.copy())
                    .fluidOutputs(
                            MaterialLibAPI.getFluidStack(
                                    Materials2Materials.Milk,
                                    Materials2FluidShapes.shapeFluidLiquid,
                                    (int) (1000)))
                    .duration(5 * SECONDS).eut(2).addTo(distilleryRecipes);
        }
    }
}
