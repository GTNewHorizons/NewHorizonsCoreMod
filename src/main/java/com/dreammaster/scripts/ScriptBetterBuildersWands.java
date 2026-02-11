package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BetterBuildersWands;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersGregworks;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
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
                getModItem(BetterBuildersWands.ID, "wandStone", 1, 0, missing),
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
                getModItem(BetterBuildersWands.ID, "wandIron", 1, 0, missing),
                "craftingToolSaw",
                "screwSteel",
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "toolRod", 1, 2, missing),
                "screwSteel",
                getModItem(TinkerConstruct.ID, "toolRod", 1, 2, missing),
                null,
                "craftingToolScrewdriver");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "toolRod", 2, 2, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 2, missing))
                .itemOutputs(getModItem(BetterBuildersWands.ID, "wandIron", 1, 0, missing)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartToughRod",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing),
                        createItemStack(
                                TinkersGregworks.ID,
                                "tGregToolPartLargePlate",
                                1,
                                1594,
                                "{material:\"Diamond\"}",
                                missing))
                .itemOutputs(getModItem(BetterBuildersWands.ID, "wandDiamond", 1, 0, missing)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "toughRod", 1, 314, missing),
                        getModItem(ExtraUtilities.ID, "builderswand", 1, 0, missing))
                .itemOutputs(getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 4, missing))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 4, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 314, missing))
                .itemOutputs(getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 5, missing))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 5, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 2, 314, missing))
                .itemOutputs(getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 6, missing))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 6, missing),
                        getModItem(ExtraUtilities.ID, "creativebuilderswand", 1, 0, missing))
                .itemOutputs(getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 12, missing))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_EV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 12, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 4, 314, missing))
                .itemOutputs(getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 13, missing))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_EV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 13, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 8, 314, missing))
                .itemOutputs(getModItem(BetterBuildersWands.ID, "wandUnbreakable", 1, 14, missing))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_IV / 2).addTo(assemblerRecipes);

    }
}
