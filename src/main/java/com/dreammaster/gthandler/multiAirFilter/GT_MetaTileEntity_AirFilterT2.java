package com.dreammaster.gthandler.multiAirFilter;

import com.dreammaster.main.MainRegistry;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.util.GT_Recipe;

public class GT_MetaTileEntity_AirFilterT2 extends GT_MetaTileEntity_AirFilterBase {

    public GT_MetaTileEntity_AirFilterT2(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
        multiTier = 2;
    }

    public GT_MetaTileEntity_AirFilterT2(String aName) {
        super(aName);
        multiTier = 2;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_MetaTileEntity_AirFilterT2(mName);
    }

    @Override
    public GT_Recipe getRecipe() {
        return tRecipeT2;
    }

    @Override
    public float getBonusByTier() {
        return MainRegistry.CoreConfig.bonusByTierT2;
    }

    @Override
    public int getCasingIndex() {
        return 59;
    }

    @Override
    public int getPipeMeta() {
        return 4;
    }

    @Override
    public int getCasingMeta() {
        return 3;
    }
}
