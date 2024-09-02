package com.dreammaster.extraUtilities;

import net.minecraft.item.ItemStack;

import com.rwtema.extrautils.tileentity.enderconstructor.EnderConstructorRecipesHandler;

import gregtech.api.util.GTUtility;

public class ExtraUtilitiesHelper {

    public static void removeQEDRecipe(ItemStack output) {
        EnderConstructorRecipesHandler.recipes
                .removeIf(r -> GTUtility.areStacksEqual(r.getRecipeOutput(), output, true));
    }
}
