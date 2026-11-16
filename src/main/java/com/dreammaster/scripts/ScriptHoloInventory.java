package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.HoloInventory;

import java.util.Collections;
import java.util.List;

import gregtech.api.enums.Mods;

public class ScriptHoloInventory implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "HoloInventory";
    }

    @Override
    public List<Mods> getDependencies() {
        return Collections.singletonList(HoloInventory);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(HoloInventory.ID, "Hologlasses", 1),
                "stickSteel",
                "screwSteel",
                "stickSteel",
                "ringSteel",
                "boltSteel",
                "ringSteel",
                "lensInfusedEntropy",
                "craftingToolScrewdriver",
                "lensInfusedEntropy");
    }
}
