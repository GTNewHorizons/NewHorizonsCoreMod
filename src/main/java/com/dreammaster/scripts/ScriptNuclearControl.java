package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.IC2NuclearControl;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Collections;
import java.util.List;

import net.minecraft.item.ItemStack;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;

public class ScriptNuclearControl implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "NuclearControl";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList(IC2NuclearControl.ID);
    }

    @Override
    public void loadRecipes() {
        final ItemStack NC2_REMOTE_SENSOR_KIT = getModItem(IC2NuclearControl.ID, "ItemRemoteSensorKit", 1, 0);
        final ItemStack NC2_PANEL_MEMORY_CARD = getModItem(IC2NuclearControl.ID, "ItemPanelMemoryCard", 1, 0);

        GT_Values.RA.addAssemblerRecipe(
                new ItemStack[] { NC2_REMOTE_SENSOR_KIT,
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2) },
                GT_Values.NF,
                NC2_PANEL_MEMORY_CARD,
                200,
                16);

        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32418, missing),
                new Object[] { getModItem("Natura", "Bluebells", 1, 0, missing) });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "blockNuclearControlMain", 1, 0, missing),
                new Object[] { "glassReinforced", "glassReinforced", "glassReinforced", "plateDenseLead",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing), "plateDenseLead",
                        "circuitAdvanced", getModItem("gregtech", "gt.metaitem.01", 1, 32731, missing),
                        "circuitAdvanced" });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "blockNuclearControlMain", 1, 1, missing),
                new Object[] { "glassReinforced",
                        getModItem("IC2NuclearControl", "blockNuclearControlLight", 1, 0, missing), "glassReinforced",
                        getModItem("minecraft", "repeater", 1, 0, missing),
                        getModItem("IC2NuclearControl", "blockNuclearControlMain", 1, 2, missing),
                        getModItem("minecraft", "repeater", 1, 0, missing), "cableGt01Gold",
                        getModItem("gregtech", "gt.blockmachines", 1, 1, missing), "cableGt01Gold" });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "blockNuclearControlMain", 1, 2, missing),
                new Object[] { "plateIron", getModItem("minecraft", "noteblock", 1, 0, missing), "plateIron",
                        "circuitBasic", getModItem("IC2", "itemRecipePart", 1, 0, missing), "circuitBasic",
                        "cableGt01RedAlloy", getModItem("IC2", "blockMachine", 1, 0, missing), "cableGt01RedAlloy" });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "blockNuclearControlMain", 1, 3, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32690, missing), "glassReinforced",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32680, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing),
                        getModItem("gregtech", "gt.blockcasings2", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing), "circuitBasic",
                        getModItem("IC2NuclearControl", "blockNuclearControlMain", 1, 0, missing), "circuitBasic" });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "blockNuclearControlMain", 1, 4, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing),
                        getModItem("minecraft", "stained_glass_pane", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing), "circuitBasic",
                        getModItem("IC2", "blockMachine", 1, 0, missing), "circuitBasic", "plateIron",
                        "cableGt01RedAlloy", "plateIron" });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "blockNuclearControlMain", 1, 5, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing),
                        getModItem("minecraft", "stained_glass_pane", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "cableGt01RedAlloy",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing) });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "blockNuclearControlMain", 1, 6, missing),
                new Object[] { "plateIron", getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing), "plateIron",
                        "cableGt01Platinum", getModItem("gregtech", "gt.blockmachines", 1, 24, missing),
                        "cableGt01Platinum", "plateIron", "circuitAdvanced", "plateIron" });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "blockNuclearControlMain", 1, 7, missing),
                new Object[] { "plateLead", getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing), "plateLead",
                        "cableGt01Platinum", getModItem("gregtech", "gt.blockmachines", 1, 24, missing),
                        "cableGt01Platinum", "plateLead", "circuitAdvanced", "plateLead" });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "blockNuclearControlMain", 1, 8, missing),
                new Object[] { "plateSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing), "plateSteel",
                        "cableGt01Platinum", getModItem("IC2", "blockMachine", 1, 12, missing), "cableGt01Platinum",
                        "circuitAdvanced", getModItem("IC2", "itemFreq", 1, 0, missing), "circuitAdvanced" });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "blockNuclearControlMain", 1, 9, missing),
                new Object[] { getModItem("IC2NuclearControl", "ItemUpgrade", 1, 0, missing),
                        getModItem("IC2NuclearControl", "blockNuclearControlMain", 1, 4, missing),
                        getModItem("IC2NuclearControl", "ItemUpgrade", 1, 1, missing), "plateAlloyCarbon",
                        "circuitAdvanced", "plateAlloyCarbon", "craftingToolWrench", "craftingToolHardHammer",
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "blockNuclearControlMain", 1, 10, missing),
                new Object[] { getModItem("IC2NuclearControl", "ItemUpgrade", 1, 0, missing),
                        getModItem("IC2NuclearControl", "blockNuclearControlMain", 1, 5, missing),
                        getModItem("IC2NuclearControl", "ItemUpgrade", 1, 1, missing), "plateAlloyCarbon", "plateSteel",
                        "plateAlloyCarbon", "craftingToolWrench", "craftingToolHardHammer",
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "blockNuclearControlLight", 1, 0, missing),
                new Object[] { "paneGlassWhite", "paneGlassWhite", "paneGlassWhite", "paneGlassWhite",
                        getModItem("minecraft", "redstone_lamp", 1, 0, missing), "paneGlassWhite", "paneGlassWhite",
                        "wireGt01RedAlloy", "paneGlassWhite" });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "blockNuclearControlLight", 1, 2, missing),
                new Object[] { "paneGlassOrange", "paneGlassOrange", "paneGlassOrange", "paneGlassOrange",
                        getModItem("minecraft", "redstone_lamp", 1, 0, missing), "paneGlassOrange", "paneGlassOrange",
                        "wireGt01RedAlloy", "paneGlassOrange" });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "ItemToolThermometer", 1, 0, missing),
                new Object[] { "stickIron", "plateGlass", null, "plateGlass", "cellMercury", "plateGlass", null,
                        "plateGlass", "plateGlass" });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "ItemToolDigitalThermometer", 1, 0, missing),
                new Object[] { getModItem("IC2NuclearControl", "ItemToolThermometer", 1, 0, missing), "plateGlass",
                        null, getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32702, missing), null, "plateGlass",
                        getModItem("IC2", "itemRecipePart", 1, 3, missing) });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "ItemUpgrade", 1, 1, missing),
                new Object[] { "dyeRed", "dyeYellow", "dyeGreen", "dyeWhite", "circuitAdvanced", "dyeMagenta",
                        "dyeBlack", "dyeCyan", "dyeBlue" });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "networkLink", 1, 0, missing),
                new Object[] { getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 23, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 23, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 0, missing),
                        getModItem("gregtech", "gt.blockcasings2", 1, 0, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 0, missing), "plateAluminium",
                        getModItem("minecraft", "comparator", 1, 0, missing), "plateAluminium" });
        addShapedRecipe(
                getModItem("IC2NuclearControl", "remoteMonitor", 1, 0, missing),
                new Object[] { "cableGt01Tin", getModItem("dreamcraft", "item.Display", 1, 0, missing), "cableGt01Tin",
                        getModItem("IC2", "itemFreq", 1, 0, missing),
                        getModItem("IC2NuclearControl", "blockNuclearControlMain", 1, 5, missing),
                        getModItem("IC2", "itemFreq", 1, 0, missing), "plateAlloyCarbon",
                        getModItem("IC2NuclearControl", "ItemUpgrade", 1, 0, missing), "plateAlloyCarbon" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2NuclearControl", "ItemToolDigitalThermometer", 1, 32767, missing),
                        getModItem("IC2", "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem("IC2NuclearControl", "ItemRemoteSensorKit", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32734, missing),
                        getModItem("IC2", "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem("IC2NuclearControl", "ItemEnergySensorKit", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32731, missing),
                        getModItem("IC2", "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem("IC2NuclearControl", "ItemMultipleSensorKit", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32732, missing),
                        getModItem("IC2", "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem("IC2NuclearControl", "ItemMultipleSensorKit", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "upgradeModule", 1, 2, missing),
                        getModItem("IC2", "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem("IC2NuclearControl", "ItemMultipleSensorKit", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 400, missing),
                        getModItem("IC2", "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem("IC2NuclearControl", "KitAppeng", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(2800).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "clock", 1, 0, missing),
                        getModItem("IC2", "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem("IC2NuclearControl", "ItemTimeCard", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32690, missing),
                        getModItem("IC2", "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem("IC2NuclearControl", "ItemUpgrade", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 32740, missing),
                        getModItem("IC2", "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem("IC2NuclearControl", "ItemTextCard", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(2).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing),
                        getModItem("IC2", "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem("IC2NuclearControl", "ItemVanilliaKit", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(2).addTo(sAssemblerRecipes);

    }
}
