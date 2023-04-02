package com.dreammaster.scripts;

import static com.dreammaster.MissingModIDs.BetterQuesting;
import static gregtech.api.enums.ModIDs.Minecraft;
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
        return Collections.singletonList(BetterQuesting.modID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(BetterQuesting.modID, "submit_station", 1),
                new Object[] { "plateWood", "plateSteel", "plateWood", "plateSteel", "gearSteel", "plateSteel",
                        "plateWood", getModItem(Minecraft.modID, "chest", 1), "plateWood" });
    }
}
