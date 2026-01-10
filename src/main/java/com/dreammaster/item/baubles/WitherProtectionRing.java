package com.dreammaster.item.baubles;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumChatFormatting;

import baubles.api.BaubleType;
import baubles.api.IBauble;

public final class WitherProtectionRing extends Item implements IBauble {

    @Override
    public boolean canEquip(ItemStack stack, EntityLivingBase user) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack stack, EntityLivingBase user) {
        return true;
    }

    @Override
    public BaubleType getBaubleType(ItemStack stack) {
        return BaubleType.RING;
    }

    @Override
    public void onEquipped(ItemStack stack, EntityLivingBase user) {}

    @Override
    public void onUnequipped(ItemStack stack, EntityLivingBase user) {}

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean adv) {
        list.add(
                EnumChatFormatting.GREEN.toString() + EnumChatFormatting.ITALIC
                        + "Finally, a way to get rid of the nasty withering effect.");
        list.add(EnumChatFormatting.GREEN.toString() + EnumChatFormatting.ITALIC + "Now it's time to get some Stars!");
    }

    @Override
    public void onWornTick(ItemStack stack, EntityLivingBase user) {
        if (!(user instanceof EntityPlayer player)) {
            return;
        }

        if (user.worldObj.rand.nextInt(20) == 0) {
            Potion potion = Potion.wither;
            if (player.isPotionActive(potion)) {
                player.removePotionEffect(potion.id);
            }
        }
    }
}
