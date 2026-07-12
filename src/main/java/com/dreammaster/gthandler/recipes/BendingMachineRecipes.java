package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.recipe.RecipeMaps.benderRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.util.GTOreDictUnificator;

public class BendingMachineRecipes implements Runnable {

    @Override
    public void run() {
        ItemStack missing = new ItemStack(Blocks.fire);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.MicaInsulatorSheet.get()).circuit(1)
                .itemOutputs(NHItemList.MicaInsulatorFoil.get(4)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(benderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials2Materials.Steel, Materials2Shapes.plateQuadruple, (int) (1L)))
                .circuit(1).itemOutputs(ItemList.Shape_Empty.get(1L)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(benderRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Obsidian, Materials2Shapes.ingot, (int) (1L)))
                .circuit(1)
                .itemOutputs(MaterialLibAPI.getStack(Materials2Materials.Obsidian, Materials2Shapes.plate, (int) (1L)))
                .duration(20 * SECONDS).eut(24).addTo(benderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Obsidian, Materials2Shapes.ingot, (int) (9L)))
                .circuit(9).itemOutputs(GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 1L))
                .duration(3 * MINUTES).eut(TierEU.RECIPE_MV).addTo(benderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Obsidian, Materials2Shapes.plate, (int) (9L)))
                .circuit(9).itemOutputs(GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Obsidian, 1L))
                .duration(3 * MINUTES).eut(TierEU.RECIPE_MV).addTo(benderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(MaterialLibAPI.getStack(Materials2Materials.Lapis, Materials2Shapes.plate, (int) (9L)))
                .circuit(9).itemOutputs(GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Lapis, 1L))
                .duration(3 * MINUTES).eut(TierEU.RECIPE_MV * 3 / 4).addTo(benderRecipes);

        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Polyethylene, 1L))
                .circuit(1).itemOutputs(GTOreDictUnificator.get(OrePrefixes.spring, Materials.Polyethylene, 1L))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(benderRecipes);

        if (GalacticraftCore.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.basicItem", 2, 7)).circuit(2)
                    .itemOutputs(getModItem(GalacticraftCore.ID, "item.canister", 1, 0)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_ULV).addTo(benderRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.basicItem", 2, 6)).circuit(2)
                    .itemOutputs(getModItem(GalacticraftCore.ID, "item.canister", 1, 1)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_ULV).addTo(benderRecipes);
        }
    }
}
