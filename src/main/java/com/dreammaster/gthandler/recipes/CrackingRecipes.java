package com.dreammaster.gthandler.recipes;

import static com.dreammaster.gthandler.GT_CoreModSupport.*;
import static gregtech.api.enums.Materials.*;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;

public class CrackingRecipes implements Runnable {

    public void run() {

        GT_Recipe.GT_Recipe_Map.sCrackingRecipes.addRecipe(
                false,
                new ItemStack[] { GT_Utility.getIntegratedCircuit(24) },
                null,
                null,
                new FluidStack[] { RadoxLight.getGas(100L), Silver.getPlasma(1) },
                new FluidStack[] { RadoxSuperLight.getGas(50L) },
                500,
                491_520,
                0);
        GT_Recipe.GT_Recipe_Map.sCrackingRecipes.addRecipe(
                false,
                new ItemStack[] { GT_Utility.getIntegratedCircuit(24) },
                null,
                null,
                new FluidStack[] { RadoxHeavy.getFluid(100L), Silver.getPlasma(1) },
                new FluidStack[] { RadoxLight.getGas(20L) },
                500,
                491_520,
                0);
    }
}
