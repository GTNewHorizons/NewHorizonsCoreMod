package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBoots;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ScriptTB implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "TB";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(IndustrialCraft2.ID, Thaumcraft.ID, ThaumicBoots.ID);
    }

    @Override
    public void loadRecipes() {

        // VoidWalker boots

        // Electric -> Nano
        TCHelper.addInfusionCraftingRecipe(
                "TB_EMT_Tainted_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemNanoVoid", 1, 27, missing),
                6,
                new AspectList().add(Aspect.getAspect("motus"), 48).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("volatus"), 8).add(Aspect.getAspect("iter"), 16),
                getModItem(ThaumicBoots.ID, "item.ItemElectricVoid", 1, wildcard, missing),
                getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1, wildcard, missing),
                OrePrefixes.plate.get(Materials.Thaumium),
                ItemList.Electric_Motor_HV.get(1L),
                OrePrefixes.wireGt04.get(Materials.Electrum),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                OrePrefixes.wireGt04.get(Materials.Electrum),
                ItemList.Electric_Motor_HV.get(1L),
                OrePrefixes.plate.get(Materials.Thaumium));

        // Nano -> Quantum
        TCHelper.addInfusionCraftingRecipe(
                "TB_EMT_Tainted_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemQuantumVoid", 1, 27, missing),
                9,
                new AspectList().add(Aspect.getAspect("motus"), 64).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("tutamen"), 48).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("volatus"), 16).add(Aspect.getAspect("iter"), 24)
                        .add(Aspect.getAspect("aer"), 8),
                getModItem(ThaumicBoots.ID, "item.ItemNanoVoid", 1, wildcard, missing),
                getModItem(IndustrialCraft2.ID, "itemArmorQuantumBoots", 1, wildcard, missing),
                OrePrefixes.plate.get(Materials.Void),
                ItemList.Electric_Motor_EV.get(1L),
                OrePrefixes.wireGt08.get(Materials.Titanium),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                OrePrefixes.wireGt08.get(Materials.Titanium),
                ItemList.Electric_Motor_EV.get(1L),
                OrePrefixes.plate.get(Materials.Void));

        // Meteor

        // Electric -> Nano
        TCHelper.addInfusionCraftingRecipe(
                "TB_Explorations_EMT_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemNanoMeteor", 1, 27, missing),
                6,
                new AspectList().add(Aspect.getAspect("motus"), 48).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("volatus"), 8).add(Aspect.getAspect("iter"), 16),
                getModItem(ThaumicBoots.ID, "item.ItemElectricMeteor", 1, wildcard, missing),
                getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1, wildcard, missing),
                OrePrefixes.plate.get(Materials.Thaumium),
                ItemList.Electric_Motor_HV.get(1L),
                OrePrefixes.wireGt04.get(Materials.Electrum),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                OrePrefixes.wireGt04.get(Materials.Electrum),
                ItemList.Electric_Motor_HV.get(1L),
                OrePrefixes.plate.get(Materials.Thaumium));

        // Nano -> Quantum
        TCHelper.addInfusionCraftingRecipe(
                "TB_Explorations_EMT_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemQuantumMeteor", 1, 27, missing),
                9,
                new AspectList().add(Aspect.getAspect("motus"), 64).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("tutamen"), 48).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("volatus"), 16).add(Aspect.getAspect("iter"), 24)
                        .add(Aspect.getAspect("aer"), 8),
                getModItem(ThaumicBoots.ID, "item.ItemNanoMeteor", 1, wildcard, missing),
                getModItem(IndustrialCraft2.ID, "itemArmorQuantumBoots", 1, wildcard, missing),
                OrePrefixes.plate.get(Materials.Void),
                ItemList.Electric_Motor_EV.get(1L),
                OrePrefixes.wireGt08.get(Materials.Titanium),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                OrePrefixes.wireGt08.get(Materials.Titanium),
                ItemList.Electric_Motor_EV.get(1L),
                OrePrefixes.plate.get(Materials.Void));

        // Comet

        // Electric -> Nano
        TCHelper.addInfusionCraftingRecipe(
                "TB_Explorations_EMT_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemNanoComet", 1, 27, missing),
                6,
                new AspectList().add(Aspect.getAspect("motus"), 48).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("volatus"), 8).add(Aspect.getAspect("iter"), 16),
                getModItem(ThaumicBoots.ID, "item.ItemElectricComet", 1, wildcard, missing),
                getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1, wildcard, missing),
                OrePrefixes.plate.get(Materials.Thaumium),
                ItemList.Electric_Motor_HV.get(1L),
                OrePrefixes.wireGt04.get(Materials.Electrum),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                OrePrefixes.wireGt04.get(Materials.Electrum),
                ItemList.Electric_Motor_HV.get(1L),
                OrePrefixes.plate.get(Materials.Thaumium));

        // Nano -> Quantum
        TCHelper.addInfusionCraftingRecipe(
                "TB_Explorations_EMT_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemQuantumComet", 1, 27, missing),
                9,
                new AspectList().add(Aspect.getAspect("motus"), 64).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("tutamen"), 48).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("volatus"), 16).add(Aspect.getAspect("iter"), 24)
                        .add(Aspect.getAspect("aer"), 8),
                getModItem(ThaumicBoots.ID, "item.ItemNanoComet", 1, wildcard, missing),
                getModItem(IndustrialCraft2.ID, "itemArmorQuantumBoots", 1, wildcard, missing),
                OrePrefixes.plate.get(Materials.Void),
                ItemList.Electric_Motor_EV.get(1L),
                OrePrefixes.wireGt08.get(Materials.Titanium),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                OrePrefixes.wireGt08.get(Materials.Titanium),
                ItemList.Electric_Motor_EV.get(1L),
                OrePrefixes.plate.get(Materials.Void));

    }
}
