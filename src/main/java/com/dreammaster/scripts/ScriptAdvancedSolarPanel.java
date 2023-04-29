package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptAdvancedSolarPanel implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Advanced Solar Panel";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.AdvancedSolarPanel.ID);
    }

    @Override
    public void loadRecipes() {

        // AUTOGENERATED

        addShapedRecipe(
                getModItem("AdvancedSolarPanel", "advanced_solar_helmet", 1, 0, missing),
                new Object[] { "craftingToolWrench",
                        getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1, 0, missing),
                        "craftingToolScrewdriver", "circuitAdvanced",
                        getModItem("IC2", "itemArmorNanoHelmet", 1, 32767, missing), "circuitAdvanced",
                        "cableGt04Aluminium", getModItem("gregtech", "gt.blockmachines", 1, 22, missing),
                        "cableGt04Aluminium" });
        addShapedRecipe(
                getModItem("AdvancedSolarPanel", "hybrid_solar_helmet", 1, 0, missing),
                new Object[] { "craftingToolWrench",
                        getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1, 1, missing),
                        "craftingToolScrewdriver", "circuitMaster",
                        getModItem("IC2", "itemArmorQuantumHelmet", 1, 32767, missing), "circuitMaster",
                        "cableGt04Platinum", getModItem("gregtech", "gt.blockmachines", 1, 23, missing),
                        "cableGt04Platinum" });
        addShapedRecipe(
                getModItem("AdvancedSolarPanel", "ultimate_solar_helmet", 1, 0, missing),
                new Object[] { "craftingToolWrench", "circuitUltimate", "craftingToolScrewdriver",
                        "craftingSolarPanelHV",
                        getModItem("AdvancedSolarPanel", "hybrid_solar_helmet", 1, 32767, missing),
                        "craftingSolarPanelHV", "cableGt04VanadiumGallium",
                        getModItem("gregtech", "gt.blockmachines", 1, 24, missing), "cableGt04VanadiumGallium" });
        addShapedRecipe(
                getModItem("AdvancedSolarPanel", "asp_crafting_items", 4, 5, missing),
                new Object[] { "glassReinforced", getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 2, missing),
                        "glassReinforced", getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 2, missing),
                        "plateGlowstone", getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 2, missing),
                        "glassReinforced", getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 2, missing),
                        "glassReinforced" });
        addShapedRecipe(
                getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 13, missing),
                new Object[] { getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 4, missing), "plateNetherStar",
                        getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 4, missing), "plateNetherStar",
                        "circuitOptical", "plateNetherStar",
                        getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 4, missing), "plateNetherStar",
                        getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 4, missing) });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32752, missing),
                new Object[] { "craftingToolCrowbar",
                        getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1, 0, missing),
                        "craftingToolScrewdriver", "craftingToolWrench", "craftingToolHardHammer",
                        "craftingToolFile" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32753, missing),
                new Object[] { "craftingToolCrowbar",
                        getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1, 1, missing),
                        "craftingToolScrewdriver", "craftingToolWrench", "craftingToolHardHammer",
                        "craftingToolFile" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32754, missing),
                new Object[] { "craftingToolCrowbar",
                        getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1, 2, missing),
                        "craftingToolScrewdriver", "craftingToolWrench", "craftingToolHardHammer",
                        "craftingToolFile" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 1, 32755, missing),
                new Object[] { "craftingToolCrowbar",
                        getModItem("AdvancedSolarPanel", "BlockAdvSolarPanel", 1, 3, missing),
                        "craftingToolScrewdriver", "craftingToolWrench", "craftingToolHardHammer",
                        "craftingToolFile" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 11098, missing),
                        getModItem("minecraft", "glowstone", 4, 0, missing))
                .itemOutputs(getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 2, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(1920).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 0, missing),
                        getModItem("AdvancedSolarPanel", "asp_crafting_items", 8, 2, missing))
                .itemOutputs(getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 3, missing)).noFluidInputs()
                .noFluidOutputs().duration(1200).eut(7680).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 17318, missing),
                        getModItem("IC2", "itemPartIridium", 8, 0, missing))
                .itemOutputs(getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 1, missing)).noFluidInputs()
                .noFluidOutputs().duration(800).eut(30720).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 1, missing),
                        getModItem("AdvancedSolarPanel", "asp_crafting_items", 8, 3, missing))
                .itemOutputs(getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 4, missing)).noFluidInputs()
                .noFluidOutputs().duration(1600).eut(122880).addTo(sAssemblerRecipes);

    }
}