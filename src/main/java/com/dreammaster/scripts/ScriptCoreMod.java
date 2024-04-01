package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BuildCraftSilicon;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.ProjectRedCore;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.RemoteIO;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.autoclaveRecipes;
import static gregtech.api.recipe.RecipeMaps.brewingRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.distilleryRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.recipe.RecipeMaps.fermentingRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.recipe.RecipeMaps.hammerRecipes;
import static gregtech.api.recipe.RecipeMaps.laserEngraverRecipes;
import static gregtech.api.recipe.RecipeMaps.latheRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.wiremillRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;

import cpw.mods.fml.common.registry.GameRegistry;
import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.Smeltery;

public class ScriptCoreMod implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Core Mod";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                TinkerConstruct.ID,
                BartWorks.ID,
                AdvancedSolarPanel.ID,
                AppliedEnergistics2.ID,
                BiomesOPlenty.ID,
                BuildCraftSilicon.ID,
                EnderIO.ID,
                Forestry.ID,
                GalacticraftCore.ID,
                GalacticraftMars.ID,
                GalaxySpace.ID,
                IndustrialCraft2.ID,
                Natura.ID,
                OpenBlocks.ID,
                PamsHarvestCraft.ID,
                ProjectRedCore.ID,
                Railcraft.ID,
                RemoteIO.ID,
                Thaumcraft.ID,
                TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(CustomItemList.SandStoneRod.get(1L), "craftingToolFile", "sandstone", "craftingToolSaw");
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 1),
                "craftingToolFile",
                "cobblestone",
                "craftingToolSaw");
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.LongObsidianRod", 2, 0, missing),
                "craftingToolSaw",
                "stoneObsidian",
                "craftingToolFile");
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.LongStoneRod", 2, 0, missing),
                "craftingToolSaw",
                "stone",
                "craftingToolFile");
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.MushroomPowder", 1, 0, missing),
                "listAllmushroom",
                null,
                null,
                "craftingToolMortar",
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                CustomItemList.Display.get(1L),
                "platePlastic",
                ItemList.Cover_Screen.get(1L),
                "platePlastic",
                "circuitBasic",
                "cableGt01Tin",
                "circuitBasic",
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron");
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.LaserEmitter", 1, 0, missing),
                "itemCasingTitanium",
                "lensRuby",
                "itemCasingTitanium",
                getModItem(IndustrialCraft2.ID, "reactorCoolantSix", 1, 1, missing),
                ItemList.Emitter_HV.get(1L),
                getModItem(IndustrialCraft2.ID, "reactorCoolantSix", 1, 1, missing),
                "plateAlloyAdvanced",
                "plateAlloyAdvanced",
                "plateAlloyAdvanced");
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.DiamondDrillTip", 1, 0, missing),
                "plateDiamond",
                "plateSteel",
                "plateDiamond",
                "plateDiamond",
                "plateSteel",
                "plateDiamond",
                "plateSteel",
                "craftingToolHardHammer",
                "plateSteel");
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.ReinforcedIridiumDrillTip", 1, 0, missing),
                "plateAlloyIridium",
                "plateSteel",
                "plateAlloyIridium",
                "plateAlloyIridium",
                "plateSteel",
                "plateAlloyIridium",
                "plateSteel",
                "craftingToolHardHammer",
                "plateSteel");
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.SawBladeDiamond", 1, 0, missing),
                "plateDiamond",
                "plateDiamond",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.SawBladeStone", 1, 0, missing),
                "plateStone",
                "plateStone",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.SawBladeArdite", 1, 0, missing),
                "plateArdite",
                "plateArdite",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.SawBladeManyullyn", 1, 0, missing),
                "plateManyullyn",
                "plateManyullyn",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.SawBladeRuby", 1, 0, missing),
                "plateRuby",
                "plateRuby",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.SawBladeSapphire", 1, 0, missing),
                "plateSapphire",
                "plateSapphire",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.SawBladePeridot", 1, 0, missing),
                "plateOlivine",
                "plateOlivine",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.BowFletchingCast", 1, 0, missing),
                null,
                null,
                "craftingToolHardHammer",
                null,
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 1, missing),
                "craftingToolKnife",
                null,
                null,
                "craftingToolFile");
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.BowFletchingCast", 1, 0, missing),
                null,
                null,
                "craftingToolHardHammer",
                null,
                "plateBrass",
                "craftingToolKnife",
                null,
                null,
                "craftingToolFile");
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.BowStringCast", 1, 0, missing),
                null,
                null,
                null,
                null,
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 1, missing),
                "craftingToolHardHammer",
                null,
                "craftingToolFile",
                "craftingToolKnife");
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.BowStringCast", 1, 0, missing),
                null,
                null,
                null,
                null,
                "plateBrass",
                "craftingToolHardHammer",
                null,
                "craftingToolFile",
                "craftingToolKnife");
        addShapedRecipe(
                getModItem(Minecraft.ID, "coal", 1, 1, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                null,
                null,
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
                null,
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
                null,
                null,
                null,
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L),
                null,
                null,
                null,
                null,
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gypsum, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 1L),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 1L),
                null,
                null,
                null,
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Brick, 1L),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.WroughtIron, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                getModItem(IndustrialCraft2.ID, "itemHarz", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Arsenic, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                getModItem(TinkerConstruct.ID, "materials", 1, 40, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Silver, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gallium, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "leather", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.CobaltBrass, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                CustomItemList.RawSDHCAlloy.get(1L),
                "screwStainlessSteel",
                "craftingToolScrewdriver",
                "screwStainlessSteel",
                getModItem(GalaxySpace.ID, "item.CompressedDualBronze", 1, 0, missing),
                getModItem(GalaxySpace.ID, "item.CompressedCoal", 1, 0, missing),
                getModItem(GalaxySpace.ID, "item.CompressedDualAluminium", 1, 0, missing),
                "screwStainlessSteel",
                "craftingToolHardHammer",
                "screwStainlessSteel");
        addShapedRecipe(
                createItemStack(NewHorizonsCoreMod.ID, "item.OvenGlove", 1, 0, "{Durability:1000}", missing),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "itemLeather",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "itemLeather",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "itemLeather",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing));
        addShapelessRecipe(
                createItemStack(NewHorizonsCoreMod.ID, "item.OvenGlove", 1, 0, "{Durability:1000}", missing),
                getModItem(NewHorizonsCoreMod.ID, "item.OvenGlove", 1, 0, missing),
                "itemLeather",
                "itemLeather",
                "itemLeather");
        addShapedRecipe(
                createItemStack(NewHorizonsCoreMod.ID, "item.OvenGlove", 1, 1, "{Durability:1000}", missing),
                "itemLeather",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "itemLeather",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "itemLeather",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing));
        addShapelessRecipe(
                createItemStack(NewHorizonsCoreMod.ID, "item.OvenGlove", 1, 1, "{Durability:1000}", missing),
                getModItem(NewHorizonsCoreMod.ID, "item.OvenGlove", 1, 1, missing),
                "itemLeather",
                "itemLeather",
                "itemLeather");
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "tile.DiamondFrameBox", 1, 0, missing),
                "stickDiamond",
                "stickDiamond",
                "stickDiamond",
                "stickDiamond",
                "craftingToolWrench",
                "stickDiamond",
                "stickDiamond",
                "stickDiamond",
                "stickDiamond");
        addShapedRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormCoinage", 1, 0, missing),
                null,
                null,
                null,
                null,
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 1, missing),
                null,
                "craftingToolFile",
                "craftingToolWireCutter",
                null);

        GT_ModHandler
                .addSmeltingRecipe(CustomItemList.UnfiredCokeOvenBrick.get(1L), CustomItemList.CokeOvenBrick.get(1L));

        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeBolt", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeHoeHead", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeGear", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapePlate", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormAnvil", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPlate", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormLeggings", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBaguette", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormGear", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormRotor", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeBottle", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeRotor", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeTurbineBlade", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeSmallGear", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBoots", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeLargePipe", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormSmallGear", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormCasing", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeWire", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormChestplate", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeShovelHead", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBread", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeIngot", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormIngot", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeFileHead", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeRod", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeHugePipe", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeSwordBlade", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeRing", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeCasing", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormNuggets", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeSmallPipe", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormName", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeHammerHead", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeTinyPipe", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormCylinder", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBottle", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeAxeHead", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeSawBlade", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBlock", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeCell", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormArrowHead", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeBoat", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormCoinage", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBall", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeBlock", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormHelmet", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapePickaxeHead", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBuns", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeNormalPipe", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                CustomItemList.MarshmallowFormMold.get(1L),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormStick", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormStickLong", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormScrew", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormRing", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBolt", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormRound", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormTurbineBlade", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeTiny", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeSmall", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeMedium", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeLarge", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));
        Smeltery.addMelting(
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeHuge", 1, 0, missing),
                GameRegistry.findBlock("TConstruct", "MetalBlock"),
                7,
                500,
                FluidRegistry.getFluidStack("aluminumbrass.molten", 72));

        GT_Values.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "machine.alpha", 1, 7, missing))
                .itemOutputs(CustomItemList.CokeOvenBrick.get(4L)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "machine.alpha", 1, 12, missing))
                .itemOutputs(CustomItemList.AdvancedCokeOvenBrick.get(4L)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        RecipeManagers.carpenterManager.addRecipe(
                20,
                FluidRegistry.getFluidStack("seedoil", 500),
                getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                CustomItemList.EngineCore.get(1L),
                "abc",
                "def",
                "ghi",
                'b',
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 1L),
                'e',
                getModItem(Minecraft.ID, "piston", 1, 0, missing));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.ExtruderShapeBoat", 1, 0, missing),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeBoat", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                CustomItemList.MoldBoots.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBoots", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                CustomItemList.MoldChestplate.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormChestplate", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                CustomItemList.MoldHelmet.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormHelmet", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                CustomItemList.MoldLeggings.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormLeggings", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                CustomItemList.MarshmallowForm.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                CustomItemList.MarshmallowFormMold.get(1L),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.BowFletchingCast", 1, 0, missing),
                FluidRegistry.getFluidStack("aluminumbrass.molten", 144),
                getModItem(TinkerConstruct.ID, "fletching", 1, wildcard, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                getModItem(NewHorizonsCoreMod.ID, "item.BowStringCast", 1, 0, missing),
                FluidRegistry.getFluidStack("aluminumbrass.molten", 144),
                getModItem(TinkerConstruct.ID, "bowstring", 1, wildcard, missing),
                true,
                100);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 4, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Naquadria, 1L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.EnrichedNaquadriaSunnariumAlloy", 1, 0, missing))
                .duration(1 * MINUTES + 40 * SECONDS).eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.EnrichedNaquadriaSunnariumAlloy", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Neutronium, 1L))
                .itemOutputs(
                        getModItem(
                                NewHorizonsCoreMod.ID,
                                "item.EnrichedNaquadriaNeutroniumSunnariumAlloy",
                                1,
                                0,
                                missing))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(
                getModItem(NewHorizonsCoreMod.ID, "item.EnrichedNaquadriaNeutroniumSunnariumAlloy", 1, 0, missing),
                getModItem(NewHorizonsCoreMod.ID, "item.BedrockiumPlate", 18, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.EnrichedXSunnariumAlloy", 1, 0, missing))
                .duration(2 * MINUTES + 20 * SECONDS).eut(8000000).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 6L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "tile.BronzePlatedReinforcedStone", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 144)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 6L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "tile.SteelPlatedReinforcedStone", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).duration(12 * SECONDS + 10 * TICKS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 6L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "tile.TitaniumPlatedReinforcedStone", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.platinum", 144)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 6L))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "tile.TungstensteelPlatedReinforcedStone", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iridium", 144)).duration(17 * SECONDS + 10 * TICKS)
                .eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 6L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "tile.NaquadahPlatedReinforcedStone", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.osmium", 144)).duration(22 * SECONDS + 10 * TICKS)
                .eut(256).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 6L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "tile.NeutroniumPlatedReinforcedStone", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.naquadria", 144)).duration(25 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 2, 6, missing),
                        getModItem(GalacticraftCore.ID, "item.basicItem", 2, 14, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.LightBinding", 1, 0, missing))
                .duration(30 * SECONDS).eut(480).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.RawBioFiber", 2, 0, missing),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.BioOrganicMesh", 1, 0, missing))
                .duration(40 * SECONDS).eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.block, Materials.Charcoal, 1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.CompressedBioBall", 8, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.BioChunk", 1, 0, missing)).duration(1 * MINUTES)
                .eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Diamond, 4L),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "tile.DiamondFrameBox", 1, 0, missing))
                .duration(3 * SECONDS + 4 * TICKS).eut(8).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone", 2, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 1L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "tile.CompressedGraphite", 2, 0, missing))
                .duration(5 * SECONDS).eut(8).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing),
                        getModItem(RemoteIO.ID, "item.blank_plate", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.BlankPlatedChip", 1, 0, missing))
                .duration(5 * SECONDS).eut(480).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.PulsatingSpatialCoreChip", 1, 0, missing))
                .itemOutputs(
                        getModItem(
                                NewHorizonsCoreMod.ID,
                                "item.EngineeringProcessorSpatialPulsatingCore",
                                1,
                                0,
                                missing))
                .duration(5 * SECONDS).eut(7680).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.DiamondFluidCoreChip", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.EngineeringProcessorFluidDiamondCore", 1, 0, missing))
                .duration(5 * SECONDS).eut(1920).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.EmeraldAdvancedFluidCoreChip", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.EngineeringProcessorFluidEmeraldCore", 1, 0, missing))
                .duration(5 * SECONDS).eut(7680).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.GoldCoreChip", 1, 0, missing))
                .itemOutputs(CustomItemList.LogicProcessorItemGoldCore.get(1L)).duration(5 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.DiamondCoreChip", 1, 0, missing))
                .itemOutputs(CustomItemList.EngineeringProcessorItemDiamondCore.get(1L)).duration(5 * SECONDS).eut(1920)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.EmeraldAdvancedCoreChip", 1, 0, missing))
                .itemOutputs(CustomItemList.EngineeringProcessorItemEmeraldCore.get(1L)).duration(5 * SECONDS).eut(7680)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.EmeraldHighAdvancedCoreChip", 1, 0, missing))
                .itemOutputs(CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1L)).duration(5 * SECONDS)
                .eut(30720).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 3, missing),
                        getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 6, missing))
                .itemOutputs(CustomItemList.LeadNickelPlate.get(2L))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 2000)).duration(30 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.ReinforcedAluminiumIronPlate.get(1L),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIndustrialDiamond", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4L))
                .itemOutputs(CustomItemList.IrradiantReinforcedAluminiumPlate.get(1L))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144)).duration(30 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.ReinforcedTitaniumIronPlate.get(1L),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MeteoricSteel, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 2, 8, missing),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4L))
                .itemOutputs(CustomItemList.IrradiantReinforcedTitaniumPlate.get(1L))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).duration(30 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.ReinforcedTitaniumIronPlate.get(1L),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MeteoricSteel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4L))
                .itemOutputs(CustomItemList.IrradiantReinforcedTitaniumPlate.get(1L))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 288)).duration(30 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.ReinforcedTungstenIronPlate.get(1L),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 3, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Uranium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steeleaf, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4L))
                .itemOutputs(CustomItemList.IrradiantReinforcedTungstenPlate.get(1L))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 576)).duration(30 * SECONDS).eut(1920)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.ReinforcedTungstenSteelIronPlate.get(1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Sunnarium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Plutonium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Knightmetal, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4L))
                .itemOutputs(CustomItemList.IrradiantReinforcedTungstenSteelPlate.get(1L))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 1152)).duration(30 * SECONDS)
                .eut(7680).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.ReinforcedChromeIronPlate.get(1L),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 1, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.YttriumBariumCuprate, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.FierySteel, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4L))
                .itemOutputs(CustomItemList.IrradiantReinforcedChromePlate.get(1L))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 2304)).duration(30 * SECONDS)
                .eut(30720).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 7, missing),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 4, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4L))
                .itemOutputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 4608)).duration(30 * SECONDS)
                .eut(122880).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.ReinforcedNaquadriaIronPlate.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.EnrichedNaquadriaSunnariumAlloy", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Quantium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4L))
                .itemOutputs(CustomItemList.IrradiantReinforcedNaquadriaPlate.get(1L))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 9216)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.ReinforcedNaquadriaIronPlate.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.EnrichedNaquadriaSunnariumAlloy", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.QuantinumPlate", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Osmiridium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4L))
                .itemOutputs(CustomItemList.IrradiantReinforcedNaquadriaPlate.get(1L))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 9216)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(
                CustomItemList.ReinforcedNeutroniumIronPlate.get(1L),
                getModItem(NewHorizonsCoreMod.ID, "item.EnrichedNaquadriaNeutroniumSunnariumAlloy", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.MysteriousCrystal, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Infinity, 2L),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4L))
                .itemOutputs(CustomItemList.IrradiantReinforcedNeutroniumPlate.get(1L))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 18432)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(
                CustomItemList.ReinforcedNeutroniumIronPlate.get(1L),
                getModItem(NewHorizonsCoreMod.ID, "item.EnrichedNaquadriaNeutroniumSunnariumAlloy", 1, 0, missing),
                getModItem(NewHorizonsCoreMod.ID, "item.MysteriousCrystalPlate", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Infinity, 2L),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4L))
                .itemOutputs(CustomItemList.IrradiantReinforcedNeutroniumPlate.get(1L))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 18432)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.ReinforcedBedrockiumIronPlate.get(1L),
                        getModItem(NewHorizonsCoreMod.ID, "item.EnrichedXSunnariumAlloy", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.DraconiumAwakened, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.InfinityCatalyst, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.RedAlloy, 4L))
                .itemOutputs(CustomItemList.IrradiantReinforcedBedrockiumPlate.get(1L))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 36864)).duration(30 * SECONDS)
                .eut(8000000).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L))
                .itemOutputs(getModItem(GalaxySpace.ID, "item.UnknowCrystal", 1, 0, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).duration(3 * MINUTES).eut(480)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L))
                .itemOutputs(getModItem(GalaxySpace.ID, "item.UnknowCrystal", 1, 0, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 800)).duration(2 * MINUTES).eut(480)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L))
                .itemOutputs(getModItem(GalaxySpace.ID, "item.UnknowCrystal", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 288)).duration(1 * MINUTES).eut(480)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 16, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.RawBioFiber", 1, 0, missing)).outputChances(3300)
                .fluidInputs(FluidRegistry.getFluidStack("ic2biomass", 8)).duration(10 * SECONDS).eut(20)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 16, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.RawBioFiber", 1, 0, missing)).outputChances(5000)
                .fluidInputs(FluidRegistry.getFluidStack("methanol", 8)).duration(7 * SECONDS + 10 * TICKS).eut(20)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 16, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.RawBioFiber", 1, 0, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("fuel", 8)).duration(5 * SECONDS).eut(20)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 16, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.RawBioFiber", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("nitrofuel", 8)).duration(2 * SECONDS + 10 * TICKS).eut(20)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L))
                .fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("enrichedbacterialsludge", 750))
                .duration(6 * SECONDS + 8 * TICKS).eut(4).addTo(brewingRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Uranium235, 1L))
                .fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("enrichedbacterialsludge", 750))
                .duration(6 * SECONDS + 8 * TICKS).eut(4).addTo(brewingRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing))
                .itemOutputs(CustomItemList.IridiumAlloyItemCasing.get(2L))
                .fluidInputs(FluidRegistry.getFluidStack("water", 288)).duration(1 * MINUTES).eut(256)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing))
                .itemOutputs(CustomItemList.IridiumAlloyItemCasing.get(2L))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 160)).duration(1 * MINUTES).eut(256)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing))
                .itemOutputs(CustomItemList.IridiumAlloyItemCasing.get(2L))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 64)).duration(30 * SECONDS).eut(256)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "tile.CallistoColdIce", 1, 0, missing))
                .itemOutputs(CustomItemList.CallistoIcePlate.get(9L))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).duration(3 * MINUTES).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().fluidInputs(FluidRegistry.getFluidStack("enrichedbacterialsludge", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("fermentedbacterialsludge", 75)).duration(2 * MINUTES).eut(2)
                .addTo(fermentingRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1L)),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 4L))
                .itemOutputs(CustomItemList.EngravedDiamondCrystalChip.get(1L)).duration(20 * SECONDS).eut(1920)
                .addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Ruby, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.EngravedEnergyChip.get(1L)).duration(30 * SECONDS).eut(4096)
                .addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Jasper, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.EngravedEnergyChip.get(1L)).duration(30 * SECONDS).eut(4096)
                .addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.FoolsRuby, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.EngravedEnergyChip.get(1L)).duration(30 * SECONDS).eut(4096)
                .addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.GarnetRed, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.EngravedEnergyChip.get(1L)).duration(30 * SECONDS).eut(4096)
                .addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility
                                .copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.InfusedFire, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.EngravedEnergyChip.get(1L)).duration(30 * SECONDS).eut(4096)
                .addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.InfusedAir, 1L)),
                        GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.GarnetYellow, 1L))
                .itemOutputs(CustomItemList.EngravedQuantumChip.get(1L)).duration(1 * MINUTES).eut(30720)
                .addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Force, 1L)),
                        GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.GarnetYellow, 1L))
                .itemOutputs(CustomItemList.EngravedQuantumChip.get(1L)).duration(1 * MINUTES).eut(30720)
                .addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility
                                .copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.GarnetYellow, 1L)),
                        GT_OreDictUnificator.get(OrePrefixes.gemExquisite, Materials.GarnetYellow, 1L))
                .itemOutputs(CustomItemList.EngravedQuantumChip.get(1L)).duration(1 * MINUTES).eut(30720)
                .addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.NanoCrystal.get(1L)).duration(30 * SECONDS).eut(480)
                .addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.NanoCrystal.get(1L)).duration(30 * SECONDS).eut(480)
                .addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.QuantumCrystal.get(1L)).duration(40 * SECONDS).eut(1920)
                .addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.QuantumCrystal.get(1L)).duration(40 * SECONDS).eut(1920)
                .addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Tanzanite, 1L)),
                        getModItem(NewHorizonsCoreMod.ID, "item.ManyullynPlate", 4, 0, missing))
                .itemOutputs(CustomItemList.ManyullynCrystal.get(1L)).duration(1 * MINUTES).eut(1920)
                .addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Amethyst, 1L)),
                        getModItem(NewHorizonsCoreMod.ID, "item.ManyullynPlate", 4, 0, missing))
                .itemOutputs(CustomItemList.ManyullynCrystal.get(1L)).duration(1 * MINUTES).eut(1920)
                .addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Tanzanite, 1L)),
                        CustomItemList.ManyullynCrystal.get(1L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.EngravedManyullynCrystalChip", 1, 0, missing))
                .duration(45 * SECONDS).eut(7680).addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Amethyst, 1L)),
                        CustomItemList.ManyullynCrystal.get(1L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.EngravedManyullynCrystalChip", 1, 0, missing))
                .duration(45 * SECONDS).eut(7680).addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.NetherStar, 1L)),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.EngravedGoldChip", 1, 0, missing))
                .duration(5 * SECONDS).eut(120).addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Dilithium, 1L)),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.EngravedGoldChip", 1, 0, missing))
                .duration(5 * SECONDS).eut(120).addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility
                                .copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.InfusedOrder, 1L)),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.EngravedGoldChip", 1, 0, missing))
                .duration(5 * SECONDS).eut(120).addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1L)),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.EngravedGoldChip", 1, 0, missing))
                .duration(5 * SECONDS).eut(120).addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_Utility.copyAmount(0L, GT_OreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1L)),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.EngravedGoldChip", 1, 0, missing))
                .duration(5 * SECONDS).eut(120).addTo(laserEngraverRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_Utility.getIntegratedCircuit(3))
                .fluidInputs(FluidRegistry.getFluidStack("fermentedbacterialsludge", 100))
                .fluidOutputs(FluidRegistry.getFluidStack("mutagen", 10)).duration(30 * SECONDS).eut(1920)
                .addTo(distilleryRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        ItemList.Shape_Extruder_Casing.get(0L))
                .itemOutputs(CustomItemList.IridiumAlloyItemCasing.get(2L)).duration(20 * SECONDS).eut(384)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 2, 4, missing),
                        ItemList.Shape_Extruder_Saw.get(0L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.SawBladeArdite", 1, 0, missing))
                .duration(20 * SECONDS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 2, 5, missing),
                        ItemList.Shape_Extruder_Saw.get(0L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.SawBladeManyullyn", 1, 0, missing))
                .duration(30 * SECONDS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 1, 5, missing),
                        ItemList.Shape_Extruder_Plate.get(0L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.ManyullynPlate", 1, 0, missing))
                .duration(5 * SECONDS).eut(480).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "feather", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.BowFletchingCast", 0, 0, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing)).duration(10 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 1, 1, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.BowFletchingCast", 0, 0, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "fletching", 1, 2, missing)).duration(10 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 1, 17, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.BowFletchingCast", 0, 0, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "fletching", 1, 3, missing)).duration(10 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "leaves", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.BowFletchingCast", 0, 0, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "fletching", 1, 1, missing)).duration(10 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "slime.leaves", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.BowFletchingCast", 0, 0, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "fletching", 1, 4, missing)).duration(10 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "string", 3, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.BowStringCast", 0, 0, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "bowstring", 1, 0, missing)).duration(20 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "barleyFood", 3, 7, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.BowStringCast", 0, 0, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "bowstring", 1, 2, missing)).duration(20 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "ItemResource", 3, 7, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.BowStringCast", 0, 0, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "bowstring", 1, 1, missing)).duration(20 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1, missing))
                .itemOutputs(CustomItemList.ChargedCertusQuartzDust.get(1L)).duration(10).eut(16).addTo(hammerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.EngravedManyullynCrystalChip", 1, 0, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 4, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.PulsatingSpatialCoreChip", 1, 0, missing))
                .duration(15 * SECONDS).eut(7680).addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.DiamondFluidCoreChip", 1, 0, missing))
                .duration(15 * SECONDS).eut(480).addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 7, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.EmeraldAdvancedFluidCoreChip", 1, 0, missing))
                .duration(15 * SECONDS).eut(1024).addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.EngravedGoldChip", 1, 0, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 2, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.GoldCoreChip", 1, 0, missing))
                .duration(15 * SECONDS).eut(256).addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.EngravedDiamondCrystalChip.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.DiamondCoreChip", 1, 0, missing))
                .duration(15 * SECONDS).eut(480).addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.EngravedEnergyChip.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 7, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.EmeraldAdvancedCoreChip", 1, 0, missing))
                .duration(15 * SECONDS).eut(1024).addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.EngravedQuantumChip.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 7, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.EmeraldHighAdvancedCoreChip", 1, 0, missing))
                .duration(15 * SECONDS).eut(4096).addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 4, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.GeneticCircuit", 1, 0, missing))
                .duration(15 * SECONDS).eut(480).addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.EnvironmentalCircuit", 1, 0, missing))
                .duration(15 * SECONDS).eut(480).addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 4, 4, missing))
                .itemOutputs(CustomItemList.AluminiumIronPlate.get(1L)).duration(30 * SECONDS).eut(120)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.AluminiumIronPlate.get(1L)).duration(30 * SECONDS).eut(120)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2L),
                        getModItem(Railcraft.ID, "part.plate", 4, 0, missing))
                .itemOutputs(CustomItemList.AluminiumIronPlate.get(1L)).duration(30 * SECONDS).eut(120)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 4, 4, missing))
                .itemOutputs(CustomItemList.TitaniumIronPlate.get(1L)).duration(30 * SECONDS).eut(480)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.TitaniumIronPlate.get(1L)).duration(30 * SECONDS).eut(480)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2L),
                        getModItem(Railcraft.ID, "part.plate", 4, 0, missing))
                .itemOutputs(CustomItemList.TitaniumIronPlate.get(1L)).duration(30 * SECONDS).eut(480)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 2L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 4, 4, missing))
                .itemOutputs(CustomItemList.TungstenIronPlate.get(1L)).duration(30 * SECONDS).eut(1920)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.TungstenIronPlate.get(1L)).duration(30 * SECONDS).eut(1920)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 2L),
                        getModItem(Railcraft.ID, "part.plate", 4, 0, missing))
                .itemOutputs(CustomItemList.TungstenIronPlate.get(1L)).duration(30 * SECONDS).eut(1920)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 2L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 4, 4, missing))
                .itemOutputs(CustomItemList.TungstenSteelIronPlate.get(1L)).duration(30 * SECONDS).eut(7680)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.TungstenSteelIronPlate.get(1L)).duration(30 * SECONDS).eut(7680)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 2L),
                        getModItem(Railcraft.ID, "part.plate", 4, 0, missing))
                .itemOutputs(CustomItemList.TungstenSteelIronPlate.get(1L)).duration(30 * SECONDS).eut(7680)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 2L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 4, 4, missing))
                .itemOutputs(CustomItemList.ChromeIronPlate.get(1L)).duration(30 * SECONDS).eut(30720)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.ChromeIronPlate.get(1L)).duration(30 * SECONDS).eut(30720)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 2L),
                        getModItem(Railcraft.ID, "part.plate", 4, 0, missing))
                .itemOutputs(CustomItemList.ChromeIronPlate.get(1L)).duration(30 * SECONDS).eut(30720)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 2L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 4, 4, missing))
                .itemOutputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 6, missing))
                .duration(30 * SECONDS).eut(122880).addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 6, missing))
                .duration(30 * SECONDS).eut(122880).addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 2L),
                        getModItem(Railcraft.ID, "part.plate", 4, 0, missing))
                .itemOutputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 6, missing))
                .duration(30 * SECONDS).eut(122880).addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadria, 2L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 4, 4, missing))
                .itemOutputs(CustomItemList.NaquadriaIronPlate.get(1L)).duration(30 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadria, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.NaquadriaIronPlate.get(1L)).duration(30 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Naquadria, 2L),
                        getModItem(Railcraft.ID, "part.plate", 4, 0, missing))
                .itemOutputs(CustomItemList.NaquadriaIronPlate.get(1L)).duration(30 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 2L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 4, 4, missing))
                .itemOutputs(CustomItemList.NeutroniumIronPlate.get(1L)).duration(30 * SECONDS).eut(TierEU.RECIPE_UHV)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.NeutroniumIronPlate.get(1L)).duration(30 * SECONDS).eut(TierEU.RECIPE_UHV)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 2L),
                        getModItem(Railcraft.ID, "part.plate", 4, 0, missing))
                .itemOutputs(CustomItemList.NeutroniumIronPlate.get(1L)).duration(30 * SECONDS).eut(TierEU.RECIPE_UHV)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bedrockium, 2L),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 4, 4, missing))
                .itemOutputs(CustomItemList.BedrockiumIronPlate.get(1L)).duration(30 * SECONDS).eut(8000000)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.BedrockiumPlate", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlates", 4, 4, missing))
                .itemOutputs(CustomItemList.BedrockiumIronPlate.get(1L)).duration(30 * SECONDS).eut(8000000)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bedrockium, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.BedrockiumIronPlate.get(1L)).duration(30 * SECONDS).eut(8000000)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.BedrockiumPlate", 2, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.BedrockiumIronPlate.get(1L)).duration(30 * SECONDS).eut(8000000)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Bedrockium, 2L),
                        getModItem(Railcraft.ID, "part.plate", 4, 0, missing))
                .itemOutputs(CustomItemList.BedrockiumIronPlate.get(1L)).duration(30 * SECONDS).eut(8000000)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.BedrockiumPlate", 2, 0, missing),
                        getModItem(Railcraft.ID, "part.plate", 4, 0, missing))
                .itemOutputs(CustomItemList.BedrockiumIronPlate.get(1L)).duration(30 * SECONDS).eut(8000000)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "obsidian", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.LongObsidianRod", 4, 0, missing))
                .duration(32 * SECONDS).eut(16).addTo(latheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.LongStoneRod", 4, 0, missing))
                .duration(16 * SECONDS).eut(16).addTo(latheRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 2, 1, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.ChargedCertusQuartzRod", 2, 0, missing),
                        CustomItemList.ChargedCertusQuartzDust.get(1L))
                .duration(10 * SECONDS).eut(16).addTo(latheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "sandstone", 1, wildcard, missing))
                .itemOutputs(CustomItemList.SandStoneRod.get(1L)).duration(8 * SECONDS).eut(16).addTo(latheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "cobblestone", 1, 0, missing))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 1),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Stone, 2L))
                .duration(8 * SECONDS).eut(16).addTo(latheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Forestry.ID, "mushroom", 1, wildcard, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.MushroomPowder", 2, 0, missing))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "brown_mushroom", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.MushroomPowder", 2, 0, missing))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "mushrooms", 1, wildcard, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.MushroomPowder", 2, 0, missing))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "whitemushroomItem", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.MushroomPowder", 2, 0, missing))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.MoldHelmet.get(1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 4L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.ExtruderShapeBoat", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 4L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.MoldLeggings.get(1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 4L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.MoldBoots.get(1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 4L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.MoldChestplate.get(1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 4L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.MarshmallowForm.get(1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 4L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.AluminiumItemCasing", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Aluminium, 2L))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.StainlessSteelItemCasing", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.StainlessSteel, 2L))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.TitaniumItemCasing", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Titanium, 2L))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.ChromeItemCasing", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Chrome, 2L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.TungstenItemCasing", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tungsten, 2L))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.TungstenSteelItemCasing", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.TungstenSteel, 2L))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.IridiumItemCasing", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 2L))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.IridiumAlloyItemCasing.get(1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 8L))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.OsmiumItemCasing", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Osmium, 2L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.NeutroniumItemCasing", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Neutronium, 2L))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.UnknowCrystal", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.MysteriousCrystal.get(1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 9L))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.RawMytryl", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.MytrylDust", 1, 0, missing)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "tile.Mytryl", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.MytrylDust", 9, 0, missing)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.MytrylCompressedPlate.get(1L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.MytrylDust", 3, 0, missing)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.MytrylIngot", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.MytrylDust", 1, 0, missing)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.MytrylPlate", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.MytrylDust", 1, 0, missing)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.MytrylDensePlate", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.MytrylDust", 9, 0, missing)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.QuantinumDensePlate", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.QuantinumDust", 9, 0, missing))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.QuantinumPlate", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.QuantinumDust", 1, 0, missing))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.QuantinumCompressedPlate.get(1L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.QuantinumDust", 3, 0, missing))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.QuantinumRod", 2, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.QuantinumDust", 1, 0, missing))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.BlackPlutoniumDensePlate", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.BlackPlutoniumDust", 18, 0, missing))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.BlackPlutoniumPlate", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.BlackPlutoniumDust", 2, 0, missing))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "tile.CallistoColdIce", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CallistoIceDust", 9, 0, missing))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CallistoIcePlate.get(1L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CallistoIceDust", 1, 0, missing))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CallistoIceCompressedPlate.get(1L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CallistoIceDust", 3, 0, missing))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "tile.Ledox", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.LedoxDust", 9, 0, missing)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.LedoxDensePlate", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.LedoxDust", 9, 0, missing)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.LedoxPlate", 1, 0, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.LedoxDust", 1, 0, missing)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.LedoxCompressedPlate.get(1L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.LedoxDust", 3, 0, missing)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 1, missing))
                .itemOutputs(CustomItemList.ChargedCertusQuartzDust.get(1L)).outputChances(10000).duration(15 * SECONDS)
                .eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.ChargedCertusQuartzPlate", 1, 0, missing))
                .itemOutputs(CustomItemList.ChargedCertusQuartzDust.get(1L)).outputChances(10000).duration(15 * SECONDS)
                .eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(NewHorizonsCoreMod.ID, "item.ChargedCertusQuartzRod", 2, 0, missing))
                .itemOutputs(CustomItemList.ChargedCertusQuartzDust.get(1L)).outputChances(10000).duration(15 * SECONDS)
                .eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 55, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.ElectrotineWire", 2, 0, missing))
                .duration(5 * SECONDS).eut(4).addTo(wiremillRecipes);
    }
}
