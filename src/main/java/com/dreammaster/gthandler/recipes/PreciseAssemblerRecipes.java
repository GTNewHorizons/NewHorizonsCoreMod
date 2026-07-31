package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.STACKS;
import static gregtech.api.util.GTRecipeConstants.PRECISE_ASSEMBLER_CASING_TIER;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import goodgenerator.api.recipe.GoodGeneratorRecipeMaps;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.FluidShapes;
import gregtech.api.enums.materials.Materials;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;

public class PreciseAssemblerRecipes implements Runnable {

    @Override
    public void run() {

        if (TwilightForest.isModLoaded() && GalacticraftAmunRa.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator.get(OrePrefixes.nanite, Materials.Glowstone, 64),
                            GregtechItemList.QuadrupleCompressedGlowstone.get(8),
                            getModItem(TwilightForest.ID, "tile.TFSapling", 64, 6))
                    .itemOutputs(getModItem(GalacticraftAmunRa.ID, "tile.saplings", 1, 1))
                    .fluidInputs(
                            MaterialLibAPI
                                    .getFluidStack(Materials.Hypogen, FluidShapes.fluidMolten, (int) (1 * STACKS)),
                            MaterialLibAPI.getFluidStack(
                                    Materials.NaquadahBasedLiquidFuelMkV,
                                    FluidShapes.fluidLiquid,
                                    (int) (4000)))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_UHV).metadata(PRECISE_ASSEMBLER_CASING_TIER, 3)
                    .addTo(GoodGeneratorRecipeMaps.preciseAssemblerRecipes);
        }
    }
}
