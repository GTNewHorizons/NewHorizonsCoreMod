package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.STACKS;
import static gregtech.api.util.GTRecipeConstants.PRECISE_ASSEMBLER_CASING_TIER;

import goodgenerator.api.recipe.GoodGeneratorRecipeMaps;
import goodgenerator.items.GGMaterial;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.material.MU;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;

public class PreciseAssemblerRecipes implements Runnable {

    @Override
    public void run() {

        if (TwilightForest.isModLoaded() && GalacticraftAmunRa.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            GTOreDictUnificator
                                    .get(OrePrefixes.nanite, MU.materialOf(Materials2Materials.Glowstone), 64),
                            GregtechItemList.QuadrupleCompressedGlowstone.get(8),
                            getModItem(TwilightForest.ID, "tile.TFSapling", 64, 6))
                    .itemOutputs(getModItem(GalacticraftAmunRa.ID, "tile.saplings", 1, 1))
                    .fluidInputs(
                            MaterialsElements.STANDALONE.HYPOGEN.getFluidStack(1 * STACKS),
                            GGMaterial.naquadahBasedFuelMkV.getFluidOrGas(4000))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_UHV).metadata(PRECISE_ASSEMBLER_CASING_TIER, 3)
                    .addTo(GoodGeneratorRecipeMaps.preciseAssemblerRecipes);
        }
    }
}
