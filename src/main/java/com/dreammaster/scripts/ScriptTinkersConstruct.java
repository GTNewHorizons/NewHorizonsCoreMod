package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.DryingRackRecipes;
import tconstruct.library.crafting.Smeltery;

import com.dreammaster.oredict.OreDictHelper;
import com.dreammaster.tinkersConstruct.TConstructHelper;

import cpw.mods.fml.common.registry.GameRegistry;
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
        OreDictionary.registerOre("bucketEnder", getModItem("TConstruct", "buckets", 1, 23, missing));
        OreDictHelper.removeOreDict("nuggetAluminium", getModItem("TConstruct", "oreBerries", 1, 4, missing));

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

        TConstructHelper.removeBasinRecipe(getModItem("minecraft", "iron_block", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem("minecraft", "gold_block", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem("minecraft", "obsidian", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem("minecraft", "emerald_block", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("TConstruct", "MetalBlock", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem("TConstruct", "MetalBlock", 1, 1, missing));
        TConstructHelper.removeBasinRecipe(getModItem("TConstruct", "MetalBlock", 1, 2, missing));
        TConstructHelper.removeBasinRecipe(getModItem("IC2", "blockMetal", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem("IC2", "blockMetal", 1, 2, missing));
        TConstructHelper.removeBasinRecipe(getModItem("IC2", "blockMetal", 1, 1, missing));
        TConstructHelper.removeBasinRecipe(getModItem("TConstruct", "MetalBlock", 1, 6, missing));
        TConstructHelper.removeBasinRecipe(getModItem("TConstruct", "MetalBlock", 1, 7, missing));
        TConstructHelper.removeBasinRecipe(getModItem("TConstruct", "MetalBlock", 1, 8, missing));
        TConstructHelper.removeBasinRecipe(getModItem("TConstruct", "GlueBlock", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem("gregtech", "gt.blockmetal5", 1, 11, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "materials", 1, 2, missing));
        TConstructHelper.removeBasinRecipe(getModItem("TConstruct", "Smeltery", 1, 4, missing));
        TConstructHelper.removeBasinRecipe(getModItem("TConstruct", "Smeltery", 1, 5, missing));
        TConstructHelper.removeBasinRecipe(getModItem("TConstruct", "MetalBlock", 1, 10, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("gregtech", "gt.blockores", 1, 33, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("TConstruct", "SearedBrick", 1, 1, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("GalaxySpace", "phobosblocks", 1, 4, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("TConstruct", "GravelOre", 1, 5, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("TConstruct", "materials", 1, 39, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 2033, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("TConstruct", "SearedBrick", 1, 2, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("gregtech", "gt.blockores", 1, 382, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("TConstruct", "materials", 1, 38, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 2382, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("TConstruct", "materials", 1, 29, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 9382, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("TConstruct", "MetalBlock", 1, 1, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("TConstruct", "materials", 1, 41, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 2386, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("TConstruct", "materials", 1, 30, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 9386, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("TConstruct", "MetalBlock", 1, 2, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("TConstruct", "MetalBlock", 1, 10, missing));
        TConstructHelper.removeTableRecipe(getModItem("BuildCraft|Core", "ironGearItem", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem("BuildCraft|Core", "goldGearItem", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem("Forestry", "gearBronze", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem("Forestry", "gearCopper", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem("Forestry", "gearTin", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem("gregtech", "gt.metaitem.02", 1, 31085, missing));
        TConstructHelper.removeTableRecipe(getModItem("gregtech", "gt.metaitem.02", 1, 31034, missing));
        TConstructHelper.removeTableRecipe(getModItem("gregtech", "gt.metaitem.02", 1, 31054, missing));
        TConstructHelper.removeTableRecipe(getModItem("gregtech", "gt.metaitem.02", 1, 31303, missing));
        TConstructHelper.removeTableRecipe(getModItem("gregtech", "gt.metaitem.02", 1, 31302, missing));
        TConstructHelper.removeTableRecipe(getModItem("gregtech", "gt.metaitem.02", 1, 31089, missing));
        TConstructHelper.removeTableRecipe(getModItem("gregtech", "gt.metaitem.02", 1, 31305, missing));
        TConstructHelper.removeTableRecipe(getModItem("IC2", "itemIngot", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem("IC2", "itemIngot", 1, 1, missing));
        TConstructHelper.removeTableRecipe(getModItem("IC2", "itemIngot", 1, 2, missing));
        TConstructHelper.removeTableRecipe(getModItem("IC2", "itemIngot", 1, 3, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("minecraft", "chainmail_helmet", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("minecraft", "chainmail_chestplate", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("minecraft", "chainmail_leggings", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("minecraft", "chainmail_boots", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 9033, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("TConstruct", "materials", 1, 3, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 11033, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("GalaxySpace", "item.Ingots", 1, 1, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("gregtech", "gt.blockmetal2", 1, 5, missing));
        TConstructHelper.removeBasinRecipe(getModItem("TConstruct", "MetalBlock", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem("BloodArsenal", "blood_infused_iron_block", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("minecraft", "sand", 1, 0, missing));
        TConstructHelper.removeSmelterAlloyMix(FluidRegistry.getFluidStack("alumite.molten", 32));
        TConstructHelper.removeMeltingRecipe(getModItem("TConstruct", "CraftedSoil", 1, 1, missing));
        TConstructHelper.removeTableRecipe(getModItem("minecraft", "golden_apple", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "gearCast", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem("gregtech", "gt.metaitem.02", 1, 31321, missing));
        TConstructHelper.removeTableRecipe(getModItem("gregtech", "gt.metaitem.02", 1, 31382, missing));
        TConstructHelper.removeTableRecipe(getModItem("gregtech", "gt.metaitem.02", 1, 31386, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "materials", 1, 29, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "materials", 1, 30, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "materials", 1, 4, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "materials", 1, 5, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "materials", 1, 11, missing));
        TConstructHelper.removeTableRecipe(getModItem("TConstruct", "materials", 1, 22, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("minecraft", "snowball", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 14, missing));
        TConstructHelper.removeMeltingRecipe(getModItem("ExtraUtilities", "cobblestone_compressed", 1, 15, missing));
        TConstructHelper.removeBasinRecipe(getModItem("IC2", "blockMetal", 1, 5, missing));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 2019, missing),
                GameRegistry.findBlock("gregtech", "gt.blockmachines"),
                1585,
                500,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 11019, missing),
                GameRegistry.findBlock("gregtech", "gt.blockmachines"),
                1585,
                500,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 19, missing),
                GameRegistry.findBlock("gregtech", "gt.blockmachines"),
                1585,
                500,
                FluidRegistry.getFluidStack("aluminum.molten", 16));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 1019, missing),
                GameRegistry.findBlock("gregtech", "gt.blockmachines"),
                1585,
                500,
                FluidRegistry.getFluidStack("aluminum.molten", 36));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 2890, missing),
                GameRegistry.findBlock("minecraft", "sand"),
                0,
                800,
                FluidRegistry.getFluidStack("glass.molten", 1000));
        Smeltery.addMelting(
                getModItem("TConstruct", "oreBerries", 1, 4, missing),
                GameRegistry.findBlock("gregtech", "gt.blockmachines"),
                1585,
                500,
                FluidRegistry.getFluidStack("aluminum.molten", 16));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 9035, missing),
                FluidRegistry.getFluidStack("copper.molten", 16),
                getModItem("TConstruct", "metalPattern", 1, 27, missing),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 9057, missing),
                FluidRegistry.getFluidStack("tin.molten", 16),
                getModItem("TConstruct", "metalPattern", 1, 27, missing),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 9032, missing),
                FluidRegistry.getFluidStack("iron.molten", 16),
                getModItem("TConstruct", "metalPattern", 1, 27, missing),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 9300, missing),
                FluidRegistry.getFluidStack("bronze.molten", 16),
                getModItem("TConstruct", "metalPattern", 1, 27, missing),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 11035, missing),
                FluidRegistry.getFluidStack("copper.molten", 144),
                getModItem("TConstruct", "metalPattern", 1, 0, missing),
                false,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 11057, missing),
                FluidRegistry.getFluidStack("tin.molten", 144),
                getModItem("TConstruct", "metalPattern", 1, 0, missing),
                false,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 11300, missing),
                FluidRegistry.getFluidStack("bronze.molten", 144),
                getModItem("TConstruct", "metalPattern", 1, 0, missing),
                false,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("TConstruct", "materials", 1, 14, missing),
                FluidRegistry.getFluidStack("aluminumbrass.molten", 144),
                getModItem("TConstruct", "metalPattern", 1, 0, missing),
                false,
                100);
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 1, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 2, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 3, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 4, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 5, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 6, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 7, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 8, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 9, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 10, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 11, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 12, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 13, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 14, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 15, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 16, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 17, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 18, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 19, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 20, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 21, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 22, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 25, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 26, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "metalPattern", 1, 27, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "Cast", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "Cast", 1, 1, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "Cast", 1, 2, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("TConstruct", "Cast", 1, 3, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 32, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1032, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2032, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3032, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4032, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 930, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1930, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2930, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3930, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4930, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 931, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1931, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2931, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3931, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4931, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 917, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1917, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2917, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3917, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4917, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 936, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1936, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2936, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3936, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4936, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 870, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1870, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 28706, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3870, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4870, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 834, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1834, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2834, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3834, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4834, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 35, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1035, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2035, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3035, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4035, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 871, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1871, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2871, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3871, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4871, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 840, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1840, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2840, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3840, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4840, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 855, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1855, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2855, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3855, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4855, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 57, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1057, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2057, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3057, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4057, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 824, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1824, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2824, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3824, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4824, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 937, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1937, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2937, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3937, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4937, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 86, missing),
                GameRegistry.findBlock("minecraft", "gold_ore"),
                0,
                600,
                FluidRegistry.getFluidStack("gold.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1086, missing),
                GameRegistry.findBlock("minecraft", "gold_ore"),
                0,
                600,
                FluidRegistry.getFluidStack("gold.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2086, missing),
                GameRegistry.findBlock("minecraft", "gold_ore"),
                0,
                600,
                FluidRegistry.getFluidStack("gold.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3086, missing),
                GameRegistry.findBlock("minecraft", "gold_ore"),
                0,
                600,
                FluidRegistry.getFluidStack("gold.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4086, missing),
                GameRegistry.findBlock("minecraft", "gold_ore"),
                0,
                600,
                FluidRegistry.getFluidStack("gold.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 19, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                5,
                400,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1019, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                5,
                400,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2019, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                5,
                400,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3019, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                5,
                400,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4019, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                5,
                400,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 34, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                34,
                400,
                FluidRegistry.getFluidStack("nickel.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1034, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                34,
                400,
                FluidRegistry.getFluidStack("nickel.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2034, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                34,
                400,
                FluidRegistry.getFluidStack("nickel.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3034, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                34,
                400,
                FluidRegistry.getFluidStack("nickel.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4034, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                34,
                400,
                FluidRegistry.getFluidStack("nickel.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 89, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                89,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1089, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                89,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2089, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                89,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3089, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                89,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4089, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                89,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 54, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                54,
                500,
                FluidRegistry.getFluidStack("silver.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1054, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                54,
                500,
                FluidRegistry.getFluidStack("silver.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2054, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                54,
                500,
                FluidRegistry.getFluidStack("silver.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3054, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                54,
                500,
                FluidRegistry.getFluidStack("silver.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4054, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                54,
                500,
                FluidRegistry.getFluidStack("silver.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 85, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                85,
                800,
                FluidRegistry.getFluidStack("platinum.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1085, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                85,
                800,
                FluidRegistry.getFluidStack("platinum.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2085, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                85,
                800,
                FluidRegistry.getFluidStack("platinum.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3085, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                85,
                800,
                FluidRegistry.getFluidStack("platinum.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4085, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                85,
                800,
                FluidRegistry.getFluidStack("platinum.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 501, missing),
                GameRegistry.findBlock("minecraft", "emerald_ore"),
                0,
                800,
                FluidRegistry.getFluidStack("emerald.liquid", 640));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 1501, missing),
                GameRegistry.findBlock("minecraft", "emerald_ore"),
                0,
                800,
                FluidRegistry.getFluidStack("emerald.liquid", 640));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 2501, missing),
                GameRegistry.findBlock("minecraft", "emerald_ore"),
                0,
                800,
                FluidRegistry.getFluidStack("emerald.liquid", 640));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 3501, missing),
                GameRegistry.findBlock("minecraft", "emerald_ore"),
                0,
                800,
                FluidRegistry.getFluidStack("emerald.liquid", 640));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.blockores", 1, 4501, missing),
                GameRegistry.findBlock("minecraft", "emerald_ore"),
                0,
                800,
                FluidRegistry.getFluidStack("emerald.liquid", 640));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32300, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32301, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32302, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32303, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32304, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32305, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32306, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32307, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32308, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32309, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32310, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32311, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32312, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32313, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32314, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32315, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32316, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32317, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32318, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32319, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32320, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32321, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32322, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32323, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32324, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32325, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32326, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32327, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32328, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32329, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32330, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32350, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32351, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32352, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32353, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32354, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32355, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32356, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32357, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32358, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32359, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32360, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32361, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32362, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32363, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32364, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32365, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32366, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32367, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32368, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32369, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32370, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32371, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32372, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32373, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32374, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32375, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 32376, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.ExtruderShapeBoat", 1, 0, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MarshmallowForm", 1, 0, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldChestplate", 1, 0, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldHelmet", 1, 0, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldLeggings", 1, 0, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("dreamcraft", "item.MoldBoots", 1, 0, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 2880, missing),
                GameRegistry.findBlock("TConstruct", "GlueBlock"),
                0,
                250,
                FluidRegistry.getFluidStack("glue", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 11880, missing),
                GameRegistry.findBlock("TConstruct", "GlueBlock"),
                0,
                300,
                FluidRegistry.getFluidStack("glue", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 17880, missing),
                GameRegistry.findBlock("TConstruct", "GlueBlock"),
                0,
                350,
                FluidRegistry.getFluidStack("glue", 288));
        Smeltery.addMelting(
                getModItem("EMT", "EMTItems", 1, 10, missing),
                GameRegistry.findBlock("TConstruct", "GlueBlock"),
                0,
                400,
                FluidRegistry.getFluidStack("glue", 576));
        Smeltery.addMelting(
                getModItem("EMT", "EMTItems", 1, 8, missing),
                GameRegistry.findBlock("TConstruct", "GlueBlock"),
                0,
                200,
                FluidRegistry.getFluidStack("glue", 288));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 11033, missing),
                GameRegistry.findBlock("TConstruct", "GravelOre"),
                5,
                650,
                FluidRegistry.getFluidStack("cobalt.molten", 144));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("TConstruct", "materials", 1, 12, missing),
                FluidRegistry.getFluidStack("aluminum.molten", 144),
                getModItem("TConstruct", "metalPattern", 1, 0, missing),
                false,
                200);
        Smeltery.addMelting(
                getModItem("TConstruct", "materials", 1, 12, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                6,
                500,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 11305, missing),
                FluidRegistry.getFluidStack("steel.molten", 144),
                getModItem("TConstruct", "metalPattern", 1, 0, missing),
                false,
                800);
        TConstructRegistry.getBasinCasting().addCastingRecipe(
                getModItem("TConstruct", "Smeltery", 1, 4, missing),
                FluidRegistry.getFluidStack("stone.seared", 360),
                null,
                false,
                245);
        TConstructRegistry.getBasinCasting().addCastingRecipe(
                getModItem("TConstruct", "Smeltery", 1, 5, missing),
                FluidRegistry.getFluidStack("stone.seared", 360),
                getModItem("minecraft", "cobblestone", 1, 0, missing),
                false,
                245);
        Smeltery.addMelting(
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 0, missing),
                GameRegistry.findBlock("minecraft", "obsidian"),
                0,
                850,
                FluidRegistry.getFluidStack("obsidian.molten", 288));
        Smeltery.addMelting(
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing),
                GameRegistry.findBlock("minecraft", "obsidian"),
                0,
                850,
                FluidRegistry.getFluidStack("obsidian.molten", 288));
        TConstructRegistry.getBasinCasting().addCastingRecipe(
                getModItem("TConstruct", "MetalBlock", 1, 10, missing),
                FluidRegistry.getFluidStack("ender", 2250),
                null,
                false,
                250);
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 2089, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                4,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 11089, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                4,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 9089, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                4,
                400,
                FluidRegistry.getFluidStack("lead.molten", 16));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 17089, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                4,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                getModItem("gregtech", "gt.metaitem.01", 1, 23089, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                4,
                400,
                FluidRegistry.getFluidStack("lead.molten", 72));
        Smeltery.addMelting(
                getModItem("IC2", "blockMetal", 1, 4, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                4,
                400,
                FluidRegistry.getFluidStack("lead.molten", 1296));
        Smeltery.addMelting(
                getModItem("TConstruct", "MetalBlock", 1, 10, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                10,
                250,
                FluidRegistry.getFluidStack("ender", 2250));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("minecraft", "glass_bottle", 1, 0, missing),
                FluidRegistry.getFluidStack("glass.molten", 144),
                getModItem("gregtech", "gt.metaitem.01", 1, 32305, missing),
                false,
                200);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("TConstruct", "strangeFood", 4, 0, missing))
                .itemOutputs(getModItem("TConstruct", "slime.gel", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "slime_ball", 4, 0, missing))
                .itemOutputs(getModItem("TConstruct", "slime.gel", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sCompressorRecipes);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("IC2", "itemArmorBronzeHelmet", 1, 0, missing),
                FluidRegistry.getFluidStack("bronze.molten", 720),
                getModItem("dreamcraft", "item.MoldHelmet", 1, 0, missing),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("IC2", "itemArmorBronzeChestplate", 1, 0, missing),
                FluidRegistry.getFluidStack("bronze.molten", 1152),
                getModItem("dreamcraft", "item.MoldChestplate", 1, 0, missing),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("IC2", "itemArmorBronzeLegs", 1, 0, missing),
                FluidRegistry.getFluidStack("bronze.molten", 1008),
                getModItem("dreamcraft", "item.MoldLeggings", 1, 0, missing),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("IC2", "itemArmorBronzeBoots", 1, 0, missing),
                FluidRegistry.getFluidStack("bronze.molten", 576),
                getModItem("dreamcraft", "item.MoldBoots", 1, 0, missing),
                false,
                400);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("Railcraft", "armor.steel.helmet", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 720),
                getModItem("dreamcraft", "item.MoldHelmet", 1, 0, missing),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("Railcraft", "armor.steel.plate", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 1152),
                getModItem("dreamcraft", "item.MoldChestplate", 1, 0, missing),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("Railcraft", "armor.steel.legs", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 1008),
                getModItem("dreamcraft", "item.MoldLeggings", 1, 0, missing),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("Railcraft", "armor.steel.boots", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem("dreamcraft", "item.MoldBoots", 1, 0, missing),
                false,
                400);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("minecraft", "iron_helmet", 1, 0, missing),
                FluidRegistry.getFluidStack("iron.molten", 720),
                getModItem("dreamcraft", "item.MoldHelmet", 1, 0, missing),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("minecraft", "iron_chestplate", 1, 0, missing),
                FluidRegistry.getFluidStack("iron.molten", 1152),
                getModItem("dreamcraft", "item.MoldChestplate", 1, 0, missing),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("minecraft", "iron_leggings", 1, 0, missing),
                FluidRegistry.getFluidStack("iron.molten", 1008),
                getModItem("dreamcraft", "item.MoldLeggings", 1, 0, missing),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("minecraft", "iron_boots", 1, 0, missing),
                FluidRegistry.getFluidStack("iron.molten", 576),
                getModItem("dreamcraft", "item.MoldBoots", 1, 0, missing),
                false,
                400);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("minecraft", "golden_helmet", 1, 0, missing),
                FluidRegistry.getFluidStack("gold.molten", 720),
                getModItem("dreamcraft", "item.MoldHelmet", 1, 0, missing),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("minecraft", "golden_chestplate", 1, 0, missing),
                FluidRegistry.getFluidStack("gold.molten", 1152),
                getModItem("dreamcraft", "item.MoldChestplate", 1, 0, missing),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("minecraft", "golden_leggings", 1, 0, missing),
                FluidRegistry.getFluidStack("gold.molten", 1008),
                getModItem("dreamcraft", "item.MoldLeggings", 1, 0, missing),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem("minecraft", "golden_boots", 1, 0, missing),
                FluidRegistry.getFluidStack("gold.molten", 576),
                getModItem("dreamcraft", "item.MoldBoots", 1, 0, missing),
                false,
                400);
        Smeltery.addAlloyMixing(
                FluidRegistry.getFluidStack("alumite.molten", 32),
                FluidRegistry.getFluidStack("aluminum.molten", 80),
                FluidRegistry.getFluidStack("steel.molten", 32),
                FluidRegistry.getFluidStack("obsidian.molten", 32));
        Smeltery.addSmelteryFuel(FluidRegistry.getFluid("ic2hotcoolant"), 900, 55);
        Smeltery.addSmelteryFuel(FluidRegistry.getFluid("ic2pahoehoelava"), 3000, 90);
        DryingRackRecipes.addDryingRecipe(
                getModItem("TConstruct", "strangeFood", 1, 1, missing),
                6000,
                getModItem("TConstruct", "jerky", 1, 7, missing));
        DryingRackRecipes.addDryingRecipe(
                getModItem("TConstruct", "strangeFood", 1, 0, missing),
                6000,
                getModItem("TConstruct", "jerky", 1, 6, missing));
        DryingRackRecipes.addDryingRecipe(
                getModItem("harvestcraft", "muttonrawItem", 1, 0, missing),
                12000,
                getModItem("TConstruct", "jerky", 1, 3, missing));

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
