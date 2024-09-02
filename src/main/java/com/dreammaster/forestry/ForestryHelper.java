package com.dreammaster.forestry;

import java.util.stream.Collectors;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.util.GTUtility;

public class ForestryHelper {

    public static void removeCarpenterRecipe(ItemStack output) {
        RecipeManagers.carpenterManager.recipes().stream()
                .filter(r -> GTUtility.areStacksEqual(r.getCraftingGridRecipe().getRecipeOutput(), output, true))
                .collect(Collectors.toList()).forEach(r -> RecipeManagers.carpenterManager.removeRecipe(r));
    }

    public static void removeCentrifugeRecipe(ItemStack input) {
        RecipeManagers.centrifugeManager.recipes().stream()
                .filter(r -> GTUtility.areStacksEqual(r.getInput(), input, true)).collect(Collectors.toList())
                .forEach(r -> RecipeManagers.centrifugeManager.removeRecipe(r));
    }

    public static void removeSqueezerRecipe(FluidStack output, ItemStack... inputs) {
        RecipeManagers.squeezerManager.recipes().stream().filter(r -> {
            if (!GTUtility.areFluidsEqual(r.getFluidOutput(), output, true)) return false;
            for (int i = 0, inputsLength = inputs.length; i < inputsLength; i++)
                if (!GTUtility.areStacksEqual(r.getResources()[i], inputs[i], true)) return false;
            return true;
        }).collect(Collectors.toList()).forEach(r -> RecipeManagers.squeezerManager.removeRecipe(r));
    }

    public static void removeFabricatorRecipe(ItemStack output) {
        RecipeManagers.fabricatorManager.recipes().stream()
                .filter(r -> GTUtility.areStacksEqual(r.getRecipeOutput(), output, true)).collect(Collectors.toList())
                .forEach(r -> RecipeManagers.fabricatorManager.removeRecipe(r));
    }
}
