package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.SuperSolarPanels;
import static gregtech.api.recipe.RecipeMaps.laserEngraverRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;

public class ScriptSuperSolarPanels implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Super Solar Panels";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(AdvancedSolarPanel.ID, SuperSolarPanels.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                ItemList.Cover_SolarPanel_IV.get(1L),
                "craftingToolCrowbar",
                ItemList.Machine_IV_SolarPanel.get(1),
                "craftingToolScrewdriver",
                "craftingToolWrench",
                "craftingToolHardHammer",
                "craftingToolFile");
        addShapedRecipe(
                ItemList.Cover_SolarPanel_LuV.get(1L),
                "craftingToolCrowbar",
                ItemList.Machine_LuV_SolarPanel.get(1),
                "craftingToolScrewdriver",
                "craftingToolWrench",
                "craftingToolHardHammer",
                "craftingToolFile");
        addShapedRecipe(
                ItemList.Cover_SolarPanel_ZPM.get(1L),
                "craftingToolCrowbar",
                ItemList.Machine_ZPM_SolarPanel.get(1),
                "craftingToolScrewdriver",
                "craftingToolWrench",
                "craftingToolHardHammer",
                "craftingToolFile");
        addShapedRecipe(
                ItemList.Cover_SolarPanel_UV.get(1L),
                "craftingToolCrowbar",
                ItemList.Machine_UV_SolarPanel.get(1),
                "craftingToolScrewdriver",
                "craftingToolWrench",
                "craftingToolHardHammer",
                "craftingToolFile");
        addShapedRecipe(
                getModItem(SuperSolarPanels.ID, "solarsplitter", 1, 0),
                getModItem(SuperSolarPanels.ID, "redcomponent", 1, 0),
                getModItem(SuperSolarPanels.ID, "greencomponent", 1, 0),
                getModItem(SuperSolarPanels.ID, "bluecomponent", 1, 0),
                getModItem(SuperSolarPanels.ID, "redcomponent", 1, 0),
                getModItem(SuperSolarPanels.ID, "greencomponent", 1, 0),
                getModItem(SuperSolarPanels.ID, "bluecomponent", 1, 0),
                getModItem(SuperSolarPanels.ID, "redcomponent", 1, 0),
                getModItem(SuperSolarPanels.ID, "greencomponent", 1, 0),
                getModItem(SuperSolarPanels.ID, "bluecomponent", 1, 0));
        addShapedRecipe(
                getModItem(SuperSolarPanels.ID, "enderquantumcomponent", 1, 0),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 3),
                "plateElectrumFlux",
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 3),
                "plateElectrumFlux",
                "plateDenseInfinityCatalyst",
                "plateElectrumFlux",
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 3),
                "plateElectrumFlux",
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 3));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(
                                0,
                                MaterialLibAPI
                                        .getStack(Materials2Materials.Emerald, Materials2Shapes.shapeLens, (int) (1L))),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "greencomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder().itemInputs(
                GTUtility.copyAmount(
                        0,
                        MaterialLibAPI
                                .getStack(Materials2Materials.GreenSapphire, Materials2Shapes.shapeLens, (int) (1L))),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "greencomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(
                                0,
                                MaterialLibAPI
                                        .getStack(Materials2Materials.Olivine, Materials2Shapes.shapeLens, (int) (1L))),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "greencomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder().itemInputs(
                GTUtility.copyAmount(
                        0,
                        MaterialLibAPI
                                .getStack(Materials2Materials.InfusedEarth, Materials2Shapes.shapeLens, (int) (1L))),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "greencomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder().itemInputs(
                GTUtility.copyAmount(
                        0,
                        MaterialLibAPI.getStack(Materials2Materials.Sapphire, Materials2Shapes.shapeLens, (int) (1L))),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "bluecomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(
                                0,
                                MaterialLibAPI
                                        .getStack(Materials2Materials.Opal, Materials2Shapes.shapeLens, (int) (1L))),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "bluecomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder().itemInputs(
                GTUtility.copyAmount(
                        0,
                        MaterialLibAPI.getStack(Materials2Materials.BlueTopaz, Materials2Shapes.shapeLens, (int) (1L))),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "bluecomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder().itemInputs(
                GTUtility.copyAmount(
                        0,
                        MaterialLibAPI
                                .getStack(Materials2Materials.InfusedWater, Materials2Shapes.shapeLens, (int) (1L))),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "bluecomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder().itemInputs(
                GTUtility.copyAmount(
                        0,
                        MaterialLibAPI.getStack(Materials2Materials.Firestone, Materials2Shapes.shapeLens, (int) (1L))),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "redcomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(
                                0,
                                MaterialLibAPI
                                        .getStack(Materials2Materials.Jasper, Materials2Shapes.shapeLens, (int) (1L))),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "redcomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, GTOreDictUnificator.get(OrePrefixes.lens, Materials.Spinel, 1L)),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "redcomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(
                                0,
                                MaterialLibAPI
                                        .getStack(Materials2Materials.Ruby, Materials2Shapes.shapeLens, (int) (1L))),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "redcomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder().itemInputs(
                GTUtility.copyAmount(
                        0,
                        MaterialLibAPI.getStack(Materials2Materials.GarnetRed, Materials2Shapes.shapeLens, (int) (1L))),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "redcomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder().itemInputs(
                GTUtility.copyAmount(
                        0,
                        MaterialLibAPI
                                .getStack(Materials2Materials.InfusedFire, Materials2Shapes.shapeLens, (int) (1L))),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "redcomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);

    }
}
