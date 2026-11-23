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

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Mods;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.objects.OreDictItemStack;

public class ScriptIronChests implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Iron Chests";
    }

    @Override
    public List<Mods> getDependencies() {
        return Arrays.asList(
                BiomesOPlenty,
                ExtraTrees,
                ExtraUtilities,
                Fether,
                ForbiddenMagic,
                Forestry,
                GalacticraftAmunRa,
                GalaxySpace,
                IndustrialCraft2,
                IronChests,
                IronChestsMinecarts,
                Natura,
                TaintedMagic,
                Thaumcraft,
                ThaumicBases,
                TwilightForest,
                Witchery);
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
                MaterialLibAPI.getStack(Materials.Diamond, Shapes.screw, 1),
                getModItem(IronChests.ID, "BlockIronChest", 1, 2),
                MaterialLibAPI.getStack(Materials.Diamond, Shapes.screw, 1),
                MaterialLibAPI.getStack(Materials.Diamond, Shapes.screw, 1),
                getModItem(Minecraft.ID, "minecart", 1, 0),
                MaterialLibAPI.getStack(Materials.Diamond, Shapes.screw, 1));
        addShapedRecipe(
                getModItem(IronChestsMinecarts.ID, "minecart_chest_crystal", 1, 0),
                null,
                "craftingToolScrewdriver",
                null,
                MaterialLibAPI.getStack(Materials.Glass, Shapes.screw, 1),
                getModItem(IronChests.ID, "BlockIronChest", 1, 5),
                MaterialLibAPI.getStack(Materials.Glass, Shapes.screw, 1),
                MaterialLibAPI.getStack(Materials.Glass, Shapes.screw, 1),
                getModItem(Minecraft.ID, "minecart", 1, 0),
                MaterialLibAPI.getStack(Materials.Glass, Shapes.screw, 1));
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
                MaterialLibAPI.getStack(Materials.Copper, Shapes.plateDouble, 1),
                "screwCopper",
                MaterialLibAPI.getStack(Materials.Copper, Shapes.plateDouble, 1),
                getModItem(Minecraft.ID, "chest", 1, 0),
                MaterialLibAPI.getStack(Materials.Copper, Shapes.plateDouble, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.Copper, Shapes.plateDouble, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0),
                "screwCopper",
                MaterialLibAPI.getStack(Materials.Copper, Shapes.plateDouble, 1),
                "screwCopper",
                MaterialLibAPI.getStack(Materials.Copper, Shapes.plateDouble, 1),
                "plankWood",
                MaterialLibAPI.getStack(Materials.Copper, Shapes.plateDouble, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.Copper, Shapes.plateDouble, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 0),
                "screwIron",
                MaterialLibAPI.getStack(Materials.Iron, Shapes.plateDouble, 1),
                "screwIron",
                MaterialLibAPI.getStack(Materials.Iron, Shapes.plateDouble, 1),
                getModItem(Minecraft.ID, "chest", 1, 0),
                MaterialLibAPI.getStack(Materials.Iron, Shapes.plateDouble, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.Iron, Shapes.plateDouble, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "woodIronUpgrade", 1, 0),
                "screwIron",
                MaterialLibAPI.getStack(Materials.Iron, Shapes.plateDouble, 1),
                "screwIron",
                MaterialLibAPI.getStack(Materials.Iron, Shapes.plateDouble, 1),
                "plankWood",
                MaterialLibAPI.getStack(Materials.Iron, Shapes.plateDouble, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.Iron, Shapes.plateDouble, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "copperIronUpgrade", 1, 0),
                "screwIron",
                MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, 1),
                "screwIron",
                MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.Copper, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 4),
                "screwSteel",
                MaterialLibAPI.getStack(Materials.Steel, Shapes.plateDouble, 1),
                "screwSteel",
                MaterialLibAPI.getStack(Materials.Steel, Shapes.plateDouble, 1),
                getModItem(Minecraft.ID, "chest", 1, 0),
                MaterialLibAPI.getStack(Materials.Steel, Shapes.plateDouble, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.Steel, Shapes.plateDouble, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "copperSteelUpgrade", 1, 0),
                "screwSteel",
                MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, 1),
                "screwSteel",
                MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.Copper, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 1),
                "screwGold",
                MaterialLibAPI.getStack(Materials.Gold, Shapes.plateDouble, 1),
                "screwGold",
                MaterialLibAPI.getStack(Materials.Gold, Shapes.plateDouble, 1),
                getModItem(Minecraft.ID, "chest", 1, 0),
                MaterialLibAPI.getStack(Materials.Gold, Shapes.plateDouble, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.Gold, Shapes.plateDouble, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "ironGoldUpgrade", 1, 0),
                "screwGold",
                MaterialLibAPI.getStack(Materials.Gold, Shapes.plate, 1),
                "screwGold",
                MaterialLibAPI.getStack(Materials.Gold, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.Gold, Shapes.plate, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.Gold, Shapes.plate, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "steelGoldUpgrade", 1, 0),
                "screwGold",
                MaterialLibAPI.getStack(Materials.Gold, Shapes.plate, 1),
                "screwGold",
                MaterialLibAPI.getStack(Materials.Gold, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.Gold, Shapes.plate, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.Gold, Shapes.plate, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 2),
                "screwDiamond",
                MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, 1),
                "screwDiamond",
                MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, 1),
                getModItem(Minecraft.ID, "chest", 1, 0),
                MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "goldDiamondUpgrade", 1, 0),
                "screwDiamond",
                MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, 1),
                "screwDiamond",
                null,
                MaterialLibAPI.getStack(Materials.Gold, Shapes.plate, 1),
                null,
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 5),
                "screwGlass",
                MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, 1),
                "screwGlass",
                MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, 1),
                getModItem(IronChests.ID, "BlockIronChest", 1, 2),
                MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "diamondCrystalUpgrade", 1, 0),
                "screwGlass",
                MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, 1),
                "screwGlass",
                MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, 1),
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
                MaterialLibAPI.getStack(Materials.Obsidian, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.Obsidian, Shapes.plate, 1),
                "craftingToolHardHammer",
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "BlockIronChest", 1, 9),
                "screwDarkSteel",
                MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plateDouble, 1),
                "screwDarkSteel",
                MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plateDouble, 1),
                getModItem(IronChests.ID, "BlockIronChest", 1, 2),
                MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plateDouble, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plateDouble, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "diamondDarkSteelUpgrade", 1, 0),
                "screwDarkSteel",
                MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plateDouble, 1),
                "screwDarkSteel",
                MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plateDouble, 1),
                MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plateDouble, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plateDouble, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "crystalDarkSteelUpgrade", 1, 0),
                "screwDarkSteel",
                MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plateDouble, 1),
                "screwDarkSteel",
                MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plateDouble, 1),
                MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plateDouble, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plateDouble, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "obsidianDarkSteelUpgrade", 1, 0),
                "screwDarkSteel",
                MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plate, 1),
                "screwDarkSteel",
                MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.Obsidian, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plate, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plate, 1),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IronChests.ID, "ironSteelUpgrade", 1, 0),
                "screwSteel",
                MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, 1),
                "screwSteel",
                MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, 1),
                MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, 1),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, 1),
                "craftingToolScrewdriver");

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "chest", 1, 0), getModItem(Minecraft.ID, "dirt", 8, 0))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 7)).duration(4 * SECONDS).eut(1)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.plateDouble, 3))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 3)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new OreDictItemStack("plankWood", 1),
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.plateDouble, 3))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "woodCopperUpgrade", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plateDouble, 3))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 0)).duration(7 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        new OreDictItemStack("plankWood", 1),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plateDouble, 3))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "woodIronUpgrade", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.plate, 1),
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plateDouble, 1))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "copperIronUpgrade", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plateDouble, 3))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 4)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Copper, Shapes.plate, 1),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plateDouble, 1))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "copperSteelUpgrade", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, 1),
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plateDouble, 1))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "ironSteelUpgrade", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.plateDouble, 3))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 1)).duration(12 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Iron, Shapes.plate, 1),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.plateDouble, 1))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "ironGoldUpgrade", 1, 0)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Steel, Shapes.plate, 1),
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.plateDouble, 1))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "steelGoldUpgrade", 1, 0)).duration(25 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "chest", 1, 0),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, 4))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 2)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Gold, Shapes.plate, 1),
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, 2))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "goldDiamondUpgrade", 1, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 2),
                        MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, 4))
                .itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 5)).duration(17 * SECONDS + 10 * TICKS)
                .eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, 1),
                        MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, 2))
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
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, 1),
                        getModItem(IndustrialCraft2.ID, "itemDensePlates", 2, 7))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "diamondObsidianUpgrade", 1, 0))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_HV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IronChests.ID, "BlockIronChest", 1, 2),
                        MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plateDouble, 2))
                .circuit(2).itemOutputs(getModItem(IronChests.ID, "BlockIronChest", 1, 9)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Diamond, Shapes.plate, 1),
                        MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plateDouble, 2))
                .circuit(7).itemOutputs(getModItem(IronChests.ID, "diamondDarkSteelUpgrade", 1, 0))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Glass, Shapes.plate, 1),
                        MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plateDouble, 2))
                .circuit(7).itemOutputs(getModItem(IronChests.ID, "crystalDarkSteelUpgrade", 1, 0))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialLibAPI.getStack(Materials.Obsidian, Shapes.plate, 1),
                        MaterialLibAPI.getStack(Materials.DarkSteel, Shapes.plateDouble, 2))
                .circuit(7).itemOutputs(getModItem(IronChests.ID, "obsidianDarkSteelUpgrade", 1, 0))
                .duration(40 * SECONDS).eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
    }
}
