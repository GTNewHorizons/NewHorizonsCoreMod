package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.PamsHarvestCraft;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class ChemicalBathRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addChemicalBathRecipe(
                CustomItemList.HotNetherrackBrick.get(1L),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000),
                CustomItemList.InfernalBrick.get(1L),
                GT_Values.NI,
                GT_Values.NI,
                new int[] { 10000 },
                200,
                30);

        GT_Values.RA.addChemicalBathRecipe(
                new ItemStack(Items.leather, 2, 0),
                Materials.PhosphoricAcid.getFluid(144),
                GT_ModHandler.getModItem(Backpack.ID, "tannedLeather", 1L, 0),
                GT_Values.NI,
                GT_Values.NI,
                new int[] { 10000 },
                300,
                30);
        GT_Values.RA.addChemicalBathRecipe(
                CustomItemList.ArtificialLeather.get(2L),
                Materials.PhosphoricAcid.getFluid(144),
                GT_ModHandler.getModItem(Backpack.ID, "tannedLeather", 1L, 0),
                GT_Values.NI,
                GT_Values.NI,
                new int[] { 10000 },
                300,
                30);
        // - Chlorine cleaning of pistons
        GT_Values.RA.addChemicalBathRecipe(
                new ItemStack(Blocks.sticky_piston, 1, 0),
                Materials.Chlorine.getGas(10L),
                new ItemStack(Blocks.piston, 1, 0),
                GT_Values.NI,
                GT_Values.NI,
                null,
                30,
                30);
        // Cooling Hot Khantal MV
        GT_Values.RA.addChemicalBathRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Kanthal, 1L),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250),
                new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Kanthal, 1L),
                GT_Values.NI,
                GT_Values.NI,
                null,
                1200,
                120);
        // Cooling Hot Tantalum MV
        GT_Values.RA.addChemicalBathRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tantalum, 1L),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250),
                new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tantalum, 1L),
                GT_Values.NI,
                GT_Values.NI,
                null,
                1800,
                120);
        // Cooling Hot Silicon MV
        GT_Values.RA.addChemicalBathRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Silicon, 1L),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250),
                new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Silicon, 1L),
                GT_Values.NI,
                GT_Values.NI,
                null,
                600,
                120);
        // Cooling Hot SiliconSG MV
        GT_Values.RA.addChemicalBathRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.SiliconSG, 1L),
                new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250),
                new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.SiliconSG, 1L),
                GT_Values.NI,
                GT_Values.NI,
                null,
                800,
                120);

        GT_Values.RA.addChemicalBathRecipe(
                CustomItemList.MysteriousCrystalGemExquisite.get(1L),
                Materials.UUMatter.getFluid(144),
                CustomItemList.MysteriousCrystalLens.get(1L),
                GT_Values.NI,
                GT_Values.NI,
                new int[] { 10000 },
                600,
                500000);

        GT_Values.RA.addChemicalBathRecipe(
                ItemList.Circuit_Parts_GlassFiber.get(1L),
                Materials.Epoxid.getMolten(144L),
                Materials.EpoxidFiberReinforced.getPlates(1),
                GT_Values.NI,
                GT_Values.NI,
                new int[] { 10000 },
                240,
                16);
        GT_Values.RA.addChemicalBathRecipe(
                GT_ModHandler.getIC2Item("carbonFiber", 1),
                Materials.Epoxid.getMolten(144L),
                Materials.EpoxidFiberReinforced.getPlates(1),
                GT_Values.NI,
                GT_Values.NI,
                new int[] { 10000 },
                240,
                16);

        if (Forestry.isModLoaded() && IndustrialCraft2.isModLoaded()) {
            GT_Values.RA.addChemicalBathRecipe(
                    GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBiochaff", 1L, 0),
                    Materials.Water.getFluid(750L),
                    GT_ModHandler.getModItem(Forestry.ID, "mulch", 8L, 0),
                    GT_ModHandler.getModItem(Forestry.ID, "mulch", 4L, 0),
                    GT_ModHandler.getModItem(Forestry.ID, "mulch", 4L, 0),
                    new int[] { 10000, 3300, 2000 },
                    500,
                    30);
        }

        if (BartWorks.isModLoaded()) {
            GT_Values.RA.addChemicalBathRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.nanite, Materials.Silver, 0, false),
                    Materials.Grade7PurifiedWater.getFluid(1000L),
                    Materials.Grade8PurifiedWater.getFluid(900L),
                    GT_ModHandler.getModItem(GTPlusPlus.ID, "particleBase", 1L, 24), // Unknown particle
                    GT_Values.NI,
                    GT_Values.NI,
                    new int[] { 100 },
                    250 * 20,
                    3_932_160);
        }

        if (EnderIO.isModLoaded()) {
            GT_Values.RA.addChemicalBathRecipe(
                    GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L),
                    new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72),
                    GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 4),
                    GT_Values.NI,
                    GT_Values.NI,
                    new int[] { 10000 },
                    500,
                    30);
            GT_Values.RA.addChemicalBathRecipe(
                    GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 1),
                    new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72),
                    GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 5),
                    GT_Values.NI,
                    GT_Values.NI,
                    new int[] { 10000 },
                    500,
                    30);
        }

        if (PamsHarvestCraft.isModLoaded()) {
            GT_Values.RA.addChemicalBathRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2L, 0),
                    Materials.PolyvinylChloride.getMolten(144L),
                    CustomItemList.ArtificialLeather.get(2L),
                    GT_Values.NI,
                    GT_Values.NI,
                    new int[] { 10000 },
                    300,
                    120);
        }

    }
}
