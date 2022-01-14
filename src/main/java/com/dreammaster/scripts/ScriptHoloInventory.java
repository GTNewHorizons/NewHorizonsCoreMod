package com.dreammaster.scripts;

import java.util.Arrays;

import static gregtech.api.util.GT_ModHandler.getModItem;

public class ScriptHoloInventory implements IScriptLoader{

    public ScriptHoloInventory() {
        scriptName.append("HoloInventory");
        dependencies.addAll(Arrays.asList("holoinventory"));
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(getModItem("holoinventory", "Hologlasses", 1), new Object[]{
                "stickSteel", "screwSteel", "stickSteel",
                "ringSteel", "boltSteel", "ringSteel",
                "lensInfusedEntropy", "craftingToolScrewdriver", "lensInfusedEntropy"});
    }
}
