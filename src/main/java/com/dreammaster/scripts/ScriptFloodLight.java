package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.FloodLights;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
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
                getModItem(FloodLights.ID, "electricFloodlight", 1, 0, missing),
                "plateSteel",
                "lensGlass",
                "plateSteel",
                "circuitBasic",
                getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing),
                "circuitBasic",
                "plateSteel",
                "wireGt01Copper",
                "plateSteel");
        addShapedRecipe(
                getModItem(FloodLights.ID, "carbonFloodlight", 1, 0, missing),
                "plateSteel",
                "lensGlass",
                "plateSteel",
                "circuitBasic",
                getModItem(FloodLights.ID, "carbonLantern", 1, 0, missing),
                "circuitBasic",
                "plateSteel",
                "wireGt01Copper",
                "plateSteel");
        addShapedRecipe(
                getModItem(FloodLights.ID, "uvFloodlight", 1, 0, missing),
                "plateSteel",
                "lensDiamond",
                "plateSteel",
                "circuitBasic",
                getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing),
                "circuitBasic",
                "plateSteel",
                "wireGt01Copper",
                "plateSteel");
        addShapedRecipe(
                getModItem(FloodLights.ID, "carbonLantern", 1, 0, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                getModItem(FloodLights.ID, "mantle", 1, 0, missing),
                getModItem(FloodLights.ID, "carbonDissolver", 1, 0, missing),
                getModItem(FloodLights.ID, "mantle", 1, 0, missing),
                "paneGlass",
                getModItem(Minecraft.ID, "flint_and_steel", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(
                getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 2, 0, missing),
                getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 1, missing));
        addShapelessRecipe(
                getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 1, missing),
                getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 0, missing),
                getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 0, missing));
        addShapedRecipe(
                getModItem(FloodLights.ID, "growLight", 1, 0, missing),
                getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 8, missing),
                getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing),
                "circuitAdvanced",
                getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing),
                "circuitAdvanced",
                "plateTitanium",
                "wireGt01Cobalt",
                "plateTitanium");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 8, 0, missing))
                .itemOutputs(getModItem(FloodLights.ID, "mantle", 1, 0, missing)).duration(5 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Tungsten, 1L),
                        getModItem(Minecraft.ID, "glass_pane", 2, 0, missing))
                .itemOutputs(getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("argon", 1)).duration(10 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 3, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L))
                .itemOutputs(getModItem(FloodLights.ID, "carbonDissolver", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(10 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 2L))
                .itemOutputs(getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 288)).duration(10 * SECONDS).eut(120)
                .addTo(assemblerRecipes);

    }
}
