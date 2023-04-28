package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BetterQuesting;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Collections;
import java.util.List;

public class ScriptBetterQuesting implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "BetterQuesting";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList(BetterQuesting.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(BetterQuesting.ID, "submit_station", 1),
                new Object[] { "plateWood", "plateSteel", "plateWood", "plateSteel", "gearSteel", "plateSteel",
                        "plateWood", getModItem(Minecraft.ID, "chest", 1), "plateWood" });

        addShapedRecipe(
                getModItem("questbook", "ItemQuestBook", 1, 0, missing),
                new Object[] { "stickWood", "stickWood", "stickWood", "stickWood",
                        getModItem("minecraft", "book", 1, 0, missing), "stickWood", "stickWood", "stickWood",
                        "stickWood" });
        addShapelessCraftingRecipe(
                getModItem("betterquesting", "submit_station", 1, 0, missing),
                new Object[] { getModItem("betterquesting", "observation_station", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("betterquesting", "observation_station", 1, 0, missing),
                new Object[] { getModItem("betterquesting", "submit_station", 1, 0, missing) });

    }
}
