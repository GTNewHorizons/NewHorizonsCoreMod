package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.BuildCraftSilicon;
import static gregtech.api.enums.Mods.ProjectRedCore;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gtPlusPlus.core.material.MaterialsAlloy;

public class FormingPressRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder()
                .itemInputs(CustomItemList.MalformedSlush.get(2L), CustomItemList.MarshmallowForm.get(0L))
                .itemOutputs(CustomItemList.UncookedSlush.get(1L)).duration(60 * SECONDS).eut(TierEU.RECIPE_IV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), CustomItemList.MarshmallowForm.get(0L))
                .itemOutputs(CustomItemList.MarshmallowForm.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.MicaBasedPulp.get(4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Asbestos, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(CustomItemList.MicaBasedSheet.get(4L)).duration(20 * SECONDS).eut(28)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.MicaBasedPulp.get(16L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Asbestos, 1L),
                        ItemList.Shape_Mold_Plate.get(0L),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(CustomItemList.MicaBasedSheet.get(16L)).duration(20 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Plate.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Plate.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Casing.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Casing.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Gear.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Gear.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Credit.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Credit.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Bottle.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Bottle.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Ingot.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Ball.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Block.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Nugget.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Nugget.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Bun.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Bun.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Bread.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Bread.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Baguette.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Baguette.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Cylinder.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Cylinder.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Anvil.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Anvil.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Name.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Name.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Arrow.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Arrow.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Gear_Small.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Gear_Small.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Rod.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Rod.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Bolt.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Bolt.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Round.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Round.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Screw.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Screw.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Ring.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Ring.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Rod_Long.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Rod_Long.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Rotor.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Rotor.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Turbine_Blade.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Turbine_Blade.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Pipe_Tiny.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Pipe_Tiny.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Pipe_Small.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Pipe_Small.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Pipe_Medium.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Pipe_Medium.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Pipe_Large.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Pipe_Large.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_Pipe_Huge.get(0L))
                .itemOutputs(ItemList.Shape_Mold_Pipe_Huge.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), CustomItemList.MoldHelmet.get(0L))
                .itemOutputs(CustomItemList.MoldHelmet.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), CustomItemList.MoldChestplate.get(0L))
                .itemOutputs(CustomItemList.MoldChestplate.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), CustomItemList.MoldLeggings.get(0L))
                .itemOutputs(CustomItemList.MoldLeggings.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), CustomItemList.MoldBoots.get(0L))
                .itemOutputs(CustomItemList.MoldBoots.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Mold_ToolHeadDrill.get(0L))
                .itemOutputs(ItemList.Shape_Mold_ToolHeadDrill.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Plate.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Plate.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Rod.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Rod.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Bolt.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Bolt.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Ring.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Ring.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Cell.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Cell.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Ingot.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Ingot.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Wire.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Wire.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Casing.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Casing.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Pipe_Tiny.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Pipe_Tiny.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Pipe_Small.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Pipe_Small.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Pipe_Medium.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Pipe_Medium.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Pipe_Large.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Pipe_Large.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Pipe_Huge.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Pipe_Huge.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Block.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Block.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Sword.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Sword.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Pickaxe.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Pickaxe.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Shovel.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Shovel.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Axe.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Axe.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Hoe.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Hoe.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Hammer.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Hammer.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_File.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_File.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Saw.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Saw.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Gear.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Gear.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Bottle.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Bottle.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Rotor.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Rotor.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Small_Gear.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Small_Gear.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_Turbine_Blade.get(0L))
                .itemOutputs(ItemList.Shape_Extruder_Turbine_Blade.get(1L)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Shape_Empty.get(1L), com.dreammaster.item.ItemList.ExtruderShapeBoat.getIS(0))
                .itemOutputs(com.dreammaster.item.ItemList.ExtruderShapeBoat.getIS(1)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Empty.get(1L), ItemList.Shape_Extruder_ToolHeadDrill.get(0))
                .itemOutputs(ItemList.Shape_Extruder_ToolHeadDrill.get(1)).duration(10 * SECONDS).eut(256)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L),
                        ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(ItemList.Circuit_Parts_Glass_Tube.get(1L)).duration(6 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L),
                        ItemList.Shape_Mold_Bottle.get(0L))
                .itemOutputs(ItemList.Bottle_Empty.get(1L)).duration(1 * SECONDS + 12 * TICKS).eut(8)
                .addTo(formingPressRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L),
                        ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(new ItemStack(Blocks.glass, 1, 0)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(formingPressRecipes);

        // Recipes for Any circuits
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ULV, 1),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(com.dreammaster.item.ItemList.CircuitULV.getIS(1)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(com.dreammaster.item.ItemList.CircuitLV.getIS(1)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 1),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(com.dreammaster.item.ItemList.CircuitMV.getIS(1)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(com.dreammaster.item.ItemList.CircuitHV.getIS(1)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.EV, 1),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(com.dreammaster.item.ItemList.CircuitEV.getIS(1)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 1),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(com.dreammaster.item.ItemList.CircuitIV.getIS(1)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LuV, 1),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(com.dreammaster.item.ItemList.CircuitLuV.getIS(1)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.ZPM, 1),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(com.dreammaster.item.ItemList.CircuitZPM.getIS(1)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UV, 1),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(com.dreammaster.item.ItemList.CircuitUV.getIS(1)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UHV, 1),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(com.dreammaster.item.ItemList.CircuitUHV.getIS(1)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UEV, 1),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(com.dreammaster.item.ItemList.CircuitUEV.getIS(1)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UIV, 1),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(com.dreammaster.item.ItemList.CircuitUIV.getIS(1)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UMV, 1),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(com.dreammaster.item.ItemList.CircuitUMV.getIS(1)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.UXV, 1),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(com.dreammaster.item.ItemList.CircuitUXV.getIS(1)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MAX, 1),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(com.dreammaster.item.ItemList.CircuitMAX.getIS(1)).duration(1 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);

        if (BloodArsenal.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTModHandler.getModItem(BloodArsenal.ID, "glass_shard", 2L, 0),
                            ItemList.Shape_Mold_Block.get(0L))
                    .itemOutputs(new ItemStack(Blocks.glass, 1, 0)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(formingPressRecipes);

        }

        if (BuildCraftSilicon.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L),
                            GTModHandler.getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1L, 4))
                    .itemOutputs(CustomItemList.EssentiaCircuit.get(1L)).duration(15 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(formingPressRecipes);

        }
        if (ProjectRedCore.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 2L),
                            CustomItemList.EtchedLowVoltageWiring.get(1L))
                    .itemOutputs(GTModHandler.getModItem(ProjectRedCore.ID, "projectred.core.part", 1L, 0))
                    .duration(5 * SECONDS).eut(16).addTo(formingPressRecipes);

        }

        // Optical CPU Containment Housing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Optical.get(1L),
                        MaterialsAlloy.BOTMIUM.getFoil(1),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.NickelZincFerrite, 1L),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.NaquadahAlloy, 1L),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.VibrantAlloy, 1L),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Bedrockium, 8L))
                .itemOutputs(ItemList.Optical_Cpu_Containment_Housing.get(1L)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_UEV).addTo(formingPressRecipes);

    }
}
