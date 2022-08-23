package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;

public class ScriptSleepingBags implements IScriptLoader {

    public ScriptSleepingBags() {}

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("SleepingBags");
        dependencies.clear();
        dependencies.addAll(Arrays.asList("sleepingbag", "adventurebackpack", "OpenBlocks"));
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(getModItem("sleepingbag", "sleepingBag", 1), new Object[] {
            getModItem("minecraft", "carpet", 1, 32767),
            getModItem("minecraft", "carpet", 1, 32767),
            getModItem("minecraft", "carpet", 1, 32767),
            "blockWool",
            "blockWool",
            "blockWool",
            getModItem("Backpack", "tannedLeather", 1),
            getModItem("Backpack", "tannedLeather", 1),
            getModItem("Backpack", "tannedLeather", 1)
        });

        addShapelessCraftingRecipe(
                getModItem("sleepingbag", "sleepingBag", 1),
                new Object[] {getModItem("adventurebackpack", "backpackComponent", 1, 1)});

        addShapelessCraftingRecipe(
                getModItem("adventurebackpack", "backpackComponent", 1, 1),
                new Object[] {getModItem("OpenBlocks", "sleepingBag", 1)});
    }
}
