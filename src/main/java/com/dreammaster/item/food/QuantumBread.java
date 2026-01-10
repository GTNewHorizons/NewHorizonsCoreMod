package com.dreammaster.item.food;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.dreammaster.main.MainRegistry;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public final class QuantumBread extends ItemFood {

    private static final String QUANTUM_BREAD_NAME = "QuantumBread";

    public QuantumBread() {
        super(1, 0.0F, true);
        setAlwaysEdible();
    }

    private static long prevTime = Long.MIN_VALUE;
    private static int curRand = -1;

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            long curTime = System.currentTimeMillis();
            if (curTime - prevTime > 250L || curRand == -1) {
                curRand = MainRegistry.Rnd.nextInt(2);
            }
            prevTime = curTime;
            return String.format("%s_%d", getUnlocalizedName(), curRand);
        } else {
            return super.getUnlocalizedName(stack);
        }
    }

    @Override
    public boolean hasEffect(ItemStack stack, int pass) {
        return true;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        player.getFoodStats().addStats(10, 1.0F);
        player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20 * 60, 2));
        player.addPotionEffect(new PotionEffect(Potion.jump.id, 20 * 60, 2));
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20 * 60, 2));
        super.onFoodEaten(stack, world, player);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean adv) {
        super.addInformation(stack, player, list, adv);

        if (curRand == 1) {
            list.add(EnumChatFormatting.AQUA + "...wasn't it sliced just a second ago?");
        }
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List<ItemStack> list) {}
}
