package com.dreammaster.gthandler.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;

public class FluidHeaterRecipes implements Runnable {

    @Override
    public void run() {
        if (Loader.isModLoaded("bartworks")) {

            GT_Recipe.GT_Recipe_Map.sFluidHeaterRecipes.addRecipe(
                    false,
                    new ItemStack[] { GT_Utility.getIntegratedCircuit(1) },
                    null,
                    null,
                    new FluidStack[] { Materials.Grade1PurifiedWater.getFluid(1000L) },
                    new FluidStack[] { Materials.Grade2PurifiedWater.getFluid(900L) },
                    5000,
                    61_440,
                    0);
        }
    }
}
