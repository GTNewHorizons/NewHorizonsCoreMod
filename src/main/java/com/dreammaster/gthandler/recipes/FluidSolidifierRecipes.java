package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class FluidSolidifierRecipes implements Runnable {

    @Override
    public void run() {

        // Sodium Dust

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L), Materials.Sodium.getFluid(1000))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L)).noFluidInputs()
                .noFluidOutputs().duration(16 * TICKS).eut(4).addTo(sFluidSolidficationRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Shape_Mold_Ball.get(0L),
                        new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.02", 1L, 32414)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sFluidSolidficationRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Shape_Mold_Ball.get(0L),
                        new FluidStack(FluidRegistry.getFluid("dye.chemical.dyered"), 72))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.02", 1L, 32415)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sFluidSolidficationRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Shape_Mold_Ball.get(0L),
                        new FluidStack(FluidRegistry.getFluid("dye.chemical.dyegreen"), 72))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.02", 1L, 32416)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sFluidSolidficationRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Shape_Mold_Ball.get(0L),
                        new FluidStack(FluidRegistry.getFluid("dye.chemical.dyebrown"), 72))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.02", 1L, 32417)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sFluidSolidficationRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Shape_Mold_Ball.get(0L),
                        new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblue"), 72))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.02", 1L, 32418)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sFluidSolidficationRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Shape_Mold_Ball.get(0L),
                        new FluidStack(FluidRegistry.getFluid("dye.chemical.dyepurple"), 72))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.02", 1L, 32419)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sFluidSolidficationRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Shape_Mold_Ball.get(0L),
                        new FluidStack(FluidRegistry.getFluid("dye.chemical.dyecyan"), 72))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.02", 1L, 32420)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sFluidSolidficationRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Shape_Mold_Ball.get(0L),
                        new FluidStack(FluidRegistry.getFluid("dye.chemical.dyelightgray"), 72))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.02", 1L, 32421)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sFluidSolidficationRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Shape_Mold_Ball.get(0L),
                        new FluidStack(FluidRegistry.getFluid("dye.chemical.dyegray"), 72))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.02", 1L, 32422)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sFluidSolidficationRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Shape_Mold_Ball.get(0L),
                        new FluidStack(FluidRegistry.getFluid("dye.chemical.dyepink"), 72))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.02", 1L, 32423)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sFluidSolidficationRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Shape_Mold_Ball.get(0L),
                        new FluidStack(FluidRegistry.getFluid("dye.chemical.dyelime"), 72))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.02", 1L, 32424)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sFluidSolidficationRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Shape_Mold_Ball.get(0L),
                        new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeyellow"), 72))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.02", 1L, 32425)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sFluidSolidficationRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Shape_Mold_Ball.get(0L),
                        new FluidStack(FluidRegistry.getFluid("dye.chemical.dyelightblue"), 72))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.02", 1L, 32426)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sFluidSolidficationRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Shape_Mold_Ball.get(0L),
                        new FluidStack(FluidRegistry.getFluid("dye.chemical.dyemagenta"), 72))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.02", 1L, 32427)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sFluidSolidficationRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Shape_Mold_Ball.get(0L),
                        new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeorange"), 72))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.02", 1L, 32428)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sFluidSolidficationRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Shape_Mold_Ball.get(0L),
                        new FluidStack(FluidRegistry.getFluid("dye.chemical.dyewhite"), 72))
                .itemOutputs(GT_ModHandler.getModItem(GregTech.ID, "gt.metaitem.02", 1L, 32429)).noFluidInputs()
                .noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sFluidSolidficationRecipes);

        if (TinkerConstruct.isModLoaded() && ExtraUtilities.isModLoaded())

            if (TinkerConstruct.isModLoaded()) {

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.Shape_Mold_Ball.get(0L),
                                new FluidStack(FluidRegistry.getFluid("glue"), 144))
                        .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 36)).noFluidInputs()
                        .noFluidOutputs().duration(5 * SECONDS).eut(8).addTo(sFluidSolidficationRecipes);
                // maybe Materials.Glue.getFluid(144L) instead

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_Utility.getIntegratedCircuit(1),
                                FluidRegistry.getFluidStack("aluminumbrass.molten", 144))
                        .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "blankPattern", 1L, 1))
                        .noFluidInputs().noFluidOutputs().duration(1 * SECONDS + 12 * TICKS).eut(48)
                        .addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.gravel, 1, 0), Materials.Tin.getMolten(16L))
                        .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 0)).noFluidInputs()
                        .noFluidOutputs().duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1, 6),
                                Materials.Steel.getMolten(288L))
                        .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1, 43)).noFluidInputs()
                        .noFluidOutputs().duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                        .addTo(sFluidSolidficationRecipes);

                // Making molds

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormAnvil", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Anvil.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormArrowHead", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Arrow.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBaguette", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Baguette.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBall", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Ball.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBlock", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Block.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBolt", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Bolt.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBottle", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Bottle.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBread", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Bread.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBuns", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Bun.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormCasing", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Casing.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormCoinage", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Credit.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormCylinder", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Cylinder.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormGear", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Gear.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormIngot", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Ingot.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MarshmallowFormMold", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(CustomItemList.MarshmallowForm.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormName", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Name.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormNuggets", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Nugget.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPlate", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Plate.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormRing", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Ring.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormRound", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Round.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormRotor", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Rotor.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormScrew", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Screw.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormSmallGear", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Gear_Small.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormStick", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Rod.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormStickLong", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Rod_Long.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeTiny", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Pipe_Tiny.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeSmall", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Pipe_Small.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeMedium", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Pipe_Medium.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeLarge", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Pipe_Large.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeHuge", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Pipe_Huge.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormTurbineBlade", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_Turbine_Blade.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBoots", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldBoots", 1, 0))
                        .noFluidInputs().noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                        .addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormChestplate", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldChestplate", 1, 0))
                        .noFluidInputs().noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                        .addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormLeggings", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldLeggings", 1, 0))
                        .noFluidInputs().noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                        .addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormHelmet", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldHelmet", 1, 0))
                        .noFluidInputs().noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                        .addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.MoldFormDrillHead", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Mold_ToolHeadDrill.get(1)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);
                // Making shapes

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeBolt", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Bolt.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeHoeHead", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Hoe.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeRing", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Ring.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeTurbineBlade", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Turbine_Blade.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeGear", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Gear.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeLargePipe", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Pipe_Large.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeShovelHead", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Shovel.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeCell", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Cell.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeAxeHead", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Axe.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeBlock", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Block.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeSwordBlade", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Sword.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapePlate", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Plate.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeBoat", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ExtruderShapeBoat", 1, 0))
                        .noFluidInputs().noFluidOutputs().duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                        .addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeCasing", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Casing.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeHugePipe", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Pipe_Huge.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeRod", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Rod.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeWire", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Wire.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeTinyPipe", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Pipe_Tiny.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeHammerHead", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Hammer.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeNormalPipe", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Pipe_Medium.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeFileHead", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_File.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeBottle", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Bottle.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeSmallGear", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Small_Gear.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeSawBlade", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Saw.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeSmallPipe", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Pipe_Small.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeRotor", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Rotor.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapePickaxeHead", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Pickaxe.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeIngot", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_Ingot.get(1L)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(NewHorizonsCoreMod.ID, "item.ShapeDrillHead", 1, 0),
                                Materials.Steel.getMolten(576L))
                        .itemOutputs(ItemList.Shape_Extruder_ToolHeadDrill.get(1)).noFluidInputs().noFluidOutputs()
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sFluidSolidficationRecipes);

            }
    }
}
