package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersDefence;
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
        return Arrays.asList(TinkersDefence.ID, TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "arrowhead", 1, 201, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "arrowhead", 1, 203, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "arrowhead", 1, 202, missing));
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkersDefence.ID, "AeonSteelIngot", 9, 0, missing))
                .itemOutputs(getModItem(TinkersDefence.ID, "AeonSteelBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkersDefence.ID, "QueensGoldIngot", 9, 0, missing))
                .itemOutputs(getModItem(TinkersDefence.ID, "QueensGoldBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkersDefence.ID, "DogbeariumIngot", 9, 0, missing))
                .itemOutputs(getModItem(TinkersDefence.ID, "DogbeariumBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersDefence.ID, "AeonSteelIngot", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 25, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "arrowhead", 1, 201, missing)).noFluidInputs()
                .noFluidOutputs().duration(1760).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersDefence.ID, "DogbeariumIngot", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 25, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "arrowhead", 1, 203, missing)).noFluidInputs()
                .noFluidOutputs().duration(1280).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersDefence.ID, "QueensGoldIngot", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 25, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "arrowhead", 1, 202, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).addTo(sExtruderRecipes);

    }
}
