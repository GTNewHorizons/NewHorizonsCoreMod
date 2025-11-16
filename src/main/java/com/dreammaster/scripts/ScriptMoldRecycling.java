package com.dreammaster.scripts;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.item.NHItemList;

import ggfab.GGItemList;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.objects.ItemData;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;

public class ScriptMoldRecycling implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Molds and Shapes recycling";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.emptyList();
    }

    @Override
    public void loadRecipes() {
        // Coremod molds
        Stream.of(
                CustomItemList.MoldHelmet,
                CustomItemList.MoldChestplate,
                CustomItemList.MoldLeggings,
                CustomItemList.MoldBoots,
                CustomItemList.MarshmallowForm).forEach(
                        item -> GTOreDictUnificator
                                .addItemData(item.get(1L), new ItemData(Materials.Steel, 4 * GTValues.M)));
        // GT5 Shapes and Molds
        Stream.of(
                ItemList.Shape_Empty,
                ItemList.Shape_Mold_Bottle,
                ItemList.Shape_Mold_Plate,
                ItemList.Shape_Mold_Ingot,
                ItemList.Shape_Mold_Casing,
                ItemList.Shape_Mold_Gear,
                ItemList.Shape_Mold_Gear_Small,
                ItemList.Shape_Mold_Credit,
                ItemList.Shape_Mold_Nugget,
                ItemList.Shape_Mold_Block,
                ItemList.Shape_Mold_Ball,
                ItemList.Shape_Mold_Bun,
                ItemList.Shape_Mold_Bread,
                ItemList.Shape_Mold_Baguette,
                ItemList.Shape_Mold_Cylinder,
                ItemList.Shape_Mold_Anvil,
                ItemList.Shape_Mold_Arrow,
                ItemList.Shape_Mold_Name,
                ItemList.Shape_Mold_Rod,
                ItemList.Shape_Mold_Bolt,
                ItemList.Shape_Mold_Round,
                ItemList.Shape_Mold_Screw,
                ItemList.Shape_Mold_Ring,
                ItemList.Shape_Mold_Rod_Long,
                ItemList.Shape_Mold_Rotor,
                ItemList.Shape_Mold_Turbine_Blade,
                ItemList.Shape_Mold_Pipe_Tiny,
                ItemList.Shape_Mold_Pipe_Small,
                ItemList.Shape_Mold_Pipe_Medium,
                ItemList.Shape_Mold_Pipe_Large,
                ItemList.Shape_Mold_Pipe_Huge,
                ItemList.Shape_Mold_ToolHeadDrill,
                ItemList.Shape_Extruder_Bottle,
                ItemList.Shape_Extruder_Plate,
                ItemList.Shape_Extruder_Cell,
                ItemList.Shape_Extruder_Ring,
                ItemList.Shape_Extruder_Rod,
                ItemList.Shape_Extruder_Wire,
                ItemList.Shape_Extruder_Bolt,
                ItemList.Shape_Extruder_Ingot,
                ItemList.Shape_Extruder_Small_Gear,
                ItemList.Shape_Extruder_Gear,
                ItemList.Shape_Extruder_Casing,
                ItemList.Shape_Extruder_Pipe_Tiny,
                ItemList.Shape_Extruder_Pipe_Small,
                ItemList.Shape_Extruder_Pipe_Medium,
                ItemList.Shape_Extruder_Pipe_Large,
                ItemList.Shape_Extruder_Pipe_Huge,
                ItemList.Shape_Extruder_Block,
                ItemList.Shape_Extruder_Sword,
                ItemList.Shape_Extruder_Pickaxe,
                ItemList.Shape_Extruder_Shovel,
                ItemList.Shape_Extruder_Axe,
                ItemList.Shape_Extruder_Hoe,
                ItemList.Shape_Extruder_Hammer,
                ItemList.Shape_Extruder_File,
                ItemList.Shape_Extruder_Saw,
                ItemList.Shape_Extruder_Rotor,
                ItemList.Shape_Extruder_Turbine_Blade,
                ItemList.Shape_Extruder_ToolHeadDrill).forEach(
                        item -> GTOreDictUnificator
                                .addItemData(item.get(1L), new ItemData(Materials.Steel, 4 * GTValues.M)));
        // GT++ Pellet Shape
        GTOreDictUnificator
                .addItemData(GregtechItemList.Pellet_Mold.get(1L), new ItemData(Materials.Steel, 4 * GTValues.M));
        // Boat Shape
        GTOreDictUnificator
                .addItemData(NHItemList.ExtruderShapeBoat.getIS(1), new ItemData(Materials.Steel, 4 * GTValues.M));
        // GGfab Single use molds
        Stream.of(
                GGItemList.SingleUseFileMold,
                GGItemList.SingleUseWrenchMold,
                GGItemList.SingleUseCrowbarMold,
                GGItemList.SingleUseWireCutterMold,
                GGItemList.SingleUseHardHammerMold,
                GGItemList.SingleUseSoftMalletMold,
                GGItemList.SingleUseScrewdriverMold,
                GGItemList.SingleUseSawMold).forEach(
                        item -> GTOreDictUnificator
                                .addItemData(item.get(1L), new ItemData(Materials.Steel, 4 * GTValues.M)));

    }
}
