package com.dreammaster.scripts;

import java.util.Arrays;
import java.util.List;

import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptTranslocator implements IScriptLoader{
    private long startTime;
    private long endTime;
    private static final String scriptName = "Translocators";
    private static final List<String> dependencies = Arrays.asList("Translocator");

    public ScriptTranslocator() {

    }
    @Override
    public void loadRecipes() {
        startTime = System.currentTimeMillis();
        addShapedRecipe(getModItem("Translocator", "translocator", 2), new Object[]{
                "itemCasingAluminium","plateRedAlloy","itemCasingAluminium",
                "pipeMediumBrass","gemEnderPearl","pipeMediumBrass",
                "itemCasingAluminium","plateRedAlloy","itemCasingAluminium"});
        addShapedRecipe(getModItem("Translocator", "translocator", 2, 1), new Object[]{
                "itemCasingAluminium","plateRedAlloy","itemCasingAluminium",
                "pipeMediumSteel","gemEnderPearl","pipeMediumSteel",
                "itemCasingAluminium","plateRedAlloy","itemCasingAluminium"});
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
