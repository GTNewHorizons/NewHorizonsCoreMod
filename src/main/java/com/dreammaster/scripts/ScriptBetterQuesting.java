package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptBetterQuesting implements IScriptLoader{

    public ScriptBetterQuesting() {
        scriptName.append("BetterQuesting");
        dependencies.add("betterquesting");
    }
    @Override
    public void loadRecipes() {
        addShapedRecipe(getModItem("betterquesting", "submit_station", 1), new Object[]{
                "plateWood","plateSteel","plateWood",
                "plateSteel","gearSteel","plateSteel",
                "plateWood",getModItem("minecraft", "chest", 1),"plateWood"});
    }
}
