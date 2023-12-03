package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Botany;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.Genetics;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.forestry.ForestryHelper;
import com.dreammaster.gthandler.CustomItemList;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

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
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.EnderEye, 1L),
                'b',
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                'c',
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.EnderEye, 1L),
                'd',
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                'e',
                "circuitData",
                'f',
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                'g',
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.EnderEye, 1L),
                'h',
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                'i',
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.EnderEye, 1L));
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
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
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

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.AluminiumItemCasing", 8, 0, missing))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 0, missing)).duration(1 * MINUTES).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 8L))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 0, missing)).duration(1 * MINUTES).eut(120)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "glass_pane", 6, 0, missing), GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 8, missing)).duration(10 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "glass_pane", 2, 0, missing), GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 288)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "glass_pane", 4, 0, missing), GT_Utility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 144)).duration(10 * SECONDS).eut(48)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Genetics.ID, "misc", 10, 6, missing), GT_Utility.getIntegratedCircuit(10))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 576)).duration(10 * SECONDS).eut(96)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "chipsets", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 2, 0, missing))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 64)).duration(20 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Forestry.ID, "chipsets", 1, 1, missing), ItemList.Circuit_Nanoprocessor.get(2L))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 64)).duration(20 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Forestry.ID, "chipsets", 1, 1, missing), ItemList.Circuit_Computer.get(2L))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 64)).duration(20 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "hardenedMachine", 1, 0, missing),
                        getModItem(Genetics.ID, "misc", 2, 10, missing),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 11, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 288)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(480).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 5, missing),
                        GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 144)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                        ItemList.Color_04.get(1L),
                        ItemList.Color_05.get(1L))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.blaze", 144)).duration(5 * SECONDS).eut(30)
                .addTo(mixerRecipes);
        GT_Values.RA.stdBuilder()
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
