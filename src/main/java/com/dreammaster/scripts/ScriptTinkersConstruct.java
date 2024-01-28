package com.dreammaster.scripts;

import static com.dreammaster.scripts.GameRegistryProxy.shapedRecipes;
import static com.dreammaster.scripts.GameRegistryProxy.shapelessRecipes;
import static gregtech.api.enums.Mods.Backpack;
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
import static gregtech.api.enums.Mods.Mantle;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersMechworks;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.mantle.MantleManualRecipeRegistry;
import com.dreammaster.oredict.OreDictHelper;
import com.dreammaster.recipes.Recipe;
import com.dreammaster.tinkersConstruct.TConstructHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import mantle.lib.client.MantleClientRegistry;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.DryingRackRecipes;
import tconstruct.library.crafting.Smeltery;

public class ScriptTinkersConstruct implements IScriptLoader {

    private static final MantleManualRecipeRegistry MANTLE = MantleManualRecipeRegistry.getInstance();

    @Override
    public String getScriptName() {
        return "Tinkers Construct";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                TinkerConstruct.ID,
                Mantle.ID,
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

        Recipe.of(
                getModItem(TinkerConstruct.ID, "LavaTank", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterytank1"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "LavaTankNether", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(Minecraft.ID, "furnace", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterycontroller"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(Natura.ID, "NetherFurnace", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "Smeltery", 2, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("searedbricks"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 2, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SmelteryNether", 2, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(Minecraft.ID, "lava_bucket", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SmelteryNether", 2, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketLava", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterydrain"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "SearedBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 4, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterytable"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlockNether", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "SearedBlock", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterybasin"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlockNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("castingchannel"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlock", 2, 1, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlockNether", 2, 1, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "CastingChannel", 1, 1, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "SearedBlock", 1, 1, missing),
                null,
                null,
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelteryfaucet"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "SearedBlockNether", 1, 1, missing),
                null,
                null,
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "LavaTank", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                "glassReinforced",
                "blockGlass",
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterytank2"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "LavaTankNether", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                "glassReinforced",
                "blockGlass",
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "LavaTank", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                "blockGlass",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("smelterytank3"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "LavaTankNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                "blockGlass",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing),
                "glassReinforced",
                getModItem(TinkerConstruct.ID, "SmelteryNether", 1, 2, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "helmetWood", 1, 0, missing),
                "logWood",
                "logWood",
                "logWood",
                "logWood",
                "craftingToolSoftHammer",
                "logWood",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "chestplateWood", 1, 0, missing),
                "logWood",
                "craftingToolSoftHammer",
                "logWood",
                "logWood",
                "logWood",
                "logWood",
                "logWood",
                "logWood",
                "logWood");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "leggingsWood", 1, 0, missing),
                "logWood",
                "logWood",
                "logWood",
                "logWood",
                "craftingToolSoftHammer",
                "logWood",
                "logWood",
                null,
                "logWood");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "bootsWood", 1, 0, missing),
                "logWood",
                "craftingToolSoftHammer",
                "logWood",
                "logWood",
                null,
                "logWood",
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPane", 2, 0, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                null);
        Recipe.of(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                "sand",
                "sand",
                "sand",
                "dustClay",
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("grout"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "dustClay",
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                "dustClay",
                "sand",
                "sand",
                "sand");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                "sand",
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "sand",
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "sand",
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "dustClay",
                "sand",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                "sand",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "dustClay",
                "sand");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                "sand",
                "sand",
                "sand",
                "dustClay",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "dustClay",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                "dustClay",
                "sand",
                "sand",
                "sand");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                "sand",
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "sand",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "sand",
                "dustClay",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 4, 1, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "dustClay",
                "sand",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                "sand",
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                "dustClay",
                "sand");
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing),
                getModItem(Minecraft.ID, "nether_wart", 1, 0, missing),
                getModItem(Minecraft.ID, "soul_sand", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing),
                getModItem(Minecraft.ID, "nether_wart", 1, 0, missing),
                getModItem(Minecraft.ID, "soul_sand", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing),
                getModItem(Minecraft.ID, "nether_wart", 1, 0, missing),
                getModItem(Natura.ID, "soil.tainted", 1, 0, missing),
                getModItem(Natura.ID, "heatsand", 1, 0, missing),
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing),
                getModItem(Minecraft.ID, "nether_wart", 1, 0, missing),
                getModItem(Natura.ID, "soil.tainted", 1, 0, missing),
                getModItem(Natura.ID, "heatsand", 1, 0, missing),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "platePaper",
                "platePaper",
                "platePaper",
                "platePaper").provideTo(shapelessRecipes())
                .provideTo(MANTLE.manualShapelessCraftingRecipeNamed("blankpattern"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingStation", 1, 0, missing),
                "craftingToolSaw",
                "craftingTableWood");
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 0, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "CraftingStation", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 0, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "stickWood",
                "stickWood",
                getModItem(TinkerConstruct.ID, "CraftingStation", 1, 0, missing),
                "stickWood",
                null,
                "craftingToolSoftHammer",
                null);
        Recipe.of(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 0, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "stickWood",
                "stickWood",
                getModItem(Minecraft.ID, "crafting_table", 1, 0, missing),
                "stickWood",
                null,
                "craftingToolSoftHammer",
                null).provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("toolstation"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 0, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "trap.barricade.oak", 1, 0, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "trap.barricade.oak", 1, 0, missing),
                null,
                "craftingToolSoftHammer",
                null).provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("partcrafter"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 2, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 3, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 4, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 2, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "trap.barricade.spruce", 1, 0, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "trap.barricade.spruce", 1, 0, missing),
                null,
                "craftingToolSoftHammer",
                null);
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 3, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "trap.barricade.birch", 1, 0, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "trap.barricade.birch", 1, 0, missing),
                null,
                "craftingToolSoftHammer",
                null);
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 4, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "trap.barricade.jungle", 1, 0, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "trap.barricade.jungle", 1, 0, missing),
                null,
                "craftingToolSoftHammer",
                null);
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 1, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 2, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 3, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 2, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 4, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 5, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "stickWood",
                "stickWood",
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                "stickWood",
                null,
                "craftingToolSoftHammer",
                null).provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("patternchest"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 4, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 5, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "stickWood",
                "fenceWood",
                "stickWood",
                "fenceWood",
                null,
                "craftingToolSoftHammer",
                null);
        Recipe.of(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "stickWood",
                Blocks.fence,
                "stickWood",
                Blocks.fence,
                null,
                "craftingToolSoftHammer",
                null).provideTo(MANTLE.manualShapedCraftingRecipeNamed("stenciltable"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 11, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 12, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing),
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 13, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 11, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "stickWood",
                createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:65537}", missing),
                "stickWood",
                createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:65537}", missing),
                null,
                "craftingToolSoftHammer",
                null);
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 12, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "stickWood",
                createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:131074}", missing),
                "stickWood",
                createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:131074}", missing),
                null,
                "craftingToolSoftHammer",
                null);
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 13, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                "stickWood",
                createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:196611}", missing),
                "stickWood",
                createItemStack(ExtraTrees.ID, "multifence", 1, 16387, "{meta:196611}", missing),
                null,
                "craftingToolSoftHammer",
                null);
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 10, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 11, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 12, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 3, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolStationBlock", 1, 13, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockIron",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockIron",
                "blockIron",
                "craftingToolHardHammer",
                "blockIron").provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("toolforge"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockGold",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockGold",
                "blockGold",
                "craftingToolHardHammer",
                "blockGold");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockDiamond",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockDiamond",
                "blockDiamond",
                "craftingToolHardHammer",
                "blockDiamond");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 3, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockEmerald",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockEmerald",
                "blockEmerald",
                "craftingToolHardHammer",
                "blockEmerald");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 4, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockCobalt",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockCobalt",
                "blockCobalt",
                "craftingToolHardHammer",
                "blockCobalt");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 5, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockArdite",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockArdite",
                "blockArdite",
                "craftingToolHardHammer",
                "blockArdite");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 6, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockManyullyn",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockManyullyn",
                "blockManyullyn",
                "craftingToolHardHammer",
                "blockManyullyn");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 7, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockCopper",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockCopper",
                "blockCopper",
                "craftingToolHardHammer",
                "blockCopper");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 8, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockBronze",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockBronze",
                "blockBronze",
                "craftingToolHardHammer",
                "blockBronze");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 9, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockTin",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockTin",
                "blockTin",
                "craftingToolHardHammer",
                "blockTin");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 10, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockAluminium",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockAluminium",
                "blockAluminium",
                "craftingToolHardHammer",
                "blockAluminium");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 11, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockAluminiumBrass",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockAluminiumBrass",
                "blockAluminiumBrass",
                "craftingToolHardHammer",
                "blockAluminiumBrass");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 12, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockAlumite",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockAlumite",
                "blockAlumite",
                "craftingToolHardHammer",
                "blockAlumite");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, 13, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "SearedSlab", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "heavyPlate", 1, 15, missing),
                "blockSteel",
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 1, missing),
                "blockSteel",
                "blockSteel",
                "craftingToolHardHammer",
                "blockSteel");
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "FurnaceSlab", 1, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "furnace", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "CraftingSlab", 1, 5, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "ToolForgeBlock", 1, wildcard, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 0, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 1, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 4, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 2, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 5, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 3, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 6, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 4, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 8, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 5, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 9, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 6, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 10, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SearedSlab", 2, 7, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 11, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 7, missing),
                "craftingToolHardHammer",
                getModItem(TinkerConstruct.ID, "Smeltery", 1, 2, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 0, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 1, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 1, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 2, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 2, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 3, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 3, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 4, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 4, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 5, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 5, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 6, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 6, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "SpeedSlab", 2, 7, missing),
                "craftingToolSaw",
                getModItem(TinkerConstruct.ID, "SpeedBlock", 1, 7, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "trap.punji", 2, 0, missing),
                getModItem(Minecraft.ID, "reeds", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "reeds", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "reeds", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "reeds", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "reeds", 1, 0, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("punji"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 0, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 1, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 1, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 2, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 2, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 3, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 3, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 4, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 4, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 5, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 5, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 6, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 6, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab1", 2, 7, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 7, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 0, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 8, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 1, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 9, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 2, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 10, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 3, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 11, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 4, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 12, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 5, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 13, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 6, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 14, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "WoolSlab2", 2, 7, missing),
                "craftingToolShears",
                getModItem(Minecraft.ID, "wool", 1, 15, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "trap.barricade.oak", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "log", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 0, missing),
                null).provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("barricade"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "trap.barricade.spruce", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 1, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 1, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "log", 1, 1, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 1, missing),
                null);
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "trap.barricade.birch", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 2, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 2, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "log", 1, 2, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 2, missing),
                null);
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "trap.barricade.jungle", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 3, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 3, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "log", 1, 3, missing),
                null,
                getModItem(Minecraft.ID, "log", 1, 3, missing),
                null);
        Recipe.of(
                getModItem(TinkerConstruct.ID, "slime.channel", 1, 0, missing),
                "slimeball",
                "slimeball",
                "slimeball",
                "dustRedstone",
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                "dustRedstone",
                "slimeball",
                "slimeball",
                "slimeball").provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("slimechannel"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "blood.channel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                "dustRedstone",
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                "dustRedstone",
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "slime.pad", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "slime.channel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "slime.channel", 1, 0, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("bouncepad"));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 0, missing),
                getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                getModItem(Minecraft.ID, "slime_ball", 1, 0, missing)).provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("slimymud"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing));
        Recipe.of(
                getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 3, missing),
                "dustBone",
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing),
                "dustBone",
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing),
                "dustBone",
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing),
                "dustBone").provideTo(shapedRecipes())
                .provideTo(MANTLE.manualShapedCraftingRecipeNamed("graveyardsoil"));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeWhite",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeWhite");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 1, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeOrange",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeOrange");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 2, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeMagenta",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeMagenta");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 3, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeLightBlue",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 3, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeLightBlue");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 4, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeYellow",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 4, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeYellow");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 5, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeLime",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 5, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeLime");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 6, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyePink",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 6, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyePink");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 7, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeGray",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 7, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeGray");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 8, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeLightGray",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 8, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeLightGray");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 9, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeCyan",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 9, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeCyan");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 10, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyePurple",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 10, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyePurple");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 11, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeBlue",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 11, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeBlue");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 12, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeBrown",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 12, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeBrown");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 13, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeGreen",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 13, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeGreen");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 14, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeRed",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 14, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeRed");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 7, 15, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeBlack",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock.StainedClear", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                "dyeBlack");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeWhite",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeWhite");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 1, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeOrange",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeOrange");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 2, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeMagenta",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 2, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeMagenta");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 3, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeLightBlue",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 3, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeLightBlue");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 4, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeYellow",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 4, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeYellow");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 5, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeLime",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 5, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeLime");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 6, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyePink",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 6, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyePink");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 7, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeGray",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 7, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeGray");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 8, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeLightGray",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 8, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeLightGray");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 9, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeCyan",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 9, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeCyan");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 10, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyePurple",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 10, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyePurple");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 11, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeBlue",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 11, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeBlue");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 12, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeBrown",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 12, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeBrown");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 13, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeGreen",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 13, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeGreen");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 14, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeRed",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 14, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeRed");
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 7, 15, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeBlack",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassPaneClearStained", 1, 15, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "dyeBlack");
        Recipe.of(
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 0, missing),
                "slabWood",
                "slabWood",
                "slabWood",
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood").provideTo(shapedRecipes()).provideTo(MANTLE.manualShapedCraftingRecipeNamed("dryingrack"));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 5, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 5, missing),
                getModItem(TinkerConstruct.ID, "Armor.DryingRack", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 0, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing),
                getModItem(Railcraft.ID, "detector", 1, 1, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 1, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing),
                getModItem(Railcraft.ID, "detector", 1, 3, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 2, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing),
                getModItem(Railcraft.ID, "detector", 1, 5, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "Redstone.Landmine", 1, 3, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing),
                getModItem(Railcraft.ID, "detector", 1, 4, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "materials", 1, 40, missing),
                null,
                null,
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L),
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L),
                null,
                null,
                getModItem(TinkerConstruct.ID, "materials", 1, 40, missing),
                null,
                null,
                null,
                null,
                null,
                null);
        // Obsidian Stick conversions
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "toolRod", 2, 6, missing),
                "stickObsidian",
                null,
                null,
                null,
                "stickObsidian",
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(RandomThings.ID, "ingredient", 2, 1, missing),
                null,
                "stickObsidian",
                null,
                null,
                "stickObsidian",
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Obsidian, 2L),
                null,
                null,
                "stickObsidian",
                null,
                "stickObsidian",
                null,
                null,
                null,
                null);
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 0, missing));
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelGoggles",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:0.0d,Built:1b,MaxDefense:4.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "boltElectrum",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "ringElectrum",
                getModItem(Minecraft.ID, "diamond_helmet", 1, 0, missing),
                "ringElectrum",
                "lensDiamond",
                "circuitAdvanced",
                "lensDiamond");
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelVest",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:4.0d,Built:1b,MaxDefense:10.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "circuitAdvanced",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "plateObsidian",
                getModItem(Minecraft.ID, "diamond_chestplate", 1, 0, missing),
                "plateObsidian",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "plateObsidian",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing));
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelGlove",
                        1,
                        0,
                        "{TinkerAccessory:{BaseDurability:500,Built:1b,Damage:0,BonusDurability:0,TotalDurability:500,ModDurability:0.0f,Modifiers:5,Broken:0b}}",
                        missing),
                null,
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "plateDiamond",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                null,
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "circuitAdvanced");
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelWings",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:2.0d,Built:1b,MaxDefense:8.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                "plateDiamond",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "plateDiamond",
                getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing),
                "circuitAdvanced",
                getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing),
                getModItem(Minecraft.ID, "diamond_leggings", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing));
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelBelt",
                        1,
                        0,
                        "{TinkerAccessory:{BaseDurability:500,Built:1b,Damage:0,BonusDurability:0,TotalDurability:500,ModDurability:0.0f,Modifiers:5,Broken:0b}}",
                        missing),
                null,
                "circuitAdvanced",
                null,
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                "plateDiamond",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                null,
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing));
        addShapedRecipe(
                createItemStack(
                        TinkerConstruct.ID,
                        "travelBoots",
                        1,
                        0,
                        "{TinkerArmor:{BaseDurability:1035,BaseDefense:2.0d,Built:1b,MaxDefense:6.0d,Damage:0,BonusDurability:0,Modifiers:3,DamageReduction:0.0d,TotalDurability:1035,ModDurability:0.0f,Broken:0b}}",
                        missing),
                null,
                "plateDiamond",
                "plateDiamond",
                null,
                getModItem(Minecraft.ID, "diamond_boots", 1, 0, missing),
                "circuitAdvanced",
                getModItem(PamsHarvestCraft.ID, "hardenedleatherItem", 1, 0, missing),
                ItemList.Electric_Piston_HV.get(1L),
                ItemList.Electric_Piston_HV.get(1L));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "materials", 1, 3, missing),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L));
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L),
                getModItem(TinkerConstruct.ID, "materials", 1, 3, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "materials", 1, 5, missing),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Manyullyn, 1L));
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Manyullyn, 1L),
                getModItem(TinkerConstruct.ID, "materials", 1, 5, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "decoration.stoneladder", 4, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(TinkersMechworks.ID, "LengthWire", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(TinkersMechworks.ID, "LengthWire", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "slime_boots", 1, 0, missing),
                getModItem(Backpack.ID, "tannedLeather", 1),
                null,
                getModItem(Backpack.ID, "tannedLeather", 1),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "slime.pad", 1, 0, missing),
                getModItem(Minecraft.ID, "leather_boots", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "slime.pad", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "slimesling", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 1, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                null,
                getModItem(TinkerConstruct.ID, "slime.channel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "slime.pad", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "slime.gel", 1, 1, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                null);

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
        TConstructHelper.removeBasinRecipe(GT_OreDictUnificator.get(OrePrefixes.block, Materials.PigIron, 1L));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 2, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "Smeltery", 1, 4, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "Smeltery", 1, 5, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GregTech.ID, "gt.blockores", 1, 33, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "SearedBrick", 1, 1, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GalaxySpace.ID, "phobosblocks", 1, 4, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "GravelOre", 1, 5, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 39, missing));
        TConstructHelper.removeMeltingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "SearedBrick", 1, 2, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GregTech.ID, "gt.blockores", 1, 382, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 38, missing));
        TConstructHelper.removeMeltingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ardite, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 29, missing));
        TConstructHelper.removeMeltingRecipe(GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Ardite, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 1, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 41, missing));
        TConstructHelper.removeMeltingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 30, missing));
        TConstructHelper.removeMeltingRecipe(GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Manyullyn, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 2, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10, missing));
        TConstructHelper.removeTableRecipe(getModItem(BuildCraftCore.ID, "ironGearItem", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(BuildCraftCore.ID, "goldGearItem", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(Forestry.ID, "gearBronze", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(Forestry.ID, "gearCopper", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(Forestry.ID, "gearTin", 1, 0, missing));
        TConstructHelper.removeTableRecipe(GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Platinum, 1L));
        TConstructHelper.removeTableRecipe(GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Nickel, 1L));
        TConstructHelper.removeTableRecipe(GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Silver, 1L));
        TConstructHelper.removeTableRecipe(GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Electrum, 1L));
        TConstructHelper.removeTableRecipe(GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Invar, 1L));
        TConstructHelper.removeTableRecipe(GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Lead, 1L));
        TConstructHelper.removeTableRecipe(GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Steel, 1L));
        TConstructHelper.removeTableRecipe(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 1, missing));
        TConstructHelper.removeTableRecipe(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 2, missing));
        TConstructHelper.removeTableRecipe(getModItem(IndustrialCraft2.ID, "itemIngot", 1, 3, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "chainmail_helmet", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "chainmail_chestplate", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "chainmail_leggings", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "chainmail_boots", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Cobalt, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 3, missing));
        TConstructHelper.removeMeltingRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L));
        TConstructHelper.removeMeltingRecipe(getModItem(GalaxySpace.ID, "item.Ingots", 1, 1, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(GregTech.ID, "gt.blockmetal2", 1, 5, missing));
        TConstructHelper.removeBasinRecipe(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 0, missing));
        TConstructHelper.removeBasinRecipe(getModItem(BloodArsenal.ID, "blood_infused_iron_block", 1, 0, missing));
        TConstructHelper.removeMeltingRecipe(getModItem(Minecraft.ID, "sand", 1, 0, missing));
        TConstructHelper.removeSmelterAlloyMix(FluidRegistry.getFluidStack("alumite.molten", 32));
        TConstructHelper.removeMeltingRecipe(getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1, missing));
        TConstructHelper.removeTableRecipe(getModItem(Minecraft.ID, "golden_apple", 1, 0, missing));
        TConstructHelper.removeTableRecipe(getModItem(TinkerConstruct.ID, "gearCast", 1, 0, missing));
        TConstructHelper.removeTableRecipe(GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Enderium, 1L));
        TConstructHelper.removeTableRecipe(GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Ardite, 1L));
        TConstructHelper.removeTableRecipe(GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Manyullyn, 1L));
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
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Aluminium, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockmachines"),
                1585,
                500,
                FluidRegistry.getFluidStack("aluminum.molten", 16));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Aluminium, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockmachines"),
                1585,
                500,
                FluidRegistry.getFluidStack("aluminum.molten", 36));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Copper, 1L),
                FluidRegistry.getFluidStack("copper.molten", 16),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27, missing),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Tin, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.AnyBronze, 1L),
                FluidRegistry.getFluidStack("bronze.molten", 16),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 27, missing),
                false,
                20);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L),
                FluidRegistry.getFluidStack("copper.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0, missing),
                false,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 1L),
                FluidRegistry.getFluidStack("tin.molten", 144),
                getModItem(TinkerConstruct.ID, "metalPattern", 1, 0, missing),
                false,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Iron, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Iron, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.AnyIron, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Iron, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.ore, Materials.BrownLimonite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.BrownLimonite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.BrownLimonite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.BrownLimonite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.BrownLimonite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.ore, Materials.YellowLimonite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.YellowLimonite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.YellowLimonite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.YellowLimonite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.YellowLimonite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.ore, Materials.BandedIron, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.BandedIron, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.BandedIron, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.BandedIron, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.BandedIron, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.ore, Materials.GraniticMineralSand, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.GraniticMineralSand, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.GraniticMineralSand, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.GraniticMineralSand, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.GraniticMineralSand, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Magnetite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Magnetite, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Magnetite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Magnetite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Pyrite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Pyrite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Pyrite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Pyrite, 1L),
                GameRegistry.findBlock("minecraft", "iron_ore"),
                0,
                700,
                FluidRegistry.getFluidStack("iron.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Pyrite, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Copper, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Copper, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Copper, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Copper, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Malachite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Malachite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Malachite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Malachite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Tetrahedrite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Tetrahedrite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Tetrahedrite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Tetrahedrite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Tetrahedrite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Chalcopyrite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Chalcopyrite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Chalcopyrite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Chalcopyrite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                3,
                600,
                FluidRegistry.getFluidStack("copper.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Chalcopyrite, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Tin, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Tin, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Tin, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Tin, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Cassiterite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Cassiterite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Cassiterite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Cassiterite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Cassiterite, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                400,
                FluidRegistry.getFluidStack("tin.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.ore, Materials.CassiteriteSand, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.CassiteriteSand, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.CassiteriteSand, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.CassiteriteSand, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                4,
                600,
                FluidRegistry.getFluidStack("tin.molten", 288));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.CassiteriteSand, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Gold, 1L),
                GameRegistry.findBlock("minecraft", "gold_ore"),
                0,
                600,
                FluidRegistry.getFluidStack("gold.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Gold, 1L),
                GameRegistry.findBlock("minecraft", "gold_ore"),
                0,
                600,
                FluidRegistry.getFluidStack("gold.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Gold, 1L),
                GameRegistry.findBlock("minecraft", "gold_ore"),
                0,
                600,
                FluidRegistry.getFluidStack("gold.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Gold, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Aluminium, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                5,
                400,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Aluminium, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                5,
                400,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Aluminium, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                5,
                400,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Aluminium, 1L),
                GameRegistry.findBlock("TConstruct", "SearedBrick"),
                5,
                400,
                FluidRegistry.getFluidStack("aluminum.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Nickel, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                34,
                400,
                FluidRegistry.getFluidStack("nickel.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Nickel, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                34,
                400,
                FluidRegistry.getFluidStack("nickel.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Nickel, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                34,
                400,
                FluidRegistry.getFluidStack("nickel.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Nickel, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                34,
                400,
                FluidRegistry.getFluidStack("nickel.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Nickel, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Lead, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                89,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Lead, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                89,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Lead, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                89,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Lead, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                89,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Silver, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                54,
                500,
                FluidRegistry.getFluidStack("silver.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Silver, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                54,
                500,
                FluidRegistry.getFluidStack("silver.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Silver, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                54,
                500,
                FluidRegistry.getFluidStack("silver.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Silver, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                54,
                500,
                FluidRegistry.getFluidStack("silver.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Silver, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                54,
                500,
                FluidRegistry.getFluidStack("silver.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Platinum, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                85,
                800,
                FluidRegistry.getFluidStack("platinum.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Platinum, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                85,
                800,
                FluidRegistry.getFluidStack("platinum.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Platinum, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                85,
                800,
                FluidRegistry.getFluidStack("platinum.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Platinum, 1L),
                GameRegistry.findBlock("gregtech", "gt.blockores"),
                85,
                800,
                FluidRegistry.getFluidStack("platinum.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Platinum, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Emerald, 1L),
                GameRegistry.findBlock("minecraft", "emerald_ore"),
                0,
                800,
                FluidRegistry.getFluidStack("emerald.liquid", 640));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Emerald, 1L),
                GameRegistry.findBlock("minecraft", "emerald_ore"),
                0,
                800,
                FluidRegistry.getFluidStack("emerald.liquid", 640));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Emerald, 1L),
                GameRegistry.findBlock("minecraft", "emerald_ore"),
                0,
                800,
                FluidRegistry.getFluidStack("emerald.liquid", 640));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Emerald, 1L),
                GameRegistry.findBlock("minecraft", "emerald_ore"),
                0,
                800,
                FluidRegistry.getFluidStack("emerald.liquid", 640));
        Smeltery.addMelting(
                ItemList.Shape_Empty.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Plate.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Casing.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Gear.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Credit.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Bottle.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Ingot.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Ball.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Block.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Nugget.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Bun.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Bread.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Baguette.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Cylinder.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Anvil.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Name.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Arrow.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Gear_Small.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Rod.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Bolt.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Round.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Screw.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Ring.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Rod_Long.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Rotor.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Turbine_Blade.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Pipe_Tiny.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Pipe_Small.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Pipe_Medium.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Pipe_Large.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Mold_Pipe_Huge.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Plate.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Rod.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Bolt.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Ring.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Cell.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Ingot.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Wire.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Casing.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Pipe_Tiny.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Pipe_Small.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Pipe_Medium.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Pipe_Large.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Pipe_Huge.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Block.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Sword.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Pickaxe.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Shovel.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Axe.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Hoe.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Hammer.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_File.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Saw.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Gear.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Bottle.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Rotor.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Small_Gear.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                ItemList.Shape_Extruder_Turbine_Blade.get(1L),
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
                CustomItemList.MarshmallowForm.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                CustomItemList.MoldChestplate.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                CustomItemList.MoldHelmet.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                CustomItemList.MoldLeggings.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                CustomItemList.MoldBoots.get(1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                5,
                800,
                FluidRegistry.getFluidStack("steel.molten", 576));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 1L),
                GameRegistry.findBlock("TConstruct", "GlueBlock"),
                0,
                250,
                FluidRegistry.getFluidStack("glue", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Rubber, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Steel, 1L),
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
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                4,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Lead, 1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                4,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Lead, 1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                4,
                400,
                FluidRegistry.getFluidStack("lead.molten", 16));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lead, 1L),
                GameRegistry.findBlock("IC2", "blockMetal"),
                4,
                400,
                FluidRegistry.getFluidStack("lead.molten", 144));
        Smeltery.addMelting(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Lead, 1L),
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
                ItemList.Shape_Mold_Bottle.get(1L),
                false,
                200);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorBronzeHelmet", 1, 0, missing),
                FluidRegistry.getFluidStack("bronze.molten", 720),
                CustomItemList.MoldHelmet.get(1L),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorBronzeChestplate", 1, 0, missing),
                FluidRegistry.getFluidStack("bronze.molten", 1152),
                CustomItemList.MoldChestplate.get(1L),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorBronzeLegs", 1, 0, missing),
                FluidRegistry.getFluidStack("bronze.molten", 1008),
                CustomItemList.MoldLeggings.get(1L),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(IndustrialCraft2.ID, "itemArmorBronzeBoots", 1, 0, missing),
                FluidRegistry.getFluidStack("bronze.molten", 576),
                CustomItemList.MoldBoots.get(1L),
                false,
                400);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Railcraft.ID, "armor.steel.helmet", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 720),
                CustomItemList.MoldHelmet.get(1L),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Railcraft.ID, "armor.steel.plate", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 1152),
                CustomItemList.MoldChestplate.get(1L),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Railcraft.ID, "armor.steel.legs", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 1008),
                CustomItemList.MoldLeggings.get(1L),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Railcraft.ID, "armor.steel.boots", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                CustomItemList.MoldBoots.get(1L),
                false,
                400);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "iron_helmet", 1, 0, missing),
                FluidRegistry.getFluidStack("iron.molten", 720),
                CustomItemList.MoldHelmet.get(1L),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "iron_chestplate", 1, 0, missing),
                FluidRegistry.getFluidStack("iron.molten", 1152),
                CustomItemList.MoldChestplate.get(1L),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "iron_leggings", 1, 0, missing),
                FluidRegistry.getFluidStack("iron.molten", 1008),
                CustomItemList.MoldLeggings.get(1L),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "iron_boots", 1, 0, missing),
                FluidRegistry.getFluidStack("iron.molten", 576),
                CustomItemList.MoldBoots.get(1L),
                false,
                400);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "golden_helmet", 1, 0, missing),
                FluidRegistry.getFluidStack("gold.molten", 720),
                CustomItemList.MoldHelmet.get(1L),
                false,
                500);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "golden_chestplate", 1, 0, missing),
                FluidRegistry.getFluidStack("gold.molten", 1152),
                CustomItemList.MoldChestplate.get(1L),
                false,
                800);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "golden_leggings", 1, 0, missing),
                FluidRegistry.getFluidStack("gold.molten", 1008),
                CustomItemList.MoldLeggings.get(1L),
                false,
                700);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(Minecraft.ID, "golden_boots", 1, 0, missing),
                FluidRegistry.getFluidStack("gold.molten", 576),
                CustomItemList.MoldBoots.get(1L),
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

        Recipe.of(getModItem(TinkerConstruct.ID, "materials", 1, 2, missing), CustomItemList.UnfiredSearedBrick.get(1L))
                .provideTo(recipe -> GT_ModHandler.addSmeltingRecipe(recipe.flatten()[0], recipe.getResult()))
                .provideTo(MANTLE.manualSmeltingRecipeNamed("searedbrick"));
        GT_ModHandler.addSmeltingRecipe(
                CustomItemList.UnfiredSlimeSoulBrick.get(1L),
                getModItem(TinkerConstruct.ID, "materials", 1, 37, missing));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "CraftedSoil", 2, 0, missing),
                        ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 1, missing)).duration(20 * SECONDS).eut(16)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "CraftedSoil", 2, 2, missing),
                        ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 17, missing)).duration(20 * SECONDS).eut(16)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 9, 32, missing),
                        ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 15, missing)).duration(10 * SECONDS).eut(8)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 9, 27, missing),
                        ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 18, missing)).duration(10 * SECONDS).eut(4)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 9, 24, missing),
                        ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 14, missing)).duration(10 * SECONDS).eut(2)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 1, missing),
                        ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 2, missing)).duration(10 * SECONDS).eut(16)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "CraftedSoil", 1, 6, missing),
                        ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 37, missing)).duration(10 * SECONDS).eut(16)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 7, 0, missing),
                        getModItem(TinkersMechworks.ID, "LengthWire", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(getModItem(TinkerConstruct.ID, "decoration.stoneladder", 4, 0, missing))
                .duration(3 * SECONDS).eut(30).addTo(assemblerRecipes);

        registerManualIcons();
    }

    private void registerManualIcons() {
        MantleClientRegistry.registerManualIcon("paper", new ItemStack(Items.paper, 64, 0));
        MantleClientRegistry.registerManualIcon("steam_compressor", ItemList.Machine_Bronze_Compressor.get(1));
    }

}
