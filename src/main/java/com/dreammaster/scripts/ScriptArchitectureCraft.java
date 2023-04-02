package com.dreammaster.scripts;

import static com.dreammaster.MissingModIDs.ArchitectureCraft;
import static gregtech.api.enums.ModIDs.GregTech;
import static gregtech.api.enums.ModIDs.Minecraft;
import static gregtech.api.enums.ModIDs.TinkerConstruct;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

public class ScriptArchitectureCraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Architecture Craft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(ArchitectureCraft.modID, GregTech.modID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(ArchitectureCraft.modID, "sawbench", 1),
                new Object[] { "screwSteel", getModItem(Minecraft.modID, "heavy_weighted_pressure_plate", 1), "screwSteel",
                        getModItem(TinkerConstruct.modID, "trap.barricade.oak", 1),
                        getModItem(ArchitectureCraft.modID, "sawblade", 1),
                        getModItem(TinkerConstruct.modID, "trap.barricade.oak", 1), "craftingToolScrewdriver",
                        getModItem(ArchitectureCraft.modID, "largePulley", 1), "craftingToolHardHammer" });

        addShapedRecipe(
                getModItem(ArchitectureCraft.modID, "largePulley", 1),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "gearGtSmallAnyIron", "gearWood",
                        "gearGtSmallAnyIron", "screwSteel", "craftingToolHardHammer", "screwSteel" });

        addShapedRecipe(
                getModItem(ArchitectureCraft.modID, "hammer", 1),
                new Object[] { "plateSteel", "plateSteel", "ingotIron", "craftingToolFile", "stickWood", "ingotIron",
                        null, "stickWood", "craftingToolHardHammer" });

        addShapedRecipe(
                getModItem(ArchitectureCraft.modID, "chisel", 1),
                new Object[] { "craftingToolHardHammer", "plateIron", "plateSteel", "screwIron", "stickIron",
                        "plateIron", "stickWood", "screwIron", "craftingToolScrewdriver" });

        addShapelessCraftingRecipe(
                getModItem(ArchitectureCraft.modID, "sawblade", 1),
                new Object[] { "toolHeadBuzzSawAnyIron" });

        addShapelessCraftingRecipe(
                getModItem(GregTech.modID, "gt.metaitem.02", 1, 15032),
                new Object[] { getModItem(ArchitectureCraft.modID, "sawblade", 1) });
    }
}
