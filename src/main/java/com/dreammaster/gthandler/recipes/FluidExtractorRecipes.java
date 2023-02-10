package com.dreammaster.gthandler.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_ModHandler;

public class FluidExtractorRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addFluidExtractionRecipe(
                ItemList.GalliumArsenideCrystal.get(1L),
                GT_Values.NI,
                Materials.GalliumArsenide.getMolten(144L),
                10000,
                24,
                37);

        if (Loader.isModLoaded("harvestcraft")) {
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "catfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "crayfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "jellyfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "mudfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "greenheartfishItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "catfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "anchovyrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "bassrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "carprawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "octopusrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "charrrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "clamrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "crabrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "crayfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "eelrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "frograwItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "grouperrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "herringrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "perchrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "scalloprawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "shrimprawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "snailrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "snapperrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "tilapiarawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "troutrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "tunarawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "turtlerawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("harvestcraft", "walleyerawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
        }

        if (Loader.isModLoaded("OpenBlocks") && Loader.isModLoaded("TConstruct")) {
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("TConstruct", "oreBerries", 1L, 5),
                    GT_Values.NI,
                    new FluidStack(FluidRegistry.getFluid("xpjuice"), 250),
                    10000,
                    100,
                    16);
        }

        if (Loader.isModLoaded("TConstruct")) {
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("TConstruct", "materials", 1L, 14),
                    GT_Values.NI,
                    FluidRegistry.getFluidStack("aluminumbrass.molten", 144),
                    10000,
                    24,
                    48);

            GT_Values.RA.addFluidExtractionRecipe(
                    new ItemStack(Items.ender_pearl, 1, 0),
                    GT_Values.NI,
                    new FluidStack(FluidRegistry.getFluid("ender"), 250),
                    10000,
                    100,
                    30);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("TConstruct", "MetalBlock", 1L, 10),
                    GT_Values.NI,
                    new FluidStack(FluidRegistry.getFluid("ender"), 2250),
                    10000,
                    200,
                    48);

            GT_Values.RA.addFluidExtractionRecipe(
                    new ItemStack(Items.slime_ball, 1, 0),
                    GT_Values.NI,
                    new FluidStack(FluidRegistry.getFluid("glue"), 144),
                    10000,
                    100,
                    16);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("TConstruct", "strangeFood", 1L, 0),
                    GT_Values.NI,
                    new FluidStack(FluidRegistry.getFluid("glue"), 144),
                    10000,
                    100,
                    16);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("TConstruct", "strangeFood", 1L, 1),
                    GT_Values.NI,
                    new FluidStack(FluidRegistry.getFluid("glue"), 144),
                    10000,
                    100,
                    16);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem("TConstruct", "materials", 1L, 36),
                    GT_Values.NI,
                    new FluidStack(FluidRegistry.getFluid("glue"), 144),
                    10000,
                    100,
                    16);
        }
    }
}
