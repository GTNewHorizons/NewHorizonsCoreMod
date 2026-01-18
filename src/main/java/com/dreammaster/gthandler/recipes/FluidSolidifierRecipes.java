package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.fluidSolidifierRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.block.BlockList;
import com.dreammaster.item.NHItemList;
import com.dreammaster.tinkersConstruct.SmelteryFluidTypes;

import bartworks.common.loaders.ItemRegistry;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;

public class FluidSolidifierRecipes implements Runnable {

    @Override
    public void run() {
        makeAvaritiaRecipes();

        // Sodium Dust

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L))
                .fluidInputs(Materials.Sodium.getFluid(1000)).duration(20 * TICKS).eut(4).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L)).itemOutputs(ItemList.Color_00.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72)).duration(20 * TICKS)
                .eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L)).itemOutputs(ItemList.Color_01.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyered"), 72)).duration(20 * TICKS)
                .eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L)).itemOutputs(ItemList.Color_02.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyegreen"), 72)).duration(20 * TICKS)
                .eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L)).itemOutputs(ItemList.Color_03.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyebrown"), 72)).duration(20 * TICKS)
                .eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L)).itemOutputs(ItemList.Color_04.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblue"), 72)).duration(20 * TICKS)
                .eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L)).itemOutputs(ItemList.Color_05.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyepurple"), 72)).duration(20 * TICKS)
                .eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L)).itemOutputs(ItemList.Color_06.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyecyan"), 72)).duration(20 * TICKS)
                .eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L)).itemOutputs(ItemList.Color_07.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyelightgray"), 72))
                .duration(20 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L)).itemOutputs(ItemList.Color_08.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyegray"), 72)).duration(20 * TICKS)
                .eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L)).itemOutputs(ItemList.Color_09.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyepink"), 72)).duration(20 * TICKS)
                .eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L)).itemOutputs(ItemList.Color_10.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyelime"), 72)).duration(20 * TICKS)
                .eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L)).itemOutputs(ItemList.Color_11.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeyellow"), 72)).duration(20 * TICKS)
                .eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L)).itemOutputs(ItemList.Color_12.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyelightblue"), 72))
                .duration(20 * TICKS).eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L)).itemOutputs(ItemList.Color_13.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyemagenta"), 72)).duration(20 * TICKS)
                .eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L)).itemOutputs(ItemList.Color_14.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeorange"), 72)).duration(20 * TICKS)
                .eut(16).addTo(fluidSolidifierRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L)).itemOutputs(ItemList.Color_15.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyewhite"), 72)).duration(20 * TICKS)
                .eut(16).addTo(fluidSolidifierRecipes);

        // Electron-permeable neutronium-coated glass
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(new ItemStack(ItemRegistry.bw_glasses[0], 1, 13)))
                .fluidInputs(Materials.Helium.getPlasma(4 * 144)).itemOutputs(ItemList.GlassUVResistant.get(1))
                .eut(TierEU.RECIPE_UV).duration(5 * SECONDS).addTo(fluidSolidifierRecipes);

        // Omni Purpose Infinity Fused Glass
        GTValues.RA.stdBuilder().itemInputs(ItemList.GlassUVResistant.get(1))
                .fluidInputs(Materials.Infinity.getMolten(144))
                .itemOutputs(ItemList.GlassOmniPurposeInfinityFused.get(1)).eut(TierEU.RECIPE_UEV).duration(5 * SECONDS)
                .addTo(fluidSolidifierRecipes);

        // Non photonic matter exclusion glass
        GTValues.RA.stdBuilder().itemInputs(ItemList.GlassOmniPurposeInfinityFused.get(1))
                .fluidInputs(Materials.ExcitedDTRC.getFluid(1000L)).itemOutputs(ItemList.GlassQuarkContainment.get(1))
                .eut(TierEU.RECIPE_UEV).duration(5 * SECONDS).addTo(fluidSolidifierRecipes);
        if (Botania.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(Botania.ID, "bifrostPerm", 1L))
                    .itemOutputs(BlockList.Gaia.getIS(1)).fluidInputs(Materials.GaiaSpirit.getMolten(1296L))
                    .duration(2 * SECONDS).eut(TierEU.RECIPE_IV).addTo(fluidSolidifierRecipes);
        }

        if (TinkerConstruct.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 36))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("glue"), 144)).duration(20 * TICKS).eut(8)
                    .addTo(fluidSolidifierRecipes);
            // maybe Materials.Glue.getFluid(144L) instead

            GTValues.RA.stdBuilder().circuit(1)
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "blankPattern", 1L, 1))
                    .fluidInputs(FluidRegistry.getFluidStack(SmelteryFluidTypes.getMoltenPatternFluidName(), 144))
                    .duration(20 * TICKS).eut(48).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.gravel, 1, 0))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 0))
                    .fluidInputs(Materials.Tin.getMolten(16L)).duration(20 * TICKS).eut(TierEU.RECIPE_LV)
                    .addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "heavyPlate", 1, 6))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "materials", 1, 43))
                    .fluidInputs(Materials.Steel.getMolten(288L)).duration(20 * TICKS).eut(TierEU.RECIPE_MV)
                    .addTo(fluidSolidifierRecipes);

            if (ExtraUtilities.isModLoaded()) {

                GTValues.RA.stdBuilder()
                        .itemInputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 12))
                        .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "SpeedBlock", 9, 0))
                        .fluidInputs(Materials.Tin.getMolten(144L)).duration(20 * TICKS).eut(TierEU.RECIPE_MV)
                        .addTo(fluidSolidifierRecipes);

                GTValues.RA.stdBuilder()
                        .itemInputs(GTModHandler.getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 12))
                        .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "SpeedBlock", 9, 0))
                        .fluidInputs(Materials.Electrum.getMolten(48L)).duration(20 * TICKS).eut(TierEU.RECIPE_MV)
                        .addTo(fluidSolidifierRecipes);

            }
            // Making molds

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormAnvil.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Anvil.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormArrowHead.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Arrow.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormBaguette.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Baguette.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormBall.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Ball.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormBlock.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Block.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormBolt.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Bolt.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormBottle.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Bottle.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormBread.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Bread.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormBuns.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Bun.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormCasing.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Casing.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormCoinage.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Credit.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormCylinder.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Cylinder.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormGear.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Gear.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormIngot.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Ingot.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MarshmallowFormMold.get())
                    .itemOutputs(NHItemList.MarshmallowForm.get()).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormName.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Name.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormNuggets.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Nugget.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormPlate.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Plate.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormRing.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Ring.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormRound.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Round.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormRotor.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Rotor.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormScrew.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Screw.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormSmallGear.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Gear_Small.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormStick.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Rod.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormStickLong.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Rod_Long.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormPipeTiny.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Pipe_Tiny.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormPipeSmall.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Pipe_Small.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormPipeMedium.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Pipe_Medium.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormPipeLarge.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Pipe_Large.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormPipeHuge.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Pipe_Huge.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormTurbineBlade.get(1))
                    .itemOutputs(ItemList.Shape_Mold_Turbine_Blade.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormBoots.get(1)).itemOutputs(NHItemList.MoldBoots.get())
                    .fluidInputs(Materials.Steel.getMolten(576L)).duration(20 * TICKS).eut(TierEU.RECIPE_MV)
                    .addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormChestplate.get(1))
                    .itemOutputs(NHItemList.MoldChestplate.get()).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormLeggings.get(1))
                    .itemOutputs(NHItemList.MoldLeggings.get()).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormHelmet.get(1))
                    .itemOutputs(NHItemList.MoldHelmet.get()).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.MoldFormDrillHead.get(1))
                    .itemOutputs(ItemList.Shape_Mold_ToolHeadDrill.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);
            // Making shapes

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeBolt.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Bolt.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeHoeHead.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Hoe.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeRing.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Ring.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeTurbineBlade.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Turbine_Blade.get(1L))
                    .fluidInputs(Materials.Steel.getMolten(576L)).duration(20 * TICKS).eut(TierEU.RECIPE_MV)
                    .addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeGear.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Gear.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeLargePipe.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Pipe_Large.get(1L))
                    .fluidInputs(Materials.Steel.getMolten(576L)).duration(20 * TICKS).eut(TierEU.RECIPE_MV)
                    .addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeShovelHead.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Shovel.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeCell.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Cell.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeAxeHead.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Axe.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeBlock.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Block.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeSwordBlade.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Sword.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapePlate.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Plate.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeBoat.get(1))
                    .itemOutputs(NHItemList.ExtruderShapeBoat.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeCasing.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Casing.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeHugePipe.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Pipe_Huge.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeRod.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Rod.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeTinyPipe.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Pipe_Tiny.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeHammerHead.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Hammer.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeNormalPipe.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Pipe_Medium.get(1L))
                    .fluidInputs(Materials.Steel.getMolten(576L)).duration(20 * TICKS).eut(TierEU.RECIPE_MV)
                    .addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeFileHead.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_File.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeBottle.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Bottle.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeSmallGear.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Small_Gear.get(1L))
                    .fluidInputs(Materials.Steel.getMolten(576L)).duration(20 * TICKS).eut(TierEU.RECIPE_MV)
                    .addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeSawBlade.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Saw.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeSmallPipe.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Pipe_Small.get(1L))
                    .fluidInputs(Materials.Steel.getMolten(576L)).duration(20 * TICKS).eut(TierEU.RECIPE_MV)
                    .addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeRotor.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Rotor.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapePickaxeHead.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Pickaxe.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeIngot.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_Ingot.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(NHItemList.ShapeDrillHead.get(1))
                    .itemOutputs(ItemList.Shape_Extruder_ToolHeadDrill.get(1))
                    .fluidInputs(Materials.Steel.getMolten(576L)).duration(20 * TICKS).eut(TierEU.RECIPE_MV)
                    .addTo(fluidSolidifierRecipes);

            // Hawking Radiation Realignment Focus
            GTValues.RA.stdBuilder().itemInputs(new ItemStack(ItemRegistry.bw_glasses[0], 1, 15))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("molten.rhugnor"), 1152)).duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_UIV).itemOutputs(ItemList.Hawking_Glass.get(1)).addTo(fluidSolidifierRecipes);
        }
    }

    private void makeAvaritiaRecipes() {
        if (!Avaritia.isModLoaded()) {
            return;
        }
        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(Materials.CosmicNeutronium.getBlocks(1))
                .fluidInputs(Materials.CosmicNeutronium.getMolten(1296L)).duration(15 * SECONDS).eut(TierEU.RECIPE_ZPM)
                .addTo(fluidSolidifierRecipes);
    }
}
