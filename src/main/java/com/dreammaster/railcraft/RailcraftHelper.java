package com.dreammaster.railcraft;

import net.minecraft.item.ItemStack;

import gregtech.api.util.GTUtility;
import mods.railcraft.api.crafting.RailcraftCraftingManager;

public class RailcraftHelper {

    public static void removeRollingRecipe(ItemStack output) {
        RailcraftCraftingManager.rollingMachine.getRecipeList()
                .removeIf(r -> GTUtility.areStacksEqual(r.getRecipeOutput(), output, true));
    }
}
