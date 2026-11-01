package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Translocator;

import java.util.Collections;
import java.util.List;

import gregtech.api.enums.Mods;

public class ScriptTranslocator implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Translocators";
    }

    @Override
    public List<Mods> getDependencies() {
        return Collections.singletonList(Translocator);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(Translocator.ID, "translocator", 2),
                "itemCasingAluminium",
                "plateRedAlloy",
                "itemCasingAluminium",
                "pipeMediumBrass",
                "gemEnderPearl",
                "pipeMediumBrass",
                "itemCasingAluminium",
                "plateRedAlloy",
                "itemCasingAluminium");
        addShapedRecipe(
                getModItem(Translocator.ID, "translocator", 2, 1),
                "itemCasingAluminium",
                "plateRedAlloy",
                "itemCasingAluminium",
                "pipeMediumSteel",
                "gemEnderPearl",
                "pipeMediumSteel",
                "itemCasingAluminium",
                "plateRedAlloy",
                "itemCasingAluminium");
    }
}
