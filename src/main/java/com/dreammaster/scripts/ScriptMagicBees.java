package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.Genetics;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MagicBees;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.dreammaster.botania.BotaniaHelper;
import com.dreammaster.forestry.ForestryHelper;
import com.dreammaster.thaumcraft.TCHelper;

import forestry.api.recipes.RecipeManagers;
import goodgenerator.loader.Loaders;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import vazkii.botania.api.BotaniaAPI;

public class ScriptMagicBees implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Magic Bees";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Mods.MagicBees.ID,
                Thaumcraft.ID,
                Forestry.ID,
                AppliedEnergistics2.ID,
                Backpack.ID,
                Botania.ID,
                Genetics.ID,
                IndustrialCraft2.ID,
                PamsHarvestCraft.ID);
    }

    @Override
    public void loadRecipes() {

        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.InfusedAir, 1L),
                getModItem(MagicBees.ID, "miscResources", 1, 18, missing));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.InfusedWater, 1L),
                getModItem(MagicBees.ID, "miscResources", 1, 19, missing));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.InfusedFire, 1L),
                getModItem(MagicBees.ID, "miscResources", 1, 20, missing));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.InfusedEarth, 1L),
                getModItem(MagicBees.ID, "miscResources", 1, 21, missing));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.InfusedOrder, 1L),
                getModItem(MagicBees.ID, "miscResources", 1, 22, missing));
        addShapelessRecipe(
                GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.InfusedEntropy, 1L),
                getModItem(MagicBees.ID, "miscResources", 1, 23, missing));
        addShapedRecipe(
                getModItem(MagicBees.ID, "backpack.thaumaturgeT1", 1, 0, missing),
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "gemAmber",
                getModItem(PamsHarvestCraft.ID, "wovencottonItem", 1, 0, missing),
                "itemLeather",
                "gemAmber",
                "itemLeather",
                "itemLeather",
                getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                "itemLeather");
        addShapelessRecipe(
                getModItem(MagicBees.ID, "backpack.thaumaturgeT1", 1, 0, missing),
                getModItem(MagicBees.ID, "backpack.thaumaturgeT1", 1, 0, missing));
        addShapedRecipe(
                getModItem(MagicBees.ID, "magnet", 1, 0, missing),
                "craftingToolWrench",
                "plateIron",
                "screwSteelMagnetic",
                getModItem(Minecraft.ID, "compass", 1, 0, missing),
                getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                getModItem(Minecraft.ID, "compass", 1, 0, missing),
                "screwSteelMagnetic",
                "gemExquisiteDiamond",
                "craftingToolScrewdriver");

        ForestryHelper.removeCarpenterRecipe(getModItem(MagicBees.ID, "backpack.thaumaturgeT2", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("seedoil", 5000),
                getModItem(MagicBees.ID, "backpack.thaumaturgeT1", 1, 0, missing),
                getModItem(MagicBees.ID, "backpack.thaumaturgeT2", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'b',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'c',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'd',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'e',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'f',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'g',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'h',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing),
                'i',
                getModItem(Forestry.ID, "craftingMaterial", 1, 3, missing));
        BotaniaHelper
                .removePetalRecipe(createItemStack(Botania.ID, "specialFlower", 1, 0, "{type:\"beegonia\"}", missing));
        BotaniaAPI.registerPetalRecipe(
                createItemStack(Botania.ID, "specialFlower", 1, 0, "{type:\"beegonia\"}", missing),
                "flowerIngredientWhite",
                "flowerIngredientYellow",
                "flowerIngredientYellow",
                "flowerIngredientBlack",
                "powderMana",
                "powderMana",
                "powderMana",
                "flowerAnemoneWhite");
        BotaniaHelper.removePetalRecipe(
                createItemStack(Botania.ID, "specialFlower", 1, 0, "{type:\"hiveacynth\"}", missing));
        BotaniaAPI.registerPetalRecipe(
                createItemStack(Botania.ID, "specialFlower", 1, 0, "{type:\"hiveacynth\"}", missing),
                "flowerIngredientLightBlue",
                "flowerIngredientCyan",
                "flowerIngredientCyan",
                "flowerIngredientBlue",
                "powderMana",
                getModItem(MagicBees.ID, "wax", 1, 1, missing),
                getModItem(MagicBees.ID, "miscResources", 1, 7, missing),
                "powderMana",
                "redstoneRoot",
                "runeSpringB",
                "flowerIcyIris");
        BotaniaHelper
                .removePetalRecipe(createItemStack(Botania.ID, "specialFlower", 1, 0, "{type:\"hibeescus\"}", missing));
        BotaniaAPI.registerPetalRecipe(
                createItemStack(Botania.ID, "specialFlower", 1, 0, "{type:\"hibeescus\"}", missing),
                "flowerIngredientOrange",
                "flowerIngredientMagenta",
                "flowerIngredientMagenta",
                "flowerIngredientMagenta",
                "flowerIngredientRed",
                "powderMana",
                getModItem(MagicBees.ID, "wax", 1, 1, missing),
                getModItem(MagicBees.ID, "wax", 1, 2, missing),
                "runeEnvyB",
                "runeGreedB",
                "runePrideB",
                getModItem(MagicBees.ID, "miscResources", 1, 10, missing),
                "redstoneRoot",
                "eternalLifeEssence",
                "flowerHibiscusPink");

        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 0, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 1, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 2, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 3, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 4, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 5, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 6, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 7, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 8, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 9, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 10, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 11, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 12, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 13, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 14, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 15, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 16, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 17, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 18, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 19, missing));
        OreDictionary.registerOre("beeComb", getModItem(MagicBees.ID, "comb", 1, 20, missing));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Genetics.ID, "misc", 2, 8, missing),
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing))
                .itemOutputs(getModItem(MagicBees.ID, "capsule.void", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 288)).duration(30 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "tile.BlockQuartzGlass", 5, 0, missing),
                        getModItem(MagicBees.ID, "pollen", 1, 0, missing))
                .itemOutputs(getModItem(MagicBees.ID, "effectJar", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 144)).duration(30 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(MagicBees.ID, "miscResources", 4, 3, missing), GTUtility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(MagicBees.ID, "miscResources", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.thaumium", 72)).duration(10 * SECONDS).eut(48)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(MagicBees.ID, "miscResources", 6, 5, missing), GTUtility.getIntegratedCircuit(6))
                .itemOutputs(getModItem(MagicBees.ID, "miscResources", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.thaumium", 288)).duration(20 * SECONDS).eut(256)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "clock", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.gem, Materials.Jade, 4L))
                .itemOutputs(getModItem(MagicBees.ID, "moonDial", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 576)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                        getModItem(MagicBees.ID, "magnet", 2, 0, missing))
                .itemOutputs(getModItem(MagicBees.ID, "magnet", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1296)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                        getModItem(MagicBees.ID, "magnet", 2, 1, missing))
                .itemOutputs(getModItem(MagicBees.ID, "magnet", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1296)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                        getModItem(MagicBees.ID, "magnet", 2, 2, missing))
                .itemOutputs(getModItem(MagicBees.ID, "magnet", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1296)).duration(20 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                        getModItem(MagicBees.ID, "magnet", 2, 3, missing))
                .itemOutputs(getModItem(MagicBees.ID, "magnet", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1296)).duration(20 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                        getModItem(MagicBees.ID, "magnet", 2, 4, missing))
                .itemOutputs(getModItem(MagicBees.ID, "magnet", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1296)).duration(30 * SECONDS).eut(256)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                        getModItem(MagicBees.ID, "magnet", 2, 5, missing))
                .itemOutputs(getModItem(MagicBees.ID, "magnet", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1296)).duration(30 * SECONDS).eut(256)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                        getModItem(MagicBees.ID, "magnet", 2, 6, missing))
                .itemOutputs(getModItem(MagicBees.ID, "magnet", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1296)).duration(40 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                        getModItem(MagicBees.ID, "magnet", 2, 7, missing))
                .itemOutputs(getModItem(MagicBees.ID, "magnet", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1296)).duration(40 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                        getModItem(MagicBees.ID, "magnet", 2, 8, missing))
                .itemOutputs(getModItem(MagicBees.ID, "magnet", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1296)).duration(50 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                        getModItem(MagicBees.ID, "magnet", 2, 9, missing))
                .itemOutputs(getModItem(MagicBees.ID, "magnet", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1296)).duration(50 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                        getModItem(MagicBees.ID, "magnet", 2, 10, missing))
                .itemOutputs(getModItem(MagicBees.ID, "magnet", 1, 12, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1296)).duration(1 * MINUTES).eut(1920)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                        getModItem(MagicBees.ID, "magnet", 2, 11, missing))
                .itemOutputs(getModItem(MagicBees.ID, "magnet", 1, 12, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1296)).duration(1 * MINUTES).eut(1920)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                        getModItem(MagicBees.ID, "magnet", 2, 12, missing))
                .itemOutputs(getModItem(MagicBees.ID, "magnet", 1, 14, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1296)).duration(1 * MINUTES + 10 * SECONDS)
                .eut(4096).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                        getModItem(MagicBees.ID, "magnet", 2, 13, missing))
                .itemOutputs(getModItem(MagicBees.ID, "magnet", 1, 14, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1296)).duration(1 * MINUTES + 10 * SECONDS)
                .eut(4096).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                        getModItem(MagicBees.ID, "magnet", 2, 14, missing))
                .itemOutputs(getModItem(MagicBees.ID, "magnet", 1, 16, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1296)).duration(1 * MINUTES + 20 * SECONDS)
                .eut(7680).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                        getModItem(MagicBees.ID, "magnet", 2, 15, missing))
                .itemOutputs(getModItem(MagicBees.ID, "magnet", 1, 16, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1296)).duration(1 * MINUTES + 20 * SECONDS)
                .eut(7680).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(MagicBees.ID, "wax", 3, 0, missing), ItemList.Shape_Extruder_Cell.get(0L))
                .itemOutputs(getModItem(MagicBees.ID, "capsule.magic", 1, 0, missing)).duration(5 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(MagicBees.ID, "wax", 3, 2, missing), ItemList.Shape_Extruder_Cell.get(0L))
                .itemOutputs(getModItem(MagicBees.ID, "capsule.magic", 1, 0, missing)).duration(5 * SECONDS).eut(30)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "sand", 2, wildcard, missing),
                        getModItem(MagicBees.ID, "miscResources", 1, 2, missing))
                .itemOutputs(getModItem(Forestry.ID, "fertilizerCompound", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 100)).duration(5 * SECONDS).eut(16)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 8L),
                        getModItem(MagicBees.ID, "miscResources", 1, 2, missing))
                .itemOutputs(getModItem(Forestry.ID, "fertilizerCompound", 12, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 100)).duration(5 * SECONDS).eut(16)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "sand", 2, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L))
                .itemOutputs(getModItem(Forestry.ID, "fertilizerCompound", 5, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 100)).duration(5 * SECONDS).eut(16)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 8L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L))
                .itemOutputs(getModItem(Forestry.ID, "fertilizerCompound", 10, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 100)).duration(5 * SECONDS).eut(16)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemFertilizer", 8, 0, missing),
                        getModItem(MagicBees.ID, "miscResources", 1, 2, missing))
                .itemOutputs(getModItem(Forestry.ID, "fertilizerCompound", 32, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).duration(5 * SECONDS).eut(16)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemFertilizer", 8, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L))
                .itemOutputs(getModItem(Forestry.ID, "fertilizerCompound", 30, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).duration(5 * SECONDS).eut(16)
                .addTo(mixerRecipes);

        TCHelper.removeInfusionRecipe(getModItem(MagicBees.ID, "miscResources", 3, 17, missing));
        TCHelper.removeInfusionRecipe(getModItem(MagicBees.ID, "miscResources", 3, 17, missing));
        TCHelper.removeInfusionRecipe(getModItem(MagicBees.ID, "apimancersDrainer", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(MagicBees.ID, "miscResources", 1, 7, missing));
        TCHelper.removeCrucibleRecipe(getModItem(MagicBees.ID, "miscResources", 1, 8, missing));
        TCHelper.removeCrucibleRecipe(getModItem(MagicBees.ID, "miscResources", 1, 9, missing));
        TCHelper.removeCrucibleRecipe(getModItem(MagicBees.ID, "miscResources", 1, 10, missing));
        TCHelper.removeArcaneRecipe(getModItem(MagicBees.ID, "miscResources", 1, 11, missing));
        TCHelper.removeCrucibleRecipe(getModItem(MagicBees.ID, "miscResources", 1, 12, missing));
        TCHelper.removeCrucibleRecipe(getModItem(MagicBees.ID, "miscResources", 1, 12, missing));
        TCHelper.removeArcaneRecipe(getModItem(MagicBees.ID, "frameMagic", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(MagicBees.ID, "visAuraProvider", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(MagicBees.ID, "item.thaumiumScoop", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(MagicBees.ID, "item.voidScoop", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(MagicBees.ID, "item.thaumiumGrafter", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(MagicBees.ID, "item.voidGrafter", 1, 0, missing));
        new ResearchItem(
                "MAGICAPIARY",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("sano"), 12)
                        .add(Aspect.getAspect("ignis"), 9).add(Aspect.getAspect("lucrum"), 6),
                1,
                7,
                3,
                getModItem(MagicBees.ID, "magicApiary", 1, 0, missing)).setParents("MB_DimensionalSingularity")
                        .setConcealed().setRound().setPages(new ResearchPage("MagicBees.research_page.MAGICAPIARY"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "MAGICAPIARY",
                getModItem(MagicBees.ID, "magicApiary", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("praecantatio"), 75).add(Aspect.getAspect("sano"), 75)
                        .add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("lucrum"), 50)
                        .add(Aspect.getAspect("exanimis"), 25).add(Aspect.getAspect("herba"), 20),
                getModItem(Forestry.ID, "apiculture", 1, 0, missing),
                getModItem(MagicBees.ID, "wax", 1, 0, missing),
                getModItem(MagicBees.ID, "wax", 1, 1, missing),
                getModItem(MagicBees.ID, "wax", 1, 2, missing),
                getModItem(MagicBees.ID, "pollen", 1, 0, missing),
                getModItem(MagicBees.ID, "pollen", 1, 1, missing));
        TCHelper.addResearchPage(
                "MAGICAPIARY",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(MagicBees.ID, "magicApiary", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("MAGICAPIARY", 2);
        TCHelper.moveResearch("MB_VisAuraProvider", "MAGICBEES", -3, 7);
        ResearchCategories.getResearch("MB_VisAuraProvider").setRound();
        TCHelper.addResearchPrereq("MB_VisAuraProvider", "MB_DimensionalSingularity", false);
        TCHelper.setResearchAspects(
                "MB_VisAuraProvider",
                new AspectList().add(Aspect.getAspect("lucrum"), 15).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("vitreus"), 12).add(Aspect.getAspect("ordo"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("machina"), 3));
        TCHelper.setResearchComplexity("MB_VisAuraProvider", 4);
        ResearchCategories.getResearch("MB_VisAuraProvider").setConcealed();
        ThaumcraftApi.addWarpToResearch("MB_VisAuraProvider", 2);
        TCHelper.clearPages("MB_VisAuraProvider");
        TCHelper.addResearchPage("MB_VisAuraProvider", new ResearchPage("tc.research_page.MB_VisAuraProvider.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MB_VisAuraProvider",
                getModItem(MagicBees.ID, "visAuraProvider", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(MagicBees.ID, "pollen", 1, 1, missing),
                'b',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 5, missing),
                'c',
                getModItem(MagicBees.ID, "pollen", 1, 0, missing),
                'd',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 5, missing),
                'e',
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 2, missing),
                'f',
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 5, missing),
                'g',
                GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Gold, 1L),
                'h',
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Gold, 1L),
                'i',
                GTOreDictUnificator.get(OrePrefixes.springSmall, Materials.Gold, 1L));
        TCHelper.addResearchPage(
                "MB_VisAuraProvider",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(MagicBees.ID, "visAuraProvider", 1, 0, missing))));
        new ResearchItem(
                "CONCENTRATEDCOMPOUND",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("messis"), 15).add(Aspect.getAspect("sano"), 12)
                        .add(Aspect.getAspect("vitreus"), 9).add(Aspect.getAspect("perditio"), 6),
                2,
                -3,
                3,
                getModItem(MagicBees.ID, "miscResources", 1, 2, missing)).setParents("MB_Root", "MB_EssenceLife")
                        .setConcealed().setPages(new ResearchPage("MagicBees.research_page.CONCENTRATEDCOMPOUND"))
                        .registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "CONCENTRATEDCOMPOUND",
                getModItem(MagicBees.ID, "miscResources", 1, 2, missing),
                GTOreDictUnificator.get(OrePrefixes.gem, Materials.Apatite, 1L),
                new AspectList().add(Aspect.getAspect("messis"), 6).add(Aspect.getAspect("vitreus"), 3));
        TCHelper.addResearchPage(
                "CONCENTRATEDCOMPOUND",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(MagicBees.ID, "miscResources", 1, 2, missing))));
        TCHelper.clearPages("MB_EssenceLife");
        TCHelper.addResearchPage("MB_EssenceLife", new ResearchPage("tc.research_page.MB_EssenceLife.1"));
        ThaumcraftApi.addCrucibleRecipe(
                "MB_EssenceLife",
                getModItem(MagicBees.ID, "miscResources", 1, 7, missing),
                getModItem(Minecraft.ID, "red_flower", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 16).add(Aspect.getAspect("permutatio"), 16)
                        .add(Aspect.getAspect("herba"), 16).add(Aspect.getAspect("terra"), 16));
        TCHelper.addResearchPage(
                "MB_EssenceLife",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(MagicBees.ID, "miscResources", 1, 7, missing))));
        TCHelper.setResearchAspects(
                "MB_EssenceLife",
                new AspectList().add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("herba"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("MB_EssenceLife", 3);
        TCHelper.clearPages("MB_EssenceDeath");
        TCHelper.addResearchPage("MB_EssenceDeath", new ResearchPage("tc.research_page.MB_EssenceDeath.1"));
        ThaumcraftApi.addCrucibleRecipe(
                "MB_EssenceDeath",
                getModItem(MagicBees.ID, "miscResources", 1, 8, missing),
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("mortuus"), 16).add(Aspect.getAspect("perditio"), 16)
                        .add(Aspect.getAspect("spiritus"), 16).add(Aspect.getAspect("exanimis"), 16));
        TCHelper.addResearchPage(
                "MB_EssenceDeath",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(MagicBees.ID, "miscResources", 1, 8, missing))));
        TCHelper.setResearchAspects(
                "MB_EssenceDeath",
                new AspectList().add(Aspect.getAspect("mortuus"), 12).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("spiritus"), 6).add(Aspect.getAspect("exanimis"), 3));
        TCHelper.setResearchComplexity("MB_EssenceDeath", 3);
        TCHelper.clearPages("MB_EssenceTime");
        TCHelper.addResearchPage("MB_EssenceTime", new ResearchPage("tc.research_page.MB_EssenceTime.1"));
        ThaumcraftApi.addCrucibleRecipe(
                "MB_EssenceTime",
                getModItem(MagicBees.ID, "miscResources", 1, 9, missing),
                getModItem(Minecraft.ID, "clock", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("vacuos"), 16)
                        .add(Aspect.getAspect("vinculum"), 16).add(Aspect.getAspect("tempus"), 16));
        TCHelper.addResearchPage(
                "MB_EssenceTime",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(MagicBees.ID, "miscResources", 1, 9, missing))));
        TCHelper.setResearchAspects(
                "MB_EssenceTime",
                new AspectList().add(Aspect.getAspect("ordo"), 12).add(Aspect.getAspect("vacuos"), 9)
                        .add(Aspect.getAspect("vinculum"), 6).add(Aspect.getAspect("tempus"), 3));
        TCHelper.setResearchComplexity("MB_EssenceTime", 3);
        TCHelper.clearPages("MB_EssenceArmor");
        TCHelper.addResearchPage("MB_EssenceArmor", new ResearchPage("tc.research_page.MB_EssenceArmor.1"));
        ThaumcraftApi.addCrucibleRecipe(
                "MB_EssenceArmor",
                getModItem(MagicBees.ID, "miscResources", 1, 10, missing),
                getModItem(Minecraft.ID, "iron_chestplate", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("tutamen"), 16).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("metallum"), 16).add(Aspect.getAspect("fabrico"), 16));
        TCHelper.addResearchPage(
                "MB_EssenceArmor",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(MagicBees.ID, "miscResources", 1, 10, missing))));
        TCHelper.setResearchAspects(
                "MB_EssenceArmor",
                new AspectList().add(Aspect.getAspect("tutamen"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("fabrico"), 3));
        TCHelper.setResearchComplexity("MB_EssenceArmor", 3);
        TCHelper.clearPages("MB_EssenceUnstable");
        TCHelper.addResearchPage("MB_EssenceUnstable", new ResearchPage("tc.research_page.MB_EssenceUnstable.1"));
        ThaumcraftApi.addCrucibleRecipe(
                "MB_EssenceUnstable",
                getModItem(MagicBees.ID, "miscResources", 1, 12, missing),
                getModItem(MagicBees.ID, "propolis", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("permutatio"), 16)
                        .add(Aspect.getAspect("limus"), 16).add(Aspect.getAspect("potentia"), 16));
        TCHelper.addResearchPage(
                "MB_EssenceUnstable",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(MagicBees.ID, "miscResources", 1, 12, missing))));
        TCHelper.setResearchAspects(
                "MB_EssenceUnstable",
                new AspectList().add(Aspect.getAspect("perditio"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("limus"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("MB_EssenceUnstable", 3);
        TCHelper.clearPages("MB_DimensionalSingularity");
        TCHelper.addResearchPrereq("MB_DimensionalSingularity", "INFUSION", false);
        ResearchCategories.getResearch("MB_DimensionalSingularity").setConcealed();
        TCHelper.addResearchPage(
                "MB_DimensionalSingularity",
                new ResearchPage("tc.research_page.MB_DimensionalSingularity.1"));
        TCHelper.addInfusionCraftingRecipe(
                "MB_DimensionalSingularity",
                getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                6,
                new AspectList().add(Aspect.getAspect("praecantatio"), 24).add(Aspect.getAspect("permutatio"), 24)
                        .add(Aspect.getAspect("alienis"), 16).add(Aspect.getAspect("tenebrae"), 16),
                getModItem(Minecraft.ID, "gold_block", 1, 0, missing),
                getModItem(MagicBees.ID, "propolis", 1, 0, missing),
                getModItem(Minecraft.ID, "ender_eye", 1, 0, missing),
                getModItem(MagicBees.ID, "propolis", 1, 0, missing),
                getModItem(Minecraft.ID, "ender_eye", 1, 0, missing),
                getModItem(MagicBees.ID, "propolis", 1, 0, missing),
                getModItem(Minecraft.ID, "ender_eye", 1, 0, missing));
        TCHelper.addResearchPage(
                "MB_DimensionalSingularity",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(MagicBees.ID, "miscResources", 1, 17, missing))));
        TCHelper.setResearchAspects(
                "MB_DimensionalSingularity",
                new AspectList().add(Aspect.getAspect("perditio"), 15).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("limus"), 9).add(Aspect.getAspect("potentia"), 6));
        TCHelper.setResearchComplexity("MB_DimensionalSingularity", 3);
        TCHelper.moveResearch("MB_EssenceOblivion", "MAGICBEES", -7, 4);
        TCHelper.clearPages("MB_EssenceOblivion");
        TCHelper.addResearchPage("MB_EssenceOblivion", new ResearchPage("tc.research_page.MB_EssenceOblivion.1"));
        TCHelper.addInfusionCraftingRecipe(
                "MB_EssenceOblivion",
                getModItem(MagicBees.ID, "miscResources", 1, 11, missing),
                8,
                new AspectList().add(Aspect.getAspect("alienis"), 100).add(Aspect.getAspect("praecantatio"), 100)
                        .add(Aspect.getAspect("lucrum"), 75).add(Aspect.getAspect("bestia"), 75),
                getModItem(Minecraft.ID, "dragon_egg", 1, 0, missing),
                getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                getModItem(MagicBees.ID, "miscResources", 1, 17, missing),
                getModItem(MagicBees.ID, "miscResources", 1, 17, missing));
        TCHelper.addResearchPage(
                "MB_EssenceOblivion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(MagicBees.ID, "miscResources", 1, 11, missing))));
        TCHelper.setResearchAspects(
                "MB_EssenceOblivion",
                new AspectList().add(Aspect.getAspect("alienis"), 5).add(Aspect.getAspect("praecantatio"), 5)
                        .add(Aspect.getAspect("lucrum"), 5).add(Aspect.getAspect("bestia"), 5));
        TCHelper.setResearchComplexity("MB_EssenceOblivion", 3);
        TCHelper.moveResearch("MB_FrameMagic", "MAGICBEES", -4, 0);
        TCHelper.addResearchPrereq("MB_FrameMagic", "MB_Root", false);
        ResearchCategories.getResearch("MB_FrameMagic").setConcealed();
        TCHelper.clearPages("MB_FrameMagic");
        TCHelper.addResearchPage("MB_FrameMagic", new ResearchPage("tc.research_page.MB_FrameMagic.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MB_FrameMagic",
                getModItem(MagicBees.ID, "frameMagic", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 8).add(Aspect.getAspect("terra"), 8)
                        .add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("perditio"), 8)
                        .add(Aspect.getAspect("ignis"), 8).add(Aspect.getAspect("aqua"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "screwSteel",
                'b',
                getModItem(MagicBees.ID, "wax", 1, 1, missing),
                'c',
                "screwSteel",
                'd',
                getModItem(MagicBees.ID, "wax", 1, 0, missing),
                'e',
                getModItem(Forestry.ID, "frameImpregnated", 1, 0, missing),
                'f',
                getModItem(MagicBees.ID, "wax", 1, 2, missing),
                'g',
                "screwSteel",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                'i',
                "screwSteel");
        TCHelper.addResearchPage(
                "MB_FrameMagic",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(MagicBees.ID, "frameMagic", 1, 0, missing))));
        TCHelper.setResearchAspects(
                "MB_FrameMagic",
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("perditio"), 6));
        TCHelper.setResearchComplexity("MB_FrameMagic", 4);
        new ResearchItem(
                "GENTLEFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("victus"), 15).add(Aspect.getAspect("instrumentum"), 15)
                        .add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("ignis"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("aqua"), 3),
                -7,
                2,
                3,
                getModItem(MagicBees.ID, "frameGentle", 1, 0, missing)).setParents("MB_FrameMagic", "MB_EssenceLife")
                        .setConcealed().setPages(new ResearchPage("MagicBees.research_page.GENTLEFRAME"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GENTLEFRAME",
                getModItem(MagicBees.ID, "frameGentle", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("perditio"), 16)
                        .add(Aspect.getAspect("ignis"), 16).add(Aspect.getAspect("aqua"), 16),
                "abc",
                "def",
                "ghi",
                'a',
                "screwAluminium",
                'b',
                getModItem(MagicBees.ID, "miscResources", 1, 7, missing),
                'c',
                "screwAluminium",
                'd',
                getModItem(MagicBees.ID, "miscResources", 1, 18, missing),
                'e',
                getModItem(MagicBees.ID, "frameMagic", 1, 0, missing),
                'f',
                getModItem(MagicBees.ID, "miscResources", 1, 18, missing),
                'g',
                "screwAluminium",
                'h',
                getModItem(MagicBees.ID, "miscResources", 1, 18, missing),
                'i',
                "screwAluminium");
        TCHelper.addResearchPage(
                "GENTLEFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(MagicBees.ID, "frameGentle", 1, 0, missing))));
        new ResearchItem(
                "RESILIENTFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("pannus"), 15)
                        .add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("ignis"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("aqua"), 3),
                -7,
                1,
                3,
                getModItem(MagicBees.ID, "frameResilient", 1, 0, missing))
                        .setParents("MB_FrameMagic", "MB_EssenceArmor").setConcealed()
                        .setPages(new ResearchPage("MagicBees.research_page.RESILIENTFRAME")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RESILIENTFRAME",
                getModItem(MagicBees.ID, "frameResilient", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("perditio"), 16)
                        .add(Aspect.getAspect("ignis"), 16).add(Aspect.getAspect("aqua"), 16),
                "abc",
                "def",
                "ghi",
                'a',
                "screwAluminium",
                'b',
                getModItem(MagicBees.ID, "miscResources", 1, 10, missing),
                'c',
                "screwAluminium",
                'd',
                getModItem(MagicBees.ID, "miscResources", 1, 22, missing),
                'e',
                getModItem(MagicBees.ID, "frameMagic", 1, 0, missing),
                'f',
                getModItem(MagicBees.ID, "miscResources", 1, 22, missing),
                'g',
                "screwAluminium",
                'h',
                getModItem(MagicBees.ID, "miscResources", 1, 22, missing),
                'i',
                "screwAluminium");
        TCHelper.addResearchPage(
                "RESILIENTFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(MagicBees.ID, "frameResilient", 1, 0, missing))));
        new ResearchItem(
                "NECROTICFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("mortuus"), 15).add(Aspect.getAspect("fabrico"), 15)
                        .add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("ignis"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("aqua"), 3),
                -7,
                0,
                3,
                getModItem(MagicBees.ID, "frameNecrotic", 1, 0, missing)).setParents("MB_FrameMagic", "MB_EssenceDeath")
                        .setConcealed().setPages(new ResearchPage("MagicBees.research_page.NECROTICFRAME"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "NECROTICFRAME",
                getModItem(MagicBees.ID, "frameNecrotic", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("perditio"), 16)
                        .add(Aspect.getAspect("ignis"), 16).add(Aspect.getAspect("aqua"), 16),
                "abc",
                "def",
                "ghi",
                'a',
                "screwAluminium",
                'b',
                getModItem(MagicBees.ID, "miscResources", 1, 8, missing),
                'c',
                "screwAluminium",
                'd',
                getModItem(MagicBees.ID, "miscResources", 1, 23, missing),
                'e',
                getModItem(MagicBees.ID, "frameMagic", 1, 0, missing),
                'f',
                getModItem(MagicBees.ID, "miscResources", 1, 23, missing),
                'g',
                "screwAluminium",
                'h',
                getModItem(MagicBees.ID, "miscResources", 1, 23, missing),
                'i',
                "screwAluminium");
        TCHelper.addResearchPage(
                "NECROTICFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(MagicBees.ID, "frameNecrotic", 1, 0, missing))));
        new ResearchItem(
                "METABOLICFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("limus"), 15).add(Aspect.getAspect("potentia"), 15)
                        .add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("ignis"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("aqua"), 3),
                -7,
                -1,
                3,
                getModItem(MagicBees.ID, "frameMetabolic", 1, 0, missing))
                        .setParents("MB_FrameMagic", "MB_EssenceUnstable").setConcealed()
                        .setPages(new ResearchPage("MagicBees.research_page.METABOLICFRAME")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "METABOLICFRAME",
                getModItem(MagicBees.ID, "frameMetabolic", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("perditio"), 16)
                        .add(Aspect.getAspect("ignis"), 16).add(Aspect.getAspect("aqua"), 16),
                "abc",
                "def",
                "ghi",
                'a',
                "screwAluminium",
                'b',
                getModItem(MagicBees.ID, "miscResources", 1, 12, missing),
                'c',
                "screwAluminium",
                'd',
                getModItem(MagicBees.ID, "miscResources", 1, 20, missing),
                'e',
                getModItem(MagicBees.ID, "frameMagic", 1, 0, missing),
                'f',
                getModItem(MagicBees.ID, "miscResources", 1, 20, missing),
                'g',
                "screwAluminium",
                'h',
                getModItem(MagicBees.ID, "miscResources", 1, 20, missing),
                'i',
                "screwAluminium");
        TCHelper.addResearchPage(
                "METABOLICFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(MagicBees.ID, "frameMetabolic", 1, 0, missing))));
        new ResearchItem(
                "TEMPORALFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("tempus"), 15).add(Aspect.getAspect("vacuos"), 15)
                        .add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("ignis"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("aqua"), 3),
                -7,
                -2,
                3,
                getModItem(MagicBees.ID, "frameTemporal", 1, 0, missing)).setParents("MB_FrameMagic", "MB_EssenceTime")
                        .setConcealed().setPages(new ResearchPage("MagicBees.research_page.TEMPORALFRAME"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TEMPORALFRAME",
                getModItem(MagicBees.ID, "frameTemporal", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("perditio"), 16)
                        .add(Aspect.getAspect("ignis"), 16).add(Aspect.getAspect("aqua"), 16),
                "abc",
                "def",
                "ghi",
                'a',
                "screwAluminium",
                'b',
                getModItem(MagicBees.ID, "miscResources", 1, 9, missing),
                'c',
                "screwAluminium",
                'd',
                getModItem(MagicBees.ID, "miscResources", 1, 21, missing),
                'e',
                getModItem(MagicBees.ID, "frameMagic", 1, 0, missing),
                'f',
                getModItem(MagicBees.ID, "miscResources", 1, 21, missing),
                'g',
                "screwAluminium",
                'h',
                getModItem(MagicBees.ID, "miscResources", 1, 22, missing),
                'i',
                "screwAluminium");
        TCHelper.addResearchPage(
                "TEMPORALFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(MagicBees.ID, "frameTemporal", 1, 0, missing))));
        new ResearchItem(
                "OBLIVIONFRAME",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("pannus"), 15)
                        .add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("ignis"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("aqua"), 3),
                -10,
                0,
                3,
                getModItem(MagicBees.ID, "frameOblivion", 1, 0, missing))
                        .setParents(
                                "INFUSION",
                                "GENTLEFRAME",
                                "RESILIENTFRAME",
                                "NECROTICFRAME",
                                "METABOLICFRAME",
                                "TEMPORALFRAME",
                                "MB_EssenceOblivion")
                        .setConcealed().setPages(new ResearchPage("MagicBees.research_page.OBLIVIONFRAME"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "OBLIVIONFRAME",
                getModItem(MagicBees.ID, "frameOblivion", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("terra"), 32)
                        .add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("perditio"), 32),
                "abc",
                "def",
                "ghi",
                'a',
                "screwStainlessSteel",
                'b',
                getModItem(MagicBees.ID, "miscResources", 1, 11, missing),
                'c',
                "screwStainlessSteel",
                'd',
                getModItem(MagicBees.ID, "miscResources", 1, 19, missing),
                'e',
                getModItem(MagicBees.ID, "frameMagic", 1, 0, missing),
                'f',
                getModItem(MagicBees.ID, "miscResources", 1, 19, missing),
                'g',
                "screwStainlessSteel",
                'h',
                getModItem(MagicBees.ID, "miscResources", 1, 19, missing),
                'i',
                "screwStainlessSteel");
        TCHelper.addResearchPage(
                "OBLIVIONFRAME",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(MagicBees.ID, "frameOblivion", 1, 0, missing))));
        TCHelper.clearPages("MB_Scoop");
        TCHelper.addResearchPage("MB_Scoop", new ResearchPage("tc.research_page.MB_Scoop.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MB_Scoop",
                getModItem(MagicBees.ID, "item.thaumiumScoop", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("aer"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Thaumium, 1L),
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                'c',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Thaumium, 1L),
                'd',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Thaumium, 1L),
                'e',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Thaumium, 1L),
                'f',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Thaumium, 1L),
                'g',
                "craftingToolWireCutter",
                'h',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Thaumium, 1L),
                'i',
                "craftingToolHardHammer");
        TCHelper.addResearchPage(
                "MB_Scoop",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(MagicBees.ID, "item.thaumiumScoop", 1, 0, missing))));
        TCHelper.setResearchAspects(
                "MB_Scoop",
                new AspectList().add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("aer"), 3));
        TCHelper.setResearchComplexity("MB_Scoop", 3);
        TCHelper.clearPages("MB_ScoopVoid");
        TCHelper.addResearchPage("MB_ScoopVoid", new ResearchPage("tc.research_page.MB_ScoopVoid.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MB_ScoopVoid",
                getModItem(MagicBees.ID, "item.voidScoop", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("aer"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Void, 1L),
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                'c',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Void, 1L),
                'd',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Void, 1L),
                'e',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Void, 1L),
                'f',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Void, 1L),
                'g',
                "craftingToolWireCutter",
                'h',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Void, 1L),
                'i',
                "craftingToolHardHammer");
        TCHelper.addResearchPage(
                "MB_ScoopVoid",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(MagicBees.ID, "item.voidScoop", 1, 0, missing))));
        TCHelper.setResearchAspects(
                "MB_ScoopVoid",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("ordo"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("aer"), 3));
        TCHelper.setResearchComplexity("MB_ScoopVoid", 3);
        ThaumcraftApi.addWarpToResearch("MB_ScoopVoid", 3);
        TCHelper.clearPages("MB_Grafter");
        TCHelper.addResearchPage("MB_Grafter", new ResearchPage("tc.research_page.MB_Grafter.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MB_Grafter",
                getModItem(MagicBees.ID, "item.thaumiumGrafter", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'b',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Thaumium, 1L),
                'd',
                "craftingToolFile",
                'e',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Thaumium, 1L),
                'g',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 2, missing),
                'i',
                "craftingToolHardHammer");
        TCHelper.addResearchPage(
                "MB_Grafter",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(MagicBees.ID, "item.thaumiumGrafter", 1, 0, missing))));
        TCHelper.setResearchAspects(
                "MB_Grafter",
                new AspectList().add(Aspect.getAspect("ordo"), 12).add(Aspect.getAspect("terra"), 9)
                        .add(Aspect.getAspect("aer"), 6));
        TCHelper.setResearchComplexity("MB_Grafter", 3);
        TCHelper.clearPages("MB_GrafterVoid");
        TCHelper.addResearchPage("MB_GrafterVoid", new ResearchPage("tc.research_page.MB_GrafterVoid.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MB_GrafterVoid",
                getModItem(MagicBees.ID, "item.voidGrafter", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("aer"), 30),
                "abc",
                "def",
                "ghi",
                'b',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Void, 1L),
                'd',
                "craftingToolFile",
                'e',
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Void, 1L),
                'g',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 16, missing),
                'i',
                "craftingToolHardHammer");
        TCHelper.addResearchPage(
                "MB_GrafterVoid",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(MagicBees.ID, "item.voidGrafter", 1, 0, missing))));
        TCHelper.setResearchAspects(
                "MB_GrafterVoid",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("aer"), 6));
        TCHelper.setResearchComplexity("MB_GrafterVoid", 3);
        ThaumcraftApi.addWarpToResearch("MB_GrafterVoid", 3);
        new ResearchItem(
                "ENCHANTEDEARTH",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("victus"), 9)
                        .add(Aspect.getAspect("sano"), 6).add(Aspect.getAspect("ordo"), 3),
                5,
                -3,
                2,
                getModItem(MagicBees.ID, "magicbees.enchantedEarth", 1, 0, missing)).setParents("MB_EssenceLife")
                        .setConcealed().setPages(new ResearchPage("MagicBees.research_page.ENCHANTEDEARTH"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENCHANTEDEARTH",
                getModItem(MagicBees.ID, "magicbees.enchantedEarth", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("aqua"), 10)
                        .add(Aspect.getAspect("terra"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                'c',
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                'e',
                getModItem(MagicBees.ID, "miscResources", 1, 7, missing),
                'g',
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                'i',
                getModItem(Minecraft.ID, "dirt", 1, 0, missing));
        TCHelper.addResearchPage(
                "ENCHANTEDEARTH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(MagicBees.ID, "magicbees.enchantedEarth", 1, 0, missing))));
        TCHelper.moveResearch("MB_ApimancersDrainer", "MAGICBEES", -1, 7);
        TCHelper.addResearchPrereq("MB_ApimancersDrainer", "MB_DimensionalSingularity", false);
        TCHelper.setResearchComplexity("MB_ApimancersDrainer", 5);
        ResearchCategories.getResearch("MB_ApimancersDrainer").setConcealed();
        ThaumcraftApi.addWarpToResearch("MB_ApimancersDrainer", 3);
        TCHelper.addInfusionCraftingRecipe(
                "MB_ApimancersDrainer",
                getModItem(MagicBees.ID, "apimancersDrainer", 1, 0, missing),
                5,
                new AspectList().add(Aspect.MAGIC, 100).add(Aspect.HARVEST, 75).add(Aspect.getAspect("tempus"), 50),
                getModItem(Thaumcraft.ID, "blockEssentiaReservoir", 1, 0, missing),
                getModItem(Thaumcraft.ID, "blockTube", 1, 2, missing),
                getModItem(MagicBees.ID, "pollen", 1, 0, missing),
                new ItemStack(Loaders.essentiaCell, 1, 0),
                new ItemStack(Loaders.essentiaCell, 1, 0),
                new ItemStack(Loaders.essentiaCell, 1, 0),
                new ItemStack(Loaders.essentiaCell, 1, 0),
                getModItem(MagicBees.ID, "pollen", 1, 1, missing));
        TCHelper.refreshResearchPages("MB_VisAuraProvider");
        TCHelper.refreshResearchPages("MB_EssenceLife");
        TCHelper.refreshResearchPages("MB_EssenceDeath");
        TCHelper.refreshResearchPages("MB_EssenceTime");
        TCHelper.refreshResearchPages("MB_EssenceArmor");
        TCHelper.refreshResearchPages("MB_EssenceUnstable");
        TCHelper.refreshResearchPages("MB_DimensionalSingularity");
        TCHelper.refreshResearchPages("MB_Scoop");
        TCHelper.refreshResearchPages("MB_ScoopVoid");
        TCHelper.refreshResearchPages("MB_GrafterVoid");
        TCHelper.refreshResearchPages("MB_ApimancersDrainer");
    }
}
