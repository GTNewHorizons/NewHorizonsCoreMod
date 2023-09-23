package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sElectrolyzerRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class ElectrolyzerRecipes implements Runnable {

    @Override
    public void run() {
        // Twilight Stuff
        if (TwilightForest.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cell_Empty.get(1),
                            GT_ModHandler.getModItem(TwilightForest.ID, "tile.TFAuroraBrick", 1L, 0))
                    .itemOutputs(
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1))
                    .fluidOutputs(Materials.Helium_3.getGas(100)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(sElectrolyzerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cell_Empty.get(1),
                            GT_ModHandler.getModItem(TwilightForest.ID, "tile.AuroraPillar", 1L, 0))
                    .itemOutputs(
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1))
                    .fluidOutputs(Materials.Helium_3.getGas(200)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(sElectrolyzerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cell_Empty.get(1),
                            GT_ModHandler.getModItem(TwilightForest.ID, "tile.AuroraSlab", 2L, 0))
                    .itemOutputs(
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1))
                    .fluidOutputs(Materials.Helium_3.getGas(50)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(sElectrolyzerRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cell_Empty.get(1),
                            GT_ModHandler.getModItem(TwilightForest.ID, "tile.AuroraDoubleSlab", 1L, 0))
                    .itemOutputs(
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1))
                    .fluidOutputs(Materials.Helium_3.getGas(100)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(sElectrolyzerRecipes);
        }
        // Ore Processing related to alumina and silicon dioxide
        // Alumina

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L))
                .fluidOutputs(Materials.Oxygen.getGas(3000L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(sElectrolyzerRecipes);
        // Cryolite

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cryolite, 10L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L))
                .fluidOutputs(Materials.Fluorine.getGas(6000L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(sElectrolyzerRecipes);
        // Magnesia

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesia, 2L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L))
                .fluidOutputs(Materials.Oxygen.getGas(1000L)).duration(2 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(sElectrolyzerRecipes);
        // Brick Dust

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Brick, 17L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 12L))
                .duration(54 * SECONDS + 12 * TICKS).eut(10).addTo(sElectrolyzerRecipes);
        // Jade

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Jade, 20L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 12L))
                .fluidOutputs(Materials.Oxygen.getGas(1000L)).duration(10 * SECONDS).eut(90)
                .addTo(sElectrolyzerRecipes);
        // Almandine

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Almandine, 20L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L))
                .fluidOutputs(Materials.Oxygen.getGas(3000L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(sElectrolyzerRecipes);
        // Kaolinite

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Kaolinite, 17L),
                        ItemList.Cell_Empty.get(2L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 6L),
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 2L))
                .fluidOutputs(Materials.Hydrogen.getGas(4000L)).duration(24 * SECONDS).eut(90)
                .addTo(sElectrolyzerRecipes);
        // Kyanite

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Kyanite, 8L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 3L))
                .duration(8 * SECONDS).eut(60).addTo(sElectrolyzerRecipes);
        // Spodumene

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Spodumene, 20L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lithium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 12L))
                .fluidOutputs(Materials.Oxygen.getGas(1000L)).duration(9 * SECONDS).eut(90).addTo(sElectrolyzerRecipes);
        // BlueTopaz

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlueTopaz, 13L),
                        ItemList.Cell_Empty.get(3L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Hydrogen, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 1L))
                .fluidOutputs(Materials.Fluorine.getGas(2000L)).duration(10 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sElectrolyzerRecipes);
        // Topaz

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Topaz, 13L),
                        ItemList.Cell_Empty.get(3L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Hydrogen, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 1L))
                .fluidOutputs(Materials.Fluorine.getGas(2000L)).duration(8 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sElectrolyzerRecipes);

        // Clay
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 16L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lithium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 6L))
                .fluidOutputs(Materials.Water.getFluid(2000L)).duration(8 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sElectrolyzerRecipes);
        // Emerald

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Emerald, 29L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Beryllium, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 18L))
                .fluidOutputs(Materials.Oxygen.getGas(3000L)).duration(26 * SECONDS + 2 * TICKS).eut(90)
                .addTo(sElectrolyzerRecipes);
        // Grossular

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Grossular, 20L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L))
                .fluidOutputs(Materials.Oxygen.getGas(3000L)).duration(22 * SECONDS).eut(90)
                .addTo(sElectrolyzerRecipes);
        // Pyrope

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pyrope, 20L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesia, 6L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L))
                .duration(20 * SECONDS).eut(90).addTo(sElectrolyzerRecipes);
        // Ruby

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 6L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L))
                .duration(7 * SECONDS + 4 * TICKS).eut(60).addTo(sElectrolyzerRecipes);
        // Spessartine

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Spessartine, 20L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L))
                .fluidOutputs(Materials.Oxygen.getGas(3000L)).duration(22 * SECONDS).eut(90)
                .addTo(sElectrolyzerRecipes);
        // Tanzanite

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tanzanite, 44L),
                        ItemList.Cell_Empty.get(5L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 15L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 18L),
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 5L))
                .fluidOutputs(Materials.Hydrogen.getGas(2000L)).duration(14 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sElectrolyzerRecipes);
        // Potassium Feldspar

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PotassiumFeldspar, 26L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 18L))
                .fluidOutputs(Materials.Oxygen.getGas(1000L)).duration(13 * SECONDS).eut(90)
                .addTo(sElectrolyzerRecipes);
        // Biotite

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Biotite, 44L),
                        ItemList.Cell_Empty.get(11L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 6L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 15L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 6L),
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 11L))
                .fluidOutputs(Materials.Fluorine.getGas(4000L)).duration(14 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sElectrolyzerRecipes);
        // Red Granite

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GraniteRed, 6L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.PotassiumFeldspar, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L))
                .duration(6 * SECONDS).eut(60).addTo(sElectrolyzerRecipes);
        // Pollucite

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Pollucite, 22L),
                        ItemList.Cell_Empty.get(1L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Caesium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 12L),
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 1L))
                .fluidOutputs(Materials.Water.getFluid(2000L)).duration(10 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sElectrolyzerRecipes);
        // Lepidolite

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lepidolite, 20L),
                        ItemList.Cell_Empty.get(4L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lithium, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 4L))
                .fluidOutputs(Materials.Fluorine.getGas(2000L)).duration(13 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sElectrolyzerRecipes);
        // Glauconite Sand

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GlauconiteSand, 21L),
                        ItemList.Cell_Empty.get(6L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 6L))
                .fluidOutputs(Materials.Hydrogen.getGas(2000L)).duration(18 * SECONDS + 18 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(sElectrolyzerRecipes);
        // Glauconite Dust

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glauconite, 21L),
                        ItemList.Cell_Empty.get(6L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 6L))
                .fluidOutputs(Materials.Hydrogen.getGas(2000L)).duration(18 * SECONDS + 18 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(sElectrolyzerRecipes);
        // Vermiculite

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Vermiculite, 29L),
                        ItemList.Cell_Empty.get(8L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 6L),
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Hydrogen, 2L))
                .fluidOutputs(Materials.Water.getFluid(4000L)).duration(21 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sElectrolyzerRecipes);
        // Mica

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 38L),
                        ItemList.Cell_Empty.get(11L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 15L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 6L),
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 11L))
                .fluidOutputs(Materials.Fluorine.getGas(4000L)).duration(13 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(sElectrolyzerRecipes);
        // Alunite

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Alunite, 52L),
                        ItemList.Cell_Empty.get(11L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 15L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 12L),
                        GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 11L))
                .fluidOutputs(Materials.Hydrogen.getGas(12000L)).duration(10 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(sElectrolyzerRecipes);
        // Zeolite

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zeolite, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Zeolite, 49L))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 4L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 64L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 17L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 9L))
                .fluidOutputs(Materials.Oxygen.getGas(18000L)).duration(47 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(sElectrolyzerRecipes);

    }
}
