package com.dreammaster.scripts;

import static com.dreammaster.scripts.TemporaryMods.ProjectRedExploration;
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
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sBlastRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sChemicalRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCompressorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCutterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GT_Values;

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
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 11, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockCargoManager", 1, 0, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 11, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32731, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDistributor", 1, 0, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 11, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 1, missing),
                new Object[] { "screwSteel", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        "screwSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32731, missing),
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32731, missing), "craftingToolWrench",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 0, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "BlockDetector", 1, 1, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing), "wireGt01RedAlloy",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 2, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "BlockDetector", 1, 1, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing), "wireGt01RedAlloy",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 3, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "BlockDetector", 1, 1, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing), "wireGt01RedAlloy",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockDetector", 1, 4, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing), "plateRedstoneAlloy",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "BlockDetector", 1, 1, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing), "wireGt01RedAlloy",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockActivator", 1, 0, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 13, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing), "wireGt01RedAlloy",
                        getModItem(StevesCarts2.ID, "BlockDetector", 1, 1, missing), "wireGt01RedAlloy",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 0, missing),
                new Object[] { null, "craftingToolSoftHammer", null, "ringWood", "stickWood", "ringWood", null,
                        "craftingToolWrench", null });
        addShapelessCraftingRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 1, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32100, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32100, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 1, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 23, missing),
                new Object[] { null, "craftingToolHardHammer", null, "ringReinforced", "stickReinforced",
                        "ringReinforced", null, "craftingToolWrench", null });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 82, missing),
                new Object[] { null, "craftingToolHardHammer", null, "ringGalgadorian", "stickGalgadorian",
                        "ringGalgadorian", null, "craftingToolWrench", null });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 37, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing), "craftingToolSoftHammer",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 0, missing), "craftingToolWrench",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 0, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 38, missing),
                new Object[] { "plateIron", "craftingToolHardHammer", "plateIron", "plateIron", "plateIron",
                        "plateIron", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 1, missing),
                        "craftingToolWrench", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 1, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 39, missing),
                new Object[] { "plateReinforced", "craftingToolHardHammer", "plateReinforced", "plateReinforced",
                        "plateReinforced", "plateReinforced",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 23, missing), "craftingToolWrench",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 23, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 81, missing),
                new Object[] { "plateGalgadorian", "craftingToolHardHammer", "plateGalgadorian", "plateGalgadorian",
                        "plateGalgadorian", "plateGalgadorian",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 82, missing), "craftingToolWrench",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 82, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 42, missing),
                new Object[] { getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "screwIron",
                        "craftingToolScrewdriver", "blockIron", "stickIron", "toolHeadDrillIron",
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "screwIron", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 8, missing),
                new Object[] { getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing), "screwSteel",
                        "craftingToolScrewdriver", "blockSteel",
                        getModItem(StevesCarts2.ID, "CartModule", 1, 42, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.DiamondDrillTip", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing), "screwSteel",
                        "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 43, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 20, missing), "screwStainlessSteel",
                        "craftingToolScrewdriver", "blockDiamond",
                        getModItem(StevesCarts2.ID, "CartModule", 1, 8, missing), "toolHeadDrillReinforced",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 20, missing), "screwStainlessSteel",
                        "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 9, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 20, missing), "screwTitanium",
                        "craftingToolScrewdriver", "blockIridium",
                        getModItem(StevesCarts2.ID, "CartModule", 1, 43, missing), "toolHeadDrillGalgadorian",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 20, missing), "screwTitanium",
                        "craftingToolHardHammer" });
        addShapelessCraftingRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32721, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32721, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80, missing),
                new Object[] { null, "dustSmallReinforced", null, "dustSmallReinforced", "gearCobaltBrass",
                        "dustSmallReinforced", null, "dustSmallReinforced", null });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81, missing),
                new Object[] { null, "dustSmallGalgadorian", null, "dustSmallGalgadorian", "gearCobaltBrass",
                        "dustSmallGalgadorian", null, "dustSmallGalgadorian", null });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 44, missing),
                new Object[] { "itemCasingIron", "craftingFurnace", "itemCasingIron", "screwIron",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "screwIron", "craftingToolWrench",
                        "craftingPiston", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 0, missing),
                new Object[] { "itemCasingSteel", "craftingIronFurnace", "itemCasingSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "screwSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing), "craftingToolScrewdriver",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 45, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing), "screwSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "screwSteel",
                        "craftingToolWrench", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 1, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing), "screwAluminium",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 56, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 58, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 1, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 58, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32641, missing), "screwStainlessSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32641, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 69, missing),
                new Object[] { "itemCasingSteel", "craftingIronFurnace", "itemCasingSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(IronTanks.ID, "obsidianTank", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(Railcraft.ID, "machine.beta", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 70, missing),
                new Object[] { "plateReinforced", getModItem(StevesCarts2.ID, "CartModule", 1, 69, missing),
                        "plateReinforced", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        getModItem(IronTanks.ID, "ironTank", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32641, missing),
                        getModItem(Railcraft.ID, "machine.beta", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32641, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 2, 30, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing), null, null,
                        "craftingToolSaw", null, null });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing),
                new Object[] { "craftingToolScrewdriver",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 30, missing), "craftingToolWrench",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 30, missing), "screwIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 30, missing), null,
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 30, missing), null });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32, missing),
                new Object[] { "craftingToolScrewdriver",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing), "craftingToolWrench",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing), "screwIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing), null,
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing), null });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 2, 34, missing),
                new Object[] { "plateIron", null, null, "craftingToolSaw", null, null });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing),
                new Object[] { "craftingToolScrewdriver",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 34, missing), "craftingToolWrench",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 34, missing), "screwSteel",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 34, missing), null,
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 34, missing), null });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing),
                new Object[] { "craftingToolScrewdriver",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing), "craftingToolWrench",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing), "screwSteel",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing), null,
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing), null });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 14, missing),
                new Object[] { "stickDiamond", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        "stickDiamond", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "stickDiamond",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing), "stickDiamond" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 84, missing),
                new Object[] { "stickGalgadorian", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        "stickGalgadorian", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 14, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing), "stickGalgadorian",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing), "stickGalgadorian" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 15, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 15, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 79, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 15, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 80, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 79, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81, missing), "circuitAdvanced",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing), "circuitAdvanced" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 2, 61, missing),
                new Object[] { "paneGlassColorless", null, null, "craftingToolSaw", null, null });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                new Object[] { "plateRedstone", "platePlastic", "plateRedstone", "platePlastic",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "platePlastic", "platePlastic",
                        "platePlastic", "platePlastic" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "BlockLiquidManager", 1, 0, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 11, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 66, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32731, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 66, missing) });
        addShapelessCraftingRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 24, missing),
                new Object[] { getModItem(GregTech.ID, "gt.blockmachines", 1, 5131, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.blockmachines", 1, 5131, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 24, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 7, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 29, missing), null,
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 29, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing), "itemCasingIron",
                        "itemCasingIron", "itemCasingIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 26, missing),
                new Object[] { "screwSteel", "dyeRed", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 12, missing),
                        "plateIron", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 12, missing), "dyeRed",
                        "plateRedstone", "plateIron", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 13, missing),
                new Object[] { "screwSteel", "dyeBlue", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 12, missing),
                        "plateGold", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 12, missing), "dyeBlue",
                        "plateRedstone", "plateGold", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 33, missing),
                new Object[] { null, "craftingToolScrewdriver", null, "screwIron", "ringIron", "screwIron", null,
                        "boltIron", null });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40, missing),
                new Object[] { getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing), "dustRedstone",
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing), "dustCoal", "rotorSteel",
                        "dustCoal", getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing), "dustRedstone",
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                new Object[] { "itemCasingSteel", "plateRedstone", "itemCasingSteel", "plateReinforced",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing), "plateReinforced",
                        "itemCasingSteel", "itemCasingSteel", "itemCasingSteel" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 0, missing),
                new Object[] { "plateRedstone", "gemDiamond", "plateRedstone", "circuitBasic",
                        createItemStack(GregTech.ID, "gt.metaitem.01", 1, 32518, "{GT.ItemCharge:100000L}", missing),
                        "circuitBasic", "plateRedstone",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing), "plateRedstone" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 1, missing),
                new Object[] { "gemFlawlessDiamond", "blockEmerald", "gemFlawlessDiamond", "circuitAdvanced",
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, 32767, missing), "circuitAdvanced",
                        "plateGlowstone", getModItem(StevesCarts2.ID, "upgrade", 1, 0, missing), "plateGlowstone" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 2, missing),
                new Object[] { "bookEmpty", getModItem(Minecraft.ID, "bookshelf", 1, 0, missing), "bookEmpty",
                        getModItem(Minecraft.ID, "bookshelf", 1, 0, missing),
                        getModItem(Minecraft.ID, "enchanting_table", 1, 0, missing),
                        getModItem(Minecraft.ID, "bookshelf", 1, 0, missing), "plateReinforced",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing), "plateReinforced" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 3, missing),
                new Object[] { getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45, missing),
                        getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45, missing), "plateReinforced",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45, missing), "plateReinforced",
                        getModItem(StevesCarts2.ID, "upgrade", 1, 2, missing), "plateReinforced" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 4, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        createItemStack(
                                Minecraft.ID,
                                "enchanted_book",
                                1,
                                0,
                                "{StoredEnchantments:[0:{lvl:3s,id:32s}]}",
                                missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "plateReinforced",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing), "plateReinforced",
                        "plateReinforced", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                        "plateReinforced" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 5, missing),
                new Object[] { "plateGalgadorian",
                        createItemStack(
                                Minecraft.ID,
                                "enchanted_book",
                                1,
                                0,
                                "{StoredEnchantments:[0:{lvl:5s,id:32s}]}",
                                missing),
                        "plateGalgadorian", "plateGalgadorian", "circuitMaster", "plateGalgadorian", "plateGalgadorian",
                        getModItem(StevesCarts2.ID, "upgrade", 1, 4, missing), "plateGalgadorian" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 6, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "rotorSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 7, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing), "craftingIronFurnace",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing), "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 8, missing),
                new Object[] { "plateIron", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        "plateIron", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing), "chestWood",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing), "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 9, missing),
                new Object[] { "plateIron", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 6, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing), "plateReinforced",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing), "plateReinforced" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 10, missing),
                new Object[] { "plateIron", getModItem(Minecraft.ID, "rail", 1, 0, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing), "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 11, missing),
                new Object[] { "plateIron", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Railcraft.ID, "anvil", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing), "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 12, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing), "frameGtSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing), "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 13, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 10, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 17, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 21, missing),
                        "plateIron", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing), "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 15, missing),
                new Object[] { "plateObsidian", "plateReinforced", "plateObsidian", "plateReinforced", "blockSteel",
                        "plateReinforced", "plateObsidian",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing), "plateObsidian" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 16, missing),
                new Object[] { "gemFlawlessDiamond", "plateReinforced", "gemFlawlessDiamond", "plateGalgadorian",
                        "blockLapis", "plateGalgadorian", "plateIron",
                        getModItem(StevesCarts2.ID, "upgrade", 1, 15, missing), "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 17, missing),
                new Object[] { "plateIron", "plateEnderEye", "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(StevesCarts2.ID, "BlockDistributor", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing), "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 18, missing),
                new Object[] { getModItem(IronTanks.ID, "ironTank", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(IronTanks.ID, "ironTank", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 69, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing), "plateObsidian",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing), "plateObsidian" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "upgrade", 1, 19, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 59, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 41, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing), "plateIron", "plateRedstone",
                        "plateIron", "screwIron", "plateIron", "screwIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 41, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing), "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 64, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 40, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing), "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 30, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 41, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing), "craftingToolWrench",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 71, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 64, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing), "craftingToolWrench",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 25, missing),
                new Object[] { "plateSteel", "craftingToolHardHammer", "plateSteel", "plateRedstone", "plateGold",
                        "plateRedstone", getModItem(Minecraft.ID, "dispenser", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Minecraft.ID, "dispenser", 1, 0, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 29, missing),
                new Object[] { "screwSteel", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 26, missing),
                        "screwSteel", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 25, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 24, missing), "plateSteel",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 27, missing), "plateSteel" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 33, missing),
                new Object[] { getModItem(Minecraft.ID, "glowstone", 1, 0, missing), "stoneNetherBrick",
                        getModItem(Minecraft.ID, "glowstone", 1, 0, missing),
                        getModItem(IronTanks.ID, "ironTank", 1, 0, missing), "craftingIronFurnace",
                        getModItem(IronTanks.ID, "ironTank", 1, 0, missing), "bucketLava", "stoneNetherBrick",
                        "bucketLava" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 34, missing),
                new Object[] { getModItem(Minecraft.ID, "glowstone", 1, 0, missing), "plateObsidian",
                        getModItem(Minecraft.ID, "glowstone", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 33, missing),
                        getModItem(Railcraft.ID, "machine.beta", 1, 6, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 33, missing), "bucketLava", "plateObsidian",
                        "bucketLava" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 10, missing),
                new Object[] { "plateIron", "plateIron", "plateIron",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(Minecraft.ID, "rail", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing), "plateIron", "plateIron",
                        "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 11, missing),
                new Object[] { "plateSteel", "plateSteel", "plateSteel",
                        getModItem(StevesCarts2.ID, "CartModule", 1, 10, missing),
                        getModItem(Minecraft.ID, "rail", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 10, missing), "plateSteel", "plateSteel",
                        "plateSteel" });
        addShapelessCraftingRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "itemDynamite", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(IndustrialCraft2.ID, "itemDynamite", 1, 0, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 31, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6, missing),
                        getModItem(Minecraft.ID, "flint_and_steel", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 59, missing),
                new Object[] { "fenceWood", getModItem(Minecraft.ID, "dispenser", 1, 0, missing), "fenceWood",
                        "chestWood", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 43, missing), "chestWood",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Minecraft.ID, "flint_and_steel", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 14, missing),
                new Object[] { "stickIron", "ringIron", "stickIron", "ringIron", "craftingToolHardHammer", "ringIron",
                        "stickIron", "ringIron", "stickIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 10, missing),
                new Object[] { "stickPlastic", "paneGlassColorless", "stickPlastic",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "stickPlastic",
                        "paneGlassColorless", "stickPlastic" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 27, missing),
                new Object[] { "craftingToolHardHammer",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 10, missing), "craftingToolWrench",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 14, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 13, missing), "plateSteel", "plateSteel",
                        "plateSteel" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 2, 60, missing),
                new Object[] { "screwIron", getModItem(GregTech.ID, "gt.blockmachines", 1, 5121, missing), "screwIron",
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "screwIron",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5121, missing), "screwIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 57, missing),
                new Object[] { getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 12, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "plateRedstone",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Minecraft.ID, "brick_block", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        getModItem(Minecraft.ID, "brick_block", 1, 0, missing), "plateIron", "blockHopper",
                        "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 13, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing),
                        getModItem(Minecraft.ID, "rail", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing), "plateIron", "plateIron",
                        "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 25, missing),
                new Object[] { "craftingToolScrewdriver", null, "plankWood", null, "screwIron", "plankWood", "slabWood",
                        "slabWood", "screwIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 49, missing),
                new Object[] { "plateTitanium", "circuitData", "plateTitanium",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(Railcraft.ID, "machine.alpha", 1, 2, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing), "plateReinforced",
                        "circuitData", "plateReinforced" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 85, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 68, missing),
                new Object[] { "plateIron", getModItem(GregTech.ID, "gt.blockmachines", 1, 5601, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(ExtraUtilities.ID, "trashcan", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "plateIron",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5601, missing), "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 32, missing),
                new Object[] { "plateDenseObsidian", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 19, missing),
                        "plateDenseObsidian", getModItem(StevesCarts2.ID, "ModuleComponents", 1, 19, missing),
                        getModItem(StevesCarts2.ID, "BlockMetalStorage", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 19, missing), "plateDenseObsidian",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 19, missing), "plateDenseObsidian" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 16, missing),
                new Object[] { getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5132, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5132, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5131, missing), "craftingToolHardHammer",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5131, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 95, missing),
                new Object[] { "plateEmerald", getModItem(OpenBlocks.ID, "xpdrain", 1, 0, missing), "plateEmerald",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Minecraft.ID, "cauldron", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5132, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 18, missing),
                new Object[] { getModItem(GregTech.ID, "gt.blockmachines", 1, 5590, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5590, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 19, missing),
                new Object[] { "plateIron", getModItem(Minecraft.ID, "compass", 1, 0, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 20, missing),
                new Object[] { "plateIron", "gemDiamond", "plateIron", "plateRedstone",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32732, missing), "plateRedstone", "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing), "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 40, missing),
                new Object[] { getModItem(Minecraft.ID, "noteblock", 1, 0, missing), "plateRedstone",
                        getModItem(Minecraft.ID, "noteblock", 1, 0, missing),
                        getModItem(Minecraft.ID, "noteblock", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Minecraft.ID, "noteblock", 1, 0, missing), "plateIron",
                        getModItem(Minecraft.ID, "jukebox", 1, 0, missing), "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 75, missing),
                new Object[] { "plateIron", "plateGold", "plateIron", "plateGold",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing), "plateGold",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing), "plateRedstone",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 77, missing),
                new Object[] { "plateIron", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32734, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing), "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 78, missing),
                new Object[] { "plateIron", "plateRedstone", "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Minecraft.ID, "stone_button", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(Minecraft.ID, "stone_button", 1, 0, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 82, missing),
                new Object[] { "plateIron", "plateEnhancedGalgadorian", "plateIron",
                        getModItem(Minecraft.ID, "writable_book", 1, 0, missing),
                        getModItem(EnderIO.ID, "blockEnchanter", 1, 0, missing),
                        getModItem(Minecraft.ID, "writable_book", 1, 0, missing), "plateRedstone",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing), "plateRedstone" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 83, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing), "plateRedstone",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45, missing), "plateGalgadorian",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45, missing),
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 86, missing),
                new Object[] { getModItem(Minecraft.ID, "hay_block", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                        getModItem(Minecraft.ID, "hay_block", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5131, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5131, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 89, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing), "plateRedstone",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing), "plateIron", "plateRedstone",
                        "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing),
                new Object[] { "treeSapling", "treeSapling", "treeSapling", "treeSapling",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "treeSapling", "treeSapling",
                        "treeSapling", "treeSapling" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 94, missing),
                new Object[] { "plateIron", getModItem(Minecraft.ID, "sign", 1, 0, missing), "plateIron",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "plateIron", "plateRedstone",
                        "plateIron" });
        addShapedRecipe(
                getModItem(StevesCarts2.ID, "CartModule", 1, 99, missing),
                new Object[] { null, getModItem(Minecraft.ID, "cake", 1, 0, missing), null,
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "slabWood",
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing), "plateIron", "plateIron",
                        "plateIron" });
        addShapelessCraftingRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 22, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11383, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11383, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 22, missing) });
        addShapelessCraftingRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 47, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11384, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11384, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 47, missing) });
        addShapelessCraftingRecipe(
                getModItem(StevesCarts2.ID, "ModuleComponents", 1, 49, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 11385, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11385, missing),
                new Object[] { getModItem(StevesCarts2.ID, "ModuleComponents", 1, 49, missing) });

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
                getModItem(GregTech.ID, "gt.blockmachines", 1, 1192, missing));
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

        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 9, 46, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 48, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "detector_rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "detector", 1, 9, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "BlockAdvDetector", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(Railcraft.ID, "track", 1, 0, "{track:\"railcraft:track.junction\"}", missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 4, 2000, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "BlockJunction", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 28809, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23383, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 28383, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 23, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23384, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 28384, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 82, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17809, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 37, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17032, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 1, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 38, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17383, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 23, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 39, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17384, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 82, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 81, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 5, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 19, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 20, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 31343, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2383, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 80, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 31343, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2384, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 81, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 7032, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 83, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 31032, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 83, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 84, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32750, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 44, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 44, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 16, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 58, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing)).noFluidInputs()
                .noFluidOutputs().duration(80).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 31, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32, missing)).noFluidInputs()
                .noFluidOutputs().duration(160).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing)).noFluidInputs()
                .noFluidOutputs().duration(160).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 35, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing)).noFluidInputs()
                .noFluidOutputs().duration(320).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 38, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 39, missing)).noFluidInputs()
                .noFluidOutputs().duration(640).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Minecraft.ID, "sapling", 8, 32767, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(BiomesOPlenty.ID, "saplings", 8, 32767, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(BiomesOPlenty.ID, "colorizedSaplings", 8, 32767, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Forestry.ID, "saplingGE", 8, 32767, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(IndustrialCraft2.ID, "blockRubSapling", 8, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Natura.ID, "florasapling", 8, 32767, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Natura.ID, "Rare Sapling", 8, 32767, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(Thaumcraft.ID, "blockCustomPlant", 8, 32767, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing),
                        getModItem(TwilightForest.ID, "tile.TFSapling", 8, 32767, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 17, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 62, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 36)).noFluidOutputs().duration(160).eut(8)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 62, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 63, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 72)).noFluidOutputs().duration(320).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "porkchop", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 21, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "diamond", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 22, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "emerald", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 23, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "slime_ball", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 24, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "glass_bottle", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 51, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "fire_charge", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 52, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "egg", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 53, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "cake", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 90, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(Minecraft.ID, "nether_wart", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 58, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 28, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 88, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "torch", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 29, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22305, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 22032, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 11, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28032, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26032, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 33, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(Minecraft.ID, "dye", 4, 1, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 32415, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(Gendustry.ID, "HoneyDrop", 4, 11, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 4, 14, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(ExtraBees.ID, "misc", 4, 19, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(Botany.ID, "pigment", 4, 59, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(Minecraft.ID, "dye", 4, 2, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(ExtraBees.ID, "misc", 4, 22, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 4, 13, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(Gendustry.ID, "HoneyDrop", 4, 12, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 32416, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(BiomesOPlenty.ID, "misc", 4, 7, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(Botany.ID, "pigment", 4, 28, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(Minecraft.ID, "dye", 4, 4, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(Botany.ID, "pigment", 4, 24, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(ExtraBees.ID, "misc", 4, 21, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(Natura.ID, "barleyFood", 4, 8, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(ProjectRedExploration.ID, "projectred.exploration.lilyseed", 4, 11, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(Gendustry.ID, "HoneyDrop", 4, 14, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 4, 32418, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17811, missing),
                        getModItem(BiomesOPlenty.ID, "misc", 4, 5, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "CartModule", 1, 41, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 16, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 101, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32744, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 9, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 87, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "CartModule", 1, 87, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 16, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 92, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockMachine", 1, 1, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 9, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 91, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "CartModule", 1, 91, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 2, 16, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 93, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 25, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 8, 24, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 28, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32762, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 21, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 26, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32762, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 22, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 26, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32762, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 23, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 26, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32762, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 24, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 26, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 21, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 27, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 22, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 27, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 23, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 27, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(StevesCarts2.ID, "CartModule", 1, 24, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 27, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "gunpowder", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 43, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 7, 0, missing),
                        getModItem(Minecraft.ID, "fermented_spider_eye", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.thaumium", 288)).noFluidOutputs().duration(200)
                .eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "ModuleComponents", 4, 5, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 45, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 36, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(400).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5121, missing),
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 2, 60, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 5, 0, missing),
                        getModItem(StevesCarts2.ID, "ModuleComponents", 1, 9, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 57, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(StevesCarts2.ID, "CartModule", 1, 81, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 129, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "CartModule", 1, 76, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.americium", 1440)).noFluidOutputs().duration(600)
                .eut(30720).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 21, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 22, missing)).noFluidInputs()
                .noFluidOutputs().duration(1000).eut(120).specialValue(1700).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 46, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 12384, missing))
                .fluidInputs(FluidRegistry.getFluidStack("oxygen", 1000)).noFluidOutputs().duration(2000).eut(120)
                .specialValue(2200).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 48, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 12385, missing))
                .fluidInputs(FluidRegistry.getFluidStack("oxygen", 1000)).noFluidOutputs().duration(3000).eut(120)
                .specialValue(3500).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 11, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(120).specialValue(1000).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 34, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 37, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(200).eut(2)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 576)).noFluidOutputs().duration(300).eut(2)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 24, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 864)).noFluidOutputs()
                .duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 24, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 864)).noFluidOutputs().duration(200)
                .eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "diamond", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 2, 18, missing))
                .fluidInputs(FluidRegistry.getFluidStack("obsidian.molten", 1152)).noFluidOutputs().duration(600)
                .eut(30).addTo(sChemicalRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 18809, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 18809, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 18809, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(50).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 6)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 4)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 31, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 30, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(50).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 31, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 8)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 31, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 6)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 32, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 31, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).noFluidOutputs().duration(50).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 18032, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 18032, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 6)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.02", 1, 18032, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 12)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 34, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 35, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 16)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 35, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 12)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 36, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 35, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 4)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 37, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 32)).noFluidOutputs().duration(300).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 37, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 24)).noFluidOutputs().duration(300)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 37, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 8)).noFluidOutputs().duration(150).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 39, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 38, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 64)).noFluidOutputs().duration(300).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 39, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 38, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 48)).noFluidOutputs().duration(300)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 39, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 38, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 16)).noFluidOutputs().duration(150).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 63, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 62, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 16)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 63, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 62, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 12)).noFluidOutputs().duration(200)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 63, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 62, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 4)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 6)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "glass_pane", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "glass_pane", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 6)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "glass_pane", 1, 0, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 62, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 12)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 62, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 8)).noFluidOutputs().duration(200).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 62, missing))
                .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 4, 61, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 2)).noFluidOutputs().duration(100).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 22, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 1, 2383, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);

    }
}
