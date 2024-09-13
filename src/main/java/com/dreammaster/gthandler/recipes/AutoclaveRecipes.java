package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.*;
import static gregtech.api.recipe.RecipeMaps.autoclaveRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.material.MaterialsElements;

public class AutoclaveRecipes implements Runnable {

    @Override
    public void run() {
        spaceRecipes();

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.LapotronDust.get(30L))
                .itemOutputs(CustomItemList.RawLapotronCrystal.get(1L)).outputChances(10000)
                .fluidInputs(Materials.EnergeticAlloy.getMolten(576L)).duration(2 * MINUTES).eut(TierEU.RECIPE_HV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.LapotronDust.get(30L))
                .itemOutputs(CustomItemList.RawLapotronCrystal.get(1L)).outputChances(10000)
                .fluidInputs(Materials.VibrantAlloy.getMolten(288L)).duration(60 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTModHandler.getModItem(EnderZoo.ID, "enderFragment", 4L, 0),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(new ItemStack(Items.ender_pearl, 1, 0)).outputChances(8000)
                .fluidInputs(Materials.Water.getFluid(100)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTModHandler.getModItem(EnderZoo.ID, "enderFragment", 4L, 0),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(new ItemStack(Items.ender_pearl, 1, 0)).outputChances(9000)
                .fluidInputs(GTModHandler.getDistilledWater(50L)).duration(45 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTModHandler.getModItem(EnderZoo.ID, "enderFragment", 4L, 0),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(new ItemStack(Items.ender_pearl, 1, 0)).outputChances(10000)
                .fluidInputs(Materials.Void.getMolten(18)).duration(30 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(new ItemStack(Items.ender_pearl, 1, 0)).outputChances(8000)
                .fluidInputs(Materials.Water.getFluid(100)).duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(new ItemStack(Items.ender_pearl, 1, 0)).outputChances(9000)
                .fluidInputs(GTModHandler.getDistilledWater(75L)).duration(60 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 1L),
                        GTUtility.getIntegratedCircuit(3))
                .itemOutputs(new ItemStack(Items.ender_pearl, 1, 0)).outputChances(10000)
                .fluidInputs(Materials.Void.getMolten(36)).duration(45 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Parts_RawCrystalParts.get(1L))
                .itemOutputs(ItemList.Circuit_Parts_RawCrystalChip.get(1L)).outputChances(10000)
                .fluidInputs(Materials.Europium.getMolten(16)).duration(10 * MINUTES).eut(TierEU.RECIPE_HV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 2))
                .itemOutputs(ItemList.GalliumArsenideCrystal.get(1L)).outputChances(8000)
                .fluidInputs(Materials.Water.getFluid(200L)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 2))
                .itemOutputs(ItemList.GalliumArsenideCrystal.get(1L)).outputChances(10000)
                .fluidInputs(Materials.Void.getMolten(36L)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 2))
                .itemOutputs(ItemList.GalliumArsenideCrystal.get(1L)).outputChances(9000)
                .fluidInputs(GTModHandler.getDistilledWater(100L)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(autoclaveRecipes);

        if (GalacticraftMars.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Parts_RawCrystalParts.get(1L))
                    .itemOutputs(ItemList.Circuit_Parts_RawCrystalChip.get(1L)).outputChances(6000)
                    .fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 250)).duration(10 * MINUTES)
                    .eut(TierEU.RECIPE_HV).addTo(autoclaveRecipes);

        }
        if (Gendustry.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Parts_RawCrystalParts.get(1L))
                    .itemOutputs(ItemList.Circuit_Parts_RawCrystalChip.get(1L)).outputChances(8000)
                    .fluidInputs(FluidRegistry.getFluidStack("mutagen", 250)).duration(10 * MINUTES)
                    .eut(TierEU.RECIPE_HV).addTo(autoclaveRecipes);

        }

        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Silicon_Wafer6.get(1L), MaterialsElements.STANDALONE.HYPOGEN.getDust(1))
                .itemOutputs(ItemList.Circuit_Wafer_Bioware.get(1L)).outputChances(10000)
                .fluidInputs(Materials.BioMediumSterilized.getFluid(8_000L)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_UHV).addTo(autoclaveRecipes);

    }

    public static void spaceRecipes() {

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Emerald, 1))
                .itemOutputs(ItemList.Circuit_Parts_RawCrystalChip.get(1L)).outputChances(1000)
                .fluidInputs(Materials.Europium.getMolten(16)).requiresCleanRoom().requiresLowGravity()
                .duration(10 * MINUTES).eut(320).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Olivine, 1))
                .itemOutputs(ItemList.Circuit_Parts_RawCrystalChip.get(1L)).outputChances(1000)
                .fluidInputs(Materials.Europium.getMolten(16)).requiresCleanRoom().requiresLowGravity()
                .duration(10 * MINUTES).eut(320).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Emerald, 12))
                .itemOutputs(ItemList.Tool_DataOrb.get(1L)).outputChances(10000)
                .fluidInputs(Materials.UUMatter.getFluid(250L)).requiresCleanRoom().requiresLowGravity()
                .duration(10 * MINUTES).eut(TierEU.RECIPE_EV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Olivine, 12))
                .itemOutputs(ItemList.Tool_DataOrb.get(1L)).outputChances(10000)
                .fluidInputs(Materials.UUMatter.getFluid(250L)).requiresCleanRoom().requiresLowGravity()
                .duration(10 * MINUTES).eut(TierEU.RECIPE_EV).addTo(autoclaveRecipes);

        GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.StargateDustAncients.getIS().splitStack(64))
                .itemOutputs(com.dreammaster.item.ItemList.StargateCrystalAncients.getIS()).outputChances(10000)
                .fluidInputs(Materials.Silver.getPlasma(8000L)).requiresCleanRoom().requiresLowGravity()
                .duration(3 * MINUTES).eut(TierEU.RECIPE_ZPM).addTo(autoclaveRecipes);
    }
}
