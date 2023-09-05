package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;

public class ScriptBinniesMods implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Binnies Mods";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Avaritia.ID, ExtraBees.ID);
    }

    @Override
    public void loadRecipes() {
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Avaritia.ID, "Resource", 1, 3, missing))
                .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 2, missing)).outputChances(10000).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 2, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Emerald, 1L)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 3, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ruby, 1L)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 4, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Sapphire, 1L))
                .outputChances(10000).noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 5, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Lapis, 1L)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);

    }
}
