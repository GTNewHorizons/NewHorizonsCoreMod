package com.dreammaster.biomesoplenty;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.util.IIcon;

import biomesoplenty.BiomesOPlenty;
import biomesoplenty.api.content.BOPCBlocks;

public class BlockBOPFenceGate extends BlockFenceGate {

    private final int woodType;

    public BlockBOPFenceGate(String type) {
        super();
        this.setCreativeTab(BiomesOPlenty.tabBiomesOPlenty);
        woodType = BOPWoodTypes.valueOf(type).ordinal();
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return BOPCBlocks.planks.getIcon(side, woodType);
    }
}
