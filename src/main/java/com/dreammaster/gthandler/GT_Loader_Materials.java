package com.dreammaster.gthandler;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.util.GTModHandler;

public class GT_Loader_Materials {

    public void run() {
        registerMaterialRecipes();
    }

    private void registerMaterialRecipes() {
        GTModHandler.addShapelessCraftingRecipe(
                MaterialLibAPI.getStack(Materials.Alumite, Shapes.dust, 3),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { OrePrefixes.dust.ingredient(Materials.Zinc), OrePrefixes.dust.ingredient(Materials.Zinc),
                        OrePrefixes.dust.ingredient(Materials.Zinc), OrePrefixes.dust.ingredient(Materials.Zinc),
                        OrePrefixes.dust.ingredient(Materials.Zinc), OrePrefixes.dust.ingredient(Materials.Steel),
                        OrePrefixes.dust.ingredient(Materials.Steel), OrePrefixes.dust.ingredient(Materials.Obsidian),
                        OrePrefixes.dust.ingredient(Materials.Obsidian) });

        GTModHandler.addShapelessCraftingRecipe(
                MaterialLibAPI.getStack(Materials.FerriteMixture, Shapes.dust, 5),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { OrePrefixes.dust.ingredient(Materials.Nickel),
                        OrePrefixes.dust.ingredient(Materials.Zinc), OrePrefixes.dust.ingredient(Materials.Iron),
                        OrePrefixes.dust.ingredient(Materials.Iron), OrePrefixes.dust.ingredient(Materials.Iron),
                        OrePrefixes.dust.ingredient(Materials.Iron) });

        GTModHandler.addShapelessCraftingRecipe(
                MaterialLibAPI.getStack(Materials.BorosilicateGlass, Shapes.dust, 7),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { OrePrefixes.dust.ingredient(Materials.Boron),
                        OrePrefixes.dust.ingredient(Materials.Glass), OrePrefixes.dust.ingredient(Materials.Glass),
                        OrePrefixes.dust.ingredient(Materials.Glass), OrePrefixes.dust.ingredient(Materials.Glass),
                        OrePrefixes.dust.ingredient(Materials.Glass), OrePrefixes.dust.ingredient(Materials.Glass),
                        OrePrefixes.dust.ingredient(Materials.Glass) });
    }
}
