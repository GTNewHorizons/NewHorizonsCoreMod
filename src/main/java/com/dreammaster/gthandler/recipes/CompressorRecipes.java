package com.dreammaster.gthandler.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;

public class CompressorRecipes implements Runnable {

    @Override
    public void run() {
        if (GTPlusPlus.isModLoaded()) {
            // Compressed Glowstone
            GT_Values.RA.addCompressorRecipe(
                    new ItemStack(Blocks.glowstone, 9),
                    GT_ModHandler.getModItem(GTPlusPlus.ID, "blockCompressedObsidian", 1L, 6),
                    300,
                    2);

            // Double Compressed Glowstone
            GT_Values.RA.addCompressorRecipe(
                    GT_ModHandler.getModItem(GTPlusPlus.ID, "blockCompressedObsidian", 9L, 6),
                    GT_ModHandler.getModItem(GTPlusPlus.ID, "blockCompressedObsidian", 1L, 7),
                    300,
                    2);
        }

        if (IndustrialCraft2.isModLoaded()) {
            GT_Values.RA.addCompressorRecipe(
                    GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemWeed", 16L),
                    ItemList.IC2_Plantball.get(1L),
                    300,
                    2);
        }

        if (ExtraTrees.isModLoaded()) {
            GT_Values.RA.addCompressorRecipe(
                    GT_ModHandler.getModItem(ExtraTrees.ID, "food", 64L, 24),
                    ItemList.IC2_Plantball.get(1L),
                    300,
                    2);
        }

        if (AdvancedSolarPanel.isModLoaded()) {
            GT_Values.RA.addCompressorRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L),
                    GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1L, 0),
                    300,
                    2);
            GT_Values.RA.addCompressorRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Sunnarium, 1L),
                    GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1L, 9),
                    300,
                    2);
            GT_Values.RA.addCompressorRecipe(
                    GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 9L, 9),
                    GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1L, 0),
                    300,
                    2);
        }
        GT_Values.RA.addCompressorRecipe(
                GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.WroughtIron, 9L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L),
                300,
                2);
        GT_Values.RA.addCompressorRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CertusQuartz, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.CertusQuartz, 1L),
                300,
                2);
        GT_Values.RA.addCompressorRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherQuartz, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                300,
                2);
        GT_Values.RA.addCompressorRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quartzite, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Quartzite, 1L),
                300,
                2);
        GT_Values.RA.addCompressorRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lazurite, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Lazurite, 1L),
                300,
                2);
        GT_Values.RA.addCompressorRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sodalite, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Sodalite, 1L),
                300,
                2);
        if (StevesCarts2.isModLoaded()) {
            GT_Values.RA.addCompressorRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnhancedGalgadorian, 9L),
                    GT_ModHandler.getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 48),
                    300,
                    2);
        }

        GT_Values.RA.addCompressorRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Carbon, 1L),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Carbon, 1L),
                300,
                2);
        GT_Values.RA.addCompressorRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Cobalt, 9L),
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Cobalt, 1L),
                300,
                2);
        GT_Values.RA.addCompressorRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Ardite, 9L),
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Ardite, 1L),
                300,
                2);
        GT_Values.RA.addCompressorRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Manyullyn, 9L),
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Manyullyn, 1L),
                300,
                2);
        GT_Values.RA.addCompressorRecipe(
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Alumite, 9L),
                GT_OreDictUnificator.get(OrePrefixes.block, Materials.Alumite, 1L),
                300,
                2);

        if (Natura.isModLoaded()) {
            GT_ModHandler.addCompressionRecipe(
                    GT_ModHandler.getModItem(Natura.ID, "barleyFood", 8, 0),
                    ItemList.IC2_Plantball.get(1));
        }

        if (Thaumcraft.isModLoaded()) {
            // Arcane Slabs -> Arcane Stone
            GT_Values.RA.addCompressorRecipe(
                    GT_ModHandler.getModItem(Thaumcraft.ID, "blockCosmeticSlabStone", 4L),
                    GT_ModHandler.getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1L, 6),
                    160,
                    4);
        }

        if (OpenComputers.isModLoaded()) {
            // Block of Chamelium
            GT_Values.RA.addCompressorRecipe(
                    GT_ModHandler.getModItem(OpenComputers.ID, "item", 9L, 96),
                    GT_ModHandler.getModItem(OpenComputers.ID, "chameliumBlock", 1L, 0),
                    300,
                    2);
        }

        if (TinkerConstruct.isModLoaded()) {
            GT_Values.RA.addCompressorRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 9L, 14),
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 7),
                    300,
                    2);
            GT_Values.RA.addCompressorRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 4L, 2),
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "Smeltery", 1L, 2),
                    300,
                    2);
            GT_Values.RA.addCompressorRecipe(
                    GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L),
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 12),
                    100,
                    2);

            // Slime crystals
            GT_Values.RA.addCompressorRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "CraftedSoil", 4L, 0),
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 1),
                    300,
                    2);
            GT_Values.RA.addCompressorRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "CraftedSoil", 4L, 2),
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 17),
                    300,
                    2);

            GT_Values.RA.addCompressorRecipe(
                    new ItemStack(Items.paper, 64, 0),
                    GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 0),
                    300,
                    2);
        }
    }
}
