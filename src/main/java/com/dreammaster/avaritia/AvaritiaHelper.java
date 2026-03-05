package com.dreammaster.avaritia;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.util.GTUtility;

public class AvaritiaHelper {

    public static void removeExtremeCraftingRecipe(ItemStack output) {
        ExtremeCraftingManager.getInstance().getRecipeList().removeIf(
                r -> r instanceof IRecipe && GTUtility.areStacksEqual(((IRecipe) r).getRecipeOutput(), output, true));
    }
}
