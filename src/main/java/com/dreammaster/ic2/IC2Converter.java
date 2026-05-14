package com.dreammaster.ic2;

import net.minecraft.item.Item;

import com.gtnewhorizons.postea.api.ItemStackReplacementManager;

import gregtech.api.GregTechAPI;
import gregtech.api.enums.MetaTileEntityIDs;
import gregtech.api.enums.Mods;

public class IC2Converter {

    // not using the mods version since IC2 depreciation will likely mean the removal of this field from the Mods class
    // down the line.
    public static final String IC2_MOD_ID = Mods.IndustrialCraft2.ID;

    public static void doPostInitialization() {
        replace1VoltSolarPanel();
    }

    private static void replace1VoltSolarPanel() {
        ItemStackReplacementManager.addSimpleReplacement(
                IC2_MOD_ID + ":blockGenerator",
                3,
                Item.getItemFromBlock(GregTechAPI.sBlockMachines),
                MetaTileEntityIDs.SOLAR_PANEL_ULV.ID,
                true);
    }
}
