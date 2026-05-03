package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Fether;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.IronChestsMinecarts;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.objects.OreDictItemStack;
import gregtech.api.util.GTOreDictUnificator;

public class ScriptIronChests implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Iron Chests";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                BiomesOPlenty.ID,
                ExtraTrees.ID,
                ExtraUtilities.ID,
                Fether.ID,
                ForbiddenMagic.ID,
                Forestry.ID,
                GalacticraftAmunRa.ID,
                GalaxySpace.ID,
                IndustrialCraft2.ID,
                IronChests.ID,
                IronChestsMinecarts.ID,
                Natura.ID,
                TaintedMagic.ID,
                Thaumcraft.ID,
                ThaumicBases.ID,
                TwilightForest.ID,
                Witchery.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(IronChestsMinecarts.ID, "minecart_chest_copper", 1, 0),
                null,
                "craftingToolScrewdriver",
                null,
                "screwCopper",
                getModItem(IronChests.ID, "BlockIronChest", 1, 3),
                "screwCopper",
                "screwCopper",
                getModItem(Minecraft.ID, "minecart", 1, 0),
                "screwCopper");
        addShapedRecipe(
                getModItem(IronChestsMinecarts.ID, "minecart_chest_iron", 1, 0),
                null,
                "craftingToolScrewdriver",
                null,
                "screwAnyIron",
                getModItem(IronChests.ID, "BlockIronChest", 1, 0),
                "screwAnyIron",
                "screwAnyIron",
                getModItem(Minecraft.ID, "minecart", 1, 0),
                "screwAnyIron");
        addShapedRecipe(
                getModItem(IronChestsMinecarts.ID, "minecart_chest_steel", 1, 0),
                null,
                "craftingToolScrewdriver",
                null,
                "screwSteel",
                getModItem(IronChests.ID, "BlockIronChest", 1, 4),
                "screwSteel",
                "screwSteel",
                getModItem(Minecraft.ID, "minecart", 1, 0),
                "screwSteel");
        addShapedRecipe(
                getModItem(IronChestsMinecarts.ID, "minecart_chest_gold", 1, 0),
                null,
                "craftingToolScrewdriver",
                null,
                "screwGold",
                getModItem(IronChests.ID, "BlockIronChest", 1, 1),
                "screwGold",
                "screwGold",
                getModItem(Minecraft.ID, "minecart", 1, 0),
                "screwGold");
        addShapedRecipe(
                getModItem(IronChestsMinecarts.ID, "minecart_chest_diamond", 1, 0),
                null,
                "craftingToolScrewdriver",
                null,
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L),
                getModItem(IronChests.ID, "BlockIronChest", 1, 2),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L),
                getModItem(Minecraft.ID, "minecart", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Diamond, 1L));
        addShapedRecipe(
                getModItem(IronChestsMinecarts.ID, "minecart_chest_crystal", 1, 0),
                null,
                "craftingToolScrewdriver",
                null,
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Glass, 1L),
                getModItem(IronChests.ID, "BlockIronChest", 1, 5),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Glass, 1L),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Glass, 1L),
                getModItem(Minecraft.ID, "minecart", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Glass, 1L));
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 7),
                getModItem(Minecraft.ID, "dirt", 1, 0),
                getModItem(Minecraft.ID, "dirt", 1, 0),
                getModItem(Minecraft.ID, "dirt", 1, 0),
                getModItem(Minecraft.ID, "dirt", 1, 0),
                getModItem(Minecraft.ID, "chest", 1, 0),
                getModItem(Minecraft.ID, "dirt", 1, 0),
                getModItem(Minecraft.ID, "dirt", 1, 0),
                getModItem(Minecraft.ID, "dirt", 1, 0),
                getModItem(Minecraft.ID, "dirt", 1, 0));
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 3),
                "screwCopper",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "screwCopper",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                getModItem(Minecraft.ID, "chest", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0),
                "screwCopper",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "screwCopper",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "plankWood",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 0),
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                getModItem(Minecraft.ID, "chest", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "woodIronUpgrade", 1, 0),
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "plankWood",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "copperIronUpgrade", 1, 0),
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                "screwIron",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 4),
                "screwSteel",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                "screwSteel",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                getModItem(Minecraft.ID, "chest", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "copperSteelUpgrade", 1, 0),
                "screwSteel",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                "screwSteel",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 1),
                "screwGold",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                "screwGold",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                getModItem(Minecraft.ID, "chest", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "ironGoldUpgrade", 1, 0),
                "screwGold",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                "screwGold",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "steelGoldUpgrade", 1, 0),
                "screwGold",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                "screwGold",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 2),
                "screwDiamond",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "screwDiamond",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                getModItem(Minecraft.ID, "chest", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "goldDiamondUpgrade", 1, 0),
                "screwDiamond",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "screwDiamond",
                null,
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                null,
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 5),
                "screwGlass",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                "screwGlass",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                getModItem(IronChests.ID, "BlockIronChest", 1, 2),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "diamondCrystalUpgrade", 1, 0),
                "screwGlass",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                "screwGlass",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 6),
                "screwDiamond",
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7),
                "screwDiamond",
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7),
                getModItem(IronChests.ID, "BlockIronChest", 1, 2),
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7),
                "craftingToolHardHammer",
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "diamondObsidianUpgrade", 1, 0),
                "screwDiamond",
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7),
                "screwDiamond",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L),
                "craftingToolHardHammer",
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 9),
                "screwDarkSteel",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "screwDarkSteel",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                getModItem(IronChests.ID, "BlockIronChest", 1, 2),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "diamondDarkSteelUpgrade", 1, 0),
                "screwDarkSteel",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "screwDarkSteel",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "crystalDarkSteelUpgrade", 1, 0),
                "screwDarkSteel",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "screwDarkSteel",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "obsidianDarkSteelUpgrade", 1, 0),
                "screwDarkSteel",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 1L),
                "screwDarkSteel",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.DarkSteel, 1L),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "ironSteelUpgrade", 1, 0),
                "screwSteel",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                "screwSteel",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                "craftingToolScrewdriver");

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "chest", 1, 0), getModItem(Minecraft.ID, "dirt", 8, 0))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 7)).duration(4 * SECONDS).eut(1)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 3)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new OreDictItemStack("plankWood", 1),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Copper, 3L))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 0)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new OreDictItemStack("plankWood", 1),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 3L))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Iron, 1L))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "copperIronUpgrade", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 3L))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 4)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Copper, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "copperSteelUpgrade", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Steel, 1L))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "ironSteelUpgrade", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 3L))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 1)).duration(12 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "ironGoldUpgrade", 1, 0)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Gold, 1L))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "steelGoldUpgrade", 1, 0)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 4L))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 2)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 2L))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "goldDiamondUpgrade", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 2),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 4L))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 5)).duration(17 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 2L))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "diamondCrystalUpgrade", 1, 0)).duration(35 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 2),
                        getModItem(IndustrialCraft2.ID, "itemDensePlates", 2, 7))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 6)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        getModItem(IndustrialCraft2.ID, "itemDensePlates", 2, 7))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "diamondObsidianUpgrade", 1, 0))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 2),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 2L))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 9)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 2L))
                .circuit(7).itemOutputs(getModItem(IronChests.ID, "diamondDarkSteelUpgrade", 1, 0))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Glass, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 2L))
                .circuit(7).itemOutputs(getModItem(IronChests.ID, "crystalDarkSteelUpgrade", 1, 0))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.DarkSteel, 2L))
                .circuit(7).itemOutputs(getModItem(IronChests.ID, "obsidianDarkSteelUpgrade", 1, 0))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
    }
}
