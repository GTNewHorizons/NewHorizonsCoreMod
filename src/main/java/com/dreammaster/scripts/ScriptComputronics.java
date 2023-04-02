package com.dreammaster.scripts;

import static gregtech.api.enums.ModIDs.Avaritia;
import static gregtech.api.enums.ModIDs.Computronics;
import static gregtech.api.enums.ModIDs.GregTech;
import static gregtech.api.enums.ModIDs.OpenComputers;
import static gregtech.api.enums.ModIDs.Thaumcraft;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;

public class ScriptComputronics implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Computronics";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Avaritia.modID, Computronics.modID, GregTech.modID, OpenComputers.modID, Thaumcraft.modID );
    }

    @Override
    public void loadRecipes() {
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(Computronics.modID, "computronics.ocSpecialParts", 1),
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
                getModItem(Thaumcraft.modID, "ItemResource", 1, 14),
                'f',
                getModItem(OpenComputers.modID, "item", 1, 103),
                'g',
                getModItem(GregTech.modID, "gt.metaitem.03", 1, 32163),
                'h',
                "ingotInfinity",
                'i',
                getModItem(Avaritia.modID, "big_pearl", 1));
    }
}
