package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.*;
import static gregtech.api.enums.Mods.GraviSuite;
import static gregtech.api.enums.Mods.GraviSuiteNEO;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static com.dreammaster.scripts.IngredientFactory.getModItem;

import java.util.Arrays;
import java.util.List;

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
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorIV, 1L),
                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorIV, 1L),
                GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.SuperconductorIV, 1L),
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0));
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 1),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.wireGt12, Materials.SuperconductorLuV, 1L),
                "plateRhodium-PlatedPalladium",
                GTOreDictUnificator.get(OrePrefixes.wireGt12, Materials.SuperconductorLuV, 1L),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0),
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 0));
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2),
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1),
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1),
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1),
                ItemList.Reactor_Coolant_NaK_3.get(1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CallistoIce, 1),
                ItemList.Reactor_Coolant_NaK_3.get(1L),
                getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0),
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1),
                getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0));
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 2),
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1),
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1),
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1),
                ItemList.Reactor_Coolant_He_3.get(1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.CallistoIce, 1),
                ItemList.Reactor_Coolant_He_3.get(1L),
                getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0),
                getModItem(IndustrialCraft2.ID, "reactorHeatSwitchDiamond", 1, 1),
                getModItem(IndustrialCraft2.ID, "reactorPlatingHeat", 1, 0));
        addShapedRecipe(
                getModItem(GraviSuite.ID, "itemSimpleItem", 1, 6),
                "itemCasingAluminium",
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0),
                "itemCasingAluminium",
                "circuitAdvanced",
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0),
                "circuitAdvanced",
                getModItem(IndustrialCraft2.ID, "reactorPlating", 1, 0),
                getModItem(IndustrialCraft2.ID, "reactorVentDiamond", 1, 1),
                getModItem(IndustrialCraft2.ID, "reactorPlating", 1, 0));
        addShapedRecipe(
                getModItem(GraviSuite.ID, "ultimateLappack", 1, 27),
                "itemCasingChrome",
                "batteryData",
                "itemCasingChrome",
                "batteryData",
                getModItem(GraviSuite.ID, "advLappack", 1, wildcard),
                "batteryData",
                "circuitMaster",
                "wireGt16NiobiumTitanium",
                "circuitMaster");
        addShapedRecipe(
                getModItem(GraviSuiteNEO.ID, "epicLappack", 1, 27),
                NHItemList.IridiumAlloyItemCasing.get(),
                ItemList.Energy_LapotronicOrb2.get(1L),
                NHItemList.IridiumAlloyItemCasing.get(),
                ItemList.Energy_LapotronicOrb2.get(1L),
                getModItem(GraviSuite.ID, "ultimateLappack", 1, wildcard),
                ItemList.Energy_LapotronicOrb2.get(1L),
                "circuitUltimate",
                "wireGt16SuperconductorZPM",
                "circuitUltimate");
        addShapedRecipe(
                getModItem(GraviSuite.ID, "advChainsaw", 1, 27),
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
                createItemStack(GraviSuite.ID, "advDDrill", 1, 27, "{toolXP:0.0d,charge:0,toolMode:0}"),
                "screwIridium",
                NHItemList.ReinforcedIridiumDrillTip.get(1),
                "craftingToolScrewdriver",
                "gearGtSmallIridium",
                ItemList.Electric_Motor_EV.get(1L),
                "gearGtSmallIridium",
                "plateAlloyIridium",
                "batteryData",
                "plateAlloyIridium");
        addShapelessRecipe(ItemList.Tool_Vajra.get(1), getModItem(GraviSuite.ID, "vajra", 1, wildcard));

    }
}
