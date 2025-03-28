package com.dreammaster.common.block;

import com.dreammaster.common.tile.TileGlobe;
import com.dreammaster.lib.Refstrings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlockGlobe extends Block {

    public BlockGlobe() {
        super(Material.iron);
        this.setHardness(10F);
        this.setResistance(20f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockName("globe");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Refstrings.MODID + ":transparency");
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean canRenderInPass(int a) {
        return true;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileGlobe();
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack item) {
        super.onBlockPlacedBy(world, x, y, z, placer, item);
        if (!item.hasDisplayName()) return;
        if (!(world.getTileEntity(x, y, z) instanceof TileGlobe globe)) return;

        globe.setName(item.getDisplayName());
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side,
                                    float subX, float subY, float subZ) {
        TileGlobe tile = (TileGlobe) world.getTileEntity(x, y, z);

        if (player.isSneaking()) {
            tile.incrementSize();
        } else {
            tile.increaseRotationSpeed();
        }

        if (!world.isRemote) {
            player.addChatComponentMessage(new ChatComponentText("Rotation Speed:" + tile.getRotationSpeed()));
            player.addChatComponentMessage(new ChatComponentText("Size: " + tile.getSize()));
        }

        return true;
    }
}