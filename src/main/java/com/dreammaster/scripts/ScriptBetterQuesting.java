package com.dreammaster.scripts;

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
        return Collections.singletonList("betterquesting");
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("betterquesting", "submit_station", 1),
                new Object[] { "plateWood", "plateSteel", "plateWood", "plateSteel", "gearSteel", "plateSteel",
                        "plateWood", getModItem("minecraft", "chest", 1), "plateWood" });
    }
}
