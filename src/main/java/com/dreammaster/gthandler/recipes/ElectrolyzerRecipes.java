package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.recipe.RecipeMaps.electrolyzerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2CellShapes;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.util.GTOreDictUnificator;

public class ElectrolyzerRecipes implements Runnable {

    @Override
    public void run() {
        // Twilight Stuff
        if (TwilightForest.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(ItemList.Cell_Empty.get(1), getModItem(TwilightForest.ID, "tile.TFAuroraBrick", 1, 0))
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials2Materials.Stone, Materials2Shapes.shapeDust, (int) (1L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Helium, Materials2CellShapes.shapeCell, (int) (1)))
                    .fluidOutputs(Materials.Helium3.getGas(100)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(electrolyzerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(ItemList.Cell_Empty.get(1), getModItem(TwilightForest.ID, "tile.AuroraPillar", 1, 0))
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials2Materials.Stone, Materials2Shapes.shapeDust, (int) (1L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Helium, Materials2CellShapes.shapeCell, (int) (1)))
                    .fluidOutputs(Materials.Helium3.getGas(200)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(electrolyzerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(ItemList.Cell_Empty.get(1), getModItem(TwilightForest.ID, "tile.AuroraSlab", 2, 0))
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials2Materials.Stone, Materials2Shapes.shapeDust, (int) (1L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Helium, Materials2CellShapes.shapeCell, (int) (1)))
                    .fluidOutputs(Materials.Helium3.getGas(50)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(electrolyzerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cell_Empty.get(1),
                            getModItem(TwilightForest.ID, "tile.AuroraDoubleSlab", 1, 0))
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials2Materials.Stone, Materials2Shapes.shapeDust, (int) (1L)),
                            MaterialLibAPI
                                    .getStack(Materials2Materials.Helium, Materials2CellShapes.shapeCell, (int) (1)))
                    .fluidOutputs(Materials.Helium3.getGas(100)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(electrolyzerRecipes);
        }
        // Ore Processing related to alumina and silicon dioxide
        // Alumina

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.shapeDust, (int) (2L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (3000L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(electrolyzerRecipes);
        // Cryolite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Cryolite, Materials2Shapes.shapeDust, (int) (10L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Sodium, Materials2Shapes.shapeDust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.shapeDust, (int) (1L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Fluorine,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (6000L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(electrolyzerRecipes);
        // Magnesia

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Magnesia, Materials2Shapes.shapeDust, (int) (2L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Magnesium, Materials2Shapes.shapeDust, (int) (1L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (1000L)))
                .duration(2 * SECONDS).eut(TierEU.RECIPE_LV).addTo(electrolyzerRecipes);
        // Brick Dust

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Brick, Materials2Shapes.shapeDust, (int) (17L)))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (12L)))
                .duration(54 * SECONDS + 12 * TICKS).eut(10).addTo(electrolyzerRecipes);
        // Jade

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Jade, Materials2Shapes.shapeDust, (int) (20L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Sodium, Materials2Shapes.shapeDust, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (12L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (1000L)))
                .duration(10 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Almandine

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Almandine, Materials2Shapes.shapeDust, (int) (20L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.shapeDust, (int) (3L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (9L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (3000L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(electrolyzerRecipes);
        // Kaolinite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Kaolinite, Materials2Shapes.shapeDust, (int) (17L)),
                        ItemList.Cell_Empty.get(2L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (6L)),
                        MaterialLibAPI.getStack(Materials2Materials.Oxygen, Materials2CellShapes.shapeCell, (int) (2L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Hydrogen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (4000L)))
                .duration(24 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Kyanite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Kyanite, Materials2Shapes.shapeDust, (int) (8L)))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (3L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(electrolyzerRecipes);
        // Spodumene

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Spodumene, Materials2Shapes.shapeDust, (int) (20L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Lithium, Materials2Shapes.shapeDust, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (12L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (1000L)))
                .duration(9 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // BlueTopaz

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.BlueTopaz, Materials2Shapes.shapeDust, (int) (13L)),
                        ItemList.Cell_Empty.get(3L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (3L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.Hydrogen, Materials2CellShapes.shapeCell, (int) (2L)),
                        MaterialLibAPI.getStack(Materials2Materials.Oxygen, Materials2CellShapes.shapeCell, (int) (1L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Fluorine,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (2000L)))
                .duration(10 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Topaz

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Topaz, Materials2Shapes.shapeDust, (int) (13L)),
                        ItemList.Cell_Empty.get(3L))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (3L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.Hydrogen, Materials2CellShapes.shapeCell, (int) (2L)),
                        MaterialLibAPI.getStack(Materials2Materials.Oxygen, Materials2CellShapes.shapeCell, (int) (1L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Fluorine,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (2000L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);

        // Clay
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Clay, Materials2Shapes.shapeDust, (int) (16L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Sodium, Materials2Shapes.shapeDust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials2Materials.Lithium, Materials2Shapes.shapeDust, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (6L)))
                .fluidOutputs(Materials.Water.getFluid(2000L)).duration(8 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(electrolyzerRecipes);
        // Emerald

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Emerald, Materials2Shapes.shapeDust, (int) (29L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Beryllium, Materials2Shapes.shapeDust, (int) (3L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (18L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (3000L)))
                .duration(26 * SECONDS + 2 * TICKS).eut(90).addTo(electrolyzerRecipes);
        // Grossular

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Grossular, Materials2Shapes.shapeDust, (int) (20L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Calcium, Materials2Shapes.shapeDust, (int) (3L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (9L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (3000L)))
                .duration(22 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Pyrope

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Pyrope, Materials2Shapes.shapeDust, (int) (20L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Magnesia, Materials2Shapes.shapeDust, (int) (6L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (9L)))
                .duration(20 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Ruby

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Ruby, Materials2Shapes.shapeDust, (int) (6L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Chrome, Materials2Shapes.shapeDust, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L))
                .duration(7 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_MV / 2).addTo(electrolyzerRecipes);
        // Spessartine

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.Spessartine, Materials2Shapes.shapeDust, (int) (20L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Manganese, Materials2Shapes.shapeDust, (int) (3L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (9L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (3000L)))
                .duration(22 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Tanzanite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Tanzanite, Materials2Shapes.shapeDust, (int) (44L)),
                        ItemList.Cell_Empty.get(5L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Calcium, Materials2Shapes.shapeDust, (int) (4L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 15L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (18L)),
                        MaterialLibAPI.getStack(Materials2Materials.Oxygen, Materials2CellShapes.shapeCell, (int) (5L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Hydrogen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (2000L)))
                .duration(14 * SECONDS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Potassium Feldspar

        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.PotassiumFeldspar, Materials2Shapes.shapeDust, (int) (26L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Potassium, Materials2Shapes.shapeDust, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (18L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (1000L)))
                .duration(13 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Biotite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Biotite, Materials2Shapes.shapeDust, (int) (44L)),
                        ItemList.Cell_Empty.get(11L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Potassium, Materials2Shapes.shapeDust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials2Materials.Magnesium, Materials2Shapes.shapeDust, (int) (6L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 15L),
                        MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.shapeDust, (int) (6L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.Oxygen, Materials2CellShapes.shapeCell, (int) (11L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Fluorine,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (4000L)))
                .duration(14 * SECONDS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Red Granite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.GraniteRed, Materials2Shapes.shapeDust, (int) (6L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(
                                Materials2Materials.PotassiumFeldspar,
                                Materials2Shapes.shapeDust,
                                (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L))
                .duration(6 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(electrolyzerRecipes);
        // Pollucite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Pollucite, Materials2Shapes.shapeDust, (int) (22L)),
                        ItemList.Cell_Empty.get(1L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Caesium, Materials2Shapes.shapeDust, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 5L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (12L)),
                        MaterialLibAPI.getStack(Materials2Materials.Oxygen, Materials2CellShapes.shapeCell, (int) (1L)))
                .fluidOutputs(Materials.Water.getFluid(2000L)).duration(10 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV)
                .addTo(electrolyzerRecipes);
        // Lepidolite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.Lepidolite, Materials2Shapes.shapeDust, (int) (20L)),
                        ItemList.Cell_Empty.get(4L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Potassium, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Lithium, Materials2Shapes.shapeDust, (int) (3L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                        MaterialLibAPI.getStack(Materials2Materials.Oxygen, Materials2CellShapes.shapeCell, (int) (4L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Fluorine,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (2000L)))
                .duration(13 * SECONDS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Glauconite Sand

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.GlauconiteSand, Materials2Shapes.shapeDust, (int) (21L)),
                        ItemList.Cell_Empty.get(6L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Potassium, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Magnesium, Materials2Shapes.shapeDust, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                        MaterialLibAPI.getStack(Materials2Materials.Oxygen, Materials2CellShapes.shapeCell, (int) (6L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Hydrogen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (2000L)))
                .duration(18 * SECONDS + 18 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Glauconite Dust

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.Glauconite, Materials2Shapes.shapeDust, (int) (21L)),
                        ItemList.Cell_Empty.get(6L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Potassium, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Magnesium, Materials2Shapes.shapeDust, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                        MaterialLibAPI.getStack(Materials2Materials.Oxygen, Materials2CellShapes.shapeCell, (int) (6L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Hydrogen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (2000L)))
                .duration(18 * SECONDS + 18 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);

        // Chlorite
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Chlorite, Materials2Shapes.shapeDust, (int) (18L)),
                        ItemList.Cell_Empty.get(4L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.shapeDust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials2Materials.Magnesium, Materials2Shapes.shapeDust, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 1L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (3L)),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Water, 4L))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (5000)))
                .duration(18 * SECONDS + 18 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);

        // Cordierite
        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.Cordierite, Materials2Shapes.shapeDust, (int) (13L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Magnesium, Materials2Shapes.shapeDust, (int) (1L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 1L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (5L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (5000)))
                .duration(13 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);

        // Staurolite
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.Staurolite, Materials2Shapes.shapeDust, (int) (32L)),
                        ItemList.Cell_Empty.get(1L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.shapeDust, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 20L),
                        MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (4L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.Hydrogen, Materials2CellShapes.shapeCell, (int) (1L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (4000)))
                .duration(32 * SECONDS + 32 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);

        // Epidote
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Epidote, Materials2Shapes.shapeDust, (int) (10L)),
                        ItemList.Cell_Empty.get(1L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Calcium, Materials2Shapes.shapeDust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.shapeDust, (int) (3L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (3L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.Hydrogen, Materials2CellShapes.shapeCell, (int) (1L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (1000)))
                .duration(10 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);

        // Datolite
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Datolite, Materials2Shapes.shapeDust, (int) (7L)),
                        ItemList.Cell_Empty.get(1L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Calcium, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Boron, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.Hydrogen, Materials2CellShapes.shapeCell, (int) (1L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (3000)))
                .duration(7 * SECONDS + 7 * TICKS).eut(TierEU.RECIPE_EV).addTo(electrolyzerRecipes);

        // Plagioclase
        GTValues.RA.stdBuilder().itemInputs(
                MaterialLibAPI.getStack(Materials2Materials.Plagioclase, Materials2Shapes.shapeDust, (int) (14L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Calcium, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Sodium, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (9L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (2000)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);

        // Vermiculite
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI
                                .getStack(Materials2Materials.Vermiculite, Materials2Shapes.shapeDust, (int) (29L)),
                        ItemList.Cell_Empty.get(8L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Iron, Materials2Shapes.shapeDust, (int) (3L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 10L),
                        MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.shapeDust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials2Materials.Oxygen, Materials2CellShapes.shapeCell, (int) (6L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.Hydrogen, Materials2CellShapes.shapeCell, (int) (2L)))
                .fluidOutputs(Materials.Water.getFluid(4000L)).duration(21 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(electrolyzerRecipes);
        // Mica

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Mica, Materials2Shapes.shapeDust, (int) (38L)),
                        ItemList.Cell_Empty.get(11L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Potassium, Materials2Shapes.shapeDust, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 15L),
                        MaterialLibAPI.getStack(Materials2Materials.Silicon, Materials2Shapes.shapeDust, (int) (6L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.Oxygen, Materials2CellShapes.shapeCell, (int) (11L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Fluorine,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (4000L)))
                .duration(13 * SECONDS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Alunite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Alunite, Materials2Shapes.shapeDust, (int) (52L)),
                        ItemList.Cell_Empty.get(11L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Potassium, Materials2Shapes.shapeDust, (int) (2L)),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminiumoxide, 15L),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (12L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.Oxygen, Materials2CellShapes.shapeCell, (int) (11L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Hydrogen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (12000L)))
                .duration(10 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Zeolite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Zeolite, Materials2Shapes.shapeDust, (int) (64L)),
                        MaterialLibAPI.getStack(Materials2Materials.Zeolite, Materials2Shapes.shapeDust, (int) (49L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials2Materials.Sodium, Materials2Shapes.shapeDust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials2Materials.Calcium, Materials2Shapes.shapeDust, (int) (4L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (64L)),
                        MaterialLibAPI
                                .getStack(Materials2Materials.SiliconDioxide, Materials2Shapes.shapeDust, (int) (17L)),
                        MaterialLibAPI.getStack(Materials2Materials.Aluminium, Materials2Shapes.shapeDust, (int) (9L)))
                .fluidOutputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Oxygen,
                                Materials2FluidShapes.shapeFluidGas,
                                (int) (18000L)))
                .duration(47 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);

    }
}
