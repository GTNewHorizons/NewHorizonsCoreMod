package com.dreammaster.gthandler.recipes;

import static com.dreammaster.MissingModIDs.Genetics;
import static com.dreammaster.MissingModIDs.PamsHarvestTheNether;
import static gregtech.api.enums.ModIDs.Forestry;
import static gregtech.api.enums.ModIDs.IndustrialCraft2;

import java.lang.reflect.Field;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import cpw.mods.fml.common.Loader;
import forestry.api.recipes.IFermenterRecipe;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Recipe;

public class BrewingMachineRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addBrewingRecipeCustom(
                GT_ModHandler.getModItem(Genetics.modID, "misc", 6L, 4),
                FluidRegistry.getFluidStack("water", 750),
                FluidRegistry.getFluidStack("binnie.growthmedium", 750),
                600,
                480,
                false);
        GT_Values.RA.addBrewingRecipeCustom(
                GT_ModHandler.getModItem(IndustrialCraft2.modID, "itemBiochaff", 16L, 0),
                FluidRegistry.getFluidStack("binnie.growthmedium", 750),
                FluidRegistry.getFluidStack("binnie.bacteria", 750),
                1200,
                480,
                false);
        GT_Values.RA.addBrewingRecipeCustom(
                new ItemStack(Items.blaze_powder, 1, 0),
                FluidRegistry.getFluidStack("binnie.bacteria", 100),
                FluidRegistry.getFluidStack("binnie.bacteriavector", 100),
                5,
                60,
                false);
        GT_Values.RA.addBrewingRecipeCustom(
                new ItemStack(Items.dye, 1, 15),
                FluidRegistry.getFluidStack("binnie.bacteria", 100),
                FluidRegistry.getFluidStack("binnie.bacteriapoly", 100),
                5,
                60,
                false);

        GT_Values.RA.addBrewingRecipeCustom(
                GT_ModHandler.getModItem(PamsHarvestTheNether.modID, "ignisfruitItem", 45L, 0),
                FluidRegistry.getFluidStack("potion.awkward", 750),
                FluidRegistry.getFluidStack("potion.fireresistance", 750),
                120,
                8,
                false);

        // Add fermenter recipes from forestry into gregtech
        if (Forestry.isModLoaded()) {
            try {
                Class forestryFermenterRecipeManager = Class.forName("forestry.factory.recipes.FermenterRecipeManager");
                Field fieldFermenterRecipes = forestryFermenterRecipeManager.getDeclaredField("recipes");
                fieldFermenterRecipes.setAccessible(true);

                Iterable<IFermenterRecipe> recipes = (Iterable<IFermenterRecipe>) fieldFermenterRecipes.get(null);

                for (IFermenterRecipe recipe : recipes) {
                    ItemStack resource = recipe.getResource();

                    boolean alreadyHasRecipe = GT_Recipe.GT_Recipe_Map.sBrewingRecipes.containsInput(resource);
                    boolean resultsInBiomass = recipe.getOutput().equals(FluidRegistry.getFluid("biomass"));

                    if (!alreadyHasRecipe && resultsInBiomass) {
                        int amountIn = recipe.getFermentationValue() * 2;
                        int amountOut = amountIn;
                        GT_Values.RA.addBrewingRecipeCustom(
                                resource,
                                FluidRegistry.getFluidStack("water", amountIn),
                                FluidRegistry.getFluidStack("biomass", amountOut),
                                8 * amountOut,
                                3,
                                false);

                        amountOut = (int) (amountOut * 1.5);
                        GT_Values.RA.addBrewingRecipeCustom(
                                resource,
                                FluidRegistry.getFluidStack("juice", amountIn),
                                FluidRegistry.getFluidStack("biomass", amountOut),
                                8 * amountOut,
                                3,
                                false);
                        GT_Values.RA.addBrewingRecipeCustom(
                                resource,
                                Materials.Honey.getFluid(amountIn),
                                FluidRegistry.getFluidStack("biomass", amountOut),
                                8 * amountOut,
                                3,
                                false);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
