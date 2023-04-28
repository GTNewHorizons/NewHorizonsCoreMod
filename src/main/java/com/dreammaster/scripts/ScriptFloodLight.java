package com.dreammaster.scripts;

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
        return Arrays.asList(Mods.FloodLights.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("FloodLights", "electricFloodlight", 1, 0, missing),
                new Object[] { "plateSteel", "lensGlass", "plateSteel", "circuitBasic",
                        getModItem("FloodLights", "electricIncandescentLightBulb", 1, 0, missing), "circuitBasic",
                        "plateSteel", "wireGt01Copper", "plateSteel" });
        addShapedRecipe(
                getModItem("FloodLights", "carbonFloodlight", 1, 0, missing),
                new Object[] { "plateSteel", "lensGlass", "plateSteel", "circuitBasic",
                        getModItem("FloodLights", "carbonLantern", 1, 0, missing), "circuitBasic", "plateSteel",
                        "wireGt01Copper", "plateSteel" });
        addShapedRecipe(
                getModItem("FloodLights", "uvFloodlight", 1, 0, missing),
                new Object[] { "plateSteel", "lensDiamond", "plateSteel", "circuitBasic",
                        getModItem("FloodLights", "electricIncandescentLightBulb", 1, 0, missing), "circuitBasic",
                        "plateSteel", "wireGt01Copper", "plateSteel" });
        addShapedRecipe(
                getModItem("FloodLights", "carbonLantern", 1, 0, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass",
                        getModItem("FloodLights", "mantle", 1, 0, missing),
                        getModItem("FloodLights", "carbonDissolver", 1, 0, missing),
                        getModItem("FloodLights", "mantle", 1, 0, missing), "paneGlass",
                        getModItem("minecraft", "flint_and_steel", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("FloodLights", "smallElectricFloodlightMetaBlock", 2, 0, missing),
                new Object[] { getModItem("FloodLights", "smallElectricFloodlightMetaBlock", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("FloodLights", "smallElectricFloodlightMetaBlock", 1, 1, missing),
                new Object[] { getModItem("FloodLights", "smallElectricFloodlightMetaBlock", 1, 0, missing),
                        getModItem("FloodLights", "smallElectricFloodlightMetaBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem("FloodLights", "growLight", 1, 0, missing),
                new Object[] { getModItem("FloodLights", "electricIncandescentLightBulb", 1, 0, missing),
                        getModItem("Thaumcraft", "blockMetalDevice", 1, 8, missing),
                        getModItem("FloodLights", "electricIncandescentLightBulb", 1, 0, missing), "circuitAdvanced",
                        getModItem("FloodLights", "electricIncandescentLightBulb", 1, 0, missing), "circuitAdvanced",
                        "plateTitanium", "wireGt01Cobalt", "plateTitanium" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "redstone", 1, 0, missing),
                        getModItem("minecraft", "string", 8, 0, missing))
                .itemOutputs(getModItem("FloodLights", "mantle", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.02", 1, 19081, missing),
                        getModItem("minecraft", "glass_pane", 2, 0, missing))
                .itemOutputs(getModItem("FloodLights", "electricIncandescentLightBulb", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("argon", 1)).noFluidOutputs().duration(200).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glass_pane", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17305, missing))
                .itemOutputs(getModItem("FloodLights", "carbonDissolver", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("FloodLights", "electricIncandescentLightBulb", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 28032, missing))
                .itemOutputs(getModItem("FloodLights", "smallElectricFloodlightMetaBlock", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glass", 288)).noFluidOutputs().duration(200).eut(120)
                .addTo(sAssemblerRecipes);

    }
}
