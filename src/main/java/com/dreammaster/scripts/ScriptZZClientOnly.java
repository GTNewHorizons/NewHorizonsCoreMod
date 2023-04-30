package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;

public class ScriptZZClientOnly implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "ZZ Client Only";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.Forestry.ID);
    }

    @Override
    public void loadRecipes() {
        // TODO !!!
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "stamps", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 32000, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 32000, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 32000, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32000, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32000, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 32000, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 32000, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 32000, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "stamps", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "stamps", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 32011, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 32011, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 32011, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32011, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32011, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 32011, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 32011, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 32011, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "stamps", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("IC2", "itemCoin", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "stamps", 1, 1, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "stamps", 1, 1, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem("IC2", "itemCoin", 1, 0, missing),
                'h',
                getModItem("IC2", "itemCoin", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "stamps", 1, 2, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "stamps", 1, 2, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("IC2", "itemCoin", 1, 0, missing),
                'c',
                getModItem("IC2", "itemCoin", 1, 0, missing),
                'e',
                getModItem("IC2", "itemCoin", 1, 0, missing),
                'g',
                getModItem("IC2", "itemCoin", 1, 0, missing),
                'i',
                getModItem("IC2", "itemCoin", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "stamps", 1, 3, missing),
                "abc",
                "def",
                "ghi",
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32002, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "stamps", 1, 3, missing),
                "abc",
                "def",
                "ghi",
                'd',
                getModItem("IC2", "itemCoin", 1, 0, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32013, missing),
                'f',
                getModItem("IC2", "itemCoin", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "stamps", 1, 4, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32002, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32002, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "stamps", 1, 4, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("IC2", "itemCoin", 1, 0, missing),
                'c',
                getModItem("IC2", "itemCoin", 1, 0, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32013, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32013, missing),
                'g',
                getModItem("IC2", "itemCoin", 1, 0, missing),
                'i',
                getModItem("IC2", "itemCoin", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "stamps", 1, 5, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 32002, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 32002, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32002, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32002, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 32002, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 32002, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "stamps", 1, 5, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 32013, missing),
                'b',
                getModItem("IC2", "itemCoin", 1, 0, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 32013, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32013, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32013, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 32013, missing),
                'h',
                getModItem("IC2", "itemCoin", 1, 0, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 32013, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "stamps", 1, 6, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 32002, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 32002, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32003, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 32002, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 32001, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 32002, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem("minecraft", "paper", 1, 0, missing),
                getModItem("Forestry", "stamps", 1, 6, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 32013, missing),
                'b',
                getModItem("IC2", "itemCoin", 1, 0, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 32013, missing),
                'd',
                getModItem("IC2", "itemCoin", 1, 0, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32014, missing),
                'f',
                getModItem("IC2", "itemCoin", 1, 0, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 32013, missing),
                'h',
                getModItem("IC2", "itemCoin", 1, 0, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 32013, missing));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.CoinBlank", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("dreamcraft", "item.CoinChunkloaderTierI", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 3000)).noFluidOutputs().duration(600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.CoinBlank", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem("dreamcraft", "item.CoinChunkloaderTierII", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 6000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.CoinBlank", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("dreamcraft", "item.CoinChunkloaderTierIII", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 12000)).noFluidOutputs().duration(600).eut(1920)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.CoinBlank", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem("dreamcraft", "item.CoinChunkloaderTierIV", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 24000)).noFluidOutputs().duration(600).eut(7680)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.CoinBlank", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem("dreamcraft", "item.CoinChunkloaderTierV", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 48000)).noFluidOutputs().duration(600).eut(30720)
                .addTo(sAssemblerRecipes);
    }
}
