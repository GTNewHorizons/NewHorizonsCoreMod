package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.FloodLights;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;

public class ScriptFloodLight implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Flood Light";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.FloodLights.ID, Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(FloodLights.ID, "electricFloodlight", 1, 0),
                "plateSteel",
                "lensGlass",
                "plateSteel",
                "circuitBasic",
                getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0),
                "circuitBasic",
                "plateSteel",
                "wireGt01Copper",
                "plateSteel");
        addShapedRecipe(
                getModItem(FloodLights.ID, "carbonFloodlight", 1, 0),
                "plateSteel",
                "lensGlass",
                "plateSteel",
                "circuitBasic",
                getModItem(FloodLights.ID, "carbonLantern", 1, 0),
                "circuitBasic",
                "plateSteel",
                "wireGt01Copper",
                "plateSteel");
        addShapedRecipe(
                getModItem(FloodLights.ID, "uvFloodlight", 1, 0),
                "plateSteel",
                "lensDiamond",
                "plateSteel",
                "circuitBasic",
                getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0),
                "circuitBasic",
                "plateSteel",
                "wireGt01Copper",
                "plateSteel");
        addShapedRecipe(
                getModItem(FloodLights.ID, "carbonLantern", 1, 0),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                getModItem(FloodLights.ID, "mantle", 1, 0),
                getModItem(FloodLights.ID, "carbonDissolver", 1, 0),
                getModItem(FloodLights.ID, "mantle", 1, 0),
                "paneGlass",
                getModItem(Minecraft.ID, "flint_and_steel", 1, 0),
                "paneGlass");
        addShapelessRecipe(
                getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 2, 0),
                getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 1));
        addShapelessRecipe(
                getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 1),
                getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 0),
                getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 0));
        addShapedRecipe(
                getModItem(FloodLights.ID, "growLight", 1, 0),
                getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 8),
                getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0),
                "circuitAdvanced",
                getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0),
                "circuitAdvanced",
                "plateTitanium",
                "wireGt01Cobalt",
                "plateTitanium");

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "redstone", 1, 0), getModItem(Minecraft.ID, "string", 8, 0))
                .itemOutputs(getModItem(FloodLights.ID, "mantle", 1, 0)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Tungsten, 1L),
                        getModItem(Minecraft.ID, "glass_pane", 2, 0))
                .itemOutputs(getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("argon", 1)).duration(10 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 3, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L))
                .itemOutputs(getModItem(FloodLights.ID, "carbonDissolver", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 2L))
                .itemOutputs(getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 288)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(assemblerRecipes);

    }
}
