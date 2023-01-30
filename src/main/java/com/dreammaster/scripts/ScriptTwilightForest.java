package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ScriptTwilightForest implements IScriptLoader {

    public ScriptTwilightForest() {}

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("TwilightForest");
        dependencies.clear();
        dependencies.addAll(Arrays.asList("TwilightForest"));
    }

    @Override
    public void loadRecipes() {

        final ItemStack TF_ROOF_TILE = getModItem("TwilightForest", "tile.CastleBrick", 8, 3);
        addShapedRecipe(
                TF_ROOF_TILE,
                new Object[] { Blocks.cobblestone, Blocks.stone, Blocks.cobblestone, Blocks.cobblestone, "dyeBlack",
                        Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone, Blocks.cobblestone });
    }
}
