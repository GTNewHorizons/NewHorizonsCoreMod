package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.BEAMCRAFTER_METADATA;
import static gregtech.api.recipe.RecipeMaps.beamcrafterRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gtnhlanth.common.beamline.Particle.GRAVITON;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.loaders.postload.recipes.beamcrafter.BeamCrafterMetadata;

public class BeamcraftingRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Wafer_APIC.get(1),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.SpaceTime, 1))
                .fluidInputs(Materials.Creon.getMolten(576L), Materials.Mellion.getMolten(576L))
                .itemOutputs(ItemList.Circuit_Wafer_ZPIC.get(1))
                .metadata(
                        BEAMCRAFTER_METADATA,
                        BeamCrafterMetadata.builder().particleID_A(GRAVITON.getId()).particleID_B(GRAVITON.getId())
                                .amount_A(20).amount_B(20).build())
                .eut(TierEU.RECIPE_UIV).duration(2 * SECONDS).addTo(beamcrafterRecipes);

    }
}
