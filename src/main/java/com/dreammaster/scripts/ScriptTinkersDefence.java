package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCompressorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sExtruderRecipes;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.tinkersConstruct.TConstructHelper;
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
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "arrowhead", 1, 201, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "arrowhead", 1, 203, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "arrowhead", 1, 202, missing));
        GT_Values.RA.stdBuilder().itemInputs(getModItem("tinkersdefense", "AeonSteelIngot", 9, 0, missing))
                .itemOutputs(getModItem("tinkersdefense", "AeonSteelBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("tinkersdefense", "QueensGoldIngot", 9, 0, missing))
                .itemOutputs(getModItem("tinkersdefense", "QueensGoldBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("tinkersdefense", "DogbeariumIngot", 9, 0, missing))
                .itemOutputs(getModItem("tinkersdefense", "DogbeariumBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
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
