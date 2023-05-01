package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.GraviSuiteNEO;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

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
                new Object[] { getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 2380, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 2380, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 2380, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 1, missing),
                new Object[] { getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                        getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                        getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 2404, missing), "plateRhodium-PlatedPalladium",
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 2404, missing),
                        getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                        getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                        getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.180k_NaK_Coolantcell", 1, 0, missing), "plateColdCallistoIce",
                        getModItem(GregTech.ID, "gt.180k_NaK_Coolantcell", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1, missing),
                        getModItem(GregTech.ID, "gt.180k_Helium_Coolantcell", 1, 0, missing), "plateColdCallistoIce",
                        getModItem(GregTech.ID, "gt.180k_Helium_Coolantcell", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 4, missing),
                new Object[] { "plateDenseNeodymiumMagnetic",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing), "plateDenseNeodymiumMagnetic",
                        "plateDenseCopper", getModItem(GregTech.ID, "gt.blockmachines", 1, 2384, missing),
                        "plateDenseCopper", "plateDenseNeodymiumMagnetic",
                        getModItem(IndustrialCraft2.ID, "itemRecipePart", 1, 0, missing),
                        "plateDenseNeodymiumMagnetic" });
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 5, missing),
                new Object[] { "craftingToolWrench", "plateCopper", "craftingToolHardHammer",
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 2384, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 23, missing),
                        getModItem(GregTech.ID, "gt.blockmachines", 1, 2384, missing) });
        addShapedRecipe(
                getModItem(GraviSuite.ID, "vajra", 1, 27, missing),
                new Object[] { getModItem(NewHorizonsCoreMod.ID, "item.EngravedEnergyChip", 1, 0, missing),
                        getModItem(GraviSuite.ID, "itemSimpleItem", 1, 4, missing), "lensReinforcedGlass",
                        "plateAlloyCarbon", getModItem(GraviSuite.ID, "itemSimpleItem", 1, 5, missing),
                        "plateAlloyCarbon", "plateAlloyIridium", "batteryMaster", "plateAlloyIridium" });
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 6, missing),
                new Object[] { "itemCasingAluminium", getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                        "itemCasingAluminium", "circuitAdvanced",
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing), "circuitAdvanced",
                        getModItem(IndustrialCraft2.ID, "reactorPlating", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "reactorPlating", 1, 0, missing) });
        addShapedRecipe(
                getModItem(GraviSuite.ID, "ultimateLappack", 1, 27, missing),
                new Object[] { "itemCasingChrome", "batteryMaster", "itemCasingChrome", "batteryMaster",
                        getModItem(GraviSuite.ID, "advLappack", 1, 32767, missing), "batteryMaster", "circuitMaster",
                        "wireGt16NiobiumTitanium", "circuitMaster" });
        addShapedRecipe(
                getModItem(GraviSuiteNEO.ID, "epicLappack", 1, 27, missing),
                new Object[] { getModItem(NewHorizonsCoreMod.ID, "item.IridiumAlloyItemCasing", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32599, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.IridiumAlloyItemCasing", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32599, missing),
                        getModItem(GraviSuite.ID, "ultimateLappack", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32599, missing), "circuitUltimate",
                        "wireGt16SuperconductorZPM", "circuitUltimate" });
        addShapedRecipe(
                getModItem(GraviSuite.ID, "advChainsaw", 1, 27, missing),
                new Object[] { "screwTungstenSteel", "toolHeadChainsawTungstenSteel", "craftingToolScrewdriver",
                        "gearGtSmallTungstenSteel", getModItem(GregTech.ID, "gt.metaitem.01", 1, 32602, missing),
                        "gearGtSmallTungstenSteel", "plateTungstenSteel", "batteryElite", "plateTungstenSteel" });
        addShapedRecipe(
                createItemStack(GraviSuite.ID, "advDDrill", 1, 27, "{toolXP:0.0d,charge:0,toolMode:0}", missing),
                new Object[] { "screwIridium",
                        getModItem(NewHorizonsCoreMod.ID, "item.ReinforcedIridiumDrillTip", 1, 0, missing),
                        "craftingToolScrewdriver", "gearGtSmallIridium",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 32603, missing), "gearGtSmallIridium",
                        "plateAlloyIridium", "batteryMaster", "plateAlloyIridium" });

    }
}
