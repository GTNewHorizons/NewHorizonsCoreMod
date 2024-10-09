package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AFSU;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

public class ScriptAFSU implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "AFSU";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(AFSU.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(AFSU.ID, "AFSU", 1),
                "cableGt01Platinum",
                "itemCasingTungstenSteel",
                "cableGt01Platinum",
                "itemCasingTungstenSteel",
                ItemList.Hull_IV.get(1L),
                "itemCasingTungstenSteel",
                "circuitMaster",
                getModItem(AFSU.ID, "ALC", 1),
                "circuitMaster");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.IV, 1),
                        ItemList.Energy_LapotronicOrb.get(1L),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(AFSU.ID, "ALC", 1)).duration(2 * MINUTES).eut(TierEU.RECIPE_EV)
                .addTo(assemblerRecipes);

    }
}
