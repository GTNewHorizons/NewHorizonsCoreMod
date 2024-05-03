package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Botany;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.BuildCraftSilicon;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.Gendustry;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.ProjectRedExploration;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.blastFurnaceRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
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
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ScriptStevesCarts implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Steves Carts";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                StevesCarts2.ID,
                ProjectRedExploration.ID,
                Backpack.ID,
                BiomesOPlenty.ID,
                Botany.ID,
                BuildCraftFactory.ID,
                BuildCraftSilicon.ID,
                EnderIO.ID,
                ExtraBees.ID,
                ExtraUtilities.ID,
                Forestry.ID,
                Gendustry.ID,
                IndustrialCraft2.ID,
                IronTanks.ID,
                Natura.ID,
                OpenBlocks.ID,
                ProjectRedIntegration.ID,
                Railcraft.ID,
                Thaumcraft.ID,
                TinkerConstruct.ID,
                TwilightForest.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockCartAssembler", 1, 0, missing),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                ItemList.Robot_Arm_LV.get(1L),
                ItemList.Conveyor_Module_LV.get(1L),
                ItemList.Hull_LV.get(1L),
                ItemList.Conveyor_Module_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockCargoManager", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                ItemList.Conveyor_Module_LV.get(1L),
                ItemList.Hull_LV.get(1L),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing),
                ItemList.Cover_ActivityDetector.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDistributor", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                ItemList.Conveyor_Module_LV.get(1L),
                ItemList.Hull_LV.get(1L),
                ItemList.Conveyor_Module_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 1, missing),
                "screwSteel",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "screwSteel",
                ItemList.Cover_ActivityDetector.get(1L),
                ItemList.Casing_LV.get(1L),
                ItemList.Cover_ActivityDetector.get(1L),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 1, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing),
                "wireGt01RedAlloy",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 2, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 1, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing),
                "wireGt01RedAlloy",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 3, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 1, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing),
                "wireGt01RedAlloy",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 4, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                "plateRedstoneAlloy",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 1, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing),
                "wireGt01RedAlloy",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockActivator", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 13, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                "wireGt01RedAlloy",
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 1, missing),
                "wireGt01RedAlloy",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 0, missing),
                null,
                "craftingToolSoftHammer",
                null,
                "ringWood",
                "stickWood",
                "ringWood",
                null,
                "craftingToolWrench",
                null);
        addShapelessRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 1, missing),
                ItemList.Component_Minecart_Wheels_Iron.get(1L));
        addShapelessRecipe(
                ItemList.Component_Minecart_Wheels_Iron.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 1, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 23, missing),
                null,
                "craftingToolHardHammer",
                null,
                "ringReinforced",
                "stickReinforced",
                "ringReinforced",
                null,
                "craftingToolWrench",
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 82, missing),
                null,
                "craftingToolHardHammer",
                null,
                "ringGalgadorian",
                "stickGalgadorian",
                "ringGalgadorian",
                null,
                "craftingToolWrench",
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 37, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "craftingToolSoftHammer",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 0, missing),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 0, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 38, missing),
                "plateIron",
                "craftingToolHardHammer",
                "plateIron",
                "plateIron",
                "plateIron",
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 1, missing),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 1, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 39, missing),
                "plateReinforced",
                "craftingToolHardHammer",
                "plateReinforced",
                "plateReinforced",
                "plateReinforced",
                "plateReinforced",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 23, missing),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 23, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 81, missing),
                "plateGalgadorian",
                "craftingToolHardHammer",
                "plateGalgadorian",
                "plateGalgadorian",
                "plateGalgadorian",
                "plateGalgadorian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 82, missing),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 82, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 42, missing),
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "screwIron",
                "craftingToolScrewdriver",
                "blockIron",
                "stickIron",
                "toolHeadDrillIron",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "screwIron",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 8, missing),
                CustomItemList.SteelBars.get(1L),
                "screwSteel",
                "craftingToolScrewdriver",
                "blockSteel",
                getModItem(StevesCarts2.ID, "CartModule", 1, 42, missing),
                getModItem(NewHorizonsCoreMod.ID, "item.DiamondDrillTip", 1, 0, missing),
                CustomItemList.SteelBars.get(1L),
                "screwSteel",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 43, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 20, missing),
                "screwStainlessSteel",
                "craftingToolScrewdriver",
                "blockDiamond",
                getModItem(StevesCarts2.ID, "CartModule", 1, 8, missing),
                "toolHeadDrillReinforced",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 20, missing),
                "screwStainlessSteel",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 9, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 20, missing),
                "screwTitanium",
                "craftingToolScrewdriver",
                "blockIridium",
                getModItem(StevesCarts2.ID, "CartModule", 1, 43, missing),
                "toolHeadDrillGalgadorian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 20, missing),
                "screwTitanium",
                "craftingToolHardHammer");
        addShapelessRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15, missing),
                ItemList.Component_Sawblade_Diamond.get(1L));
        addShapelessRecipe(
                ItemList.Component_Sawblade_Diamond.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80, missing),
                null,
                "dustSmallReinforced",
                null,
                "dustSmallReinforced",
                "gearCobaltBrass",
                "dustSmallReinforced",
                null,
                "dustSmallReinforced",
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81, missing),
                null,
                "dustSmallGalgadorian",
                null,
                "dustSmallGalgadorian",
                "gearCobaltBrass",
                "dustSmallGalgadorian",
                null,
                "dustSmallGalgadorian",
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 44, missing),
                "itemCasingIron",
                "craftingFurnace",
                "itemCasingIron",
                "screwIron",
                ItemList.Electric_Motor_LV.get(1L),
                "screwIron",
                "craftingToolWrench",
                "craftingPiston",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 0, missing),
                "itemCasingSteel",
                "craftingIronFurnace",
                "itemCasingSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "screwSteel",
                ItemList.Electric_Motor_LV.get(1L),
                ItemList.Electric_Piston_LV.get(1L),
                "craftingToolScrewdriver",
                ItemList.Electric_Piston_LV.get(1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 45, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing),
                "screwSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "screwSteel",
                "craftingToolWrench",
                ItemList.Electric_Piston_LV.get(1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 1, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                ItemList.Electric_Motor_LV.get(1L),
                ItemList.Electric_Piston_LV.get(1L),
                "screwAluminium",
                ItemList.Electric_Piston_LV.get(1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 56, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 58, missing),
                getModItem(StevesCarts2.ID, "CartModule", 1, 1, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 58, missing),
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                ItemList.Electric_Motor_MV.get(1L),
                ItemList.Electric_Piston_MV.get(1L),
                "screwStainlessSteel",
                ItemList.Electric_Piston_MV.get(1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 69, missing),
                "itemCasingSteel",
                "craftingIronFurnace",
                "itemCasingSteel",
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(IronTanks.ID, "obsidianTank", 1, 0, missing),
                ItemList.Electric_Motor_LV.get(1L),
                ItemList.Electric_Piston_LV.get(1L),
                getModItem(Railcraft.ID, "machine.beta", 1, 3, missing),
                ItemList.Electric_Piston_LV.get(1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 70, missing),
                "plateReinforced",
                getModItem(StevesCarts2.ID, "CartModule", 1, 69, missing),
                "plateReinforced",
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(IronTanks.ID, "ironTank", 1, 0, missing),
                ItemList.Electric_Motor_MV.get(1L),
                ItemList.Electric_Piston_MV.get(1L),
                getModItem(Railcraft.ID, "machine.beta", 1, 4, missing),
                ItemList.Electric_Piston_MV.get(1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 2, 30, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                null,
                null,
                "craftingToolSaw",
                null,
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing),
                "craftingToolScrewdriver",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 30, missing),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 30, missing),
                "screwIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 30, missing),
                null,
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 30, missing),
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32, missing),
                "craftingToolScrewdriver",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing),
                "screwIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing),
                null,
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing),
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 2, 34, missing),
                "plateIron",
                null,
                null,
                "craftingToolSaw",
                null,
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing),
                "craftingToolScrewdriver",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 34, missing),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 34, missing),
                "screwSteel",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 34, missing),
                null,
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 34, missing),
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing),
                "craftingToolScrewdriver",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing),
                "screwSteel",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing),
                null,
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing),
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 14, missing),
                "stickDiamond",
                ItemList.Electric_Motor_LV.get(1L),
                "stickDiamond",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "stickDiamond",
                ItemList.Robot_Arm_LV.get(1L),
                "stickDiamond");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 84, missing),
                "stickGalgadorian",
                ItemList.Electric_Motor_MV.get(1L),
                "stickGalgadorian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                getModItem(StevesCarts2.ID, "CartModule", 1, 14, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                "stickGalgadorian",
                ItemList.Robot_Arm_MV.get(1L),
                "stickGalgadorian");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 15, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 79, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80, missing),
                getModItem(StevesCarts2.ID, "CartModule", 1, 15, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 80, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81, missing),
                getModItem(StevesCarts2.ID, "CartModule", 1, 79, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81, missing),
                "circuitAdvanced",
                ItemList.Electric_Motor_HV.get(1L),
                "circuitAdvanced");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 2, 61, missing),
                "paneGlassColorless",
                null,
                null,
                "craftingToolSaw",
                null,
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                "plateRedstone",
                "platePlastic",
                "plateRedstone",
                "platePlastic",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "platePlastic",
                "platePlastic",
                "platePlastic",
                "platePlastic");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockLiquidManager", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                ItemList.Conveyor_Module_LV.get(1L),
                ItemList.Hull_LV.get(1L),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(StevesCarts2.ID, "CartModule", 1, 66, missing),
                ItemList.Cover_ActivityDetector.get(1L),
                getModItem(StevesCarts2.ID, "CartModule", 1, 66, missing));
        addShapelessRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 24, missing),
                GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L));
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 24, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 7, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 29, missing),
                null,
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 29, missing),
                ItemList.Conveyor_Module_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                ItemList.Robot_Arm_LV.get(1L),
                "itemCasingIron",
                "itemCasingIron",
                "itemCasingIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 26, missing),
                "screwSteel",
                "dyeRed",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 12, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 12, missing),
                "dyeRed",
                "plateRedstone",
                "plateIron",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 13, missing),
                "screwSteel",
                "dyeBlue",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 12, missing),
                "plateGold",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 12, missing),
                "dyeBlue",
                "plateRedstone",
                "plateGold",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 33, missing),
                null,
                "craftingToolScrewdriver",
                null,
                "screwIron",
                "ringIron",
                "screwIron",
                null,
                "boltIron",
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40, missing),
                CustomItemList.SteelBars.get(1L),
                "dustRedstone",
                CustomItemList.SteelBars.get(1L),
                "dustCoal",
                "rotorSteel",
                "dustCoal",
                CustomItemList.SteelBars.get(1L),
                "dustRedstone",
                CustomItemList.SteelBars.get(1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                "itemCasingSteel",
                "plateRedstone",
                "itemCasingSteel",
                "plateSteel",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                "plateSteel",
                "itemCasingSteel",
                "itemCasingSteel",
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 0, missing),
                "plateRedstone",
                "gemDiamond",
                "plateRedstone",
                "circuitBasic",
                createItemStack(GregTech.ID, "gt.metaitem.01", 1, 32518, "{GT.ItemCharge:100000L}", missing),
                "circuitBasic",
                "plateRedstone",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                "plateRedstone");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 1, missing),
                "gemFlawlessDiamond",
                "blockEmerald",
                "gemFlawlessDiamond",
                "circuitAdvanced",
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                "circuitAdvanced",
                "plateGlowstone",
                getModItem(StevesCarts2.ID, "upgrade", 1, 0, missing),
                "plateGlowstone");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 2, missing),
                "bookEmpty",
                getModItem(Minecraft.ID, "bookshelf", 1, 0, missing),
                "bookEmpty",
                getModItem(Minecraft.ID, "bookshelf", 1, 0, missing),
                getModItem(Minecraft.ID, "enchanting_table", 1, 0, missing),
                getModItem(Minecraft.ID, "bookshelf", 1, 0, missing),
                "plateReinforced",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                "plateReinforced");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 3, missing),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45, missing),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45, missing),
                "plateReinforced",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45, missing),
                "plateReinforced",
                getModItem(StevesCarts2.ID, "upgrade", 1, 2, missing),
                "plateReinforced");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 4, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                createItemStack(
                        Minecraft.ID,
                        "enchanted_book",
                        1,
                        0,
                        "{StoredEnchantments:[0:{lvl:3s,id:32s}]}",
                        missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "plateReinforced",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                "plateReinforced",
                "plateReinforced",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                "plateReinforced");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 5, missing),
                "plateGalgadorian",
                createItemStack(
                        Minecraft.ID,
                        "enchanted_book",
                        1,
                        0,
                        "{StoredEnchantments:[0:{lvl:5s,id:32s}]}",
                        missing),
                "plateGalgadorian",
                "plateGalgadorian",
                "circuitMaster",
                "plateGalgadorian",
                "plateGalgadorian",
                getModItem(StevesCarts2.ID, "upgrade", 1, 4, missing),
                "plateGalgadorian");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 6, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                CustomItemList.SteelBars.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                ItemList.Electric_Motor_LV.get(1L),
                "rotorSteel",
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 7, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                ItemList.Electric_Piston_LV.get(1L),
                "craftingIronFurnace",
                ItemList.Electric_Piston_LV.get(1L),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 8, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                "plateIron",
                ItemList.Electric_Piston_LV.get(1L),
                "chestWood",
                ItemList.Electric_Piston_LV.get(1L),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 9, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 6, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                "plateReinforced",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                "plateReinforced");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 10, missing),
                "plateIron",
                getModItem(Minecraft.ID, "rail", 1, 0, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                ItemList.Electric_Piston_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 11, missing),
                "plateIron",
                ItemList.Robot_Arm_LV.get(1L),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(Railcraft.ID, "anvil", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 12, missing),
                ItemList.Electric_Piston_LV.get(1L),
                ItemList.Robot_Arm_LV.get(1L),
                ItemList.Electric_Piston_LV.get(1L),
                ItemList.Conveyor_Module_LV.get(1L),
                "frameGtSteel",
                ItemList.Conveyor_Module_LV.get(1L),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 13, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 10, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 17, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 21, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 15, missing),
                "plateObsidian",
                "plateReinforced",
                "plateObsidian",
                "plateReinforced",
                "blockSteel",
                "plateReinforced",
                "plateObsidian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                "plateObsidian");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 16, missing),
                "gemFlawlessDiamond",
                "plateReinforced",
                "gemFlawlessDiamond",
                "plateGalgadorian",
                "blockLapis",
                "plateGalgadorian",
                "plateIron",
                getModItem(StevesCarts2.ID, "upgrade", 1, 15, missing),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 17, missing),
                "plateIron",
                "plateEnderEye",
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                getModItem(StevesCarts2.ID, "BlockDistributor", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 18, missing),
                getModItem(IronTanks.ID, "ironTank", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                getModItem(IronTanks.ID, "ironTank", 1, 0, missing),
                ItemList.Electric_Piston_LV.get(1L),
                getModItem(StevesCarts2.ID, "CartModule", 1, 69, missing),
                ItemList.Electric_Piston_LV.get(1L),
                "plateObsidian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                "plateObsidian");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 19, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing),
                ItemList.Electric_Piston_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                ItemList.Electric_Piston_LV.get(1L),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                ItemList.Electric_Motor_LV.get(1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 41, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing),
                "plateIron",
                "plateRedstone",
                "plateIron",
                "screwIron",
                "plateIron",
                "screwIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 41, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 64, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 30, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 41, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 71, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 64, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 25, missing),
                "plateSteel",
                "craftingToolHardHammer",
                "plateSteel",
                "plateRedstone",
                "plateGold",
                "plateRedstone",
                getModItem(Minecraft.ID, "dispenser", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(Minecraft.ID, "dispenser", 1, 0, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 29, missing),
                "screwSteel",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 26, missing),
                "screwSteel",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 25, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 24, missing),
                "plateSteel",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 27, missing),
                "plateSteel");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 33, missing),
                getModItem(Minecraft.ID, "glowstone", 1, 0, missing),
                "stoneNetherBrick",
                getModItem(Minecraft.ID, "glowstone", 1, 0, missing),
                getModItem(IronTanks.ID, "ironTank", 1, 0, missing),
                "craftingIronFurnace",
                getModItem(IronTanks.ID, "ironTank", 1, 0, missing),
                "bucketLava",
                "stoneNetherBrick",
                "bucketLava");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 34, missing),
                getModItem(Minecraft.ID, "glowstone", 1, 0, missing),
                "plateObsidian",
                getModItem(Minecraft.ID, "glowstone", 1, 0, missing),
                getModItem(StevesCarts2.ID, "CartModule", 1, 33, missing),
                getModItem(Railcraft.ID, "machine.beta", 1, 6, missing),
                getModItem(StevesCarts2.ID, "CartModule", 1, 33, missing),
                "bucketLava",
                "plateObsidian",
                "bucketLava");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 10, missing),
                "plateIron",
                "plateIron",
                "plateIron",
                ItemList.Conveyor_Module_LV.get(1L),
                getModItem(Minecraft.ID, "rail", 1, 0, missing),
                ItemList.Robot_Arm_LV.get(1L),
                "plateIron",
                "plateIron",
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 11, missing),
                "plateSteel",
                "plateSteel",
                "plateSteel",
                getModItem(StevesCarts2.ID, "CartModule", 1, 10, missing),
                getModItem(Minecraft.ID, "rail", 1, 0, missing),
                getModItem(StevesCarts2.ID, "CartModule", 1, 10, missing),
                "plateSteel",
                "plateSteel",
                "plateSteel");
        addShapelessRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6, missing),
                getModItem(IndustrialCraft2.ID, "itemDynamite", 1, 0, missing));
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "itemDynamite", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 31, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6, missing),
                getModItem(Minecraft.ID, "flint_and_steel", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 59, missing),
                "fenceWood",
                getModItem(Minecraft.ID, "dispenser", 1, 0, missing),
                "fenceWood",
                "chestWood",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 43, missing),
                "chestWood",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(Minecraft.ID, "flint_and_steel", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 14, missing),
                "stickIron",
                "ringIron",
                "stickIron",
                "ringIron",
                "craftingToolHardHammer",
                "ringIron",
                "stickIron",
                "ringIron",
                "stickIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 10, missing),
                "stickPlastic",
                "paneGlassColorless",
                "stickPlastic",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                CustomItemList.Display.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "stickPlastic",
                "paneGlassColorless",
                "stickPlastic");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 27, missing),
                "craftingToolHardHammer",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 10, missing),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 14, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 13, missing),
                "plateSteel",
                "plateSteel",
                "plateSteel");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 2, 60, missing),
                "screwIron",
                GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Bronze, 1L),
                "screwIron",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "screwIron",
                GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Bronze, 1L),
                "screwIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 57, missing),
                CustomItemList.SteelBars.get(1L),
                CustomItemList.SteelBars.get(1L),
                CustomItemList.SteelBars.get(1L),
                CustomItemList.SteelBars.get(1L),
                "craftingToolHardHammer",
                CustomItemList.SteelBars.get(1L),
                CustomItemList.SteelBars.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                CustomItemList.SteelBars.get(1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 12, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "plateRedstone",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(Minecraft.ID, "brick_block", 1, 0, missing),
                ItemList.Electric_Piston_LV.get(1L),
                getModItem(Minecraft.ID, "brick_block", 1, 0, missing),
                "plateIron",
                "blockHopper",
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 13, missing),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                ItemList.Robot_Arm_LV.get(1L),
                ItemList.Conveyor_Module_LV.get(1L),
                getModItem(Minecraft.ID, "rail", 1, 0, missing),
                ItemList.Conveyor_Module_LV.get(1L),
                "plateIron",
                "plateIron",
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 25, missing),
                "craftingToolScrewdriver",
                null,
                "plankWood",
                null,
                "screwIron",
                "plankWood",
                "slabWood",
                "slabWood",
                "screwIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 49, missing),
                "plateTitanium",
                "circuitData",
                "plateTitanium",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                getModItem(Railcraft.ID, "machine.alpha", 1, 2, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                "plateReinforced",
                "circuitData",
                "plateReinforced");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 85, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84, missing),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84, missing),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84, missing),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 68, missing),
                "plateIron",
                GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Brass, 1L),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(ExtraUtilities.ID, "trashcan", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "plateIron",
                GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Brass, 1L),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 32, missing),
                "plateDenseObsidian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 19, missing),
                "plateDenseObsidian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 19, missing),
                getModItem(StevesCarts2.ID, "BlockMetalStorage", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 19, missing),
                "plateDenseObsidian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 19, missing),
                "plateDenseObsidian");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 16, missing),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 95, missing),
                "plateEmerald",
                getModItem(OpenBlocks.ID, "xpdrain", 1, 0, missing),
                "plateEmerald",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(Minecraft.ID, "cauldron", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 18, missing),
                GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Tin, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Tin, 1L),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(Backpack.ID, "tannedLeather", 1, 0, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 19, missing),
                "plateIron",
                getModItem(Minecraft.ID, "compass", 1, 0, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                CustomItemList.Display.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 20, missing),
                "plateIron",
                "gemDiamond",
                "plateIron",
                "plateRedstone",
                ItemList.Cover_FluidDetector.get(1L),
                "plateRedstone",
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 40, missing),
                getModItem(Minecraft.ID, "noteblock", 1, 0, missing),
                "plateRedstone",
                getModItem(Minecraft.ID, "noteblock", 1, 0, missing),
                getModItem(Minecraft.ID, "noteblock", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(Minecraft.ID, "noteblock", 1, 0, missing),
                "plateIron",
                getModItem(Minecraft.ID, "jukebox", 1, 0, missing),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 75, missing),
                "plateIron",
                "plateGold",
                "plateIron",
                "plateGold",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                "plateGold",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                "plateRedstone",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 77, missing),
                "plateIron",
                ItemList.Electric_Piston_LV.get(1L),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                ItemList.Cover_EnergyDetector.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 78, missing),
                "plateIron",
                "plateRedstone",
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                CustomItemList.Display.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                getModItem(Minecraft.ID, "stone_button", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                getModItem(Minecraft.ID, "stone_button", 1, 0, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 82, missing),
                "plateIron",
                "plateEnhancedGalgadorian",
                "plateIron",
                getModItem(Minecraft.ID, "writable_book", 1, 0, missing),
                getModItem(EnderIO.ID, "blockEnchanter", 1, 0, missing),
                getModItem(Minecraft.ID, "writable_book", 1, 0, missing),
                "plateRedstone",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                "plateRedstone");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 83, missing),
                ItemList.Sensor_HV.get(1L),
                "plateRedstone",
                ItemList.Sensor_HV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45, missing),
                "plateGalgadorian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45, missing),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 86, missing),
                getModItem(Minecraft.ID, "hay_block", 1, 0, missing),
                ItemList.Electric_Pump_LV.get(1L),
                getModItem(Minecraft.ID, "hay_block", 1, 0, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 89, missing),
                ItemList.Sensor_MV.get(1L),
                "plateRedstone",
                ItemList.Sensor_MV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                "plateIron",
                "plateRedstone",
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing),
                "treeSapling",
                "treeSapling",
                "treeSapling",
                "treeSapling",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "treeSapling",
                "treeSapling",
                "treeSapling",
                "treeSapling");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 94, missing),
                "plateIron",
                getModItem(Minecraft.ID, "sign", 1, 0, missing),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                CustomItemList.Display.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "plateIron",
                "plateRedstone",
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 99, missing),
                null,
                getModItem(Minecraft.ID, "cake", 1, 0, missing),
                null,
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "slabWood",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                "plateIron",
                "plateIron",
                "plateIron");
        addShapelessRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 22, missing),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Reinforced, 1L));
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Reinforced, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 22, missing));
        addShapelessRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 47, missing),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Galgadorian, 1L));
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Galgadorian, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 47, missing));
        addShapelessRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 49, missing),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnhancedGalgadorian, 1L));
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.EnhancedGalgadorian, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 49, missing));

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 14, missing),
                "---------",
                "---------",
                "--abcba--",
                "--ddddd--",
                "--cdedc--",
                "--ddddd--",
                "--abcba--",
                "---------",
                "---------",
                'a',
                "plateDenseNaquadria",
                'b',
                "ingotInfinity",
                'c',
                getModItem(StevesCarts2.ID, "upgrade", 1, 5, missing),
                'd',
                "plateEnhancedGalgadorian",
                'e',
                ItemList.Generator_Naquadah_Mark_III.get(1L));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 61, missing),
                "---------",
                "---------",
                "--abcba--",
                "--ddddd--",
                "--edfde--",
                "--ddddd--",
                "--abcba--",
                "---------",
                "---------",
                'a',
                getModItem(Railcraft.ID, "firestone.refined", 1, 0, missing),
                'b',
                "ingotInfinity",
                'c',
                getModItem(StevesCarts2.ID, "upgrade", 1, 19, missing),
                'd',
                "plateEnhancedGalgadorian",
                'e',
                getModItem(StevesCarts2.ID, "upgrade", 1, 18, missing),
                'f',
                getModItem(IndustrialCraft2.ID, "blockReactorChamber", 1, 0, missing));

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "detector_rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "detector", 1, 9, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "BlockAdvDetector", 1, 0, missing)).duration(10 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.junction\"}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 4L))
                .itemOutputs(getModItem(StevesCarts2.ID, "BlockJunction", 1, 0, missing)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Wood, 2L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 0, missing)).duration(10 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Reinforced, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Reinforced, 2L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 23, missing)).duration(20 * SECONDS)
                .eut(4).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Galgadorian, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Galgadorian, 2L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 82, missing)).duration(20 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 4L),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 37, missing)).duration(20 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 1, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 38, missing)).duration(20 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Reinforced, 4L),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 23, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 39, missing)).duration(20 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Galgadorian, 4L),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 82, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 81, missing)).duration(20 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.SteelBars.get(5L),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 19, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 20, missing)).duration(10 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.CobaltBrass, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Reinforced, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80, missing))
                .duration(1 * MINUTES + 20 * SECONDS).eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.CobaltBrass, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galgadorian, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81, missing))
                .duration(1 * MINUTES + 20 * SECONDS).eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.toolHeadSaw, Materials.Iron, 2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 83, missing)).duration(15 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Iron, 1L),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 83, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84, missing)).duration(30 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Cover_SolarPanel.get(1L),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing)).duration(30 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 44, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 16, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 58, missing)).duration(1 * MINUTES)
                .eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30, missing),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing)).duration(4 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 31, missing),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32, missing)).duration(8 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34, missing),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing)).duration(8 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 35, missing),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing)).duration(16 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 38, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 39, missing)).duration(32 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Minecraft.ID, "sapling", 8, wildcard, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(BiomesOPlenty.ID, "saplings", 8, wildcard, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(BiomesOPlenty.ID, "colorizedSaplings", 8, wildcard, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Forestry.ID, "saplingGE", 8, wildcard, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(IndustrialCraft2.ID, "blockRubSapling", 8, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Natura.ID, "florasapling", 8, wildcard, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Natura.ID, "Rare Sapling", 8, wildcard, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Thaumcraft.ID, "blockCustomPlant", 8, wildcard, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(TwilightForest.ID, "tile.TFSapling", 8, wildcard, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 62, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 36)).duration(8 * SECONDS).eut(8)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 62, missing),
                        GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 63, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 72)).duration(16 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "porkchop", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 21, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "diamond", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 22, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "emerald", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 23, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "slime_ball", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 24, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "glass_bottle", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 51, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "fire_charge", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 52, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "egg", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 53, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "cake", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 90, missing)).duration(30 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "nether_wart", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 58, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 88, missing)).duration(30 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "torch", 3, 0, missing), GT_Utility.getIntegratedCircuit(3))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 29, missing)).duration(5 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.Iron, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 11, missing)).duration(5 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Iron, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 33, missing)).duration(5 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Minecraft.ID, "dye", 4, 1, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        ItemList.Color_01.get(4L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Gendustry.ID, "HoneyDrop", 4, 11, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 4, 14, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(ExtraBees.ID, "misc", 4, 19, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Botany.ID, "pigment", 4, 59, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Minecraft.ID, "dye", 4, 2, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(ExtraBees.ID, "misc", 4, 22, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 4, 13, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Gendustry.ID, "HoneyDrop", 4, 12, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        ItemList.Color_02.get(4L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(BiomesOPlenty.ID, "misc", 4, 7, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Botany.ID, "pigment", 4, 28, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Minecraft.ID, "dye", 4, 4, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Botany.ID, "pigment", 4, 24, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(ExtraBees.ID, "misc", 4, 21, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Natura.ID, "barleyFood", 4, 8, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 4, 11, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Gendustry.ID, "HoneyDrop", 4, 14, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        ItemList.Color_04.get(4L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(BiomesOPlenty.ID, "misc", 4, 5, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing)).duration(5 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "CartModule", 1, 41, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 101, missing)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Cover_Crafting.get(1L),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 9, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 87, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "CartModule", 1, 87, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 16, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 92, missing)).duration(15 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockMachine", 1, 1, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 9, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 91, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "CartModule", 1, 91, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 16, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 93, missing)).duration(15 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 25, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 8, 24, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 28, missing)).duration(20 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Tool_Scanner.get(1L), getModItem(StevesCarts2.ID, "CartModule", 1, 21, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 26, missing)).duration(20 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Tool_Scanner.get(1L), getModItem(StevesCarts2.ID, "CartModule", 1, 22, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 26, missing)).duration(20 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Tool_Scanner.get(1L), getModItem(StevesCarts2.ID, "CartModule", 1, 23, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 26, missing)).duration(20 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Tool_Scanner.get(1L), getModItem(StevesCarts2.ID, "CartModule", 1, 24, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 26, missing)).duration(20 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Sensor_MV.get(1L), getModItem(StevesCarts2.ID, "CartModule", 1, 21, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 27, missing)).duration(20 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Sensor_MV.get(1L), getModItem(StevesCarts2.ID, "CartModule", 1, 22, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 27, missing)).duration(20 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Sensor_MV.get(1L), getModItem(StevesCarts2.ID, "CartModule", 1, 23, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 27, missing)).duration(20 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Sensor_MV.get(1L), getModItem(StevesCarts2.ID, "CartModule", 1, 24, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 27, missing)).duration(20 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 43, missing))
                .duration(2 * SECONDS + 10 * TICKS).eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 7, 0, missing),
                        getModItem(Minecraft.ID, "fermented_spider_eye", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.thaumium", 288)).duration(10 * SECONDS).eut(256)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 5, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 36, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).duration(20 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Bronze, 1L),
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 2, 60, missing)).duration(20 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.SteelBars.get(5L),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 57, missing)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "CartModule", 1, 81, missing),
                        ItemList.Quantum_Chest_IV.get(1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 76, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.americium", 1440)).duration(30 * SECONDS).eut(30720)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 21, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 22, missing)).duration(50 * SECONDS)
                .eut(120).specialValue(1700).addTo(blastFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 46, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Galgadorian, 1L))
                .fluidInputs(FluidRegistry.getFluidStack("oxygen", 1000)).duration(1 * MINUTES + 40 * SECONDS).eut(120)
                .specialValue(2200).addTo(blastFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 48, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.EnhancedGalgadorian, 1L))
                .fluidInputs(FluidRegistry.getFluidStack("oxygen", 1000)).duration(2 * MINUTES + 30 * SECONDS).eut(120)
                .specialValue(3500).addTo(blastFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 11, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 12, missing)).duration(10 * SECONDS)
                .eut(120).specialValue(1000).addTo(blastFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "diamond", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 2, 18, missing))
                .fluidInputs(Materials.Obsidian.getMolten(1152)).duration(30 * SECONDS).eut(30)
                .addTo(UniversalChemical);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Wood, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Wood, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Wood, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(2 * SECONDS + 10 * TICKS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 6)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 4)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(2 * SECONDS + 10 * TICKS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 31, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 8)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 31, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 6)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 31, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(2 * SECONDS + 10 * TICKS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(ItemList.IC2_Item_Casing_Iron.get(1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 8)).duration(10 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(ItemList.IC2_Item_Casing_Iron.get(1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 6)).duration(10 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(ItemList.IC2_Item_Casing_Iron.get(1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 12)).duration(10 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 8)).duration(10 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 35, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 16)).duration(10 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 35, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 12)).duration(10 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 35, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 4)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 37, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).duration(15 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 37, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 24)).duration(15 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 37, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).duration(7 * SECONDS + 10 * TICKS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 39, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 38, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 64)).duration(15 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 39, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 38, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 48)).duration(15 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 39, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 38, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 16)).duration(7 * SECONDS + 10 * TICKS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 63, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 62, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 16)).duration(10 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 63, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 62, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 12)).duration(10 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 63, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 62, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 4)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 8)).duration(10 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 6)).duration(10 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "glass_pane", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 8)).duration(10 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "glass_pane", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 6)).duration(10 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "glass_pane", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 62, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 12)).duration(10 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 62, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 8)).duration(10 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 62, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(5 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 22, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Reinforced, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

    }
}
