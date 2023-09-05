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
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAutoclaveRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sExtractorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sExtruderRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sHammerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sPressRecipes;
import static gregtech.api.util.GT_RecipeConstants.UniversalChemical;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

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
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                null,
                "craftingToolFile",
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                "craftingToolHardHammer",
                null,
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.toolHeadPickaxe, Materials.Diamond, 1L),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
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
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                "craftingToolHardHammer",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.toolHeadAxe, Materials.Diamond, 1L),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                "gemDiamond",
                "craftingToolHardHammer",
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                null,
                null,
                "craftingToolFile",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.toolHeadHoe, Materials.Diamond, 1L),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                "gemDiamond",
                "craftingToolHardHammer",
                "craftingToolFile",
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 28809, missing),
                "craftingToolKnife",
                null,
                null,
                null,
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                null);
        addShapelessRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 2890, missing),
                "craftingToolMortar",
                getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing));
        addShapelessRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 1890, missing),
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
                getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing),
                "craftingToolMortar",
                "logWood");
        addShapelessRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 1625, missing),
                "craftingToolMortar",
                getModItem(Minecraft.ID, "brick", 1, 0, missing));
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22874, missing),
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
                getModItem(GregTech.ID, "gt.blockores", 1, 1817, missing),
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Salt, 1L),
                getModItem(GregTech.ID, "gt.blockores", 1, 2817, missing),
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Salt, 1L),
                getModItem(GregTech.ID, "gt.blockores", 1, 3817, missing),
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Salt, 1L),
                getModItem(GregTech.ID, "gt.blockores", 1, 4817, missing),
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapelessRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 1805, missing),
                "craftingToolMortar",
                getModItem(Minecraft.ID, "clay_ball", 1, 0, missing));
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32, missing),
                "nuggetIron",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 86, missing),
                "nuggetGold",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 35, missing),
                "nuggetCopper",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 57, missing),
                "nuggetTin",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 54, missing),
                "nuggetSilver",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 89, missing),
                "nuggetLead",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 36, missing),
                "nuggetZinc",
                null,
                null,
                "craftingToolMortar",
                null,
                null);
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 34, missing),
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
                getModItem(GregTech.ID, "gt.blockmachines", 1, 2000, missing),
                getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 1, 0, missing));
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22880, missing),
                "stickRubber",
                "craftingToolHardHammer",
                "stickRubber");
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22530, missing),
                "stickApatite",
                "craftingToolHardHammer",
                "stickApatite");
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22526, missing),
                "stickLapis",
                "craftingToolHardHammer",
                "stickLapis");
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22524, missing),
                "stickLazurite",
                "craftingToolHardHammer",
                "stickLazurite");
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22525, missing),
                "stickSodalite",
                "craftingToolHardHammer",
                "stickSodalite");
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22532, missing),
                "stickEnderPearl",
                "craftingToolHardHammer",
                "stickEnderPearl");
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 22533, missing),
                "stickEnderEye",
                "craftingToolHardHammer",
                "stickEnderEye");
        addShapelessRecipe(
                getModItem(GregTech.ID, "gt.blockmachines", 2, 4905, missing),
                getModItem(MCFrames.ID, "mcframes.frame", 1, 0, missing));
        addShapelessRecipe(
                getModItem(GregTech.ID, "gt.blockmachines", 1, 4905, missing),
                getModItem(OpenBlocks.ID, "scaffolding", 1, 0, missing));
        addShapelessRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 1890, missing),
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
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 20849, missing),
                "stoneGraniteBlack",
                null,
                null,
                null,
                "craftingToolFile",
                null);
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 20850, missing),
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
                getModItem(NewHorizonsCoreMod.ID, "item.IrradiantReinforcedAluminiumPlate", 1, 0, missing),
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
                getModItem(NewHorizonsCoreMod.ID, "item.IrradiantReinforcedTitaniumPlate", 1, 0, missing),
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
                getModItem(NewHorizonsCoreMod.ID, "item.IrradiantReinforcedTungstenPlate", 1, 0, missing),
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
                getModItem(NewHorizonsCoreMod.ID, "item.IrradiantReinforcedTungstenSteelPlate", 1, 0, missing),
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
                getModItem(NewHorizonsCoreMod.ID, "item.IrradiantReinforcedChromePlate", 1, 0, missing),
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
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 19599, missing),
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
                getModItem(NewHorizonsCoreMod.ID, "item.IrradiantReinforcedNaquadriaPlate", 1, 0, missing),
                'g',
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                'h',
                ItemList.Circuit_Silicon_Wafer5.get(1L),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 20599, missing),
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
                getModItem(NewHorizonsCoreMod.ID, "item.RawPicoWafer", 1, 0, missing),
                'g',
                getModItem(NewHorizonsCoreMod.ID, "item.PicoWafer", 1, 0, missing),
                'h',
                getModItem(NewHorizonsCoreMod.ID, "item.IrradiantReinforcedNeutroniumPlate", 1, 0, missing),
                'i',
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                'j',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 22599, missing),
                'k',
                "circuitInfinite",
                'l',
                "circuitBio",
                'm',
                ItemList.Cover_SolarPanel_ZPM.get(1L));

        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "strangeFood", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 2896, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);
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

        GT_ModHandler.addSmeltingRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatCooked, 1L));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1246, missing))
                .itemOutputs(ItemList.Transformer_MV_LV.get(1L)).noFluidInputs().noFluidOutputs().duration(300).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1366, missing))
                .itemOutputs(ItemList.Transformer_HV_MV.get(1L)).noFluidInputs().noFluidOutputs().duration(250).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1426, missing))
                .itemOutputs(ItemList.Transformer_EV_HV.get(1L)).noFluidInputs().noFluidOutputs().duration(200).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1587, missing))
                .itemOutputs(ItemList.Transformer_IV_EV.get(1L)).noFluidInputs().noFluidOutputs().duration(100)
                .eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 22032, missing),
                        getModItem(IndustrialCraft2.ID, "itemPlutonium", 3, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemRTGPellet", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2coolant", 1000)).noFluidOutputs().duration(1200).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 9, 9057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 27, 9035, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 9, 9057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 2035, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 9, 9057, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 11035, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 27, 9035, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2057, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 27, 9035, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11057, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 27, 9035, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 9, 9057, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 4, 11300, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(ThaumicBases.ID, "resource", 9, 0, missing), ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(ThaumicBases.ID, "resource", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(ThaumicBases.ID, "resource", 1, 1, missing), ItemList.Shape_Mold_Nugget.get(0L))
                .itemOutputs(getModItem(ThaumicBases.ID, "resource", 9, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2890, missing),
                        ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 1890, missing),
                        ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 9, 890, missing),
                        ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2540, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 0, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2540, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 0, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2540, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2541, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2541, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2541, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2543, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2543, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2543, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2542, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2542, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2542, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2545, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 4, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2545, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 4, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2545, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 4, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2544, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 5, missing)).outputChances(8000)
                .fluidInputs(FluidRegistry.getFluidStack("water", 200)).noFluidOutputs().duration(2000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2544, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 5, missing)).outputChances(9000)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 100)).noFluidOutputs().duration(1500)
                .eut(30).addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2544, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemShard", 1, 5, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.void", 36)).noFluidOutputs().duration(1000).eut(30)
                .addTo(sAutoclaveRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.PotassiumHydroxideDust", 3, 0, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 5, 2836, missing))
                .fluidInputs(FluidRegistry.getFluidStack("nitricacid", 5000))
                .fluidOutputs(FluidRegistry.getFluidStack("steam", 16000)).duration(10).eut(30)
                .addTo(UniversalChemical);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 1, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "toolRod", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 2, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "pickaxeHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 3, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "shovelHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 4, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "hatchetHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 5, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "swordBlade", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 6, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "wideGuard", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 7, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "handGuard", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 8, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "crossbar", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 9, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "binding", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 10, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "frypanHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 11, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "signHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 12, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "knifeBlade", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 13, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "chiselHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 14, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "toughRod", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(3639).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 15, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "toughBinding", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(3639).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 16, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "heavyPlate", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 17, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "broadAxeHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 18, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "scytheBlade", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 19, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "excavatorHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 20, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "largeSwordBlade", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 21, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "hammerHead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(9704).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 22, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "fullGuard", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(3639).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "metalPattern", 0, 25, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "arrowhead", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1213).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 11382, missing),
                        getModItem(TinkerConstruct.ID, "Cast", 0, 0, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "ShurikenPart", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(606).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 11382, missing),
                        getModItem(TinkerConstruct.ID, "Cast", 0, 1, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "CrossbowLimbPart", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(4852).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 5, 11382, missing),
                        getModItem(TinkerConstruct.ID, "Cast", 0, 2, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "CrossbowBodyPart", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(6065).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 11382, missing),
                        getModItem(TinkerConstruct.ID, "Cast", 0, 3, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "BowLimbPart", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(1820).eut(120).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "materials", 1, 18, missing),
                        ItemList.Shape_Extruder_Plate.get(0L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(64).addTo(sExtruderRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 23874, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22874, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 23880, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22880, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 23530, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22530, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 23526, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22526, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 23524, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22524, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 23525, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22525, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 23532, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22532, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 23533, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 22533, missing)).noFluidInputs()
                .noFluidOutputs().duration(20).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "flint", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 802, missing)).noFluidInputs()
                .noFluidOutputs().duration(32).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 8890, missing)).noFluidInputs()
                .noFluidOutputs().duration(10).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 27890, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 1890, missing)).noFluidInputs()
                .noFluidOutputs().duration(10).eut(16).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17086, missing),
                        ItemList.Shape_Mold_Credit.get(0L))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "barleyFood", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "barleyItem", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "plants", 1, 6, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "ryeItem", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "oatsItem", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockTaint", 1, 2, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 9, 2892, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "walleyerawItem", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(400).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2890, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 1890, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "glass_shard", 2, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2890, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.blockores", 1, 937, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 4, 5937, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_ModHandler.addSmeltingRecipe(
                getModItem(GregTech.ID, "gt.blockores", 1, 870, missing),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem(GregTech.ID, "gt.blockores", 1, 1870, missing),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem(GregTech.ID, "gt.blockores", 1, 2870, missing),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem(GregTech.ID, "gt.blockores", 1, 3870, missing),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem(GregTech.ID, "gt.blockores", 1, 4870, missing),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing));
    }
}
