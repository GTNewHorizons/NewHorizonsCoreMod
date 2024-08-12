package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.GalaxySpace;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import codechicken.nei.PositionedStack;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SpaceStationRecipe;
import micdoodle8.mods.galacticraft.api.world.SpaceStationType;
import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.nei.BuggyRecipeHandler;
import micdoodle8.mods.galacticraft.core.nei.NEIGalacticraftConfig;
import micdoodle8.mods.galacticraft.core.recipe.NasaWorkbenchRecipe;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import micdoodle8.mods.galacticraft.core.util.RecipeUtil;
import micdoodle8.mods.galacticraft.planets.asteroids.blocks.AsteroidBlocks;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import micdoodle8.mods.galacticraft.planets.asteroids.nei.AstroMinerRecipeHandler;
import micdoodle8.mods.galacticraft.planets.asteroids.nei.NEIGalacticraftAsteroidsConfig;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import micdoodle8.mods.galacticraft.planets.mars.nei.CargoRocketRecipeHandler;
import micdoodle8.mods.galacticraft.planets.mars.nei.NEIGalacticraftMarsConfig;
import micdoodle8.mods.galacticraft.planets.mars.util.MarsUtil;

public class CompatGalacticraft {

    protected static void spaceStationRecipes() {
        final HashMap<Object, Integer> inputMap = new HashMap<>();
        inputMap.put(new ItemStack(GCBlocks.basicBlock, 1, 4), 231);
        inputMap.put(new ItemStack(Blocks.glass_pane), 6);
        inputMap.put("circuitAdvanced", 4);
        inputMap.put(ItemList.Hull_HV.get(1), 1);
        GalacticraftRegistry.registerSpaceStation(
                new SpaceStationType(ConfigManagerCore.idDimensionOverworldOrbit, 0, new SpaceStationRecipe(inputMap)));
    }

