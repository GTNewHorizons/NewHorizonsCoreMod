package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.ProjectRedExploration;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.cricketcraft.chisel.api.carving.CarvingUtils;
import com.dreammaster.chisel.ChiselHelper;

import gregtech.api.GregTechAPI;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

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
                Botania.ID,
                Chisel.ID,
                EnderIO.ID,
                GalacticraftAmunRa.ID,
                GalacticraftCore.ID,
                IndustrialCraft2.ID,
                IronChests.ID,
                Natura.ID,
                Railcraft.ID,
                TinkerConstruct.ID,
                TwilightForest.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(Chisel.ID, "chisel", 1, 0, missing),
                "craftingToolHardHammer",
                "plateAnyIron",
                "plateAnyIron",
                "screwAnyIron",
                "stickWood",
                "plateAnyIron",
                "stickWood",
                "screwAnyIron",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(Chisel.ID, "chisel", 1, 0, missing),
                "craftingToolScrewdriver",
                "plateAnyIron",
                "plateAnyIron",
                "screwAnyIron",
                "stickWood",
                "plateAnyIron",
                "stickWood",
                "screwAnyIron",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Chisel.ID, "obsidianChisel", 1, 0, missing),
                "craftingToolHardHammer",
                "plateObsidian",
                "plateObsidian",
                "screwWroughtIron",
                "stickWroughtIron",
                "plateObsidian",
                "stickWroughtIron",
                "screwWroughtIron",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(Chisel.ID, "obsidianChisel", 1, 0, missing),
                "craftingToolScrewdriver",
                "plateObsidian",
                "plateObsidian",
                "screwWroughtIron",
                "stickWroughtIron",
                "plateObsidian",
                "stickWroughtIron",
                "screwWroughtIron",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Chisel.ID, "diamondChisel", 1, 0, missing),
                "craftingToolHardHammer",
                "plateDiamond",
                "plateDiamond",
                "screwSteel",
                "stickSteel",
                "plateDiamond",
                "stickSteel",
                "screwSteel",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(Chisel.ID, "diamondChisel", 1, 0, missing),
                "craftingToolScrewdriver",
                "plateDiamond",
                "plateDiamond",
                "screwSteel",
                "stickSteel",
                "plateDiamond",
                "stickSteel",
                "screwSteel",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Chisel.ID, "autoChisel", 1, 0, missing),
                "screwSteel",
                "ringWoodSealed",
                "screwSteel",
                ItemList.Conveyor_Module_LV.get(1L),
                ItemList.Cover_Crafting.get(1L),
                ItemList.Robot_Arm_LV.get(1L),
                "craftingToolScrewdriver",
                getModItem(IronChests.ID, "BlockIronChest", 1, 0, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Chisel.ID, "upgrade", 1, 0, missing),
                "screwSteel",
                "plateEmerald",
                "screwSteel",
                "plateEmerald",
                "circuitBasic",
                "plateEmerald",
                "wireGt01RedAlloy",
                ItemList.Conveyor_Module_LV.get(1L),
                "wireGt01RedAlloy");
        addShapedRecipe(
                getModItem(Chisel.ID, "upgrade", 1, 1, missing),
                "screwSteel",
                "plateEmerald",
                "screwSteel",
                "plateEmerald",
                "circuitBasic",
                "plateEmerald",
                "wireGt01RedAlloy",
                ItemList.Robot_Arm_LV.get(1L),
                "wireGt01RedAlloy");
        addShapedRecipe(
                getModItem(Chisel.ID, "upgrade", 1, 2, missing),
                "screwSteel",
                "plateEmerald",
                "screwSteel",
                "plateEmerald",
                "circuitBasic",
                "plateEmerald",
                "wireGt01RedAlloy",
                ItemList.Cover_Crafting.get(1L),
                "wireGt01RedAlloy");
        addShapedRecipe(
                getModItem(Chisel.ID, "upgrade", 1, 3, missing),
                "screwSteel",
                "plateEmerald",
                "screwSteel",
                "plateEmerald",
                "circuitBasic",
                "plateEmerald",
                "wireGt01RedAlloy",
                ItemList.Electric_Motor_LV.get(1L),
                "wireGt01RedAlloy");
        addShapedRecipe(
                getModItem(Chisel.ID, "mossy_templeblock", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(Chisel.ID, "templeblock", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing));
        addShapedRecipe(
                getModItem(Chisel.ID, "voidstone2", 8, 0, missing),
                getModItem(Chisel.ID, "voidstone", 1, 0, missing),
                getModItem(Chisel.ID, "voidstone", 1, 0, missing),
                getModItem(Chisel.ID, "voidstone", 1, 0, missing),
                getModItem(Chisel.ID, "voidstone", 1, 0, missing),
                "dustGlowstone",
                getModItem(Chisel.ID, "voidstone", 1, 0, missing),
                getModItem(Chisel.ID, "voidstone", 1, 0, missing),
                getModItem(Chisel.ID, "voidstone", 1, 0, missing),
                getModItem(Chisel.ID, "voidstone", 1, 0, missing));

        ChiselHelper.addGroup("glasswork");
        CarvingUtils.getChiselRegistry().removeGroup("cobblestone");
        CarvingUtils.getChiselRegistry().removeGroup("glowstone");
        CarvingUtils.getChiselRegistry().removeGroup("diamond_block");
        CarvingUtils.getChiselRegistry().removeGroup("gold_block");
        CarvingUtils.getChiselRegistry().removeGroup("iron_block");
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

        ChiselHelper.addGroup("diamond_block");
        ChiselHelper.addVariationFromStack("diamond_block", getModItem(Minecraft.ID, "diamond_block", 1, 0, missing));
        for (int i = 1; i <= 12; i++) {
            ChiselHelper.addVariationFromStack("diamond_block", getModItem(Chisel.ID, "diamond_block", 1, i, missing));
        }
        ChiselHelper.addGroup("gold_block");
        ChiselHelper.addVariationFromStack("gold_block", getModItem(Minecraft.ID, "gold_block", 1, 0, missing));
        for (int i = 1; i <= 14; i++) {
            ChiselHelper.addVariationFromStack("gold_block", getModItem(Chisel.ID, "gold_block", 1, i, missing));
        }
        for (int i = 0; i <= 5; i++) {
            ChiselHelper.addVariationFromStack("gold_block", getModItem(Chisel.ID, "gold2", 1, i, missing));
        }
        ChiselHelper.addGroup("iron_block");
        ChiselHelper.addVariationFromStack("iron_block", getModItem(Minecraft.ID, "iron_block", 1, 0, missing));
        for (int i = 1; i <= 15; i++) {
            ChiselHelper.addVariationFromStack("iron_block", getModItem(Chisel.ID, "iron_block", 1, i, missing));
        }
        for (int i = 0; i <= 5; i++) {
            ChiselHelper.addVariationFromStack("iron_block", getModItem(Chisel.ID, "iron2", 1, i, missing));
        }

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
        ChiselHelper.addVariationFromStack("marble", new ItemStack(GregTechAPI.sBlockStones, 1, 0));
        ChiselHelper.addVariationFromStack("marble", new ItemStack(GregTechAPI.sBlockStones, 1, 1));
        ChiselHelper.addVariationFromStack("marble", new ItemStack(GregTechAPI.sBlockStones, 1, 2));
        ChiselHelper.addVariationFromStack("marble", new ItemStack(GregTechAPI.sBlockStones, 1, 3));
        ChiselHelper.addVariationFromStack("marble", new ItemStack(GregTechAPI.sBlockStones, 1, 4));
        ChiselHelper.addVariationFromStack("marble", new ItemStack(GregTechAPI.sBlockStones, 1, 5));
        ChiselHelper.addVariationFromStack("marble", new ItemStack(GregTechAPI.sBlockStones, 1, 6));
        ChiselHelper.addVariationFromStack("marble", new ItemStack(GregTechAPI.sBlockStones, 1, 7));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", getModItem(Railcraft.ID, "cube", 1, 6, missing));
        ChiselHelper.addVariationFromStack(
                "RCAbyssalBlock",
                GTOreDictUnificator.get(OrePrefixes.stone, Materials.GraniteBlack, 1L));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", new ItemStack(GregTechAPI.sBlockGranites, 1, 1));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", new ItemStack(GregTechAPI.sBlockGranites, 1, 2));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", new ItemStack(GregTechAPI.sBlockGranites, 1, 3));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", new ItemStack(GregTechAPI.sBlockGranites, 1, 4));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", new ItemStack(GregTechAPI.sBlockGranites, 1, 5));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", new ItemStack(GregTechAPI.sBlockGranites, 1, 6));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", new ItemStack(GregTechAPI.sBlockGranites, 1, 7));
        ChiselHelper.addGroup("basalts");
        ChiselHelper.addVariationFromStack("basalts", new ItemStack(GregTechAPI.sBlockStones, 1, 8));
        ChiselHelper.addVariationFromStack("basalts", new ItemStack(GregTechAPI.sBlockStones, 1, 9));
        ChiselHelper.addVariationFromStack("basalts", new ItemStack(GregTechAPI.sBlockStones, 1, 10));
        ChiselHelper.addVariationFromStack("basalts", new ItemStack(GregTechAPI.sBlockStones, 1, 11));
        ChiselHelper.addVariationFromStack("basalts", new ItemStack(GregTechAPI.sBlockStones, 1, 12));
        ChiselHelper.addVariationFromStack("basalts", new ItemStack(GregTechAPI.sBlockStones, 1, 13));
        ChiselHelper.addVariationFromStack("basalts", new ItemStack(GregTechAPI.sBlockStones, 1, 14));
        ChiselHelper.addVariationFromStack("basalts", new ItemStack(GregTechAPI.sBlockStones, 1, 15));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem(ProjectRedExploration.ID, "projectred.exploration.stone", 1, 2, missing));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem(ProjectRedExploration.ID, "projectred.exploration.stone", 1, 3, missing));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem(ProjectRedExploration.ID, "projectred.exploration.stone", 1, 4, missing));
        ChiselHelper.addVariationFromStack("basalts", getModItem(IndustrialCraft2.ID, "blockBasalt", 1, 0, missing));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem(GalacticraftAmunRa.ID, "tile.baseBlockRock", 1, 0, missing));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem(GalacticraftAmunRa.ID, "tile.baseBlockRock", 1, 1, missing));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem(GalacticraftAmunRa.ID, "tile.baseBlockRock", 1, 7, missing));
        ChiselHelper.addGroup("redgranite");
        ChiselHelper.addVariationFromStack(
                "redgranite",
                GTOreDictUnificator.get(OrePrefixes.stone, Materials.GraniteRed, 1L));
        ChiselHelper.addVariationFromStack("redgranite", new ItemStack(GregTechAPI.sBlockGranites, 1, 9));
        ChiselHelper.addVariationFromStack("redgranite", new ItemStack(GregTechAPI.sBlockGranites, 1, 10));
        ChiselHelper.addVariationFromStack("redgranite", new ItemStack(GregTechAPI.sBlockGranites, 1, 11));
        ChiselHelper.addVariationFromStack("redgranite", new ItemStack(GregTechAPI.sBlockGranites, 1, 12));
        ChiselHelper.addVariationFromStack("redgranite", new ItemStack(GregTechAPI.sBlockGranites, 1, 13));
        ChiselHelper.addVariationFromStack("redgranite", new ItemStack(GregTechAPI.sBlockGranites, 1, 14));
        ChiselHelper.addVariationFromStack("redgranite", new ItemStack(GregTechAPI.sBlockGranites, 1, 15));
        ChiselHelper.addVariationFromStack("limestone", getModItem(BiomesOPlenty.ID, "rocks", 1, 0, missing));
        ChiselHelper.addVariationFromStack("amber", new ItemStack(GregTechAPI.sBlockGem1, 1, 1));
        ChiselHelper.addVariationFromStack("amber", getModItem(BiomesOPlenty.ID, "gemOre", 1, 15, missing));
        CarvingUtils.getChiselRegistry().removeGroup("end_stone");
        ChiselHelper.addGroup("endstone");
        ChiselHelper.addVariationFromStack("endstone", getModItem(Minecraft.ID, "end_stone", 1, 0, missing));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 0, missing));
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
        ChiselHelper.addVariationFromStack("concrete", new ItemStack(GregTechAPI.sBlockConcretes, 1, 8));
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
        ChiselHelper.addVariationFromStack("aluminumblock", new ItemStack(GregTechAPI.sBlockMetal1, 1, 1));
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

        ChiselHelper.addGroup("blazeblock");
        ChiselHelper.addVariationFromStack("blazeblock", getModItem(Botania.ID, "blazeBlock", 1, 0, missing));
        ChiselHelper.addVariationFromStack("blazeblock", new ItemStack(GregTechAPI.sBlockGem3, 1, 5));
        ChiselHelper.addGroup("steeleafblock");
        ChiselHelper.addVariationFromStack("steeleafblock", getModItem(TwilightForest.ID, "tile.SteeleafBlock", 1));
        ChiselHelper.addVariationFromStack("steeleafblock", new ItemStack(GregTechAPI.sBlockMetal8, 1, 12));
        ChiselHelper.addGroup("knightmetalblock");
        ChiselHelper.addVariationFromStack(
                "knightmetalblock",
                getModItem(TwilightForest.ID, "tile.KnightmetalBlock", 1, 0, missing));
        ChiselHelper.addVariationFromStack("knightmetalblock", new ItemStack(GregTechAPI.sBlockMetal4, 1, 0));
        ChiselHelper.addGroup("ironwoodblock");
        ChiselHelper.addVariationFromStack(
                "ironwoodblock",
                getModItem(TwilightForest.ID, "tile.IronwoodBlock", 1, 0, missing));
        ChiselHelper.addVariationFromStack("ironwoodblock", new ItemStack(GregTechAPI.sBlockMetal3, 1, 14));
        ChiselHelper.addGroup("fieryblock");
        ChiselHelper
                .addVariationFromStack("fieryblock", getModItem(TwilightForest.ID, "tile.FieryBlock", 1, 0, missing));
        ChiselHelper.addVariationFromStack("fieryblock", new ItemStack(GregTechAPI.sBlockMetal3, 1, 4));
    }
}
