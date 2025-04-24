package com.dreammaster.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import eu.usrv.yamcore.iface.IExtendedBlockProperties;

/**
 * This is the helper class to define extended properties for your block. If you decide to use it, you *MUST* define
 * every value or it will not register properly or may even crash.
 * 
 * @author Namikon
 *
 */
public class GaiaBlockProperties implements IExtendedBlockProperties {

    @Override
    public Material getMaterial() {
        return Material.rock;
    }

    @Override
    public boolean getUnbreakable() {
        return false;
    }

    @Override
    public int getHarvestLevel() {
        return 6;
    }

    @Override
    public int getOpacity() {
        return 100;
    }

    @Override
    public float getHardness() {
        return 50.0F;
    }

    @Override
    public float getLightLevel() {
        return 8;
    }

    @Override
    public float getResistance() {
        return 30.0F;
    }

    @Override
    public String getBlockName() {
        return "Gaia";
    }

    @Override
    public String getTextureName() {
        return "";
    }

    @Override
    public String getHarvestToolClass() {
        return "pickaxe";
    }

    @Override
    public Block.SoundType getStepSound() {
        return Block.soundTypeMetal;
    }

    @Override
    public boolean getIsOpaqueCube() {
        return true;
    }
}
