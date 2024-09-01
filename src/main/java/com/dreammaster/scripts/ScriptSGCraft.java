package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.GoodGenerator;
import static gregtech.api.enums.Mods.SGCraft;
import static gregtech.api.enums.Mods.TecTech;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.CustomItemList;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import goodgenerator.items.GGMaterial;
import goodgenerator.loader.Loaders;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import tectech.thing.casing.TTCasingsContainer;

public class ScriptSGCraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Stargate Craft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(SGCraft.ID, BartWorks.ID, EnderIO.ID, GoodGenerator.ID, TecTech.ID);
    }

    @Override
    public void loadRecipes() {
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(SGCraft.ID, "stargateRing", 1, 0, missing),
                "aaabcbbdd",
                "aaabbbdee",
                "aaabbde--",
                "fffbbde--",
                "fffbcde--",
                "fffbbde--",
                "aaabbde--",
                "aaabbbdee",
                "aaabcbbdd",
                'a',
                GT_OreDictUnificator.get(OrePrefixes.block, MaterialsUEVplus.BlackDwarfMatter, 1L),
                'b',
                CustomItemList.StargateFramePart.get(1L),
                'c',
                CustomItemList.StargateChevron.get(1L),
                'd',
                CustomItemList.StargateShieldingFoil.get(1L),
                'e',
                ItemList.Field_Generator_UXV.get(1L),
                'f',
                GT_OreDictUnificator.get(OrePrefixes.block, MaterialsUEVplus.TranscendentMetal, 1L));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(SGCraft.ID, "sgChevronUpgrade", 1, 0, missing),
                "---------",
                "---aba---",
                "---cac---",
                "---dbd---",
                "---cec---",
                "---dcd---",
                "---cac---",
                "---aba---",
                "---------",
                'a',
                ItemList.Electric_Piston_UXV.get(1L),
                'b',
                CustomItemList.StargateChevron.get(1L),
                'c',
                CustomItemList.StargateFramePart.get(1L),
                'd',
                ItemList.Field_Generator_UXV.get(1L),
                'e',
                ItemList.Sensor_UXV.get(1L));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(SGCraft.ID, "stargateRing", 1, 1, missing),
                "---------",
                "----a----",
                "---aba---",
                "--acdca--",
                "-abdedba-",
                "--acdca--",
                "---aba---",
                "----a----",
                "---------",
                'a',
                GT_OreDictUnificator.get(OrePrefixes.block, MaterialsUEVplus.BlackDwarfMatter, 1L),
                'b',
                ItemList.Field_Generator_UXV.get(1L),
                'c',
                CustomItemList.QuantumCircuit.get(1L),
                'd',
                getModItem(SGCraft.ID, "sgChevronUpgrade", 1, 0, missing),
                'e',
                getModItem(SGCraft.ID, "stargateRing", 1, 0, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(SGCraft.ID, "stargateBase", 1, 0, missing),
                "abbcdcbba",
                "befghgfeb",
                "beigjgieb",
                "cklmnmlkc",
                "dklnonlkd",
                "cklmnmlkc",
                "beigjgieb",
                "befghgfeb",
                "abbcdcbba",
                'a',
                ItemList.Sensor_UXV.get(1L),
                'b',
                ItemList.Field_Generator_UXV.get(1L),
                'c',
                ItemList.Emitter_UXV.get(1L),
                'd',
                GT_OreDictUnificator.get(OrePrefixes.nanite, MaterialsUEVplus.Universium, 1L),
                'e',
                new ItemStack(TTCasingsContainer.SpacetimeCompressionFieldGenerators, 1, 8),
                'f',
                GGMaterial.shirabon.get(OrePrefixes.block, 1),
                'g',
                CustomItemList.StargateShieldingFoil.get(1L),
                'h',
                CustomItemList.StargateFramePart.get(1L),
                'i',
                ItemList.ZPM4.get(1L),
                'j',
                GT_OreDictUnificator
                        .get(OrePrefixes.plateDense, MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter, 1L),
                'k',
                new ItemStack(TTCasingsContainer.StabilisationFieldGenerators, 1, 8),
                'l',
                tectech.thing.CustomItemList.Machine_Multi_EyeOfHarmony.get(1),
                'm',
                getModItem(SGCraft.ID, "stargateRing", 1, 0, missing),
                'n',
                getModItem(SGCraft.ID, "stargateRing", 1, 1, missing),
                'o',
                getModItem(SGCraft.ID, "sgCoreCrystal", 1, 0, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(SGCraft.ID, "ic2Capacitor", 1, 0, missing),
                "---------",
                "---------",
                "---aaa---",
                "--abcba--",
                "--acbca--",
                "--abcba--",
                "---aaa---",
                "---------",
                "---------",
                'a',
                CustomItemList.StargateShieldingFoil.get(1L),
                'b',
                ItemList.Field_Generator_UXV.get(1L),
                'c',
                createItemStack(
                        EnderIO.ID,
                        "blockCapBank",
                        1,
                        0,
                        "{type:\"CREATIVE\",storedEnergyRF:2500000}",
                        missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(SGCraft.ID, "sgIrisBlade", 1, 0, missing),
                "-----aaaa",
                "----aaaa-",
                "---aaaa--",
                "--aaaa---",
                "-aaaaa---",
                "abaaaa---",
                "abaaaaa--",
                "acbbaaaa-",
                "daaaaaaaa",
                'a',
                GT_OreDictUnificator.get(OrePrefixes.plateDense, MaterialsUEVplus.WhiteDwarfMatter, 1L),
                'b',
                ItemList.Electric_Piston_UXV.get(1L),
                'c',
                ItemList.ZPM4.get(1L),
                'd',
                new ItemStack(Loaders.compactFusionCoil, 1, 3));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(SGCraft.ID, "sgIrisUpgrade", 1, 0, missing),
                "--aaaaa--",
                "-b-----b-",
                "a-------a",
                "a-------a",
                "a-------a",
                "a-------a",
                "a-------a",
                "-b-----b-",
                "--aaaaa--",
                'a',
                getModItem(SGCraft.ID, "sgIrisBlade", 1, 0, missing),
                'b',
                new ItemStack(Loaders.compactFusionCoil, 1, 3));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(SGCraft.ID, "rfPowerUnit", 1, 0, missing),
                "aabcccbaa",
                "a-b---b-a",
                "a-b-d-b-a",
                "c--beb--c",
                "c-defed-c",
                "c--beb--c",
                "agg-d-gga",
                "a-g---g-a",
                "aaacccaaa",
                'a',
                GT_OreDictUnificator.get(OrePrefixes.block, MaterialsUEVplus.BlackDwarfMatter, 1L),
                'b',
                new ItemStack(Loaders.compactFusionCoil, 1, 3),
                'c',
                GT_OreDictUnificator.get(OrePrefixes.block, MaterialsUEVplus.TranscendentMetal, 1L),
                'd',
                CustomItemList.QuantumCircuit.get(1L),
                'e',
                getModItem(SGCraft.ID, "ic2Capacitor", 1, 0, missing),
                'f',
                getModItem(SGCraft.ID, "stargateRing", 1, 0, missing),
                'g',
                GT_OreDictUnificator.get(OrePrefixes.nanite, MaterialsUEVplus.BlackDwarfMatter, 1L));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(SGCraft.ID, "ocInterface", 1, 0, missing),
                "abccdccea",
                "ed--d--db",
                "c-d-d-d-c",
                "c--ddd--c",
                "ddddadddd",
                "c--ddd--c",
                "c-d-d-d-c",
                "bd--d--de",
                "aeccdccba",
                'a',
                CustomItemList.QuantumCircuit.get(1L),
                'b',
                ItemList.Emitter_UXV.get(1L),
                'c',
                GT_OreDictUnificator.get(OrePrefixes.block, MaterialsUEVplus.BlackDwarfMatter, 1L),
                'd',
                new ItemStack(Loaders.compactFusionCoil, 1, 3),
                'e',
                ItemList.Sensor_UXV.get(1L));

    }
}
