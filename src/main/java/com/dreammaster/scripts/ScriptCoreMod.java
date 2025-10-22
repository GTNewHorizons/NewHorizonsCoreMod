package com.dreammaster.scripts;

import static com.dreammaster.tinkersConstruct.SmelteryFluidTypes.getMoltenPatternFluidTypeName;
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
import static gregtech.api.recipe.RecipeCategories.alloySmelterMolding;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.autoclaveRecipes;
import static gregtech.api.recipe.RecipeMaps.brewingRecipes;
import static gregtech.api.recipe.RecipeMaps.compressorRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.distilleryRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.recipe.RecipeMaps.fermentingRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidExtractionRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidSolidifierRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.recipe.RecipeMaps.laserEngraverRecipes;
import static gregtech.api.recipe.RecipeMaps.latheRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.wiremillRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.block.BlockList;
import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.item.CustomPatterns;
import com.dreammaster.item.NHItemList;
import com.dreammaster.main.NHItems;
import com.dreammaster.tinkersConstruct.SmelteryFluidTypes;
import com.dreammaster.tinkersConstruct.TConstructHelper;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.objects.ItemData;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.crafting.FluidType;

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
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 1),
                "craftingToolFile",
                "cobblestone",
                "craftingToolSaw");
        addShapedRecipe(NHItemList.LongObsidianRod.getIS(2), "craftingToolSaw", "stoneObsidian", "craftingToolFile");
        addShapedRecipe(NHItemList.LongStoneRod.getIS(2), "craftingToolSaw", "stone", "craftingToolFile");
        addShapedRecipe(
                NHItemList.MushroomPowder.getIS(1),
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
                NHItemList.LaserEmitter.getIS(1),
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
                NHItemList.DiamondDrillTip.getIS(1),
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
                NHItemList.ReinforcedIridiumDrillTip.getIS(1),
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
                NHItemList.SawBladeDiamond.getIS(1),
                "plateDiamond",
                "plateDiamond",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                NHItemList.SawBladeStone.getIS(1),
                "plateStone",
                "plateStone",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                NHItemList.SawBladeArdite.getIS(1),
                "plateArdite",
                "plateArdite",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                NHItemList.SawBladeManyullyn.getIS(1),
                "plateManyullyn",
                "plateManyullyn",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                NHItemList.SawBladeRuby.getIS(1),
                "plateRuby",
                "plateRuby",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                NHItemList.SawBladeSapphire.getIS(1),
                "plateSapphire",
                "plateSapphire",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                NHItemList.SawBladePeridot.getIS(1),
                "plateOlivine",
                "plateOlivine",
                null,
                "craftingToolFile",
                "craftingToolHardHammer",
                null);
        addShapedRecipe(
                new ItemStack(CustomPatterns.BowFletchingCast, 1),
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
                new ItemStack(CustomPatterns.BowFletchingCast, 1),
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
                new ItemStack(CustomPatterns.BowStringCast, 1),
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
                new ItemStack(CustomPatterns.BowStringCast, 1),
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
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L),
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
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Clay, 1L),
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
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L),
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
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L),
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
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gypsum, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 1L),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L),
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.RubberRaw, 1L),
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
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 1L),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                null,
                null);
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Brick, 1L),
                null,
                null,
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing),
                getModItem(OpenBlocks.ID, "filledbucket", 1, 0, missing));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.WroughtIron, 1L),
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
                GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Arsenic, 1L),
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
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Zinc, 1L),
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
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Silver, 1L),
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
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L),
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
                GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gallium, 1L),
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
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.CobaltBrass, 1L),
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
                new ItemStack(NHItems.OVEN_GLOVE.get(), 1, 0),
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
                new ItemStack(NHItems.OVEN_GLOVE.get(), 1, 1),
                "itemLeather",
                "itemLeather",
                "itemLeather");
        addShapedRecipe(
                BlockList.DiamondFrameBox.getIS(),
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
                NHItemList.MoldFormCoinage.getIS(1),
                null,
                null,
                null,
                null,
                getModItem(TinkerConstruct.ID, "blankPattern", 1, 1, missing),
                null,
                "craftingToolFile",
                "craftingToolWireCutter",
                null);

        GTModHandler
                .addSmeltingRecipe(CustomItemList.UnfiredCokeOvenBrick.get(1L), CustomItemList.CokeOvenBrick.get(1L));
        TConstructHelper.getMeltingAdder(FluidType.getFluidType(getMoltenPatternFluidTypeName()), 150, 72)
                .add(
                        Stream.of(
                                NHItemList.ShapeBolt,
                                NHItemList.ShapeHoeHead,
                                NHItemList.ShapeGear,
                                NHItemList.ShapePlate,
                                NHItemList.MoldFormAnvil,
                                NHItemList.MoldFormPlate,
                                NHItemList.MoldFormLeggings,
                                NHItemList.MoldFormBaguette,
                                NHItemList.MoldFormGear,
                                NHItemList.MoldFormRotor,
                                NHItemList.ShapeBottle,
                                NHItemList.ShapeRotor,
                                NHItemList.ShapeTurbineBlade,
                                NHItemList.ShapeSmallGear,
                                NHItemList.MoldFormBoots,
                                NHItemList.ShapeLargePipe,
                                NHItemList.MoldFormSmallGear,
                                NHItemList.MoldFormCasing,
                                NHItemList.ShapeWire,
                                NHItemList.MoldFormChestplate,
                                NHItemList.ShapeShovelHead,
                                NHItemList.MoldFormBread,
                                NHItemList.ShapeIngot,
                                NHItemList.MoldFormIngot,
                                NHItemList.ShapeFileHead,
                                NHItemList.ShapeRod,
                                NHItemList.ShapeHugePipe,
                                NHItemList.ShapeSwordBlade,
                                NHItemList.ShapeRing,
                                NHItemList.ShapeCasing,
                                NHItemList.MoldFormNuggets,
                                NHItemList.ShapeSmallPipe,
                                NHItemList.MoldFormName,
                                NHItemList.ShapeHammerHead,
                                NHItemList.ShapeTinyPipe,
                                NHItemList.MoldFormCylinder,
                                NHItemList.MoldFormBottle,
                                NHItemList.ShapeAxeHead,
                                NHItemList.ShapeSawBlade,
                                NHItemList.MoldFormBlock,
                                NHItemList.ShapeCell,
                                NHItemList.MoldFormArrowHead,
                                NHItemList.ShapeBoat,
                                NHItemList.MoldFormCoinage,
                                NHItemList.MoldFormBall,
                                NHItemList.ShapeBlock,
                                NHItemList.MoldFormHelmet,
                                NHItemList.ShapePickaxeHead,
                                NHItemList.MoldFormBuns,
                                NHItemList.ShapeNormalPipe,
                                NHItemList.MoldFormStick,
                                NHItemList.MoldFormStickLong,
                                NHItemList.MoldFormScrew,
                                NHItemList.MoldFormRing,
                                NHItemList.MoldFormBolt,
                                NHItemList.MoldFormRound,
                                NHItemList.MoldFormTurbineBlade,
                                NHItemList.MoldFormPipeTiny,
                                NHItemList.MoldFormPipeSmall,
                                NHItemList.MoldFormPipeMedium,
                                NHItemList.MoldFormPipeLarge,
                                NHItemList.MoldFormPipeHuge).map(NHItemList::getIS))
                .add(CustomItemList.MarshmallowFormMold.get(1L));

        GTValues.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "machine.alpha", 1, 7, missing))
                .itemOutputs(CustomItemList.CokeOvenBrick.get(4L)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "machine.alpha", 1, 12, missing))
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
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 1L),
                'e',
                getModItem(Minecraft.ID, "piston", 1, 0, missing));
        TConstructRegistry.getTableCasting().addCastingRecipe(
                NHItemList.ExtruderShapeBoat.getIS(1),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.ShapeBoat.getIS(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                CustomItemList.MoldBoots.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormBoots.getIS(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                CustomItemList.MoldChestplate.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormChestplate.getIS(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                CustomItemList.MoldHelmet.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormHelmet.getIS(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                CustomItemList.MoldLeggings.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                NHItemList.MoldFormLeggings.getIS(1),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                CustomItemList.MarshmallowForm.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                CustomItemList.MarshmallowFormMold.get(1L),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                new ItemStack(CustomPatterns.BowFletchingCast, 1),
                FluidRegistry.getFluidStack(SmelteryFluidTypes.getMoltenPatternFluidName(), 144),
                getModItem(TinkerConstruct.ID, "fletching", 1, wildcard, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                new ItemStack(CustomPatterns.BowStringCast, 1),
                FluidRegistry.getFluidStack(SmelteryFluidTypes.getMoltenPatternFluidName(), 144),
                getModItem(TinkerConstruct.ID, "bowstring", 1, wildcard, missing),
                true,
                100);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 4, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Naquadria, 1L))
                .itemOutputs(NHItemList.EnrichedNaquadriaSunnariumAlloy.getIS(1)).duration(1 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EnrichedNaquadriaSunnariumAlloy.getIS(1),
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Neutronium, 1L))
                .itemOutputs(
                        getModItem(
                                NewHorizonsCoreMod.ID,
                                "item.EnrichedNaquadriaNeutroniumSunnariumAlloy",
                                1,
                                0,
                                missing))
                .duration(2 * MINUTES).eut(TierEU.RECIPE_UHV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EnrichedNaquadriaNeutroniumSunnariumAlloy.getIS(1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bedrockium, 18))
                .itemOutputs(NHItemList.EnrichedXSunnariumAlloy.getIS(1)).duration(2 * MINUTES + 20 * SECONDS)
                .eut(TierEU.RECIPE_UEV).addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bronze, 6L))
                .itemOutputs(BlockList.BronzePlatedReinforcedStone.getIS())
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 144)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 6L))
                .itemOutputs(BlockList.SteelPlatedReinforcedStone.getIS())
                .fluidInputs(FluidRegistry.getFluidStack("molten.aluminium", 144)).duration(12 * SECONDS + 10 * TICKS)
                .eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 6L))
                .itemOutputs(BlockList.TitaniumPlatedReinforcedStone.getIS())
                .fluidInputs(FluidRegistry.getFluidStack("molten.platinum", 144)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 6L))
                .itemOutputs(BlockList.TungstensteelPlatedReinforcedStone.getIS())
                .fluidInputs(FluidRegistry.getFluidStack("molten.iridium", 144)).duration(17 * SECONDS + 10 * TICKS)
                .eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 6L))
                .itemOutputs(BlockList.NaquadahPlatedReinforcedStone.getIS())
                .fluidInputs(FluidRegistry.getFluidStack("molten.osmium", 144)).duration(22 * SECONDS + 10 * TICKS)
                .eut(256).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockAlloy", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 6L))
                .itemOutputs(BlockList.NeutroniumPlatedReinforcedStone.getIS())
                .fluidInputs(FluidRegistry.getFluidStack("molten.naquadria", 144)).duration(25 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GTOreDictUnificator.addItemData(
                BlockList.BronzePlatedReinforcedStone.getIS(),
                new ItemData(
                        new ItemData(Materials.Bronze, 6 * GTValues.M),
                        new ItemData(Materials.Steel, 3 * GTValues.M),
                        new ItemData(Materials.Concrete, 1 * GTValues.M)));
        GTOreDictUnificator.addItemData(
                BlockList.SteelPlatedReinforcedStone.getIS(),
                new ItemData(
                        new ItemData(Materials.Steel, 8 * GTValues.M),
                        new ItemData(Materials.Aluminium, 1 * GTValues.M),
                        new ItemData(Materials.Concrete, 1 * GTValues.M)));
        GTOreDictUnificator.addItemData(
                BlockList.TitaniumPlatedReinforcedStone.getIS(),
                new ItemData(
                        new ItemData(Materials.Titanium, 6 * GTValues.M),
                        new ItemData(Materials.Platinum, 1 * GTValues.M),
                        new ItemData(Materials.Steel, 2 * GTValues.M),
                        new ItemData(Materials.Concrete, 1 * GTValues.M)));
        GTOreDictUnificator.addItemData(
                BlockList.TungstensteelPlatedReinforcedStone.getIS(),
                new ItemData(
                        new ItemData(Materials.TungstenSteel, 6 * GTValues.M),
                        new ItemData(Materials.Iridium, 1 * GTValues.M),
                        new ItemData(Materials.Steel, 2 * GTValues.M),
                        new ItemData(Materials.Concrete, 1 * GTValues.M)));
        GTOreDictUnificator.addItemData(
                BlockList.NaquadahPlatedReinforcedStone.getIS(),
                new ItemData(
                        new ItemData(Materials.Naquadah, 6 * GTValues.M),
                        new ItemData(Materials.Osmium, 1 * GTValues.M),
                        new ItemData(Materials.Steel, 2 * GTValues.M),
                        new ItemData(Materials.Concrete, 1 * GTValues.M)));
        GTOreDictUnificator.addItemData(
                BlockList.NeutroniumPlatedReinforcedStone.getIS(),
                new ItemData(
                        new ItemData(Materials.Neutronium, 6 * GTValues.M),
                        new ItemData(Materials.Naquadria, 1 * GTValues.M),
                        new ItemData(Materials.Steel, 2 * GTValues.M),
                        new ItemData(Materials.Concrete, 1 * GTValues.M)));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftMars.ID, "item.itemBasicAsteroids", 2, 6, missing),
                        getModItem(GalacticraftCore.ID, "item.basicItem", 2, 14, missing))
                .itemOutputs(NHItemList.LightBinding.getIS(1)).duration(30 * SECONDS).eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.RawBioFiber.getIS(2), GTUtility.getIntegratedCircuit(2))
                .itemOutputs(NHItemList.BioOrganicMesh.getIS(1)).duration(40 * SECONDS).eut(2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Charcoal, 1L),
                        NHItemList.CompressedBioBall.getIS(8))
                .itemOutputs(NHItemList.BioChunk.getIS(1)).duration(1 * MINUTES).eut(64).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Diamond, 4L),
                        GTUtility.getIntegratedCircuit(4))
                .itemOutputs(BlockList.DiamondFrameBox.getIS()).duration(3 * SECONDS + 4 * TICKS).eut(8)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone", 2, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Graphite, 1L))
                .itemOutputs(BlockList.CompressedGraphite.getIS(2)).duration(5 * SECONDS).eut(8)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing),
                        getModItem(RemoteIO.ID, "item.blank_plate", 1, 0, missing))
                .itemOutputs(NHItemList.BlankPlatedChip.getIS(1)).duration(5 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        NHItemList.PulsatingSpatialCoreChip.getIS(1))
                .itemOutputs(
                        getModItem(
                                NewHorizonsCoreMod.ID,
                                "item.EngineeringProcessorSpatialPulsatingCore",
                                1,
                                0,
                                missing))
                .duration(5 * SECONDS).eut(7680).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        NHItemList.DiamondFluidCoreChip.getIS(1))
                .itemOutputs(NHItemList.EngineeringProcessorFluidDiamondCore.getIS(1)).duration(5 * SECONDS).eut(1920)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        NHItemList.EmeraldAdvancedFluidCoreChip.getIS(1))
                .itemOutputs(NHItemList.EngineeringProcessorFluidEmeraldCore.getIS(1)).duration(5 * SECONDS).eut(7680)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 22, missing),
                        NHItemList.GoldCoreChip.getIS(1))
                .itemOutputs(CustomItemList.LogicProcessorItemGoldCore.get(1L)).duration(5 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        NHItemList.DiamondCoreChip.getIS(1))
                .itemOutputs(CustomItemList.EngineeringProcessorItemDiamondCore.get(1L)).duration(5 * SECONDS).eut(1920)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        NHItemList.EmeraldAdvancedCoreChip.getIS(1))
                .itemOutputs(CustomItemList.EngineeringProcessorItemEmeraldCore.get(1L)).duration(5 * SECONDS).eut(7680)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 24, missing),
                        NHItemList.EmeraldHighAdvancedCoreChip.getIS(1))
                .itemOutputs(CustomItemList.EngineeringProcessorItemAdvEmeraldCore.get(1L)).duration(5 * SECONDS)
                .eut(30720).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 3, missing),
                        getModItem(GalaxySpace.ID, "item.CompressedPlates", 1, 6, missing))
                .itemOutputs(CustomItemList.LeadNickelPlate.get(2L))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 2000)).duration(30 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L))
                .itemOutputs(getModItem(GalaxySpace.ID, "item.UnknowCrystal", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 288)).duration(1 * MINUTES).eut(480)
                .addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 16, 0, missing))
                .itemOutputs(NHItemList.RawBioFiber.getIS(1)).outputChances(3300)
                .fluidInputs(FluidRegistry.getFluidStack("ic2biomass", 8)).duration(10 * SECONDS).eut(20)
                .addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 16, 0, missing))
                .itemOutputs(NHItemList.RawBioFiber.getIS(1)).outputChances(5000)
                .fluidInputs(FluidRegistry.getFluidStack("methanol", 8)).duration(7 * SECONDS + 10 * TICKS).eut(20)
                .addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 16, 0, missing))
                .itemOutputs(NHItemList.RawBioFiber.getIS(1)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("fuel", 8)).duration(5 * SECONDS).eut(20)
                .addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 16, 0, missing))
                .itemOutputs(NHItemList.RawBioFiber.getIS(1)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("nitrofuel", 8)).duration(2 * SECONDS + 10 * TICKS).eut(20)
                .addTo(autoclaveRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1L))
                .fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("enrichedbacterialsludge", 750))
                .duration(6 * SECONDS + 8 * TICKS).eut(4).addTo(brewingRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Uranium235, 1L))
                .fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("enrichedbacterialsludge", 750))
                .duration(6 * SECONDS + 8 * TICKS).eut(4).addTo(brewingRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing))
                .itemOutputs(CustomItemList.IridiumAlloyItemCasing.get(2L))
                .fluidInputs(FluidRegistry.getFluidStack("water", 288)).duration(1 * MINUTES).eut(256)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing))
                .itemOutputs(CustomItemList.IridiumAlloyItemCasing.get(2L))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 160)).duration(1 * MINUTES).eut(256)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing))
                .itemOutputs(CustomItemList.IridiumAlloyItemCasing.get(2L))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 64)).duration(30 * SECONDS).eut(256)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().fluidInputs(FluidRegistry.getFluidStack("enrichedbacterialsludge", 750))
                .fluidOutputs(FluidRegistry.getFluidStack("fermentedbacterialsludge", 75)).duration(2 * MINUTES).eut(2)
                .addTo(fermentingRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 4L))
                .itemOutputs(CustomItemList.EngravedDiamondCrystalChip.get(1L)).duration(20 * SECONDS).eut(1920)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Ruby, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.EngravedEnergyChip.get(1L)).duration(30 * SECONDS).eut(4096)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Jasper, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.EngravedEnergyChip.get(1L)).duration(30 * SECONDS).eut(4096)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Spinel, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.EngravedEnergyChip.get(1L)).duration(30 * SECONDS).eut(4096)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.GarnetRed, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.EngravedEnergyChip.get(1L)).duration(30 * SECONDS).eut(4096)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.InfusedFire, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.EngravedEnergyChip.get(1L)).duration(30 * SECONDS).eut(4096)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.InfusedAir, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.GarnetYellow, 1L))
                .itemOutputs(CustomItemList.EngravedQuantumChip.get(1L)).duration(1 * MINUTES).eut(30720)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Force, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.GarnetYellow, 1L))
                .itemOutputs(CustomItemList.EngravedQuantumChip.get(1L)).duration(1 * MINUTES).eut(30720)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.GarnetYellow, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.GarnetYellow, 1L))
                .itemOutputs(CustomItemList.EngravedQuantumChip.get(1L)).duration(1 * MINUTES).eut(30720)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.NanoCrystal.get(1L)).duration(30 * SECONDS).eut(480)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.NanoCrystal.get(1L)).duration(30 * SECONDS).eut(480)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.QuantumCrystal.get(1L)).duration(40 * SECONDS).eut(1920)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.EnderPearl, 1L)),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing))
                .itemOutputs(CustomItemList.QuantumCrystal.get(1L)).duration(40 * SECONDS).eut(1920)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Tanzanite, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 4))
                .itemOutputs(CustomItemList.ManyullynCrystal.get(1L)).duration(1 * MINUTES).eut(1920)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Amethyst, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 4))
                .itemOutputs(CustomItemList.ManyullynCrystal.get(1L)).duration(1 * MINUTES).eut(1920)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Tanzanite, 1L)),
                        CustomItemList.ManyullynCrystal.get(1L))
                .itemOutputs(NHItemList.EngravedManyullynCrystalChip.getIS(1)).duration(45 * SECONDS).eut(7680)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Amethyst, 1L)),
                        CustomItemList.ManyullynCrystal.get(1L))
                .itemOutputs(NHItemList.EngravedManyullynCrystalChip.getIS(1)).duration(45 * SECONDS).eut(7680)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.NetherStar, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(NHItemList.EngravedGoldChip.getIS(1)).duration(5 * SECONDS).eut(120)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Dilithium, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(NHItemList.EngravedGoldChip.getIS(1)).duration(5 * SECONDS).eut(120)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.InfusedOrder, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(NHItemList.EngravedGoldChip.getIS(1)).duration(5 * SECONDS).eut(120)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Glass, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(NHItemList.EngravedGoldChip.getIS(1)).duration(5 * SECONDS).eut(120)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Diamond, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L))
                .itemOutputs(NHItemList.EngravedGoldChip.getIS(1)).duration(5 * SECONDS).eut(120)
                .addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTUtility.getIntegratedCircuit(3))
                .fluidInputs(FluidRegistry.getFluidStack("fermentedbacterialsludge", 10))
                .fluidOutputs(FluidRegistry.getFluidStack("mutagen", 1)).duration(3 * SECONDS).eut(1920)
                .addTo(distilleryRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        ItemList.Shape_Extruder_Casing.get(0L))
                .itemOutputs(CustomItemList.IridiumAlloyItemCasing.get(2L)).duration(20 * SECONDS).eut(384)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 2, 4, missing),
                        ItemList.Shape_Extruder_Saw.get(0L))
                .itemOutputs(NHItemList.SawBladeArdite.getIS(1)).duration(20 * SECONDS).eut(120).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 2, 5, missing),
                        ItemList.Shape_Extruder_Saw.get(0L))
                .itemOutputs(NHItemList.SawBladeManyullyn.getIS(1)).duration(30 * SECONDS).eut(120)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 1, 5, missing),
                        ItemList.Shape_Extruder_Plate.get(0L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 1)).duration(5 * SECONDS)
                .eut(480).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "feather", 1, 0, missing),
                        new ItemStack(CustomPatterns.BowFletchingCast, 0))
                .itemOutputs(getModItem(TinkerConstruct.ID, "fletching", 1, 0, missing)).duration(10 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 1, 1, missing),
                        new ItemStack(CustomPatterns.BowFletchingCast, 0))
                .itemOutputs(getModItem(TinkerConstruct.ID, "fletching", 1, 2, missing)).duration(10 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 1, 17, missing),
                        new ItemStack(CustomPatterns.BowFletchingCast, 0))
                .itemOutputs(getModItem(TinkerConstruct.ID, "fletching", 1, 3, missing)).duration(10 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "leaves", 1, 0, missing),
                        new ItemStack(CustomPatterns.BowFletchingCast, 0))
                .itemOutputs(getModItem(TinkerConstruct.ID, "fletching", 1, 1, missing)).duration(10 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "slime.leaves", 1, 0, missing),
                        new ItemStack(CustomPatterns.BowFletchingCast, 0))
                .itemOutputs(getModItem(TinkerConstruct.ID, "fletching", 1, 4, missing)).duration(10 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "string", 3, 0, missing),
                        new ItemStack(CustomPatterns.BowStringCast, 0))
                .itemOutputs(getModItem(TinkerConstruct.ID, "bowstring", 1, 0, missing)).duration(20 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "barleyFood", 3, 7, missing),
                        new ItemStack(CustomPatterns.BowStringCast, 0))
                .itemOutputs(getModItem(TinkerConstruct.ID, "bowstring", 1, 2, missing)).duration(20 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "ItemResource", 3, 7, missing),
                        new ItemStack(CustomPatterns.BowStringCast, 0))
                .itemOutputs(getModItem(TinkerConstruct.ID, "bowstring", 1, 1, missing)).duration(20 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EngravedManyullynCrystalChip.getIS(1),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 4, missing))
                .itemOutputs(NHItemList.PulsatingSpatialCoreChip.getIS(1)).duration(15 * SECONDS).eut(7680)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing))
                .itemOutputs(NHItemList.DiamondFluidCoreChip.getIS(1)).duration(15 * SECONDS).eut(480)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Crystal_Chip_Master.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 7, missing))
                .itemOutputs(NHItemList.EmeraldAdvancedFluidCoreChip.getIS(1)).duration(15 * SECONDS).eut(1024)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        NHItemList.EngravedGoldChip.getIS(1),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 2, missing))
                .itemOutputs(NHItemList.GoldCoreChip.getIS(1)).duration(15 * SECONDS).eut(256)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.EngravedDiamondCrystalChip.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing))
                .itemOutputs(NHItemList.DiamondCoreChip.getIS(1)).duration(15 * SECONDS).eut(480)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.EngravedEnergyChip.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 7, missing))
                .itemOutputs(NHItemList.EmeraldAdvancedCoreChip.getIS(1)).duration(15 * SECONDS).eut(1024)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.EngravedQuantumChip.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 7, missing))
                .itemOutputs(NHItemList.EmeraldHighAdvancedCoreChip.getIS(1)).duration(15 * SECONDS).eut(4096)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 4, missing))
                .itemOutputs(NHItemList.GeneticCircuit.getIS(1)).duration(15 * SECONDS).eut(480)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Parts_Crystal_Chip_Elite.get(1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing))
                .itemOutputs(NHItemList.EnvironmentalCircuit.getIS(1)).duration(15 * SECONDS).eut(480)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Aluminium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.AluminiumIronPlate.get(1L)).duration(30 * SECONDS).eut(120)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.TitaniumIronPlate.get(1L)).duration(30 * SECONDS).eut(480)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Tungsten, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.TungstenIronPlate.get(1L)).duration(30 * SECONDS).eut(1920)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.TungstenSteelIronPlate.get(1L)).duration(30 * SECONDS).eut(7680)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Chrome, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.ChromeIronPlate.get(1L)).duration(30 * SECONDS).eut(30720)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iridium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 6, missing))
                .duration(30 * SECONDS).eut(122880).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Naquadria, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.NaquadriaIronPlate.get(1L)).duration(30 * SECONDS).eut(TierEU.RECIPE_UV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Neutronium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.NeutroniumIronPlate.get(1L)).duration(30 * SECONDS).eut(TierEU.RECIPE_UHV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Bedrockium, 2L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L))
                .itemOutputs(CustomItemList.BedrockiumIronPlate.get(1L)).duration(30 * SECONDS).eut(TierEU.RECIPE_UEV)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone", 1, 0, missing))
                .itemOutputs(NHItemList.LongStoneRod.getIS(4)).duration(16 * SECONDS).eut(16).addTo(latheRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "sandstone", 1, wildcard, missing))
                .itemOutputs(CustomItemList.SandStoneRod.get(1L)).duration(8 * SECONDS).eut(16).addTo(latheRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "cobblestone", 1, 0, missing))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 1),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Stone, 2L))
                .duration(8 * SECONDS).eut(16).addTo(latheRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Forestry.ID, "mushroom", 1, wildcard, missing))
                .itemOutputs(NHItemList.MushroomPowder.getIS(2)).outputChances(10000).duration(15 * SECONDS).eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "brown_mushroom", 1, 0, missing))
                .itemOutputs(NHItemList.MushroomPowder.getIS(2)).outputChances(10000).duration(15 * SECONDS).eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "mushrooms", 1, wildcard, missing))
                .itemOutputs(NHItemList.MushroomPowder.getIS(2)).outputChances(10000).duration(15 * SECONDS).eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "whitemushroomItem", 1, 0, missing))
                .itemOutputs(NHItemList.MushroomPowder.getIS(2)).outputChances(10000).duration(15 * SECONDS).eut(2)
                .addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(CustomItemList.IridiumAlloyItemCasing.get(1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Iridium, 8L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "item.UnknowCrystal", 1, 0, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(CustomItemList.MysteriousCrystal.get(1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 9L))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(NHItemList.RawMytryl.getIS(1))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Mytryl, 1)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 55, missing))
                .itemOutputs(NHItemList.ElectrotineWire.getIS(2)).duration(5 * SECONDS).eut(4).addTo(wiremillRecipes);

        // Obsidian Stuff
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian))
                .itemOutputs(NHItemList.LongObsidianRod.getIS(2)).duration(32 * SECONDS).eut(16).addTo(latheRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 2))
                .fluidInputs(Materials.Lubricant.getFluid(5)).duration(11 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 2))
                .fluidInputs(Materials.Water.getFluid(20)).duration(22 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 2))
                .fluidInputs(GTModHandler.getDistilledWater(15)).duration(22 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian))
                .fluidOutputs(Materials.Obsidian.getMolten(288)).duration(10 * SECONDS + 16 * TICKS).eut(35)
                .addTo(fluidExtractionRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 2))
                .duration(9 * SECONDS + 18 * TICKS).eut(4).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.obsidian), ItemList.Shape_Mold_Ingot.get(0))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Obsidian, 2))
                .duration(6 * SECONDS + 10 * TICKS).eut(3).recipeCategory(alloySmelterMolding)
                .addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Obsidian, 2))
                .itemOutputs(new ItemStack(Blocks.obsidian)).duration(15 * SECONDS).eut(2).addTo(compressorRecipes);
        GTValues.RA.stdBuilder().fluidInputs(Materials.Obsidian.getMolten(288))
                .itemInputs(ItemList.Shape_Mold_Block.get(0)).itemOutputs(new ItemStack(Blocks.obsidian))
                .duration(14 * SECONDS + 8 * TICKS).eut(8).addTo(fluidSolidifierRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 2),
                        ItemList.Shape_Extruder_Block.get(0))
                .itemOutputs(new ItemStack(Blocks.obsidian)).duration(10 * TICKS).eut(24).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Obsidian, 2),
                        ItemList.Shape_Extruder_Block.get(0))
                .itemOutputs(new ItemStack(Blocks.obsidian)).duration(10 * TICKS).eut(24).addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Obsidian, 2),
                        ItemList.Shape_Mold_Block.get(0))
                .itemOutputs(new ItemStack(Blocks.obsidian)).duration(5 * TICKS).eut(12)
                .recipeCategory(alloySmelterMolding).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Obsidian, 2),
                        ItemList.Shape_Mold_Block.get(0))
                .itemOutputs(new ItemStack(Blocks.obsidian)).duration(5 * TICKS).eut(12)
                .recipeCategory(alloySmelterMolding).addTo(alloySmelterRecipes);

    }
}
