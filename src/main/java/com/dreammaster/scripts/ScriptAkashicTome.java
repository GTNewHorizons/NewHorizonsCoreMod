package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AkashicTome;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.Minecraft;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.Mods;

public class ScriptAkashicTome implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Akashic Tome";
    }

    @Override
    public List<Mods> getDependencies() {
        return Arrays.asList(AkashicTome, Backpack);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(AkashicTome.ID, "tome", 1, 0),
                getModItem(Backpack.ID, "tannedLeather", 1, 0),
                getModItem(Minecraft.ID, "book", 1, 0),
                getModItem(Minecraft.ID, "book", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "chest", 1, 0),
                getModItem(Minecraft.ID, "paper", 1, 0),
                getModItem(Backpack.ID, "tannedLeather", 1, 0),
                getModItem(Minecraft.ID, "book", 1, 0),
                getModItem(Minecraft.ID, "book", 1, 0));
    }

}
