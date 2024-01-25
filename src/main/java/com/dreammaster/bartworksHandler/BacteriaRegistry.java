package com.dreammaster.bartworksHandler;

import static com.dreammaster.gthandler.GT_CoreModSupport.*;
import static com.github.bartimaeusnek.bartworks.API.BioObjectAdder.*;
import static com.github.bartimaeusnek.bartworks.API.BioRecipeAdder.*;
import static gregtech.api.enums.Materials.*;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.Genetics;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.recipe.RecipeMaps.autoclaveRecipes;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.recipe.RecipeMaps.crackingRecipes;
import static gregtech.api.recipe.RecipeMaps.distillationTowerRecipes;
import static gregtech.api.recipe.RecipeMaps.fusionRecipes;
import static gregtech.api.recipe.RecipeMaps.multiblockChemicalReactorRecipes;
import static gregtech.api.recipe.RecipeMaps.pyrolyseRecipes;
import static gregtech.api.recipe.RecipeMaps.vacuumFreezerRecipes;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;
import static gregtech.api.util.GT_RecipeConstants.FUSION_THRESHOLD;

import java.awt.Color;
import java.util.LinkedHashMap;

import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.fluids.FluidList;
import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.gthandler.GT_CoreModSupport;
import com.github.bartimaeusnek.bartworks.util.BioCulture;
import com.github.bartimaeusnek.bartworks.util.BioDNA;
import com.github.bartimaeusnek.bartworks.util.BioData;
import com.github.bartimaeusnek.bartworks.util.BioPlasmid;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class BacteriaRegistry {

    static final LinkedHashMap<String, BioCulture> CultureSet = new LinkedHashMap<>();

    public void runAllPostinit() {
        runLateBioOBJs();
        runBWRecipes();
        runGTRecipes();
        new BW_Recipe_Loader().run();
        CultureSet.clear(); // deletes map, not used anymore
    }

    private void runLateBioOBJs() {
        BioData bioData = createAndRegisterBioData( // BioData because Plasmis == DNA
                "Barnadafis Arboriatoris", // Name
                EnumRarity.rare, // rare (only visual)
                750, // 7.5% chance of getting it
                getBacteriaTierFromVoltageTier(8) // UV
        );
        BioCulture bioCulture = createAndRegisterBioCulture(
                new Color(133, 0, 128), // color = violet
                "Barnadafis Arboriatoris", // name
                BioPlasmid.convertDataToPlasmid(bioData), // BioData -> plasmid
                BioDNA.convertDataToDNA(bioData), // /BioData -> DNA
                EnumRarity.rare, // rare (only visual)
                true // can be multiplied in the BioVat
        );

        CultureSet.put("BarnadaCBac", bioCulture); // save it in a Map to get it later

        // TCetiE culture, same as above
        bioData = createAndRegisterBioData("TCetiEis Fucus Serratus", EnumRarity.rare, 750, 2);
        bioCulture = createAndRegisterBioCulture(
                new Color(27, 153, 94),
                "TCetiEis Fucus Serratus",
                BioPlasmid.convertDataToPlasmid(bioData),
                BioDNA.convertDataToDNA(bioData),
                EnumRarity.rare,
                true);

        CultureSet.put("TcetiEBac", bioCulture);

        // combined Culture
        bioCulture = createAndRegisterBioCulture(
                new Color(54, 119, 181),
                "Xenoxene Xenoxsis",
                CultureSet.get("BarnadaCBac").getPlasmid(), // Barnada Plasmid
                CultureSet.get("TcetiEBac").getdDNA(), // TcetiE DNA
                EnumRarity.epic,
                false);

        CultureSet.put("CombinedBac", bioCulture);

        bioData = createAndRegisterBioData("OvumBac", EnumRarity.rare, 1500, 2);
        bioCulture = createAndRegisterBioCulture(
                new Color(223, 206, 155),
                "Ova Evolutionis",
                BioPlasmid.convertDataToPlasmid(bioData),
                BioDNA.convertDataToDNA(bioData),
                EnumRarity.rare,
                false);

        CultureSet.put("OvumBac", bioCulture);

        bioData = createAndRegisterBioData("StemCellBac", EnumRarity.rare, 750, 3);
        bioCulture = createAndRegisterBioCulture(
                new Color(26, 59, 137),
                "Derivantur Cellula Evolutionis",
                BioPlasmid.convertDataToPlasmid(bioData),
                BioDNA.convertDataToDNA(bioData),
                EnumRarity.rare,
                false);

        CultureSet.put("StemCellBac", bioCulture);

        bioData = createAndRegisterBioData("BioCellBac", EnumRarity.epic, 300, 4);
        bioCulture = createAndRegisterBioCulture(
                new Color(91, 255, 41),
                "Cellula Biologicum Evolutione",
                BioPlasmid.convertDataToPlasmid(bioData),
                BioDNA.convertDataToDNA(bioData),
                EnumRarity.epic,
                false);

        CultureSet.put("BioCellBac", bioCulture);

        bioData = createAndRegisterBioData("BinniGrowthMedium", EnumRarity.common, 9000, 0);
        bioCulture = createAndRegisterBioCulture(
                new Color(219, 223, 138),
                "Binni Growth Medium",
                BioPlasmid.convertDataToPlasmid(bioData),
                BioDNA.convertDataToDNA(bioData),
                EnumRarity.common,
                false);

        CultureSet.put("BinniGrowthMedium", bioCulture);

        bioData = createAndRegisterBioData("BinniBacteria", EnumRarity.common, 6000, 0);
        bioCulture = createAndRegisterBioCulture(
                new Color(209, 181, 129),
                "Binni Bacteria",
                BioPlasmid.convertDataToPlasmid(bioData),
                BioDNA.convertDataToDNA(bioData),
                EnumRarity.common,
                true);

        CultureSet.put("BinniBacteria", bioCulture);

        bioData = createAndRegisterBioData("BacterialSludgeBac", EnumRarity.uncommon, 3000, 1);
        bioCulture = createAndRegisterBioCulture(
                new Color(10, 62, 13),
                "Corynebacterium Sludge Marsensis",
                BioPlasmid.convertDataToPlasmid(bioData),
                BioDNA.convertDataToDNA(bioData),
                EnumRarity.uncommon,
                false);

        CultureSet.put("BacterialSludgeBac", bioCulture);

        bioData = createAndRegisterBioData("Mutagen", EnumRarity.rare, 1500, 2);
        bioCulture = createAndRegisterBioCulture(
                new Color(29, 149, 50),
                "Mutagen Bacteria a Spatio",
                BioPlasmid.convertDataToPlasmid(bioData),
                BioDNA.convertDataToDNA(bioData),
                EnumRarity.rare,
                false);

        CultureSet.put("Mutagen", bioCulture);

        regenerateBioFluids(); // this will generate bacteria fluids. needs to be called AFTER ALL breedable bacterias
        // have been registered.
    }

    private void runAdditionalFuelRecipes() {
        // XenoxRecycleRecipe
        GT_Values.RA.stdBuilder().itemOutputs(Ash.getDust(1)).fluidInputs(DelutedXenoxene.getFluid(1000))
                .fluidOutputs(Xenoxene.getFluid(250), RadoxLight.getGas(300)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(distillationTowerRecipes);

        // LightRadox + Nq -> Enriched Naquadah condensation
        GT_Values.RA.stdBuilder().itemInputs(Materials.Naquadah.getDust(1))
                .itemOutputs(Materials.NaquadahEnriched.getDust(3)).outputChances(10000)
                .fluidInputs(RadoxLight.getGas(2000)).requiresLowGravity().duration(17 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_IV).addTo(autoclaveRecipes);

        // super heavy -> heavy radox conversion
        GT_Values.RA.stdBuilder().itemOutputs().fluidInputs(RadoxSuperHeavy.getFluid(1000))
                .fluidOutputs(RadoxHeavy.getFluid(2000)).duration(50 * MINUTES).eut(TierEU.RECIPE_UV).noOptimize()
                .addTo(centrifugeRecipes);

        // heavy radox + Nq+ -> Nq*
        GT_Values.RA.stdBuilder().itemInputs(Materials.NaquadahEnriched.getDust(1))
                .itemOutputs(Materials.Naquadria.getDust(3)).outputChances(10000).fluidInputs(RadoxHeavy.getFluid(4000))
                .requiresLowGravity().duration(17 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ZPM)
                .addTo(autoclaveRecipes);

    }

    private void runGTRecipes() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_ModHandler.getModItem(GalaxySpace.ID, "barnardaClog", 64L),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(Ash.getDust(8)).fluidInputs(Xenoxene.getFluid(1000)).fluidOutputs(RawRadox.getFluid(1000))
                .duration(3 * MINUTES).eut(TierEU.RECIPE_UV).addTo(pyrolyseRecipes);

        GT_Values.RA.stdBuilder().itemOutputs(Ash.getDust(5)).fluidInputs(RawRadox.getFluid(5000))
                .fluidOutputs(
                        OilHeavy.getFluid(600),
                        Oil.getFluid(300),
                        Creosote.getFluid(1000),
                        Water.getFluid(1400),
                        FluidList.FermentedBacterialSludge.getFluidStack(50),
                        FermentedBiomass.getFluid(50),
                        RadoxSuperHeavy.getFluid(100),
                        RadoxHeavy.getFluid(150),
                        DelutedXenoxene.getFluid(50),
                        RadoxLight.getGas(300),
                        RadoxSuperLight.getGas(500))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(distillationTowerRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_Utility.getIntegratedCircuit(24))
                .fluidInputs(RadoxSuperLight.getGas(100), Silver.getPlasma(1)).fluidOutputs(RadoxCracked.getGas(100))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_UV).addTo(crackingRecipes);

        GT_Values.RA.stdBuilder().itemOutputs(Ash.getDust(1)).fluidInputs(RadoxCracked.getGas(1000))
                .fluidOutputs(RadoxGas.getGas(100), RadoxLight.getGas(200)).duration(30 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(distillationTowerRecipes);

        // Ti & O Plasma Recipes
        GT_Values.RA.stdBuilder().fluidInputs(Aluminium.getMolten(144), Fluorine.getGas(144))
                .fluidOutputs(Titanium.getPlasma(144)).duration(8 * SECONDS).eut(49_152)
                .metadata(FUSION_THRESHOLD, 100_000_000).addTo(fusionRecipes);

        GT_Values.RA.stdBuilder().fluidInputs(Helium.getPlasma(144), Lithium.getMolten(144))
                .fluidOutputs(Boron.getPlasma(144)).duration(12 * SECONDS).eut(10_240)
                .metadata(FUSION_THRESHOLD, 50_000_000).addTo(fusionRecipes);

        GT_Values.RA.stdBuilder().fluidInputs(Boron.getPlasma(144), Lithium.getMolten(144))
                .fluidOutputs(Oxygen.getPlasma(144)).duration(12 * SECONDS).eut(49_152)
                .metadata(FUSION_THRESHOLD, 100_000_000).addTo(fusionRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_Utility.getIntegratedCircuit(2))
                .fluidInputs(RadoxGas.getGas(2160), Oxygen.getPlasma(7500L), Titanium.getPlasma(100L))
                .fluidOutputs(GT_CoreModSupport.RadoxPolymer.getMolten(720L)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(multiblockChemicalReactorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.cell, RadoxPolymer, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.cellMolten, RadoxPolymer, 1L)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(vacuumFreezerRecipes);

        runAdditionalFuelRecipes();
    }

    private void runBWRecipes() {
        addBioLabRecipeIncubation(
                GT_ModHandler.getModItem(GalaxySpace.ID, "barnardaClog", 1L),
                CultureSet.get("BarnadaCBac"),
                new int[] { 250 },
                FluidRegistry.getFluidStack("unknowwater", 8000),
                500,
                (int) TierEU.RECIPE_UV,
                0);

        for (int i = 0; i < OreDictionary.getOres("cropTcetiESeaweed").size(); i++) {
            addBioLabRecipeIncubation(
                    OreDictionary.getOres("cropTcetiESeaweed").get(i),
                    CultureSet.get("TcetiEBac"),
                    new int[] { 250 },
                    FluidRegistry.getFluidStack("unknowwater", 8000),
                    500,
                    (int) TierEU.RECIPE_UV,
                    0);
        }
        addBacterialVatRecipe(
                new ItemStack[] { AntimonyTrioxide.getDust(16), Osmium.getDust(16) },
                CultureSet.get("CombinedBac"),
                new FluidStack[] { Oil.getFluid(20) },
                new FluidStack[] { Xenoxene.getFluid(20) },
                3600,
                (int) TierEU.RECIPE_UEV,
                Materials.NaquadahEnriched,
                8,
                0,
                false);

        addBioLabRecipeIncubation(
                new ItemStack(Items.egg, 1, 0),
                CultureSet.get("OvumBac"),
                new int[] { 1500 },
                FluidRegistry.getFluidStack("binnie.bacteria", 1000),
                1200,
                (int) TierEU.RECIPE_IV,
                CLEANROOM);

        addBacterialVatRecipe(
                new ItemStack[] { ItemList.Circuit_Chip_Stemcell.get(64L),
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.UnknowCrystal", 16L),
                        CustomItemList.TCetiESeaweedExtract.get(4L), Tritanium.getDust(4) },
                CultureSet.get("StemCellBac"),
                new FluidStack[] { GrowthMediumRaw.getFluid(8) },
                new FluidStack[] { BioMediumRaw.getFluid(2) },
                3600,
                (int) TierEU.RECIPE_LuV,
                Plutonium,
                6,
                CLEANROOM,
                true);

        addBacterialVatRecipe(
                new ItemStack[] { ItemList.Circuit_Chip_Stemcell.get(16L),
                        GT_ModHandler.getModItem(GalaxySpace.ID, "item.UnknowCrystal", 16L),
                        CustomItemList.TCetiESeaweedExtract.get(8L), InfinityCatalyst.getDustTiny(4) },
                CultureSet.get("BioCellBac"),
                new FluidStack[] { GrowthMediumRaw.getFluid(5) },
                new FluidStack[] { BioMediumRaw.getFluid(5) },
                3600,
                (int) TierEU.RECIPE_ZPM,
                NaquadahEnriched,
                7,
                CLEANROOM,
                true);

        addBacterialVatRecipe(
                new ItemStack[] { ItemList.Circuit_Chip_Biocell.get(8L), CustomItemList.TCetiESeaweedExtract.get(16L),
                        InfinityCatalyst.getDust(4) },
                CultureSet.get("BioCellBac"),
                new FluidStack[] { GrowthMediumRaw.getFluid(5) },
                new FluidStack[] { BioMediumRaw.getFluid(10) },
                3600,
                (int) TierEU.RECIPE_UV,
                Naquadria,
                8,
                CLEANROOM,
                true);

        addBioLabRecipeIncubation(
                ItemList.Circuit_Chip_Stemcell.get(1L),
                CultureSet.get("StemCellBac"),
                new int[] { 750 },
                GrowthMediumRaw.getFluid(1000),
                2400,
                (int) TierEU.RECIPE_ZPM,
                CLEANROOM);

        addBioLabRecipeIncubation(
                ItemList.Circuit_Chip_Biocell.get(1L),
                CultureSet.get("BioCellBac"),
                new int[] { 750 },
                Materials.BioMediumRaw.getFluid(1000),
                3600,
                (int) TierEU.RECIPE_UV,
                CLEANROOM);

        addBacterialVatRecipe(
                new ItemStack[] { GT_ModHandler.getModItem(Genetics.ID, "misc", 2L, 4) },
                CultureSet.get("BinniGrowthMedium"),
                new FluidStack[] { GT_ModHandler.getDistilledWater(4L) },
                new FluidStack[] { FluidRegistry.getFluidStack("binnie.growthmedium", 2) },
                150,
                (int) TierEU.RECIPE_HV,
                0,
                4,
                0,
                false);

        addBacterialVatRecipe(
                new ItemStack[] { MysteriousCrystal.getDust(1) },
                CultureSet.get("BinniGrowthMedium"),
                new FluidStack[] { GT_ModHandler.getDistilledWater(8L) },
                new FluidStack[] { FluidRegistry.getFluidStack("binnie.growthmedium", 4) },
                150,
                (int) TierEU.RECIPE_EV,
                Bismuth,
                5,
                0,
                false);

        addBacterialVatRecipe(
                new ItemStack[] { InfinityCatalyst.getDustTiny(1) },
                CultureSet.get("BinniGrowthMedium"),
                new FluidStack[] { GT_ModHandler.getDistilledWater(16L) },
                new FluidStack[] { FluidRegistry.getFluidStack("binnie.growthmedium", 8) },
                150,
                (int) TierEU.RECIPE_IV,
                Uranium,
                5,
                0,
                false);

        addBioLabRecipeIncubation(
                GT_ModHandler.getModItem(Genetics.ID, "misc", 1L, 4),
                CultureSet.get("BinniGrowthMedium"),
                new int[] { 5000 },
                Water.getFluid(4000),
                150,
                (int) TierEU.RECIPE_HV,
                0);

        addBioLabRecipeIncubation(
                GT_ModHandler.getModItem(Genetics.ID, "misc", 1L, 4),
                CultureSet.get("BinniGrowthMedium"),
                new int[] { 7500 },
                GT_ModHandler.getDistilledWater(2000L),
                150,
                (int) TierEU.RECIPE_HV,
                0);

        addBioLabRecipeIncubation(
                GT_ModHandler.getModItem(Genetics.ID, "misc", 1L, 4),
                CultureSet.get("BinniGrowthMedium"),
                new int[] { 9000 },
                FluidRegistry.getFluidStack("binnie.growthmedium", 1000),
                150,
                (int) TierEU.RECIPE_HV,
                0);

        addBioLabRecipeIncubation(
                MysteriousCrystal.getDust(4),
                CultureSet.get("BinniGrowthMedium"),
                new int[] { 10000 },
                FluidRegistry.getFluidStack("binnie.growthmedium", 500),
                150,
                (int) TierEU.RECIPE_EV,
                0);

        addBacterialVatRecipe(
                new ItemStack[] { GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBiochaff", 4L, 0) },
                CultureSet.get("BinniBacteria"),
                new FluidStack[] { GT_ModHandler.getDistilledWater(4L) },
                new FluidStack[] { FluidRegistry.getFluidStack("binnie.bacteria", 2) },
                300,
                (int) TierEU.RECIPE_HV,
                Bismuth,
                4,
                0,
                false);

        addBacterialVatRecipe(
                new ItemStack[] { MysteriousCrystal.getDust(1) },
                CultureSet.get("BinniBacteria"),
                new FluidStack[] { GT_ModHandler.getDistilledWater(8L) },
                new FluidStack[] { FluidRegistry.getFluidStack("binnie.bacteria", 4) },
                300,
                (int) TierEU.RECIPE_EV,
                Uranium,
                5,
                0,
                false);

        addBacterialVatRecipe(
                new ItemStack[] { InfinityCatalyst.getDustTiny(1) },
                CultureSet.get("BinniBacteria"),
                new FluidStack[] { GT_ModHandler.getDistilledWater(16L) },
                new FluidStack[] { FluidRegistry.getFluidStack("binnie.bacteria", 8) },
                300,
                (int) TierEU.RECIPE_IV,
                Plutonium,
                6,
                CLEANROOM,
                false);

        addBioLabRecipeIncubation(
                GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBiochaff", 16L, 0),
                CultureSet.get("BinniBacteria"),
                new int[] { 6000 },
                FluidRegistry.getFluidStack("binnie.bacteria", 1000),
                300,
                (int) TierEU.RECIPE_HV,
                0);

        addBioLabRecipeIncubation(
                MysteriousCrystal.getDust(4),
                CultureSet.get("BinniBacteria"),
                new int[] { 8000 },
                FluidRegistry.getFluidStack("binnie.bacteria", 500),
                300,
                (int) TierEU.RECIPE_IV,
                CLEANROOM);

        addBioLabRecipeIncubation(
                InfinityCatalyst.getDustTiny(1),
                CultureSet.get("BinniBacteria"),
                new int[] { 10000 },
                FluidRegistry.getFluidStack("binnie.bacteria", 250),
                300,
                (int) TierEU.RECIPE_LuV,
                CLEANROOM);

        addBacterialVatRecipe(
                new ItemStack[] { CustomItemList.MarsStoneDust.get(16L) },
                CultureSet.get("BacterialSludgeBac"),
                new FluidStack[] { GT_ModHandler.getDistilledWater(4L) },
                new FluidStack[] { FluidRegistry.getFluidStack("bacterialsludge", 1) },
                600,
                (int) TierEU.RECIPE_EV,
                Bismuth,
                5,
                0,
                false);

        addBacterialVatRecipe(
                new ItemStack[] { MysteriousCrystal.getDust(1) },
                CultureSet.get("BacterialSludgeBac"),
                new FluidStack[] { GT_ModHandler.getDistilledWater(8L) },
                new FluidStack[] { FluidRegistry.getFluidStack("bacterialsludge", 2) },
                600,
                (int) TierEU.RECIPE_IV,
                Uranium,
                6,
                CLEANROOM,
                false);

        addBacterialVatRecipe(
                new ItemStack[] { InfinityCatalyst.getDustTiny(1) },
                CultureSet.get("BacterialSludgeBac"),
                new FluidStack[] { GT_ModHandler.getDistilledWater(16L) },
                new FluidStack[] { FluidRegistry.getFluidStack("bacterialsludge", 4) },
                600,
                (int) TierEU.RECIPE_LuV,
                Plutonium,
                7,
                CLEANROOM,
                true);

        addBioLabRecipeIncubation(
                CustomItemList.MarsStoneDust.get(64L),
                CultureSet.get("BacterialSludgeBac"),
                new int[] { 3000 },
                FluidRegistry.getFluidStack("bacterialsludge", 1000),
                600,
                (int) TierEU.RECIPE_EV,
                0);

        addBioLabRecipeIncubation(
                MysteriousCrystal.getDust(16),
                CultureSet.get("BacterialSludgeBac"),
                new int[] { 5000 },
                FluidRegistry.getFluidStack("bacterialsludge", 500),
                600,
                (int) TierEU.RECIPE_IV,
                CLEANROOM);

        addBioLabRecipeIncubation(
                InfinityCatalyst.getDustTiny(4),
                CultureSet.get("BacterialSludgeBac"),
                new int[] { 7500 },
                FluidRegistry.getFluidStack("bacterialsludge", 250),
                600,
                (int) TierEU.RECIPE_LuV,
                CLEANROOM);

        addBacterialVatRecipe(
                new ItemStack[] { MysteriousCrystal.getDust(4) },
                CultureSet.get("Mutagen"),
                new FluidStack[] { GT_ModHandler.getDistilledWater(4L) },
                new FluidStack[] { FluidRegistry.getFluidStack("mutagen", 1) },
                1200,
                (int) TierEU.RECIPE_IV,
                Uranium,
                6,
                CLEANROOM,
                false);

        addBacterialVatRecipe(
                new ItemStack[] { InfinityCatalyst.getDustTiny(1) },
                CultureSet.get("Mutagen"),
                new FluidStack[] { GT_ModHandler.getDistilledWater(8L) },
                new FluidStack[] { FluidRegistry.getFluidStack("mutagen", 2) },
                1200,
                (int) TierEU.RECIPE_LuV,
                Plutonium,
                7,
                CLEANROOM,
                true);

        addBioLabRecipeIncubation(
                MysteriousCrystal.getDust(16),
                CultureSet.get("Mutagen"),
                new int[] { 1500 },
                FluidRegistry.getFluidStack("mutagen", 1000),
                1200,
                (int) TierEU.RECIPE_LuV,
                CLEANROOM);

        addBioLabRecipeIncubation(
                InfinityCatalyst.getDustTiny(4),
                CultureSet.get("Mutagen"),
                new int[] { 3000 },
                FluidRegistry.getFluidStack("mutagen", 500),
                1200,
                (int) TierEU.RECIPE_ZPM,
                CLEANROOM);

        new BioItemLoader();
    }
}
