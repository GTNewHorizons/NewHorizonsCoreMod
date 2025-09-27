package com.dreammaster.baubles;

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
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dreammaster.lib.Refstrings;
import com.dreammaster.main.MainRegistry;
import com.dreammaster.main.NHItems;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import eu.usrv.yamcore.iface.IExtendedModItem;
import gregtech.api.damagesources.GTDamageSources.DamageSourceHotItem;
import gregtech.api.enums.Mods;
import xonin.backhand.api.core.BackhandUtils;

public final class OvenGlove extends Item implements IBauble, IExtendedModItem<OvenGlove> {

    public static final Logger LOGGER = LogManager.getLogger();
    private static final String NBTTAG_DURABILITY = "Durability";

    private final String _mItemName;
    private final String _mCreativeTab;
    private static final int MaxDurability = 1000;
    private static boolean checkPopup = false;

    @Override
    public OvenGlove getConstructedItem() {
        return NHItems.OVEN_GLOVE.get();
    }

    @Override
    public String getCreativeTabName() {
        return _mCreativeTab;
    }

    @Override
    public String getUnlocalizedNameForRegistration() {
        return super.getUnlocalizedName();
    }

    public OvenGlove(String pItemName, String pCreativeTab) {
        _mItemName = pItemName;
        _mCreativeTab = pCreativeTab;

        super.setTextureName(String.format("%s:item%s", Refstrings.MODID, _mItemName));
        super.setUnlocalizedName(_mItemName);
        super.setMaxDamage(0);
        super.setHasSubtypes(true);
    }

    private static long prevTime = Long.MIN_VALUE;
    private static int curRand = -1;

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
            long curTime = System.currentTimeMillis();
            if (curTime - prevTime > 1000L || curRand == -1) {
                curRand = MainRegistry.Rnd.nextInt(4);
            }
            prevTime = curTime;
            return String.format("%s_%d_%d", getUnlocalizedName(), stack.getItemDamage(), curRand);
        } else {
            return super.getUnlocalizedName(stack);
        }
    }

    public IIcon[] icons = new IIcon[2];

    @Override
    public void registerIcons(IIconRegister reg) {
        for (int i = 0; i < 2; i++) {
            icons[i] = reg.registerIcon(String.format("%s:item%s_%d", Refstrings.MODID, _mItemName, i));
        }
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        return icons[meta];
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int i = 0; i < 2; i++) {
            list.add(new ItemStack(item, 1, i));
        }
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
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {

    }

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
    public void addInformation(ItemStack pItemStack, EntityPlayer pWorld, List list, boolean par4) {
        createOrInitNBTTag(pItemStack);

        list.add("Protecting your fingers since 1890");
        list.add(String.format("Durability: %d/%d", getNBTDurability(pItemStack), MaxDurability));
        if (pItemStack.stackTagCompound.getInteger(NBTTAG_DURABILITY) <= 1) {
            list.add("This glove is too damaged to protect you. You need to repair it");
        }
    }

    private void createOrInitNBTTag(ItemStack pItemStack) {
        if (pItemStack.stackTagCompound == null) {
            pItemStack.setTagCompound(new NBTTagCompound());
            pItemStack.stackTagCompound.setInteger(NBTTAG_DURABILITY, MaxDurability);
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
            for (int i = 0; i < stackList.length; i++) {
                ItemStack stack = stackList[i];
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
