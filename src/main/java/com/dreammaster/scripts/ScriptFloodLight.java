package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.FloodLights;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_OreDictUnificator;

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

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 8, 0, missing))
                .itemOutputs(getModItem(FloodLights.ID, "mantle", 1, 0, missing)).duration(100).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.wireFine, Materials.Tungsten, 1L),
                        getModItem(Minecraft.ID, "glass_pane", 2, 0, missing))
                .itemOutputs(getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("argon", 1)).duration(200).eut(120).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 3, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 2L))
                .itemOutputs(getModItem(FloodLights.ID, "carbonDissolver", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 2L))
                .itemOutputs(getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 288)).duration(200).eut(120)
                .addTo(sAssemblerRecipes);

    }
}
