package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BetterQuesting;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.QuestBook;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

public class ScriptBetterQuesting implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "BetterQuesting";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(BetterQuesting.ID, QuestBook.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(BetterQuesting.ID, "submit_station", 1),
                "plateWood",
                "plateSteel",
                "plateWood",
                "plateSteel",
                "gearSteel",
                "plateSteel",
                "plateWood",
                getModItem(Minecraft.ID, "chest", 1),
                "plateWood");

        addShapedRecipe(
                getModItem(QuestBook.ID, "ItemQuestBook", 1, 0, missing),
                "stickWood",
                "stickWood",
                "stickWood",
                "stickWood",
                getModItem(Minecraft.ID, "book", 1, 0, missing),
                "stickWood",
                "stickWood",
                "stickWood",
                "stickWood");
        addShapelessRecipe(
                getModItem(BetterQuesting.ID, "submit_station", 1, 0, missing),
                getModItem(BetterQuesting.ID, "observation_station", 1, 0, missing));
        addShapelessRecipe(
                getModItem(BetterQuesting.ID, "observation_station", 1, 0, missing),
                getModItem(BetterQuesting.ID, "submit_station", 1, 0, missing));

    }
}
