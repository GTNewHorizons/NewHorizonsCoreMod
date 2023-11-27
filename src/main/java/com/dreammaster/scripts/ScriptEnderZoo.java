package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.EnderZoo;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import java.util.Collections;
import java.util.List;

import gregtech.api.enums.GT_Values;
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
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "tnt", 1), getModItem(EnderZoo.ID, "confusingDust", 4))
                .itemOutputs(getModItem(EnderZoo.ID, "blockConfusingCharge", 1)).duration(20 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "tnt", 1), getModItem(EnderZoo.ID, "enderFragment", 4))
                .itemOutputs(getModItem(EnderZoo.ID, "blockEnderCharge", 1)).duration(20 * SECONDS).eut(16)
                .addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderZoo.ID, "blockConfusingCharge", 1),
                        getModItem(EnderZoo.ID, "blockEnderCharge", 1))
                .itemOutputs(getModItem(EnderZoo.ID, "blockConcussionCharge", 2)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
    }
}
