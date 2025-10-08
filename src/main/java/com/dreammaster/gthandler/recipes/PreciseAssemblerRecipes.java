package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.STACKS;
import static gregtech.api.util.GTRecipeConstants.PRECISE_ASSEMBLER_CASING_TIER;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import goodgenerator.api.recipe.GoodGeneratorRecipeMaps;
import goodgenerator.items.GGMaterial;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;

public class PreciseAssemblerRecipes implements Runnable {

    // put the soldering Materials in this array
    final Materials[] solderingMaterials = new Materials[] { Materials.Lead, Materials.SolderingAlloy, Materials.Tin };

    ItemStack missing = new ItemStack(Blocks.fire);

    @Override
    public void run() {
        if (TwilightForest.isModLoaded() && GalacticraftAmunRa.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            Materials.Glowstone.getNanite(64),
                            GregtechItemList.QuadrupleCompressedGlowstone.get(8),
                            GTModHandler.getModItem(TwilightForest.ID, "tile.TFSapling", 64, 6))
                    .itemOutputs(GTModHandler.getModItem(GalacticraftAmunRa.ID, "tile.saplings", 1, 1))
                    .fluidInputs(
                            MaterialsElements.STANDALONE.HYPOGEN.getFluidStack(1 * STACKS),
                            GGMaterial.naquadahBasedFuelMkV.getFluidOrGas(4000))
                    .duration(30 * SECONDS).eut(TierEU.RECIPE_UHV).metadata(PRECISE_ASSEMBLER_CASING_TIER, 3)
                    .addTo(GoodGeneratorRecipeMaps.preciseAssemblerRecipes);
        }
    }
}
