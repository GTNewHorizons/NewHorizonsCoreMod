package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.TinkerConstruct;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_ModHandler;

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
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "catfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "crayfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "jellyfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "mudfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "greenheartfishItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "catfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "anchovyrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "bassrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "carprawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "octopusrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "charrrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "clamrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "crabrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "crayfishrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "eelrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "frograwItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "grouperrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "herringrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "perchrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "scalloprawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "shrimprawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "snailrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "snapperrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "tilapiarawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "troutrawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "tunarawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "turtlerawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(PamsHarvestCraft.ID, "walleyerawItem", 1, 0),
                    GT_Values.NI,
                    Materials.FishOil.getFluid(50L),
                    10000,
                    16,
                    4);
        }

        if (OpenBlocks.isModLoaded() && TinkerConstruct.isModLoaded()) {
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "oreBerries", 1L, 5),
                    GT_Values.NI,
                    new FluidStack(FluidRegistry.getFluid("xpjuice"), 250),
                    10000,
                    100,
                    16);
        }

        if (TinkerConstruct.isModLoaded()) {
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 14),
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
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 10),
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
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "strangeFood", 1L, 0),
                    GT_Values.NI,
                    new FluidStack(FluidRegistry.getFluid("glue"), 144),
                    10000,
                    100,
                    16);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "strangeFood", 1L, 1),
                    GT_Values.NI,
                    new FluidStack(FluidRegistry.getFluid("glue"), 144),
                    10000,
                    100,
                    16);
            GT_Values.RA.addFluidExtractionRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 36),
                    GT_Values.NI,
                    new FluidStack(FluidRegistry.getFluid("glue"), 144),
                    10000,
                    100,
                    16);
        }
    }
}
