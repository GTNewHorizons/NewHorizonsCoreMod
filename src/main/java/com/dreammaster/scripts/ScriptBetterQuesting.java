package com.dreammaster.scripts;

import java.util.Arrays;
import java.util.List;

import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptBetterQuesting implements IScriptLoader{
    private long startTime;
    private long endTime;
    private static final String scriptName = "BetterQuesting";
    private static final List<String> dependencies = Arrays.asList("betterquesting");

    public ScriptBetterQuesting() {

    }
    @Override
    public void loadRecipes() {
        startTime = System.currentTimeMillis();
        addShapedRecipe(getModItem("betterquesting", "submit_station", 1), new Object[]{
                "plateWood","plateSteel","plateWood",
                "plateSteel","gearSteel","plateSteel",
                "plateWood",getModItem("minecraft", "chest", 1),"plateWood"});
        endTime = System.currentTimeMillis();
    }

    @Override
    public long getExecutionTime(){
        return endTime-startTime;
    }

    @Override
    public List<String> getDependencies() {
        return dependencies;
    }

    @Override
    public String getScriptName() {
        return scriptName;
    }
}
