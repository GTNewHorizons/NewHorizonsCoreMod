package com.dreammaster.gthandler.recipes;

import static gregtech.api.recipe.RecipeMaps.latheRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;

public class LatheRecipes implements Runnable {

    @Override
    public void run() {

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.ChromaticGlass, Materials2Shapes.plate, (int) (1)))
                .itemOutputs(NHItemList.ChromaticLens.get()).duration(60 * SECONDS).eut(TierEU.RECIPE_UHV)
                .addTo(latheRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.RadoxPoly, Materials2Shapes.plate, (int) (1)))
                .itemOutputs(NHItemList.RadoxPolymerLens.get()).duration(1 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_UEV).addTo(latheRecipes);
    }
}
