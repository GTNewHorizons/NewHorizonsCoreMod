package com.dreammaster.modess;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockEldritchElementalSplitter extends Block implements ITileEntityProvider {
    protected BlockEldritchElementalSplitter() {
        super(Material.iron);
        this.setHardness(3.0F);
        this.setResistance(17.0F);
        this.setStepSound(Block.soundTypeMetal);
        this.setBlockBounds(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TEESS();
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return Blocks.stone.getIcon(side, meta);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
