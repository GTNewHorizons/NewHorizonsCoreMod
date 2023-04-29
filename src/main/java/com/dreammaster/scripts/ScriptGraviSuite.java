package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.Mods;

public class ScriptGraviSuite implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Gravi Suite";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.GraviSuite.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("GraviSuite", "itemSimpleItem", 1, 0, missing),
                new Object[] { getModItem("IC2", "itemPartAlloy", 1, 0, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("IC2", "itemPartAlloy", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 2380, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 2380, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 2380, missing),
                        getModItem("IC2", "itemPartAlloy", 1, 0, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("IC2", "itemPartAlloy", 1, 0, missing) });
        addShapedRecipe(
                getModItem("GraviSuite", "itemSimpleItem", 1, 1, missing),
                new Object[] { getModItem("GraviSuite", "itemSimpleItem", 1, 0, missing),
                        getModItem("GraviSuite", "itemSimpleItem", 1, 0, missing),
                        getModItem("GraviSuite", "itemSimpleItem", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 2404, missing), "plateRhodium-PlatedPalladium",
                        getModItem("gregtech", "gt.blockmachines", 1, 2404, missing),
                        getModItem("GraviSuite", "itemSimpleItem", 1, 0, missing),
                        getModItem("GraviSuite", "itemSimpleItem", 1, 0, missing),
                        getModItem("GraviSuite", "itemSimpleItem", 1, 0, missing) });
        addShapedRecipe(
                getModItem("GraviSuite", "itemSimpleItem", 1, 2, missing),
                new Object[] { getModItem("IC2", "reactorVentDiamond", 1, 1, missing),
                        getModItem("IC2", "reactorHeatSwitchDiamond", 1, 1, missing),
                        getModItem("IC2", "reactorVentDiamond", 1, 1, missing),
                        getModItem("gregtech", "gt.180k_NaK_Coolantcell", 1, 0, missing), "plateColdCallistoIce",
                        getModItem("gregtech", "gt.180k_NaK_Coolantcell", 1, 0, missing),
                        getModItem("IC2", "reactorPlatingHeat", 1, 0, missing),
                        getModItem("IC2", "reactorHeatSwitchDiamond", 1, 1, missing),
                        getModItem("IC2", "reactorPlatingHeat", 1, 0, missing) });
        addShapedRecipe(
                getModItem("GraviSuite", "itemSimpleItem", 1, 2, missing),
                new Object[] { getModItem("IC2", "reactorVentDiamond", 1, 1, missing),
                        getModItem("IC2", "reactorHeatSwitchDiamond", 1, 1, missing),
                        getModItem("IC2", "reactorVentDiamond", 1, 1, missing),
                        getModItem("gregtech", "gt.180k_Helium_Coolantcell", 1, 0, missing), "plateColdCallistoIce",
                        getModItem("gregtech", "gt.180k_Helium_Coolantcell", 1, 0, missing),
                        getModItem("IC2", "reactorPlatingHeat", 1, 0, missing),
                        getModItem("IC2", "reactorHeatSwitchDiamond", 1, 1, missing),
                        getModItem("IC2", "reactorPlatingHeat", 1, 0, missing) });
        addShapedRecipe(
                getModItem("GraviSuite", "itemSimpleItem", 1, 4, missing),
                new Object[] { "plateDenseNeodymiumMagnetic", getModItem("IC2", "itemRecipePart", 1, 0, missing),
                        "plateDenseNeodymiumMagnetic", "plateDenseCopper",
                        getModItem("gregtech", "gt.blockmachines", 1, 2384, missing), "plateDenseCopper",
                        "plateDenseNeodymiumMagnetic", getModItem("IC2", "itemRecipePart", 1, 0, missing),
                        "plateDenseNeodymiumMagnetic" });
        addShapedRecipe(
                getModItem("GraviSuite", "itemSimpleItem", 1, 5, missing),
                new Object[] { "craftingToolWrench", "plateCopper", "craftingToolHardHammer",
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("IC2", "blockMachine2", 1, 1, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 2384, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 23, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 2384, missing) });
        addShapedRecipe(
                getModItem("GraviSuite", "vajra", 1, 27, missing),
                new Object[] { getModItem("dreamcraft", "item.EngravedEnergyChip", 1, 0, missing),
                        getModItem("GraviSuite", "itemSimpleItem", 1, 4, missing), "lensReinforcedGlass",
                        "plateAlloyCarbon", getModItem("GraviSuite", "itemSimpleItem", 1, 5, missing),
                        "plateAlloyCarbon", "plateAlloyIridium", "batteryMaster", "plateAlloyIridium" });
        addShapedRecipe(
                getModItem("GraviSuite", "itemSimpleItem", 1, 6, missing),
                new Object[] { "itemCasingAluminium", getModItem("IC2", "itemPartAlloy", 1, 0, missing),
                        "itemCasingAluminium", "circuitAdvanced", getModItem("IC2", "upgradeModule", 1, 0, missing),
                        "circuitAdvanced", getModItem("IC2", "reactorPlating", 1, 0, missing),
                        getModItem("IC2", "reactorVentDiamond", 1, 1, missing),
                        getModItem("IC2", "reactorPlating", 1, 0, missing) });
        addShapedRecipe(
                getModItem("GraviSuite", "ultimateLappack", 1, 27, missing),
                new Object[] { "itemCasingChrome", "batteryMaster", "itemCasingChrome", "batteryMaster",
                        getModItem("GraviSuite", "advLappack", 1, 32767, missing), "batteryMaster", "circuitMaster",
                        "wireGt16NiobiumTitanium", "circuitMaster" });
        addShapedRecipe(
                getModItem("gravisuiteneo", "epicLappack", 1, 27, missing),
                new Object[] { getModItem("dreamcraft", "item.IridiumAlloyItemCasing", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32599, missing),
                        getModItem("dreamcraft", "item.IridiumAlloyItemCasing", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32599, missing),
                        getModItem("GraviSuite", "ultimateLappack", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32599, missing), "circuitUltimate",
                        "wireGt16SuperconductorZPM", "circuitUltimate" });
        addShapedRecipe(
                getModItem("GraviSuite", "advChainsaw", 1, 27, missing),
                new Object[] { "screwTungstenSteel", "toolHeadChainsawTungstenSteel", "craftingToolScrewdriver",
                        "gearGtSmallTungstenSteel", getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing),
                        "gearGtSmallTungstenSteel", "plateTungstenSteel", "batteryElite", "plateTungstenSteel" });
        addShapedRecipe(
                createItemStack("GraviSuite", "advDDrill", 1, 27, "{toolXP:0.0d,charge:0,toolMode:0}", missing),
                new Object[] { "screwIridium",
                        getModItem("dreamcraft", "item.ReinforcedIridiumDrillTip", 1, 0, missing),
                        "craftingToolScrewdriver", "gearGtSmallIridium",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32603, missing), "gearGtSmallIridium",
                        "plateAlloyIridium", "batteryMaster", "plateAlloyIridium" });

    }
}
