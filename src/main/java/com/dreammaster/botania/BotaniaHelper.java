package com.dreammaster.botania;

import net.minecraft.item.ItemStack;

import gregtech.api.util.GT_Utility;
import vazkii.botania.api.BotaniaAPI;

public class BotaniaHelper {

    public static void removePetalRecipe(ItemStack output) {
        BotaniaAPI.petalRecipes.removeIf(r -> GT_Utility.areStacksEqual(r.getOutput(), output, false));
    }
}
