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
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.ProjectRedCore;
import static gregtech.api.enums.Mods.ProjectRedExpansion;
import static gregtech.api.enums.Mods.ProjectRedTransportation;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sLaserEngraverRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sPressRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

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
        addShapelessCraftingRecipe(
                getModItem(BuildCraftCore.ID, "diamondGearItem", 1, 0, missing),
                new Object[] { "gearGtDiamond" });
        addShapelessCraftingRecipe(
                getModItem(BuildCraftCore.ID, "goldGearItem", 1, 0, missing),
                new Object[] { "gearGtGold" });
        addShapelessCraftingRecipe(
                getModItem(BuildCraftCore.ID, "ironGearItem", 1, 0, missing),
                new Object[] { "gearGtIron" });
        addShapelessCraftingRecipe(
                getModItem(BuildCraftCore.ID, "stoneGearItem", 1, 0, missing),
                new Object[] { "gearGtStone" });
        addShapelessCraftingRecipe(
                getModItem(BuildCraftCore.ID, "woodenGearItem", 1, 0, missing),
                new Object[] { "gearGtWood" });
        addShapedRecipe(
                getModItem(BuildCraftCore.ID, "engineBlock", 1, 2, missing),
                new Object[] { "plateInvar", "plateLapis", "plateInvar", "springInvar",
                        getModItem(Minecraft.ID, "piston", 1, 0, missing), "springInvar", "gearInvar",
                        getModItem(Forestry.ID, "sturdyMachine", 1, 0, missing), "gearInvar" });
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipestructurecobblestone", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 23299, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23299, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23299, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23299, missing) });
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowercobblestone", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 23299, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23299, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "wireGt01Tin",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23299, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23299, missing) });
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerstone", 1, 0, missing),
                new Object[] { getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "wireGt01Nickel",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ForgeMicroblocks.ID, "stoneRod", 1, 0, missing) });
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerwood", 1, 0, missing),
                new Object[] { "stickWood", getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "stickWood",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "wireGt01Copper",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "stickWood",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowersandstone", 1, 0, missing),
                new Object[] { getModItem(NewHorizonsCoreMod.ID, "item.SandStoneRod", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SandStoneRod", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "wireGt01Cupronickel",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SandStoneRod", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SandStoneRod", 1, 0, missing) });
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerquartz", 1, 0, missing),
                new Object[] { "stickNetherQuartz", getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        "stickNetherQuartz", getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        "wireGt01Silver", getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        "stickNetherQuartz", getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        "stickNetherQuartz" });
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepoweriron", 1, 0, missing),
                new Object[] { "stickIron", getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "stickIron",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "wireGt01Electrum",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "stickIron",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "stickIron" });
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowergold", 1, 0, missing),
                new Object[] { "stickGold", getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "stickGold",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "wireGt01Aluminium",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "stickGold",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "stickGold" });
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepoweremerald", 1, 0, missing),
                new Object[] { "stickEmerald", getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        "stickEmerald", getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "wireGt01Nichrome",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "stickEmerald",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "stickEmerald" });
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipepowerdiamond", 1, 0, missing),
                new Object[] { "stickDiamond", getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        "stickDiamond", getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "wireGt01Platinum",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "stickDiamond",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "stickDiamond" });
        addShapedRecipe(
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                new Object[] { "screwIron", "ringIron", "screwIron", "craftingToolWrench",
                        getModItem(Railcraft.ID, "glass", 1, 0, missing), "craftingToolScrewdriver", "screwIron",
                        "ringIron", "screwIron" });
        addShapedRecipe(
                getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                new Object[] { "screwIron", "ringIron", "screwIron", "craftingToolWrench",
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 5, missing), "craftingToolScrewdriver",
                        "screwIron", "ringIron", "screwIron" });
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsvoid", 1, 0, missing),
                new Object[] { getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "gemEnderPearl",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(RandomThings.ID, "ingredient", 1, 1, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(RandomThings.ID, "ingredient", 1, 1, missing) });
        addShapedRecipe(
                getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipefluidsvoid", 1, 0, missing),
                new Object[] { "stickAnyRubber", getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        "stickAnyRubber", getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "gemEnderPearl",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "stickAnyRubber",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "stickAnyRubber" });
        addShapedRecipe(
                getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                new Object[] { "itemCasingAnyIron", "gearGtSmallAnyIron", "itemCasingAnyIron", "gearGtSmallAnyIron",
                        getModItem(Forestry.ID, "factory2", 1, 2, missing), "gearGtSmallAnyIron", "itemCasingAnyIron",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing), "itemCasingAnyIron" });
        addShapelessCraftingRecipe(
                getModItem(BuildCraftCore.ID, "paintbrush", 1, 0, missing),
                new Object[] { getModItem(OpenBlocks.ID, "paintBrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing),
                new Object[] { getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 11, missing) });
        addShapedRecipe(
                getModItem(BuildCraftBuilders.ID, "fillerBlock", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing), "crystalRedstone",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32651, missing), "circuitGood",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 12, missing), "circuitGood",
                        "gearGtSmallAluminium", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32601, missing),
                        "gearGtSmallAluminium" });
        addShapedRecipe(
                getModItem(BuildCraftBuilders.ID, "builderBlock", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing), "crystalRedstone",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing), "circuitAdvanced",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 13, missing), "circuitAdvanced",
                        "gearGtSmallStainlessSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing),
                        "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem(BuildCraftBuilders.ID, "architectBlock", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(BuildCraftBuilders.ID, "templateItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing), "circuitAdvanced",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 13, missing), "circuitAdvanced", "gearGtDiamond",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing), "gearGtDiamond" });
        addShapedRecipe(
                getModItem(BuildCraftBuilders.ID, "libraryBlock", 1, 0, missing),
                new Object[] { "itemCasingStainlessSteel", "crystalRedstone", "itemCasingStainlessSteel", "circuitData",
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing), "circuitData",
                        "itemCasingStainlessSteel", "plateSteel", "itemCasingStainlessSteel" });
        addShapedRecipe(
                getModItem(BuildCraftFactory.ID, "floodGateBlock", 1, 0, missing),
                new Object[] { "itemCasingSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32610, missing),
                        "itemCasingSteel", getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                        getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing), "itemCasingSteel",
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing), "itemCasingSteel" });
        addShapedRecipe(
                getModItem(BuildCraftSilicon.ID, "laserBlock", 1, 0, missing),
                new Object[] { "screwStainlessSteel", "blockRedstone", "screwStainlessSteel", "lensDiamond",
                        "circuitAdvanced", "lensDiamond", "plateDenseObsidian",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32682, missing), "plateDenseObsidian" });
        addShapedRecipe(
                getModItem(BuildCraftSilicon.ID, "laserTableBlock", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing), "blockRedstone",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing), "plateDiamond", "circuitAdvanced",
                        "plateDiamond", "plateDenseObsidian",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing), "plateDenseObsidian" });
        addShapedRecipe(
                getModItem(BuildCraftSilicon.ID, "laserTableBlock", 1, 3, missing),
                new Object[] { "circuitAdvanced", "blockRedstone", "circuitAdvanced", "chipsetRed", "crystalRedstone",
                        "chipsetRed", "plateDenseObsidian", "chipsetRed", "plateDenseObsidian" });
        addShapedRecipe(
                getModItem(BuildCraftSilicon.ID, "laserTableBlock", 1, 2, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing), "blockRedstone",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing), "circuitAdvanced",
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing), "plateDenseObsidian",
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 0, missing), "plateDenseObsidian" });
        addShapedRecipe(
                getModItem(BuildCraftSilicon.ID, "laserTableBlock", 1, 4, missing),
                new Object[] { "circuitAdvanced", "blockRedstone", "circuitAdvanced",
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 6, missing), "plateDenseObsidian",
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 0, missing), "plateDenseObsidian" });
        addShapedRecipe(
                getModItem(BuildCraftRobotics.ID, "zonePlan", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing), "circuitAdvanced",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing), "gearGtDiamond",
                        getModItem(Minecraft.ID, "map", 1, 0, missing), "gearGtDiamond",
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 7, missing) });
        addShapedRecipe(
                getModItem(BuildCraftRobotics.ID, "robot", 1, 0, missing),
                new Object[] { "plateStainlessSteel", "plateStainlessSteel", "plateStainlessSteel",
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneCrystal", 1, 0, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 3, missing), "circuitAdvanced",
                        "plateStainlessSteel", "circuitAdvanced" });
        addShapedRecipe(
                getModItem(BuildCraftRobotics.ID, "requester", 1, 0, missing),
                new Object[] { "plateStainlessSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32642, missing),
                        "plateStainlessSteel", "gearGtSteel", "chestSteel", "gearGtSteel", "plateStainlessSteel",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32692, missing), "plateStainlessSteel" });
        addShapedRecipe(
                getModItem(BuildCraftCore.ID, "wrenchItem", 1, 0, missing),
                new Object[] { null, "ingotStainlessSteel", null, "ingotStainlessSteel", "ingotStainlessSteel",
                        "ingotStainlessSteel", "ingotStainlessSteel", "craftingToolHardHammer",
                        "ingotStainlessSteel" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 1, missing),
                        getModItem(Forestry.ID, "propolis", 2, 0, missing))
                .itemOutputs(getModItem(BuildCraftCompat.ID, "item.buildcraftPipe.pipeitemspropolis", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 400)).noFluidOutputs().duration(300).eut(48)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 1, missing),
                        getModItem(Forestry.ID, "propolis", 2, 0, missing))
                .itemOutputs(getModItem(BuildCraftCompat.ID, "item.buildcraftPipe.pipeitemspropolis", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("honey", 400)).noFluidOutputs().duration(300).eut(48)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 30, missing))
                .itemOutputs(getModItem(BuildCraftCore.ID, "markerBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing),
                        getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 24, missing))
                .itemOutputs(getModItem(BuildCraftCore.ID, "pathMarkerBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing))
                .itemOutputs(getModItem(BuildCraftBuilders.ID, "templateItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("squidink", 144)).noFluidOutputs().duration(100).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing))
                .itemOutputs(getModItem(BuildCraftBuilders.ID, "blueprintItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144)).noFluidOutputs().duration(100)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Railcraft.ID, "glass", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 28032, missing))
                .itemOutputs(getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "decorativeBlock2", 1, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 28032, missing))
                .itemOutputs(getModItem(BuildCraftFactory.ID, "tankBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem(BuildCraftRobotics.ID, "redstone_board", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17306, missing))
                .itemOutputs(getModItem(BuildCraftRobotics.ID, "robotStation", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32425, missing))
                .itemOutputs(getModItem(BuildCraftCore.ID, "mapLocation", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 8, 0, missing),
                        getModItem(Minecraft.ID, "dye", 1, 11, missing))
                .itemOutputs(getModItem(BuildCraftCore.ID, "mapLocation", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 8, 0, missing),
                        getModItem(Botany.ID, "pigment", 1, 78, missing))
                .itemOutputs(getModItem(BuildCraftCore.ID, "mapLocation", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 8, 0, missing),
                        getModItem(ExtraBees.ID, "misc", 1, 20, missing))
                .itemOutputs(getModItem(BuildCraftCore.ID, "mapLocation", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BuildCraftCore.ID, "wrenchItem", 1, 0, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 0, missing))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "gateCopier", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32632, missing))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemswood", 16, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 0, missing),
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 1, missing))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsiron", 16, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsgold", 16, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 0, missing),
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 1, 4, missing))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsdiamond", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32652, missing))
                .itemOutputs(
                        getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsobsidian", 16, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsemerald", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32703, missing))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsemerald", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ProjectRedTransportation.ID, "projectred.transportation.pipe", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 1, 32082, missing))
                .itemOutputs(getModItem(BuildCraftTransport.ID, "item.buildcraftPipe.pipeitemsemerald", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 20032, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 2, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing))
                .itemOutputs(getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 20304, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 2, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing))
                .itemOutputs(getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 20032, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 18032, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing))
                .itemOutputs(getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 20304, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 18032, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing))
                .itemOutputs(getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 20032, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 18304, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing))
                .itemOutputs(getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 20304, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 18304, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing))
                .itemOutputs(getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 20032, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 18307, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing))
                .itemOutputs(getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "factory2", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 20304, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 18307, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32600, missing))
                .itemOutputs(getModItem(BuildCraftFactory.ID, "autoWorkbenchBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17501, missing),
                        getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 0, missing))
                .itemOutputs(getModItem(BuildCraftSilicon.ID, "redstoneChipset", 1, 7, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 24347, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17347, missing))
                .itemOutputs(getModItem(BuildCraftSilicon.ID, "redstoneCrystal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sLaserEngraverRecipes);

    }
}
