package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Botany;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.Genetics;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.forestry.ForestryHelper;
import com.dreammaster.gthandler.CustomItemList;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

public class ScriptGenetics implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Genetics";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Mods.Genetics.ID,
                Botany.ID,
                BuildCraftFactory.ID,
                ExtraBees.ID,
                ExtraTrees.ID,
                Forestry.ID,
                IndustrialCraft2.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessRecipe(
                getModItem(Genetics.ID, "database", 1, 0, missing),
                getModItem(Genetics.ID, "database", 1, 0, missing));
        addShapedRecipe(
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                "screwStainlessSteel",
                "craftingToolScrewdriver",
                "screwStainlessSteel",
                "circuitAdvanced",
                getModItem(Forestry.ID, "chipsets", 1, 1, missing),
                "circuitAdvanced",
                "screwStainlessSteel",
                "craftingToolWrench",
                "screwStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "machine", 1, 0, missing),
                getModItem(Genetics.ID, "misc", 1, 3, missing),
                "chestIron",
                getModItem(Genetics.ID, "misc", 1, 3, missing),
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                getModItem(Genetics.ID, "misc", 1, 0, missing),
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "machine", 1, 1, missing),
                getModItem(Genetics.ID, "misc", 1, 2, missing),
                "chestIron",
                getModItem(Genetics.ID, "misc", 1, 2, missing),
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                getModItem(Genetics.ID, "misc", 1, 0, missing),
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "machine", 1, 2, missing),
                getModItem(Genetics.ID, "misc", 1, 7, missing),
                "chestIron",
                getModItem(Genetics.ID, "misc", 1, 7, missing),
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                getModItem(Genetics.ID, "misc", 1, 0, missing),
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "machine", 1, 3, missing),
                "plateEmerald",
                "chestIron",
                "plateEmerald",
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                getModItem(Genetics.ID, "misc", 1, 0, missing),
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "labMachine", 1, 1, missing),
                getModItem(Genetics.ID, "misc", 1, 1, missing),
                "chestIron",
                getModItem(Genetics.ID, "misc", 1, 1, missing),
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                getModItem(Genetics.ID, "misc", 1, 0, missing),
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "labMachine", 1, 2, missing),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                "craftingIronFurnace",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                getModItem(Genetics.ID, "misc", 1, 0, missing),
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "labMachine", 1, 3, missing),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                "chestIron",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                getModItem(Genetics.ID, "misc", 1, 0, missing),
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "labMachine", 1, 4, missing),
                "bucketWater",
                "bucketLava",
                "bucketWater",
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                getModItem(Genetics.ID, "misc", 1, 0, missing),
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "labMachine", 1, 0, missing),
                "plateStainlessSteel",
                "paneGlass",
                "plateStainlessSteel",
                "paneGlass",
                getModItem(Genetics.ID, "misc", 1, 0, missing),
                "paneGlass",
                "plateStainlessSteel",
                "paneGlass",
                "plateStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "advMachine", 1, 0, missing),
                "plateKanthal",
                "chestDiamond",
                "plateKanthal",
                getModItem(Genetics.ID, "misc", 1, 10, missing),
                getModItem(Genetics.ID, "misc", 1, 11, missing),
                getModItem(Genetics.ID, "misc", 1, 10, missing),
                "gearGtSmallDiamond",
                ItemList.Electric_Motor_HV.get(1L),
                "gearGtSmallDiamond");

        ForestryHelper.removeCarpenterRecipe(getModItem(Genetics.ID, "database", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 2880),
                CustomItemList.Display.get(1L),
                getModItem(Genetics.ID, "database", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.EnderEye, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                'c',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.EnderEye, 1L),
                'd',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                'e',
                "circuitData",
                'f',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                'g',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.EnderEye, 1L),
                'h',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                'i',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.EnderEye, 1L));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 4320),
                CustomItemList.Display.get(1L),
                getModItem(Genetics.ID, "analyst", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                'b',
                getModItem(Forestry.ID, "treealyzer", 1, 0, missing),
                'c',
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                'd',
                getModItem(Forestry.ID, "beealyzer", 1, 0, missing),
                'e',
                getModItem(Genetics.ID, "misc", 1, 10, missing),
                'f',
                getModItem(Forestry.ID, "flutterlyzer", 1, 0, missing),
                'g',
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                'h',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                'i',
                getModItem(Genetics.ID, "misc", 1, 9, missing));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 4320),
                CustomItemList.Display.get(1L),
                getModItem(Genetics.ID, "registry", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                'b',
                getModItem(ExtraTrees.ID, "database", 1, 0, missing),
                'c',
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                'd',
                getModItem(Botany.ID, "database", 1, 0, missing),
                'e',
                getModItem(Genetics.ID, "misc", 1, 10, missing),
                'f',
                getModItem(ExtraBees.ID, "dictionary", 1, 0, missing),
                'g',
                getModItem(Genetics.ID, "misc", 1, 9, missing),
                'h',
                getModItem(ExtraTrees.ID, "databaseMoth", 1, 0, missing),
                'i',
                getModItem(Genetics.ID, "misc", 1, 9, missing));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 8))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 0, missing)).duration(1 * MINUTES).eut(120)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "glass_pane", 6, 0, missing), GTUtility.getIntegratedCircuit(6))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 8, missing)).duration(10 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "glass_pane", 2, 0, missing), GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 288)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "glass_pane", 4, 0, missing), GTUtility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 144)).duration(10 * SECONDS).eut(48)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Genetics.ID, "misc", 10, 6, missing), GTUtility.getIntegratedCircuit(10))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 576)).duration(10 * SECONDS).eut(96)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "chipsets", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 2))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 64)).duration(20 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                        getModItem(Genetics.ID, "misc", 2, 10, missing),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 11, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 288)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 5, missing),
                        GTUtility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 144)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        ItemList.Color_04.get(1L),
                        ItemList.Color_05.get(1L))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.blaze", 144)).duration(5 * SECONDS).eut(30)
                .addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        ItemList.Color_14.get(1L),
                        ItemList.Color_11.get(1L))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.blaze", 144)).duration(5 * SECONDS).eut(30)
                .addTo(mixerRecipes);

    }
}
