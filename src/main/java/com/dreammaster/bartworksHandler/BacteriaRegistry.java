package com.dreammaster.bartworksHandler;

import com.dreammaster.fluids.FluidList;
import com.dreammaster.gthandler.CustomItemList;
import com.github.bartimaeusnek.bartworks.util.*;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.objects.GT_FluidStack;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import java.awt.*;
import java.util.LinkedHashMap;

import static com.dreammaster.gthandler.GT_CoreModSupport.*;
import static com.github.bartimaeusnek.bartworks.API.BioObjectAdder.*;
import static com.github.bartimaeusnek.bartworks.API.BioRecipeAdder.*;
import static gregtech.api.enums.Materials.*;

public class BacteriaRegistry {

    final static LinkedHashMap<String,BioCulture> CultureSet = new LinkedHashMap<>();

    public void runAllPostinit(){
        runLateBioOBJs();
        runBWRecipes();
        runGTRecipes();
        new BW_Recipe_Loader().run();
        //GalacticGreg.ADDITIONALVEINREGISTER.add(new BW_New_Ores_Loader());
        CultureSet.clear(); //deletes map, not used anymore
    }

    private void runLateBioOBJs(){
        BioData bioData = createAndRegisterBioData( //BioData because Plasmis == DNA
                "Barnadafis Arboriatoris", //Name
                EnumRarity.rare, //rare (only visual)
                750, //7.5% chance of getting it
                getBacteriaTierFromVoltageTier(8) //UV
        );
        BioCulture bioCulture = createAndRegisterBioCulture(
                new Color(133, 0, 128), //color = violet
                "Barnadafis Arboriatoris", //name
                BioPlasmid.convertDataToPlasmid(bioData), //BioData -> plasmid
                BioDNA.convertDataToDNA(bioData), ///BioData -> DNA
                EnumRarity.rare, //rare (only visual)
                true //can be multiplied in the BioVat
        );

        CultureSet.put("BarnadaCBac", bioCulture); //save it in a Map to get it later

        //TCetiE culture, same as above
        bioData = createAndRegisterBioData("TCetiEis Fucus Serratus",EnumRarity.rare, 750,2);
        bioCulture = createAndRegisterBioCulture
                (new Color(27, 153, 94),
                "TCetiEis Fucus Serratus",
                        BioPlasmid.convertDataToPlasmid(bioData),
                        BioDNA.convertDataToDNA(bioData),
                        EnumRarity.rare,true);

        CultureSet.put("TcetiEBac", bioCulture);

        //combined Culture
        bioCulture = createAndRegisterBioCulture(
                new Color(54, 119, 181),
                "Xenoxene Xenoxsis",
                CultureSet.get("BarnadaCBac").getPlasmid(), //Barnada Plasmid
                CultureSet.get("TcetiEBac").getdDNA(), //TcetiE DNA
                EnumRarity.epic,
                false
        );
        
        CultureSet.put("CombinedBac",bioCulture);
        
        bioData = createAndRegisterBioData("OvumBac",EnumRarity.rare, 1500,2);
        bioCulture = createAndRegisterBioCulture(new Color(223, 206, 155),"Ova Evolutionis",
                BioPlasmid.convertDataToPlasmid(bioData),
                BioDNA.convertDataToDNA(bioData),
                EnumRarity.rare,false
        );

        CultureSet.put("OvumBac",bioCulture);

        bioData = createAndRegisterBioData("StemCellBac",EnumRarity.rare, 750,3);
        bioCulture = createAndRegisterBioCulture(new Color(26, 59, 137),"Derivantur Cellula Evolutionis",
                BioPlasmid.convertDataToPlasmid(bioData),
                BioDNA.convertDataToDNA(bioData),
                EnumRarity.rare,false
        );

        CultureSet.put("StemCellBac",bioCulture);

        bioData = createAndRegisterBioData("BioCellBac",EnumRarity.epic, 300,4);
        bioCulture = createAndRegisterBioCulture(new Color(91, 255, 41),"Cellula Biologicum Evolutione",
                BioPlasmid.convertDataToPlasmid(bioData),
                BioDNA.convertDataToDNA(bioData),
                EnumRarity.epic,false
        );

        CultureSet.put("BioCellBac",bioCulture);

        bioData = createAndRegisterBioData("BinniGrowthMedium",EnumRarity.common, 9000,0);
        bioCulture = createAndRegisterBioCulture(new Color(219, 223, 138),"Binni Growth Medium",
                BioPlasmid.convertDataToPlasmid(bioData),
                BioDNA.convertDataToDNA(bioData),
                EnumRarity.common,false
        );

        CultureSet.put("BinniGrowthMedium",bioCulture);

        bioData = createAndRegisterBioData("BinniBacteria",EnumRarity.common, 6000,0);
        bioCulture = createAndRegisterBioCulture(new Color(209, 181, 129),"Binni Bacteria",
                BioPlasmid.convertDataToPlasmid(bioData),
                BioDNA.convertDataToDNA(bioData),
                EnumRarity.common,true
        );

        CultureSet.put("BinniBacteria",bioCulture);

        bioData = createAndRegisterBioData("BacterialSludgeBac",EnumRarity.uncommon, 3000,1);
        bioCulture = createAndRegisterBioCulture(new Color(10, 62, 13),"Corynebacterium Sludge Marsensis",
                BioPlasmid.convertDataToPlasmid(bioData),
                BioDNA.convertDataToDNA(bioData),
                EnumRarity.uncommon,false
        );

        CultureSet.put("BacterialSludgeBac",bioCulture);

        bioData = createAndRegisterBioData("Mutagen",EnumRarity.rare, 1500,2);
        bioCulture = createAndRegisterBioCulture(new Color(29, 149, 50),"Mutagen Bacteria a Spatio",
                BioPlasmid.convertDataToPlasmid(bioData),
                BioDNA.convertDataToDNA(bioData),
                EnumRarity.rare,false
        );

        CultureSet.put("Mutagen",bioCulture);

        regenerateBioFluids(); //this will generate bacteria fluids. needs to be called AFTER ALL breedable bacterias have been registered.
    }


