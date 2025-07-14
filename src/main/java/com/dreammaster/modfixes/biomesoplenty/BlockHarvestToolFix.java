package com.dreammaster.modfixes.biomesoplenty;

import net.minecraft.block.Block;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.Mods;

public class BlockHarvestToolFix {

    public static void fixBOPHarvestTools() {
        Block flesh = GameRegistry.findBlock(Mods.ModIDs.BIOMES_O_PLENTY, "flesh");
        if (flesh != null) {
            flesh.setHarvestLevel("shovel", 0);
        }
    }

}
