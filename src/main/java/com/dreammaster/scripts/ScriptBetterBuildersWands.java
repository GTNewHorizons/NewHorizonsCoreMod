package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.BetterBuildersWands;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersGregworks;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.TierEU;

public class ScriptBetterBuildersWands implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Better Builders Wands";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(BetterBuildersWands.ID, ExtraUtilities.ID, TinkerConstruct.ID, TinkersGregworks.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(BetterBuildersWands.ID, "wandStone", 1, 0),
                "craftingToolSaw",
                "screwIron",
                "plateStone",
                null,
                "stickWood",
                "screwIron",
                "stickWood",
                null,
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(BetterBuildersWands.ID, "wandIron", 1, 0),
                "craftingToolSaw",
                "screwSteel",
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 2),
                null,
                getModItem(TinkerConstruct.ID, "toolRod", 1, 2),
                "screwSteel",
                getModItem(TinkerConstruct.ID, "toolRod", 1, 2),
                null,
                "craftingToolScrewdriver");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "toolRod", 2, 2),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 2))
                .itemOutputs(getModItem(BetterBuildersWands.ID, "wandIron", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(
                createItemStack(TinkersGregworks.ID, "tGregToolPartToughRod", 1, 1594, "{material:\"Diamond\"}"),
                createItemStack(TinkersGregworks.ID, "tGregToolPartLargePlate", 1, 1594, "{material:\"Diamond\"}"))
                .itemOutputs(getModItem(BetterBuildersWands.ID, "wandDiamond", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "toughRod", 1, 314),
                        getModItem(ExtraUtilities.ID, "builderswand", 1, 0))
                .itemOutputs(getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 4)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 4),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 314))
                .itemOutputs(getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 5)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 5),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 2, 314))
                .itemOutputs(getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 6)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 6),
                        getModItem(ExtraUtilities.ID, "creativebuilderswand", 1, 0))
                .itemOutputs(getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 12)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_EV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 12),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 4, 314))
                .itemOutputs(getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 13)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 13),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 8, 314))
                .itemOutputs(getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 14)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_IV / 2).addTo(assemblerRecipes);

    }
}
