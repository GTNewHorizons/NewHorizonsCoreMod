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

import static gregtech.api.enums.ModIDs.PamsHarvestCraft;
import static gregtech.api.enums.ModIDs.TinkerConstruct;

public class FluidExtractorRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addFluidExtractionRecipe(
                new ItemStack(Items.glass_bottle, 1, 0),
                GT_Values.NI,
                Materials.Glass.getMolten(144L),
                10000,
                24,
                54);

        GT_Values.RA.addFluidExtractionRecipe(
                ItemList.GalliumArsenideCrystal.get(1L),
                GT_Values.NI,
                Materials.GalliumArsenide.getMolten(144L),
                10000,
                24,
                37);

        if (PamsHarvestCraft.isModLoaded()) {
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "catfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "crayfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "jellyfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "mudfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "greenheartfishItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "catfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "anchovyrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "bassrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "carprawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "octopusrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "charrrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "clamrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "crabrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "crayfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "eelrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "frograwItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "grouperrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "herringrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "perchrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "scalloprawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "shrimprawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "snailrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "snapperrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "tilapiarawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "troutrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "tunarawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "turtlerawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.modID, "walleyerawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
        }

        if (Loader.isModLoaded("OpenBlocks") && TinkerConstruct.isModLoaded()) {
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "oreBerries", 1L, 5),
                    GT_Values.NI,
                    new FluidStack(FluidRegistry.getFluid("xpjuice"), 250),
                    10000,
                    100,
                    16);
        }

        if (TinkerConstruct.isModLoaded()) {
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "materials", 1L, 14),
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
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "MetalBlock", 1L, 10),
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
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "strangeFood", 1L, 0),
                    GT_Values.NI,
                    new FluidStack(FluidRegistry.getFluid("glue"), 144),
                    10000,
                    100,
                    16);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "strangeFood", 1L, 1),
                    GT_Values.NI,
                    new FluidStack(FluidRegistry.getFluid("glue"), 144),
                    10000,
                    100,
                    16);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "materials", 1L, 36),
                    GT_Values.NI,
                    new FluidStack(FluidRegistry.getFluid("glue"), 144),
                    10000,
                    100,
                    16);
        }
    }
}
