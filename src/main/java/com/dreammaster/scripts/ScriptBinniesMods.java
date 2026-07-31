package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;

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
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 2))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Emerald, Shapes.dustTiny, (int) (1L)))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 3))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Ruby, Shapes.dustTiny, (int) (1L))).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 4))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Sapphire, Shapes.dustTiny, (int) (1L)))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ExtraBees.ID, "misc", 1, 5))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Lapis, Shapes.dustTiny, (int) (1L))).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

    }
}
