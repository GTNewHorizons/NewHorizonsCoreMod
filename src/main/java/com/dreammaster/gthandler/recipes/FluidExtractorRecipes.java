package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFluidExtractionRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;

public class FluidExtractorRecipes implements Runnable {

    @Override
    public void run() {

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.glass_bottle, 1, 0)).noItemOutputs().noFluidInputs()
                .fluidOutputs(Materials.Glass.getMolten(144L)).duration(1 * SECONDS + 4 * TICKS).eut(54)
                .addTo(sFluidExtractionRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.GalliumArsenideCrystal.get(1L)).noItemOutputs().noFluidInputs()
                .fluidOutputs(Materials.GalliumArsenide.getMolten(288L)).duration(2 * SECONDS + 8 * TICKS).eut(37)
                .addTo(sFluidExtractionRecipes);

        if (PamsHarvestCraft.isModLoaded()) {

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "catfishrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "crayfishrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "jellyfishrawItem", 1, 0)).noItemOutputs()
                    .noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS).eut(4)
                    .addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "mudfishrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "greenheartfishItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "catfishrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "anchovyrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "bassrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "carprawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "octopusrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "charrrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "clamrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "crabrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "crayfishrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "eelrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "frograwItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "grouperrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "herringrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "perchrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "scalloprawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "shrimprawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "snailrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "snapperrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "tilapiarawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "troutrawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "tunarawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "turtlerawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "walleyerawItem", 1, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(Materials.FishOil.getFluid(50L)).duration(16 * TICKS)
                    .eut(4).addTo(sFluidExtractionRecipes);

        }

        if (OpenBlocks.isModLoaded() && TinkerConstruct.isModLoaded()) {

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "oreBerries", 1L, 5))
                    .noItemOutputs().noFluidInputs()
                    .fluidOutputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 250)).duration(5 * SECONDS).eut(16)
                    .addTo(sFluidExtractionRecipes);

        }

        if (TinkerConstruct.isModLoaded()) {

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 14))
                    .noItemOutputs().noFluidInputs()
                    .fluidOutputs(FluidRegistry.getFluidStack("aluminumbrass.molten", 144))
                    .duration(1 * SECONDS + 4 * TICKS).eut(48).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.ender_pearl, 1, 0)).noItemOutputs().noFluidInputs()
                    .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ender"), 250)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 10))
                    .noItemOutputs().noFluidInputs().fluidOutputs(new FluidStack(FluidRegistry.getFluid("ender"), 2250))
                    .duration(10 * SECONDS).eut(48).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.slime_ball, 1, 0)).noItemOutputs().noFluidInputs()
                    .fluidOutputs(new FluidStack(FluidRegistry.getFluid("glue"), 144)).duration(5 * SECONDS).eut(16)
                    .addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "strangeFood", 1L, 0))
                    .noItemOutputs().noFluidInputs().fluidOutputs(new FluidStack(FluidRegistry.getFluid("glue"), 144))
                    .duration(5 * SECONDS).eut(16).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "strangeFood", 1L, 1))
                    .noItemOutputs().noFluidInputs().fluidOutputs(new FluidStack(FluidRegistry.getFluid("glue"), 144))
                    .duration(5 * SECONDS).eut(16).addTo(sFluidExtractionRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 36))
                    .noItemOutputs().noFluidInputs().fluidOutputs(new FluidStack(FluidRegistry.getFluid("glue"), 144))
                    .duration(5 * SECONDS).eut(16).addTo(sFluidExtractionRecipes);

        }
    }
}
