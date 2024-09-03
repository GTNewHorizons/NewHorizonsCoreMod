package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.ProjectRedCore;
import static gregtech.api.enums.Mods.ProjectRedIllumination;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.ZTones;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;

public class CuttingMachineRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_ILC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_ILC.get(8L)).duration(45 * SECONDS).eut(64).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_Ram.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_Ram.get(32L)).duration(45 * SECONDS).eut(96).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_NAND.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_NAND.get(32L)).requiresCleanRoom().duration(45 * SECONDS).eut(192)
                .addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_NOR.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_NOR.get(16L)).requiresCleanRoom().duration(45 * SECONDS).eut(192)
                .addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_CPU.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_CPU.get(8L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_Simple_SoC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_Simple_SoC.get(6L)).duration(45 * SECONDS).eut(64)
                .addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_SoC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_SoC.get(6L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_SoC2.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_SoC2.get(6L)).requiresCleanRoom().duration(45 * SECONDS).eut(1024)
                .addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_ULPIC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_ULPIC.get(6L)).duration(45 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_LPIC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_LPIC.get(4L)).duration(45 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_PIC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_PIC.get(4L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_HPIC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_HPIC.get(2L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_UHPIC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_UHPIC.get(2L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_NPIC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_NPIC.get(2L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_PPIC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_PPIC.get(2L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_QPIC.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_QPIC.get(2L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_UHV).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_NanoCPU.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_NanoCPU.get(8L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_QuantumCPU.get(1L))
                .itemOutputs(ItemList.Circuit_Chip_QuantumCPU.get(4L)).requiresCleanRoom().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Wafer_Bioware.get(1L))
                .itemOutputs(ItemList.Circuit_Parts_Chip_Bioware.get(16L), ItemList.Circuit_Chip_Biocell.get(16L))
                .fluidInputs(Materials.UUMatter.getFluid(8_000L)).duration(15 * SECONDS).eut(TierEU.RECIPE_UEV)
                .addTo(cutterRecipes);
        if (IndustrialCraft2.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(IndustrialCraft2.ID, "blockAlloyGlass", 1L, 0))
                    .itemOutputs(CustomItemList.ReinforcedGlassPLate.get(2L)).duration(60 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);

        }

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.NandChipBoard.get(1)).itemOutputs(ItemList.NandChip.get(8))
                .requiresCleanRoom().duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(cutterRecipes);

        if (ZTones.isModLoaded() && ProjectRedCore.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 16))
                    .itemOutputs(GTModHandler.getModItem(ZTones.ID, "lampf", 4L, 0))
                    .fluidInputs(Materials.Water.getFluid(100L)).duration(10 * SECONDS).eut(4).addTo(cutterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 16))
                    .itemOutputs(GTModHandler.getModItem(ZTones.ID, "lampf", 4L, 0))
                    .fluidInputs(GTModHandler.getDistilledWater(75L)).duration(10 * SECONDS).eut(4)
                    .addTo(cutterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 16))
                    .itemOutputs(GTModHandler.getModItem(ZTones.ID, "lampf", 4L, 0))
                    .fluidInputs(Materials.Lubricant.getFluid(25L)).duration(5 * SECONDS).eut(4).addTo(cutterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 24))
                    .itemOutputs(GTModHandler.getModItem(ZTones.ID, "lampt", 4L, 0))
                    .fluidInputs(Materials.Water.getFluid(100L)).duration(10 * SECONDS).eut(4).addTo(cutterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 24))
                    .itemOutputs(GTModHandler.getModItem(ZTones.ID, "lampt", 4L, 0))
                    .fluidInputs(GTModHandler.getDistilledWater(75L)).duration(10 * SECONDS).eut(4)
                    .addTo(cutterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 24))
                    .itemOutputs(GTModHandler.getModItem(ZTones.ID, "lampt", 4L, 0))
                    .fluidInputs(Materials.Lubricant.getFluid(25L)).duration(5 * SECONDS).eut(4).addTo(cutterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 23))
                    .itemOutputs(GTModHandler.getModItem(ZTones.ID, "lampb", 4L, 0))
                    .fluidInputs(Materials.Water.getFluid(100L)).duration(10 * SECONDS).eut(4).addTo(cutterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 23))
                    .itemOutputs(GTModHandler.getModItem(ZTones.ID, "lampb", 4L, 0))
                    .fluidInputs(GTModHandler.getDistilledWater(75L)).duration(10 * SECONDS).eut(4)
                    .addTo(cutterRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1L, 23))
                    .itemOutputs(GTModHandler.getModItem(ZTones.ID, "lampb", 4L, 0))
                    .fluidInputs(Materials.Lubricant.getFluid(25L)).duration(5 * SECONDS).eut(4).addTo(cutterRecipes);

        }

        if (TinkerConstruct.isModLoaded()) {
            // Cutting Saw

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.crafting_table, 1))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "CraftingStation", 1L))
                    .duration(4 * MINUTES).eut(TierEU.RECIPE_LV).addTo(cutterRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "CraftingStation", 1L))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "CraftingSlab", 1L)).duration(4 * MINUTES)
                    .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 1))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Ardite, 9L))
                    .fluidInputs(Materials.Water.getFluid(1000)).duration(4 * MINUTES).eut(TierEU.RECIPE_LV)
                    .addTo(cutterRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 1))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Ardite, 9L))
                    .fluidInputs(GTModHandler.getDistilledWater(750L)).duration(4 * MINUTES).eut(TierEU.RECIPE_LV)
                    .addTo(cutterRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 1))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Ardite, 9L))
                    .fluidInputs(Materials.Lubricant.getFluid(250)).duration(2 * MINUTES).eut(TierEU.RECIPE_LV)
                    .addTo(cutterRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 2))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 9L))
                    .fluidInputs(Materials.Water.getFluid(1000)).duration(8 * MINUTES).eut(TierEU.RECIPE_LV)
                    .addTo(cutterRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 2))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 9L))
                    .fluidInputs(GTModHandler.getDistilledWater(750L)).duration(8 * MINUTES).eut(TierEU.RECIPE_LV)
                    .addTo(cutterRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 2))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 9L))
                    .fluidInputs(Materials.Lubricant.getFluid(250)).duration(4 * MINUTES).eut(TierEU.RECIPE_LV)
                    .addTo(cutterRecipes);

        }

        // Photonically Prepared Wafer
        int wafer_duration_ticks = 50 * SECONDS;
        long wafer_eu_per_tick = TierEU.RECIPE_UEV;

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Silicon_Ingot6.get(1L)) // Optical boule
                .itemOutputs(ItemList.Circuit_Silicon_Wafer6.get(16))
                .fluidInputs(Materials.Grade7PurifiedWater.getFluid(1000L)).duration(wafer_duration_ticks)
                .eut(wafer_eu_per_tick).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Silicon_Ingot6.get(1L)) // Optical boule
                .itemOutputs(ItemList.Circuit_Silicon_Wafer6.get(24))
                .fluidInputs(Materials.Grade8PurifiedWater.getFluid(1000L)).duration(wafer_duration_ticks / 2)
                .eut(wafer_eu_per_tick).addTo(cutterRecipes);

        if (Chisel.isModLoaded()) {
            // Floor Carpet
            for (int meta = 0; meta < 16; ++meta) {
                GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(Chisel.ID, "carpet_block", 1, meta))
                        .fluidInputs(Materials.Water.getFluid(4L))
                        .itemOutputs(GTModHandler.getModItem(Chisel.ID, "carpet", 2, meta)).duration(5 * SECONDS).eut(7)
                        .addTo(cutterRecipes);
                GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(Chisel.ID, "carpet_block", 1, meta))
                        .fluidInputs(GTModHandler.getDistilledWater(3L))
                        .itemOutputs(GTModHandler.getModItem(Chisel.ID, "carpet", 2, meta)).duration(5 * SECONDS).eut(7)
                        .addTo(cutterRecipes);
                GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(Chisel.ID, "carpet_block", 1, meta))
                        .fluidInputs(Materials.Lubricant.getFluid(1L))
                        .itemOutputs(GTModHandler.getModItem(Chisel.ID, "carpet", 2, meta)).duration(50).eut(7)
                        .addTo(cutterRecipes);
            }
        }
    }
}
