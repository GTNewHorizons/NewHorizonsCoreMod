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
import gregtech.api.enums.Mods;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.util.GTUtility;

public class ScriptSuperSolarPanels implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Super Solar Panels";
    }

    @Override
    public List<Mods> getDependencies() {
        return Arrays.asList(AdvancedSolarPanel, SuperSolarPanels);
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
                        GTUtility.copyAmount(0, MaterialLibAPI.getStack(Materials.Emerald, Shapes.lens, 1)),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "greencomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, MaterialLibAPI.getStack(Materials.GreenSapphire, Shapes.lens, 1)),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "greencomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, MaterialLibAPI.getStack(Materials.Olivine, Shapes.lens, 1)),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "greencomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, MaterialLibAPI.getStack(Materials.InfusedEarth, Shapes.lens, 1)),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "greencomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, MaterialLibAPI.getStack(Materials.Sapphire, Shapes.lens, 1)),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "bluecomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, MaterialLibAPI.getStack(Materials.Opal, Shapes.lens, 1)),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "bluecomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, MaterialLibAPI.getStack(Materials.BlueTopaz, Shapes.lens, 1)),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "bluecomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, MaterialLibAPI.getStack(Materials.InfusedWater, Shapes.lens, 1)),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "bluecomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, MaterialLibAPI.getStack(Materials.Firestone, Shapes.lens, 1)),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "redcomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, MaterialLibAPI.getStack(Materials.Jasper, Shapes.lens, 1)),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "redcomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, MaterialLibAPI.getStack(Materials.FoolsRuby, Shapes.lens, 1)),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "redcomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, MaterialLibAPI.getStack(Materials.Ruby, Shapes.lens, 1)),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "redcomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, MaterialLibAPI.getStack(Materials.GarnetRed, Shapes.lens, 1)),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "redcomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTUtility.copyAmount(0, MaterialLibAPI.getStack(Materials.InfusedFire, Shapes.lens, 1)),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 5))
                .itemOutputs(getModItem(SuperSolarPanels.ID, "redcomponent", 1, 0)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(laserEngraverRecipes);

    }
}
