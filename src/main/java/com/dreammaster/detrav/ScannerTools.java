package com.dreammaster.detrav;

import net.minecraft.item.ItemStack;

import detrav.items.DetravMetaGeneratedTool01;
import gregtech.api.enums.Circuits;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.interfaces.IOreRecipeRegistrator;
import gregtech.api.material.MU;
import gregtech.api.util.GTModHandler;

public class ScannerTools implements IOreRecipeRegistrator {

    public ScannerTools() {
        OrePrefixes.toolHeadDrill.add(this);
    }

    public void registerOre(OrePrefixes o, Materials material, String s, String s2, ItemStack i) {
        GTModHandler.addCraftingRecipe(
                DetravMetaGeneratedTool01.INSTANCE.getToolWithStats(
                        100,
                        1,
                        material,
                        Materials.Iridium,
                        new long[] { 102400000L, GTValues.V[6], 6L, -1L }),
                GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GTModHandler.RecipeBits.BUFFERED,
                new Object[] { "EHR", "CSC", "PBP", 'S', ItemList.Cover_Screen, 'R', ItemList.Sensor_LuV, 'H',
                        OrePrefixes.toolHeadDrill.get(material), 'E', ItemList.Emitter_LuV, 'C',
                        Circuits.LuV.getIngredient(), 'P',
                        MU.craftIngredient(OrePrefixes.plate, Materials2Materials.Iridium), 'B',
                        ItemList.BatteryHull_LuV_Full.get(1L) });
        GTModHandler.addCraftingRecipe(
                DetravMetaGeneratedTool01.INSTANCE.getToolWithStats(
                        102,
                        1,
                        material,
                        Materials.Osmium,
                        new long[] { 409600000L, GTValues.V[7], 7L, -1L }),
                GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GTModHandler.RecipeBits.BUFFERED,
                new Object[] { "EHR", "CSC", "PBP", 'S', ItemList.Cover_Screen, 'R', ItemList.Sensor_ZPM, 'H',
                        OrePrefixes.toolHeadDrill.get(material), 'E', ItemList.Emitter_ZPM, 'C',
                        Circuits.ZPM.getIngredient(), 'P',
                        MU.craftIngredient(OrePrefixes.plate, Materials2Materials.Osmium), 'B',
                        ItemList.BatteryHull_ZPM_Full.get(1L) });
        GTModHandler.addCraftingRecipe(
                DetravMetaGeneratedTool01.INSTANCE.getToolWithStats(
                        104,
                        1,
                        material,
                        Materials.Neutronium,
                        new long[] { 1638400000L, GTValues.V[8], 8L, -1L }),
                GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GTModHandler.RecipeBits.BUFFERED,
                new Object[] { "EHR", "CSC", "PBP", 'S', ItemList.Cover_Screen, 'R', ItemList.Sensor_UV, 'H',
                        OrePrefixes.toolHeadDrill.get(material), 'E', ItemList.Emitter_UV, 'C',
                        Circuits.UV.getIngredient(), 'P',
                        MU.craftIngredient(OrePrefixes.plate, Materials2Materials.Neutronium), 'B',
                        ItemList.BatteryHull_UV_Full.get(1L) });
        GTModHandler.addCraftingRecipe(
                DetravMetaGeneratedTool01.INSTANCE.getToolWithStats(
                        106,
                        1,
                        material,
                        Materials.Infinity,
                        new long[] { 6553600000L, GTValues.V[9], 9L, -1L }),
                GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GTModHandler.RecipeBits.BUFFERED,
                new Object[] { "EHR", "CSC", "PBP", 'S', ItemList.Cover_Screen, 'R', ItemList.Sensor_UHV, 'H',
                        OrePrefixes.toolHeadDrill.get(material), 'E', ItemList.Emitter_UHV, 'C',
                        Circuits.UHV.getIngredient(), 'P',
                        MU.craftIngredient(OrePrefixes.plate, Materials2Materials.Infinity), 'B',
                        ItemList.BatteryHull_UHV_Full.get(1L) });
    }
}
