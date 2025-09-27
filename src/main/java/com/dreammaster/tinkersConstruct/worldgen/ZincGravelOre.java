package com.dreammaster.tinkersConstruct.worldgen;

import java.util.List;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ZincGravelOre extends BlockSand {

    public IIcon icon;

    public ZincGravelOre() {
        this.blockMaterial = Material.craftedSnow;
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(soundTypeGravel);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.icon = iconRegister.registerIcon("dreamcraft:ore_zinc_gravel");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return this.icon;
    }

    public float getBlockHardness(World world, int x, int y, int z) {
        return 3f;
    }

    @Override
    public void getSubBlocks(Item id, CreativeTabs tab, List<ItemStack> list) {
        list.add(new ItemStack(this, 1, 0));
    }
}
