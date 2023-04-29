package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptRandomThings implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Random Things";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays
                .asList(Mods.RandomThings.ID, Mods.TinkerConstruct.ID, Mods.ExtraUtilities.ID, Mods.TwilightForest.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("RandomThings", "bloodMoonSensor", 1, 0, missing),
                new Object[] { getModItem("minecraft", "stained_glass_pane", 1, 14, missing), null,
                        getModItem("minecraft", "daylight_detector", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("RandomThings", "lapisLamp", 1, 0, missing),
                new Object[] { getModItem("chisel", "iron_bars", 1, 2, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                        getModItem("chisel", "iron_bars", 1, 2, missing),
                        getModItem("chisel", "iron_bars", 1, 2, missing),
                        getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1, 27, missing),
                        getModItem("chisel", "iron_bars", 1, 2, missing),
                        getModItem("chisel", "iron_bars", 1, 2, missing),
                        getModItem("minecraft", "redstone_torch", 1, 0, missing),
                        getModItem("chisel", "iron_bars", 1, 2, missing) });
        addShapedRecipe(
                getModItem("RandomThings", "moonSensor", 1, 0, missing),
                new Object[] { getModItem("minecraft", "stained_glass_pane", 1, 0, missing), null,
                        getModItem("minecraft", "daylight_detector", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("RandomThings", "onlineDetector", 1, 0, missing),
                new Object[] { getModItem("chisel", "iron_bars", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("chisel", "iron_bars", 1, 2, missing),
                        getModItem("chisel", "iron_bars", 1, 2, missing),
                        getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1, 30, missing),
                        getModItem("chisel", "iron_bars", 1, 2, missing),
                        getModItem("chisel", "iron_bars", 1, 2, missing), "circuitGood",
                        getModItem("chisel", "iron_bars", 1, 2, missing) });
        addShapedRecipe(
                getModItem("RandomThings", "onlineDetector", 1, 0, missing),
                new Object[] { getModItem("minecraft", "iron_bars", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32691, missing),
                        getModItem("minecraft", "iron_bars", 1, 0, missing),
                        getModItem("minecraft", "iron_bars", 1, 0, missing),
                        getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1, 30, missing),
                        getModItem("minecraft", "iron_bars", 1, 0, missing),
                        getModItem("minecraft", "iron_bars", 1, 0, missing), "circuitGood",
                        getModItem("minecraft", "iron_bars", 1, 0, missing) });
        addShapedRecipe(
                getModItem("RandomThings", "imbuingStation", 1, 0, missing),
                new Object[] { getModItem("minecraft", "vine", 1, 0, missing),
                        getModItem("minecraft", "brewing_stand", 1, 0, missing),
                        getModItem("minecraft", "vine", 1, 0, missing),
                        getModItem("minecraft", "tallgrass", 1, 1, missing),
                        getModItem("minecraft", "stained_hardened_clay", 1, 5, missing),
                        getModItem("minecraft", "tallgrass", 1, 1, missing),
                        getModItem("minecraft", "waterlily", 1, 0, missing), "blockEmerald",
                        getModItem("minecraft", "waterlily", 1, 0, missing) });
        addShapedRecipe(
                getModItem("RandomThings", "enderEnergyDistributor", 1, 0, missing),
                new Object[] { "plateEnderPearl", getModItem("RandomThings", "ingredient", 1, 6, missing),
                        "plateEnderPearl", getModItem("RandomThings", "ingredient", 1, 6, missing),
                        getModItem("RandomThings", "energyDistributor", 1, 0, missing),
                        getModItem("RandomThings", "ingredient", 1, 6, missing), "plateEnderPearl",
                        getModItem("EnderIO", "blockWirelessCharger", 1, 0, missing), "plateEnderPearl" });
        addShapedRecipe(
                getModItem("RandomThings", "energyDistributor", 1, 0, missing),
                new Object[] { "blockRedstone",
                        getModItem("ProjRed|Integration", "projectred.integration.gate", 1, 10, missing),
                        "blockRedstone", getModItem("EnderIO", "itemPowerConduit", 1, 0, missing),
                        getModItem("RandomThings", "ingredient", 1, 7, missing),
                        getModItem("EnderIO", "itemPowerConduit", 1, 0, missing), "plateBlackSteel",
                        getModItem("ProjRed|Integration", "projectred.integration.gate", 1, 10, missing),
                        "plateBlackSteel" });
        addShapedRecipe(
                getModItem("RandomThings", "itemCollector", 1, 0, missing),
                new Object[] { null, "gemDiamond", null, getModItem("gregtech", "gt.metaitem.01", 1, 32650, missing),
                        "stickObsidian", "blockHopper", null, "plateRedstone", null });
        addShapelessCraftingRecipe(
                getModItem("RandomThings", "advancedItemCollector", 1, 0, missing),
                new Object[] { getModItem("ExtraUtilities", "enderCollector", 1, 0, missing) });
        addShapedRecipe(
                getModItem("RandomThings", "dyeingMachine", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("minecraft", "crafting_table", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 11, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing) });
        addShapelessCraftingRecipe(
                getModItem("RandomThings", "playerinterface", 1, 0, missing),
                new Object[] { getModItem("RIO", "tile.remote_interface", 1, 0, missing),
                        getModItem("RandomThings", "ingredient", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("RandomThings", "voidStone", 1, 0, missing),
                new Object[] { getModItem("ExtraUtilities", "trashcan", 1, 0, missing),
                        getModItem("minecraft", "ender_pearl", 1, 0, missing) });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "ender_pearl", 1, 0, missing),
                        getModItem("minecraft", "nether_wart", 1, 0, missing))
                .itemOutputs(getModItem("RandomThings", "ingredient", 1, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(150).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "emerald", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17526, missing))
                .itemOutputs(getModItem("RandomThings", "ingredient", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(250).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "GlassPane", 16, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("RandomThings", "fluidDisplay", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 72)).noFluidOutputs().duration(200).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("RandomThings", "fluidDisplay", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("RandomThings", "advancedFluidDisplay", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).noFluidOutputs().duration(200).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("minecraft", "stone", 1, 0, missing))
                .itemOutputs(getModItem("RandomThings", "filter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("minecraft", "iron_ingot", 1, 0, missing))
                .itemOutputs(getModItem("RandomThings", "filter", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("minecraft", "porkchop", 1, 0, missing))
                .itemOutputs(getModItem("RandomThings", "filter", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32729, missing),
                        getModItem("minecraft", "ender_pearl", 1, 0, missing))
                .itemOutputs(getModItem("RandomThings", "filter", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "lever", 1, 0, missing),
                        getModItem("minecraft", "redstone_block", 1, 0, missing))
                .itemOutputs(getModItem("RandomThings", "wirelessLever", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(300).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TwilightForest", "item.charmOfKeeping3", 4, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem("RandomThings", "whitestone", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 4000)).noFluidOutputs().duration(1200).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraUtilities", "trashcan", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("RandomThings", "dropFilter", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 250)).noFluidOutputs().duration(300).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("RandomThings", "ingredient", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23028, missing))
                .itemOutputs(getModItem("RandomThings", "spectreKey", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 1000)).noFluidOutputs().duration(600)
                .eut(1024).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 2032, missing),
                        getModItem("RandomThings", "ingredient", 1, 3, missing))
                .itemOutputs(getModItem("RandomThings", "ingredient", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(480).specialValue(2500).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "diamond", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("RandomThings", "ingredient", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(1200).eut(30)
                .addTo(sChemicalRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "dirt", 1, 0, missing),
                        getModItem("minecraft", "dye", 4, 15, missing))
                .itemOutputs(getModItem("RandomThings", "fertilizedDirt", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).noFluidOutputs().duration(100).eut(30)
                .addTo(sChemicalRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "dirt", 1, 0, missing),
                        getModItem("Forestry", "fertilizerCompound", 2, 0, missing))
                .itemOutputs(getModItem("RandomThings", "fertilizedDirt", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).noFluidOutputs().duration(100).eut(30)
                .addTo(sChemicalRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "dirt", 1, 0, missing),
                        getModItem("IC2", "itemFertilizer", 2, 0, missing))
                .itemOutputs(getModItem("RandomThings", "fertilizedDirt", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).noFluidOutputs().duration(100).eut(30)
                .addTo(sChemicalRecipes);

    }
}
