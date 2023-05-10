package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sBlastRecipes;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;
import static gregtech.api.util.GT_RecipeConstants.COIL_HEAT;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class BlastFurnaceRecipes implements Runnable {

    @Override
    public void run() {

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.UncookedSlush.get(1L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.GlowingMarshmallow.get(1L)).fluidInputs(Materials.Radon.getGas(1000L))
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedstoneAlloy, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedstoneAlloy, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ConductiveIron, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(60 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ConductiveIron, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1500)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticAlloy, 1L))
                .fluidInputs(Materials.Hydrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticAlloy, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2500)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticSilver, 1L))
                .fluidInputs(Materials.Hydrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticSilver, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2500)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VibrantAlloy, 1L))
                .fluidInputs(Materials.Hydrogen.getGas(1000L)).noFluidOutputs().duration(2 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VibrantAlloy, 1L)).noFluidInputs()
                .noFluidOutputs().duration(5 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3600)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VividAlloy, 1L))
                .fluidInputs(Materials.Hydrogen.getGas(1000L)).noFluidOutputs().duration(2 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VividAlloy, 1L)).noFluidInputs()
                .noFluidOutputs().duration(5 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3600)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallineAlloy, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).noFluidOutputs().duration(60 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallineAlloy, 1L))
                .noFluidInputs().noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 5000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallinePinkSlime, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallinePinkSlime, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallinePinkSlime, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallinePinkSlime, 1L))
                .noFluidInputs().noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5600)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MelodicAlloy, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).noFluidOutputs().duration(2 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5400).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MelodicAlloy, 1L)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5800)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StellarAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.StellarAlloy, 1L))
                .fluidInputs(Materials.Argon.getGas(1000L)).noFluidOutputs().duration(3 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 7200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StellarAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.StellarAlloy, 1L)).noFluidInputs()
                .noFluidOutputs().duration(4 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 9000)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(60 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.PulsatingIron, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1800).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.PulsatingIron, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Soularium, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).noFluidOutputs().duration(50 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Soularium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DarkSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(50 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1800).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DarkSteel, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2200)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EndSteel, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).noFluidOutputs().duration(60 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EndSteel, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5000)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnderiumBase, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).noFluidOutputs().duration(2 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3300).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnderiumBase, 1L)).noFluidInputs()
                .noFluidOutputs().duration(5 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3600)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).noFluidOutputs().duration(2 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 4500).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(5 * MINUTES + 50 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 4500)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Reinforced, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Reinforced, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(60 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1700).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Reinforced, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Reinforced, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1700)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galgadorian, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Galgadorian, 1L))
                .fluidInputs(Materials.Hydrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2800).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galgadorian, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Galgadorian, 1L)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 3000)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnhancedGalgadorian, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnhancedGalgadorian, 1L))
                .fluidInputs(Materials.Hydrogen.getGas(1000L)).noFluidOutputs().duration(2 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 4200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Draconium, 1L))
                .fluidInputs(Materials.Argon.getGas(1000L)).noFluidOutputs().duration(3 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 7200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DraconiumAwakened, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DraconiumAwakened, 1L))
                .fluidInputs(Materials.Argon.getGas(1000L)).noFluidOutputs().duration(4 * MINUTES + 10 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 10 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1700).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 25 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1700)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ardite, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L))
                .fluidInputs(Materials.Hydrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ardite, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Manyullyn, 1L))
                .fluidInputs(Materials.Hydrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3300).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Manyullyn, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3600)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Desh, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Desh, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2500).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Desh, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Desh, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2500)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectrumFlux, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.ElectrumFlux, 1L))
                .fluidInputs(Materials.Argon.getGas(1000L)).noFluidOutputs().duration(50 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.FierySteel, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.FierySteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(50 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.FierySteel, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.FierySteel, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1900)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Sunnarium, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Sunnarium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 50 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4500)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSG, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSG, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSG, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSG, 1L)).noFluidInputs()
                .noFluidOutputs().duration(3 * MINUTES + 30 * SECONDS).eut(2920).metadata(COIL_HEAT, 4500)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSE, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSE, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).noFluidOutputs().duration(2 * MINUTES + 5 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSE, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSE, 1L)).noFluidInputs()
                .noFluidOutputs().duration(4 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5400)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSS, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSS, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).noFluidOutputs().duration(2 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSS, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSS, 1L)).noFluidInputs()
                .noFluidOutputs().duration(7 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5400)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadah, 1L))
                .fluidInputs(Materials.Argon.getGas(1000L)).noFluidOutputs().duration(25 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahAlloy, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahAlloy, 1L))
                .fluidInputs(Materials.Argon.getGas(1000L)).noFluidOutputs().duration(50 * SECONDS).eut(62880)
                .metadata(COIL_HEAT, 7200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahEnriched, 1L))
                .fluidInputs(Materials.Argon.getGas(1000L)).noFluidOutputs().duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5350).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadria, 1L))
                .fluidInputs(Materials.Argon.getGas(1000L)).noFluidOutputs().duration(25 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Trinium, 1L))
                .fluidInputs(Materials.Argon.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 7200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmium, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).noFluidOutputs().duration(50 * SECONDS)
                .eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 4500).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 4500)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Iridium, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 4500).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Iridium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 4500)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Oriharukon, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Oriharukon, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vyroxeres, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vyroxeres, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vyroxeres, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vyroxeres, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Orichalcum, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Orichalcum, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Orichalcum, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Orichalcum, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6000)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Alduorite, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Alduorite, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6600).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Alduorite, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Alduorite, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6600)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mithril, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Mithril, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 6600).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mithril, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Mithril, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 6600)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ceruclase, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Ceruclase, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 6600).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ceruclase, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Ceruclase, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 6600)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vulcanite, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vulcanite, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 8400).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vulcanite, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vulcanite, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 8400)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ShadowIron, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.ShadowIron, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 8400).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ShadowIron, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.ShadowIron, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 8400)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrysotile, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Chrysotile, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_UV).metadata(COIL_HEAT, 9400).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrysotile, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Chrysotile, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_UV).metadata(COIL_HEAT, 9400)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tartarite, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tartarite, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_UHV).metadata(COIL_HEAT, 10400).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tartarite, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tartarite, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_UHV).metadata(COIL_HEAT, 10400)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(5 * MINUTES)
                .eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L))
                .noFluidInputs().noFluidOutputs().duration(6 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .metadata(COIL_HEAT, 9000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumSteel, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.VanadiumSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(60 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1453).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumSteel, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.VanadiumSteel, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 12 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 1453).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DamascusSteel, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DamascusSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(60 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1500).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DamascusSteel, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DamascusSteel, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1500)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlackSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(50 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlackSteel, 1L)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedSteel, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(55 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1300).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedSteel, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedSteel, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 5 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1300)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlueSteel, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlueSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(60 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1400).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlueSteel, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlueSteel, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1400)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconSG, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.SiliconSG, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2273).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconSG, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.SiliconSG, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 50 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 2273)
                .addTo(sBlastRecipes);
        // 2Al(OH)3 = Al2O3 + 3H2O

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumhydroxide, 14L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1300)
                .addTo(sBlastRecipes);
        // 2NaAlO2 + CO2 = Al2O3 + Na2CO3

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 8L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumCarbonate, 6L))
                .fluidInputs(Materials.CarbonDioxide.getGas(1000L)).noFluidOutputs().duration(5 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1200).addTo(sBlastRecipes);
        // 2Al2O3 + 3C = 4Al + 3CO2

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 3L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 4L)).noFluidInputs()
                .fluidOutputs(Materials.CarbonDioxide.getGas(3000L)).duration(60 * SECONDS).eut(TierEU.RECIPE_MV)
                .metadata(COIL_HEAT, 2054).addTo(sBlastRecipes);
        // 6Al2O3 =Na3AlF6= 12Al

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 30L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cryolite, 15L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 12L)).noFluidInputs()
                .noFluidOutputs().duration(4 * MINUTES).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 963)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(60 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2054).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2054)
                .addTo(sBlastRecipes);
        // NEEDED TO MOVE FROM GREG, CODE WAS TOO LONG

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmiridium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmiridium, 1L))
                .fluidInputs(Materials.Helium.getGas(1000)).noFluidOutputs().duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 4500).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L),
                        Materials.Ash.getDustTiny(1))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(25 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L),
                        Materials.Ash.getDustTiny(1))
                .noFluidInputs().noFluidOutputs().duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 2000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.WroughtIron, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L),
                        Materials.Ash.getDustTiny(1))
                .noFluidInputs().noFluidOutputs().duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 2000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L),
                        Materials.Ash.getDustTiny(1))
                .noFluidInputs().noFluidOutputs().duration(12 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 2000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.WroughtIron, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L),
                        Materials.Ash.getDustTiny(1))
                .noFluidInputs().noFluidOutputs().duration(2 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 2000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PigIron, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L),
                        Materials.Ash.getDustTiny(1))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.WroughtIron, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L),
                        Materials.Ash.getDustTiny(1))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ShadowIron, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ShadowSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(25 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1100).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(25 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.GalliumArsenide, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Arsenic, 1L))
                .itemOutputs(ItemList.GalliumArsenideCrystal.get(1L)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1511).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 2L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(ItemList.GalliumArsenideCrystal.get(1L)).fluidInputs(Materials.Oxygen.getGas(1000L))
                .noFluidOutputs().duration(45 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1511)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Rutile, 3L))
                .noFluidInputs().fluidOutputs(Materials.CarbonMonoxide.getGas(1000L))
                .duration(2 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1700)
                .addTo(sBlastRecipes);
        // 2Mg + TiCl4 = Ti + 2MgCl2

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 2L),
                        GT_Utility.getIntegratedCircuit(12))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesiumchloride, 6L))
                .fluidInputs(Materials.Titaniumtetrachloride.getFluid(1000L)).noFluidOutputs().duration(40 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2140).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.AnnealedCopper, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(25 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 1940)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 1940).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tungsten, 1L)).noFluidInputs()
                .noFluidOutputs().duration(10 * MINUTES).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 3000)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tungsten, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(8 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 3000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalum, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tantalum, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3000)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalum, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tantalum, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(2 * MINUTES)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2400).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TPV, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TPV, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 3000)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TPV, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TPV, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(2 * MINUTES + 5 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 3000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenSteel, 1L))
                .noFluidInputs().noFluidOutputs().duration(2 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 4000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenSteel, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(2 * MINUTES + 5 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenCarbide, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenCarbide, 1L))
                .noFluidInputs().noFluidOutputs().duration(2 * MINUTES + 3 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 2460).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenCarbide, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenCarbide, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2460).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumGallium, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VanadiumGallium, 1L))
                .noFluidInputs().noFluidOutputs().duration(3 * MINUTES + 45 * SECONDS).eut(TierEU.RECIPE_HV)
                .metadata(COIL_HEAT, 4500).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumGallium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VanadiumGallium, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).noFluidOutputs().duration(3 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 4500).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NiobiumTitanium, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NiobiumTitanium, 1L))
                .noFluidInputs().noFluidOutputs().duration(3 * MINUTES + 45 * SECONDS).eut(TierEU.RECIPE_HV)
                .metadata(COIL_HEAT, 4500).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NiobiumTitanium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NiobiumTitanium, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).noFluidOutputs().duration(3 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 4500).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nichrome, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Nichrome, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2700)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nichrome, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Nichrome, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(60 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 2700).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 1L)).noFluidInputs()
                .noFluidOutputs().duration(1 * MINUTES + 25 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1700)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(60 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1700).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pentacadmiummagnesiumhexaoxid, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Pentacadmiummagnesiumhexaoxid, 1L))
                .noFluidInputs().noFluidOutputs().duration(2 * MINUTES).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2500)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pentacadmiummagnesiumhexaoxid, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Pentacadmiummagnesiumhexaoxid, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 2500).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(
                        GT_OreDictUnificator
                                .get(OrePrefixes.ingotHot, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L))
                .noFluidInputs().noFluidOutputs().duration(2 * MINUTES + 15 * SECONDS).eut(TierEU.RECIPE_HV)
                .metadata(COIL_HEAT, 3300).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(
                        GT_OreDictUnificator
                                .get(OrePrefixes.ingotHot, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L))
                .fluidInputs(Materials.Nitrogen.getGas(1000L)).noFluidOutputs().duration(1 * MINUTES + 55 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 3300).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraniumtriplatinid, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Uraniumtriplatinid, 1L))
                .noFluidInputs().noFluidOutputs().duration(2 * MINUTES + 45 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 4400).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraniumtriplatinid, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Uraniumtriplatinid, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).noFluidOutputs().duration(2 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 4400).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadiumtriindinid, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vanadiumtriindinid, 1L))
                .noFluidInputs().noFluidOutputs().duration(3 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_EV)
                .metadata(COIL_HEAT, 5200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadiumtriindinid, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vanadiumtriindinid, 1L))
                .fluidInputs(Materials.Helium.getGas(1000L)).noFluidOutputs().duration(2 * MINUTES + 50 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(COIL_HEAT, 5200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(
                                OrePrefixes.dust,
                                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(
                        GT_OreDictUnificator.get(
                                OrePrefixes.ingotHot,
                                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                1L))
                .noFluidInputs().noFluidOutputs().duration(4 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_IV)
                .metadata(COIL_HEAT, 6000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(
                                OrePrefixes.dust,
                                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(
                        GT_OreDictUnificator.get(
                                OrePrefixes.ingotHot,
                                Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                                1L))
                .fluidInputs(Materials.Argon.getGas(1000L)).noFluidOutputs().duration(3 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 6000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DeepIron, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DeepIron, 1L)).noFluidInputs()
                .noFluidOutputs().duration(5 * MINUTES).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 7500)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DeepIron, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DeepIron, 1L))
                .fluidInputs(Materials.Argon.getGas(1000L)).noFluidOutputs().duration(4 * MINUTES + 10 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 7500).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator
                                .get(OrePrefixes.dust, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(
                        GT_OreDictUnificator
                                .get(OrePrefixes.ingotHot, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L))
                .noFluidInputs().noFluidOutputs().duration(5 * MINUTES).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 9000)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator
                                .get(OrePrefixes.dust, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(
                        GT_OreDictUnificator
                                .get(OrePrefixes.ingotHot, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L))
                .fluidInputs(Materials.Argon.getGas(1000L)).noFluidOutputs().duration(4 * MINUTES + 10 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 9000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuvwire, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(
                        GT_OreDictUnificator
                                .get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuvwire, 1L))
                .noFluidInputs().noFluidOutputs().duration(5 * MINUTES + 50 * SECONDS).eut(TierEU.RECIPE_LuV)
                .metadata(COIL_HEAT, 9900).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuvwire, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(
                        GT_OreDictUnificator
                                .get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuvwire, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).noFluidOutputs().duration(5 * MINUTES)
                .eut(TierEU.RECIPE_LuV).metadata(COIL_HEAT, 9900).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuhvwire, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(
                        GT_OreDictUnificator
                                .get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuhvwire, 1L))
                .noFluidInputs().noFluidOutputs().duration(7 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .metadata(COIL_HEAT, 10800).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuhvwire, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(
                        GT_OreDictUnificator
                                .get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuhvwire, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).noFluidOutputs().duration(6 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 10500).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tritanium, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tritanium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(5 * MINUTES).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tritanium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tritanium, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).noFluidOutputs().duration(4 * MINUTES + 10 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Quantium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(2 * MINUTES + 55 * SECONDS).eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Quantium, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).noFluidOutputs().duration(2 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(COIL_HEAT, 5400).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Bedrockium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(7 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Bedrockium, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).noFluidOutputs().duration(6 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MysteriousCrystal, 1L))
                .noFluidInputs().noFluidOutputs().duration(5 * MINUTES).eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 7200)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MysteriousCrystal, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).noFluidOutputs().duration(3 * MINUTES + 45 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 7200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CosmicNeutronium, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CosmicNeutronium, 1L))
                .noFluidInputs().noFluidOutputs().duration(10 * MINUTES).eut(TierEU.RECIPE_ZPM)
                .metadata(COIL_HEAT, 9900).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CosmicNeutronium, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CosmicNeutronium, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).noFluidOutputs().duration(8 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_ZPM).metadata(COIL_HEAT, 9900).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.InfinityCatalyst, 1L))
                .noFluidInputs().noFluidOutputs().duration(12 * MINUTES + 30 * SECONDS).eut(500000)
                .metadata(COIL_HEAT, 10800).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.InfinityCatalyst, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).noFluidOutputs().duration(10 * MINUTES).eut(500000)
                .metadata(COIL_HEAT, 10800).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infinity, 1L)).noFluidInputs()
                .noFluidOutputs().duration(25 * MINUTES).eut(2000000).metadata(COIL_HEAT, 10800).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infinity, 1L))
                .fluidInputs(Materials.Radon.getGas(1000L)).noFluidOutputs().duration(20 * MINUTES + 50 * SECONDS)
                .eut(2000000).metadata(COIL_HEAT, 10800).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Kanthal, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Kanthal, 1L)).noFluidInputs()
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1800)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Kanthal, 1L),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Kanthal, 1L))
                .fluidInputs(Materials.Oxygen.getGas(1000L)).noFluidOutputs().duration(45 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 1800).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.FerriteMixture, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NickelZincFerrite, 1L))
                .fluidInputs(Materials.Oxygen.getGas(2000)).noFluidOutputs().duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, (int) Materials.NickelZincFerrite.mBlastFurnaceTemp)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BrickNether, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.HotNetherrackBrick.get(1L)).fluidInputs(Materials.Oxygen.getGas(1000L))
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.InfernalBrick.get(1L), CustomItemList.CokeOvenBrick.get(1L))
                .itemOutputs(CustomItemList.AdvancedCokeOvenBrick.get(2L)).fluidInputs(Materials.Oxygen.getGas(1000L))
                .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.RawNeutronium.get(1L), GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Neutronium, 1L))
                .fluidInputs(Materials.Argon.getGas(1000L)).noFluidOutputs().duration(8 * MINUTES + 20 * SECONDS)
                .eut(500000).metadata(COIL_HEAT, 9000).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder().itemInputs(Materials.Sapphire.getDust(3), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(Materials.Aluminiumoxide.getDust(1)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder().itemInputs(Materials.GreenSapphire.getDust(3), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(Materials.Aluminiumoxide.getDust(1)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder().itemInputs(Materials.Ruby.getDust(3), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(Materials.Aluminiumoxide.getDust(1)).noFluidInputs().noFluidOutputs()
                .duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200).addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.Sapphire.getDust(1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L))
                .itemOutputs(Materials.Aluminiumoxide.getDust(1), Materials.DarkAsh.getDustTiny(1)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        Materials.GreenSapphire.getDust(1),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L))
                .itemOutputs(Materials.Aluminiumoxide.getDust(1), Materials.DarkAsh.getDustTiny(1)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(sBlastRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(Materials.Ruby.getDust(1), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L))
                .itemOutputs(Materials.Aluminiumoxide.getDust(1), Materials.DarkAsh.getDustTiny(1)).noFluidInputs()
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1200)
                .addTo(sBlastRecipes);

        if (TinkerConstruct.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 12),
                            GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(Materials.Aluminium.getIngots(1)).noFluidInputs().noFluidOutputs()
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1600)
                    .addTo(sBlastRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 12),
                            GT_Utility.getIntegratedCircuit(11))
                    .itemOutputs(Materials.Aluminium.getIngots(1)).fluidInputs(Materials.Nitrogen.getGas(1000))
                    .noFluidOutputs().duration(60 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1300)
                    .addTo(sBlastRecipes);

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.glass, 1, 0), GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "GlassBlock", 1L, 0)).noFluidInputs()
                    .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000)
                    .addTo(sBlastRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(new ItemStack(Blocks.glass_pane, 1, 0), GT_Utility.getIntegratedCircuit(1))
                    .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "GlassPane", 1L, 0)).noFluidInputs()
                    .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000)
                    .addTo(sBlastRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 1))
                    .itemOutputs(ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L))
                    .fluidInputs(Materials.Helium.getGas(1000)).noFluidOutputs().duration(45 * SECONDS)
                    .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 5000).addTo(sBlastRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Olivine, 1))
                    .itemOutputs(ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L))
                    .fluidInputs(Materials.Helium.getGas(1000)).noFluidOutputs().duration(45 * SECONDS)
                    .eut(TierEU.RECIPE_HV).metadata(COIL_HEAT, 5000).addTo(sBlastRecipes);

        }

        if (EnderIO.isModLoaded()) {

            GT_Values.RA.stdBuilder().itemInputs(Materials.CertusQuartz.getDust(2), Materials.Glass.getDust(1))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).noFluidInputs()
                    .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000)
                    .addTo(sBlastRecipes);

            GT_Values.RA.stdBuilder().itemInputs(Materials.NetherQuartz.getDust(2), Materials.Glass.getDust(1))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).noFluidInputs()
                    .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000)
                    .addTo(sBlastRecipes);

            GT_Values.RA.stdBuilder().itemInputs(Materials.CertusQuartz.getDust(2), Materials.Quartzite.getDust(2))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).noFluidInputs()
                    .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000)
                    .addTo(sBlastRecipes);

            GT_Values.RA.stdBuilder().itemInputs(Materials.NetherQuartz.getDust(2), Materials.Quartzite.getDust(2))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).noFluidInputs()
                    .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000)
                    .addTo(sBlastRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(Materials.CertusQuartz.getDust(1), Materials.BorosilicateGlass.getDust(1))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).noFluidInputs()
                    .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000)
                    .addTo(sBlastRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(Materials.NetherQuartz.getDust(1), Materials.BorosilicateGlass.getDust(1))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L)).noFluidInputs()
                    .noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_MV).metadata(COIL_HEAT, 1000)
                    .addTo(sBlastRecipes);

        }
    }
}
