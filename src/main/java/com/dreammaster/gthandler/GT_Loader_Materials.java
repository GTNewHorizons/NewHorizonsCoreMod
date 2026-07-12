package com.dreammaster.gthandler;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.util.GTModHandler;

public class GT_Loader_Materials {

    public void run() {
        registerMaterialRecipes();
    }

    private void registerMaterialRecipes() {
        GTModHandler.addShapelessCraftingRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Alumite, Materials2Shapes.dust, (int) (3)),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { OrePrefixes.dust.get(Materials.Zinc), OrePrefixes.dust.get(Materials.Zinc),
                        OrePrefixes.dust.get(Materials.Zinc), OrePrefixes.dust.get(Materials.Zinc),
                        OrePrefixes.dust.get(Materials.Zinc), OrePrefixes.dust.get(Materials.Steel),
                        OrePrefixes.dust.get(Materials.Steel), OrePrefixes.dust.get(Materials.Obsidian),
                        OrePrefixes.dust.get(Materials.Obsidian) });

        GTModHandler.addShapelessCraftingRecipe(
                MaterialLibAPI.getStack(Materials2Materials.FerriteMixture, Materials2Shapes.dust, (int) (5L)),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.Zinc),
                        OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron),
                        OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron) });

        GTModHandler.addShapelessCraftingRecipe(
                MaterialLibAPI.getStack(Materials2Materials.BorosilicateGlass, Materials2Shapes.dust, (int) (7L)),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { OrePrefixes.dust.get(Materials.Boron), OrePrefixes.dust.get(Materials.Glass),
                        OrePrefixes.dust.get(Materials.Glass), OrePrefixes.dust.get(Materials.Glass),
                        OrePrefixes.dust.get(Materials.Glass), OrePrefixes.dust.get(Materials.Glass),
                        OrePrefixes.dust.get(Materials.Glass), OrePrefixes.dust.get(Materials.Glass) });
    }
}
