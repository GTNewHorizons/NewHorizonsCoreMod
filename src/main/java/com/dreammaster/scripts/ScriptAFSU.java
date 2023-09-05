package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AFSU;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

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

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Elite, 1),
                        ItemList.Energy_LapotronicOrb.get(1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(AFSU.ID, "ALC", 1)).noFluidInputs().noFluidOutputs().duration(2 * MINUTES)
                .eut(TierEU.RECIPE_EV).addTo(sAssemblerRecipes);

    }
}
