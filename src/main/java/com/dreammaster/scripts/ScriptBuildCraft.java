package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

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
        return Arrays.asList(Mods.BuildCraftCore.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessCraftingRecipe(
                getModItem("BuildCraft|Core", "diamondGearItem", 1, 0, missing),
                new Object[] { "gearGtDiamond" });
        addShapelessCraftingRecipe(
                getModItem("BuildCraft|Core", "goldGearItem", 1, 0, missing),
                new Object[] { "gearGtGold" });
        addShapelessCraftingRecipe(
                getModItem("BuildCraft|Core", "ironGearItem", 1, 0, missing),
                new Object[] { "gearGtIron" });
        addShapelessCraftingRecipe(
                getModItem("BuildCraft|Core", "stoneGearItem", 1, 0, missing),
                new Object[] { "gearGtStone" });
        addShapelessCraftingRecipe(
                getModItem("BuildCraft|Core", "woodenGearItem", 1, 0, missing),
                new Object[] { "gearGtWood" });
        addShapedRecipe(
                getModItem("BuildCraft|Core", "engineBlock", 1, 2, missing),
                new Object[] { "plateInvar", "plateLapis", "plateInvar", "springInvar",
                        getModItem("minecraft", "piston", 1, 0, missing), "springInvar", "gearInvar",
                        getModItem("Forestry", "sturdyMachine", 1, 0, missing), "gearInvar" });
        addShapedRecipe(
                getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipestructurecobblestone", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 23299, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23299, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("minecraft", "gravel", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23299, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23299, missing) });
        addShapedRecipe(
                getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowercobblestone", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 23299, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23299, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "wireGt01Tin",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23299, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23299, missing) });
        addShapedRecipe(
                getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowerstone", 1, 0, missing),
                new Object[] { getModItem("ForgeMicroblock", "stoneRod", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ForgeMicroblock", "stoneRod", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "wireGt01Nickel",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ForgeMicroblock", "stoneRod", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ForgeMicroblock", "stoneRod", 1, 0, missing) });
        addShapedRecipe(
                getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowerwood", 1, 0, missing),
                new Object[] { "stickWood", getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickWood",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "wireGt01Copper",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickWood",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowersandstone", 1, 0, missing),
                new Object[] { getModItem("dreamcraft", "item.SandStoneRod", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("dreamcraft", "item.SandStoneRod", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "wireGt01Cupronickel",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("dreamcraft", "item.SandStoneRod", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("dreamcraft", "item.SandStoneRod", 1, 0, missing) });
        addShapedRecipe(
                getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowerquartz", 1, 0, missing),
                new Object[] { "stickNetherQuartz", getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        "stickNetherQuartz", getModItem("TConstruct", "GlassPane", 1, 0, missing), "wireGt01Silver",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickNetherQuartz",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickNetherQuartz" });
        addShapedRecipe(
                getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepoweriron", 1, 0, missing),
                new Object[] { "stickIron", getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickIron",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "wireGt01Electrum",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickIron",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickIron" });
        addShapedRecipe(
                getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowergold", 1, 0, missing),
                new Object[] { "stickGold", getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickGold",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "wireGt01Aluminium",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickGold",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickGold" });
        addShapedRecipe(
                getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepoweremerald", 1, 0, missing),
                new Object[] { "stickEmerald", getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickEmerald",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "wireGt01Nichrome",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickEmerald",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickEmerald" });
        addShapedRecipe(
                getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipepowerdiamond", 1, 0, missing),
                new Object[] { "stickDiamond", getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickDiamond",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "wireGt01Platinum",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickDiamond",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickDiamond" });
        addShapedRecipe(
                getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                new Object[] { "screwIron", "ringIron", "screwIron", "craftingToolWrench",
                        getModItem("Railcraft", "glass", 1, 0, missing), "craftingToolScrewdriver", "screwIron",
                        "ringIron", "screwIron" });
        addShapedRecipe(
                getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                new Object[] { "screwIron", "ringIron", "screwIron", "craftingToolWrench",
                        getModItem("ExtraUtilities", "decorativeBlock2", 1, 5, missing), "craftingToolScrewdriver",
                        "screwIron", "ringIron", "screwIron" });
        addShapedRecipe(
                getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipeitemsvoid", 1, 0, missing),
                new Object[] { getModItem("RandomThings", "ingredient", 1, 1, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("RandomThings", "ingredient", 1, 1, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "gemEnderPearl",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("RandomThings", "ingredient", 1, 1, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("RandomThings", "ingredient", 1, 1, missing) });
        addShapedRecipe(
                getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipefluidsvoid", 1, 0, missing),
                new Object[] { "stickAnyRubber", getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickAnyRubber",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "gemEnderPearl",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickAnyRubber",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "stickAnyRubber" });
        addShapedRecipe(
                getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing),
                new Object[] { "itemCasingAnyIron", "gearGtSmallAnyIron", "itemCasingAnyIron", "gearGtSmallAnyIron",
                        getModItem("Forestry", "factory2", 1, 2, missing), "gearGtSmallAnyIron", "itemCasingAnyIron",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "itemCasingAnyIron" });
        addShapelessCraftingRecipe(
                getModItem("BuildCraft|Core", "paintbrush", 1, 0, missing),
                new Object[] { getModItem("OpenBlocks", "paintBrush", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing),
                new Object[] { getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 11, missing) });
        addShapedRecipe(
                getModItem("BuildCraft|Builders", "fillerBlock", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing), "crystalRedstone",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32651, missing), "circuitGood",
                        getModItem("gregtech", "gt.blockmachines", 1, 12, missing), "circuitGood",
                        "gearGtSmallAluminium", getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        "gearGtSmallAluminium" });
        addShapedRecipe(
                getModItem("BuildCraft|Builders", "builderBlock", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing), "crystalRedstone",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing), "circuitAdvanced",
                        getModItem("gregtech", "gt.blockmachines", 1, 13, missing), "circuitAdvanced",
                        "gearGtSmallStainlessSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing),
                        "gearGtSmallStainlessSteel" });
        addShapedRecipe(
                getModItem("BuildCraft|Builders", "architectBlock", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("BuildCraft|Builders", "templateItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing), "circuitAdvanced",
                        getModItem("gregtech", "gt.blockmachines", 1, 13, missing), "circuitAdvanced", "gearGtDiamond",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing), "gearGtDiamond" });
        addShapedRecipe(
                getModItem("BuildCraft|Builders", "libraryBlock", 1, 0, missing),
                new Object[] { "itemCasingStainlessSteel", "crystalRedstone", "itemCasingStainlessSteel", "circuitData",
                        getModItem("dreamcraft", "item.Display", 1, 0, missing), "circuitData",
                        "itemCasingStainlessSteel", "plateSteel", "itemCasingStainlessSteel" });
        addShapedRecipe(
                getModItem("BuildCraft|Factory", "floodGateBlock", 1, 0, missing),
                new Object[] { "itemCasingSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32610, missing),
                        "itemCasingSteel", getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing), "itemCasingSteel",
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing), "itemCasingSteel" });
        addShapedRecipe(
                getModItem("BuildCraft|Silicon", "laserBlock", 1, 0, missing),
                new Object[] { "screwStainlessSteel", "blockRedstone", "screwStainlessSteel", "lensDiamond",
                        "circuitAdvanced", "lensDiamond", "plateDenseObsidian",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32682, missing), "plateDenseObsidian" });
        addShapedRecipe(
                getModItem("BuildCraft|Silicon", "laserTableBlock", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing), "blockRedstone",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing), "plateDiamond", "circuitAdvanced",
                        "plateDiamond", "plateDenseObsidian",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing), "plateDenseObsidian" });
        addShapedRecipe(
                getModItem("BuildCraft|Silicon", "laserTableBlock", 1, 3, missing),
                new Object[] { "circuitAdvanced", "blockRedstone", "circuitAdvanced", "chipsetRed", "crystalRedstone",
                        "chipsetRed", "plateDenseObsidian", "chipsetRed", "plateDenseObsidian" });
        addShapedRecipe(
                getModItem("BuildCraft|Silicon", "laserTableBlock", 1, 2, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing), "blockRedstone",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 3, missing), "circuitAdvanced",
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 3, missing), "plateDenseObsidian",
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 0, missing), "plateDenseObsidian" });
        addShapedRecipe(
                getModItem("BuildCraft|Silicon", "laserTableBlock", 1, 4, missing),
                new Object[] { "circuitAdvanced", "blockRedstone", "circuitAdvanced",
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 6, missing), "plateDenseObsidian",
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 0, missing), "plateDenseObsidian" });
        addShapedRecipe(
                getModItem("BuildCraft|Robotics", "zonePlan", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing), "circuitAdvanced",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing), "gearGtDiamond",
                        getModItem("minecraft", "map", 1, 0, missing), "gearGtDiamond",
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 7, missing) });
        addShapedRecipe(
                getModItem("BuildCraft|Robotics", "robot", 1, 0, missing),
                new Object[] { "plateStainlessSteel", "plateStainlessSteel", "plateStainlessSteel",
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 3, missing),
                        getModItem("BuildCraft|Silicon", "redstoneCrystal", 1, 0, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 3, missing), "circuitAdvanced",
                        "plateStainlessSteel", "circuitAdvanced" });
        addShapedRecipe(
                getModItem("BuildCraft|Robotics", "requester", 1, 0, missing),
                new Object[] { "plateStainlessSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32642, missing),
                        "plateStainlessSteel", "gearGtSteel", "chestSteel", "gearGtSteel", "plateStainlessSteel",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing), "plateStainlessSteel" });
        addShapedRecipe(
                getModItem("BuildCraft|Core", "wrenchItem", 1, 0, missing),
                new Object[] { null, "ingotStainlessSteel", null, "ingotStainlessSteel", "ingotStainlessSteel",
                        "ingotStainlessSteel", "ingotStainlessSteel", "craftingToolHardHammer",
                        "ingotStainlessSteel" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 1, missing),
                        getModItem("Forestry", "propolis", 2, 0, missing))
                .itemOutputs(getModItem("BuildCraft|Compat", "item.buildcraftPipe.pipeitemspropolis", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 400)).noFluidOutputs().duration(300).eut(48)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 1, missing),
                        getModItem("Forestry", "propolis", 2, 0, missing))
                .itemOutputs(getModItem("BuildCraft|Compat", "item.buildcraftPipe.pipeitemspropolis", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("honey", 400)).noFluidOutputs().duration(300).eut(48)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "redstone_torch", 1, 0, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 30, missing))
                .itemOutputs(getModItem("BuildCraft|Core", "markerBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "redstone_torch", 1, 0, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 24, missing))
                .itemOutputs(getModItem("BuildCraft|Core", "pathMarkerBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "paper", 1, 0, missing),
                        getModItem("minecraft", "redstone", 1, 0, missing))
                .itemOutputs(getModItem("BuildCraft|Builders", "templateItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("squidink", 144)).noFluidOutputs().duration(100).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "paper", 1, 0, missing),
                        getModItem("minecraft", "redstone", 1, 0, missing))
                .itemOutputs(getModItem("BuildCraft|Builders", "blueprintItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144)).noFluidOutputs().duration(100)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Railcraft", "glass", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 28032, missing))
                .itemOutputs(getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "decorativeBlock2", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 28032, missing))
                .itemOutputs(getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "paper", 8, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 8, missing))
                .itemOutputs(getModItem("BuildCraft|Robotics", "redstone_board", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17306, missing))
                .itemOutputs(getModItem("BuildCraft|Robotics", "robotStation", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "paper", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32425, missing))
                .itemOutputs(getModItem("BuildCraft|Core", "mapLocation", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "paper", 8, 0, missing),
                        getModItem("minecraft", "dye", 1, 11, missing))
                .itemOutputs(getModItem("BuildCraft|Core", "mapLocation", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "paper", 8, 0, missing),
                        getModItem("Botany", "pigment", 1, 78, missing))
                .itemOutputs(getModItem("BuildCraft|Core", "mapLocation", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "paper", 8, 0, missing),
                        getModItem("ExtraBees", "misc", 1, 20, missing))
                .itemOutputs(getModItem("BuildCraft|Core", "mapLocation", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BuildCraft|Core", "wrenchItem", 1, 0, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 0, missing))
                .itemOutputs(getModItem("BuildCraft|Transport", "gateCopier", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32632, missing))
                .itemOutputs(getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipeitemswood", 16, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 16, 0, missing),
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 1, missing))
                .itemOutputs(getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipeitemsiron", 16, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing))
                .itemOutputs(getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipeitemsgold", 16, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 8, 0, missing),
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 1, 4, missing))
                .itemOutputs(getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipeitemsdiamond", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 16, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32652, missing))
                .itemOutputs(
                        getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipeitemsobsidian", 16, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 8, 0, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 1, 0, missing))
                .itemOutputs(getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipeitemsemerald", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32703, missing))
                .itemOutputs(getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipeitemsemerald", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Transportation", "projectred.transportation.pipe", 8, 0, missing),
                        getModItem("gregtech", "gt.metaitem.03", 1, 32082, missing))
                .itemOutputs(getModItem("BuildCraft|Transport", "item.buildcraftPipe.pipeitemsemerald", 8, 0, missing))
                .noFluidInputs().noFluidOutputs().duration(400).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "factory2", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 20032, missing),
                        getModItem("IC2", "itemCasing", 2, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing))
                .itemOutputs(getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "factory2", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 20304, missing),
                        getModItem("IC2", "itemCasing", 2, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing))
                .itemOutputs(getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "factory2", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 20032, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 18032, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing))
                .itemOutputs(getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "factory2", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 20304, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 18032, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing))
                .itemOutputs(getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "factory2", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 20032, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 18304, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing))
                .itemOutputs(getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "factory2", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 20304, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 18304, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing))
                .itemOutputs(getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "factory2", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 20032, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 18307, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing))
                .itemOutputs(getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "factory2", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 20304, missing),
                        getModItem("gregtech", "gt.metaitem.02", 2, 18307, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing))
                .itemOutputs(getModItem("BuildCraft|Factory", "autoWorkbenchBlock", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17501, missing),
                        getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 0, missing))
                .itemOutputs(getModItem("BuildCraft|Silicon", "redstoneChipset", 1, 7, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sPressRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 0, 24347, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17347, missing))
                .itemOutputs(getModItem("BuildCraft|Silicon", "redstoneCrystal", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(120).addTo(sLaserEngraverRecipes);

    }
}
