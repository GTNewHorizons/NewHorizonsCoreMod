package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Fether;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.Genetics;
import static gregtech.api.recipe.RecipeMaps.brewingRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import forestry.api.recipes.IFermenterRecipe;
import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;

public class BrewingMachineRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder().itemInputs(getModItem(Genetics.ID, "misc", 6, 4))
                .fluidInputs(FluidRegistry.getFluidStack("water", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.growthmedium", 750)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(brewingRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Chaff.get(16))
                .fluidInputs(FluidRegistry.getFluidStack("binnie.growthmedium", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.bacteria", 750)).duration(60 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(brewingRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.blaze_powder, 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("binnie.bacteria", 100))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.bacteriavector", 100)).duration(5 * TICKS)
                .eut(TierEU.RECIPE_MV / 2).addTo(brewingRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.dye, 1, 15))
                .fluidInputs(FluidRegistry.getFluidStack("binnie.bacteria", 100))
                .fluidOutputs(FluidRegistry.getFluidStack("binnie.bacteriapoly", 100)).duration(5 * TICKS)
                .eut(TierEU.RECIPE_MV / 2).addTo(brewingRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(Fether.ID, "ignis_fruit", 45, 0))
                .fluidInputs(FluidRegistry.getFluidStack("potion.awkward", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("potion.fireresistance", 750)).duration(6 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(brewingRecipes);

        // Add fermenter recipes from forestry into gregtech
        if (Forestry.isModLoaded()) {
            for (IFermenterRecipe recipe : RecipeManagers.fermenterManager.recipes()) {
                ItemStack resource = recipe.getResource();

                boolean alreadyHasRecipe = brewingRecipes.containsInput(resource);
                boolean resultsInBiomass = recipe.getOutput().equals(Materials.Biomass.mFluid);

                if (!alreadyHasRecipe && resultsInBiomass) {
                    int amountIn = recipe.getFermentationValue() * 2;
                    int amountOut = amountIn;

                    GTValues.RA.stdBuilder().itemInputs(resource)
                            .fluidInputs(FluidRegistry.getFluidStack("water", amountIn))
                            .fluidOutputs(Materials.Biomass.getFluid(amountOut)).duration(8 * amountOut).eut(3)
                            .addTo(brewingRecipes);

                    amountOut = (int) (amountOut * 1.5);

                    GTValues.RA.stdBuilder().itemInputs(resource)
                            .fluidInputs(FluidRegistry.getFluidStack("juice", amountIn))
                            .fluidOutputs(Materials.Biomass.getFluid(amountOut)).duration(8 * amountOut).eut(3)
                            .addTo(brewingRecipes);

                    GTValues.RA.stdBuilder().itemInputs(resource).fluidInputs(Materials.Honey.getFluid(amountIn))
                            .fluidOutputs(Materials.Biomass.getFluid(amountOut)).duration(8 * amountOut).eut(3)
                            .addTo(brewingRecipes);

                }
            }
        }
    }

}
