package com.dreammaster.bartworksHandler;

import static bartworks.API.BioObjectAdder.*;
import static bartworks.API.recipe.BartWorksRecipeMaps.bacterialVatRecipes;
import static bartworks.API.recipe.BartWorksRecipeMaps.bioLabRecipes;
import static bartworks.util.BWRecipes.computeSieverts;
import static com.dreammaster.gthandler.GT_CoreModSupport.*;
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
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeConstants.FUSION_THRESHOLD;
import static gregtech.api.util.GTRecipeConstants.SIEVERTS;

import java.awt.Color;
import java.util.LinkedHashMap;

import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.fluids.FluidList;
import com.dreammaster.gthandler.CustomItemList;

import bartworks.common.loaders.BioItemList;
import bartworks.util.BioCulture;
import bartworks.util.BioDNA;
import bartworks.util.BioData;
import bartworks.util.BioPlasmid;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

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
        GTValues.RA.stdBuilder().itemOutputs(Ash.getDust(1)).fluidInputs(Materials.DilutedXenoxene.getFluid(1000))
                .fluidOutputs(Xenoxene.getFluid(250), RadoxLight.getGas(300)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(distillationTowerRecipes);

        // LightRadox + Nq -> Enriched Naquadah condensation
        GTValues.RA.stdBuilder().itemInputs(Materials.Naquadah.getDust(1))
                .itemOutputs(Materials.NaquadahEnriched.getDust(3)).outputChances(10000)
                .fluidInputs(RadoxLight.getGas(2000)).requiresLowGravity().duration(17 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_IV).addTo(autoclaveRecipes);

        // super heavy -> heavy radox conversion
        GTValues.RA.stdBuilder().itemOutputs().fluidInputs(RadoxSuperHeavy.getFluid(1000))
                .fluidOutputs(RadoxHeavy.getFluid(2000)).duration(50 * MINUTES).eut(TierEU.RECIPE_UV).noOptimize()
                .addTo(centrifugeRecipes);

        // heavy radox + Nq+ -> Nq*
        GTValues.RA.stdBuilder().itemInputs(Materials.NaquadahEnriched.getDust(1))
                .itemOutputs(Materials.Naquadria.getDust(3)).outputChances(10000).fluidInputs(RadoxHeavy.getFluid(4000))
                .requiresLowGravity().duration(17 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_ZPM)
                .addTo(autoclaveRecipes);

    }

    private void runGTRecipes() {
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTModHandler.getModItem(GalaxySpace.ID, "barnardaClog", 64L),
                        GTUtility.getIntegratedCircuit(24))
                .itemOutputs(Ash.getDust(8)).fluidInputs(Materials.Xenoxene.getFluid(1000))
                .fluidOutputs(Materials.RawRadox.getFluid(1000)).duration(3 * MINUTES).eut(TierEU.RECIPE_UV)
                .addTo(pyrolyseRecipes);

        GTValues.RA.stdBuilder().itemOutputs(Ash.getDust(5)).fluidInputs(Materials.RawRadox.getFluid(5000))
                .fluidOutputs(
                        OilHeavy.getFluid(600),
                        Oil.getFluid(300),
                        Creosote.getFluid(1000),
                        Water.getFluid(1400),
                        FluidList.FermentedBacterialSludge.getFluidStack(50),
                        FermentedBiomass.getFluid(50),
                        RadoxSuperHeavy.getFluid(100),
                        RadoxHeavy.getFluid(150),
                        DilutedXenoxene.getFluid(50),
                        RadoxLight.getGas(300),
                        RadoxSuperLight.getGas(500))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_UHV).addTo(distillationTowerRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTUtility.getIntegratedCircuit(24))
                .fluidInputs(RadoxSuperLight.getGas(100), Silver.getPlasma(1)).fluidOutputs(RadoxCracked.getGas(100))
                .duration(25 * SECONDS).eut(TierEU.RECIPE_UV).addTo(crackingRecipes);

        GTValues.RA.stdBuilder().itemOutputs(Ash.getDust(1)).fluidInputs(RadoxCracked.getGas(1000))
                .fluidOutputs(RadoxGas.getGas(100), RadoxLight.getGas(200)).duration(30 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(distillationTowerRecipes);

        // Ti & O Plasma Recipes
        GTValues.RA.stdBuilder().fluidInputs(Aluminium.getMolten(144), Fluorine.getGas(144))
                .fluidOutputs(Titanium.getPlasma(144)).duration(8 * SECONDS).eut(49_152)
                .metadata(FUSION_THRESHOLD, 100_000_000).addTo(fusionRecipes);

        GTValues.RA.stdBuilder().fluidInputs(Helium.getPlasma(144), Lithium.getMolten(144))
                .fluidOutputs(Boron.getPlasma(144)).duration(12 * SECONDS).eut(10_240)
                .metadata(FUSION_THRESHOLD, 50_000_000).addTo(fusionRecipes);

        GTValues.RA.stdBuilder().fluidInputs(Boron.getPlasma(144), Lithium.getMolten(144))
                .fluidOutputs(Oxygen.getPlasma(144)).duration(12 * SECONDS).eut(49_152)
                .metadata(FUSION_THRESHOLD, 100_000_000).addTo(fusionRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTUtility.getIntegratedCircuit(2))
                .fluidInputs(RadoxGas.getGas(2160), Oxygen.getPlasma(7500L), Titanium.getPlasma(100L))
                .fluidOutputs(Materials.RadoxPolymer.getMolten(720L)).duration(30 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(multiblockChemicalReactorRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.cell, RadoxPolymer, 1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.cellMolten, RadoxPolymer, 1L)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(vacuumFreezerRecipes);

        runAdditionalFuelRecipes();
    }

    private void bacterialVatRecipes() {
        GTValues.RA.stdBuilder().itemInputs(AntimonyTrioxide.getDust(16), Osmium.getDust(16))
                .special(BioItemList.getPetriDish(CultureSet.get("CombinedBac"))).fluidInputs(Oil.getFluid(20))
                .fluidOutputs(Xenoxene.getFluid(20)).duration(3 * MINUTES).eut(TierEU.RECIPE_UEV)
                .metadata(SIEVERTS, computeSieverts(Materials.NaquadahEnriched, 8, false, false, false)).noOptimize()
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Chip_Stemcell.get(64L),
                        GTModHandler.getModItem(GalaxySpace.ID, "item.UnknowCrystal", 16L),
                        CustomItemList.TCetiESeaweedExtract.get(4L),
                        Tritanium.getDust(4))
                .special(BioItemList.getPetriDish(CultureSet.get("StemCellBac")))
                .fluidInputs(GrowthMediumRaw.getFluid(8)).fluidOutputs(BioMediumRaw.getFluid(2)).duration(3 * MINUTES)
                .eut(TierEU.RECIPE_LuV).metadata(SIEVERTS, computeSieverts(Plutonium, 6, true, true, false))
                .requiresCleanRoom().noOptimize().addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Chip_Stemcell.get(16L),
                        GTModHandler.getModItem(GalaxySpace.ID, "item.UnknowCrystal", 16L),
                        CustomItemList.TCetiESeaweedExtract.get(8L),
                        InfinityCatalyst.getDustTiny(4))
                .special(BioItemList.getPetriDish(CultureSet.get("BioCellBac")))
                .fluidInputs(GrowthMediumRaw.getFluid(5)).fluidOutputs(BioMediumRaw.getFluid(5)).duration(3 * MINUTES)
                .eut(TierEU.RECIPE_ZPM).metadata(SIEVERTS, computeSieverts(NaquadahEnriched, 7, true, true, false))
                .requiresCleanRoom().noOptimize().addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Chip_Biocell.get(8L),
                        CustomItemList.TCetiESeaweedExtract.get(16L),
                        InfinityCatalyst.getDust(4))
                .special(BioItemList.getPetriDish(CultureSet.get("BioCellBac")))
                .fluidInputs(GrowthMediumRaw.getFluid(5)).fluidOutputs(BioMediumRaw.getFluid(10)).duration(3 * MINUTES)
                .eut(TierEU.RECIPE_UV).metadata(SIEVERTS, computeSieverts(Naquadria, 8, true, true, false)).noOptimize()
                .requiresCleanRoom().addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(Genetics.ID, "misc", 2L, 4))
                .special(BioItemList.getPetriDish(CultureSet.get("BinniGrowthMedium")))
                .fluidInputs(GTModHandler.getDistilledWater(4L))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.growthmedium", 2)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).metadata(SIEVERTS, computeSieverts(0, 4, false, false, false)).noOptimize()
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(MysteriousCrystal.getDust(1))
                .special(BioItemList.getPetriDish(CultureSet.get("BinniGrowthMedium")))
                .fluidInputs(GTModHandler.getDistilledWater(8L))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.growthmedium", 4)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_EV).metadata(SIEVERTS, computeSieverts(Bismuth, 5, false, false, false)).noOptimize()
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(InfinityCatalyst.getDustTiny(1))
                .special(BioItemList.getPetriDish(CultureSet.get("BinniGrowthMedium")))
                .fluidInputs(GTModHandler.getDistilledWater(16L))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.growthmedium", 8)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_IV).metadata(SIEVERTS, computeSieverts(Uranium, 5, false, false, false)).noOptimize()
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(InfinityCatalyst.getDust(1))
                .special(BioItemList.getPetriDish(CultureSet.get("BinniGrowthMedium")))
                .fluidInputs(GTModHandler.getDistilledWater(16L * 9L))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.growthmedium", 8 * 9))
                .duration(9 * (7 * SECONDS + 10 * TICKS)).eut(TierEU.RECIPE_IV)
                .metadata(SIEVERTS, computeSieverts(Uranium, 5, false, false, false)).noOptimize()
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(IndustrialCraft2.ID, "itemBiochaff", 4L, 0))
                .special(BioItemList.getPetriDish(CultureSet.get("BinniBacteria")))
                .fluidInputs(GTModHandler.getDistilledWater(4L))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.bacteria", 2)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_HV).metadata(SIEVERTS, computeSieverts(Bismuth, 4, false, false, false)).noOptimize()
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(MysteriousCrystal.getDust(1))
                .special(BioItemList.getPetriDish(CultureSet.get("BinniBacteria")))
                .fluidInputs(GTModHandler.getDistilledWater(8L))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.bacteria", 4)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(SIEVERTS, computeSieverts(Uranium, 5, false, false, false)).noOptimize()
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(InfinityCatalyst.getDustTiny(1))
                .special(BioItemList.getPetriDish(CultureSet.get("BinniBacteria")))
                .fluidInputs(GTModHandler.getDistilledWater(16L))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.bacteria", 8)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(SIEVERTS, computeSieverts(Plutonium, 6, false, true, false))
                .noOptimize().requiresCleanRoom().addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(InfinityCatalyst.getDust(1))
                .special(BioItemList.getPetriDish(CultureSet.get("BinniBacteria")))
                .fluidInputs(GTModHandler.getDistilledWater(16L * 9L))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.bacteria", 8 * 9)).duration(9 * 15 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(SIEVERTS, computeSieverts(Plutonium, 6, false, true, false))
                .noOptimize().requiresCleanRoom().addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.MarsStoneDust.get(16L))
                .special(BioItemList.getPetriDish(CultureSet.get("BacterialSludgeBac")))
                .fluidInputs(GTModHandler.getDistilledWater(4L))
                .fluidOutputs(FluidRegistry.getFluidStack("bacterialsludge", 1)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_EV).metadata(SIEVERTS, computeSieverts(Bismuth, 5, false, false, false)).noOptimize()
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(MysteriousCrystal.getDust(1))
                .special(BioItemList.getPetriDish(CultureSet.get("BacterialSludgeBac")))
                .fluidInputs(GTModHandler.getDistilledWater(8L))
                .fluidOutputs(FluidRegistry.getFluidStack("bacterialsludge", 2)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_IV).metadata(SIEVERTS, computeSieverts(Uranium, 6, false, true, false)).noOptimize()
                .requiresCleanRoom().addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(InfinityCatalyst.getDustTiny(1))
                .special(BioItemList.getPetriDish(CultureSet.get("BacterialSludgeBac")))
                .fluidInputs(GTModHandler.getDistilledWater(16L))
                .fluidOutputs(FluidRegistry.getFluidStack("bacterialsludge", 4)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LuV).metadata(SIEVERTS, computeSieverts(Plutonium, 7, true, true, false))
                .noOptimize().requiresCleanRoom().addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(InfinityCatalyst.getDust(1))
                .special(BioItemList.getPetriDish(CultureSet.get("BacterialSludgeBac")))
                .fluidInputs(GTModHandler.getDistilledWater(16L * 9L))
                .fluidOutputs(FluidRegistry.getFluidStack("bacterialsludge", 4 * 9)).duration(9 * 30 * SECONDS)
                .eut(TierEU.RECIPE_LuV).metadata(SIEVERTS, computeSieverts(Plutonium, 7, true, true, false))
                .noOptimize().requiresCleanRoom().addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(MysteriousCrystal.getDust(4))
                .special(BioItemList.getPetriDish(CultureSet.get("Mutagen")))
                .fluidInputs(GTModHandler.getDistilledWater(4L)).fluidOutputs(FluidRegistry.getFluidStack("mutagen", 1))
                .duration(1 * MINUTES).eut(TierEU.RECIPE_IV)
                .metadata(SIEVERTS, computeSieverts(Uranium, 6, false, true, false)).noOptimize().requiresCleanRoom()
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(InfinityCatalyst.getDustTiny(1))
                .special(BioItemList.getPetriDish(CultureSet.get("Mutagen")))
                .fluidInputs(GTModHandler.getDistilledWater(8L)).fluidOutputs(FluidRegistry.getFluidStack("mutagen", 2))
                .duration(1 * MINUTES).eut(TierEU.RECIPE_LuV)
                .metadata(SIEVERTS, computeSieverts(Plutonium, 7, true, true, false)).noOptimize().requiresCleanRoom()
                .addTo(bacterialVatRecipes);

        GTValues.RA.stdBuilder().itemInputs(InfinityCatalyst.getDust(1))
                .special(BioItemList.getPetriDish(CultureSet.get("Mutagen")))
                .fluidInputs(GTModHandler.getDistilledWater(8L * 9L))
                .fluidOutputs(FluidRegistry.getFluidStack("mutagen", 2 * 9)).duration(9 * MINUTES)
                .eut(TierEU.RECIPE_LuV).metadata(SIEVERTS, computeSieverts(Plutonium, 7, true, true, false))
                .noOptimize().requiresCleanRoom().addTo(bacterialVatRecipes);
    }

    private void bioLabRecipes() {
        GTValues.RA.stdBuilder()
                .itemInputs(BioItemList.getPetriDish(null), GTModHandler.getModItem(GalaxySpace.ID, "barnardaClog", 1L))
                .itemOutputs(BioItemList.getPetriDish(CultureSet.get("BarnadaCBac"))).outputChances(2_50)
                .fluidInputs(FluidRegistry.getFluidStack("unknowwater", 8000)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(bioLabRecipes);

        for (int i = 0; i < OreDictionary.getOres("cropTcetiESeaweed").size(); i++) {
            GTValues.RA.stdBuilder()
                    .itemInputs(BioItemList.getPetriDish(null), OreDictionary.getOres("cropTcetiESeaweed").get(i))
                    .itemOutputs(BioItemList.getPetriDish(CultureSet.get("TcetiEBac"))).outputChances(2_50)
                    .fluidInputs(FluidRegistry.getFluidStack("unknowwater", 8000)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_UV).addTo(bioLabRecipes);
        }

        GTValues.RA.stdBuilder().itemInputs(BioItemList.getPetriDish(null), new ItemStack(Items.egg, 1, 0))
                .itemOutputs(BioItemList.getPetriDish(CultureSet.get("OvumBac"))).outputChances(15_00)
                .fluidInputs(FluidRegistry.getFluidStack("binnie.bacteria", 1000)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_IV).requiresCleanRoom().addTo(bioLabRecipes);

        GTValues.RA.stdBuilder().itemInputs(BioItemList.getPetriDish(null), ItemList.Circuit_Chip_Stemcell.get(1L))
                .itemOutputs(BioItemList.getPetriDish(CultureSet.get("StemCellBac"))).outputChances(7_50)
                .fluidInputs(GrowthMediumRaw.getFluid(1000)).duration(2 * MINUTES).eut(TierEU.RECIPE_ZPM)
                .requiresCleanRoom().addTo(bioLabRecipes);

        GTValues.RA.stdBuilder().itemInputs(BioItemList.getPetriDish(null), ItemList.Circuit_Chip_Biocell.get(1L))
                .itemOutputs(BioItemList.getPetriDish(CultureSet.get("BioCellBac"))).outputChances(7_50)
                .fluidInputs(Materials.BioMediumRaw.getFluid(1000)).duration(3 * MINUTES).eut(TierEU.RECIPE_UV)
                .requiresCleanRoom().addTo(bioLabRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(BioItemList.getPetriDish(null), GTModHandler.getModItem(Genetics.ID, "misc", 1L, 4))
                .itemOutputs(BioItemList.getPetriDish(CultureSet.get("BinniGrowthMedium"))).outputChances(50_00)
                .fluidInputs(Water.getFluid(4000)).duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV)
                .addTo(bioLabRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(BioItemList.getPetriDish(null), GTModHandler.getModItem(Genetics.ID, "misc", 1L, 4))
                .itemOutputs(BioItemList.getPetriDish(CultureSet.get("BinniGrowthMedium"))).outputChances(75_00)
                .fluidInputs(GTModHandler.getDistilledWater(2000L)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV).addTo(bioLabRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(BioItemList.getPetriDish(null), GTModHandler.getModItem(Genetics.ID, "misc", 1L, 4))
                .itemOutputs(BioItemList.getPetriDish(CultureSet.get("BinniGrowthMedium"))).outputChances(90_00)
                .fluidInputs(FluidRegistry.getFluidStack("binnie.growthmedium", 1000))
                .duration(7 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_HV).addTo(bioLabRecipes);

        GTValues.RA.stdBuilder().itemInputs(BioItemList.getPetriDish(null), MysteriousCrystal.getDust(4))
                .itemOutputs(BioItemList.getPetriDish(CultureSet.get("BinniGrowthMedium")))
                .fluidInputs(FluidRegistry.getFluidStack("binnie.growthmedium", 500)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_EV).addTo(bioLabRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        BioItemList.getPetriDish(null),
                        GTModHandler.getModItem(IndustrialCraft2.ID, "itemBiochaff", 16L, 0))
                .itemOutputs(BioItemList.getPetriDish(CultureSet.get("BinniBacteria"))).outputChances(60_00)
                .fluidInputs(FluidRegistry.getFluidStack("binnie.bacteria", 1000)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(bioLabRecipes);

        GTValues.RA.stdBuilder().itemInputs(BioItemList.getPetriDish(null), MysteriousCrystal.getDust(4))
                .itemOutputs(BioItemList.getPetriDish(CultureSet.get("BinniBacteria"))).outputChances(80_00)
                .fluidInputs(FluidRegistry.getFluidStack("binnie.bacteria", 500)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_IV).requiresCleanRoom().addTo(bioLabRecipes);

        GTValues.RA.stdBuilder().itemInputs(BioItemList.getPetriDish(null), InfinityCatalyst.getDustTiny(1))
                .itemOutputs(BioItemList.getPetriDish(CultureSet.get("BinniBacteria")))
                .fluidInputs(FluidRegistry.getFluidStack("binnie.bacteria", 250)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LuV).requiresCleanRoom().addTo(bioLabRecipes);

        GTValues.RA.stdBuilder().itemInputs(BioItemList.getPetriDish(null), CustomItemList.MarsStoneDust.get(64L))
                .itemOutputs(BioItemList.getPetriDish(CultureSet.get("BacterialSludgeBac"))).outputChances(30_00)
                .fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 1000)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(bioLabRecipes);

        GTValues.RA.stdBuilder().itemInputs(BioItemList.getPetriDish(null), MysteriousCrystal.getDust(16))
                .itemOutputs(BioItemList.getPetriDish(CultureSet.get("BacterialSludgeBac"))).outputChances(50_00)
                .fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 500)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_IV).requiresCleanRoom().addTo(bioLabRecipes);

        GTValues.RA.stdBuilder().itemInputs(BioItemList.getPetriDish(null), InfinityCatalyst.getDustTiny(4))
                .itemOutputs(BioItemList.getPetriDish(CultureSet.get("BacterialSludgeBac"))).outputChances(75_00)
                .fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 250)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LuV).requiresCleanRoom().addTo(bioLabRecipes);

        GTValues.RA.stdBuilder().itemInputs(BioItemList.getPetriDish(null), MysteriousCrystal.getDust(16))
                .itemOutputs(BioItemList.getPetriDish(CultureSet.get("Mutagen"))).outputChances(15_00)
                .fluidInputs(FluidRegistry.getFluidStack("mutagen", 1000)).duration(1 * MINUTES).eut(TierEU.RECIPE_LuV)
                .requiresCleanRoom().addTo(bioLabRecipes);

        GTValues.RA.stdBuilder().itemInputs(BioItemList.getPetriDish(null), InfinityCatalyst.getDustTiny(4))
                .itemOutputs(BioItemList.getPetriDish(CultureSet.get("Mutagen"))).outputChances(30_00)
                .fluidInputs(FluidRegistry.getFluidStack("mutagen", 500)).duration(1 * MINUTES).eut(TierEU.RECIPE_ZPM)
                .requiresCleanRoom().addTo(bioLabRecipes);
    }

    private void runBWRecipes() {
        bioLabRecipes();
        bacterialVatRecipes();

        BioItemLoader.registerRecipes();
    }
}
