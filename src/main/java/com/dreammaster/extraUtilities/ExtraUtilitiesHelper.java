package com.dreammaster.extraUtilities;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.oredict.OreDictHelper;
import com.rwtema.extrautils.ExtraUtils;
import com.rwtema.extrautils.block.BlockColor;
import com.rwtema.extrautils.helper.XUHelper;
import com.rwtema.extrautils.tileentity.enderconstructor.EnderConstructorRecipesHandler;

import gregtech.api.util.GTUtility;

public class ExtraUtilitiesHelper {

    public static void removeQEDRecipe(ItemStack output) {
        EnderConstructorRecipesHandler.recipes
                .removeIf(r -> GTUtility.areStacksEqual(r.getRecipeOutput(), output, true));
    }

    public static void fixColorBlockOreDictionary() {
        for (BlockColor b : ExtraUtils.colorblocks) {
            for (int i = 0; i < 16; ++i) {
                if (b.oreName != null) {
                    ItemStack stack = new ItemStack(b, 1, i);
                    String old = b.oreName + XUHelper.dyes[i].substring(3);
                    OreDictHelper.removeOreDict(old, stack);
                    OreDictionary.registerOre(b.oreName + XUHelper.dyes[15 - i].substring(3), stack);
                }
            }
        }
    }
}
