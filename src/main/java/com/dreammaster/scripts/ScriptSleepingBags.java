package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AdventureBackpack;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.SleepingBags;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

public class ScriptSleepingBags implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "SleepingBags";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(SleepingBags.ID, AdventureBackpack.ID, OpenBlocks.ID, Backpack.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(SleepingBags.ID, "sleepingBag", 1),
                getModItem(Minecraft.ID, "carpet", 1, wildcard),
                getModItem(Minecraft.ID, "carpet", 1, wildcard),
                getModItem(Minecraft.ID, "carpet", 1, wildcard),
                "blockWool",
                "blockWool",
                "blockWool",
                getModItem(Backpack.ID, "tannedLeather", 1),
                getModItem(Backpack.ID, "tannedLeather", 1),
                getModItem(Backpack.ID, "tannedLeather", 1));

        addShapelessRecipe(
                getModItem(SleepingBags.ID, "sleepingBag", 1),
                getModItem(AdventureBackpack.ID, "backpackComponent", 1, 1));

        addShapelessRecipe(
                getModItem(AdventureBackpack.ID, "backpackComponent", 1, 1),
                getModItem(OpenBlocks.ID, "sleepingBag", 1));
    }
}
