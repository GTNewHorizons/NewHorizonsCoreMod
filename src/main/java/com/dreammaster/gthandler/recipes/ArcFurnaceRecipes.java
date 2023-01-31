package com.dreammaster.gthandler.recipes;

import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.RA;

public class ArcFurnaceRecipes implements Runnable{
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
