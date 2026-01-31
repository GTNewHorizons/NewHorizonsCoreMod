package com.dreammaster.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DiamondFrameBox extends Block {

    public DiamondFrameBox() {
        super(Material.iron);
        setHardness(25f);
        setHarvestLevel("pickaxe", 3);
        setLightOpacity(1);
        setStepSound(Block.soundTypeMetal);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
