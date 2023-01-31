package com.dreammaster.gthandler.recipes;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.enums.GT_Values.NI;

public class SifterRecipes implements Runnable{
    @Override
    public void run() {
        GT_Values.RA.addSifterRecipe(
                GT_OreDictUnificator.get(OrePrefixes.crushedPurified, Materials.Cinnabar, 1L),
                new ItemStack[]{Materials.Mercury.getGems(1), Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1), Materials.Mercury.getGems(1), Materials.Mercury.getGems(1),
                        Materials.Cinnabar.getDust(1)},
                new int[]{100, 300, 500, 1000, 1000, 1500, 2300, 2500, 3500},
                7200,
                30);

        if (Loader.isModLoaded("bartworks")){
            // Water Line
            GT_Values.RA.addSifterRecipe(
                    new ItemStack[] { NI },
                    new FluidStack[] { Materials.Water.getFluid(1000L) },
                    new ItemStack[] { Materials.Stone.getDust(1), Materials.Clay.getDust(1),
                            Materials.Calcite.getDust(1), Materials.Salt.getDust(1),
                            Materials.PolyvinylChloride.getNuggets(1) },
                    new FluidStack[] { Materials.Grade1PurifiedWater.getFluid(900L) },
                    new int[] { 5000, 2000, 1000, 1000, 100 },
                    500 * 10,
                    30_720,
                    true);
        }
    }
}
