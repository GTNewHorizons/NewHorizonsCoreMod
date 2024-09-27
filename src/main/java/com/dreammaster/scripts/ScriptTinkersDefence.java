package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersDefence;
import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.tinkersConstruct.TConstructHelper;

import gregtech.api.enums.GTValues;
import gregtech.api.recipe.RecipeCategories;

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
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersDefence.ID, "AeonSteel Ingot", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 25, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "arrowhead", 1, 201, missing))
                .duration(1 * MINUTES + 28 * SECONDS).eut(120).recipeCategory(RecipeCategories.ticPartExtruding)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersDefence.ID, "DogbeariumIngot", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 25, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "arrowhead", 1, 203, missing))
                .duration(1 * MINUTES + 4 * SECONDS).eut(120).recipeCategory(RecipeCategories.ticPartExtruding)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersDefence.ID, "Queen's Gold Ingot", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 25, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "arrowhead", 1, 202, missing)).duration(10 * SECONDS)
                .eut(120).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);

    }
}
