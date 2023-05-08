package com.dreammaster.gthandler.recipes;

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
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class MaceratorRecipes implements Runnable {

    @Override
    public void run() {
        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.glass_bottle, 1, 0))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(4 * SECONDS).eut(8).addTo(sMaceratorRecipes);

        if (IndustrialCraft2.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 2L, 0))
                    .itemOutputs(
                            CustomItemList.MaceratedPlantmass.get(1L),
                            CustomItemList.MaceratedPlantmass.get(1L),
                            CustomItemList.MaceratedPlantmass.get(1L),
                            CustomItemList.MaceratedPlantmass.get(1L))
                    .outputChances(10000, 10000, 5000, 2500).noFluidInputs().noFluidOutputs().duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "blockMiningPipe", 2L))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(5 * SECONDS).eut(16).addTo(sMaceratorRecipes);

        }

        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.flint, 2, 0))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L)).noFluidInputs()
                .noFluidOutputs().duration(10 * SECONDS).eut(2).addTo(sMaceratorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.CokeOvenBrick.get(1L))
                .itemOutputs(
                        CustomItemList.CokeOvenBrickDust.get(1L),
                        CustomItemList.CokeOvenBrickDust.get(1L),
                        CustomItemList.CokeOvenBrickDust.get(1L),
                        CustomItemList.CokeOvenBrickDust.get(1L))
                .outputChances(10000, 2500, 750, 500).noFluidInputs().noFluidOutputs().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sMaceratorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.AdvancedCokeOvenBrick.get(1L))
                .itemOutputs(
                        CustomItemList.AdvancedCokeOvenBrickDust.get(1L),
                        CustomItemList.AdvancedCokeOvenBrickDust.get(1L),
                        CustomItemList.AdvancedCokeOvenBrickDust.get(1L),
                        CustomItemList.AdvancedCokeOvenBrickDust.get(1L))
                .outputChances(10000, 2500, 750, 500).noFluidInputs().noFluidOutputs().duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sMaceratorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.GalliumArsenideCrystal.get(1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GalliumArsenide, 2))
                .outputChances(10000).noFluidInputs().noFluidOutputs().duration(5 * SECONDS).eut(4)
                .addTo(sMaceratorRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.GalliumArsenideCrystalSmallPart.get(1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.GalliumArsenide, 1))
                .outputChances(10000).noFluidInputs().noFluidOutputs().duration(1 * SECONDS + 5 * TICKS).eut(4)
                .addTo(sMaceratorRecipes);

        // recipes for everything that uses sand
        for (int i = 0; i < OreDictionary.getOres("sand").size(); ++i) {
            GT_Values.RA.stdBuilder().itemInputs(OreDictionary.getOres("sand").get(i))
                    .itemOutputs(
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.QuartzSand, 1L))
                    .outputChances(10000, 2500, 2000, 1500).noFluidInputs().noFluidOutputs().duration(10 * SECONDS)
                    .eut(8).addTo(sMaceratorRecipes);
        }

        if (OpenPrinters.isModLoaded()) {

            // Open Printers
            // Paper shreds
            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_ModHandler.getModItem(OpenPrinters.ID, "openprinter.paperShreds", 1L, 0))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Paper, 1L)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(20 * TICKS).eut(2).addTo(sMaceratorRecipes);

        }

        if (ThaumicBases.isModLoaded()) {

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(ThaumicBases.ID, "resource", 1L, 7))
                    .itemOutputs(GT_ModHandler.getModItem(ThaumicBases.ID, "tobaccoPowder", 1L, 0)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(10 * TICKS).eut(2).addTo(sMaceratorRecipes);

        }

        if (TinkerConstruct.isModLoaded()) {

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 4))
                    .itemOutputs(Materials.Ardite.getDust(1)).outputChances(10000).noFluidInputs().noFluidOutputs()
                    .duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 1))
                    .itemOutputs(Materials.Ardite.getDust(9)).outputChances(10000).noFluidInputs().noFluidOutputs()
                    .duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "SearedBrick", 1L, 1))
                    .itemOutputs(
                            GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Cobalt, 2L),
                            Materials.Cobalt.getDust(1))
                    .outputChances(10000, 1000).noFluidInputs().noFluidOutputs().duration(20 * SECONDS).eut(2)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "SearedBrick", 1L, 2))
                    .itemOutputs(
                            GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Ardite, 2L),
                            Materials.Ardite.getDust(1))
                    .outputChances(10000, 1000).noFluidInputs().noFluidOutputs().duration(20 * SECONDS).eut(2)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "GravelOre", 1L, 4))
                    .itemOutputs(
                            GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Aluminium, 2L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bauxite, 1L))
                    .outputChances(10000, 1000).noFluidInputs().noFluidOutputs().duration(20 * SECONDS).eut(2)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 12))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L))
                    .outputChances(10000).noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 14))
                    .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 42)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 7))
                    .itemOutputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 9L, 42)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 0))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 9L)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "materials", 1L, 5))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L))
                    .outputChances(10000).noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 2))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 9L))
                    .outputChances(10000).noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "MetalBlock", 1L, 10))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 9L))
                    .outputChances(10000).noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "woodPattern", 1L, GT_Values.W))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(10 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "Pattern", 1L, GT_Values.W))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(10 * SECONDS).eut(2).addTo(sMaceratorRecipes);
            // Oreberries

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "oreBerries", 1L, 0))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Iron, 1L))
                    .outputChances(10000).noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "oreBerries", 1L, 1))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Gold, 1L))
                    .outputChances(10000).noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "oreBerries", 1L, 2))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Copper, 1L))
                    .outputChances(10000).noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "oreBerries", 1L, 3))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Tin, 1L)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(TinkerConstruct.ID, "oreBerries", 1L, 4))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Aluminium, 1L))
                    .outputChances(10000).noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2)
                    .addTo(sMaceratorRecipes);

        }

        if (Avaritia.isModLoaded()) {

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.record_11, 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.record_13, 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.record_cat, 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.record_blocks, 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.record_chirp, 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.record_far, 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.record_mellohi, 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.record_mall, 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.record_stal, 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.record_strad, 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.record_ward, 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.record_wait, 1, 0))
                    .itemOutputs(GT_ModHandler.getModItem(Avaritia.ID, "Resource", 9L, 7)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2).addTo(sMaceratorRecipes);

        }

        if (AdvancedSolarPanel.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1L, 0))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L))
                    .outputChances(10000).noFluidInputs().noFluidOutputs().duration(15 * SECONDS).eut(2)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_ModHandler.getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1L, 9))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.Sunnarium, 1L))
                    .outputChances(10000).noFluidInputs().noFluidOutputs().duration(1 * SECONDS + 10 * TICKS).eut(2)
                    .addTo(sMaceratorRecipes);

        }

        if (PamsHarvestTheNether.isModLoaded()) {

            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_ModHandler.getModItem(PamsHarvestTheNether.ID, "fleshrootItem", 9L, 0))
                    .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L)).outputChances(10000)
                    .noFluidInputs().noFluidOutputs().duration(5 * SECONDS).eut(2).addTo(sMaceratorRecipes);

        }

        if (GalacticraftCore.isModLoaded()) {

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.moonBlock", 1L, 3))
                    .itemOutputs(
                            CustomItemList.MoonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1))
                    .outputChances(10000, 1250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.moonBlock", 1L, 4))
                    .itemOutputs(
                            CustomItemList.MoonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1))
                    .outputChances(10000, 1250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalacticraftCore.ID, "tile.moonBlock", 1L, 5))
                    .itemOutputs(
                            CustomItemList.MoonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1))
                    .outputChances(10000, 1250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(sMaceratorRecipes);

        }

        if (GalacticraftMars.isModLoaded()) {

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.mars", 1L, 4))
                    .itemOutputs(
                            CustomItemList.MarsStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1000).noFluidInputs().noFluidOutputs().duration(20 * SECONDS).eut(64)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.mars", 1L, 5))
                    .itemOutputs(
                            CustomItemList.MarsStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1000).noFluidInputs().noFluidOutputs().duration(20 * SECONDS).eut(64)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.mars", 1L, 6))
                    .itemOutputs(
                            CustomItemList.MarsStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1000).noFluidInputs().noFluidOutputs().duration(20 * SECONDS).eut(64)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.mars", 1L, 9))
                    .itemOutputs(
                            CustomItemList.MarsStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1000).noFluidInputs().noFluidOutputs().duration(20 * SECONDS).eut(64)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1L, 0))
                    .itemOutputs(
                            CustomItemList.AsteroidsStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1))
                    .outputChances(10000, 1000, 500).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1L, 1))
                    .itemOutputs(
                            CustomItemList.AsteroidsStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1))
                    .outputChances(10000, 1000, 500).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_ModHandler.getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1L, 2))
                    .itemOutputs(
                            CustomItemList.AsteroidsStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1))
                    .outputChances(10000, 1000, 500).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sMaceratorRecipes);

        }

        if (GalaxySpace.isModLoaded()) {

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "phobosblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.PhobosStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS).eut(64)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "phobosblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.PhobosStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS).eut(64)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "phobosblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.PhobosStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS).eut(64)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "deimosblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.DeimosStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesite, 1))
                    .outputChances(10000, 1250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS).eut(64)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "deimosblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.DeimosStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Magnesite, 1))
                    .outputChances(10000, 1250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS).eut(64)
                    .addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.CeresStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Beryllium, 1))
                    .outputChances(10000, 1250, 625).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "ceresblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.CeresStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Beryllium, 1))
                    .outputChances(10000, 1250, 625).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "europagrunt", 1L, 1))
                    .itemOutputs(
                            CustomItemList.EuropaIceDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1))
                    .outputChances(10000, 1250, 625).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "europaunderwatergeyser", 1L, 0))
                    .itemOutputs(
                            CustomItemList.EuropaIceDust.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 2),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 2))
                    .outputChances(10000, 1250, 625).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "europagrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.EuropaStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1))
                    .outputChances(10000, 1250, 500).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "europageyser", 1L, 0))
                    .itemOutputs(
                            CustomItemList.EuropaStoneDust.get(2L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 2),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 2))
                    .outputChances(10000, 1250, 875).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "ganymedeblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.GanymedeStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chromite, 1))
                    .outputChances(10000, 875, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "ganymedeblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.GanymedeStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chromite, 1))
                    .outputChances(10000, 875, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "callistoblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.CallistoStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CallistoIce, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 1))
                    .outputChances(10000, 1250, 625).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "callistoblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.CallistoStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CallistoIce, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 1))
                    .outputChances(10000, 1250, 625).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.IoStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1))
                    .outputChances(10000, 1250, 625, 375).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(256).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.IoStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1))
                    .outputChances(10000, 1250, 750, 500).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(256).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "ioblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.IoStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1))
                    .outputChances(10000, 1250, 625, 375).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(256).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "venusblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.VenusStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mytryl, 1))
                    .outputChances(10000, 1125, 625, 375).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(256).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "venusblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.VenusStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Mytryl, 1))
                    .outputChances(10000, 1125, 625, 375).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(256).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "mercuryblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.MercuryStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1))
                    .outputChances(10000, 750, 500, 300).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(256).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "mercuryblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.MercuryStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1))
                    .outputChances(10000, 750, 500, 300).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(256).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "mercuryblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.MercuryCoreDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1))
                    .outputChances(10000, 750, 500, 300).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(256).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "enceladusblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.EnceladusIceDust.get(1L),
                            CustomItemList.MysteriousCrystalDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1))
                    .outputChances(10000, 1500, 500, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "enceladusblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.EnceladusStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1))
                    .outputChances(10000, 750, 500, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "enceladusblocks", 1L, 3))
                    .itemOutputs(
                            CustomItemList.EnceladusIceDust.get(1L),
                            CustomItemList.MysteriousCrystalDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1))
                    .outputChances(10000, 1500, 500, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "titanblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.TitanStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1))
                    .outputChances(10000, 1125, 750, 500).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "titanblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.TitanStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1))
                    .outputChances(10000, 1125, 750, 500).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "titanblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.TitanStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1))
                    .outputChances(10000, 1125, 750, 500).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "oberonblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.OberonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1))
                    .outputChances(10000, 500, 250, 212).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "oberonblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.OberonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1))
                    .outputChances(10000, 500, 250, 212).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "oberonblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.OberonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1))
                    .outputChances(10000, 500, 250, 212).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "mirandablocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.MirandaStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1))
                    .outputChances(10000, 625, 375, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "mirandablocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.MirandaStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1))
                    .outputChances(10000, 625, 375, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "mirandablocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.MirandaStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1))
                    .outputChances(10000, 625, 375, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_HV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "proteusblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.ProteusStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 1))
                    .outputChances(10000, 1250, 625, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(1024).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "proteusblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.ProteusStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 1))
                    .outputChances(10000, 1250, 625, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(1024).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "proteusblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.ProteusStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 1))
                    .outputChances(10000, 1250, 625, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(1024).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "tritonblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.TritonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1))
                    .outputChances(10000, 1250, 625, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(1024).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "tritonblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.TritonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1))
                    .outputChances(10000, 1250, 625, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(1024).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "tritonblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.TritonStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1))
                    .outputChances(10000, 1250, 625, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(1024).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "plutoblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.PlutoIceDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1))
                    .outputChances(10000, 1250, 625, 312).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "plutoblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.PlutoIceDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1))
                    .outputChances(10000, 1250, 625, 312).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "plutoblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.PlutoIceDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1))
                    .outputChances(10000, 1250, 625, 312).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "plutoblocks", 1L, 3))
                    .itemOutputs(
                            CustomItemList.PlutoIceDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1))
                    .outputChances(10000, 1250, 625, 312).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "plutoblocks", 1L, 4))
                    .itemOutputs(
                            CustomItemList.PlutoIceDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1))
                    .outputChances(10000, 1250, 625, 312).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "plutoblocks", 1L, 5))
                    .itemOutputs(
                            CustomItemList.PlutoStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1))
                    .outputChances(10000, 1250, 625, 212).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "makemakegrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.MakeMakeStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetRed, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetYellow, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1))
                    .outputChances(10000, 625, 625, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "makemakegrunt", 1L, 1))
                    .itemOutputs(
                            CustomItemList.MakeMakeStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetRed, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.GarnetYellow, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1))
                    .outputChances(10000, 625, 625, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "haumeablocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.HaumeaStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.InfusedGold, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 1))
                    .outputChances(10000, 1250, 625, 212).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(TierEU.RECIPE_EV).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "acentauribbgrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.CentauriASurfaceDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1))
                    .outputChances(10000, 1250, 750, 250).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(4096).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "acentauribbsubgrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.CentauriAStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 1))
                    .outputChances(10000, 1250, 750, 125).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(4096).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "vegabsubgrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.VegaBStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 1))
                    .outputChances(10000, 1250, 750, 375).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(4096).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "vegabgrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.VegaBStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 1))
                    .outputChances(10000, 1250, 750, 375).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(4096).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "barnardaEgrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.BarnardaEStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1))
                    .outputChances(10000, 625, 500, 375).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(4096).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "barnardaEsubgrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.BarnardaEStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1))
                    .outputChances(10000, 625, 500, 375).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(4096).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "barnardaFgrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.BarnardaFStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1))
                    .outputChances(10000, 625, 500, 375).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(4096).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "barnardaFsubgrunt", 1L, 0))
                    .itemOutputs(
                            CustomItemList.BarnardaFStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1))
                    .outputChances(10000, 625, 500, 375).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(4096).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "tcetieblocks", 1L, 0))
                    .itemOutputs(
                            CustomItemList.TCetiEStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1))
                    .outputChances(10000, 625, 500, 375).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(4096).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "tcetieblocks", 1L, 1))
                    .itemOutputs(
                            CustomItemList.TCetiEStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1))
                    .outputChances(10000, 625, 500, 375).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(4096).addTo(sMaceratorRecipes);

            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(GalaxySpace.ID, "tcetieblocks", 1L, 2))
                    .itemOutputs(
                            CustomItemList.TCetiEStoneDust.get(1L),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1))
                    .outputChances(10000, 625, 500, 375).noFluidInputs().noFluidOutputs().duration(20 * SECONDS)
                    .eut(4096).addTo(sMaceratorRecipes);

        }
    }
}
