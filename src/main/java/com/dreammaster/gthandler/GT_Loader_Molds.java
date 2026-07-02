package com.dreammaster.gthandler;

import com.dreammaster.item.NHItemList;

import gtPlusPlus.xmod.gregtech.api.metatileentity.implementations.MTEHatchSolidifier;

public class GT_Loader_Molds {

    public static void run() {
        MTEHatchSolidifier.solidifierMolds.add(NHItemList.MoldHelmet.get());
        MTEHatchSolidifier.solidifierMolds.add(NHItemList.MoldChestplate.get());
        MTEHatchSolidifier.solidifierMolds.add(NHItemList.MoldLeggings.get());
        MTEHatchSolidifier.solidifierMolds.add(NHItemList.MoldBoots.get());
    }
}
