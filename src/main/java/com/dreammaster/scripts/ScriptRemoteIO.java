package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptRemoteIO implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Remote IO";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.RemoteIO.ID, Mods.TinkerConstruct.ID, "WR-CBE|Logic");
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("RIO", "tile.remote_interface", 2, 0, missing),
                new Object[] { getModItem("gregtech", "gt.blockmachines", 1, 9275, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32693, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 9275, missing), "circuitElite",
                        getModItem("gregtech", "gt.blockmachines", 1, 1541, missing), "circuitElite",
                        getModItem("gregtech", "gt.blockmachines", 1, 9275, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32683, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 9275, missing) });
        addShapelessCraftingRecipe(
                getModItem("RIO", "tile.remote_interface", 1, 0, missing),
                new Object[] { getModItem("RandomThings", "playerinterface", 1, 0, missing) });
        addShapedRecipe(
                getModItem("RIO", "tile.machine", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32613, missing), "pipeMediumTitanium",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32613, missing), "pipeMediumTitanium",
                        getModItem("gregtech", "gt.blockcasings", 1, 3, missing), "pipeMediumTitanium",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32613, missing), "pipeMediumTitanium",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32613, missing) });
        addShapedRecipe(
                getModItem("RIO", "tile.machine", 1, 1, missing),
                new Object[] { getModItem("IC2", "itemRecipePart", 1, 0, missing),
                        getModItem("IC2", "itemRecipePart", 1, 0, missing),
                        getModItem("IC2", "itemRecipePart", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32613, missing),
                        getModItem("gregtech", "gt.blockcasings", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32613, missing), "plateTitanium", "plateTitanium",
                        "plateTitanium" });
        addShapedRecipe(
                getModItem("RIO", "skylight", 1, 0, missing),
                new Object[] { "plateObsidian", getModItem("TConstruct", "GlassPane", 1, 0, missing), "plateObsidian",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("ProjRed|Integration", "projectred.integration.gate", 1, 21, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "plateObsidian",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "plateObsidian" });
        addShapedRecipe(
                getModItem("RIO", "intelligentWorkbench", 1, 0, missing),
                new Object[] { null, getModItem("RIO", "item.chip.location", 1, 0, missing), null, "screwTitanium",
                        getModItem("gregtech", "gt.blockcasings4", 1, 0, missing), "screwTitanium", null,
                        "craftingToolScrewdriver", null });
        addShapelessCraftingRecipe(
                getModItem("RIO", "item.chip.location", 1, 0, missing),
                new Object[] { getModItem("RIO", "item.chip.location", 1, 0, missing) });
        addShapedRecipe(
                getModItem("RIO", "item.io_tool", 1, 0, missing),
                new Object[] { "plateTungstenSteel", "craftingToolSaw", "plateTungstenSteel", "screwTungstenSteel",
                        "stickTungstenSteel", "screwTungstenSteel", "craftingToolScrewdriver", "stickTungstenSteel",
                        "craftingToolFile" });
        addShapedRecipe(
                getModItem("RIO", "item.linker", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", "boltElectrum", "screwIron", "boltElectrum", "lensEnderEye",
                        "ringSteel", "screwIron", "ringSteel", getModItem("RIO", "item.io_tool", 1, 0, missing) });
        addShapedRecipe(
                getModItem("RIO", "item.remoteAccessor", 1, 0, missing),
                new Object[] { "itemCasingTungstenSteel", getModItem("RIO", "tile.remote_interface", 1, 0, missing),
                        "itemCasingTungstenSteel", getModItem("RIO", "item.linker", 1, 0, missing),
                        getModItem("RIO", "item.chip.location", 1, 0, missing),
                        getModItem("RIO", "item.linker", 1, 0, missing), "screwTungstenSteel",
                        getModItem("RIO", "item.wireless_transmitter", 1, 0, missing), "screwTungstenSteel" });
        addShapedRecipe(
                getModItem("RIO", "item.pda", 1, 0, missing),
                new Object[] { "screwIron", "itemCasingAluminium", "screwIron", "circuitBasic",
                        getModItem("dreamcraft", "item.Display", 1, 0, missing), "circuitBasic", "itemCasingAluminium",
                        createItemStack("gregtech", "gt.metaitem.01", 1, 32518, "{GT.ItemCharge:100000L}", missing),
                        "itemCasingAluminium" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("WR-CBE|Logic", "wirelessLogic", 1, 0, missing),
                        getModItem("WR-CBE|Logic", "wirelessLogic", 1, 1, missing))
                .itemOutputs(getModItem("RIO", "item.wireless_transmitter", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 1000)).noFluidOutputs().duration(600)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "blankPattern", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17316, missing))
                .itemOutputs(getModItem("RIO", "item.blank_plate", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(200)
                .eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 32704, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32705, missing))
                .itemOutputs(getModItem("RIO", "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 32704, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32084, missing))
                .itemOutputs(getModItem("RIO", "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 32704, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32086, missing))
                .itemOutputs(getModItem("RIO", "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 2, 32704, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32089, missing))
                .itemOutputs(getModItem("RIO", "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.03", 2, 32083, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32705, missing))
                .itemOutputs(getModItem("RIO", "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.03", 2, 32083, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32084, missing))
                .itemOutputs(getModItem("RIO", "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.03", 2, 32083, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32086, missing))
                .itemOutputs(getModItem("RIO", "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.03", 2, 32083, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32089, missing))
                .itemOutputs(getModItem("RIO", "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.03", 2, 32085, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32705, missing))
                .itemOutputs(getModItem("RIO", "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.03", 2, 32085, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32084, missing))
                .itemOutputs(getModItem("RIO", "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.03", 2, 32085, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32086, missing))
                .itemOutputs(getModItem("RIO", "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.03", 2, 32085, missing),
                        getModItem("gregtech", "gt.metaitem.03", 2, 32089, missing))
                .itemOutputs(getModItem("RIO", "item.chip.location", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.BlankPlatedChip", 1, 0, missing),
                        getModItem("EnderStorage", "enderChest", 1, 0, missing))
                .itemOutputs(getModItem("RIO", "item.chip.transfer", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.BlankPlatedChip", 1, 0, missing),
                        getModItem("EnderStorage", "enderChest", 1, 4096, missing))
                .itemOutputs(getModItem("RIO", "item.chip.transfer", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.BlankPlatedChip", 1, 0, missing),
                        getModItem("Thaumcraft", "blockJar", 2, 0, missing))
                .itemOutputs(getModItem("RIO", "item.chip.transfer", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.BlankPlatedChip", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 1546, missing))
                .itemOutputs(getModItem("RIO", "item.chip.transfer", 1, 10, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.BlankPlatedChip", 1, 0, missing),
                        getModItem("ExtraUtilities", "extractor_base", 2, 12, missing))
                .itemOutputs(getModItem("RIO", "item.chip.transfer", 1, 12, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.BlankPlatedChip", 1, 0, missing),
                        getModItem("appliedenergistics2", "tile.BlockController", 1, 0, missing))
                .itemOutputs(getModItem("RIO", "item.chip.transfer", 1, 20, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.BlankPlatedChip", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 2, 2001, missing))
                .itemOutputs(getModItem("RIO", "item.chip.transfer", 1, 21, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.BlankPlatedChip", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 17321, missing))
                .itemOutputs(getModItem("RIO", "item.chip.upgrade", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.BlankPlatedChip", 1, 0, missing),
                        getModItem("RIO", "item.wireless_transmitter", 1, 0, missing))
                .itemOutputs(getModItem("RIO", "item.chip.upgrade", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(480).addTo(sAssemblerRecipes);

    }
}
