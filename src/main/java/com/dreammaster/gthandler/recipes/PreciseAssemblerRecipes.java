package com.dreammaster.gthandler.recipes;

import static goodgenerator.api.recipe.GoodGeneratorRecipeMaps.preciseAssemblerRecipes;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.util.GTRecipeBuilder.INGOTS;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.STACKS;
import static gregtech.api.util.GTRecipeConstants.PRECISE_ASSEMBLER_CASING_TIER;

import goodgenerator.api.recipe.GoodGeneratorRecipeMaps;
import goodgenerator.items.GGMaterial;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gtPlusPlus.core.material.MaterialsElements;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;

public class PreciseAssemblerRecipes implements Runnable {

    @Override
    public void run() {

        // Central Exo Foundry Casing
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Radiator_Fluid_Solidifier.get(4),
                        ItemList.Naquarite_Universal_Insulator_Foil.get(8),
                        ItemList.FluidRegulator_UHV.get(4),
                        ItemList.Field_Generator_UV.get(1))
                .fluidInputs(
                        Materials.SuperconductorUVBase.getMolten(INGOTS * 40),
                        Materials.TungstenCarbide.getMolten(INGOTS * 40),
                        Materials.NaquadahEnriched.getMolten(INGOTS * 40))
                .itemOutputs(ItemList.Central_Casing_ExoFoundry.get(4)).duration(20 * SECONDS).eut(TierEU.RECIPE_UHV)
                .metadata(PRECISE_ASSEMBLER_CASING_TIER, 3).addTo(preciseAssemblerRecipes);

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
