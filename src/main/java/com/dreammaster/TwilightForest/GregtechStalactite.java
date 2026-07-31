package com.dreammaster.TwilightForest;

import net.minecraft.world.World;

import com.ruling_0.materiallib.api.Material;

import gregtech.api.enums.StoneType;
import gregtech.api.material.MU;
import gregtech.common.ores.OreManager;
import twilightforest.world.TFGenCaveStalactite;

class GregtechStalactite extends TFGenCaveStalactite {

    private final Material material;

    public GregtechStalactite(Material material, float size, int maxLength, int minHeight) {
        super(null, size, maxLength, minHeight);
        this.material = material;
    }

    @Override
    protected void placeStalactiteBlock(World world, int x, int y, int z) {
        OreManager.setOreForWorldGen(world, x, y, z, StoneType.Stone, MU.materialOf(material), false);
    }
}
