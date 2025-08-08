package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Botania;

import java.util.Arrays;
import java.util.List;

class ScriptBotania implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Botania";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Botania.ID);
    }

    @Override
    public void loadRecipes() {

    }
}
