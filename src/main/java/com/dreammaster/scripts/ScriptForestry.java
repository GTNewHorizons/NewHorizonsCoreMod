package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptForestry implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Forestry";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.Forestry.ID, Mods.Thaumcraft.ID, Mods.MagicBees.ID);
    }

    @Override
    public void loadRecipes() {

        addShapedRecipe(
                getModItem("Forestry", "sturdyMachine", 1, 0, missing),
                new Object[] { "itemCasingBronze", "screwSteel", "itemCasingBronze", "screwSteel",
                        getModItem("gregtech", "gt.blockcasings", 1, 1, missing), "screwSteel", "itemCasingBronze",
                        "screwSteel", "itemCasingBronze" });
        addShapedRecipe(
                getModItem("Forestry", "core", 1, 0, missing),
                new Object[] { getModItem("Forestry", "treealyzer", 1, 0, missing),
                        getModItem("Forestry", "beealyzer", 1, 0, missing),
                        getModItem("Forestry", "flutterlyzer", 1, 0, missing),
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        getModItem("Forestry", "sturdyMachine", 1, 0, missing),
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing), "circuitBasic",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "circuitBasic" });
        addShapedRecipe(
                getModItem("Forestry", "factory", 1, 0, missing),
                new Object[] { "plateCupronickel", getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        "plateCupronickel", "ringAnyRubber", getModItem("Forestry", "sturdyMachine", 1, 0, missing),
                        "ringAnyRubber", "gearGtSmallSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem("Forestry", "factory", 1, 1, missing),
                new Object[] { "plateCupronickel", getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        "plateCupronickel", getModItem("gregtech", "gt.metaitem.01", 1, 32650, missing),
                        getModItem("Forestry", "sturdyMachine", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32650, missing), "gearGtSmallSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem("Forestry", "factory", 1, 2, missing),
                new Object[] { "plateCupronickel", getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                        "plateCupronickel", getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                        getModItem("Forestry", "sturdyMachine", 1, 0, missing),
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing), "gearGtSmallSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem("Forestry", "factory", 1, 3, missing),
                new Object[] { "plateCupronickel", getModItem("gregtech", "gt.metaitem.02", 1, 21057, missing),
                        "plateCupronickel", getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        getModItem("Forestry", "sturdyMachine", 1, 0, missing),
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing), "gearGtSmallSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem("Forestry", "factory", 1, 4, missing),
                new Object[] { "plateCupronickel", getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        "plateCupronickel", getModItem("gregtech", "gt.metaitem.02", 1, 21057, missing),
                        getModItem("Forestry", "sturdyMachine", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 21057, missing), "gearGtSmallSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem("Forestry", "factory", 1, 5, missing),
                new Object[] { "plateCupronickel", getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        "plateCupronickel", getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        getModItem("Forestry", "sturdyMachine", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing), "gearGtSmallSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem("Forestry", "factory", 1, 6, missing),
                new Object[] { "plateCupronickel", getModItem("IC2", "itemRecipePart", 1, 0, missing),
                        "plateCupronickel", getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        getModItem("Forestry", "sturdyMachine", 1, 0, missing),
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing), "gearGtSmallSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem("Forestry", "factory", 1, 7, missing),
                new Object[] { "plateCupronickel", getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        "plateCupronickel", getModItem("gregtech", "gt.metaitem.01", 1, 32641, missing),
                        getModItem("Forestry", "hardenedMachine", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32641, missing), "gearGtSmallAluminium",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing), "gearGtSmallAluminium" });
        addShapedRecipe(
                getModItem("Forestry", "factory2", 1, 1, missing),
                new Object[] { "plateIron", "ringIron", "plateIron", "plateIron", "craftingToolHardHammer", "plateIron",
                        "plateIron", "ringIron", "plateIron" });
        addShapedRecipe(
                getModItem("Forestry", "factory2", 1, 2, missing),
                new Object[] { "screwIron", getModItem("minecraft", "bookshelf", 1, 0, missing), "screwIron",
                        "craftingToolSaw", getModItem("minecraft", "crafting_table", 1, 0, missing),
                        "craftingToolScrewdriver", "screwIron", getModItem("minecraft", "chest", 1, 0, missing),
                        "screwIron" });
        addShapedRecipe(
                getModItem("Forestry", "factory2", 1, 2, missing),
                new Object[] { "screwIron", getModItem("minecraft", "bookshelf", 1, 0, missing), "screwIron",
                        "craftingToolSaw", getModItem("TConstruct", "CraftingStation", 1, 0, missing),
                        "craftingToolScrewdriver", "screwIron", getModItem("minecraft", "chest", 1, 0, missing),
                        "screwIron" });
        addShapedRecipe(
                getModItem("Forestry", "mail", 1, 0, missing),
                new Object[] { "plateIron", getModItem("minecraft", "iron_bars", 1, 0, missing), "plateIron", "dyeBlue",
                        getModItem("IC2", "blockMachine", 1, 0, missing), "dyeBlue", "gearGtSmallBronze", "chestWood",
                        "gearGtSmallBronze" });
        addShapedRecipe(
                getModItem("Forestry", "mail", 1, 1, missing),
                new Object[] { getModItem("Forestry", "thermionicTubes", 1, 9, missing),
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                        getModItem("Forestry", "thermionicTubes", 1, 9, missing), "plateSteel",
                        getModItem("Forestry", "sturdyMachine", 1, 0, missing), "plateSteel", "gearGtSmallSteel",
                        "circuitBasic", "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem("Forestry", "engine", 1, 3, missing),
                new Object[] { "plateCupronickel", getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        "plateCupronickel", "circuitBasic", getModItem("Forestry", "sturdyMachine", 1, 0, missing),
                        "circuitBasic", "gearGtSmallSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                        "gearGtSmallSteel" });
        addShapedRecipe(
                getModItem("Forestry", "apiculture", 1, 2, missing),
                new Object[] { "slabWood", "slabWood", "slabWood",
                        getModItem("Forestry", "frameUntreated", 1, 0, missing),
                        getModItem("dreamcraft", "item.WoodenCasing", 1, 0, missing),
                        getModItem("Forestry", "frameUntreated", 1, 0, missing), "beeComb", "slabWood", "beeComb" });
        addShapelessCraftingRecipe(
                getModItem("Forestry", "apiculture", 1, 2, missing),
                new Object[] { getModItem("harvestcraft", "apiary", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Forestry", "beealyzer", 1, 0, missing),
                new Object[] { getModItem("Forestry", "beealyzer", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Forestry", "treealyzer", 1, 0, missing),
                new Object[] { getModItem("Forestry", "treealyzer", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Forestry", "flutterlyzer", 1, 0, missing),
                new Object[] { getModItem("Forestry", "flutterlyzer", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Forestry", "infuser", 1, 0, missing),
                new Object[] { null, "stickBronze", null, null, "stickIron", null, "craftingToolHardHammer",
                        getModItem("minecraft", "iron_bars", 1, 0, missing), "craftingToolFile" });
        addShapedRecipe(
                getModItem("Forestry", "pipette", 1, 0, missing),
                new Object[] { null, "plateAnyRubber", "plateAnyRubber", null, "cellEmpty", "plateAnyRubber",
                        "boltGlass", null, null });
        addShapedRecipe(
                getModItem("Forestry", "naturalistHelmet", 1, 0, missing),
                new Object[] { "screwIron", "ringIron", "screwIron", "lensGlass", null, "lensGlass", null, null,
                        null });
        addShapedRecipe(
                getModItem("Forestry", "frameUntreated", 1, 0, missing),
                new Object[] { "slabWood", "slabWood", "slabWood", "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood", "stickWood", "stickWood",
                        "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "apiaristBag", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "wovencottonItem", 1, 0, missing),
                        getModItem("Forestry", "apicultureChest", 1, 0, missing),
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "itemLeather",
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "itemLeather", "itemLeather",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem("Forestry", "apiaristBag", 1, 0, missing),
                new Object[] { getModItem("Forestry", "apiaristBag", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Forestry", "lepidopteristBag", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "wovencottonItem", 1, 0, missing),
                        getModItem("Forestry", "lepidopterology", 1, 0, missing),
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "itemLeather",
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "itemLeather", "itemLeather",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem("Forestry", "lepidopteristBag", 1, 0, missing),
                new Object[] { getModItem("Forestry", "lepidopteristBag", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Forestry", "minerBag", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "ingotIron",
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "itemLeather", "ingotIron",
                        "itemLeather", "itemLeather", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem("Forestry", "minerBag", 1, 0, missing),
                new Object[] { getModItem("Forestry", "minerBag", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Forestry", "diggerBag", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "stone",
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "itemLeather", "stone",
                        "itemLeather", "itemLeather", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem("Forestry", "diggerBag", 1, 0, missing),
                new Object[] { getModItem("Forestry", "diggerBag", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Forestry", "foresterBag", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "logWood",
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "itemLeather", "logWood",
                        "itemLeather", "itemLeather", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem("Forestry", "foresterBag", 1, 0, missing),
                new Object[] { getModItem("Forestry", "foresterBag", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Forestry", "hunterBag", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "wovencottonItem", 1, 0, missing),
                        getModItem("minecraft", "feather", 1, 0, missing),
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "itemLeather",
                        getModItem("minecraft", "feather", 1, 0, missing), "itemLeather", "itemLeather",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem("Forestry", "hunterBag", 1, 0, missing),
                new Object[] { getModItem("Forestry", "hunterBag", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Forestry", "builderBag", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "fenceWood",
                        getModItem("harvestcraft", "wovencottonItem", 1, 0, missing), "itemLeather", "fenceWood",
                        "itemLeather", "itemLeather", getModItem("Backpack", "tannedLeather", 1, 0, missing),
                        "itemLeather" });
        addShapelessCraftingRecipe(
                getModItem("Forestry", "builderBag", 1, 0, missing),
                new Object[] { getModItem("Forestry", "builderBag", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 0, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 0, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 0, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 0, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 0, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 1, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 1, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 1, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 1, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 1, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 1, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 1, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 1, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 1, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 1, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 2, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 2, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 2, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 2, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 2, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 2, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 2, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 2, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 2, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 2, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 3, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 3, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 3, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 3, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 3, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 3, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 3, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 3, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 3, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 3, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 4, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 4, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 4, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 4, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 4, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 4, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 4, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 4, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 4, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 4, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 5, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 5, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 5, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 5, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 5, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 5, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 5, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 5, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 5, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 5, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 6, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 6, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 6, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 6, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 6, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 6, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 6, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 6, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 6, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 6, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 7, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 7, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 7, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 7, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 7, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 7, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 7, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 7, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 7, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 7, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 8, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 8, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 8, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 8, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 8, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 8, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 8, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 8, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 8, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 8, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 9, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 9, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 9, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 9, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 9, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 9, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 9, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 9, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 9, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 9, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 10, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 10, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 10, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 10, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 10, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 10, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 10, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 10, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 10, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 10, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 11, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 11, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 11, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 11, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 11, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 11, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 11, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 11, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 11, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 11, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 12, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 12, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 12, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 12, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 12, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 12, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 12, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 12, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 12, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 12, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 13, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 13, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 13, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 13, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 13, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 13, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 13, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 13, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 13, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 13, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 14, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 14, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 14, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 14, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 14, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 14, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 14, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 14, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 14, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 14, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 15, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 15, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 15, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 15, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 15, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 15, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 15, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 15, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 15, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 15, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 16, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 16, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 16, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 16, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 16, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 16, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 16, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 16, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 16, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 16, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 17, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 17, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 17, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 17, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 17, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 17, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 17, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 17, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 17, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 17, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 18, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 18, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 18, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 18, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 18, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 18, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 18, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 18, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 18, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 18, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 19, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 19, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 19, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 19, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 19, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 19, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 19, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 19, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 19, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 19, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 20, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 20, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 20, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 20, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 20, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 20, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 20, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 20, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 20, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 20, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 21, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 21, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 21, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 21, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 21, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 21, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 21, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 21, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 21, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 21, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 22, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 22, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 22, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 22, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 22, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 22, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 22, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 22, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 22, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 22, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 23, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 23, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 23, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 23, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 23, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 23, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 23, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 23, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 23, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 23, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 24, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 24, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 24, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 24, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 24, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 24, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 24, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 24, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 24, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 24, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 25, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 25, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 25, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 25, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 25, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 25, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 25, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 25, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 25, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 25, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 26, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 26, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 26, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 26, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 26, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 26, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 26, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 26, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 26, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 26, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 27, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 27, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 27, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 27, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 27, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 27, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 27, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 27, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 27, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 27, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 1, 28, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 28, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 28, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 28, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 2, 28, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planks", 1, 28, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 28, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fences", 4, 28, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planks", 1, 28, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planks", 1, 28, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 0, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planks", 1, 29, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 0, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 0, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 0, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 1, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 1, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 1, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 1, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 1, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 1, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 1, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 1, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 1, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 1, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 2, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 2, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 2, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 2, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 2, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 2, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 2, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 2, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 2, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 2, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 3, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 3, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 3, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 3, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 3, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 3, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 3, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 3, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 3, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 3, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 4, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 4, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 4, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 4, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 4, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 4, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 4, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 4, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 4, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 4, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 5, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 5, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 5, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 5, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 5, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 5, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 5, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 5, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 5, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 5, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 6, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 6, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 6, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 6, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 6, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 6, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 6, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 6, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 6, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 6, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 7, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 7, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 7, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 7, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 7, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 7, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 7, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 7, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 7, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 7, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 8, missing),
                new Object[] { null, null, null, "stickWood", getModItem("Forestry", "planksFireproof", 1, 8, missing),
                        "stickWood", "stickWood", getModItem("Forestry", "planksFireproof", 1, 8, missing),
                        "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 8, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 8, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 8, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 8, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 8, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 8, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 9, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 9, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 9, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 9, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 9, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 9, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 9, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 9, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 9, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 9, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 10, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 10, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 10, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 10, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 10, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 10, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 10, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 10, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 10, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 10, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 11, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 11, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 11, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 11, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 11, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 11, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 11, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 11, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 11, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 11, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 12, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 12, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 12, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 12, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 12, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 12, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 12, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 12, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 12, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 12, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 13, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 13, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 13, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 13, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 13, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 13, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 13, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 13, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 13, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 13, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 14, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 14, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 14, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 14, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 14, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 14, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 14, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 14, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 14, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 14, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 15, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 15, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 15, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 15, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 15, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 15, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 15, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 15, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 15, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 15, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 16, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 16, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 16, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 16, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 16, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 16, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 16, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 16, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 16, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 16, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 17, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 17, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 17, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 17, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 17, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 17, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 17, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 17, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 17, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 17, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 18, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 18, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 18, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 18, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 18, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 18, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 18, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 18, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 18, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 18, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 19, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 19, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 19, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 19, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 19, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 19, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 19, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 19, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 19, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 19, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 20, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 20, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 20, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 20, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 20, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 20, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 20, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 20, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 20, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 20, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 21, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 21, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 21, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 21, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 21, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 21, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 21, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 21, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 21, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 21, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 22, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 22, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 22, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 22, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 22, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 22, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 22, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 22, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 22, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 22, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 23, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 23, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 23, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 23, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 23, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 23, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 23, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 23, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 23, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 23, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 24, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 24, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 24, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 24, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 24, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 24, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 24, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 24, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 24, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 24, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 25, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 25, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 25, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 25, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 25, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 25, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 25, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 25, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 25, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 25, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 26, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 26, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 26, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 26, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 26, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 26, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 26, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 26, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 26, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 26, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 27, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 27, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 27, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 27, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 27, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 27, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 27, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 27, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 27, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 27, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 1, 28, missing),
                new Object[] { "stickWood", getModItem("Forestry", "planksFireproof", 1, 28, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 28, missing), "stickWood",
                        "stickWood", getModItem("Forestry", "planksFireproof", 1, 28, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 2, 28, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 28, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 28, missing), "stickWood" });
        addShapedRecipe(
                getModItem("Forestry", "fencesFireproof", 4, 28, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 28, missing), "stickWood", "stickWood",
                        getModItem("Forestry", "planksFireproof", 1, 28, missing), "stickWood" });
        addShapelessCraftingRecipe(
                getModItem("Forestry", "factory2", 1, 2, missing),
                new Object[] { getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 10, missing) });
        addShapedRecipe(
                getModItem("Forestry", "cart.beehouse", 1, 0, missing),
                new Object[] { null, "craftingToolScrewdriver", null, "screwSteel",
                        getModItem("Forestry", "apiculture", 1, 2, missing), "screwSteel", "screwSteel",
                        getModItem("minecraft", "minecart", 1, 0, missing), "screwSteel" });
        addShapedRecipe(
                getModItem("Forestry", "cart.beehouse", 1, 1, missing),
                new Object[] { null, "craftingToolScrewdriver", null, "screwSteel",
                        getModItem("Forestry", "apiculture", 1, 0, missing), "screwSteel", "screwSteel",
                        getModItem("minecraft", "minecart", 1, 0, missing), "screwSteel" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "minecart", 1, 0, missing),
                new Object[] { getModItem("Forestry", "cart.beehouse", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "minecart", 1, 0, missing),
                new Object[] { getModItem("Forestry", "cart.beehouse", 1, 1, missing) });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "beeswax", 9, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem("Forestry", "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "refractoryWax", 9, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem("Forestry", "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("MagicBees", "wax", 9, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem("Forestry", "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("MagicBees", "wax", 9, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem("Forestry", "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("MagicBees", "wax", 9, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem("Forestry", "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "paper", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 6, 2896, missing))
                .itemOutputs(getModItem("Forestry", "letters", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(8).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "impregnatedCasing", 1, 0, missing),
                        getModItem("Forestry", "craftingMaterial", 8, 6, missing))
                .itemOutputs(getModItem("Forestry", "alveary", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockcasings", 1, 1, missing),
                        getModItem("IC2", "itemCasing", 4, 2, missing))
                .itemOutputs(getModItem("Forestry", "sturdyMachine", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(800).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockcasings", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 18300, missing))
                .itemOutputs(getModItem("Forestry", "sturdyMachine", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(800).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "sturdyMachine", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 17500, missing))
                .itemOutputs(getModItem("Forestry", "hardenedMachine", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 17057, missing),
                        getModItem("minecraft", "glass_pane", 1, 0, missing))
                .itemOutputs(getModItem("Forestry", "canEmpty", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(120).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "craftingMaterial", 5, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("Forestry", "apiaristHelmet", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "craftingMaterial", 8, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("Forestry", "apiaristChest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "craftingMaterial", 7, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 7, missing))
                .itemOutputs(getModItem("Forestry", "apiaristLegs", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "craftingMaterial", 4, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem("Forestry", "apiaristBoots", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "apiculture", 1, 2, missing),
                        getModItem("minecraft", "minecart", 1, 0, missing))
                .itemOutputs(getModItem("Forestry", "cart.beehouse", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "apiculture", 1, 0, missing),
                        getModItem("minecraft", "minecart", 1, 0, missing))
                .itemOutputs(getModItem("Forestry", "cart.beehouse", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "book", 1, 0, missing),
                        getModItem("minecraft", "crafting_table", 1, 0, missing),
                        getModItem("minecraft", "chest", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("Forestry", "factory2", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("BiomesOPlenty", "hive", 1, 1, missing))
                .itemOutputs(getModItem("Forestry", "propolis", 1, 0, missing)).outputChances(500).noFluidInputs()
                .noFluidOutputs().duration(400).eut(40).addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 0, 32309, missing))
                .itemOutputs(getModItem("Forestry", "honeyDrop", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 200)).noFluidOutputs().duration(400).eut(8)
                .addTo(sFluidSolidficationRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "beeswax", 9, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem("Forestry", "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "refractoryWax", 9, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem("Forestry", "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("MagicBees", "wax", 9, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem("Forestry", "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("MagicBees", "wax", 9, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem("Forestry", "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("MagicBees", "wax", 9, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem("Forestry", "waxCast", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sPressRecipes);

        new ResearchItem(
                "PROVENFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("potentia"), 6),
                7,
                0,
                3,
                getModItem("Forestry", "frameProven", 1, 0, missing)).setParents("MB_EssenceArmor").setConcealed()
                        .setPages(new ResearchPage("Forestry.research_page.PROVENFRAME")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "PROVENFRAME",
                getModItem("Forestry", "frameProven", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("perditio"), 15)
                        .add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("aqua"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem("Forestry", "propolis", 1, 0, missing),
                'e',
                getModItem("Forestry", "frameImpregnated", 1, 0, missing),
                'f',
                getModItem("Forestry", "propolis", 1, 3, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing));
        TCHelper.addResearchPage(
                "PROVENFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Forestry", "frameProven", 1, 0, missing))));
        new ResearchItem(
                "PROVENGRAFTER",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("arbor"), 6),
                -5,
                -3,
                3,
                getModItem("Forestry", "grafterProven", 1, 0, missing)).setParents("MB_Scoop").setConcealed()
                        .setPages(new ResearchPage("Forestry.research_page.PROVENGRAFTER")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "PROVENGRAFTER",
                getModItem("Forestry", "grafterProven", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("instrumentum"), 25).add(Aspect.getAspect("permutatio"), 25)
                        .add(Aspect.getAspect("metallum"), 20).add(Aspect.getAspect("arbor"), 10),
                getModItem("Forestry", "grafter", 1, 0, missing),
                new ItemStack[] { getModItem("minecraft", "sapling", 1, 1, missing),
                        getModItem("minecraft", "sapling", 1, 2, missing),
                        getModItem("Forestry", "pollen", 1, 0, missing),
                        getModItem("minecraft", "sapling", 1, 3, missing),
                        getModItem("minecraft", "sapling", 1, 4, missing),
                        getModItem("minecraft", "sapling", 1, 5, missing),
                        getModItem("Forestry", "pollen", 1, 1, missing),
                        getModItem("minecraft", "sapling", 1, 0, missing), });
        TCHelper.addResearchPage(
                "PROVENGRAFTER",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("Forestry", "grafterProven", 1, 0, missing))));
    }
}
