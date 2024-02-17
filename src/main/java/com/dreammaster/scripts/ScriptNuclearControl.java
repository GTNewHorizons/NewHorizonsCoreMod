package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.IC2NuclearControl;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_OreDictUnificator;

public class ScriptNuclearControl implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "NuclearControl";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(IC2NuclearControl.ID, AppliedEnergistics2.ID, IndustrialCraft2.ID, Natura.ID);
    }

    @Override
    public void loadRecipes() {
        final ItemStack NC2_REMOTE_SENSOR_KIT = getModItem(IC2NuclearControl.ID, "ItemRemoteSensorKit", 1, 0);
        final ItemStack NC2_PANEL_MEMORY_CARD = getModItem(IC2NuclearControl.ID, "ItemPanelMemoryCard", 1, 0);

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        NC2_REMOTE_SENSOR_KIT,
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 2),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2))
                .itemOutputs(NC2_PANEL_MEMORY_CARD).duration(10 * SECONDS).eut(16).addTo(assemblerRecipes);

        addShapelessRecipe(ItemList.Color_04.get(1L), getModItem(Natura.ID, "Bluebells", 1, 0, missing));
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 0, missing),
                "glassReinforced",
                "glassReinforced",
                "glassReinforced",
                "plateDenseLead",
                ItemList.Cover_Screen.get(1L),
                "plateDenseLead",
                "circuitAdvanced",
                ItemList.Cover_ActivityDetector.get(1L),
                "circuitAdvanced");
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 1, missing),
                "glassReinforced",
                getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 0, missing),
                "glassReinforced",
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 2, missing),
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                "cableGt01Gold",
                ItemList.Hull_Bronze.get(1L),
                "cableGt01Gold");
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 2, missing),
                "plateIron",
                getModItem(Minecraft.ID, "noteblock", 1, 0, missing),
                "plateIron",
                "circuitBasic",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                "circuitBasic",
                "cableGt01RedAlloy",
                getModItem(IndustrialCraft2.ID, "blockMachine", 1, 0, missing),
                "cableGt01RedAlloy");
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 3, missing),
                ItemList.Sensor_LV.get(1L),
                "glassReinforced",
                ItemList.Emitter_LV.get(1L),
                ItemList.Cover_Screen.get(1L),
                ItemList.Casing_SolidSteel.get(1L),
                ItemList.Cover_Screen.get(1L),
                "circuitBasic",
                getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 0, missing),
                "circuitBasic");
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 4, missing),
                ItemList.Cover_Screen.get(1L),
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 5, missing),
                ItemList.Cover_Screen.get(1L),
                "circuitBasic",
                getModItem(IndustrialCraft2.ID, "blockMachine", 1, 0, missing),
                "circuitBasic",
                "plateIron",
                "cableGt01RedAlloy",
                "plateIron");
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 5, missing),
                ItemList.Cover_Screen.get(1L),
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 5, missing),
                ItemList.Cover_Screen.get(1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "cableGt01RedAlloy",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 6, missing),
                "plateIron",
                ItemList.Cover_Screen.get(1L),
                "plateIron",
                "cableGt01Platinum",
                ItemList.Transformer_IV_EV.get(1L),
                "cableGt01Platinum",
                "plateIron",
                "circuitAdvanced",
                "plateIron");
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 7, missing),
                "plateLead",
                ItemList.Cover_Screen.get(1L),
                "plateLead",
                "cableGt01Platinum",
                ItemList.Transformer_IV_EV.get(1L),
                "cableGt01Platinum",
                "plateLead",
                "circuitAdvanced",
                "plateLead");
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 8, missing),
                "plateSteel",
                ItemList.Cover_Screen.get(1L),
                "plateSteel",
                "cableGt01Platinum",
                getModItem(IndustrialCraft2.ID, "blockMachine", 1, 12, missing),
                "cableGt01Platinum",
                "circuitAdvanced",
                getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing),
                "circuitAdvanced");
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 9, missing),
                getModItem(IC2NuclearControl.ID, "ItemUpgrade", 1, 0, missing),
                getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 4, missing),
                getModItem(IC2NuclearControl.ID, "ItemUpgrade", 1, 1, missing),
                "plateAlloyCarbon",
                "circuitAdvanced",
                "plateAlloyCarbon",
                "craftingToolWrench",
                "craftingToolHardHammer",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 10, missing),
                getModItem(IC2NuclearControl.ID, "ItemUpgrade", 1, 0, missing),
                getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 5, missing),
                getModItem(IC2NuclearControl.ID, "ItemUpgrade", 1, 1, missing),
                "plateAlloyCarbon",
                "plateSteel",
                "plateAlloyCarbon",
                "craftingToolWrench",
                "craftingToolHardHammer",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 0, missing),
                "paneGlassWhite",
                "paneGlassWhite",
                "paneGlassWhite",
                "paneGlassWhite",
                getModItem(Minecraft.ID, "redstone_lamp", 1, 0, missing),
                "paneGlassWhite",
                "paneGlassWhite",
                "wireGt01RedAlloy",
                "paneGlassWhite");
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 2, missing),
                "paneGlassOrange",
                "paneGlassOrange",
                "paneGlassOrange",
                "paneGlassOrange",
                getModItem(Minecraft.ID, "redstone_lamp", 1, 0, missing),
                "paneGlassOrange",
                "paneGlassOrange",
                "wireGt01RedAlloy",
                "paneGlassOrange");
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "ItemToolThermometer", 1, 0, missing),
                "stickIron",
                "plateGlass",
                null,
                "plateGlass",
                "cellMercury",
                "plateGlass",
                null,
                "plateGlass",
                "plateGlass");
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "ItemToolDigitalThermometer", 1, 0, missing),
                getModItem(IC2NuclearControl.ID, "ItemToolThermometer", 1, 0, missing),
                "plateGlass",
                null,
                "circuitGood",
                ItemList.Cover_Screen.get(1L),
                "circuitGood",
                null,
                "plateGlass",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 3, missing));
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "ItemUpgrade", 1, 1, missing),
                "dyeRed",
                "dyeYellow",
                "dyeGreen",
                "dyeWhite",
                "circuitAdvanced",
                "dyeMagenta",
                "dyeBlack",
                "dyeCyan",
                "dyeBlue");
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "networkLink", 1, 0, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23, missing),
                ItemList.Cover_Screen.get(1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 23, missing),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 0, missing),
                ItemList.Casing_SolidSteel.get(1L),
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 0, missing),
                "plateAluminium",
                getModItem(Minecraft.ID, "comparator", 1, 0, missing),
                "plateAluminium");
        addShapedRecipe(
                getModItem(IC2NuclearControl.ID, "remoteMonitor", 1, 0, missing),
                "cableGt01Tin",
                CustomItemList.Display.get(1L),
                "cableGt01Tin",
                getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing),
                getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 5, missing),
                getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing),
                "plateAlloyCarbon",
                getModItem(IC2NuclearControl.ID, "ItemUpgrade", 1, 0, missing),
                "plateAlloyCarbon");

        GT_Values.RA.stdBuilder() // Remote Sensor Kit
                .itemInputs(
                        getModItem(IC2NuclearControl.ID, "ItemToolDigitalThermometer", 1, wildcard, missing),
                        getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "ItemRemoteSensorKit", 1, 0, missing))
                .duration(80 * SECONDS).eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder() // Energy Sensor Kit
                .itemInputs(
                        ItemList.Cover_EnergyDetector.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "ItemEnergySensorKit", 1, 0, missing))
                .duration(80 * SECONDS).eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder() // Counter Sensor Kit
                .itemInputs(
                        ItemList.Cover_ActivityDetector.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "ItemMultipleSensorKit", 1, 0, missing))
                .duration(80 * SECONDS).eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder() // Liquid Sensor Kit
                .itemInputs(
                        ItemList.Cover_FluidDetector.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "ItemMultipleSensorKit", 1, 1, missing))
                .duration(80 * SECONDS).eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder() // Generator Sensor Kit
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 2, missing),
                        getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "ItemMultipleSensorKit", 1, 2, missing))
                .duration(80 * SECONDS).eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder() // Applied Energistics Monitor Kit
                .itemInputs(
                        getModItem(AppliedEnergistics2.ID, "item.ItemMultiPart", 1, 400, missing),
                        getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "KitAppeng", 1, 0, missing)).duration(140 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder() // Time Card
                .itemInputs(
                        getModItem(Minecraft.ID, "clock", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "ItemTimeCard", 1, 0, missing)).duration(80 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder() // Text Card
                .itemInputs(ItemList.Cover_Screen.get(1L), getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "ItemTextCard", 1, 0, missing)).duration(80 * SECONDS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder() // Vanillia Kit
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPartCircuit", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "ItemVanilliaKit", 1, 0, missing)).duration(80 * SECONDS)
                .eut(2).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder() // Color upgrade
                .itemInputs(
                        new ItemStack(Items.dye, 1, 1),
                        new ItemStack(Items.dye, 1, 2),
                        new ItemStack(Items.dye, 1, 4),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "ItemUpgrade", 1, 1, missing)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_HV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder() // Range upgrade
                .itemInputs(ItemList.Sensor_LV.get(1L), getModItem(IndustrialCraft2.ID, "itemFreq", 1, 0, missing))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "ItemUpgrade", 1, 0, missing)).duration(80 * SECONDS)
                .eut(2).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder() // Industria lInformation Panel
                .itemInputs(
                        ItemList.Cover_Screen.get(1L),
                        new ItemStack(Blocks.stained_glass_pane, 1, 5),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Basic, 2L),
                        getModItem(IndustrialCraft2.ID, "blockMachine", 1, 0, missing))
                .fluidInputs(Materials.RedAlloy.getMolten(72L))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 4, missing))
                .duration(20 * SECONDS).eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder() // Industrial Panel Extender
                .itemInputs(
                        ItemList.Cover_Screen.get(1L),
                        new ItemStack(Blocks.stained_glass_pane, 1, 5),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 3L))
                .fluidInputs(Materials.RedAlloy.getMolten(72L))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 5, missing))
                .duration(20 * SECONDS).eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder() // Advanced Information Panel
                .itemInputs(
                        getModItem(IC2NuclearControl.ID, "ItemUpgrade", 1, 0, missing),
                        getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 4, missing),
                        getModItem(IC2NuclearControl.ID, "ItemUpgrade", 1, 1, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 1),
                        GT_OreDictUnificator.get(OrePrefixes.circuit, Materials.Advanced, 1L))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 9, missing))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder() // Advanced Panel Extender
                .itemInputs(
                        getModItem(IC2NuclearControl.ID, "ItemUpgrade", 1, 0, missing),
                        getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 5, missing),
                        getModItem(IC2NuclearControl.ID, "ItemUpgrade", 1, 1, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plateAlloy, Materials.Carbon, 1),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "blockNuclearControlMain", 1, 10, missing))
                .duration(20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        GT_Values.RA.stdBuilder() // White Lamp
                .itemInputs(new ItemStack(Blocks.stained_glass_pane, 4, 0), new ItemStack(Blocks.redstone_lamp, 1, 0))
                .fluidInputs(Materials.RedAlloy.getMolten(72L))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 0, missing))
                .duration(2 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder() // Orange Lamp
                .itemInputs(new ItemStack(Blocks.stained_glass_pane, 4, 1), new ItemStack(Blocks.redstone_lamp, 1, 0))
                .fluidInputs(Materials.RedAlloy.getMolten(72L))
                .itemOutputs(getModItem(IC2NuclearControl.ID, "blockNuclearControlLight", 1, 2, missing))
                .duration(2 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

    }
}
