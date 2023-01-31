package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.GT_Values.RA;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class ArcFurnaceRecipes implements Runnable {

    @Override
    public void run() {
        RA.addArcFurnaceRecipe(
                GT_ModHandler.getModItem("IC2", "blockMiningPipe", 1L),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Steel, 2L), },
                null,
                50,
                90);
    }
}
