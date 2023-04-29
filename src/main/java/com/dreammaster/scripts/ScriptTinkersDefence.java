package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sExtruderRecipes;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GT_Values;

public class ScriptTinkersDefence implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Tinkers Defence";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList("tinkersdefense");
    }

    @Override
    public void loadRecipes() {
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("tinkersdefense", "AeonSteelIngot", 1, 0, missing),
                        getModItem("TConstruct", "metalPattern", 0, 25, missing))
                .itemOutputs(getModItem("TConstruct", "arrowhead", 1, 201, missing)).noFluidInputs().noFluidOutputs()
                .duration(1760).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("tinkersdefense", "DogbeariumIngot", 1, 0, missing),
                        getModItem("TConstruct", "metalPattern", 0, 25, missing))
                .itemOutputs(getModItem("TConstruct", "arrowhead", 1, 203, missing)).noFluidInputs().noFluidOutputs()
                .duration(1280).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("tinkersdefense", "QueensGoldIngot", 1, 0, missing),
                        getModItem("TConstruct", "metalPattern", 0, 25, missing))
                .itemOutputs(getModItem("TConstruct", "arrowhead", 1, 202, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(120).addTo(sExtruderRecipes);

    }
}
