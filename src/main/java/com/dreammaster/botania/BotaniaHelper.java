package com.dreammaster.botania;

import net.minecraft.item.ItemStack;

import vazkii.botania.api.BotaniaAPI;
import gregtech.api.util.GT_Utility;

public class BotaniaHelper {

    public static void removePetalRecipe(ItemStack output) {
        BotaniaAPI.petalRecipes.removeIf(r -> GT_Utility.areStacksEqual(r.getOutput(), output, false));
    }
}
