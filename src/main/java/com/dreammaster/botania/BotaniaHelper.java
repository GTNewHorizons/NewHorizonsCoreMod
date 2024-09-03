package com.dreammaster.botania;

import net.minecraft.item.ItemStack;

import gregtech.api.util.GTUtility;
import vazkii.botania.api.BotaniaAPI;

public class BotaniaHelper {

    public static void removePetalRecipe(ItemStack output) {
        BotaniaAPI.petalRecipes.removeIf(r -> GTUtility.areStacksEqual(r.getOutput(), output, false));
    }
}
