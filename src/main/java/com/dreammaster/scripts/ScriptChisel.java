package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.Mods;

public class ScriptChisel implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Chisel";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.Chisel.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("chisel", "chisel", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "plateAnyIron", "plateAnyIron", "screwAnyIron", "stickWood",
                        "plateAnyIron", "stickWood", "screwAnyIron", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("chisel", "chisel", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", "plateAnyIron", "plateAnyIron", "screwAnyIron", "stickWood",
                        "plateAnyIron", "stickWood", "screwAnyIron", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("chisel", "obsidianChisel", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "plateObsidian", "plateObsidian", "screwWroughtIron",
                        "stickWroughtIron", "plateObsidian", "stickWroughtIron", "screwWroughtIron",
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("chisel", "obsidianChisel", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", "plateObsidian", "plateObsidian", "screwWroughtIron",
                        "stickWroughtIron", "plateObsidian", "stickWroughtIron", "screwWroughtIron",
                        "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("chisel", "diamondChisel", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "plateDiamond", "plateDiamond", "screwSteel", "stickSteel",
                        "plateDiamond", "stickSteel", "screwSteel", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("chisel", "diamondChisel", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", "plateDiamond", "plateDiamond", "screwSteel", "stickSteel",
                        "plateDiamond", "stickSteel", "screwSteel", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("chisel", "autoChisel", 1, 0, missing),
                new Object[] { "screwSteel", "ringWoodSealed", "screwSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32650, missing), "craftingToolScrewdriver",
                        getModItem("IronChest", "BlockIronChest", 1, 0, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("chisel", "upgrade", 1, 0, missing),
                new Object[] { "screwSteel", "plateEmerald", "screwSteel", "plateEmerald", "circuitBasic",
                        "plateEmerald", "wireGt01RedAlloy", getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                        "wireGt01RedAlloy" });
        addShapedRecipe(
                getModItem("chisel", "upgrade", 1, 1, missing),
                new Object[] { "screwSteel", "plateEmerald", "screwSteel", "plateEmerald", "circuitBasic",
                        "plateEmerald", "wireGt01RedAlloy", getModItem("gregtech", "gt.metaitem.01", 1, 32650, missing),
                        "wireGt01RedAlloy" });
        addShapedRecipe(
                getModItem("chisel", "upgrade", 1, 2, missing),
                new Object[] { "screwSteel", "plateEmerald", "screwSteel", "plateEmerald", "circuitBasic",
                        "plateEmerald", "wireGt01RedAlloy", getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        "wireGt01RedAlloy" });
        addShapedRecipe(
                getModItem("chisel", "upgrade", 1, 3, missing),
                new Object[] { "screwSteel", "plateEmerald", "screwSteel", "plateEmerald", "circuitBasic",
                        "plateEmerald", "wireGt01RedAlloy", getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                        "wireGt01RedAlloy" });
        addShapedRecipe(
                getModItem("chisel", "mossy_templeblock", 1, 0, missing),
                new Object[] { getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("chisel", "templeblock", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem("chisel", "voidstone2", 8, 0, missing),
                new Object[] { getModItem("chisel", "voidstone", 1, 0, missing),
                        getModItem("chisel", "voidstone", 1, 0, missing),
                        getModItem("chisel", "voidstone", 1, 0, missing),
                        getModItem("chisel", "voidstone", 1, 0, missing), "dustGlowstone",
                        getModItem("chisel", "voidstone", 1, 0, missing),
                        getModItem("chisel", "voidstone", 1, 0, missing),
                        getModItem("chisel", "voidstone", 1, 0, missing),
                        getModItem("chisel", "voidstone", 1, 0, missing) });

    }
}
