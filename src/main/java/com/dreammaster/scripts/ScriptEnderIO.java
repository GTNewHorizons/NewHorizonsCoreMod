package com.dreammaster.scripts;

import static gregtech.api.enums.ModIDs.AppliedEnergistics2;
import static gregtech.api.enums.ModIDs.Avaritia;
import static gregtech.api.enums.ModIDs.EnderIO;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

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
        return Arrays.asList(EnderIO.modID, AppliedEnergistics2.modID, Avaritia.modID);
    }

    @Override
    public void loadRecipes() {
        ItemStack teleportStaff = getModItem(EnderIO.modID, "itemTeleportStaff", 1);
        ItemStack denseEnergyCell = getModItem(AppliedEnergistics2.modID, "tile.BlockDenseEnergyCell", 1);
        ItemStack energyCell = getModItem(AppliedEnergistics2.modID, "tile.BlockEnergyCell", 1);
        ItemStack staffOfTravelling = getModItem(EnderIO.modID, "itemTravelStaff", 1, wildcard);
        ItemStack endestPearl = getModItem(Avaritia.modID, "Endest_Pearl", 1);
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
                new ItemStack[] { getModItem(AppliedEnergistics2.modID, "item.ItemMultiPart", 4, 16),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Good, 1L), circuit2 },
                Materials.ConductiveIron.getMolten(144L),
                getModItem(EnderIO.modID, "itemMEConduit", 4),
                200,
                256);
        // ME Dense Conduit
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(EnderIO.modID, "itemMEConduit", 16),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L), circuit2 },
                Materials.EnergeticAlloy.getMolten(144L),
                getModItem(EnderIO.modID, "itemMEConduit", 4, 1),
                200,
                480);
        // ME Ultra Dense Conduit
        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { getModItem(EnderIO.modID, "itemMEConduit", 16, 1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Data, 1L), circuit2 },
                Materials.VibrantAlloy.getMolten(144L),
                getModItem(EnderIO.modID, "itemMEConduit", 4, 2),
                200,
                960);
    }
}
