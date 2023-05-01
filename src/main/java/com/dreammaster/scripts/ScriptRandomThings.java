package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.ProjectRedIllumination;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.RemoteIO;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sBlastRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sChemicalRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;

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
                new Object[] { getModItem(Minecraft.ID, "stained_glass_pane", 1, 14, missing), null,
                        getModItem(Minecraft.ID, "daylight_detector", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(RandomThings.ID, "lapisLamp", 1, 0, missing),
                new Object[] { getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 0, missing),
                        getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                        getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                        getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 27, missing),
                        getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                        getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                        getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing),
                        getModItem(Chisel.ID, "iron_bars", 1, 2, missing) });
        addShapedRecipe(
                getModItem(RandomThings.ID, "moonSensor", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "stained_glass_pane", 1, 0, missing), null,
                        getModItem(Minecraft.ID, "daylight_detector", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(RandomThings.ID, "onlineDetector", 1, 0, missing),
                new Object[] { getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                        getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                        getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 30, missing),
                        getModItem(Chisel.ID, "iron_bars", 1, 2, missing),
                        getModItem(Chisel.ID, "iron_bars", 1, 2, missing), "circuitGood",
                        getModItem(Chisel.ID, "iron_bars", 1, 2, missing) });
        addShapedRecipe(
                getModItem(RandomThings.ID, "onlineDetector", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32691, missing),
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                        getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 30, missing),
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "circuitGood",
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing) });
        addShapedRecipe(
                getModItem(RandomThings.ID, "imbuingStation", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "vine", 1, 0, missing),
                        getModItem(Minecraft.ID, "brewing_stand", 1, 0, missing),
                        getModItem(Minecraft.ID, "vine", 1, 0, missing),
                        getModItem(Minecraft.ID, "tallgrass", 1, 1, missing),
                        getModItem(Minecraft.ID, "stained_hardened_clay", 1, 5, missing),
                        getModItem(Minecraft.ID, "tallgrass", 1, 1, missing),
                        getModItem(Minecraft.ID, "waterlily", 1, 0, missing), "blockEmerald",
                        getModItem(Minecraft.ID, "waterlily", 1, 0, missing) });
        addShapedRecipe(
                getModItem(RandomThings.ID, "enderEnergyDistributor", 1, 0, missing),
                new Object[] { "plateEnderPearl", getModItem(RandomThings.ID, "ingredient", 1, 6, missing),
                        "plateEnderPearl", getModItem(RandomThings.ID, "ingredient", 1, 6, missing),
                        getModItem(RandomThings.ID, "energyDistributor", 1, 0, missing),
                        getModItem(RandomThings.ID, "ingredient", 1, 6, missing), "plateEnderPearl",
                        getModItem(EnderIO.ID, "blockWirelessCharger", 1, 0, missing), "plateEnderPearl" });
        addShapedRecipe(
                getModItem(RandomThings.ID, "energyDistributor", 1, 0, missing),
                new Object[] { "blockRedstone",
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 10, missing),
                        "blockRedstone", getModItem(EnderIO.ID, "itemPowerConduit", 1, 0, missing),
                        getModItem(RandomThings.ID, "ingredient", 1, 7, missing),
                        getModItem(EnderIO.ID, "itemPowerConduit", 1, 0, missing), "plateBlackSteel",
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 10, missing),
                        "plateBlackSteel" });
        addShapedRecipe(
                getModItem(RandomThings.ID, "itemCollector", 1, 0, missing),
                new Object[] { null, "gemDiamond", null, getModItem(GregTech.ID, "gt.metaitem.01", 1, 32650, missing),
                        "stickObsidian", "blockHopper", null, "plateRedstone", null });
        addShapelessCraftingRecipe(
                getModItem(RandomThings.ID, "advancedItemCollector", 1, 0, missing),
                new Object[] { getModItem(ExtraUtilities.ID, "enderCollector", 1, 0, missing) });
        addShapedRecipe(
                getModItem(RandomThings.ID, "dyeingMachine", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(Minecraft.ID, "crafting_table", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 11, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17809, missing) });
        addShapelessCraftingRecipe(
                getModItem(RandomThings.ID, "playerinterface", 1, 0, missing),
                new Object[] { getModItem(RemoteIO.ID, "tile.remote_interface", 1, 0, missing),
                        getModItem(RandomThings.ID, "ingredient", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(RandomThings.ID, "voidStone", 1, 0, missing),
                new Object[] { getModItem(ExtraUtilities.ID, "trashcan", 1, 0, missing),
                        getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing) });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing),
                        getModItem(Minecraft.ID, "nether_wart", 1, 0, missing))
                .itemOutputs(getModItem(RandomThings.ID, "ingredient", 1, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(150).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "emerald", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17526, missing))
                .itemOutputs(getModItem(RandomThings.ID, "ingredient", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(250).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "GlassPane", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(RandomThings.ID, "fluidDisplay", 8, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 72)).noFluidOutputs().duration(200).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(RandomThings.ID, "fluidDisplay", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(RandomThings.ID, "advancedFluidDisplay", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 144)).noFluidOutputs().duration(200).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(Minecraft.ID, "stone", 1, 0, missing))
                .itemOutputs(getModItem(RandomThings.ID, "filter", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing))
                .itemOutputs(getModItem(RandomThings.ID, "filter", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(Minecraft.ID, "porkchop", 1, 0, missing))
                .itemOutputs(getModItem(RandomThings.ID, "filter", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32729, missing),
                        getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing))
                .itemOutputs(getModItem(RandomThings.ID, "filter", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "lever", 1, 0, missing),
                        getModItem(Minecraft.ID, "redstone_block", 1, 0, missing))
                .itemOutputs(getModItem(RandomThings.ID, "wirelessLever", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(300).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TwilightForest.ID, "item.charmOfKeeping3", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem(RandomThings.ID, "whitestone", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 4000)).noFluidOutputs().duration(1200).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraUtilities.ID, "trashcan", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(RandomThings.ID, "dropFilter", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 250)).noFluidOutputs().duration(300).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(RandomThings.ID, "ingredient", 1, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23028, missing))
                .itemOutputs(getModItem(RandomThings.ID, "spectreKey", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("bacterialsludge", 1000)).noFluidOutputs().duration(600)
                .eut(1024).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2032, missing),
                        getModItem(RandomThings.ID, "ingredient", 1, 3, missing))
                .itemOutputs(getModItem(RandomThings.ID, "ingredient", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(1200).eut(480).specialValue(2500).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "diamond", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(RandomThings.ID, "ingredient", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(1200).eut(30)
                .addTo(sChemicalRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                        getModItem(Minecraft.ID, "dye", 4, 15, missing))
                .itemOutputs(getModItem(RandomThings.ID, "fertilizedDirt", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).noFluidOutputs().duration(100).eut(30)
                .addTo(sChemicalRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                        getModItem(Forestry.ID, "fertilizerCompound", 2, 0, missing))
                .itemOutputs(getModItem(RandomThings.ID, "fertilizedDirt", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).noFluidOutputs().duration(100).eut(30)
                .addTo(sChemicalRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemFertilizer", 2, 0, missing))
                .itemOutputs(getModItem(RandomThings.ID, "fertilizedDirt", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).noFluidOutputs().duration(100).eut(30)
                .addTo(sChemicalRecipes);

    }
}
