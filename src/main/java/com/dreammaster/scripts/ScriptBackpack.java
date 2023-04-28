package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.Mods;

public class ScriptBackpack implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Backpack";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.Backpack.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("Backpack", "boundLeather", 1, 0, missing),
                new Object[] { getModItem("minecraft", "string", 1, 0, missing), "itemLeather",
                        getModItem("minecraft", "string", 1, 0, missing), "itemLeather", "materialCloth", "itemLeather",
                        getModItem("minecraft", "string", 1, 0, missing), "itemLeather",
                        getModItem("minecraft", "string", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 0, missing),
                new Object[] { "materialCloth", "ringSteel", "materialCloth",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "materialCloth",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 1, missing),
                new Object[] { "SmallBackpacks", "dyeBlack",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 2, missing),
                new Object[] { "SmallBackpacks", "dyeRed", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 3, missing),
                new Object[] { "SmallBackpacks", "dyeGreen",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 4, missing),
                new Object[] { "SmallBackpacks", "dyeBrown",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 5, missing),
                new Object[] { "SmallBackpacks", "dyeBlue",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 6, missing),
                new Object[] { "SmallBackpacks", "dyePurple",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 7, missing),
                new Object[] { "SmallBackpacks", "dyeCyan",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 8, missing),
                new Object[] { "SmallBackpacks", "dyeLightGray",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 9, missing),
                new Object[] { "SmallBackpacks", "dyeGray",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 10, missing),
                new Object[] { "SmallBackpacks", "dyePink",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 11, missing),
                new Object[] { "SmallBackpacks", "dyeLime",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 12, missing),
                new Object[] { "SmallBackpacks", "dyeYellow",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 13, missing),
                new Object[] { "SmallBackpacks", "dyeLightBlue",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 14, missing),
                new Object[] { "SmallBackpacks", "dyeMagenta",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 15, missing),
                new Object[] { "SmallBackpacks", "dyeOrange",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 16, missing),
                new Object[] { "SmallBackpacks", "dyeWhite",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 100, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 0, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 101, missing),
                new Object[] { "MediumBackpacks", "dyeBlack",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 101, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 1, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 102, missing),
                new Object[] { "MediumBackpacks", "dyeRed",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 102, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 2, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 103, missing),
                new Object[] { "MediumBackpacks", "dyeGreen",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 103, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 3, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 104, missing),
                new Object[] { "MediumBackpacks", "dyeBrown",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 104, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 4, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 105, missing),
                new Object[] { "MediumBackpacks", "dyeBlue",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 105, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 5, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 106, missing),
                new Object[] { "MediumBackpacks", "dyePurple",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 106, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 6, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 107, missing),
                new Object[] { "MediumBackpacks", "dyeCyan",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 107, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 7, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 108, missing),
                new Object[] { "MediumBackpacks", "dyeLightBlue",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 108, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 8, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 109, missing),
                new Object[] { "MediumBackpacks", "dyeGray",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 109, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 9, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 110, missing),
                new Object[] { "MediumBackpacks", "dyePink",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 110, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 10, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 111, missing),
                new Object[] { "MediumBackpacks", "dyeLime",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 111, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 11, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 112, missing),
                new Object[] { "MediumBackpacks", "dyeYellow",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 112, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 12, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 113, missing),
                new Object[] { "MediumBackpacks", "dyeLightBlue",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 113, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 13, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 114, missing),
                new Object[] { "MediumBackpacks", "dyeMagenta",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 114, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 14, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 115, missing),
                new Object[] { "MediumBackpacks", "dyeOrange",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 115, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 15, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 116, missing),
                new Object[] { "MediumBackpacks", "dyeWhite",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 116, missing),
                new Object[] { "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "ringStainlessSteel", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 16, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "ringStainlessSteel" });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 200, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 100, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 201, missing),
                new Object[] { "BigBackpacks", "dyeBlack", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 201, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 101, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 202, missing),
                new Object[] { "BigBackpacks", "dyeRed", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 202, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 102, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 203, missing),
                new Object[] { "BigBackpacks", "dyeGreen", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 203, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 103, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 204, missing),
                new Object[] { "BigBackpacks", "dyeBrown", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 204, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 104, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 205, missing),
                new Object[] { "BigBackpacks", "dyeBlue", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 205, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 105, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 206, missing),
                new Object[] { "BigBackpacks", "dyePurple",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 206, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 106, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 207, missing),
                new Object[] { "BigBackpacks", "dyeCyan", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 207, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 107, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 208, missing),
                new Object[] { "BigBackpacks", "dyeLightGray",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 208, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 108, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 209, missing),
                new Object[] { "BigBackpacks", "dyeGray", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 209, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 109, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 210, missing),
                new Object[] { "BigBackpacks", "dyePink", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 210, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 110, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 211, missing),
                new Object[] { "BigBackpacks", "dyeLime", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 211, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 111, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 212, missing),
                new Object[] { "BigBackpacks", "dyeYellow",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 212, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 112, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 213, missing),
                new Object[] { "BigBackpacks", "dyeLightBlue",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 213, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 113, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 214, missing),
                new Object[] { "BigBackpacks", "dyeMagenta",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 214, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 114, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 215, missing),
                new Object[] { "BigBackpacks", "dyeOrange",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 215, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 115, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapelessCraftingRecipe(
                getModItem("Backpack", "backpack", 1, 216, missing),
                new Object[] { "BigBackpacks", "dyeWhite", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "backpack", 1, 216, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 116, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium" });
        addShapedRecipe(
                getModItem("Backpack", "workbenchbackpack", 1, 17, missing),
                new Object[] { "materialCloth", "ringSteel", "materialCloth",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "materialCloth",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        getModItem("TConstruct", "CraftingSlab", 1, 0, missing),
                        getModItem("Backpack", "tannedLeather", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Backpack", "workbenchbackpack", 1, 217, missing),
                new Object[] { "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "ringTitanium", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Backpack", "backpack", 1, 100, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringTitanium",
                        getModItem("TConstruct", "CraftingSlab", 1, 0, missing), "ringTitanium" });

    }
}
