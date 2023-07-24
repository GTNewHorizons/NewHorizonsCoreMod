package com.dreammaster.gthandler.recipes;

import static gregtech.api.GregTech_API.mGTPlusPlus;
import static gregtech.api.enums.Mods.*;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sPlasmaForgeRecipes;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;
import static gregtech.api.util.GT_RecipeConstants.COIL_HEAT;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.block.BlockList;
import com.dreammaster.gthandler.GT_CoreModSupport;

import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gtPlusPlus.core.material.ALLOY;
import gtPlusPlus.core.material.ELEMENT;
import gtPlusPlus.core.recipe.common.CI;

public class DTPFRecipes implements Runnable {

    @Override
    public void run() {
        // Dimensionally transcendent plasma forge recipes.

        {
            // Coils
            int awakened_heat = 10800;
            int infinity_heat = awakened_heat + 900;
            int hypogen_heat = infinity_heat + 900;
            int eternal_heat = hypogen_heat + 900;

            // ------------------------------------------------------------------------------------------
            // ------------------------------------- Plasma Forge ---------------------------------------
            // ------------------------------------------------------------------------------------------

            // See https://docs.google.com/spreadsheets/d/1_n2HSFyzfNzkJHYBPFu3HTZvkh69GBi5LXw2c9FyG9o/edit?usp=sharing
            // for details on plasma forge maths.
            {
                // Neutronium Smelting.

                long base_quantity = 512L;
                long tier_up_multiplier = 2L;

                int base_time = 2500;

                long tier_1_quantity = 144L * base_quantity;
                long fuel_quantity_1 = 65017L;

                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.ExcitedDTCC.getFluid(fuel_quantity_1),
                                Materials.Iron.getMolten(tier_1_quantity))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 8),
                                Materials.Neutronium.getMolten(tier_1_quantity))
                        .duration(base_time).eut(25_165_824).metadata(COIL_HEAT, awakened_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_2_quantity = 144L * base_quantity * tier_up_multiplier;
                long fuel_quantity_2 = 25442L;

                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.ExcitedDTPC.getFluid(fuel_quantity_2),
                                Materials.Iron.getMolten(tier_2_quantity))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2 / 4),
                                Materials.Neutronium.getMolten(tier_2_quantity))
                        .duration(base_time / 2).eut(50_331_648).metadata(COIL_HEAT, infinity_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_3_quantity = 144L * base_quantity * tier_up_multiplier * tier_up_multiplier;
                long fuel_quantity_3 = 10979L;

                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_3),
                                Materials.Iron.getMolten(tier_3_quantity))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_3 / 2),
                                Materials.Neutronium.getMolten(tier_3_quantity))
                        .duration(base_time / 4).eut(100_663_296).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_4_quantity = 144L * base_quantity
                        * tier_up_multiplier
                        * tier_up_multiplier
                        * tier_up_multiplier;
                long fuel_quantity_4 = 4632L;

                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_4),
                                Materials.Iron.getMolten(tier_4_quantity))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_4),
                                Materials.Neutronium.getMolten(tier_4_quantity))
                        .duration(base_time / 8).eut(201_326_592).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);
            }

            {
                // Cosmic Neutronium Smelting.

                long base_quantity = 512L;
                long tier_up_multiplier = 2L;

                int base_time = 4200;
                int base_time_bee = 2100;

                long tier_1_quantity = 144L * base_quantity;
                // Bee Recipes
                long fuel_quantity_bee_1 = (long) (30883L * 0.85);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(GregTech.ID, "gt.comb", 1L, 117),
                                GT_Utility.getIntegratedCircuit(1))
                        .noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.ExcitedDTCC.getFluid(fuel_quantity_bee_1),
                                Materials.Copper.getMolten(tier_1_quantity))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_bee_1 / 8),
                                Materials.CosmicNeutronium.getMolten(tier_1_quantity))
                        .duration(base_time_bee).eut(7_115_337).metadata(COIL_HEAT, awakened_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_2_bee_quantity = 144L * base_quantity * tier_up_multiplier;
                long fuel_quantity_bee_2 = (long) (12085L * 0.85);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(GregTech.ID, "gt.comb", 1L, 117),
                                GT_Utility.getIntegratedCircuit(1))
                        .noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.ExcitedDTPC.getFluid(fuel_quantity_bee_2),
                                Materials.Copper.getMolten(tier_2_bee_quantity))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_bee_2 / 4),
                                Materials.CosmicNeutronium.getMolten(tier_2_bee_quantity))
                        .duration(base_time_bee / 2).eut(14_230_674).metadata(COIL_HEAT, infinity_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_3_bee_quantity = 144L * base_quantity * tier_up_multiplier * tier_up_multiplier;
                long fuel_quantity_bee_3 = (long) (5215L * 0.85);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(GregTech.ID, "gt.comb", 1L, 117),
                                GT_Utility.getIntegratedCircuit(1))
                        .noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_bee_3),
                                Materials.Copper.getMolten(tier_3_bee_quantity))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_bee_3 / 2),
                                Materials.CosmicNeutronium.getMolten(tier_3_bee_quantity))
                        .duration(base_time_bee / 4).eut(28_461_349).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_4_bee_quantity = 144L * base_quantity
                        * tier_up_multiplier
                        * tier_up_multiplier
                        * tier_up_multiplier;
                long fuel_quantity_bee_4 = (long) (2200L * 0.85);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(GregTech.ID, "gt.comb", 1L, 117),
                                GT_Utility.getIntegratedCircuit(1))
                        .noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_bee_4),
                                Materials.Copper.getMolten(tier_4_bee_quantity))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_bee_4),
                                Materials.CosmicNeutronium.getMolten(tier_4_bee_quantity))
                        .duration(base_time_bee / 8).eut(56_922_697).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);

                // normal ones

                long fuel_quantity_1 = 30883L;

                GT_Values.RA.stdBuilder().itemInputs(GT_Utility.getIntegratedCircuit(4)).noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.ExcitedDTCC.getFluid(fuel_quantity_1),
                                Materials.Copper.getMolten(tier_1_quantity))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 8),
                                Materials.CosmicNeutronium.getMolten(tier_1_quantity))
                        .duration(base_time).eut(7_115_337).metadata(COIL_HEAT, awakened_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_2_quantity = 144L * base_quantity * tier_up_multiplier;
                long fuel_quantity_2 = 12085L;

                GT_Values.RA.stdBuilder().itemInputs(GT_Utility.getIntegratedCircuit(4)).noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.ExcitedDTPC.getFluid(fuel_quantity_2),
                                Materials.Copper.getMolten(tier_2_quantity))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2 / 4),
                                Materials.CosmicNeutronium.getMolten(tier_2_quantity))
                        .duration(base_time / 2).eut(14_230_674).metadata(COIL_HEAT, infinity_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_3_quantity = 144L * base_quantity * tier_up_multiplier * tier_up_multiplier;
                long fuel_quantity_3 = 5215L;

                GT_Values.RA.stdBuilder().itemInputs(GT_Utility.getIntegratedCircuit(4)).noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_3),
                                Materials.Copper.getMolten(tier_3_quantity))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_3 / 2),
                                Materials.CosmicNeutronium.getMolten(tier_3_quantity))
                        .duration(base_time / 4).eut(28_461_349).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_4_quantity = 144L * base_quantity
                        * tier_up_multiplier
                        * tier_up_multiplier
                        * tier_up_multiplier;
                long fuel_quantity_4 = 2200L;

                GT_Values.RA.stdBuilder().itemInputs(GT_Utility.getIntegratedCircuit(4)).noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_4),
                                Materials.Copper.getMolten(tier_4_quantity))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_4),
                                Materials.CosmicNeutronium.getMolten(tier_4_quantity))
                        .duration(base_time / 8).eut(56_922_697).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);
            }

            {
                // Bedrockium.

                long base_quantity = 2048L;
                long tier_up_multiplier = 2L;

                int base_time = 3360;

                long tier_1_quantity = 144L * base_quantity;
                long fuel_quantity_1 = 102987L;

                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.ExcitedDTCC.getFluid(fuel_quantity_1),
                                Materials.Steel.getMolten(tier_1_quantity))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 8),
                                Materials.Bedrockium.getMolten(tier_1_quantity))
                        .duration(base_time).eut(29_659_721).metadata(COIL_HEAT, awakened_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_2_quantity = tier_1_quantity * tier_up_multiplier;
                long fuel_quantity_2 = 40299L;

                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.ExcitedDTPC.getFluid(fuel_quantity_2),
                                Materials.Steel.getMolten(tier_2_quantity))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2 / 4),
                                Materials.Bedrockium.getMolten(tier_2_quantity))
                        .duration(base_time / 2).eut(59_319_442).metadata(COIL_HEAT, infinity_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_3_quantity = tier_2_quantity * tier_up_multiplier;
                long fuel_quantity_3 = 17391L;

                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_3),
                                Materials.Steel.getMolten(tier_3_quantity))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_3 / 2),
                                Materials.Bedrockium.getMolten(tier_3_quantity))
                        .duration(base_time / 4).eut(118_638_885).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_4_quantity = tier_3_quantity * tier_up_multiplier;
                long fuel_quantity_4 = 7337L;

                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_4),
                                Materials.Steel.getMolten(tier_4_quantity))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_4),
                                Materials.Bedrockium.getMolten(tier_4_quantity))
                        .duration(base_time / 8).eut(237_277_769).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);
            }

            if (mGTPlusPlus) {
                // Hypogen v1
                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                new FluidStack(ELEMENT.STANDALONE.HYPOGEN.getFluid(), 144),
                                Materials.Neutronium.getMolten(5760L),
                                new FluidStack(ALLOY.QUANTUM.getFluid(), 5760),
                                Materials.Infinity.getMolten(1440L),
                                MaterialsUEVplus.ExcitedDTPC.getFluid(1000))
                        .fluidOutputs(
                                new FluidStack(ELEMENT.STANDALONE.HYPOGEN.getFluid(), 1584),
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(1000L / 4))
                        .duration(1 * MINUTES + 15 * SECONDS).eut(800_000_000).metadata(COIL_HEAT, infinity_heat)
                        .addTo(sPlasmaForgeRecipes);

                // Hypogen v2
                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                Materials.Neutronium.getMolten(5760L),
                                new FluidStack(ALLOY.QUANTUM.getFluid(), 5760),
                                Materials.Infinity.getMolten(1440L),
                                MaterialsUEVplus.ExcitedDTRC.getFluid(1000))
                        .fluidOutputs(
                                new FluidStack(ELEMENT.STANDALONE.HYPOGEN.getFluid(), 2880),
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(1000L / 2))
                        .duration(1 * MINUTES + 15 * SECONDS).eut(1_200_000_000).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(sPlasmaForgeRecipes);

                // Hypogen v3
                GT_Values.RA.stdBuilder()
                        .itemInputs(GT_ModHandler.getModItem(GTPlusPlus.ID, "MU-metaitem.01", 0L, 32100))
                        .noItemOutputs()
                        .fluidInputs(
                                Materials.Neutronium.getMolten(5760L),
                                new FluidStack(ALLOY.QUANTUM.getFluid(), 5760),
                                Materials.Infinity.getMolten(1440L),
                                MaterialsUEVplus.ExcitedDTEC.getFluid(1000))
                        .fluidOutputs(
                                new FluidStack(ELEMENT.STANDALONE.HYPOGEN.getFluid(), 5760),
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(1000L))
                        .duration(1 * MINUTES + 15 * SECONDS).eut(1_600_000_000).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);

                // Hypogen v4
                GT_Values.RA.stdBuilder()
                        .itemInputs(GT_ModHandler.getModItem(GTPlusPlus.ID, "MU-metaitem.01", 0L, 32100))
                        .noItemOutputs()
                        .fluidInputs(
                                Materials.Neutronium.getMolten(5760L * 2),
                                new FluidStack(ALLOY.QUANTUM.getFluid(), 5760),
                                Materials.Infinity.getMolten(1440L),
                                MaterialsUEVplus.ExcitedDTSC.getFluid(1000))
                        .fluidOutputs(
                                new FluidStack(ELEMENT.STANDALONE.HYPOGEN.getFluid(), 5760 * 2),
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(2000L))
                        .duration(1 * MINUTES + 15 * SECONDS).eut(2_000_000_000).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);

                {
                    // Chromatic Glass

                    long base_quantity = 256L;
                    long tier_up_multiplier = 2L;

                    int base_time = 3000;

                    long tier_1_quantity = 144L * base_quantity;
                    long fuel_quantity_1 = 156040L;

                    GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                            .fluidInputs(
                                    MaterialsUEVplus.ExcitedDTCC.getFluid(fuel_quantity_1),
                                    Materials.Glass.getMolten(tier_1_quantity))
                            .fluidOutputs(
                                    MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 8),
                                    new FluidStack(
                                            FluidRegistry.getFluid("molten.chromaticglass"),
                                            (int) tier_1_quantity))
                            .duration(base_time).eut(50_331_648).metadata(COIL_HEAT, awakened_heat)
                            .addTo(sPlasmaForgeRecipes);

                    long tier_2_quantity = tier_1_quantity * tier_up_multiplier;
                    long fuel_quantity_2 = 61060L;

                    GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                            .fluidInputs(
                                    MaterialsUEVplus.ExcitedDTPC.getFluid(fuel_quantity_2),
                                    Materials.Glass.getMolten(tier_2_quantity))
                            .fluidOutputs(
                                    MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2 / 4),
                                    new FluidStack(
                                            FluidRegistry.getFluid("molten.chromaticglass"),
                                            (int) tier_2_quantity))
                            .duration(base_time / 2).eut(100_663_296).metadata(COIL_HEAT, infinity_heat)
                            .addTo(sPlasmaForgeRecipes);

                    long tier_3_quantity = tier_2_quantity * tier_up_multiplier;
                    long fuel_quantity_3 = 26350L;
                    GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                            .fluidInputs(
                                    MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_3),
                                    Materials.Glass.getMolten(tier_3_quantity))
                            .fluidOutputs(
                                    MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_3 / 2),
                                    new FluidStack(
                                            FluidRegistry.getFluid("molten.chromaticglass"),
                                            (int) tier_3_quantity))
                            .duration(base_time / 4).eut(201_326_592).metadata(COIL_HEAT, hypogen_heat)
                            .addTo(sPlasmaForgeRecipes);

                    long tier_4_quantity = tier_3_quantity * tier_up_multiplier;
                    long fuel_quantity_4 = 11117L;
                    GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                            .fluidInputs(
                                    MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_4),
                                    Materials.Glass.getMolten(tier_4_quantity))
                            .fluidOutputs(
                                    MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_4),
                                    new FluidStack(
                                            FluidRegistry.getFluid("molten.chromaticglass"),
                                            (int) tier_4_quantity))
                            .duration(base_time / 8).eut(402_653_184).metadata(COIL_HEAT, eternal_heat)
                            .addTo(sPlasmaForgeRecipes);
                }

                // SpaceTime v1
                GT_Values.RA.stdBuilder().itemInputs(ItemList.EnergisedTesseract.get(1)).noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(10000L),
                                Materials.Infinity.getMolten(2304L),
                                new FluidStack(ELEMENT.STANDALONE.HYPOGEN.getFluid(), 1152))
                        .fluidOutputs(MaterialsUEVplus.SpaceTime.getMolten(144L)).duration(40 * SECONDS)
                        .eut(1_000_000_000).metadata(COIL_HEAT, hypogen_heat).addTo(sPlasmaForgeRecipes);

                // Spacetime v2
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                ItemList.EnergisedTesseract.get(1),
                                GT_ModHandler.getModItem(GTPlusPlus.ID, "MU-metaitem.01", 0L, 32100))
                        .noItemOutputs()
                        .fluidInputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(5000L),
                                Materials.Infinity.getMolten(1152L))
                        .fluidOutputs(MaterialsUEVplus.SpaceTime.getMolten(576L)).duration(20 * SECONDS)
                        .eut(2_000_000_000).metadata(COIL_HEAT, eternal_heat).addTo(sPlasmaForgeRecipes);

                // Raw Tesseract recipe
                // 16 Vertices, 24 faces and 32 edges.
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.CosmicNeutronium, 8L),
                                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemRodOctiron", 8L),
                                GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedstick", 8L, 10106),
                                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Sunnarium, 8L),
                                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemPlateAbyssalAlloy", 24L),
                                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemScrewBotmium", 16L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 1L))
                        .itemOutputs(ItemList.Tesseract.get(4)).fluidInputs(MaterialsUEVplus.ExcitedDTRC.getFluid(1000))
                        .fluidOutputs(MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(1000 / 2))
                        .duration(40 * SECONDS).eut(32_000_000).metadata(COIL_HEAT, infinity_heat)
                        .addTo(sPlasmaForgeRecipes);

                // Raw Tesseract v2
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.CosmicNeutronium, 12L),
                                GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedstick", 12L, 10106),
                                GT_OreDictUnificator.get(OrePrefixes.stick, MaterialsUEVplus.TranscendentMetal, 8L),
                                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemPlateBotmium", 24L),
                                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemScrewArcanite", 16L),
                                GT_ModHandler.getModItem(SuperSolarPanels.ID, "enderquantumcomponent", 1L))
                        .itemOutputs(ItemList.Tesseract.get(8)).fluidInputs(MaterialsUEVplus.ExcitedDTEC.getFluid(1000))
                        .fluidOutputs(MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(1000))
                        .duration(40 * SECONDS).eut(128_000_000).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);

                // Raw Tesseract v3
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_OreDictUnificator.get(OrePrefixes.stick, MaterialsUEVplus.TranscendentMetal, 32L),
                                ALLOY.BLACK_TITANIUM.getPlate(24),
                                ALLOY.ZERON_100.getScrew(16),
                                GT_ModHandler.getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1L, 32105))
                        .itemOutputs(ItemList.Tesseract.get(16))
                        .fluidInputs(MaterialsUEVplus.ExcitedDTSC.getFluid(1000))
                        .fluidOutputs(MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(2000))
                        .duration(40 * SECONDS).eut(512_000_000).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);

                // Transcendent metal
                GT_Values.RA.stdBuilder()
                        .itemInputs(ItemList.Tesseract.get(32), GT_OreDictUnificator.get("blockCosmicNeutronium", 40))
                        .itemOutputs(
                                MaterialsUEVplus.TranscendentMetal.getBlocks(40),
                                MaterialsUEVplus.TranscendentMetal.getDust(24))
                        .fluidInputs(
                                ALLOY.TITANSTEEL.getFluidStack(144 * 40 * 9),
                                Materials.CallistoIce.getMolten(144 * 20 * 9),
                                Materials.Ledox.getMolten(144 * 20 * 9),
                                Materials.Tungsten.getMolten(144 * 40 * 9),
                                MaterialsUEVplus.ExcitedDTSC.getFluid(5632))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(5632 * 2),
                                ELEMENT.STANDALONE.CELESTIAL_TUNGSTEN.getFluidStack(144 * 20 * 9))
                        .duration(40 * SECONDS).eut(256_000_000).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);

                // Quantum + Astral Titanium
                GT_Values.RA.stdBuilder().itemInputs(
                        CI.getEnergyCore(9, 0),
                        BlockList.Quantinum.getIS(2),
                        // Quantum Anomaly
                        GT_ModHandler.getModItem(GTPlusPlus.ID, "MU-metaitem.01", 2, 32105))
                        .itemOutputs(ELEMENT.STANDALONE.ASTRAL_TITANIUM.getBlock(2))
                        .fluidInputs(
                                ALLOY.BLACK_TITANIUM.getFluidStack(144 * 320 * 7 / 10),
                                Materials.Americium.getMolten(144 * 320 / 10),
                                Materials.Bismuth.getMolten(144 * 320 / 10),
                                ELEMENT.STANDALONE.HYPOGEN.getFluidStack(144 * 320 / 10),
                                Materials.Titanium.getPlasma(144 * 9 * 2 * 2),
                                MaterialsUEVplus.ExcitedDTEC.getFluid(8547))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(8547),
                                ALLOY.QUANTUM.getFluidStack(144 * 320))
                        .duration(27 * SECONDS).eut(1_543_932_302).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);

                // Quantum + Astral Titanium v2
                GT_Values.RA.stdBuilder().itemInputs(
                        CI.getEnergyCore(9, 0),
                        BlockList.Quantinum.getIS(4),
                        // Quantum Anomaly
                        GT_ModHandler.getModItem(GTPlusPlus.ID, "MU-metaitem.01", 3, 32105))
                        .itemOutputs(ELEMENT.STANDALONE.ASTRAL_TITANIUM.getBlock(4))
                        .fluidInputs(
                                ALLOY.BLACK_TITANIUM.getFluidStack(144 * 640 * 7 / 10),
                                Materials.Americium.getMolten(144 * 640 / 10),
                                Materials.Bismuth.getMolten(144 * 640 / 10),
                                ELEMENT.STANDALONE.HYPOGEN.getFluidStack(144 * 640 / 10),
                                Materials.Titanium.getPlasma(144 * 9 * 4 * 2),
                                MaterialsUEVplus.ExcitedDTSC.getFluid(3801))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(3801 * 2),
                                ALLOY.QUANTUM.getFluidStack(144 * 640))
                        .duration(13 * SECONDS + 10 * TICKS).eut(1_543_932_303).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);

                // Timepiece
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                getModItem(GTPlusPlus.ID, "gtplusplus.blockcasings.5", 0, 14),
                                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.DarkIron, 1L),
                                Materials.Dilithium.getGems(32),
                                MaterialsUEVplus.Universium.getNanite(1))
                        .itemOutputs(ItemList.Timepiece.get(3))
                        .fluidInputs(
                                MaterialsUEVplus.Time.getMolten(18432L * 8),
                                MaterialsUEVplus.ExcitedDTSC.getFluid(100000L))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(100000L * 2),
                                MaterialsUEVplus.Space.getMolten(18432L * 8))
                        .duration(80 * SECONDS).eut(TierEU.RECIPE_MAX).metadata(COIL_HEAT, 13500)
                        .addTo(sPlasmaForgeRecipes);

                // Time to Space
                GT_Values.RA.stdBuilder().itemInputs(
                        // Spacetime Continuum Ripper
                        getModItem(GTPlusPlus.ID, "gtplusplus.blockcasings.5", 0, 10),
                        ItemList.EnergisedTesseract.get(2),
                        // Quantum Anomaly
                        GT_ModHandler.getModItem(GTPlusPlus.ID, "MU-metaitem.01", 16, 32105))
                        .itemOutputs(ItemList.Tesseract.get(1))
                        .fluidInputs(
                                MaterialsUEVplus.Time.getMolten(9216L * 64),
                                MaterialsUEVplus.SpaceTime.getMolten(9216L * 16),
                                MaterialsUEVplus.ExcitedDTSC.getFluid(1000L))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(1000L * 2),
                                MaterialsUEVplus.Space.getMolten(9216L * 64))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MAX).metadata(COIL_HEAT, 13500)
                        .addTo(sPlasmaForgeRecipes);

                // Space to Time
                GT_Values.RA.stdBuilder().itemInputs(
                        // Spacetime Continuum Ripper
                        getModItem(GTPlusPlus.ID, "gtplusplus.blockcasings.5", 0, 10),
                        ItemList.EnergisedTesseract.get(2),
                        ItemList.Timepiece.get(16)).itemOutputs(ItemList.Tesseract.get(1))
                        .fluidInputs(
                                MaterialsUEVplus.Space.getMolten(9216L * 64),
                                MaterialsUEVplus.SpaceTime.getMolten(9216L * 16),
                                MaterialsUEVplus.ExcitedDTSC.getFluid(1000L))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(1000L * 2),
                                MaterialsUEVplus.Time.getMolten(9216L * 64))
                        .duration(10 * SECONDS).eut(TierEU.RECIPE_MAX).metadata(COIL_HEAT, 13500)
                        .addTo(sPlasmaForgeRecipes);
            }

            if (Avaritia.isModLoaded()) {
                // Plasma forge infinity Smelting.

                int base_time = 5_000;

                // Bee comb catalyst recipes for infinity
                long fuel_quantity_5 = (long) (11_373 * 0.9);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(Avaritia.ID, "Resource", 4L, 5),
                                GT_ModHandler.getModItem(GregTech.ID, "gt.comb", 1L, 119),
                                GT_Utility.getIntegratedCircuit(3))
                        .noItemOutputs().fluidInputs(MaterialsUEVplus.ExcitedDTSC.getFluid(fuel_quantity_5))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_5 * 2),
                                Materials.Infinity.getMolten(256L * 144L))
                        .duration(base_time / 8).eut(409_600_000).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);

                long fuel_quantity_3 = (long) (26_244 * 0.85);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(Avaritia.ID, "Resource", 2L, 5),
                                GT_ModHandler.getModItem(GregTech.ID, "gt.comb", 1L, 119),
                                GT_Utility.getIntegratedCircuit(3))
                        .noItemOutputs().fluidInputs(MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_3))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_3),
                                Materials.Infinity.getMolten(128L * 144L))
                        .duration(base_time / 4).eut(204_800_000).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);

                long fuel_quantity_4 = (long) (58_932 * 0.85);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 5),
                                GT_ModHandler.getModItem(GregTech.ID, "gt.comb", 1L, 119),
                                GT_Utility.getIntegratedCircuit(2))
                        .noItemOutputs().fluidInputs(MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_4))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_4 / 2),
                                Materials.Infinity.getMolten(64L * 144L))
                        .duration(base_time / 2).eut(102_400_000).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(sPlasmaForgeRecipes);

                long fuel_quantity_special_bee = (long) ((58_932L / 64) * 0.75);

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 5),
                                GT_ModHandler.getModItem(GregTech.ID, "gt.comb", 1L, 119),
                                GT_Utility.getIntegratedCircuit(3))
                        .noItemOutputs().fluidInputs(MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_special_bee))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue
                                        .getFluid(fuel_quantity_special_bee / 2),
                                Materials.Infinity.getMolten(144L))
                        .duration(base_time / 256).eut(102_400_000 / 64).metadata(COIL_HEAT, awakened_heat)
                        .addTo(sPlasmaForgeRecipes);

                // normal recipes

                long fuel_quantity_special = 58_932L / 64;

                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 5),
                                GT_Utility.getIntegratedCircuit(4))
                        .noItemOutputs().fluidInputs(MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_special))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_special / 2),
                                Materials.Infinity.getMolten(144L))
                        .duration(base_time / 128).eut(102_400_000 / 64).metadata(COIL_HEAT, awakened_heat)
                        .addTo(sPlasmaForgeRecipes);

                long fuel_quantity_1 = 58_932L;
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 5),
                                GT_Utility.getIntegratedCircuit(1))
                        .noItemOutputs().fluidInputs(MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_1))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 2),
                                Materials.Infinity.getMolten(64L * 144L))
                        .duration(base_time).eut(102_400_000).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(sPlasmaForgeRecipes);

                long fuel_quantity_2 = 26_244L;
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(Avaritia.ID, "Resource", 2L, 5),
                                GT_Utility.getIntegratedCircuit(4))
                        .noItemOutputs().fluidInputs(MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_2))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2),
                                Materials.Infinity.getMolten(128L * 144L))
                        .duration(base_time / 2).eut(204_800_000).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);

                long fuel_quantity_6 = 11_373L;
                GT_Values.RA.stdBuilder()
                        .itemInputs(
                                GT_ModHandler.getModItem(Avaritia.ID, "Resource", 4L, 5),
                                GT_Utility.getIntegratedCircuit(4))
                        .noItemOutputs().fluidInputs(MaterialsUEVplus.ExcitedDTSC.getFluid(fuel_quantity_6))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_6 * 2),
                                Materials.Infinity.getMolten(256L * 144L))
                        .duration(base_time / 4).eut(409_600_000).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);
            }

            // UV Superconductor.

            {
                long base_quantity = 2043L;
                long tier_up_multiplier = 2L;

                int base_time = 5040;

                long tier_1_quantity = 144L * base_quantity;
                long fuel_quantity_1 = 2491L;
                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                Materials.Samarium.getMolten(tier_1_quantity / 9),
                                Materials.Europium.getMolten(tier_1_quantity / 9),
                                Materials.Osmiridium.getMolten(3L * tier_1_quantity / 9),
                                Materials.Naquadria.getMolten(4L * tier_1_quantity / 9),
                                MaterialsUEVplus.ExcitedDTCC.getFluid(fuel_quantity_1))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 8),
                                Materials.Longasssuperconductornameforuvwire.getMolten(tier_1_quantity))
                        .duration(base_time).eut(14_345_265).metadata(COIL_HEAT, awakened_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_2_quantity = 144L * base_quantity * tier_up_multiplier;
                long fuel_quantity_2 = 1354L;
                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                Materials.Samarium.getMolten(tier_2_quantity / 9),
                                Materials.Europium.getMolten(tier_2_quantity / 9),
                                Materials.Osmiridium.getMolten(3L * tier_2_quantity / 9),
                                Materials.Naquadria.getMolten(4L * tier_2_quantity / 9),
                                MaterialsUEVplus.ExcitedDTPC.getFluid(fuel_quantity_2))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2 / 4),
                                Materials.Longasssuperconductornameforuvwire.getMolten(tier_2_quantity))
                        .duration(base_time / 2).eut(28_690_530).metadata(COIL_HEAT, infinity_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_3_quantity = 144L * base_quantity * tier_up_multiplier * tier_up_multiplier;
                long fuel_quantity_3 = 671L;
                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                Materials.Samarium.getMolten(tier_3_quantity / 9),
                                Materials.Europium.getMolten(tier_3_quantity / 9),
                                Materials.Osmiridium.getMolten(3L * tier_3_quantity / 9),
                                Materials.Naquadria.getMolten(4L * tier_3_quantity / 9),
                                MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_3))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_3 / 2),
                                Materials.Longasssuperconductornameforuvwire.getMolten(tier_3_quantity))
                        .duration(base_time / 4).eut(57_381_060).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_4_quantity = 144L * base_quantity
                        * tier_up_multiplier
                        * tier_up_multiplier
                        * tier_up_multiplier;
                long fuel_quantity_4 = 303L;
                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                Materials.Samarium.getMolten(tier_4_quantity / 9),
                                Materials.Europium.getMolten(tier_4_quantity / 9),
                                Materials.Osmiridium.getMolten(3L * tier_4_quantity / 9),
                                Materials.Naquadria.getMolten(4L * tier_4_quantity / 9),
                                MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_4))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_4),
                                Materials.Longasssuperconductornameforuvwire.getMolten(tier_4_quantity))
                        .duration(base_time / 8).eut(114_762_120).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);
            }

            // UHV Superconductor.

            {
                long base_quantity = 1008L;
                long tier_up_multiplier = 2L;

                int base_time = 3150;

                long tier_1_quantity = 144L * base_quantity;
                long fuel_quantity_1 = 44_384L;
                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                Materials.Draconium.getMolten(6L * tier_1_quantity / 24),
                                Materials.Americium.getMolten(6L * tier_1_quantity / 24),
                                Materials.CosmicNeutronium.getMolten(7L * tier_1_quantity / 24),
                                Materials.Tritanium.getMolten(5L * tier_1_quantity / 24),
                                MaterialsUEVplus.ExcitedDTPC.getFluid(fuel_quantity_1))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 4),
                                Materials.Longasssuperconductornameforuhvwire.getMolten(tier_1_quantity))
                        .duration(base_time).eut(62_717_952).metadata(COIL_HEAT, infinity_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_2_quantity = 144L * base_quantity * tier_up_multiplier;
                long fuel_quantity_2 = 19_806L;
                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                Materials.Draconium.getMolten(6L * tier_2_quantity / 24),
                                Materials.Americium.getMolten(6L * tier_2_quantity / 24),
                                Materials.CosmicNeutronium.getMolten(7L * tier_2_quantity / 24),
                                Materials.Tritanium.getMolten(5L * tier_2_quantity / 24),
                                MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_2))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2 / 2),
                                Materials.Longasssuperconductornameforuhvwire.getMolten(tier_2_quantity))
                        .duration(base_time / 2).eut(125_435_904).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_3_quantity = 144L * base_quantity * tier_up_multiplier * tier_up_multiplier;
                long fuel_quantity_3 = 8_654L;
                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                Materials.Draconium.getMolten(6L * tier_3_quantity / 24),
                                Materials.Americium.getMolten(6L * tier_3_quantity / 24),
                                Materials.CosmicNeutronium.getMolten(7L * tier_3_quantity / 24),
                                Materials.Tritanium.getMolten(5L * tier_3_quantity / 24),
                                MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_3))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_3),
                                Materials.Longasssuperconductornameforuhvwire.getMolten(tier_3_quantity))
                        .duration(base_time / 4).eut(250_871_808).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_4_quantity = 144L * base_quantity * (long) Math.pow(tier_up_multiplier, 3);
                long fuel_quantity_4 = 4_389L;
                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs()
                        .fluidInputs(
                                Materials.Draconium.getMolten(6L * tier_4_quantity / 24),
                                Materials.Americium.getMolten(6L * tier_4_quantity / 24),
                                Materials.CosmicNeutronium.getMolten(7L * tier_4_quantity / 24),
                                Materials.Tritanium.getMolten(5L * tier_4_quantity / 24),
                                MaterialsUEVplus.ExcitedDTSC.getFluid(fuel_quantity_4))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_4 * 2),
                                Materials.Longasssuperconductornameforuhvwire.getMolten(tier_4_quantity))
                        .duration(base_time / 8).eut(501_743_616).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);
            }

            // UEV Superconductors.

            if (GTPlusPlus.isModLoaded()) {

                long base_quantity = 504L;
                long tier_up_multiplier = 2L;

                int base_time = 7431;

                long tier_1_quantity = 144L * base_quantity;
                long fuel_quantity_1 = 40_477;

                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs().fluidInputs(
                        new FluidStack(FluidRegistry.getFluid("molten.advancednitinol"), (int) tier_1_quantity / 12),
                        new FluidStack(FluidRegistry.getFluid("molten.celestialtungsten"), (int) tier_1_quantity / 12),
                        Materials.DraconiumAwakened.getMolten(5L * tier_1_quantity / 12),
                        Materials.Infinity.getMolten(5L * tier_1_quantity / 12),
                        Materials.Iron.getPlasma(tier_1_quantity / 12),
                        MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_1))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 2),
                                Materials.SuperconductorUEVBase.getMolten(tier_1_quantity))
                        .duration(base_time / 2).eut(195_457_244).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_2_quantity = 144L * base_quantity * tier_up_multiplier;
                long fuel_quantity_2 = 18_274;

                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs().fluidInputs(
                        new FluidStack(FluidRegistry.getFluid("molten.advancednitinol"), (int) tier_2_quantity / 12),
                        new FluidStack(FluidRegistry.getFluid("molten.celestialtungsten"), (int) tier_2_quantity / 12),
                        Materials.DraconiumAwakened.getMolten(5L * tier_2_quantity / 12),
                        Materials.Infinity.getMolten(5L * tier_2_quantity / 12),
                        Materials.Iron.getPlasma(tier_2_quantity / 12),
                        MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_2))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2),
                                Materials.SuperconductorUEVBase.getMolten(tier_2_quantity))
                        .duration(base_time / 4).eut(390_914_488).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_3_quantity = 144L * base_quantity * tier_up_multiplier * tier_up_multiplier;
                long fuel_quantity_3 = 7_981;

                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs().fluidInputs(
                        new FluidStack(FluidRegistry.getFluid("molten.advancednitinol"), (int) tier_3_quantity / 12),
                        new FluidStack(FluidRegistry.getFluid("molten.celestialtungsten"), (int) tier_3_quantity / 12),
                        Materials.DraconiumAwakened.getMolten(5L * tier_3_quantity / 12),
                        Materials.Infinity.getMolten(5L * tier_3_quantity / 12),
                        Materials.Iron.getPlasma(tier_3_quantity / 12),
                        MaterialsUEVplus.ExcitedDTSC.getFluid(fuel_quantity_3))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_3 * 2),
                                Materials.SuperconductorUEVBase.getMolten(tier_3_quantity))
                        .duration(base_time / 8).eut(781_828_976).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);
            }

            // UIV Superconductors.

            if (GTPlusPlus.isModLoaded()) {

                long base_quantity = 250L;
                long tier_up_multiplier = 2L;

                int base_time = 7431;

                long tier_1_quantity = 144L * base_quantity;
                long fuel_quantity_1 = 77_448;

                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs().fluidInputs(
                        GT_CoreModSupport.RadoxPolymer.getMolten(4L * tier_1_quantity / 25),
                        MaterialsUEVplus.TranscendentMetal.getMolten(10L * tier_1_quantity / 25),
                        new FluidStack(FluidRegistry.getFluid("molten.rhugnor"), (int) tier_1_quantity * 6 / 25),
                        new FluidStack(FluidRegistry.getFluid("molten.chromaticglass"), (int) tier_1_quantity * 5 / 25),
                        Materials.Bismuth.getPlasma(tier_1_quantity / 25),
                        MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_1))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 2),
                                Materials.SuperconductorUIVBase.getMolten(tier_1_quantity))
                        .duration(base_time / 2).eut(374_265_584).metadata(COIL_HEAT, hypogen_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_2_quantity = 144L * base_quantity * tier_up_multiplier;
                long fuel_quantity_2 = 34_992;

                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs().fluidInputs(
                        GT_CoreModSupport.RadoxPolymer.getMolten(4L * tier_2_quantity / 25),
                        MaterialsUEVplus.TranscendentMetal.getMolten(10L * tier_2_quantity / 25),
                        new FluidStack(FluidRegistry.getFluid("molten.rhugnor"), (int) tier_2_quantity * 6 / 25),
                        new FluidStack(FluidRegistry.getFluid("molten.chromaticglass"), (int) tier_2_quantity * 5 / 25),
                        Materials.Bismuth.getPlasma(tier_2_quantity / 25),
                        MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_2))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2),
                                Materials.SuperconductorUIVBase.getMolten(tier_2_quantity))
                        .duration(base_time / 4).eut(748_531_167).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_3_quantity = 144L * base_quantity * tier_up_multiplier * tier_up_multiplier;
                long fuel_quantity_3 = 15_282;

                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs().fluidInputs(
                        GT_CoreModSupport.RadoxPolymer.getMolten(4L * tier_3_quantity / 25),
                        MaterialsUEVplus.TranscendentMetal.getMolten(10L * tier_3_quantity / 25),
                        new FluidStack(FluidRegistry.getFluid("molten.rhugnor"), (int) tier_3_quantity * 6 / 25),
                        new FluidStack(FluidRegistry.getFluid("molten.chromaticglass"), (int) tier_3_quantity * 5 / 25),
                        Materials.Bismuth.getPlasma(tier_3_quantity / 25),
                        MaterialsUEVplus.ExcitedDTSC.getFluid(fuel_quantity_3))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_3 * 2),
                                Materials.SuperconductorUIVBase.getMolten(tier_3_quantity))
                        .duration(base_time / 8).eut(1_497_062_335).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);
            }

            // UMV Superconductors.

            if (GoodGenerator.isModLoaded()) {

                long base_quantity = 243L;
                long tier_up_multiplier = 4L;

                int base_time = 3715;

                long tier_1_quantity = 144L * base_quantity;
                long fuel_quantity_1 = 65_536;
                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs().fluidInputs(
                        MaterialsUEVplus.SpaceTime.getMolten(6L * tier_1_quantity / 27),
                        new FluidStack(FluidRegistry.getFluid("molten.orundum"), (int) tier_1_quantity * 3 / 27),
                        new FluidStack(FluidRegistry.getFluid("molten.hypogen"), (int) tier_1_quantity * 11 / 27),
                        new FluidStack(FluidRegistry.getFluid("molten.titansteel"), (int) tier_1_quantity * 5 / 27),
                        new FluidStack(FluidRegistry.getFluid("molten.dragonblood"), (int) tier_1_quantity * 2 / 27),
                        Materials.Oxygen.getPlasma(tier_1_quantity / 27),
                        MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_1))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1),
                                Materials.SuperconductorUMVBase.getMolten(tier_1_quantity))
                        .duration(base_time).eut(1_455_144_621).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);

                long tier_2_quantity = 144L * base_quantity * tier_up_multiplier;
                long fuel_quantity_2 = 59_416;

                GT_Values.RA.stdBuilder().noItemInputs().noItemOutputs().fluidInputs(
                        MaterialsUEVplus.SpaceTime.getMolten(6L * tier_2_quantity / 27),
                        new FluidStack(FluidRegistry.getFluid("molten.orundum"), (int) tier_2_quantity * 3 / 27),
                        new FluidStack(FluidRegistry.getFluid("molten.hypogen"), (int) tier_2_quantity * 11 / 27),
                        new FluidStack(FluidRegistry.getFluid("molten.titansteel"), (int) tier_2_quantity * 5 / 27),
                        new FluidStack(FluidRegistry.getFluid("molten.dragonblood"), (int) tier_2_quantity * 2 / 27),
                        Materials.Oxygen.getPlasma(tier_2_quantity / 27),
                        MaterialsUEVplus.ExcitedDTSC.getFluid(fuel_quantity_2))
                        .fluidOutputs(
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2 * 2),
                                Materials.SuperconductorUMVBase.getMolten(tier_2_quantity))
                        .duration(base_time).eut(1_455_144_621).metadata(COIL_HEAT, eternal_heat)
                        .addTo(sPlasmaForgeRecipes);
            }
        }
    }
}
