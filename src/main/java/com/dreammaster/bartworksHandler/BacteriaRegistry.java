package com.dreammaster.bartworksHandler;

import bloodasp.galacticgreg.GalacticGreg;
import com.dreammaster.fluids.FluidList;
import com.github.bartimaeusnek.bartworks.API.BioObjectAdder;
import com.github.bartimaeusnek.bartworks.API.BioRecipeAdder;
import com.github.bartimaeusnek.bartworks.util.*;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.objects.GT_FluidStack;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import java.awt.*;
import java.util.LinkedHashMap;

import static com.dreammaster.gthandler.GT_CoreModSupport.*;
import static com.github.bartimaeusnek.bartworks.API.BioObjectAdder.*;
import static com.github.bartimaeusnek.bartworks.API.BioRecipeAdder.addBacterialVatRecipe;
import static com.github.bartimaeusnek.bartworks.API.BioRecipeAdder.addBioLabRecipeIncubation;
import static gregtech.api.enums.Materials.*;

public class BacteriaRegistry {

    final static LinkedHashMap<String,BioCulture> CultureSet = new LinkedHashMap<>();

    public void runAllPostinit(){
        runLateBioOBJs();
        runBWRecipes();
        runGTRecipes();
        new BW_Recipe_Loader().run();
        GalacticGreg.ADDITIONALVEINREGISTER.add(new BW_New_Ores_Loader());
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
        bioCulture = createAndRegisterBioCulture(new Color(27, 153, 94),"TCetiEis Fucus Serratus",BioPlasmid.convertDataToPlasmid(bioData),BioDNA.convertDataToDNA(bioData),EnumRarity.rare,true);
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
        GT_Values.RA.addAutoclaveSpaceRecipe(Materials.Naquadah.getDust(1),RadoxLight.getGas(2000),Materials.NaquadahEnriched.getDust(3),10000,350,BW_Util.getMachineVoltageFromTier(5),false);

        //super heavy -> heavy radox conversion
        GT_Values.RA.addCentrifugeRecipe(null,null,RadoxSuperHeavy.getFluid(1000),RadoxHeavy.getFluid(2000),null,null,null,null,null,null,null,60000, BW_Util.getMachineVoltageFromTier(8));

        //heavy radox + Nq+ -> Nq*
        GT_Values.RA.addAutoclaveSpaceRecipe(Materials.NaquadahEnriched.getDust(1),RadoxHeavy.getFluid(4000),Materials.Naquadria.getDust(3),10000,350,BW_Util.getMachineVoltageFromTier(7),false);
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
        addBioLabRecipeIncubation(GT_ModHandler.getModItem("GalaxySpace","barnardaClog",1L),CultureSet.get("BarnadaCBac"),new int[]{250}, FluidRegistry.getFluidStack("unknowwater",8000),500, BW_Util.getMachineVoltageFromTier(8),0);
        for (int i = 0; i < OreDictionary.getOres("cropTcetiESeaweed").size(); i++) {
            addBioLabRecipeIncubation(OreDictionary.getOres("cropTcetiESeaweed").get(i),CultureSet.get("TcetiEBac"),new int[]{250}, FluidRegistry.getFluidStack("unknowwater",8000),500, BW_Util.getMachineVoltageFromTier(8),0);
        }
        addBacterialVatRecipe(new ItemStack[]{AntimonyTrioxide.getDust(16),Osmium.getDust(16)},CultureSet.get("CombinedBac"),new FluidStack[]{Oil.getFluid(1000)},new FluidStack[]{Xenoxene.getFluid(1)},3600,BW_Util.getMachineVoltageFromTier(8),Materials.NaquadahEnriched,8,0,false);
        new BioItemLoader();
    }
}
