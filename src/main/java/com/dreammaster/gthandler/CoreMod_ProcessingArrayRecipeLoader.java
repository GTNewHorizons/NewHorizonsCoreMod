package com.dreammaster.gthandler;

import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_ProcessingArray_Manager;


public class CoreMod_ProcessingArrayRecipeLoader {


        public static void registerMaps() {

            // Centrifuge
            registerMapBetweenRange(11040, 11046, GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes);

            // Electrolyzer
            registerMapBetweenRange(10850, 10856, GT_Recipe.GT_Recipe_Map.sElectrolyzerRecipes);

            // Assembler
            registerMapBetweenRange(10780, 10786, GT_Recipe.GT_Recipe_Map.sAssemblerRecipes);

            // Compressor
            registerMapBetweenRange(10810, 10818, GT_Recipe.GT_Recipe_Map.sCompressorRecipes);

            //Extractor
            registerMapBetweenRange(10870, 10876, GT_Recipe.GT_Recipe_Map.sExtractorRecipes);

            //Macerator
            registerMapBetweenRange(10940, 10946, GT_Recipe.GT_Recipe_Map.sMaceratorRecipes);

            // Microwave (New)
            registerMapBetweenRange(10960, 10966, GT_Recipe.GT_Recipe_Map.sMicrowaveRecipes);

            //Recycler
            registerMapBetweenRange(10990, 10996, GT_Recipe.GT_Recipe_Map.sRecyclerRecipes);

            //Thermal Centrifuge
            registerMapBetweenRange(11080, 11086, GT_Recipe.GT_Recipe_Map.sThermalCentrifugeRecipes);

            // Ore Washer
            registerMapBetweenRange(10970, 10976, GT_Recipe.GT_Recipe_Map.sOreWasherRecipes);

            // Chemical Reactor
            registerMapBetweenRange(11150, 11156, GT_Recipe.GT_Recipe_Map.sChemicalRecipes);

            // Chemical Bath
            registerMapBetweenRange(11140, 11146, GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes);

            // Magnetic Seperator
            registerMapBetweenRange(10860, 10866, GT_Recipe.GT_Recipe_Map.sElectroMagneticSeparatorRecipes);

            // Autoclave
            registerMapBetweenRange(10790, 10796, GT_Recipe.GT_Recipe_Map.sAutoclaveRecipes);

            // Mixer
            registerMapBetweenRange(11210, 11216, GT_Recipe.GT_Recipe_Map.sMixerRecipes);

            // Forge Hammer
            registerMapBetweenRange(10910, 10916, GT_Recipe.GT_Recipe_Map.sHammerRecipes);

            // Sifter
            registerMapBetweenRange(11020, 11026, GT_Recipe.GT_Recipe_Map.sSifterRecipes);

            // Extruder
            registerMapBetweenRange(10880, 10886, GT_Recipe.GT_Recipe_Map.sExtruderRecipes);

            // Laser Engraver
            registerMapBetweenRange(10930, 10936, GT_Recipe.GT_Recipe_Map.sLaserEngraverRecipes);

            // Bender
            registerMapBetweenRange(10800, 10806, GT_Recipe.GT_Recipe_Map.sBenderRecipes);

            // Wiremill
            registerMapBetweenRange(11050, 11056, GT_Recipe.GT_Recipe_Map.sWiremillRecipes);

            // Arc Furnace
            registerMapBetweenRange(11070, 11076, GT_Recipe.GT_Recipe_Map.sArcFurnaceRecipes);

            // Plasma Arc Furnace
            registerMapBetweenRange(11090, 11096, GT_Recipe.GT_Recipe_Map.sPlasmaArcFurnaceRecipes);

            // Brewery
            registerMapBetweenRange(11120, 11126, GT_Recipe.GT_Recipe_Map.sBrewingRecipes);

            // Canner
            registerMapBetweenRange(11130, 11136, GT_Recipe.GT_Recipe_Map.sCannerRecipes);

            // Cutter
            registerMapBetweenRange(10820, 10826, GT_Recipe.GT_Recipe_Map.sCutterRecipes);

            // Fermenter
            registerMapBetweenRange(11170, 11176, GT_Recipe.GT_Recipe_Map.sFermentingRecipes);

            // Fluid Extractor
            registerMapBetweenRange(11190, 11196, GT_Recipe.GT_Recipe_Map.sFluidExtractionRecipes);

            // Fluid Solidifier
            registerMapBetweenRange(10890, 10896, GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes);

            // Lathe
            registerMapBetweenRange(10920, 10926, GT_Recipe.GT_Recipe_Map.sLatheRecipes);

            // Boxinator no Coremod recipe
            //registerMapBetweenRange(401, 411, GT_Recipe.GT_Recipe_Map.sBoxinatorRecipes);

            // Unboxinatorno Coremod recipe
            //registerMapBetweenRange(411, 421, GT_Recipe.GT_Recipe_Map.sUnboxinatorRecipes);

            // Polarizer
            registerMapBetweenRange(10980, 10986, GT_Recipe.GT_Recipe_Map.sPolarizerRecipes);

            // Printer no Coremod recipe
            //registerMapBetweenRange(321, 325, GT_Recipe.GT_Recipe_Map.sPrinterRecipes);

            // Fluid Canner
            registerMapBetweenRange(11180, 11186, GT_Recipe.GT_Recipe_Map.sFluidCannerRecipes);

            // Fluid Heater
            registerMapBetweenRange(11200, 11206, GT_Recipe.GT_Recipe_Map.sFluidHeaterRecipes);

            // Distillery
            registerMapBetweenRange(10830, 10836, GT_Recipe.GT_Recipe_Map.sDistilleryRecipes);

            // Slicer
            registerMapBetweenRange(11028, 11036, GT_Recipe.GT_Recipe_Map.sSlicerRecipes);

            // Matter Amplifier
            registerMapBetweenRange(10770, 10776, GT_Recipe.GT_Recipe_Map.sAmplifiers);

            // Circuit Assembler
            registerMapBetweenRange(12090, 12096, GT_Recipe.GT_Recipe_Map.sCircuitAssemblerRecipes);

            // Alloy Smelter
            registerMapBetweenRange(10760, 10766, GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes);

            // Forming Press
            registerMapBetweenRange(10900, 10900, GT_Recipe.GT_Recipe_Map.sPressRecipes);

        }

        private static final void registerMapBetweenRange(int aMin, int aMax, GT_Recipe.GT_Recipe_Map aMap) {
            for (int i=aMin; i<=aMax;i++) {
                GT_ProcessingArray_Manager.registerRecipeMapForMeta(i, aMap);
            }
        }
}
