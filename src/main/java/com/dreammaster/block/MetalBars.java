package com.dreammaster.block;

import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

public class MetalBars extends BlockPane {

    public MetalBars(String texture) {
        super("dreamcraft:block" + texture, "dreamcraft:block" + texture, Material.iron, true);
    }
}
