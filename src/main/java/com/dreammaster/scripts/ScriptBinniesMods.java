package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

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
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 2, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Emerald, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 3, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Ruby, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 4, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Sapphire, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 5, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Lapis, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

    }
}
