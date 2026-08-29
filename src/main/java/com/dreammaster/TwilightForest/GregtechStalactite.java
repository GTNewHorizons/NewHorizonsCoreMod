package com.dreammaster.TwilightForest;

import net.minecraft.world.World;

import gregtech.api.enums.Materials;
import gregtech.api.enums.StoneType;
import gregtech.common.ores.OreManager;
import twilightforest.world.TFGenCaveStalactite;

class GregtechStalactite extends TFGenCaveStalactite {

    private final Materials material;

    public GregtechStalactite(Materials material, float size, int maxLength, int minHeight) {
        super(null, size, maxLength, minHeight);
        this.material = material;
    }

    @Override
    protected void placeStalactiteBlock(World world, int x, int y, int z) {
        OreManager.setOreForWorldGen(world, x, y, z, StoneType.Stone, material, false);
    }
}
