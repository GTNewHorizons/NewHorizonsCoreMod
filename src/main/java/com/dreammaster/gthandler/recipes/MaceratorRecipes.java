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

import com.dreammaster.block.BlockList;
import com.dreammaster.item.NHItemList;
import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.recipe.RecipeCategories;

public class MaceratorRecipes implements Runnable {

    @Override
    public void run() {
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.glass_bottle, 1, 0))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Glass, Shapes.dust, (int) (1L))).outputChances(10000)
                .duration(4 * SECONDS).eut(TierEU.RECIPE_ULV).addTo(maceratorRecipes);

        if (IndustrialCraft2.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemFuelPlantBall", 2, 0))
                    .itemOutputs(
                            NHItemList.MaceratedPlantmass.get(),
                            NHItemList.MaceratedPlantmass.get(),
                            NHItemList.MaceratedPlantmass.get(),
                            NHItemList.MaceratedPlantmass.get())
                    .outputChances(10000, 10000, 5000, 2500).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "blockMiningPipe", 2))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Steel, Shapes.dust, (int) (1L))).outputChances(10000)
                    .duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(maceratorRecipes);

        }

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.flint, 2, 0))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Flint, Shapes.dust, (int) (1L))).duration(10 * SECONDS)
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
                .itemOutputs(MaterialLibAPI.getStack(Materials.GalliumArsenide, Shapes.dust, (int) (2)))
                .outputChances(10000).duration(5 * SECONDS).eut(4).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.GalliumArsenideCrystalSmallPart.get(1L))
                .itemOutputs(MaterialLibAPI.getStack(Materials.GalliumArsenide, Shapes.dustSmall, (int) (1)))
                .outputChances(10000).duration(1 * SECONDS + 5 * TICKS).eut(4).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.sand, 1, wildcard))
                .itemOutputs(
                        MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dust, (int) (1L)),
                        MaterialLibAPI.getStack(Materials.QuartzSand, Shapes.dust, (int) (1L)))
                .outputChances(10000, 2500, 2000, 1500).duration(10 * SECONDS).eut(TierEU.RECIPE_ULV)
                .addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ChromaticGemExquisite.get())
                .itemOutputs(MaterialLibAPI.getStack(Materials.ChromaticGlass, Shapes.dust, (int) (8)))
                .duration(16 * SECONDS).eut(TierEU.RECIPE_UV).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ChromaticGemFlawless.get())
                .itemOutputs(MaterialLibAPI.getStack(Materials.ChromaticGlass, Shapes.dust, (int) (4)))
                .duration(8 * SECONDS).eut(TierEU.RECIPE_UV).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(NHItemList.ChromaticGem.get())
                .itemOutputs(MaterialLibAPI.getStack(Materials.ChromaticGlass, Shapes.dust, (int) (2)))
                .duration(4 * SECONDS).eut(TierEU.RECIPE_UV).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Calcium, Shapes.ingot, (int) (1)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Calcium, Shapes.dust, (int) (1))).duration(20 * SECONDS)
                .eut(2).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Calcium, Shapes.nugget, (int) (1)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Calcium, Shapes.dustTiny, (int) (1)))
                .duration(20 * SECONDS).eut(2).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Magnesia, Shapes.ingot, (int) (1)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Magnesia, Shapes.dust, (int) (1))).duration(20 * SECONDS)
                .eut(2).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(MaterialLibAPI.getStack(Materials.Magnesia, Shapes.nugget, (int) (1)))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Magnesia, Shapes.dustTiny, (int) (1)))
                .duration(20 * SECONDS).eut(2).addTo(maceratorRecipes);

        GTValues.RA.stdBuilder().itemInputs(BlockList.Sulfur.get(1))
                .itemOutputs(MaterialLibAPI.getStack(Materials.Sulfur, Shapes.dust, (int) (9L))).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(maceratorRecipes);

        if (OpenPrinters.isModLoaded()) {

            // Open Printers
            // Paper shreds
            GTValues.RA.stdBuilder().itemInputs(getModItem(OpenPrinters.ID, "openprinter.paperShreds", 1, 0))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Paper, Shapes.dust, (int) (1L))).outputChances(10000)
                    .duration(20 * TICKS).eut(2).addTo(maceratorRecipes);

        }

        if (ThaumicBases.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(ThaumicBases.ID, "resource", 1, 7))
                    .itemOutputs(getModItem(ThaumicBases.ID, "tobaccoPowder", 1, 0)).outputChances(10000)
                    .duration(10 * TICKS).eut(2).addTo(maceratorRecipes);

        }

        if (TinkerConstruct.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 1, 4))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Ardite, Shapes.dust, (int) (1))).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 1))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Ardite, Shapes.dust, (int) (9))).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 1, 12))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dust, (int) (1L)))
                    .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 1, 14))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 1, 42)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 7))
                    .itemOutputs(getModItem(TinkerConstruct.ID, "materials", 9, 42)).outputChances(10000)
                    .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 0))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Cobalt, Shapes.dust, (int) (9L)))
                    .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "materials", 1, 5))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Manyullyn, Shapes.dust, (int) (1L)))
                    .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 2))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Manyullyn, Shapes.dust, (int) (9L)))
                    .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "MetalBlock", 1, 10))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.EnderPearl, Shapes.dust, (int) (9L)))
                    .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "woodPattern", 1, WILDCARD))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Wood, Shapes.dust, (int) (1L))).outputChances(10000)
                    .duration(10 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "Pattern", 1, WILDCARD))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Wood, Shapes.dust, (int) (1L))).outputChances(10000)
                    .duration(10 * SECONDS).eut(2).addTo(maceratorRecipes);
            // Oreberries

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "oreBerries", 9, 0))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (1L))).outputChances(10000)
                    .duration(15 * SECONDS).eut(18).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "oreBerries", 9, 1))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, (int) (1L))).outputChances(10000)
                    .duration(15 * SECONDS).eut(18).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "oreBerries", 9, 2))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, (int) (1L)))
                    .outputChances(10000).duration(15 * SECONDS).eut(18).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "oreBerries", 9, 3))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Tin, Shapes.dust, (int) (1L))).outputChances(10000)
                    .duration(15 * SECONDS).eut(18).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(TinkerConstruct.ID, "oreBerries", 9, 4))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Aluminium, Shapes.dust, (int) (1L)))
                    .outputChances(10000).duration(15 * SECONDS).eut(18).addTo(maceratorRecipes);

        }

        if (Avaritia.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_11, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000).duration(15 * SECONDS)
                    .eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_13, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000).duration(15 * SECONDS)
                    .eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_cat, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000).duration(15 * SECONDS)
                    .eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_blocks, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000).duration(15 * SECONDS)
                    .eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_chirp, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000).duration(15 * SECONDS)
                    .eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_far, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000).duration(15 * SECONDS)
                    .eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_mellohi, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000).duration(15 * SECONDS)
                    .eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_mall, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000).duration(15 * SECONDS)
                    .eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_stal, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000).duration(15 * SECONDS)
                    .eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_strad, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000).duration(15 * SECONDS)
                    .eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_ward, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000).duration(15 * SECONDS)
                    .eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.record_wait, 1, 0))
                    .itemOutputs(getModItem(Avaritia.ID, "Resource", 9, 7)).outputChances(10000).duration(15 * SECONDS)
                    .eut(2).addTo(maceratorRecipes);

        }

        if (AdvancedSolarPanel.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 0))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Sunnarium, Shapes.dust, (int) (1L)))
                    .outputChances(10000).duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 9))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.Sunnarium, Shapes.dustTiny, (int) (1L)))
                    .outputChances(10000).duration(1 * SECONDS + 10 * TICKS).eut(2).addTo(maceratorRecipes);

        }

        if (Fether.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(Fether.ID, "flesh_root", 9, 0))
                    .itemOutputs(MaterialLibAPI.getStack(Materials.MeatRaw, Shapes.dust, (int) (1L)))
                    .outputChances(10000).duration(5 * SECONDS).eut(2).addTo(maceratorRecipes);

        }

        if (GalacticraftCore.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "tile.moonBlock", 1, 3))
                    .itemOutputs(
                            NHItemList.MoonStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "tile.moonBlock", 1, 4))
                    .itemOutputs(
                            NHItemList.MoonStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftCore.ID, "tile.moonBlock", 1, 5))
                    .itemOutputs(
                            NHItemList.MoonStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(maceratorRecipes);

        }

        if (GalacticraftMars.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "tile.mars", 1, 4))
                    .itemOutputs(
                            NHItemList.MarsStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.BandedIron, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1000).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "tile.mars", 1, 5))
                    .itemOutputs(
                            NHItemList.MarsStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.BandedIron, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1000).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "tile.mars", 1, 6))
                    .itemOutputs(
                            NHItemList.MarsStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.BandedIron, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1000).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "tile.mars", 1, 9))
                    .itemOutputs(
                            NHItemList.MarsStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.BandedIron, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1000).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1, 0))
                    .itemOutputs(
                            NHItemList.AsteroidsStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Lead, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1000, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1, 1))
                    .itemOutputs(
                            NHItemList.AsteroidsStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Lead, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1000, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalacticraftMars.ID, "tile.asteroidsBlock", 1, 2))
                    .itemOutputs(
                            NHItemList.AsteroidsStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Lead, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1000, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

        }

        if (GalaxySpace.isModLoaded()) {

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "phobosblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.PhobosStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.BandedIron, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "phobosblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.PhobosStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.BandedIron, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "phobosblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.PhobosStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.BandedIron, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "deimosblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.DeimosStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Magnesite, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "deimosblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.DeimosStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Magnesite, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250).duration(20 * SECONDS).eut(TierEU.RECIPE_MV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "ceresblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.CeresStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.MeteoricIron, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Beryllium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "ceresblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.CeresStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.MeteoricIron, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Beryllium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "europagrunt", 1, 1))
                    .itemOutputs(
                            NHItemList.EuropaIceDust.get(),
                            MaterialLibAPI.getStack(Materials.Ledox, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Lapis, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "europaunderwatergeyser", 1, 0))
                    .itemOutputs(
                            NHItemList.EuropaIceDust.get(2),
                            MaterialLibAPI.getStack(Materials.Ledox, Shapes.dust, (int) (2)),
                            MaterialLibAPI.getStack(Materials.Lapis, Shapes.dust, (int) (2)))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "europagrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.EuropaStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "europageyser", 1, 0))
                    .itemOutputs(
                            NHItemList.EuropaStoneDust.get(2),
                            MaterialLibAPI.getStack(Materials.SiliconDioxide, Shapes.dust, (int) (2)),
                            MaterialLibAPI.getStack(Materials.Iron, Shapes.dust, (int) (2)))
                    .outputChances(10000, 1250, 875).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "ganymedeblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.GanymedeStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Titanium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Chromite, Shapes.dust, (int) (1)))
                    .outputChances(10000, 875, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "ganymedeblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.GanymedeStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Titanium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Chromite, Shapes.dust, (int) (1)))
                    .outputChances(10000, 875, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "callistoblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.CallistoStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.CallistoIce, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Galena, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "callistoblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.CallistoStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.CallistoIce, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Galena, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625).duration(20 * SECONDS).eut(TierEU.RECIPE_MV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "ioblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.IoStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Sulfur, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Tantalite, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Tungsten, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "ioblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.IoStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Ash, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Sulfur, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Tantalite, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 750, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "ioblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.IoStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Sulfur, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Tantalite, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Tungsten, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "venusblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.VenusStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Tetrahedrite, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Quantium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Mytryl, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1125, 625, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "venusblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.VenusStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Tetrahedrite, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Quantium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Mytryl, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1125, 625, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "mercuryblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.MercuryStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Ilmenite, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Tungsten, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 750, 500, 300).duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "mercuryblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.MercuryStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Ilmenite, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Tungsten, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 750, 500, 300).duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "mercuryblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.MercuryCoreDust.get(),
                            MaterialLibAPI.getStack(Materials.Ilmenite, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Tungsten, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 750, 500, 300).duration(20 * SECONDS).eut(TierEU.RECIPE_HV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "enceladusblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.EnceladusIceDust.get(),
                            MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.dust, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1500, 500, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "enceladusblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.EnceladusStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.dust, (int) (1)))
                    .outputChances(10000, 750, 500, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "enceladusblocks", 1, 3))
                    .itemOutputs(
                            NHItemList.EnceladusIceDust.get(),
                            MaterialLibAPI.getStack(Materials.MysteriousCrystal, Shapes.dust, (int) (1L)),
                            MaterialLibAPI.getStack(Materials.Chrome, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1500, 500, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "titanblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.TitanStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Nickel, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1125, 750, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "titanblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.TitanStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Nickel, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1125, 750, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "titanblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.TitanStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Nickel, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1125, 750, 500).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "oberonblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.OberonStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (1)))
                    .outputChances(10000, 500, 250, 212).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "oberonblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.OberonStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (1)))
                    .outputChances(10000, 500, 250, 212).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "oberonblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.OberonStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (1)))
                    .outputChances(10000, 500, 250, 212).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "mirandablocks", 1, 0))
                    .itemOutputs(
                            NHItemList.MirandaStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Tin, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Tetrahedrite, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 625, 375, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "mirandablocks", 1, 1))
                    .itemOutputs(
                            NHItemList.MirandaStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Tin, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Tetrahedrite, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 625, 375, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "mirandablocks", 1, 2))
                    .itemOutputs(
                            NHItemList.MirandaStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Tin, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Tetrahedrite, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 625, 375, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_HV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "proteusblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.ProteusStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Uraninite, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Adamantium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "proteusblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.ProteusStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Uraninite, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Adamantium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "proteusblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.ProteusStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Copper, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Uraninite, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Adamantium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "tritonblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.TritonStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Neodymium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.RareEarth, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "tritonblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.TritonStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Neodymium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.RareEarth, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "tritonblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.TritonStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Gold, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Neodymium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.RareEarth, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "plutoblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.PlutoIceDust.get(),
                            MaterialLibAPI.getStack(Materials.Thorium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Plutonium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625, 312).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "plutoblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.PlutoIceDust.get(),
                            MaterialLibAPI.getStack(Materials.Thorium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Plutonium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625, 312).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "plutoblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.PlutoIceDust.get(),
                            MaterialLibAPI.getStack(Materials.Thorium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Plutonium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625, 312).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "plutoblocks", 1, 3))
                    .itemOutputs(
                            NHItemList.PlutoIceDust.get(),
                            MaterialLibAPI.getStack(Materials.Thorium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Plutonium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625, 312).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "plutoblocks", 1, 4))
                    .itemOutputs(
                            NHItemList.PlutoIceDust.get(),
                            MaterialLibAPI.getStack(Materials.Thorium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Plutonium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625, 312).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "plutoblocks", 1, 5))
                    .itemOutputs(
                            NHItemList.PlutoStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Uranium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Plutonium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625, 212).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "makemakegrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.MakeMakeStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.GarnetRed, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.GarnetYellow, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 625, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "makemakegrunt", 1, 1))
                    .itemOutputs(
                            NHItemList.MakeMakeStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.GarnetRed, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.GarnetYellow, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 625, 625, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "haumeablocks", 1, 0))
                    .itemOutputs(
                            NHItemList.HaumeaStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.InfusedGold, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Naquadah, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.NetherStar, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 625, 212).duration(20 * SECONDS).eut(TierEU.RECIPE_EV)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "acentauribbgrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.CentauriASurfaceDust.get(),
                            MaterialLibAPI.getStack(Materials.Iridium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.NaquadahEnriched, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Draconium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 750, 250).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "acentauribbsubgrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.CentauriAStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Osmium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.NaquadahEnriched, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Neutronium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 750, 125).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "vegabsubgrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.VegaBStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Uranium235, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Plutonium241, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Europium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 750, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "vegabgrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.VegaBStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Uranium235, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Plutonium241, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Europium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 1250, 750, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "barnardaEgrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.BarnardaEStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Niobium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Yttrium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Gallium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "barnardaEsubgrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.BarnardaEStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Niobium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Yttrium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Gallium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "barnardaFgrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.BarnardaFStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Gallium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Yttrium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Niobium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "barnardaFsubgrunt", 1, 0))
                    .itemOutputs(
                            NHItemList.BarnardaFStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Gallium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Yttrium, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Niobium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "tcetieblocks", 1, 0))
                    .itemOutputs(
                            NHItemList.TCetiEStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Lapis, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Apatite, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "tcetieblocks", 1, 1))
                    .itemOutputs(
                            NHItemList.TCetiEStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Lapis, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Apatite, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.dust, (int) (1)))
                    .outputChances(10000, 625, 500, 375).duration(20 * SECONDS).eut(TierEU.RECIPE_IV / 2)
                    .addTo(maceratorRecipes);

            GTValues.RA.stdBuilder().itemInputs(getModItem(GalaxySpace.ID, "tcetieblocks", 1, 2))
                    .itemOutputs(
                            NHItemList.TCetiEStoneDust.get(),
                            MaterialLibAPI.getStack(Materials.Lapis, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Apatite, Shapes.dust, (int) (1)),
                            MaterialLibAPI.getStack(Materials.Bedrockium, Shapes.dust, (int) (1)))
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
                            MaterialLibAPI.getStack(Materials.DraconiumAwakened, Shapes.dust, (int) (64)),
                            MaterialLibAPI.getStack(Materials.SpaceTime, Shapes.dust, (int) (10)),
                            MaterialLibAPI.getStack(Materials.BlackPlutonium, Shapes.dust, (int) (4)),
                            NHItemList.ChaoticDust.get(1))
                    .duration(50 * SECONDS).eut(TierEU.RECIPE_UMV).addTo(maceratorRecipes);
        }
    }
}
