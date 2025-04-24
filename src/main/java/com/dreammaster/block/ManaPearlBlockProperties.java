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
public class ManaPearlBlockProperties implements IExtendedBlockProperties {

    @Override
    public Material getMaterial() {
        return Material.glass;
    }

    @Override
    public boolean getUnbreakable() {
        return false;
    }

    @Override
    public int getHarvestLevel() {
        return 1;
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
        return 2;
    }

    @Override
    public float getResistance() {
        return 30.0F;
    }

    @Override
    public String getBlockName() {
        return "ManaPearl";
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
        return Block.soundTypeGlass;
    }

    @Override
    public boolean getIsOpaqueCube() {
        return true;
    }
}
