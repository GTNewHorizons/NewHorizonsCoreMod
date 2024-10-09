package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.ForgeMicroblocks;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Collections;
import java.util.List;

public class ScriptForgeMultipart implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Forge Multipart";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList(ForgeMicroblocks.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(ForgeMicroblocks.ID, "sawStone", 1),
                "stickWood",
                "stickStone",
                "stickStone",
                "stickWood",
                com.dreammaster.item.ItemList.SawBladeStone.getIS(1),
                "stickStone",
                null,
                null,
                null);

        addShapedRecipe(
                getModItem(ForgeMicroblocks.ID, "sawIron", 1),
                "stickWood",
                "stickIron",
                "stickIron",
                "stickWood",
                "toolHeadSawIron",
                "stickIron",
                null,
                null,
                null);

        addShapedRecipe(
                getModItem(ForgeMicroblocks.ID, "sawDiamond", 1),
                "stickWood",
                "stickSteel",
                "stickSteel",
                "stickWood",
                com.dreammaster.item.ItemList.SawBladeDiamond.getIS(1),
                "stickSteel",
                null,
                null,
                null);

        addShapedRecipe(
                getModItem(ForgeMicroblocks.ID, "stoneRod", 2),
                "stone",
                null,
                null,
                "stone",
                null,
                null,
                null,
                null,
                null);

        addShapedRecipe(
                getModItem(ForgeMicroblocks.ID, "stoneRod", 4),
                "craftingToolSaw",
                null,
                null,
                "stone",
                null,
                null,
                "stone",
                null,
                null);
    }
}
