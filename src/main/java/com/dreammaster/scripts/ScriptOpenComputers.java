package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.Mods;

public class ScriptOpenComputers implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Open Computers";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.OpenComputers.ID);
    }

    @Override
    public void loadRecipes() {
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("OpenComputers", "item", 1, 69, missing),
                "---------",
                "---------",
                "--aaaaa--",
                "--abcba--",
                "--adeda--",
                "--abcba--",
                "--aaaaa--",
                "---------",
                "---------",
                'a',
                "circuitMaster",
                'b',
                "circuitElite",
                'c',
                "circuitSuperconductor",
                'd',
                getModItem("OpenComputers", "item", 1, 103, missing),
                'e',
                getModItem("OpenComputers", "case3", 1, 0, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("OpenComputers", "item", 1, 103, missing),
                "---------",
                "---------",
                "--aaaaa--",
                "--abcba--",
                "--adefa--",
                "--abcba--",
                "--aaaaa--",
                "---------",
                "---------",
                'a',
                "circuitElite",
                'b',
                "circuitMaster",
                'c',
                "circuitSuperconductor",
                'd',
                getModItem("OpenComputers", "item", 1, 10, missing),
                'e',
                getModItem("OpenComputers", "item", 1, 102, missing),
                'f',
                getModItem("OpenComputers", "item", 1, 43, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("OpenComputers", "item", 1, 90, missing),
                "---------",
                "---------",
                "--abcbd--",
                "--eeeee--",
                "--efgfe--",
                "--eeeee--",
                "--dbcba--",
                "---------",
                "---------",
                'a',
                "wireGt16Electrum",
                'b',
                "circuitMaster",
                'c',
                "circuitSuperconductor",
                'd',
                "circuitElite",
                'e',
                "plateDenseObsidian",
                'f',
                getModItem("IC2", "itemRTGPellet", 1, 0, missing),
                'g',
                getModItem("IC2", "blockGenerator", 1, 6, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("OpenComputers", "item", 1, 93, missing),
                "---------",
                "---------",
                "--abcba--",
                "--ddedd--",
                "--dfgfd--",
                "--ddddd--",
                "--abcba--",
                "---------",
                "---------",
                'a',
                "circuitMaster",
                'b',
                "circuitElite",
                'c',
                "circuitSuperconductor",
                'd',
                "plateDenseChrome",
                'e',
                getModItem("OpenComputers", "screen3", 1, 0, missing),
                'f',
                getModItem("IC2", "itemRTGPellet", 1, 0, missing),
                'g',
                getModItem("IC2", "blockGenerator", 1, 6, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("OpenComputers", "item", 1, 91, missing),
                "---------",
                "---------",
                "--ababa--",
                "--cdedc--",
                "--fdgdf--",
                "--cdedc--",
                "--ababa--",
                "---------",
                "---------",
                'a',
                "circuitMaster",
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 32606, missing),
                'c',
                "circuitElite",
                'd',
                "turbineBladeChrome",
                'e',
                "circuitSuperconductor",
                'f',
                getModItem("HardcoreEnderExpansion", "biome_compass", 1, 0, missing),
                'g',
                getModItem("OpenComputers", "item", 1, 90, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("OpenComputers", "item", 1, 114, missing),
                "aaaaaaaaa",
                "abacdcaba",
                "aaaaaaaaa",
                "abaefeaba",
                "aaaagaaaa",
                "abaefeaba",
                "aaaaaaaaa",
                "abacdcaba",
                "aaaaaaaaa",
                'a',
                getModItem("OpenComputers", "item", 1, 72, missing),
                'b',
                getModItem("OpenComputers", "item", 1, 39, missing),
                'c',
                getModItem("OpenComputers", "item", 1, 26, missing),
                'd',
                getModItem("OpenComputers", "item", 1, 106, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.03", 1, 32105, missing),
                'f',
                "circuitSuperconductor",
                'g',
                getModItem("OpenComputers", "item", 1, 7, missing));

    }
}
