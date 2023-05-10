package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.Genetics;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.PamsHarvestTheNether;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sBrewingRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import java.lang.reflect.Field;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import forestry.api.recipes.IFermenterRecipe;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;

public class BrewingMachineRecipes implements Runnable {

    @Override
    public void run() {

        GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(Genetics.ID, "misc", 6L, 4)).noItemOutputs()
                .fluidInputs(FluidRegistry.getFluidStack("water", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.growthmedium", 750)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sBrewingRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBiochaff", 16L, 0))
                .noItemOutputs().fluidInputs(FluidRegistry.getFluidStack("binnie.growthmedium", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.bacteria", 750)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(sBrewingRecipes);

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.blaze_powder, 1, 0)).noItemOutputs()
                .fluidInputs(FluidRegistry.getFluidStack("binnie.bacteria", 100))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.bacteriavector", 100)).duration(5 * TICKS).eut(60)
                .addTo(sBrewingRecipes);

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.dye, 1, 15)).noItemOutputs()
                .fluidInputs(FluidRegistry.getFluidStack("binnie.bacteria", 100))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.bacteriapoly", 100)).duration(5 * TICKS).eut(60)
                .addTo(sBrewingRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(GT_ModHandler.getModItem(PamsHarvestTheNether.ID, "ignisfruitItem", 45L, 0)).noItemOutputs()
                .fluidInputs(FluidRegistry.getFluidStack("potion.awkward", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("potion.fireresistance", 750)).duration(6 * SECONDS).eut(8)
                .addTo(sBrewingRecipes);

        // Add fermenter recipes from forestry into gregtech
        if (Forestry.isModLoaded()) {
            try {
                Class forestryFermenterRecipeManager = Class.forName("forestry.factory.recipes.FermenterRecipeManager");
                Field fieldFermenterRecipes = forestryFermenterRecipeManager.getDeclaredField("recipes");
                fieldFermenterRecipes.setAccessible(true);

                Iterable<IFermenterRecipe> recipes = (Iterable<IFermenterRecipe>) fieldFermenterRecipes.get(null);

                for (IFermenterRecipe recipe : recipes) {
                    ItemStack resource = recipe.getResource();

                    boolean alreadyHasRecipe = sBrewingRecipes.containsInput(resource);
                    boolean resultsInBiomass = recipe.getOutput().equals(FluidRegistry.getFluid("biomass"));

                    if (!alreadyHasRecipe && resultsInBiomass) {
                        int amountIn = recipe.getFermentationValue() * 2;
                        int amountOut = amountIn;

                        GT_Values.RA.stdBuilder().itemInputs(resource).noItemOutputs()
                                .fluidInputs(FluidRegistry.getFluidStack("water", amountIn))
                                .fluidOutputs(FluidRegistry.getFluidStack("biomass", amountOut)).duration(8 * amountOut)
                                .eut(3).addTo(sBrewingRecipes);

                        amountOut = (int) (amountOut * 1.5);

                        GT_Values.RA.stdBuilder().itemInputs(resource).noItemOutputs()
                                .fluidInputs(FluidRegistry.getFluidStack("juice", amountIn))
                                .fluidOutputs(FluidRegistry.getFluidStack("biomass", amountOut)).duration(8 * amountOut)
                                .eut(3).addTo(sBrewingRecipes);

                        GT_Values.RA.stdBuilder().itemInputs(resource).noItemOutputs()
                                .fluidInputs(Materials.Honey.getFluid(amountIn))
                                .fluidOutputs(FluidRegistry.getFluidStack("biomass", amountOut)).duration(8 * amountOut)
                                .eut(3).addTo(sBrewingRecipes);

                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
