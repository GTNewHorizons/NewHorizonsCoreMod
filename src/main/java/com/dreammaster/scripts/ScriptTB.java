package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBoots;

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
                getModItem(ThaumicBoots.ID, "item.ItemNanoVoid", 1, 27),
                6,
                new AspectList().add(Aspect.MOTION, 48).add(Aspect.ENERGY, 24).add(Aspect.ARMOR, 32)
                        .add(Aspect.MAGIC, 16).add(Aspect.FLIGHT, 8).add(Aspect.TRAVEL, 16),
                getModItem(ThaumicBoots.ID, "item.ItemElectricVoid", 1, wildcard),
                getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1, wildcard),
                OrePrefixes.plate.get(Materials.Thaumium),
                ItemList.Electric_Motor_HV.get(1L),
                OrePrefixes.wireGt04.get(Materials.Electrum),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                OrePrefixes.wireGt04.get(Materials.Electrum),
                ItemList.Electric_Motor_HV.get(1L),
                OrePrefixes.plate.get(Materials.Thaumium));

        // Nano -> Quantum
        TCHelper.addInfusionCraftingRecipe(
                "TB_EMT_Tainted_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemQuantumVoid", 1, 27),
                9,
                new AspectList().add(Aspect.MOTION, 64).add(Aspect.ENERGY, 32).add(Aspect.ARMOR, 48)
                        .add(Aspect.MAGIC, 24).add(Aspect.FLIGHT, 16).add(Aspect.TRAVEL, 24).add(Aspect.AIR, 8),
                getModItem(ThaumicBoots.ID, "item.ItemNanoVoid", 1, wildcard),
                getModItem(IndustrialCraft2.ID, "itemArmorQuantumBoots", 1, wildcard),
                OrePrefixes.plate.get(Materials.Void),
                ItemList.Electric_Motor_EV.get(1L),
                OrePrefixes.wireGt08.get(Materials.Titanium),
                "plateAlloyIridium",
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard),
                "plateAlloyIridium",
                OrePrefixes.wireGt08.get(Materials.Titanium),
                ItemList.Electric_Motor_EV.get(1L),
                OrePrefixes.plate.get(Materials.Void));

        // Meteor

        // Electric -> Nano
        TCHelper.addInfusionCraftingRecipe(
                "TB_Explorations_EMT_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemNanoMeteor", 1, 27),
                6,
                new AspectList().add(Aspect.MOTION, 48).add(Aspect.ENERGY, 24).add(Aspect.ARMOR, 32)
                        .add(Aspect.MAGIC, 16).add(Aspect.FLIGHT, 8).add(Aspect.TRAVEL, 16),
                getModItem(ThaumicBoots.ID, "item.ItemElectricMeteor", 1, wildcard),
                getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1, wildcard),
                OrePrefixes.plate.get(Materials.Thaumium),
                ItemList.Electric_Motor_HV.get(1L),
                OrePrefixes.wireGt04.get(Materials.Electrum),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                OrePrefixes.wireGt04.get(Materials.Electrum),
                ItemList.Electric_Motor_HV.get(1L),
                OrePrefixes.plate.get(Materials.Thaumium));

        // Nano -> Quantum
        TCHelper.addInfusionCraftingRecipe(
                "TB_Explorations_EMT_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemQuantumMeteor", 1, 27),
                9,
                new AspectList().add(Aspect.MOTION, 64).add(Aspect.ENERGY, 32).add(Aspect.ARMOR, 48)
                        .add(Aspect.MAGIC, 24).add(Aspect.FLIGHT, 16).add(Aspect.TRAVEL, 24).add(Aspect.AIR, 8),
                getModItem(ThaumicBoots.ID, "item.ItemNanoMeteor", 1, wildcard),
                getModItem(IndustrialCraft2.ID, "itemArmorQuantumBoots", 1, wildcard),
                OrePrefixes.plate.get(Materials.Void),
                ItemList.Electric_Motor_EV.get(1L),
                OrePrefixes.wireGt08.get(Materials.Titanium),
                "plateAlloyIridium",
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard),
                "plateAlloyIridium",
                OrePrefixes.wireGt08.get(Materials.Titanium),
                ItemList.Electric_Motor_EV.get(1L),
                OrePrefixes.plate.get(Materials.Void));

        // Comet

        // Electric -> Nano
        TCHelper.addInfusionCraftingRecipe(
                "TB_Explorations_EMT_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemNanoComet", 1, 27),
                6,
                new AspectList().add(Aspect.MOTION, 48).add(Aspect.ENERGY, 24).add(Aspect.ARMOR, 32)
                        .add(Aspect.MAGIC, 16).add(Aspect.FLIGHT, 8).add(Aspect.TRAVEL, 16),
                getModItem(ThaumicBoots.ID, "item.ItemElectricComet", 1, wildcard),
                getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1, wildcard),
                OrePrefixes.plate.get(Materials.Thaumium),
                ItemList.Electric_Motor_HV.get(1L),
                OrePrefixes.wireGt04.get(Materials.Electrum),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                OrePrefixes.wireGt04.get(Materials.Electrum),
                ItemList.Electric_Motor_HV.get(1L),
                OrePrefixes.plate.get(Materials.Thaumium));

        // Nano -> Quantum
        TCHelper.addInfusionCraftingRecipe(
                "TB_Explorations_EMT_Compat",
                getModItem(ThaumicBoots.ID, "item.ItemQuantumComet", 1, 27),
                9,
                new AspectList().add(Aspect.MOTION, 64).add(Aspect.ENERGY, 32).add(Aspect.ARMOR, 48)
                        .add(Aspect.MAGIC, 24).add(Aspect.FLIGHT, 16).add(Aspect.TRAVEL, 24).add(Aspect.AIR, 8),
                getModItem(ThaumicBoots.ID, "item.ItemNanoComet", 1, wildcard),
                getModItem(IndustrialCraft2.ID, "itemArmorQuantumBoots", 1, wildcard),
                OrePrefixes.plate.get(Materials.Void),
                ItemList.Electric_Motor_EV.get(1L),
                OrePrefixes.wireGt08.get(Materials.Titanium),
                "plateAlloyIridium",
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard),
                "plateAlloyIridium",
                OrePrefixes.wireGt08.get(Materials.Titanium),
                ItemList.Electric_Motor_EV.get(1L),
                OrePrefixes.plate.get(Materials.Void));

    }
}
