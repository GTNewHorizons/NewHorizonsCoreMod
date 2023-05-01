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

    public static void removeSqueezerRecipe(FluidStack output, ItemStack... inputs) {
        RecipeManagers.squeezerManager.removeRecipe(RecipeManagers.squeezerManager.recipes().stream().filter(r -> {
            if (!GT_Utility.areFluidsEqual(r.getFluidOutput(), output, true)) return false;
            for (int i = 0, inputsLength = inputs.length; i < inputsLength; i++)
                if (!GT_Utility.areStacksEqual(r.getResources()[i], inputs[i], true)) return false;
            return true;
        }).findFirst().orElse(null));
    }

    public static void removeFabricatorRecipe(ItemStack output) {
        RecipeManagers.fabricatorManager.removeRecipe(
                RecipeManagers.fabricatorManager.recipes().stream()
                        .filter(r -> GT_Utility.areStacksEqual(r.getRecipeOutput(), output, true)).findFirst()
                        .orElse(null));
    }
}
