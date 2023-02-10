package com.dreammaster.gthandler.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.CustomItemList;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class FormingPressRecipes implements Runnable {

    @Override
    public void run() {

        GT_Values.RA.addFormingPressRecipe(
                CustomItemList.MalformedSlush.get(2L),
                CustomItemList.MarshmallowForm.get(0L),
                CustomItemList.UncookedSlush.get(1L),
                1200,
                7680);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                CustomItemList.MarshmallowForm.get(0L),
                CustomItemList.MarshmallowForm.get(1L),
                200,
                256);

        GT_Values.RA.addFormingPressRecipe(
                CustomItemList.MicaBasedPulp.get(4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Asbestos, 1L),
                CustomItemList.MicaBasedSheet.get(4L),
                400,
                28);

        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Plate.get(0L),
                ItemList.Shape_Mold_Plate.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Casing.get(0L),
                ItemList.Shape_Mold_Casing.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Gear.get(0L),
                ItemList.Shape_Mold_Gear.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Credit.get(0L),
                ItemList.Shape_Mold_Credit.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Bottle.get(0L),
                ItemList.Shape_Mold_Bottle.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Ingot.get(0L),
                ItemList.Shape_Mold_Ingot.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Ball.get(0L),
                ItemList.Shape_Mold_Ball.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Block.get(0L),
                ItemList.Shape_Mold_Block.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Nugget.get(0L),
                ItemList.Shape_Mold_Nugget.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Bun.get(0L),
                ItemList.Shape_Mold_Bun.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Bread.get(0L),
                ItemList.Shape_Mold_Bread.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Baguette.get(0L),
                ItemList.Shape_Mold_Baguette.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Cylinder.get(0L),
                ItemList.Shape_Mold_Cylinder.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Anvil.get(0L),
                ItemList.Shape_Mold_Anvil.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Name.get(0L),
                ItemList.Shape_Mold_Name.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Arrow.get(0L),
                ItemList.Shape_Mold_Arrow.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Gear_Small.get(0L),
                ItemList.Shape_Mold_Gear_Small.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Rod.get(0L),
                ItemList.Shape_Mold_Rod.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Bolt.get(0L),
                ItemList.Shape_Mold_Bolt.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Round.get(0L),
                ItemList.Shape_Mold_Round.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Screw.get(0L),
                ItemList.Shape_Mold_Screw.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Ring.get(0L),
                ItemList.Shape_Mold_Ring.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Rod_Long.get(0L),
                ItemList.Shape_Mold_Rod_Long.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Rotor.get(0L),
                ItemList.Shape_Mold_Rotor.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Turbine_Blade.get(0L),
                ItemList.Shape_Mold_Turbine_Blade.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Pipe_Tiny.get(0L),
                ItemList.Shape_Mold_Pipe_Tiny.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Pipe_Small.get(0L),
                ItemList.Shape_Mold_Pipe_Small.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Pipe_Medium.get(0L),
                ItemList.Shape_Mold_Pipe_Medium.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Pipe_Large.get(0L),
                ItemList.Shape_Mold_Pipe_Large.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Mold_Pipe_Huge.get(0L),
                ItemList.Shape_Mold_Pipe_Huge.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                GT_ModHandler.getModItem("dreamcraft", "item.MoldHelmet", 0, 0),
                GT_ModHandler.getModItem("dreamcraft", "item.MoldHelmet", 1, 0),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                GT_ModHandler.getModItem("dreamcraft", "item.MoldChestplate", 0, 0),
                GT_ModHandler.getModItem("dreamcraft", "item.MoldChestplate", 1, 0),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                GT_ModHandler.getModItem("dreamcraft", "item.MoldLeggings", 0, 0),
                GT_ModHandler.getModItem("dreamcraft", "item.MoldLeggings", 1, 0),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                GT_ModHandler.getModItem("dreamcraft", "item.MoldBoots", 0, 0),
                GT_ModHandler.getModItem("dreamcraft", "item.MoldBoots", 1, 0),
                200,
                256);

        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Plate.get(0L),
                ItemList.Shape_Extruder_Plate.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Rod.get(0L),
                ItemList.Shape_Extruder_Rod.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Bolt.get(0L),
                ItemList.Shape_Extruder_Bolt.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Ring.get(0L),
                ItemList.Shape_Extruder_Ring.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Cell.get(0L),
                ItemList.Shape_Extruder_Cell.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Ingot.get(0L),
                ItemList.Shape_Extruder_Ingot.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Wire.get(0L),
                ItemList.Shape_Extruder_Wire.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Casing.get(0L),
                ItemList.Shape_Extruder_Casing.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Pipe_Tiny.get(0L),
                ItemList.Shape_Extruder_Pipe_Tiny.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Pipe_Small.get(0L),
                ItemList.Shape_Extruder_Pipe_Small.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Pipe_Medium.get(0L),
                ItemList.Shape_Extruder_Pipe_Medium.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Pipe_Large.get(0L),
                ItemList.Shape_Extruder_Pipe_Large.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Pipe_Huge.get(0L),
                ItemList.Shape_Extruder_Pipe_Huge.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Block.get(0L),
                ItemList.Shape_Extruder_Block.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Sword.get(0L),
                ItemList.Shape_Extruder_Sword.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Pickaxe.get(0L),
                ItemList.Shape_Extruder_Pickaxe.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Shovel.get(0L),
                ItemList.Shape_Extruder_Shovel.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Axe.get(0L),
                ItemList.Shape_Extruder_Axe.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Hoe.get(0L),
                ItemList.Shape_Extruder_Hoe.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Hammer.get(0L),
                ItemList.Shape_Extruder_Hammer.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_File.get(0L),
                ItemList.Shape_Extruder_File.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Saw.get(0L),
                ItemList.Shape_Extruder_Saw.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Gear.get(0L),
                ItemList.Shape_Extruder_Gear.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Bottle.get(0L),
                ItemList.Shape_Extruder_Bottle.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Rotor.get(0L),
                ItemList.Shape_Extruder_Rotor.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Small_Gear.get(0L),
                ItemList.Shape_Extruder_Small_Gear.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                ItemList.Shape_Extruder_Turbine_Blade.get(0L),
                ItemList.Shape_Extruder_Turbine_Blade.get(1L),
                200,
                256);
        GT_Values.RA.addFormingPressRecipe(
                ItemList.Shape_Empty.get(1L),
                GT_ModHandler.getModItem("dreamcraft", "item.ExtruderShapeBoat", 0, 0),
                GT_ModHandler.getModItem("dreamcraft", "item.ExtruderShapeBoat", 1, 0),
                200,
                256);

        GT_Values.RA.addFormingPressRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L),
                ItemList.Shape_Mold_Ball.get(0L),
                ItemList.Circuit_Parts_Glass_Tube.get(1L),
                120,
                30);
        GT_Values.RA.addFormingPressRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L),
                ItemList.Shape_Mold_Bottle.get(0L),
                ItemList.Bottle_Empty.get(1L),
                32,
                8);
        GT_Values.RA.addFormingPressRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L),
                ItemList.Shape_Mold_Block.get(0L),
                new ItemStack(Blocks.glass, 1, 0),
                100,
                30);

        if (Loader.isModLoaded("BloodArsenal")) {
            GT_Values.RA.addFormingPressRecipe(
                    GT_ModHandler.getModItem("BloodArsenal", "glass_shard", 2L, 0),
                    ItemList.Shape_Mold_Block.get(0L),
                    new ItemStack(Blocks.glass, 1, 0),
                    100,
                    30);
        }

        if (Loader.isModLoaded("BuildCraft|Silicon")) {
            GT_Values.RA.addFormingPressRecipe(
                    ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L),
                    GT_ModHandler.getModItem("BuildCraft|Silicon", "redstoneChipset", 1L, 4),
                    CustomItemList.EssentiaCircuit.get(1L),
                    300,
                    480);
        }
        if (Loader.isModLoaded("ProjRed|Core")) {
            GT_Values.RA.addFormingPressRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Stone, 2L),
                    CustomItemList.EtchedLowVoltageWiring.get(1L),
                    GT_ModHandler.getModItem("ProjRed|Core", "projectred.core.part", 1L, 0),
                    100,
                    16);
        }

        if (Loader.isModLoaded("Thaumcraft")) {
            GT_Values.RA.addForgeHammerRecipe(
                    GT_ModHandler.getModItem("Thaumcraft", "ItemEldritchObject", 1L, 3),
                    CustomItemList.PrimordialPearlFragment.get(3L),
                    16,
                    7680);
        }
        if (Loader.isModLoaded("bartworks")) {
            // Optical CPU Containment Housing
            GT_Values.RA.addFormingPressRecipe(
                    new ItemStack[] { ItemList.Circuit_Board_Optical.get(1L),
                            GT_ModHandler.getModItem("miscutils", "itemFoilBotmium", 1L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NickelZincFerrite, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, Materials.NaquadahAlloy, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.foil, Materials.VibrantAlloy, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Bedrockium, 8L) },
                    new ItemStack[] { ItemList.Optical_Cpu_Containment_Housing.get(1L) },
                    10 * 10,
                    7_864_320);
        }
    }
}
