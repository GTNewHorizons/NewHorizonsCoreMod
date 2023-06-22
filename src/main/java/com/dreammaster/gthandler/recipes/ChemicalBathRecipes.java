package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;
import static net.minecraftforge.fluids.FluidRegistry.getFluidStack;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;

public class ChemicalBathRecipes implements Runnable {

    @Override
    public void run() {

        ItemStack missing = new ItemStack(Blocks.fire);

        // tanned leather
        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Items.leather, 2, 0))
                .itemOutputs(GT_ModHandler.getModItem(Backpack.ID, "tannedLeather", 1L, 0))
                .fluidInputs(Materials.PhosphoricAcid.getFluid(144)).noFluidOutputs().duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.ArtificialLeather.get(2L))
                .itemOutputs(GT_ModHandler.getModItem(Backpack.ID, "tannedLeather", 1L, 0))
                .fluidInputs(Materials.PhosphoricAcid.getFluid(144)).noFluidOutputs().duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sChemicalBathRecipes);

        // Chlorine cleaning of pistons
        GT_Values.RA.stdBuilder().itemInputs(new ItemStack(Blocks.sticky_piston, 1, 0))
                .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Chlorine.getGas(10L))
                .noFluidOutputs().duration(1 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(sChemicalBathRecipes);

        // Cooling Hot Netherrack Bricks
        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.HotNetherrackBrick.get(1L))
                .itemOutputs(CustomItemList.InfernalBrick.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 1000))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 1000)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(sChemicalBathRecipes);
        // Cooling Hot Kanthal MV
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Kanthal, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Kanthal, 1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_MV).addTo(sChemicalBathRecipes);
        // Cooling Hot Tantalum MV
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tantalum, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tantalum, 1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(sChemicalBathRecipes);
        // Cooling Hot Silicon MV
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.Silicon, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Silicon, 1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sChemicalBathRecipes);
        // Cooling Hot SiliconSG MV
        GT_Values.RA.stdBuilder().itemInputs(GT_OreDictUnificator.get(OrePrefixes.ingotHot, Materials.SiliconSG, 1L))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.SiliconSG, 1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(sChemicalBathRecipes);

        GT_Values.RA.stdBuilder().itemInputs(CustomItemList.MysteriousCrystalGemExquisite.get(1L))
                .itemOutputs(CustomItemList.MysteriousCrystalLens.get(1L)).fluidInputs(Materials.UUMatter.getFluid(144))
                .noFluidOutputs().duration(30 * SECONDS).eut(TierEU.RECIPE_UV).addTo(sChemicalBathRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ItemList.Circuit_Parts_GlassFiber.get(1L))
                .itemOutputs(Materials.EpoxidFiberReinforced.getPlates(1)).fluidInputs(Materials.Epoxid.getMolten(144L))
                .noFluidOutputs().duration(12 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getIC2Item("carbonFiber", 1))
                .itemOutputs(Materials.EpoxidFiberReinforced.getPlates(1)).fluidInputs(Materials.Epoxid.getMolten(144L))
                .noFluidOutputs().duration(12 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(sChemicalBathRecipes);

        if (BiomesOPlenty.isModLoaded() && HardcoreEnderExpansion.isModLoaded() && Thaumcraft.isModLoaded()) {
            GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 0, missing))
                    .itemOutputs(
                            getModItem(Minecraft.ID, "bone", 8, 0, missing),
                            getModItem(Minecraft.ID, "bone", 6, 0, missing),
                            getModItem(Minecraft.ID, "bone", 4, 0, missing))
                    .outputChances(10000, 7500, 5000).fluidInputs(getFluidStack("hell_blood", 1000)).noFluidOutputs()
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sChemicalBathRecipes);
            GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 1, missing))
                    .itemOutputs(
                            getModItem(Minecraft.ID, "coal_block", 2, 0, missing),
                            getModItem(Minecraft.ID, "coal_block", 1, 0, missing),
                            getModItem(Minecraft.ID, "coal_block", 1, 0, missing))
                    .outputChances(10000, 7500, 5000).fluidInputs(getFluidStack("hell_blood", 1000)).noFluidOutputs()
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sChemicalBathRecipes);
            GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 4, missing))
                    .itemOutputs(
                            getModItem(Minecraft.ID, "gunpowder", 4, 0, missing),
                            getModItem(Minecraft.ID, "gunpowder", 3, 0, missing),
                            getModItem(Minecraft.ID, "gunpowder", 2, 0, missing))
                    .outputChances(10000, 7500, 5000).fluidInputs(getFluidStack("hell_blood", 1000)).noFluidOutputs()
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sChemicalBathRecipes);
            GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "enderman_head", 1, 0, missing))
                    .itemOutputs(
                            getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing),
                            getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing),
                            getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing))
                    .outputChances(10000, 5000, 2500).fluidInputs(getFluidStack("hell_blood", 1000)).noFluidOutputs()
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sChemicalBathRecipes);
            GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 3, missing))
                    .itemOutputs(getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0, missing)).outputChances(1000)
                    .fluidInputs(getFluidStack("hell_blood", 1000)).noFluidOutputs().duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(sChemicalBathRecipes);
            GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 2, missing))
                    .itemOutputs(
                            getModItem(Minecraft.ID, "rotten_flesh", 4, 0, missing),
                            getModItem(Minecraft.ID, "leather", 2, 0, missing),
                            GT_OreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 4))
                    .outputChances(10000, 3000, 5000).fluidInputs(getFluidStack("hell_blood", 1000)).noFluidOutputs()
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sChemicalBathRecipes);
        }

        if (Forestry.isModLoaded()) {
            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(IndustrialCraft2.ID, "itemBiochaff", 1L, 0))
                    .itemOutputs(
                            GT_ModHandler.getModItem(Forestry.ID, "mulch", 8L, 0),
                            GT_ModHandler.getModItem(Forestry.ID, "mulch", 4L, 0),
                            GT_ModHandler.getModItem(Forestry.ID, "mulch", 4L, 0))
                    .outputChances(10000, 3300, 2000).fluidInputs(Materials.Water.getFluid(750L)).noFluidOutputs()
                    .duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sChemicalBathRecipes);
        }

        if (GTPlusPlus.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_OreDictUnificator.get(OrePrefixes.nanite, Materials.Silver, 0, false))
                    .itemOutputs(GT_ModHandler.getModItem(GTPlusPlus.ID, "particleBase", 1L, 24)).outputChances(100)
                    .fluidInputs(Materials.Grade7PurifiedWater.getFluid(1000L))
                    .fluidOutputs(Materials.Grade8PurifiedWater.getFluid(900L)).duration(4 * MINUTES + 10 * SECONDS)
                    .eut(TierEU.RECIPE_UEV / 2).addTo(sChemicalBathRecipes);
        }

        if (EnderIO.isModLoaded()) {
            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 4))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72)).noFluidOutputs()
                    .duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sChemicalBathRecipes);
            GT_Values.RA.stdBuilder().itemInputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 1))
                    .itemOutputs(GT_ModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 5))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72)).noFluidOutputs()
                    .duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(sChemicalBathRecipes);
            GT_Values.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemConduitFacade", 1, 0, missing))
                    .itemOutputs(getModItem(EnderIO.ID, "itemConduitFacade", 1, 1, missing)).outputChances(10000)
                    .fluidInputs(Materials.Obsidian.getMolten(576L)).noFluidOutputs().duration(10 * SECONDS).eut(2)
                    .addTo(sChemicalBathRecipes);
            GT_Values.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 2, missing))
                    .itemOutputs(
                            getModItem(EnderIO.ID, "itemMaterial", 2, 1, missing),
                            getModItem(EnderIO.ID, "itemMaterial", 2, 1, missing),
                            getModItem(EnderIO.ID, "itemMaterial", 1, 1, missing))
                    .outputChances(10000, 9000, 5000).fluidInputs(Materials.Rubber.getMolten(144L)).noFluidOutputs()
                    .duration(10 * SECONDS).eut(2).addTo(sChemicalBathRecipes);
        }

        if (PamsHarvestCraft.isModLoaded()) {
            GT_Values.RA.stdBuilder()
                    .itemInputs(GT_ModHandler.getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2L, 0))
                    .itemOutputs(CustomItemList.ArtificialLeather.get(2L))
                    .fluidInputs(Materials.PolyvinylChloride.getMolten(144L)).noFluidOutputs().duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(sChemicalBathRecipes);
        }
    }
}
