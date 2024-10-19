package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.Computronics;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.ItemList;

public class ScriptComputronics implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Computronics";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Avaritia.ID, Computronics.ID, GregTech.ID, OpenComputers.ID, Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Computronics.ID, "computronics.ocSpecialParts", 1),
                "aaaaaaaaa",
                "abbbbbbbc",
                "abdefedbc",
                "abgggggbc",
                "abdhihdbc",
                "abgggggbc",
                "abdefedbc",
                "abbbbbbbc",
                "aaaaaaaaa",
                'a',
                "plateNeutronium",
                'b',
                "oc:ram6",
                'c',
                "wireGt04ElectrumFlux",
                'd',
                "circuitBio",
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                'f',
                getModItem(OpenComputers.ID, "item", 1, 103),
                'g',
                ItemList.Circuit_Chip_PPIC.get(1L),
                'h',
                "ingotInfinity",
                'i',
                getModItem(Avaritia.ID, "big_pearl", 1));
    }
}
