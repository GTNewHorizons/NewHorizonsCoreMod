package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.BotanicHorizons;
import static gregtech.api.enums.Mods.Thaumcraft;

import java.util.Arrays;
import java.util.List;

public class ScriptBotania implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Botania";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Botania.ID, BotanicHorizons.ID, Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {

    }
}
