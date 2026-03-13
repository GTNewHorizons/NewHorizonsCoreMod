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
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import com.cricketcraft.chisel.api.carving.CarvingUtils;
import com.dreammaster.chisel.ChiselHelper;

import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;
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
                BiomesOPlenty.ID,
                Botania.ID,
                Chisel.ID,
                EnderIO.ID,
                GalacticraftAmunRa.ID,
                GalacticraftCore.ID,
                IndustrialCraft2.ID,
                IronChests.ID,
                Natura.ID,
                ProjectRedExploration.ID,
                Railcraft.ID,
                TinkerConstruct.ID,
                TwilightForest.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(Chisel.ID, "chisel", 1, 0),
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
                getModItem(Chisel.ID, "chisel", 1, 0),
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
                getModItem(Chisel.ID, "obsidianChisel", 1, 0),
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
                getModItem(Chisel.ID, "obsidianChisel", 1, 0),
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
                getModItem(Chisel.ID, "diamondChisel", 1, 0),
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
                getModItem(Chisel.ID, "diamondChisel", 1, 0),
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
                getModItem(Chisel.ID, "autoChisel", 1, 0),
                "screwSteel",
                "ringWoodSealed",
                "screwSteel",
                ItemList.Conveyor_Module_LV.get(1L),
                ItemList.Cover_Crafting.get(1L),
                ItemList.Robot_Arm_LV.get(1L),
                "craftingToolScrewdriver",
                getModItem(IronChests.ID, "BlockIronChest", 1, 0),
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Chisel.ID, "upgrade", 1, 0),
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
                getModItem(Chisel.ID, "upgrade", 1, 1),
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
                getModItem(Chisel.ID, "upgrade", 1, 2),
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
                getModItem(Chisel.ID, "upgrade", 1, 3),
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
                getModItem(Chisel.ID, "mossy_templeblock", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(Chisel.ID, "templeblock", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0));
        addShapedRecipe(
                getModItem(Chisel.ID, "voidstone2", 8, 0),
                getModItem(Chisel.ID, "voidstone", 1, 0),
                getModItem(Chisel.ID, "voidstone", 1, 0),
                getModItem(Chisel.ID, "voidstone", 1, 0),
                getModItem(Chisel.ID, "voidstone", 1, 0),
                "dustGlowstone",
                getModItem(Chisel.ID, "voidstone", 1, 0),
                getModItem(Chisel.ID, "voidstone", 1, 0),
                getModItem(Chisel.ID, "voidstone", 1, 0),
                getModItem(Chisel.ID, "voidstone", 1, 0));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "Cloud", 64, 0),
                        getModItem(Botania.ID, "manaBottle", 1, 0),
                        new ItemStack(Blocks.wooden_button, 1))
                .itemOutputs(getModItem(Chisel.ID, "cloudinabottle", 1, 0)).duration(10 * SECONDS).eut(2)
                .addTo(formingPressRecipes);

        ChiselHelper.addGroup("glasswork");
        CarvingUtils.getChiselRegistry().removeGroup("cobblestone");
        CarvingUtils.getChiselRegistry().removeGroup("glowstone");
        CarvingUtils.getChiselRegistry().removeGroup("diamond_block");
        CarvingUtils.getChiselRegistry().removeGroup("gold_block");
        CarvingUtils.getChiselRegistry().removeGroup("iron_block");
        ChiselHelper.removeVariationStack(getModItem(Minecraft.ID, "stonebrick", 1, 1));
        ChiselHelper.removeVariationStack(getModItem(Minecraft.ID, "torch", 1, 0));
        ChiselHelper.addGroup("CobblestoneBricks");
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Minecraft.ID, "cobblestone", 1, 0));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 1));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 2));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 3));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 4));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 5));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 6));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 7));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 8));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 9));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 10));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 11));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 12));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 13));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 14));
        ChiselHelper.addVariationFromStack("CobblestoneBricks", getModItem(Chisel.ID, "cobblestone", 1, 15));

        ChiselHelper.addGroup("diamond_block");
        ChiselHelper.addVariationFromStack("diamond_block", getModItem(Minecraft.ID, "diamond_block", 1, 0));
        for (int i = 1; i <= 12; i++) {
            ChiselHelper.addVariationFromStack("diamond_block", getModItem(Chisel.ID, "diamond_block", 1, i));
        }
        ChiselHelper.addGroup("gold_block");
        ChiselHelper.addVariationFromStack("gold_block", getModItem(Minecraft.ID, "gold_block", 1, 0));
        for (int i = 1; i <= 14; i++) {
            ChiselHelper.addVariationFromStack("gold_block", getModItem(Chisel.ID, "gold_block", 1, i));
        }
        for (int i = 0; i <= 5; i++) {
            ChiselHelper.addVariationFromStack("gold_block", getModItem(Chisel.ID, "gold2", 1, i));
        }
        ChiselHelper.addGroup("iron_block");
        ChiselHelper.addVariationFromStack("iron_block", getModItem(Minecraft.ID, "iron_block", 1, 0));
        for (int i = 1; i <= 15; i++) {
            ChiselHelper.addVariationFromStack("iron_block", getModItem(Chisel.ID, "iron_block", 1, i));
        }
        for (int i = 0; i <= 5; i++) {
            ChiselHelper.addVariationFromStack("iron_block", getModItem(Chisel.ID, "iron2", 1, i));
        }

        ChiselHelper.addVariationFromStack("glasswork", getModItem(Minecraft.ID, "glass", 1, 0));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 1));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 2));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 3));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 4));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 5));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 6));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 7));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 8));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 9));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 10));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 11));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 12));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 13));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 14));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass", 1, 15));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(Chisel.ID, "glass2", 1, 0));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        ChiselHelper.addVariationFromStack("glasswork", getModItem(EnderIO.ID, "blockFusedQuartz", 1, 1));
        ChiselHelper.addVariationFromStack("glass", getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0));
        ChiselHelper.addVariationFromStack("cloud", getModItem(Natura.ID, "Cloud", 1, 0));
        ChiselHelper.addVariationFromStack("marble", getModItem(Railcraft.ID, "cube", 1, 7));
        ChiselHelper.addVariationFromStack("marble", new ItemStack(GregTechAPI.sBlockStones, 1, 0));
        ChiselHelper.addVariationFromStack("marble", new ItemStack(GregTechAPI.sBlockStones, 1, 1));
        ChiselHelper.addVariationFromStack("marble", new ItemStack(GregTechAPI.sBlockStones, 1, 2));
        ChiselHelper.addVariationFromStack("marble", new ItemStack(GregTechAPI.sBlockStones, 1, 3));
        ChiselHelper.addVariationFromStack("marble", new ItemStack(GregTechAPI.sBlockStones, 1, 4));
        ChiselHelper.addVariationFromStack("marble", new ItemStack(GregTechAPI.sBlockStones, 1, 5));
        ChiselHelper.addVariationFromStack("marble", new ItemStack(GregTechAPI.sBlockStones, 1, 6));
        ChiselHelper.addVariationFromStack("marble", new ItemStack(GregTechAPI.sBlockStones, 1, 7));
        ChiselHelper.addVariationFromStack("RCAbyssalBlock", getModItem(Railcraft.ID, "cube", 1, 6));
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
                getModItem(ProjectRedExploration.ID, "projectred.exploration.stone", 1, 2));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem(ProjectRedExploration.ID, "projectred.exploration.stone", 1, 3));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem(ProjectRedExploration.ID, "projectred.exploration.stone", 1, 4));
        ChiselHelper.addVariationFromStack("basalts", getModItem(IndustrialCraft2.ID, "blockBasalt", 1, 0));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem(GalacticraftAmunRa.ID, "tile.baseBlockRock", 1, 0));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem(GalacticraftAmunRa.ID, "tile.baseBlockRock", 1, 1));
        ChiselHelper.addVariationFromStack(
                "basalts",
                getModItem(GalacticraftAmunRa.ID, "tile.baseBlockRock", 1, 7));
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
        ChiselHelper.addVariationFromStack("limestone", getModItem(BiomesOPlenty.ID, "rocks", 1, 0));
        ChiselHelper.addVariationFromStack("amber", new ItemStack(GregTechAPI.sBlockGem1, 1, 1));
        ChiselHelper.addVariationFromStack("amber", getModItem(BiomesOPlenty.ID, "gemOre", 1, 15));
        CarvingUtils.getChiselRegistry().removeGroup("end_stone");
        ChiselHelper.addGroup("endstone");
        ChiselHelper.addVariationFromStack("endstone", getModItem(Minecraft.ID, "end_stone", 1, 0));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 0));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 1));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 2));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 3));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 4));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 5));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 6));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 7));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 8));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 9));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 10));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 11));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 12));
        ChiselHelper.addVariationFromStack("endstone", getModItem(Chisel.ID, "end_Stone", 1, 13));
        ChiselHelper.addVariationFromStack(
                "endstone",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 12));
        ChiselHelper.addVariationFromStack(
                "endstone",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 12));
        ChiselHelper.addVariationFromStack("concrete", new ItemStack(GregTechAPI.sBlockConcretes, 1, 8));
        ChiselHelper.addGroup("glowstoneGTNH");
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Minecraft.ID, "glowstone", 1, 0));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 1));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 2));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 3));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 4));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 5));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 6));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 7));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 8));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 9));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 10));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 11));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 12));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 13));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 14));
        ChiselHelper.addVariationFromStack("glowstoneGTNH", getModItem(Chisel.ID, "glowstone", 1, 15));
        ChiselHelper
                .addVariationFromStack("torch", getModItem(GalacticraftCore.ID, "tile.glowstoneTorch", 1, 0));
        ChiselHelper.addVariationFromStack("aluminumblock", new ItemStack(GregTechAPI.sBlockMetal1, 1, 1));
        ChiselHelper.addGroup("searedStoneTCon");
        ChiselHelper
                .addVariationFromStack("searedStoneTCon", getModItem(TinkerConstruct.ID, "Smeltery", 1, 4));
        ChiselHelper
                .addVariationFromStack("searedStoneTCon", getModItem(TinkerConstruct.ID, "Smeltery", 1, 6));
        ChiselHelper
                .addVariationFromStack("searedStoneTCon", getModItem(TinkerConstruct.ID, "Smeltery", 1, 11));
        ChiselHelper.addGroup("searedStoneNetherTCon");
        ChiselHelper.addVariationFromStack(
                "searedStoneNetherTCon",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 4));
        ChiselHelper.addVariationFromStack(
                "searedStoneNetherTCon",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 6));
        ChiselHelper.addVariationFromStack(
                "searedStoneNetherTCon",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 11));
        ChiselHelper.addGroup("searedBricksTCon");
        ChiselHelper
                .addVariationFromStack("searedBricksTCon", getModItem(TinkerConstruct.ID, "Smeltery", 1, 2));
        ChiselHelper
                .addVariationFromStack("searedBricksTCon", getModItem(TinkerConstruct.ID, "Smeltery", 1, 8));
        ChiselHelper
                .addVariationFromStack("searedBricksTCon", getModItem(TinkerConstruct.ID, "Smeltery", 1, 9));
        ChiselHelper.addGroup("searedBricksNetherTCon");
        ChiselHelper.addVariationFromStack(
                "searedBricksNetherTCon",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2));
        ChiselHelper.addVariationFromStack(
                "searedBricksNetherTCon",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 8));
        ChiselHelper.addVariationFromStack(
                "searedBricksNetherTCon",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 9));
        ChiselHelper.addGroup("speedBlockTCon");
        ChiselHelper
                .addVariationFromStack("speedBlockTCon", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 0));
        ChiselHelper
                .addVariationFromStack("speedBlockTCon", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 1));
        ChiselHelper.addGroup("brownStoneTCon");
        ChiselHelper
                .addVariationFromStack("brownStoneTCon", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 2));
        ChiselHelper
                .addVariationFromStack("brownStoneTCon", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 3));
        ChiselHelper
                .addVariationFromStack("brownStoneTCon", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 4));
        ChiselHelper
                .addVariationFromStack("brownStoneTCon", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 5));
        ChiselHelper
                .addVariationFromStack("brownStoneTCon", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 6));
        ChiselHelper.addGroup("ironBricksTCon");
        ChiselHelper.addVariationFromStack(
                "ironBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 4));
        ChiselHelper.addVariationFromStack(
                "ironBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 4));
        ChiselHelper.addGroup("goldBricksTCon");
        ChiselHelper.addVariationFromStack(
                "goldBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 5));
        ChiselHelper.addVariationFromStack(
                "goldBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 5));
        ChiselHelper.addGroup("lapisBricksTCon");
        ChiselHelper.addVariationFromStack(
                "lapisBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 6));
        ChiselHelper.addVariationFromStack(
                "lapisBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 6));
        ChiselHelper.addGroup("diamondBricksTCon");
        ChiselHelper.addVariationFromStack(
                "diamondBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 7));
        ChiselHelper.addVariationFromStack(
                "diamondBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 7));
        ChiselHelper.addGroup("redstoneBricksTCon");
        ChiselHelper.addVariationFromStack(
                "redstoneBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 8));
        ChiselHelper.addVariationFromStack(
                "redstoneBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 8));
        ChiselHelper.addGroup("boneBricksTCon");
        ChiselHelper.addVariationFromStack(
                "boneBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 9));
        ChiselHelper.addVariationFromStack(
                "boneBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 9));
        ChiselHelper.addGroup("greenSlimeBricksTCon");
        ChiselHelper.addVariationFromStack(
                "greenSlimeBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 10));
        ChiselHelper.addVariationFromStack(
                "greenSlimeBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 10));
        ChiselHelper.addGroup("blueSlimeBricksTCon");
        ChiselHelper.addVariationFromStack(
                "blueSlimeBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 11));
        ChiselHelper.addVariationFromStack(
                "blueSlimeBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 11));
        ChiselHelper.addGroup("obsidianBricksTCon");
        ChiselHelper.addVariationFromStack(
                "obsidianBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrick", 1, 13));
        ChiselHelper.addVariationFromStack(
                "obsidianBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickfancy", 1, 13));
        ChiselHelper.addGroup("alumiteBricksTCon");
        ChiselHelper.addVariationFromStack(
                "alumiteBricksTCon",
                getModItem(TinkerConstruct.ID, "MetalBlock", 1, 8));
        ChiselHelper.addVariationFromStack(
                "alumiteBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 0));
        ChiselHelper.addVariationFromStack(
                "alumiteBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 4));
        ChiselHelper.addGroup("arditeBricksTCon");
        ChiselHelper
                .addVariationFromStack("arditeBricksTCon", getModItem(TinkerConstruct.ID, "MetalBlock", 1, 1));
        ChiselHelper.addVariationFromStack(
                "arditeBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 1));
        ChiselHelper.addVariationFromStack(
                "arditeBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 5));
        ChiselHelper.addGroup("cobaltBricksTCon");
        ChiselHelper
                .addVariationFromStack("cobaltBricksTCon", getModItem(TinkerConstruct.ID, "MetalBlock", 1, 0));
        ChiselHelper.addVariationFromStack(
                "cobaltBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 2));
        ChiselHelper.addVariationFromStack(
                "cobaltBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 6));
        ChiselHelper.addGroup("manyullynBricksTCon");
        ChiselHelper.addVariationFromStack(
                "manyullynBricksTCon",
                getModItem(TinkerConstruct.ID, "MetalBlock", 1, 2));
        ChiselHelper.addVariationFromStack(
                "manyullynBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 3));
        ChiselHelper.addVariationFromStack(
                "manyullynBricksTCon",
                getModItem(TinkerConstruct.ID, "decoration.multibrickmetal", 1, 7));
        ChiselHelper.addGroup("brown_mushroom");
        ChiselHelper.addGroup("red_mushroom");
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 0));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 0));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 1));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 1));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 2));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 2));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 3));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 3));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 4));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 4));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 5));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 5));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 6));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 6));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 7));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 7));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 8));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 8));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 9));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 9));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 10));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 10));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 11));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 11));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 12));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 12));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 13));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 13));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 14));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 14));
        ChiselHelper.addVariationFromStack(
                "brown_mushroom",
                getModItem(Minecraft.ID, "brown_mushroom_block", 1, 15));
        ChiselHelper
                .addVariationFromStack("red_mushroom", getModItem(Minecraft.ID, "red_mushroom_block", 1, 15));

        ChiselHelper.addGroup("blazeblock");
        ChiselHelper.addVariationFromStack("blazeblock", getModItem(Botania.ID, "blazeBlock", 1, 0));
        ChiselHelper.addVariationFromStack("blazeblock", new ItemStack(GregTechAPI.sBlockGem3, 1, 5));
        ChiselHelper.addGroup("steeleafblock");
        ChiselHelper.addVariationFromStack("steeleafblock", getModItem(TwilightForest.ID, "tile.SteeleafBlock", 1));
        ChiselHelper.addVariationFromStack("steeleafblock", new ItemStack(GregTechAPI.sBlockMetal8, 1, 12));
        ChiselHelper.addGroup("knightmetalblock");
        ChiselHelper.addVariationFromStack(
                "knightmetalblock",
                getModItem(TwilightForest.ID, "tile.KnightmetalBlock", 1, 0));
        ChiselHelper.addVariationFromStack("knightmetalblock", new ItemStack(GregTechAPI.sBlockMetal4, 1, 0));
        ChiselHelper.addGroup("ironwoodblock");
        ChiselHelper.addVariationFromStack(
                "ironwoodblock",
                getModItem(TwilightForest.ID, "tile.IronwoodBlock", 1, 0));
        ChiselHelper.addVariationFromStack("ironwoodblock", new ItemStack(GregTechAPI.sBlockMetal3, 1, 14));
        ChiselHelper.addGroup("fieryblock");
        ChiselHelper
                .addVariationFromStack("fieryblock", getModItem(TwilightForest.ID, "tile.FieryBlock", 1, 0));
        ChiselHelper.addVariationFromStack("fieryblock", new ItemStack(GregTechAPI.sBlockMetal3, 1, 4));
    }
}
