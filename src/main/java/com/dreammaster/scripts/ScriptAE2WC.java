package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.Mods;

public class ScriptAE2WC implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Applied Energistics 2 Wireless Crafting";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.AppliedEnergistics2.ID, "ae2wct");
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("ae2wct", "magnetCard", 1, 0, missing),
                new Object[] { "plateLapis", getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 300, missing),
                        "plateLapis", "plateNeodymiumMagnetic",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 28, missing),
                        "plateNeodymiumMagnetic", "plateNeodymiumMagnetic", "plateNeodymiumMagnetic",
                        "plateNeodymiumMagnetic" });
        addShapedRecipe(
                getModItem("ae2wct", "wirelessCraftingTerminal", 1, 0, missing),
                new Object[] { "pearlFluix", getModItem("appliedenergistics2", "tile.BlockWireless", 1, 0, missing),
                        "pearlFluix", "crystalPureFluix",
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 360, missing), "crystalPureFluix",
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 38, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 47, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 38, missing) });
    }
}
