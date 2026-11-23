package com.dreammaster.detrav;

import com.ruling_0.materiallib.api.Material;
import com.ruling_0.materiallib.api.MaterialLibAPI;
import com.ruling_0.materiallib.api.MaterialRegistrationEvent;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import detrav.items.DetravMetaGeneratedTool01;
import gregtech.api.enums.Circuits;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.material.GTMaterialFlag;
import gregtech.api.material.MaterialUtils;
import gregtech.api.util.GTModHandler;

/// Crafting recipes for the LuV to UHV Detrav prospectors, one set per drill-head material.
public class ScannerTools {

    /// Runs after GregTech declares its shapes.
    @SubscribeEvent(priority = EventPriority.LOW)
    public void materialRegistration(MaterialRegistrationEvent event) {
        MaterialLibAPI.registerPostInitShapeConsumer(
                "dreamcraft",
                Shapes.toolHeadDrill,
                (shape, material) -> {
                    if (!MaterialUtils.hasFlag(material, GTMaterialFlag.NO_RECIPES)) addRecipes(material);
                });
    }

    private static void addRecipes(Material material) {
        GTModHandler.addCraftingRecipe(
                DetravMetaGeneratedTool01.INSTANCE.getToolWithStats(
                        100,
                        1,
                        material,
                        Materials.Iridium,
                        new long[] { 102400000L, GTValues.V[6], 6L, -1L }),
                GTModHandler.RecipeBits.DO_NOT_CHECK_FOR_COLLISIONS | GTModHandler.RecipeBits.BUFFERED,
                new Object[] { "EHR", "CSC", "PBP", 'S', ItemList.Cover_Screen, 'R', ItemList.Sensor_LuV, 'H',
                        OrePrefixes.toolHeadDrill.ingredient(material), 'E', ItemList.Emitter_LuV, 'C',
                        Circuits.LuV.getIngredient(), 'P', OrePrefixes.plate.ingredient(Materials.Iridium), 'B',
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
                        OrePrefixes.toolHeadDrill.ingredient(material), 'E', ItemList.Emitter_ZPM, 'C',
                        Circuits.ZPM.getIngredient(), 'P', OrePrefixes.plate.ingredient(Materials.Osmium), 'B',
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
                        OrePrefixes.toolHeadDrill.ingredient(material), 'E', ItemList.Emitter_UV, 'C',
                        Circuits.UV.getIngredient(), 'P', OrePrefixes.plate.ingredient(Materials.Neutronium), 'B',
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
                        OrePrefixes.toolHeadDrill.ingredient(material), 'E', ItemList.Emitter_UHV, 'C',
                        Circuits.UHV.getIngredient(), 'P', OrePrefixes.plate.ingredient(Materials.Infinity), 'B',
                        ItemList.BatteryHull_UHV_Full.get(1L) });
    }
}
