package com.dreammaster.gthandler;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

import static gregtech.api.enums.Mods.NewHorizonsCoreMod;

public class GT_Loader_Materials {

    public void run() {
        registerMaterialRecipes();
    }

    private void registerMaterialRecipes() {
        GT_ModHandler.addShapelessCraftingRecipe(
                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.AlumiteDust", 8L),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { OrePrefixes.dust.get(Materials.Aluminium), OrePrefixes.dust.get(Materials.Aluminium),
                        OrePrefixes.dust.get(Materials.Aluminium), OrePrefixes.dust.get(Materials.Aluminium),
                        OrePrefixes.dust.get(Materials.Aluminium), OrePrefixes.dust.get(Materials.Steel),
                        OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.Obsidian),
                        OrePrefixes.dust.get(Materials.Obsidian) });

        GT_ModHandler.addShapelessCraftingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.FerriteMixture, 5L),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.Zinc),
                        OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron),
                        OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron) });

        GT_ModHandler.addShapelessCraftingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BorosilicateGlass, 7L),
                GT_ModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { OrePrefixes.dust.get(Materials.Boron), OrePrefixes.dust.get(Materials.Glass),
                        OrePrefixes.dust.get(Materials.Glass), OrePrefixes.dust.get(Materials.Glass),
                        OrePrefixes.dust.get(Materials.Glass), OrePrefixes.dust.get(Materials.Glass),
                        OrePrefixes.dust.get(Materials.Glass), OrePrefixes.dust.get(Materials.Glass) });
    }
}
