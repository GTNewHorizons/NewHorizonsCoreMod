package com.dreammaster.gthandler.multiAirFilter;

import com.dreammaster.main.MainRegistry;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.util.GT_Recipe;

public class GT_MetaTileEntity_AirFilterT3 extends GT_MetaTileEntity_AirFilterBase {

    public GT_MetaTileEntity_AirFilterT3(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional);
        multiTier = 3;
    }

    public GT_MetaTileEntity_AirFilterT3(String aName) {
        super(aName);
        multiTier = 3;
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_MetaTileEntity_AirFilterT3(mName);
    }

    @Override
    public GT_Recipe getRecipe() {
        return tRecipeT3;
    }

    @Override
    public float getBonusByTier() {
        return MainRegistry.CoreConfig.bonusByTierT3;
    }

    @Override
    public int getCasingIndex() {
        return 60;
    }

    @Override
    public int getPipeMeta() {
        return 6;
    }

    @Override
    public int getCasingMeta() {
        return 5;
    }
}
