package com.dreammaster.biomesoplenty;

import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;

import biomesoplenty.BiomesOPlenty;

public class BlockBOPFence extends BlockFence {

    public BlockBOPFence(String type) {
        super(type.equals("bamboothatching") ? "biomesoplenty:" + type : "biomesoplenty:plank_" + type, Material.wood);
        this.setCreativeTab(BiomesOPlenty.tabBiomesOPlenty);
    }

}
