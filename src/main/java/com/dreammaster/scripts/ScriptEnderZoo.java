package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.EnderZoo;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Collections;
import java.util.List;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;

public class ScriptEnderZoo implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "EnderZoo";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList(EnderZoo.ID);
    }

    @Override
    public void loadRecipes() {
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "tnt", 1), getModItem(EnderZoo.ID, "confusingDust", 4))
                .itemOutputs(getModItem(EnderZoo.ID, "blockConfusingCharge", 1)).duration(20 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "tnt", 1), getModItem(EnderZoo.ID, "enderFragment", 4))
                .itemOutputs(getModItem(EnderZoo.ID, "blockEnderCharge", 1)).duration(20 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderZoo.ID, "blockConfusingCharge", 1),
                        getModItem(EnderZoo.ID, "blockEnderCharge", 1))
                .itemOutputs(getModItem(EnderZoo.ID, "blockConcussionCharge", 2)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
    }
}
