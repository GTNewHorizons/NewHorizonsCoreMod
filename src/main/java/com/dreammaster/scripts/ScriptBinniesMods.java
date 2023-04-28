package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptBinniesMods implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Binnies Mods";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.Avaritia.ID, Mods.ExtraBees.ID);
    }

    @Override
    public void loadRecipes() {
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Avaritia", "Resource", 1, 3, missing))
                .itemOutputs(getModItem("Avaritia", "Resource", 9, 2, missing)).outputChances(10000).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraBees", "misc", 1, 2, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 501, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraBees", "misc", 1, 3, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 502, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraBees", "misc", 1, 4, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 503, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("ExtraBees", "misc", 1, 5, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 526, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);

    }
}
