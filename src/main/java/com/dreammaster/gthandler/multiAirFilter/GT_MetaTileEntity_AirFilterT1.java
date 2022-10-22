package com.dreammaster.gthandler.multiAirFilter;

import com.dreammaster.main.MainRegistry;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.util.GT_Recipe;

public class GT_MetaTileEntity_AirFilterT1 extends GT_MetaTileEntity_AirFilterBase {

    public GT_MetaTileEntity_AirFilterT1(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
        multiTier = 1;
    }

    public GT_MetaTileEntity_AirFilterT1(String aName) {
        super(aName);
        multiTier = 1;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_MetaTileEntity_AirFilterT1(mName);
    }

    @Override
    public GT_Recipe getRecipe() {
        return tRecipeT1;
    }

    @Override
    public float getBonusByTier() {
        return MainRegistry.CoreConfig.bonusByTierT1;
    }

    @Override
    public int getCasingIndex() {
        return 57;
    }

    @Override
    public int getPipeMeta() {
        return 1;
    }

    @Override
    public int getCasingMeta() {
        return 0;
    }
}
