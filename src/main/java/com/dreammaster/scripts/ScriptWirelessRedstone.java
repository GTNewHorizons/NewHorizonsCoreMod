package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sChemicalRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;

public class ScriptWirelessRedstone implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Wireless Redstone";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList("WR-CBE|Core", "WR-CBE|Addons");
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("WR-CBE|Core", "stoneBowl", 1, 0, missing),
                new Object[] { "plateStone", null, "plateStone", "plateStone", "craftingToolHardHammer", "plateStone",
                        "plateStone", "plateStone", "plateStone" });
        addShapedRecipe(
                getModItem("WR-CBE|Addons", "remote", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver",
                        getModItem("WR-CBE|Core", "wirelessTransceiver", 1, 0, missing), "craftingToolFile",
                        "circuitAdvanced", getModItem("dreamcraft", "item.Display", 1, 0, missing), "circuitAdvanced",
                        "itemCasingTungstenSteel", "screwTungstenSteel", "itemCasingTungstenSteel" });
        addShapedRecipe(
                getModItem("WR-CBE|Addons", "sniffer", 1, 0, missing),
                new Object[] { getModItem("WR-CBE|Core", "recieverDish", 1, 0, missing),
                        getModItem("WR-CBE|Core", "wirelessTransceiver", 1, 0, missing),
                        getModItem("WR-CBE|Core", "recieverDish", 1, 0, missing), "itemCasingTungstenSteel",
                        "stickTungstenSteel", "itemCasingTungstenSteel",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 0, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 0, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 0, missing) });
        addShapedRecipe(
                getModItem("WR-CBE|Addons", "psniffer", 1, 0, missing),
                new Object[] { getModItem("WR-CBE|Core", "blazeRecieverDish", 1, 0, missing),
                        getModItem("WR-CBE|Core", "blazeTransceiver", 1, 0, missing),
                        getModItem("WR-CBE|Core", "blazeRecieverDish", 1, 0, missing), "itemCasingTungstenSteel",
                        "stickTungstenSteel", "itemCasingTungstenSteel",
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 0, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 0, missing),
                        getModItem("ProjRed|Core", "projectred.core.part", 1, 0, missing) });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 23316, missing),
                        getModItem("WR-CBE|Core", "retherPearl", 1, 0, missing))
                .itemOutputs(getModItem("WR-CBE|Core", "wirelessTransceiver", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "blaze_rod", 1, 0, missing),
                        getModItem("WR-CBE|Core", "retherPearl", 1, 0, missing))
                .itemOutputs(getModItem("WR-CBE|Core", "blazeTransceiver", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("WR-CBE|Core", "stoneBowl", 1, 0, missing),
                        getModItem("WR-CBE|Core", "wirelessTransceiver", 1, 0, missing))
                .itemOutputs(getModItem("WR-CBE|Core", "recieverDish", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 250)).noFluidOutputs().duration(600).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("WR-CBE|Core", "stoneBowl", 1, 0, missing),
                        getModItem("WR-CBE|Core", "blazeTransceiver", 1, 0, missing))
                .itemOutputs(getModItem("WR-CBE|Core", "blazeRecieverDish", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 250)).noFluidOutputs().duration(600).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 3, 0, missing),
                        getModItem("WR-CBE|Core", "wirelessTransceiver", 1, 0, missing))
                .itemOutputs(getModItem("WR-CBE|Logic", "wirelessLogic", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 500)).noFluidOutputs().duration(600).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 3, 0, missing),
                        getModItem("WR-CBE|Core", "recieverDish", 1, 0, missing))
                .itemOutputs(getModItem("WR-CBE|Logic", "wirelessLogic", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 500)).noFluidOutputs().duration(600).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ProjRed|Core", "projectred.core.part", 3, 0, missing),
                        getModItem("WR-CBE|Core", "blazeTransceiver", 1, 0, missing))
                .itemOutputs(getModItem("WR-CBE|Logic", "wirelessLogic", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 250)).noFluidOutputs().duration(600).eut(256)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "compass", 1, 0, missing),
                        getModItem("WR-CBE|Core", "wirelessTransceiver", 1, 0, missing))
                .itemOutputs(getModItem("WR-CBE|Addons", "triangulator", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("WR-CBE|Addons", "triangulator", 1, 0, missing),
                        getModItem("minecraft", "paper", 8, 0, missing))
                .itemOutputs(getModItem("WR-CBE|Addons", "map", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(300).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 3, 17804, missing),
                        getModItem("WR-CBE|Core", "wirelessTransceiver", 1, 0, missing))
                .itemOutputs(getModItem("WR-CBE|Addons", "tracker", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("WR-CBE|Core", "blazeTransceiver", 2, 0, missing),
                        getModItem("WR-CBE|Core", "retherPearl", 2, 0, missing))
                .itemOutputs(getModItem("WR-CBE|Addons", "rep", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("obsidian.molten", 1440)).noFluidOutputs().duration(600)
                .eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "ender_pearl", 1, 0, missing),
                        getModItem("minecraft", "glowstone_dust", 1, 0, missing))
                .itemOutputs(getModItem("WR-CBE|Core", "retherPearl", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(1200)
                .eut(30).addTo(sChemicalRecipes);

    }
}
