package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.*;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gtPlusPlus.core.material.ELEMENT;

public class AutoclaveRecipes implements Runnable {

    @Override
    public void run() {
        spaceRecipes();

        GT_Values.RA.addAutoclaveRecipe(
                CustomItemList.LapotronDust.get(30L),
                Materials.EnergeticAlloy.getMolten(576L),
                CustomItemList.RawLapotronCrystal.get(1L),
                10000,
                2400,
                480);
        GT_Values.RA.addAutoclaveRecipe(
                CustomItemList.LapotronDust.get(30L),
                Materials.VibrantAlloy.getMolten(288L),
                CustomItemList.RawLapotronCrystal.get(1L),
                10000,
                1200,
                480);

        GT_Values.RA.addAutoclaveRecipe(
                GT_ModHandler.getModItem(EnderZoo.ID, "enderFragment", 4L, 0),
                GT_Utility.getIntegratedCircuit(1),
                Materials.Water.getFluid(100),
                new ItemStack(Items.ender_pearl, 1, 0),
                8000,
                1200,
                30,
                false);
        GT_Values.RA.addAutoclaveRecipe(
                GT_ModHandler.getModItem(EnderZoo.ID, "enderFragment", 4L, 0),
                GT_Utility.getIntegratedCircuit(2),
                GT_ModHandler.getDistilledWater(50L),
                new ItemStack(Items.ender_pearl, 1, 0),
                9000,
                900,
                30,
                false);
        GT_Values.RA.addAutoclaveRecipe(
                GT_ModHandler.getModItem(EnderZoo.ID, "enderFragment", 4L, 0),
                GT_Utility.getIntegratedCircuit(3),
                Materials.Void.getMolten(18),
                new ItemStack(Items.ender_pearl, 1, 0),
                10000,
                600,
                30,
                false);

        GT_Values.RA.addAutoclaveRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L),
                GT_Utility.getIntegratedCircuit(1),
                Materials.Water.getFluid(100),
                new ItemStack(Items.ender_pearl, 1, 0),
                8000,
                1500,
                30,
                false);
        GT_Values.RA.addAutoclaveRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L),
                GT_Utility.getIntegratedCircuit(2),
                GT_ModHandler.getDistilledWater(75L),
                new ItemStack(Items.ender_pearl, 1, 0),
                9000,
                1200,
                30,
                false);
        GT_Values.RA.addAutoclaveRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L),
                GT_Utility.getIntegratedCircuit(3),
                Materials.Void.getMolten(36),
                new ItemStack(Items.ender_pearl, 1, 0),
                10000,
                900,
                30,
                false);

        GT_Values.RA.addAutoclaveRecipe(
                ItemList.Circuit_Parts_RawCrystalParts.get(1L),
                Materials.Europium.getMolten(16),
                ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                10000,
                12000,
                480);

        GT_Values.RA.addAutoclaveRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 2),
                Materials.Water.getFluid(200L),
                ItemList.GalliumArsenideCrystal.get(1L),
                100 * 80,
                400,
                480);
        GT_Values.RA.addAutoclaveRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 2),
                Materials.Void.getMolten(36L),
                ItemList.GalliumArsenideCrystal.get(1L),
                100 * 100,
                400,
                480);
        GT_Values.RA.addAutoclaveRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 2),
                GT_ModHandler.getDistilledWater(100L),
                ItemList.GalliumArsenideCrystal.get(1L),
                100 * 90,
                400,
                480);

        if (GalacticraftMars.isModLoaded()) {
            GT_Values.RA.addAutoclaveRecipe(
                    ItemList.Circuit_Parts_RawCrystalParts.get(1L),
                    FluidRegistry.getFluidStack("bacterialsludge", 250),
                    ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                    6000,
                    12000,
                    480);
        }
        if (Gendustry.isModLoaded()) {
            GT_Values.RA.addAutoclaveRecipe(
                    ItemList.Circuit_Parts_RawCrystalParts.get(1L),
                    FluidRegistry.getFluidStack("mutagen", 250),
                    ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                    8000,
                    12000,
                    480);
        }
        if (GTPlusPlus.isModLoaded()) {
            GT_Values.RA.addAutoclaveRecipe(
                    ItemList.Circuit_Silicon_Wafer6.get(1L),
                    ELEMENT.STANDALONE.HYPOGEN.getDust(1),
                    Materials.BioMediumSterilized.getFluid(8_000L),
                    ItemList.Circuit_Wafer_Bioware.get(1L),
                    10000,
                    60 * 20,
                    (int) TierEU.RECIPE_UHV,
                    false);
        }
    }

    public static void spaceRecipes() {
        GT_Values.RA.addAutoclaveSpaceRecipe(
                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Emerald, 1),
                GT_Values.NI,
                Materials.Europium.getMolten(16),
                ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                1000,
                12000,
                320,
                true);
        GT_Values.RA.addAutoclaveSpaceRecipe(
                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Olivine, 1),
                GT_Values.NI,
                Materials.Europium.getMolten(16),
                ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                1000,
                12000,
                320,
                true);

        GT_Values.RA.addAutoclaveSpaceRecipe(
                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Emerald, 12),
                GT_Values.NI,
                Materials.UUMatter.getFluid(250L),
                ItemList.Tool_DataOrb.get(1L),
                10000,
                12000,
                960,
                true);
        GT_Values.RA.addAutoclaveSpaceRecipe(
                GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Olivine, 12),
                GT_Values.NI,
                Materials.UUMatter.getFluid(250L),
                ItemList.Tool_DataOrb.get(1L),
                10000,
                12000,
                960,
                true);

        if (SGCraft.isModLoaded()) {
            GT_Values.RA.addAutoclaveSpaceRecipe(
                    com.dreammaster.item.ItemList.StargateCrystalDust.getIS().splitStack(64),
                    GT_Values.NI,
                    Materials.Silver.getPlasma(8000L),
                    GT_ModHandler.getModItem(SGCraft.ID, "sgCoreCrystal", 1L),
                    10000,
                    3600,
                    131000,
                    true);
        }

    }
}
