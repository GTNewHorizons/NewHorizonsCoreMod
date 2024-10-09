package com.dreammaster.gthandler;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;

public class GT_Loader_Materials {

    public void run() {
        registerMaterialRecipes();
    }

    private void registerMaterialRecipes() {
        GTModHandler.addShapelessCraftingRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Alumite, 8),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { OrePrefixes.dust.get(Materials.Aluminium), OrePrefixes.dust.get(Materials.Aluminium),
                        OrePrefixes.dust.get(Materials.Aluminium), OrePrefixes.dust.get(Materials.Aluminium),
                        OrePrefixes.dust.get(Materials.Aluminium), OrePrefixes.dust.get(Materials.Steel),
                        OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.Obsidian),
                        OrePrefixes.dust.get(Materials.Obsidian) });

        GTModHandler.addShapelessCraftingRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.FerriteMixture, 5L),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.Zinc),
                        OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron),
                        OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron) });

        GTModHandler.addShapelessCraftingRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.BorosilicateGlass, 7L),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { OrePrefixes.dust.get(Materials.Boron), OrePrefixes.dust.get(Materials.Glass),
                        OrePrefixes.dust.get(Materials.Glass), OrePrefixes.dust.get(Materials.Glass),
                        OrePrefixes.dust.get(Materials.Glass), OrePrefixes.dust.get(Materials.Glass),
                        OrePrefixes.dust.get(Materials.Glass), OrePrefixes.dust.get(Materials.Glass) });
    }
}
