package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.recipe.RecipeMaps.electrolyzerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;

public class ElectrolyzerRecipes implements Runnable {

    @Override
    public void run() {
        // Twilight Stuff
        if (TwilightForest.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cell_Empty.get(1),
                            GTModHandler.getModItem(TwilightForest.ID, "tile.TFAuroraBrick", 1L, 0))
                    .itemOutputs(
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                            GTOreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1))
                    .fluidOutputs(Materials.Helium_3.getGas(100)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(electrolyzerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cell_Empty.get(1),
                            GTModHandler.getModItem(TwilightForest.ID, "tile.AuroraPillar", 1L, 0))
                    .itemOutputs(
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                            GTOreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1))
                    .fluidOutputs(Materials.Helium_3.getGas(200)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(electrolyzerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cell_Empty.get(1),
                            GTModHandler.getModItem(TwilightForest.ID, "tile.AuroraSlab", 2L, 0))
                    .itemOutputs(
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                            GTOreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1))
                    .fluidOutputs(Materials.Helium_3.getGas(50)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(electrolyzerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cell_Empty.get(1),
                            GTModHandler.getModItem(TwilightForest.ID, "tile.AuroraDoubleSlab", 1L, 0))
                    .itemOutputs(
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                            GTOreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1))
                    .fluidOutputs(Materials.Helium_3.getGas(100)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(electrolyzerRecipes);
        }
        // Ore Processing related to alumina and silicon dioxide
        // Alumina

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 2L))
                .fluidOutputs(Materials.Oxygen.getGas(3000L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(electrolyzerRecipes);
        // Cryolite

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cryolite, 10L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L))
                .fluidOutputs(Materials.Fluorine.getGas(6000L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(electrolyzerRecipes);
        // Magnesia

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesia, 2L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 1L))
                .fluidOutputs(Materials.Oxygen.getGas(1000L)).duration(2 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(electrolyzerRecipes);
        // Brick Dust

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Brick, 17L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 12L))
                .duration(54 * SECONDS + 12 * TICKS).eut(10).addTo(electrolyzerRecipes);
        // Jade

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Jade, 20L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 12L))
                .fluidOutputs(Materials.Oxygen.getGas(1000L)).duration(10 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Almandine

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Almandine, 20L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L))
                .fluidOutputs(Materials.Oxygen.getGas(3000L)).duration(5 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(electrolyzerRecipes);
        // Kaolinite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Kaolinite, 17L),
                        ItemList.Cell_Empty.get(2L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 6L),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 2L))
                .fluidOutputs(Materials.Hydrogen.getGas(4000L)).duration(24 * SECONDS).eut(90)
                .addTo(electrolyzerRecipes);
        // Kyanite

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Kyanite, 8L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 3L))
                .duration(8 * SECONDS).eut(60).addTo(electrolyzerRecipes);
        // Spodumene

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Spodumene, 20L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lithium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 12L))
                .fluidOutputs(Materials.Oxygen.getGas(1000L)).duration(9 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // BlueTopaz

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlueTopaz, 13L),
                        ItemList.Cell_Empty.get(3L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 3L),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Hydrogen, 2L),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 1L))
                .fluidOutputs(Materials.Fluorine.getGas(2000L)).duration(10 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(electrolyzerRecipes);
        // Topaz

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Topaz, 13L),
                        ItemList.Cell_Empty.get(3L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 3L),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Hydrogen, 2L),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 1L))
                .fluidOutputs(Materials.Fluorine.getGas(2000L)).duration(8 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(electrolyzerRecipes);

        // Clay
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 16L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lithium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 6L))
                .fluidOutputs(Materials.Water.getFluid(2000L)).duration(8 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(electrolyzerRecipes);
        // Emerald

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Emerald, 29L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Beryllium, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 18L))
                .fluidOutputs(Materials.Oxygen.getGas(3000L)).duration(26 * SECONDS + 2 * TICKS).eut(90)
                .addTo(electrolyzerRecipes);
        // Grossular

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Grossular, 20L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L))
                .fluidOutputs(Materials.Oxygen.getGas(3000L)).duration(22 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Pyrope

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Pyrope, 20L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesia, 6L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L))
                .duration(20 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Ruby

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ruby, 6L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L))
                .duration(7 * SECONDS + 4 * TICKS).eut(60).addTo(electrolyzerRecipes);
        // Spessartine

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Spessartine, 20L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Manganese, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 9L))
                .fluidOutputs(Materials.Oxygen.getGas(3000L)).duration(22 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Tanzanite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tanzanite, 44L),
                        ItemList.Cell_Empty.get(5L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 15L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 18L),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 5L))
                .fluidOutputs(Materials.Hydrogen.getGas(2000L)).duration(14 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(electrolyzerRecipes);
        // Potassium Feldspar

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.PotassiumFeldspar, 26L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 18L))
                .fluidOutputs(Materials.Oxygen.getGas(1000L)).duration(13 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Biotite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Biotite, 44L),
                        ItemList.Cell_Empty.get(11L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 6L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 15L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 6L),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 11L))
                .fluidOutputs(Materials.Fluorine.getGas(4000L)).duration(14 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(electrolyzerRecipes);
        // Red Granite

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.GraniteRed, 6L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.PotassiumFeldspar, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L))
                .duration(6 * SECONDS).eut(60).addTo(electrolyzerRecipes);
        // Pollucite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Pollucite, 22L),
                        ItemList.Cell_Empty.get(1L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Caesium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 12L),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 1L))
                .fluidOutputs(Materials.Water.getFluid(2000L)).duration(10 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(electrolyzerRecipes);
        // Lepidolite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lepidolite, 20L),
                        ItemList.Cell_Empty.get(4L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lithium, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 4L))
                .fluidOutputs(Materials.Fluorine.getGas(2000L)).duration(13 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(electrolyzerRecipes);
        // Glauconite Sand

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.GlauconiteSand, 21L),
                        ItemList.Cell_Empty.get(6L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 6L))
                .fluidOutputs(Materials.Hydrogen.getGas(2000L)).duration(18 * SECONDS + 18 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Glauconite Dust

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glauconite, 21L),
                        ItemList.Cell_Empty.get(6L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 6L))
                .fluidOutputs(Materials.Hydrogen.getGas(2000L)).duration(18 * SECONDS + 18 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Vermiculite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Vermiculite, 29L),
                        ItemList.Cell_Empty.get(8L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 3L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 4L),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 6L),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Hydrogen, 2L))
                .fluidOutputs(Materials.Water.getFluid(4000L)).duration(21 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(electrolyzerRecipes);
        // Mica

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Mica, 38L),
                        ItemList.Cell_Empty.get(11L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 15L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Silicon, 6L),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 11L))
                .fluidOutputs(Materials.Fluorine.getGas(4000L)).duration(13 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(electrolyzerRecipes);
        // Alunite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Alunite, 52L),
                        ItemList.Cell_Empty.get(11L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Potassium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 15L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 12L),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 11L))
                .fluidOutputs(Materials.Hydrogen.getGas(12000L)).duration(10 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Zeolite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Zeolite, 64L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Zeolite, 49L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sodium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Calcium, 4L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 64L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 17L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 9L))
                .fluidOutputs(Materials.Oxygen.getGas(18000L)).duration(47 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(electrolyzerRecipes);

    }
}
