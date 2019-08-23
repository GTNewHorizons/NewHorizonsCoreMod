package com.dreammaster.modfixes.enderIO;

import com.dreammaster.modfixes.IModFix;
import cpw.mods.fml.common.event.FMLInterModComms;
import crazypants.enderio.EnderIO;
import crazypants.enderio.machine.soul.SoulBinderRecipeManager;
import crazypants.enderio.material.FrankenSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class FrankenskullFix {

    public static void fixEnderIO(){
        //Example of how to add a recipe:

        NBTTagCompound root = new NBTTagCompound();
        root.setString(SoulBinderRecipeManager.KEY_RECIPE_UID, "sentientEnderMK2");
        root.setInteger(SoulBinderRecipeManager.KEY_REQUIRED_ENERGY, 100000);
        root.setInteger(SoulBinderRecipeManager.KEY_REQUIRED_XP, 10);
        root.setString(SoulBinderRecipeManager.KEY_SOUL_TYPES, "SpecialMobs.SpecialWitch");
        ItemStack is = new ItemStack(EnderIO.itemFrankenSkull, 1, FrankenSkull.ENDER_RESONATOR.ordinal());
        NBTTagCompound stackRoot = new NBTTagCompound();
        is.writeToNBT(stackRoot);
        root.setTag(SoulBinderRecipeManager.KEY_INPUT_STACK, stackRoot);
        is = new ItemStack(EnderIO.itemFrankenSkull, 1, FrankenSkull.SENTIENT_ENDER.ordinal());
        stackRoot = new NBTTagCompound();
        is.writeToNBT(stackRoot);
        root.setTag(SoulBinderRecipeManager.KEY_OUTPUT_STACK, stackRoot);

        SoulBinderRecipeManager.getInstance().addRecipeFromNBT(root);
        FMLInterModComms.sendMessage("EnderIO",  "recipe:soulbinder", root);

    }

}
