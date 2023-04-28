package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

public class ScriptBinniesCore implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Binnies Core";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList("BinnieCore");
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("BinnieCore", "fieldKit", 1, 63, missing),
                new Object[] { "lensGlass", "ringSteel", "screwSteel", "ringSteel", "stickSteel", "craftingToolSaw",
                        "screwSteel", "craftingToolScrewdriver", "stickSteel" });
    }
}
