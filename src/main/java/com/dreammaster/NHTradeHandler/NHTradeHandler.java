package com.dreammaster.NHTradeHandler;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class NHTradeHandler implements IVillageTradeHandler {

    @Override
    public void manipulateTradesForVillager(final EntityVillager villager, final MerchantRecipeList recipeList,
            final Random random) {
        recipeList.addToListWithCheck(
                new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(Items.ender_pearl, 1)));
        recipeList.addToListWithCheck(
                new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(Items.dye, 1, 4)));
    }
}
