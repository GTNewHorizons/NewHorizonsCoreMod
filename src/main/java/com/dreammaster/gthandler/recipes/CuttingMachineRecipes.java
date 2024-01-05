package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.ProjectRedCore;
import static gregtech.api.enums.Mods.ProjectRedIllumination;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.ZTones;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class CuttingMachineRecipes implements Runnable {

    @Override
    public void run() {

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_ILC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_ILC.get(8L)).duration(45 * SECONDS).eut(64).addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_Ram.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_Ram.get(32L)).duration(45 * SECONDS).eut(96).addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_NAND.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_NAND.get(32L)).requiresCleanRoom().duration(45 * SECONDS).eut(192)
                .addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_NOR.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_NOR.get(16L)).requiresCleanRoom().duration(45 * SECONDS).eut(192)
                .addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_CPU.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_CPU.get(8L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_Simple_SoC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_Simple_SoC.get(6L)).duration(45 * SECONDS).eut(64)
                .addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_SoC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_SoC.get(6L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_SoC2.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_SoC2.get(6L)).requiresCleanRoom().duration(45 * SECONDS).eut(1024)
                .addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_ULPIC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_ULPIC.get(6L)).duration(45 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_LPIC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_LPIC.get(4L)).duration(45 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_PIC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_PIC.get(4L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_HPIC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_HPIC.get(2L)).requiresCleanRoom().duration(45 * SECONDS).eut(7860)
                .addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_UHPIC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_UHPIC.get(2L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_NPIC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_NPIC.get(2L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_PPIC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_PPIC.get(2L)).requiresCleanRoom().duration(45 * SECONDS).eut(500000)
                .addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_QPIC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_QPIC.get(2L)).requiresCleanRoom().duration(45 * SECONDS).eut(2000000)
                .addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_NanoCPU.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_NanoCPU.get(8L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_QuantumCPU.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_QuantumCPU.get(4L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_Bioware.get(1L))
                .itemOutputs(ItemList.Circuit_Parts_Chip_Bioware.get(16L), ItemList.Circuit_Chip_Biocell.get(16L))
                .fluidInputs(Materials.UUMatter.getFluid(8_000L)).duration(15 * SECONDS).eut(TierEU.RECIPE_UEV)
                .addTo(cutterRecipes);
        if (IndustrialCraft2.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockAlloyGlass", 1L, 0))
                    .itemOutputs(CustomItemList.ReinforcedGlassPLate.get(2L)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);

        }

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.NandChipBoard.get(1)).itemOutputs(ItemList.NandChip.get(8))
                .requiresCleanRoom().duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(cutterRecipes);

        if (ZTones.isModLoaded() && ProjectRedCore.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 16))
                    .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "lampf", 4L, 0))
                    .fluidInputs(Materials.Water.getFluid(100L)).duration(10 * SECONDS).eut(4).addTo(cutterRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 16))
                    .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "lampf", 4L, 0))
                    .fluidInputs(GT_ModHandler.getDistilledWater(75L)).duration(10 * SECONDS).eut(4)
                    .addTo(cutterRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 16))
                    .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "lampf", 4L, 0))
                    .fluidInputs(Materials.Lubricant.getFluid(25L)).duration(5 * SECONDS).eut(4).addTo(cutterRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 24))
                    .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "lampt", 4L, 0))
                    .fluidInputs(Materials.Water.getFluid(100L)).duration(10 * SECONDS).eut(4).addTo(cutterRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 24))
                    .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "lampt", 4L, 0))
                    .fluidInputs(GT_ModHandler.getDistilledWater(75L)).duration(10 * SECONDS).eut(4)
                    .addTo(cutterRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 24))
                    .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "lampt", 4L, 0))
                    .fluidInputs(Materials.Lubricant.getFluid(25L)).duration(5 * SECONDS).eut(4).addTo(cutterRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 23))
                    .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "lampb", 4L, 0))
                    .fluidInputs(Materials.Water.getFluid(100L)).duration(10 * SECONDS).eut(4).addTo(cutterRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 23))
                    .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "lampb", 4L, 0))
                    .fluidInputs(GT_ModHandler.getDistilledWater(75L)).duration(10 * SECONDS).eut(4)
                    .addTo(cutterRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 23))
                    .itemOutputs(GT_ModHandler.getModItem(ZTones.ID, "lampb", 4L, 0))
                    .fluidInputs(Materials.Lubricant.getFluid(25L)).duration(5 * SECONDS).eut(4).addTo(cutterRecipes);

        }

        if (TinkerConstruct.isModLoaded()) {
            // Cutting Saw

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.crafting_table, 1))
                    .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CraftingStation", 1L))
                    .duration(4 * MINUTES).eut(TierEU.RECIPE_LV).addTo(cutterRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CraftingStation", 1L))
                    .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "CraftingSlab", 1L)).duration(4 * MINUTES)
                    .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 1))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Ardite, 9L))
                    .fluidInputs(Materials.Water.getFluid(1000)).duration(4 * MINUTES).eut(TierEU.RECIPE_LV)
                    .addTo(cutterRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 1))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Ardite, 9L))
                    .fluidInputs(GT_ModHandler.getDistilledWater(750L)).duration(4 * MINUTES).eut(TierEU.RECIPE_LV)
                    .addTo(cutterRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 1))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Ardite, 9L))
                    .fluidInputs(Materials.Lubricant.getFluid(250)).duration(2 * MINUTES).eut(TierEU.RECIPE_LV)
                    .addTo(cutterRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 2))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 9L))
                    .fluidInputs(Materials.Water.getFluid(1000)).duration(8 * MINUTES).eut(TierEU.RECIPE_LV)
                    .addTo(cutterRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 2))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 9L))
                    .fluidInputs(GT_ModHandler.getDistilledWater(750L)).duration(8 * MINUTES).eut(TierEU.RECIPE_LV)
                    .addTo(cutterRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 2))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 9L))
                    .fluidInputs(Materials.Lubricant.getFluid(250)).duration(4 * MINUTES).eut(TierEU.RECIPE_LV)
                    .addTo(cutterRecipes);

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

                GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Silicon_Ingot6.get(1L) // Optical Boul
                ).itemOutputs(ItemList.Circuit_Silicon_Wafer6.get((i + 1) * 2L)).fluidInputs(purified_water[i])
                        .duration(wafer_duration_ticks *= 0.95).eut(wafer_eu_per_tick).addTo(cutterRecipes);

            }
        }

        if (Chisel.isModLoaded()) {
            // Floor Carpet
            for (int meta = 0; meta < 16; ++meta) {
                GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Chisel.ID, "carpet_block", 1, meta))
                        .fluidInputs(Materials.Water.getFluid(4L))
                        .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "carpet", 2, meta)).duration(5 * SECONDS)
                        .eut(7).addTo(cutterRecipes);
                GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Chisel.ID, "carpet_block", 1, meta))
                        .fluidInputs(GT_ModHandler.getDistilledWater(3L))
                        .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "carpet", 2, meta)).duration(5 * SECONDS)
                        .eut(7).addTo(cutterRecipes);
                GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Chisel.ID, "carpet_block", 1, meta))
                        .fluidInputs(Materials.Lubricant.getFluid(1L))
                        .itemOutputs(GT_ModHandler.getModItem(Chisel.ID, "carpet", 2, meta)).duration(50).eut(7)
                        .addTo(cutterRecipes);
            }
        }
    }
}
