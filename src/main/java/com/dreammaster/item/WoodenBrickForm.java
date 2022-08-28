package com.dreammaster.item;

import com.dreammaster.lib.Refstrings;
import com.dreammaster.main.NHItems;
import eu.usrv.yamcore.iface.IExtendedModItem;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WoodenBrickForm extends Item implements IExtendedModItem<WoodenBrickForm> {
    public static final Logger LOGGER = LogManager.getLogger();
    private static final String NBTTAG_DURABILITY = "Durability";

    private final String _mCreativeTab;
    private final String _mItemName;
    private static final int maxDurability = 100;

    @Override
    public WoodenBrickForm getConstructedItem() {
        return NHItems.WOODEN_BRICK_FORM.get();
    }

    @Override
    public String getUnlocalizedNameForRegistration() {
        return super.getUnlocalizedName();
    }

    @Override
    public String getCreativeTabName() {
        return _mCreativeTab;
    }

    public WoodenBrickForm(String pItemName, String pCreativeTab) {
        _mItemName = pItemName;
        _mCreativeTab = pCreativeTab;

        super.setTextureName(String.format("%s:item%s", Refstrings.MODID, _mItemName));
        super.setUnlocalizedName(_mItemName);
        super.setMaxDamage(maxDurability);
        super.setHasSubtypes(true);
    }

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
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
        return false;
    }

    @Deprecated
    @Override
    public boolean hasContainerItem() {
        return true;
    }

    // ------------------ NBT Start
    @Override
    public void onCreated(ItemStack pItemStack, World pWorld, EntityPlayer pEntityPlayer) {
        createOrInitNBTTag(pItemStack);
    }

    private int getNBTDurability(ItemStack pItemStack) {
        createOrInitNBTTag(pItemStack);
        return pItemStack.stackTagCompound.getInteger(NBTTAG_DURABILITY);
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        ItemStack ret = stack.copy().splitStack(1);
        int tCurrentDura = getNBTDurability(ret);
        if (tCurrentDura > 0) {
            ret.stackTagCompound.setInteger(NBTTAG_DURABILITY, --tCurrentDura);
            ret.setItemDamage(maxDurability - getNBTDurability(ret));
            return ret;
        } else return null;
    }

    private void createOrInitNBTTag(ItemStack pItemStack) {
        if (pItemStack.stackTagCompound == null) {
            pItemStack.setTagCompound(new NBTTagCompound());
            pItemStack.stackTagCompound.setInteger(NBTTAG_DURABILITY, maxDurability);
        }
    }
}
