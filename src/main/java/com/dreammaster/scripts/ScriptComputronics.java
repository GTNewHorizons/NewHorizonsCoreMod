package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;

public class ScriptComputronics implements IScriptLoader {

    public ScriptComputronics() {}

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("Computronics");
        dependencies.clear();
        dependencies.addAll(Arrays.asList("Avaritia", "computronics", "gregtech"));
    }

    @Override
    public void loadRecipes() {
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("computronics", "computronics.ocSpecialParts", 1),
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
                getModItem("Thaumcraft", "ItemResource", 1, 14),
                'f',
                getModItem("OpenComputers", "item", 1, 103),
                'g',
                getModItem("gregtech", "gt.metaitem.03", 1, 32163),
                'h',
                "ingotInfinity",
                'i',
                getModItem("Avaritia", "big_pearl", 1));
    }
}
