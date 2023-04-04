package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.HoloInventory;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Collections;
import java.util.List;

public class ScriptHoloInventory implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "HoloInventory";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList(HoloInventory.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(HoloInventory.ID, "Hologlasses", 1),
                new Object[] { "stickSteel", "screwSteel", "stickSteel", "ringSteel", "boltSteel", "ringSteel",
                        "lensInfusedEntropy", "craftingToolScrewdriver", "lensInfusedEntropy" });
    }
}
