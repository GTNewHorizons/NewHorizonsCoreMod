package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersDefence;
import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.tinkersConstruct.TConstructHelper;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;
import gregtech.api.recipe.RecipeCategories;

public class ScriptTinkersDefence implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Tinkers Defence";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(TinkerConstruct.ID, TinkersDefence.ID);
    }

    @Override
    public void loadRecipes() {
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "arrowhead", 1, 201));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "arrowhead", 1, 203));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "arrowhead", 1, 202));
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersDefence.ID, "AeonSteel Ingot", 1, 0),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 25))
                .itemOutputs(getModItem(TinkerConstruct.ID, "arrowhead", 1, 201)).duration(1 * MINUTES + 28 * SECONDS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersDefence.ID, "DogbeariumIngot", 1, 0),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 25))
                .itemOutputs(getModItem(TinkerConstruct.ID, "arrowhead", 1, 203)).duration(1 * MINUTES + 4 * SECONDS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkersDefence.ID, "Queen's Gold Ingot", 1, 0),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 25))
                .itemOutputs(getModItem(TinkerConstruct.ID, "arrowhead", 1, 202)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).recipeCategory(RecipeCategories.ticPartExtruding).addTo(extruderRecipes);

    }
}
