package com.dreammaster.scripts;

import static com.dreammaster.scripts.TemporaryMods.TinkersMechworks;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.BuildCraftCore;
import static gregtech.api.enums.Mods.ElectroMagicTools;
import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.ForgeMicroblocks;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IguanaTweaksTinkerConstruct;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCompressorRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.oredict.OreDictHelper;
import com.dreammaster.tinkersConstruct.TConstructHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_ModHandler;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.DryingRackRecipes;
import tconstruct.library.crafting.Smeltery;

public class ScriptTinkersConstruct implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Tinkers Construct";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                TinkerConstruct.ID,
                RandomThings.ID,
                TinkersMechworks.ID,
                BloodArsenal.ID,
                BuildCraftCore.ID,
                ElectroMagicTools.ID,
                ExtraTrees.ID,
                ExtraUtilities.ID,
                Forestry.ID,
                ForgeMicroblocks.ID,
                GalaxySpace.ID,
                IguanaTweaksTinkerConstruct.ID,
                IndustrialCraft2.ID,
                Natura.ID,
                PamsHarvestCraft.ID,
                Railcraft.ID,
                Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        OreDictionary.registerOre("bucketEnder", getModItem(TinkerConstruct.ID, "buckets", 1, 23, missing));
        OreDictHelper.removeOreDict("nuggetAluminium", getModItem(TinkerConstruct.ID, "oreBerries", 1, 4, missing));

        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "LavaTank", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing), null,
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "LavaTankNether", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing), null,
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(Minecraft.ID, "furnace", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(Natura.ID, "NetherFurnace", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 2, 2, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 2, 2, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SmelteryNether", 2, 2, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(Minecraft.ID, "lava_bucket", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SmelteryNether", 2, 2, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketLava", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 1, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 1, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlock", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "materials", 1, 2, missing), null,
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 4, missing),
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing), null,
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlockNether", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "materials", 1, 37, missing), null,
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing), null,
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlock", 1, 2, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing), null,
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing), null,
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlockNether", 1, 2, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing), null,
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing), null,
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "materials", 1, 2, missing), null,
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing), null,
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 1, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "materials", 1, 37, missing), null,
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing), null,
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlock", 2, 1, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlockNether", 2, 1, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "CastingChannel", 1, 1, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlock", 1, 1, missing),
                new Object[] { null, null, null, getModItem(TinkerConstruct.ID, "materials", 1, 2, missing), null,
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlockNether", 1, 1, missing),
                new Object[] { null, null, null, getModItem(TinkerConstruct.ID, "materials", 1, 37, missing), null,
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                        getModItem(TinkerConstruct.ID, "materials", 1, 37, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "LavaTank", 1, 1, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing), "glassReinforced",
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing), "glassReinforced", "blockGlass",
                        "glassReinforced", getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing), "glassReinforced",
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "LavaTankNether", 1, 1, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing), "glassReinforced",
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing), "glassReinforced",
                        "blockGlass", "glassReinforced",
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing), "glassReinforced",
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "LavaTank", 1, 2, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing), "glassReinforced",
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing), "blockGlass",
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing), "glassReinforced",
                        getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "LavaTankNether", 1, 2, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing), "glassReinforced",
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing), "blockGlass",
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing), "glassReinforced",
                        getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "helmetWood", 1, 0, missing),
                new Object[] { "logWood", "logWood", "logWood", "logWood", "craftingToolSoftHammer", "logWood", null,
                        null, null });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "chestplateWood", 1, 0, missing),
                new Object[] { "logWood", "craftingToolSoftHammer", "logWood", "logWood", "logWood", "logWood",
                        "logWood", "logWood", "logWood" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "leggingsWood", 1, 0, missing),
                new Object[] { "logWood", "logWood", "logWood", "logWood", "craftingToolSoftHammer", "logWood",
                        "logWood", null, "logWood" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "bootsWood", 1, 0, missing),
                new Object[] { "logWood", "craftingToolSoftHammer", "logWood", "logWood", null, "logWood", null, null,
                        null });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPane", 2, 0, missing),
                new Object[] { "craftingToolSaw", null, null, null,
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                new Object[] { "sand", "sand", "sand", "dustClay",
                        getModItem(Minecraft.ID, "water_bucket", 1, 0, missing), "dustClay",
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                new Object[] { getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing), "dustClay",
                        getModItem(Minecraft.ID, "water_bucket", 1, 0, missing), "dustClay", "sand", "sand", "sand" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                new Object[] { "sand", "dustClay", getModItem(Minecraft.ID, "gravel", 1, 0, missing), "sand",
                        getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing), "sand", "dustClay",
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                new Object[] { getModItem(Minecraft.ID, "gravel", 1, 0, missing), "dustClay", "sand",
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                        getModItem(Minecraft.ID, "water_bucket", 1, 0, missing), "sand",
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing), "dustClay", "sand" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                new Object[] { "sand", "sand", "sand", "dustClay",
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing), "dustClay",
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                new Object[] { getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing), "dustClay",
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing), "dustClay",
                        "sand", "sand", "sand" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                new Object[] { "sand", "dustClay", getModItem(Minecraft.ID, "gravel", 1, 0, missing), "sand",
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing), "sand", "dustClay",
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                new Object[] { getModItem(Minecraft.ID, "gravel", 1, 0, missing), "dustClay", "sand",
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing), "sand",
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing), "dustClay", "sand" });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing),
                new Object[] { getModItem(Minecraft.ID, "nether_wart", 1, 0, missing),
                        getModItem(Minecraft.ID, "soul_sand", 1, 0, missing),
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                        getModItem(Minecraft.ID, "water_bucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing),
                new Object[] { getModItem(Minecraft.ID, "nether_wart", 1, 0, missing),
                        getModItem(Minecraft.ID, "soul_sand", 1, 0, missing),
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing),
                new Object[] { getModItem(Minecraft.ID, "nether_wart", 1, 0, missing),
                        getModItem(Natura.ID, "soil.tainted", 1, 0, missing),
                        getModItem(Natura.ID, "heatsand", 1, 0, missing),
                        getModItem(Minecraft.ID, "water_bucket", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing),
                new Object[] { getModItem(Minecraft.ID, "nether_wart", 1, 0, missing),
                        getModItem(Natura.ID, "soil.tainted", 1, 0, missing),
                        getModItem(Natura.ID, "heatsand", 1, 0, missing),
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                new Object[] { "platePaper", "platePaper", "platePaper", "platePaper" });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftingStation", 1, 0, missing),
                new Object[] { "craftingToolSaw", "craftingTableWood" });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "CraftingStation", 1, 0, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 0, missing),
                new Object[] { "stickWood", getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), "stickWood",
                        "stickWood", getModItem(TinkerConstruct.ID, "CraftingStation", 1, 0, missing), "stickWood",
                        null, "craftingToolSoftHammer", null });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 0, missing),
                new Object[] { "stickWood", getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), "stickWood",
                        "stickWood", getModItem(Minecraft.ID, "crafting_table", 1, 0, missing), "stickWood", null,
                        "craftingToolSoftHammer", null });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1, missing),
                new Object[] { "stickWood", getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), "stickWood",
                        getModItem(TinkerConstruct.ID, "trap.barricade.oak", 1, 0, missing), "stickWood",
                        getModItem(TinkerConstruct.ID, "trap.barricade.oak", 1, 0, missing), null,
                        "craftingToolSoftHammer", null });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 4, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 2, missing),
                new Object[] { "stickWood", getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), "stickWood",
                        getModItem(TinkerConstruct.ID, "trap.barricade.spruce", 1, 0, missing), "stickWood",
                        getModItem(TinkerConstruct.ID, "trap.barricade.spruce", 1, 0, missing), null,
                        "craftingToolSoftHammer", null });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 3, missing),
                new Object[] { "stickWood", getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), "stickWood",
                        getModItem(TinkerConstruct.ID, "trap.barricade.birch", 1, 0, missing), "stickWood",
                        getModItem(TinkerConstruct.ID, "trap.barricade.birch", 1, 0, missing), null,
                        "craftingToolSoftHammer", null });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 4, missing),
                new Object[] { "stickWood", getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), "stickWood",
                        getModItem(TinkerConstruct.ID, "trap.barricade.jungle", 1, 0, missing), "stickWood",
                        getModItem(TinkerConstruct.ID, "trap.barricade.jungle", 1, 0, missing), null,
                        "craftingToolSoftHammer", null });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 4, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 5, missing),
                new Object[] { "stickWood", getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), "stickWood",
                        "stickWood", getModItem(Minecraft.ID, "chest", 1, 0, missing), "stickWood", null,
                        "craftingToolSoftHammer", null });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 4, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 5, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing),
                new Object[] { "stickWood", getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), "stickWood",
                        "fenceWood", "stickWood", "fenceWood", null, "craftingToolSoftHammer", null });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 11, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 12, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 13, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 11, missing),
                new Object[] { "stickWood", getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:65537}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:65537}", missing), null,
                        "craftingToolSoftHammer", null });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 12, missing),
                new Object[] { "stickWood", getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:131074}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:131074}", missing), null,
                        "craftingToolSoftHammer", null });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 13, missing),
                new Object[] { "stickWood", getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:196611}", missing), "stickWood",
                        createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:196611}", missing), null,
                        "craftingToolSoftHammer", null });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 11, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 12, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 13, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                        getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing), "blockIron",
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing), "blockIron", "blockIron",
                        "craftingToolHardHammer", "blockIron" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 1, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                        getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing), "blockGold",
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing), "blockGold", "blockGold",
                        "craftingToolHardHammer", "blockGold" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 2, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                        getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing), "blockDiamond",
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing), "blockDiamond", "blockDiamond",
                        "craftingToolHardHammer", "blockDiamond" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 3, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                        getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing), "blockEmerald",
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing), "blockEmerald", "blockEmerald",
                        "craftingToolHardHammer", "blockEmerald" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 4, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                        getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing), "blockCobalt",
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing), "blockCobalt", "blockCobalt",
                        "craftingToolHardHammer", "blockCobalt" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 5, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                        getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing), "blockArdite",
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing), "blockArdite", "blockArdite",
                        "craftingToolHardHammer", "blockArdite" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 6, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                        getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing), "blockManyullyn",
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing), "blockManyullyn",
                        "blockManyullyn", "craftingToolHardHammer", "blockManyullyn" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 7, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                        getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing), "blockCopper",
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing), "blockCopper", "blockCopper",
                        "craftingToolHardHammer", "blockCopper" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 8, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                        getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing), "blockBronze",
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing), "blockBronze", "blockBronze",
                        "craftingToolHardHammer", "blockBronze" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 9, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                        getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing), "blockTin",
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing), "blockTin", "blockTin",
                        "craftingToolHardHammer", "blockTin" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 10, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                        getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing), "blockAluminium",
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing), "blockAluminium",
                        "blockAluminium", "craftingToolHardHammer", "blockAluminium" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 11, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                        getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing), "blockAluminiumBrass",
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing), "blockAluminiumBrass",
                        "blockAluminiumBrass", "craftingToolHardHammer", "blockAluminiumBrass" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 12, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                        getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing), "blockAlumite",
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing), "blockAlumite", "blockAlumite",
                        "craftingToolHardHammer", "blockAlumite" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 13, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                        getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing), "blockSteel",
                        getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing), "blockSteel", "blockSteel",
                        "craftingToolHardHammer", "blockSteel" });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "FurnaceSlab", 1, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Minecraft.ID, "furnace", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 5, missing),
                new Object[] { "craftingToolSaw",
                        getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 32767, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 1, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "Smeltery", 1, 4, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 2, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "Smeltery", 1, 5, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 3, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "Smeltery", 1, 6, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 4, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "Smeltery", 1, 8, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 5, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "Smeltery", 1, 9, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 6, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "Smeltery", 1, 10, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 7, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "Smeltery", 1, 11, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 7, missing),
                new Object[] { "craftingToolHardHammer", getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 1, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 2, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 3, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 4, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 4, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 5, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 5, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 6, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 6, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 7, missing),
                new Object[] { "craftingToolSaw", getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 7, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "trap.punji", 2, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "reeds", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "reeds", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "reeds", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "reeds", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "reeds", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 0, missing),
                new Object[] { "craftingToolShears", getModItem(Minecraft.ID, "wool", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 1, missing),
                new Object[] { "craftingToolShears", getModItem(Minecraft.ID, "wool", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 2, missing),
                new Object[] { "craftingToolShears", getModItem(Minecraft.ID, "wool", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 3, missing),
                new Object[] { "craftingToolShears", getModItem(Minecraft.ID, "wool", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 4, missing),
                new Object[] { "craftingToolShears", getModItem(Minecraft.ID, "wool", 1, 4, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 5, missing),
                new Object[] { "craftingToolShears", getModItem(Minecraft.ID, "wool", 1, 5, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 6, missing),
                new Object[] { "craftingToolShears", getModItem(Minecraft.ID, "wool", 1, 6, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 7, missing),
                new Object[] { "craftingToolShears", getModItem(Minecraft.ID, "wool", 1, 7, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 0, missing),
                new Object[] { "craftingToolShears", getModItem(Minecraft.ID, "wool", 1, 8, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 1, missing),
                new Object[] { "craftingToolShears", getModItem(Minecraft.ID, "wool", 1, 9, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 2, missing),
                new Object[] { "craftingToolShears", getModItem(Minecraft.ID, "wool", 1, 10, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 3, missing),
                new Object[] { "craftingToolShears", getModItem(Minecraft.ID, "wool", 1, 11, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 4, missing),
                new Object[] { "craftingToolShears", getModItem(Minecraft.ID, "wool", 1, 12, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 5, missing),
                new Object[] { "craftingToolShears", getModItem(Minecraft.ID, "wool", 1, 13, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 6, missing),
                new Object[] { "craftingToolShears", getModItem(Minecraft.ID, "wool", 1, 14, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 7, missing),
                new Object[] { "craftingToolShears", getModItem(Minecraft.ID, "wool", 1, 15, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "trap.barricade.oak", 1, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "log", 1, 0, missing), null,
                        getModItem(Minecraft.ID, "log", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "log", 1, 0, missing), null,
                        getModItem(Minecraft.ID, "log", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "trap.barricade.spruce", 1, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "log", 1, 1, missing), null,
                        getModItem(Minecraft.ID, "log", 1, 1, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "log", 1, 1, missing), null,
                        getModItem(Minecraft.ID, "log", 1, 1, missing), null });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "trap.barricade.birch", 1, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "log", 1, 2, missing), null,
                        getModItem(Minecraft.ID, "log", 1, 2, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "log", 1, 2, missing), null,
                        getModItem(Minecraft.ID, "log", 1, 2, missing), null });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "trap.barricade.jungle", 1, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "log", 1, 3, missing), null,
                        getModItem(Minecraft.ID, "log", 1, 3, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "log", 1, 3, missing), null,
                        getModItem(Minecraft.ID, "log", 1, 3, missing), null });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "slime.channel", 1, 0, missing),
                new Object[] { "slimeball", "slimeball", "slimeball", "dustRedstone",
                        getModItem(Minecraft.ID, "water_bucket", 1, 0, missing), "dustRedstone", "slimeball",
                        "slimeball", "slimeball" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "blood.channel", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing), "dustRedstone",
                        getModItem(Minecraft.ID, "water_bucket", 1, 0, missing), "dustRedstone",
                        getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "slime.pad", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "slime.gel", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "slime.gel", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "slime.gel", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "slime.channel", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "slime.gel", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "slime.channel", 1, 0, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                        getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                        getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                        getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1, missing),
                        getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                        getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                        getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                        getModItem(Minecraft.ID, "slime_ball", 1, 0, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 2, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                        getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1, missing),
                        getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 3, missing),
                new Object[] { "dustBone", getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing), "dustBone",
                        getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing),
                        getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                        getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing), "dustBone",
                        getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing), "dustBone" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeWhite",
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeWhite" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 1, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeOrange",
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 1, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeOrange" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 2, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeMagenta",
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 2, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeMagenta" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 3, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeLightBlue",
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 3, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeLightBlue" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 4, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeYellow",
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 4, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeYellow" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 5, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeLime",
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 5, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeLime" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 6, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyePink",
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 6, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyePink" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 7, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeGray",
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 7, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeGray" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 8, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeLightGray",
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 8, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeLightGray" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 9, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeCyan",
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 9, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeCyan" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 10, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyePurple",
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 10, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyePurple" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 11, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeBlue",
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 11, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeBlue" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 12, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeBrown",
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 12, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeBrown" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 13, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeGreen",
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 13, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeGreen" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 14, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeRed",
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 14, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeRed" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 15, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeBlack",
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 15, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing), "dyeBlack" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeWhite",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeWhite" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 1, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeOrange",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 1, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeOrange" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 2, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeMagenta",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 2, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeMagenta" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 3, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeLightBlue",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 3, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeLightBlue" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 4, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeYellow",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 4, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeYellow" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 5, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeLime",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 5, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeLime" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 6, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyePink",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 6, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyePink" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 7, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeGray",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 7, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeGray" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 8, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeLightGray",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 8, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeLightGray" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 9, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeCyan",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 9, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeCyan" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 10, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyePurple",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 10, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyePurple" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 11, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeBlue",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 11, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeBlue" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 12, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeBrown",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 12, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeBrown" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 13, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeGreen",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 13, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeGreen" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 14, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeRed",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 14, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeRed" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 15, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeBlack",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 15, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "dyeBlack" });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 0, missing),
                new Object[] { "slabWood", "slabWood", "slabWood", "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 5, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 5, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 0, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                        getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                        getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone", 1, 0, missing),
                        getModItem(Railcraft.ID, "detector", 1, 1, missing),
                        getModItem(Minecraft.ID, "stone", 1, 0, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 1, missing),
                new Object[] { getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                        getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                        getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone", 1, 0, missing),
                        getModItem(Railcraft.ID, "detector", 1, 3, missing),
                        getModItem(Minecraft.ID, "stone", 1, 0, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 2, missing),
                new Object[] { getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                        getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                        getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone", 1, 0, missing),
                        getModItem(Railcraft.ID, "detector", 1, 5, missing),
                        getModItem(Minecraft.ID, "stone", 1, 0, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 3, missing),
                new Object[] { getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                        getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                        getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone", 1, 0, missing),
                        getModItem(Railcraft.ID, "detector", 1, 4, missing),
                        getModItem(Minecraft.ID, "stone", 1, 0, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "materials", 1, 40, missing),
                new Object[] { null, null, getModItem(GregTech.ID, "gt.metaitem.01", 1, 2019, missing), null, null,
                        null, null, null, null });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2019, missing),
                new Object[] { null, null, getModItem(TinkerConstruct.ID, "materials", 1, 40, missing), null, null,
                        null, null, null, null });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "toolRod", 1, 6, missing),
                new Object[] { getModItem(RandomThings.ID, "ingredient", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "toolRod", 1, 6, missing) });
        addShapelessCraftingRecipe(
                getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 23804, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23804, missing),
                new Object[] { getModItem(RandomThings.ID, "ingredient", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "toolRod", 1, 6, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 23804, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23804, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "toolRod", 1, 6, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                new Object[] { getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0, missing) });
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelGoggles",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:0.0d,Built:1b,MaxDefense:4.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "boltElectrum",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "ringElectrum",
                        getModItem(Minecraft.ID, "diamond_helmet", 1, 0, missing), "ringElectrum", "lensDiamond",
                        "circuitAdvanced", "lensDiamond" });
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelVest",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:4.0d,Built:1b,MaxDefense:10.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "circuitAdvanced",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "plateObsidian",
                        getModItem(Minecraft.ID, "diamond_chestplate", 1, 0, missing), "plateObsidian",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "plateObsidian",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing) });
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelGlove",
                        1,
                        0,
                        "{TinkerAccessory:{BaseDurability:500,Built:1b,Damage:0,BonusDurability:0,TotalDurability:500,ModDurability:0.0f,Modifiers:5,Broken:0b}}",
                        missing),
                new Object[] { null, getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "plateDiamond", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), null,
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "circuitAdvanced" });
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelWings",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:2.0d,Built:1b,MaxDefense:8.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                new Object[] { "plateDiamond", getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        "plateDiamond", getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing), "circuitAdvanced",
                        getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing),
                        getModItem(Minecraft.ID, "diamond_leggings", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing) });
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelBelt",
                        1,
                        0,
                        "{TinkerAccessory:{BaseDurability:500,Built:1b,Damage:0,BonusDurability:0,TotalDurability:500,ModDurability:0.0f,Modifiers:5,Broken:0b}}",
                        missing),
                new Object[] { null, "circuitAdvanced", null,
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), "plateDiamond",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing), null,
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing) });
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelBoots",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:2.0d,Built:1b,MaxDefense:6.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                new Object[] { null, "plateDiamond", "plateDiamond", null,
                        getModItem(Minecraft.ID, "diamond_boots", 1, 0, missing), "circuitAdvanced",
                        getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32642, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32642, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "materials", 1, 3, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11033, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11033, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "materials", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem(TinkerConstruct.ID, "materials", 1, 5, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11386, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11386, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "materials", 1, 5, missing) });
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "decoration.stoneladder", 4, 0, missing),
                new Object[] { getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(TinkersMechworks.ID, "LengthWire", 1, 0, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(TinkersMechworks.ID, "LengthWire", 1, 0, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing) });

        TConstructHelper.removeBasinRecipe(getModItem(Minecraft.ID, "iron_block", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem(Minecraft.ID, "gold_block", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem(Minecraft.ID, "obsidian", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem(Minecraft.ID, "emerald_block", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 1, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 2, missing));
        TConstructHelper.removeBasinRecipe(getModItem(IndustrialCraft2.ID, "blockMetal", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem(IndustrialCraft2.ID, "blockMetal", 1, 2, missing));
        TConstructHelper.removeBasinRecipe(getModItem(IndustrialCraft2.ID, "blockMetal", 1, 1, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 6, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 7, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 8, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "GlueBlock", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem(GregTech.ID, "gt.blockmetal5", 1, 11, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 2, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "Smeltery", 1, 4, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "Smeltery", 1, 5, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GregTech.ID, "gt.blockores", 1, 33, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "SearedBrick", 1, 1, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GalaxySpace.ID, "phobosblocks", 1, 4, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "GravelOre", 1, 5, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 39, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2033, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "SearedBrick", 1, 2, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GregTech.ID, "gt.blockores", 1, 382, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 38, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2382, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 29, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GregTech.ID, "gt.metaitem.01", 1, 9382, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 1, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 41, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2386, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 30, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GregTech.ID, "gt.metaitem.01", 1, 9386, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 2, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10, missing));
        TConstructHelper.removeTableRecipe(getModItem(BuildCraftCore.ID, "ironGearItem", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(BuildCraftCore.ID, "goldGearItem", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(Forestry.ID, "gearBronze", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(Forestry.ID, "gearCopper", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(Forestry.ID, "gearTin", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(GregTech.ID, "gt.metaitem.02", 1, 31085, missing));
        TConstructHelper.removeTableRecipe(getModItem(GregTech.ID, "gt.metaitem.02", 1, 31034, missing));
        TConstructHelper.removeTableRecipe(getModItem(GregTech.ID, "gt.metaitem.02", 1, 31054, missing));
        TConstructHelper.removeTableRecipe(getModItem(GregTech.ID, "gt.metaitem.02", 1, 31303, missing));
        TConstructHelper.removeTableRecipe(getModItem(GregTech.ID, "gt.metaitem.02", 1, 31302, missing));
        TConstructHelper.removeTableRecipe(getModItem(GregTech.ID, "gt.metaitem.02", 1, 31089, missing));
        TConstructHelper.removeTableRecipe(getModItem(GregTech.ID, "gt.metaitem.02", 1, 31305, missing));
        TConstructHelper.removeTableRecipe(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 1, missing));
        TConstructHelper.removeTableRecipe(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 2, missing));
        TConstructHelper.removeTableRecipe(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 3, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "chainmail_helmet", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "chainmail_chestplate", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "chainmail_leggings", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "chainmail_boots", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GregTech.ID, "gt.metaitem.01", 1, 9033, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 3, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GregTech.ID, "gt.metaitem.01", 1, 11033, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GalaxySpace.ID, "item.Ingots", 1, 1, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GregTech.ID, "gt.blockmetal2", 1, 5, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "sand", 1, 0, missing));
        TConstructHelper.removeSmelterAlloyMix(FluidRegistry.getFluidStack("alumite.molten", 32));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1, missing));
        TConstructHelper.removeTableRecipe(getModItem(Minecraft.ID, "golden_apple", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "gearCast", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(GregTech.ID, "gt.metaitem.02", 1, 31321, missing));
        TConstructHelper.removeTableRecipe(getModItem(GregTech.ID, "gt.metaitem.02", 1, 31382, missing));
        TConstructHelper.removeTableRecipe(getModItem(GregTech.ID, "gt.metaitem.02", 1, 31386, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 29, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 30, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 4, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 5, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 11, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 22, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "snowball", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 14, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(ExtraUtilities.ID, "cobblestone_compressed", 1, 15, missing));
        TConstructHelper.removeBasinRecipe(getModItem(IndustrialCraft2.ID, "blockMetal", 1, 5, missing));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2019, missing),
                GameRegistry.findBlock("gregtech", "gt.blockmachines"),
                1585,
                500,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11019, missing),
                GameRegistry.findBlock("gregtech", "gt.blockmachines"),
                1585,
                500,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 19, missing),
                GameRegistry.findBlock("gregtech", "gt.blockmachines"),
                1585,
                500,
                FluidRegistry.getFluidStack("aluminum.molten", 16));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 1019, missing),
                GameRegistry.findBlock("gregtech", "gt.blockmachines"),
                1585,
                500,
                FluidRegistry.getFluidStack("aluminum.molten", 36));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2890, missing),
                GameRegistry.findBlock("minecraft", "sand"),
                0,
                800,
                FluidRegistry.getFluidStack("glass.molten", 1000));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "oreBerries", 1, 4, missing),
                GameRegistry.findBlock("gregtech", "gt.blockmachines"),
                1585,
                500,
                FluidRegistry.getFluidStack("aluminum.molten", 16));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 9035, missing),
                FluidRegistry.getFluidStack("copper.molten", 16),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27, missing),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 9057, missing),
                FluidRegistry.getFluidStack("tin.molten", 16),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27, missing),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 9032, missing),
                FluidRegistry.getFluidStack("iron.molten", 16),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27, missing),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 9300, missing),
                FluidRegistry.getFluidStack("bronze.molten", 16),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27, missing),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11035, missing),
                FluidRegistry.getFluidStack("copper.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0, missing),
                false,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11057, missing),
                FluidRegistry.getFluidStack("tin.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0, missing),
                false,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11300, missing),
                FluidRegistry.getFluidStack("bronze.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0, missing),
                false,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(TinkerConstruct.ID, "materials", 1, 14, missing),
                FluidRegistry.getFluidStack("aluminumbrass.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0, missing),
                false,
                100);
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 1, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 2, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 3, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 4, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 5, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 6, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 7, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 8, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 9, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 10, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 11, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 12, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 13, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 14, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 15, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 16, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 17, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 18, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 19, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 20, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 21, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 22, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 25, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 26, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "Cast", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "Cast", 1, 1, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "Cast", 1, 2, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "Cast", 1, 3, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 32, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1032, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2032, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3032, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4032, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 930, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1930, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2930, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3930, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4930, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 931, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1931, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2931, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3931, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4931, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 917, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1917, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2917, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3917, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4917, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 936, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1936, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2936, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3936, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4936, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 870, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1870, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 28706, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3870, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4870, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 834, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1834, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2834, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3834, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4834, missing),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 35, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1035, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2035, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3035, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4035, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 871, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1871, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2871, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3871, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4871, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 840, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1840, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2840, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3840, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4840, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 855, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1855, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2855, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3855, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4855, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 57, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1057, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2057, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3057, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4057, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 824, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1824, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2824, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3824, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4824, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 937, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1937, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2937, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3937, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4937, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 86, missing),
                GameRegistry.findBlock("minecraft", "gold_ore"),
                0,
                600,
                FluidRegistry.getFluidStack("gold.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1086, missing),
                GameRegistry.findBlock("minecraft", "gold_ore"),
                0,
                600,
                FluidRegistry.getFluidStack("gold.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2086, missing),
                GameRegistry.findBlock("minecraft", "gold_ore"),
                0,
                600,
                FluidRegistry.getFluidStack("gold.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3086, missing),
                GameRegistry.findBlock("minecraft", "gold_ore"),
                0,
                600,
                FluidRegistry.getFluidStack("gold.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4086, missing),
                GameRegistry.findBlock("minecraft", "gold_ore"),
                0,
                600,
                FluidRegistry.getFluidStack("gold.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 19, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                5,
                400,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1019, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                5,
                400,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2019, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                5,
                400,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3019, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                5,
                400,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4019, missing),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                5,
                400,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 34, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                34,
                400,
                FluidRegistry.getFluidStack("nickel.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1034, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                34,
                400,
                FluidRegistry.getFluidStack("nickel.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2034, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                34,
                400,
                FluidRegistry.getFluidStack("nickel.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3034, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                34,
                400,
                FluidRegistry.getFluidStack("nickel.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4034, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                34,
                400,
                FluidRegistry.getFluidStack("nickel.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 89, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                89,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1089, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                89,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2089, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                89,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3089, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                89,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4089, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                89,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 54, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                54,
                500,
                FluidRegistry.getFluidStack("silver.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1054, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                54,
                500,
                FluidRegistry.getFluidStack("silver.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2054, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                54,
                500,
                FluidRegistry.getFluidStack("silver.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3054, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                54,
                500,
                FluidRegistry.getFluidStack("silver.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4054, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                54,
                500,
                FluidRegistry.getFluidStack("silver.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 85, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                85,
                800,
                FluidRegistry.getFluidStack("platinum.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1085, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                85,
                800,
                FluidRegistry.getFluidStack("platinum.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2085, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                85,
                800,
                FluidRegistry.getFluidStack("platinum.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3085, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                85,
                800,
                FluidRegistry.getFluidStack("platinum.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4085, missing),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                85,
                800,
                FluidRegistry.getFluidStack("platinum.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 501, missing),
                GameRegistry.findBlock("minecraft", "emerald_ore"),
                0,
                800,
                FluidRegistry.getFluidStack("emerald.liquid", 640));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 1501, missing),
                GameRegistry.findBlock("minecraft", "emerald_ore"),
                0,
                800,
                FluidRegistry.getFluidStack("emerald.liquid", 640));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 2501, missing),
                GameRegistry.findBlock("minecraft", "emerald_ore"),
                0,
                800,
                FluidRegistry.getFluidStack("emerald.liquid", 640));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 3501, missing),
                GameRegistry.findBlock("minecraft", "emerald_ore"),
                0,
                800,
                FluidRegistry.getFluidStack("emerald.liquid", 640));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.blockores", 1, 4501, missing),
                GameRegistry.findBlock("minecraft", "emerald_ore"),
                0,
                800,
                FluidRegistry.getFluidStack("emerald.liquid", 640));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32300, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32301, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32302, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32303, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32304, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32305, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32306, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32307, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32308, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32309, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32310, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32311, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32312, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32313, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32314, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32315, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32316, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32317, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32318, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32319, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32320, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32321, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32322, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32323, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32324, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32325, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32326, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32327, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32328, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32329, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32330, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32350, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32351, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32352, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32353, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32354, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32355, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32356, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32357, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32358, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32359, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32360, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32361, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32362, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32363, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32364, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32365, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32366, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32367, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32368, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32369, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32370, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32371, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32372, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32373, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32374, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32375, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32376, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ExtruderShapeBoat", 1, 0, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MarshmallowForm", 1, 0, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldChestplate", 1, 0, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldHelmet", 1, 0, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldLeggings", 1, 0, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldBoots", 1, 0, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2880, missing),
                GameRegistry.findBlock("TConstruct", "GlueBlock"),
                0,
                250,
                FluidRegistry.getFluidStack("glue", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11880, missing),
                GameRegistry.findBlock("TConstruct", "GlueBlock"),
                0,
                300,
                FluidRegistry.getFluidStack("glue", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17880, missing),
                GameRegistry.findBlock("TConstruct", "GlueBlock"),
                0,
                350,
                FluidRegistry.getFluidStack("glue", 288));
        Smeltery.addMelting(
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 10, missing),
                GameRegistry.findBlock("TConstruct", "GlueBlock"),
                0,
                400,
                FluidRegistry.getFluidStack("glue", 576));
        Smeltery.addMelting(
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8, missing),
                GameRegistry.findBlock("TConstruct", "GlueBlock"),
                0,
                200,
                FluidRegistry.getFluidStack("glue", 288));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11033, missing),
                GameRegistry.findBlock("TConstruct", "GravelOre"),
                5,
                650,
                FluidRegistry.getFluidStack("cobalt.molten", 144));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(TinkerConstruct.ID, "materials", 1, 12, missing),
                FluidRegistry.getFluidStack("aluminum.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0, missing),
                false,
                200);
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "materials", 1, 12, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                6,
                500,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11305, missing),
                FluidRegistry.getFluidStack("steel.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0, missing),
                false,
                800);
        TConstructRegistry.getBasinCasting().addCastingRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 4, missing),
                FluidRegistry.getFluidStack("stone.seared", 360),
                null,
                false,
                245);
        TConstructRegistry.getBasinCasting().addCastingRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 5, missing),
                FluidRegistry.getFluidStack("stone.seared", 360),
                getModItem(Minecraft.ID, "cobblestone", 1, 0, missing),
                false,
                245);
        Smeltery.addMelting(
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0, missing),
                GameRegistry.findBlock("minecraft", "obsidian"),
                0,
                850,
                FluidRegistry.getFluidStack("obsidian.molten", 288));
        Smeltery.addMelting(
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1, missing),
                GameRegistry.findBlock("minecraft", "obsidian"),
                0,
                850,
                FluidRegistry.getFluidStack("obsidian.molten", 288));
        TConstructRegistry.getBasinCasting().addCastingRecipe(
                getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10, missing),
                FluidRegistry.getFluidStack("ender", 2250),
                null,
                false,
                250);
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2089, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                4,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11089, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                4,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 9089, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                4,
                400,
                FluidRegistry.getFluidStack("lead.molten", 16));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17089, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                4,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 23089, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                4,
                400,
                FluidRegistry.getFluidStack("lead.molten", 72));
        Smeltery.addMelting(
                getModItem(IndustrialCraft2.ID, "blockMetal", 1, 4, missing),
                GameRegistry.findBlock("IC2", "blockMetal"),
                4,
                400,
                FluidRegistry.getFluidStack("lead.molten", 1296));
        Smeltery.addMelting(
                getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                10,
                250,
                FluidRegistry.getFluidStack("ender", 2250));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "glass_bottle", 1, 0, missing),
                FluidRegistry.getFluidStack("glass.molten", 144),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32305, missing),
                false,
                200);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "strangeFood", 4, 0, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "slime.gel", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "slime_ball", 4, 0, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "slime.gel", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorBronzeHelmet", 1, 0, missing),
                FluidRegistry.getFluidStack("bronze.molten", 720),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldHelmet", 1, 0, missing),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorBronzeChestplate", 1, 0, missing),
                FluidRegistry.getFluidStack("bronze.molten", 1152),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldChestplate", 1, 0, missing),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorBronzeLegs", 1, 0, missing),
                FluidRegistry.getFluidStack("bronze.molten", 1008),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldLeggings", 1, 0, missing),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorBronzeBoots", 1, 0, missing),
                FluidRegistry.getFluidStack("bronze.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldBoots", 1, 0, missing),
                false,
                400);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Railcraft.ID, "armor.steel.helmet", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 720),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldHelmet", 1, 0, missing),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Railcraft.ID, "armor.steel.plate", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 1152),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldChestplate", 1, 0, missing),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Railcraft.ID, "armor.steel.legs", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 1008),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldLeggings", 1, 0, missing),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Railcraft.ID, "armor.steel.boots", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldBoots", 1, 0, missing),
                false,
                400);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "iron_helmet", 1, 0, missing),
                FluidRegistry.getFluidStack("iron.molten", 720),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldHelmet", 1, 0, missing),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "iron_chestplate", 1, 0, missing),
                FluidRegistry.getFluidStack("iron.molten", 1152),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldChestplate", 1, 0, missing),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "iron_leggings", 1, 0, missing),
                FluidRegistry.getFluidStack("iron.molten", 1008),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldLeggings", 1, 0, missing),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "iron_boots", 1, 0, missing),
                FluidRegistry.getFluidStack("iron.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldBoots", 1, 0, missing),
                false,
                400);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "golden_helmet", 1, 0, missing),
                FluidRegistry.getFluidStack("gold.molten", 720),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldHelmet", 1, 0, missing),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "golden_chestplate", 1, 0, missing),
                FluidRegistry.getFluidStack("gold.molten", 1152),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldChestplate", 1, 0, missing),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "golden_leggings", 1, 0, missing),
                FluidRegistry.getFluidStack("gold.molten", 1008),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldLeggings", 1, 0, missing),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "golden_boots", 1, 0, missing),
                FluidRegistry.getFluidStack("gold.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldBoots", 1, 0, missing),
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
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                6000,
                getModItem(TinkerConstruct.ID, "jerky", 1, 7, missing));
        DryingRackRecipes.addDryingRecipe(
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                6000,
                getModItem(TinkerConstruct.ID, "jerky", 1, 6, missing));
        DryingRackRecipes.addDryingRecipe(
                getModItem(PamsHarvestCraft.ID, "muttonrawItem", 1, 0, missing),
                12000,
                getModItem(TinkerConstruct.ID, "jerky", 1, 3, missing));

        GT_ModHandler.addSmeltingRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.UnfiredSearedBrick", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.UnfiredSlimeSoulBrick", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "CraftedSoil", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32307, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "CraftedSoil", 2, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32307, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 17, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 9, 32, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 15, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(8).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 9, 27, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 18, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(4).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 9, 24, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 14, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(2).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 37, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 7, 0, missing),
                        getModItem(TinkersMechworks.ID, "LengthWire", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "decoration.stoneladder", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(60).eut(30).addTo(sAssemblerRecipes);

    }
}
