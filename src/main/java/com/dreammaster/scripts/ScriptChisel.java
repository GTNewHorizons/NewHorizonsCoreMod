package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.ProjectRedExploration;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import com.cricketcraft.chisel.api.carving.CarvingUtils;
import com.dreammaster.chisel.ChiselHelper;

public class ScriptChisel implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Chisel";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Chisel.ID,
                ProjectRedExploration.ID,
                BiomesOPlenty.ID,
                Chisel.ID,
                EnderIO.ID,
                GalacticraftCore.ID,
                IronChests.ID,
                Natura.ID,
                Railcraft.ID,
                TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(Chisel.ID, "chisel", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "plateAnyIron", "plateAnyIron", "screwAnyIron", "stickWood",
                        "plateAnyIron", "stickWood", "screwAnyIron", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(Chisel.ID, "chisel", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", "plateAnyIron", "plateAnyIron", "screwAnyIron", "stickWood",
                        "plateAnyIron", "stickWood", "screwAnyIron", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(Chisel.ID, "obsidianChisel", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "plateObsidian", "plateObsidian", "screwWroughtIron",
                        "stickWroughtIron", "plateObsidian", "stickWroughtIron", "screwWroughtIron",
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(Chisel.ID, "obsidianChisel", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", "plateObsidian", "plateObsidian", "screwWroughtIron",
                        "stickWroughtIron", "plateObsidian", "stickWroughtIron", "screwWroughtIron",
                        "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(Chisel.ID, "diamondChisel", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "plateDiamond", "plateDiamond", "screwSteel", "stickSteel",
                        "plateDiamond", "stickSteel", "screwSteel", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(Chisel.ID, "diamondChisel", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", "plateDiamond", "plateDiamond", "screwSteel", "stickSteel",
                        "plateDiamond", "stickSteel", "screwSteel", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(Chisel.ID, "autoChisel", 1, 0, missing),
                new Object[] { "screwSteel", "ringWoodSealed", "screwSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing), "craftingToolScrewdriver",
                        getModItem(IronChests.ID, "BlockIronChest", 1, 0, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(Chisel.ID, "upgrade", 1, 0, missing),
                new Object[] { "screwSteel", "plateEmerald", "screwSteel", "plateEmerald", "circuitBasic",
                        "plateEmerald", "wireGt01RedAlloy",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing), "wireGt01RedAlloy" });
        addShapedRecipe(
                getModItem(Chisel.ID, "upgrade", 1, 1, missing),
                new Object[] { "screwSteel", "plateEmerald", "screwSteel", "plateEmerald", "circuitBasic",
                        "plateEmerald", "wireGt01RedAlloy",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing), "wireGt01RedAlloy" });
        addShapedRecipe(
                getModItem(Chisel.ID, "upgrade", 1, 2, missing),
                new Object[] { "screwSteel", "plateEmerald", "screwSteel", "plateEmerald", "circuitBasic",
                        "plateEmerald", "wireGt01RedAlloy",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing), "wireGt01RedAlloy" });
        addShapedRecipe(
                getModItem(Chisel.ID, "upgrade", 1, 3, missing),
                new Object[] { "screwSteel", "plateEmerald", "screwSteel", "plateEmerald", "circuitBasic",
                        "plateEmerald", "wireGt01RedAlloy",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "wireGt01RedAlloy" });
        addShapedRecipe(
                getModItem(Chisel.ID, "mossy_templeblock", 1, 0, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(Chisel.ID, "templeblock", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Chisel.ID, "voidstone2", 8, 0, missing),
                new Object[] { getModItem(Chisel.ID, "voidstone", 1, 0, missing),
                        getModItem(Chisel.ID, "voidstone", 1, 0, missing),
                        getModItem(Chisel.ID, "voidstone", 1, 0, missing),
                        getModItem(Chisel.ID, "voidstone", 1, 0, missing), "dustGlowstone",
                        getModItem(Chisel.ID, "voidstone", 1, 0, missing),
                        getModItem(Chisel.ID, "voidstone", 1, 0, missing),
                        getModItem(Chisel.ID, "voidstone", 1, 0, missing),
                        getModItem(Chisel.ID, "voidstone", 1, 0, missing) });

        ChiselHelper.addGroup("glasswork");
        CarvingUtils.getChiselRegistry().removeGroup("cobblestone");
        CarvingUtils.getChiselRegistry().removeGroup("glowstone");
        ChiselHelper.removeVariationStack(getModItem(Minecraft.ID, "stonebrick", 1, 1, missing));
        ChiselHelper.removeVariationStack(getModItem(Minecraft.ID, "torch", 1, 0, missing));
        ChiselHelper.addGroup("CobblestoneBricks");
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Minecraft.ID, "cobblestone", 1, 0, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 1, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 2, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 3, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 4, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 5, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 6, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 7, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 8, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 9, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 10, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 11, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 12, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 13, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 14, missing));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 15, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Minecraft.ID, "glass", 1, 0, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 1, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 2, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 3, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 4, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 5, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 6, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 7, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 8, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 9, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 10, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 11, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 12, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 13, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 14, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 15, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass2", 1, 0, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(EnderIO.ID, "blockFusedQuartz", 1, 1, missing));
        ChiselHelper.addVariationFromStack("glass", getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        ChiselHelper.addVariationFromStack("cloud", getModItem(Natura.ID, "Cloud", 1, 0, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem(Railcraft.ID, "cube", 1, 7, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem(GregTech.ID, "gt.blockstones", 1, 0, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem(GregTech.ID, "gt.blockstones", 1, 1, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem(GregTech.ID, "gt.blockstones", 1, 2, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem(GregTech.ID, "gt.blockstones", 1, 3, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem(GregTech.ID, "gt.blockstones", 1, 4, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem(GregTech.ID, "gt.blockstones", 1, 5, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem(GregTech.ID, "gt.blockstones", 1, 6, missing));
        ChiselHelper.addVariationFromStack("marble", getModItem(GregTech.ID, "gt.blockstones", 1, 7, missing));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", getModItem(Railcraft.ID, "cube", 1, 6, missing));
        ChiselHelper
                .addVariationFromStack("RCAbyssalBlock", getModItem(GregTech.ID, "gt.blockgranites", 1, 0, missing));
        ChiselHelper
                .addVariationFromStack("RCAbyssalBlock", getModItem(GregTech.ID, "gt.blockgranites", 1, 1, missing));
        ChiselHelper
                .addVariationFromStack("RCAbyssalBlock", getModItem(GregTech.ID, "gt.blockgranites", 1, 2, missing));
        ChiselHelper
                .addVariationFromStack("RCAbyssalBlock", getModItem(GregTech.ID, "gt.blockgranites", 1, 3, missing));
        ChiselHelper
                .addVariationFromStack("RCAbyssalBlock", getModItem(GregTech.ID, "gt.blockgranites", 1, 4, missing));
        ChiselHelper
                .addVariationFromStack("RCAbyssalBlock", getModItem(GregTech.ID, "gt.blockgranites", 1, 5, missing));
        ChiselHelper
                .addVariationFromStack("RCAbyssalBlock", getModItem(GregTech.ID, "gt.blockgranites", 1, 6, missing));
        ChiselHelper
                .addVariationFromStack("RCAbyssalBlock", getModItem(GregTech.ID, "gt.blockgranites", 1, 7, missing));
        ChiselHelper.addGroup("basalts");
        ChiselHelper.addVariationFromStack("basalts", getModItem(GregTech.ID, "gt.blockstones", 1, 8, missing));
        ChiselHelper.addVariationFromStack("basalts", getModItem(GregTech.ID, "gt.blockstones", 1, 9, missing));
        ChiselHelper.addVariationFromStack("basalts", getModItem(GregTech.ID, "gt.blockstones", 1, 10, missing));
        ChiselHelper.addVariationFromStack("basalts", getModItem(GregTech.ID, "gt.blockstones", 1, 11, missing));
        ChiselHelper.addVariationFromStack("basalts", getModItem(GregTech.ID, "gt.blockstones", 1, 12, missing));
        ChiselHelper.addVariationFromStack("basalts", getModItem(GregTech.ID, "gt.blockstones", 1, 13, missing));
        ChiselHelper.addVariationFromStack("basalts", getModItem(GregTech.ID, "gt.blockstones", 1, 14, missing));
        ChiselHelper.addVariationFromStack("basalts", getModItem(GregTech.ID, "gt.blockstones", 1, 15, missing));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem(ProjectRedExploration.ID, "projectred.exploration.stone", 1, 2, missing));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem(ProjectRedExploration.ID, "projectred.exploration.stone", 1, 3, missing));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem(ProjectRedExploration.ID, "projectred.exploration.stone", 1, 4, missing));
        ChiselHelper.addGroup("redgranite");
        ChiselHelper.addVariationFromStack("redgranite", getModItem(GregTech.ID, "gt.blockgranites", 1, 8, missing));
        ChiselHelper.addVariationFromStack("redgranite", getModItem(GregTech.ID, "gt.blockgranites", 1, 9, missing));
        ChiselHelper.addVariationFromStack("redgranite", getModItem(GregTech.ID, "gt.blockgranites", 1, 10, missing));
        ChiselHelper.addVariationFromStack("redgranite", getModItem(GregTech.ID, "gt.blockgranites", 1, 11, missing));
        ChiselHelper.addVariationFromStack("redgranite", getModItem(GregTech.ID, "gt.blockgranites", 1, 12, missing));
        ChiselHelper.addVariationFromStack("redgranite", getModItem(GregTech.ID, "gt.blockgranites", 1, 13, missing));
        ChiselHelper.addVariationFromStack("redgranite", getModItem(GregTech.ID, "gt.blockgranites", 1, 14, missing));
        ChiselHelper.addVariationFromStack("redgranite", getModItem(GregTech.ID, "gt.blockgranites", 1, 15, missing));
        ChiselHelper.addVariationFromStack("limestone", getModItem(BiomesOPlenty.ID, "rocks", 1, 0, missing));
        ChiselHelper.addVariationFromStack("amber", getModItem(GregTech.ID, "gt.blockgem1", 1, 1, missing));
        ChiselHelper.addVariationFromStack("amber", getModItem(BiomesOPlenty.ID, "gemOre", 1, 15, missing));
        ChiselHelper.addGroup("endstone");
        ChiselHelper.addVariationFromStack("endstone", getModItem(Minecraft.ID, "end_stone", 1, 0, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 1, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 2, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 3, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 4, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 5, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 6, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 7, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 8, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 9, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 10, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 11, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 12, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 13, missing));
        ChiselHelper.addVariationFromStack(
                "endstone",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 12, missing));
        ChiselHelper.addVariationFromStack(
                "endstone",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 12, missing));
        ChiselHelper.addVariationFromStack("concrete", getModItem(GregTech.ID, "gt.blockconcretes", 1, 8, missing));
        ChiselHelper.addGroup("glowstoneGTNH");
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Minecraft.ID, "glowstone", 1, 0, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 1, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 2, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 3, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 4, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 5, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 6, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 7, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 8, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 9, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 10, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 11, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 12, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 13, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 14, missing));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 15, missing));
        ChiselHelper
                .addVariationFromStack("torch", getModItem(GalacticraftCore.ID, "tile.glowstoneTorch", 1, 0, missing));
        ChiselHelper.addVariationFromStack("aluminumblock", getModItem(GregTech.ID, "gt.blockmetal1", 1, 1, missing));
        ChiselHelper.addGroup("searedStoneTCon");
        ChiselHelper
                .addVariationFromStack("searedStoneTCon", getModItem(TinkerConstruct.ID, "Smeltery", 1, 4, missing));
        ChiselHelper
                .addVariationFromStack("searedStoneTCon", getModItem(TinkerConstruct.ID, "Smeltery", 1, 6, missing));
        ChiselHelper
                .addVariationFromStack("searedStoneTCon", getModItem(TinkerConstruct.ID, "Smeltery", 1, 11, missing));
        ChiselHelper.addGroup("searedStoneNetherTCon");
        ChiselHelper.addVariationFromStack(
                "searedStoneNetherTCon",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 4, missing));
        ChiselHelper.addVariationFromStack(
                "searedStoneNetherTCon",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 6, missing));
        ChiselHelper.addVariationFromStack(
                "searedStoneNetherTCon",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 11, missing));
        ChiselHelper.addGroup("searedBricksTCon");
        ChiselHelper
                .addVariationFromStack("searedBricksTCon", getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing));
        ChiselHelper
                .addVariationFromStack("searedBricksTCon", getModItem(TinkerConstruct.ID, "Smeltery", 1, 8, missing));
        ChiselHelper
                .addVariationFromStack("searedBricksTCon", getModItem(TinkerConstruct.ID, "Smeltery", 1, 9, missing));
        ChiselHelper.addGroup("searedBricksNetherTCon");
        ChiselHelper.addVariationFromStack(
                "searedBricksNetherTCon",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing));
        ChiselHelper.addVariationFromStack(
                "searedBricksNetherTCon",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 8, missing));
        ChiselHelper.addVariationFromStack(
                "searedBricksNetherTCon",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 9, missing));
        ChiselHelper.addGroup("speedBlockTCon");
        ChiselHelper
                .addVariationFromStack("speedBlockTCon", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 0, missing));
        ChiselHelper
                .addVariationFromStack("speedBlockTCon", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 1, missing));
        ChiselHelper.addGroup("brownStoneTCon");
        ChiselHelper
                .addVariationFromStack("brownStoneTCon", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 2, missing));
        ChiselHelper
                .addVariationFromStack("brownStoneTCon", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 3, missing));
        ChiselHelper
                .addVariationFromStack("brownStoneTCon", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 4, missing));
        ChiselHelper
                .addVariationFromStack("brownStoneTCon", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 5, missing));
        ChiselHelper
                .addVariationFromStack("brownStoneTCon", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 6, missing));
        ChiselHelper.addGroup("ironBricksTCon");
        ChiselHelper.addVariationFromStack(
                "ironBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 4, missing));
        ChiselHelper.addVariationFromStack(
                "ironBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 4, missing));
        ChiselHelper.addGroup("goldBricksTCon");
        ChiselHelper.addVariationFromStack(
                "goldBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 5, missing));
        ChiselHelper.addVariationFromStack(
                "goldBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 5, missing));
        ChiselHelper.addGroup("lapisBricksTCon");
        ChiselHelper.addVariationFromStack(
                "lapisBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 6, missing));
        ChiselHelper.addVariationFromStack(
                "lapisBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 6, missing));
        ChiselHelper.addGroup("diamondBricksTCon");
        ChiselHelper.addVariationFromStack(
                "diamondBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 7, missing));
        ChiselHelper.addVariationFromStack(
                "diamondBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 7, missing));
        ChiselHelper.addGroup("redstoneBricksTCon");
        ChiselHelper.addVariationFromStack(
                "redstoneBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 8, missing));
        ChiselHelper.addVariationFromStack(
                "redstoneBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 8, missing));
        ChiselHelper.addGroup("boneBricksTCon");
        ChiselHelper.addVariationFromStack(
                "boneBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 9, missing));
        ChiselHelper.addVariationFromStack(
                "boneBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 9, missing));
        ChiselHelper.addGroup("greenSlimeBricksTCon");
        ChiselHelper.addVariationFromStack(
                "greenSlimeBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 10, missing));
        ChiselHelper.addVariationFromStack(
                "greenSlimeBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 10, missing));
        ChiselHelper.addGroup("blueSlimeBricksTCon");
        ChiselHelper.addVariationFromStack(
                "blueSlimeBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 11, missing));
        ChiselHelper.addVariationFromStack(
                "blueSlimeBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 11, missing));
        ChiselHelper.addGroup("obsidianBricksTCon");
        ChiselHelper.addVariationFromStack(
                "obsidianBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 13, missing));
        ChiselHelper.addVariationFromStack(
                "obsidianBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 13, missing));
        ChiselHelper.addGroup("alumiteBricksTCon");
        ChiselHelper.addVariationFromStack(
                "alumiteBricksTCon",
                getModItem(TinkerConstruct.ID, "MetalBlock", 1, 8, missing));
        ChiselHelper.addVariationFromStack(
                "alumiteBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 0, missing));
        ChiselHelper.addVariationFromStack(
                "alumiteBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 4, missing));
        ChiselHelper.addGroup("arditeBricksTCon");
        ChiselHelper
                .addVariationFromStack("arditeBricksTCon", getModItem(TinkerConstruct.ID, "MetalBlock", 1, 1, missing));
        ChiselHelper.addVariationFromStack(
                "arditeBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 1, missing));
        ChiselHelper.addVariationFromStack(
                "arditeBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 5, missing));
        ChiselHelper.addGroup("cobaltBricksTCon");
        ChiselHelper
                .addVariationFromStack("cobaltBricksTCon", getModItem(TinkerConstruct.ID, "MetalBlock", 1, 0, missing));
        ChiselHelper.addVariationFromStack(
                "cobaltBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 2, missing));
        ChiselHelper.addVariationFromStack(
                "cobaltBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 6, missing));
        ChiselHelper.addGroup("manyullynBricksTCon");
        ChiselHelper.addVariationFromStack(
                "manyullynBricksTCon",
                getModItem(TinkerConstruct.ID, "MetalBlock", 1, 2, missing));
        ChiselHelper.addVariationFromStack(
                "manyullynBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 3, missing));
        ChiselHelper.addVariationFromStack(
                "manyullynBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 7, missing));
        ChiselHelper.addGroup("brown_mushroom");
        ChiselHelper.addGroup("red_mushroom");
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 0, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 0, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 1, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 1, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 2, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 2, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 3, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 3, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 4, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 4, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 5, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 5, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 6, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 6, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 7, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 7, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 8, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 8, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 9, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 9, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 10, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 10, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 11, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 11, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 12, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 12, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 13, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 13, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 14, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 14, missing));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 15, missing));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 15, missing));

    }
}