    private void runAdditionalFuelRecipes(){
        //XenoxRecycleRecipe
        GT_Values.RA.addDistillationTowerRecipe(
            DelutedXenoxene.getFluid(1000),
                new FluidStack[]{
                        Xenoxene.getFluid(250),
                        RadoxLight.getGas(750)
                },
                Ash.getDust(1),
                600,
                BW_Util.getMachineVoltageFromTier(8)
        );

        //LightRadox + Nq -> Enriched Naquadah condensation int aChance, int aDuration, int aEUt, boolean aCleanroom
        GT_Values.RA.addAutoclaveSpaceRecipe(Materials.Naquadah.getDust(1), GT_Values.NI, RadoxLight.getGas(2000),Materials.NaquadahEnriched.getDust(3),10000,350,BW_Util.getMachineVoltageFromTier(5),false);

        //super heavy -> heavy radox conversion
        GT_Values.RA.addCentrifugeRecipe(null,null,RadoxSuperHeavy.getFluid(1000),RadoxHeavy.getFluid(2000),null,null,null,null,null,null,null,60000, BW_Util.getMachineVoltageFromTier(8));

        //heavy radox + Nq+ -> Nq*
        GT_Values.RA.addAutoclaveSpaceRecipe(Materials.NaquadahEnriched.getDust(1), GT_Values.NI,RadoxHeavy.getFluid(4000),Materials.Naquadria.getDust(3),10000,350,BW_Util.getMachineVoltageFromTier(7),false);
    }

