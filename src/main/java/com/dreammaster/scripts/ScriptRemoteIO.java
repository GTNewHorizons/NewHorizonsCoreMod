package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.EnderStorage;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.RemoteIO;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.WirelessRedstoneCBELogic;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;

public class ScriptRemoteIO implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Remote IO";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                RemoteIO.ID,
                TinkerConstruct.ID,
                WirelessRedstoneCBELogic.ID,
                AppliedEnergistics2.ID,
                EnderStorage.ID,
                ExtraUtilities.ID,
                IndustrialCraft2.ID,
                ProjectRedIntegration.ID,
                RandomThings.ID,
                Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(RemoteIO.ID, "tile.remote_interface", 2, 0, missing),
                ItemList.Automation_Regulator_IV.get(1L),
                ItemList.Sensor_EV.get(1L),
                ItemList.Automation_Regulator_IV.get(1L),
                "circuitElite",
                GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.BlackSteel, 1L),
                "circuitElite",
                ItemList.Automation_Regulator_IV.get(1L),
                ItemList.Emitter_EV.get(1L),
                ItemList.Automation_Regulator_IV.get(1L));
        addShapelessRecipe(
                getModItem(RemoteIO.ID, "tile.remote_interface", 1, 0, missing),
                getModItem(RandomThings.ID, "playerinterface", 1, 0, missing));
        addShapedRecipe(
                getModItem(RemoteIO.ID, "tile.machine", 1, 0, missing),
                ItemList.Electric_Pump_EV.get(1L),
                "pipeMediumTitanium",
                ItemList.Electric_Pump_EV.get(1L),
                "pipeMediumTitanium",
                ItemList.Casing_HV.get(1L),
                "pipeMediumTitanium",
                ItemList.Electric_Pump_EV.get(1L),
                "pipeMediumTitanium",
                ItemList.Electric_Pump_EV.get(1L));
        addShapedRecipe(
                getModItem(RemoteIO.ID, "tile.machine", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                ItemList.Electric_Pump_EV.get(1L),
                ItemList.Casing_HV.get(1L),
                ItemList.Electric_Pump_EV.get(1L),
                "plateTitanium",
                "plateTitanium",
                "plateTitanium");
        addShapedRecipe(
                getModItem(RemoteIO.ID, "skylight", 1, 0, missing),
                "plateObsidian",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "plateObsidian",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 21, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "plateObsidian",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "plateObsidian");
        addShapedRecipe(
                getModItem(RemoteIO.ID, "intelligentWorkbench", 1, 0, missing),
                null,
                getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing),
                null,
                "screwTitanium",
                ItemList.Casing_RobustTungstenSteel.get(1L),
                "screwTitanium",
                null,
                "craftingToolScrewdriver",
                null);
        addShapelessRecipe(
                getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing),
                getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing));
        addShapedRecipe(
                getModItem(RemoteIO.ID, "item.io_tool", 1, 0, missing),
                "plateTungstenSteel",
                "craftingToolSaw",
                "plateTungstenSteel",
                "screwTungstenSteel",
                "stickTungstenSteel",
                "screwTungstenSteel",
                "craftingToolScrewdriver",
                "stickTungstenSteel",
                "craftingToolFile");
        addShapedRecipe(
                getModItem(RemoteIO.ID, "item.linker", 1, 0, missing),
                "craftingToolScrewdriver",
                "boltElectrum",
                "screwIron",
                "boltElectrum",
                "lensEnderEye",
                "ringSteel",
                "screwIron",
                "ringSteel",
                getModItem(RemoteIO.ID, "item.io_tool", 1, 0, missing));
        addShapedRecipe(
                getModItem(RemoteIO.ID, "item.remoteAccessor", 1, 0, missing),
                "itemCasingTungstenSteel",
                getModItem(RemoteIO.ID, "tile.remote_interface", 1, 0, missing),
                "itemCasingTungstenSteel",
                getModItem(RemoteIO.ID, "item.linker", 1, 0, missing),
                getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing),
                getModItem(RemoteIO.ID, "item.linker", 1, 0, missing),
                "screwTungstenSteel",
                getModItem(RemoteIO.ID, "item.wireless_transmitter", 1, 0, missing),
                "screwTungstenSteel");
        addShapedRecipe(
                getModItem(RemoteIO.ID, "item.pda", 1, 0, missing),
                "screwIron",
                "itemCasingAluminium",
                "screwIron",
                "circuitBasic",
                getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing),
                "circuitBasic",
                "itemCasingAluminium",
                createItemStack(GregTech.ID, "gt.metaitem.01", 1, 32518, "{GT.ItemCharge:100000L}", missing),
                "itemCasingAluminium");

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(WirelessRedstoneCBELogic.ID, "wirelessLogic", 1, 0, missing),
                        getModItem(WirelessRedstoneCBELogic.ID, "wirelessLogic", 1, 1, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.wireless_transmitter", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1000)).noFluidOutputs().duration(600)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 1, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.blank_plate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Data.get(2L), ItemList.Circuit_Elite.get(2L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Data.get(2L), ItemList.Circuit_Elitenanocomputer.get(2L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Data.get(2L), ItemList.Circuit_Quantumcomputer.get(2L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Data.get(2L), ItemList.Circuit_Crystalprocessor.get(2L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Nanocomputer.get(2L), ItemList.Circuit_Elite.get(2L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Nanocomputer.get(2L), ItemList.Circuit_Elitenanocomputer.get(2L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Nanocomputer.get(2L), ItemList.Circuit_Quantumcomputer.get(2L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Nanocomputer.get(2L), ItemList.Circuit_Crystalprocessor.get(2L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Quantumprocessor.get(2L), ItemList.Circuit_Elite.get(2L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Quantumprocessor.get(2L), ItemList.Circuit_Elitenanocomputer.get(2L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Quantumprocessor.get(2L), ItemList.Circuit_Quantumcomputer.get(2L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Circuit_Quantumprocessor.get(2L), ItemList.Circuit_Crystalprocessor.get(2L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.BlankPlatedChip", 1, 0, missing),
                        getModItem(EnderStorage.ID, "enderChest", 1, 0, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.transfer", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.BlankPlatedChip", 1, 0, missing),
                        getModItem(EnderStorage.ID, "enderChest", 1, 4096, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.transfer", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.BlankPlatedChip", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockJar", 2, 0, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.transfer", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.BlankPlatedChip", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.cableGt01, Materials.BlackSteel, 2L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.transfer", 1, 10, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.BlankPlatedChip", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "extractor_base", 2, 12, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.transfer", 1, 12, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.BlankPlatedChip", 1, 0, missing),
                        getModItem(AppliedEnergistics2.ID, "tile.BlockController", 1, 0, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.transfer", 1, 20, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.BlankPlatedChip", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.wireGt02, Materials.RedAlloy, 2L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.transfer", 1, 21, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.BlankPlatedChip", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Enderium, 4L))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.upgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.BlankPlatedChip", 1, 0, missing),
                        getModItem(RemoteIO.ID, "item.wireless_transmitter", 1, 0, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.upgrade", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);

    }
}
