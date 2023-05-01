package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.oredict.OreDictionary;

import tconstruct.library.crafting.DryingRackRecipes;

public class ScriptBackpack implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Backpack";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Backpack.ID, ExtraUtilities.ID, PamsHarvestCraft.ID, TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {

        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 0, missing));
        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 1, missing));
        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 2, missing));
        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 3, missing));
        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 4, missing));
        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 5, missing));
        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 6, missing));
        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 7, missing));
        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 8, missing));
        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 9, missing));
        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 10, missing));
        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 11, missing));
        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 12, missing));
        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 13, missing));
        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 14, missing));
        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 15, missing));
        OreDictionary.registerOre("SmallBackpacks", getModItem(Backpack.ID, "backpack", 1, 16, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 100, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 101, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 102, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 103, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 104, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 105, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 106, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 107, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 108, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 109, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 110, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 111, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 112, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 113, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 114, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 115, missing));
        OreDictionary.registerOre("MediumBackpacks", getModItem(Backpack.ID, "backpack", 1, 116, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 200, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 201, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 202, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 203, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 204, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 205, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 206, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 207, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 208, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 209, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 210, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 211, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 212, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 213, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 214, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 215, missing));
        OreDictionary.registerOre("BigBackpacks", getModItem(Backpack.ID, "backpack", 1, 216, missing));

        addShapedRecipe(
                getModItem(Backpack.ID, "boundLeather", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "string", 1, 0, missing), "itemLeather",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "itemLeather", "materialCloth",
                        "itemLeather", getModItem(Minecraft.ID, "string", 1, 0, missing), "itemLeather",
                        getModItem(Minecraft.ID, "string", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 0, missing),
                new Object[] { "materialCloth", "ringSteel", "materialCloth",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "materialCloth",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 1, missing),
                new Object[] { "SmallBackpacks", "dyeBlack",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 2, missing),
                new Object[] { "SmallBackpacks", "dyeRed",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 3, missing),
                new Object[] { "SmallBackpacks", "dyeGreen",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 4, missing),
                new Object[] { "SmallBackpacks", "dyeBrown",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 5, missing),
                new Object[] { "SmallBackpacks", "dyeBlue",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 6, missing),
                new Object[] { "SmallBackpacks", "dyePurple",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 7, missing),
                new Object[] { "SmallBackpacks", "dyeCyan",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 8, missing),
                new Object[] { "SmallBackpacks", "dyeLightGray",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 9, missing),
                new Object[] { "SmallBackpacks", "dyeGray",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 10, missing),
                new Object[] { "SmallBackpacks", "dyePink",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 11, missing),
                new Object[] { "SmallBackpacks", "dyeLime",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 12, missing),
                new Object[] { "SmallBackpacks", "dyeYellow",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 13, missing),
                new Object[] { "SmallBackpacks", "dyeLightBlue",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 14, missing),
                new Object[] { "SmallBackpacks", "dyeMagenta",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 15, missing),
                new Object[] { "SmallBackpacks", "dyeOrange",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 16, missing),
                new Object[] { "SmallBackpacks", "dyeWhite",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 100, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 0, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 101, missing),
                new Object[] { "MediumBackpacks", "dyeBlack",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 101, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 1, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 102, missing),
                new Object[] { "MediumBackpacks", "dyeRed",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 102, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 2, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 103, missing),
                new Object[] { "MediumBackpacks", "dyeGreen",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 103, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 3, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 104, missing),
                new Object[] { "MediumBackpacks", "dyeBrown",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 104, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 4, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 105, missing),
                new Object[] { "MediumBackpacks", "dyeBlue",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 105, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 5, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 106, missing),
                new Object[] { "MediumBackpacks", "dyePurple",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 106, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 6, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 107, missing),
                new Object[] { "MediumBackpacks", "dyeCyan",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 107, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 7, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 108, missing),
                new Object[] { "MediumBackpacks", "dyeLightBlue",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 108, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 8, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 109, missing),
                new Object[] { "MediumBackpacks", "dyeGray",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 109, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 9, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 110, missing),
                new Object[] { "MediumBackpacks", "dyePink",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 110, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 10, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 111, missing),
                new Object[] { "MediumBackpacks", "dyeLime",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 111, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 11, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 112, missing),
                new Object[] { "MediumBackpacks", "dyeYellow",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 112, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 12, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 113, missing),
                new Object[] { "MediumBackpacks", "dyeLightBlue",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 113, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 13, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 114, missing),
                new Object[] { "MediumBackpacks", "dyeMagenta",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 114, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 14, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 115, missing),
                new Object[] { "MediumBackpacks", "dyeOrange",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 115, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 15, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 116, missing),
                new Object[] { "MediumBackpacks", "dyeWhite",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 116, missing),
                new Object[] { "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 16, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 200, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 100, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 201, missing),
                new Object[] { "BigBackpacks", "dyeBlack",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 201, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 101, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 202, missing),
                new Object[] { "BigBackpacks", "dyeRed", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 202, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 102, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 203, missing),
                new Object[] { "BigBackpacks", "dyeGreen",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 203, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 103, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 204, missing),
                new Object[] { "BigBackpacks", "dyeBrown",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 204, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 104, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 205, missing),
                new Object[] { "BigBackpacks", "dyeBlue", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 205, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 105, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 206, missing),
                new Object[] { "BigBackpacks", "dyePurple",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 206, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 106, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 207, missing),
                new Object[] { "BigBackpacks", "dyeCyan", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 207, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 107, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 208, missing),
                new Object[] { "BigBackpacks", "dyeLightGray",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 208, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 108, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 209, missing),
                new Object[] { "BigBackpacks", "dyeGray", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 209, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 109, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 210, missing),
                new Object[] { "BigBackpacks", "dyePink", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 210, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 110, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 211, missing),
                new Object[] { "BigBackpacks", "dyeLime", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 211, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 111, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 212, missing),
                new Object[] { "BigBackpacks", "dyeYellow",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 212, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 112, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 213, missing),
                new Object[] { "BigBackpacks", "dyeLightBlue",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 213, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 113, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 214, missing),
                new Object[] { "BigBackpacks", "dyeMagenta",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 214, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 114, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 215, missing),
                new Object[] { "BigBackpacks", "dyeOrange",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 215, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 115, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem(Backpack.ID, "backpack", 1, 216, missing),
                new Object[] { "BigBackpacks", "dyeWhite",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "backpack", 1, 216, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 116, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapedRecipe(
                getModItem(Backpack.ID, "workbenchbackpack", 1, 17, missing),
                new Object[] { "materialCloth", "ringSteel", "materialCloth",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "materialCloth",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 0, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Backpack.ID, "workbenchbackpack", 1, 217, missing),
                new Object[] { "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(Backpack.ID, "backpack", 1, 100, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 0, missing), "ringTitanium" });

        DryingRackRecipes.addDryingRecipe(
                getModItem(Backpack.ID, "boundLeather", 1, 0, missing),
                12000,
                getModItem(Backpack.ID, "tannedLeather", 1, 0, missing));

    }
}
