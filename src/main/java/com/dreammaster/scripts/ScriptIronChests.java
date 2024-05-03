package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.IronChestsMinecarts;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.PamsHarvestTheNether;
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ScriptIronChests implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Iron Chests";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                IronChests.ID,
                GalacticraftAmunRa.ID,
                IronChestsMinecarts.ID,
                BiomesOPlenty.ID,
                ExtraTrees.ID,
                ExtraUtilities.ID,
                ForbiddenMagic.ID,
                Forestry.ID,
                GalaxySpace.ID,
                IndustrialCraft2.ID,
                Natura.ID,
                PamsHarvestTheNether.ID,
                TaintedMagic.ID,
                Thaumcraft.ID,
                ThaumicBases.ID,
                TwilightForest.ID,
                Witchery.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(IronChestsMinecarts.ID, "minecart_chest_copper", 1, 0, missing),
                null,
                "craftingToolScrewdriver",
                null,
                "screwCopper",
                getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing),
                "screwCopper",
                "screwCopper",
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                "screwCopper");
        addShapedRecipe(
                getModItem(IronChestsMinecarts.ID, "minecart_chest_iron", 1, 0, missing),
                null,
                "craftingToolScrewdriver",
                null,
                "screwAnyIron",
                getModItem(IronChests.ID, "BlockIronChest", 1, 0, missing),
                "screwAnyIron",
                "screwAnyIron",
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                "screwAnyIron");
        addShapedRecipe(
                getModItem(IronChestsMinecarts.ID, "minecart_chest_steel", 1, 0, missing),
                null,
                "craftingToolScrewdriver",
                null,
                "screwSteel",
                getModItem(IronChests.ID, "BlockIronChest", 1, 4, missing),
                "screwSteel",
                "screwSteel",
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                "screwSteel");
        addShapedRecipe(
                getModItem(IronChestsMinecarts.ID, "minecart_chest_gold", 1, 0, missing),
                null,
                "craftingToolScrewdriver",
                null,
                "screwGold",
                getModItem(IronChests.ID, "BlockIronChest", 1, 1, missing),
                "screwGold",
                "screwGold",
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                "screwGold");
        addShapedRecipe(
                getModItem(IronChestsMinecarts.ID, "minecart_chest_diamond", 1, 0, missing),
                null,
                "craftingToolScrewdriver",
                null,
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L),
                getModItem(IronChests.ID, "BlockIronChest", 1, 2, missing),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L),
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L));
        addShapedRecipe(
                getModItem(IronChestsMinecarts.ID, "minecart_chest_crystal", 1, 0, missing),
                null,
                "craftingToolScrewdriver",
                null,
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Glass, 1L),
                getModItem(IronChests.ID, "BlockIronChest", 1, 5, missing),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Glass, 1L),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Glass, 1L),
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Glass, 1L));
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 7, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing));
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing),
                "screwCopper",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "screwCopper",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing),
                "screwCopper",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "screwCopper",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "plankWood",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 0, missing),
                "screwIron",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "screwIron",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing),
                "screwIron",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "screwIron",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "plankWood",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "copperIronUpgrade", 1, 0, missing),
                "screwIron",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                "screwIron",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 4, missing),
                "screwSteel",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                "screwSteel",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "copperSteelUpgrade", 1, 0, missing),
                "screwSteel",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                "screwSteel",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 1, missing),
                "screwGold",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                "screwGold",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "ironGoldUpgrade", 1, 0, missing),
                "screwGold",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                "screwGold",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "steelGoldUpgrade", 1, 0, missing),
                "screwGold",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                "screwGold",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 2, missing),
                "screwDiamond",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "screwDiamond",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "goldDiamondUpgrade", 1, 0, missing),
                "screwDiamond",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "screwDiamond",
                null,
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                null,
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 5, missing),
                "screwGlass",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                "screwGlass",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                getModItem(IronChests.ID, "BlockIronChest", 1, 2, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "diamondCrystalUpgrade", 1, 0, missing),
                "screwGlass",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                "screwGlass",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 6, missing),
                "screwDiamond",
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7, missing),
                "screwDiamond",
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7, missing),
                getModItem(IronChests.ID, "BlockIronChest", 1, 2, missing),
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7, missing),
                "craftingToolHardHammer",
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7, missing),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "diamondObsidianUpgrade", 1, 0, missing),
                "screwDiamond",
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7, missing),
                "screwDiamond",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L),
                "craftingToolHardHammer",
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7, missing),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 9, missing),
                "screwDarkSteel",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "screwDarkSteel",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                getModItem(IronChests.ID, "BlockIronChest", 1, 2, missing),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "diamondDarkSteelUpgrade", 1, 0, missing),
                "screwDarkSteel",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "screwDarkSteel",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "craftingToolScrewdriver");

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        getModItem(Minecraft.ID, "dirt", 8, 0, missing))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 7, missing)).duration(4 * SECONDS).eut(1)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 3, missing)).duration(5 * SECONDS).eut(8)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "planks", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 1, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 2, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 3, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 4, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 5, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 6, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 7, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 8, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 9, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 10, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 11, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 12, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 13, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 14, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 15, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftAmunRa.ID, "tile.wood1", 1, 3, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftAmunRa.ID, "tile.wood1", 1, 2, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 7, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "planks", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "planks", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "planksFireproof", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ThaumicBases.ID, "enderPlanks", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Witchery.ID, "witchwood", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalaxySpace.ID, "barnardaCplanks", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TaintedMagic.ID, "BlockWarpwoodPlanks", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TwilightForest.ID, "tile.TFTowerStone", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TwilightForest.ID, "tile.TFPlanks", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ForbiddenMagic.ID, "TaintPlank", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 0, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "planks", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 1, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 2, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 3, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 4, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 5, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 6, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 7, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 8, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 9, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 10, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 11, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 12, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 13, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 14, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 1, 15, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftAmunRa.ID, "tile.wood1", 1, 3, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftAmunRa.ID, "tile.wood1", 1, 2, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 6, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 7, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "planks", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "planks", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "planksFireproof", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 0, "{meta:0}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 1, "{meta:1}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 2, "{meta:2}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 3, "{meta:3}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 4, "{meta:4}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 5, "{meta:5}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 6, "{meta:6}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 7, "{meta:7}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 8, "{meta:8}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 9, "{meta:9}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 10, "{meta:10}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 11, "{meta:11}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 12, "{meta:12}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 13, "{meta:13}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 14, "{meta:14}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 15, "{meta:15}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 16, "{meta:16}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 17, "{meta:17}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 18, "{meta:18}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 19, "{meta:19}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 20, "{meta:20}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 21, "{meta:21}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 22, "{meta:22}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 23, "{meta:23}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 24, "{meta:24}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 25, "{meta:25}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 26, "{meta:26}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 27, "{meta:27}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 28, "{meta:28}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 29, "{meta:29}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 30, "{meta:30}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 31, "{meta:31}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 32, "{meta:32}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 33, "{meta:33}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "planks", 1, 34, "{meta:34}", missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ThaumicBases.ID, "enderPlanks", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Witchery.ID, "witchwood", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalaxySpace.ID, "barnardaCplanks", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TaintedMagic.ID, "BlockWarpwoodPlanks", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TwilightForest.ID, "tile.TFTowerStone", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TwilightForest.ID, "tile.TFPlanks", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ForbiddenMagic.ID, "TaintPlank", 1, wildcard, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0, missing)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "copperIronUpgrade", 1, 0, missing)).duration(15 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 3L))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 4, missing)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "copperSteelUpgrade", 1, 0, missing)).duration(20 * SECONDS)
                .eut(30).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 3L))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 1, missing))
                .duration(12 * SECONDS + 10 * TICKS).eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "ironGoldUpgrade", 1, 0, missing)).duration(25 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "steelGoldUpgrade", 1, 0, missing)).duration(25 * SECONDS)
                .eut(64).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 4L))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 2, missing)).duration(15 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 2L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "goldDiamondUpgrade", 1, 0, missing)).duration(30 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 2, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 4L))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 5, missing))
                .duration(17 * SECONDS + 10 * TICKS).eut(256).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 2L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "diamondCrystalUpgrade", 1, 0, missing)).duration(35 * SECONDS)
                .eut(256).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 2, missing),
                        getModItem(IndustrialCraft2.ID, "itemDensePlates", 3, 7, missing),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 6, missing)).duration(20 * SECONDS).eut(256)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7, missing),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "diamondObsidianUpgrade", 1, 0, missing)).duration(40 * SECONDS)
                .eut(256).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 2, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 2L),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 9, missing)).duration(20 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 2L))
                .itemOutputs(getModItem(IronChests.ID, "diamondDarkSteelUpgrade", 1, 0, missing)).duration(40 * SECONDS)
                .eut(480).addTo(assemblerRecipes);

    }
}
