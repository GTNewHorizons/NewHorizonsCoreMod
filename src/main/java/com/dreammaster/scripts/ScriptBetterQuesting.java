package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BetterQuesting;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Collections;
import java.util.List;

public class ScriptBetterQuesting implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "BetterQuesting";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList(BetterQuesting.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(BetterQuesting.ID, "submit_station", 1),
                new Object[] { "plateWood", "plateSteel", "plateWood", "plateSteel", "gearSteel", "plateSteel",
                        "plateWood", getModItem(Minecraft.ID, "chest", 1), "plateWood" });
    }
}
