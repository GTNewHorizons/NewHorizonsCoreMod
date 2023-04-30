package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import com.cricketcraft.chisel.api.carving.CarvingUtils;
import com.dreammaster.chisel.ChiselHelper;
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

        ChiselHelper.addGroup("glasswork");
        CarvingUtils.getChiselRegistry().removeGroup("cobblestone");
        CarvingUtils.getChiselRegistry().removeGroup("glowstone");
        ChiselHelper.removeVariationStack(getModItem("minecraft", "stonebrick", 1, 1, missing));
        ChiselHelper.removeVariationStack(getModItem("minecraft", "torch", 1, 0, missing));
        ChiselHelper.addGroup("CobblestoneBricks");
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem("minecraft", "cobblestone", 1, 0, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem("chisel", "cobblestone", 1, 1, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem("chisel", "cobblestone", 1, 2, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem("chisel", "cobblestone", 1, 3, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem("chisel", "cobblestone", 1, 4, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem("chisel", "cobblestone", 1, 5, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem("chisel", "cobblestone", 1, 6, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem("chisel", "cobblestone", 1, 7, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem("chisel", "cobblestone", 1, 8, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem("chisel", "cobblestone", 1, 9, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem("chisel", "cobblestone", 1, 10, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem("chisel", "cobblestone", 1, 11, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem("chisel", "cobblestone", 1, 12, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem("chisel", "cobblestone", 1, 13, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem("chisel", "cobblestone", 1, 14, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem("chisel", "cobblestone", 1, 15, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("minecraft", "glass", 1, 0, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("chisel", "glass", 1, 1, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("chisel", "glass", 1, 2, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("chisel", "glass", 1, 3, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("chisel", "glass", 1, 4, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("chisel", "glass", 1, 5, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("chisel", "glass", 1, 6, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("chisel", "glass", 1, 7, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("chisel", "glass", 1, 8, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("chisel", "glass", 1, 9, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("chisel", "glass", 1, 10, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("chisel", "glass", 1, 11, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("chisel", "glass", 1, 12, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("chisel", "glass", 1, 13, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("chisel", "glass", 1, 14, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("chisel", "glass", 1, 15, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("chisel", "glass2", 1, 0, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("TConstruct", "GlassBlock", 1, 0, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem("EnderIO", "blockFusedQuartz", 1, 1, missing));
        ChiselHelper.addVariationFromStack("glass", getModItem("TConstruct", "GlassBlock", 1, 0, missing));
        ChiselHelper.addVariationFromStack("cloud", getModItem("Natura", "Cloud", 1, 0, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem("Railcraft", "cube", 1, 7, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem("gregtech", "gt.blockstones", 1, 0, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem("gregtech", "gt.blockstones", 1, 1, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem("gregtech", "gt.blockstones", 1, 2, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem("gregtech", "gt.blockstones", 1, 3, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem("gregtech", "gt.blockstones", 1, 4, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem("gregtech", "gt.blockstones", 1, 5, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem("gregtech", "gt.blockstones", 1, 6, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem("gregtech", "gt.blockstones", 1, 7, missing));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", getModItem("Railcraft", "cube", 1, 6, missing));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", getModItem("gregtech", "gt.blockgranites", 1, 0, missing));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", getModItem("gregtech", "gt.blockgranites", 1, 1, missing));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", getModItem("gregtech", "gt.blockgranites", 1, 2, missing));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", getModItem("gregtech", "gt.blockgranites", 1, 3, missing));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", getModItem("gregtech", "gt.blockgranites", 1, 4, missing));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", getModItem("gregtech", "gt.blockgranites", 1, 5, missing));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", getModItem("gregtech", "gt.blockgranites", 1, 6, missing));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", getModItem("gregtech", "gt.blockgranites", 1, 7, missing));
        ChiselHelper.addGroup("basalts");
        ChiselHelper.addVariationFromStack("basalts", getModItem("gregtech", "gt.blockstones", 1, 8, missing));
        ChiselHelper.addVariationFromStack("basalts", getModItem("gregtech", "gt.blockstones", 1, 9, missing));
        ChiselHelper.addVariationFromStack("basalts", getModItem("gregtech", "gt.blockstones", 1, 10, missing));
        ChiselHelper.addVariationFromStack("basalts", getModItem("gregtech", "gt.blockstones", 1, 11, missing));
        ChiselHelper.addVariationFromStack("basalts", getModItem("gregtech", "gt.blockstones", 1, 12, missing));
        ChiselHelper.addVariationFromStack("basalts", getModItem("gregtech", "gt.blockstones", 1, 13, missing));
        ChiselHelper.addVariationFromStack("basalts", getModItem("gregtech", "gt.blockstones", 1, 14, missing));
        ChiselHelper.addVariationFromStack("basalts", getModItem("gregtech", "gt.blockstones", 1, 15, missing));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem("ProjRed|Exploration", "projectred.exploration.stone", 1, 2, missing));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem("ProjRed|Exploration", "projectred.exploration.stone", 1, 3, missing));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem("ProjRed|Exploration", "projectred.exploration.stone", 1, 4, missing));
        ChiselHelper.addGroup("redgranite");
        ChiselHelper.addVariationFromStack("redgranite", getModItem("gregtech", "gt.blockgranites", 1, 8, missing));
        ChiselHelper.addVariationFromStack("redgranite", getModItem("gregtech", "gt.blockgranites", 1, 9, missing));
        ChiselHelper.addVariationFromStack("redgranite", getModItem("gregtech", "gt.blockgranites", 1, 10, missing));
        ChiselHelper.addVariationFromStack("redgranite", getModItem("gregtech", "gt.blockgranites", 1, 11, missing));
        ChiselHelper.addVariationFromStack("redgranite", getModItem("gregtech", "gt.blockgranites", 1, 12, missing));
        ChiselHelper.addVariationFromStack("redgranite", getModItem("gregtech", "gt.blockgranites", 1, 13, missing));
        ChiselHelper.addVariationFromStack("redgranite", getModItem("gregtech", "gt.blockgranites", 1, 14, missing));
        ChiselHelper.addVariationFromStack("redgranite", getModItem("gregtech", "gt.blockgranites", 1, 15, missing));
        ChiselHelper.addVariationFromStack("limestone", getModItem("BiomesOPlenty", "rocks", 1, 0, missing));
        ChiselHelper.addVariationFromStack("amber", getModItem("gregtech", "gt.blockgem1", 1, 1, missing));
        ChiselHelper.addVariationFromStack("amber", getModItem("BiomesOPlenty", "gemOre", 1, 15, missing));
        ChiselHelper.addGroup("endstone");
        ChiselHelper.addVariationFromStack("endstone", getModItem("minecraft", "end_stone", 1, 0, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem("chisel", "end_Stone", 1, 1, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem("chisel", "end_Stone", 1, 2, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem("chisel", "end_Stone", 1, 3, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem("chisel", "end_Stone", 1, 4, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem("chisel", "end_Stone", 1, 5, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem("chisel", "end_Stone", 1, 6, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem("chisel", "end_Stone", 1, 7, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem("chisel", "end_Stone", 1, 8, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem("chisel", "end_Stone", 1, 9, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem("chisel", "end_Stone", 1, 10, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem("chisel", "end_Stone", 1, 11, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem("chisel", "end_Stone", 1, 12, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem("chisel", "end_Stone", 1, 13, missing));
        ChiselHelper
                .addVariationFromStack("endstone", getModItem("TConstruct", "decoration.multibrick", 1, 12, missing));
        ChiselHelper.addVariationFromStack(
                "endstone",
                getModItem("TConstruct", "decoration.multibrickfancy", 1, 12, missing));
        ChiselHelper.addVariationFromStack("concrete", getModItem("gregtech", "gt.blockconcretes", 1, 8, missing));
        ChiselHelper.addGroup("glowstoneGTNH");
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem("minecraft", "glowstone", 1, 0, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem("chisel", "glowstone", 1, 1, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem("chisel", "glowstone", 1, 2, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem("chisel", "glowstone", 1, 3, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem("chisel", "glowstone", 1, 4, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem("chisel", "glowstone", 1, 5, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem("chisel", "glowstone", 1, 6, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem("chisel", "glowstone", 1, 7, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem("chisel", "glowstone", 1, 8, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem("chisel", "glowstone", 1, 9, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem("chisel", "glowstone", 1, 10, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem("chisel", "glowstone", 1, 11, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem("chisel", "glowstone", 1, 12, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem("chisel", "glowstone", 1, 13, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem("chisel", "glowstone", 1, 14, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem("chisel", "glowstone", 1, 15, missing));
        ChiselHelper
                .addVariationFromStack("torch", getModItem("GalacticraftCore", "tile.glowstoneTorch", 1, 0, missing));
        ChiselHelper.addVariationFromStack("aluminumblock", getModItem("gregtech", "gt.blockmetal1", 1, 1, missing));
        ChiselHelper.addGroup("searedStoneTCon");
        ChiselHelper.addVariationFromStack("searedStoneTCon", getModItem("TConstruct", "Smeltery", 1, 4, missing));
        ChiselHelper.addVariationFromStack("searedStoneTCon", getModItem("TConstruct", "Smeltery", 1, 6, missing));
        ChiselHelper.addVariationFromStack("searedStoneTCon", getModItem("TConstruct", "Smeltery", 1, 11, missing));
        ChiselHelper.addGroup("searedStoneNetherTCon");
        ChiselHelper.addVariationFromStack(
                "searedStoneNetherTCon",
                getModItem("TConstruct", "SmelteryNether", 1, 4, missing));
        ChiselHelper.addVariationFromStack(
                "searedStoneNetherTCon",
                getModItem("TConstruct", "SmelteryNether", 1, 6, missing));
        ChiselHelper.addVariationFromStack(
                "searedStoneNetherTCon",
                getModItem("TConstruct", "SmelteryNether", 1, 11, missing));
        ChiselHelper.addGroup("searedBricksTCon");
        ChiselHelper.addVariationFromStack("searedBricksTCon", getModItem("TConstruct", "Smeltery", 1, 2, missing));
        ChiselHelper.addVariationFromStack("searedBricksTCon", getModItem("TConstruct", "Smeltery", 1, 8, missing));
        ChiselHelper.addVariationFromStack("searedBricksTCon", getModItem("TConstruct", "Smeltery", 1, 9, missing));
        ChiselHelper.addGroup("searedBricksNetherTCon");
        ChiselHelper.addVariationFromStack(
                "searedBricksNetherTCon",
                getModItem("TConstruct", "SmelteryNether", 1, 2, missing));
        ChiselHelper.addVariationFromStack(
                "searedBricksNetherTCon",
                getModItem("TConstruct", "SmelteryNether", 1, 8, missing));
        ChiselHelper.addVariationFromStack(
                "searedBricksNetherTCon",
                getModItem("TConstruct", "SmelteryNether", 1, 9, missing));
        ChiselHelper.addGroup("speedBlockTCon");
        ChiselHelper.addVariationFromStack("speedBlockTCon", getModItem("TConstruct", "SpeedBlock", 1, 0, missing));
        ChiselHelper.addVariationFromStack("speedBlockTCon", getModItem("TConstruct", "SpeedBlock", 1, 1, missing));
        ChiselHelper.addGroup("brownStoneTCon");
        ChiselHelper.addVariationFromStack("brownStoneTCon", getModItem("TConstruct", "SpeedBlock", 1, 2, missing));
        ChiselHelper.addVariationFromStack("brownStoneTCon", getModItem("TConstruct", "SpeedBlock", 1, 3, missing));
        ChiselHelper.addVariationFromStack("brownStoneTCon", getModItem("TConstruct", "SpeedBlock", 1, 4, missing));
        ChiselHelper.addVariationFromStack("brownStoneTCon", getModItem("TConstruct", "SpeedBlock", 1, 5, missing));
        ChiselHelper.addVariationFromStack("brownStoneTCon", getModItem("TConstruct", "SpeedBlock", 1, 6, missing));
        ChiselHelper.addGroup("ironBricksTCon");
        ChiselHelper.addVariationFromStack(
                "ironBricksTCon",
                getModItem("TConstruct", "decoration.multibrick", 1, 4, missing));
        ChiselHelper.addVariationFromStack(
                "ironBricksTCon",
                getModItem("TConstruct", "decoration.multibrickfancy", 1, 4, missing));
        ChiselHelper.addGroup("goldBricksTCon");
        ChiselHelper.addVariationFromStack(
                "goldBricksTCon",
                getModItem("TConstruct", "decoration.multibrick", 1, 5, missing));
        ChiselHelper.addVariationFromStack(
                "goldBricksTCon",
                getModItem("TConstruct", "decoration.multibrickfancy", 1, 5, missing));
        ChiselHelper.addGroup("lapisBricksTCon");
        ChiselHelper.addVariationFromStack(
                "lapisBricksTCon",
                getModItem("TConstruct", "decoration.multibrick", 1, 6, missing));
        ChiselHelper.addVariationFromStack(
                "lapisBricksTCon",
                getModItem("TConstruct", "decoration.multibrickfancy", 1, 6, missing));
        ChiselHelper.addGroup("diamondBricksTCon");
        ChiselHelper.addVariationFromStack(
                "diamondBricksTCon",
                getModItem("TConstruct", "decoration.multibrick", 1, 7, missing));
        ChiselHelper.addVariationFromStack(
                "diamondBricksTCon",
                getModItem("TConstruct", "decoration.multibrickfancy", 1, 7, missing));
        ChiselHelper.addGroup("redstoneBricksTCon");
        ChiselHelper.addVariationFromStack(
                "redstoneBricksTCon",
                getModItem("TConstruct", "decoration.multibrick", 1, 8, missing));
        ChiselHelper.addVariationFromStack(
                "redstoneBricksTCon",
                getModItem("TConstruct", "decoration.multibrickfancy", 1, 8, missing));
        ChiselHelper.addGroup("boneBricksTCon");
        ChiselHelper.addVariationFromStack(
                "boneBricksTCon",
                getModItem("TConstruct", "decoration.multibrick", 1, 9, missing));
        ChiselHelper.addVariationFromStack(
                "boneBricksTCon",
                getModItem("TConstruct", "decoration.multibrickfancy", 1, 9, missing));
        ChiselHelper.addGroup("greenSlimeBricksTCon");
        ChiselHelper.addVariationFromStack(
                "greenSlimeBricksTCon",
                getModItem("TConstruct", "decoration.multibrick", 1, 10, missing));
        ChiselHelper.addVariationFromStack(
                "greenSlimeBricksTCon",
                getModItem("TConstruct", "decoration.multibrickfancy", 1, 10, missing));
        ChiselHelper.addGroup("blueSlimeBricksTCon");
        ChiselHelper.addVariationFromStack(
                "blueSlimeBricksTCon",
                getModItem("TConstruct", "decoration.multibrick", 1, 11, missing));
        ChiselHelper.addVariationFromStack(
                "blueSlimeBricksTCon",
                getModItem("TConstruct", "decoration.multibrickfancy", 1, 11, missing));
        ChiselHelper.addGroup("obsidianBricksTCon");
        ChiselHelper.addVariationFromStack(
                "obsidianBricksTCon",
                getModItem("TConstruct", "decoration.multibrick", 1, 13, missing));
        ChiselHelper.addVariationFromStack(
                "obsidianBricksTCon",
                getModItem("TConstruct", "decoration.multibrickfancy", 1, 13, missing));
        ChiselHelper.addGroup("alumiteBricksTCon");
        ChiselHelper.addVariationFromStack("alumiteBricksTCon", getModItem("TConstruct", "MetalBlock", 1, 8, missing));
        ChiselHelper.addVariationFromStack(
                "alumiteBricksTCon",
                getModItem("TConstruct", "decoration.multibrickmetal", 1, 0, missing));
        ChiselHelper.addVariationFromStack(
                "alumiteBricksTCon",
                getModItem("TConstruct", "decoration.multibrickmetal", 1, 4, missing));
        ChiselHelper.addGroup("arditeBricksTCon");
        ChiselHelper.addVariationFromStack("arditeBricksTCon", getModItem("TConstruct", "MetalBlock", 1, 1, missing));
        ChiselHelper.addVariationFromStack(
                "arditeBricksTCon",
                getModItem("TConstruct", "decoration.multibrickmetal", 1, 1, missing));
        ChiselHelper.addVariationFromStack(
                "arditeBricksTCon",
                getModItem("TConstruct", "decoration.multibrickmetal", 1, 5, missing));
        ChiselHelper.addGroup("cobaltBricksTCon");
        ChiselHelper.addVariationFromStack("cobaltBricksTCon", getModItem("TConstruct", "MetalBlock", 1, 0, missing));
        ChiselHelper.addVariationFromStack(
                "cobaltBricksTCon",
                getModItem("TConstruct", "decoration.multibrickmetal", 1, 2, missing));
        ChiselHelper.addVariationFromStack(
                "cobaltBricksTCon",
                getModItem("TConstruct", "decoration.multibrickmetal", 1, 6, missing));
        ChiselHelper.addGroup("manyullynBricksTCon");
        ChiselHelper
                .addVariationFromStack("manyullynBricksTCon", getModItem("TConstruct", "MetalBlock", 1, 2, missing));
        ChiselHelper.addVariationFromStack(
                "manyullynBricksTCon",
                getModItem("TConstruct", "decoration.multibrickmetal", 1, 3, missing));
        ChiselHelper.addVariationFromStack(
                "manyullynBricksTCon",
                getModItem("TConstruct", "decoration.multibrickmetal", 1, 7, missing));
        ChiselHelper.addGroup("brown_mushroom");
        ChiselHelper.addGroup("red_mushroom");
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem("minecraft", "brown_mushroom_block", 1, 0, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem("minecraft", "red_mushroom_block", 1, 0, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem("minecraft", "brown_mushroom_block", 1, 1, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem("minecraft", "red_mushroom_block", 1, 1, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem("minecraft", "brown_mushroom_block", 1, 2, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem("minecraft", "red_mushroom_block", 1, 2, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem("minecraft", "brown_mushroom_block", 1, 3, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem("minecraft", "red_mushroom_block", 1, 3, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem("minecraft", "brown_mushroom_block", 1, 4, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem("minecraft", "red_mushroom_block", 1, 4, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem("minecraft", "brown_mushroom_block", 1, 5, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem("minecraft", "red_mushroom_block", 1, 5, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem("minecraft", "brown_mushroom_block", 1, 6, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem("minecraft", "red_mushroom_block", 1, 6, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem("minecraft", "brown_mushroom_block", 1, 7, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem("minecraft", "red_mushroom_block", 1, 7, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem("minecraft", "brown_mushroom_block", 1, 8, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem("minecraft", "red_mushroom_block", 1, 8, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem("minecraft", "brown_mushroom_block", 1, 9, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem("minecraft", "red_mushroom_block", 1, 9, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem("minecraft", "brown_mushroom_block", 1, 10, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem("minecraft", "red_mushroom_block", 1, 10, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem("minecraft", "brown_mushroom_block", 1, 11, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem("minecraft", "red_mushroom_block", 1, 11, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem("minecraft", "brown_mushroom_block", 1, 12, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem("minecraft", "red_mushroom_block", 1, 12, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem("minecraft", "brown_mushroom_block", 1, 13, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem("minecraft", "red_mushroom_block", 1, 13, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem("minecraft", "brown_mushroom_block", 1, 14, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem("minecraft", "red_mushroom_block", 1, 14, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem("minecraft", "brown_mushroom_block", 1, 15, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem("minecraft", "red_mushroom_block", 1, 15, missing));

    }
}
