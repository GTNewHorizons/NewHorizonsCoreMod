package com.dreammaster.main;

import net.minecraft.item.ItemStack;

import com.gtnewhorizons.postea.api.ItemStackReplacementManager;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

public class NHCoreModConverter {

    public static void doPostInitialization() {
        final ItemStack arditeSawBlade = GTOreDictUnificator.get(OrePrefixes.toolHeadSaw, Materials.Ardite, 1L);
        final ItemStack manyullynSawBlade = GTOreDictUnificator.get(OrePrefixes.toolHeadSaw, Materials.Manyullyn, 1L);

        ItemStackReplacementManager.ignoreMissingMapping("dreamcraft:SawBladeArdite");
        ItemStackReplacementManager.addSimpleReplacement("dreamcraft:SawBladeArdite", arditeSawBlade, true);
        ItemStackReplacementManager.ignoreMissingMapping("dreamcraft:item.SawBladeArdite");
        ItemStackReplacementManager.addSimpleReplacement("dreamcraft:item.SawBladeArdite", arditeSawBlade, true);

        ItemStackReplacementManager.ignoreMissingMapping("dreamcraft:SawBladeManyullyn");
        ItemStackReplacementManager.addSimpleReplacement("dreamcraft:SawBladeManyullyn", manyullynSawBlade, true);
        ItemStackReplacementManager.ignoreMissingMapping("dreamcraft:item.SawBladeManyullyn");
        ItemStackReplacementManager.addSimpleReplacement("dreamcraft:item.SawBladeManyullyn", manyullynSawBlade, true);
    }
}
