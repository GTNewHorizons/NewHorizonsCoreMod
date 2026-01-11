package com.dreammaster.item.baubles;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import com.dreammaster.main.MainRegistry;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import gregtech.api.damagesources.GTDamageSources.DamageSourceHotItem;
import gregtech.api.enums.Mods;
import xonin.backhand.api.core.BackhandUtils;

public final class OvenGlove extends Item implements IBauble {

    private static final String NBTTAG_DURABILITY = "Durability";
    private static final int MAX_DURABILITY = 1000;

    public OvenGlove() {
        super.setMaxDamage(0);
        super.setHasSubtypes(true);
    }

    private static long prevTime = Long.MIN_VALUE;
    private static int curRand = -1;

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            long curTime = System.currentTimeMillis();
            if (curTime - prevTime > 1000L || curRand == -1) {
                curRand = MainRegistry.Rnd.nextInt(4);
            }
            prevTime = curTime;

            return StatCollector
                    .translateToLocal(getUnlocalizedName() + "_" + stack.getItemDamage() + "_" + curRand + ".name");
        } else {
            return super.getItemStackDisplayName(stack);
        }
    }

    public IIcon[] icons = new IIcon[2];

    @Override
    public void registerIcons(IIconRegister reg) {
        icons[0] = reg.registerIcon(super.getIconString() + "_0");
        icons[1] = reg.registerIcon(super.getIconString() + "_1");
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        return icons[meta];
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> list) {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
    }

    @Override
    public boolean canEquip(ItemStack arg0, EntityLivingBase arg1) {
        return arg1 instanceof EntityPlayer;
    }

    @Override
    public boolean canUnequip(ItemStack arg0, EntityLivingBase arg1) {
        return true;
    }

    @Override
    public BaubleType getBaubleType(ItemStack arg0) {
        return BaubleType.RING;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {}

    @Override
    public void onEquipped(ItemStack arg0, EntityLivingBase entity) {}

    @Override
    public void onUnequipped(ItemStack arg0, EntityLivingBase pEntityBase) {}

    // ------------------ NBT Start
    @Override
    public void onCreated(ItemStack pItemStack, World pWorld, EntityPlayer pEntityPlayer) {
        createOrInitNBTTag(pItemStack);
    }

    private static int getNBTDurability(ItemStack pItemStack) {
        return pItemStack.stackTagCompound.getInteger(NBTTAG_DURABILITY);
    }

    private static void damageItem(ItemStack pItemStack) {
        int tCurrentDura = getNBTDurability(pItemStack);
        if (tCurrentDura > 0) {
            pItemStack.stackTagCompound.setInteger(NBTTAG_DURABILITY, --tCurrentDura);
        }
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean adv) {
        createOrInitNBTTag(stack);

        list.add(StatCollector.translateToLocal("item.OvenGlove.desc.1"));
        list.add(
                StatCollector
                        .translateToLocalFormatted("item.OvenGlove.desc.2", getNBTDurability(stack), MAX_DURABILITY));
        if (stack.stackTagCompound.getInteger(NBTTAG_DURABILITY) <= 1) {
            list.add(StatCollector.translateToLocal("item.OvenGlove.desc.broken"));
        }
    }

    private void createOrInitNBTTag(ItemStack stack) {
        if (stack.stackTagCompound == null) {
            stack.setTagCompound(new NBTTagCompound());
            stack.stackTagCompound.setInteger(NBTTAG_DURABILITY, MAX_DURABILITY);
        }
    }

    public static class EventHandler {

        @SubscribeEvent
        public void onDamage(LivingAttackEvent event) {
            Entity entity = event.entity;

            if (!(entity instanceof EntityPlayer player)) {
                return;
            }

            if (!(event.source instanceof DamageSourceHotItem)) {
                return;
            }

            // If the game is in peaceful, exit early. Why do this? See issue #16879
            if (player.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
                event.setCanceled(true);
                return;
            }

            InventoryBaubles baubles = PlayerHandler.getPlayerBaubles(player);
            ItemStack cause = ((DamageSourceHotItem) event.source).getDamagingStack();

            // We cancel damage only for held items!
            boolean shouldAttemptCancel = cause == player.getHeldItem();
            if (!shouldAttemptCancel && Mods.Backhand.isModLoaded()) {
                if (cause == BackhandUtils.getOffhandItem(player)) {
                    shouldAttemptCancel = true;
                }
            }

            if (!shouldAttemptCancel) return;

            ItemStack gloveL = null;
            ItemStack gloveR = null;

            ItemStack[] stackList = baubles.stackList;
            for (ItemStack stack : stackList) {
                if (stack != null && stack.getItem() instanceof OvenGlove) {
                    if (gloveL == null && stack.getItemDamage() == 0) {
                        gloveL = stack;
                    } else if (gloveR == null && stack.getItemDamage() == 1) {
                        gloveR = stack;
                    }

                    if (gloveL != null && gloveR != null) break;
                }
            }

            if (gloveL == null || gloveR == null) return;

            // Cheated gloves don't have NBT tags sometimes
            if (gloveL.stackTagCompound == null || gloveR.stackTagCompound == null) {
                return;
            }

            if (gloveL.stackTagCompound.getInteger(NBTTAG_DURABILITY) <= 1
                    || gloveR.stackTagCompound.getInteger(NBTTAG_DURABILITY) <= 1) {
                return;
            }

            event.setCanceled(true);

            // Randomly damage gloves while giving the protection effect
            int randomDamage = MainRegistry.Rnd.nextInt(10);

            if (randomDamage == 1) {
                OvenGlove.damageItem(gloveL);
            } else if (randomDamage == 2) {
                OvenGlove.damageItem(gloveR);
            }
        }
    }
}
