package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.ProjectRedIllumination;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.RemoteIO;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.blastFurnaceRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeConstants.UniversalChemical;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

public class ScriptRandomThings implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Random Things";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                RandomThings.ID,
                TinkerConstruct.ID,
                ExtraUtilities.ID,
                TwilightForest.ID,
                Chisel.ID,
                EnderIO.ID,
                Forestry.ID,
                IndustrialCraft2.ID,
                ProjectRedIllumination.ID,
                ProjectRedIntegration.ID,
                RemoteIO.ID,
                Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(RandomThings.ID, "bloodMoonSensor", 1, 0, missing),
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 14, missing),
                null,
                getModItem(Minecraft.ID, "daylight_detector", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(RandomThings.ID, "lapisLamp", 1, 0, missing),
                getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0, missing),
                getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 27, missing),
                getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing),
                getModItem(Chisel.ID, "iron_bars", 1, 2, missing));
        addShapedRecipe(
                getModItem(RandomThings.ID, "moonSensor", 1, 0, missing),
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "daylight_detector", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(RandomThings.ID, "onlineDetector", 1, 0, missing),
                getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                ItemList.Sensor_MV.get(1L),
                getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 30, missing),
                getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                "circuitGood",
                getModItem(Chisel.ID, "iron_bars", 1, 2, missing));
        addShapedRecipe(
                getModItem(RandomThings.ID, "onlineDetector", 1, 0, missing),
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                ItemList.Sensor_MV.get(1L),
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 30, missing),
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "circuitGood",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing));
        addShapedRecipe(
                getModItem(RandomThings.ID, "imbuingStation", 1, 0, missing),
                getModItem(Minecraft.ID, "vine", 1, 0, missing),
                getModItem(Minecraft.ID, "brewing_stand", 1, 0, missing),
                getModItem(Minecraft.ID, "vine", 1, 0, missing),
                getModItem(Minecraft.ID, "tallgrass", 1, 1, missing),
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 5, missing),
                getModItem(Minecraft.ID, "tallgrass", 1, 1, missing),
                getModItem(Minecraft.ID, "waterlily", 1, 0, missing),
                "blockEmerald",
                getModItem(Minecraft.ID, "waterlily", 1, 0, missing));
        addShapedRecipe(
                getModItem(RandomThings.ID, "enderEnergyDistributor", 1, 0, missing),
                "plateEnderPearl",
                getModItem(RandomThings.ID, "ingredient", 1, 6, missing),
                "plateEnderPearl",
                getModItem(RandomThings.ID, "ingredient", 1, 6, missing),
                getModItem(RandomThings.ID, "energyDistributor", 1, 0, missing),
                getModItem(RandomThings.ID, "ingredient", 1, 6, missing),
                "plateEnderPearl",
                getModItem(EnderIO.ID, "blockWirelessCharger", 1, 0, missing),
                "plateEnderPearl");
        addShapedRecipe(
                getModItem(RandomThings.ID, "energyDistributor", 1, 0, missing),
                "blockRedstone",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 10, missing),
                "blockRedstone",
                getModItem(EnderIO.ID, "itemPowerConduit", 1, 0, missing),
                getModItem(RandomThings.ID, "ingredient", 1, 7, missing),
                getModItem(EnderIO.ID, "itemPowerConduit", 1, 0, missing),
                "plateBlackSteel",
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 10, missing),
                "plateBlackSteel");
        addShapedRecipe(
                getModItem(RandomThings.ID, "itemCollector", 1, 0, missing),
                null,
                "gemDiamond",
                null,
                ItemList.Robot_Arm_LV.get(1L),
                "stickObsidian",
                "blockHopper",
                null,
                "plateRedstone",
                null);
        addShapelessRecipe(
                getModItem(RandomThings.ID, "advancedItemCollector", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "enderCollector", 1, 0, missing));
        addShapedRecipe(
                getModItem(RandomThings.ID, "dyeingMachine", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                getModItem(Minecraft.ID, "crafting_table", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                ItemList.Hull_LV.get(1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L));
        addShapelessRecipe(
                getModItem(RandomThings.ID, "playerinterface", 1, 0, missing),
                getModItem(RemoteIO.ID, "tile.remote_interface", 1, 0, missing),
                getModItem(RandomThings.ID, "ingredient", 1, 0, missing));
        addShapelessRecipe(
                getModItem(RandomThings.ID, "voidStone", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "trashcan", 1, 0, missing),
                getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing),
                        getModItem(Minecraft.ID, "nether_wart", 1, 0, missing))
                .itemOutputs(getModItem(RandomThings.ID, "ingredient", 1, 5, missing))
                .duration(7 * SECONDS + 10 * TICKS).eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "emerald", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 4L))
                .itemOutputs(getModItem(RandomThings.ID, "ingredient", 1, 0, missing))
                .duration(12 * SECONDS + 10 * TICKS).eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "GlassPane", 16, 0, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(RandomThings.ID, "fluidDisplay", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 72)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(RandomThings.ID, "fluidDisplay", 1, 0, missing),
                        GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(RandomThings.ID, "advancedFluidDisplay", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Component_Filter.get(1L), getModItem(Minecraft.ID, "stone", 1, 0, missing))
                .itemOutputs(getModItem(RandomThings.ID, "filter", 1, 0, missing)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Component_Filter.get(1L), getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing))
                .itemOutputs(getModItem(RandomThings.ID, "filter", 1, 1, missing)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Component_Filter.get(1L), getModItem(Minecraft.ID, "porkchop", 1, 0, missing))
                .itemOutputs(getModItem(RandomThings.ID, "filter", 1, 2, missing)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Component_Filter.get(1L), getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing))
                .itemOutputs(getModItem(RandomThings.ID, "filter", 1, 3, missing)).duration(10 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "lever", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone_block", 1, 0, missing))
                .itemOutputs(getModItem(RandomThings.ID, "wirelessLever", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TwilightForest.ID, "item.charmOfKeeping3", 4, 0, missing),
                        GTUtility.getIntegratedCircuit(4))
                .itemOutputs(getModItem(RandomThings.ID, "whitestone", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 4000)).duration(1 * MINUTES).eut(480)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(ExtraUtilities.ID, "trashcan", 1, 0, missing), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(RandomThings.ID, "dropFilter", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 250)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(RandomThings.ID, "ingredient", 1, 4, missing),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Titanium, 1L))
                .itemOutputs(getModItem(RandomThings.ID, "spectreKey", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 1000)).duration(30 * SECONDS).eut(1024)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Iron, 1L),
                        getModItem(RandomThings.ID, "ingredient", 1, 3, missing))
                .itemOutputs(getModItem(RandomThings.ID, "ingredient", 1, 4, missing)).duration(1 * MINUTES).eut(480)
                .specialValue(2500).addTo(blastFurnaceRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "diamond", 1, 0, missing), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(RandomThings.ID, "ingredient", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).duration(1 * MINUTES).eut(30)
                .addTo(UniversalChemical);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                        getModItem(Minecraft.ID, "dye", 4, 15, missing))
                .itemOutputs(getModItem(RandomThings.ID, "fertilizedDirt", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).duration(5 * SECONDS).eut(30)
                .addTo(UniversalChemical);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                        getModItem(Forestry.ID, "fertilizerCompound", 2, 0, missing))
                .itemOutputs(getModItem(RandomThings.ID, "fertilizedDirt", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).duration(5 * SECONDS).eut(30)
                .addTo(UniversalChemical);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemFertilizer", 2, 0, missing))
                .itemOutputs(getModItem(RandomThings.ID, "fertilizedDirt", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).duration(5 * SECONDS).eut(30)
                .addTo(UniversalChemical);

    }
}
