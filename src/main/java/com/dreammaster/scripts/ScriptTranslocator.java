package com.dreammaster.scripts;

import java.util.Arrays;

import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptTranslocator implements IScriptLoader{

    public ScriptTranslocator() {

    }

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("Translocators");
        dependencies.clear();
        dependencies.addAll(Arrays.asList("Translocator"));
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(getModItem("Translocator", "translocator", 2), new Object[]{
                "itemCasingAluminium","plateRedAlloy","itemCasingAluminium",
                "pipeMediumBrass","gemEnderPearl","pipeMediumBrass",
                "itemCasingAluminium","plateRedAlloy","itemCasingAluminium"});
        addShapedRecipe(getModItem("Translocator", "translocator", 2, 1), new Object[]{
                "itemCasingAluminium","plateRedAlloy","itemCasingAluminium",
                "pipeMediumSteel","gemEnderPearl","pipeMediumSteel",
                "itemCasingAluminium","plateRedAlloy","itemCasingAluminium"});
    }
}
