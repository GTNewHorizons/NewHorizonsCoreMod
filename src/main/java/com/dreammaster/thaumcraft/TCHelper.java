package com.dreammaster.thaumcraft;

import net.minecraft.item.ItemStack;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategoryList;
import thaumcraft.api.research.ResearchItem;

public class TCHelper {

    public static void orphanResearch(String research) {
        // TODO: Implement
    }

    public static void removeResearch(String research) {
        ResearchItem ri = ResearchCategories.getResearch(research);
        ResearchCategoryList rcl = ResearchCategories.getResearchList(ri.category);
        rcl.research.remove(research);
    }

    public static void removeArcaneRecipe(ItemStack output) {
        ThaumcraftApi.getCraftingRecipes().removeIf(recipe -> {
            if (recipe instanceof IArcaneRecipe) return ((IArcaneRecipe) recipe).getRecipeOutput().isItemEqual(output);
            return false;
        });
    }

    public static void removeCrucibleRecipe(ItemStack output) {
        ThaumcraftApi.getCraftingRecipes().removeIf(recipe -> {
            if (recipe instanceof CrucibleRecipe) return ((CrucibleRecipe) recipe).getRecipeOutput().isItemEqual(output);
            return false;
        });
    }
}
