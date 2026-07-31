package com.dreammaster.gthandler;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.material.MU;
import gregtech.api.util.GTModHandler;

public class GT_Loader_Materials {

    public void run() {
        registerMaterialRecipes();
    }

    private void registerMaterialRecipes() {
        GTModHandler.addShapelessCraftingRecipe(
                MaterialLibAPI.getStack(Materials2Materials.Alumite, Materials2Shapes.dust, (int) (3)),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Zinc),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Zinc),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Zinc),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Zinc),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Zinc),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Steel),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Steel),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Obsidian),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Obsidian) });

        GTModHandler.addShapelessCraftingRecipe(
                MaterialLibAPI.getStack(Materials2Materials.FerriteMixture, Materials2Shapes.dust, (int) (5L)),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Nickel),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Zinc),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Iron),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Iron),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Iron),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Iron) });

        GTModHandler.addShapelessCraftingRecipe(
                MaterialLibAPI.getStack(Materials2Materials.BorosilicateGlass, Materials2Shapes.dust, (int) (7L)),
                GTModHandler.RecipeBits.NOT_REMOVABLE,
                new Object[] { MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Boron),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Glass),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Glass),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Glass),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Glass),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Glass),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Glass),
                        MU.craftIngredient(OrePrefixes.dust, Materials2Materials.Glass) });
    }
}