    protected static void buggyRecipes() {
        HashMap<Integer, ItemStack> input = new HashMap<>();
        HashMap<Integer, ItemStack> input2;
        input.put(1, new ItemStack(GCItems.basicItem, 1, 19));
        input.put(2, new ItemStack(GCItems.partBuggy, 1, 1));
        if (GalaxySpace.isModLoaded()) {
            input.put(3, GT_ModHandler.getModItem(GalaxySpace.ID, "item.RocketControlComputer", 1, 100));
        }
        for (int i = 4; i <= 7; i++) {
            input.put(i, new ItemStack(GCItems.partBuggy));
        }
        for (int i = 8; i <= 11; i++) {
            input.put(i, GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1));
        }
        for (int i = 12; i <= 16; i++) {
            input.put(i, new ItemStack(GCItems.meteoricIronIngot, 1, 1));
        }
        for (int i = 17; i <= 24; i++) {
            input.put(i, GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1));
        }
        for (int i = 25; i <= 34; i++) {
            input.put(i, new ItemStack(GCItems.heavyPlatingTier1));
        }

        input2 = new HashMap<>(input);
        input2.put(35, null);
        RecipeUtil.addBuggyBenchRecipe(new ItemStack(GCItems.buggy, 1, 0), input2);

        input2 = new HashMap<>(input);
        input2.put(35, RecipeUtil.getChestItemStack(1, 3));
        RecipeUtil.addBuggyBenchRecipe(new ItemStack(GCItems.buggy, 1, 1), input2);

        input2 = new HashMap<>(input);
        input2.put(35, RecipeUtil.getChestItemStack(1, 0));
        RecipeUtil.addBuggyBenchRecipe(new ItemStack(GCItems.buggy, 1, 2), input2);

        input2 = new HashMap<>(input);
        input2.put(35, RecipeUtil.getChestItemStack(1, 1));
        RecipeUtil.addBuggyBenchRecipe(new ItemStack(GCItems.buggy, 1, 3), input2);

        // NEI Integration
        NEIGalacticraftConfig instance = new NEIGalacticraftConfig();
        final int x = BuggyRecipeHandler.tX - BuggyRecipeHandler.x;
        final int y = BuggyRecipeHandler.tY - BuggyRecipeHandler.y;
        final HashMap<Integer, PositionedStack> input3 = new HashMap<>();
        input3.put(1, new PositionedStack(new ItemStack(GCItems.basicItem, 1, 19), 62 - x, 19 - y));
        input3.put(2, new PositionedStack(new ItemStack(GCItems.partBuggy, 1, 1), 62 - x, 55 - y));
        if (GalaxySpace.isModLoaded()) {
            input3.put(
                    3,
                    new PositionedStack(
                            GT_ModHandler
                                    .getModItem(Constants.MOD_ID_GALAXYSPACE, "item.RocketControlComputer", 1, 100),
                            62 - x,
                            73 - y));
        }
        input3.put(4, new PositionedStack(new ItemStack(GCItems.partBuggy), 8 - x, 19 - y));
        input3.put(5, new PositionedStack(new ItemStack(GCItems.partBuggy), 116 - x, 19 - y));
        input3.put(6, new PositionedStack(new ItemStack(GCItems.partBuggy), 8 - x, 109 - y));
        input3.put(7, new PositionedStack(new ItemStack(GCItems.partBuggy), 116 - x, 109 - y));
        input3.put(
                8,
                new PositionedStack(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1),
                        26 - x,
                        19 - y));
        input3.put(
                9,
                new PositionedStack(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1),
                        98 - x,
                        19 - y));
        input3.put(
                10,
                new PositionedStack(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1),
                        26 - x,
                        109 - y));
        input3.put(
                11,
                new PositionedStack(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.StainlessSteel, 1),
                        98 - x,
                        109 - y));
        input3.put(12, new PositionedStack(new ItemStack(GCItems.meteoricIronIngot, 1, 1), 44 - x, 19 - y));
        input3.put(13, new PositionedStack(new ItemStack(GCItems.meteoricIronIngot, 1, 1), 80 - x, 19 - y));
        input3.put(14, new PositionedStack(new ItemStack(GCItems.meteoricIronIngot, 1, 1), 44 - x, 109 - y));
        input3.put(15, new PositionedStack(new ItemStack(GCItems.meteoricIronIngot, 1, 1), 62 - x, 109 - y));
        input3.put(16, new PositionedStack(new ItemStack(GCItems.meteoricIronIngot, 1, 1), 80 - x, 109 - y));
        input3.put(
                17,
                new PositionedStack(
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        8 - x,
                        37 - y));
        input3.put(
                18,
                new PositionedStack(
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        26 - x,
                        37 - y));
        input3.put(
                19,
                new PositionedStack(
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        98 - x,
                        37 - y));
        input3.put(
                20,
                new PositionedStack(
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        116 - x,
                        37 - y));
        input3.put(
                21,
                new PositionedStack(
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        8 - x,
                        91 - y));
        input3.put(
                22,
                new PositionedStack(
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        26 - x,
                        91 - y));
        input3.put(
                23,
                new PositionedStack(
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        98 - x,
                        91 - y));
        input3.put(
                24,
                new PositionedStack(
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.StainlessSteel, 1),
                        116 - x,
                        91 - y));
        input3.put(25, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 44 - x, 37 - y));
        input3.put(26, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 62 - x, 37 - y));
        input3.put(27, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 80 - x, 37 - y));
        input3.put(28, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 44 - x, 55 - y));
        input3.put(29, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 80 - x, 55 - y));
        input3.put(30, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 44 - x, 73 - y));
        input3.put(31, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 80 - x, 73 - y));
        input3.put(32, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 44 - x, 91 - y));
        input3.put(33, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 62 - x, 91 - y));
        input3.put(34, new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 80 - x, 91 - y));
        instance.registerBuggyBenchRecipe(input3, new PositionedStack(new ItemStack(GCItems.buggy), 143 - x, 64 - y));
        HashMap<Integer, PositionedStack> input4 = new HashMap<>(input3);
        input4.put(35, new PositionedStack(RecipeUtil.getChestItemStack(1, 3), 107 - x, 64 - y));
        instance.registerBuggyBenchRecipe(
                input4,
                new PositionedStack(new ItemStack(GCItems.buggy, 1, 1), 143 - x, 64 - y));
        input4 = new HashMap<>(input3);
        input4.put(35, new PositionedStack(RecipeUtil.getChestItemStack(1, 0), 107 - x, 64 - y));
        instance.registerBuggyBenchRecipe(
                input4,
                new PositionedStack(new ItemStack(GCItems.buggy, 1, 2), 143 - x, 64 - y));
        input4 = new HashMap<>(input3);
        input4.put(35, new PositionedStack(RecipeUtil.getChestItemStack(1, 1), 107 - x, 64 - y));
        instance.registerBuggyBenchRecipe(
                input4,
                new PositionedStack(new ItemStack(GCItems.buggy, 1, 3), 143 - x, 64 - y));
    }

    protected static void cargoRecipes() {
        HashMap<Integer, ItemStack> input = new HashMap<>();
        HashMap<Integer, ItemStack> input2;
        input.put(1, new ItemStack(GCItems.basicItem, 1, 14));
        if (GalaxySpace.isModLoaded()) {
            input.put(2, GT_ModHandler.getModItem(Constants.MOD_ID_GALAXYSPACE, "item.RocketControlComputer", 1, 101));
            for (int i = 3; i <= 5; i++) {
                input.put(i, GT_ModHandler.getModItem(Constants.MOD_ID_GALAXYSPACE, "item.ModuleSmallFuelCanister", 1));
            }
        }
        input.put(7, new ItemStack(GCItems.partNoseCone));
        for (int i = 8; i <= 15; i++) {
            input.put(i, new ItemStack(MarsItems.marsItemBasic, 1, 3));
        }
        input.put(16, new ItemStack(GCItems.rocketEngine));
        for (int i = 17; i <= 20; i++) {
            input.put(i, new ItemStack(GCItems.partFins));
        }

        input2 = new HashMap<>(input);
        input2.put(21, RecipeUtil.getChestItemStack(1, 3));
        MarsUtil.adCargoRocketRecipe(new ItemStack(MarsItems.spaceship, 1, 11), input2);
        input2 = new HashMap<>(input);
        input2.put(21, RecipeUtil.getChestItemStack(1, 0));
        MarsUtil.adCargoRocketRecipe(new ItemStack(MarsItems.spaceship, 1, 12), input2);
        input2 = new HashMap<>(input);
        input2.put(21, RecipeUtil.getChestItemStack(1, 1));
        MarsUtil.adCargoRocketRecipe(new ItemStack(MarsItems.spaceship, 1, 13), input2);

        // NEI integration
        NEIGalacticraftMarsConfig instance = new NEIGalacticraftMarsConfig();
        final ArrayList<PositionedStack> input3 = new ArrayList<>();
        ArrayList<PositionedStack> input4 = new ArrayList<>();
        final int x = CargoRocketRecipeHandler.tX - CargoRocketRecipeHandler.x;
        final int y = CargoRocketRecipeHandler.tY - CargoRocketRecipeHandler.y;
        input3.add(new PositionedStack(new ItemStack(GCItems.basicItem, 1, 14), 134 - x, 10 - y));
        if (GalaxySpace.isModLoaded()) {
            input3.add(
                    new PositionedStack(
                            GT_ModHandler
                                    .getModItem(Constants.MOD_ID_GALAXYSPACE, "item.RocketControlComputer", 1, 101),
                            134 - x,
                            28 - y));
            input3.add(
                    new PositionedStack(
                            GT_ModHandler.getModItem(Constants.MOD_ID_GALAXYSPACE, "item.ModuleSmallFuelCanister", 1),
                            116 - x,
                            19 - y));
            input3.add(
                    new PositionedStack(
                            GT_ModHandler.getModItem(Constants.MOD_ID_GALAXYSPACE, "item.ModuleSmallFuelCanister", 1),
                            152 - x,
                            19 - y));
            input3.add(
                    new PositionedStack(
                            GT_ModHandler.getModItem(Constants.MOD_ID_GALAXYSPACE, "item.ModuleSmallFuelCanister", 1),
                            116 - x,
                            37 - y));
        }
        input3.add(new PositionedStack(new ItemStack(GCItems.partNoseCone), 53 - x, 19 - y));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                input3.add(
                        new PositionedStack(
                                new ItemStack(MarsItems.marsItemBasic, 1, 3),
                                44 + j * 18 - x,
                                37 + i * 18 - y));
            }
        }
        input3.add(new PositionedStack(new ItemStack(GCItems.rocketEngine), 53 - x, 109 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.partFins), 26 - x, 91 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.partFins), 80 - x, 91 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.partFins), 26 - x, 109 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.partFins), 80 - x, 109 - y));
        input4 = new ArrayList<>(input3);
        input4.add(new PositionedStack(RecipeUtil.getChestItemStack(1, 3), 134 - x, 46 - y));
        instance.registerCargoBenchRecipe(
                input4,
                new PositionedStack(new ItemStack(MarsItems.spaceship, 1, 11), 134 - x, 73 - y));
        input4 = new ArrayList<>(input3);
        input4.add(new PositionedStack(RecipeUtil.getChestItemStack(1, 0), 134 - x, 46 - y));
        instance.registerCargoBenchRecipe(
                input4,
                new PositionedStack(new ItemStack(MarsItems.spaceship, 1, 12), 134 - x, 73 - y));
        input4 = new ArrayList<>(input3);
        input4.add(new PositionedStack(RecipeUtil.getChestItemStack(1, 1), 134 - x, 46 - y));
        instance.registerCargoBenchRecipe(
                input4,
                new PositionedStack(new ItemStack(MarsItems.spaceship, 1, 13), 134 - x, 73 - y));
    }

    protected static void astroMinerRecipes() {
        final HashMap<Integer, ItemStack> input = new HashMap<>();
        for (int i = 1; i <= 8; i++) {
            input.put(i, new ItemStack(MarsItems.marsItemBasic, 1, 3));
        }
        input.put(9, new ItemStack(GCItems.flagPole));
        input.put(10, new ItemStack(GCItems.flagPole));
        for (int i = 11; i <= 13; i++) {
            input.put(i, new ItemStack(AsteroidsItems.basicItem));
        }
        for (int i = 14; i <= 17; i++) {
            input.put(i, new ItemStack(AsteroidsItems.orionDrive));
        }
        if (GalaxySpace.isModLoaded()) {
            input.put(18, GT_ModHandler.getModItem(Constants.MOD_ID_GALAXYSPACE, "item.RocketControlComputer", 1, 102));
        }
        input.put(19, new ItemStack(GCItems.basicItem, 1, 14));
        input.put(20, new ItemStack(GCItems.basicItem, 1, 14));
        for (int i = 21; i <= 23; i++) {
            input.put(i, new ItemStack(GCItems.heavyPlatingTier1));
        }
        input.put(24, RecipeUtil.getChestItemStack(1, 1));
        input.put(25, RecipeUtil.getChestItemStack(1, 1));
        input.put(26, new ItemStack(AsteroidsItems.basicItem, 1, 8));
        input.put(27, new ItemStack(AsteroidBlocks.beamReceiver));
        input.put(28, GT_ModHandler.getModItem(Constants.MOD_ID_GREGTECH, "gt.metaitem.01", 1, 32603));
        input.put(29, GT_ModHandler.getModItem(Constants.MOD_ID_GREGTECH, "gt.metaitem.01", 1, 32603));
        GalacticraftRegistry
                .addAstroMinerRecipe(new NasaWorkbenchRecipe(new ItemStack(AsteroidsItems.astroMiner, 1, 0), input));

        // NEI integration
        NEIGalacticraftAsteroidsConfig instance = new NEIGalacticraftAsteroidsConfig();
        ArrayList<PositionedStack> input3 = new ArrayList<>();
        final int x = AstroMinerRecipeHandler.tX - AstroMinerRecipeHandler.x;
        final int y = AstroMinerRecipeHandler.tY - AstroMinerRecipeHandler.y;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                input3.add(
                        new PositionedStack(
                                new ItemStack(MarsItems.marsItemBasic, 1, 3),
                                44 + j * 18 - x,
                                19 + i * 72 - y));
            }
        }
        input3.add(new PositionedStack(new ItemStack(GCItems.flagPole), 116 - x, 19 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.flagPole), 116 - x, 91 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidsItems.basicItem), 26 - x, 37 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidsItems.basicItem), 8 - x, 55 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidsItems.basicItem), 26 - x, 73 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidsItems.orionDrive), 44 - x, 37 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidsItems.orionDrive), 26 - x, 55 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidsItems.orionDrive), 44 - x, 55 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidsItems.orionDrive), 62 - x, 55 - y));
        if (GalaxySpace.isModLoaded()) {
            input3.add(
                    new PositionedStack(
                            GT_ModHandler
                                    .getModItem(Constants.MOD_ID_GALAXYSPACE, "item.RocketControlComputer", 1, 102),
                            62 - x,
                            37 - y));
        }
        input3.add(new PositionedStack(new ItemStack(GCItems.basicItem, 1, 14), 80 - x, 37 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.basicItem, 1, 14), 98 - x, 37 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 116 - x, 37 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 116 - x, 55 - y));
        input3.add(new PositionedStack(new ItemStack(GCItems.heavyPlatingTier1), 116 - x, 73 - y));
        input3.add(new PositionedStack(RecipeUtil.getChestItemStack(1, 1), 80 - x, 55 - y));
        input3.add(new PositionedStack(RecipeUtil.getChestItemStack(1, 1), 98 - x, 55 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidsItems.basicItem, 1, 8), 44 - x, 73 - y));
        input3.add(new PositionedStack(new ItemStack(AsteroidBlocks.beamReceiver), 62 - x, 73 - y));
        input3.add(
                new PositionedStack(
                        GT_ModHandler.getModItem(Constants.MOD_ID_GREGTECH, "gt.metaitem.01", 1, 32603),
                        80 - x,
                        73 - y));
        input3.add(
                new PositionedStack(
                        GT_ModHandler.getModItem(Constants.MOD_ID_GREGTECH, "gt.metaitem.01", 1, 32603),
                        98 - x,
                        73 - y));
        instance.registerAstroMinerRecipe(
                input3,
                new PositionedStack(new ItemStack(AsteroidsItems.astroMiner), 143 - x, 55 - y));
    }
}
