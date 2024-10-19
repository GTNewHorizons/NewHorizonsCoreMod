package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.fluidSolidifierRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.gthandler.GT_CustomLoader;

import bartworks.common.loaders.ItemRegistry;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.MaterialsUEVplus;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

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
        GTValues.RA.stdBuilder()
                .itemInputs(GTOreDictUnificator.get(GT_CustomLoader.AdvancedGTMaterials.UHV.getGlass(), 1))
                .fluidInputs(Materials.Helium.getPlasma(4 * 144)).itemOutputs(ItemList.GlassUVResistant.get(1))
                .eut(TierEU.RECIPE_UV).duration(5 * SECONDS).addTo(fluidSolidifierRecipes);

        // Omni Purpose Infinity Fused Glass
        GTValues.RA.stdBuilder().itemInputs(ItemList.GlassUVResistant.get(1))
                .fluidInputs(Materials.Infinity.getMolten(144))
                .itemOutputs(ItemList.GlassOmniPurposeInfinityFused.get(1)).eut(TierEU.RECIPE_UEV).duration(5 * SECONDS)
                .addTo(fluidSolidifierRecipes);

        // Non photonic matter exclusion glass
        GTValues.RA.stdBuilder().itemInputs(ItemList.GlassOmniPurposeInfinityFused.get(1))
                .fluidInputs(MaterialsUEVplus.ExcitedDTRC.getFluid(1000L))
                .itemOutputs(ItemList.GlassQuarkContainment.get(1)).eut(TierEU.RECIPE_UEV).duration(5 * SECONDS)
                .addTo(fluidSolidifierRecipes);

        if (TinkerConstruct.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 36))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("glue"), 144)).duration(20 * TICKS).eut(8)
                    .addTo(fluidSolidifierRecipes);
            // maybe Materials.Glue.getFluid(144L) instead

            GTValues.RA.stdBuilder().itemInputs(GTUtility.getIntegratedCircuit(1))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "blankPattern", 1L, 1))
                    .fluidInputs(FluidRegistry.getFluidStack("aluminumbrass.molten", 144)).duration(20 * TICKS).eut(48)
                    .addTo(fluidSolidifierRecipes);

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

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormAnvil.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Anvil.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormArrowHead.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Arrow.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormBaguette.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Baguette.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormBall.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Ball.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormBlock.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Block.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormBolt.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Bolt.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormBottle.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Bottle.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormBread.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Bread.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormBuns.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Bun.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormCasing.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Casing.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormCoinage.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Credit.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormCylinder.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Cylinder.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormGear.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Gear.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormIngot.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Ingot.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(CustomItemList.MarshmallowFormMold.get(1L))
                    .itemOutputs(CustomItemList.MarshmallowForm.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormName.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Name.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormNuggets.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Nugget.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormPlate.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Plate.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormRing.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Ring.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormRound.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Round.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormRotor.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Rotor.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormScrew.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Screw.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormSmallGear.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Gear_Small.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormStick.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Rod.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormStickLong.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Rod_Long.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormPipeTiny.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Pipe_Tiny.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormPipeSmall.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Pipe_Small.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormPipeMedium.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Pipe_Medium.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormPipeLarge.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Pipe_Large.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormPipeHuge.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Pipe_Huge.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormTurbineBlade.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_Turbine_Blade.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormBoots.getIS(1))
                    .itemOutputs(CustomItemList.MoldBoots.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormChestplate.getIS(1))
                    .itemOutputs(CustomItemList.MoldChestplate.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormLeggings.getIS(1))
                    .itemOutputs(CustomItemList.MoldLeggings.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormHelmet.getIS(1))
                    .itemOutputs(CustomItemList.MoldHelmet.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.MoldFormDrillHead.getIS(1))
                    .itemOutputs(ItemList.Shape_Mold_ToolHeadDrill.get(1)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);
            // Making shapes

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeBolt.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Bolt.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeHoeHead.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Hoe.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeRing.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Ring.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeTurbineBlade.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Turbine_Blade.get(1L))
                    .fluidInputs(Materials.Steel.getMolten(576L)).duration(20 * TICKS).eut(TierEU.RECIPE_MV)
                    .addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeGear.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Gear.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeLargePipe.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Pipe_Large.get(1L))
                    .fluidInputs(Materials.Steel.getMolten(576L)).duration(20 * TICKS).eut(TierEU.RECIPE_MV)
                    .addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeShovelHead.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Shovel.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeCell.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Cell.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeAxeHead.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Axe.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeBlock.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Block.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeSwordBlade.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Sword.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapePlate.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Plate.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeBoat.getIS(1))
                    .itemOutputs(com.dreammaster.item.ItemList.ExtruderShapeBoat.getIS(1))
                    .fluidInputs(Materials.Steel.getMolten(576L)).duration(20 * TICKS).eut(TierEU.RECIPE_MV)
                    .addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeCasing.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Casing.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeHugePipe.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Pipe_Huge.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeRod.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Rod.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeWire.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Wire.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeTinyPipe.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Pipe_Tiny.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeHammerHead.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Hammer.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeNormalPipe.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Pipe_Medium.get(1L))
                    .fluidInputs(Materials.Steel.getMolten(576L)).duration(20 * TICKS).eut(TierEU.RECIPE_MV)
                    .addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeFileHead.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_File.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeBottle.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Bottle.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeSmallGear.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Small_Gear.get(1L))
                    .fluidInputs(Materials.Steel.getMolten(576L)).duration(20 * TICKS).eut(TierEU.RECIPE_MV)
                    .addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeSawBlade.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Saw.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeSmallPipe.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Pipe_Small.get(1L))
                    .fluidInputs(Materials.Steel.getMolten(576L)).duration(20 * TICKS).eut(TierEU.RECIPE_MV)
                    .addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeRotor.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Rotor.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapePickaxeHead.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Pickaxe.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeIngot.getIS(1))
                    .itemOutputs(ItemList.Shape_Extruder_Ingot.get(1L)).fluidInputs(Materials.Steel.getMolten(576L))
                    .duration(20 * TICKS).eut(TierEU.RECIPE_MV).addTo(fluidSolidifierRecipes);

            GTValues.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.ShapeDrillHead.getIS(1))
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
