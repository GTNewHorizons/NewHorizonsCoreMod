package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

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
        return Arrays.asList(EnderIO.ID, AppliedEnergistics2.ID, Avaritia.ID);
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
                createItemStack("EnderIO", "blockCapBank", 1, 0, "{type:\"CREATIVE\",storedEnergyRF:2500000}", missing),
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
                createItemStack("EnderIO", "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:25000000}", missing),
                'b',
                getModItem("EnderIO", "itemMaterial", 1, 6, missing),
                'c',
                "plateVibrantAlloy",
                'd',
                "plateNeutronium",
                'e',
                createItemStack("DraconicEvolution", "draconiumFluxCapacitor", 1, 0, "{Energy:80000000}", missing),
                'f',
                getModItem("DraconicEvolution", "chaoticCore", 1, 0, missing));
        ExtremeCraftingManager.getInstance().addExtremeShapedOreRecipe(
                getModItem("EnderIO", "blockTelePad", 9, 0, missing),
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
                getModItem("EnderIO", "itemMachinePart", 1, 3, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 32676, missing),
                'c',
                getModItem("bartworks", "BW_GlasBlocks", 1, 4, missing),
                'd',
                "plateDenseAmericium",
                'e',
                "plateDenseStellarAlloy",
                'f',
                getModItem("EnderIO", "itemPowerConduitEndergy", 1, 11, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 32607, missing),
                'h',
                getModItem("EnderIO", "itemCoordSelector", 1, 32767, missing),
                'i',
                getModItem("GraviSuite", "itemSimpleItem", 1, 2, missing),
                'j',
                getModItem("EnderIO", "itemBasicCapacitor", 1, 5, missing),
                'k',
                getModItem("EnderIO", "blockCapBank", 1, 3, missing),
                'l',
                "circuitSuperconductor");

        addShapedRecipe(
                getModItem("EnderIO", "blockStirlingGenerator", 1, 0, missing),
                new Object[] { "itemCasingAnyIron", "circuitBasic", "itemCasingAnyIron", "rotorIron",
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing), "rotorIron",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "craftingIronFurnace",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockCombustionGenerator", 1, 0, missing),
                new Object[] { "itemCasingSteel", "circuitGood", "itemCasingSteel", "rotorSteel",
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing), "rotorSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        getModItem("EnderIO", "blockTank", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockZombieGenerator", 1, 0, missing),
                new Object[] { "itemCasingSteel", "circuitGood", "itemCasingSteel",
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockFrankenzombieGenerator", 1, 0, missing),
                new Object[] { "itemCasingDarkSteel", "circuitAdvanced", "itemCasingDarkSteel",
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 2, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockEnderGenerator", 1, 0, missing),
                new Object[] { "itemCasingEndSteel", "circuitData", "itemCasingEndSteel",
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 3, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32603, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32603, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockSolarPanel", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17366, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17366, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32750, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 0, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 0, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockSolarPanel", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17366, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17366, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32750, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 7, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 7, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockSolarPanel", 1, 1, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17378, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17378, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing),
                        getModItem("EnderIO", "blockSolarPanel", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 1, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 1, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockSolarPanel", 1, 1, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17378, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17378, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing),
                        getModItem("EnderIO", "blockSolarPanel", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 8, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 8, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockSolarPanel", 1, 2, missing),
                new Object[] { "plateEndSteel", getModItem("EnderIO", "blockFusedQuartz", 1, 2, missing),
                        "plateEndSteel", getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing),
                        getModItem("EnderIO", "blockSolarPanel", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 2, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 2, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 2, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockSolarPanel", 1, 2, missing),
                new Object[] { "plateEndSteel", getModItem("EnderIO", "blockFusedQuartz", 1, 2, missing),
                        "plateEndSteel", getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing),
                        getModItem("EnderIO", "blockSolarPanel", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 9, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 2, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 9, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockSagMill", 1, 0, missing),
                new Object[] { "itemCasingSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                        "itemCasingSteel", "circuitBasic", getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        "circuitBasic", getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32721, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockAlloySmelter", 1, 0, missing),
                new Object[] { "circuitBasic", "craftingIronFurnace", "circuitBasic", "craftingIronFurnace",
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing), "craftingIronFurnace",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing),
                        getModItem("minecraft", "cauldron", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing) });
        addShapedRecipe(
                createItemStack("EnderIO", "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}", missing),
                new Object[] { getModItem("EnderIO", "itemBasicCapacitor", 1, 0, missing), "circuitBasic",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 0, missing), "plateRedstone",
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing), "plateRedstone",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32527, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 0, missing) });
        addShapedRecipe(
                createItemStack("EnderIO", "blockCapBank", 1, 1, "{type:\"SIMPLE\",storedEnergyRF:0}", missing),
                new Object[] { getModItem("EnderIO", "itemBasicCapacitor", 1, 7, missing), "circuitBasic",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 7, missing), "plateRedstone",
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing), "plateRedstone",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32527, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 7, missing) });
        addShapedRecipe(
                createItemStack("EnderIO", "blockCapBank", 1, 2, "{type:\"ACTIVATED\",storedEnergyRF:0}", missing),
                new Object[] { getModItem("EnderIO", "itemBasicCapacitor", 1, 1, missing), "circuitGood",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17366, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17366, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32537, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 1, missing) });
        addShapedRecipe(
                createItemStack("EnderIO", "blockCapBank", 1, 2, "{type:\"ACTIVATED\",storedEnergyRF:0}", missing),
                new Object[] { getModItem("EnderIO", "itemBasicCapacitor", 1, 8, missing), "circuitGood",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17366, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17366, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32537, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 8, missing) });
        addShapedRecipe(
                createItemStack("EnderIO", "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}", missing),
                new Object[] { getModItem("EnderIO", "itemBasicCapacitor", 1, 2, missing), "circuitAdvanced",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 2, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 6, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 6, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32540, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 2, missing) });
        addShapedRecipe(
                createItemStack("EnderIO", "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}", missing),
                new Object[] { getModItem("EnderIO", "itemBasicCapacitor", 1, 2, missing), "circuitAdvanced",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 2, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 6, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 6, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 2, missing),
                        getModItem("miscutils", "MU-metaitem.01", 1, 32054, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 2, missing) });
        addShapedRecipe(
                createItemStack("EnderIO", "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}", missing),
                new Object[] { getModItem("EnderIO", "itemBasicCapacitor", 1, 9, missing), "circuitAdvanced",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 9, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 6, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 6, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32540, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 9, missing) });
        addShapedRecipe(
                createItemStack("EnderIO", "blockCapBank", 1, 3, "{type:\"VIBRANT\",storedEnergyRF:0}", missing),
                new Object[] { getModItem("EnderIO", "itemBasicCapacitor", 1, 9, missing), "circuitAdvanced",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 9, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 6, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 6, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 9, missing),
                        getModItem("miscutils", "MU-metaitem.01", 1, 32054, missing),
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 9, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockPainter", 1, 0, missing),
                new Object[] { "itemCasingSteel", "rotorSteel", "itemCasingSteel", "circuitBasic",
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing), "circuitBasic",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "rotorSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockCrafter", 1, 0, missing),
                new Object[] { "itemCasingSteel", getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing),
                        "itemCasingSteel", "circuitBasic", getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        "circuitBasic", "itemCasingSteel", getModItem("EnderIO", "itemFrankenSkull", 1, 1, missing),
                        "itemCasingSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                new Object[] { "itemCasingSteel", "plateElectricalSteel", "itemCasingSteel", "plateElectricalSteel",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 0, missing), "plateElectricalSteel",
                        "itemCasingSteel", "plateElectricalSteel", "itemCasingSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                new Object[] { "itemCasingSteel", "plateElectricalSteel", "itemCasingSteel", "plateElectricalSteel",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 7, missing), "plateElectricalSteel",
                        "itemCasingSteel", "plateElectricalSteel", "itemCasingSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "itemMachinePart", 1, 2, missing),
                new Object[] { "itemCasingSoularium", "plateSoularium", "itemCasingSoularium", "plateSoularium",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 1, missing), "plateSoularium",
                        "itemCasingSoularium", "plateSoularium", "itemCasingSoularium" });
        addShapedRecipe(
                getModItem("EnderIO", "itemMachinePart", 1, 2, missing),
                new Object[] { "itemCasingSoularium", "plateSoularium", "itemCasingSoularium", "plateSoularium",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 8, missing), "plateSoularium",
                        "itemCasingSoularium", "plateSoularium", "itemCasingSoularium" });
        addShapedRecipe(
                getModItem("EnderIO", "itemMachinePart", 1, 3, missing),
                new Object[] { "itemCasingEndSteel", "plateEndSteel", "itemCasingEndSteel", "plateEndSteel",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 2, missing), "plateEndSteel",
                        "itemCasingEndSteel", "plateEndSteel", "itemCasingEndSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "itemMachinePart", 1, 3, missing),
                new Object[] { "itemCasingEndSteel", "plateEndSteel", "itemCasingEndSteel", "plateEndSteel",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 9, missing), "plateEndSteel",
                        "itemCasingEndSteel", "plateEndSteel", "itemCasingEndSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "blockVat", 1, 0, missing),
                new Object[] { "itemCasingSteel", getModItem("minecraft", "cauldron", 1, 0, missing), "itemCasingSteel",
                        getModItem("EnderIO", "blockTank", 1, 0, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "blockTank", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "craftingIronFurnace",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockPowerMonitor", 1, 0, missing),
                new Object[] { "plateElectricalSteel", getModItem("dreamcraft", "item.Display", 1, 0, missing),
                        "plateElectricalSteel", "circuitBasic", getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        "circuitBasic", getModItem("EnderIO", "itemPowerConduit", 1, 0, missing),
                        getModItem("EnderIO", "itemConduitProbe", 1, 0, missing),
                        getModItem("EnderIO", "itemPowerConduit", 1, 0, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockFarmStation", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing), "plateDensePulsatingIron",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 5, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 5, missing), "gearElectricalSteel",
                        getModItem("EnderIO", "itemFrankenSkull", 1, 1, missing), "gearElectricalSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "blockWirelessCharger", 1, 0, missing),
                new Object[] { "plateElectricalSteel", getModItem("EnderIO", "itemBasicCapacitor", 1, 2, missing),
                        "plateElectricalSteel", "circuitAdvanced",
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing), "circuitAdvanced",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockWirelessCharger", 1, 0, missing),
                new Object[] { "plateElectricalSteel", getModItem("EnderIO", "itemBasicCapacitor", 1, 9, missing),
                        "plateElectricalSteel", "circuitAdvanced",
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing), "circuitAdvanced",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockTank", 1, 0, missing),
                new Object[] { "itemCasingSteel", getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                        "itemCasingSteel", getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 4461, missing),
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing), "itemCasingSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing), "itemCasingSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "blockTank", 1, 1, missing),
                new Object[] { "plateDarkSteel", getModItem("EnderIO", "blockDarkIronBars", 1, 0, missing),
                        "plateDarkSteel", getModItem("EnderIO", "blockDarkIronBars", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 4460, missing),
                        getModItem("EnderIO", "blockDarkIronBars", 1, 0, missing), "plateDarkSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32611, missing), "plateDarkSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "blockReservoir", 2, 0, missing),
                new Object[] { getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("minecraft", "cauldron", 1, 0, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32612, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockTransceiver", 1, 0, missing),
                new Object[] { getModItem("EnderIO", "itemBasicCapacitor", 1, 3, missing), "circuitMaster",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 3, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 8, missing), "frameGtEnderium",
                        getModItem("EnderIO", "itemMaterial", 1, 8, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 4, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockBuffer", 1, 0, missing),
                new Object[] { "plateElectricalSteel", "chestWood", "plateElectricalSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32630, missing), "frameGtDarkSteel",
                        "circuitBasic" });
        addShapedRecipe(
                getModItem("EnderIO", "blockBuffer", 1, 1, missing),
                new Object[] { "plateElectricalSteel", getModItem("EnderIO", "itemPowerConduit", 1, 0, missing),
                        "plateElectricalSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32519, missing),
                        "frameGtDarkSteel", "circuitBasic" });
        addShapedRecipe(
                getModItem("EnderIO", "blockInventoryPanel", 1, 0, missing),
                new Object[] { "plateDarkSteel", getModItem("EnderIO", "itemFunctionUpgrade", 1, 0, missing),
                        "plateDarkSteel", getModItem("EnderIO", "itemMaterial", 1, 5, missing),
                        getModItem("dreamcraft", "item.Display", 1, 0, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 5, missing), "plateDarkSteel",
                        getModItem("EnderIO", "itemFrankenSkull", 1, 1, missing), "plateDarkSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGrindingBall", 4, 0, missing),
                new Object[] { "screwElectricalSteel", "plateElectricalSteel", "screwElectricalSteel",
                        "plateElectricalSteel", "ringElectricalSteel", "plateElectricalSteel", "screwElectricalSteel",
                        "plateElectricalSteel", "screwElectricalSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGrindingBall", 4, 1, missing),
                new Object[] { "screwEnergeticAlloy", "plateEnergeticAlloy", "screwEnergeticAlloy",
                        "plateEnergeticAlloy", "ringEnergeticAlloy", "plateEnergeticAlloy", "screwEnergeticAlloy",
                        "plateEnergeticAlloy", "screwEnergeticAlloy" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGrindingBall", 4, 2, missing),
                new Object[] { "screwVibrantAlloy", "plateVibrantAlloy", "screwVibrantAlloy", "plateVibrantAlloy",
                        "ringVibrantAlloy", "plateVibrantAlloy", "screwVibrantAlloy", "plateVibrantAlloy",
                        "screwVibrantAlloy" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGrindingBall", 4, 3, missing),
                new Object[] { "screwRedstoneAlloy", "plateRedstoneAlloy", "screwRedstoneAlloy", "plateRedstoneAlloy",
                        "ringRedstoneAlloy", "plateRedstoneAlloy", "screwRedstoneAlloy", "plateRedstoneAlloy",
                        "screwRedstoneAlloy" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGrindingBall", 4, 4, missing),
                new Object[] { "screwConductiveIron", "plateConductiveIron", "screwConductiveIron",
                        "plateConductiveIron", "ringConductiveIron", "plateConductiveIron", "screwConductiveIron",
                        "plateConductiveIron", "screwConductiveIron" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGrindingBall", 4, 5, missing),
                new Object[] { "screwPulsatingIron", "platePulsatingIron", "screwPulsatingIron", "platePulsatingIron",
                        "ringPulsatingIron", "platePulsatingIron", "screwPulsatingIron", "platePulsatingIron",
                        "screwPulsatingIron" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGrindingBall", 4, 6, missing),
                new Object[] { "screwDarkSteel", "plateDarkSteel", "screwDarkSteel", "plateDarkSteel", "ringDarkSteel",
                        "plateDarkSteel", "screwDarkSteel", "plateDarkSteel", "screwDarkSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGrindingBall", 4, 7, missing),
                new Object[] { "screwSoularium", "plateSoularium", "screwSoularium", "plateSoularium", "ringSoularium",
                        "plateSoularium", "screwSoularium", "plateSoularium", "screwSoularium" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGrindingBall", 4, 8, missing),
                new Object[] { "screwEndSteel", "plateEndSteel", "screwEndSteel", "plateEndSteel", "ringEndSteel",
                        "plateEndSteel", "screwEndSteel", "plateEndSteel", "screwEndSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGrindingBallEndergy", 4, 0, missing),
                new Object[] { "screwCrudeSteel", "plateCrudeSteel", "screwCrudeSteel", "plateCrudeSteel",
                        "ringCrudeSteel", "plateCrudeSteel", "screwCrudeSteel", "plateCrudeSteel", "screwCrudeSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGrindingBallEndergy", 4, 1, missing),
                new Object[] { "screwCrystallineAlloy", "plateCrystallineAlloy", "screwCrystallineAlloy",
                        "plateCrystallineAlloy", "ringCrystallineAlloy", "plateCrystallineAlloy",
                        "screwCrystallineAlloy", "plateCrystallineAlloy", "screwCrystallineAlloy" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGrindingBallEndergy", 4, 2, missing),
                new Object[] { "screwMelodicAlloy", "plateMelodicAlloy", "screwMelodicAlloy", "plateMelodicAlloy",
                        "ringMelodicAlloy", "plateMelodicAlloy", "screwMelodicAlloy", "plateMelodicAlloy",
                        "screwMelodicAlloy" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGrindingBallEndergy", 4, 3, missing),
                new Object[] { "screwStellarAlloy", "plateStellarAlloy", "screwStellarAlloy", "plateStellarAlloy",
                        "ringStellarAlloy", "plateStellarAlloy", "screwStellarAlloy", "plateStellarAlloy",
                        "screwStellarAlloy" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGrindingBallEndergy", 4, 4, missing),
                new Object[] { "screwCrystallinePinkSlime", "plateCrystallinePinkSlime", "screwCrystallinePinkSlime",
                        "plateCrystallinePinkSlime", "ringCrystallinePinkSlime", "plateCrystallinePinkSlime",
                        "screwCrystallinePinkSlime", "plateCrystallinePinkSlime", "screwCrystallinePinkSlime" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGrindingBallEndergy", 4, 5, missing),
                new Object[] { "screwEnergeticSilver", "plateEnergeticSilver", "screwEnergeticSilver",
                        "plateEnergeticSilver", "ringEnergeticSilver", "plateEnergeticSilver", "screwEnergeticSilver",
                        "plateEnergeticSilver", "screwEnergeticSilver" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGrindingBallEndergy", 4, 6, missing),
                new Object[] { "screwVividAlloy", "plateVividAlloy", "screwVividAlloy", "plateVividAlloy",
                        "ringVividAlloy", "plateVividAlloy", "screwVividAlloy", "plateVividAlloy", "screwVividAlloy" });
        addShapedRecipe(
                getModItem("EnderIO", "blockEnderIo", 1, 0, missing),
                new Object[] { "plateElectricalSteel", getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        "plateElectricalSteel", getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        "lensEnderEye", getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        "plateElectricalSteel", getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        "plateElectricalSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "blockTravelAnchor", 1, 0, missing),
                new Object[] { "plateElectricalSteel", getModItem("OpenBlocks", "elevator", 1, 0, missing),
                        "plateElectricalSteel", getModItem("EnderIO", "itemMaterial", 1, 5, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 5, missing), "plateElectricalSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32670, missing), "plateElectricalSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "blockSliceAndSplice", 1, 0, missing),
                new Object[] { "plateSoularium", getModItem("minecraft", "shears", 1, 0, missing), "plateSoularium",
                        "circuitGood", getModItem("EnderIO", "itemMachinePart", 1, 0, missing), "circuitGood",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        getModItem("minecraft", "iron_axe", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockSoulBinder", 1, 0, missing),
                new Object[] { "plateSoularium", getModItem("EnderIO", "itemFrankenSkull", 1, 3, missing),
                        "plateSoularium", "circuitAdvanced", getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        "circuitAdvanced", getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockPoweredSpawner", 1, 0, missing),
                new Object[] { "plateDarkSteel", "itemSkull", "plateDarkSteel", "plateSoularium",
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing), "plateSoularium",
                        getModItem("EnderIO", "itemMaterial", 1, 8, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 2, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 8, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockKillerJoe", 1, 0, missing),
                new Object[] { "itemCasingAluminium", "circuitGood", "itemCasingAluminium",
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockAttractor", 1, 0, missing),
                new Object[] { null, getModItem("EnderIO", "itemMaterial", 1, 9, missing), null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 17366, missing), "plateSoularium",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17366, missing), "plateSoularium",
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing), "plateSoularium" });
        addShapedRecipe(
                getModItem("EnderIO", "blockSpawnGuard", 1, 0, missing),
                new Object[] { null, getModItem("EnderIO", "blockEndermanSkull", 1, 2, missing), null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 17366, missing), "plateSoularium",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17366, missing), "plateSoularium",
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing), "plateSoularium" });
        addShapedRecipe(
                getModItem("EnderIO", "blockExperienceObelisk", 1, 0, missing),
                new Object[] { null, getModItem("EnderIO", "itemXpTransfer", 1, 0, missing), null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 17366, missing), "plateSoularium",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17366, missing), "plateSoularium",
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing), "plateSoularium" });
        addShapedRecipe(
                getModItem("EnderIO", "blockWeatherObelisk", 1, 0, missing),
                new Object[] { null, getModItem("EnderIO", "itemMaterial", 1, 10, missing), null, "bucketLava",
                        "plateSoularium", "bucketWater", "plateSoularium",
                        getModItem("EnderIO", "blockCapBank", 1, 2, missing), "plateSoularium" });
        addShapedRecipe(
                getModItem("EnderIO", "blockEnchanter", 1, 0, missing),
                new Object[] { getModItem("EnderIO", "itemMaterial", 1, 5, missing), "craftingBook",
                        getModItem("EnderIO", "itemMaterial", 1, 6, missing), null, "plateDarkSteel", null,
                        "plateDarkSteel", getModItem("minecraft", "enchanting_table", 1, 0, missing),
                        "plateDarkSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "blockDarkIronBars", 3, 0, missing),
                new Object[] { null, "craftingToolHardHammer", null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 23364, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23364, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23364, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23364, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23364, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23364, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockSoulariumBars", 3, 0, missing),
                new Object[] { null, "craftingToolHardHammer", null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 23379, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23379, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23379, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23379, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23379, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23379, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockEndSteelBars", 3, 0, missing),
                new Object[] { null, "craftingToolHardHammer", null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 23401, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23401, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23401, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23401, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23401, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23401, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockDarkSteelLadder", 1, 0, missing),
                new Object[] { getModItem("EnderIO", "blockDarkIronBars", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem("EnderIO", "blockDarkIronBars", 1, 0, missing), "wireFineSteel", "screwSteel",
                        "wireFineSteel", getModItem("EnderIO", "blockDarkIronBars", 1, 0, missing),
                        "craftingToolWrench", getModItem("EnderIO", "blockDarkIronBars", 1, 0, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "blockElectricLight", 8, 0, missing),
                new Object[] { getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing), "plateSiliconSolarGrade",
                        getModItem("FloodLights", "electricIncandescentLightBulb", 1, 0, missing),
                        "plateSiliconSolarGrade", "circuitBasic",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 0, missing), "circuitBasic" });
        addShapedRecipe(
                getModItem("EnderIO", "blockElectricLight", 8, 0, missing),
                new Object[] { getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing), "plateSiliconSolarGrade",
                        getModItem("FloodLights", "electricIncandescentLightBulb", 1, 0, missing),
                        "plateSiliconSolarGrade", "circuitBasic",
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 7, missing), "circuitBasic" });
        addShapedRecipe(
                getModItem("EnderIO", "blockElectricLight", 16, 2, missing),
                new Object[] { getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing),
                        getModItem("EnderIO", "blockFusedQuartz", 1, 0, missing), "plateSiliconSolarGrade",
                        getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1, 0, missing),
                        "plateSiliconSolarGrade", "plateIron", "wireGt01RedAlloy", "plateIron" });
        addShapedRecipe(
                getModItem("EnderIO", "blockReinforcedObsidian", 1, 0, missing),
                new Object[] { "plateDarkSteel", getModItem("EnderIO", "blockDarkIronBars", 1, 0, missing),
                        "plateDarkSteel", getModItem("EnderIO", "blockDarkIronBars", 1, 0, missing), "blockObsidian",
                        getModItem("EnderIO", "blockDarkIronBars", 1, 0, missing), "plateDarkSteel",
                        getModItem("EnderIO", "blockDarkIronBars", 1, 0, missing), "plateDarkSteel" });
        addShapedRecipe(
                createItemStack("EnderIO", "itemCoordSelector", 1, 0, "{bc:x:0,default:1b,bc:y:0,bc:z:0}", missing),
                new Object[] { "plateElectricalSteel", "gemEnderEye", "plateElectricalSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17378, missing),
                        getModItem("minecraft", "compass", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17378, missing), "plateElectricalSteel",
                        "gemEnderEye", "plateElectricalSteel" });
        addShapelessCraftingRecipe(
                getModItem("EnderIO", "itemExtractSpeedUpgrade", 1, 0, missing),
                new Object[] { getModItem("EnderIO", "itemExtractSpeedUpgrade", 1, 1, missing) });
        addShapedRecipe(
                getModItem("EnderIO", "itemFunctionUpgrade", 1, 0, missing),
                new Object[] { "plateSiliconSolarGrade", getModItem("EnderIO", "itemMaterial", 1, 1, missing),
                        "plateSiliconSolarGrade", "circuitAdvanced", "gemEnderEye", "circuitAdvanced",
                        "plateSiliconSolarGrade", "plateElectricalSteel", "plateSiliconSolarGrade" });
        addShapedRecipe(
                getModItem("EnderIO", "itemYetaWrench", 1, 0, missing),
                new Object[] { "ingotElectricalSteel", "craftingToolHardHammer", "ingotElectricalSteel",
                        "ingotElectricalSteel", "gearElectricalSteel", "ingotElectricalSteel", null,
                        "ingotElectricalSteel", null });
        addShapedRecipe(
                getModItem("EnderIO", "itemConduitProbe", 1, 0, missing),
                new Object[] { "plateSiliconSolarGrade", getModItem("EnderIO", "itemPowerConduit", 1, 0, missing),
                        "plateSiliconSolarGrade", "circuitBasic",
                        getModItem("ProjRed|Integration", "projectred.integration.gate", 1, 26, missing),
                        "circuitBasic", "plateElectricalSteel",
                        getModItem("EnderIO", "itemRedstoneConduit", 1, 2, missing), "plateElectricalSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "itemTravelStaff", 1, 16, missing),
                new Object[] { "craftingToolScrewdriver", "circuitAdvanced",
                        getModItem("EnderIO", "itemMaterial", 1, 8, missing), "screwVibrantAlloy", "stickDarkSteel",
                        "circuitAdvanced", "stickDarkSteel", "screwVibrantAlloy", "craftingToolWrench" });
        addShapedRecipe(
                getModItem("EnderIO", "itemXpTransfer", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", "circuitAdvanced",
                        getModItem("EnderIO", "itemMaterial", 1, 5, missing), "screwEnergeticAlloy", "stickSoularium",
                        "circuitAdvanced", "stickSoularium", "screwEnergeticAlloy", "craftingToolWrench" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGliderWing", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "stickDarkSteel", "itemLeather", "stickDarkSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "itemLeather", "itemLeather",
                        "itemLeather", "itemLeather" });
        addShapedRecipe(
                getModItem("EnderIO", "itemGliderWing", 1, 1, missing),
                new Object[] { "screwDarkSteel", "stickDarkSteel", "screwDarkSteel",
                        getModItem("EnderIO", "itemGliderWing", 1, 0, missing), "plateDarkSteel",
                        getModItem("EnderIO", "itemGliderWing", 1, 0, missing), "craftingToolWrench", "stickDarkSteel",
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("EnderIO", "itemMagnet", 1, 16, missing),
                new Object[] { "plateElectricalSteel", "plateConductiveIron", "plateConductiveIron",
                        "craftingToolWrench", "screwSteelMagnetic",
                        getModItem("EnderIO", "itemMaterial", 1, 6, missing), "plateElectricalSteel",
                        "plateConductiveIron", "plateConductiveIron" });
        addShapedRecipe(
                getModItem("EnderIO", "item.endSteel_helmet", 1, 0, missing),
                new Object[] { "plateEndSteel", "plateEndSteel", "plateEndSteel", "plateEndSteel",
                        "craftingToolHardHammer", "plateEndSteel", null,
                        getModItem("EnderIO", "itemFrankenSkull", 1, 6, missing), null });
        addShapedRecipe(
                getModItem("EnderIO", "item.endSteel_chestplate", 1, 0, missing),
                new Object[] { "plateEndSteel", "craftingToolHardHammer", "plateEndSteel", "plateEndSteel",
                        getModItem("EnderIO", "itemFrankenSkull", 1, 6, missing), "plateEndSteel", "plateEndSteel",
                        "plateEndSteel", "plateEndSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "item.endSteel_leggings", 1, 0, missing),
                new Object[] { "plateEndSteel", "plateEndSteel", "plateEndSteel", "plateEndSteel",
                        "craftingToolHardHammer", "plateEndSteel", "plateEndSteel",
                        getModItem("EnderIO", "itemFrankenSkull", 1, 6, missing), "plateEndSteel" });
        addShapedRecipe(
                getModItem("EnderIO", "item.endSteel_boots", 1, 0, missing),
                new Object[] { "plateEndSteel", getModItem("EnderIO", "itemFrankenSkull", 1, 6, missing),
                        "plateEndSteel", "plateEndSteel", "craftingToolHardHammer", "plateEndSteel", null, null,
                        null });
        addShapedRecipe(
                getModItem("EnderIO", "item.stellar_helmet", 1, 0, missing),
                new Object[] { "plateStellarAlloy", "plateStellarAlloy", "plateStellarAlloy", "plateStellarAlloy",
                        "craftingToolHardHammer", "plateStellarAlloy", null,
                        getModItem("EnderIO", "itemFrankenSkull", 1, 4, missing), null });
        addShapedRecipe(
                getModItem("EnderIO", "item.stellar_chestplate", 1, 0, missing),
                new Object[] { "plateStellarAlloy", "craftingToolHardHammer", "plateStellarAlloy", "plateStellarAlloy",
                        getModItem("EnderIO", "itemFrankenSkull", 1, 4, missing), "plateStellarAlloy",
                        "plateStellarAlloy", "plateStellarAlloy", "plateStellarAlloy" });
        addShapedRecipe(
                getModItem("EnderIO", "item.stellar_leggings", 1, 0, missing),
                new Object[] { "plateStellarAlloy", "plateStellarAlloy", "plateStellarAlloy", "plateStellarAlloy",
                        "craftingToolHardHammer", "plateStellarAlloy", "plateStellarAlloy",
                        getModItem("EnderIO", "itemFrankenSkull", 1, 4, missing), "plateStellarAlloy" });
        addShapedRecipe(
                getModItem("EnderIO", "item.stellar_boots", 1, 0, missing),
                new Object[] { "plateStellarAlloy", getModItem("EnderIO", "itemFrankenSkull", 1, 4, missing),
                        "plateStellarAlloy", "plateStellarAlloy", "craftingToolHardHammer", "plateStellarAlloy", null,
                        null, null });
        addShapedRecipe(
                getModItem("EnderIO", "item.endSteel_pickaxe", 1, 0, missing),
                new Object[] { "plateEndSteel", "ingotEndSteel", "ingotEndSteel", "craftingToolFile",
                        getModItem("EnderIO", "itemMaterial", 1, 12, missing), "craftingToolHardHammer", null,
                        getModItem("EnderIO", "itemMaterial", 1, 12, missing), null });
        addShapedRecipe(
                getModItem("EnderIO", "item.endSteel_axe", 1, 0, missing),
                new Object[] { "plateEndSteel", "ingotEndSteel", "craftingToolHardHammer", "plateEndSteel",
                        getModItem("EnderIO", "itemMaterial", 1, 12, missing), "plateEndSteel", "craftingToolFile",
                        getModItem("EnderIO", "itemMaterial", 1, 12, missing), null });
        addShapedRecipe(
                getModItem("EnderIO", "item.endSteel_sword", 1, 0, missing),
                new Object[] { null, "plateEndSteel", null, "craftingToolFile", "plateEndSteel",
                        "craftingToolHardHammer", null, getModItem("EnderIO", "itemMaterial", 1, 12, missing), null });
        addShapedRecipe(
                getModItem("EnderIO", "item.stellar_pickaxe", 1, 0, missing),
                new Object[] { "plateStellarAlloy", "ingotStellarAlloy", "ingotStellarAlloy", "craftingToolFile",
                        getModItem("EnderIO", "itemFrankenSkull", 1, 4, missing), "craftingToolHardHammer", null,
                        getModItem("EnderIO", "itemMaterial", 1, 12, missing), null });
        addShapedRecipe(
                getModItem("EnderIO", "item.stellar_axe", 1, 0, missing),
                new Object[] { "plateStellarAlloy", "ingotStellarAlloy", "craftingToolHardHammer", "plateStellarAlloy",
                        getModItem("EnderIO", "itemFrankenSkull", 1, 4, missing), "plateStellarAlloy",
                        "craftingToolFile", getModItem("EnderIO", "itemMaterial", 1, 12, missing), null });
        addShapedRecipe(
                getModItem("EnderIO", "item.stellar_sword", 1, 0, missing),
                new Object[] { null, getModItem("EnderIO", "itemFrankenSkull", 1, 4, missing), null, "craftingToolFile",
                        "plateStellarAlloy", "craftingToolHardHammer", null,
                        getModItem("EnderIO", "itemMaterial", 1, 12, missing), null });
        addShapedRecipe(
                getModItem("EnderIO", "itemMaterial", 1, 12, missing),
                new Object[] { "craftingToolScrewdriver", "screwEndSteel", "stickDarkSteel", "screwEndSteel",
                        "stickDarkSteel", "screwEndSteel", "stickDarkSteel", "screwEndSteel",
                        "craftingToolHardHammer" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 9231, missing),
                        getModItem("ExtraUtilities", "enderCollector", 1, 0, missing))
                .itemOutputs(getModItem("EnderIO", "blockVacuumChest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "blockBuffer", 1, 0, missing),
                        getModItem("EnderIO", "blockBuffer", 1, 1, missing))
                .itemOutputs(getModItem("EnderIO", "blockBuffer", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "diamond", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 9378, missing))
                .itemOutputs(getModItem("EnderIO", "itemMaterial", 1, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "emerald", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 9367, missing))
                .itemOutputs(getModItem("EnderIO", "itemMaterial", 1, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17365, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBall", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17366, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBall", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBall", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17381, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBall", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17369, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBall", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17378, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBall", 1, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17364, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBall", 1, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17379, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBall", 1, 7, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17401, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBall", 1, 8, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17401, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBall", 1, 9, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17402, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBallEndergy", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17403, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBallEndergy", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17404, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBallEndergy", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17405, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBallEndergy", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17406, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBallEndergy", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17407, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBallEndergy", 1, 5, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17408, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemGrindingBallEndergy", 1, 6, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ManyullynCrystal", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 8, 9321, missing))
                .itemOutputs(getModItem("EnderIO", "itemMaterial", 1, 10, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "heavy_weighted_pressure_plate", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17364, missing))
                .itemOutputs(getModItem("EnderIO", "blockDarkSteelPressurePlate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "blockDarkSteelPressurePlate", 1, 0, missing),
                        getModItem("IC2", "blockRubber", 1, 0, missing))
                .itemOutputs(getModItem("EnderIO", "blockDarkSteelPressurePlate", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "blockDarkIronBars", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("EnderIO", "blockDarkSteelLadder", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(96).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 3, 23364, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("EnderIO", "blockDarkIronBars", 4, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 3, 23379, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("EnderIO", "blockSoulariumBars", 4, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 3, 23401, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("EnderIO", "blockEndSteelBars", 4, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "blockElectricLight", 1, 0, missing),
                        getModItem("minecraft", "redstone_torch", 1, 0, missing))
                .itemOutputs(getModItem("EnderIO", "blockElectricLight", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "blockElectricLight", 1, 2, missing),
                        getModItem("minecraft", "redstone_torch", 1, 0, missing))
                .itemOutputs(getModItem("EnderIO", "blockElectricLight", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "blockElectricLight", 16, 0, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 3, missing))
                .itemOutputs(getModItem("EnderIO", "blockElectricLight", 16, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "blockElectricLight", 1, 4, missing),
                        getModItem("minecraft", "redstone_torch", 1, 0, missing))
                .itemOutputs(getModItem("EnderIO", "blockElectricLight", 1, 5, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 4905, missing),
                        getModItem("EnderIO", "itemMaterial", 4, 1, missing))
                .itemOutputs(getModItem("EnderIO", "itemFusedQuartzFrame", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemMaterial", 8, 1, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("EnderIO", "itemConduitFacade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemRedstoneConduit", 1, 0, missing),
                        getModItem("EnderIO", "itemMaterial", 2, 1, missing))
                .itemOutputs(getModItem("EnderIO", "itemRedstoneConduit", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemRedstoneConduit", 1, 2, missing),
                        getModItem("minecraft", "lever", 1, 0, missing))
                .itemOutputs(getModItem("EnderIO", "itemRedstoneConduit", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 2000, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17381, missing))
                .itemOutputs(getModItem("EnderIO", "itemRedstoneConduit", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 2000, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17381, missing))
                .itemOutputs(getModItem("EnderIO", "itemRedstoneConduit", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 1420, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17369, missing))
                .itemOutputs(getModItem("EnderIO", "itemPowerConduit", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 1580, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17366, missing))
                .itemOutputs(getModItem("EnderIO", "itemPowerConduit", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 1620, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing))
                .itemOutputs(getModItem("EnderIO", "itemPowerConduit", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.epoxid", 144)).noFluidOutputs().duration(100).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 2000, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17402, missing))
                .itemOutputs(getModItem("EnderIO", "itemPowerConduitEndergy", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).noFluidOutputs().duration(100).eut(8)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 1260, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing))
                .itemOutputs(getModItem("EnderIO", "itemPowerConduitEndergy", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).noFluidOutputs().duration(100).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 1280, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing))
                .itemOutputs(getModItem("EnderIO", "itemPowerConduitEndergy", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).noFluidOutputs().duration(100).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 1320, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing))
                .itemOutputs(getModItem("EnderIO", "itemPowerConduitEndergy", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144)).noFluidOutputs().duration(100)
                .eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 1380, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17035, missing))
                .itemOutputs(getModItem("EnderIO", "itemPowerConduitEndergy", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.solderingalloy", 144)).noFluidOutputs().duration(100)
                .eut(96).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 1440, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17054, missing))
                .itemOutputs(getModItem("EnderIO", "itemPowerConduitEndergy", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(160)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 1540, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17303, missing))
                .itemOutputs(getModItem("EnderIO", "itemPowerConduitEndergy", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(192)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 1660, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17407, missing))
                .itemOutputs(getModItem("EnderIO", "itemPowerConduitEndergy", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.epoxid", 144)).noFluidOutputs().duration(100).eut(320)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 1700, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17403, missing))
                .itemOutputs(getModItem("EnderIO", "itemPowerConduitEndergy", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.epoxid", 144)).noFluidOutputs().duration(100).eut(960)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 1720, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17406, missing))
                .itemOutputs(getModItem("EnderIO", "itemPowerConduitEndergy", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144)).noFluidOutputs()
                .duration(100).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 1780, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17404, missing))
                .itemOutputs(getModItem("EnderIO", "itemPowerConduitEndergy", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144)).noFluidOutputs()
                .duration(100).eut(7680).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 11390, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17405, missing))
                .itemOutputs(getModItem("EnderIO", "itemPowerConduitEndergy", 1, 11, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polybenzimidazole", 144)).noFluidOutputs()
                .duration(100).eut(30720).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5112, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17365, missing))
                .itemOutputs(getModItem("EnderIO", "itemLiquidConduit", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5132, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17364, missing))
                .itemOutputs(getModItem("EnderIO", "itemLiquidConduit", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5680, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing))
                .itemOutputs(getModItem("EnderIO", "itemLiquidConduit", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5682, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17403, missing))
                .itemOutputs(getModItem("EnderIO", "itemLiquidConduit", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.epoxid", 144)).noFluidOutputs().duration(100).eut(960)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5682, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17406, missing))
                .itemOutputs(getModItem("EnderIO", "itemLiquidConduit", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144)).noFluidOutputs()
                .duration(100).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5282, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17404, missing))
                .itemOutputs(getModItem("EnderIO", "itemLiquidConduit", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polytetrafluoroethylene", 144)).noFluidOutputs()
                .duration(100).eut(7680).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5282, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17405, missing))
                .itemOutputs(getModItem("EnderIO", "itemLiquidConduit", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.polybenzimidazole", 144)).noFluidOutputs()
                .duration(100).eut(30720).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 5611, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17378, missing))
                .itemOutputs(getModItem("EnderIO", "itemItemConduit", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 16, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17381, missing))
                .itemOutputs(getModItem("EnderIO", "itemOCConduit", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.plastic", 144)).noFluidOutputs().duration(100).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("minecraft", "iron_bars", 1, 0, missing))
                .itemOutputs(getModItem("EnderIO", "itemBasicFilterUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemBasicFilterUpgrade", 1, 0, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 1, missing))
                .itemOutputs(getModItem("EnderIO", "itemBasicFilterUpgrade", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemBasicFilterUpgrade", 2, 1, missing),
                        getModItem("EnderIO", "blockEndSteelBars", 2, 0, missing))
                .itemOutputs(getModItem("EnderIO", "itemBigFilterUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemBigFilterUpgrade", 1, 0, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 2, missing))
                .itemOutputs(getModItem("EnderIO", "itemBigFilterUpgrade", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(256).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemBasicFilterUpgrade", 1, 1, missing),
                        getModItem("ProjRed|Integration", "projectred.integration.gate", 1, 26, missing))
                .itemOutputs(getModItem("EnderIO", "itemExistingItemFilter", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemBasicFilterUpgrade", 1, 0, missing),
                        getModItem("EnderIO", "itemYetaWrench", 1, 0, missing))
                .itemOutputs(getModItem("EnderIO", "itemModItemFilter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemBasicFilterUpgrade", 1, 0, missing),
                        getModItem("EnderIO", "itemConduitProbe", 1, 0, missing))
                .itemOutputs(getModItem("EnderIO", "itemPowerItemFilter", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemBasicFilterUpgrade", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing))
                .itemOutputs(getModItem("EnderIO", "itemExtractSpeedUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemExtractSpeedUpgrade", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("EnderIO", "itemExtractSpeedUpgrade", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 144)).noFluidOutputs().duration(300).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "blockFusedQuartz", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 25379, missing))
                .itemOutputs(getModItem("EnderIO", "itemSoulVessel", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(48).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 1, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem("EnderIO", "blockCrafter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("IC2", "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem("EnderIO", "blockCrafter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("IC2", "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem("EnderIO", "blockCrafter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 1, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("IC2", "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem("EnderIO", "blockCrafter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 1, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 18305, missing))
                .itemOutputs(getModItem("EnderIO", "blockCrafter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32701, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 18305, missing))
                .itemOutputs(getModItem("EnderIO", "blockCrafter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32078, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 18305, missing))
                .itemOutputs(getModItem("EnderIO", "blockCrafter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing),
                        getModItem("EnderIO", "itemMachinePart", 1, 0, missing),
                        getModItem("EnderIO", "itemFrankenSkull", 1, 1, missing),
                        getModItem("bartworks", "gt.bwMetaGeneratedItem0", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 18305, missing))
                .itemOutputs(getModItem("EnderIO", "blockCrafter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17365, missing),
                        getModItem("IC2", "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemMachinePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 0, missing),
                        getModItem("miscutils", "itemPlateElectricalSteel", 2, 0, missing),
                        getModItem("IC2", "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemMachinePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17365, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 18305, missing))
                .itemOutputs(getModItem("EnderIO", "itemMachinePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 0, missing),
                        getModItem("miscutils", "itemPlateElectricalSteel", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 18305, missing))
                .itemOutputs(getModItem("EnderIO", "itemMachinePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17365, missing),
                        getModItem("IC2", "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemMachinePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 7, missing),
                        getModItem("miscutils", "itemPlateElectricalSteel", 2, 0, missing),
                        getModItem("IC2", "itemCasing", 2, 5, missing))
                .itemOutputs(getModItem("EnderIO", "itemMachinePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17365, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 18305, missing))
                .itemOutputs(getModItem("EnderIO", "itemMachinePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("EnderIO", "itemBasicCapacitor", 1, 7, missing),
                        getModItem("miscutils", "itemPlateElectricalSteel", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 18305, missing))
                .itemOutputs(getModItem("EnderIO", "itemMachinePart", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(64).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "obsidian", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17364, missing),
                        getModItem("EnderIO", "blockDarkIronBars", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 17, missing))
                .itemOutputs(getModItem("EnderIO", "blockReinforcedObsidian", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("EnderIO", "itemConduitFacade", 1, 0, missing))
                .itemOutputs(getModItem("EnderIO", "itemConduitFacade", 1, 1, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("obsidian.molten", 576)).noFluidOutputs().duration(200).eut(2)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("EnderIO", "itemMaterial", 1, 2, missing))
                .itemOutputs(
                        getModItem("EnderIO", "itemMaterial", 2, 1, missing),
                        getModItem("EnderIO", "itemMaterial", 2, 1, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 1, missing))
                .outputChances(10000, 9000, 5000).fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 144))
                .noFluidOutputs().duration(200).eut(2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("gregtech", "gt.metaitem.01", 0, 32314, missing))
                .itemOutputs(getModItem("EnderIO", "blockDarkSteelAnvil", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.darksteel", 4464)).noFluidOutputs().duration(900)
                .eut(120).addTo(sFluidSolidficationRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("IC2", "itemPartCFPowder", 1, 0, missing))
                .itemOutputs(getModItem("EnderIO", "itemMaterial", 9, 2, missing)).outputChances(10000).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("EnderIO", "itemMaterial", 1, 5, missing))
                .itemOutputs(
                        getModItem("EnderIO", "itemMaterial", 1, 14, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 14, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 14, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 14, missing))
                .outputChances(10000, 1000, 100, 10).noFluidInputs().noFluidOutputs().duration(100).eut(480)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("EnderIO", "itemMaterial", 1, 6, missing))
                .itemOutputs(
                        getModItem("EnderIO", "itemMaterial", 1, 15, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 15, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 15, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 15, missing))
                .outputChances(10000, 1000, 100, 10).noFluidInputs().noFluidOutputs().duration(300).eut(480)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("EnderIO", "itemMaterial", 1, 8, missing))
                .itemOutputs(
                        getModItem("EnderIO", "itemMaterial", 1, 16, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 16, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 16, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 16, missing))
                .outputChances(10000, 1000, 100, 10).noFluidInputs().noFluidOutputs().duration(300).eut(480)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("EnderIO", "itemMaterial", 1, 13, missing))
                .itemOutputs(
                        getModItem("EnderIO", "itemMaterial", 1, 17, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 17, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 17, missing),
                        getModItem("EnderIO", "itemMaterial", 1, 17, missing))
                .outputChances(10000, 1000, 100, 10).noFluidInputs().noFluidOutputs().duration(300).eut(480)
                .addTo(sMaceratorRecipes);

    }
}
