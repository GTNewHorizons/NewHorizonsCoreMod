package com.dreammaster.gthandler.multiAirFilter;

import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;

public class GT_MetaTileEntity_AirFilterT3 extends GT_MetaTileEntity_AirFilterBase{

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
}