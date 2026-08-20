package com.dreammaster.gthandler;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.material.MaterialParts;
import gregtech.api.util.GTModHandler;

public class GT_Loader_Materials {

    public void run() {
        registerMaterialRecipes();
    }

    private void registerMaterialRecipes() {
        GTModHandler.addShapelessCraftingRecipe(
                MaterialLibAPI.getStack(Materials.Alumite, Shapes.dust, 3),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Zinc),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Zinc),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Zinc),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Zinc),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Zinc),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Steel),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Steel),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Obsidian),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Obsidian) });

        GTModHandler.addShapelessCraftingRecipe(
                MaterialLibAPI.getStack(Materials.FerriteMixture, Shapes.dust, 5),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Nickel),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Zinc),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Iron),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Iron),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Iron),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Iron) });

        GTModHandler.addShapelessCraftingRecipe(
                MaterialLibAPI.getStack(Materials.BorosilicateGlass, Shapes.dust, 7),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Boron),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Glass),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Glass),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Glass),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Glass),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Glass),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Glass),
                        MaterialParts.craftIngredient(OrePrefixes.dust, Materials.Glass) });
    }
}
