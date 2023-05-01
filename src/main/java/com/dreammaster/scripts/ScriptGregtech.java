package com.dreammaster.scripts;

import static com.dreammaster.scripts.TemporaryMods.MCFrames;
import static com.dreammaster.scripts.TemporaryMods.ProjectRedExpansion;
import static com.dreammaster.scripts.TemporaryMods.ProjectRedTransmission;
import static com.dreammaster.scripts.TemporaryMods.StructureLib;
import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.CropsPlusPlus;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.SGCraft;
import static gregtech.api.enums.Mods.SuperSolarPanels;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAutoclaveRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sBenderRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sChemicalRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sExtractorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sExtruderRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sHammerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sPressRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import tconstruct.library.TConstructRegistry;
import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_ModHandler;

public class ScriptGregtech implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Gregtech";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                MCFrames.ID,
                ProjectRedExpansion.ID,
                ProjectRedTransmission.ID,
                StructureLib.ID,
                AdvancedSolarPanel.ID,
                BiomesOPlenty.ID,
                BloodArsenal.ID,
                CropsPlusPlus.ID,
                IndustrialCraft2.ID,
                Natura.ID,
                OpenBlocks.ID,
                PamsHarvestCraft.ID,
                SGCraft.ID,
                SuperSolarPanels.ID,
                Thaumcraft.ID,
                ThaumicBases.ID,
                TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1145, missing),
                new Object[] { "circuitOptical", getModItem(SGCraft.ID, "ic2PowerUnit", 1, 0, missing),
                        "circuitOptical", getModItem(SGCraft.ID, "ic2Capacitor", 1, 0, missing),
                        getModItem(SGCraft.ID, "stargateBase", 1, 0, missing),
                        getModItem(SGCraft.ID, "ic2Capacitor", 1, 0, missing),
                        getModItem(SGCraft.ID, "ic2Capacitor", 1, 0, missing),
                        getModItem(SGCraft.ID, "ocInterface", 1, 0, missing),
                        getModItem(SGCraft.ID, "ic2Capacitor", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 500, missing),
                new Object[] { null, getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing), null,
                        "craftingToolFile", getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        "craftingToolHardHammer", null, null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 1500, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing), "gemDiamond", "gemDiamond",
                        "craftingToolFile", null, "craftingToolHardHammer", null, null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 2500, missing),
                new Object[] { "craftingToolFile", getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        "craftingToolHardHammer", null, null, null, null, null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 3500, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing), "gemDiamond",
                        "craftingToolHardHammer", getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing), null,
                        null, "craftingToolFile", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 4500, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing), "gemDiamond",
                        "craftingToolHardHammer", "craftingToolFile", null, null, null, null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 28809, missing),
                new Object[] { "craftingToolKnife", null, null, null,
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing), null });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2890, missing),
                new Object[] { "craftingToolMortar", getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 1890, missing),
                new Object[] { "craftingToolMortar", getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2892, missing),
                new Object[] { "craftingToolMortar", "listAllmeatraw" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2892, missing),
                new Object[] { "craftingToolMortar", "listAllfishraw" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "sugar", 4, 0, missing),
                new Object[] { "craftingToolMortar", getModItem(CropsPlusPlus.ID, "foodBerries", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2893, missing),
                new Object[] { "craftingToolMortar", "listAllmeatcooked" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2893, missing),
                new Object[] { "craftingToolMortar", "listAllfishcooked" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing),
                new Object[] { "craftingToolMortar", "logWood" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 1625, missing),
                new Object[] { "craftingToolMortar", getModItem(Minecraft.ID, "brick", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22874, missing),
                new Object[] { "stickPlastic", "craftingToolHardHammer", "stickPlastic" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2881, missing),
                new Object[] { "cropBarley", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2881, missing),
                new Object[] { "cropWheat", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2881, missing),
                new Object[] { "cropRye", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2881, missing),
                new Object[] { "cropOats", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2817, missing),
                new Object[] { getModItem(GregTech.ID, "gt.blockores", 1, 817, missing), null, null,
                        "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2817, missing),
                new Object[] { getModItem(GregTech.ID, "gt.blockores", 1, 1817, missing), null, null,
                        "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2817, missing),
                new Object[] { getModItem(GregTech.ID, "gt.blockores", 1, 2817, missing), null, null,
                        "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2817, missing),
                new Object[] { getModItem(GregTech.ID, "gt.blockores", 1, 3817, missing), null, null,
                        "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2817, missing),
                new Object[] { getModItem(GregTech.ID, "gt.blockores", 1, 4817, missing), null, null,
                        "craftingToolMortar", null, null });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 1805, missing),
                new Object[] { "craftingToolMortar", getModItem(Minecraft.ID, "clay_ball", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32, missing),
                new Object[] { "nuggetIron", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 86, missing),
                new Object[] { "nuggetGold", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 35, missing),
                new Object[] { "nuggetCopper", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 57, missing),
                new Object[] { "nuggetTin", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 54, missing),
                new Object[] { "nuggetSilver", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 89, missing),
                new Object[] { "nuggetLead", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 36, missing),
                new Object[] { "nuggetZinc", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 34, missing),
                new Object[] { "nuggetNickel", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockcasings2", 1, 11, missing),
                new Object[] { "itemCasingStainlessSteel", "circuitAdvanced", "itemCasingStainlessSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing),
                        getModItem(GregTech.ID, "gt.blockcasings2", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing), "itemCasingStainlessSteel",
                        "circuitAdvanced", "itemCasingStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32750, missing),
                new Object[] { getModItem(ProjectRedExpansion.ID, "projectred.expansion.solar_panel", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.blockmachines", 1, 2000, missing),
                new Object[] { getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22880, missing),
                new Object[] { "stickRubber", "craftingToolHardHammer", "stickRubber" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22530, missing),
                new Object[] { "stickApatite", "craftingToolHardHammer", "stickApatite" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22526, missing),
                new Object[] { "stickLapis", "craftingToolHardHammer", "stickLapis" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22524, missing),
                new Object[] { "stickLazurite", "craftingToolHardHammer", "stickLazurite" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22525, missing),
                new Object[] { "stickSodalite", "craftingToolHardHammer", "stickSodalite" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22532, missing),
                new Object[] { "stickEnderPearl", "craftingToolHardHammer", "stickEnderPearl" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22533, missing),
                new Object[] { "stickEnderEye", "craftingToolHardHammer", "stickEnderEye" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.blockmachines", 2, 4905, missing),
                new Object[] { getModItem(MCFrames.ID, "mcframes.frame", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.blockmachines", 1, 4905, missing),
                new Object[] { getModItem(OpenBlocks.ID, "scaffolding", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 1890, missing),
                new Object[] { "craftingToolMortar", getModItem(BloodArsenal.ID, "glass_shard", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 2, 2322, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 2305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 10, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1047, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1345, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1034, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1029, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1030, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1048, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1028, missing) });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockcasings2", 1, 10, missing),
                new Object[] { "itemCasingStainlessSteel", "circuitAdvanced", "itemCasingStainlessSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing),
                        getModItem(GregTech.ID, "gt.blockcasings2", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing), "itemCasingStainlessSteel",
                        "circuitAdvanced", "itemCasingStainlessSteel" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 20849, missing),
                new Object[] { "stoneGraniteBlack", null, null, null, "craftingToolFile", null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 20850, missing),
                new Object[] { "stoneGraniteRed", null, null, null, "craftingToolFile", null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockcasings2", 1, 6, missing),
                new Object[] { "itemCasingStainlessSteel", "circuitElite", "itemCasingStainlessSteel", "circuitElite",
                        getModItem(GregTech.ID, "gt.blockcasings2", 1, 0, missing), "circuitElite",
                        "itemCasingStainlessSteel", "circuitElite", "itemCasingStainlessSteel" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17804, missing),
                new Object[] { "craftingToolHardHammer", null, null, "ingotObsidian", null, null, "ingotObsidian", null,
                        null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockstones", 1, 2, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockstones", 1, 1, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockstones", 1, 5, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockstones", 1, 3, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockconcretes", 1, 10, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockconcretes", 1, 9, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockconcretes", 1, 13, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockconcretes", 1, 11, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockstones", 1, 10, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockstones", 1, 9, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockstones", 1, 13, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockstones", 1, 11, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockgranites", 1, 2, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockgranites", 1, 1, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockgranites", 1, 5, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockgranites", 1, 3, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockgranites", 1, 10, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockgranites", 1, 9, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockgranites", 1, 13, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockgranites", 1, 11, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32417, missing),
                new Object[] { "dyeBrown" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32421, missing),
                new Object[] { "dyeLightGray" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32425, missing),
                new Object[] { "dyeYellow" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32429, missing),
                new Object[] { "dyeWhite" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32418, missing),
                new Object[] { "dyeBlue" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32422, missing),
                new Object[] { "dyeGray" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32424, missing),
                new Object[] { "dyeLime" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32428, missing),
                new Object[] { "dyeOrange" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32415, missing),
                new Object[] { "dyeRed" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32419, missing),
                new Object[] { "dyePurple" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32423, missing),
                new Object[] { "dyePink" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32427, missing),
                new Object[] { "dyeMagenta" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32414, missing),
                new Object[] { "dyeBlack" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32416, missing),
                new Object[] { "dyeGreen" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32420, missing),
                new Object[] { "dyeCyan" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32426, missing),
                new Object[] { "dyeLightBlue" });
        addShapelessCraftingRecipe(
                getModItem(StructureLib.ID, "item.structurelib.constructableTrigger", 1, 0, missing),
                new Object[] { "dyeBlue", "platePaper", "dyeBlue", "dyeWhite" });

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32752, missing),
                "---------",
                "---------",
                "---aba---",
                "---cdc---",
                "---efe---",
                "---cdc---",
                "---aba---",
                "---------",
                "---------",
                'a',
                "wireGt01SuperconductorMV",
                'b',
                getModItem(NewHorizonsCoreMod.ID, "item.IrradiantReinforcedAluminiumPlate", 1, 0, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32034, missing),
                'd',
                "platePolytetrafluoroethylene",
                'e',
                "circuitAdvanced",
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32751, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32753, missing),
                "---------",
                "----a----",
                "---bcb---",
                "---ded---",
                "---fgf---",
                "---ded---",
                "---bcb---",
                "----a----",
                "---------",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32063, missing),
                'b',
                "wireGt01SuperconductorHV",
                'c',
                getModItem(NewHorizonsCoreMod.ID, "item.IrradiantReinforcedTitaniumPlate", 1, 0, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32034, missing),
                'e',
                "plateEpoxid",
                'f',
                "circuitData",
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32752, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32754, missing),
                "---------",
                "----a----",
                "---bcb---",
                "---ded---",
                "--ffgff--",
                "---ded---",
                "---bcb---",
                "----a----",
                "---------",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32065, missing),
                'b',
                "wireGt01SuperconductorEV",
                'c',
                getModItem(NewHorizonsCoreMod.ID, "item.IrradiantReinforcedTungstenPlate", 1, 0, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32034, missing),
                'e',
                "plateIndiumGalliumPhosphide",
                'f',
                "circuitElite",
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32753, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32755, missing),
                "---------",
                "----a----",
                "--bcdcb--",
                "---efe---",
                "-bgghggb-",
                "---efe---",
                "--bcdcb--",
                "----a----",
                "---------",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32051, missing),
                'b',
                "wireGt01SuperconductorIV",
                'c',
                "plateTripleSiliconSolarGrade",
                'd',
                getModItem(NewHorizonsCoreMod.ID, "item.IrradiantReinforcedTungstenSteelPlate", 1, 0, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32035, missing),
                'f',
                "platePolybenzimidazole",
                'g',
                "circuitMaster",
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32754, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32756, missing),
                "---------",
                "----a----",
                "--bcdcb--",
                "--efgfe--",
                "-bhhihhb-",
                "--efgfe--",
                "--bcdcb--",
                "----a----",
                "---------",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32053, missing),
                'b',
                "wireGt01SuperconductorLuV",
                'c',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32034, missing),
                'd',
                getModItem(NewHorizonsCoreMod.ID, "item.IrradiantReinforcedChromePlate", 1, 0, missing),
                'e',
                "plateQuadrupleSiliconSolarGrade",
                'f',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32035, missing),
                'g',
                "plateDoublePolybenzimidazole",
                'h',
                "circuitUltimate",
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32755, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32757, missing),
                "----a----",
                "---bcb---",
                "--bdedb--",
                "--fghgf--",
                "-icjkjci-",
                "--fghgf--",
                "--bdedb--",
                "---bcb---",
                "----a----",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32059, missing),
                'b',
                "wireGt02SuperconductorZPM",
                'c',
                "circuitUltimate",
                'd',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32035, missing),
                'e',
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 8, missing),
                'f',
                "plateQuintupleSiliconSolarGrade",
                'g',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32151, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 19599, missing),
                'i',
                getModItem(SuperSolarPanels.ID, "solarsplitter", 1, 0, missing),
                'j',
                "circuitSuperconductor",
                'k',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32756, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32758, missing),
                "---aba---",
                "--cadac--",
                "--aefea--",
                "--ghihg--",
                "-fjklkjf-",
                "--ghihg--",
                "--aefea--",
                "--cadac--",
                "---aba---",
                'a',
                "wireGt02SuperconductorUV",
                'b',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32048, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32161, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32164, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32151, missing),
                'f',
                getModItem(NewHorizonsCoreMod.ID, "item.IrradiantReinforcedNaquadriaPlate", 1, 0, missing),
                'g',
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32153, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 20599, missing),
                'j',
                "circuitSuperconductor",
                'k',
                "circuitInfinite",
                'l',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32757, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32759, missing),
                "--abcba--",
                "-daefead-",
                "-agbhbga-",
                "-aibjbia-",
                "ahklmlkha",
                "-aibjbia-",
                "-agbhbga-",
                "-daefead-",
                "--abcba--",
                'a',
                "wireGt02Superconductor",
                'b',
                "plateDenseSiliconSolarGrade",
                'c',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32068, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32163, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.03", 1, 32153, missing),
                'f',
                getModItem(NewHorizonsCoreMod.ID, "item.RawPicoWafer", 1, 0, missing),
                'g',
                getModItem(NewHorizonsCoreMod.ID, "item.PicoWafer", 1, 0, missing),
                'h',
                getModItem(NewHorizonsCoreMod.ID, "item.IrradiantReinforcedNeutroniumPlate", 1, 0, missing),
                'i',
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                'j',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 22599, missing),
                'k',
                "circuitInfinite",
                'l',
                "circuitBio",
                'm',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32758, missing));

        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 2896, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32300, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                null,
                false,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32301, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPlate", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32302, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormCasing", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32303, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormGear", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32304, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormCoinage", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32305, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBottle", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32306, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormIngot", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32307, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBall", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32308, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBlock", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32309, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormNuggets", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32310, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBuns", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32311, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBread", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32312, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBaguette", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32313, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormCylinder", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32314, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormAnvil", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32315, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormName", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32316, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormArrowHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32317, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormSmallGear", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32318, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormStick", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32319, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBolt", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32320, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormRound", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32321, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormScrew", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32322, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormRing", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32323, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormStickLong", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32325, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormTurbineBlade", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32324, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormRotor", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32326, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeTiny", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32327, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeSmall", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32328, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeMedium", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32329, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeLarge", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32330, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeHuge", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32350, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapePlate", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32351, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeRod", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32352, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeBolt", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32354, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeCell", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32353, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeRing", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32355, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeIngot", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32356, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeWire", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32357, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeCasing", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32358, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeTinyPipe", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32359, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeSmallPipe", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32360, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeNormalPipe", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32361, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeLargePipe", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32362, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeHugePipe", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32363, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeBlock", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32364, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeSwordBlade", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32365, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapePickaxeHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32366, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeShovelHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32367, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeAxeHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32368, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeHoeHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32369, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeHammerHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32370, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeFileHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32371, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeSawBlade", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32372, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeGear", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32373, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeBottle", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32374, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeRotor", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32376, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeTurbineBlade", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32375, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeSmallGear", 1, 0, missing),
                true,
                100);

        GT_ModHandler.addSmeltingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2892, missing),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2893, missing));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1246, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 21, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1366, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 22, missing)).noFluidInputs()
                .noFluidOutputs().duration(250).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1426, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 23, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1587, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.blockmachines", 1, 24, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 22032, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlutonium", 3, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemRTGPellet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).noFluidOutputs().duration(1200).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 9, 9057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 27, 9035, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 9, 9057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 2035, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 9, 9057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 11035, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 27, 9035, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2057, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 27, 9035, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11057, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 27, 9035, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 9, 9057, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ThaumicBases.ID, "resource", 9, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "resource", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ThaumicBases.ID, "resource", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32309, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "resource", 9, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2890, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 1890, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 9, 890, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2540, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 0, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2540, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 0, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2540, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2541, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2541, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2541, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2543, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2543, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2543, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2542, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2542, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2542, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2545, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 4, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2545, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 4, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2545, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 4, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2544, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 5, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2544, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 5, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2544, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 5, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.PotassiumHydroxideDust", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 5, 2836, missing))
                .fluidInputs(FluidRegistry.getFluidStack("nitricacid", 5000))
                .fluidOutputs(FluidRegistry.getFluidStack("steam", 16000)).duration(10).eut(30).addTo(sChemicalRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 1, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "toolRod", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 2, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "pickaxeHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 3, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "shovelHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 4, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "hatchetHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 5, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "swordBlade", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 6, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "wideGuard", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 7, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "handGuard", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 8, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "crossbar", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 9, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "binding", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 10, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "frypanHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 11, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "signHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 12, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "knifeBlade", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 13, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "chiselHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 14, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "toughRod", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(3639).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 15, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "toughBinding", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(3639).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 16, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "heavyPlate", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 17, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "broadAxeHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 18, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "scytheBlade", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 19, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "excavatorHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 20, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "largeSwordBlade", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 21, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "hammerHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 22, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "fullGuard", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(3639).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 25, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "arrowhead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "Cast", 0, 0, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "ShurikenPart", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11382, missing),
                        getModItem(TinkerConstruct.ID, "Cast", 0, 1, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(4852).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 11382, missing),
                        getModItem(TinkerConstruct.ID, "Cast", 0, 2, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(6065).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 11382, missing),
                        getModItem(TinkerConstruct.ID, "Cast", 0, 3, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "BowLimbPart", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1820).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 1, 18, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32350, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 17804, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(64).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 23874, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22874, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 23880, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22880, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 23530, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22530, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 23526, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22526, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 23524, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22524, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 23525, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22525, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 23532, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22532, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 23533, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22533, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "flint", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 802, missing)).noFluidInputs()
                .noFluidOutputs().duration(32).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 8890, missing)).noFluidInputs()
                .noFluidOutputs().duration(10).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 27890, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 1890, missing)).noFluidInputs()
                .noFluidOutputs().duration(10).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32304, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "barleyFood", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2881, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "barleyItem", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2881, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "plants", 1, 6, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2881, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "ryeItem", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2881, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "oatsItem", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2881, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockTaint", 1, 2, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 9, 2892, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "walleyerawItem", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2892, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(400).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2890, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 1890, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "glass_shard", 2, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2890, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.blockores", 1, 937, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 4, 5937, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_ModHandler.addSmeltingRecipe(
                getModItem(GregTech.ID, "gt.blockores", 1, 870, missing),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem(GregTech.ID, "gt.blockores", 1, 1870, missing),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem(GregTech.ID, "gt.blockores", 1, 2870, missing),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem(GregTech.ID, "gt.blockores", 1, 3870, missing),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem(GregTech.ID, "gt.blockores", 1, 4870, missing),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing));
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22874, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 24874, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sBenderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 23028, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 23028, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(8).addTo(sBenderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 1, 18, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 17804, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(24).addTo(sBenderRecipes);

    }
}
