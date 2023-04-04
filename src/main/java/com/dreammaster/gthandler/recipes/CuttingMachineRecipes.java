package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.ProjectRedCore;
import static gregtech.api.enums.Mods.ProjectRedIllumination;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.ZTones;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class CuttingMachineRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_ILC.get(1L),
                ItemList.Circuit_Chip_ILC.get(8L),
                GT_Values.NI,
                900,
                64);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_Ram.get(1L),
                ItemList.Circuit_Chip_Ram.get(32L),
                GT_Values.NI,
                900,
                96);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_NAND.get(1L),
                GT_Values.NI,
                ItemList.Circuit_Chip_NAND.get(32L),
                GT_Values.NI,
                900,
                192,
                true);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_NOR.get(1L),
                GT_Values.NI,
                ItemList.Circuit_Chip_NOR.get(16L),
                GT_Values.NI,
                900,
                192,
                true);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_CPU.get(1L),
                GT_Values.NI,
                ItemList.Circuit_Chip_CPU.get(8L),
                GT_Values.NI,
                900,
                120,
                true);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_Simple_SoC.get(1L),
                GT_Values.NI,
                ItemList.Circuit_Chip_Simple_SoC.get(6L),
                GT_Values.NI,
                900,
                64,
                false);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_SoC.get(1L),
                GT_Values.NI,
                ItemList.Circuit_Chip_SoC.get(6L),
                GT_Values.NI,
                900,
                480,
                true);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_SoC2.get(1L),
                GT_Values.NI,
                ItemList.Circuit_Chip_SoC2.get(6L),
                GT_Values.NI,
                900,
                1024,
                true);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_ULPIC.get(1L),
                GT_Values.NI,
                ItemList.Circuit_Chip_ULPIC.get(6L),
                GT_Values.NI,
                900,
                120,
                false);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_LPIC.get(1L),
                GT_Values.NI,
                ItemList.Circuit_Chip_LPIC.get(4L),
                GT_Values.NI,
                900,
                480,
                false);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_PIC.get(1L),
                GT_Values.NI,
                ItemList.Circuit_Chip_PIC.get(4L),
                GT_Values.NI,
                900,
                1920,
                true);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_HPIC.get(1L),
                GT_Values.NI,
                ItemList.Circuit_Chip_HPIC.get(2L),
                GT_Values.NI,
                900,
                7860,
                true);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_UHPIC.get(1L),
                GT_Values.NI,
                ItemList.Circuit_Chip_UHPIC.get(2L),
                GT_Values.NI,
                900,
                30720,
                true);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_NPIC.get(1L),
                GT_Values.NI,
                ItemList.Circuit_Chip_NPIC.get(2L),
                GT_Values.NI,
                900,
                122880,
                true);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_PPIC.get(1L),
                GT_Values.NI,
                ItemList.Circuit_Chip_PPIC.get(2L),
                GT_Values.NI,
                900,
                500000,
                true);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_QPIC.get(1L),
                GT_Values.NI,
                ItemList.Circuit_Chip_QPIC.get(2L),
                GT_Values.NI,
                900,
                2000000,
                true);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_NanoCPU.get(1L),
                GT_Values.NI,
                ItemList.Circuit_Chip_NanoCPU.get(8L),
                GT_Values.NI,
                900,
                480,
                true);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_QuantumCPU.get(1L),
                GT_Values.NI,
                ItemList.Circuit_Chip_QuantumCPU.get(4L),
                GT_Values.NI,
                900,
                1920,
                true);
        GT_Values.RA.addCutterRecipe(
                ItemList.Circuit_Wafer_Bioware.get(1L),
                Materials.UUMatter.getFluid(8_000L),
                ItemList.Circuit_Parts_Chip_Bioware.get(16L),
                ItemList.Circuit_Chip_Biocell.get(16L),
                15 * 20,
                (int) TierEU.RECIPE_UEV);
        if (IndustrialCraft2.isModLoaded()) {
            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockAlloyGlass", 1L, 0),
                    CustomItemList.ReinforcedGlassPLate.get(2L),
                    GT_Values.NI,
                    1200,
                    30);
        }

        GT_Values.RA
                .addCutterRecipe(CustomItemList.NandChipBoard.get(1), ItemList.NandChip.get(8), null, 100, 480, true);

        if (ZTones.isModLoaded() && ProjectRedCore.isModLoaded()) {
            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 16),
                    Materials.Water.getFluid(100L),
                    GT_ModHandler.getModItem(ZTones.ID, "lampf", 4L, 0),
                    GT_Values.NI,
                    200,
                    4);
            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 16),
                    GT_ModHandler.getDistilledWater(75L),
                    GT_ModHandler.getModItem(ZTones.ID, "lampf", 4L, 0),
                    GT_Values.NI,
                    200,
                    4);
            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 16),
                    Materials.Lubricant.getFluid(25L),
                    GT_ModHandler.getModItem(ZTones.ID, "lampf", 4L, 0),
                    GT_Values.NI,
                    100,
                    4);

            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 24),
                    Materials.Water.getFluid(100L),
                    GT_ModHandler.getModItem(ZTones.ID, "lampt", 4L, 0),
                    GT_Values.NI,
                    200,
                    4);
            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 24),
                    GT_ModHandler.getDistilledWater(75L),
                    GT_ModHandler.getModItem(ZTones.ID, "lampt", 4L, 0),
                    GT_Values.NI,
                    200,
                    4);
            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 24),
                    Materials.Lubricant.getFluid(25L),
                    GT_ModHandler.getModItem(ZTones.ID, "lampt", 4L, 0),
                    GT_Values.NI,
                    100,
                    4);

            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 23),
                    Materials.Water.getFluid(100L),
                    GT_ModHandler.getModItem(ZTones.ID, "lampb", 4L, 0),
                    GT_Values.NI,
                    200,
                    4);
            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 23),
                    GT_ModHandler.getDistilledWater(75L),
                    GT_ModHandler.getModItem(ZTones.ID, "lampb", 4L, 0),
                    GT_Values.NI,
                    200,
                    4);
            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 23),
                    Materials.Lubricant.getFluid(25L),
                    GT_ModHandler.getModItem(ZTones.ID, "lampb", 4L, 0),
                    GT_Values.NI,
                    100,
                    4);

        }

        if (TinkerConstruct.isModLoaded()) {
            // Cutting Saw
            GT_Values.RA.addCutterRecipe(
                    new ItemStack(Blocks.crafting_table, 1),
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "CraftingStation", 1L),
                    GT_Values.NI,
                    4800,
                    30);
            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "CraftingStation", 1L),
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "CraftingSlab", 1L),
                    GT_Values.NI,
                    4800,
                    30);

            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 1),
                    Materials.Water.getFluid(1000),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Ardite, 9L),
                    GT_Values.NI,
                    4800,
                    30);
            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 1),
                    GT_ModHandler.getDistilledWater(750L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Ardite, 9L),
                    GT_Values.NI,
                    4800,
                    30);
            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 1),
                    Materials.Lubricant.getFluid(250),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Ardite, 9L),
                    GT_Values.NI,
                    2400,
                    30);
            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 2),
                    Materials.Water.getFluid(1000),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 9L),
                    GT_Values.NI,
                    9600,
                    30);
            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 2),
                    GT_ModHandler.getDistilledWater(750L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 9L),
                    GT_Values.NI,
                    9600,
                    30);
            GT_Values.RA.addCutterRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 2),
                    Materials.Lubricant.getFluid(250),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 9L),
                    GT_Values.NI,
                    4800,
                    30);
        }

        if (BartWorks.isModLoaded()) {
            // Photonically Prepared Wafer
            int wafer_duration_ticks = 50 * 20;
            int wafer_eu_per_tick = 7_864_320;
            FluidStack[] purified_water = { Materials.Grade1PurifiedWater.getFluid(1000L),
                    Materials.Grade2PurifiedWater.getFluid(1000L), Materials.Grade3PurifiedWater.getFluid(1000L),
                    Materials.Grade4PurifiedWater.getFluid(1000L), Materials.Grade5PurifiedWater.getFluid(1000L),
                    Materials.Grade6PurifiedWater.getFluid(1000L), Materials.Grade7PurifiedWater.getFluid(1000L),
                    Materials.Grade8PurifiedWater.getFluid(1000L) };
            for (int i = 0; i < purified_water.length; i++) {
                GT_Values.RA.addCutterRecipe(
                        ItemList.Circuit_Silicon_Ingot6.get(1L), // Optical Boule
                        purified_water[i],
                        ItemList.Circuit_Silicon_Wafer6.get((i + 1) * 2L),
                        GT_Values.NI,
                        wafer_duration_ticks *= 0.95,
                        wafer_eu_per_tick);
            }
        }
    }
}
