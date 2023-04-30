package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

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
        return Arrays.asList("structurelib");
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("gregtech", "gt.blockmachines", 1, 1145, missing),
                new Object[] { "circuitOptical", getModItem("SGCraft", "ic2PowerUnit", 1, 0, missing), "circuitOptical",
                        getModItem("SGCraft", "ic2Capacitor", 1, 0, missing),
                        getModItem("SGCraft", "stargateBase", 1, 0, missing),
                        getModItem("SGCraft", "ic2Capacitor", 1, 0, missing),
                        getModItem("SGCraft", "ic2Capacitor", 1, 0, missing),
                        getModItem("SGCraft", "ocInterface", 1, 0, missing),
                        getModItem("SGCraft", "ic2Capacitor", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 500, missing),
                new Object[] { null, getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), null,
                        "craftingToolFile", getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        "craftingToolHardHammer", null, null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 1500, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), "gemDiamond", "gemDiamond",
                        "craftingToolFile", null, "craftingToolHardHammer", null, null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 2500, missing),
                new Object[] { "craftingToolFile", getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        "craftingToolHardHammer", null, null, null, null, null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 3500, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), "gemDiamond",
                        "craftingToolHardHammer", getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), null,
                        null, "craftingToolFile", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 4500, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), "gemDiamond",
                        "craftingToolHardHammer", "craftingToolFile", null, null, null, null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 28809, missing),
                new Object[] { "craftingToolKnife", null, null, null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), null });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2890, missing),
                new Object[] { "craftingToolMortar", getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 1890, missing),
                new Object[] { "craftingToolMortar", getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2892, missing),
                new Object[] { "craftingToolMortar", "listAllmeatraw" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2892, missing),
                new Object[] { "craftingToolMortar", "listAllfishraw" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "sugar", 4, 0, missing),
                new Object[] { "craftingToolMortar", getModItem("berriespp", "foodBerries", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2893, missing),
                new Object[] { "craftingToolMortar", "listAllmeatcooked" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2893, missing),
                new Object[] { "craftingToolMortar", "listAllfishcooked" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing),
                new Object[] { "craftingToolMortar", "logWood" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 1625, missing),
                new Object[] { "craftingToolMortar", getModItem("minecraft", "brick", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 22874, missing),
                new Object[] { "stickPlastic", "craftingToolHardHammer", "stickPlastic" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2881, missing),
                new Object[] { "cropBarley", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2881, missing),
                new Object[] { "cropWheat", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2881, missing),
                new Object[] { "cropRye", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2881, missing),
                new Object[] { "cropOats", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2817, missing),
                new Object[] { getModItem("gregtech", "gt.blockores", 1, 817, missing), null, null,
                        "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2817, missing),
                new Object[] { getModItem("gregtech", "gt.blockores", 1, 1817, missing), null, null,
                        "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2817, missing),
                new Object[] { getModItem("gregtech", "gt.blockores", 1, 2817, missing), null, null,
                        "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2817, missing),
                new Object[] { getModItem("gregtech", "gt.blockores", 1, 3817, missing), null, null,
                        "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2817, missing),
                new Object[] { getModItem("gregtech", "gt.blockores", 1, 4817, missing), null, null,
                        "craftingToolMortar", null, null });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 1805, missing),
                new Object[] { "craftingToolMortar", getModItem("minecraft", "clay_ball", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32, missing),
                new Object[] { "nuggetIron", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 86, missing),
                new Object[] { "nuggetGold", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 35, missing),
                new Object[] { "nuggetCopper", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 57, missing),
                new Object[] { "nuggetTin", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 54, missing),
                new Object[] { "nuggetSilver", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 89, missing),
                new Object[] { "nuggetLead", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 36, missing),
                new Object[] { "nuggetZinc", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 34, missing),
                new Object[] { "nuggetNickel", null, null, "craftingToolMortar", null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockcasings2", 1, 11, missing),
                new Object[] { "itemCasingStainlessSteel", "circuitAdvanced", "itemCasingStainlessSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing),
                        getModItem("gregtech", "gt.blockcasings2", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing), "itemCasingStainlessSteel",
                        "circuitAdvanced", "itemCasingStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32750, missing),
                new Object[] { getModItem("ProjRed|Expansion", "projectred.expansion.solar_panel", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.blockmachines", 1, 2000, missing),
                new Object[] { getModItem("ProjRed|Transmission", "projectred.transmission.wire", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 22880, missing),
                new Object[] { "stickRubber", "craftingToolHardHammer", "stickRubber" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 22530, missing),
                new Object[] { "stickApatite", "craftingToolHardHammer", "stickApatite" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 22526, missing),
                new Object[] { "stickLapis", "craftingToolHardHammer", "stickLapis" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 22524, missing),
                new Object[] { "stickLazurite", "craftingToolHardHammer", "stickLazurite" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 22525, missing),
                new Object[] { "stickSodalite", "craftingToolHardHammer", "stickSodalite" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 22532, missing),
                new Object[] { "stickEnderPearl", "craftingToolHardHammer", "stickEnderPearl" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 22533, missing),
                new Object[] { "stickEnderEye", "craftingToolHardHammer", "stickEnderEye" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.blockmachines", 2, 4905, missing),
                new Object[] { getModItem("MCFrames", "mcframes.frame", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.blockmachines", 1, 4905, missing),
                new Object[] { getModItem("OpenBlocks", "scaffolding", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 1890, missing),
                new Object[] { "craftingToolMortar", getModItem("BloodArsenal", "glass_shard", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 2, 2322, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 2305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1047, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1345, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1034, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1029, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1030, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1048, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1028, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockcasings2", 1, 10, missing),
                new Object[] { "itemCasingStainlessSteel", "circuitAdvanced", "itemCasingStainlessSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing),
                        getModItem("gregtech", "gt.blockcasings2", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing), "itemCasingStainlessSteel",
                        "circuitAdvanced", "itemCasingStainlessSteel" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 20849, missing),
                new Object[] { "stoneGraniteBlack", null, null, null, "craftingToolFile", null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 20850, missing),
                new Object[] { "stoneGraniteRed", null, null, null, "craftingToolFile", null });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockcasings2", 1, 6, missing),
                new Object[] { "itemCasingStainlessSteel", "circuitElite", "itemCasingStainlessSteel", "circuitElite",
                        getModItem("gregtech", "gt.blockcasings2", 1, 0, missing), "circuitElite",
                        "itemCasingStainlessSteel", "circuitElite", "itemCasingStainlessSteel" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 17804, missing),
                new Object[] { "craftingToolHardHammer", null, null, "ingotObsidian", null, null, "ingotObsidian", null,
                        null });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockstones", 1, 2, missing),
                new Object[] { getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("gregtech", "gt.blockstones", 1, 1, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockstones", 1, 5, missing),
                new Object[] { getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("gregtech", "gt.blockstones", 1, 3, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockconcretes", 1, 10, missing),
                new Object[] { getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("gregtech", "gt.blockconcretes", 1, 9, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockconcretes", 1, 13, missing),
                new Object[] { getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("gregtech", "gt.blockconcretes", 1, 11, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockstones", 1, 10, missing),
                new Object[] { getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("gregtech", "gt.blockstones", 1, 9, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockstones", 1, 13, missing),
                new Object[] { getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("gregtech", "gt.blockstones", 1, 11, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockgranites", 1, 2, missing),
                new Object[] { getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("gregtech", "gt.blockgranites", 1, 1, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockgranites", 1, 5, missing),
                new Object[] { getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("gregtech", "gt.blockgranites", 1, 3, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockgranites", 1, 10, missing),
                new Object[] { getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("gregtech", "gt.blockgranites", 1, 9, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.blockgranites", 1, 13, missing),
                new Object[] { getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("gregtech", "gt.blockgranites", 1, 11, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32417, missing),
                new Object[] { "dyeBrown" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32421, missing),
                new Object[] { "dyeLightGray" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32425, missing),
                new Object[] { "dyeYellow" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32429, missing),
                new Object[] { "dyeWhite" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32418, missing),
                new Object[] { "dyeBlue" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32422, missing),
                new Object[] { "dyeGray" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32424, missing),
                new Object[] { "dyeLime" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32428, missing),
                new Object[] { "dyeOrange" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32415, missing),
                new Object[] { "dyeRed" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32419, missing),
                new Object[] { "dyePurple" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32423, missing),
                new Object[] { "dyePink" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32427, missing),
                new Object[] { "dyeMagenta" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32414, missing),
                new Object[] { "dyeBlack" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32416, missing),
                new Object[] { "dyeGreen" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32420, missing),
                new Object[] { "dyeCyan" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32426, missing),
                new Object[] { "dyeLightBlue" });
        addShapelessCraftingRecipe(
                getModItem("structurelib", "item.structurelib.constructableTrigger", 1, 0, missing),
                new Object[] { "dyeBlue", "platePaper", "dyeBlue", "dyeWhite" });

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32752, missing),
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
                getModItem("dreamcraft", "item.IrradiantReinforcedAluminiumPlate", 1, 0, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.03", 1, 32034, missing),
                'd',
                "platePolytetrafluoroethylene",
                'e',
                "circuitAdvanced",
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32751, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32753, missing),
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
                getModItem("gregtech", "gt.metaitem.03", 1, 32063, missing),
                'b',
                "wireGt01SuperconductorHV",
                'c',
                getModItem("dreamcraft", "item.IrradiantReinforcedTitaniumPlate", 1, 0, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.03", 1, 32034, missing),
                'e',
                "plateEpoxid",
                'f',
                "circuitData",
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 32752, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32754, missing),
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
                getModItem("gregtech", "gt.metaitem.03", 1, 32065, missing),
                'b',
                "wireGt01SuperconductorEV",
                'c',
                getModItem("dreamcraft", "item.IrradiantReinforcedTungstenPlate", 1, 0, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.03", 1, 32034, missing),
                'e',
                "plateIndiumGalliumPhosphide",
                'f',
                "circuitElite",
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 32753, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32755, missing),
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
                getModItem("gregtech", "gt.metaitem.03", 1, 32051, missing),
                'b',
                "wireGt01SuperconductorIV",
                'c',
                "plateTripleSiliconSolarGrade",
                'd',
                getModItem("dreamcraft", "item.IrradiantReinforcedTungstenSteelPlate", 1, 0, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.03", 1, 32035, missing),
                'f',
                "platePolybenzimidazole",
                'g',
                "circuitMaster",
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 32754, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32756, missing),
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
                getModItem("gregtech", "gt.metaitem.03", 1, 32053, missing),
                'b',
                "wireGt01SuperconductorLuV",
                'c',
                getModItem("gregtech", "gt.metaitem.03", 1, 32034, missing),
                'd',
                getModItem("dreamcraft", "item.IrradiantReinforcedChromePlate", 1, 0, missing),
                'e',
                "plateQuadrupleSiliconSolarGrade",
                'f',
                getModItem("gregtech", "gt.metaitem.03", 1, 32035, missing),
                'g',
                "plateDoublePolybenzimidazole",
                'h',
                "circuitUltimate",
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 32755, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32757, missing),
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
                getModItem("gregtech", "gt.metaitem.03", 1, 32059, missing),
                'b',
                "wireGt02SuperconductorZPM",
                'c',
                "circuitUltimate",
                'd',
                getModItem("gregtech", "gt.metaitem.03", 1, 32035, missing),
                'e',
                getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 8, missing),
                'f',
                "plateQuintupleSiliconSolarGrade",
                'g',
                getModItem("gregtech", "gt.metaitem.03", 1, 32151, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 19599, missing),
                'i',
                getModItem("supersolarpanel", "solarsplitter", 1, 0, missing),
                'j',
                "circuitSuperconductor",
                'k',
                getModItem("gregtech", "gt.metaitem.01", 1, 32756, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32758, missing),
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
                getModItem("gregtech", "gt.metaitem.03", 1, 32048, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.03", 1, 32161, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.03", 1, 32164, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.03", 1, 32151, missing),
                'f',
                getModItem("dreamcraft", "item.IrradiantReinforcedNaquadriaPlate", 1, 0, missing),
                'g',
                getModItem("IC2", "itemPartCarbonPlate", 1, 0, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.03", 1, 32153, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 20599, missing),
                'j',
                "circuitSuperconductor",
                'k',
                "circuitInfinite",
                'l',
                getModItem("gregtech", "gt.metaitem.01", 1, 32757, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32759, missing),
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
                getModItem("gregtech", "gt.metaitem.03", 1, 32068, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.03", 1, 32163, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.03", 1, 32153, missing),
                'f',
                getModItem("dreamcraft", "item.RawPicoWafer", 1, 0, missing),
                'g',
                getModItem("dreamcraft", "item.PicoWafer", 1, 0, missing),
                'h',
                getModItem("dreamcraft", "item.IrradiantReinforcedNeutroniumPlate", 1, 0, missing),
                'i',
                getModItem("IC2", "itemPartCarbonPlate", 1, 0, missing),
                'j',
                getModItem("gregtech", "gt.metaitem.01", 1, 22599, missing),
                'k',
                "circuitInfinite",
                'l',
                "circuitBio",
                'm',
                getModItem("gregtech", "gt.metaitem.01", 1, 32758, missing));

        GT_Values.RA.stdBuilder().itemInputs(getModItem("TConstruct", "strangeFood", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 2, 2896, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32300, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                null,
                false,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32301, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormPlate", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32302, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormCasing", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32303, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormGear", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32304, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormCoinage", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32305, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormBottle", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32306, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormIngot", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32307, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormBall", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32308, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormBlock", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32309, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormNuggets", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32310, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormBuns", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32311, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormBread", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32312, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormBaguette", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32313, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormCylinder", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32314, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormAnvil", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32315, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormName", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32316, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormArrowHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32317, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormSmallGear", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32318, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormStick", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32319, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormBolt", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32320, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormRound", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32321, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormScrew", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32322, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormRing", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32323, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormStickLong", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32325, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormTurbineBlade", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32324, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormRotor", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32326, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormPipeTiny", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32327, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormPipeSmall", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32328, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormPipeMedium", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32329, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormPipeLarge", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32330, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldFormPipeHuge", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32350, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapePlate", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32351, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeRod", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32352, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeBolt", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32354, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeCell", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32353, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeRing", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32355, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeIngot", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32356, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeWire", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32357, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeCasing", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32358, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeTinyPipe", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32359, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeSmallPipe", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32360, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeNormalPipe", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32361, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeLargePipe", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32362, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeHugePipe", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32363, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeBlock", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32364, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeSwordBlade", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32365, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapePickaxeHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32366, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeShovelHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32367, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeAxeHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32368, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeHoeHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32369, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeHammerHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32370, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeFileHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32371, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeSawBlade", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32372, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeGear", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32373, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeBottle", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32374, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeRotor", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32376, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeTurbineBlade", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32375, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.ShapeSmallGear", 1, 0, missing),
                true,
                100);

        GT_ModHandler.addSmeltingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2892, missing),
                getModItem("gregtech", "gt.metaitem.01", 1, 2893, missing));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockElectric", 1, 3, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1246, missing))
                .itemOutputs(getModItem("gregtech", "gt.blockmachines", 1, 21, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockElectric", 1, 4, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1366, missing))
                .itemOutputs(getModItem("gregtech", "gt.blockmachines", 1, 22, missing)).noFluidInputs()
                .noFluidOutputs().duration(250).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockElectric", 1, 5, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1426, missing))
                .itemOutputs(getModItem("gregtech", "gt.blockmachines", 1, 23, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockElectric", 1, 6, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1587, missing))
                .itemOutputs(getModItem("gregtech", "gt.blockmachines", 1, 24, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 22032, missing),
                        getModItem("IC2", "itemPlutonium", 3, 0, missing))
                .itemOutputs(getModItem("IC2", "itemRTGPellet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).noFluidOutputs().duration(1200).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 9, 9057, missing),
                        getModItem("gregtech", "gt.metaitem.01", 27, 9035, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 9, 9057, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 2035, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 9, 9057, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 11035, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 27, 9035, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2057, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 27, 9035, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 11057, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 27, 9035, missing),
                        getModItem("gregtech", "gt.metaitem.01", 9, 9057, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("thaumicbases", "resource", 9, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem("thaumicbases", "resource", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("thaumicbases", "resource", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32309, missing))
                .itemOutputs(getModItem("thaumicbases", "resource", 9, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 2890, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem("minecraft", "glass", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 1890, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem("minecraft", "glass", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 9, 890, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem("minecraft", "glass", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2540, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 0, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2540, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 0, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2540, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2541, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 1, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2541, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 1, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2541, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 1, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2543, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 2, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2543, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 2, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2543, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 2, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2542, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 3, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2542, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 3, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2542, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 3, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2545, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 4, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2545, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 4, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2545, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 4, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2544, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 5, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2544, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 5, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 2544, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemShard", 1, 5, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.PotassiumHydroxideDust", 3, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 5, 2836, missing))
                .fluidInputs(FluidRegistry.getFluidStack("nitricacid", 5000))
                .fluidOutputs(FluidRegistry.getFluidStack("steam", 16000)).duration(10).eut(30).addTo(sChemicalRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 1, missing))
                .itemOutputs(getModItem("TConstruct", "toolRod", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 2, missing))
                .itemOutputs(getModItem("TConstruct", "pickaxeHead", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 3, missing))
                .itemOutputs(getModItem("TConstruct", "shovelHead", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 4, missing))
                .itemOutputs(getModItem("TConstruct", "hatchetHead", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 5, missing))
                .itemOutputs(getModItem("TConstruct", "swordBlade", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 6, missing))
                .itemOutputs(getModItem("TConstruct", "wideGuard", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 7, missing))
                .itemOutputs(getModItem("TConstruct", "handGuard", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 8, missing))
                .itemOutputs(getModItem("TConstruct", "crossbar", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 9, missing))
                .itemOutputs(getModItem("TConstruct", "binding", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 10, missing))
                .itemOutputs(getModItem("TConstruct", "frypanHead", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 11, missing))
                .itemOutputs(getModItem("TConstruct", "signHead", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 12, missing))
                .itemOutputs(getModItem("TConstruct", "knifeBlade", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 13, missing))
                .itemOutputs(getModItem("TConstruct", "chiselHead", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 3, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 14, missing))
                .itemOutputs(getModItem("TConstruct", "toughRod", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(3639).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 3, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 15, missing))
                .itemOutputs(getModItem("TConstruct", "toughBinding", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(3639).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 8, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 16, missing))
                .itemOutputs(getModItem("TConstruct", "heavyPlate", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 8, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 17, missing))
                .itemOutputs(getModItem("TConstruct", "broadAxeHead", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 8, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 18, missing))
                .itemOutputs(getModItem("TConstruct", "scytheBlade", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 8, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 19, missing))
                .itemOutputs(getModItem("TConstruct", "excavatorHead", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 8, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 20, missing))
                .itemOutputs(getModItem("TConstruct", "largeSwordBlade", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 8, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 21, missing))
                .itemOutputs(getModItem("TConstruct", "hammerHead", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 3, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 22, missing))
                .itemOutputs(getModItem("TConstruct", "fullGuard", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(3639).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11382, missing),
                        getModItem("TConstruct", "metalPattern", 0, 25, missing))
                .itemOutputs(getModItem("TConstruct", "arrowhead", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11382, missing),
                        getModItem("TConstruct", "Cast", 0, 0, missing))
                .itemOutputs(getModItem("TConstruct", "ShurikenPart", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 11382, missing),
                        getModItem("TConstruct", "Cast", 0, 1, missing))
                .itemOutputs(getModItem("TConstruct", "CrossbowLimbPart", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(4852).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 5, 11382, missing),
                        getModItem("TConstruct", "Cast", 0, 2, missing))
                .itemOutputs(getModItem("TConstruct", "CrossbowBodyPart", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(6065).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 11382, missing),
                        getModItem("TConstruct", "Cast", 0, 3, missing))
                .itemOutputs(getModItem("TConstruct", "BowLimbPart", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(1820).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "materials", 1, 18, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32350, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 17804, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(64).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 2, 23874, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 1, 22874, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 2, 23880, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 1, 22880, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 2, 23530, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 1, 22530, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 2, 23526, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 1, 22526, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 2, 23524, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 1, 22524, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 2, 23525, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 1, 22525, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 2, 23532, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 1, 22532, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 2, 23533, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 1, 22533, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "flint", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 2, 802, missing)).noFluidInputs().noFluidOutputs()
                .duration(32).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("TConstruct", "GlassBlock", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 8890, missing)).noFluidInputs()
                .noFluidOutputs().duration(10).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.02", 1, 27890, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 1890, missing)).noFluidInputs()
                .noFluidOutputs().duration(10).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32304, missing))
                .itemOutputs(getModItem("dreamcraft", "item.CoinBlank", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "barleyFood", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 2881, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("harvestcraft", "barleyItem", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 2881, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "plants", 1, 6, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 2881, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("harvestcraft", "ryeItem", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 2881, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("harvestcraft", "oatsItem", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 2881, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Thaumcraft", "blockTaint", 1, 2, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 9, 2892, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("harvestcraft", "walleyerawItem", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 2892, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(400).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("TConstruct", "GlassBlock", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 2890, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("TConstruct", "GlassPane", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 1890, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BloodArsenal", "glass_shard", 2, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 2890, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.blockores", 1, 937, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 4, 5937, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_ModHandler.addSmeltingRecipe(
                getModItem("gregtech", "gt.blockores", 1, 870, missing),
                getModItem("minecraft", "iron_ingot", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem("gregtech", "gt.blockores", 1, 1870, missing),
                getModItem("minecraft", "iron_ingot", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem("gregtech", "gt.blockores", 1, 2870, missing),
                getModItem("minecraft", "iron_ingot", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem("gregtech", "gt.blockores", 1, 3870, missing),
                getModItem("minecraft", "iron_ingot", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem("gregtech", "gt.blockores", 1, 4870, missing),
                getModItem("minecraft", "iron_ingot", 1, 0, missing));
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.02", 1, 22874, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 1, 24874, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sBenderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 1, 23028, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 1, 23028, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(8).addTo(sBenderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("TConstruct", "materials", 1, 18, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 1, 17804, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(24).addTo(sBenderRecipes);

    }
}
