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
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.forestry.ForestryHelper;
import com.dreammaster.item.NHItemList;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;

public class ScriptGenetics implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Genetics";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Botany.ID,
                BuildCraftFactory.ID,
                ExtraBees.ID,
                ExtraTrees.ID,
                Forestry.ID,
                Genetics.ID,
                IndustrialCraft2.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessRecipe(
                getModItem(Genetics.ID, "database", 1, 0),
                getModItem(Genetics.ID, "database", 1, 0));
        addShapedRecipe(
                getModItem(Genetics.ID, "misc", 1, 9),
                "screwStainlessSteel",
                "craftingToolScrewdriver",
                "screwStainlessSteel",
                "circuitAdvanced",
                getModItem(Forestry.ID, "chipsets", 1, 1),
                "circuitAdvanced",
                "screwStainlessSteel",
                "craftingToolWrench",
                "screwStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "machine", 1, 0),
                getModItem(Genetics.ID, "misc", 1, 3),
                "chestIron",
                getModItem(Genetics.ID, "misc", 1, 3),
                getModItem(Genetics.ID, "misc", 1, 9),
                getModItem(Genetics.ID, "misc", 1, 0),
                getModItem(Genetics.ID, "misc", 1, 9),
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "machine", 1, 1),
                getModItem(Genetics.ID, "misc", 1, 2),
                "chestIron",
                getModItem(Genetics.ID, "misc", 1, 2),
                getModItem(Genetics.ID, "misc", 1, 9),
                getModItem(Genetics.ID, "misc", 1, 0),
                getModItem(Genetics.ID, "misc", 1, 9),
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "machine", 1, 2),
                getModItem(Genetics.ID, "misc", 1, 7),
                "chestIron",
                getModItem(Genetics.ID, "misc", 1, 7),
                getModItem(Genetics.ID, "misc", 1, 9),
                getModItem(Genetics.ID, "misc", 1, 0),
                getModItem(Genetics.ID, "misc", 1, 9),
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "machine", 1, 3),
                "plateEmerald",
                "chestIron",
                "plateEmerald",
                getModItem(Genetics.ID, "misc", 1, 9),
                getModItem(Genetics.ID, "misc", 1, 0),
                getModItem(Genetics.ID, "misc", 1, 9),
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "labMachine", 1, 1),
                getModItem(Genetics.ID, "misc", 1, 1),
                "chestIron",
                getModItem(Genetics.ID, "misc", 1, 1),
                getModItem(Genetics.ID, "misc", 1, 9),
                getModItem(Genetics.ID, "misc", 1, 0),
                getModItem(Genetics.ID, "misc", 1, 9),
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "labMachine", 1, 2),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                "craftingIronFurnace",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                getModItem(Genetics.ID, "misc", 1, 9),
                getModItem(Genetics.ID, "misc", 1, 0),
                getModItem(Genetics.ID, "misc", 1, 9),
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "labMachine", 1, 3),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                "chestIron",
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0),
                getModItem(Genetics.ID, "misc", 1, 9),
                getModItem(Genetics.ID, "misc", 1, 0),
                getModItem(Genetics.ID, "misc", 1, 9),
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "labMachine", 1, 4),
                "bucketWater",
                "bucketLava",
                "bucketWater",
                getModItem(Genetics.ID, "misc", 1, 9),
                getModItem(Genetics.ID, "misc", 1, 0),
                getModItem(Genetics.ID, "misc", 1, 9),
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "labMachine", 1, 0),
                "plateStainlessSteel",
                "paneGlass",
                "plateStainlessSteel",
                "paneGlass",
                getModItem(Genetics.ID, "misc", 1, 0),
                "paneGlass",
                "plateStainlessSteel",
                "paneGlass",
                "plateStainlessSteel");
        addShapedRecipe(
                getModItem(Genetics.ID, "advMachine", 1, 0),
                "plateKanthal",
                "chestDiamond",
                "plateKanthal",
                getModItem(Genetics.ID, "misc", 1, 10),
                getModItem(Genetics.ID, "misc", 1, 11),
                getModItem(Genetics.ID, "misc", 1, 10),
                "gearGtSmallDiamond",
                ItemList.Electric_Motor_HV.get(1L),
                "gearGtSmallDiamond");

        ForestryHelper.removeCarpenterRecipe(getModItem(Genetics.ID, "database", 1, 0));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 2880),
                NHItemList.Display.get(),
                getModItem(Genetics.ID, "database", 1, 0),
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
                NHItemList.Display.get(),
                getModItem(Genetics.ID, "analyst", 1, 0),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Genetics.ID, "misc", 1, 9),
                'b',
                getModItem(Forestry.ID, "treealyzer", 1, 0),
                'c',
                getModItem(Genetics.ID, "misc", 1, 9),
                'd',
                getModItem(Forestry.ID, "beealyzer", 1, 0),
                'e',
                getModItem(Genetics.ID, "misc", 1, 10),
                'f',
                getModItem(Forestry.ID, "flutterlyzer", 1, 0),
                'g',
                getModItem(Genetics.ID, "misc", 1, 9),
                'h',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                'i',
                getModItem(Genetics.ID, "misc", 1, 9));
        RecipeManagers.carpenterManager.addRecipe(
                60,
                FluidRegistry.getFluidStack("molten.redstone", 4320),
                NHItemList.Display.get(),
                getModItem(Genetics.ID, "registry", 1, 0),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Genetics.ID, "misc", 1, 9),
                'b',
                getModItem(ExtraTrees.ID, "database", 1, 0),
                'c',
                getModItem(Genetics.ID, "misc", 1, 9),
                'd',
                getModItem(Botany.ID, "database", 1, 0),
                'e',
                getModItem(Genetics.ID, "misc", 1, 10),
                'f',
                getModItem(ExtraBees.ID, "dictionary", 1, 0),
                'g',
                getModItem(Genetics.ID, "misc", 1, 9),
                'h',
                getModItem(ExtraTrees.ID, "databaseMoth", 1, 0),
                'i',
                getModItem(Genetics.ID, "misc", 1, 9));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Aluminium, 8))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 0)).duration(1 * MINUTES).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "glass_pane", 6, 0)).circuit(6)
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 8)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "glass_pane", 2, 0)).circuit(2)
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 5))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 288)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "glass_pane", 4, 0)).circuit(4)
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 6))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 144)).duration(10 * SECONDS).eut(48)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Genetics.ID, "misc", 10, 6)).circuit(10)
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 7))
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 576)).duration(10 * SECONDS).eut(96)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "chipsets", 1, 1),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 2))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 9))
                .fluidInputs(FluidRegistry.getFluidStack("molten.stainlesssteel", 64)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "hardenedMachine", 1, 0),
                        getModItem(Genetics.ID, "misc", 2, 10))
                .circuit(2).itemOutputs(getModItem(Genetics.ID, "misc", 1, 11))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 288)).duration(1 * MINUTES + 15 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        getModItem(Forestry.ID, "thermionicTubes", 1, 5))
                .circuit(2).itemOutputs(getModItem(Genetics.ID, "misc", 1, 10))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 144)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "redstone", 1, 0),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                        ItemList.Color_04.get(1L),
                        ItemList.Color_05.get(1L))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("molten.blaze", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "redstone", 1, 0),
                        getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                        ItemList.Color_14.get(1L),
                        ItemList.Color_11.get(1L))
                .itemOutputs(getModItem(Genetics.ID, "misc", 1, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.blaze", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(mixerRecipes);

    }
}
