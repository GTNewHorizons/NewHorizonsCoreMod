package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.GraviSuiteNEO;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.item.NHItemList;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

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
                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorIV, 1L),
                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorIV, 1L),
                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorIV, 1L),
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing));
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 1, missing),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.wireGt12, Materials.SuperconductorLuV, 1L),
                "plateRhodium-PlatedPalladium",
                GTOreDictUnificator.get(OrePrefixes.wireGt12, Materials.SuperconductorLuV, 1L),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0, missing));
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2, missing),
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1, missing),
                ItemList.Reactor_Coolant_NaK_3.get(1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CallistoIce, 1),
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
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CallistoIce, 1),
                ItemList.Reactor_Coolant_He_3.get(1L),
                getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0, missing),
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1, missing),
                getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0, missing));
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
                "batteryData",
                "itemCasingChrome",
                "batteryData",
                getModItem(GraviSuite.ID, "advLappack", 1, wildcard, missing),
                "batteryData",
                "circuitMaster",
                "wireGt16NiobiumTitanium",
                "circuitMaster");
        addShapedRecipe(
                getModItem(GraviSuiteNEO.ID, "epicLappack", 1, 27, missing),
                CustomItemList.IridiumAlloyItemCasing.get(1L),
                ItemList.Energy_LapotronicOrb2.get(1L),
                CustomItemList.IridiumAlloyItemCasing.get(1L),
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
                "batteryData",
                "plateTungstenSteel");
        addShapedRecipe(
                createItemStack(GraviSuite.ID, "advDDrill", 1, 27, "{toolXP:0.0d,charge:0,toolMode:0}", missing),
                "screwIridium",
                NHItemList.ReinforcedIridiumDrillTip.get(1),
                "craftingToolScrewdriver",
                "gearGtSmallIridium",
                ItemList.Electric_Motor_EV.get(1L),
                "gearGtSmallIridium",
                "plateAlloyIridium",
                "batteryData",
                "plateAlloyIridium");
        addShapelessRecipe(ItemList.Tool_Vajra.get(1), getModItem(GraviSuite.ID, "vajra", 1, wildcard, missing));

    }
}
