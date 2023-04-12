package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.TwilightForest;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class ElectrolyzerRecipes implements Runnable {

    @Override
    public void run() {
        // Twilight Stuff
        if (TwilightForest.isModLoaded()) {
            GT_Values.RA.addElectrolyzerRecipe(
                    ItemList.Cell_Empty.get(1),
                    GT_ModHandler.getModItem(TwilightForest.ID, "tile.TFAuroraBrick", 1L, 0),
                    GT_Values.NF,
                    Materials.Helium_3.getFluid(100),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    null,
                    600,
                    480);
            GT_Values.RA.addElectrolyzerRecipe(
                    ItemList.Cell_Empty.get(1),
                    GT_ModHandler.getModItem(TwilightForest.ID, "tile.AuroraPillar", 1L, 0),
                    GT_Values.NF,
                    Materials.Helium_3.getFluid(200),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    null,
                    600,
                    480);
            GT_Values.RA.addElectrolyzerRecipe(
                    ItemList.Cell_Empty.get(1),
                    GT_ModHandler.getModItem(TwilightForest.ID, "tile.AuroraSlab", 2L, 0),
                    GT_Values.NF,
                    Materials.Helium_3.getFluid(50),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    null,
                    600,
                    480);
            GT_Values.RA.addElectrolyzerRecipe(
                    ItemList.Cell_Empty.get(1),
                    GT_ModHandler.getModItem(TwilightForest.ID, "tile.AuroraDoubleSlab", 1L, 0),
                    GT_Values.NF,
                    Materials.Helium_3.getFluid(100),
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                    GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1),
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    GT_Values.NI,
                    null,
                    600,
                    480);
        }
        // Ore Processing related to alumina and silicon dioxide
        // Alumina
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Oxygen.getGas(3000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                null,
                100,
                480);
        // Cryolite
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cryolite, 10L),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Fluorine.getGas(6000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                null,
                100,
                480);
        // Magnesia
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesia, 2L),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Oxygen.getGas(1000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                null,
                40,
                30);
        // Jade
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Jade, 20L),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Oxygen.getGas(1000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 12L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                null,
                200,
                90);
        // Almandine
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Almandine, 20L),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Oxygen.getGas(3000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                null,
                100,
                480);
        // Kaolinite
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Kaolinite, 17L),
                ItemList.Cell_Empty.get(2L),
                GT_Values.NF,
                Materials.Hydrogen.getGas(4000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 6L),
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 2L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                null,
                480,
                90);
        // Kyanite
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Kyanite, 8L),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 3L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                null,
                160,
                60);
        // Spodumene
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Spodumene, 20L),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Oxygen.getGas(1000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lithium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 12L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                null,
                180,
                90);
        // BlueTopaz
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlueTopaz, 13L),
                ItemList.Cell_Empty.get(3L),
                GT_Values.NF,
                Materials.Fluorine.getGas(2000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 3L),
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Hydrogen, 2L),
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 1L),
                GT_Values.NI,
                GT_Values.NI,
                null,
                208,
                120);
        // Topaz
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Topaz, 13L),
                ItemList.Cell_Empty.get(3L),
                GT_Values.NF,
                Materials.Fluorine.getGas(2000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 3L),
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Hydrogen, 2L),
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 1L),
                GT_Values.NI,
                GT_Values.NI,
                null,
                160,
                120);
        // Clay
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 25L),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Water.getFluid(6000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lithium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 6L),
                GT_Values.NI,
                GT_Values.NI,
                null,
                156,
                120);
        // Emerald
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Emerald, 29L),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Oxygen.getFluid(3000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Beryllium, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 18L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                null,
                522,
                90);
        // Grossular
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Grossular, 20L),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Oxygen.getFluid(3000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                null,
                440,
                90);
        // Pyrope
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pyrope, 20L),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesia, 6L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                null,
                400,
                90);
        // Ruby
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 6L),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                null,
                144,
                60);
        // Spessartine
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Spessartine, 20L),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Oxygen.getGas(3000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                null,
                440,
                90);
        // Tanzanite
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tanzanite, 44L),
                ItemList.Cell_Empty.get(5L),
                GT_Values.NF,
                Materials.Hydrogen.getGas(2000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 15L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 18L),
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 5L),
                GT_Values.NI,
                GT_Values.NI,
                null,
                280,
                120);
        // Potassium Feldspar
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PotassiumFeldspar, 26L),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Oxygen.getFluid(1000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 18L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                null,
                260,
                90);
        // Biotite
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Biotite, 45L),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Fluorine.getGas(4000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 6L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 15L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 18L),
                GT_Values.NI,
                GT_Values.NI,
                null,
                280,
                120);
        // Red Granite
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GraniteRed, 6L),
                GT_Values.NI,
                GT_Values.NF,
                GT_Values.NF,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PotassiumFeldspar, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                null,
                120,
                60);
        // Pollucite
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pollucite, 26L),
                ItemList.Cell_Empty.get(3L),
                GT_Values.NF,
                Materials.Hydrogen.getGas(4000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Caesium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 12L),
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 3L),
                GT_Values.NI,
                GT_Values.NI,
                null,
                210,
                120);
        // Lepidolite
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lepidolite, 20L),
                ItemList.Cell_Empty.get(4L),
                GT_Values.NF,
                Materials.Fluorine.getGas(2000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lithium, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 4L),
                GT_Values.NI,
                GT_Values.NI,
                null,
                260,
                120);
        // Glauconite Sand
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GlauconiteSand, 21L),
                ItemList.Cell_Empty.get(6L),
                GT_Values.NF,
                Materials.Hydrogen.getGas(2000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 6L),
                GT_Values.NI,
                GT_Values.NI,
                null,
                378,
                120);
        // Glauconite Dust
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glauconite, 21L),
                ItemList.Cell_Empty.get(6L),
                GT_Values.NF,
                Materials.Hydrogen.getGas(2000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 6L),
                GT_Values.NI,
                GT_Values.NI,
                null,
                378,
                120);
        // Vermiculite
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vermiculite, 37L),
                ItemList.Cell_Empty.get(2L),
                GT_Values.NF,
                Materials.Hydrogen.getGas(10000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 12L),
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 2L),
                GT_Values.NI,
                GT_Values.NI,
                null,
                420,
                120);
        // Mica
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 38L),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Fluorine.getGas(4000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 15L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 18L),
                GT_Values.NI,
                GT_Values.NI,
                GT_Values.NI,
                null,
                260,
                120);
        // Alunite
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Alunite, 52L),
                ItemList.Cell_Empty.get(11L),
                GT_Values.NF,
                Materials.Hydrogen.getGas(12000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 2L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 15L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 12L),
                GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 11L),
                GT_Values.NI,
                GT_Values.NI,
                null,
                210,
                120);
        // Zeolite
        GT_Values.RA.addElectrolyzerRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zeolite, 41L),
                GT_Values.NI,
                GT_Values.NF,
                Materials.Oxygen.getGas(18000L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 4L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 27L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 9L),
                GT_Values.NI,
                GT_Values.NI,
                null,
                944,
                120);

    }
}
