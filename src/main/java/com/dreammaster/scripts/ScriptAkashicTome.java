package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AkashicTome;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

public class ScriptAkashicTome implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Akashic Tome";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(AkashicTome.ID, Backpack.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(AkashicTome.ID, "tome", 1, 0, missing),
                getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                getModItem(Minecraft.ID, "book", 1, 0, missing),
                getModItem(Minecraft.ID, "book", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                getModItem(Minecraft.ID, "book", 1, 0, missing),
                getModItem(Minecraft.ID, "book", 1, 0, missing));
    }

}
