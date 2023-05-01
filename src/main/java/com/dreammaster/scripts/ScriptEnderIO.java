package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BartWorks;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.FloodLights;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.ProjectRedIllumination;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ScriptEnderIO implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "EnderIO";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                EnderIO.ID,
                AppliedEnergistics2.ID,
                Avaritia.ID,
                Backpack.ID,
                BartWorks.ID,
                BuildCraftFactory.ID,
                DraconicEvolution.ID,
                ExtraUtilities.ID,
                FloodLights.ID,
                GTPlusPlus.ID,
                GraviSuite.ID,
                IndustrialCraft2.ID,
                OpenBlocks.ID,
                ProjectRedIllumination.ID,
                ProjectRedIntegration.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack teleportStaff = getModItem(EnderIO.ID, "itemTeleportStaff", 1);
        ItemStack denseEnergyCell = getModItem(AppliedEnergistics2.ID, "tile.BlockDenseEnergyCell", 1);
        ItemStack energyCell = getModItem(AppliedEnergistics2.ID, "tile.BlockEnergyCell", 1);
        ItemStack staffOfTravelling = getModItem(EnderIO.ID, "itemTravelStaff", 1, wildcard);
        ItemStack endestPearl = getModItem(Avaritia.ID, "Endest_Pearl", 1);
        ItemStack fieldGeneratorZPM = ItemList.Field_Generator_ZPM.get(1);
        ItemStack circuit2 = GT_Utility.getIntegratedCircuit(2);

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                teleportStaff,
                "      aaa",
                "     abca",
                "    abcba",
                "   abcba ",
                "   daba  ",
                "  deda   ",
                " dfd     ",
                "dfd      ",
                " d       ",
                'a',
                "plateDenseObsidian",
                'b',
                denseEnergyCell,
                'c',
                energyCell,
                'd',
                staffOfTravelling,
                'e',
                endestPearl,
                'f',
                fieldGeneratorZPM);
        // ME Conduit
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 4, 16),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L), circuit2 },
                Materials.ConductiveIron.getMolten(144L),
                getModItem(EnderIO.ID, "itemMEConduit", 4),
                200,
                256);
        // ME Dense Conduit
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(EnderIO.ID, "itemMEConduit", 16),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L), circuit2 },
                Materials.EnergeticAlloy.getMolten(144L),
                getModItem(EnderIO.ID, "itemMEConduit", 4, 1),
                200,
                480);
        // ME Ultra Dense Conduit
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(EnderIO.ID, "itemMEConduit", 16, 1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L), circuit2 },
                Materials.VibrantAlloy.getMolten(144L),
                getModItem(EnderIO.ID, "itemMEConduit", 4, 2),
                200,
                960);

        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                createItemStack(
                        EnderIO.ID,
                        "blockCapBank",
                        1,
                        0,
                        "{type:\"CREATIVE\",storedEnergyRF:2500000}",
                        missing),
                "aaaaaaaaa",
                "aabbcbbaa",
                "abadddaba",
                "abdaeadba",
                "acdefedca",
                "abdaeadba",
                "abadddaba",
                "aabbcbbaa",
                "aaaaaaaaa",
                'a',
                createItemStack(
                        EnderIO.ID,
                        "blockCapBank",
                        1,
                        3,
                        "{type:\"VIBRANT\",storedEnergyRF:25000000}",
                        missing),
                'b',
                getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                'c',
                "plateVibrantAlloy",
                'd',
                "plateNeutronium",
                'e',
                createItemStack(DraconicEvolution.ID, "draconiumFluxCapacitor", 1, 0, "{Energy:80000000}", missing),
                'f',
                getModItem(DraconicEvolution.ID, "chaoticCore", 1, 0, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem(EnderIO.ID, "blockTelePad", 9, 0, missing),
                "aaaaaaaaa",
                "abcdddcba",
                "aefcdcfea",
                "acgfhfgca",
                "aijfkfjia",
                "acgflfgca",
                "aefcdcfea",
                "abcdddcba",
                "aaaaaaaaa",
                'a',
                getModItem(EnderIO.ID, "itemMachinePart", 1, 3, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32676, missing),
                'c',
                getModItem(BartWorks.ID, "BW_GlasBlocks", 1, 4, missing),
                'd',
                "plateDenseAmericium",
                'e',
                "plateDenseStellarAlloy",
                'f',
                getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 11, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32607, missing),
                'h',
                getModItem(EnderIO.ID, "itemCoordSelector", 1, 32767, missing),
                'i',
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2, missing),
                'j',
                getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 5, missing),
                'k',
                getModItem(EnderIO.ID, "blockCapBank", 1, 3, missing),
                'l',
                "circuitSuperconductor");

        addShapedRecipe(
                getModItem(EnderIO.ID, "blockStirlingGenerator", 1, 0, missing),
                new Object[] { "itemCasingAnyIron", "circuitBasic", "itemCasingAnyIron", "rotorIron",
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing), "rotorIron",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "craftingIronFurnace",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockCombustionGenerator", 1, 0, missing),
                new Object[] { "itemCasingSteel", "circuitGood", "itemCasingSteel", "rotorSteel",
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing), "rotorSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        getModItem(EnderIO.ID, "blockTank", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockZombieGenerator", 1, 0, missing),
                new Object[] { "itemCasingSteel", "circuitGood", "itemCasingSteel",
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockFrankenzombieGenerator", 1, 0, missing),
                new Object[] { "itemCasingDarkSteel", "circuitAdvanced", "itemCasingDarkSteel",
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 2, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockEnderGenerator", 1, 0, missing),
                new Object[] { "itemCasingEndSteel", "circuitData", "itemCasingEndSteel",
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 3, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32603, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32603, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17366, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17366, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17367, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32750, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17367, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17366, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17366, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17367, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32750, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17367, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 1, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17378, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17378, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17367, missing),
                        getModItem(EnderIO.ID, "blockSolarPanel", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17367, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 1, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17378, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17378, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17367, missing),
                        getModItem(EnderIO.ID, "blockSolarPanel", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17367, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 2, missing),
                new Object[] { "plateEndSteel", getModItem(EnderIO.ID, "blockFusedQuartz", 1, 2, missing),
                        "plateEndSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 17367, missing),
                        getModItem(EnderIO.ID, "blockSolarPanel", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17367, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 2, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSolarPanel", 1, 2, missing),
                new Object[] { "plateEndSteel", getModItem(EnderIO.ID, "blockFusedQuartz", 1, 2, missing),
                        "plateEndSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 17367, missing),
                        getModItem(EnderIO.ID, "blockSolarPanel", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17367, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 2, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSagMill", 1, 0, missing),
                new Object[] { "itemCasingSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing),
                        "itemCasingSteel", "circuitBasic", getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        "circuitBasic", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32721, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockAlloySmelter", 1, 0, missing),
                new Object[] { "circuitBasic", "craftingIronFurnace", "circuitBasic", "craftingIronFurnace",
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing), "craftingIronFurnace",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing),
                        getModItem(Minecraft.ID, "cauldron", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing) });
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}", missing),
                new Object[] { getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing), "circuitBasic",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing), "plateRedstone",
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing), "plateRedstone",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32527, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing) });
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}", missing),
                new Object[] { getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing), "circuitBasic",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing), "plateRedstone",
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing), "plateRedstone",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32527, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing) });
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 2, "{type:\"ACTIVATED\",storedEnergyRF:0}", missing),
                new Object[] { getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1, missing), "circuitGood",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17366, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17366, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32537, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1, missing) });
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 2, "{type:\"ACTIVATED\",storedEnergyRF:0}", missing),
                new Object[] { getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8, missing), "circuitGood",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17366, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17366, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32537, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8, missing) });
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}", missing),
                new Object[] { getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing), "circuitAdvanced",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32540, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing) });
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}", missing),
                new Object[] { getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing), "circuitAdvanced",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing),
                        getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1, 32054, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing) });
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}", missing),
                new Object[] { getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing), "circuitAdvanced",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32540, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing) });
        addShapedRecipe(
                createItemStack(EnderIO.ID, "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}", missing),
                new Object[] { getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing), "circuitAdvanced",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing),
                        getModItem(GTPlusPlus.ID, "MU-metaitem.01", 1, 32054, missing),
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockPainter", 1, 0, missing),
                new Object[] { "itemCasingSteel", "rotorSteel", "itemCasingSteel", "circuitBasic",
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing), "circuitBasic",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "rotorSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing),
                new Object[] { "itemCasingSteel", getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        "itemCasingSteel", "circuitBasic", getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        "circuitBasic", "itemCasingSteel", getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        "itemCasingSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                new Object[] { "itemCasingSteel", "plateElectricalSteel", "itemCasingSteel", "plateElectricalSteel",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing), "plateElectricalSteel",
                        "itemCasingSteel", "plateElectricalSteel", "itemCasingSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                new Object[] { "itemCasingSteel", "plateElectricalSteel", "itemCasingSteel", "plateElectricalSteel",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing), "plateElectricalSteel",
                        "itemCasingSteel", "plateElectricalSteel", "itemCasingSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 2, missing),
                new Object[] { "itemCasingSoularium", "plateSoularium", "itemCasingSoularium", "plateSoularium",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 1, missing), "plateSoularium",
                        "itemCasingSoularium", "plateSoularium", "itemCasingSoularium" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 2, missing),
                new Object[] { "itemCasingSoularium", "plateSoularium", "itemCasingSoularium", "plateSoularium",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 8, missing), "plateSoularium",
                        "itemCasingSoularium", "plateSoularium", "itemCasingSoularium" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 3, missing),
                new Object[] { "itemCasingEndSteel", "plateEndSteel", "itemCasingEndSteel", "plateEndSteel",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing), "plateEndSteel",
                        "itemCasingEndSteel", "plateEndSteel", "itemCasingEndSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMachinePart", 1, 3, missing),
                new Object[] { "itemCasingEndSteel", "plateEndSteel", "itemCasingEndSteel", "plateEndSteel",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing), "plateEndSteel",
                        "itemCasingEndSteel", "plateEndSteel", "itemCasingEndSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockVat", 1, 0, missing),
                new Object[] { "itemCasingSteel", getModItem(Minecraft.ID, "cauldron", 1, 0, missing),
                        "itemCasingSteel", getModItem(EnderIO.ID, "blockTank", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "blockTank", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "craftingIronFurnace",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockPowerMonitor", 1, 0, missing),
                new Object[] { "plateElectricalSteel", getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        "plateElectricalSteel", "circuitBasic",
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing), "circuitBasic",
                        getModItem(EnderIO.ID, "itemPowerConduit", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemConduitProbe", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemPowerConduit", 1, 0, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockFarmStation", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing), "plateDensePulsatingIron",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing), "gearElectricalSteel",
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing), "gearElectricalSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockWirelessCharger", 1, 0, missing),
                new Object[] { "plateElectricalSteel", getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 2, missing),
                        "plateElectricalSteel", "circuitAdvanced",
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing), "circuitAdvanced",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockWirelessCharger", 1, 0, missing),
                new Object[] { "plateElectricalSteel", getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 9, missing),
                        "plateElectricalSteel", "circuitAdvanced",
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing), "circuitAdvanced",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockTank", 1, 0, missing),
                new Object[] { "itemCasingSteel", getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                        "itemCasingSteel", getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4461, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing), "itemCasingSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing), "itemCasingSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockTank", 1, 1, missing),
                new Object[] { "plateDarkSteel", getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                        "plateDarkSteel", getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4460, missing),
                        getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing), "plateDarkSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32611, missing), "plateDarkSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockReservoir", 2, 0, missing),
                new Object[] { getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(Minecraft.ID, "cauldron", 1, 0, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32612, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockTransceiver", 1, 0, missing),
                new Object[] { getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 3, missing), "circuitMaster",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 3, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing), "frameGtEnderium",
                        getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockBuffer", 1, 0, missing),
                new Object[] { "plateElectricalSteel", "chestWood", "plateElectricalSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32630, missing), "frameGtDarkSteel",
                        "circuitBasic" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockBuffer", 1, 1, missing),
                new Object[] { "plateElectricalSteel", getModItem(EnderIO.ID, "itemPowerConduit", 1, 0, missing),
                        "plateElectricalSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32519, missing),
                        "frameGtDarkSteel", "circuitBasic" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockInventoryPanel", 1, 0, missing),
                new Object[] { "plateDarkSteel", getModItem(EnderIO.ID, "itemFunctionUpgrade", 1, 0, missing),
                        "plateDarkSteel", getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing), "plateDarkSteel",
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing), "plateDarkSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 0, missing),
                new Object[] { "screwElectricalSteel", "plateElectricalSteel", "screwElectricalSteel",
                        "plateElectricalSteel", "ringElectricalSteel", "plateElectricalSteel", "screwElectricalSteel",
                        "plateElectricalSteel", "screwElectricalSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 1, missing),
                new Object[] { "screwEnergeticAlloy", "plateEnergeticAlloy", "screwEnergeticAlloy",
                        "plateEnergeticAlloy", "ringEnergeticAlloy", "plateEnergeticAlloy", "screwEnergeticAlloy",
                        "plateEnergeticAlloy", "screwEnergeticAlloy" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 2, missing),
                new Object[] { "screwVibrantAlloy", "plateVibrantAlloy", "screwVibrantAlloy", "plateVibrantAlloy",
                        "ringVibrantAlloy", "plateVibrantAlloy", "screwVibrantAlloy", "plateVibrantAlloy",
                        "screwVibrantAlloy" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 3, missing),
                new Object[] { "screwRedstoneAlloy", "plateRedstoneAlloy", "screwRedstoneAlloy", "plateRedstoneAlloy",
                        "ringRedstoneAlloy", "plateRedstoneAlloy", "screwRedstoneAlloy", "plateRedstoneAlloy",
                        "screwRedstoneAlloy" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 4, missing),
                new Object[] { "screwConductiveIron", "plateConductiveIron", "screwConductiveIron",
                        "plateConductiveIron", "ringConductiveIron", "plateConductiveIron", "screwConductiveIron",
                        "plateConductiveIron", "screwConductiveIron" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 5, missing),
                new Object[] { "screwPulsatingIron", "platePulsatingIron", "screwPulsatingIron", "platePulsatingIron",
                        "ringPulsatingIron", "platePulsatingIron", "screwPulsatingIron", "platePulsatingIron",
                        "screwPulsatingIron" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 6, missing),
                new Object[] { "screwDarkSteel", "plateDarkSteel", "screwDarkSteel", "plateDarkSteel", "ringDarkSteel",
                        "plateDarkSteel", "screwDarkSteel", "plateDarkSteel", "screwDarkSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 7, missing),
                new Object[] { "screwSoularium", "plateSoularium", "screwSoularium", "plateSoularium", "ringSoularium",
                        "plateSoularium", "screwSoularium", "plateSoularium", "screwSoularium" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBall", 4, 8, missing),
                new Object[] { "screwEndSteel", "plateEndSteel", "screwEndSteel", "plateEndSteel", "ringEndSteel",
                        "plateEndSteel", "screwEndSteel", "plateEndSteel", "screwEndSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 0, missing),
                new Object[] { "screwCrudeSteel", "plateCrudeSteel", "screwCrudeSteel", "plateCrudeSteel",
                        "ringCrudeSteel", "plateCrudeSteel", "screwCrudeSteel", "plateCrudeSteel", "screwCrudeSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 1, missing),
                new Object[] { "screwCrystallineAlloy", "plateCrystallineAlloy", "screwCrystallineAlloy",
                        "plateCrystallineAlloy", "ringCrystallineAlloy", "plateCrystallineAlloy",
                        "screwCrystallineAlloy", "plateCrystallineAlloy", "screwCrystallineAlloy" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 2, missing),
                new Object[] { "screwMelodicAlloy", "plateMelodicAlloy", "screwMelodicAlloy", "plateMelodicAlloy",
                        "ringMelodicAlloy", "plateMelodicAlloy", "screwMelodicAlloy", "plateMelodicAlloy",
                        "screwMelodicAlloy" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 3, missing),
                new Object[] { "screwStellarAlloy", "plateStellarAlloy", "screwStellarAlloy", "plateStellarAlloy",
                        "ringStellarAlloy", "plateStellarAlloy", "screwStellarAlloy", "plateStellarAlloy",
                        "screwStellarAlloy" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 4, missing),
                new Object[] { "screwCrystallinePinkSlime", "plateCrystallinePinkSlime", "screwCrystallinePinkSlime",
                        "plateCrystallinePinkSlime", "ringCrystallinePinkSlime", "plateCrystallinePinkSlime",
                        "screwCrystallinePinkSlime", "plateCrystallinePinkSlime", "screwCrystallinePinkSlime" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 5, missing),
                new Object[] { "screwEnergeticSilver", "plateEnergeticSilver", "screwEnergeticSilver",
                        "plateEnergeticSilver", "ringEnergeticSilver", "plateEnergeticSilver", "screwEnergeticSilver",
                        "plateEnergeticSilver", "screwEnergeticSilver" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGrindingBallEndergy", 4, 6, missing),
                new Object[] { "screwVividAlloy", "plateVividAlloy", "screwVividAlloy", "plateVividAlloy",
                        "ringVividAlloy", "plateVividAlloy", "screwVividAlloy", "plateVividAlloy", "screwVividAlloy" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockEnderIo", 1, 0, missing),
                new Object[] { "plateElectricalSteel", getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        "plateElectricalSteel", getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        "lensEnderEye", getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        "plateElectricalSteel", getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        "plateElectricalSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockTravelAnchor", 1, 0, missing),
                new Object[] { "plateElectricalSteel", getModItem(OpenBlocks.ID, "elevator", 1, 0, missing),
                        "plateElectricalSteel", getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing), "plateElectricalSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32670, missing), "plateElectricalSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSliceAndSplice", 1, 0, missing),
                new Object[] { "plateSoularium", getModItem(Minecraft.ID, "shears", 1, 0, missing), "plateSoularium",
                        "circuitGood", getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing), "circuitGood",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        getModItem(Minecraft.ID, "iron_axe", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSoulBinder", 1, 0, missing),
                new Object[] { "plateSoularium", getModItem(EnderIO.ID, "itemFrankenSkull", 1, 3, missing),
                        "plateSoularium", "circuitAdvanced", getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        "circuitAdvanced", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockPoweredSpawner", 1, 0, missing),
                new Object[] { "plateDarkSteel", "itemSkull", "plateDarkSteel", "plateSoularium",
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing), "plateSoularium",
                        getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 2, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockKillerJoe", 1, 0, missing),
                new Object[] { "itemCasingAluminium", "circuitGood", "itemCasingAluminium",
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockAttractor", 1, 0, missing),
                new Object[] { null, getModItem(EnderIO.ID, "itemMaterial", 1, 9, missing), null,
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17366, missing), "plateSoularium",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17366, missing), "plateSoularium",
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing), "plateSoularium" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSpawnGuard", 1, 0, missing),
                new Object[] { null, getModItem(EnderIO.ID, "blockEndermanSkull", 1, 2, missing), null,
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17366, missing), "plateSoularium",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17366, missing), "plateSoularium",
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing), "plateSoularium" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockExperienceObelisk", 1, 0, missing),
                new Object[] { null, getModItem(EnderIO.ID, "itemXpTransfer", 1, 0, missing), null,
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17366, missing), "plateSoularium",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17366, missing), "plateSoularium",
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing), "plateSoularium" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockWeatherObelisk", 1, 0, missing),
                new Object[] { null, getModItem(EnderIO.ID, "itemMaterial", 1, 10, missing), null, "bucketLava",
                        "plateSoularium", "bucketWater", "plateSoularium",
                        getModItem(EnderIO.ID, "blockCapBank", 1, 2, missing), "plateSoularium" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockEnchanter", 1, 0, missing),
                new Object[] { getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing), "craftingBook",
                        getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing), null, "plateDarkSteel", null,
                        "plateDarkSteel", getModItem(Minecraft.ID, "enchanting_table", 1, 0, missing),
                        "plateDarkSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockDarkIronBars", 3, 0, missing),
                new Object[] { null, "craftingToolHardHammer", null,
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23364, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23364, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23364, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23364, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23364, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23364, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockSoulariumBars", 3, 0, missing),
                new Object[] { null, "craftingToolHardHammer", null,
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23379, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23379, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23379, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23379, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23379, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23379, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockEndSteelBars", 3, 0, missing),
                new Object[] { null, "craftingToolHardHammer", null,
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23401, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23401, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23401, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23401, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23401, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23401, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockDarkSteelLadder", 1, 0, missing),
                new Object[] { getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing), "wireFineSteel", "screwSteel",
                        "wireFineSteel", getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                        "craftingToolWrench", getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockElectricLight", 8, 0, missing),
                new Object[] { getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing), "plateSiliconSolarGrade",
                        getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing),
                        "plateSiliconSolarGrade", "circuitBasic",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing), "circuitBasic" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockElectricLight", 8, 0, missing),
                new Object[] { getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing), "plateSiliconSolarGrade",
                        getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing),
                        "plateSiliconSolarGrade", "circuitBasic",
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing), "circuitBasic" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockElectricLight", 16, 2, missing),
                new Object[] { getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing),
                        getModItem(EnderIO.ID, "blockFusedQuartz", 1, 0, missing), "plateSiliconSolarGrade",
                        getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 0, missing),
                        "plateSiliconSolarGrade", "plateIron", "wireGt01RedAlloy", "plateIron" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "blockReinforcedObsidian", 1, 0, missing),
                new Object[] { "plateDarkSteel", getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                        "plateDarkSteel", getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing), "blockObsidian",
                        getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing), "plateDarkSteel",
                        getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing), "plateDarkSteel" });
        addShapedRecipe(
                createItemStack(EnderIO.ID, "itemCoordSelector", 1, 0, "{bc:x:0,default:1b,bc:y:0,bc:z:0}", missing),
                new Object[] { "plateElectricalSteel", "gemEnderEye", "plateElectricalSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17378, missing),
                        getModItem(Minecraft.ID, "compass", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17378, missing), "plateElectricalSteel",
                        "gemEnderEye", "plateElectricalSteel" });
        addShapelessCraftingRecipe(
                getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 0, missing),
                new Object[] { getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 1, missing) });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemFunctionUpgrade", 1, 0, missing),
                new Object[] { "plateSiliconSolarGrade", getModItem(EnderIO.ID, "itemMaterial", 1, 1, missing),
                        "plateSiliconSolarGrade", "circuitAdvanced", "gemEnderEye", "circuitAdvanced",
                        "plateSiliconSolarGrade", "plateElectricalSteel", "plateSiliconSolarGrade" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemYetaWrench", 1, 0, missing),
                new Object[] { "ingotElectricalSteel", "craftingToolHardHammer", "ingotElectricalSteel",
                        "ingotElectricalSteel", "gearElectricalSteel", "ingotElectricalSteel", null,
                        "ingotElectricalSteel", null });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemConduitProbe", 1, 0, missing),
                new Object[] { "plateSiliconSolarGrade", getModItem(EnderIO.ID, "itemPowerConduit", 1, 0, missing),
                        "plateSiliconSolarGrade", "circuitBasic",
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing),
                        "circuitBasic", "plateElectricalSteel",
                        getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 2, missing), "plateElectricalSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemTravelStaff", 1, 16, missing),
                new Object[] { "craftingToolScrewdriver", "circuitAdvanced",
                        getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing), "screwVibrantAlloy", "stickDarkSteel",
                        "circuitAdvanced", "stickDarkSteel", "screwVibrantAlloy", "craftingToolWrench" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemXpTransfer", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", "circuitAdvanced",
                        getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing), "screwEnergeticAlloy", "stickSoularium",
                        "circuitAdvanced", "stickSoularium", "screwEnergeticAlloy", "craftingToolWrench" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGliderWing", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "stickDarkSteel", "itemLeather", "stickDarkSteel",
                        getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "itemLeather", "itemLeather",
                        "itemLeather", "itemLeather" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemGliderWing", 1, 1, missing),
                new Object[] { "screwDarkSteel", "stickDarkSteel", "screwDarkSteel",
                        getModItem(EnderIO.ID, "itemGliderWing", 1, 0, missing), "plateDarkSteel",
                        getModItem(EnderIO.ID, "itemGliderWing", 1, 0, missing), "craftingToolWrench", "stickDarkSteel",
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMagnet", 1, 16, missing),
                new Object[] { "plateElectricalSteel", "plateConductiveIron", "plateConductiveIron",
                        "craftingToolWrench", "screwSteelMagnetic",
                        getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing), "plateElectricalSteel",
                        "plateConductiveIron", "plateConductiveIron" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_helmet", 1, 0, missing),
                new Object[] { "plateEndSteel", "plateEndSteel", "plateEndSteel", "plateEndSteel",
                        "craftingToolHardHammer", "plateEndSteel", null,
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 6, missing), null });
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_chestplate", 1, 0, missing),
                new Object[] { "plateEndSteel", "craftingToolHardHammer", "plateEndSteel", "plateEndSteel",
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 6, missing), "plateEndSteel", "plateEndSteel",
                        "plateEndSteel", "plateEndSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_leggings", 1, 0, missing),
                new Object[] { "plateEndSteel", "plateEndSteel", "plateEndSteel", "plateEndSteel",
                        "craftingToolHardHammer", "plateEndSteel", "plateEndSteel",
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 6, missing), "plateEndSteel" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_boots", 1, 0, missing),
                new Object[] { "plateEndSteel", getModItem(EnderIO.ID, "itemFrankenSkull", 1, 6, missing),
                        "plateEndSteel", "plateEndSteel", "craftingToolHardHammer", "plateEndSteel", null, null,
                        null });
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_helmet", 1, 0, missing),
                new Object[] { "plateStellarAlloy", "plateStellarAlloy", "plateStellarAlloy", "plateStellarAlloy",
                        "craftingToolHardHammer", "plateStellarAlloy", null,
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4, missing), null });
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_chestplate", 1, 0, missing),
                new Object[] { "plateStellarAlloy", "craftingToolHardHammer", "plateStellarAlloy", "plateStellarAlloy",
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4, missing), "plateStellarAlloy",
                        "plateStellarAlloy", "plateStellarAlloy", "plateStellarAlloy" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_leggings", 1, 0, missing),
                new Object[] { "plateStellarAlloy", "plateStellarAlloy", "plateStellarAlloy", "plateStellarAlloy",
                        "craftingToolHardHammer", "plateStellarAlloy", "plateStellarAlloy",
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4, missing), "plateStellarAlloy" });
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_boots", 1, 0, missing),
                new Object[] { "plateStellarAlloy", getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4, missing),
                        "plateStellarAlloy", "plateStellarAlloy", "craftingToolHardHammer", "plateStellarAlloy", null,
                        null, null });
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_pickaxe", 1, 0, missing),
                new Object[] { "plateEndSteel", "ingotEndSteel", "ingotEndSteel", "craftingToolFile",
                        getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing), "craftingToolHardHammer", null,
                        getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing), null });
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_axe", 1, 0, missing),
                new Object[] { "plateEndSteel", "ingotEndSteel", "craftingToolHardHammer", "plateEndSteel",
                        getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing), "plateEndSteel", "craftingToolFile",
                        getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing), null });
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.endSteel_sword", 1, 0, missing),
                new Object[] { null, "plateEndSteel", null, "craftingToolFile", "plateEndSteel",
                        "craftingToolHardHammer", null, getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing), null });
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_pickaxe", 1, 0, missing),
                new Object[] { "plateStellarAlloy", "ingotStellarAlloy", "ingotStellarAlloy", "craftingToolFile",
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4, missing), "craftingToolHardHammer", null,
                        getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing), null });
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_axe", 1, 0, missing),
                new Object[] { "plateStellarAlloy", "ingotStellarAlloy", "craftingToolHardHammer", "plateStellarAlloy",
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4, missing), "plateStellarAlloy",
                        "craftingToolFile", getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing), null });
        addShapedRecipe(
                getModItem(EnderIO.ID, "item.stellar_sword", 1, 0, missing),
                new Object[] { null, getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4, missing), null,
                        "craftingToolFile", "plateStellarAlloy", "craftingToolHardHammer", null,
                        getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing), null });
        addShapedRecipe(
                getModItem(EnderIO.ID, "itemMaterial", 1, 12, missing),
                new Object[] { "craftingToolScrewdriver", "screwEndSteel", "stickDarkSteel", "screwEndSteel",
                        "stickDarkSteel", "screwEndSteel", "stickDarkSteel", "screwEndSteel",
                        "craftingToolHardHammer" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 9231, missing),
                        getModItem(ExtraUtilities.ID, "enderCollector", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockVacuumChest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockBuffer", 1, 0, missing),
                        getModItem(EnderIO.ID, "blockBuffer", 1, 1, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockBuffer", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "diamond", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 9378, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "emerald", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 9367, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17365, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17366, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17367, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17381, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17369, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17378, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17364, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17379, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 7, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17401, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 8, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17401, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBall", 1, 9, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17402, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17403, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17404, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17405, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17406, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17407, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 5, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17408, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemGrindingBallEndergy", 1, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.ManyullynCrystal", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 8, 9321, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 1, 10, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "heavy_weighted_pressure_plate", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17364, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockDarkSteelPressurePlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockDarkSteelPressurePlate", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockRubber", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockDarkSteelPressurePlate", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockDarkIronBars", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockDarkSteelLadder", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(96).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 23364, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockDarkIronBars", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 23379, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockSoulariumBars", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 23401, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockEndSteelBars", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockElectricLight", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockElectricLight", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockElectricLight", 1, 2, missing),
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockElectricLight", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockElectricLight", 16, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 3, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockElectricLight", 16, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockElectricLight", 1, 4, missing),
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockElectricLight", 1, 5, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 4905, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 4, 1, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemFusedQuartzFrame", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemMaterial", 8, 1, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemConduitFacade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 2, 1, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 2, missing),
                        getModItem(Minecraft.ID, "lever", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 2000, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17381, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 2000, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17381, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemRedstoneConduit", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 1420, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17369, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduit", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 1580, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17366, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduit", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 1620, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17367, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduit", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.epoxid", 144)).noFluidOutputs().duration(100).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 2000, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17402, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).noFluidOutputs().duration(100).eut(8)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 1260, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17032, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).noFluidOutputs().duration(100).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 1280, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17019, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).noFluidOutputs().duration(100).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 1320, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17086, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144)).noFluidOutputs().duration(100)
                .eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 1380, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17035, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144)).noFluidOutputs().duration(100)
                .eut(96).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 1440, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17054, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(160)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 1540, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17303, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(192)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 1660, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17407, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.epoxid", 144)).noFluidOutputs().duration(100).eut(320)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 1700, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17403, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.epoxid", 144)).noFluidOutputs().duration(100).eut(960)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 1720, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17406, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144)).noFluidOutputs()
                .duration(100).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 1780, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17404, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144)).noFluidOutputs()
                .duration(100).eut(7680).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 11390, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17405, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerConduitEndergy", 1, 11, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polybenzimidazole", 144)).noFluidOutputs()
                .duration(100).eut(30720).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5112, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17365, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5132, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17364, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5680, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17367, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5682, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17403, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.epoxid", 144)).noFluidOutputs().duration(100).eut(960)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5682, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17406, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144)).noFluidOutputs()
                .duration(100).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5282, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17404, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144)).noFluidOutputs()
                .duration(100).eut(7680).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5282, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17405, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemLiquidConduit", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polybenzimidazole", 144)).noFluidOutputs()
                .duration(100).eut(30720).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 5611, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17378, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemItemConduit", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 16, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17381, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemOCConduit", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 2, 1, missing),
                        getModItem(EnderIO.ID, "blockEndSteelBars", 2, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemBigFilterUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBigFilterUpgrade", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 2, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemBigFilterUpgrade", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 1, missing),
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemExistingItemFilter", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemYetaWrench", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemModItemFilter", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemConduitProbe", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemPowerItemFilter", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicFilterUpgrade", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32640, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemExtractSpeedUpgrade", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 144)).noFluidOutputs().duration(300).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "blockFusedQuartz", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 25379, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemSoulVessel", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(48).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 18305, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32701, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 18305, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32078, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 18305, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing),
                        getModItem(EnderIO.ID, "itemFrankenSkull", 1, 1, missing),
                        getModItem(BartWorks.ID, "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 18305, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockCrafter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17365, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemPlateElectricalSteel", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17365, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 18305, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 0, missing),
                        getModItem(GTPlusPlus.ID, "itemPlateElectricalSteel", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 18305, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17365, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing),
                        getModItem(GTPlusPlus.ID, "itemPlateElectricalSteel", 2, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17365, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 18305, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(EnderIO.ID, "itemBasicCapacitor", 1, 7, missing),
                        getModItem(GTPlusPlus.ID, "itemPlateElectricalSteel", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 18305, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemMachinePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17364, missing),
                        getModItem(EnderIO.ID, "blockDarkIronBars", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 17, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockReinforcedObsidian", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemConduitFacade", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemConduitFacade", 1, 1, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("obsidian.molten", 576)).noFluidOutputs().duration(200).eut(2)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 2, missing))
                .itemOutputs(
                        getModItem(EnderIO.ID, "itemMaterial", 2, 1, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 2, 1, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 1, missing))
                .outputChances(10000, 9000, 5000).fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GregTech.ID, "gt.metaitem.01", 0, 32314, missing))
                .itemOutputs(getModItem(EnderIO.ID, "blockDarkSteelAnvil", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.darksteel", 4464)).noFluidOutputs().duration(900)
                .eut(120).addTo(sFluidSolidficationRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemPartCFPowder", 1, 0, missing))
                .itemOutputs(getModItem(EnderIO.ID, "itemMaterial", 9, 2, missing)).outputChances(10000).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 5, missing))
                .itemOutputs(
                        getModItem(EnderIO.ID, "itemMaterial", 1, 14, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 14, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 14, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 14, missing))
                .outputChances(10000, 1000, 100, 10).noFluidInputs().noFluidOutputs().duration(100).eut(480)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 6, missing))
                .itemOutputs(
                        getModItem(EnderIO.ID, "itemMaterial", 1, 15, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 15, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 15, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 15, missing))
                .outputChances(10000, 1000, 100, 10).noFluidInputs().noFluidOutputs().duration(300).eut(480)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 8, missing))
                .itemOutputs(
                        getModItem(EnderIO.ID, "itemMaterial", 1, 16, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 16, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 16, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 16, missing))
                .outputChances(10000, 1000, 100, 10).noFluidInputs().noFluidOutputs().duration(300).eut(480)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 13, missing))
                .itemOutputs(
                        getModItem(EnderIO.ID, "itemMaterial", 1, 17, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 17, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 17, missing),
                        getModItem(EnderIO.ID, "itemMaterial", 1, 17, missing))
                .outputChances(10000, 1000, 100, 10).noFluidInputs().noFluidOutputs().duration(300).eut(480)
                .addTo(sMaceratorRecipes);

    }
}
