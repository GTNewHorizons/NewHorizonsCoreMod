package com.dreammaster.gthandler.recipes;

import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sBenderRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.*;
import gregtech.api.util.GT_OreDictUnificator;

public class BendingMachineRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.MicaInsulatorSheet.get(1L), ItemList.Circuit_Integrated.getWithDamage(0, 1))
                .itemOutputs(CustomItemList.MicaInsulatorFoil.get(4L)).noFluidInputs().noFluidOutputs()
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sBenderRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Steel, 1L),
                        ItemList.Circuit_Integrated.getWithDamage(0, 1))
                .itemOutputs(ItemList.Shape_Empty.get(1L)).noFluidInputs().noFluidOutputs().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sBenderRecipes);
    }
}
