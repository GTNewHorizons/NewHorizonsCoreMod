package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IScriptLoader.wildcard;
import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.OpenPrinters;
import static gregtech.api.enums.Mods.PamsHarvestTheNether;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;

public class MaceratorRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glass_bottle, 1, 0))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L)).outputChances(10000)
                .duration(4 * SECONDS).eut(8).addTo(maceratorRecipes);

        if (IndustrialCraft2.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 2L, 0))
                    .itemOutputs(
                            CustomItemList.MaceratedPlantmass.get(1L),
                            CustomItemList.MaceratedPlantmass.get(1L),
                            CustomItemList.MaceratedPlantmass.get(1L),
                            CustomItemList.MaceratedPlantmass.get(1L))
                    .outputChances(10000, 10000, 5000, 2500).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(IndustrialCraft2.ID, "blockMiningPipe", 2L))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L)).outputChances(10000)
                    .duration(5 * SECONDS).eut(16).addTo(maceratorRecipes);

        }

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.flint, 2, 0))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L)).duration(10 * SECONDS)
                .eut(2).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.CokeOvenBrick.get(1L))
                .itemOutputs(
                        CustomItemList.CokeOvenBrickDust.get(1L),
                        CustomItemList.CokeOvenBrickDust.get(1L),
                        CustomItemList.CokeOvenBrickDust.get(1L),
                        CustomItemList.CokeOvenBrickDust.get(1L))
                .outputChances(10000, 2500, 750, 500).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.AdvancedCokeOvenBrick.get(1L))
                .itemOutputs(
                        CustomItemList.AdvancedCokeOvenBrickDust.get(1L),
                        CustomItemList.AdvancedCokeOvenBrickDust.get(1L),
                        CustomItemList.AdvancedCokeOvenBrickDust.get(1L),
                        CustomItemList.AdvancedCokeOvenBrickDust.get(1L))
                .outputChances(10000, 2500, 750, 500).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.GalliumArsenideCrystal.get(1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 2))
                .outputChances(10000).duration(5 * SECONDS).eut(4).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.GalliumArsenideCrystalSmallPart.get(1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1))
                .outputChances(10000).duration(1 * SECONDS + 5 * TICKS).eut(4).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.sand, 1, wildcard))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L))
                .outputChances(10000, 2500, 2000, 1500).duration(10 * SECONDS).eut(8).addTo(maceratorRecipes);

        if (OpenPrinters.isModLoaded()) {

            // Open Printers
            // Paper shreds
            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(OpenPrinters.ID, "openprinter.paperShreds", 1L, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Paper, 1L)).outputChances(10000)
                    .duration(20 * TICKS).eut(2).addTo(maceratorRecipes);

        }

        if (ThaumicBases.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(ThaumicBases.ID, "resource", 1L, 7))
                    .itemOutputs(GTModHandler.getModItem(ThaumicBases.ID, "tobaccoPowder", 1L, 0)).outputChances(10000)
                    .duration(10 * TICKS).eut(2).addTo(maceratorRecipes);

        }

        if (TinkerConstruct.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 4))
                    .itemOutputs(Materials.Ardite.getDust(1)).outputChances(10000).duration(15 * SECONDS).eut(2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 1))
                    .itemOutputs(Materials.Ardite.getDust(9)).outputChances(10000).duration(15 * SECONDS).eut(2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "SearedBrick", 1L, 1))
                    .itemOutputs(
                            GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Cobalt, 2L),
                            Materials.Cobalt.getDust(1))
                    .outputChances(10000, 1000).duration(20 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "SearedBrick", 1L, 2))
                    .itemOutputs(
                            GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Ardite, 2L),
                            Materials.Ardite.getDust(1))
                    .outputChances(10000, 1000).duration(20 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 12))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L))
                    .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 14))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 42)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 7))
                    .itemOutputs(GTModHandler.getModItem(TinkerConstruct.ID, "materials", 9L, 42)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 9L)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 5))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L))
                    .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 2))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 9L))
                    .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 10))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 9L))
                    .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "woodPattern", 1L, GTValues.W))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L)).outputChances(10000)
                    .duration(10 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "Pattern", 1L, GTValues.W))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L)).outputChances(10000)
                    .duration(10 * SECONDS).eut(2).addTo(maceratorRecipes);
            // Oreberries

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "oreBerries", 9L, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L)).outputChances(10000)
                    .duration(15 * SECONDS).eut(18).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "oreBerries", 9L, 1))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L)).outputChances(10000)
                    .duration(15 * SECONDS).eut(18).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "oreBerries", 9L, 2))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L)).outputChances(10000)
                    .duration(15 * SECONDS).eut(18).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "oreBerries", 9L, 3))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1L)).outputChances(10000)
                    .duration(15 * SECONDS).eut(18).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(TinkerConstruct.ID, "oreBerries", 9L, 4))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L))
                    .outputChances(10000).duration(15 * SECONDS).eut(18).addTo(maceratorRecipes);

        }

        if (Avaritia.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_11, 1, 0))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_13, 1, 0))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_cat, 1, 0))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_blocks, 1, 0))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_chirp, 1, 0))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_far, 1, 0))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_mellohi, 1, 0))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_mall, 1, 0))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_stal, 1, 0))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_strad, 1, 0))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_ward, 1, 0))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_wait, 1, 0))
                    .itemOutputs(GTModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

        }

        if (AdvancedSolarPanel.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1L, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L))
                    .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1L, 9))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Sunnarium, 1L))
                    .outputChances(10000).duration(1 * SECONDS + 10 * TICKS).eut(2).addTo(maceratorRecipes);

        }

        if (PamsHarvestTheNether.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(PamsHarvestTheNether.ID, "fleshrootItem", 9L, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L)).outputChances(10000)
                    .duration(5 * SECONDS).eut(2).addTo(maceratorRecipes);

        }

        if (GalacticraftCore.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalacticraftCore.ID, "tile.moonBlock", 1L, 3))
                    .itemOutputs(
                            CustomItemList.MoonStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalacticraftCore.ID, "tile.moonBlock", 1L, 4))
                    .itemOutputs(
                            CustomItemList.MoonStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalacticraftCore.ID, "tile.moonBlock", 1L, 5))
                    .itemOutputs(
                            CustomItemList.MoonStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(maceratorRecipes);

        }

        if (GalacticraftMars.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalacticraftMars.ID, "tile.mars", 1L, 4))
                    .itemOutputs(
                            CustomItemList.MarsStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1000).duration(20 * SECONDS).eut(64).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalacticraftMars.ID, "tile.mars", 1L, 5))
                    .itemOutputs(
                            CustomItemList.MarsStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1000).duration(20 * SECONDS).eut(64).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalacticraftMars.ID, "tile.mars", 1L, 6))
                    .itemOutputs(
                            CustomItemList.MarsStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1000).duration(20 * SECONDS).eut(64).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalacticraftMars.ID, "tile.mars", 1L, 9))
                    .itemOutputs(
                            CustomItemList.MarsStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1000).duration(20 * SECONDS).eut(64).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1L, 0))
                    .itemOutputs(
                            CustomItemList.AsteroidsStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1))
                    .outputChances(10000, 1000, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1L, 1))
                    .itemOutputs(
                            CustomItemList.AsteroidsStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1))
                    .outputChances(10000, 1000, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1L, 2))
                    .itemOutputs(
                            CustomItemList.AsteroidsStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1))
                    .outputChances(10000, 1000, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

        }

        if (GalaxySpace.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "phobosblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.PhobosStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(64).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "phobosblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.PhobosStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(64).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "phobosblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.PhobosStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(64).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "deimosblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.DeimosStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesite, 1))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(64).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "deimosblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.DeimosStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesite, 1))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(64).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.CeresStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Beryllium, 1))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.CeresStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Beryllium, 1))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "europagrunt", 1L, 1))
                    .itemOutputs(
                            CustomItemList.EuropaIceDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "europaunderwatergeyser", 1L, 0))
                    .itemOutputs(
                            CustomItemList.EuropaIceDust.get(2L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 2),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 2))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "europagrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.EuropaStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1))
                    .outputChances(10000, 1250, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "europageyser", 1L, 0))
                    .itemOutputs(
                            CustomItemList.EuropaStoneDust.get(2L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 2),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 2))
                    .outputChances(10000, 1250, 875).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "ganymedeblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.GanymedeStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chromite, 1))
                    .outputChances(10000, 875, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "ganymedeblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.GanymedeStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chromite, 1))
                    .outputChances(10000, 875, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "callistoblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.CallistoStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.CallistoIce, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 1))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "callistoblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.CallistoStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.CallistoIce, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 1))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.IoStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1))
                    .outputChances(10000, 1250, 625, 375).duration(20 * SECONDS).eut(256).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.IoStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1))
                    .outputChances(10000, 1250, 750, 500).duration(20 * SECONDS).eut(256).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.IoStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1))
                    .outputChances(10000, 1250, 625, 375).duration(20 * SECONDS).eut(256).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "venusblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.VenusStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Mytryl, 1))
                    .outputChances(10000, 1125, 625, 375).duration(20 * SECONDS).eut(256).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "venusblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.VenusStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Mytryl, 1))
                    .outputChances(10000, 1125, 625, 375).duration(20 * SECONDS).eut(256).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "mercuryblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.MercuryStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1))
                    .outputChances(10000, 750, 500, 300).duration(20 * SECONDS).eut(256).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "mercuryblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.MercuryStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1))
                    .outputChances(10000, 750, 500, 300).duration(20 * SECONDS).eut(256).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "mercuryblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.MercuryCoreDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1))
                    .outputChances(10000, 750, 500, 300).duration(20 * SECONDS).eut(256).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "enceladusblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.EnceladusIceDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1))
                    .outputChances(10000, 1500, 500, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "enceladusblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.EnceladusStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1))
                    .outputChances(10000, 750, 500, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "enceladusblocks", 1L, 3))
                    .itemOutputs(
                            CustomItemList.EnceladusIceDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1))
                    .outputChances(10000, 1500, 500, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "titanblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.TitanStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1))
                    .outputChances(10000, 1125, 750, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "titanblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.TitanStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1))
                    .outputChances(10000, 1125, 750, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "titanblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.TitanStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1))
                    .outputChances(10000, 1125, 750, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "oberonblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.OberonStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1))
                    .outputChances(10000, 500, 250, 212).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "oberonblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.OberonStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1))
                    .outputChances(10000, 500, 250, 212).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "oberonblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.OberonStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1))
                    .outputChances(10000, 500, 250, 212).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "mirandablocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.MirandaStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1))
                    .outputChances(10000, 625, 375, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "mirandablocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.MirandaStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1))
                    .outputChances(10000, 625, 375, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "mirandablocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.MirandaStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1))
                    .outputChances(10000, 625, 375, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "proteusblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.ProteusStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 1))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(1024).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "proteusblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.ProteusStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 1))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(1024).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "proteusblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.ProteusStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 1))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(1024).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "tritonblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.TritonStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(1024).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "tritonblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.TritonStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(1024).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "tritonblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.TritonStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(1024).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "plutoblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.PlutoIceDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1))
                    .outputChances(10000, 1250, 625, 312).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "plutoblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.PlutoIceDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1))
                    .outputChances(10000, 1250, 625, 312).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "plutoblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.PlutoIceDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1))
                    .outputChances(10000, 1250, 625, 312).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "plutoblocks", 1L, 3))
                    .itemOutputs(
                            CustomItemList.PlutoIceDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1))
                    .outputChances(10000, 1250, 625, 312).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "plutoblocks", 1L, 4))
                    .itemOutputs(
                            CustomItemList.PlutoIceDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1))
                    .outputChances(10000, 1250, 625, 312).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "plutoblocks", 1L, 5))
                    .itemOutputs(
                            CustomItemList.PlutoStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1))
                    .outputChances(10000, 1250, 625, 212).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "makemakegrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.MakeMakeStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.GarnetRed, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.GarnetYellow, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1))
                    .outputChances(10000, 625, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "makemakegrunt", 1L, 1))
                    .itemOutputs(
                            CustomItemList.MakeMakeStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.GarnetRed, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.GarnetYellow, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1))
                    .outputChances(10000, 625, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "haumeablocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.HaumeaStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfusedGold, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 1))
                    .outputChances(10000, 1250, 625, 212).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "acentauribbgrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.CentauriASurfaceDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1))
                    .outputChances(10000, 1250, 750, 250).duration(20 * SECONDS).eut(4096).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "acentauribbsubgrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.CentauriAStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 1))
                    .outputChances(10000, 1250, 750, 125).duration(20 * SECONDS).eut(4096).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "vegabsubgrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.VegaBStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 1))
                    .outputChances(10000, 1250, 750, 375).duration(20 * SECONDS).eut(4096).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "vegabgrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.VegaBStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 1))
                    .outputChances(10000, 1250, 750, 375).duration(20 * SECONDS).eut(4096).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "barnardaEgrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.BarnardaEStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(4096).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "barnardaEsubgrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.BarnardaEStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(4096).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "barnardaFgrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.BarnardaFStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(4096).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "barnardaFsubgrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.BarnardaFStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(4096).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "tcetieblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.TCetiEStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(4096).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "tcetieblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.TCetiEStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(4096).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(GalaxySpace.ID, "tcetieblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.TCetiEStoneDust.get(1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(4096).addTo(maceratorRecipes);

        }
    }
}
