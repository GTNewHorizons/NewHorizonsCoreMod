package com.dreammaster.gthandler.recipes;

import static com.dreammaster.scripts.IScriptLoader.wildcard;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.Fether;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GalacticraftMars;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.OpenPrinters;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.item.NHItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.recipe.RecipeCategories;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.core.material.MaterialsElements;

public class MaceratorRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glass_bottle, 1, 0))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Glass, 1L)).outputChances(10000)
                .duration(4 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(maceratorRecipes);

        if (IndustrialCraft2.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 2, 0))
                    .itemOutputs(
                            NHItemList.MaceratedPlantmass.get(),
                            NHItemList.MaceratedPlantmass.get(),
                            NHItemList.MaceratedPlantmass.get(),
                            NHItemList.MaceratedPlantmass.get())
                    .outputChances(10000, 10000, 5000, 2500).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 2))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L)).outputChances(10000)
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(maceratorRecipes);

        }

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.flint, 2, 0))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Flint, 1L)).duration(10 * SECONDS)
                .eut(2).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.CokeOvenBrick.get())
                .itemOutputs(NHItemList.CokeOvenBrickDust.get()).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.AdvancedCokeOvenBrick.get())
                .itemOutputs(
                        NHItemList.AdvancedCokeOvenBrickDust.get(),
                        NHItemList.AdvancedCokeOvenBrickDust.get(),
                        NHItemList.AdvancedCokeOvenBrickDust.get(),
                        NHItemList.AdvancedCokeOvenBrickDust.get())
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
                .outputChances(10000, 2500, 2000, 1500).duration(10 * SECONDS).eut(TierEU.RECIPE_ULV)
                .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ChromaticGemExquisite.get())
                .itemOutputs(MaterialsElements.STANDALONE.CHRONOMATIC_GLASS.getDust(8)).duration(16 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ChromaticGemFlawless.get())
                .itemOutputs(MaterialsElements.STANDALONE.CHRONOMATIC_GLASS.getDust(4)).duration(8 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ChromaticGem.get())
                .itemOutputs(MaterialsElements.STANDALONE.CHRONOMATIC_GLASS.getDust(2)).duration(4 * SECONDS)
                .eut(TierEU.RECIPE_UV).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(Materials.Calcium.getIngots(1)).itemOutputs(Materials.Calcium.getDust(1))
                .duration(20 * SECONDS).eut(2).addTo(maceratorRecipes);

        if (OpenPrinters.isModLoaded()) {

            // Open Printers
            // Paper shreds
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(OpenPrinters.ID, "openprinter.paperShreds", 1, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Paper, 1L)).outputChances(10000)
                    .duration(20 * TICKS).eut(2).addTo(maceratorRecipes);

        }

        if (ThaumicBases.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "resource", 1, 7))
                    .itemOutputs(getModItem(ThaumicBases.ID, "tobaccoPowder", 1, 0)).outputChances(10000)
                    .duration(10 * TICKS).eut(2).addTo(maceratorRecipes);

        }

        if (TinkerConstruct.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 1, 4))
                    .itemOutputs(Materials.Ardite.getDust(1)).outputChances(10000).duration(15 * SECONDS).eut(2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 1))
                    .itemOutputs(Materials.Ardite.getDust(9)).outputChances(10000).duration(15 * SECONDS).eut(2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 1, 12))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L))
                    .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 1, 14))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 42)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 7))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 9, 42)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Cobalt, 9L)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 1, 5))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 1L))
                    .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 2))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Manyullyn, 9L))
                    .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.EnderPearl, 9L))
                    .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(TinkerConstruct.ID, "woodPattern", 1, WILDCARD))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L)).outputChances(10000)
                    .duration(10 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "Pattern", 1, WILDCARD))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L)).outputChances(10000)
                    .duration(10 * SECONDS).eut(2).addTo(maceratorRecipes);
            // Oreberries

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "oreBerries", 9, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L)).outputChances(10000)
                    .duration(15 * SECONDS).eut(18).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "oreBerries", 9, 1))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1L)).outputChances(10000)
                    .duration(15 * SECONDS).eut(18).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "oreBerries", 9, 2))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1L)).outputChances(10000)
                    .duration(15 * SECONDS).eut(18).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "oreBerries", 9, 3))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1L)).outputChances(10000)
                    .duration(15 * SECONDS).eut(18).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "oreBerries", 9, 4))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Aluminium, 1L))
                    .outputChances(10000).duration(15 * SECONDS).eut(18).addTo(maceratorRecipes);

        }

        if (Avaritia.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_11, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_13, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_cat, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_blocks, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_chirp, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_far, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_mellohi, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_mall, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_stal, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_strad, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_ward, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_wait, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

        }

        if (AdvancedSolarPanel.isModLoaded()) {

            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sunnarium, 1L))
                    .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 9))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dustTiny, Materials.Sunnarium, 1L))
                    .outputChances(10000).duration(1 * SECONDS + 10 * TICKS).eut(2).addTo(maceratorRecipes);

        }

        if (Fether.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(Fether.ID, "flesh_root", 9, 0))
                    .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 1L)).outputChances(10000)
                    .duration(5 * SECONDS).eut(2).addTo(maceratorRecipes);

        }

        if (GalacticraftCore.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "tile.moonBlock", 1, 3))
                    .itemOutputs(
                            NHItemList.MoonStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "tile.moonBlock", 1, 4))
                    .itemOutputs(
                            NHItemList.MoonStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "tile.moonBlock", 1, 5))
                    .itemOutputs(
                            NHItemList.MoonStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(maceratorRecipes);

        }

        if (GalacticraftMars.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "tile.mars", 1, 4))
                    .itemOutputs(
                            NHItemList.MarsStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1000).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "tile.mars", 1, 5))
                    .itemOutputs(
                            NHItemList.MarsStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1000).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "tile.mars", 1, 6))
                    .itemOutputs(
                            NHItemList.MarsStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1000).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "tile.mars", 1, 9))
                    .itemOutputs(
                            NHItemList.MarsStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1000).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1, 0))
                    .itemOutputs(
                            NHItemList.AsteroidsStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1))
                    .outputChances(10000, 1000, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1, 1))
                    .itemOutputs(
                            NHItemList.AsteroidsStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1))
                    .outputChances(10000, 1000, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1, 2))
                    .itemOutputs(
                            NHItemList.AsteroidsStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lead, 1))
                    .outputChances(10000, 1000, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

        }

        if (GalaxySpace.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "phobosblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.PhobosStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "phobosblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.PhobosStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "phobosblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.PhobosStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BandedIron, 1))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "deimosblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.DeimosStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesite, 1))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "deimosblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.DeimosStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Magnesite, 1))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "ceresblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.CeresStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Beryllium, 1))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "ceresblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.CeresStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeteoricIron, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Beryllium, 1))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "europagrunt", 1, 1))
                    .itemOutputs(
                            NHItemList.EuropaIceDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(GalaxySpace.ID, "europaunderwatergeyser", 1, 0))
                    .itemOutputs(
                            NHItemList.EuropaIceDust.get(2),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ledox, 2),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 2))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "europagrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.EuropaStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1))
                    .outputChances(10000, 1250, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "europageyser", 1, 0))
                    .itemOutputs(
                            NHItemList.EuropaStoneDust.get(2),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.SiliconDioxide, 2),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 2))
                    .outputChances(10000, 1250, 875).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "ganymedeblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.GanymedeStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chromite, 1))
                    .outputChances(10000, 875, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "ganymedeblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.GanymedeStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Titanium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chromite, 1))
                    .outputChances(10000, 875, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "callistoblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.CallistoStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.CallistoIce, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 1))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "callistoblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.CallistoStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.CallistoIce, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Galena, 1))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "ioblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.IoStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1))
                    .outputChances(10000, 1250, 625, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "ioblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.IoStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1))
                    .outputChances(10000, 1250, 750, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "ioblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.IoStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tantalite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1))
                    .outputChances(10000, 1250, 625, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "venusblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.VenusStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Mytryl, 1))
                    .outputChances(10000, 1125, 625, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "venusblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.VenusStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Quantium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Mytryl, 1))
                    .outputChances(10000, 1125, 625, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "mercuryblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.MercuryStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1))
                    .outputChances(10000, 750, 500, 300).duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "mercuryblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.MercuryStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1))
                    .outputChances(10000, 750, 500, 300).duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "mercuryblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.MercuryCoreDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ilmenite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tungsten, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1))
                    .outputChances(10000, 750, 500, 300).duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "enceladusblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.EnceladusIceDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1))
                    .outputChances(10000, 1500, 500, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "enceladusblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.EnceladusStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1))
                    .outputChances(10000, 750, 500, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "enceladusblocks", 1, 3))
                    .itemOutputs(
                            NHItemList.EnceladusIceDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.MysteriousCrystal, 1L),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Chrome, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1))
                    .outputChances(10000, 1500, 500, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "titanblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.TitanStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1))
                    .outputChances(10000, 1125, 750, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "titanblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.TitanStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1))
                    .outputChances(10000, 1125, 750, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "titanblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.TitanStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Nickel, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1))
                    .outputChances(10000, 1125, 750, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "oberonblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.OberonStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1))
                    .outputChances(10000, 500, 250, 212).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "oberonblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.OberonStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1))
                    .outputChances(10000, 500, 250, 212).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "oberonblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.OberonStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1))
                    .outputChances(10000, 500, 250, 212).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "mirandablocks", 1, 0))
                    .itemOutputs(
                            NHItemList.MirandaStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1))
                    .outputChances(10000, 625, 375, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "mirandablocks", 1, 1))
                    .itemOutputs(
                            NHItemList.MirandaStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1))
                    .outputChances(10000, 625, 375, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "mirandablocks", 1, 2))
                    .itemOutputs(
                            NHItemList.MirandaStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tin, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Tetrahedrite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1))
                    .outputChances(10000, 625, 375, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "proteusblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.ProteusStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 1))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "proteusblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.ProteusStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 1))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "proteusblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.ProteusStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Copper, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uraninite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Adamantium, 1))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "tritonblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.TritonStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "tritonblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.TritonStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "tritonblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.TritonStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gold, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Neodymium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.RareEarth, 1))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "plutoblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.PlutoIceDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1))
                    .outputChances(10000, 1250, 625, 312).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "plutoblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.PlutoIceDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1))
                    .outputChances(10000, 1250, 625, 312).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "plutoblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.PlutoIceDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1))
                    .outputChances(10000, 1250, 625, 312).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "plutoblocks", 1, 3))
                    .itemOutputs(
                            NHItemList.PlutoIceDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1))
                    .outputChances(10000, 1250, 625, 312).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "plutoblocks", 1, 4))
                    .itemOutputs(
                            NHItemList.PlutoIceDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Thorium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1))
                    .outputChances(10000, 1250, 625, 312).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "plutoblocks", 1, 5))
                    .itemOutputs(
                            NHItemList.PlutoStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1))
                    .outputChances(10000, 1250, 625, 212).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "makemakegrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.MakeMakeStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.GarnetRed, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.GarnetYellow, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1))
                    .outputChances(10000, 625, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "makemakegrunt", 1, 1))
                    .itemOutputs(
                            NHItemList.MakeMakeStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.GarnetRed, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.GarnetYellow, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.BlackPlutonium, 1))
                    .outputChances(10000, 625, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "haumeablocks", 1, 0))
                    .itemOutputs(
                            NHItemList.HaumeaStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfusedGold, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Naquadah, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.NetherStar, 1))
                    .outputChances(10000, 1250, 625, 212).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "acentauribbgrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.CentauriASurfaceDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iridium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Draconium, 1))
                    .outputChances(10000, 1250, 750, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "acentauribbsubgrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.CentauriAStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Osmium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.NaquadahEnriched, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Neutronium, 1))
                    .outputChances(10000, 1250, 750, 125).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "vegabsubgrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.VegaBStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 1))
                    .outputChances(10000, 1250, 750, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "vegabgrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.VegaBStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Uranium235, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Plutonium241, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Europium, 1))
                    .outputChances(10000, 1250, 750, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "barnardaEgrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.BarnardaEStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "barnardaEsubgrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.BarnardaEStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "barnardaFgrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.BarnardaFStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "barnardaFsubgrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.BarnardaFStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Gallium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Yttrium, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Niobium, 1))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "tcetieblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.TCetiEStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "tcetieblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.TCetiEStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "tcetieblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.TCetiEStoneDust.get(),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Lapis, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.Bedrockium, 1))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

        }

        if (Chisel.isModLoaded()) {
            for (int meta = 0; meta < 16; ++meta) {
                GTValues.RA.stdBuilder().itemInputs(getModItem(Chisel.ID, "hempcrete", 1, meta))
                        .itemOutputs(getModItem(Chisel.ID, "hempcretesand", 1, meta))
                        .recipeCategory(RecipeCategories.maceratorRecycling).duration(4 * SECONDS + 18 * TICKS).eut(4)
                        .addTo(maceratorRecipes);
            }
        }

        if (DraconicEvolution.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(DraconicEvolution.ID, "chaoticCore", 1, 0))
                    .itemOutputs(
                            Materials.DraconiumAwakened.getDust(64),
                            Materials.SpaceTime.getDust(10),
                            Materials.BlackPlutonium.getDust(4),
                            NHItemList.ChaoticDust.get(1))
                    .duration(50 * SECONDS).eut(TierEU.RECIPE_UMV).addTo(maceratorRecipes);
        }
    }
}
