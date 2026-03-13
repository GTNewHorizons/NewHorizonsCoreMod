package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AE2WCT;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static com.dreammaster.scripts.IngredientFactory.getModItem;

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
                getModItem(AE2WCT.ID, "magnetCard", 1, 0),
                "plateLapis",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 300),
                "plateLapis",
                "plateNeodymiumMagnetic",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 28),
                "plateNeodymiumMagnetic",
                "plateNeodymiumMagnetic",
                "plateNeodymiumMagnetic",
                "plateNeodymiumMagnetic");
        addShapedRecipe(
                getModItem(AE2WCT.ID, "wirelessCraftingTerminal", 1, 0),
                "pearlFluix",
                getModItem(AppliedEnergistics2.ID, "tile.BlockWireless", 1, 0),
                "pearlFluix",
                "crystalPureFluix",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 360),
                "crystalPureFluix",
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 47),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 38));

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(AE2WCT.ID, "infinityBoosterCard", 1, 0),
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
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 42),
                'b',
                getModItem(Avaritia.ID, "Resource", 1, 6),
                'c',
                getModItem(Avaritia.ID, "Resource", 1, 4),
                'd',
                getModItem(Avaritia.ID, "Resource", 1, 5));

    }
}
