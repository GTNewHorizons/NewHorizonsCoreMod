package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.GraviSuiteNEO;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.ItemList;

public class ScriptGraviSuite implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Gravi Suite";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(GraviSuite.ID, GraviSuiteNEO.ID, IndustrialCraft2.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                getModItem(GregTech.ID, "gt.blockmachines", 1, 2380, missing),
                getModItem(GregTech.ID, "gt.blockmachines", 1, 2380, missing),
                getModItem(GregTech.ID, "gt.blockmachines", 1, 2380, missing),
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing));
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 1, missing),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                getModItem(GregTech.ID, "gt.blockmachines", 1, 2404, missing),
                "plateRhodium-PlatedPalladium",
                getModItem(GregTech.ID, "gt.blockmachines", 1, 2404, missing),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing));
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2, missing),
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1, missing),
                ItemList.Reactor_Coolant_NaK_3.get(1L),
                "plateColdCallistoIce",
                ItemList.Reactor_Coolant_NaK_3.get(1L),
                getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0, missing));
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2, missing),
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1, missing),
                ItemList.Reactor_Coolant_He_3.get(1L),
                "plateColdCallistoIce",
                ItemList.Reactor_Coolant_He_3.get(1L),
                getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0, missing));
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 4, missing),
                "plateDenseNeodymiumMagnetic",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                "plateDenseNeodymiumMagnetic",
                "plateDenseCopper",
                getModItem(GregTech.ID, "gt.blockmachines", 1, 2384, missing),
                "plateDenseCopper",
                "plateDenseNeodymiumMagnetic",
                getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                "plateDenseNeodymiumMagnetic");
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 5, missing),
                "craftingToolWrench",
                "plateCopper",
                "craftingToolHardHammer",
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                getModItem(GregTech.ID, "gt.blockmachines", 1, 2384, missing),
                ItemList.Transformer_EV_HV.get(1L),
                getModItem(GregTech.ID, "gt.blockmachines", 1, 2384, missing));
        addShapedRecipe(
                getModItem(GraviSuite.ID, "vajra", 1, 27, missing),
                getModItem(NewHorizonsCoreMod.ID, "item.EngravedEnergyChip", 1, 0, missing),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 4, missing),
                "lensReinforcedGlass",
                "plateAlloyCarbon",
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 5, missing),
                "plateAlloyCarbon",
                "plateAlloyIridium",
                "batteryMaster",
                "plateAlloyIridium");
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 6, missing),
                "itemCasingAluminium",
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                "itemCasingAluminium",
                "circuitAdvanced",
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                "circuitAdvanced",
                getModItem(IndustrialCraft2.ID, "reactorPlating", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "reactorPlating", 1, 0, missing));
        addShapedRecipe(
                getModItem(GraviSuite.ID, "ultimateLappack", 1, 27, missing),
                "itemCasingChrome",
                "batteryMaster",
                "itemCasingChrome",
                "batteryMaster",
                getModItem(GraviSuite.ID, "advLappack", 1, wildcard, missing),
                "batteryMaster",
                "circuitMaster",
                "wireGt16NiobiumTitanium",
                "circuitMaster");
        addShapedRecipe(
                getModItem(GraviSuiteNEO.ID, "epicLappack", 1, 27, missing),
                getModItem(NewHorizonsCoreMod.ID, "item.IridiumAlloyItemCasing", 1, 0, missing),
                ItemList.Energy_LapotronicOrb2.get(1L),
                getModItem(NewHorizonsCoreMod.ID, "item.IridiumAlloyItemCasing", 1, 0, missing),
                ItemList.Energy_LapotronicOrb2.get(1L),
                getModItem(GraviSuite.ID, "ultimateLappack", 1, wildcard, missing),
                ItemList.Energy_LapotronicOrb2.get(1L),
                "circuitUltimate",
                "wireGt16SuperconductorZPM",
                "circuitUltimate");
        addShapedRecipe(
                getModItem(GraviSuite.ID, "advChainsaw", 1, 27, missing),
                "screwTungstenSteel",
                "toolHeadChainsawTungstenSteel",
                "craftingToolScrewdriver",
                "gearGtSmallTungstenSteel",
                ItemList.Electric_Motor_HV.get(1L),
                "gearGtSmallTungstenSteel",
                "plateTungstenSteel",
                "batteryElite",
                "plateTungstenSteel");
        addShapedRecipe(
                createItemStack(GraviSuite.ID, "advDDrill", 1, 27, "{toolXP:0.0d,charge:0,toolMode:0}", missing),
                "screwIridium",
                getModItem(NewHorizonsCoreMod.ID, "item.ReinforcedIridiumDrillTip", 1, 0, missing),
                "craftingToolScrewdriver",
                "gearGtSmallIridium",
                ItemList.Electric_Motor_EV.get(1L),
                "gearGtSmallIridium",
                "plateAlloyIridium",
                "batteryMaster",
                "plateAlloyIridium");

    }
}
