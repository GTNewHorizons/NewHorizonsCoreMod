package com.dreammaster.ic2;

import java.util.Objects;

import net.minecraft.item.Item;

import com.gtnewhorizons.postea.api.ItemStackReplacementManager;

import gregtech.api.GregTechAPI;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.MetaTileEntityIDs;
import gregtech.api.enums.Mods;

public class IC2Converter {

    // not using the mods version since IC2 depreciation will likely mean the removal of this field from the Mods class
    // down the line.
    public static final String IC2_MOD_ID = Mods.IndustrialCraft2.ID;

    public static void doPostInitialization() {
        replace1VoltSolarPanel();
        replaceIC2Credits();
    }

    private static void replace1VoltSolarPanel() {
        ItemStackReplacementManager.addSimpleReplacement(
                IC2_MOD_ID + ":blockGenerator",
                3,
                Item.getItemFromBlock(GregTechAPI.sBlockMachines),
                MetaTileEntityIDs.SOLAR_PANEL_ULV.ID,
                true);
    }

    private static void replaceIC2Credits() {
        ItemStackReplacementManager.addSimpleReplacement(
                IC2_MOD_ID + ":itemCoin",
                0,
                Objects.requireNonNull(ItemList.Credit_Greg_Cupronickel.get(1L).getItem()),
                ItemList.Credit_Greg_Cupronickel.get(1L).getItemDamage(),
                true);
    }
}
