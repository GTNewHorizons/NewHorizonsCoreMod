package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;

public class ScriptHoloInventory implements IScriptLoader {

    public ScriptHoloInventory() {}

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("HoloInventory");
        dependencies.clear();
        dependencies.addAll(Arrays.asList("holoinventory"));
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(getModItem("holoinventory", "Hologlasses", 1), new Object[] {
            "stickSteel", "screwSteel", "stickSteel",
            "ringSteel", "boltSteel", "ringSteel",
            "lensInfusedEntropy", "craftingToolScrewdriver", "lensInfusedEntropy"
        });
    }
}
