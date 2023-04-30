package com.dreammaster.bloodmagic;

import net.minecraft.item.ItemStack;

import WayofTime.alchemicalWizardry.api.alchemy.AlchemyRecipeRegistry;
import gregtech.api.util.GT_Utility;

public class BloodMagicHelper {

    public static void removeAlchemyRecipe(ItemStack output) {
        AlchemyRecipeRegistry.recipes.removeIf(r -> GT_Utility.areStacksEqual(r.getResult(), output, true));
    }
}
