package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.GoodGenerator;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.SGCraft;
import static gregtech.api.enums.Mods.TecTech;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;

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
                getModItem(NewHorizonsCoreMod.ID, "item.StargateFramePart", 1, 0, missing),
                'c',
                getModItem(NewHorizonsCoreMod.ID, "item.StargateChevron", 1, 0, missing),
                'd',
                getModItem(NewHorizonsCoreMod.ID, "item.StargateShieldingFoil", 1, 0, missing),
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
                getModItem(NewHorizonsCoreMod.ID, "item.StargateChevron", 1, 0, missing),
                'c',
                getModItem(NewHorizonsCoreMod.ID, "item.StargateFramePart", 1, 0, missing),
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
                getModItem(NewHorizonsCoreMod.ID, "item.QuantumCircuit", 1, 0, missing),
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
                getModItem(TecTech.ID, "gt.spacetime_compression_field_generator", 1, 8, missing),
                'f',
                getModItem(BartWorks.ID, "bw.werkstoffblocks.01", 1, 10112, missing),
                'g',
                getModItem(NewHorizonsCoreMod.ID, "item.StargateShieldingFoil", 1, 0, missing),
                'h',
                getModItem(NewHorizonsCoreMod.ID, "item.StargateFramePart", 1, 0, missing),
                'i',
                ItemList.ZPM4.get(1L),
                'j',
                GT_OreDictUnificator
                        .get(OrePrefixes.plateDense, MaterialsUEVplus.MagnetohydrodynamicallyConstrainedStarMatter, 1L),
                'k',
                getModItem(TecTech.ID, "gt.stabilisation_field_generator", 1, 8, missing),
                'l',
                getModItem(GregTech.ID, "gt.blockmachines", 1, 15410, missing),
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
                getModItem(NewHorizonsCoreMod.ID, "item.StargateShieldingFoil", 1, 0, missing),
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
                getModItem(GoodGenerator.ID, "compactFusionCoil", 1, 3, missing));
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
                getModItem(GoodGenerator.ID, "compactFusionCoil", 1, 3, missing));
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
                getModItem(GoodGenerator.ID, "compactFusionCoil", 1, 3, missing),
                'c',
                GT_OreDictUnificator.get(OrePrefixes.block, MaterialsUEVplus.TranscendentMetal, 1L),
                'd',
                getModItem(NewHorizonsCoreMod.ID, "item.QuantumCircuit", 1, 0, missing),
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
                getModItem(NewHorizonsCoreMod.ID, "item.QuantumCircuit", 1, 0, missing),
                'b',
                ItemList.Emitter_UXV.get(1L),
                'c',
                GT_OreDictUnificator.get(OrePrefixes.block, MaterialsUEVplus.BlackDwarfMatter, 1L),
                'd',
                getModItem(GoodGenerator.ID, "compactFusionCoil", 1, 3, missing),
                'e',
                ItemList.Sensor_UXV.get(1L));

    }
}
