package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sPressRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

import com.dreammaster.forestry.ForestryHelper;
import com.dreammaster.thaumcraft.TCHelper;

import forestry.api.recipes.RecipeManagers;
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

        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "hardenedMachine", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "core", 1, 1, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "stamps", 9, 4, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "stamps", 9, 5, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "stamps", 9, 6, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "iodineCapsule", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "craftingMaterial", 1, 4, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "craftingMaterial", 1, 6, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "chipsets", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "chipsets", 1, 1, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "chipsets", 1, 2, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "chipsets", 1, 3, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem("Forestry", "thermionicTubes", 4, 0, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem("Forestry", "thermionicTubes", 4, 1, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem("Forestry", "thermionicTubes", 4, 2, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem("Forestry", "thermionicTubes", 4, 3, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem("Forestry", "thermionicTubes", 4, 4, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem("Forestry", "thermionicTubes", 4, 5, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem("Forestry", "thermionicTubes", 4, 6, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem("Forestry", "thermionicTubes", 4, 7, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem("Forestry", "thermionicTubes", 4, 8, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem("Forestry", "thermionicTubes", 4, 9, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem("Forestry", "thermionicTubes", 4, 10, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem("Forestry", "thermionicTubes", 4, 11, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem("Forestry", "thermionicTubes", 4, 12, missing));
        ForestryHelper.removeFabricatorRecipe(getModItem("Forestry", "thermionicTubes", 4, 13, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "carton", 2, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "kitShovel", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "kitPickaxe", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "woodPulp", 4, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "solderingIron", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "oakStick", 2, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "candle", 24, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "candle", 6, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "stamps", 9, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "stamps", 9, 1, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "stamps", 9, 2, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "stamps", 9, 3, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "crate", 24, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("minecraft", "torch", 2, 0, missing));
        ForestryHelper.removeCentrifugeRecipe(getModItem("Forestry", "beeCombs", 1, 9, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "minerBagT2", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "diggerBagT2", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "foresterBagT2", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "hunterBagT2", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "adventurerBagT2", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "builderBagT2", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "beealyzer", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "treealyzer", 1, 0, missing));
        ForestryHelper.removeCarpenterRecipe(getModItem("Forestry", "flutterlyzer", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 1152),
                getModItem("Forestry", "factory2", 1, 2, missing),
                getModItem("Forestry", "factory2", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem("IC2", "itemRecipePart", 1, 0, missing),
                'e',
                getModItem("Forestry", "sturdyMachine", 1, 0, missing),
                'f',
                getModItem("IC2", "itemRecipePart", 1, 0, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 1000),
                null,
                getModItem("Forestry", "core", 1, 1, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("minecraft", "planks", 1, 32767, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem("minecraft", "wooden_slab", 1, 32767, missing),
                'e',
                getModItem("minecraft", "wooden_slab", 1, 32767, missing),
                'f',
                getModItem("minecraft", "wooden_slab", 1, 32767, missing),
                'g',
                getModItem("minecraft", "fence", 1, 0, missing),
                'i',
                getModItem("minecraft", "fence", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 1000),
                getModItem("Forestry", "frameImpregnated", 1, 0, missing),
                getModItem("Forestry", "apiculture", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem("minecraft", "wooden_slab", 1, 32767, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem("Forestry", "apiculture", 1, 2, missing),
                'e',
                getModItem("Forestry", "beeCombs", 1, 32767, missing),
                'f',
                getModItem("Forestry", "apiculture", 1, 2, missing),
                'g',
                getModItem("minecraft", "fence", 1, 0, missing),
                'h',
                getModItem("minecraft", "wooden_slab", 1, 32767, missing),
                'i',
                getModItem("minecraft", "fence", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem("minecraft", "chest", 1, 0, missing),
                getModItem("Forestry", "apicultureChest", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "beeCombs", 1, 32767, missing),
                'b',
                getModItem("Forestry", "beeCombs", 1, 32767, missing),
                'c',
                getModItem("Forestry", "beeCombs", 1, 32767, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32403, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32403, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32403, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 32403, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 32403, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem("minecraft", "chest", 1, 0, missing),
                getModItem("Forestry", "apicultureChest", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "beeCombs", 1, 32767, missing),
                'b',
                getModItem("Forestry", "beeCombs", 1, 32767, missing),
                'c',
                getModItem("Forestry", "beeCombs", 1, 32767, missing),
                'd',
                getModItem("Forestry", "crate", 1, 0, missing),
                'e',
                getModItem("Forestry", "crate", 1, 0, missing),
                'f',
                getModItem("Forestry", "crate", 1, 0, missing),
                'g',
                getModItem("Forestry", "crate", 1, 0, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'i',
                getModItem("Forestry", "crate", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 1000),
                getModItem("minecraft", "chest", 1, 0, missing),
                getModItem("Forestry", "arboriculture", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "sapling", 1, 32767, missing),
                'b',
                getModItem("Forestry", "sapling", 1, 32767, missing),
                'c',
                getModItem("Forestry", "sapling", 1, 32767, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32403, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32403, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32403, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 32403, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 32403, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 1000),
                getModItem("minecraft", "chest", 1, 0, missing),
                getModItem("Forestry", "arboriculture", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("minecraft", "sapling", 1, 32767, missing),
                'b',
                getModItem("minecraft", "sapling", 1, 32767, missing),
                'c',
                getModItem("minecraft", "sapling", 1, 32767, missing),
                'd',
                getModItem("Forestry", "crate", 1, 0, missing),
                'e',
                getModItem("Forestry", "crate", 1, 0, missing),
                'f',
                getModItem("Forestry", "crate", 1, 0, missing),
                'g',
                getModItem("Forestry", "crate", 1, 0, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'i',
                getModItem("Forestry", "crate", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 1000),
                getModItem("minecraft", "chest", 1, 0, missing),
                getModItem("Forestry", "lepidopterology", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "butterflyGE", 1, 32767, missing),
                'b',
                getModItem("Forestry", "butterflyGE", 1, 32767, missing),
                'c',
                getModItem("Forestry", "butterflyGE", 1, 32767, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32403, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32403, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32403, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 32403, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 32403, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 5000),
                getModItem("Forestry", "alveary", 1, 0, missing),
                getModItem("Forestry", "alveary", 1, 2, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 5, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 29351, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 5, missing),
                'd',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'e',
                getModItem("Forestry", "frameProven", 1, 0, missing),
                'f',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 5, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 29351, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 5, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 5000),
                getModItem("Forestry", "alveary", 1, 0, missing),
                getModItem("Forestry", "alveary", 1, 3, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'b',
                getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'd',
                getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.02", 1, 21300, missing),
                'f',
                getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 5000),
                getModItem("Forestry", "alveary", 1, 0, missing),
                getModItem("Forestry", "alveary", 1, 4, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 7, missing),
                'b',
                getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 7, missing),
                'd',
                getModItem("IC2", "itemRecipePart", 1, 0, missing),
                'e',
                getModItem("IC2", "itemRecipePart", 1, 0, missing),
                'f',
                getModItem("IC2", "itemRecipePart", 1, 0, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 7, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 7, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 5000),
                getModItem("Forestry", "alveary", 1, 0, missing),
                getModItem("Forestry", "alveary", 1, 5, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 6, missing),
                'b',
                "circuitGood",
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 6, missing),
                'd',
                getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                'e',
                getModItem("gregtech", "gt.blockmachines", 1, 5142, missing),
                'f',
                getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 6, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 6, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 5000),
                getModItem("Forestry", "alveary", 1, 0, missing),
                getModItem("Forestry", "alveary", 1, 6, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'b',
                getModItem("dreamcraft", "item.ChargedCertusQuartzPlate", 1, 0, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                'e',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'h',
                getModItem("dreamcraft", "item.ChargedCertusQuartzPlate", 1, 0, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("for.honey", 5000),
                getModItem("Forestry", "alveary", 1, 0, missing),
                getModItem("Forestry", "alveary", 1, 7, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 9, missing),
                'b',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 9, missing),
                'd',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'e',
                getModItem("Forestry", "pollenFertile", 1, 32767, missing),
                'f',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 9, missing),
                'h',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 9, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem("dreamcraft", "item.Display", 1, 0, missing),
                getModItem("Forestry", "beealyzer", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27500, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 18057, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27500, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 18057, missing),
                'e',
                "circuitBasic",
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 18057, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27500, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 18057, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27500, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem("dreamcraft", "item.Display", 1, 0, missing),
                getModItem("Forestry", "treealyzer", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27500, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27500, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'e',
                "circuitBasic",
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27500, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27500, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                getModItem("dreamcraft", "item.Display", 1, 0, missing),
                getModItem("Forestry", "flutterlyzer", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27500, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 18300, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27500, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 18300, missing),
                'e',
                "circuitBasic",
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 18300, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27500, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 18300, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27500, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem("minecraft", "stonebrick", 1, 0, missing),
                createItemStack("Forestry", "ffarm", 4, 0, "{FarmBlock:0}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem("Forestry", "thermionicTubes", 1, 10, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem("minecraft", "stonebrick", 4, 1, missing),
                createItemStack("Forestry", "ffarm", 4, 0, "{FarmBlock:1}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem("Forestry", "thermionicTubes", 1, 10, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem("minecraft", "stonebrick", 1, 2, missing),
                createItemStack("Forestry", "ffarm", 4, 0, "{FarmBlock:2}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem("Forestry", "thermionicTubes", 1, 10, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem("minecraft", "brick_block", 1, 0, missing),
                createItemStack("Forestry", "ffarm", 4, 0, "{FarmBlock:3}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem("Forestry", "thermionicTubes", 1, 10, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem("minecraft", "sandstone", 1, 2, missing),
                createItemStack("Forestry", "ffarm", 4, 0, "{FarmBlock:4}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem("Forestry", "thermionicTubes", 1, 10, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem("minecraft", "sandstone", 1, 1, missing),
                createItemStack("Forestry", "ffarm", 4, 0, "{FarmBlock:5}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem("Forestry", "thermionicTubes", 1, 10, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem("minecraft", "nether_brick", 1, 0, missing),
                createItemStack("Forestry", "ffarm", 4, 0, "{FarmBlock:6}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem("Forestry", "thermionicTubes", 1, 10, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem("minecraft", "stonebrick", 1, 3, missing),
                createItemStack("Forestry", "ffarm", 4, 0, "{FarmBlock:7}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem("Forestry", "thermionicTubes", 1, 10, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem("minecraft", "quartz_block", 1, 0, missing),
                createItemStack("Forestry", "ffarm", 4, 0, "{FarmBlock:8}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem("Forestry", "thermionicTubes", 1, 10, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem("minecraft", "quartz_block", 1, 1, missing),
                createItemStack("Forestry", "ffarm", 4, 0, "{FarmBlock:9}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem("Forestry", "thermionicTubes", 1, 10, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("creosote", 500),
                getModItem("minecraft", "quartz_block", 1, 2, missing),
                createItemStack("Forestry", "ffarm", 4, 0, "{FarmBlock:10}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'e',
                getModItem("Forestry", "thermionicTubes", 1, 10, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 18035, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:0}", missing),
                createItemStack("Forestry", "ffarm", 2, 2, "{FarmBlock:0}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:1}", missing),
                createItemStack("Forestry", "ffarm", 2, 2, "{FarmBlock:1}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:2}", missing),
                createItemStack("Forestry", "ffarm", 2, 2, "{FarmBlock:2}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:3}", missing),
                createItemStack("Forestry", "ffarm", 2, 2, "{FarmBlock:3}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:4}", missing),
                createItemStack("Forestry", "ffarm", 2, 2, "{FarmBlock:4}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:5}", missing),
                createItemStack("Forestry", "ffarm", 2, 2, "{FarmBlock:5}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:6}", missing),
                createItemStack("Forestry", "ffarm", 2, 2, "{FarmBlock:6}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:7}", missing),
                createItemStack("Forestry", "ffarm", 2, 2, "{FarmBlock:7}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:8}", missing),
                createItemStack("Forestry", "ffarm", 2, 2, "{FarmBlock:8}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:9}", missing),
                createItemStack("Forestry", "ffarm", 2, 2, "{FarmBlock:9}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:10}", missing),
                createItemStack("Forestry", "ffarm", 2, 2, "{FarmBlock:10}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:0}", missing),
                createItemStack("Forestry", "ffarm", 2, 3, "{FarmBlock:0}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'h',
                getModItem("minecraft", "hopper", 1, 0, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:1}", missing),
                createItemStack("Forestry", "ffarm", 2, 3, "{FarmBlock:1}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'h',
                getModItem("minecraft", "hopper", 1, 0, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:2}", missing),
                createItemStack("Forestry", "ffarm", 2, 3, "{FarmBlock:2}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'h',
                getModItem("minecraft", "hopper", 1, 0, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:3}", missing),
                createItemStack("Forestry", "ffarm", 2, 3, "{FarmBlock:3}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'h',
                getModItem("minecraft", "hopper", 1, 0, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:4}", missing),
                createItemStack("Forestry", "ffarm", 2, 3, "{FarmBlock:4}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'h',
                getModItem("minecraft", "hopper", 1, 0, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:5}", missing),
                createItemStack("Forestry", "ffarm", 2, 3, "{FarmBlock:5}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'h',
                getModItem("minecraft", "hopper", 1, 0, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:6}", missing),
                createItemStack("Forestry", "ffarm", 2, 3, "{FarmBlock:6}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'h',
                getModItem("minecraft", "hopper", 1, 0, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:7}", missing),
                createItemStack("Forestry", "ffarm", 2, 3, "{FarmBlock:7}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'h',
                getModItem("minecraft", "hopper", 1, 0, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:8}", missing),
                createItemStack("Forestry", "ffarm", 2, 3, "{FarmBlock:8}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'h',
                getModItem("minecraft", "hopper", 1, 0, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:9}", missing),
                createItemStack("Forestry", "ffarm", 2, 3, "{FarmBlock:9}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'h',
                getModItem("minecraft", "hopper", 1, 0, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:10}", missing),
                createItemStack("Forestry", "ffarm", 2, 3, "{FarmBlock:10}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing),
                'h',
                getModItem("minecraft", "hopper", 1, 0, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:0}", missing),
                createItemStack("Forestry", "ffarm", 2, 4, "{FarmBlock:0}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:1}", missing),
                createItemStack("Forestry", "ffarm", 2, 4, "{FarmBlock:1}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:2}", missing),
                createItemStack("Forestry", "ffarm", 2, 4, "{FarmBlock:2}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:3}", missing),
                createItemStack("Forestry", "ffarm", 2, 4, "{FarmBlock:3}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:4}", missing),
                createItemStack("Forestry", "ffarm", 2, 4, "{FarmBlock:4}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:5}", missing),
                createItemStack("Forestry", "ffarm", 2, 4, "{FarmBlock:5}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:6}", missing),
                createItemStack("Forestry", "ffarm", 2, 4, "{FarmBlock:6}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:7}", missing),
                createItemStack("Forestry", "ffarm", 2, 4, "{FarmBlock:7}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:8}", missing),
                createItemStack("Forestry", "ffarm", 2, 4, "{FarmBlock:8}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:9}", missing),
                createItemStack("Forestry", "ffarm", 2, 4, "{FarmBlock:9}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 1, 0, "{FarmBlock:10}", missing),
                createItemStack("Forestry", "ffarm", 2, 4, "{FarmBlock:10}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 28880, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 11, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 2, 0, "{FarmBlock:0}", missing),
                createItemStack("Forestry", "ffarm", 2, 5, "{FarmBlock:0}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'h',
                getModItem("gregtech", "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 2, 0, "{FarmBlock:1}", missing),
                createItemStack("Forestry", "ffarm", 2, 5, "{FarmBlock:1}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'h',
                getModItem("gregtech", "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 2, 0, "{FarmBlock:2}", missing),
                createItemStack("Forestry", "ffarm", 2, 5, "{FarmBlock:2}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'h',
                getModItem("gregtech", "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 2, 0, "{FarmBlock:3}", missing),
                createItemStack("Forestry", "ffarm", 2, 5, "{FarmBlock:3}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'h',
                getModItem("gregtech", "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 2, 0, "{FarmBlock:4}", missing),
                createItemStack("Forestry", "ffarm", 2, 5, "{FarmBlock:4}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'h',
                getModItem("gregtech", "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 2, 0, "{FarmBlock:5}", missing),
                createItemStack("Forestry", "ffarm", 2, 5, "{FarmBlock:5}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'h',
                getModItem("gregtech", "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 2, 0, "{FarmBlock:6}", missing),
                createItemStack("Forestry", "ffarm", 2, 5, "{FarmBlock:6}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'h',
                getModItem("gregtech", "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 2, 0, "{FarmBlock:7}", missing),
                createItemStack("Forestry", "ffarm", 2, 5, "{FarmBlock:7}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'h',
                getModItem("gregtech", "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 2, 0, "{FarmBlock:8}", missing),
                createItemStack("Forestry", "ffarm", 2, 5, "{FarmBlock:8}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'h',
                getModItem("gregtech", "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 2, 0, "{FarmBlock:9}", missing),
                createItemStack("Forestry", "ffarm", 2, 5, "{FarmBlock:9}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'h',
                getModItem("gregtech", "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("creosote", 1000),
                createItemStack("Forestry", "ffarm", 2, 0, "{FarmBlock:10}", missing),
                createItemStack("Forestry", "ffarm", 2, 5, "{FarmBlock:10}", missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing),
                'c',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing),
                'h',
                getModItem("gregtech", "gt.blockmachines", 1, 1246, missing),
                'i',
                getModItem("Forestry", "thermionicTubes", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem("Forestry", "fertilizerBio", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("minecraft", "wheat", 1, 0, missing),
                'd',
                getModItem("minecraft", "wheat", 1, 0, missing),
                'e',
                getModItem("minecraft", "dirt", 1, 32767, missing),
                'f',
                getModItem("minecraft", "wheat", 1, 0, missing),
                'h',
                getModItem("minecraft", "wheat", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem("Forestry", "fertilizerBio", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'e',
                getModItem("minecraft", "dirt", 1, 32767, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem("Forestry", "fertilizerBio", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("Natura", "barleyFood", 1, 0, missing),
                'd',
                getModItem("Natura", "barleyFood", 1, 0, missing),
                'e',
                getModItem("minecraft", "dirt", 1, 32767, missing),
                'f',
                getModItem("Natura", "barleyFood", 1, 0, missing),
                'h',
                getModItem("Natura", "barleyFood", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem("Forestry", "fertilizerBio", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("harvestcraft", "barleyItem", 1, 0, missing),
                'd',
                getModItem("harvestcraft", "barleyItem", 1, 0, missing),
                'e',
                getModItem("minecraft", "dirt", 1, 32767, missing),
                'f',
                getModItem("harvestcraft", "barleyItem", 1, 0, missing),
                'h',
                getModItem("harvestcraft", "barleyItem", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem("Forestry", "fertilizerBio", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("BiomesOPlenty", "plants", 1, 6, missing),
                'd',
                getModItem("BiomesOPlenty", "plants", 1, 6, missing),
                'e',
                getModItem("minecraft", "dirt", 1, 32767, missing),
                'f',
                getModItem("BiomesOPlenty", "plants", 1, 6, missing),
                'h',
                getModItem("BiomesOPlenty", "plants", 1, 6, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem("Forestry", "fertilizerBio", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("harvestcraft", "ryeItem", 1, 0, missing),
                'd',
                getModItem("harvestcraft", "ryeItem", 1, 0, missing),
                'e',
                getModItem("minecraft", "dirt", 1, 32767, missing),
                'f',
                getModItem("harvestcraft", "ryeItem", 1, 0, missing),
                'h',
                getModItem("harvestcraft", "ryeItem", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem("Forestry", "fertilizerBio", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("harvestcraft", "oatsItem", 1, 0, missing),
                'd',
                getModItem("harvestcraft", "oatsItem", 1, 0, missing),
                'e',
                getModItem("minecraft", "dirt", 1, 32767, missing),
                'f',
                getModItem("harvestcraft", "oatsItem", 1, 0, missing),
                'h',
                getModItem("harvestcraft", "oatsItem", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem("Forestry", "fertilizerCompound", 5, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("minecraft", "sand", 1, 32767, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 2530, missing),
                'h',
                getModItem("minecraft", "sand", 1, 32767, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem("Forestry", "fertilizerCompound", 6, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("minecraft", "sand", 1, 32767, missing),
                'e',
                getModItem("MagicBees", "miscResources", 1, 2, missing),
                'h',
                getModItem("minecraft", "sand", 1, 32767, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem("Forestry", "fertilizerCompound", 10, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 2530, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem("Forestry", "fertilizerCompound", 12, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'e',
                getModItem("MagicBees", "miscResources", 1, 2, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("water", 100),
                null,
                getModItem("Forestry", "fertilizerCompound", 2, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("minecraft", "sand", 1, 32767, missing),
                'd',
                getModItem("minecraft", "dirt", 1, 32767, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 2836, missing),
                'f',
                getModItem("minecraft", "dirt", 1, 32767, missing),
                'h',
                getModItem("minecraft", "sand", 1, 32767, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem("Forestry", "canEmpty", 1, 0, missing),
                getModItem("Forestry", "iodineCapsule", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'b',
                getModItem("Forestry", "pollen", 1, 32767, missing),
                'c',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'd',
                getModItem("Forestry", "pollen", 1, 32767, missing),
                'e',
                getModItem("Forestry", "propolis", 1, 32767, missing),
                'f',
                getModItem("Forestry", "pollen", 1, 32767, missing),
                'g',
                getModItem("minecraft", "gunpowder", 1, 0, missing),
                'h',
                getModItem("Forestry", "pollen", 1, 32767, missing),
                'i',
                getModItem("minecraft", "gunpowder", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem("Forestry", "canEmpty", 1, 0, missing),
                getModItem("Forestry", "iodineCapsule", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'b',
                getModItem("Forestry", "pollen", 1, 32767, missing),
                'c',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'd',
                getModItem("Forestry", "pollen", 1, 32767, missing),
                'e',
                getModItem("ExtraBees", "propolis", 1, 32767, missing),
                'f',
                getModItem("Forestry", "pollen", 1, 32767, missing),
                'g',
                getModItem("minecraft", "gunpowder", 1, 0, missing),
                'h',
                getModItem("Forestry", "pollen", 1, 32767, missing),
                'i',
                getModItem("minecraft", "gunpowder", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem("Forestry", "canEmpty", 1, 0, missing),
                getModItem("Forestry", "iodineCapsule", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'b',
                getModItem("Forestry", "pollen", 1, 32767, missing),
                'c',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'd',
                getModItem("Forestry", "pollen", 1, 32767, missing),
                'e',
                getModItem("MagicBees", "propolis", 1, 32767, missing),
                'f',
                getModItem("Forestry", "pollen", 1, 32767, missing),
                'g',
                getModItem("minecraft", "gunpowder", 1, 0, missing),
                'h',
                getModItem("Forestry", "pollen", 1, 32767, missing),
                'i',
                getModItem("minecraft", "gunpowder", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem("Forestry", "canEmpty", 1, 0, missing),
                getModItem("Forestry", "craftingMaterial", 1, 4, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'b',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'c',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'd',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'e',
                getModItem("Forestry", "propolis", 1, 32767, missing),
                'f',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'g',
                getModItem("minecraft", "gunpowder", 1, 0, missing),
                'h',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'i',
                getModItem("minecraft", "gunpowder", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem("Forestry", "canEmpty", 1, 0, missing),
                getModItem("Forestry", "craftingMaterial", 1, 4, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'b',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'c',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'd',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'e',
                getModItem("ExtraBees", "propolis", 1, 32767, missing),
                'f',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'g',
                getModItem("minecraft", "gunpowder", 1, 0, missing),
                'h',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'i',
                getModItem("minecraft", "gunpowder", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("for.honey", 1000),
                getModItem("Forestry", "canEmpty", 1, 0, missing),
                getModItem("Forestry", "craftingMaterial", 1, 4, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'b',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'c',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'd',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'e',
                getModItem("MagicBees", "propolis", 1, 32767, missing),
                'f',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'g',
                getModItem("minecraft", "gunpowder", 1, 0, missing),
                'h',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'i',
                getModItem("minecraft", "gunpowder", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 1000),
                null,
                getModItem("Forestry", "craftingMaterial", 1, 6, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.02", 1, 19086, missing),
                'b',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.02", 1, 19086, missing),
                'd',
                getModItem("Forestry", "oakStick", 1, 0, missing),
                'e',
                getModItem("Forestry", "oakStick", 1, 0, missing),
                'f',
                getModItem("Forestry", "oakStick", 1, 0, missing),
                'g',
                getModItem("Forestry", "beeswax", 1, 0, missing),
                'h',
                getModItem("Forestry", "pollen", 1, 32767, missing),
                'i',
                getModItem("Forestry", "beeswax", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("creosote", 200),
                null,
                getModItem("Forestry", "bituminousPeat", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'd',
                getModItem("Forestry", "peat", 1, 0, missing),
                'e',
                getModItem("Forestry", "propolis", 1, 32767, missing),
                'f',
                getModItem("Forestry", "peat", 1, 0, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing));
        RecipeManagers.carpenterManager.addRecipe(
                12,
                (FluidStack) null,
                null,
                getModItem("Forestry", "bituminousPeat", 2, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'd',
                getModItem("Forestry", "peat", 1, 0, missing),
                'e',
                getModItem("ExtraBees", "propolis", 1, 7, missing),
                'f',
                getModItem("Forestry", "peat", 1, 0, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing));
        RecipeManagers.carpenterManager.addRecipe(
                14,
                (FluidStack) null,
                null,
                getModItem("Forestry", "bituminousPeat", 3, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'd',
                getModItem("Forestry", "peat", 1, 0, missing),
                'e',
                getModItem("ExtraBees", "propolis", 1, 1, missing),
                'f',
                getModItem("Forestry", "peat", 1, 0, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing));
        RecipeManagers.carpenterManager.addRecipe(
                16,
                (FluidStack) null,
                null,
                getModItem("Forestry", "bituminousPeat", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                'd',
                getModItem("Forestry", "peat", 1, 0, missing),
                'e',
                getModItem("ExtraBees", "propolis", 1, 2, missing),
                'f',
                getModItem("Forestry", "peat", 1, 0, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("molten.redstone", 1152),
                getModItem("gregtech", "gt.metaitem.03", 1, 32100, missing),
                getModItem("Forestry", "chipsets", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 29032, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing),
                'd',
                "circuitPrimitive",
                'e',
                getModItem("gregtech", "gt.metaitem.02", 1, 19032, missing),
                'f',
                "circuitPrimitive",
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 29032, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("molten.redstone", 1152),
                getModItem("gregtech", "gt.metaitem.03", 1, 32100, missing),
                getModItem("Forestry", "chipsets", 1, 1, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27300, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 29300, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27300, missing),
                'd',
                "circuitBasic",
                'e',
                getModItem("gregtech", "gt.metaitem.02", 1, 19300, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27300, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 29300, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27300, missing));
        RecipeManagers.carpenterManager.addRecipe(
                30,
                FluidRegistry.getFluidStack("molten.redstone", 1152),
                getModItem("gregtech", "gt.metaitem.03", 1, 32101, missing),
                getModItem("Forestry", "chipsets", 1, 2, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 29305, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'd',
                "circuitGood",
                'e',
                getModItem("gregtech", "gt.metaitem.02", 1, 19305, missing),
                'f',
                "circuitGood",
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 29305, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("molten.redstone", 1152),
                getModItem("gregtech", "gt.metaitem.03", 1, 32101, missing),
                getModItem("Forestry", "chipsets", 1, 3, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27303, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 29303, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27303, missing),
                'd',
                "circuitAdvanced",
                'e',
                getModItem("gregtech", "gt.metaitem.02", 1, 19303, missing),
                'f',
                "circuitAdvanced",
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27303, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 29303, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27303, missing));
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem("Forestry", "thermionicTubes", 2, 0, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem("gregtech", "gt.metaitem.02", 1, 22035, missing),
                        'd', getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem("gregtech", "gt.metaitem.02", 1, 22035, missing), 'f',
                        getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem("Forestry", "thermionicTubes", 2, 1, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem("gregtech", "gt.metaitem.02", 1, 22057, missing),
                        'd', getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem("gregtech", "gt.metaitem.02", 1, 22057, missing), 'f',
                        getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem("Forestry", "thermionicTubes", 2, 2, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem("gregtech", "gt.metaitem.02", 1, 22300, missing),
                        'd', getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem("gregtech", "gt.metaitem.02", 1, 22300, missing), 'f',
                        getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem("Forestry", "thermionicTubes", 2, 3, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem("gregtech", "gt.metaitem.02", 1, 22032, missing),
                        'd', getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem("gregtech", "gt.metaitem.02", 1, 22032, missing), 'f',
                        getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem("Forestry", "thermionicTubes", 2, 4, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem("gregtech", "gt.metaitem.02", 1, 22086, missing),
                        'd', getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem("gregtech", "gt.metaitem.02", 1, 22086, missing), 'f',
                        getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem("Forestry", "thermionicTubes", 2, 5, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem("gregtech", "gt.metaitem.02", 1, 22500, missing),
                        'd', getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem("gregtech", "gt.metaitem.02", 1, 22500, missing), 'f',
                        getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem("Forestry", "thermionicTubes", 2, 6, missing),
                new Object[] { "abc", "def", "ghi", 'b',
                        getModItem("dreamcraft", "item.LongObsidianRod", 1, 0, missing), 'd',
                        getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem("dreamcraft", "item.LongObsidianRod", 1, 0, missing), 'f',
                        getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem("Forestry", "thermionicTubes", 2, 7, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem("gregtech", "gt.metaitem.02", 1, 22801, missing),
                        'd', getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem("gregtech", "gt.metaitem.02", 1, 22801, missing), 'f',
                        getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem("Forestry", "thermionicTubes", 2, 8, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem("gregtech", "gt.metaitem.02", 1, 22880, missing),
                        'd', getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem("gregtech", "gt.metaitem.02", 1, 22880, missing), 'f',
                        getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem("Forestry", "thermionicTubes", 2, 9, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem("gregtech", "gt.metaitem.02", 1, 22501, missing),
                        'd', getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem("gregtech", "gt.metaitem.02", 1, 22501, missing), 'f',
                        getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem("Forestry", "thermionicTubes", 2, 10, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem("gregtech", "gt.metaitem.02", 1, 22530, missing),
                        'd', getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem("gregtech", "gt.metaitem.02", 1, 22530, missing), 'f',
                        getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem("Forestry", "thermionicTubes", 2, 11, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem("gregtech", "gt.metaitem.02", 1, 22526, missing),
                        'd', getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem("gregtech", "gt.metaitem.02", 1, 22526, missing), 'f',
                        getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem("Forestry", "thermionicTubes", 2, 12, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem("gregtech", "gt.metaitem.02", 1, 22533, missing),
                        'd', getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem("gregtech", "gt.metaitem.02", 1, 22533, missing), 'f',
                        getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing), 'i',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.fabricatorManager.addRecipe(
                null,
                FluidRegistry.getFluidStack("glass", 2000),
                getModItem("Forestry", "thermionicTubes", 2, 13, missing),
                new Object[] { "abc", "def", "ghi", 'b', getModItem("gregtech", "gt.metaitem.02", 1, 22098, missing),
                        'd', getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'e',
                        getModItem("gregtech", "gt.metaitem.02", 1, 22098, missing), 'f',
                        getModItem("gregtech", "gt.metaitem.02", 1, 19035, missing), 'g',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing), 'h',
                        getModItem("gregtech", "gt.metaitem.01", 1, 17533, missing), 'i',
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing) });
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 288),
                getModItem("minecraft", "compass", 1, 0, missing),
                getModItem("Forestry", "habitatLocator", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27300, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 18300, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27300, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 18300, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 28305, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 18300, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27300, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 18300, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27300, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 576),
                null,
                getModItem("Forestry", "solderingIron", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 23305, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 26305, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 23305, missing),
                'i',
                getModItem("IC2", "itemRecipePart", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                null,
                getModItem("Forestry", "oakStick", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("minecraft", "stick", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                null,
                getModItem("Forestry", "oakStick", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Natura", "natura.stick", 1, 32767, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("seedoil", 250),
                null,
                getModItem("Forestry", "frameImpregnated", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Railcraft", "slab", 1, 38, missing),
                'b',
                getModItem("Railcraft", "slab", 1, 38, missing),
                'c',
                getModItem("Railcraft", "slab", 1, 38, missing),
                'd',
                getModItem("Forestry", "oakStick", 1, 0, missing),
                'e',
                getModItem("harvestcraft", "wovencottonItem", 1, 0, missing),
                'f',
                getModItem("Forestry", "oakStick", 1, 0, missing),
                'g',
                getModItem("Forestry", "oakStick", 1, 0, missing),
                'h',
                getModItem("Forestry", "oakStick", 1, 0, missing),
                'i',
                getModItem("Forestry", "oakStick", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem("Forestry", "candle", 2, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("minecraft", "string", 1, 0, missing),
                'h',
                getModItem("Forestry", "beeswax", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem("Forestry", "candle", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("Forestry", "craftingMaterial", 1, 2, missing),
                'h',
                getModItem("Forestry", "beeswax", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem("Forestry", "candle", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("minecraft", "string", 1, 0, missing),
                'h',
                getModItem("Forestry", "refractoryWax", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem("Forestry", "candle", 8, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("Forestry", "craftingMaterial", 1, 2, missing),
                'h',
                getModItem("Forestry", "refractoryWax", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem("Forestry", "candle", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("minecraft", "string", 1, 0, missing),
                'h',
                getModItem("MagicBees", "wax", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem("Forestry", "candle", 8, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("Forestry", "craftingMaterial", 1, 2, missing),
                'h',
                getModItem("MagicBees", "wax", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem("Forestry", "candle", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("minecraft", "string", 1, 0, missing),
                'h',
                getModItem("MagicBees", "wax", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem("Forestry", "candle", 8, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("Forestry", "craftingMaterial", 1, 2, missing),
                'h',
                getModItem("MagicBees", "wax", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem("Forestry", "candle", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("minecraft", "string", 1, 0, missing),
                'h',
                getModItem("MagicBees", "wax", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 100),
                null,
                getModItem("Forestry", "candle", 8, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("Forestry", "craftingMaterial", 1, 2, missing),
                'h',
                getModItem("MagicBees", "wax", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("for.honey", 800),
                null,
                getModItem("Forestry", "honeyedSlice", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 32566, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("for.honey", 400),
                getModItem("Forestry", "waxCapsule", 1, 0, missing),
                getModItem("Forestry", "ambrosia", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'b',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'c',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'd',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'e',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'f',
                getModItem("Forestry", "royalJelly", 1, 0, missing),
                'g',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'h',
                getModItem("Forestry", "honeydew", 1, 0, missing),
                'i',
                getModItem("Forestry", "honeydew", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                (FluidStack) null,
                getModItem("Forestry", "waxCapsule", 1, 0, missing),
                getModItem("Forestry", "honeyPot", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "honeyDrop", 1, 0, missing),
                'c',
                getModItem("Forestry", "honeyDrop", 1, 0, missing),
                'e',
                getModItem("Forestry", "honeyDrop", 1, 0, missing),
                'g',
                getModItem("Forestry", "honeyDrop", 1, 0, missing),
                'i',
                getModItem("Forestry", "honeyDrop", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("seedoil", 200),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "letters", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("minecraft", "paper", 1, 0, missing),
                'd',
                getModItem("minecraft", "paper", 1, 0, missing),
                'e',
                getModItem("Forestry", "propolis", 1, 32767, missing),
                'f',
                getModItem("minecraft", "paper", 1, 0, missing),
                'h',
                getModItem("minecraft", "paper", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("seedoil", 200),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "letters", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("minecraft", "paper", 1, 0, missing),
                'd',
                getModItem("minecraft", "paper", 1, 0, missing),
                'e',
                getModItem("ExtraBees", "propolis", 1, 32767, missing),
                'f',
                getModItem("minecraft", "paper", 1, 0, missing),
                'h',
                getModItem("minecraft", "paper", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("seedoil", 200),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "letters", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("minecraft", "paper", 1, 0, missing),
                'd',
                getModItem("minecraft", "paper", 1, 0, missing),
                'e',
                getModItem("MagicBees", "propolis", 1, 32767, missing),
                'f',
                getModItem("minecraft", "paper", 1, 0, missing),
                'h',
                getModItem("minecraft", "paper", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("seedoil", 400),
                getModItem("minecraft", "book", 1, 0, missing),
                getModItem("Forestry", "catalogue", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("Forestry", "stamps", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("seedoil", 400),
                getModItem("minecraft", "book", 1, 0, missing),
                getModItem("Forestry", "catalogue", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("Forestry", "stamps", 1, 1, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("seedoil", 400),
                getModItem("minecraft", "book", 1, 0, missing),
                getModItem("Forestry", "catalogue", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("Forestry", "stamps", 1, 2, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("seedoil", 400),
                getModItem("minecraft", "book", 1, 0, missing),
                getModItem("Forestry", "catalogue", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("Forestry", "stamps", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("seedoil", 400),
                getModItem("minecraft", "book", 1, 0, missing),
                getModItem("Forestry", "catalogue", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("Forestry", "stamps", 1, 4, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("seedoil", 400),
                getModItem("minecraft", "book", 1, 0, missing),
                getModItem("Forestry", "catalogue", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("Forestry", "stamps", 1, 5, missing));
        RecipeManagers.carpenterManager.addRecipe(
                40,
                FluidRegistry.getFluidStack("seedoil", 400),
                getModItem("minecraft", "book", 1, 0, missing),
                getModItem("Forestry", "catalogue", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("Forestry", "stamps", 1, 6, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("creosote", 400),
                null,
                getModItem("Forestry", "crate", 4, 0, missing),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem("Forestry", "minerBag", 1, 0, missing),
                getModItem("Forestry", "minerBagT2", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'b',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'c',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'd',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'e',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'f',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'g',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'h',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'i',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem("Forestry", "diggerBag", 1, 0, missing),
                getModItem("Forestry", "diggerBagT2", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'b',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'c',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'd',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'e',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'f',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'g',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'h',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'i',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem("Forestry", "foresterBag", 1, 0, missing),
                getModItem("Forestry", "foresterBagT2", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'b',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'c',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'd',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'e',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'f',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'g',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'h',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'i',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem("Forestry", "hunterBag", 1, 0, missing),
                getModItem("Forestry", "hunterBagT2", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'b',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'c',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'd',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'e',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'f',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'g',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'h',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'i',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem("Forestry", "builderBag", 1, 0, missing),
                getModItem("Forestry", "builderBagT2", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'b',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'c',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'd',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'e',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'f',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'g',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'h',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing),
                'i',
                getModItem("Forestry", "craftingMaterial", 1, 3, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("creosote", 500),
                null,
                getModItem("minecraft", "torch", 5, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("minecraft", "wool", 1, 32767, missing),
                'h',
                getModItem("minecraft", "stick", 1, 0, missing));
        RecipeManagers.fermenterManager.addRecipe(
                getModItem("miscutils", "blockRainforestOakSapling", 1, 0, missing),
                75,
                1.f,
                FluidRegistry.getFluidStack("biomass", 1000),
                FluidRegistry.getFluidStack("juice", 1));
        RecipeManagers.fermenterManager.addRecipe(
                getModItem("miscutils", "blockRainforestOakSapling", 1, 0, missing),
                75,
                1.f,
                FluidRegistry.getFluidStack("biomass", 1000),
                FluidRegistry.getFluidStack("for.honey", 1));
        RecipeManagers.fermenterManager.addRecipe(
                getModItem("miscutils", "blockRainforestOakSapling", 1, 0, missing),
                75,
                1.f,
                FluidRegistry.getFluidStack("biomass", 1000),
                FluidRegistry.getFluidStack("honey", 1));
        RecipeManagers.fermenterManager.addRecipe(
                getModItem("miscutils", "blockRainforestOakSapling", 1, 0, missing),
                50,
                1.f,
                FluidRegistry.getFluidStack("biomass", 1000),
                FluidRegistry.getFluidStack("water", 1));
        GT_Values.RA.addFuel(
                getModItem("Forestry", "bucketShortMead", 1, 0, missing),
                getModItem("minecraft", "bucket", 1, 0, missing),
                4,
                0);
        GT_Values.RA.addFuel(
                getModItem("gregtech", "gt.metaitem.01", 1, 30711, missing),
                getModItem("IC2", "itemCellEmpty", 1, 0, missing),
                2,
                0);
        GT_Values.RA.addFuel(
                getModItem("Forestry", "canBiomass", 1, 0, missing),
                getModItem("Forestry", "canEmpty", 1, 0, missing),
                8,
                0);
        OreDictionary.registerOre("foodHoneydrop", getModItem("Forestry", "honeyDrop", 1, 0, missing));
        OreDictionary.registerOre("listAllsugar", getModItem("Forestry", "honeyDrop", 1, 0, missing));

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
