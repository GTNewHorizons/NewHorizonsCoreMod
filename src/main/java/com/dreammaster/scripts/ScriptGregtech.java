package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.CropsPlusPlus;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MCFrames;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.ProjectRedExpansion;
import static gregtech.api.enums.Mods.ProjectRedTransmission;
import static gregtech.api.enums.Mods.SGCraft;
import static gregtech.api.enums.Mods.StructureLib;
import static gregtech.api.enums.Mods.SuperSolarPanels;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.autoclaveRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.recipe.RecipeMaps.hammerRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;
import static gregtech.api.util.GT_RecipeConstants.UniversalChemical;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import tconstruct.library.TConstructRegistry;

public class ScriptGregtech implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Gregtech";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                MCFrames.ID,
                ProjectRedExpansion.ID,
                ProjectRedTransmission.ID,
                StructureLib.ID,
                AdvancedSolarPanel.ID,
                BiomesOPlenty.ID,
                BloodArsenal.ID,
                CropsPlusPlus.ID,
                IndustrialCraft2.ID,
                Natura.ID,
                OpenBlocks.ID,
                PamsHarvestCraft.ID,
                SGCraft.ID,
                SuperSolarPanels.ID,
                Thaumcraft.ID,
                ThaumicBases.ID,
                TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                ItemList.Teleporter.get(1L),
                "circuitOptical",
                getModItem(SGCraft.ID, "ic2PowerUnit", 1, 0, missing),
                "circuitOptical",
                getModItem(SGCraft.ID, "ic2Capacitor", 1, 0, missing),
                getModItem(SGCraft.ID, "stargateBase", 1, 0, missing),
                getModItem(SGCraft.ID, "ic2Capacitor", 1, 0, missing),
                getModItem(SGCraft.ID, "ic2Capacitor", 1, 0, missing),
                getModItem(SGCraft.ID, "ocInterface", 1, 0, missing),
                getModItem(SGCraft.ID, "ic2Capacitor", 1, 0, missing));
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.toolHeadSword, Materials.Diamond, 1L),
                null,
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                null,
                "craftingToolFile",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                null,
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.toolHeadPickaxe, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "gemDiamond",
                "gemDiamond",
                "craftingToolFile",
                null,
                "craftingToolHardHammer",
                null,
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.toolHeadShovel, Materials.Diamond, 1L),
                "craftingToolFile",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.toolHeadAxe, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "gemDiamond",
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                null,
                null,
                "craftingToolFile",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "gemDiamond",
                "craftingToolHardHammer",
                "craftingToolFile",
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Wood, 1L),
                "craftingToolKnife",
                null,
                null,
                null,
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                null);
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L),
                "craftingToolMortar",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Glass, 1L),
                "craftingToolMortar",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L),
                "craftingToolMortar",
                "listAllmeatraw");
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L),
                "craftingToolMortar",
                "listAllfishraw");
        addShapelessRecipe(
                getModItem(Minecraft.ID, "sugar", 4, 0, missing),
                "craftingToolMortar",
                getModItem(CropsPlusPlus.ID, "foodBerries", 1, 1, missing));
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatCooked, 1L),
                "craftingToolMortar",
                "listAllmeatcooked");
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatCooked, 1L),
                "craftingToolMortar",
                "listAllfishcooked");
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 2L),
                "craftingToolMortar",
                "logWood");
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Brick, 1L),
                "craftingToolMortar",
                getModItem(Minecraft.ID, "brick", 1, 0, missing));
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Plastic, 1L),
                "stickPlastic",
                "craftingToolHardHammer",
                "stickPlastic");
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L),
                "cropBarley",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L),
                "cropWheat",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L),
                "cropRye",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L),
                "cropOats",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Salt, 1L),
                getModItem(GregTech.ID, "gt.blockores", 1, 817, missing),
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Salt, 1L),
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Salt, 1L),
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Salt, 1L),
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Salt, 1L),
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Salt, 1L),
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Salt, 1L),
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Salt, 1L),
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Salt, 1L),
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Clay, 1L),
                "craftingToolMortar",
                getModItem(Minecraft.ID, "clay_ball", 1, 0, missing));
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Iron, 1L),
                "nuggetIron",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gold, 1L),
                "nuggetGold",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Copper, 1L),
                "nuggetCopper",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tin, 1L),
                "nuggetTin",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Silver, 1L),
                "nuggetSilver",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Lead, 1L),
                "nuggetLead",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Zinc, 1L),
                "nuggetZinc",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Nickel, 1L),
                "nuggetNickel",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                ItemList.Casing_Motor.get(1L),
                "itemCasingStainlessSteel",
                "circuitAdvanced",
                "itemCasingStainlessSteel",
                ItemList.Electric_Motor_HV.get(1L),
                ItemList.Casing_SolidSteel.get(1L),
                ItemList.Electric_Motor_HV.get(1L),
                "itemCasingStainlessSteel",
                "circuitAdvanced",
                "itemCasingStainlessSteel");
        addShapelessRecipe(
                ItemList.Cover_SolarPanel.get(1L),
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.solar_panel", 1, 0, missing));
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 1L),
                getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 0, missing));
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22880, missing),
                "stickRubber",
                "craftingToolHardHammer",
                "stickRubber");
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Apatite, 1L),
                "stickApatite",
                "craftingToolHardHammer",
                "stickApatite");
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Lapis, 1L),
                "stickLapis",
                "craftingToolHardHammer",
                "stickLapis");
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Lazurite, 1L),
                "stickLazurite",
                "craftingToolHardHammer",
                "stickLazurite");
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Sodalite, 1L),
                "stickSodalite",
                "craftingToolHardHammer",
                "stickSodalite");
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.EnderPearl, 1L),
                "stickEnderPearl",
                "craftingToolHardHammer",
                "stickEnderPearl");
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.EnderEye, 1L),
                "stickEnderEye",
                "craftingToolHardHammer",
                "stickEnderEye");
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 2L),
                getModItem(MCFrames.ID, "mcframes.frame", 1, 0, missing));
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L),
                getModItem(OpenBlocks.ID, "scaffolding", 1, 0, missing));
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Glass, 1L),
                "craftingToolMortar",
                getModItem(BloodArsenal.ID, "glass_shard", 1, 0, missing));
        addShapedRecipe(
                ItemList.Casing_Pump.get(1L),
                "itemCasingStainlessSteel",
                "circuitAdvanced",
                "itemCasingStainlessSteel",
                ItemList.Electric_Pump_HV.get(1L),
                ItemList.Casing_SolidSteel.get(1L),
                ItemList.Electric_Pump_HV.get(1L),
                "itemCasingStainlessSteel",
                "circuitAdvanced",
                "itemCasingStainlessSteel");
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.GraniteBlack, 1L),
                "stoneGraniteBlack",
                null,
                null,
                null,
                "craftingToolFile",
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.GraniteRed, 1L),
                "stoneGraniteRed",
                null,
                null,
                null,
                "craftingToolFile",
                null);
        addShapedRecipe(
                ItemList.Casing_Processor.get(1L),
                "itemCasingStainlessSteel",
                "circuitElite",
                "itemCasingStainlessSteel",
                "circuitElite",
                ItemList.Casing_SolidSteel.get(1L),
                "circuitElite",
                "itemCasingStainlessSteel",
                "circuitElite",
                "itemCasingStainlessSteel");
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L),
                "craftingToolHardHammer",
                null,
                null,
                "ingotObsidian",
                null,
                null,
                "ingotObsidian",
                null,
                null);
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockstones", 1, 2, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(GregTech.ID, "gt.blockstones", 1, 1, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing));
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockstones", 1, 5, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(GregTech.ID, "gt.blockstones", 1, 3, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing));
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockconcretes", 1, 10, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(GregTech.ID, "gt.blockconcretes", 1, 9, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing));
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockconcretes", 1, 13, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(GregTech.ID, "gt.blockconcretes", 1, 11, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing));
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockstones", 1, 10, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(GregTech.ID, "gt.blockstones", 1, 9, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing));
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockstones", 1, 13, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(GregTech.ID, "gt.blockstones", 1, 11, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing));
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockgranites", 1, 2, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(GregTech.ID, "gt.blockgranites", 1, 1, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing));
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockgranites", 1, 5, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(GregTech.ID, "gt.blockgranites", 1, 3, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing));
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockgranites", 1, 10, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(GregTech.ID, "gt.blockgranites", 1, 9, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing));
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.blockgranites", 1, 13, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(GregTech.ID, "gt.blockgranites", 1, 11, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing));
        addShapelessRecipe(ItemList.Color_03.get(1L), "dyeBrown");
        addShapelessRecipe(ItemList.Color_07.get(1L), "dyeLightGray");
        addShapelessRecipe(ItemList.Color_11.get(1L), "dyeYellow");
        addShapelessRecipe(ItemList.Color_15.get(1L), "dyeWhite");
        addShapelessRecipe(ItemList.Color_04.get(1L), "dyeBlue");
        addShapelessRecipe(ItemList.Color_08.get(1L), "dyeGray");
        addShapelessRecipe(ItemList.Color_10.get(1L), "dyeLime");
        addShapelessRecipe(ItemList.Color_14.get(1L), "dyeOrange");
        addShapelessRecipe(ItemList.Color_01.get(1L), "dyeRed");
        addShapelessRecipe(ItemList.Color_05.get(1L), "dyePurple");
        addShapelessRecipe(ItemList.Color_09.get(1L), "dyePink");
        addShapelessRecipe(ItemList.Color_13.get(1L), "dyeMagenta");
        addShapelessRecipe(ItemList.Color_00.get(1L), "dyeBlack");
        addShapelessRecipe(ItemList.Color_02.get(1L), "dyeGreen");
        addShapelessRecipe(ItemList.Color_06.get(1L), "dyeCyan");
        addShapelessRecipe(ItemList.Color_12.get(1L), "dyeLightBlue");
        addShapelessRecipe(
                getModItem(StructureLib.ID, "item.structurelib.constructableTrigger", 1, 0, missing),
                "dyeBlue",
                "platePaper",
                "dyeBlue",
                "dyeWhite");

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                ItemList.Cover_SolarPanel_LV.get(1L),
                "---------",
                "---------",
                "---aba---",
                "---cdc---",
                "---efe---",
                "---cdc---",
                "---aba---",
                "---------",
                "---------",
                'a',
                "wireGt01SuperconductorMV",
                'b',
                CustomItemList.IrradiantReinforcedAluminiumPlate.get(1L),
                'c',
                ItemList.Circuit_Silicon_Wafer2.get(1L),
                'd',
                "platePolytetrafluoroethylene",
                'e',
                "circuitAdvanced",
                'f',
                ItemList.Cover_SolarPanel_8V.get(1L));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                ItemList.Cover_SolarPanel_MV.get(1L),
                "---------",
                "----a----",
                "---bcb---",
                "---ded---",
                "---fgf---",
                "---ded---",
                "---bcb---",
                "----a----",
                "---------",
                'a',
                ItemList.Circuit_Chip_ULPIC.get(1L),
                'b',
                "wireGt01SuperconductorHV",
                'c',
                CustomItemList.IrradiantReinforcedTitaniumPlate.get(1L),
                'd',
                ItemList.Circuit_Silicon_Wafer2.get(1L),
                'e',
                "plateEpoxid",
                'f',
                "circuitData",
                'g',
                ItemList.Cover_SolarPanel_LV.get(1L));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                ItemList.Cover_SolarPanel_HV.get(1L),
                "---------",
                "----a----",
                "---bcb---",
                "---ded---",
                "--ffgff--",
                "---ded---",
                "---bcb---",
                "----a----",
                "---------",
                'a',
                ItemList.Circuit_Chip_LPIC.get(1L),
                'b',
                "wireGt01SuperconductorEV",
                'c',
                CustomItemList.IrradiantReinforcedTungstenPlate.get(1L),
                'd',
                ItemList.Circuit_Silicon_Wafer2.get(1L),
                'e',
                "plateIndiumGalliumPhosphide",
                'f',
                "circuitElite",
                'g',
                ItemList.Cover_SolarPanel_MV.get(1L));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                ItemList.Cover_SolarPanel_EV.get(1L),
                "---------",
                "----a----",
                "--bcdcb--",
                "---efe---",
                "-bgghggb-",
                "---efe---",
                "--bcdcb--",
                "----a----",
                "---------",
                'a',
                ItemList.Circuit_Chip_PIC.get(1L),
                'b',
                "wireGt01SuperconductorIV",
                'c',
                "plateTripleSiliconSolarGrade",
                'd',
                CustomItemList.IrradiantReinforcedTungstenSteelPlate.get(1L),
                'e',
                ItemList.Circuit_Silicon_Wafer3.get(1L),
                'f',
                "platePolybenzimidazole",
                'g',
                "circuitMaster",
                'h',
                ItemList.Cover_SolarPanel_HV.get(1L));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                ItemList.Cover_SolarPanel_IV.get(1L),
                "---------",
                "----a----",
                "--bcdcb--",
                "--efgfe--",
                "-bhhihhb-",
                "--efgfe--",
                "--bcdcb--",
                "----a----",
                "---------",
                'a',
                ItemList.Circuit_Chip_HPIC.get(1L),
                'b',
                "wireGt01SuperconductorLuV",
                'c',
                ItemList.Circuit_Silicon_Wafer2.get(1L),
                'd',
                CustomItemList.IrradiantReinforcedChromePlate.get(1L),
                'e',
                "plateQuadrupleSiliconSolarGrade",
                'f',
                ItemList.Circuit_Silicon_Wafer3.get(1L),
                'g',
                "plateDoublePolybenzimidazole",
                'h',
                "circuitUltimate",
                'i',
                ItemList.Cover_SolarPanel_EV.get(1L));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                ItemList.Cover_SolarPanel_LuV.get(1L),
                "----a----",
                "---bcb---",
                "--bdedb--",
                "--fghgf--",
                "-icjkjci-",
                "--fghgf--",
                "--bdedb--",
                "---bcb---",
                "----a----",
                'a',
                ItemList.Circuit_Chip_UHPIC.get(1L),
                'b',
                "wireGt02SuperconductorZPM",
                'c',
                "circuitUltimate",
                'd',
                ItemList.Circuit_Silicon_Wafer3.get(1L),
                'e',
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 8, missing),
                'f',
                "plateQuintupleSiliconSolarGrade",
                'g',
                ItemList.Circuit_Silicon_Wafer4.get(1L),
                'h',
                GT_OreDictUnificator.get(OrePrefixes.plateTriple, Materials.Polybenzimidazole, 1L),
                'i',
                getModItem(SuperSolarPanels.ID, "solarsplitter", 1, 0, missing),
                'j',
                "circuitSuperconductor",
                'k',
                ItemList.Cover_SolarPanel_IV.get(1L));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                ItemList.Cover_SolarPanel_ZPM.get(1L),
                "---aba---",
                "--cadac--",
                "--aefea--",
                "--ghihg--",
                "-fjklkjf-",
                "--ghihg--",
                "--aefea--",
                "--cadac--",
                "---aba---",
                'a',
                "wireGt02SuperconductorUV",
                'b',
                ItemList.Circuit_Wafer_SoC2.get(1L),
                'c',
                ItemList.Circuit_Chip_NPIC.get(1L),
                'd',
                ItemList.Circuit_Wafer_QPIC.get(1L),
                'e',
                ItemList.Circuit_Silicon_Wafer4.get(1L),
                'f',
                CustomItemList.IrradiantReinforcedNaquadriaPlate.get(1L),
                'g',
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                'h',
                ItemList.Circuit_Silicon_Wafer5.get(1L),
                'i',
                GT_OreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Polybenzimidazole, 1L),
                'j',
                "circuitSuperconductor",
                'k',
                "circuitInfinite",
                'l',
                ItemList.Cover_SolarPanel_LuV.get(1L));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                ItemList.Cover_SolarPanel_UV.get(1L),
                "--abcba--",
                "-daefead-",
                "-agbhbga-",
                "-aibjbia-",
                "ahklmlkha",
                "-aibjbia-",
                "-agbhbga-",
                "-daefead-",
                "--abcba--",
                'a',
                "wireGt02Superconductor",
                'b',
                "plateDenseSiliconSolarGrade",
                'c',
                ItemList.Circuit_Chip_CrystalSoC2.get(1L),
                'd',
                ItemList.Circuit_Chip_PPIC.get(1L),
                'e',
                ItemList.Circuit_Silicon_Wafer5.get(1L),
                'f',
                CustomItemList.RawPicoWafer.get(1L),
                'g',
                CustomItemList.PicoWafer.get(1L),
                'h',
                CustomItemList.IrradiantReinforcedNeutroniumPlate.get(1L),
                'i',
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                'j',
                GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Polybenzimidazole, 1L),
                'k',
                "circuitInfinite",
                'l',
                "circuitBio",
                'm',
                ItemList.Cover_SolarPanel_ZPM.get(1L));

        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RawRubber, 2L)).duration(15 * SECONDS)
                .eut(2).addTo(extractorRecipes);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Empty.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                null,
                false,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Plate.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPlate", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Casing.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormCasing", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Gear.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormGear", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Credit.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormCoinage", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Bottle.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBottle", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Ingot.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormIngot", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Ball.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBall", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Block.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBlock", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Nugget.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormNuggets", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Bun.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBuns", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Bread.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBread", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Baguette.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBaguette", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Cylinder.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormCylinder", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Anvil.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormAnvil", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Name.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormName", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Arrow.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormArrowHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Gear_Small.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormSmallGear", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Rod.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormStick", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Bolt.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormBolt", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Round.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormRound", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Screw.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormScrew", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Ring.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormRing", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Rod_Long.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormStickLong", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Turbine_Blade.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormTurbineBlade", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Rotor.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormRotor", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Pipe_Tiny.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeTiny", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Pipe_Small.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeSmall", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Pipe_Medium.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeMedium", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Pipe_Large.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeLarge", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_Pipe_Huge.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormPipeHuge", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Mold_ToolHeadDrill.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.MoldFormDrillHead", 1, 0, missing),
                true,
                100);

        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Plate.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapePlate", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Rod.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeRod", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Bolt.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeBolt", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Cell.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeCell", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Ring.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeRing", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Ingot.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeIngot", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Wire.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeWire", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Casing.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeCasing", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Pipe_Tiny.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeTinyPipe", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Pipe_Small.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeSmallPipe", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Pipe_Medium.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeNormalPipe", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Pipe_Large.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeLargePipe", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Pipe_Huge.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeHugePipe", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Block.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeBlock", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Sword.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeSwordBlade", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Pickaxe.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapePickaxeHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Shovel.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeShovelHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Axe.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeAxeHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Hoe.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeHoeHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Hammer.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeHammerHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_File.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeFileHead", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Saw.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeSawBlade", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Gear.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeGear", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Bottle.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeBottle", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Rotor.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeRotor", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Turbine_Blade.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeTurbineBlade", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_Small_Gear.get(1L),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeSmallGear", 1, 0, missing),
                true,
                100);
        TConstructRegistry.getTableCasting().addCastingRecipe(
                ItemList.Shape_Extruder_ToolHeadDrill.get(1),
                FluidRegistry.getFluidStack("steel.molten", 576),
                getModItem(NewHorizonsCoreMod.ID, "item.ShapeDrillHead", 1, 0, missing),
                true,
                100);

        GT_ModHandler.addSmeltingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatCooked, 1L));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 3, missing),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Tin, 2L))
                .itemOutputs(ItemList.Transformer_MV_LV.get(1L)).duration(15 * SECONDS).eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 4, missing),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Copper, 2L))
                .itemOutputs(ItemList.Transformer_HV_MV.get(1L)).duration(12 * SECONDS + 10 * TICKS).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 5, missing),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.Gold, 2L))
                .itemOutputs(ItemList.Transformer_EV_HV.get(1L)).duration(10 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 6, missing),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt02, Materials.Aluminium, 2L))
                .itemOutputs(ItemList.Transformer_IV_EV.get(1L)).duration(5 * SECONDS).eut(1920)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plateDense, Materials.Iron, 6L),
                        getModItem(IndustrialCraft2.ID, "itemPlutonium", 3, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemRTGPellet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).duration(1 * MINUTES).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Tin, 9L),
                        GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Copper, 27L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4L)).duration(10 * SECONDS)
                .eut(16).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Tin, 9L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 3L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4L)).duration(10 * SECONDS)
                .eut(16).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Tin, 9L),
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 3L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4L)).duration(10 * SECONDS)
                .eut(16).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Copper, 27L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4L)).duration(10 * SECONDS)
                .eut(16).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Copper, 27L),
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4L)).duration(10 * SECONDS)
                .eut(16).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Copper, 27L),
                        GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.Tin, 9L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, 4L)).duration(10 * SECONDS)
                .eut(16).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(ThaumicBases.ID, "resource", 9, 0, missing), ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(ThaumicBases.ID, "resource", 1, 1, missing)).duration(10 * SECONDS).eut(16)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(ThaumicBases.ID, "resource", 1, 1, missing), ItemList.Shape_Mold_Nugget.get(0L))
                .itemOutputs(getModItem(ThaumicBases.ID, "resource", 9, 0, missing)).duration(10 * SECONDS).eut(16)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L),
                        ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0, missing)).duration(10 * SECONDS).eut(16)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Glass, 4L),
                        ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0, missing)).duration(10 * SECONDS).eut(16)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Glass, 9L),
                        ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0, missing)).duration(10 * SECONDS).eut(16)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedAir, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 0, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).duration(1 * MINUTES + 40 * SECONDS).eut(30)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedAir, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 0, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(30).addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedAir, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).duration(50 * SECONDS).eut(30)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedFire, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).duration(1 * MINUTES + 40 * SECONDS).eut(30)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedFire, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(30).addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedFire, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).duration(50 * SECONDS).eut(30)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedWater, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).duration(1 * MINUTES + 40 * SECONDS).eut(30)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedWater, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(30).addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedWater, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).duration(50 * SECONDS).eut(30)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedEarth, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).duration(1 * MINUTES + 40 * SECONDS).eut(30)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedEarth, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(30).addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedEarth, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).duration(50 * SECONDS).eut(30)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedOrder, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 4, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).duration(1 * MINUTES + 40 * SECONDS).eut(30)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedOrder, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 4, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(30).addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedOrder, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 4, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).duration(50 * SECONDS).eut(30)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedEntropy, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 5, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).duration(1 * MINUTES + 40 * SECONDS).eut(30)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedEntropy, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 5, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(30).addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedEntropy, 1L))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 5, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).duration(50 * SECONDS).eut(30)
                .addTo(autoclaveRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(CustomItemList.PotassiumHydroxideDust.get(3L), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Saltpeter, 5L))
                .fluidInputs(FluidRegistry.getFluidStack("nitricacid", 5000))
                .fluidOutputs(FluidRegistry.getFluidStack("steam", 16000)).duration(10).eut(30)
                .addTo(UniversalChemical);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 1, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "toolRod", 1, 11, missing))
                .duration(30 * SECONDS + 6 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 2, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "pickaxeHead", 1, 11, missing))
                .duration(1 * MINUTES + 13 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 3, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "shovelHead", 1, 11, missing))
                .duration(1 * MINUTES + 13 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 4, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "hatchetHead", 1, 11, missing))
                .duration(1 * MINUTES + 13 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 5, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "swordBlade", 1, 11, missing))
                .duration(1 * MINUTES + 13 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 6, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "wideGuard", 1, 11, missing))
                .duration(30 * SECONDS + 6 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 7, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "handGuard", 1, 11, missing))
                .duration(30 * SECONDS + 6 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 8, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "crossbar", 1, 11, missing))
                .duration(30 * SECONDS + 6 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 9, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "binding", 1, 11, missing))
                .duration(30 * SECONDS + 6 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 10, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "frypanHead", 1, 11, missing))
                .duration(1 * MINUTES + 13 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 11, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "signHead", 1, 11, missing))
                .duration(1 * MINUTES + 13 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 12, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "knifeBlade", 1, 11, missing))
                .duration(30 * SECONDS + 6 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 13, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "chiselHead", 1, 11, missing))
                .duration(30 * SECONDS + 6 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 3L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 14, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "toughRod", 1, 11, missing))
                .duration(3 * MINUTES + 1 * SECONDS + 19 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 3L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 15, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "toughBinding", 1, 11, missing))
                .duration(3 * MINUTES + 1 * SECONDS + 19 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 8L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 16, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "heavyPlate", 1, 11, missing))
                .duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 8L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 17, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "broadAxeHead", 1, 11, missing))
                .duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 8L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 18, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "scytheBlade", 1, 11, missing))
                .duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 8L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 19, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "excavatorHead", 1, 11, missing))
                .duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 8L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 20, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "largeSwordBlade", 1, 11, missing))
                .duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 8L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 21, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "hammerHead", 1, 11, missing))
                .duration(8 * MINUTES + 5 * SECONDS + 4 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 3L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 22, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "fullGuard", 1, 11, missing))
                .duration(3 * MINUTES + 1 * SECONDS + 19 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 25, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "arrowhead", 1, 11, missing))
                .duration(1 * MINUTES + 13 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 1L),
                        getModItem(TinkerConstruct.ID, "Cast", 0, 0, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "ShurikenPart", 1, 11, missing))
                .duration(30 * SECONDS + 6 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 4L),
                        getModItem(TinkerConstruct.ID, "Cast", 0, 1, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1, 11, missing))
                .duration(4 * MINUTES + 2 * SECONDS + 12 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 5L),
                        getModItem(TinkerConstruct.ID, "Cast", 0, 2, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1, 11, missing))
                .duration(5 * MINUTES + 3 * SECONDS + 5 * TICKS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 2L),
                        getModItem(TinkerConstruct.ID, "Cast", 0, 3, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "BowLimbPart", 1, 11, missing))
                .duration(1 * MINUTES + 31 * SECONDS).eut(120).addTo(extruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 1, 18, missing),
                        ItemList.Shape_Extruder_Plate.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L)).duration(20).eut(64)
                .addTo(extruderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Plastic, 2L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Plastic, 1L)).duration(20)
                .eut(16).addTo(hammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Rubber, 2L))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22880, missing)).duration(20).eut(16)
                .addTo(hammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Apatite, 2L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Apatite, 1L)).duration(20)
                .eut(16).addTo(hammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Lapis, 2L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Lapis, 1L)).duration(20).eut(16)
                .addTo(hammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Lazurite, 2L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Lazurite, 1L)).duration(20)
                .eut(16).addTo(hammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Sodalite, 2L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Sodalite, 1L)).duration(20)
                .eut(16).addTo(hammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EnderPearl, 2L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.EnderPearl, 1L)).duration(20)
                .eut(16).addTo(hammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.EnderEye, 2L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.EnderEye, 1L)).duration(20)
                .eut(16).addTo(hammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "flint", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Flint, 2L))
                .duration(1 * SECONDS + 12 * TICKS).eut(16).addTo(hammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Glass, 1L)).duration(10).eut(16)
                .addTo(hammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.gemChipped, Materials.Glass, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Glass, 1L)).duration(10).eut(16)
                .addTo(hammerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                        ItemList.Shape_Mold_Credit.get(0L))
                .itemOutputs(CustomItemList.CoinBlank.get(1L)).duration(10 * SECONDS).eut(30)
                .addTo(formingPressRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "barleyFood", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "barleyItem", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "plants", 1, 6, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "ryeItem", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "oatsItem", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockTaint", 1, 2, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 9L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "walleyerawItem", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L)).outputChances(10000)
                .duration(20 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Glass, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "glass_shard", 2, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ore, Materials.CassiteriteSand, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.CassiteriteSand, 4L))
                .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_ModHandler.addSmeltingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ore, Materials.Magnetite, 1L),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.oreNetherrack, Materials.Magnetite, 1L),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.oreEndstone, Materials.Magnetite, 1L),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.oreBlackgranite, Materials.Magnetite, 1L),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.oreRedgranite, Materials.Magnetite, 1L),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing));
    }
}
