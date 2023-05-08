package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sSifterRecipes;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_OreDictUnificator;

public class SifterRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.crushedPurified, Materials.Cinnabar, 1L))
                .itemOutputs(
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Mercury.getGems(1),
                        Materials.Cinnabar.getDust(1))
                .outputChances(100, 300, 500, 1000, 1000, 1500, 2300, 2500, 3500).noFluidInputs().noFluidOutputs()
                .duration(6 * MINUTES).eut(TierEU.RECIPE_LV).addTo(sSifterRecipes);

        if (BartWorks.isModLoaded()) {
            // Water Line
            GT_Values.RA.stdBuilder().noItemInputs()
                    .itemOutputs(
                            Materials.Stone.getDust(1),
                            Materials.Clay.getDust(1),
                            Materials.Calcite.getDust(1),
                            Materials.Salt.getDust(1),
                            Materials.PolyvinylChloride.getNuggets(1))
                    .outputChances(5000, 2000, 1000, 1000, 100).fluidInputs(Materials.Water.getFluid(1000L))
                    .fluidOutputs(Materials.Grade1PurifiedWater.getFluid(900L)).requiresCleanRoom()
                    .duration(4 * MINUTES + 10 * SECONDS).eut(TierEU.RECIPE_LuV).addTo(sSifterRecipes);
        }
    }
}
