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
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;

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
                new Object[] { getModItem(GregTech.ID, "gt.blockmachines", 1, 9275, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32693, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 9275, missing), "circuitElite",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 1541, missing), "circuitElite",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 9275, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32683, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 9275, missing) });
        addShapelessCraftingRecipe(
                getModItem(RemoteIO.ID, "tile.remote_interface", 1, 0, missing),
                new Object[] { getModItem(RandomThings.ID, "playerinterface", 1, 0, missing) });
        addShapedRecipe(
                getModItem(RemoteIO.ID, "tile.machine", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 32613, missing), "pipeMediumTitanium",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32613, missing), "pipeMediumTitanium",
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 3, missing), "pipeMediumTitanium",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32613, missing), "pipeMediumTitanium",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32613, missing) });
        addShapedRecipe(
                getModItem(RemoteIO.ID, "tile.machine", 1, 1, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32613, missing),
                        getModItem(GregTech.ID, "gt.blockcasings", 1, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32613, missing), "plateTitanium", "plateTitanium",
                        "plateTitanium" });
        addShapedRecipe(
                getModItem(RemoteIO.ID, "skylight", 1, 0, missing),
                new Object[] { "plateObsidian", getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        "plateObsidian", getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 21, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "plateObsidian",
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "plateObsidian" });
        addShapedRecipe(
                getModItem(RemoteIO.ID, "intelligentWorkbench", 1, 0, missing),
                new Object[] { null, getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing), null,
                        "screwTitanium", getModItem(GregTech.ID, "gt.blockcasings4", 1, 0, missing), "screwTitanium",
                        null, "craftingToolScrewdriver", null });
        addShapelessCraftingRecipe(
                getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing),
                new Object[] { getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing) });
        addShapedRecipe(
                getModItem(RemoteIO.ID, "item.io_tool", 1, 0, missing),
                new Object[] { "plateTungstenSteel", "craftingToolSaw", "plateTungstenSteel", "screwTungstenSteel",
                        "stickTungstenSteel", "screwTungstenSteel", "craftingToolScrewdriver", "stickTungstenSteel",
                        "craftingToolFile" });
        addShapedRecipe(
                getModItem(RemoteIO.ID, "item.linker", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", "boltElectrum", "screwIron", "boltElectrum", "lensEnderEye",
                        "ringSteel", "screwIron", "ringSteel",
                        getModItem(RemoteIO.ID, "item.io_tool", 1, 0, missing) });
        addShapedRecipe(
                getModItem(RemoteIO.ID, "item.remoteAccessor", 1, 0, missing),
                new Object[] { "itemCasingTungstenSteel",
                        getModItem(RemoteIO.ID, "tile.remote_interface", 1, 0, missing), "itemCasingTungstenSteel",
                        getModItem(RemoteIO.ID, "item.linker", 1, 0, missing),
                        getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing),
                        getModItem(RemoteIO.ID, "item.linker", 1, 0, missing), "screwTungstenSteel",
                        getModItem(RemoteIO.ID, "item.wireless_transmitter", 1, 0, missing), "screwTungstenSteel" });
        addShapedRecipe(
                getModItem(RemoteIO.ID, "item.pda", 1, 0, missing),
                new Object[] { "screwIron", "itemCasingAluminium", "screwIron", "circuitBasic",
                        getModItem(NewHorizonsCoreMod.ID, "item.Display", 1, 0, missing), "circuitBasic",
                        "itemCasingAluminium",
                        createItemStack(GregTech.ID, "gt.metaitem.01", 1, 32518, "{GT.ItemCharge:100000L}", missing),
                        "itemCasingAluminium" });

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
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17316, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.blank_plate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32704, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32705, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32704, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32084, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32704, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32086, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32704, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32089, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32083, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32705, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32083, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32084, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32083, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32086, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32083, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32089, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32085, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 32705, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32085, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32084, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32085, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32086, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32085, missing),
                        getModItem(GregTech.ID, "gt.metaitem.03", 2, 32089, missing))
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
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 1546, missing))
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
                        getModItem(GregTech.ID, "gt.blockmachines", 2, 2001, missing))
                .itemOutputs(getModItem(RemoteIO.ID, "item.chip.transfer", 1, 21, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.BlankPlatedChip", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17321, missing))
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
