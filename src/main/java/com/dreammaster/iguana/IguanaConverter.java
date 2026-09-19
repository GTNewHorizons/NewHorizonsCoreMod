package com.dreammaster.iguana;

import com.gtnewhorizons.postea.api.ItemStackReplacementManager;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

public class IguanaConverter {

    public static void doPostInitialization() {
        ItemStackReplacementManager.ignoreMissingMapping("dreamcraft:SawBladeArdite");
        ItemStackReplacementManager.addSimpleReplacement(
                "dreamcraft:SawBladeArdite",
                GTOreDictUnificator.get(OrePrefixes.toolHeadSaw, Materials.Ardite, 1L),
                true);

        ItemStackReplacementManager.ignoreMissingMapping("dreamcraft:SawBladeManyullyn");
        ItemStackReplacementManager.addSimpleReplacement(
                "dreamcraft:SawBladeManyullyn",
                GTOreDictUnificator.get(OrePrefixes.toolHeadSaw, Materials.Manyullyn, 1L),
                true);
    }
}
