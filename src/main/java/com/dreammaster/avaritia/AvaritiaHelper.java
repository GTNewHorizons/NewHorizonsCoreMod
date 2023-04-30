package com.dreammaster.avaritia;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.util.GT_Utility;

public class AvaritiaHelper {

    @SuppressWarnings("unchecked")
    public static void removeExtremeCraftingRecipe(ItemStack output) {
        ExtremeCraftingManager.getInstance().getRecipeList().removeIf(
                r -> r instanceof IRecipe && GT_Utility.areStacksEqual(((IRecipe) r).getRecipeOutput(), output, false));
    }
}
