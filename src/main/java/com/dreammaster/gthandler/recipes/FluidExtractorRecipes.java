package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.fluidExtractionRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gregtech.api.recipe.RecipeCategories;
import gregtech.api.util.GTModHandler;

public class FluidExtractorRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glass_bottle, 1, 0))
                .fluidOutputs(Materials.Glass.getMolten(144L)).duration(1 * SECONDS + 4 * TICKS).eut(54)
                .addTo(fluidExtractionRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.GalliumArsenideCrystal.get(1L))
                .fluidOutputs(Materials.GalliumArsenide.getMolten(288L)).duration(2 * SECONDS + 8 * TICKS).eut(37)
                .addTo(fluidExtractionRecipes);

        if (OpenBlocks.isModLoaded() && TinkerConstruct.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "oreBerries", 1L, 5))
                    .fluidOutputs(new FluidStack(FluidRegistry.getFluid("xpjuice"), 250)).duration(5 * SECONDS).eut(16)
                    .addTo(fluidExtractionRecipes);

        }

        if (TinkerConstruct.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 14))
                    .fluidOutputs(FluidRegistry.getFluidStack("aluminumbrass.molten", 144))
                    .duration(1 * SECONDS + 4 * TICKS).eut(48).addTo(fluidExtractionRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.ender_pearl, 1, 0))
                    .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ender"), 250)).duration(5 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(fluidExtractionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 10))
                    .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ender"), 2250)).duration(10 * SECONDS).eut(48)
                    .addTo(fluidExtractionRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.slime_ball, 1, 0))
                    .fluidOutputs(new FluidStack(FluidRegistry.getFluid("glue"), 144)).duration(5 * SECONDS).eut(16)
                    .addTo(fluidExtractionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "strangeFood", 1L, 0))
                    .fluidOutputs(new FluidStack(FluidRegistry.getFluid("glue"), 144)).duration(5 * SECONDS).eut(16)
                    .addTo(fluidExtractionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "strangeFood", 1L, 1))
                    .fluidOutputs(new FluidStack(FluidRegistry.getFluid("glue"), 144)).duration(5 * SECONDS).eut(16)
                    .addTo(fluidExtractionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 36))
                    .fluidOutputs(new FluidStack(FluidRegistry.getFluid("glue"), 144)).duration(5 * SECONDS).eut(16)
                    .addTo(fluidExtractionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "GlassBlock", 1L, 0))
                    .fluidOutputs(Materials.Glass.getMolten(144L)).duration(24 * TICKS).eut(54)
                    .recipeCategory(RecipeCategories.fluidExtractorRecycling).addTo(fluidExtractionRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "GlassPane", 1L, 0))
                    .fluidOutputs(Materials.Glass.getMolten(54L)).duration(9 * TICKS).eut(54)
                    .recipeCategory(RecipeCategories.fluidExtractorRecycling).addTo(fluidExtractionRecipes);

        }
    }
}
