package com.dreammaster.tinkersConstruct.worldgen;

import net.minecraft.block.Block;

import mantle.blocks.abstracts.MultiItemBlock;

public class ZincGravelOreItem extends MultiItemBlock {

    public static final String[] blockTypes = { "zinc" };

    public ZincGravelOreItem(Block b) {
        super(b, "block.ore.gravel", blockTypes);
        setMaxDamage(0);
        setHasSubtypes(false);
    }
}
