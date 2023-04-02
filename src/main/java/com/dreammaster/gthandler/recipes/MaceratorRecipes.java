package com.dreammaster.gthandler.recipes;

import static com.dreammaster.MissingModIDs.PamsHarvestTheNether;
import static gregtech.api.enums.ModIDs.AdvancedSolarPanel;
import static gregtech.api.enums.ModIDs.Avaritia;
import static gregtech.api.enums.ModIDs.GalacticraftCore;
import static gregtech.api.enums.ModIDs.GalacticraftMars;
import static gregtech.api.enums.ModIDs.GalaxySpace;
import static gregtech.api.enums.ModIDs.ThaumicBases;
import static gregtech.api.enums.ModIDs.TinkerConstruct;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.gthandler.CustomItemList;

import cpw.mods.fml.common.Loader;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class MaceratorRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.addPulveriserRecipe(
                new ItemStack(Items.glass_bottle, 1, 0),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L) },
                new int[] { 10000 },
                80,
                8);

        GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("IC2", "itemFuelPlantBall", 2L, 0),
                new ItemStack[] { CustomItemList.MaceratedPlantmass.get(1L), CustomItemList.MaceratedPlantmass.get(1L),
                        CustomItemList.MaceratedPlantmass.get(1L), CustomItemList.MaceratedPlantmass.get(1L) },
                new int[] { 10000, 10000, 5000, 2500 },
                200,
                30);

        GT_Values.RA.addPulveriserRecipe(
                GT_ModHandler.getModItem("IC2", "blockMiningPipe", 2L),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L), },
                new int[] { 10000 },
                100,
                16);

        GT_Values.RA.addPulveriserRecipe(
                new ItemStack(Items.flint, 2, 0),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L) },
                null,
                200,
                2);
        GT_Values.RA.addPulveriserRecipe(
                CustomItemList.CokeOvenBrick.get(1L),
                new ItemStack[] { CustomItemList.CokeOvenBrickDust.get(1L), CustomItemList.CokeOvenBrickDust.get(1L),
                        CustomItemList.CokeOvenBrickDust.get(1L), CustomItemList.CokeOvenBrickDust.get(1L) },
                new int[] { 10000, 2500, 750, 500 },
                200,
                30);
        GT_Values.RA.addPulveriserRecipe(
                CustomItemList.AdvancedCokeOvenBrick.get(1L),
                new ItemStack[] { CustomItemList.AdvancedCokeOvenBrickDust.get(1L),
                        CustomItemList.AdvancedCokeOvenBrickDust.get(1L),
                        CustomItemList.AdvancedCokeOvenBrickDust.get(1L),
                        CustomItemList.AdvancedCokeOvenBrickDust.get(1L) },
                new int[] { 10000, 2500, 750, 500 },
                200,
                120);

        GT_Values.RA.addPulveriserRecipe(
                ItemList.GalliumArsenideCrystal.get(1L),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 2) },
                new int[] { 10000 },
                100,
                4);
        GT_Values.RA.addPulveriserRecipe(
                ItemList.GalliumArsenideCrystalSmallPart.get(1L),
                new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1) },
                new int[] { 10000 },
                25,
                4);

        // recipes for everything that uses sand
        for (int i = 0; i < OreDictionary.getOres("sand").size(); ++i) {
            GT_Values.RA.addPulveriserRecipe(
                    OreDictionary.getOres("sand").get(i),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L) },
                    new int[] { 10000, 2500, 2000, 1500 },
                    200,
                    8);

        }

        if (Loader.isModLoaded("openprinter")) {

            // Open Printers
            // Paper shreds
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem("openprinter", "openprinter.paperShreds", 1L, 0),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Paper, 1L) },
                    new int[] { 10000 },
                    20,
                    2);
        }

        if (ThaumicBases.isModLoaded()) {
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(ThaumicBases.modID, "resource", 1L, 7),
                    new ItemStack[] { GT_ModHandler.getModItem(ThaumicBases.modID, "tobaccoPowder", 1L, 0) },
                    new int[] { 10000 },
                    10,
                    2);
        }

        if (TinkerConstruct.isModLoaded()) {

            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "materials", 1L, 4),
                    new ItemStack[] { Materials.Ardite.getDust(1) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "MetalBlock", 1L, 1),
                    new ItemStack[] { Materials.Ardite.getDust(9) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "SearedBrick", 1L, 1),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Cobalt, 2L),
                            Materials.Cobalt.getDust(1) },
                    new int[] { 10000, 1000 },
                    400,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "SearedBrick", 1L, 2),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Ardite, 2L),
                            Materials.Ardite.getDust(1) },
                    new int[] { 10000, 1000 },
                    400,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "GravelOre", 1L, 4),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Aluminium, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bauxite, 1L) },
                    new int[] { 10000, 1000 },
                    400,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "materials", 1L, 12),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "materials", 1L, 14),
                    new ItemStack[] { GT_ModHandler.getModItem(TinkerConstruct.modID, "materials", 1L, 42) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "MetalBlock", 1L, 7),
                    new ItemStack[] { GT_ModHandler.getModItem(TinkerConstruct.modID, "materials", 9L, 42) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "MetalBlock", 1L, 0),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 9L) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "materials", 1L, 5),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "MetalBlock", 1L, 2),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 9L) },
                    new int[] { 10000 },
                    300,
                    2);

            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "MetalBlock", 1L, 10),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 9L) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "woodPattern", 1L, GT_Values.W),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L) },
                    new int[] { 10000 },
                    200,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "Pattern", 1L, GT_Values.W),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L) },
                    new int[] { 10000 },
                    200,
                    2);

            // Oreberries
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "oreBerries", 1L, 0),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Iron, 1L) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "oreBerries", 1L, 1),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gold, 1L) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "oreBerries", 1L, 2),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Copper, 1L) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "oreBerries", 1L, 3),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tin, 1L) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(TinkerConstruct.modID, "oreBerries", 1L, 4),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Aluminium, 1L) },
                    new int[] { 10000 },
                    300,
                    2);
        }

        if (Avaritia.isModLoaded()) {
            GT_Values.RA.addPulveriserRecipe(
                    new ItemStack(Items.record_11, 1, 0),
                    new ItemStack[] { GT_ModHandler.getModItem(Avaritia.modID, "Resource", 9L, 7) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    new ItemStack(Items.record_13, 1, 0),
                    new ItemStack[] { GT_ModHandler.getModItem(Avaritia.modID, "Resource", 9L, 7) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    new ItemStack(Items.record_cat, 1, 0),
                    new ItemStack[] { GT_ModHandler.getModItem(Avaritia.modID, "Resource", 9L, 7) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    new ItemStack(Items.record_blocks, 1, 0),
                    new ItemStack[] { GT_ModHandler.getModItem(Avaritia.modID, "Resource", 9L, 7) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    new ItemStack(Items.record_chirp, 1, 0),
                    new ItemStack[] { GT_ModHandler.getModItem(Avaritia.modID, "Resource", 9L, 7) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    new ItemStack(Items.record_far, 1, 0),
                    new ItemStack[] { GT_ModHandler.getModItem(Avaritia.modID, "Resource", 9L, 7) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    new ItemStack(Items.record_mellohi, 1, 0),
                    new ItemStack[] { GT_ModHandler.getModItem(Avaritia.modID, "Resource", 9L, 7) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    new ItemStack(Items.record_mall, 1, 0),
                    new ItemStack[] { GT_ModHandler.getModItem(Avaritia.modID, "Resource", 9L, 7) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    new ItemStack(Items.record_stal, 1, 0),
                    new ItemStack[] { GT_ModHandler.getModItem(Avaritia.modID, "Resource", 9L, 7) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    new ItemStack(Items.record_strad, 1, 0),
                    new ItemStack[] { GT_ModHandler.getModItem(Avaritia.modID, "Resource", 9L, 7) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    new ItemStack(Items.record_ward, 1, 0),
                    new ItemStack[] { GT_ModHandler.getModItem(Avaritia.modID, "Resource", 9L, 7) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    new ItemStack(Items.record_wait, 1, 0),
                    new ItemStack[] { GT_ModHandler.getModItem(Avaritia.modID, "Resource", 9L, 7) },
                    new int[] { 10000 },
                    300,
                    2);
        }

        if (AdvancedSolarPanel.isModLoaded()) {
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(AdvancedSolarPanel.modID, "asp_crafting_items", 1L, 0),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L) },
                    new int[] { 10000 },
                    300,
                    2);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(AdvancedSolarPanel.modID, "asp_crafting_items", 1L, 9),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Sunnarium, 1L) },
                    new int[] { 10000 },
                    30,
                    2);
        }

        if (PamsHarvestTheNether.isModLoaded()) {
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(PamsHarvestTheNether.modID, "fleshrootItem", 9L, 0),
                    new ItemStack[] { GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L) },
                    new int[] { 10000 },
                    100,
                    2);
        }

        if (GalacticraftCore.isModLoaded()) {
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.moonBlock", 1L, 3),
                    new ItemStack[] { CustomItemList.MoonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1) },
                    new int[] { 10000, 1250 },
                    400,
                    30);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.moonBlock", 1L, 4),
                    new ItemStack[] { CustomItemList.MoonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1) },
                    new int[] { 10000, 1250 },
                    400,
                    30);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalacticraftCore.modID, "tile.moonBlock", 1L, 5),
                    new ItemStack[] { CustomItemList.MoonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1) },
                    new int[] { 10000, 1250 },
                    400,
                    30);
        }

        if (GalacticraftMars.isModLoaded()) {
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.mars", 1L, 4),
                    new ItemStack[] { CustomItemList.MarsStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1) },
                    new int[] { 10000, 1000 },
                    400,
                    64);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.mars", 1L, 5),
                    new ItemStack[] { CustomItemList.MarsStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1) },
                    new int[] { 10000, 1000 },
                    400,
                    64);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.mars", 1L, 6),
                    new ItemStack[] { CustomItemList.MarsStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1) },
                    new int[] { 10000, 1000 },
                    400,
                    64);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.mars", 1L, 9),
                    new ItemStack[] { CustomItemList.MarsStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1) },
                    new int[] { 10000, 1000 },
                    400,
                    64);
        }

        if (GalaxySpace.isModLoaded()) {
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "phobosblocks", 1L, 0),
                    new ItemStack[] { CustomItemList.PhobosStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1) },
                    new int[] { 10000, 1250 },
                    400,
                    64);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "phobosblocks", 1L, 1),
                    new ItemStack[] { CustomItemList.PhobosStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1) },
                    new int[] { 10000, 1250 },
                    400,
                    64);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "phobosblocks", 1L, 2),
                    new ItemStack[] { CustomItemList.PhobosStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1) },
                    new int[] { 10000, 1250 },
                    400,
                    64);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "deimosblocks", 1L, 0),
                    new ItemStack[] { CustomItemList.DeimosStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesite, 1) },
                    new int[] { 10000, 1250 },
                    400,
                    64);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "deimosblocks", 1L, 1),
                    new ItemStack[] { CustomItemList.DeimosStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesite, 1) },
                    new int[] { 10000, 1250 },
                    400,
                    64);
        }

        if (Loader.isModLoaded(GalacticraftMars.modID)) {
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.asteroidsBlock", 1L, 0),
                    new ItemStack[] { CustomItemList.AsteroidsStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1) },
                    new int[] { 10000, 1000, 500 },
                    400,
                    120);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.asteroidsBlock", 1L, 1),
                    new ItemStack[] { CustomItemList.AsteroidsStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1) },
                    new int[] { 10000, 1000, 500 },
                    400,
                    120);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalacticraftMars.modID, "tile.asteroidsBlock", 1L, 2),
                    new ItemStack[] { CustomItemList.AsteroidsStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1) },
                    new int[] { 10000, 1000, 500 },
                    400,
                    120);
        }

        if (GalaxySpace.isModLoaded()) {
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "ceresblocks", 1L, 0),
                    new ItemStack[] { CustomItemList.CeresStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Beryllium, 1) },
                    new int[] { 10000, 1250, 625 },
                    400,
                    120);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "ceresblocks", 1L, 1),
                    new ItemStack[] { CustomItemList.CeresStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Beryllium, 1) },
                    new int[] { 10000, 1250, 625 },
                    400,
                    120);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "europagrunt", 1L, 1),
                    new ItemStack[] { CustomItemList.EuropaIceDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1) },
                    new int[] { 10000, 1250, 625 },
                    400,
                    120);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "europaunderwatergeyser", 1L, 0),
                    new ItemStack[] { CustomItemList.EuropaIceDust.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 2),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 2) },
                    new int[] { 10000, 1250, 625 },
                    400,
                    120);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "europagrunt", 1L, 0),
                    new ItemStack[] { CustomItemList.EuropaStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1) },
                    new int[] { 10000, 1250, 500 },
                    400,
                    120);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "europageyser", 1L, 0),
                    new ItemStack[] { CustomItemList.EuropaStoneDust.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 2),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 2) },
                    new int[] { 10000, 1250, 875 },
                    400,
                    120);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "ganymedeblocks", 1L, 0),
                    new ItemStack[] { CustomItemList.GanymedeStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chromite, 1) },
                    new int[] { 10000, 875, 250 },
                    400,
                    120);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "ganymedeblocks", 1L, 1),
                    new ItemStack[] { CustomItemList.GanymedeStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chromite, 1) },
                    new int[] { 10000, 875, 250 },
                    400,
                    120);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "callistoblocks", 1L, 0),
                    new ItemStack[] { CustomItemList.CallistoStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CallistoIce, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 1) },
                    new int[] { 10000, 1250, 625 },
                    400,
                    120);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "callistoblocks", 1L, 1),
                    new ItemStack[] { CustomItemList.CallistoStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CallistoIce, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 1) },
                    new int[] { 10000, 1250, 625 },
                    400,
                    120);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "ioblocks", 1L, 0),
                    new ItemStack[] { CustomItemList.IoStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1) },
                    new int[] { 10000, 1250, 625, 375 },
                    400,
                    256);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "ioblocks", 1L, 1),
                    new ItemStack[] { CustomItemList.IoStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1) },
                    new int[] { 10000, 1250, 750, 500 },
                    400,
                    256);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "ioblocks", 1L, 2),
                    new ItemStack[] { CustomItemList.IoStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1) },
                    new int[] { 10000, 1250, 625, 375 },
                    400,
                    256);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "venusblocks", 1L, 0),
                    new ItemStack[] { CustomItemList.VenusStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mytryl, 1) },
                    new int[] { 10000, 1125, 625, 375 },
                    400,
                    256);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "venusblocks", 1L, 1),
                    new ItemStack[] { CustomItemList.VenusStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mytryl, 1) },
                    new int[] { 10000, 1125, 625, 375 },
                    400,
                    256);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "mercuryblocks", 1L, 0),
                    new ItemStack[] { CustomItemList.MercuryStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1) },
                    new int[] { 10000, 750, 500, 300 },
                    400,
                    256);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "mercuryblocks", 1L, 1),
                    new ItemStack[] { CustomItemList.MercuryStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1) },
                    new int[] { 10000, 750, 500, 300 },
                    400,
                    256);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "mercuryblocks", 1L, 2),
                    new ItemStack[] { CustomItemList.MercuryCoreDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1) },
                    new int[] { 10000, 750, 500, 300 },
                    400,
                    256);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "enceladusblocks", 1L, 0),
                    new ItemStack[] { CustomItemList.EnceladusIceDust.get(1L),
                            CustomItemList.MysteriousCrystalDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1) },
                    new int[] { 10000, 1500, 500, 250 },
                    400,
                    480);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "enceladusblocks", 1L, 1),
                    new ItemStack[] { CustomItemList.EnceladusStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1) },
                    new int[] { 10000, 750, 500, 250 },
                    400,
                    480);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "enceladusblocks", 1L, 3),
                    new ItemStack[] { CustomItemList.EnceladusIceDust.get(1L),
                            CustomItemList.MysteriousCrystalDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1) },
                    new int[] { 10000, 1500, 500, 250 },
                    400,
                    480);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "titanblocks", 1L, 0),
                    new ItemStack[] { CustomItemList.TitanStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1) },
                    new int[] { 10000, 1125, 750, 500 },
                    400,
                    480);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "titanblocks", 1L, 1),
                    new ItemStack[] { CustomItemList.TitanStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1) },
                    new int[] { 10000, 1125, 750, 500 },
                    400,
                    480);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "titanblocks", 1L, 2),
                    new ItemStack[] { CustomItemList.TitanStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1) },
                    new int[] { 10000, 1125, 750, 500 },
                    400,
                    480);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "oberonblocks", 1L, 0),
                    new ItemStack[] { CustomItemList.OberonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1) },
                    new int[] { 10000, 500, 250, 212 },
                    400,
                    480);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "oberonblocks", 1L, 1),
                    new ItemStack[] { CustomItemList.OberonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1) },
                    new int[] { 10000, 500, 250, 212 },
                    400,
                    480);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "oberonblocks", 1L, 2),
                    new ItemStack[] { CustomItemList.OberonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1) },
                    new int[] { 10000, 500, 250, 212 },
                    400,
                    480);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "mirandablocks", 1L, 0),
                    new ItemStack[] { CustomItemList.MirandaStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1) },
                    new int[] { 10000, 625, 375, 250 },
                    400,
                    480);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "mirandablocks", 1L, 1),
                    new ItemStack[] { CustomItemList.MirandaStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1) },
                    new int[] { 10000, 625, 375, 250 },
                    400,
                    480);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "mirandablocks", 1L, 2),
                    new ItemStack[] { CustomItemList.MirandaStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1) },
                    new int[] { 10000, 625, 375, 250 },
                    400,
                    480);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "proteusblocks", 1L, 0),
                    new ItemStack[] { CustomItemList.ProteusStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 1) },
                    new int[] { 10000, 1250, 625, 250 },
                    400,
                    1024);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "proteusblocks", 1L, 1),
                    new ItemStack[] { CustomItemList.ProteusStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 1) },
                    new int[] { 10000, 1250, 625, 250 },
                    400,
                    1024);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "proteusblocks", 1L, 2),
                    new ItemStack[] { CustomItemList.ProteusStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 1) },
                    new int[] { 10000, 1250, 625, 250 },
                    400,
                    1024);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "tritonblocks", 1L, 0),
                    new ItemStack[] { CustomItemList.TritonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1) },
                    new int[] { 10000, 1250, 625, 250 },
                    400,
                    1024);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "tritonblocks", 1L, 1),
                    new ItemStack[] { CustomItemList.TritonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1) },
                    new int[] { 10000, 1250, 625, 250 },
                    400,
                    1024);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "tritonblocks", 1L, 2),
                    new ItemStack[] { CustomItemList.TritonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1) },
                    new int[] { 10000, 1250, 625, 250 },
                    400,
                    1024);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "plutoblocks", 1L, 0),
                    new ItemStack[] { CustomItemList.PlutoIceDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1) },
                    new int[] { 10000, 1250, 625, 312 },
                    400,
                    1920);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "plutoblocks", 1L, 1),
                    new ItemStack[] { CustomItemList.PlutoIceDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1) },
                    new int[] { 10000, 1250, 625, 312 },
                    400,
                    1920);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "plutoblocks", 1L, 2),
                    new ItemStack[] { CustomItemList.PlutoIceDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1) },
                    new int[] { 10000, 1250, 625, 312 },
                    400,
                    1920);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "plutoblocks", 1L, 3),
                    new ItemStack[] { CustomItemList.PlutoIceDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1) },
                    new int[] { 10000, 1250, 625, 312 },
                    400,
                    1920);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "plutoblocks", 1L, 4),
                    new ItemStack[] { CustomItemList.PlutoIceDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1) },
                    new int[] { 10000, 1250, 625, 312 },
                    400,
                    1920);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "plutoblocks", 1L, 5),
                    new ItemStack[] { CustomItemList.PlutoStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1) },
                    new int[] { 10000, 1250, 625, 212 },
                    400,
                    1920);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "makemakegrunt", 1L, 0),
                    new ItemStack[] { CustomItemList.MakeMakeStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetRed, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetYellow, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1) },
                    new int[] { 10000, 625, 625, 250 },
                    400,
                    1920);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "makemakegrunt", 1L, 1),
                    new ItemStack[] { CustomItemList.MakeMakeStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetRed, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetYellow, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1) },
                    new int[] { 10000, 625, 625, 250 },
                    400,
                    1920);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "haumeablocks", 1L, 0),
                    new ItemStack[] { CustomItemList.HaumeaStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedGold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 1) },
                    new int[] { 10000, 1250, 625, 212 },
                    400,
                    1920);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "acentauribbgrunt", 1L, 0),
                    new ItemStack[] { CustomItemList.CentauriASurfaceDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1) },
                    new int[] { 10000, 1250, 750, 250 },
                    400,
                    4096);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "acentauribbsubgrunt", 1L, 0),
                    new ItemStack[] { CustomItemList.CentauriAStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 1) },
                    new int[] { 10000, 1250, 750, 125 },
                    400,
                    4096);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "vegabsubgrunt", 1L, 0),
                    new ItemStack[] { CustomItemList.VegaBStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 1) },
                    new int[] { 10000, 1250, 750, 375 },
                    400,
                    4096);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "vegabgrunt", 1L, 0),
                    new ItemStack[] { CustomItemList.VegaBStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 1) },
                    new int[] { 10000, 1250, 750, 375 },
                    400,
                    4096);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "barnardaEgrunt", 1L, 0),
                    new ItemStack[] { CustomItemList.BarnardaEStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1) },
                    new int[] { 10000, 625, 500, 375 },
                    400,
                    4096);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "barnardaEsubgrunt", 1L, 0),
                    new ItemStack[] { CustomItemList.BarnardaEStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1) },
                    new int[] { 10000, 625, 500, 375 },
                    400,
                    4096);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "barnardaFgrunt", 1L, 0),
                    new ItemStack[] { CustomItemList.BarnardaFStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1) },
                    new int[] { 10000, 625, 500, 375 },
                    400,
                    4096);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "barnardaFsubgrunt", 1L, 0),
                    new ItemStack[] { CustomItemList.BarnardaFStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1) },
                    new int[] { 10000, 625, 500, 375 },
                    400,
                    4096);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "tcetieblocks", 1L, 0),
                    new ItemStack[] { CustomItemList.TCetiEStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1) },
                    new int[] { 10000, 625, 500, 375 },
                    400,
                    4096);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "tcetieblocks", 1L, 1),
                    new ItemStack[] { CustomItemList.TCetiEStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1) },
                    new int[] { 10000, 625, 500, 375 },
                    400,
                    4096);
            GT_Values.RA.addPulveriserRecipe(
                    GT_ModHandler.getModItem(GalaxySpace.modID, "tcetieblocks", 1L, 2),
                    new ItemStack[] { CustomItemList.TCetiEStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1) },
                    new int[] { 10000, 625, 500, 375 },
                    400,
                    4096);
        }
    }
}
