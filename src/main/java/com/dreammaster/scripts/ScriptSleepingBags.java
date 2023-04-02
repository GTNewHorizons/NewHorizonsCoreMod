package com.dreammaster.scripts;

import static com.dreammaster.MissingModIDs.AdventureBackpack;
import static com.dreammaster.MissingModIDs.Backpack;
import static com.dreammaster.MissingModIDs.OpenBlocks;
import static com.dreammaster.MissingModIDs.SleepingBags;
import static gregtech.api.enums.ModIDs.Minecraft;
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
        return Arrays.asList(SleepingBags.modID, AdventureBackpack.modID, OpenBlocks.modID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(SleepingBags.modID, "sleepingBag", 1),
                new Object[] { getModItem(Minecraft.modID, "carpet", 1, 32767),
                        getModItem(Minecraft.modID, "carpet", 1, 32767),
                        getModItem(Minecraft.modID, "carpet", 1, 32767), "blockWool", "blockWool", "blockWool",
                        getModItem(Backpack.modID, "tannedLeather", 1), getModItem(Backpack.modID, "tannedLeather", 1),
                        getModItem(Backpack.modID, "tannedLeather", 1) });

        addShapelessCraftingRecipe(
                getModItem(SleepingBags.modID, "sleepingBag", 1),
                new Object[] { getModItem(AdventureBackpack.modID, "backpackComponent", 1, 1) });

        addShapelessCraftingRecipe(
                getModItem(AdventureBackpack.modID, "backpackComponent", 1, 1),
                new Object[] { getModItem(OpenBlocks.modID, "sleepingBag", 1) });
    }
}
