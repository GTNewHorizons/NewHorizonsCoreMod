package com.dreammaster.baubles;

import java.util.List;
import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;

import com.dreammaster.lib.Refstrings;
import com.dreammaster.main.NHItems;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import baubles.common.container.InventoryBaubles;
import baubles.common.lib.PlayerHandler;
import eu.usrv.yamcore.iface.IExtendedModItem;

public final class WitherProtectionRing extends Item implements IBauble, IExtendedModItem<WitherProtectionRing> {

    Random _mRnd = new Random();

    private final String _mItemName;
    private final String _mCreativeTab;

    @Override
    public WitherProtectionRing getConstructedItem() {
        return NHItems.WITHER_PROTECTION_RING.get();
    }

    @Override
    public String getCreativeTabName() {
        return _mCreativeTab;
    }

    @Override
    public String getUnlocalizedNameForRegistration() {
        return super.getUnlocalizedName();
    }

    public WitherProtectionRing(String pItemName, String pCreativeTab) {
        _mItemName = pItemName;
        _mCreativeTab = pCreativeTab;

        super.setTextureName(String.format("%s:item%s", Refstrings.MODID, _mItemName));
        super.setUnlocalizedName(_mItemName);
        super.setMaxDamage(0);
        super.setHasSubtypes(false);
    }

    private static final long prevTime = Long.MIN_VALUE;
    private static final int curRand = -1;

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName(stack);
    }

    public IIcon icon;

    @Override
    public void registerIcons(IIconRegister reg) {
        icon = reg.registerIcon(String.format("%s:item%s", Refstrings.MODID, _mItemName));
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        return icon;
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item, 1, 0));
    }

    @Override
    public boolean canEquip(ItemStack arg0, EntityLivingBase arg1) {
        return true;
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
    public void onEquipped(ItemStack arg0, EntityLivingBase arg1) {}

    @Override
    public void onUnequipped(ItemStack arg0, EntityLivingBase pEntityBase) {}

    // ------------------ NBT Start
    @Override
    public void addInformation(ItemStack pItemStack, EntityPlayer pWorld, List list, boolean par4) {
        list.add(
                String.format(
                        "%s%sFinally, a way to get rid of the nasty withering effect.",
                        EnumChatFormatting.GREEN,
                        EnumChatFormatting.ITALIC));
        list.add(
                String.format(
                        "%s%sNow it's time to get some Stars!",
                        EnumChatFormatting.GREEN,
                        EnumChatFormatting.ITALIC));
    }

    @Override
    public void onWornTick(ItemStack arg0, EntityLivingBase pEntity) {
        if (!(pEntity instanceof EntityPlayer)) {
            return;
        }

        if (_mRnd.nextInt(20) == 0) {
            EntityPlayer tPlayer = (EntityPlayer) pEntity;
            InventoryBaubles tBaubles = PlayerHandler.getPlayerBaubles(tPlayer);

            Potion tPot = Potion.wither;
            if (tPlayer.isPotionActive(tPot)) {
                tPlayer.removePotionEffect(tPot.id);
            }
        }
    }
}
