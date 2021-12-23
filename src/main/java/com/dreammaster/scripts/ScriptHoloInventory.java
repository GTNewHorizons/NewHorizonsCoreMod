package com.dreammaster.scripts;

import java.util.Arrays;
import java.util.List;

import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptHoloInventory implements IScriptLoader{
    private long startTime;
    private long endTime;
    private static final String scriptName = "HoloInventory";
    private static final List<String> dependencies = Arrays.asList("holoinventory");

    public ScriptHoloInventory() {

    }
    @Override
    public void loadRecipes() {
        startTime = System.currentTimeMillis();
        addShapedRecipe(getModItem("holoinventory", "Hologlasses", 1), new Object[]{
                "stickSteel", "screwSteel", "stickSteel",
                "ringSteel", "boltSteel", "ringSteel",
                "lensInfusedEntropy", "craftingToolScrewdriver", "lensInfusedEntropy"});
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
