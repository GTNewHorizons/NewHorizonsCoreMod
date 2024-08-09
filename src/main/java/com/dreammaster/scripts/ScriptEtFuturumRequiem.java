package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.EtFuturumRequiem;

import java.util.Arrays;
import java.util.List;

public class ScriptEtFuturumRequiem implements IScriptLoader {
    @Override
    public String getScriptName() {
        return "Et Futurum Requiem";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                EtFuturumRequiem.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessRecipe(getModItem(EtFuturumRequiem.ID, "stone_slab", 2, 0, missing), "craftingToolSaw", null, "stone", null);
    }
};