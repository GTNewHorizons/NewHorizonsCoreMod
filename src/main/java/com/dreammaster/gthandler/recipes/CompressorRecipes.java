package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.BloodMagic;
import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.ProjectRedCore;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TinkersDefence;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.recipe.RecipeMaps.compressorRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.WILDCARD;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.block.BlockList;
import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_OreDictUnificator;

public class CompressorRecipes implements Runnable {

    ItemStack missing = new ItemStack(Blocks.fire);

    @Override
    public void run() {
        makeAdvancedSolarPanelRecipes();
        makeAvaritiaRecipes();
        makeBiomesOPlentyRecipes();
        makeBloodMagicRecipes();
        makeExtraUtilitiesRecipes();
        makeGTPlusPlusRecipes();
        makeHardcoreEnderExpansionRecipes();
        makeNaturaRecipes();
        makePamsHarvestCraftRecipes();
        makeRailcraftRecipes();
        makeTinkerConstructRecipes();
        makeTinkersDefenceRecipes();
        makeThaumcraftRecipes();

        // custom dust to plate compression
        Materials[] dustToPlateList = new Materials[] { Materials.CertusQuartz, Materials.NetherQuartz,
                Materials.Quartzite, Materials.Lazurite, Materials.Sodalite, Materials.CertusQuartzCharged };
        for (Materials material : dustToPlateList) {
            GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, material, 1L))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, material, 1L)).duration(15 * SECONDS)
                    .eut(2).addTo(compressorRecipes);
        }

        // custom dust to ingot compression
        Materials[] dustToIngotList = new Materials[] { Materials.Carbon, Materials.Ledox };
        for (Materials material : dustToIngotList) {
            GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, material, 1L))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, material, 1L)).duration(15 * SECONDS)
                    .eut(2).addTo(compressorRecipes);
        }

        // custom ingot to block compression
        Materials[] ingotToBlockList = new Materials[] { Materials.Cobalt, Materials.Ardite, Materials.Manyullyn,
                Materials.Alumite };
        for (Materials material : ingotToBlockList) {
            GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingot, material, 9L))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.block, material, 1L)).duration(15 * SECONDS)
                    .eut(2).addTo(compressorRecipes);
        }

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.nugget, Materials.WroughtIron, 9L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.WroughtIron, 1L))
                .duration(15 * SECONDS).eut(2).addTo(compressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 9))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.block, Materials.NetherStar, 1))
                .duration(15 * SECONDS).eut(TierEU.RECIPE_UV).addTo(compressorRecipes);

        // compressed coal variants
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Charcoal, 9))
                .itemOutputs(BlockList.CompressedCharcoal.getIS(1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.block, Materials.Coal, 9))
                .itemOutputs(BlockList.CompressedCoal.getIS(1)).duration(15 * SECONDS).eut(2).addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "cube", 9, 0, missing))
                .itemOutputs(BlockList.CompressedCoalCoke.getIS(1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(BlockList.CompressedCharcoal.getIS(9))
                .itemOutputs(BlockList.DoubleCompressedCharcoal.getIS(1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(BlockList.CompressedCoal.getIS(9))
                .itemOutputs(BlockList.DoubleCompressedCoal.getIS(1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(BlockList.CompressedCoalCoke.getIS(9))
                .itemOutputs(BlockList.DoubleCompressedCoalCoke.getIS(1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(BlockList.DoubleCompressedCharcoal.getIS(9))
                .itemOutputs(BlockList.TripleCompressedCharcoal.getIS(1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(BlockList.DoubleCompressedCoal.getIS(9))
                .itemOutputs(BlockList.TripleCompressedCoal.getIS(1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(BlockList.DoubleCompressedCoalCoke.getIS(9))
                .itemOutputs(BlockList.TripleCompressedCoalCoke.getIS(1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(BlockList.TripleCompressedCharcoal.getIS(9))
                .itemOutputs(BlockList.QuadrupleCompressedCharcoal.getIS(1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(BlockList.TripleCompressedCoal.getIS(9))
                .itemOutputs(BlockList.QuadrupleCompressedCoal.getIS(1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(BlockList.TripleCompressedCoalCoke.getIS(9))
                .itemOutputs(BlockList.QuadrupleCompressedCoalCoke.getIS(1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(BlockList.QuadrupleCompressedCharcoal.getIS(9))
                .itemOutputs(BlockList.QuintupleCompressedCharcoal.getIS(1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(BlockList.QuadrupleCompressedCoal.getIS(9))
                .itemOutputs(BlockList.QuintupleCompressedCoal.getIS(1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(BlockList.QuadrupleCompressedCoalCoke.getIS(9))
                .itemOutputs(BlockList.QuintupleCompressedCoalCoke.getIS(1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.BioBall.get(1L))
                .itemOutputs(com.dreammaster.item.ItemList.CompressedBioBall.getIS(1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(com.dreammaster.item.ItemList.BioOrganicMesh.getIS(1))
                .itemOutputs(com.dreammaster.item.ItemList.BioCarbonPlate.getIS(1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "reeds", 8, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "sapling", 8, WILDCARD, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "blockRubSapling", 8, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);

        if (TwilightForest.isModLoaded()) {
            GT_Values.RA.stdBuilder().itemInputs(getModItem(TwilightForest.ID, "tile.TFSapling", 8, WILDCARD, missing))
                    .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing))
                    .duration(15 * SECONDS).eut(2).addTo(compressorRecipes);
        }

        if (StevesCarts2.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnhancedGalgadorian, 9L))
                    .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1L, 48)).duration(15 * SECONDS).eut(2)
                    .addTo(compressorRecipes);
        }

        if (OpenComputers.isModLoaded()) {
            // Block of Chamelium
            GT_Values.RA.stdBuilder().itemInputs(getModItem(OpenComputers.ID, "item", 9L, 96))
                    .itemOutputs(getModItem(OpenComputers.ID, "chameliumBlock", 1L, 0)).duration(15 * SECONDS).eut(2)
                    .addTo(compressorRecipes);
        }

        if (IndustrialCraft2.isModLoaded()) {
            GT_Values.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemWeed", 16L))
                    .itemOutputs(ItemList.IC2_Plantball.get(1L)).duration(15 * SECONDS).eut(2).addTo(compressorRecipes);
        }

        if (ExtraTrees.isModLoaded()) {
            GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraTrees.ID, "food", 64L, 24))
                    .itemOutputs(ItemList.IC2_Plantball.get(1L)).duration(15 * SECONDS).eut(2).addTo(compressorRecipes);
        }
        if (GalacticraftCore.isModLoaded()) {
            GT_Values.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "item.cheeseCurd", 9, 0, missing))
                    .itemOutputs(getModItem(GalacticraftCore.ID, "tile.moonBlock", 1, 2, missing))
                    .duration(15 * SECONDS).eut(2).addTo(compressorRecipes);
        }
        if (ProjectRedCore.isModLoaded()) {
            GT_Values.RA.stdBuilder().itemInputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 57, missing))
                    .itemOutputs(getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 55, missing))
                    .duration(15 * SECONDS).eut(2).addTo(compressorRecipes);
        }
        if (StevesCarts2.isModLoaded()) {
            GT_Values.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 9, 46, missing))
                    .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 48, missing)).duration(15 * SECONDS)
                    .eut(2).addTo(compressorRecipes);
        }
        if (ThaumicTinkerer.isModLoaded()) {
            GT_Values.RA.stdBuilder().itemInputs(getModItem(ThaumicTinkerer.ID, "darkQuartzItem", 4, 0, missing))
                    .itemOutputs(getModItem(ThaumicTinkerer.ID, "darkQuartz", 1, 0, missing)).duration(15 * SECONDS)
                    .eut(2).addTo(compressorRecipes);
        }
        if (Forestry.isModLoaded()) {
            GT_Values.RA.stdBuilder().itemInputs(getModItem(Forestry.ID, "sapling", 8, WILDCARD, missing))
                    .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing))
                    .duration(15 * SECONDS).eut(2).addTo(compressorRecipes);
        }
    }

    private void makeAdvancedSolarPanelRecipes() {
        if (!AdvancedSolarPanel.isModLoaded()) {
            return;
        }
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L))
                .itemOutputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1L, 0)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Sunnarium, 1L))
                .itemOutputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1L, 9)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 9L, 9))
                .itemOutputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1L, 0)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
    }

    private void makeAvaritiaRecipes() {
        if (!Avaritia.isModLoaded()) {
            return;
        }
        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.crafting_table, 9))
                .itemOutputs(getModItem(Avaritia.ID, "Double_Craft", 1, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Avaritia.ID, "Double_Craft", 9, 0, missing))
                .itemOutputs(getModItem(Avaritia.ID, "Triple_Craft", 1, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Avaritia.ID, "Resource", 9, 1, missing))
                .itemOutputs(getModItem(Avaritia.ID, "Crystal_Matrix", 1, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
    }

    private void makeBiomesOPlentyRecipes() {
        if (!BiomesOPlenty.isModLoaded()) {
            return;
        }
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "packed_ice", 16, 0, missing))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "hardIce", 1, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "bones", 2, 0, missing))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "bones", 1, 1, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "bones", 2, 1, missing))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "bones", 1, 2, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "saplings", 8, WILDCARD, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "colorizedSaplings", 8, WILDCARD, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
    }

    private void makeBloodMagicRecipes() {
        if (!BloodArsenal.isModLoaded() || !BloodMagic.isModLoaded()) {
            return;
        }
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "blankSlate", 9, 0, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "reinforcedSlate", 9, 0, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 1, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "imbuedSlate", 9, 0, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 2, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "demonicSlate", 9, 0, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 3, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodMagic.ID, "bloodMagicBaseItems", 9, 27, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_stone", 1, 4, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_money", 4, 0, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_money", 1, 1, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_money", 4, 1, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_money", 1, 2, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BloodArsenal.ID, "blood_money", 4, 2, missing))
                .itemOutputs(getModItem(BloodArsenal.ID, "blood_money", 1, 3, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
    }

    private void makeExtraUtilitiesRecipes() {
        if (!ExtraUtilities.isModLoaded()) {
            return;
        }
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "unstableingot", 9, 2, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 5, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(ExtraUtilities.ID, "unstableingot", 9, 0, missing))
                .itemOutputs(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 5, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
    }

    private void makeGTPlusPlusRecipes() {
        if (!GTPlusPlus.isModLoaded()) {
            return;
        }
        // Compressed Glowstone
        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.glowstone, 9))
                .itemOutputs(getModItem(GTPlusPlus.ID, "blockCompressedObsidian", 1L, 6)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        // Double Compressed Glowstone
        GT_Values.RA.stdBuilder().itemInputs(getModItem(GTPlusPlus.ID, "blockCompressedObsidian", 9L, 6))
                .itemOutputs(getModItem(GTPlusPlus.ID, "blockCompressedObsidian", 1L, 7)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
    }

    private void makeHardcoreEnderExpansionRecipes() {
        if (!HardcoreEnderExpansion.isModLoaded()) {
            return;
        }
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.HeeEndium, 9L))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing))
                .duration(15 * SECONDS).eut(2).addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "dry_splinter", 9, 0, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "spooky_log", 1, 0, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
    }

    private void makeNaturaRecipes() {
        if (!Natura.isModLoaded()) {
            return;
        }
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "barleyFood", 8, 0))
                .itemOutputs(ItemList.IC2_Plantball.get(1)).duration(15 * SECONDS).eut(2).addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "florasapling", 8, WILDCARD, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Rare Sapling", 8, WILDCARD, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
    }

    private void makePamsHarvestCraftRecipes() {
        if (!PamsHarvestCraft.isModLoaded()) {
            return;
        }
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "silkentofuItem", 1, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "firmtofuItem", 1, 0, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "beeswaxItem", 4, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Forestry.ID, "beeswax", 4, 0, missing))
                .itemOutputs(getModItem(PamsHarvestCraft.ID, "waxItem", 1, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
    }

    private void makeRailcraftRecipes() {
        if (!Railcraft.isModLoaded()) {
            return;
        }
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "fuel.coke", 9, 0, missing))
                .itemOutputs(getModItem(Railcraft.ID, "cube", 1, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "slab", 2, 2, missing))
                .itemOutputs(getModItem(Railcraft.ID, "cube", 1, 1, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Railcraft.ID, "slab", 4, 38, missing))
                .itemOutputs(getModItem(Railcraft.ID, "cube", 1, 8, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.AdvancedCokeOvenBrick.get(4L))
                .itemOutputs(getModItem(Railcraft.ID, "machine.alpha", 1, 12, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CokeOvenBrick.get(4L))
                .itemOutputs(getModItem(Railcraft.ID, "machine.alpha", 1, 7, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
    }

    private void makeThaumcraftRecipes() {
        if (!Thaumcraft.isModLoaded() || !ThaumicBases.isModLoaded()) {
            return;
        }
        // Arcane Slabs -> Arcane Stone
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCosmeticSlabStone", 4L))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1L, 6)).duration(8 * SECONDS).eut(4)
                .addTo(compressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "ItemResource", 9, 4, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 5, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "rotten_flesh", 9, 0, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockTaint", 1, 2, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.ArcaneSlate.get(9L))
                .itemOutputs(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "ItemResource", 9, 3, missing))
                .itemOutputs(getModItem(ThaumicBases.ID, "quicksilverBlock", 1, 0, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCustomPlant", 8, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCustomPlant", 8, 1, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 1, 0, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
    }

    private void makeTinkerConstructRecipes() {
        if (!TinkerConstruct.isModLoaded()) {
            return;
        }
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 9L, 14))
                .itemOutputs(getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 7)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 4L, 2))
                .itemOutputs(getModItem(TinkerConstruct.ID, "Smeltery", 1L, 2)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1L, 12)).duration(5 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        // Slime crystals
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 4L, 0))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1L, 1)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "CraftedSoil", 4L, 2))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1L, 17)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.paper, 64, 0))
                .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1L, 0)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "strangeFood", 4, 0, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "slime.gel", 1, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "slime_ball", 4, 0, missing))
                .itemOutputs(getModItem(TinkerConstruct.ID, "slime.gel", 1, 1, missing)).duration(15 * SECONDS).eut(2)
                .addTo(compressorRecipes);
    }

    private void makeTinkersDefenceRecipes() {
        if (!TinkersDefence.isModLoaded()) {
            return;
        }
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkersDefence.ID, "AeonSteel Ingot", 9, 0, missing))
                .itemOutputs(getModItem(TinkersDefence.ID, "aeonsteelblock", 1, 0, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkersDefence.ID, "Queen's Gold Ingot", 9, 0, missing))
                .itemOutputs(getModItem(TinkersDefence.ID, "QueensGoldblock", 1, 0, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(TinkersDefence.ID, "DogbeariumIngot", 9, 0, missing))
                .itemOutputs(getModItem(TinkersDefence.ID, "Dogbeariumblock", 1, 0, missing)).duration(15 * SECONDS)
                .eut(2).addTo(compressorRecipes);
    }
}