    private void runGTRecipes() {

        GT_Values.RA.addPyrolyseRecipe(
                GT_ModHandler.getModItem("GalaxySpace","barnardaClog",64L),
                Xenoxene.getFluid(1000),
                24,
                Ash.getDust(8),
                RawRadox.getFluid(1000),
                3600,
                BW_Util.getMachineVoltageFromTier(8)
        );

        GT_Values.RA.addDistillationTowerRecipe(
                RawRadox.getFluid(1000),
                new FluidStack[]{
                        OilHeavy.getFluid(200),
                        Oil.getFluid(100),
                        Creosote.getFluid(250),
                        Water.getFluid(280),
                        FluidList.FermentedBacterialSludge.getFluidStack(10),
                        FermentedBiomass.getFluid(10),
                        RadoxSuperHeavy.getFluid(10),
                        RadoxHeavy.getFluid(10),
                        DelutedXenoxene.getFluid(10),
                        RadoxLight.getGas(10),
                        RadoxSuperLight.getGas(10),
                },
                Ash.getDust(1),
                600,
                BW_Util.getMachineVoltageFromTier(8)
        );

        GT_Values.RA.addCrackingRecipe(
                24,
                RadoxSuperLight.getGas(100),
                Silver.getPlasma(1),
                RadoxCracked.getGas(100),
                500,BW_Util.getMachineVoltageFromTier(8));

        GT_Values.RA.addDistillationTowerRecipe(
                RadoxCracked.getGas(1000),
                new FluidStack[]{
                        RadoxGas.getGas(100),
                        RadoxLight.getGas(900),
                },
                Ash.getDust(1),
                600,BW_Util.getMachineVoltageFromTier(8)
        );

        //Ti & O Plasma Recipes
        GT_Values.RA.addFusionReactorRecipe(
                Aluminium.getMolten(144),
                Fluorine.getGas(144),
                Titanium.getPlasma(144),
                160,
                49152,
                100000000
        );

        GT_Values.RA.addFusionReactorRecipe(
                Helium.getPlasma(144),
                Lithium.getMolten(144),
                Boron.getPlasma(144),
                240,
                10240,
                50000000
        );

        GT_Values.RA.addFusionReactorRecipe(
                Boron.getPlasma(144),
                Lithium.getMolten(144),
                Oxygen.getPlasma(144),
                240,
                49152,
                100000000
        );

        GT_Values.RA.addMultiblockChemicalRecipe(
                new ItemStack[]{GT_Utility.getIntegratedCircuit(2)},
                new FluidStack[]{
                        RadoxGas.getGas(2160),
                        Oxygen.getPlasma(7500L),
                        Titanium.getPlasma(100L)
                },
                new FluidStack[]{
                        new GT_FluidStack(RadoxPolymer.mGas, 4320)
                },
                (ItemStack[])null,
                800, BW_Util.getMachineVoltageFromTier(1)
        );

        GT_Values.RA.addVacuumFreezerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.cell,RadoxPolymer,1L),
                GT_OreDictUnificator.get(OrePrefixes.cellMolten,RadoxPolymer,1L),
                600,BW_Util.getMachineVoltageFromTier(8)
        );
        runAdditionalFuelRecipes();
    }

    private void runBWRecipes(){
        addBioLabRecipeIncubation(
                GT_ModHandler.getModItem("GalaxySpace","barnardaClog",1L),
                CultureSet.get("BarnadaCBac"),
                new int[]{250},
                FluidRegistry.getFluidStack("unknowwater",8000),
                500, BW_Util.getMachineVoltageFromTier(8),0);

        for (int i = 0; i < OreDictionary.getOres("cropTcetiESeaweed").size(); i++) {
            addBioLabRecipeIncubation(OreDictionary.getOres("cropTcetiESeaweed").get(i),
                    CultureSet.get("TcetiEBac"),new int[]{250},
                    FluidRegistry.getFluidStack("unknowwater",8000),
                    500, BW_Util.getMachineVoltageFromTier(8),0);
        }
        addBacterialVatRecipe(
                new ItemStack[]{AntimonyTrioxide.getDust(16), Osmium.getDust(16)},
                CultureSet.get("CombinedBac"),
                new FluidStack[]{Oil.getFluid(1)},
                new FluidStack[]{Xenoxene.getFluid(1)},
            3600,BW_Util.getMachineVoltageFromTier(8), Materials.NaquadahEnriched,8,0,false);

    addBioLabRecipeIncubation(
                new ItemStack(Items.egg, 1, 0),
                CultureSet.get("OvumBac"),
                new int[]{1500},
                FluidRegistry.getFluidStack("binnie.bacteria",1000),
                1200,7680, CLEANROOM);

    addBacterialVatRecipe(
                new ItemStack[]{ItemList.Circuit_Chip_Stemcell.get(64L), GT_ModHandler.getModItem("GalaxySpace","item.UnknowCrystal",16L), CustomItemList.TCetiESeaweedExtract.get(4L), Tritanium.getDust(4)},
                CultureSet.get("StemCellBac"),
                new FluidStack[]{GrowthMediumRaw.getFluid(8)},
                new FluidStack[]{BioMediumRaw.getFluid(2)},
                3600, 30720, Plutonium, 6, CLEANROOM, true);

        addBacterialVatRecipe(
                new ItemStack[]{ItemList.Circuit_Chip_Stemcell.get(16L), GT_ModHandler.getModItem("GalaxySpace","item.UnknowCrystal",16L), CustomItemList.TCetiESeaweedExtract.get(8L), InfinityCatalyst.getDustTiny(4)},
                CultureSet.get("BioCellBac"),
                new FluidStack[]{GrowthMediumRaw.getFluid(5)},
                new FluidStack[]{BioMediumRaw.getFluid(5)},
                3600, 122880, NaquadahEnriched, 7, CLEANROOM, true);

        addBacterialVatRecipe(
                new ItemStack[]{ItemList.Circuit_Chip_Biocell.get(8L), CustomItemList.TCetiESeaweedExtract.get(16L), InfinityCatalyst.getDust(4)},
                CultureSet.get("BioCellBac"),
                new FluidStack[]{GrowthMediumRaw.getFluid(5)},
                new FluidStack[]{BioMediumRaw.getFluid(10)},
                3600, 500000, Naquadria, 8, CLEANROOM, true);

        addBioLabRecipeIncubation(
                ItemList.Circuit_Chip_Stemcell.get(1L),
                CultureSet.get("StemCellBac"),
                new int[]{750},
                GrowthMediumRaw.getFluid(1000),
                2400,122880, CLEANROOM);

        addBioLabRecipeIncubation(
                ItemList.Circuit_Chip_Biocell.get(1L),
                CultureSet.get("BioCellBac"),
                new int[]{750},
                Materials.BioMediumRaw.getFluid(1000),
                3600,500000, CLEANROOM);

        addBacterialVatRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("Genetics", "misc", 2L, 4)},
                CultureSet.get("BinniGrowthMedium"),
                new FluidStack[]{GT_ModHandler.getDistilledWater(4L)},
                new FluidStack[]{FluidRegistry.getFluidStack("binnie.growthmedium",2)},
                150, 480, 0, 4, 0, false);

        addBacterialVatRecipe(
                new ItemStack[]{MysteriousCrystal.getDust(1)},
                CultureSet.get("BinniGrowthMedium"),
                new FluidStack[]{GT_ModHandler.getDistilledWater(8L)},
                new FluidStack[]{FluidRegistry.getFluidStack("binnie.growthmedium",4)},
                150, 1920, Bismuth, 5, 0, false);

        addBacterialVatRecipe(
                new ItemStack[]{InfinityCatalyst.getDustTiny(1)},
                CultureSet.get("BinniGrowthMedium"),
                new FluidStack[]{GT_ModHandler.getDistilledWater(16L)},
                new FluidStack[]{FluidRegistry.getFluidStack("binnie.growthmedium",8)},
                150, 7680, Uranium, 5, 0, false);

        addBioLabRecipeIncubation(
                GT_ModHandler.getModItem("Genetics", "misc", 1L, 4),
                CultureSet.get("BinniGrowthMedium"),
                new int[]{5000},
                Water.getFluid(4000),
                150,480, 0);

        addBioLabRecipeIncubation(
                GT_ModHandler.getModItem("Genetics", "misc", 1L, 4),
                CultureSet.get("BinniGrowthMedium"),
                new int[]{7500},
                GT_ModHandler.getDistilledWater(2000L),
                150,480, 0);

        addBioLabRecipeIncubation(
                GT_ModHandler.getModItem("Genetics", "misc", 1L, 4),
                CultureSet.get("BinniGrowthMedium"),
                new int[]{9000},
                FluidRegistry.getFluidStack("binnie.growthmedium", 1000),
                150,480, 0);

        addBioLabRecipeIncubation(
                MysteriousCrystal.getDust(4),
                CultureSet.get("BinniGrowthMedium"),
                new int[]{10000},
                FluidRegistry.getFluidStack("binnie.growthmedium", 500),
                150,1920, 0);

        addBacterialVatRecipe(
                new ItemStack[]{GT_ModHandler.getModItem("IC2", "itemBiochaff", 4L, 0)},
                CultureSet.get("BinniBacteria"),
                new FluidStack[]{GT_ModHandler.getDistilledWater(4L)},
                new FluidStack[]{FluidRegistry.getFluidStack("binnie.bacteria",2)},
                300, 480, Bismuth, 4, 0, false);

        addBacterialVatRecipe(
                new ItemStack[]{MysteriousCrystal.getDust(1)},
                CultureSet.get("BinniBacteria"),
                new FluidStack[]{GT_ModHandler.getDistilledWater(8L)},
                new FluidStack[]{FluidRegistry.getFluidStack("binnie.bacteria",4)},
                300, 1920, Uranium, 5, 0, false);

        addBacterialVatRecipe(
                new ItemStack[]{InfinityCatalyst.getDustTiny(1)},
                CultureSet.get("BinniBacteria"),
                new FluidStack[]{GT_ModHandler.getDistilledWater(16L)},
                new FluidStack[]{FluidRegistry.getFluidStack("binnie.bacteria",8)},
                300, 7680, Plutonium, 6, CLEANROOM, false);

        addBioLabRecipeIncubation(
                GT_ModHandler.getModItem("IC2", "itemBiochaff", 16L, 0),
                CultureSet.get("BinniBacteria"),
                new int[]{6000},
                FluidRegistry.getFluidStack("binnie.bacteria",1000),
                300,480, 0);

        addBioLabRecipeIncubation(
                MysteriousCrystal.getDust(4),
                CultureSet.get("BinniBacteria"),
                new int[]{8000},
                FluidRegistry.getFluidStack("binnie.bacteria",500),
                300,7680, CLEANROOM);

        addBioLabRecipeIncubation(
                InfinityCatalyst.getDustTiny(1),
                CultureSet.get("BinniBacteria"),
                new int[]{10000},
                FluidRegistry.getFluidStack("binnie.bacteria",250),
                300,30720, CLEANROOM);

        addBacterialVatRecipe(
                new ItemStack[]{CustomItemList.MarsStoneDust.get(16L)},
                CultureSet.get("BacterialSludgeBac"),
                new FluidStack[]{GT_ModHandler.getDistilledWater(4L)},
                new FluidStack[]{FluidRegistry.getFluidStack("bacterialsludge", 1)},
                600, 1920, Bismuth, 5, 0, false);

        addBacterialVatRecipe(
                new ItemStack[]{MysteriousCrystal.getDust(1)},
                CultureSet.get("BacterialSludgeBac"),
                new FluidStack[]{GT_ModHandler.getDistilledWater(8L)},
                new FluidStack[]{FluidRegistry.getFluidStack("bacterialsludge", 2)},
                600, 7680, Uranium, 6, CLEANROOM, false);

        addBacterialVatRecipe(
                new ItemStack[]{InfinityCatalyst.getDustTiny(1)},
                CultureSet.get("BacterialSludgeBac"),
                new FluidStack[]{GT_ModHandler.getDistilledWater(16L)},
                new FluidStack[]{FluidRegistry.getFluidStack("bacterialsludge", 4)},
                600, 30720, Plutonium, 7, CLEANROOM, true);

        addBioLabRecipeIncubation(
                CustomItemList.MarsStoneDust.get(64L),
                CultureSet.get("BacterialSludgeBac"),
                new int[]{3000},
                FluidRegistry.getFluidStack("bacterialsludge", 1000),
                600,1920,0);

        addBioLabRecipeIncubation(
                MysteriousCrystal.getDust(16),
                CultureSet.get("BacterialSludgeBac"),
                new int[]{5000},
                FluidRegistry.getFluidStack("bacterialsludge", 500),
                600,7680, CLEANROOM);

        addBioLabRecipeIncubation(
                InfinityCatalyst.getDustTiny(4),
                CultureSet.get("BacterialSludgeBac"),
                new int[]{7500},
                FluidRegistry.getFluidStack("bacterialsludge", 250),
                600,30720, CLEANROOM);

        addBacterialVatRecipe(
                new ItemStack[]{MysteriousCrystal.getDust(4)},
                CultureSet.get("Mutagen"),
                new FluidStack[]{GT_ModHandler.getDistilledWater(4L)},
                new FluidStack[]{FluidRegistry.getFluidStack("mutagen", 1)},
                1200, 7680, Uranium, 6, CLEANROOM, false);

        addBacterialVatRecipe(
                new ItemStack[]{InfinityCatalyst.getDustTiny(1)},
                CultureSet.get("Mutagen"),
                new FluidStack[]{GT_ModHandler.getDistilledWater(8L)},
                new FluidStack[]{FluidRegistry.getFluidStack("mutagen", 2)},
                1200, 30720, Plutonium, 7, CLEANROOM, true);

        addBioLabRecipeIncubation(
                MysteriousCrystal.getDust(16),
                CultureSet.get("Mutagen"),
                new int[]{1500},
                FluidRegistry.getFluidStack("mutagen", 1000),
                1200,30720, CLEANROOM);

        addBioLabRecipeIncubation(
                InfinityCatalyst.getDustTiny(4),
                CultureSet.get("Mutagen"),
                new int[]{3000},
                FluidRegistry.getFluidStack("mutagen", 500),
                1200,122880, CLEANROOM);

        new BioItemLoader();
    }
}
