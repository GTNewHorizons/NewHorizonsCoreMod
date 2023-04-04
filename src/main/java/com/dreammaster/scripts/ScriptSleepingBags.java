package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AdventureBackpack;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.SleepingBags;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

public class ScriptSleepingBags implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "SleepingBags";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(SleepingBags.ID, AdventureBackpack.ID, OpenBlocks.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(SleepingBags.ID, "sleepingBag", 1),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 32767),
                        getModItem(Minecraft.ID, "carpet", 1, 32767),
                        getModItem(Minecraft.ID, "carpet", 1, 32767), "blockWool", "blockWool", "blockWool",
                        getModItem(Backpack.ID, "tannedLeather", 1), getModItem(Backpack.ID, "tannedLeather", 1),
                        getModItem(Backpack.ID, "tannedLeather", 1) });

        addShapelessCraftingRecipe(
                getModItem(SleepingBags.ID, "sleepingBag", 1),
                new Object[] { getModItem(AdventureBackpack.ID, "backpackComponent", 1, 1) });

        addShapelessCraftingRecipe(
                getModItem(AdventureBackpack.ID, "backpackComponent", 1, 1),
                new Object[] { getModItem(OpenBlocks.ID, "sleepingBag", 1) });
    }
}
