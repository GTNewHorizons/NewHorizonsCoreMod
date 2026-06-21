package com.dreammaster.item.baubles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import baubles.api.BaubleType;
import baubles.api.IBauble;

public final class HealingAmulet extends Item implements IBauble {

    @Override
    public BaubleType getBaubleType(ItemStack stack) {
        return BaubleType.AMULET;
    }

    @Override
    public void onWornTick(ItemStack stack, EntityLivingBase user) {
        if (!(user instanceof EntityPlayer player)) {
            return;
        }

        if (user.worldObj.rand.nextInt(40) == 0) {
            player.getFoodStats().addStats(1, 0.5F);
        }
    }

    @Override
    public void onEquipped(ItemStack stack, EntityLivingBase user) {}

    @Override
    public void onUnequipped(ItemStack stack, EntityLivingBase user) {}

    @Override
    public boolean canEquip(ItemStack stack, EntityLivingBase user) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack stack, EntityLivingBase user) {
        return true;
    }

}
