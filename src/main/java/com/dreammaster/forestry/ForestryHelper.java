package com.dreammaster.forestry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.util.GT_Utility;

public class ForestryHelper {

    public static void removeCarpenterRecipe(ItemStack output) {
        RecipeManagers.carpenterManager.removeRecipe(
                RecipeManagers.carpenterManager.recipes().stream().filter(
                        r -> GT_Utility.areStacksEqual(r.getCraftingGridRecipe().getRecipeOutput(), output, true))
                        .findFirst().orElse(null));
    }

    public static void removeCentrifugeRecipe(ItemStack input) {
        RecipeManagers.centrifugeManager.removeRecipe(
                RecipeManagers.centrifugeManager.recipes().stream()
                        .filter(r -> GT_Utility.areStacksEqual(r.getInput(), input, true)).findFirst().orElse(null));
    }

    public static void removeSqueezerRecipe(FluidStack input) {
        RecipeManagers.squeezerManager.removeRecipe(
                RecipeManagers.squeezerManager.recipes().stream()
                        .filter(r -> GT_Utility.areFluidsEqual(r.getFluidOutput(), input, true)).findFirst()
                        .orElse(null));
    }

    public static void removeFabricatorRecipe(ItemStack output) {
        RecipeManagers.fabricatorManager.removeRecipe(
                RecipeManagers.fabricatorManager.recipes().stream()
                        .filter(r -> GT_Utility.areStacksEqual(r.getRecipeOutput(), output, true)).findFirst()
                        .orElse(null));
    }
}