package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.SGCraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.blastFurnaceRecipes;
import static gregtech.api.util.GTRecipeBuilder.HOURS;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeConstants.COIL_HEAT;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.item.NHItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

public class BlastFurnaceRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.UncookedSlush.get(1L), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.GlowingMarshmallow.get(1L)).fluidInputs(Materials.Radon.getGas(1000L))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.RedstoneAlloy, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(40 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.RedstoneAlloy, 1L))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.ConductiveIron, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.ConductiveIron, 1L))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticAlloy, 1L))
                .fluidInputs(Materials.Hydrogen.getGas(1000L)).duration(1 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticAlloy, 1L))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticSilver, 1L))
                .fluidInputs(Materials.Hydrogen.getGas(1000L)).duration(1 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticSilver, 1L))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.VibrantAlloy, 1L))
                .fluidInputs(Materials.Hydrogen.getGas(1000L)).duration(2 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.VibrantAlloy, 1L))
                .duration(5 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.VividAlloy, 1L))
                .fluidInputs(Materials.Hydrogen.getGas(1000L)).duration(2 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.VividAlloy, 1L))
                .duration(5 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallineAlloy, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 4500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallineAlloy, 1L))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CrystallinePinkSlime, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallinePinkSlime, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 5000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CrystallinePinkSlime, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallinePinkSlime, 1L))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.MelodicAlloy, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 5400).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.MelodicAlloy, 1L))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5800)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.StellarAlloy, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.StellarAlloy, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(2 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LuV)
                .metadata(COIL_HEAT, 7200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.StellarAlloy, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.StellarAlloy, 1L))
                .duration(4 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 9000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 1L))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.PulsatingIron, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.PulsatingIron, 1L))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Soularium, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).duration(50 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Soularium, 1L))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.DarkSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(50 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.DarkSteel, 1L))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.EndSteel, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 4500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.EndSteel, 1L))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnderiumBase, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 3300).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnderiumBase, 1L))
                .duration(5 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).duration(2 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 4500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L))
                .duration(5 * MINUTES + 50 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 4500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Reinforced, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Reinforced, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1700).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Reinforced, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Reinforced, 1L))
                .duration(1 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1700)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Galgadorian, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Galgadorian, 1L))
                .fluidInputs(Materials.Hydrogen.getGas(1000L)).duration(1 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Galgadorian, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Galgadorian, 1L))
                .duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnhancedGalgadorian, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnhancedGalgadorian, 1L))
                .fluidInputs(Materials.Hydrogen.getGas(1000L)).duration(2 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 4200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Draconium, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(2 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LuV)
                .metadata(COIL_HEAT, 7200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.DraconiumAwakened, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.DraconiumAwakened, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(2 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .metadata(COIL_HEAT, 9900).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(1 * MINUTES + 10 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1700).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L))
                .duration(1 * MINUTES + 25 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1700)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ardite, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L))
                .fluidInputs(Materials.Hydrogen.getGas(1000L)).duration(1 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ardite, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L)).duration(2 * MINUTES)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Manyullyn, 1L))
                .fluidInputs(Materials.Hydrogen.getGas(1000L)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3300).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Manyullyn, 1L))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Desh, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Desh, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_HV)
                .metadata(COIL_HEAT, 2500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Desh, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Desh, 1L))
                .duration(2 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.ElectrumFlux, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.ElectrumFlux, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(42 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .metadata(COIL_HEAT, 9000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.FierySteel, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.FierySteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(50 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.FierySteel, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.FierySteel, 1L))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1900)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Sunnarium, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 4500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Sunnarium, 1L))
                .duration(1 * MINUTES + 50 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.HSSG, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSG, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(1 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.HSSG, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSG, 1L))
                .duration(3 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_IV / 2).metadata(COIL_HEAT, 4500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.HSSE, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSE, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).duration(2 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 5000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.HSSE, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSE, 1L))
                .duration(4 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5400)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.HSSS, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSS, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 5000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.HSSS, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSS, 1L))
                .duration(7 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5400)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadah, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(21 * SECONDS).eut(TierEU.RECIPE_IV)
                .metadata(COIL_HEAT, 5000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahAlloy, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahAlloy, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(42 * SECONDS).eut(TierEU.RECIPE_ZPM / 2)
                .metadata(COIL_HEAT, 7200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahEnriched, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(42 * SECONDS).eut(TierEU.RECIPE_IV)
                .metadata(COIL_HEAT, 5350).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadria, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(21 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .metadata(COIL_HEAT, 9000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Trinium, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(49 * SECONDS).eut(TierEU.RECIPE_LuV)
                .metadata(COIL_HEAT, 7200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmium, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).duration(50 * SECONDS).eut(TierEU.RECIPE_LuV)
                .metadata(COIL_HEAT, 4500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmium, 1L))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 4500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Iridium, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(50 * SECONDS).eut(TierEU.RECIPE_IV)
                .metadata(COIL_HEAT, 4500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Iridium, 1L))
                .duration(2 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 4500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Oriharukon, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Oriharukon, 1L))
                .duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Vyroxeres, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vyroxeres, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Vyroxeres, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vyroxeres, 1L))
                .duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Orichalcum, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Orichalcum, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Orichalcum, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Orichalcum, 1L))
                .duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Alduorite, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Alduorite, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Alduorite, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Alduorite, 1L))
                .duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6600)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Mithril, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Mithril, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 6600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Mithril, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Mithril, 1L))
                .duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 6600)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ceruclase, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Ceruclase, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 6600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ceruclase, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Ceruclase, 1L))
                .duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 6600)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Vulcanite, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vulcanite, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 8400).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Vulcanite, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vulcanite, 1L))
                .duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 8400)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.ShadowIron, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.ShadowIron, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 8400).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.ShadowIron, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.ShadowIron, 1L))
                .duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 8400)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrysotile, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Chrysotile, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_UV).metadata(COIL_HEAT, 9400).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrysotile, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Chrysotile, 1L))
                .duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_UV).metadata(COIL_HEAT, 9400)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tartarite, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tartarite, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_UHV).metadata(COIL_HEAT, 10400).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tartarite, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tartarite, 1L))
                .duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_UHV).metadata(COIL_HEAT, 10400)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(5 * MINUTES).eut(TierEU.RECIPE_ZPM)
                .metadata(COIL_HEAT, 9000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L))
                .duration(6 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumSteel, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.VanadiumSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1453).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumSteel, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.VanadiumSteel, 1L))
                .duration(1 * MINUTES + 12 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1453)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.DamascusSteel, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.DamascusSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.DamascusSteel, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.DamascusSteel, 1L))
                .duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.BlackSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(50 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.BlackSteel, 1L))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.RedSteel, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.RedSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(55 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1300).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.RedSteel, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.RedSteel, 1L))
                .duration(1 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1300)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlueSteel, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.BlueSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1400).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlueSteel, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.BlueSteel, 1L))
                .duration(1 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1400)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconSG, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.SiliconSG, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 2273).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconSG, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.SiliconSG, 1L))
                .duration(1 * MINUTES + 50 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2273)
                .addTo(blastFurnaceRecipes);
        // 2Al(OH)3 = Al2O3 + 3H2O

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumhydroxide, 8L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1300).addTo(blastFurnaceRecipes);
        // 2NaAlO2 + CO2 = Al2O3 + Na2CO3

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 8L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SodiumCarbonate, 6L))
                .fluidInputs(Materials.CarbonDioxide.getGas(1000L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);
        // 2Al2O3 + 3C = 4Al + 3CO2

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 3L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 4L))
                .fluidOutputs(Materials.CarbonDioxide.getGas(3000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 2054).addTo(blastFurnaceRecipes);
        // 6Al2O3 =Na3AlF6= 12Al

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 30L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cryolite, 15L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 12L)).duration(4 * MINUTES)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 963).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_HV)
                .metadata(COIL_HEAT, 2054).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1L))
                .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2054)
                .addTo(blastFurnaceRecipes);
        // NEEDED TO MOVE FROM GREG, CODE WAS TOO LONG

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmiridium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmiridium, 1L))
                .fluidInputs(Materials.Helium.getGas(1000)).duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_LuV)
                .metadata(COIL_HEAT, 4500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L), Materials.Ash.getDust(1))
                .outputChances(10000, 1111).fluidInputs(Materials.Oxygen.getGas(1000L)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L), Materials.Ash.getDust(1))
                .outputChances(10000, 1111).duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 2000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.WroughtIron, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L), Materials.Ash.getDust(1))
                .outputChances(10000, 1111).duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 2000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L), Materials.Ash.getDust(1))
                .outputChances(10000, 1111).duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 2000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.WroughtIron, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L), Materials.Ash.getDust(1))
                .outputChances(10000, 1111).duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 2000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.PigIron, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L), Materials.Ash.getDust(1))
                .outputChances(10000, 1111).fluidInputs(Materials.Oxygen.getGas(1000L)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.WroughtIron, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L), Materials.Ash.getDust(1))
                .outputChances(10000, 1111).fluidInputs(Materials.Oxygen.getGas(1000L)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.ShadowIron, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.ShadowSteel, 4L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(25 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.GalliumArsenide, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Arsenic, 1L))
                .itemOutputs(ItemList.GalliumArsenideCrystal.get(1L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1511).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 2L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(ItemList.GalliumArsenideCrystal.get(1L)).fluidInputs(Materials.Oxygen.getGas(1000L))
                .duration(45 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1511).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Rutile, 3L))
                .fluidOutputs(Materials.CarbonMonoxide.getGas(1000L)).duration(2 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1700).addTo(blastFurnaceRecipes);
        // 2Mg + TiCl4 = Ti + 2MgCl2

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 2L),
                        GTUtility.getIntegratedCircuit(12))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesiumchloride, 6L))
                .fluidInputs(Materials.Titaniumtetrachloride.getFluid(1000L)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2140).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.AnnealedCopper, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(25 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 1940).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(1 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 1940).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tungsten, 1L))
                .duration(10 * MINUTES).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 3000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tungsten, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(8 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 3000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tantalum, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tantalum, 1L))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tantalum, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tantalum, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(2 * MINUTES).eut(TierEU.RECIPE_HV)
                .metadata(COIL_HEAT, 2400).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.TPV, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.TPV, 1L))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 3000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.TPV, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.TPV, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(2 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 3000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenSteel, 1L))
                .duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenSteel, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(2 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 4000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.TungstenCarbide, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenCarbide, 1L))
                .duration(2 * MINUTES + 3 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2460)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.TungstenCarbide, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenCarbide, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(1 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2460).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumGallium, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.VanadiumGallium, 1L))
                .duration(3 * MINUTES + 45 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 4500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumGallium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.VanadiumGallium, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV)
                .metadata(COIL_HEAT, 4500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.NiobiumTitanium, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.NiobiumTitanium, 1L))
                .duration(3 * MINUTES + 45 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 4500)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.NiobiumTitanium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.NiobiumTitanium, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV)
                .metadata(COIL_HEAT, 4500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Nichrome, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Nichrome, 1L))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2700)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Nichrome, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Nichrome, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 2700).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 1L))
                .duration(1 * MINUTES + 25 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1700)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_HV)
                .metadata(COIL_HEAT, 1700).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Pentacadmiummagnesiumhexaoxid, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Pentacadmiummagnesiumhexaoxid, 1L))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Pentacadmiummagnesiumhexaoxid, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Pentacadmiummagnesiumhexaoxid, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(1 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(
                        GTOreDictUnificator
                                .get(OrePrefixes.ingotHot, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L))
                .duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3300)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(
                        GTOreDictUnificator
                                .get(OrePrefixes.ingotHot, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3300).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uraniumtriplatinid, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Uraniumtriplatinid, 1L))
                .duration(2 * MINUTES + 45 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4400)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uraniumtriplatinid, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Uraniumtriplatinid, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).duration(2 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 4400).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Vanadiumtriindinid, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vanadiumtriindinid, 1L))
                .duration(3 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Vanadiumtriindinid, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vanadiumtriindinid, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).duration(2 * MINUTES + 50 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 5200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(
                                OrePrefixes.dust,
                                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(
                        GTOreDictUnificator.get(
                                OrePrefixes.ingotHot,
                                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                1L))
                .duration(4 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6000)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(
                                OrePrefixes.dust,
                                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(
                        GTOreDictUnificator.get(
                                OrePrefixes.ingotHot,
                                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(2 * MINUTES + 27 * SECONDS).eut(TierEU.RECIPE_IV)
                .metadata(COIL_HEAT, 6000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.DeepIron, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.DeepIron, 1L))
                .duration(5 * MINUTES).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 7500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.DeepIron, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.DeepIron, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(2 * MINUTES + 48 * SECONDS).eut(TierEU.RECIPE_IV)
                .metadata(COIL_HEAT, 7500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(
                        GTOreDictUnificator
                                .get(OrePrefixes.ingotHot, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L))
                .duration(5 * MINUTES).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 9000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator
                                .get(OrePrefixes.dust, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(
                        GTOreDictUnificator
                                .get(OrePrefixes.ingotHot, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(2 * MINUTES + 48 * SECONDS).eut(TierEU.RECIPE_IV)
                .metadata(COIL_HEAT, 9000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuvwire, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuvwire, 1L))
                .duration(5 * MINUTES + 50 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 9900)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuvwire, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuvwire, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(5 * MINUTES).eut(TierEU.RECIPE_LuV)
                .metadata(COIL_HEAT, 9900).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuhvwire, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(
                        GTOreDictUnificator
                                .get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuhvwire, 1L))
                .duration(7 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 10800)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuhvwire, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(
                        GTOreDictUnificator
                                .get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuhvwire, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(6 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .metadata(COIL_HEAT, 10500).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tritanium, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tritanium, 1L))
                .duration(5 * MINUTES).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tritanium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tritanium, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(4 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .metadata(COIL_HEAT, 9900).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Quantium, 1L))
                .duration(2 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Quantium, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_IV)
                .metadata(COIL_HEAT, 5400).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Bedrockium, 1L))
                .duration(7 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Bedrockium, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(6 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .metadata(COIL_HEAT, 9900).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.MysteriousCrystal, 1L))
                .duration(5 * MINUTES).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 7200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.MysteriousCrystal, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(3 * MINUTES + 45 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .metadata(COIL_HEAT, 7200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.CosmicNeutronium, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.CosmicNeutronium, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(6 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .metadata(COIL_HEAT, 9900).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.InfinityCatalyst, 1L))
                .duration(12 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_UV).metadata(COIL_HEAT, 10800)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.InfinityCatalyst, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(10 * MINUTES).eut(TierEU.RECIPE_UV)
                .metadata(COIL_HEAT, 10800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infinity, 1L))
                .duration(25 * MINUTES).eut(TierEU.RECIPE_UHV).metadata(COIL_HEAT, 10800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infinity, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(20 * MINUTES + 50 * SECONDS).eut(TierEU.RECIPE_UHV)
                .metadata(COIL_HEAT, 10800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Kanthal, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Kanthal, 1L))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Kanthal, 1L),
                        GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Kanthal, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).duration(45 * SECONDS).eut(TierEU.RECIPE_HV)
                .metadata(COIL_HEAT, 1800).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.FerriteMixture, 1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.NickelZincFerrite, 1L))
                .fluidInputs(Materials.Oxygen.getGas(2000)).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, (int) Materials.NickelZincFerrite.mBlastFurnaceTemp).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.BrickNether, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.HotNetherrackBrick.get(1L)).fluidInputs(Materials.Oxygen.getGas(1000L))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.InfernalBrick.get(1L), CustomItemList.CokeOvenBrick.get(1L))
                .itemOutputs(CustomItemList.AdvancedCokeOvenBrick.get(2L)).fluidInputs(Materials.Oxygen.getGas(1000L))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.RawNeutronium.get(1L), GTUtility.getIntegratedCircuit(11))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Neutronium, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).duration(4 * MINUTES + 28 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_UV)
                .metadata(COIL_HEAT, 9000).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(Materials.Sapphire.getDust(3), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(Materials.Aluminiumoxide.getDust(1)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(Materials.GreenSapphire.getDust(3), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(Materials.Aluminiumoxide.getDust(1)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder().itemInputs(Materials.Ruby.getDust(3), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(Materials.Aluminiumoxide.getDust(1)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1200).addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        Materials.Sapphire.getDust(1),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L))
                .itemOutputs(Materials.Aluminiumoxide.getDust(1), Materials.DarkAsh.getDust(1))
                .outputChances(10000, 1111).duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        Materials.GreenSapphire.getDust(1),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L))
                .itemOutputs(Materials.Aluminiumoxide.getDust(1), Materials.DarkAsh.getDust(1))
                .outputChances(10000, 1111).duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(Materials.Ruby.getDust(1), GTOreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L))
                .itemOutputs(Materials.Aluminiumoxide.getDust(1), Materials.DarkAsh.getDust(1))
                .outputChances(10000, 1111).duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(blastFurnaceRecipes);

        if (TinkerConstruct.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 12),
                            GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(Materials.Aluminium.getIngots(1)).duration(1 * MINUTES + 20 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 12),
                            GTUtility.getIntegratedCircuit(11))
                    .itemOutputs(Materials.Aluminium.getIngots(1)).fluidInputs(Materials.Nitrogen.getGas(1000))
                    .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1300).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.glass, 1, 0), GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "GlassBlock", 1L, 0)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(new ItemStack(Blocks.glass_pane, 1, 0), GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "GlassPane", 1L, 0)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 1))
                    .itemOutputs(ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L))
                    .fluidInputs(Materials.Helium.getGas(1000)).duration(45 * SECONDS).eut(TierEU.RECIPE_HV)
                    .metadata(COIL_HEAT, 5000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Olivine, 1))
                    .itemOutputs(ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L))
                    .fluidInputs(Materials.Helium.getGas(1000)).duration(45 * SECONDS).eut(TierEU.RECIPE_HV)
                    .metadata(COIL_HEAT, 5000).addTo(blastFurnaceRecipes);

        }

        if (EnderIO.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(Materials.CertusQuartz.getDust(2), Materials.Glass.getDust(1))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder().itemInputs(Materials.NetherQuartz.getDust(2), Materials.Glass.getDust(1))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder().itemInputs(Materials.CertusQuartz.getDust(2), Materials.Quartzite.getDust(2))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder().itemInputs(Materials.NetherQuartz.getDust(2), Materials.Quartzite.getDust(2))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(Materials.CertusQuartz.getDust(1), Materials.BorosilicateGlass.getDust(1))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(Materials.NetherQuartz.getDust(1), Materials.BorosilicateGlass.getDust(1))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(blastFurnaceRecipes);

        }

        if (SGCraft.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(NHItemList.StargateCrystalDust.getIS().splitStack(64))
                    .fluidInputs(MaterialsUEVplus.StargateCrystalSlurry.getFluid(128_000_000L))
                    .itemOutputs(GTModHandler.getModItem(SGCraft.ID, "sgCoreCrystal", 1L)).duration(7 * 24 * HOURS * 2)
                    .eut(TierEU.RECIPE_MAX).metadata(COIL_HEAT, 100_000).addTo(blastFurnaceRecipes); // ^ 2 weeks

            GTValues.RA.stdBuilder().itemInputs(NHItemList.StargateCrystalDust.getIS().splitStack(64))
                    .fluidInputs(MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter.getMolten(128_000_000L))
                    .itemOutputs(GTModHandler.getModItem(SGCraft.ID, "sgControllerCrystal", 1L))
                    .duration(7 * 24 * HOURS * 2).eut(TierEU.RECIPE_MAX).metadata(COIL_HEAT, 100_000)
                    .addTo(blastFurnaceRecipes);

        }
    }
}
