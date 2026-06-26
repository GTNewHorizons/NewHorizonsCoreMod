package com.dreammaster.block;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

public class ZincGravelOre extends BlockFalling {

    public ZincGravelOre() {
        super(Material.craftedSnow);
        this.setStepSound(soundTypeGravel);
        this.setHardness(3f);
        this.setHarvestLevel("shovel", 1, 0);
    }

}
