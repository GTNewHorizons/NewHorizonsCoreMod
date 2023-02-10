package com.dreammaster.gthandler.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.CustomItemList;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class BlastFurnaceRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addBlastRecipe(
                CustomItemList.UncookedSlush.get(1L),
                GT_Utility.getIntegratedCircuit(1),
                Materials.Radon.getGas(1000L),
                GT_Values.NF,
                CustomItemList.GlowingMarshmallow.get(1L),
                GT_Values.NI,
                2400,
                1920,
                4500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedstoneAlloy, 1L),
                GT_Values.NI,
                800,
                120,
                1000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedstoneAlloy, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedstoneAlloy, 1L),
                GT_Values.NI,
                1600,
                120,
                1200);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ConductiveIron, 1L),
                GT_Values.NI,
                1200,
                120,
                1200);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ConductiveIron, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ConductiveIron, 1L),
                GT_Values.NI,
                2400,
                120,
                1500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Hydrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticAlloy, 1L),
                GT_Values.NI,
                1600,
                120,
                2200);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticAlloy, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticAlloy, 1L),
                GT_Values.NI,
                3200,
                120,
                2500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Hydrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticSilver, 1L),
                GT_Values.NI,
                1600,
                120,
                2200);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnergeticSilver, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnergeticSilver, 1L),
                GT_Values.NI,
                3200,
                120,
                2500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Hydrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VibrantAlloy, 1L),
                GT_Values.NI,
                3000,
                120,
                3000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VibrantAlloy, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VibrantAlloy, 1L),
                GT_Values.NI,
                6000,
                120,
                3600);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Hydrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VividAlloy, 1L),
                GT_Values.NI,
                3000,
                120,
                3000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VividAlloy, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VividAlloy, 1L),
                GT_Values.NI,
                6000,
                120,
                3600);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallineAlloy, 1L),
                GT_Values.NI,
                1200,
                1920,
                4500);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallineAlloy, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallineAlloy, 1L),
                GT_Values.NI,
                1800,
                1920,
                5000);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallinePinkSlime, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallinePinkSlime, 1L),
                GT_Values.NI,
                1800,
                1920,
                5000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CrystallinePinkSlime, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CrystallinePinkSlime, 1L),
                GT_Values.NI,
                2400,
                1920,
                5600);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MelodicAlloy, 1L),
                GT_Values.NI,
                3000,
                1920,
                5400);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MelodicAlloy, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MelodicAlloy, 1L),
                GT_Values.NI,
                4000,
                1920,
                5800);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StellarAlloy, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Argon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.StellarAlloy, 1L),
                GT_Values.NI,
                4000,
                30720,
                7200);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StellarAlloy, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.StellarAlloy, 1L),
                GT_Values.NI,
                5000,
                30720,
                9000);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 1L),
                GT_Values.NI,
                1200,
                120,
                1000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectricalSteel, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ElectricalSteel, 1L),
                GT_Values.NI,
                2400,
                120,
                1200);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.PulsatingIron, 1L),
                GT_Values.NI,
                1600,
                120,
                1800);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PulsatingIron, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.PulsatingIron, 1L),
                GT_Values.NI,
                3200,
                120,
                2200);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Soularium, 1L),
                GT_Values.NI,
                1000,
                120,
                1000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Soularium, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Soularium, 1L),
                GT_Values.NI,
                2000,
                120,
                1200);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DarkSteel, 1L),
                GT_Values.NI,
                1000,
                120,
                1800);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkSteel, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DarkSteel, 1L),
                GT_Values.NI,
                2000,
                120,
                2200);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EndSteel, 1L),
                GT_Values.NI,
                1200,
                1920,
                4500);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EndSteel, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EndSteel, 1L),
                GT_Values.NI,
                1800,
                1920,
                5000);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnderiumBase, 1L),
                GT_Values.NI,
                3000,
                120,
                3300);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderiumBase, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnderiumBase, 1L),
                GT_Values.NI,
                6000,
                120,
                3600);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L),
                GT_Values.NI,
                3500,
                120,
                4500);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Enderium, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Enderium, 1L),
                GT_Values.NI,
                7000,
                120,
                4500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Reinforced, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Reinforced, 1L),
                GT_Values.NI,
                1200,
                120,
                1700);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Reinforced, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Reinforced, 1L),
                GT_Values.NI,
                1400,
                120,
                1700);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galgadorian, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Hydrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Galgadorian, 1L),
                GT_Values.NI,
                2000,
                120,
                2800);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galgadorian, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Galgadorian, 1L),
                GT_Values.NI,
                4000,
                120,
                3000);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnhancedGalgadorian, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Hydrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnhancedGalgadorian, 1L),
                GT_Values.NI,
                3000,
                480,
                4200);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Argon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Draconium, 1L),
                GT_Values.NI,
                4000,
                30720,
                7200);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DraconiumAwakened, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Argon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DraconiumAwakened, 1L),
                GT_Values.NI,
                5000,
                122880,
                9900);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L),
                GT_Values.NI,
                1400,
                120,
                1700);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L),
                GT_Values.NI,
                1700,
                120,
                1700);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ardite, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Hydrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                GT_Values.NI,
                1800,
                120,
                1600);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ardite, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                GT_Values.NI,
                2400,
                120,
                1600);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Hydrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Manyullyn, 1L),
                GT_Values.NI,
                1500,
                480,
                3300);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Manyullyn, 1L),
                GT_Values.NI,
                2400,
                480,
                3600);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Desh, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Desh, 1L),
                GT_Values.NI,
                2000,
                480,
                2500);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Desh, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Desh, 1L),
                GT_Values.NI,
                2800,
                480,
                2500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ElectrumFlux, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Argon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.ElectrumFlux, 1L),
                GT_Values.NI,
                1000,
                122880,
                9000);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.FierySteel, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.FierySteel, 1L),
                GT_Values.NI,
                1000,
                120,
                1600);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.FierySteel, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.FierySteel, 1L),
                GT_Values.NI,
                2000,
                120,
                1900);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Sunnarium, 1L),
                GT_Values.NI,
                1800,
                1920,
                4500);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Sunnarium, 1L),
                GT_Values.NI,
                2200,
                1920,
                4500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSG, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSG, 1L),
                GT_Values.NI,
                1800,
                1920,
                4200);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSG, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSG, 1L),
                GT_Values.NI,
                4200,
                2920,
                4500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSE, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSE, 1L),
                GT_Values.NI,
                2500,
                1920,
                5000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSE, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSE, 1L),
                GT_Values.NI,
                5000,
                1920,
                5400);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSS, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSS, 1L),
                GT_Values.NI,
                3000,
                1920,
                5000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HSSS, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.HSSS, 1L),
                GT_Values.NI,
                9000,
                1920,
                5400);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Argon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadah, 1L),
                GT_Values.NI,
                500,
                7680,
                5000);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahAlloy, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Argon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahAlloy, 1L),
                GT_Values.NI,
                1000,
                62880,
                7200);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Argon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NaquadahEnriched, 1L),
                GT_Values.NI,
                1000,
                7680,
                5350);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadria, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Argon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Naquadria, 1L),
                GT_Values.NI,
                500,
                122880,
                9000);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Trinium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Argon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Trinium, 1L),
                GT_Values.NI,
                1500,
                30720,
                7200);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmium, 1L),
                GT_Values.NI,
                1000,
                30720,
                4500);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmium, 1L),
                GT_Values.NI,
                3000,
                30720,
                4500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Iridium, 1L),
                GT_Values.NI,
                1000,
                7680,
                4500);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Iridium, 1L),
                GT_Values.NI,
                2500,
                7680,
                4500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Oriharukon, 1L),
                GT_Values.NI,
                2300,
                7680,
                5400);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Oriharukon, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Oriharukon, 1L),
                GT_Values.NI,
                2700,
                7680,
                5400);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vyroxeres, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vyroxeres, 1L),
                GT_Values.NI,
                2300,
                7680,
                5400);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vyroxeres, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vyroxeres, 1L),
                GT_Values.NI,
                2700,
                7680,
                5400);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Orichalcum, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Orichalcum, 1L),
                GT_Values.NI,
                2300,
                7680,
                6000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Orichalcum, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Orichalcum, 1L),
                GT_Values.NI,
                2700,
                7680,
                6000);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Alduorite, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Alduorite, 1L),
                GT_Values.NI,
                2300,
                7680,
                6600);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Alduorite, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Alduorite, 1L),
                GT_Values.NI,
                2700,
                7680,
                6600);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mithril, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Mithril, 1L),
                GT_Values.NI,
                2300,
                30720,
                6600);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mithril, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Mithril, 1L),
                GT_Values.NI,
                2700,
                30720,
                6600);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ceruclase, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Ceruclase, 1L),
                GT_Values.NI,
                2300,
                30720,
                6600);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ceruclase, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Ceruclase, 1L),
                GT_Values.NI,
                2700,
                30720,
                6600);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vulcanite, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vulcanite, 1L),
                GT_Values.NI,
                2300,
                122880,
                8400);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vulcanite, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vulcanite, 1L),
                GT_Values.NI,
                2700,
                122880,
                8400);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ShadowIron, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.ShadowIron, 1L),
                GT_Values.NI,
                2300,
                122880,
                8400);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ShadowIron, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.ShadowIron, 1L),
                GT_Values.NI,
                2700,
                122880,
                8400);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrysotile, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Chrysotile, 1L),
                GT_Values.NI,
                2300,
                491520,
                9400);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrysotile, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Chrysotile, 1L),
                GT_Values.NI,
                2700,
                491520,
                9400);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tartarite, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tartarite, 1L),
                GT_Values.NI,
                2300,
                1966080,
                10400);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tartarite, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tartarite, 1L),
                GT_Values.NI,
                2700,
                1966080,
                10400);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L),
                GT_Values.NI,
                6000,
                122880,
                9000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.BlackPlutonium, 1L),
                GT_Values.NI,
                7500,
                122880,
                9000);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumSteel, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.VanadiumSteel, 1L),
                GT_Values.NI,
                1200,
                120,
                1453);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumSteel, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.VanadiumSteel, 1L),
                GT_Values.NI,
                1453,
                120,
                1453);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DamascusSteel, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DamascusSteel, 1L),
                GT_Values.NI,
                1200,
                120,
                1500);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DamascusSteel, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.DamascusSteel, 1L),
                GT_Values.NI,
                1500,
                120,
                1500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlackSteel, 1L),
                GT_Values.NI,
                1000,
                120,
                1200);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackSteel, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlackSteel, 1L),
                GT_Values.NI,
                1200,
                120,
                1200);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedSteel, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedSteel, 1L),
                GT_Values.NI,
                1100,
                120,
                1300);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RedSteel, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.RedSteel, 1L),
                GT_Values.NI,
                1300,
                120,
                1300);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlueSteel, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlueSteel, 1L),
                GT_Values.NI,
                1200,
                120,
                1400);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlueSteel, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BlueSteel, 1L),
                GT_Values.NI,
                1400,
                120,
                1400);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconSG, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.SiliconSG, 1L),
                GT_Values.NI,
                1600,
                120,
                2273);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconSG, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.SiliconSG, 1L),
                GT_Values.NI,
                2200,
                120,
                2273);

        // 2Al(OH)3 = Al2O3 + 3H2O
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumhydroxide, 14L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_Values.NI,
                200,
                480,
                1300);
        // 2NaAlO2 + CO2 = Al2O3 + Na2CO3
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumAluminate, 8L),
                GT_Values.NI,
                Materials.CarbonDioxide.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SodiumCarbonate, 6L),
                100,
                480,
                1200);

        // 2Al2O3 + 3C = 4Al + 3CO2
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 3L),
                GT_Values.NF,
                Materials.CarbonDioxide.getGas(3000L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 4L),
                GT_Values.NI,
                1200,
                120,
                2054);
        // 6Al2O3 =Na3AlF6= 12Al
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 30L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cryolite, 15L),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 12L),
                GT_Values.NI,
                4800,
                120,
                963);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1L),
                GT_Values.NI,
                1200,
                480,
                2054);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Aluminium, 1L),
                GT_Values.NI,
                1600,
                480,
                2054);

        // NEEDED TO MOVE FROM GREG, CODE WAS TOO LONG
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmiridium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Osmiridium, 1L),
                GT_Values.NI,
                1500,
                30720,
                4500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L),
                Materials.Ash.getDustTiny(1),
                500,
                120,
                1000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L),
                Materials.Ash.getDustTiny(1),
                250,
                1920,
                2000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.WroughtIron, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L),
                Materials.Ash.getDustTiny(1),
                50,
                1920,
                2000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L),
                Materials.Ash.getDustTiny(1),
                250,
                1920,
                2000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.WroughtIron, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 4L),
                Materials.Ash.getDustTiny(1),
                50,
                1920,
                2000);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PigIron, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L),
                Materials.Ash.getDustTiny(1),
                100,
                120,
                1000);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.WroughtIron, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L),
                Materials.Ash.getDustTiny(1),
                100,
                120,
                1000);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.ShadowIron, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.ShadowSteel, 1L),
                GT_Values.NI,
                500,
                120,
                1100);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.MeteoricSteel, 1L),
                GT_Values.NI,
                500,
                120,
                1200);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.GalliumArsenide, 1L),
                GT_Values.NI,
                600,
                120,
                1200);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Arsenic, 1L),
                GT_Values.NF,
                GT_Values.NF,
                ItemList.GalliumArsenideCrystal.get(1L),
                GT_Values.NI,
                1200,
                120,
                1511);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 2L),
                GT_Utility.getIntegratedCircuit(2),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                ItemList.GalliumArsenideCrystal.get(1L),
                GT_Values.NI,
                900,
                120,
                1511);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 9L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 9L),
                GT_Values.NF,
                Materials.CarbonMonoxide.getGas(9000L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Rutile, 4L),
                3200,
                480,
                1700);

        // 2Mg + TiCl4 = Ti + 2MgCl2
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 2L),
                GT_Utility.getIntegratedCircuit(12),
                Materials.Titaniumtetrachloride.getFluid(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesiumchloride, 6L),
                800,
                480,
                2140);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.AnnealedCopper, 1L),
                GT_Values.NI,
                500,
                120,
                1200);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L),
                GT_Values.NI,
                2400,
                1920,
                1940);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titanium, 1L),
                GT_Values.NI,
                1800,
                1920,
                1940);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tungsten, 1L),
                GT_Values.NI,
                12000,
                1920,
                3000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tungsten, 1L),
                GT_Values.NI,
                10000,
                1920,
                3000);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalum, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tantalum, 1L),
                GT_Values.NI,
                3000,
                480,
                3000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalum, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tantalum, 1L),
                GT_Values.NI,
                2400,
                480,
                2400);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TPV, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TPV, 1L),
                GT_Values.NI,
                3000,
                1920,
                3000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TPV, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TPV, 1L),
                GT_Values.NI,
                2500,
                1920,
                3000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenSteel, 1L),
                GT_Values.NI,
                3000,
                1920,
                3000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenSteel, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenSteel, 1L),
                GT_Values.NI,
                2500,
                1920,
                3000);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenCarbide, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenCarbide, 1L),
                GT_Values.NI,
                2460,
                1920,
                2460);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.TungstenCarbide, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.TungstenCarbide, 1L),
                GT_Values.NI,
                2000,
                1920,
                2460);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumGallium, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VanadiumGallium, 1L),
                GT_Values.NI,
                4500,
                480,
                4500);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.VanadiumGallium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.VanadiumGallium, 1L),
                GT_Values.NI,
                4000,
                480,
                4500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NiobiumTitanium, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NiobiumTitanium, 1L),
                GT_Values.NI,
                4500,
                480,
                4500);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NiobiumTitanium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.NiobiumTitanium, 1L),
                GT_Values.NI,
                4000,
                480,
                4500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nichrome, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Nichrome, 1L),
                GT_Values.NI,
                1800,
                1920,
                2700);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nichrome, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Nichrome, 1L),
                GT_Values.NI,
                1200,
                1920,
                2700);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 1L),
                GT_Values.NI,
                1700,
                480,
                1700);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.StainlessSteel, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.StainlessSteel, 1L),
                GT_Values.NI,
                1200,
                480,
                1700);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pentacadmiummagnesiumhexaoxid, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Pentacadmiummagnesiumhexaoxid, 1L),
                GT_Values.NI,
                2400,
                480,
                2500);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pentacadmiummagnesiumhexaoxid, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Pentacadmiummagnesiumhexaoxid, 1L),
                GT_Values.NI,
                2000,
                480,
                2500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L),
                GT_Values.NI,
                2700,
                480,
                3300);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Nitrogen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Titaniumonabariumdecacoppereikosaoxid, 1L),
                GT_Values.NI,
                2300,
                480,
                3300);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraniumtriplatinid, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Uraniumtriplatinid, 1L),
                GT_Values.NI,
                3300,
                1920,
                4400);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraniumtriplatinid, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Uraniumtriplatinid, 1L),
                GT_Values.NI,
                2800,
                1920,
                4400);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadiumtriindinid, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vanadiumtriindinid, 1L),
                GT_Values.NI,
                3800,
                1920,
                5200);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vanadiumtriindinid, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Helium.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Vanadiumtriindinid, 1L),
                GT_Values.NI,
                3400,
                1920,
                5200);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(
                        OrePrefixes.dust,
                        Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                        1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(
                        OrePrefixes.ingotHot,
                        Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                        1L),
                GT_Values.NI,
                5000,
                7680,
                6000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(
                        OrePrefixes.dust,
                        Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                        1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Argon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(
                        OrePrefixes.ingotHot,
                        Materials.Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid,
                        1L),
                GT_Values.NI,
                4400,
                7680,
                6000);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DeepIron, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DeepIron, 1L),
                GT_Values.NI,
                6000,
                7680,
                7500);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DeepIron, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Argon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.DeepIron, 1L),
                GT_Values.NI,
                5000,
                7680,
                7500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_Values.NI,
                6000,
                7680,
                9000);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Argon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tetranaquadahdiindiumhexaplatiumosminid, 1L),
                GT_Values.NI,
                5000,
                7680,
                9000);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuvwire, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuvwire, 1L),
                GT_Values.NI,
                7000,
                30720,
                9900);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuvwire, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Radon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuvwire, 1L),
                GT_Values.NI,
                6000,
                30720,
                9900);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuhvwire, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuhvwire, 1L),
                GT_Values.NI,
                9000,
                122880,
                10800);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Longasssuperconductornameforuhvwire, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Radon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Longasssuperconductornameforuhvwire, 1L),
                GT_Values.NI,
                7500,
                122880,
                10500);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tritanium, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tritanium, 1L),
                GT_Values.NI,
                6000,
                122880,
                9900);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tritanium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Radon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tritanium, 1L),
                GT_Values.NI,
                5000,
                122880,
                9900);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Quantium, 1L),
                GT_Values.NI,
                3500,
                7680,
                5400);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Radon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Quantium, 1L),
                GT_Values.NI,
                3000,
                7680,
                5400);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Bedrockium, 1L),
                GT_Values.NI,
                9000,
                122880,
                9900);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Radon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Bedrockium, 1L),
                GT_Values.NI,
                8000,
                122880,
                9900);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MysteriousCrystal, 1L),
                GT_Values.NI,
                6000,
                122880,
                7200);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Radon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.MysteriousCrystal, 1L),
                GT_Values.NI,
                4500,
                122880,
                7200);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CosmicNeutronium, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CosmicNeutronium, 1L),
                GT_Values.NI,
                12000,
                122880,
                9900);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CosmicNeutronium, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Radon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.CosmicNeutronium, 1L),
                GT_Values.NI,
                10000,
                122880,
                9900);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.InfinityCatalyst, 1L),
                GT_Values.NI,
                15000,
                500000,
                10800);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfinityCatalyst, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Radon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.InfinityCatalyst, 1L),
                GT_Values.NI,
                12000,
                500000,
                10800);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infinity, 1L),
                GT_Values.NI,
                30000,
                2000000,
                10800);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Infinity, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Radon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Infinity, 1L),
                GT_Values.NI,
                25000,
                2000000,
                10800);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Kanthal, 1L),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Kanthal, 1L),
                GT_Values.NI,
                1200,
                480,
                1800);
        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Kanthal, 1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Kanthal, 1L),
                GT_Values.NI,
                900,
                480,
                1800);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.FerriteMixture, 1L),
                GT_Values.NI,
                Materials.Oxygen.getGas(2000),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.NickelZincFerrite, 1L),
                GT_Values.NI,
                600,
                120,
                Materials.NickelZincFerrite.mBlastFurnaceTemp);

        GT_Values.RA.addBlastRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.BrickNether, 1L),
                GT_Utility.getIntegratedCircuit(1),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                CustomItemList.HotNetherrackBrick.get(1L),
                GT_Values.NI,
                600,
                120,
                1200);
        GT_Values.RA.addBlastRecipe(
                CustomItemList.InfernalBrick.get(1L),
                CustomItemList.CokeOvenBrick.get(1L),
                Materials.Oxygen.getGas(1000L),
                GT_Values.NF,
                CustomItemList.AdvancedCokeOvenBrick.get(2L),
                GT_Values.NI,
                1200,
                120,
                1600);

        GT_Values.RA.addBlastRecipe(
                CustomItemList.RawNeutronium.get(1L),
                GT_Utility.getIntegratedCircuit(11),
                Materials.Argon.getGas(1000L),
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Neutronium, 1L),
                GT_Values.NI,
                10000,
                500000,
                9000);

        GT_Values.RA.addBlastRecipe(
                Materials.Sapphire.getDust(3),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                Materials.Aluminiumoxide.getDust(1),
                GT_Values.NI,
                1200,
                120,
                1200);
        GT_Values.RA.addBlastRecipe(
                Materials.GreenSapphire.getDust(3),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                Materials.Aluminiumoxide.getDust(1),
                GT_Values.NI,
                1200,
                120,
                1200);
        GT_Values.RA.addBlastRecipe(
                Materials.Ruby.getDust(3),
                GT_Utility.getIntegratedCircuit(1),
                GT_Values.NF,
                GT_Values.NF,
                Materials.Aluminiumoxide.getDust(1),
                GT_Values.NI,
                1200,
                120,
                1200);
        GT_Values.RA.addBlastRecipe(
                Materials.Sapphire.getDust(1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L),
                GT_Values.NF,
                GT_Values.NF,
                Materials.Aluminiumoxide.getDust(1),
                Materials.DarkAsh.getDustTiny(1),
                600,
                120,
                1200);
        GT_Values.RA.addBlastRecipe(
                Materials.GreenSapphire.getDust(1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L),
                GT_Values.NF,
                GT_Values.NF,
                Materials.Aluminiumoxide.getDust(1),
                Materials.DarkAsh.getDustTiny(1),
                600,
                120,
                1200);
        GT_Values.RA.addBlastRecipe(
                Materials.Ruby.getDust(1),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L),
                GT_Values.NF,
                GT_Values.NF,
                Materials.Aluminiumoxide.getDust(1),
                Materials.DarkAsh.getDustTiny(1),
                600,
                120,
                1200);

        if (Loader.isModLoaded("TConstruct")) {

            GT_Values.RA.addBlastRecipe(
                    GT_ModHandler.getModItem("TConstruct", "materials", 1L, 12),
                    GT_Utility.getIntegratedCircuit(1),
                    GT_Values.NF,
                    GT_Values.NF,
                    Materials.Aluminium.getIngots(1),
                    GT_Values.NI,
                    1600,
                    120,
                    1600);
            GT_Values.RA.addBlastRecipe(
                    GT_ModHandler.getModItem("TConstruct", "materials", 1L, 12),
                    GT_Utility.getIntegratedCircuit(11),
                    Materials.Nitrogen.getGas(1000),
                    GT_Values.NF,
                    Materials.Aluminium.getIngots(1),
                    GT_Values.NI,
                    1200,
                    120,
                    1300);

            GT_Values.RA.addBlastRecipe(
                    new ItemStack(Blocks.glass, 1, 0),
                    GT_Utility.getIntegratedCircuit(1),
                    GT_Values.NF,
                    GT_Values.NF,
                    GT_ModHandler.getModItem("TConstruct", "GlassBlock", 1L, 0),
                    GT_Values.NI,
                    100,
                    120,
                    1000);
            GT_Values.RA.addBlastRecipe(
                    new ItemStack(Blocks.glass_pane, 1, 0),
                    GT_Utility.getIntegratedCircuit(1),
                    GT_Values.NF,
                    GT_Values.NF,
                    GT_ModHandler.getModItem("TConstruct", "GlassPane", 1L, 0),
                    GT_Values.NI,
                    100,
                    120,
                    1000);

            GT_Values.RA.addBlastRecipe(
                    ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 1),
                    Materials.Helium.getGas(1000),
                    GT_Values.NF,
                    ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L),
                    GT_Values.NI,
                    900,
                    480,
                    5000);
            GT_Values.RA.addBlastRecipe(
                    ItemList.Circuit_Parts_RawCrystalChip.get(1L),
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Olivine, 1),
                    Materials.Helium.getGas(1000),
                    GT_Values.NF,
                    ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L),
                    GT_Values.NI,
                    900,
                    480,
                    5000);
        }

        if (Loader.isModLoaded("EnderIO")) {
            GT_Values.RA.addBlastRecipe(
                    Materials.CertusQuartz.getDust(2),
                    Materials.Glass.getDust(1),
                    GT_Values.NF,
                    GT_Values.NF,
                    GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L),
                    GT_Values.NI,
                    100,
                    120,
                    1000);
            GT_Values.RA.addBlastRecipe(
                    Materials.NetherQuartz.getDust(2),
                    Materials.Glass.getDust(1),
                    GT_Values.NF,
                    GT_Values.NF,
                    GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L),
                    GT_Values.NI,
                    100,
                    120,
                    1000);
            GT_Values.RA.addBlastRecipe(
                    Materials.CertusQuartz.getDust(2),
                    Materials.Quartzite.getDust(2),
                    GT_Values.NF,
                    GT_Values.NF,
                    GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L),
                    GT_Values.NI,
                    100,
                    120,
                    1000);
            GT_Values.RA.addBlastRecipe(
                    Materials.NetherQuartz.getDust(2),
                    Materials.Quartzite.getDust(2),
                    GT_Values.NF,
                    GT_Values.NF,
                    GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L),
                    GT_Values.NI,
                    100,
                    120,
                    1000);
            GT_Values.RA.addBlastRecipe(
                    Materials.CertusQuartz.getDust(1),
                    Materials.BorosilicateGlass.getDust(1),
                    GT_Values.NF,
                    GT_Values.NF,
                    GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L),
                    GT_Values.NI,
                    200,
                    120,
                    1000);
            GT_Values.RA.addBlastRecipe(
                    Materials.NetherQuartz.getDust(1),
                    Materials.BorosilicateGlass.getDust(1),
                    GT_Values.NF,
                    GT_Values.NF,
                    GT_ModHandler.getModItem("EnderIO", "blockFusedQuartz", 1L),
                    GT_Values.NI,
                    200,
                    120,
                    1000);
        }
    }
}
