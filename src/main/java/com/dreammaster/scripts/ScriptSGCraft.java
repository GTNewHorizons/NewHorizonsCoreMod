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
                getModItem(GregTech.ID, "gt.blockmetal9", 1, 7, missing),
                'b',
                getModItem(NewHorizonsCoreMod.ID, "item.StargateFramePart", 1, 0, missing),
                'c',
                getModItem(NewHorizonsCoreMod.ID, "item.StargateChevron", 1, 0, missing),
                'd',
                getModItem(NewHorizonsCoreMod.ID, "item.StargateShieldingFoil", 1, 0, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32047, missing),
                'f',
                getModItem(GregTech.ID, "gt.blockmetal9", 1, 4, missing));
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
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32023, missing),
                'b',
                getModItem(NewHorizonsCoreMod.ID, "item.StargateChevron", 1, 0, missing),
                'c',
                getModItem(NewHorizonsCoreMod.ID, "item.StargateFramePart", 1, 0, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32047, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32043, missing));
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
                getModItem(GregTech.ID, "gt.blockmetal9", 1, 7, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32047, missing),
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
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32043, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32047, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32039, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 4139, missing),
                'e',
                getModItem(TecTech.ID, "gt.spacetime_compression_field_generator", 1, 8, missing),
                'f',
                getModItem(BartWorks.ID, "bw.werkstoffblocks.01", 1, 10112, missing),
                'g',
                getModItem(NewHorizonsCoreMod.ID, "item.StargateShieldingFoil", 1, 0, missing),
                'h',
                getModItem(NewHorizonsCoreMod.ID, "item.StargateFramePart", 1, 0, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32594, missing),
                'j',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 22583, missing),
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
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32047, missing),
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
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 22585, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32023, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32594, missing),
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
                getModItem(GregTech.ID, "gt.blockmetal9", 1, 7, missing),
                'b',
                getModItem(GoodGenerator.ID, "compactFusionCoil", 1, 3, missing),
                'c',
                getModItem(GregTech.ID, "gt.blockmetal9", 1, 4, missing),
                'd',
                getModItem(NewHorizonsCoreMod.ID, "item.QuantumCircuit", 1, 0, missing),
                'e',
                getModItem(SGCraft.ID, "ic2Capacitor", 1, 0, missing),
                'f',
                getModItem(SGCraft.ID, "stargateRing", 1, 0, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 4586, missing));
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
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32039, missing),
                'c',
                getModItem(GregTech.ID, "gt.blockmetal9", 1, 7, missing),
                'd',
                getModItem(GoodGenerator.ID, "compactFusionCoil", 1, 3, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32043, missing));

    }
}
