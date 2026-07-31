package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.recipe.RecipeMaps.electrolyzerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.CellShapes;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.material.MaterialUtils;
import gregtech.api.util.GTOreDictUnificator;

public class ElectrolyzerRecipes implements Runnable {

    @Override
    public void run() {
        // Twilight Stuff
        if (TwilightForest.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(ItemList.Cell_Empty.get(1), getModItem(TwilightForest.ID, "tile.TFAuroraBrick", 1, 0))
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials.Stone, Shapes.dust, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Helium, CellShapes.cell, (int) (1)))
                    .fluidOutputs(MaterialUtils.gas(Materials.Helium3, 100)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(electrolyzerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(ItemList.Cell_Empty.get(1), getModItem(TwilightForest.ID, "tile.AuroraPillar", 1, 0))
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials.Stone, Shapes.dust, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Helium, CellShapes.cell, (int) (1)))
                    .fluidOutputs(MaterialUtils.gas(Materials.Helium3, 200)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(electrolyzerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(ItemList.Cell_Empty.get(1), getModItem(TwilightForest.ID, "tile.AuroraSlab", 2, 0))
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials.Stone, Shapes.dust, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Helium, CellShapes.cell, (int) (1)))
                    .fluidOutputs(MaterialUtils.gas(Materials.Helium3, 50)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(electrolyzerRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(
                            ItemList.Cell_Empty.get(1),
                            getModItem(TwilightForest.ID, "tile.AuroraDoubleSlab", 1, 0))
                    .itemOutputs(
                            MaterialLibAPI.getStack(Materials.Stone, Shapes.dust, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Helium, CellShapes.cell, (int) (1)))
                    .fluidOutputs(MaterialUtils.gas(Materials.Helium3, 100)).duration(30 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(electrolyzerRecipes);
        }
        // Ore Processing related to alumina and silicon dioxide
        // Alumina

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dust, (int) (2L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (3000L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(electrolyzerRecipes);
        // Cryolite

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Cryolite, Shapes.dust, (int) (10L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Sodium, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dust, (int) (1L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Fluorine, FluidShapes.fluidGas, (int) (6000L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(electrolyzerRecipes);
        // Magnesia

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Magnesia, Shapes.dust, (int) (2L)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Magnesium, Shapes.dust, (int) (1L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(2 * SECONDS).eut(TierEU.RECIPE_LV).addTo(electrolyzerRecipes);
        // Brick Dust

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Brick, Shapes.dust, (int) (17L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (12L)))
                .duration(54 * SECONDS + 12 * TICKS).eut(10).addTo(electrolyzerRecipes);
        // Jade

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Jade, Shapes.dust, (int) (20L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Sodium, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (12L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(10 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Almandine

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Almandine, Shapes.dust, (int) (20L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (9L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (3000L)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_HV).addTo(electrolyzerRecipes);
        // Kaolinite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Kaolinite, Shapes.dust, (int) (17L)),
                        ItemList.Cell_Empty.get(2L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (6L)),
                        MaterialLibAPI.getStack(Materials.Oxygen, CellShapes.cell, (int) (2L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, (int) (4000L)))
                .duration(24 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Kyanite

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Kyanite, Shapes.dust, (int) (8L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (3L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(electrolyzerRecipes);
        // Spodumene

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Spodumene, Shapes.dust, (int) (20L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Lithium, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (12L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(9 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // BlueTopaz

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.BlueTopaz, Shapes.dust, (int) (13L)),
                        ItemList.Cell_Empty.get(3L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Hydrogen, CellShapes.cell, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Oxygen, CellShapes.cell, (int) (1L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Fluorine, FluidShapes.fluidGas, (int) (2000L)))
                .duration(10 * SECONDS + 8 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Topaz

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Topaz, Shapes.dust, (int) (13L)),
                        ItemList.Cell_Empty.get(3L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Hydrogen, CellShapes.cell, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Oxygen, CellShapes.cell, (int) (1L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Fluorine, FluidShapes.fluidGas, (int) (2000L)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);

        // Clay
        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Clay, Shapes.dust, (int) (16L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Sodium, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Lithium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (6L)))
                .fluidOutputs(MaterialUtils.fluid(Materials.Water, 2000L)).duration(8 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(electrolyzerRecipes);
        // Emerald

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Emerald, Shapes.dust, (int) (29L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Beryllium, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (18L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (3000L)))
                .duration(26 * SECONDS + 2 * TICKS).eut(90).addTo(electrolyzerRecipes);
        // Grossular

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Grossular, Shapes.dust, (int) (20L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Calcium, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (9L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (3000L)))
                .duration(22 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Pyrope

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Pyrope, Shapes.dust, (int) (20L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Magnesia, Shapes.dust, (int) (6L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (9L)))
                .duration(20 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Ruby

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Ruby, Shapes.dust, (int) (6L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)))
                .duration(7 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_MV / 2).addTo(electrolyzerRecipes);
        // Spessartine

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Spessartine, Shapes.dust, (int) (20L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Manganese, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (9L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (3000L)))
                .duration(22 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Tanzanite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Tanzanite, Shapes.dust, (int) (44L)),
                        ItemList.Cell_Empty.get(5L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Calcium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (15L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (18L)),
                        MaterialLibAPI.getStack(Materials.Oxygen, CellShapes.cell, (int) (5L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, (int) (2000L)))
                .duration(14 * SECONDS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Potassium Feldspar

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials.PotassiumFeldspar, Shapes.dust, (int) (26L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Potassium, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (18L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000L)))
                .duration(13 * SECONDS).eut(90).addTo(electrolyzerRecipes);
        // Biotite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Biotite, Shapes.dust, (int) (44L)),
                        ItemList.Cell_Empty.get(11L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Potassium, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Magnesium, Shapes.dust, (int) (6L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (15L)),
                        MaterialLibAPI.getStack(Materials.Silicon, Shapes.dust, (int) (6L)),
                        MaterialLibAPI.getStack(Materials.Oxygen, CellShapes.cell, (int) (11L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Fluorine, FluidShapes.fluidGas, (int) (4000L)))
                .duration(14 * SECONDS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Red Granite

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.GraniteRed, Shapes.dust, (int) (6L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.PotassiumFeldspar, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)))
                .duration(6 * SECONDS).eut(TierEU.RECIPE_MV / 2).addTo(electrolyzerRecipes);
        // Pollucite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Pollucite, Shapes.dust, (int) (22L)),
                        ItemList.Cell_Empty.get(1L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Caesium, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (5L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (12L)),
                        MaterialLibAPI.getStack(Materials.Oxygen, CellShapes.cell, (int) (1L)))
                .fluidOutputs(MaterialUtils.fluid(Materials.Water, 2000L)).duration(10 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Lepidolite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Lepidolite, Shapes.dust, (int) (20L)),
                        ItemList.Cell_Empty.get(4L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Potassium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Lithium, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (10L)),
                        MaterialLibAPI.getStack(Materials.Oxygen, CellShapes.cell, (int) (4L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Fluorine, FluidShapes.fluidGas, (int) (2000L)))
                .duration(13 * SECONDS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Glauconite Sand

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.GlauconiteSand, Shapes.dust, (int) (21L)),
                        ItemList.Cell_Empty.get(6L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Potassium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Magnesium, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (10L)),
                        MaterialLibAPI.getStack(Materials.Oxygen, CellShapes.cell, (int) (6L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, (int) (2000L)))
                .duration(18 * SECONDS + 18 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Glauconite Dust

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Glauconite, Shapes.dust, (int) (21L)),
                        ItemList.Cell_Empty.get(6L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Potassium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Magnesium, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (10L)),
                        MaterialLibAPI.getStack(Materials.Oxygen, CellShapes.cell, (int) (6L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, (int) (2000L)))
                .duration(18 * SECONDS + 18 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);

        // Chlorite
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Chlorite, Shapes.dust, (int) (18L)),
                        ItemList.Cell_Empty.get(4L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Magnesium, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (3L)),
                        GTOreDictUnificator.get(OrePrefixes.cell, Materials.Water, 4L))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (5000)))
                .duration(18 * SECONDS + 18 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);

        // Cordierite
        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Cordierite, Shapes.dust, (int) (13L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Magnesium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (5L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (5000)))
                .duration(13 * SECONDS + 13 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);

        // Staurolite
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Staurolite, Shapes.dust, (int) (32L)),
                        ItemList.Cell_Empty.get(1L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (20L)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Hydrogen, CellShapes.cell, (int) (1L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (4000)))
                .duration(32 * SECONDS + 32 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);

        // Epidote
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Epidote, Shapes.dust, (int) (10L)),
                        ItemList.Cell_Empty.get(1L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Calcium, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Hydrogen, CellShapes.cell, (int) (1L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (1000)))
                .duration(10 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);

        // Datolite
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Datolite, Shapes.dust, (int) (7L)),
                        ItemList.Cell_Empty.get(1L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Calcium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Boron, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Hydrogen, CellShapes.cell, (int) (1L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (3000)))
                .duration(7 * SECONDS + 7 * TICKS).eut(TierEU.RECIPE_EV).addTo(electrolyzerRecipes);

        // Plagioclase
        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Plagioclase, Shapes.dust, (int) (14L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Calcium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Sodium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (9L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (2000)))
                .duration(14 * SECONDS + 14 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);

        // Vermiculite
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Vermiculite, Shapes.dust, (int) (29L)),
                        ItemList.Cell_Empty.get(8L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (3L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (10L)),
                        MaterialLibAPI.getStack(Materials.Silicon, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.Oxygen, CellShapes.cell, (int) (6L)),
                        MaterialLibAPI.getStack(Materials.Hydrogen, CellShapes.cell, (int) (2L)))
                .fluidOutputs(MaterialUtils.fluid(Materials.Water, 4000L)).duration(21 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(electrolyzerRecipes);
        // Mica

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Mica, Shapes.dust, (int) (38L)),
                        ItemList.Cell_Empty.get(11L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Potassium, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (15L)),
                        MaterialLibAPI.getStack(Materials.Silicon, Shapes.dust, (int) (6L)),
                        MaterialLibAPI.getStack(Materials.Oxygen, CellShapes.cell, (int) (11L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Fluorine, FluidShapes.fluidGas, (int) (4000L)))
                .duration(13 * SECONDS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Alunite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Alunite, Shapes.dust, (int) (52L)),
                        ItemList.Cell_Empty.get(11L))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Potassium, Shapes.dust, (int) (2L)),
                        MaterialLibAPI.getStack(Materials.Alumina, Shapes.dust, (int) (15L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (12L)),
                        MaterialLibAPI.getStack(Materials.Oxygen, CellShapes.cell, (int) (11L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Hydrogen, FluidShapes.fluidGas, (int) (12000L)))
                .duration(10 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);
        // Zeolite

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Zeolite, Shapes.dust, (int) (64L)),
                        MaterialLibAPI.getStack(Materials.Zeolite, Shapes.dust, (int) (49L)))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.Sodium, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.Calcium, Shapes.dust, (int) (4L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (64L)),
                        MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (17L)),
                        MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dust, (int) (9L)))
                .fluidOutputs(MaterialLibAPI.getFluidStack(Materials.Oxygen, FluidShapes.fluidGas, (int) (18000L)))
                .duration(47 * SECONDS + 4 * TICKS).eut(TierEU.RECIPE_MV).addTo(electrolyzerRecipes);

    }
}
