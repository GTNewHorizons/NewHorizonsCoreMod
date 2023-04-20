package com.dreammaster.gthandler.recipes;

import static gregtech.api.GregTech_API.mGTPlusPlus;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.GoodGenerator;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.SuperSolarPanels;

import gregtech.api.enums.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.GT_CoreModSupport;

import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gtPlusPlus.core.material.ALLOY;
import gtPlusPlus.core.material.ELEMENT;

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
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTCC.getFluid(fuel_quantity_1),
                                Materials.Iron.getMolten(tier_1_quantity) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 8),
                                Materials.Neutronium.getMolten(tier_1_quantity) },
                        base_time,
                        25_165_824,
                        awakened_heat);

                long tier_2_quantity = 144L * base_quantity * tier_up_multiplier;
                long fuel_quantity_2 = 25442L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTPC.getFluid(fuel_quantity_2),
                                Materials.Iron.getMolten(tier_2_quantity) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2 / 4),
                                Materials.Neutronium.getMolten(tier_2_quantity) },
                        base_time / 2,
                        50_331_648,
                        infinity_heat);

                long tier_3_quantity = 144L * base_quantity * tier_up_multiplier * tier_up_multiplier;
                long fuel_quantity_3 = 10979L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_3),
                                Materials.Iron.getMolten(tier_3_quantity) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_3 / 2),
                                Materials.Neutronium.getMolten(tier_3_quantity) },
                        base_time / 4,
                        100_663_296,
                        hypogen_heat);

                long tier_4_quantity = 144L * base_quantity
                        * tier_up_multiplier
                        * tier_up_multiplier
                        * tier_up_multiplier;
                long fuel_quantity_4 = 4632L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_4),
                                Materials.Iron.getMolten(tier_4_quantity) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_4),
                                Materials.Neutronium.getMolten(tier_4_quantity) },
                        base_time / 8,
                        201_326_592,
                        eternal_heat);
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
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem(GregTech.ID, "gt.comb", 1L, 117),
                                GT_Utility.getIntegratedCircuit(1) },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTCC.getFluid(fuel_quantity_bee_1),
                                Materials.Copper.getMolten(tier_1_quantity) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_bee_1 / 8),
                                Materials.CosmicNeutronium.getMolten(tier_1_quantity) },
                        base_time_bee,
                        7_115_337,
                        awakened_heat);

                long tier_2_bee_quantity = 144L * base_quantity * tier_up_multiplier;
                long fuel_quantity_bee_2 = (long) (12085L * 0.85);
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem(GregTech.ID, "gt.comb", 1L, 117),
                                GT_Utility.getIntegratedCircuit(1) },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTPC.getFluid(fuel_quantity_bee_2),
                                Materials.Copper.getMolten(tier_2_bee_quantity) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_bee_2 / 4),
                                Materials.CosmicNeutronium.getMolten(tier_2_bee_quantity) },
                        base_time_bee / 2,
                        14_230_674,
                        infinity_heat);

                long tier_3_bee_quantity = 144L * base_quantity * tier_up_multiplier * tier_up_multiplier;
                long fuel_quantity_bee_3 = (long) (5215L * 0.85);
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem(GregTech.ID, "gt.comb", 1L, 117),
                                GT_Utility.getIntegratedCircuit(1) },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_bee_3),
                                Materials.Copper.getMolten(tier_3_bee_quantity) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_bee_3 / 2),
                                Materials.CosmicNeutronium.getMolten(tier_3_bee_quantity) },
                        base_time_bee / 4,
                        28_461_349,
                        hypogen_heat);

                long tier_4_bee_quantity = 144L * base_quantity
                        * tier_up_multiplier
                        * tier_up_multiplier
                        * tier_up_multiplier;
                long fuel_quantity_bee_4 = (long) (2200L * 0.85);
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem(GregTech.ID, "gt.comb", 1L, 117),
                                GT_Utility.getIntegratedCircuit(1) },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_bee_4),
                                Materials.Copper.getMolten(tier_4_bee_quantity) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_bee_4),
                                Materials.CosmicNeutronium.getMolten(tier_4_bee_quantity) },
                        base_time_bee / 8,
                        56_922_697,
                        eternal_heat);

                // normal ones

                long fuel_quantity_1 = 30883L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Utility.getIntegratedCircuit(4) },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTCC.getFluid(fuel_quantity_1),
                                Materials.Copper.getMolten(tier_1_quantity) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 8),
                                Materials.CosmicNeutronium.getMolten(tier_1_quantity) },
                        base_time,
                        7_115_337,
                        awakened_heat);

                long tier_2_quantity = 144L * base_quantity * tier_up_multiplier;
                long fuel_quantity_2 = 12085L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Utility.getIntegratedCircuit(4) },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTPC.getFluid(fuel_quantity_2),
                                Materials.Copper.getMolten(tier_2_quantity) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2 / 4),
                                Materials.CosmicNeutronium.getMolten(tier_2_quantity) },
                        base_time / 2,
                        14_230_674,
                        infinity_heat);

                long tier_3_quantity = 144L * base_quantity * tier_up_multiplier * tier_up_multiplier;
                long fuel_quantity_3 = 5215L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Utility.getIntegratedCircuit(4) },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_3),
                                Materials.Copper.getMolten(tier_3_quantity) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_3 / 2),
                                Materials.CosmicNeutronium.getMolten(tier_3_quantity) },
                        base_time / 4,
                        28_461_349,
                        hypogen_heat);

                long tier_4_quantity = 144L * base_quantity
                        * tier_up_multiplier
                        * tier_up_multiplier
                        * tier_up_multiplier;
                long fuel_quantity_4 = 2200L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Utility.getIntegratedCircuit(4) },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_4),
                                Materials.Copper.getMolten(tier_4_quantity) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_4),
                                Materials.CosmicNeutronium.getMolten(tier_4_quantity) },
                        base_time / 8,
                        56_922_697,
                        eternal_heat);
            }

            {
                // Bedrockium.

                long base_quantity = 2048L;
                long tier_up_multiplier = 2L;

                int base_time = 3360;

                long tier_1_quantity = 144L * base_quantity;
                long fuel_quantity_1 = 102987L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTCC.getFluid(fuel_quantity_1),
                                Materials.Steel.getMolten(tier_1_quantity) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 8),
                                Materials.Bedrockium.getMolten(tier_1_quantity) },
                        base_time,
                        29_659_721,
                        awakened_heat);

                long tier_2_quantity = tier_1_quantity * tier_up_multiplier;
                long fuel_quantity_2 = 40299L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTPC.getFluid(fuel_quantity_2),
                                Materials.Steel.getMolten(tier_2_quantity) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2 / 4),
                                Materials.Bedrockium.getMolten(tier_2_quantity) },
                        base_time / 2,
                        59_319_442,
                        infinity_heat);

                long tier_3_quantity = tier_2_quantity * tier_up_multiplier;
                long fuel_quantity_3 = 17391L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_3),
                                Materials.Steel.getMolten(tier_3_quantity) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_3 / 2),
                                Materials.Bedrockium.getMolten(tier_3_quantity) },
                        base_time / 4,
                        118_638_885,
                        hypogen_heat);

                long tier_4_quantity = tier_3_quantity * tier_up_multiplier;
                long fuel_quantity_4 = 7337L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_4),
                                Materials.Steel.getMolten(tier_4_quantity) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_4),
                                Materials.Bedrockium.getMolten(tier_4_quantity) },
                        base_time / 8,
                        237_277_769,
                        eternal_heat);
            }

            if (mGTPlusPlus) {
                // Hypogen v1
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { new FluidStack(ELEMENT.STANDALONE.HYPOGEN.getFluid(), 144),
                                Materials.Neutronium.getMolten(5760L), new FluidStack(ALLOY.QUANTUM.getFluid(), 5760),
                                Materials.Infinity.getMolten(1440L), MaterialsUEVplus.ExcitedDTPC.getFluid(1000) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { new FluidStack(ELEMENT.STANDALONE.HYPOGEN.getFluid(), 1584),
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(1000L / 4) },
                        1500,
                        800_000_000,
                        infinity_heat);

                // Hypogen v2
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { Materials.Neutronium.getMolten(5760L),
                                new FluidStack(ALLOY.QUANTUM.getFluid(), 5760), Materials.Infinity.getMolten(1440L),
                                MaterialsUEVplus.ExcitedDTRC.getFluid(1000) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { new FluidStack(ELEMENT.STANDALONE.HYPOGEN.getFluid(), 2880),
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(1000L / 2) },
                        1500,
                        1_200_000_000,
                        hypogen_heat);

                // Hypogen v3
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem(GTPlusPlus.ID, "MU-metaitem.01", 0L, 32100) },
                        new FluidStack[] { Materials.Neutronium.getMolten(5760L),
                                new FluidStack(ALLOY.QUANTUM.getFluid(), 5760), Materials.Infinity.getMolten(1440L),
                                MaterialsUEVplus.ExcitedDTEC.getFluid(1000) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { new FluidStack(ELEMENT.STANDALONE.HYPOGEN.getFluid(), 5760),
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(1000L) },
                        1500,
                        1_600_000_000,
                        eternal_heat);

                {
                    // Chromatic Glass

                    long base_quantity = 256L;
                    long tier_up_multiplier = 2L;

                    int base_time = 3000;

                    long tier_1_quantity = 144L * base_quantity;
                    long fuel_quantity_1 = 156040L;
                    GT_Values.RA.addPlasmaForgeRecipe(
                            new ItemStack[] { GT_Values.NI },
                            new FluidStack[] { MaterialsUEVplus.ExcitedDTCC.getFluid(fuel_quantity_1),
                                    Materials.Glass.getMolten(tier_1_quantity) },
                            new ItemStack[] { GT_Values.NI },
                            new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 8),
                                    new FluidStack(
                                            FluidRegistry.getFluid("molten.chromaticglass"),
                                            (int) tier_1_quantity) },
                            base_time,
                            50_331_648,
                            awakened_heat);

                    long tier_2_quantity = tier_1_quantity * tier_up_multiplier;
                    long fuel_quantity_2 = 61060L;
                    GT_Values.RA.addPlasmaForgeRecipe(
                            new ItemStack[] { GT_Values.NI },
                            new FluidStack[] { MaterialsUEVplus.ExcitedDTPC.getFluid(fuel_quantity_2),
                                    Materials.Glass.getMolten(tier_2_quantity) },
                            new ItemStack[] { GT_Values.NI },
                            new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2 / 4),
                                    new FluidStack(
                                            FluidRegistry.getFluid("molten.chromaticglass"),
                                            (int) tier_2_quantity) },
                            base_time / 2,
                            100_663_296,
                            infinity_heat);

                    long tier_3_quantity = tier_2_quantity * tier_up_multiplier;
                    long fuel_quantity_3 = 26350L;
                    GT_Values.RA.addPlasmaForgeRecipe(
                            new ItemStack[] { GT_Values.NI },
                            new FluidStack[] { MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_3),
                                    Materials.Glass.getMolten(tier_3_quantity) },
                            new ItemStack[] { GT_Values.NI },
                            new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_3 / 2),
                                    new FluidStack(
                                            FluidRegistry.getFluid("molten.chromaticglass"),
                                            (int) tier_3_quantity) },
                            base_time / 4,
                            201_326_592,
                            hypogen_heat);

                    long tier_4_quantity = tier_3_quantity * tier_up_multiplier;
                    long fuel_quantity_4 = 11117L;
                    GT_Values.RA.addPlasmaForgeRecipe(
                            new ItemStack[] { GT_Values.NI },
                            new FluidStack[] { MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_4),
                                    Materials.Glass.getMolten(tier_4_quantity) },
                            new ItemStack[] { GT_Values.NI },
                            new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_4),
                                    new FluidStack(
                                            FluidRegistry.getFluid("molten.chromaticglass"),
                                            (int) tier_4_quantity) },
                            base_time / 8,
                            402_653_184,
                            eternal_heat);
                }

                // Energised tesseract
                GT_Values.RA
                        .addLaserEngraverRecipe(
                                new ItemStack[] { ItemList.Tesseract.get(1),
                                        GT_Utility.copyAmount(
                                                0L,
                                                GT_ModHandler
                                                        .getModItem(GTPlusPlus.ID, "MU-metaitem.01:>", 1, 32105)) },
                                new FluidStack[] { GT_Values.NF },
                                new ItemStack[] { ItemList.EnergisedTesseract.get(1) },
                                new FluidStack[] { MaterialsUEVplus.ExcitedDTEC.getFluid(100L) },
                                30 * 20,
                                32_000_000,
                                true);

                // SpaceTime v1
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { ItemList.EnergisedTesseract.get(1) },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(10000L),
                                Materials.Infinity.getMolten(2304L),
                                new FluidStack(ELEMENT.STANDALONE.HYPOGEN.getFluid(), 1152) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.SpaceTime.getMolten(144L) },
                        40 * 20,
                        1_000_000_000,
                        hypogen_heat);

                // Spacetime v2
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { ItemList.EnergisedTesseract.get(1),
                                GT_ModHandler.getModItem(GTPlusPlus.ID, "MU-metaitem.01", 0L, 32100) },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(5000L),
                                Materials.Infinity.getMolten(1152L) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.SpaceTime.getMolten(576L) },
                        20 * 20,
                        2_000_000_000,
                        eternal_heat);

                // Raw Tesseract recipe
                // 16 Vertices, 24 faces and 32 edges.
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.stick, Materials.CosmicNeutronium, 8L),
                                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemRodOctiron", 8L),
                                GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedstick", 8L, 10106),
                                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Sunnarium, 8L),
                                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemPlateAbyssalAlloy", 24L),
                                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemScrewBotmium", 16L),
                                GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Ultimate, 1L), },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTRC.getFluid(1000) },
                        new ItemStack[] { ItemList.Tesseract.get(4) },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(1000 / 2) },
                        40 * 20,
                        32_000_000,
                        infinity_heat);

                // Raw Tesseract v2
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.stick, Materials.CosmicNeutronium, 12L),
                                GT_ModHandler.getModItem(BartWorks.ID, "gt.bwMetaGeneratedstick", 12L, 10106),
                                GT_OreDictUnificator.get(OrePrefixes.stick, MaterialsUEVplus.TranscendentMetal, 8L),
                                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemPlateBotmium", 24L),
                                GT_ModHandler.getModItem(GTPlusPlus.ID, "itemScrewArcanite", 16L),
                                GT_ModHandler.getModItem(SuperSolarPanels.ID, "enderquantumcomponent", 1L), },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTEC.getFluid(1000) },
                        new ItemStack[] { ItemList.Tesseract.get(8) },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(1000) },
                        40 * 20,
                        128_000_000,
                        eternal_heat);
            }

            if (Avaritia.isModLoaded()) {
                // Plasma forge infinity Smelting.

                int base_time = 5_000;

                // Bee comb catalyst recipes for infinity
                long fuel_quantity_3 = (long) (25_767 * 0.85);
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem(Avaritia.ID, "Resource", 2L, 5),
                                GT_ModHandler.getModItem(GregTech.ID, "gt.comb", 1L, 119),
                                GT_Utility.getIntegratedCircuit(3) },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_3) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_3),
                                Materials.Infinity.getMolten(128L * 144L) },
                        base_time / 4,
                        204_800_000,
                        eternal_heat);

                long fuel_quantity_4 = (long) (57_031 * 0.85);
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 5),
                                GT_ModHandler.getModItem(GregTech.ID, "gt.comb", 1L, 119),
                                GT_Utility.getIntegratedCircuit(2) },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_4) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_4 / 2),
                                Materials.Infinity.getMolten(64L * 144L) },
                        base_time / 2,
                        102_400_000,
                        hypogen_heat);

                long fuel_quantity_special_bee = (long) ((57_031L / 64) * 0.75);
                GT_Values.RA
                        .addPlasmaForgeRecipe(
                                new ItemStack[] { GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 5),
                                        GT_ModHandler.getModItem(GregTech.ID, "gt.comb", 1L, 119),
                                        GT_Utility.getIntegratedCircuit(3) },
                                new FluidStack[] { MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_special_bee) },
                                new ItemStack[] { GT_Values.NI },
                                new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue
                                        .getFluid(fuel_quantity_special_bee / 2), Materials.Infinity.getMolten(144L) },
                                base_time / 256,
                                102_400_000 / 64,
                                awakened_heat);

                // normal recipes

                long fuel_quantity_special = 57_031L / 64;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 5),
                                GT_Utility.getIntegratedCircuit(4) },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_special) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] {
                                MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_special / 2),
                                Materials.Infinity.getMolten(144L) },
                        base_time / 128,
                        102_400_000 / 64,
                        awakened_heat);

                long fuel_quantity_1 = 57_031L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem(Avaritia.ID, "Resource", 1L, 5),
                                GT_Utility.getIntegratedCircuit(1) },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_1) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 2),
                                Materials.Infinity.getMolten(64L * 144L) },
                        base_time,
                        102_400_000,
                        hypogen_heat);

                long fuel_quantity_2 = 25_767L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_ModHandler.getModItem(Avaritia.ID, "Resource", 2L, 5),
                                GT_Utility.getIntegratedCircuit(4) },
                        new FluidStack[] { MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_2) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2),
                                Materials.Infinity.getMolten(128L * 144L) },
                        base_time / 2,
                        204_800_000,
                        eternal_heat);
            }

            // UV Superconductor.

            {
                long base_quantity = 2043L;
                long tier_up_multiplier = 2L;

                int base_time = 5040;

                long tier_1_quantity = 144L * base_quantity;
                long fuel_quantity_1 = 2491L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { Materials.Samarium.getMolten(tier_1_quantity / 9),
                                Materials.Europium.getMolten(tier_1_quantity / 9),
                                Materials.Osmiridium.getMolten(3L * tier_1_quantity / 9),
                                Materials.Naquadria.getMolten(4L * tier_1_quantity / 9),
                                MaterialsUEVplus.ExcitedDTCC.getFluid(fuel_quantity_1) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 8),
                                Materials.Longasssuperconductornameforuvwire.getMolten(tier_1_quantity) },
                        base_time,
                        14_345_265,
                        awakened_heat);

                long tier_2_quantity = 144L * base_quantity * tier_up_multiplier;
                long fuel_quantity_2 = 1354L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { Materials.Samarium.getMolten(tier_2_quantity / 9),
                                Materials.Europium.getMolten(tier_2_quantity / 9),
                                Materials.Osmiridium.getMolten(3L * tier_2_quantity / 9),
                                Materials.Naquadria.getMolten(4L * tier_2_quantity / 9),
                                MaterialsUEVplus.ExcitedDTPC.getFluid(fuel_quantity_2) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2 / 4),
                                Materials.Longasssuperconductornameforuvwire.getMolten(tier_2_quantity) },
                        base_time / 2,
                        28_690_530,
                        infinity_heat);

                long tier_3_quantity = 144L * base_quantity * tier_up_multiplier * tier_up_multiplier;
                long fuel_quantity_3 = 671L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { Materials.Samarium.getMolten(tier_3_quantity / 9),
                                Materials.Europium.getMolten(tier_3_quantity / 9),
                                Materials.Osmiridium.getMolten(3L * tier_3_quantity / 9),
                                Materials.Naquadria.getMolten(4L * tier_3_quantity / 9),
                                MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_3) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_3 / 2),
                                Materials.Longasssuperconductornameforuvwire.getMolten(tier_3_quantity) },
                        base_time / 4,
                        57_381_060,
                        hypogen_heat);

                long tier_4_quantity = 144L * base_quantity
                        * tier_up_multiplier
                        * tier_up_multiplier
                        * tier_up_multiplier;
                long fuel_quantity_4 = 303L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { Materials.Samarium.getMolten(tier_4_quantity / 9),
                                Materials.Europium.getMolten(tier_4_quantity / 9),
                                Materials.Osmiridium.getMolten(3L * tier_4_quantity / 9),
                                Materials.Naquadria.getMolten(4L * tier_4_quantity / 9),
                                MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_4) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_4),
                                Materials.Longasssuperconductornameforuvwire.getMolten(tier_4_quantity) },
                        base_time / 8,
                        114_762_120,
                        eternal_heat);
            }

            // UHV Superconductor.

            {
                long base_quantity = 1008L;
                long tier_up_multiplier = 2L;

                int base_time = 3150;

                long tier_1_quantity = 144L * base_quantity;
                long fuel_quantity_1 = 44_384L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { Materials.Draconium.getMolten(6L * tier_1_quantity / 24),
                                Materials.Americium.getMolten(6L * tier_1_quantity / 24),
                                Materials.CosmicNeutronium.getMolten(7L * tier_1_quantity / 24),
                                Materials.Tritanium.getMolten(5L * tier_1_quantity / 24),
                                MaterialsUEVplus.ExcitedDTPC.getFluid(fuel_quantity_1) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 4),
                                Materials.Longasssuperconductornameforuhvwire.getMolten(tier_1_quantity) },
                        base_time,
                        62_717_952,
                        infinity_heat);

                long tier_2_quantity = 144L * base_quantity * tier_up_multiplier;
                long fuel_quantity_2 = 19_806L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { Materials.Draconium.getMolten(6L * tier_2_quantity / 24),
                                Materials.Americium.getMolten(6L * tier_2_quantity / 24),
                                Materials.CosmicNeutronium.getMolten(7L * tier_2_quantity / 24),
                                Materials.Tritanium.getMolten(5L * tier_2_quantity / 24),
                                MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_2) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2 / 2),
                                Materials.Longasssuperconductornameforuhvwire.getMolten(tier_2_quantity) },
                        base_time / 2,
                        125_435_904,
                        hypogen_heat);

                long tier_3_quantity = 144L * base_quantity * tier_up_multiplier * tier_up_multiplier;
                long fuel_quantity_3 = 8_654L;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { Materials.Draconium.getMolten(6L * tier_3_quantity / 24),
                                Materials.Americium.getMolten(6L * tier_3_quantity / 24),
                                Materials.CosmicNeutronium.getMolten(7L * tier_3_quantity / 24),
                                Materials.Tritanium.getMolten(5L * tier_3_quantity / 24),
                                MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_3) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_3),
                                Materials.Longasssuperconductornameforuhvwire.getMolten(tier_3_quantity) },
                        base_time / 4,
                        250_871_808,
                        eternal_heat);
            }

            // UEV Superconductors.

            if (GTPlusPlus.isModLoaded()) {

                long base_quantity = 504L;
                long tier_up_multiplier = 2L;

                int base_time = 7431;

                long tier_1_quantity = 144L * base_quantity;
                long fuel_quantity_1 = 40_477;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] {
                                new FluidStack(
                                        FluidRegistry.getFluid("molten.advancednitinol"),
                                        (int) tier_1_quantity / 12),
                                new FluidStack(
                                        FluidRegistry.getFluid("molten.celestialtungsten"),
                                        (int) tier_1_quantity / 12),
                                Materials.DraconiumAwakened.getMolten(5L * tier_1_quantity / 12),
                                Materials.Infinity.getMolten(5L * tier_1_quantity / 12),
                                Materials.Iron.getPlasma(tier_1_quantity / 12),
                                MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_1) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 2),
                                Materials.SuperconductorUEVBase.getMolten(tier_1_quantity) },
                        base_time / 2,
                        195_457_244,
                        hypogen_heat);

                long tier_2_quantity = 144L * base_quantity * tier_up_multiplier;
                long fuel_quantity_2 = 18_274;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] {
                                new FluidStack(
                                        FluidRegistry.getFluid("molten.advancednitinol"),
                                        (int) tier_2_quantity / 12),
                                new FluidStack(
                                        FluidRegistry.getFluid("molten.celestialtungsten"),
                                        (int) tier_2_quantity / 12),
                                Materials.DraconiumAwakened.getMolten(5L * tier_2_quantity / 12),
                                Materials.Infinity.getMolten(5L * tier_2_quantity / 12),
                                Materials.Iron.getPlasma(tier_2_quantity / 12),
                                MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_2) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2),
                                Materials.SuperconductorUEVBase.getMolten(tier_2_quantity) },
                        base_time / 4,
                        390_914_488,
                        eternal_heat);
            }

            // UIV Superconductors.

            if (GTPlusPlus.isModLoaded()) {

                long base_quantity = 250L;
                long tier_up_multiplier = 2L;

                int base_time = 7431;

                long tier_1_quantity = 144L * base_quantity;
                long fuel_quantity_1 = 77_448;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { GT_CoreModSupport.RadoxPolymer.getMolten(4L * tier_1_quantity / 25),
                                MaterialsUEVplus.TranscendentMetal.getMolten(10L * tier_1_quantity / 25),
                                new FluidStack(
                                        FluidRegistry.getFluid("molten.rhugnor"),
                                        (int) tier_1_quantity * 6 / 25),
                                new FluidStack(
                                        FluidRegistry.getFluid("molten.chromaticglass"),
                                        (int) tier_1_quantity * 5 / 25),
                                Materials.Bismuth.getPlasma(tier_1_quantity / 25),
                                MaterialsUEVplus.ExcitedDTRC.getFluid(fuel_quantity_1) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1 / 2),
                                Materials.SuperconductorUIVBase.getMolten(tier_1_quantity) },
                        base_time / 2,
                        374_265_584,
                        hypogen_heat);

                long tier_2_quantity = 144L * base_quantity * tier_up_multiplier;
                long fuel_quantity_2 = 34_992;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { GT_CoreModSupport.RadoxPolymer.getMolten(4L * tier_2_quantity / 25),
                                MaterialsUEVplus.TranscendentMetal.getMolten(10L * tier_2_quantity / 25),
                                new FluidStack(
                                        FluidRegistry.getFluid("molten.rhugnor"),
                                        (int) tier_2_quantity * 6 / 25),
                                new FluidStack(
                                        FluidRegistry.getFluid("molten.chromaticglass"),
                                        (int) tier_2_quantity * 5 / 25),
                                Materials.Bismuth.getPlasma(tier_2_quantity / 25),
                                MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_2) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_2),
                                Materials.SuperconductorUIVBase.getMolten(tier_2_quantity) },
                        base_time / 4,
                        748_531_167,
                        eternal_heat);
            }

            // UMV Superconductors.

            if (GoodGenerator.isModLoaded()) {

                long base_quantity = 243L;

                int base_time = 3715;

                long tier_1_quantity = 144L * base_quantity;
                long fuel_quantity_1 = 65_536;
                GT_Values.RA.addPlasmaForgeRecipe(
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.SpaceTime.getMolten(6L * tier_1_quantity / 27),
                                new FluidStack(
                                        FluidRegistry.getFluid("molten.orundum"),
                                        (int) tier_1_quantity * 3 / 27),
                                new FluidStack(
                                        FluidRegistry.getFluid("molten.hypogen"),
                                        (int) tier_1_quantity * 11 / 27),
                                new FluidStack(
                                        FluidRegistry.getFluid("molten.titansteel"),
                                        (int) tier_1_quantity * 5 / 27),
                                new FluidStack(
                                        FluidRegistry.getFluid("molten.dragonblood"),
                                        (int) tier_1_quantity * 2 / 27),
                                Materials.Oxygen.getPlasma(tier_1_quantity / 27),
                                MaterialsUEVplus.ExcitedDTEC.getFluid(fuel_quantity_1) },
                        new ItemStack[] { GT_Values.NI },
                        new FluidStack[] { MaterialsUEVplus.DimensionallyTranscendentResidue.getFluid(fuel_quantity_1),
                                Materials.SuperconductorUMVBase.getMolten(tier_1_quantity) },
                        base_time,
                        1_455_144_621,
                        eternal_heat);
            }
        }
    }
}
