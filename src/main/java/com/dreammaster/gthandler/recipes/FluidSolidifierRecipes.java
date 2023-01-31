package com.dreammaster.gthandler.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class FluidSolidifierRecipes implements Runnable {

    @Override
    public void run() {
        // Sodium Dust
        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                Materials.Sodium.getFluid(1000),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L),
                16,
                4);

        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32414),
                100,
                16);
        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                new FluidStack(FluidRegistry.getFluid("dye.chemical.dyered"), 72),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32415),
                100,
                16);
        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                new FluidStack(FluidRegistry.getFluid("dye.chemical.dyegreen"), 72),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32416),
                100,
                16);
        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                new FluidStack(FluidRegistry.getFluid("dye.chemical.dyebrown"), 72),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32417),
                100,
                16);
        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblue"), 72),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32418),
                100,
                16);
        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                new FluidStack(FluidRegistry.getFluid("dye.chemical.dyepurple"), 72),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32419),
                100,
                16);
        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                new FluidStack(FluidRegistry.getFluid("dye.chemical.dyecyan"), 72),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32420),
                100,
                16);
        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                new FluidStack(FluidRegistry.getFluid("dye.chemical.dyelightgray"), 72),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32421),
                100,
                16);
        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                new FluidStack(FluidRegistry.getFluid("dye.chemical.dyegray"), 72),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32422),
                100,
                16);
        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                new FluidStack(FluidRegistry.getFluid("dye.chemical.dyepink"), 72),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32423),
                100,
                16);
        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                new FluidStack(FluidRegistry.getFluid("dye.chemical.dyelime"), 72),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32424),
                100,
                16);
        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeyellow"), 72),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32425),
                100,
                16);
        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                new FluidStack(FluidRegistry.getFluid("dye.chemical.dyelightblue"), 72),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32426),
                100,
                16);
        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                new FluidStack(FluidRegistry.getFluid("dye.chemical.dyemagenta"), 72),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32427),
                100,
                16);
        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeorange"), 72),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32428),
                100,
                16);
        GT_Values.RA.addFluidSolidifierRecipe(
                ItemList.Shape_Mold_Ball.get(0L),
                new FluidStack(FluidRegistry.getFluid("dye.chemical.dyewhite"), 72),
                GT_ModHandler.getModItem("gregtech", "gt.metaitem.02", 1L, 32429),
                100,
                16);

        if (Loader.isModLoaded("TConstruct")) {
            GT_Values.RA.addFluidSolidifierRecipe(
                    ItemList.Shape_Mold_Ball.get(0L),
                    new FluidStack(FluidRegistry.getFluid("glue"), 144),
                    GT_ModHandler.getModItem("TConstruct", "materials", 1L, 36),
                    100,
                    8); // maybe Materials.Glue.getFluid(144L) instead
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_Utility.getIntegratedCircuit(1),
                    FluidRegistry.getFluidStack("aluminumbrass.molten", 144),
                    GT_ModHandler.getModItem("TConstruct", "blankPattern", 1L, 1),
                    32,
                    48);

            GT_Values.RA.addFluidSolidifierRecipe(
                    new ItemStack(Blocks.gravel, 1, 0),
                    Materials.Tin.getMolten(16L),
                    GT_ModHandler.getModItem("TConstruct", "SpeedBlock", 1, 0),
                    100,
                    30);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("TConstruct", "largePlate", 1, 6),
                    Materials.DamascusSteel.getMolten(288L),
                    GT_ModHandler.getModItem("TConstruct", "materials", 1, 43),
                    400,
                    120);
            if (Loader.isModLoaded("ExtraUtilities")) {
                GT_Values.RA.addFluidSolidifierRecipe(
                        GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1, 12),
                        Materials.Tin.getMolten(144L),
                        GT_ModHandler.getModItem("TConstruct", "SpeedBlock", 9, 0),
                        100,
                        120);
                GT_Values.RA.addFluidSolidifierRecipe(
                        GT_ModHandler.getModItem("ExtraUtilities", "cobblestone_compressed", 1, 12),
                        Materials.Electrum.getMolten(48L),
                        GT_ModHandler.getModItem("TConstruct", "SpeedBlock", 9, 0),
                        100,
                        120);
            }
            // Making molds
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormAnvil", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Anvil.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormArrowHead", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Arrow.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormBaguette", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Baguette.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormBall", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Ball.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormBlock", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Block.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormBolt", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Bolt.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormBottle", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Bottle.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormBread", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Bread.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormBuns", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Bun.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormCasing", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Casing.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormCoinage", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Credit.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormCylinder", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Cylinder.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormGear", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Gear.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormIngot", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Ingot.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MarshmallowFormMold", 1, 0),
                    Materials.Steel.getMolten(576L),
                    CustomItemList.MarshmallowForm.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormName", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Name.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormNuggets", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Nugget.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormPlate", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Plate.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormRing", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Ring.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormRound", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Round.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormRotor", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Rotor.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormScrew", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Screw.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormSmallGear", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Gear_Small.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormStick", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Rod.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormStickLong", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Rod_Long.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormPipeTiny", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Pipe_Tiny.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormPipeSmall", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Pipe_Small.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormPipeMedium", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Pipe_Medium.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormPipeLarge", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Pipe_Large.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormPipeHuge", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Pipe_Huge.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormTurbineBlade", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_Turbine_Blade.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormBoots", 1, 0),
                    Materials.Steel.getMolten(576L),
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldBoots", 1, 0),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormChestplate", 1, 0),
                    Materials.Steel.getMolten(576L),
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldChestplate", 1, 0),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormLeggings", 1, 0),
                    Materials.Steel.getMolten(576L),
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldLeggings", 1, 0),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormHelmet", 1, 0),
                    Materials.Steel.getMolten(576L),
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldHelmet", 1, 0),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.MoldFormDrillHead", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Mold_ToolHeadDrill.get(1),
                    200,
                    120);

            // Making shapes
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeBolt", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Bolt.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeHoeHead", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Hoe.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeRing", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Ring.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeTurbineBlade", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Turbine_Blade.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeGear", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Gear.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeLargePipe", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Pipe_Large.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeShovelHead", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Shovel.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeCell", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Cell.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeAxeHead", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Axe.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeBlock", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Block.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeSwordBlade", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Sword.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapePlate", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Plate.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeBoat", 1, 0),
                    Materials.Steel.getMolten(576L),
                    GT_ModHandler.getModItem("dreamcraft", "item.ExtruderShapeBoat", 1, 0),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeCasing", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Casing.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeHugePipe", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Pipe_Huge.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeRod", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Rod.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeWire", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Wire.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeTinyPipe", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Pipe_Tiny.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeHammerHead", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Hammer.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeNormalPipe", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Pipe_Medium.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeFileHead", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_File.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeBotte", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Bottle.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeSmallGear", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Small_Gear.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeSawBlade", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Saw.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeSmallPipe", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Pipe_Small.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeRotor", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Rotor.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapePickaxeHead", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Pickaxe.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeIngot", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Ingot.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeBottle", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_Bottle.get(1L),
                    200,
                    120);
            GT_Values.RA.addFluidSolidifierRecipe(
                    GT_ModHandler.getModItem("dreamcraft", "item.ShapeDrillHead", 1, 0),
                    Materials.Steel.getMolten(576L),
                    ItemList.Shape_Extruder_ToolHeadDrill.get(1),
                    200,
                    120);
        }
    }
}
