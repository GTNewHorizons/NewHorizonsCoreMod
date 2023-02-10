package com.dreammaster.gthandler.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class DistillationRecipes implements Runnable {

    @Override
    public void run() {
        distilleryRecipes();
        distillationTowerRecipes();
    }

    public static void distillationTowerRecipes() {
        GT_Values.RA.addDistillationTowerRecipe(
                new FluidStack(FluidRegistry.getFluid("pollution"), 1000),
                new ItemStack[] { GT_Utility.getIntegratedCircuit(1) },
                new FluidStack[] { Materials.SulfuricAcid.getFluid(150L), Materials.NitrogenDioxide.getGas(150L),
                        Materials.Methane.getGas(150L), Materials.Mercury.getFluid(10L) },
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L),
                600,
                480);
        GT_Values.RA.addDistillationTowerRecipe(
                new FluidStack(FluidRegistry.getFluid("pollution"), 10000),
                new ItemStack[] { GT_Utility.getIntegratedCircuit(2) },
                new FluidStack[] { Materials.SulfuricAcid.getFluid(3000L), Materials.NitrogenDioxide.getGas(3000L),
                        Materials.Methane.getGas(3000L), Materials.Mercury.getFluid(200L) },
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 10L),
                600,
                1920);

        if (Loader.isModLoaded("bartworks")) {
            GT_Values.RA.addDistillationTowerRecipe(
                    Materials.Grade2PurifiedWater.getFluid(1000L),
                    new FluidStack[] { Materials.Grade3PurifiedWater.getFluid(900L),
                            Materials.Grade2PurifiedWater.getFluid(50L), Materials.Grade1PurifiedWater.getFluid(100L),
                            Materials.Oil.getFluid(50L), Materials.Ammonia.getFluid(100L) },
                    Materials.Calcite.getDust(1),
                    500 * 10,
                    122_880);

            GT_Values.RA.addDistillationTowerRecipe(
                    Materials.Grade6PurifiedWater.getFluid(1000L),
                    new FluidStack[] { Materials.Grade7PurifiedWater.getFluid(900L),
                            Materials.Grade6PurifiedWater.getFluid(50L), Materials.Grade5PurifiedWater.getFluid(100L),
                            Materials.Ethanol.getFluid(50L) },
                    null,
                    500 * 10,
                    1_966_080);
        }
    }

    public static void distilleryRecipes() {
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
