package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Botany;
import static gregtech.api.enums.Mods.BuildCraftBuilders;
import static gregtech.api.enums.Mods.BuildCraftCompat;
import static gregtech.api.enums.Mods.BuildCraftCore;
import static gregtech.api.enums.Mods.BuildCraftFactory;
import static gregtech.api.enums.Mods.BuildCraftRobotics;
import static gregtech.api.enums.Mods.BuildCraftSilicon;
import static gregtech.api.enums.Mods.BuildCraftTransport;
import static gregtech.api.enums.Mods.ExtraBees;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.ForgeMicroblocks;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.ProjectRedCore;
import static gregtech.api.enums.Mods.ProjectRedExpansion;
import static gregtech.api.enums.Mods.ProjectRedTransportation;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.recipe.RecipeMaps.laserEngraverRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

public class ScriptBuildCraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Build Craft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Mods.BuildCraftCore.ID,
                BuildCraftBuilders.ID,
                BuildCraftCompat.ID,
                BuildCraftRobotics.ID,
                ProjectRedExpansion.ID,
                ProjectRedTransportation.ID,
                Botany.ID,
                BuildCraftFactory.ID,
                BuildCraftSilicon.ID,
                BuildCraftSilicon.ID,
                BuildCraftTransport.ID,
                ExtraBees.ID,
                ExtraUtilities.ID,
                Forestry.ID,
                ForgeMicroblocks.ID,
                IndustrialCraft2.ID,
                OpenBlocks.ID,
                ProjectRedCore.ID,
                Railcraft.ID,
                RandomThings.ID,
                TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessRecipe(getModItem(BuildCraftCore.ID, "diamondGearItem", 1, 0, missing), "gearGtDiamond");
        addShapelessRecipe(getModItem(BuildCraftCore.ID, "goldGearItem", 1, 0, missing), "gearGtGold");
        addShapelessRecipe(getModItem(BuildCraftCore.ID, "ironGearItem", 1, 0, missing), "gearGtIron");
        addShapelessRecipe(getModItem(BuildCraftCore.ID, "stoneGearItem", 1, 0, missing), "gearGtStone");
        addShapelessRecipe(getModItem(BuildCraftCore.ID, "woodenGearItem", 1, 0, missing), "gearGtWood");
        addShapedRecipe(
                getModItem(BuildCraftCore.ID, "engineBlock", 1, 2, missing),
                "plateInvar",
                "plateLapis",
                "plateInvar",
                "springInvar",
                getModItem(Minecraft.ID, "piston", 1, 0, missing),
                "springInvar",
                "gearInvar",
                getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing),
                "gearInvar");
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipestructurecobblestone", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 1),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 1),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 1),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 1));
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowercobblestone", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 1),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 1),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "wireGt01Tin",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 1),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.stick, Materials.Stone, 1));
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerstone", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "wireGt01Nickel",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing));
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerwood", 1, 0, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "wireGt01Copper",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickWood",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickWood");
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowersandstone", 1, 0, missing),
                CustomItemList.SandStoneRod.get(1L),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                CustomItemList.SandStoneRod.get(1L),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "wireGt01Cupronickel",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                CustomItemList.SandStoneRod.get(1L),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                CustomItemList.SandStoneRod.get(1L));
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerquartz", 1, 0, missing),
                "stickNetherQuartz",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickNetherQuartz",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "wireGt01Silver",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickNetherQuartz",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickNetherQuartz");
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepoweriron", 1, 0, missing),
                "stickIron",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickIron",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "wireGt01Electrum",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickIron",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickIron");
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowergold", 1, 0, missing),
                "stickGold",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickGold",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "wireGt01Aluminium",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickGold",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickGold");
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepoweremerald", 1, 0, missing),
                "stickEmerald",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickEmerald",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "wireGt01Nichrome",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickEmerald",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickEmerald");
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerdiamond", 1, 0, missing),
                "stickDiamond",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickDiamond",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "wireGt01Platinum",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickDiamond",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickDiamond");
        addShapedRecipe(
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                "screwIron",
                "ringIron",
                "screwIron",
                "craftingToolWrench",
                getModItem(Railcraft.ID, "glass", 1, 0, missing),
                "craftingToolScrewdriver",
                "screwIron",
                "ringIron",
                "screwIron");
        addShapedRecipe(
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                "screwIron",
                "ringIron",
                "screwIron",
                "craftingToolWrench",
                getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 5, missing),
                "craftingToolScrewdriver",
                "screwIron",
                "ringIron",
                "screwIron");
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsvoid", 1, 0, missing),
                getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "gemEnderPearl",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(RandomThings.ID, "ingredient", 1, 1, missing));
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipefluidsvoid", 1, 0, missing),
                "stickAnyRubber",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickAnyRubber",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "gemEnderPearl",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickAnyRubber",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stickAnyRubber");
        addShapedRecipe(
                getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                "itemCasingAnyIron",
                "gearGtSmallAnyIron",
                "itemCasingAnyIron",
                "gearGtSmallAnyIron",
                getModItem(Forestry.ID, "factory2", 1, 2, missing),
                "gearGtSmallAnyIron",
                "itemCasingAnyIron",
                ItemList.Electric_Motor_LV.get(1L),
                "itemCasingAnyIron");
        addShapelessRecipe(
                getModItem(BuildCraftCore.ID, "paintbrush", 1, 0, missing),
                getModItem(OpenBlocks.ID, "paintBrush", 1, 0, missing));
        addShapelessRecipe(
                getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 11, missing));
        addShapedRecipe(
                getModItem(BuildCraftBuilders.ID, "fillerBlock", 1, 0, missing),
                ItemList.Robot_Arm_MV.get(1L),
                "crystalRedstone",
                ItemList.Robot_Arm_MV.get(1L),
                "circuitGood",
                ItemList.Hull_MV.get(1L),
                "circuitGood",
                "gearGtSmallAluminium",
                ItemList.Electric_Motor_MV.get(1L),
                "gearGtSmallAluminium");
        addShapedRecipe(
                getModItem(BuildCraftBuilders.ID, "builderBlock", 1, 0, missing),
                ItemList.Robot_Arm_HV.get(1L),
                "crystalRedstone",
                ItemList.Robot_Arm_HV.get(1L),
                "circuitAdvanced",
                ItemList.Hull_HV.get(1L),
                "circuitAdvanced",
                "gearGtSmallStainlessSteel",
                ItemList.Electric_Motor_HV.get(1L),
                "gearGtSmallStainlessSteel");
        addShapedRecipe(
                getModItem(BuildCraftBuilders.ID, "architectBlock", 1, 0, missing),
                ItemList.Robot_Arm_HV.get(1L),
                getModItem(BuildCraftBuilders.ID, "templateItem", 1, 0, missing),
                ItemList.Robot_Arm_HV.get(1L),
                "circuitAdvanced",
                ItemList.Hull_HV.get(1L),
                "circuitAdvanced",
                "gearGtDiamond",
                ItemList.Electric_Motor_HV.get(1L),
                "gearGtDiamond");
        addShapedRecipe(
                getModItem(BuildCraftBuilders.ID, "libraryBlock", 1, 0, missing),
                "itemCasingStainlessSteel",
                "crystalRedstone",
                "itemCasingStainlessSteel",
                "circuitData",
                CustomItemList.Display.get(1L),
                "circuitData",
                "itemCasingStainlessSteel",
                "plateSteel",
                "itemCasingStainlessSteel");
        addShapedRecipe(
                getModItem(BuildCraftFactory.ID, "floodGateBlock", 1, 0, missing),
                "itemCasingSteel",
                ItemList.Electric_Pump_LV.get(1L),
                "itemCasingSteel",
                CustomItemList.SteelBars.get(1L),
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                CustomItemList.SteelBars.get(1L),
                "itemCasingSteel",
                CustomItemList.SteelBars.get(1L),
                "itemCasingSteel");
        addShapedRecipe(
                getModItem(BuildCraftSilicon.ID, "laserBlock", 1, 0, missing),
                "screwStainlessSteel",
                "blockRedstone",
                "screwStainlessSteel",
                "lensDiamond",
                "circuitAdvanced",
                "lensDiamond",
                "plateDenseObsidian",
                ItemList.Emitter_HV.get(1L),
                "plateDenseObsidian");
        addShapedRecipe(
                getModItem(BuildCraftSilicon.ID, "laserTableBlock", 1, 0, missing),
                ItemList.Robot_Arm_HV.get(1L),
                "blockRedstone",
                ItemList.Robot_Arm_HV.get(1L),
                "plateDiamond",
                "circuitAdvanced",
                "plateDiamond",
                "plateDenseObsidian",
                ItemList.Sensor_HV.get(1L),
                "plateDenseObsidian");
        addShapedRecipe(
                getModItem(BuildCraftSilicon.ID, "laserTableBlock", 1, 3, missing),
                "circuitAdvanced",
                "blockRedstone",
                "circuitAdvanced",
                "chipsetRed",
                "crystalRedstone",
                "chipsetRed",
                "plateDenseObsidian",
                "chipsetRed",
                "plateDenseObsidian");
        addShapedRecipe(
                getModItem(BuildCraftSilicon.ID, "laserTableBlock", 1, 2, missing),
                ItemList.Robot_Arm_HV.get(1L),
                "blockRedstone",
                ItemList.Robot_Arm_HV.get(1L),
                getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing),
                "circuitAdvanced",
                getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing),
                "plateDenseObsidian",
                getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 0, missing),
                "plateDenseObsidian");
        addShapedRecipe(
                getModItem(BuildCraftSilicon.ID, "laserTableBlock", 1, 4, missing),
                "circuitAdvanced",
                "blockRedstone",
                "circuitAdvanced",
                getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 6, missing),
                ItemList.Robot_Arm_HV.get(1L),
                getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 6, missing),
                "plateDenseObsidian",
                getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 0, missing),
                "plateDenseObsidian");
        addShapedRecipe(
                getModItem(BuildCraftRobotics.ID, "zonePlan", 1, 0, missing),
                ItemList.Robot_Arm_HV.get(1L),
                "circuitAdvanced",
                ItemList.Robot_Arm_HV.get(1L),
                "gearGtDiamond",
                getModItem(Minecraft.ID, "map", 1, 0, missing),
                "gearGtDiamond",
                getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 7, missing),
                ItemList.Electric_Motor_HV.get(1L),
                getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 7, missing));
        addShapedRecipe(
                getModItem(BuildCraftRobotics.ID, "robot", 1, 0, missing),
                "plateStainlessSteel",
                "plateStainlessSteel",
                "plateStainlessSteel",
                getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing),
                getModItem(BuildCraftSilicon.ID, "redstoneCrystal", 1, 0, missing),
                getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing),
                "circuitAdvanced",
                "plateStainlessSteel",
                "circuitAdvanced");
        addShapedRecipe(
                getModItem(BuildCraftRobotics.ID, "requester", 1, 0, missing),
                "plateStainlessSteel",
                ItemList.Electric_Piston_HV.get(1L),
                "plateStainlessSteel",
                "gearGtSteel",
                "chestSteel",
                "gearGtSteel",
                "plateStainlessSteel",
                ItemList.Sensor_HV.get(1L),
                "plateStainlessSteel");
        addShapedRecipe(
                getModItem(BuildCraftCore.ID, "wrenchItem", 1, 0, missing),
                null,
                "ingotStainlessSteel",
                null,
                "ingotStainlessSteel",
                "ingotStainlessSteel",
                "ingotStainlessSteel",
                "ingotStainlessSteel",
                "craftingToolHardHammer",
                "ingotStainlessSteel");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 1, missing),
                        getModItem(Forestry.ID, "propolis", 2, 0, missing))
                .itemOutputs(getModItem(BuildCraftCompat.ID, "item.buildcraftPipe.pipeitemspropolis", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 400)).duration(15 * SECONDS).eut(48)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 1, missing),
                        getModItem(Forestry.ID, "propolis", 2, 0, missing))
                .itemOutputs(getModItem(BuildCraftCompat.ID, "item.buildcraftPipe.pipeitemspropolis", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("honey", 400)).duration(15 * SECONDS).eut(48)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 30, missing))
                .itemOutputs(getModItem(BuildCraftCore.ID, "markerBlock", 1, 0, missing)).duration(5 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 24, missing))
                .itemOutputs(getModItem(BuildCraftCore.ID, "pathMarkerBlock", 1, 0, missing)).duration(5 * SECONDS)
                .eut(120).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing))
                .itemOutputs(getModItem(BuildCraftBuilders.ID, "templateItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("squidink", 144)).duration(5 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing))
                .itemOutputs(getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144)).duration(5 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Railcraft.ID, "glass", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 2L))
                .itemOutputs(getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing)).duration(5 * SECONDS).eut(8)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 5, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 2L))
                .itemOutputs(getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing)).duration(5 * SECONDS).eut(8)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "paper", 8, 0, missing), GTUtility.getIntegratedCircuit(8))
                .itemOutputs(getModItem(BuildCraftRobotics.ID, "redstone_board", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(10 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 2, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.StainlessSteel, 4L))
                .itemOutputs(getModItem(BuildCraftRobotics.ID, "robotStation", 1, 0, missing)).duration(15 * SECONDS)
                .eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "paper", 8, 0, missing), ItemList.Color_11.get(1L))
                .itemOutputs(getModItem(BuildCraftCore.ID, "mapLocation", 1, 0, missing)).duration(10 * SECONDS)
                .eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 8, 0, missing),
                        getModItem(Minecraft.ID, "dye", 1, 11, missing))
                .itemOutputs(getModItem(BuildCraftCore.ID, "mapLocation", 1, 0, missing)).duration(10 * SECONDS)
                .eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 8, 0, missing),
                        getModItem(Botany.ID, "pigment", 1, 78, missing))
                .itemOutputs(getModItem(BuildCraftCore.ID, "mapLocation", 1, 0, missing)).duration(10 * SECONDS)
                .eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 8, 0, missing),
                        getModItem(ExtraBees.ID, "misc", 1, 20, missing))
                .itemOutputs(getModItem(BuildCraftCore.ID, "mapLocation", 1, 0, missing)).duration(10 * SECONDS)
                .eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftCore.ID, "wrenchItem", 1, 0, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 0, missing))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "gateCopier", 1, 0, missing)).duration(5 * SECONDS)
                .eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 0, missing),
                        ItemList.Conveyor_Module_HV.get(1L))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemswood", 16, 0, missing))
                .duration(20 * SECONDS).eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 0, missing),
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 1, missing))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsiron", 16, 0, missing))
                .duration(20 * SECONDS).eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 0, missing),
                        ItemList.Electric_Motor_HV.get(1L))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsgold", 16, 0, missing))
                .duration(20 * SECONDS).eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 0, missing),
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 4, missing))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsdiamond", 8, 0, missing))
                .duration(20 * SECONDS).eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 0, missing),
                        ItemList.Robot_Arm_HV.get(1L))
                .itemOutputs(
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsobsidian", 16, 0, missing))
                .duration(20 * SECONDS).eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 1))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsemerald", 8, 0, missing))
                .duration(20 * SECONDS).eut(480).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Iron, 1),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.Iron, 2),
                        ItemList.Electric_Motor_LV.get(1L))
                .itemOutputs(getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing))
                .duration(10 * SECONDS).eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Emerald, 1L),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 0, missing))
                .itemOutputs(getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 7, missing)).duration(10 * SECONDS)
                .eut(480).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0L, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Firestone, 1L)),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Firestone, 4L))
                .itemOutputs(getModItem(BuildCraftSilicon.ID, "redstoneCrystal", 1, 0, missing)).duration(30 * SECONDS)
                .eut(120).addTo(laserEngraverRecipes);

    }
}
