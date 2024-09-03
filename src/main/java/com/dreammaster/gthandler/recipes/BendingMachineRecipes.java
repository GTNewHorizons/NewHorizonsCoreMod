package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.recipe.RecipeMaps.benderRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

public class BendingMachineRecipes implements Runnable {

    @Override
    public void run() {
        ItemStack missing = new ItemStack(Blocks.fire);

        GTValues.RA.stdBuilder()
                .itemInputs(CustomItemList.MicaInsulatorSheet.get(1L), ItemList.Circuit_Integrated.getWithDamage(0, 1))
                .itemOutputs(CustomItemList.MicaInsulatorFoil.get(4L)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(benderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Steel, 1L),
                        ItemList.Circuit_Integrated.getWithDamage(0, 1))
                .itemOutputs(ItemList.Shape_Empty.get(1L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(benderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Obsidian, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L)).duration(20 * SECONDS)
                .eut(24).addTo(benderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Obsidian, 9L),
                        GTUtility.getIntegratedCircuit(9))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 1L))
                .duration(3 * MINUTES).eut(TierEU.RECIPE_MV).addTo(benderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 9L),
                        GTUtility.getIntegratedCircuit(9))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 1L))
                .duration(3 * MINUTES).eut(TierEU.RECIPE_MV).addTo(benderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 9L),
                        GTUtility.getIntegratedCircuit(9))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Lapis, 1L)).duration(3 * MINUTES)
                .eut(TierEU.RECIPE_MV * 3 / 4).addTo(benderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Plastic, 1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.spring, Materials.Plastic, 1L)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(benderRecipes);

        if (GalacticraftCore.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(GalacticraftCore.ID, "item.basicItem", 2, 7, missing),
                            GTUtility.getIntegratedCircuit(2))
                    .itemOutputs(getModItem(GalacticraftCore.ID, "item.canister", 1, 0, missing)).duration(10 * SECONDS)
                    .eut(8).addTo(benderRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(
                            getModItem(GalacticraftCore.ID, "item.basicItem", 2, 6, missing),
                            GTUtility.getIntegratedCircuit(2))
                    .itemOutputs(getModItem(GalacticraftCore.ID, "item.canister", 1, 1, missing)).duration(10 * SECONDS)
                    .eut(8).addTo(benderRecipes);
        }
    }
}
