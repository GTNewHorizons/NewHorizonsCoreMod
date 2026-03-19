package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Botany;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.BuildCraftSilicon;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.EtFuturumRequiem;
import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.Gendustry;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
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
import static gregtech.api.recipe.RecipeMaps.multiblockChemicalReactorRecipes;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeConstants.UniversalChemical;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.item.NHItemList;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.ToolDictNames;
import gregtech.api.util.GTOreDictUnificator;

public class ScriptStevesCarts implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Steves Carts";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Backpack.ID,
                BiomesOPlenty.ID,
                Botany.ID,
                BuildCraftFactory.ID,
                BuildCraftSilicon.ID,
                EnderIO.ID,
                EtFuturumRequiem.ID,
                ExtraBees.ID,
                ExtraUtilities.ID,
                Forestry.ID,
                Gendustry.ID,
                IndustrialCraft2.ID,
                IronTanks.ID,
                Natura.ID,
                OpenBlocks.ID,
                ProjectRedExploration.ID,
                ProjectRedIntegration.ID,
                Railcraft.ID,
                StevesCarts2.ID,
                Thaumcraft.ID,
                TinkerConstruct.ID,
                TwilightForest.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockCartAssembler", 1, 0),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                ItemList.Robot_Arm_LV.get(1L),
                ItemList.Conveyor_Module_LV.get(1L),
                ItemList.Hull_LV.get(1L),
                ItemList.Conveyor_Module_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockCargoManager", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38),
                ItemList.Conveyor_Module_LV.get(1L),
                ItemList.Hull_LV.get(1L),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36),
                ItemList.Cover_ActivityDetector.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDistributor", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38),
                ItemList.Conveyor_Module_LV.get(1L),
                ItemList.Hull_LV.get(1L),
                ItemList.Conveyor_Module_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 1),
                "screwSteel",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "screwSteel",
                ItemList.Cover_ActivityDetector.get(1L),
                ItemList.Casing_LV.get(1L),
                ItemList.Cover_ActivityDetector.get(1L),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 1),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36),
                "wireGt01RedAlloy",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 2),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 1),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36),
                "wireGt01RedAlloy",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 3),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38),
                getModItem(Minecraft.ID, "redstone_torch", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 1),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36),
                "wireGt01RedAlloy",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 4),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38),
                "plateRedstoneAlloy",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 1),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36),
                "wireGt01RedAlloy",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockActivator", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 13),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38),
                "wireGt01RedAlloy",
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 1),
                "wireGt01RedAlloy",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 0),
                null,
                ToolDictNames.craftingToolSoftMallet.name(),
                null,
                "ringWood",
                "stickWood",
                "ringWood",
                null,
                "craftingToolWrench",
                null);
        addShapelessRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 1),
                ItemList.Component_Minecart_Wheels_Iron.get(1L));
        addShapelessRecipe(
                ItemList.Component_Minecart_Wheels_Iron.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 1));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 23),
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
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 82),
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
                getModItem(StevesCarts2.ID, "CartModule", 1, 37),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                ToolDictNames.craftingToolSoftMallet.name(),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 0),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 0));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 38),
                "plateIron",
                "craftingToolHardHammer",
                "plateIron",
                "plateIron",
                "plateIron",
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 1),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 1));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 39),
                "plateReinforced",
                "craftingToolHardHammer",
                "plateReinforced",
                "plateReinforced",
                "plateReinforced",
                "plateReinforced",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 23),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 23));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 81),
                "plateGalgadorian",
                "craftingToolHardHammer",
                "plateGalgadorian",
                "plateGalgadorian",
                "plateGalgadorian",
                "plateGalgadorian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 82),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 82));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 42),
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "blockIron",
                "stickIron",
                "toolHeadDrillIron",
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "screwIron",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 8),
                NHItemList.SteelBars.get(),
                "screwSteel",
                "craftingToolScrewdriver",
                "blockSteel",
                getModItem(StevesCarts2.ID, "CartModule", 1, 42),
                NHItemList.DiamondDrillTip.get(1),
                NHItemList.SteelBars.get(),
                "screwSteel",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 43),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 20),
                "screwStainlessSteel",
                "craftingToolScrewdriver",
                "blockDiamond",
                getModItem(StevesCarts2.ID, "CartModule", 1, 8),
                "toolHeadDrillReinforced",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 20),
                "screwStainlessSteel",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 9),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 20),
                "screwTitanium",
                "craftingToolScrewdriver",
                "blockIridium",
                getModItem(StevesCarts2.ID, "CartModule", 1, 43),
                "toolHeadDrillGalgadorian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 20),
                "screwTitanium",
                "craftingToolHardHammer");
        addShapelessRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15),
                ItemList.Component_Sawblade_Diamond.get(1L));
        addShapelessRecipe(
                ItemList.Component_Sawblade_Diamond.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80),
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
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81),
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
                getModItem(StevesCarts2.ID, "CartModule", 1, 44),
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
                getModItem(StevesCarts2.ID, "CartModule", 1, 0),
                "itemCasingSteel",
                "craftingBlastFurnace",
                "itemCasingSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "screwSteel",
                ItemList.Electric_Motor_LV.get(1L),
                ItemList.Electric_Piston_LV.get(1L),
                "craftingToolScrewdriver",
                ItemList.Electric_Piston_LV.get(1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 45),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44),
                "screwSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "screwSteel",
                "craftingToolWrench",
                ItemList.Electric_Piston_LV.get(1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 1),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                ItemList.Electric_Motor_LV.get(1L),
                ItemList.Electric_Piston_LV.get(1L),
                "screwAluminium",
                ItemList.Electric_Piston_LV.get(1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 56),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 58),
                getModItem(StevesCarts2.ID, "CartModule", 1, 1),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 58),
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                ItemList.Electric_Motor_MV.get(1L),
                ItemList.Electric_Piston_MV.get(1L),
                "screwStainlessSteel",
                ItemList.Electric_Piston_MV.get(1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 69),
                "itemCasingSteel",
                "craftingBlastFurnace",
                "itemCasingSteel",
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(IronTanks.ID, "obsidianTank", 1, 0),
                ItemList.Electric_Motor_LV.get(1L),
                ItemList.Electric_Piston_LV.get(1L),
                getModItem(Railcraft.ID, "machine.beta", 1, 3),
                ItemList.Electric_Piston_LV.get(1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 70),
                "plateReinforced",
                getModItem(StevesCarts2.ID, "CartModule", 1, 69),
                "plateReinforced",
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(IronTanks.ID, "ironTank", 1, 0),
                ItemList.Electric_Motor_MV.get(1L),
                ItemList.Electric_Piston_MV.get(1L),
                getModItem(Railcraft.ID, "machine.beta", 1, 4),
                ItemList.Electric_Piston_MV.get(1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 2, 30),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                null,
                null,
                "craftingToolSaw",
                null,
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31),
                "craftingToolScrewdriver",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 30),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 30),
                "screwIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 30),
                null,
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 30),
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32),
                "craftingToolScrewdriver",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31),
                "screwIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31),
                null,
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31),
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 2, 34),
                "plateIron",
                null,
                null,
                "craftingToolSaw",
                null,
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35),
                "craftingToolScrewdriver",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 34),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 34),
                "screwSteel",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 34),
                null,
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 34),
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36),
                "craftingToolScrewdriver",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35),
                "screwSteel",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35),
                null,
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35),
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 14),
                "stickDiamond",
                ItemList.Electric_Motor_LV.get(1L),
                "stickDiamond",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "stickDiamond",
                ItemList.Robot_Arm_LV.get(1L),
                "stickDiamond");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 84),
                "stickGalgadorian",
                ItemList.Electric_Motor_MV.get(1L),
                "stickGalgadorian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                getModItem(StevesCarts2.ID, "CartModule", 1, 14),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                "stickGalgadorian",
                ItemList.Robot_Arm_MV.get(1L),
                "stickGalgadorian");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 15),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 79),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80),
                getModItem(StevesCarts2.ID, "CartModule", 1, 15),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 80),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81),
                getModItem(StevesCarts2.ID, "CartModule", 1, 79),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81),
                "circuitAdvanced",
                ItemList.Electric_Motor_HV.get(1L),
                "circuitAdvanced");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 2, 61),
                "paneGlassColorless",
                null,
                null,
                "craftingToolSaw",
                null,
                null);
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28),
                "plateRedstone",
                "platePlastic",
                "plateRedstone",
                "platePlastic",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "platePlastic",
                "platePlastic",
                "platePlastic",
                "platePlastic");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockLiquidManager", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38),
                ItemList.Conveyor_Module_LV.get(1L),
                ItemList.Hull_LV.get(1L),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(StevesCarts2.ID, "CartModule", 1, 66),
                ItemList.Cover_ActivityDetector.get(1L),
                getModItem(StevesCarts2.ID, "CartModule", 1, 66));
        addShapelessRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 24),
                GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 24));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 7),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 29),
                null,
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 29),
                ItemList.Conveyor_Module_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                ItemList.Robot_Arm_LV.get(1L),
                "itemCasingIron",
                "itemCasingIron",
                "itemCasingIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 26),
                "screwSteel",
                "dyeRed",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 12),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 12),
                "dyeRed",
                "plateRedstone",
                "plateIron",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 13),
                "screwSteel",
                "dyeBlue",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 12),
                "plateGold",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 12),
                "dyeBlue",
                "plateRedstone",
                "plateGold",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 33),
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
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40),
                NHItemList.SteelBars.get(),
                "dustRedstone",
                NHItemList.SteelBars.get(),
                "dustCoal",
                "rotorSteel",
                "dustCoal",
                NHItemList.SteelBars.get(),
                "dustRedstone",
                NHItemList.SteelBars.get());
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59),
                "itemCasingSteel",
                "plateRedstone",
                "itemCasingSteel",
                "plateSteel",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                "plateSteel",
                "itemCasingSteel",
                "itemCasingSteel",
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 0),
                "plateRedstone",
                "gemDiamond",
                "plateRedstone",
                "circuitBasic",
                createItemStack(GregTech.ID, "gt.metaitem.01", 1, 32518, "{GT.ItemCharge:100000L}"),
                "circuitBasic",
                "plateRedstone",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59),
                "plateRedstone");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 1),
                "gemFlawlessDiamond",
                "blockEmerald",
                "gemFlawlessDiamond",
                "circuitAdvanced",
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                "circuitAdvanced",
                "plateGlowstone",
                getModItem(StevesCarts2.ID, "upgrade", 1, 0),
                "plateGlowstone");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 2),
                "bookEmpty",
                getModItem(Minecraft.ID, "bookshelf", 1, 0),
                "bookEmpty",
                getModItem(Minecraft.ID, "bookshelf", 1, 0),
                getModItem(Minecraft.ID, "enchanting_table", 1, 0),
                getModItem(Minecraft.ID, "bookshelf", 1, 0),
                "plateReinforced",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59),
                "plateReinforced");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 3),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45),
                "plateReinforced",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45),
                "plateReinforced",
                getModItem(StevesCarts2.ID, "upgrade", 1, 2),
                "plateReinforced");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 4),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                createItemStack(Minecraft.ID, "enchanted_book", 1, 0, "{StoredEnchantments:[0:{lvl:3s,id:32s}]}"),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "plateReinforced",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                "plateReinforced",
                "plateReinforced",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59),
                "plateReinforced");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 5),
                "plateGalgadorian",
                createItemStack(Minecraft.ID, "enchanted_book", 1, 0, "{StoredEnchantments:[0:{lvl:5s,id:32s}]}"),
                "plateGalgadorian",
                "plateGalgadorian",
                "circuitMaster",
                "plateGalgadorian",
                "plateGalgadorian",
                getModItem(StevesCarts2.ID, "upgrade", 1, 4),
                "plateGalgadorian");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 6),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                NHItemList.SteelBars.get(),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                ItemList.Electric_Motor_LV.get(1L),
                "rotorSteel",
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 7),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                ItemList.Electric_Piston_LV.get(1L),
                "craftingBlastFurnace",
                ItemList.Electric_Piston_LV.get(1L),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 8),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                "plateIron",
                ItemList.Electric_Piston_LV.get(1L),
                "chestWood",
                ItemList.Electric_Piston_LV.get(1L),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 9),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 6),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                "plateReinforced",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59),
                "plateReinforced");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 10),
                "plateIron",
                getModItem(Minecraft.ID, "rail", 1, 0),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                ItemList.Electric_Piston_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 11),
                "plateIron",
                ItemList.Robot_Arm_LV.get(1L),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(Railcraft.ID, "anvil", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 12),
                ItemList.Electric_Piston_LV.get(1L),
                ItemList.Robot_Arm_LV.get(1L),
                ItemList.Electric_Piston_LV.get(1L),
                ItemList.Conveyor_Module_LV.get(1L),
                "frameGtSteel",
                ItemList.Conveyor_Module_LV.get(1L),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 13),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 10),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 17),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 21),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 15),
                "plateObsidian",
                "plateReinforced",
                "plateObsidian",
                "plateReinforced",
                "blockSteel",
                "plateReinforced",
                "plateObsidian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59),
                "plateObsidian");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 16),
                "gemFlawlessDiamond",
                "plateReinforced",
                "gemFlawlessDiamond",
                "plateGalgadorian",
                "blockLapis",
                "plateGalgadorian",
                "plateIron",
                getModItem(StevesCarts2.ID, "upgrade", 1, 15),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 17),
                "plateIron",
                "plateEnderEye",
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                getModItem(StevesCarts2.ID, "BlockDistributor", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 18),
                getModItem(IronTanks.ID, "ironTank", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                getModItem(IronTanks.ID, "ironTank", 1, 0),
                ItemList.Electric_Piston_LV.get(1L),
                getModItem(StevesCarts2.ID, "CartModule", 1, 69),
                ItemList.Electric_Piston_LV.get(1L),
                "plateObsidian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59),
                "plateObsidian");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 19),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44),
                ItemList.Electric_Piston_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                ItemList.Electric_Piston_LV.get(1L),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59),
                ItemList.Electric_Motor_LV.get(1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 41),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4),
                "plateIron",
                "plateRedstone",
                "plateIron",
                "screwIron",
                "plateIron",
                "screwIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 41),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 64),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 30),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 41),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 71),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 64),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 25),
                "plateSteel",
                "craftingToolHardHammer",
                "plateSteel",
                "plateRedstone",
                "plateGold",
                "plateRedstone",
                getModItem(Minecraft.ID, "dispenser", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(Minecraft.ID, "dispenser", 1, 0));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 29),
                "screwSteel",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 26),
                "screwSteel",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 25),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 24),
                "plateSteel",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 27),
                "plateSteel");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 33),
                getModItem(Minecraft.ID, "glowstone", 1, 0),
                "stoneNetherBrick",
                getModItem(Minecraft.ID, "glowstone", 1, 0),
                getModItem(IronTanks.ID, "ironTank", 1, 0),
                "craftingBlastFurnace",
                getModItem(IronTanks.ID, "ironTank", 1, 0),
                "bucketLava",
                "stoneNetherBrick",
                "bucketLava");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 34),
                getModItem(Minecraft.ID, "glowstone", 1, 0),
                "plateObsidian",
                getModItem(Minecraft.ID, "glowstone", 1, 0),
                getModItem(StevesCarts2.ID, "CartModule", 1, 33),
                getModItem(Railcraft.ID, "machine.beta", 1, 6),
                getModItem(StevesCarts2.ID, "CartModule", 1, 33),
                "bucketLava",
                "plateObsidian",
                "bucketLava");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 10),
                "plateIron",
                "plateIron",
                "plateIron",
                ItemList.Conveyor_Module_LV.get(1L),
                getModItem(Minecraft.ID, "rail", 1, 0),
                ItemList.Robot_Arm_LV.get(1L),
                "plateIron",
                "plateIron",
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 11),
                "plateSteel",
                "plateSteel",
                "plateSteel",
                getModItem(StevesCarts2.ID, "CartModule", 1, 10),
                getModItem(Minecraft.ID, "rail", 1, 0),
                getModItem(StevesCarts2.ID, "CartModule", 1, 10),
                "plateSteel",
                "plateSteel",
                "plateSteel");
        addShapelessRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6),
                getModItem(IndustrialCraft2.ID, "itemDynamite", 1, 0));
        addShapelessRecipe(
                getModItem(IndustrialCraft2.ID, "itemDynamite", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 31),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6),
                getModItem(Minecraft.ID, "flint_and_steel", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 59),
                "fenceWood",
                getModItem(Minecraft.ID, "dispenser", 1, 0),
                "fenceWood",
                "chestWood",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 43),
                "chestWood",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(Minecraft.ID, "flint_and_steel", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 14),
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
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 10),
                "stickPlastic",
                "paneGlassColorless",
                "stickPlastic",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                NHItemList.Display.get(),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "stickPlastic",
                "paneGlassColorless",
                "stickPlastic");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 27),
                "craftingToolHardHammer",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 10),
                "craftingToolWrench",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 14),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 13),
                "plateSteel",
                "plateSteel",
                "plateSteel");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 2, 60),
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Bronze, 1L),
                "screwIron",
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Bronze, 1L),
                "screwIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 57),
                NHItemList.SteelBars.get(),
                NHItemList.SteelBars.get(),
                NHItemList.SteelBars.get(),
                NHItemList.SteelBars.get(),
                "craftingToolHardHammer",
                NHItemList.SteelBars.get(),
                NHItemList.SteelBars.get(),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                NHItemList.SteelBars.get());
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 12),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "plateRedstone",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(Minecraft.ID, "brick_block", 1, 0),
                ItemList.Electric_Piston_LV.get(1L),
                getModItem(Minecraft.ID, "brick_block", 1, 0),
                "plateIron",
                "blockHopper",
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 13),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                ItemList.Robot_Arm_LV.get(1L),
                ItemList.Conveyor_Module_LV.get(1L),
                getModItem(Minecraft.ID, "rail", 1, 0),
                ItemList.Conveyor_Module_LV.get(1L),
                "plateIron",
                "plateIron",
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 25),
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
                getModItem(StevesCarts2.ID, "CartModule", 1, 49),
                "plateTitanium",
                "circuitData",
                "plateTitanium",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                getModItem(Railcraft.ID, "machine.alpha", 1, 2),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                "plateReinforced",
                "circuitData",
                "plateReinforced");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 85),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                ItemList.Robot_Arm_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84),
                ItemList.Electric_Motor_LV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 68),
                "plateIron",
                GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Brass, 1L),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(ExtraUtilities.ID, "trashcan", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "plateIron",
                GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Brass, 1L),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 32),
                "plateDenseObsidian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 19),
                "plateDenseObsidian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 19),
                getModItem(StevesCarts2.ID, "BlockMetalStorage", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 19),
                "plateDenseObsidian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 19),
                "plateDenseObsidian");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 16),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L),
                GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 95),
                "plateEmerald",
                getModItem(OpenBlocks.ID, "xpdrain", 1, 0),
                "plateEmerald",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(Minecraft.ID, "cauldron", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 18),
                GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Tin, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Tin, 1L),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                getModItem(Backpack.ID, "tannedLeather", 1, 0),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                getModItem(Backpack.ID, "tannedLeather", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(Backpack.ID, "tannedLeather", 1, 0));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 19),
                "plateIron",
                getModItem(Minecraft.ID, "compass", 1, 0),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                NHItemList.Display.get(),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 20),
                "plateIron",
                "gemDiamond",
                "plateIron",
                "plateRedstone",
                ItemList.Cover_FluidDetector.get(1L),
                "plateRedstone",
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 40),
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                "plateRedstone",
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(Minecraft.ID, "noteblock", 1, 0),
                "plateIron",
                getModItem(Minecraft.ID, "jukebox", 1, 0),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 75),
                "plateIron",
                "plateGold",
                "plateIron",
                "plateGold",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                "plateGold",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                "plateRedstone",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 77),
                "plateIron",
                ItemList.Electric_Piston_LV.get(1L),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                ItemList.Cover_EnergyDetector.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 78),
                "plateIron",
                "plateRedstone",
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                NHItemList.Display.get(),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                getModItem(Minecraft.ID, "stone_button", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                getModItem(Minecraft.ID, "stone_button", 1, 0));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 82),
                "plateIron",
                "plateEnhancedGalgadorian",
                "plateIron",
                getModItem(Minecraft.ID, "writable_book", 1, 0),
                getModItem(EnderIO.ID, "blockEnchanter", 1, 0),
                getModItem(Minecraft.ID, "writable_book", 1, 0),
                "plateRedstone",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                "plateRedstone");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 83),
                ItemList.Sensor_HV.get(1L),
                "plateRedstone",
                ItemList.Sensor_HV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45),
                "plateGalgadorian",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 86),
                getModItem(Minecraft.ID, "hay_block", 1, 0),
                ItemList.Electric_Pump_LV.get(1L),
                getModItem(Minecraft.ID, "hay_block", 1, 0),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0));
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 89),
                ItemList.Sensor_MV.get(1L),
                "plateRedstone",
                ItemList.Sensor_MV.get(1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                "plateIron",
                "plateRedstone",
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17),
                "treeSapling",
                "treeSapling",
                "treeSapling",
                "treeSapling",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "treeSapling",
                "treeSapling",
                "treeSapling",
                "treeSapling");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 94),
                "plateIron",
                getModItem(Minecraft.ID, "sign", 1, 0),
                "plateIron",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                NHItemList.Display.get(),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "plateIron",
                "plateRedstone",
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 99),
                null,
                getModItem(Minecraft.ID, "cake", 1, 0),
                null,
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "slabWood",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "plateIron",
                "plateIron",
                "plateIron");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 117),
                "plateSteel",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                "plateSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "gearSteel",
                ItemList.Electric_Motor_LV.get(1L),
                "plateSteel",
                GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Tin, 1L),
                "plateSteel");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 118),
                "plateAluminium",
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16),
                "plateAluminium",
                ItemList.Electric_Motor_MV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Reinforced, 1L),
                ItemList.Electric_Motor_MV.get(1L),
                "plateAluminium",
                GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Copper, 1L),
                "plateAluminium");
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 119),
                "plateStainlessSteel",
                "circuitAdvanced",
                "plateStainlessSteel",
                ItemList.Electric_Motor_HV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Galgadorian, 1L),
                ItemList.Electric_Motor_HV.get(1L),
                "plateStainlessSteel",
                GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Gold, 1L),
                "plateStainlessSteel");
        addShapelessRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 22),
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Reinforced, 1L));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Reinforced, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 22));
        addShapelessRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 47),
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Galgadorian, 1L));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Galgadorian, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 47));
        addShapelessRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 49),
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.GalgadorianEnhanced, 1L));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.GalgadorianEnhanced, 1L),
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 49));

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 14),
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
                getModItem(StevesCarts2.ID, "upgrade", 1, 5),
                'd',
                "plateEnhancedGalgadorian",
                'e',
                ItemList.Generator_Naquadah_Mark_III.get(1L));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 61),
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
                getModItem(Railcraft.ID, "firestone.refined", 1, 0),
                'b',
                "ingotInfinity",
                'c',
                getModItem(StevesCarts2.ID, "upgrade", 1, 19),
                'd',
                "plateEnhancedGalgadorian",
                'e',
                getModItem(StevesCarts2.ID, "upgrade", 1, 18),
                'f',
                getModItem(IndustrialCraft2.ID, "blockReactorChamber", 1, 0));

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "detector_rail", 1, 0), getModItem(Railcraft.ID, "detector", 1, 9))
                .itemOutputs(getModItem(StevesCarts2.ID, "BlockAdvDetector", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.junction\"}"),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.RedAlloy, 4L))
                .itemOutputs(getModItem(StevesCarts2.ID, "BlockJunction", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Wood, 2L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 0)).duration(10 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Reinforced, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Reinforced, 2L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 23)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Galgadorian, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Galgadorian, 2L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 82)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 4L),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 37)).duration(20 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 1))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 38)).duration(20 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Reinforced, 4L),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 23))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 39)).duration(20 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Galgadorian, 4L),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 82))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 81)).duration(20 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(NHItemList.SteelBars.get(5), getModItem(StevesCarts2.ID, "ModuleComponents", 4, 19))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 20)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.CobaltBrass, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Reinforced, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80))
                .duration(1 * MINUTES + 20 * SECONDS).eut(2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.CobaltBrass, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Galgadorian, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81))
                .duration(1 * MINUTES + 20 * SECONDS).eut(2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.toolHeadSaw, Materials.Iron, 2L))
                .circuit(1).itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 83)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.gearGt, Materials.Iron, 1L),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 83))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Cover_SolarPanel.get(1L), getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 44),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 16))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 58)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30)).circuit(4)
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 31)).circuit(4)
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32)).duration(8 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34)).circuit(4)
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35)).duration(8 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 35)).circuit(4)
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36)).duration(16 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 38),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 39)).duration(32 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                        getModItem(Minecraft.ID, "sapling", 8, wildcard))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                        getModItem(BiomesOPlenty.ID, "saplings", 8, wildcard))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                        getModItem(BiomesOPlenty.ID, "colorizedSaplings", 8, wildcard))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                        getModItem(Forestry.ID, "saplingGE", 8, wildcard))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                        getModItem(IndustrialCraft2.ID, "blockRubSapling", 8, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                        getModItem(Natura.ID, "florasapling", 8, wildcard))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                        getModItem(Natura.ID, "Rare Sapling", 8, wildcard))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                        getModItem(Thaumcraft.ID, "blockCustomPlant", 8, wildcard))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9),
                        getModItem(TwilightForest.ID, "tile.TFSapling", 8, wildcard))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61)).circuit(4)
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 62))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 36)).duration(8 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 62)).circuit(4)
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 63))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 72)).duration(16 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28),
                        getModItem(Minecraft.ID, "porkchop", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 21)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28),
                        getModItem(Minecraft.ID, "diamond", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 22)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28),
                        getModItem(Minecraft.ID, "emerald", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 23)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28),
                        getModItem(Minecraft.ID, "slime_ball", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 24)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28),
                        getModItem(Minecraft.ID, "glass_bottle", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 51)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28),
                        getModItem(Minecraft.ID, "fire_charge", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 52)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28),
                        getModItem(Minecraft.ID, "egg", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 53)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28),
                        getModItem(Minecraft.ID, "cake", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 90)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28),
                        getModItem(Minecraft.ID, "nether_wart", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 58)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 88)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "torch", 3, 0)).circuit(3)
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 29)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Steel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Iron, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 11)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 1L),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Iron, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 33)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Minecraft.ID, "dye", 4, 1))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        ItemList.Color_01.get(4L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Gendustry.ID, "HoneyDrop", 4, 11))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 4, 14))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(ExtraBees.ID, "misc", 4, 19))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Botany.ID, "pigment", 4, 59))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Minecraft.ID, "dye", 4, 2))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(ExtraBees.ID, "misc", 4, 22))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 4, 13))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Gendustry.ID, "HoneyDrop", 4, 12))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        ItemList.Color_02.get(4L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(BiomesOPlenty.ID, "misc", 4, 7))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Botany.ID, "pigment", 4, 28))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Minecraft.ID, "dye", 4, 4))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Botany.ID, "pigment", 4, 24))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(ExtraBees.ID, "misc", 4, 21))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Natura.ID, "barleyFood", 4, 8))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 4, 11))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(Gendustry.ID, "HoneyDrop", 4, 14))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        ItemList.Color_04.get(4L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glowstone, 2L),
                        getModItem(BiomesOPlenty.ID, "misc", 4, 5))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4)).duration(5 * SECONDS).eut(2)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "CartModule", 1, 41),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 101)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Cover_Crafting.get(1L), getModItem(StevesCarts2.ID, "ModuleComponents", 2, 9))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 87)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "CartModule", 1, 87),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 16))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 92)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(EtFuturumRequiem.ID, "blast_furnace", 1, 0),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 9))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 91)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "CartModule", 1, 91),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 16))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 93)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 25),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 8, 24))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 28)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Tool_Scanner.get(1L), getModItem(StevesCarts2.ID, "CartModule", 1, 21))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 26)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Tool_Scanner.get(1L), getModItem(StevesCarts2.ID, "CartModule", 1, 22))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 26)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Tool_Scanner.get(1L), getModItem(StevesCarts2.ID, "CartModule", 1, 23))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 26)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Tool_Scanner.get(1L), getModItem(StevesCarts2.ID, "CartModule", 1, 24))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 26)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Sensor_MV.get(1L), getModItem(StevesCarts2.ID, "CartModule", 1, 21))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 27)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Sensor_MV.get(1L), getModItem(StevesCarts2.ID, "CartModule", 1, 22))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 27)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Sensor_MV.get(1L), getModItem(StevesCarts2.ID, "CartModule", 1, 23))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 27)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Sensor_MV.get(1L), getModItem(StevesCarts2.ID, "CartModule", 1, 24))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 27)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "string", 1, 0), getModItem(Minecraft.ID, "gunpowder", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 43)).duration(2 * SECONDS + 10 * TICKS)
                .eut(2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 7, 0),
                        getModItem(Minecraft.ID, "fermented_spider_eye", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 5))
                .fluidInputs(FluidRegistry.getFluidStack("molten.thaumium", 288)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 5),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 36))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Bronze, 1L),
                        getModItem(Minecraft.ID, "iron_bars", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 2, 60)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(NHItemList.SteelBars.get(5), getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 57)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(StevesCarts2.ID, "CartModule", 1, 81), ItemList.Quantum_Chest_IV.get(1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 76))
                .fluidInputs(FluidRegistry.getFluidStack("molten.americium", 1440)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LuV).addTo(assemblerRecipes);
        // Qol Recipes
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.glowstone_dust, 30),
                        new ItemStack(Blocks.diamond_block, 10),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 30, 45))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 20, 46))
                .fluidInputs(Materials.Reinforced.getMolten(2880)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 20),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 12, 19))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 20, 21))
                .fluidInputs(Materials.Iron.getMolten(2880)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new ItemStack(Items.magma_cream, 8),
                        new ItemStack(Items.fermented_spider_eye, 8),
                        new ItemStack(Items.ghast_tear, 8),
                        new ItemStack(Items.ender_eye, 4))
                .circuit(24).itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 45))
                .fluidInputs(Materials.Glowstone.getMolten(144)).duration(10 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(multiblockChemicalReactorRecipes);
        //
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 21))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 22)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_MV).specialValue(1700).addTo(blastFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 46))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Galgadorian, 1L))
                .fluidInputs(FluidRegistry.getFluidStack("oxygen", 1000)).duration(1 * MINUTES + 40 * SECONDS)
                .eut(TierEU.RECIPE_MV).specialValue(2200).addTo(blastFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 48))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.GalgadorianEnhanced, 1L))
                .fluidInputs(FluidRegistry.getFluidStack("oxygen", 1000)).duration(2 * MINUTES + 30 * SECONDS)
                .eut(TierEU.RECIPE_MV).specialValue(3500).addTo(blastFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 11))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 12)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).specialValue(1000).addTo(blastFurnaceRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "diamond", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 2, 18))
                .fluidInputs(Materials.Obsidian.getMolten(1152)).duration(30 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Wood, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Wood, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Wood, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Wood, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(12 * TICKS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30))
                .fluidInputs(FluidRegistry.getFluidStack("water", 6)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 4)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(12 * TICKS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 31))
                .fluidInputs(FluidRegistry.getFluidStack("water", 8)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 31))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 6)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 31))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(2 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 31))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(12 * TICKS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Iron, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34))
                .fluidInputs(FluidRegistry.getFluidStack("water", 8)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Iron, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 6)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Iron, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Iron, 1L))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(2 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34))
                .fluidInputs(FluidRegistry.getFluidStack("water", 12)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 8)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(2 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 35))
                .fluidInputs(FluidRegistry.getFluidStack("water", 16)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 35))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 12)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 35))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 4)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 35))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(2 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 37))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 37))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 24)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 37))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 37))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(2)).duration(3 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 39))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 38))
                .fluidInputs(FluidRegistry.getFluidStack("water", 64)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 39))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 38))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 48)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 39))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 38))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 16)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 39))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 38))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(3)).duration(3 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 63))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 62))
                .fluidInputs(FluidRegistry.getFluidStack("water", 16)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 63))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 62))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 12)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 63))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 62))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 4)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 63))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 62))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(2 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61))
                .fluidInputs(FluidRegistry.getFluidStack("water", 8)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 6)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(2 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "glass_pane", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61))
                .fluidInputs(FluidRegistry.getFluidStack("water", 8)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "glass_pane", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 6)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "glass_pane", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "glass_pane", 1, 0))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(2 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 62))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61))
                .fluidInputs(FluidRegistry.getFluidStack("water", 12)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 62))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 8)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 62))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 62))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(2 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 22))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Reinforced, 1L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

    }
}
