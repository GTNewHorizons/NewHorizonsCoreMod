package com.dreammaster.scripts;

import static com.dreammaster.scripts.TemporaryMods.AE2WCT;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;

public class ScriptAE2WC implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Applied Energistics 2 Wireless Crafting";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(AppliedEnergistics2.ID, Avaritia.ID, AE2WCT.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(AE2WCT.ID, "magnetCard", 1, 0, missing),
                new Object[] { "plateLapis", getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 300, missing),
                        "plateLapis", "plateNeodymiumMagnetic",
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28, missing),
                        "plateNeodymiumMagnetic", "plateNeodymiumMagnetic", "plateNeodymiumMagnetic",
                        "plateNeodymiumMagnetic" });
        addShapedRecipe(
                getModItem(AE2WCT.ID, "wirelessCraftingTerminal", 1, 0, missing),
                new Object[] { "pearlFluix", getModItem(AppliedEnergistics2.ID, "tile.BlockWireless", 1, 0, missing),
                        "pearlFluix", "crystalPureFluix",
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 360, missing), "crystalPureFluix",
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 47, missing),
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38, missing) });

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(AE2WCT.ID, "infinityBoosterCard", 1, 0, missing),
                "aaaaaaaaa",
                "abcbabcba",
                "acdcacdca",
                "abcbabcba",
                "aaaaaaaaa",
                "abcbabcba",
                "acdcacdca",
                "abcbabcba",
                "aaaaaaaaa",
                'a',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 42, missing),
                'b',
                getModItem(Avaritia.ID, "Resource", 1, 6, missing),
                'c',
                getModItem(Avaritia.ID, "Resource", 1, 4, missing),
                'd',
                getModItem(Avaritia.ID, "Resource", 1, 5, missing));

    }
}
