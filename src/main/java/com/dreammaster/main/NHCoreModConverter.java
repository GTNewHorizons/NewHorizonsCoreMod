package com.dreammaster.main;

import net.minecraft.item.ItemStack;

import com.gtnewhorizons.postea.api.ItemStackReplacementManager;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;

public class NHCoreModConverter {

    public static void doPostInitialization() {
        final ItemStack arditeSawBlade = MaterialLibAPI.getStack(Materials.Ardite, Shapes.toolHeadSaw, 1);
        final ItemStack manyullynSawBlade = MaterialLibAPI.getStack(Materials.Manyullyn, Shapes.toolHeadSaw, 1);

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
