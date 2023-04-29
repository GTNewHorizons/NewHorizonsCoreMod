package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;
import gregtech.api.util.GT_ModHandler;

public class ScriptTinkersConstruct implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Tinkers Construct";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.TinkerConstruct.ID, Mods.RandomThings.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("TConstruct", "LavaTank", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "Smeltery", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "Smeltery", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing), null,
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "Smeltery", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "Smeltery", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "LavaTankNether", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "SmelteryNether", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing), null,
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "Smeltery", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "Smeltery", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "Smeltery", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("minecraft", "furnace", 1, 0, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "Smeltery", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "Smeltery", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "SmelteryNether", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "SmelteryNether", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("Natura", "NetherFurnace", 1, 0, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "Smeltery", 2, 2, missing),
                new Object[] { getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("minecraft", "water_bucket", 1, 0, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "Smeltery", 2, 2, missing),
                new Object[] { getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1, 0, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "SmelteryNether", 2, 2, missing),
                new Object[] { getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("minecraft", "lava_bucket", 1, 0, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "SmelteryNether", 2, 2, missing),
                new Object[] { getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("IguanaTweaksTConstruct", "clayBucketLava", 1, 0, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "Smeltery", 1, 1, missing),
                new Object[] { getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "CastingChannel", 1, 0, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "SmelteryNether", 1, 1, missing),
                new Object[] { getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "CastingChannel", 1, 0, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "SearedBlock", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "materials", 1, 2, missing), null,
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "Smeltery", 1, 2, missing),
                        getModItem("TConstruct", "Smeltery", 1, 4, missing),
                        getModItem("TConstruct", "Smeltery", 1, 2, missing),
                        getModItem("TConstruct", "Smeltery", 1, 2, missing), null,
                        getModItem("TConstruct", "Smeltery", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "SearedBlockNether", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "materials", 1, 37, missing), null,
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing),
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing),
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing),
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing), null,
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "SearedBlock", 1, 2, missing),
                new Object[] { getModItem("TConstruct", "Smeltery", 1, 2, missing), null,
                        getModItem("TConstruct", "Smeltery", 1, 2, missing),
                        getModItem("TConstruct", "Smeltery", 1, 2, missing), null,
                        getModItem("TConstruct", "Smeltery", 1, 2, missing),
                        getModItem("TConstruct", "Smeltery", 1, 2, missing),
                        getModItem("TConstruct", "Smeltery", 1, 2, missing),
                        getModItem("TConstruct", "Smeltery", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "SearedBlockNether", 1, 2, missing),
                new Object[] { getModItem("TConstruct", "SmelteryNether", 1, 2, missing), null,
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing),
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing), null,
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing),
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing),
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing),
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "CastingChannel", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "materials", 1, 2, missing), null,
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing), null,
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "CastingChannel", 1, 1, missing),
                new Object[] { getModItem("TConstruct", "materials", 1, 37, missing), null,
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing), null,
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "SearedBlock", 2, 1, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "CastingChannel", 1, 0, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "SearedBlockNether", 2, 1, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "CastingChannel", 1, 1, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "SearedBlock", 1, 1, missing),
                new Object[] { null, null, null, getModItem("TConstruct", "materials", 1, 2, missing), null,
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing),
                        getModItem("TConstruct", "materials", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "SearedBlockNether", 1, 1, missing),
                new Object[] { null, null, null, getModItem("TConstruct", "materials", 1, 37, missing), null,
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing),
                        getModItem("TConstruct", "materials", 1, 37, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "LavaTank", 1, 1, missing),
                new Object[] { getModItem("TConstruct", "Smeltery", 1, 2, missing), "glassReinforced",
                        getModItem("TConstruct", "Smeltery", 1, 2, missing), "glassReinforced", "blockGlass",
                        "glassReinforced", getModItem("TConstruct", "Smeltery", 1, 2, missing), "glassReinforced",
                        getModItem("TConstruct", "Smeltery", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "LavaTankNether", 1, 1, missing),
                new Object[] { getModItem("TConstruct", "SmelteryNether", 1, 2, missing), "glassReinforced",
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing), "glassReinforced", "blockGlass",
                        "glassReinforced", getModItem("TConstruct", "SmelteryNether", 1, 2, missing), "glassReinforced",
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "LavaTank", 1, 2, missing),
                new Object[] { getModItem("TConstruct", "Smeltery", 1, 2, missing), "glassReinforced",
                        getModItem("TConstruct", "Smeltery", 1, 2, missing),
                        getModItem("TConstruct", "Smeltery", 1, 2, missing), "blockGlass",
                        getModItem("TConstruct", "Smeltery", 1, 2, missing),
                        getModItem("TConstruct", "Smeltery", 1, 2, missing), "glassReinforced",
                        getModItem("TConstruct", "Smeltery", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "LavaTankNether", 1, 2, missing),
                new Object[] { getModItem("TConstruct", "SmelteryNether", 1, 2, missing), "glassReinforced",
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing),
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing), "blockGlass",
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing),
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing), "glassReinforced",
                        getModItem("TConstruct", "SmelteryNether", 1, 2, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "helmetWood", 1, 0, missing),
                new Object[] { "logWood", "logWood", "logWood", "logWood", "craftingToolSoftHammer", "logWood", null,
                        null, null });
        addShapedRecipe(
                getModItem("TConstruct", "chestplateWood", 1, 0, missing),
                new Object[] { "logWood", "craftingToolSoftHammer", "logWood", "logWood", "logWood", "logWood",
                        "logWood", "logWood", "logWood" });
        addShapedRecipe(
                getModItem("TConstruct", "leggingsWood", 1, 0, missing),
                new Object[] { "logWood", "logWood", "logWood", "logWood", "craftingToolSoftHammer", "logWood",
                        "logWood", null, "logWood" });
        addShapedRecipe(
                getModItem("TConstruct", "bootsWood", 1, 0, missing),
                new Object[] { "logWood", "craftingToolSoftHammer", "logWood", "logWood", null, "logWood", null, null,
                        null });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPane", 2, 0, missing),
                new Object[] { "craftingToolSaw", null, null, null,
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("TConstruct", "CraftedSoil", 4, 1, missing),
                new Object[] { "sand", "sand", "sand", "dustClay",
                        getModItem("minecraft", "water_bucket", 1, 0, missing), "dustClay",
                        getModItem("minecraft", "gravel", 1, 0, missing),
                        getModItem("minecraft", "gravel", 1, 0, missing),
                        getModItem("minecraft", "gravel", 1, 0, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "CraftedSoil", 4, 1, missing),
                new Object[] { getModItem("minecraft", "gravel", 1, 0, missing),
                        getModItem("minecraft", "gravel", 1, 0, missing),
                        getModItem("minecraft", "gravel", 1, 0, missing), "dustClay",
                        getModItem("minecraft", "water_bucket", 1, 0, missing), "dustClay", "sand", "sand", "sand" });
        addShapedRecipe(
                getModItem("TConstruct", "CraftedSoil", 4, 1, missing),
                new Object[] { "sand", "dustClay", getModItem("minecraft", "gravel", 1, 0, missing), "sand",
                        getModItem("minecraft", "water_bucket", 1, 0, missing),
                        getModItem("minecraft", "gravel", 1, 0, missing), "sand", "dustClay",
                        getModItem("minecraft", "gravel", 1, 0, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "CraftedSoil", 4, 1, missing),
                new Object[] { getModItem("minecraft", "gravel", 1, 0, missing), "dustClay", "sand",
                        getModItem("minecraft", "gravel", 1, 0, missing),
                        getModItem("minecraft", "water_bucket", 1, 0, missing), "sand",
                        getModItem("minecraft", "gravel", 1, 0, missing), "dustClay", "sand" });
        addShapedRecipe(
                getModItem("TConstruct", "CraftedSoil", 4, 1, missing),
                new Object[] { "sand", "sand", "sand", "dustClay",
                        getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1, 0, missing), "dustClay",
                        getModItem("minecraft", "gravel", 1, 0, missing),
                        getModItem("minecraft", "gravel", 1, 0, missing),
                        getModItem("minecraft", "gravel", 1, 0, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "CraftedSoil", 4, 1, missing),
                new Object[] { getModItem("minecraft", "gravel", 1, 0, missing),
                        getModItem("minecraft", "gravel", 1, 0, missing),
                        getModItem("minecraft", "gravel", 1, 0, missing), "dustClay",
                        getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1, 0, missing), "dustClay", "sand",
                        "sand", "sand" });
        addShapedRecipe(
                getModItem("TConstruct", "CraftedSoil", 4, 1, missing),
                new Object[] { "sand", "dustClay", getModItem("minecraft", "gravel", 1, 0, missing), "sand",
                        getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1, 0, missing),
                        getModItem("minecraft", "gravel", 1, 0, missing), "sand", "dustClay",
                        getModItem("minecraft", "gravel", 1, 0, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "CraftedSoil", 4, 1, missing),
                new Object[] { getModItem("minecraft", "gravel", 1, 0, missing), "dustClay", "sand",
                        getModItem("minecraft", "gravel", 1, 0, missing),
                        getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1, 0, missing), "sand",
                        getModItem("minecraft", "gravel", 1, 0, missing), "dustClay", "sand" });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftedSoil", 1, 6, missing),
                new Object[] { getModItem("minecraft", "nether_wart", 1, 0, missing),
                        getModItem("minecraft", "soul_sand", 1, 0, missing),
                        getModItem("minecraft", "gravel", 1, 0, missing),
                        getModItem("minecraft", "water_bucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftedSoil", 1, 6, missing),
                new Object[] { getModItem("minecraft", "nether_wart", 1, 0, missing),
                        getModItem("minecraft", "soul_sand", 1, 0, missing),
                        getModItem("minecraft", "gravel", 1, 0, missing),
                        getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftedSoil", 1, 6, missing),
                new Object[] { getModItem("minecraft", "nether_wart", 1, 0, missing),
                        getModItem("Natura", "soil.tainted", 1, 0, missing),
                        getModItem("Natura", "heatsand", 1, 0, missing),
                        getModItem("minecraft", "water_bucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftedSoil", 1, 6, missing),
                new Object[] { getModItem("minecraft", "nether_wart", 1, 0, missing),
                        getModItem("Natura", "soil.tainted", 1, 0, missing),
                        getModItem("Natura", "heatsand", 1, 0, missing),
                        getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "blankPattern", 1, 0, missing),
                new Object[] { "platePaper", "platePaper", "platePaper", "platePaper" });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftingStation", 1, 0, missing),
                new Object[] { "craftingToolSaw", "craftingTableWood" });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftingSlab", 1, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "CraftingStation", 1, 0, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 0, missing),
                new Object[] { "stickWood", getModItem("TConstruct", "blankPattern", 1, 0, missing), "stickWood",
                        "stickWood", getModItem("TConstruct", "CraftingStation", 1, 0, missing), "stickWood", null,
                        "craftingToolSoftHammer", null });
        addShapedRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 0, missing),
                new Object[] { "stickWood", getModItem("TConstruct", "blankPattern", 1, 0, missing), "stickWood",
                        "stickWood", getModItem("minecraft", "crafting_table", 1, 0, missing), "stickWood", null,
                        "craftingToolSoftHammer", null });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftingSlab", 1, 1, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "ToolStationBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 1, missing),
                new Object[] { "stickWood", getModItem("TConstruct", "blankPattern", 1, 0, missing), "stickWood",
                        getModItem("TConstruct", "trap.barricade.oak", 1, 0, missing), "stickWood",
                        getModItem("TConstruct", "trap.barricade.oak", 1, 0, missing), null, "craftingToolSoftHammer",
                        null });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 1, missing),
                new Object[] { getModItem("TConstruct", "ToolStationBlock", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 1, missing),
                new Object[] { getModItem("TConstruct", "ToolStationBlock", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 1, missing),
                new Object[] { getModItem("TConstruct", "ToolStationBlock", 1, 4, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 2, missing),
                new Object[] { "stickWood", getModItem("TConstruct", "blankPattern", 1, 0, missing), "stickWood",
                        getModItem("TConstruct", "trap.barricade.spruce", 1, 0, missing), "stickWood",
                        getModItem("TConstruct", "trap.barricade.spruce", 1, 0, missing), null,
                        "craftingToolSoftHammer", null });
        addShapedRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 3, missing),
                new Object[] { "stickWood", getModItem("TConstruct", "blankPattern", 1, 0, missing), "stickWood",
                        getModItem("TConstruct", "trap.barricade.birch", 1, 0, missing), "stickWood",
                        getModItem("TConstruct", "trap.barricade.birch", 1, 0, missing), null, "craftingToolSoftHammer",
                        null });
        addShapedRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 4, missing),
                new Object[] { "stickWood", getModItem("TConstruct", "blankPattern", 1, 0, missing), "stickWood",
                        getModItem("TConstruct", "trap.barricade.jungle", 1, 0, missing), "stickWood",
                        getModItem("TConstruct", "trap.barricade.jungle", 1, 0, missing), null,
                        "craftingToolSoftHammer", null });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftingSlab", 1, 2, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "ToolStationBlock", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftingSlab", 1, 2, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "ToolStationBlock", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftingSlab", 1, 2, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "ToolStationBlock", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftingSlab", 1, 2, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "ToolStationBlock", 1, 4, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 5, missing),
                new Object[] { "stickWood", getModItem("TConstruct", "blankPattern", 1, 0, missing), "stickWood",
                        "stickWood", getModItem("minecraft", "chest", 1, 0, missing), "stickWood", null,
                        "craftingToolSoftHammer", null });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftingSlab", 1, 4, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "ToolStationBlock", 1, 5, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 10, missing),
                new Object[] { "stickWood", getModItem("TConstruct", "blankPattern", 1, 0, missing), "stickWood",
                        "fenceWood", "stickWood", "fenceWood", null, "craftingToolSoftHammer", null });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 10, missing),
                new Object[] { getModItem("TConstruct", "ToolStationBlock", 1, 11, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 10, missing),
                new Object[] { getModItem("TConstruct", "ToolStationBlock", 1, 12, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 10, missing),
                new Object[] { getModItem("TConstruct", "ToolStationBlock", 1, 13, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 11, missing),
                new Object[] { "stickWood", getModItem("TConstruct", "blankPattern", 1, 0, missing), "stickWood",
                        createItemStack("ExtraTrees", "multifence", 1, 16387, "{meta:65537}", missing), "stickWood",
                        createItemStack("ExtraTrees", "multifence", 1, 16387, "{meta:65537}", missing), null,
                        "craftingToolSoftHammer", null });
        addShapedRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 12, missing),
                new Object[] { "stickWood", getModItem("TConstruct", "blankPattern", 1, 0, missing), "stickWood",
                        createItemStack("ExtraTrees", "multifence", 1, 16387, "{meta:131074}", missing), "stickWood",
                        createItemStack("ExtraTrees", "multifence", 1, 16387, "{meta:131074}", missing), null,
                        "craftingToolSoftHammer", null });
        addShapedRecipe(
                getModItem("TConstruct", "ToolStationBlock", 1, 13, missing),
                new Object[] { "stickWood", getModItem("TConstruct", "blankPattern", 1, 0, missing), "stickWood",
                        createItemStack("ExtraTrees", "multifence", 1, 16387, "{meta:196611}", missing), "stickWood",
                        createItemStack("ExtraTrees", "multifence", 1, 16387, "{meta:196611}", missing), null,
                        "craftingToolSoftHammer", null });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftingSlab", 1, 3, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "ToolStationBlock", 1, 10, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftingSlab", 1, 3, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "ToolStationBlock", 1, 11, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftingSlab", 1, 3, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "ToolStationBlock", 1, 12, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftingSlab", 1, 3, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "ToolStationBlock", 1, 13, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "ToolForgeBlock", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "heavyPlate", 1, 15, missing),
                        getModItem("TConstruct", "SearedSlab", 1, 1, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 15, missing), "blockIron",
                        getModItem("TConstruct", "CraftingSlab", 1, 1, missing), "blockIron", "blockIron",
                        "craftingToolHardHammer", "blockIron" });
        addShapedRecipe(
                getModItem("TConstruct", "ToolForgeBlock", 1, 1, missing),
                new Object[] { getModItem("TConstruct", "heavyPlate", 1, 15, missing),
                        getModItem("TConstruct", "SearedSlab", 1, 1, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 15, missing), "blockGold",
                        getModItem("TConstruct", "CraftingSlab", 1, 1, missing), "blockGold", "blockGold",
                        "craftingToolHardHammer", "blockGold" });
        addShapedRecipe(
                getModItem("TConstruct", "ToolForgeBlock", 1, 2, missing),
                new Object[] { getModItem("TConstruct", "heavyPlate", 1, 15, missing),
                        getModItem("TConstruct", "SearedSlab", 1, 1, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 15, missing), "blockDiamond",
                        getModItem("TConstruct", "CraftingSlab", 1, 1, missing), "blockDiamond", "blockDiamond",
                        "craftingToolHardHammer", "blockDiamond" });
        addShapedRecipe(
                getModItem("TConstruct", "ToolForgeBlock", 1, 3, missing),
                new Object[] { getModItem("TConstruct", "heavyPlate", 1, 15, missing),
                        getModItem("TConstruct", "SearedSlab", 1, 1, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 15, missing), "blockEmerald",
                        getModItem("TConstruct", "CraftingSlab", 1, 1, missing), "blockEmerald", "blockEmerald",
                        "craftingToolHardHammer", "blockEmerald" });
        addShapedRecipe(
                getModItem("TConstruct", "ToolForgeBlock", 1, 4, missing),
                new Object[] { getModItem("TConstruct", "heavyPlate", 1, 15, missing),
                        getModItem("TConstruct", "SearedSlab", 1, 1, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 15, missing), "blockCobalt",
                        getModItem("TConstruct", "CraftingSlab", 1, 1, missing), "blockCobalt", "blockCobalt",
                        "craftingToolHardHammer", "blockCobalt" });
        addShapedRecipe(
                getModItem("TConstruct", "ToolForgeBlock", 1, 5, missing),
                new Object[] { getModItem("TConstruct", "heavyPlate", 1, 15, missing),
                        getModItem("TConstruct", "SearedSlab", 1, 1, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 15, missing), "blockArdite",
                        getModItem("TConstruct", "CraftingSlab", 1, 1, missing), "blockArdite", "blockArdite",
                        "craftingToolHardHammer", "blockArdite" });
        addShapedRecipe(
                getModItem("TConstruct", "ToolForgeBlock", 1, 6, missing),
                new Object[] { getModItem("TConstruct", "heavyPlate", 1, 15, missing),
                        getModItem("TConstruct", "SearedSlab", 1, 1, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 15, missing), "blockManyullyn",
                        getModItem("TConstruct", "CraftingSlab", 1, 1, missing), "blockManyullyn", "blockManyullyn",
                        "craftingToolHardHammer", "blockManyullyn" });
        addShapedRecipe(
                getModItem("TConstruct", "ToolForgeBlock", 1, 7, missing),
                new Object[] { getModItem("TConstruct", "heavyPlate", 1, 15, missing),
                        getModItem("TConstruct", "SearedSlab", 1, 1, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 15, missing), "blockCopper",
                        getModItem("TConstruct", "CraftingSlab", 1, 1, missing), "blockCopper", "blockCopper",
                        "craftingToolHardHammer", "blockCopper" });
        addShapedRecipe(
                getModItem("TConstruct", "ToolForgeBlock", 1, 8, missing),
                new Object[] { getModItem("TConstruct", "heavyPlate", 1, 15, missing),
                        getModItem("TConstruct", "SearedSlab", 1, 1, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 15, missing), "blockBronze",
                        getModItem("TConstruct", "CraftingSlab", 1, 1, missing), "blockBronze", "blockBronze",
                        "craftingToolHardHammer", "blockBronze" });
        addShapedRecipe(
                getModItem("TConstruct", "ToolForgeBlock", 1, 9, missing),
                new Object[] { getModItem("TConstruct", "heavyPlate", 1, 15, missing),
                        getModItem("TConstruct", "SearedSlab", 1, 1, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 15, missing), "blockTin",
                        getModItem("TConstruct", "CraftingSlab", 1, 1, missing), "blockTin", "blockTin",
                        "craftingToolHardHammer", "blockTin" });
        addShapedRecipe(
                getModItem("TConstruct", "ToolForgeBlock", 1, 10, missing),
                new Object[] { getModItem("TConstruct", "heavyPlate", 1, 15, missing),
                        getModItem("TConstruct", "SearedSlab", 1, 1, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 15, missing), "blockAluminium",
                        getModItem("TConstruct", "CraftingSlab", 1, 1, missing), "blockAluminium", "blockAluminium",
                        "craftingToolHardHammer", "blockAluminium" });
        addShapedRecipe(
                getModItem("TConstruct", "ToolForgeBlock", 1, 11, missing),
                new Object[] { getModItem("TConstruct", "heavyPlate", 1, 15, missing),
                        getModItem("TConstruct", "SearedSlab", 1, 1, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 15, missing), "blockAluminiumBrass",
                        getModItem("TConstruct", "CraftingSlab", 1, 1, missing), "blockAluminiumBrass",
                        "blockAluminiumBrass", "craftingToolHardHammer", "blockAluminiumBrass" });
        addShapedRecipe(
                getModItem("TConstruct", "ToolForgeBlock", 1, 12, missing),
                new Object[] { getModItem("TConstruct", "heavyPlate", 1, 15, missing),
                        getModItem("TConstruct", "SearedSlab", 1, 1, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 15, missing), "blockAlumite",
                        getModItem("TConstruct", "CraftingSlab", 1, 1, missing), "blockAlumite", "blockAlumite",
                        "craftingToolHardHammer", "blockAlumite" });
        addShapedRecipe(
                getModItem("TConstruct", "ToolForgeBlock", 1, 13, missing),
                new Object[] { getModItem("TConstruct", "heavyPlate", 1, 15, missing),
                        getModItem("TConstruct", "SearedSlab", 1, 1, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 15, missing), "blockSteel",
                        getModItem("TConstruct", "CraftingSlab", 1, 1, missing), "blockSteel", "blockSteel",
                        "craftingToolHardHammer", "blockSteel" });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "FurnaceSlab", 1, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("minecraft", "furnace", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "CraftingSlab", 1, 5, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "ToolForgeBlock", 1, 32767, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "SearedSlab", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "Smeltery", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "SearedSlab", 2, 1, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "Smeltery", 1, 4, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "SearedSlab", 2, 2, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "Smeltery", 1, 5, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "SearedSlab", 2, 3, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "Smeltery", 1, 6, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "SearedSlab", 2, 4, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "Smeltery", 1, 8, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "SearedSlab", 2, 5, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "Smeltery", 1, 9, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "SearedSlab", 2, 6, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "Smeltery", 1, 10, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "SearedSlab", 2, 7, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "Smeltery", 1, 11, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "Smeltery", 1, 7, missing),
                new Object[] { "craftingToolHardHammer", getModItem("TConstruct", "Smeltery", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "SpeedSlab", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "SpeedBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "SpeedSlab", 2, 1, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "SpeedBlock", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "SpeedSlab", 2, 2, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "SpeedBlock", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "SpeedSlab", 2, 3, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "SpeedBlock", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "SpeedSlab", 2, 4, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "SpeedBlock", 1, 4, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "SpeedSlab", 2, 5, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "SpeedBlock", 1, 5, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "SpeedSlab", 2, 6, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "SpeedBlock", 1, 6, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "SpeedSlab", 2, 7, missing),
                new Object[] { "craftingToolSaw", getModItem("TConstruct", "SpeedBlock", 1, 7, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "trap.punji", 2, 0, missing),
                new Object[] { getModItem("minecraft", "reeds", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "reeds", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "reeds", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "reeds", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "reeds", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "WoolSlab1", 2, 0, missing),
                new Object[] { "craftingToolShears", getModItem("minecraft", "wool", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "WoolSlab1", 2, 1, missing),
                new Object[] { "craftingToolShears", getModItem("minecraft", "wool", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "WoolSlab1", 2, 2, missing),
                new Object[] { "craftingToolShears", getModItem("minecraft", "wool", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "WoolSlab1", 2, 3, missing),
                new Object[] { "craftingToolShears", getModItem("minecraft", "wool", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "WoolSlab1", 2, 4, missing),
                new Object[] { "craftingToolShears", getModItem("minecraft", "wool", 1, 4, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "WoolSlab1", 2, 5, missing),
                new Object[] { "craftingToolShears", getModItem("minecraft", "wool", 1, 5, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "WoolSlab1", 2, 6, missing),
                new Object[] { "craftingToolShears", getModItem("minecraft", "wool", 1, 6, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "WoolSlab1", 2, 7, missing),
                new Object[] { "craftingToolShears", getModItem("minecraft", "wool", 1, 7, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "WoolSlab2", 2, 0, missing),
                new Object[] { "craftingToolShears", getModItem("minecraft", "wool", 1, 8, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "WoolSlab2", 2, 1, missing),
                new Object[] { "craftingToolShears", getModItem("minecraft", "wool", 1, 9, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "WoolSlab2", 2, 2, missing),
                new Object[] { "craftingToolShears", getModItem("minecraft", "wool", 1, 10, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "WoolSlab2", 2, 3, missing),
                new Object[] { "craftingToolShears", getModItem("minecraft", "wool", 1, 11, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "WoolSlab2", 2, 4, missing),
                new Object[] { "craftingToolShears", getModItem("minecraft", "wool", 1, 12, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "WoolSlab2", 2, 5, missing),
                new Object[] { "craftingToolShears", getModItem("minecraft", "wool", 1, 13, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "WoolSlab2", 2, 6, missing),
                new Object[] { "craftingToolShears", getModItem("minecraft", "wool", 1, 14, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "WoolSlab2", 2, 7, missing),
                new Object[] { "craftingToolShears", getModItem("minecraft", "wool", 1, 15, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "trap.barricade.oak", 1, 0, missing),
                new Object[] { null, getModItem("minecraft", "log", 1, 0, missing), null,
                        getModItem("minecraft", "log", 1, 0, missing), getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "log", 1, 0, missing), null,
                        getModItem("minecraft", "log", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("TConstruct", "trap.barricade.spruce", 1, 0, missing),
                new Object[] { null, getModItem("minecraft", "log", 1, 1, missing), null,
                        getModItem("minecraft", "log", 1, 1, missing), getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "log", 1, 1, missing), null,
                        getModItem("minecraft", "log", 1, 1, missing), null });
        addShapedRecipe(
                getModItem("TConstruct", "trap.barricade.birch", 1, 0, missing),
                new Object[] { null, getModItem("minecraft", "log", 1, 2, missing), null,
                        getModItem("minecraft", "log", 1, 2, missing), getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "log", 1, 2, missing), null,
                        getModItem("minecraft", "log", 1, 2, missing), null });
        addShapedRecipe(
                getModItem("TConstruct", "trap.barricade.jungle", 1, 0, missing),
                new Object[] { null, getModItem("minecraft", "log", 1, 3, missing), null,
                        getModItem("minecraft", "log", 1, 3, missing), getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "log", 1, 3, missing), null,
                        getModItem("minecraft", "log", 1, 3, missing), null });
        addShapedRecipe(
                getModItem("TConstruct", "slime.channel", 1, 0, missing),
                new Object[] { "slimeball", "slimeball", "slimeball", "dustRedstone",
                        getModItem("minecraft", "water_bucket", 1, 0, missing), "dustRedstone", "slimeball",
                        "slimeball", "slimeball" });
        addShapedRecipe(
                getModItem("TConstruct", "blood.channel", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "strangeFood", 1, 1, missing),
                        getModItem("TConstruct", "strangeFood", 1, 1, missing),
                        getModItem("TConstruct", "strangeFood", 1, 1, missing), "dustRedstone",
                        getModItem("minecraft", "water_bucket", 1, 0, missing), "dustRedstone",
                        getModItem("TConstruct", "strangeFood", 1, 1, missing),
                        getModItem("TConstruct", "strangeFood", 1, 1, missing),
                        getModItem("TConstruct", "strangeFood", 1, 1, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "slime.pad", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "slime.gel", 1, 0, missing),
                        getModItem("TConstruct", "slime.gel", 1, 0, missing),
                        getModItem("TConstruct", "slime.gel", 1, 0, missing),
                        getModItem("TConstruct", "slime.channel", 1, 0, missing),
                        getModItem("TConstruct", "slime.gel", 1, 1, missing),
                        getModItem("TConstruct", "slime.channel", 1, 0, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "CraftedSoil", 1, 0, missing),
                new Object[] { getModItem("minecraft", "slime_ball", 1, 0, missing),
                        getModItem("minecraft", "slime_ball", 1, 0, missing),
                        getModItem("minecraft", "slime_ball", 1, 0, missing),
                        getModItem("minecraft", "dirt", 1, 0, missing),
                        getModItem("TConstruct", "CraftedSoil", 1, 1, missing),
                        getModItem("minecraft", "dirt", 1, 0, missing),
                        getModItem("minecraft", "slime_ball", 1, 0, missing),
                        getModItem("minecraft", "slime_ball", 1, 0, missing),
                        getModItem("minecraft", "slime_ball", 1, 0, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "CraftedSoil", 1, 2, missing),
                new Object[] { getModItem("TConstruct", "strangeFood", 1, 0, missing),
                        getModItem("TConstruct", "strangeFood", 1, 0, missing),
                        getModItem("TConstruct", "strangeFood", 1, 0, missing),
                        getModItem("minecraft", "dirt", 1, 0, missing),
                        getModItem("TConstruct", "CraftedSoil", 1, 1, missing),
                        getModItem("minecraft", "dirt", 1, 0, missing),
                        getModItem("TConstruct", "strangeFood", 1, 0, missing),
                        getModItem("TConstruct", "strangeFood", 1, 0, missing),
                        getModItem("TConstruct", "strangeFood", 1, 0, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "CraftedSoil", 1, 3, missing),
                new Object[] { "dustBone", getModItem("minecraft", "rotten_flesh", 1, 0, missing), "dustBone",
                        getModItem("minecraft", "rotten_flesh", 1, 0, missing),
                        getModItem("minecraft", "dirt", 1, 0, missing),
                        getModItem("minecraft", "rotten_flesh", 1, 0, missing), "dustBone",
                        getModItem("minecraft", "rotten_flesh", 1, 0, missing), "dustBone" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 7, 0, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeWhite",
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeWhite" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 7, 1, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeOrange",
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 1, 1, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeOrange" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 7, 2, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeMagenta",
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 1, 2, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeMagenta" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 7, 3, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeLightBlue",
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 1, 3, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeLightBlue" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 7, 4, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeYellow",
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 1, 4, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeYellow" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 7, 5, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeLime",
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 1, 5, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeLime" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 7, 6, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyePink",
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 1, 6, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyePink" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 7, 7, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeGray",
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 1, 7, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeGray" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 7, 8, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeLightGray",
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 1, 8, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeLightGray" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 7, 9, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeCyan",
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 1, 9, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeCyan" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 7, 10, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyePurple",
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 1, 10, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyePurple" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 7, 11, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeBlue",
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 1, 11, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeBlue" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 7, 12, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeBrown",
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 1, 12, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeBrown" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 7, 13, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeGreen",
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 1, 13, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeGreen" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 7, 14, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeRed",
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 1, 14, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeRed" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 7, 15, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeBlack",
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock.StainedClear", 1, 15, missing),
                new Object[] { getModItem("TConstruct", "GlassBlock", 1, 0, missing), "dyeBlack" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 7, 0, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeWhite",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeWhite" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 7, 1, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeOrange",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 1, 1, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeOrange" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 7, 2, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeMagenta",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 1, 2, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeMagenta" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 7, 3, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeLightBlue",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 1, 3, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeLightBlue" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 7, 4, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeYellow",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 1, 4, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeYellow" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 7, 5, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeLime",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 1, 5, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeLime" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 7, 6, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyePink",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 1, 6, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyePink" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 7, 7, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeGray",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 1, 7, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeGray" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 7, 8, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeLightGray",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 1, 8, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeLightGray" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 7, 9, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeCyan",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 1, 9, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeCyan" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 7, 10, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyePurple",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 1, 10, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyePurple" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 7, 11, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeBlue",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 1, 11, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeBlue" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 7, 12, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeBrown",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 1, 12, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeBrown" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 7, 13, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeGreen",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 1, 13, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeGreen" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 7, 14, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeRed",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 1, 14, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeRed" });
        addShapedRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 7, 15, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeBlack",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassPaneClearStained", 1, 15, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "dyeBlack" });
        addShapedRecipe(
                getModItem("TConstruct", "Armor.DryingRack", 1, 0, missing),
                new Object[] { "slabWood", "slabWood", "slabWood", "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "Armor.DryingRack", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "Armor.DryingRack", 1, 5, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "Armor.DryingRack", 1, 5, missing),
                new Object[] { getModItem("TConstruct", "Armor.DryingRack", 1, 0, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "Redstone.Landmine", 1, 0, missing),
                new Object[] { getModItem("minecraft", "repeater", 1, 0, missing),
                        getModItem("minecraft", "light_weighted_pressure_plate", 1, 0, missing),
                        getModItem("minecraft", "repeater", 1, 0, missing),
                        getModItem("minecraft", "stone", 1, 0, missing),
                        getModItem("Railcraft", "detector", 1, 1, missing),
                        getModItem("minecraft", "stone", 1, 0, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "Redstone.Landmine", 1, 1, missing),
                new Object[] { getModItem("minecraft", "repeater", 1, 0, missing),
                        getModItem("minecraft", "light_weighted_pressure_plate", 1, 0, missing),
                        getModItem("minecraft", "repeater", 1, 0, missing),
                        getModItem("minecraft", "stone", 1, 0, missing),
                        getModItem("Railcraft", "detector", 1, 3, missing),
                        getModItem("minecraft", "stone", 1, 0, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "Redstone.Landmine", 1, 2, missing),
                new Object[] { getModItem("minecraft", "repeater", 1, 0, missing),
                        getModItem("minecraft", "light_weighted_pressure_plate", 1, 0, missing),
                        getModItem("minecraft", "repeater", 1, 0, missing),
                        getModItem("minecraft", "stone", 1, 0, missing),
                        getModItem("Railcraft", "detector", 1, 5, missing),
                        getModItem("minecraft", "stone", 1, 0, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "Redstone.Landmine", 1, 3, missing),
                new Object[] { getModItem("minecraft", "repeater", 1, 0, missing),
                        getModItem("minecraft", "light_weighted_pressure_plate", 1, 0, missing),
                        getModItem("minecraft", "repeater", 1, 0, missing),
                        getModItem("minecraft", "stone", 1, 0, missing),
                        getModItem("Railcraft", "detector", 1, 4, missing),
                        getModItem("minecraft", "stone", 1, 0, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "materials", 1, 40, missing),
                new Object[] { null, null, getModItem("gregtech", "gt.metaitem.01", 1, 2019, missing), null, null, null,
                        null, null, null });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 2019, missing),
                new Object[] { null, null, getModItem("TConstruct", "materials", 1, 40, missing), null, null, null,
                        null, null, null });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "toolRod", 1, 6, missing),
                new Object[] { getModItem("RandomThings", "ingredient", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("RandomThings", "ingredient", 1, 1, missing),
                new Object[] { getModItem("TConstruct", "toolRod", 1, 6, missing) });
        addShapelessCraftingRecipe(
                getModItem("RandomThings", "ingredient", 1, 1, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 23804, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 23804, missing),
                new Object[] { getModItem("RandomThings", "ingredient", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "toolRod", 1, 6, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 23804, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 23804, missing),
                new Object[] { getModItem("TConstruct", "toolRod", 1, 6, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                new Object[] { getModItem("ExtraUtilities", "decorativeBlock2", 1, 0, missing) });
        addShapedRecipe(
                createItemStack(
                        "TConstruct",
                        "travelGoggles",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:0.0d,Built:1b,MaxDefense:4.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                new Object[] { getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "boltElectrum",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "ringElectrum",
                        getModItem("minecraft", "diamond_helmet", 1, 0, missing), "ringElectrum", "lensDiamond",
                        "circuitAdvanced", "lensDiamond" });
        addShapedRecipe(
                createItemStack(
                        "TConstruct",
                        "travelVest",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:4.0d,Built:1b,MaxDefense:10.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                new Object[] { getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "circuitAdvanced",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "plateObsidian",
                        getModItem("minecraft", "diamond_chestplate", 1, 0, missing), "plateObsidian",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "plateObsidian",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing) });
        addShapedRecipe(
                createItemStack(
                        "TConstruct",
                        "travelGlove",
                        1,
                        0,
                        "{TinkerAccessory:{BaseDurability:500,Built:1b,Damage:0,BonusDurability:0,TotalDurability:500,ModDurability:0.0f,Modifiers:5,Broken:0b}}",
                        missing),
                new Object[] { null, getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "plateDiamond",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), null,
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "circuitAdvanced" });
        addShapedRecipe(
                createItemStack(
                        "TConstruct",
                        "travelWings",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:2.0d,Built:1b,MaxDefense:8.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                new Object[] { "plateDiamond", getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        "plateDiamond", getModItem("TConstruct", "fletching", 1, 0, missing), "circuitAdvanced",
                        getModItem("TConstruct", "fletching", 1, 0, missing),
                        getModItem("TConstruct", "fletching", 1, 0, missing),
                        getModItem("minecraft", "diamond_leggings", 1, 0, missing),
                        getModItem("TConstruct", "fletching", 1, 0, missing) });
        addShapedRecipe(
                createItemStack(
                        "TConstruct",
                        "travelBelt",
                        1,
                        0,
                        "{TinkerAccessory:{BaseDurability:500,Built:1b,Damage:0,BonusDurability:0,TotalDurability:500,ModDurability:0.0f,Modifiers:5,Broken:0b}}",
                        missing),
                new Object[] { null, "circuitAdvanced", null,
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), "plateDiamond",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing), null,
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing) });
        addShapedRecipe(
                createItemStack(
                        "TConstruct",
                        "travelBoots",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:2.0d,Built:1b,MaxDefense:6.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                new Object[] { null, "plateDiamond", "plateDiamond", null,
                        getModItem("minecraft", "diamond_boots", 1, 0, missing), "circuitAdvanced",
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32642, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32642, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "materials", 1, 3, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 11033, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 11033, missing),
                new Object[] { getModItem("TConstruct", "materials", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem("TConstruct", "materials", 1, 5, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 11386, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 11386, missing),
                new Object[] { getModItem("TConstruct", "materials", 1, 5, missing) });
        addShapedRecipe(
                getModItem("TConstruct", "decoration.stoneladder", 4, 0, missing),
                new Object[] { getModItem("ForgeMicroblock", "stoneRod", 1, 0, missing),
                        getModItem("TMechworks", "LengthWire", 1, 0, missing),
                        getModItem("ForgeMicroblock", "stoneRod", 1, 0, missing),
                        getModItem("ForgeMicroblock", "stoneRod", 1, 0, missing),
                        getModItem("ForgeMicroblock", "stoneRod", 1, 0, missing),
                        getModItem("ForgeMicroblock", "stoneRod", 1, 0, missing),
                        getModItem("ForgeMicroblock", "stoneRod", 1, 0, missing),
                        getModItem("TMechworks", "LengthWire", 1, 0, missing),
                        getModItem("ForgeMicroblock", "stoneRod", 1, 0, missing) });

        GT_ModHandler.addSmeltingRecipe(
                getModItem("dreamcraft", "item.UnfiredSearedBrick", 1, 0, missing),
                getModItem("TConstruct", "materials", 1, 2, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem("dreamcraft", "item.UnfiredSlimeSoulBrick", 1, 0, missing),
                getModItem("TConstruct", "materials", 1, 37, missing));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "CraftedSoil", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32307, missing))
                .itemOutputs(getModItem("TConstruct", "materials", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "CraftedSoil", 2, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32307, missing))
                .itemOutputs(getModItem("TConstruct", "materials", 1, 17, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "materials", 9, 32, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem("TConstruct", "materials", 1, 15, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "materials", 9, 27, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem("TConstruct", "materials", 1, 18, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "materials", 9, 24, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem("TConstruct", "materials", 1, 14, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(2).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "CraftedSoil", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem("TConstruct", "materials", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "CraftedSoil", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem("TConstruct", "materials", 1, 37, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ForgeMicroblock", "stoneRod", 7, 0, missing),
                        getModItem("TMechworks", "LengthWire", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem("TConstruct", "decoration.stoneladder", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(60).eut(30).addTo(sAssemblerRecipes);

    }
}
