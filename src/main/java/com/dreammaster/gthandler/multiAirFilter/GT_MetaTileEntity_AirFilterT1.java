package com.dreammaster.gthandler.multiAirFilter;

import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;

/**
 * Created by danie_000 on 03.10.2016.
 */
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
}
