package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;

public class ScriptArchitectureCraft implements IScriptLoader {

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("Architecture Craft");
        dependencies.clear();
        dependencies.addAll(Arrays.asList("ArchitectureCraft", "gregtech"));
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(getModItem("ArchitectureCraft", "sawbench", 1), new Object[] {
            "screwSteel",
            getModItem("minecraft", "heavy_weighted_pressure_plate", 1),
            "screwSteel",
            getModItem("TConstruct", "trap.barricade.oak", 1),
            getModItem("ArchitectureCraft", "sawblade", 1),
            getModItem("TConstruct", "trap.barricade.oak", 1),
            "craftingToolScrewdriver",
            getModItem("ArchitectureCraft", "largePulley", 1),
            "craftingToolHardHammer"
        });

        addShapedRecipe(getModItem("ArchitectureCraft", "largePulley", 1), new Object[] {
            "screwSteel", "craftingToolScrewdriver", "screwSteel",
            "gearGtSmallAnyIron", "gearWood", "gearGtSmallAnyIron",
            "screwSteel", "craftingToolHardHammer", "screwSteel"
        });

        addShapedRecipe(getModItem("ArchitectureCraft", "hammer", 1), new Object[] {
            "plateSteel",
            "plateSteel",
            "ingotIron",
            "craftingToolFile",
            "stickWood",
            "ingotIron",
            null,
            "stickWood",
            "craftingToolHardHammer"
        });

        addShapedRecipe(getModItem("ArchitectureCraft", "chisel", 1), new Object[] {
            "craftingToolHardHammer", "plateIron", "plateSteel",
            "screwIron", "stickIron", "plateIron",
            "stickWood", "screwIron", "craftingToolScrewdriver"
        });

        addShapelessCraftingRecipe(
                getModItem("ArchitectureCraft", "sawblade", 1), new Object[] {"toolHeadBuzzSawAnyIron"});

        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 15032),
                new Object[] {getModItem("ArchitectureCraft", "sawblade", 1)});
    }
}
