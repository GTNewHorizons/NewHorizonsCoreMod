package com.dreammaster.scripts;

import static gregtech.api.enums.ModIDs.Translocator;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Collections;
import java.util.List;

public class ScriptTranslocator implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Translocators";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList(Translocator.modID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(Translocator.modID, "translocator", 2),
                new Object[] { "itemCasingAluminium", "plateRedAlloy", "itemCasingAluminium", "pipeMediumBrass",
                        "gemEnderPearl", "pipeMediumBrass", "itemCasingAluminium", "plateRedAlloy",
                        "itemCasingAluminium" });
        addShapedRecipe(
                getModItem(Translocator.modID, "translocator", 2, 1),
                new Object[] { "itemCasingAluminium", "plateRedAlloy", "itemCasingAluminium", "pipeMediumSteel",
                        "gemEnderPearl", "pipeMediumSteel", "itemCasingAluminium", "plateRedAlloy",
                        "itemCasingAluminium" });
    }
}
