package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import forestry.api.recipes.RecipeManagers;
import gregtech.api.enums.GT_Values;

public class ScriptZZClientOnly implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "ZZ Client Only";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Forestry.ID, IndustrialCraft2.ID);
    }

    @Override
    public void loadRecipes() {
        // TODO !!!
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "stamps", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32000, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32000, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32000, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32000, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32000, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32000, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32000, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32000, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "stamps", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "stamps", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32011, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32011, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32011, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32011, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32011, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32011, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32011, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32011, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "stamps", 1, 0, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "stamps", 1, 1, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "stamps", 1, 1, missing),
                "abc",
                "def",
                "ghi",
                'e',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                'h',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "stamps", 1, 2, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "stamps", 1, 2, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                'c',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                'e',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                'g',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                'i',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "stamps", 1, 3, missing),
                "abc",
                "def",
                "ghi",
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "stamps", 1, 3, missing),
                "abc",
                "def",
                "ghi",
                'd',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                'f',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "stamps", 1, 4, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "stamps", 1, 4, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                'c',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                'g',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                'i',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "stamps", 1, 5, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "stamps", 1, 5, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                'b',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                'h',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "stamps", 1, 6, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                'b',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                'd',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32003, missing),
                'f',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing),
                'h',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32001, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32002, missing));
        RecipeManagers.carpenterManager.addRecipe(
                10,
                FluidRegistry.getFluidStack("seedoil", 100),
                getModItem(Minecraft.ID, "paper", 1, 0, missing),
                getModItem(Forestry.ID, "stamps", 1, 6, missing),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                'b',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                'c',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                'd',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                'e',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32014, missing),
                'f',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                'g',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing),
                'h',
                getModItem(IndustrialCraft2.ID, "itemCoin", 1, 0, missing),
                'i',
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 32013, missing));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinChunkloaderTierI", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 3000)).noFluidOutputs().duration(600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 2, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinChunkloaderTierII", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 6000)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinChunkloaderTierIII", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 12000)).noFluidOutputs().duration(600).eut(1920)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 4, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinChunkloaderTierIV", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 24000)).noFluidOutputs().duration(600).eut(7680)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.CoinBlank", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 5, missing))
                .itemOutputs(getModItem(NewHorizonsCoreMod.ID, "item.CoinChunkloaderTierV", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 48000)).noFluidOutputs().duration(600).eut(30720)
                .addTo(sAssemblerRecipes);
    }
}
