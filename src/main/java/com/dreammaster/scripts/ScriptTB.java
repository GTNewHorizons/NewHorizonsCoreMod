package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBoots;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ScriptTB implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "TB";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Thaumcraft.ID, ThaumicBoots.ID, IndustrialCraft2.ID);
    }

    @Override
    public void loadRecipes() {

        // VoidWalker boots

        // Electric -> Nano
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB_EMT_Tainted_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemNanoVoid", 1, 27, missing),
                6,
                new AspectList().add(Aspect.getAspect("motus"), 48).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("volatus"), 8).add(Aspect.getAspect("iter"), 16),
                getModItem(ThaumicBoots.ID, "item.ItemElectricVoid", 1, wildcard, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        ItemList.Electric_Motor_HV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 1L),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 1L),
                        ItemList.Electric_Motor_HV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L), });

        // Nano -> Quantum
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB_EMT_Tainted_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemQuantumVoid", 1, 27, missing),
                9,
                new AspectList().add(Aspect.getAspect("motus"), 64).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("tutamen"), 48).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("volatus"), 16).add(Aspect.getAspect("iter"), 24)
                        .add(Aspect.getAspect("aer"), 8),
                getModItem(ThaumicBoots.ID, "item.ItemNanoVoid", 1, wildcard, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemArmorQuantumBoots", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        ItemList.Electric_Motor_EV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Titanium, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Titanium, 1L),
                        ItemList.Electric_Motor_EV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L), });

        // Meteor

        // Electric -> Nano
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB_Explorations_EMT_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemNanoMeteor", 1, 27, missing),
                6,
                new AspectList().add(Aspect.getAspect("motus"), 48).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("volatus"), 8).add(Aspect.getAspect("iter"), 16),
                getModItem(ThaumicBoots.ID, "item.ItemElectricMeteor", 1, wildcard, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        ItemList.Electric_Motor_HV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 1L),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 1L),
                        ItemList.Electric_Motor_HV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L), });

        // Nano -> Quantum
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB_Explorations_EMT_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemQuantumMeteor", 1, 27, missing),
                9,
                new AspectList().add(Aspect.getAspect("motus"), 64).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("tutamen"), 48).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("volatus"), 16).add(Aspect.getAspect("iter"), 24)
                        .add(Aspect.getAspect("aer"), 8),
                getModItem(ThaumicBoots.ID, "item.ItemNanoMeteor", 1, wildcard, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemArmorQuantumBoots", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        ItemList.Electric_Motor_EV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Titanium, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Titanium, 1L),
                        ItemList.Electric_Motor_EV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L), });

        // Comet

        // Electric -> Nano
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB_Explorations_EMT_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemNanoComet", 1, 27, missing),
                6,
                new AspectList().add(Aspect.getAspect("motus"), 48).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("volatus"), 8).add(Aspect.getAspect("iter"), 16),
                getModItem(ThaumicBoots.ID, "item.ItemElectricComet", 1, wildcard, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        ItemList.Electric_Motor_HV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 1L),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 1L),
                        ItemList.Electric_Motor_HV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L), });

        // Nano -> Quantum
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TB_Explorations_EMT_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemQuantumComet", 1, 27, missing),
                9,
                new AspectList().add(Aspect.getAspect("motus"), 64).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("tutamen"), 48).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("volatus"), 16).add(Aspect.getAspect("iter"), 24)
                        .add(Aspect.getAspect("aer"), 8),
                getModItem(ThaumicBoots.ID, "item.ItemNanoComet", 1, wildcard, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemArmorQuantumBoots", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        ItemList.Electric_Motor_EV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Titanium, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Titanium, 1L),
                        ItemList.Electric_Motor_EV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L), });

    }
}
