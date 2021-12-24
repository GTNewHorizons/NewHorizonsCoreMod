package com.dreammaster.scripts;

import java.util.Arrays;
import java.util.List;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptSleepingBags implements IScriptLoader{
    private long startTime;
    private long endTime;
    private static final String scriptName = "SleepingBags";
    private static final List<String> dependencies = Arrays.asList("sleepingbag", "adventurebackpack", "OpenBlocks");

    public ScriptSleepingBags() {

    }

    @Override
    public void loadRecipes() {
        startTime = System.currentTimeMillis();
        addShapedRecipe(getModItem("sleepingbag", "sleepingBag", 1), new Object[]{
                getModItem("minecraft", "carpet", 1, 32767), getModItem("minecraft", "carpet", 1, 32767), getModItem("minecraft", "carpet", 1, 32767),
                "blockWool", "blockWool", "blockWool",
                getModItem("Backpack", "tannedLeather", 1), getModItem("Backpack", "tannedLeather", 1), getModItem("Backpack", "tannedLeather", 1)});

        addShapelessCraftingRecipe(getModItem("sleepingbag", "sleepingBag", 1), new Object[]{
                getModItem("adventurebackpack", "backpackComponent", 1, 1)});

        addShapelessCraftingRecipe(getModItem("adventurebackpack", "backpackComponent", 1, 1), new Object[]{
                getModItem("OpenBlocks", "sleepingBag", 1)});

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
