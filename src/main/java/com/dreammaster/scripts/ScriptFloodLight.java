package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.FloodLights;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

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
                new Object[] { "plateSteel", "lensGlass", "plateSteel", "circuitBasic",
                        getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing), "circuitBasic",
                        "plateSteel", "wireGt01Copper", "plateSteel" });
        addShapedRecipe(
                getModItem(FloodLights.ID, "carbonFloodlight", 1, 0, missing),
                new Object[] { "plateSteel", "lensGlass", "plateSteel", "circuitBasic",
                        getModItem(FloodLights.ID, "carbonLantern", 1, 0, missing), "circuitBasic", "plateSteel",
                        "wireGt01Copper", "plateSteel" });
        addShapedRecipe(
                getModItem(FloodLights.ID, "uvFloodlight", 1, 0, missing),
                new Object[] { "plateSteel", "lensDiamond", "plateSteel", "circuitBasic",
                        getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing), "circuitBasic",
                        "plateSteel", "wireGt01Copper", "plateSteel" });
        addShapedRecipe(
                getModItem(FloodLights.ID, "carbonLantern", 1, 0, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass",
                        getModItem(FloodLights.ID, "mantle", 1, 0, missing),
                        getModItem(FloodLights.ID, "carbonDissolver", 1, 0, missing),
                        getModItem(FloodLights.ID, "mantle", 1, 0, missing), "paneGlass",
                        getModItem(Minecraft.ID, "flint_and_steel", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 2, 0, missing),
                new Object[] { getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 1, missing),
                new Object[] { getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 0, missing),
                        getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem(FloodLights.ID, "growLight", 1, 0, missing),
                new Object[] { getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 8, missing),
                        getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing), "circuitAdvanced",
                        getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing), "circuitAdvanced",
                        "plateTitanium", "wireGt01Cobalt", "plateTitanium" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 8, 0, missing))
                .itemOutputs(getModItem(FloodLights.ID, "mantle", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 19081, missing),
                        getModItem(Minecraft.ID, "glass_pane", 2, 0, missing))
                .itemOutputs(getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("argon", 1)).noFluidOutputs().duration(200).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass_pane", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17305, missing))
                .itemOutputs(getModItem(FloodLights.ID, "carbonDissolver", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(FloodLights.ID, "electricIncandescentLightBulb", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 28032, missing))
                .itemOutputs(getModItem(FloodLights.ID, "smallElectricFloodlightMetaBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 288)).noFluidOutputs().duration(200).eut(120)
                .addTo(sAssemblerRecipes);

    }
}
