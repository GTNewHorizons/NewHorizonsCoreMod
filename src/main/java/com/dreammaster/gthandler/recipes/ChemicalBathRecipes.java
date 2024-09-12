package com.dreammaster.gthandler.recipes;

import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.LogisticsPipes;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.OpenModularTurrets;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.ProjectRedTransmission;
import static gregtech.api.enums.Mods.StevesCarts2;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.recipe.RecipeMaps.chemicalBathRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;
import static gregtech.api.util.GTRecipeBuilder.WILDCARD;
import static net.minecraftforge.fluids.FluidRegistry.getFluidStack;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.GregTechAPI;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;

public class ChemicalBathRecipes implements Runnable {

    @Override
    public void run() {

        ItemStack missing = new ItemStack(Blocks.fire);

        // tanned leather
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Items.leather, 2, 0))
                .itemOutputs(GTModHandler.getModItem(Backpack.ID, "tannedLeather", 1L, 0))
                .fluidInputs(Materials.PhosphoricAcid.getFluid(144)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(CustomItemList.ArtificialLeather.get(2L))
                .itemOutputs(GTModHandler.getModItem(Backpack.ID, "tannedLeather", 1L, 0))
                .fluidInputs(Materials.PhosphoricAcid.getFluid(144)).duration(15 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(chemicalBathRecipes);

        // Chlorine cleaning of pistons
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.sticky_piston, 1, 0))
                .itemOutputs(new ItemStack(Blocks.piston, 1, 0)).fluidInputs(Materials.Chlorine.getGas(10L))
                .duration(1 * SECONDS + 10 * TICKS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);

        // Cooling Hot Netherrack Bricks
        GTValues.RA.stdBuilder().itemInputs(CustomItemList.HotNetherrackBrick.get(1L))
                .itemOutputs(CustomItemList.InfernalBrick.get(1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
        // Cooling Hot Kanthal MV
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Kanthal, 1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Kanthal, 1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_MV).addTo(chemicalBathRecipes);
        // Cooling Hot Tantalum MV
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Tantalum, 1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Tantalum, 1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250))
                .duration(1 * MINUTES + 30 * SECONDS).eut(TierEU.RECIPE_MV).addTo(chemicalBathRecipes);
        // Cooling Hot Silicon MV
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.Silicon, 1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Silicon, 1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(chemicalBathRecipes);
        // Cooling Hot SiliconSG MV
        GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.ingotHot, Materials.SiliconSG, 1L))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.ingot, Materials.SiliconSG, 1L))
                .fluidInputs(new FluidStack(FluidRegistry.getFluid("ic2coolant"), 250))
                .fluidOutputs(new FluidStack(FluidRegistry.getFluid("ic2hotcoolant"), 250)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_MV).addTo(chemicalBathRecipes);

        GTValues.RA.stdBuilder().itemInputs(CustomItemList.MysteriousCrystalGemExquisite.get(1L))
                .itemOutputs(CustomItemList.MysteriousCrystalLens.get(1L)).fluidInputs(Materials.UUMatter.getFluid(144))
                .duration(30 * SECONDS).eut(TierEU.RECIPE_UV).addTo(chemicalBathRecipes);

        GTValues.RA.stdBuilder().itemInputs(ItemList.Circuit_Parts_GlassFiber.get(1L))
                .itemOutputs(Materials.EpoxidFiberReinforced.getPlates(1)).fluidInputs(Materials.Epoxid.getMolten(144L))
                .duration(12 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getIC2Item("carbonFiber", 1))
                .itemOutputs(Materials.EpoxidFiberReinforced.getPlates(1)).fluidInputs(Materials.Epoxid.getMolten(144L))
                .duration(12 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(chemicalBathRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterBlack", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblack", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterRed", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterGreen", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterBrown", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterBlue", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterPurple", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterCyan", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterLightGrey", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 144)).duration(10 * SECONDS)
                .eut(2).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterDarkGrey", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterPink", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterLime", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterYellow", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterCloud", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 144)).duration(10 * SECONDS)
                .eut(2).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterMagenta", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 144)).duration(10 * SECONDS)
                .eut(2).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterOrange", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "itemToolPainter", 1, 0, missing))
                .itemOutputs(getModItem(IndustrialCraft2.ID, "itemToolPainterWhite", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 144)).duration(10 * SECONDS).eut(2)
                .addTo(chemicalBathRecipes);

        // Laser Resistant Plate
        GTValues.RA.stdBuilder().itemInputs(getModItem(IndustrialCraft2.ID, "blockAlloy", 1))
                .itemOutputs(new ItemStack(GregTechAPI.sLaserRender))
                .fluidInputs(FluidRegistry.getFluidStack("molten.hastelloyx", 1152)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(chemicalBathRecipes);

        // Neutronium Casing
        GTValues.RA.stdBuilder().itemInputs(ItemList.Casing_AdvancedRadiationProof.get(1))
                .itemOutputs(ItemList.Neutronium_Casing.get(1)).fluidInputs(Materials.Neutronium.getMolten(8 * 144))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_UV).addTo(chemicalBathRecipes);

        // Superplasticizer-treated high strength concrete
        Fluid naphthalene = FluidRegistry.getFluid("fluid.naphthalene");
        GTValues.RA.stdBuilder().itemInputs(GTModHandler.getIC2Item("reinforcedStone", 1))
                .fluidInputs(new FluidStack(naphthalene, 1000))
                .itemOutputs(ItemList.BlockIndustrialStrengthConcrete.get(1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_IV).addTo(chemicalBathRecipes);

        if (BiomesOPlenty.isModLoaded() && HardcoreEnderExpansion.isModLoaded() && Thaumcraft.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 0, missing))
                    .itemOutputs(
                            getModItem(Minecraft.ID, "bone", 8, 0, missing),
                            getModItem(Minecraft.ID, "bone", 6, 0, missing),
                            getModItem(Minecraft.ID, "bone", 4, 0, missing))
                    .outputChances(10000, 7500, 5000).fluidInputs(getFluidStack("hell_blood", 1000))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 1, missing))
                    .itemOutputs(
                            getModItem(Minecraft.ID, "coal_block", 2, 0, missing),
                            getModItem(Minecraft.ID, "coal_block", 1, 0, missing),
                            getModItem(Minecraft.ID, "coal_block", 1, 0, missing))
                    .outputChances(10000, 7500, 5000).fluidInputs(getFluidStack("hell_blood", 1000))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 4, missing))
                    .itemOutputs(
                            getModItem(Minecraft.ID, "gunpowder", 4, 0, missing),
                            getModItem(Minecraft.ID, "gunpowder", 3, 0, missing),
                            getModItem(Minecraft.ID, "gunpowder", 2, 0, missing))
                    .outputChances(10000, 7500, 5000).fluidInputs(getFluidStack("hell_blood", 1000))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "enderman_head", 1, 0, missing))
                    .itemOutputs(
                            getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing),
                            getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing),
                            getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing))
                    .outputChances(10000, 5000, 2500).fluidInputs(getFluidStack("hell_blood", 1000))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 3, missing))
                    .itemOutputs(getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0, missing)).outputChances(1000)
                    .fluidInputs(getFluidStack("hell_blood", 1000)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                    .addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 2, missing))
                    .itemOutputs(
                            getModItem(Minecraft.ID, "rotten_flesh", 4, 0, missing),
                            getModItem(Minecraft.ID, "leather", 2, 0, missing),
                            GTOreDictUnificator.get(OrePrefixes.dust, Materials.MeatRaw, 4))
                    .outputChances(10000, 3000, 5000).fluidInputs(getFluidStack("hell_blood", 1000))
                    .duration(10 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
        }

        if (Forestry.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(IndustrialCraft2.ID, "itemBiochaff", 1L, 0))
                    .itemOutputs(
                            GTModHandler.getModItem(Forestry.ID, "mulch", 8L, 0),
                            GTModHandler.getModItem(Forestry.ID, "mulch", 4L, 0),
                            GTModHandler.getModItem(Forestry.ID, "mulch", 4L, 0))
                    .outputChances(10000, 3300, 2000).fluidInputs(Materials.Water.getFluid(750L)).duration(25 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
        }

        if (EnderIO.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 4))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72))
                    .duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 1))
                    .itemOutputs(GTModHandler.getModItem(EnderIO.ID, "blockFusedQuartz", 1L, 5))
                    .fluidInputs(new FluidStack(FluidRegistry.getFluid("dye.chemical.dyeblack"), 72))
                    .duration(25 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemConduitFacade", 1, 0, missing))
                    .itemOutputs(getModItem(EnderIO.ID, "itemConduitFacade", 1, 1, missing)).outputChances(10000)
                    .fluidInputs(Materials.Obsidian.getMolten(576L)).duration(10 * SECONDS).eut(2)
                    .addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(EnderIO.ID, "itemMaterial", 1, 2, missing))
                    .itemOutputs(
                            getModItem(EnderIO.ID, "itemMaterial", 2, 1, missing),
                            getModItem(EnderIO.ID, "itemMaterial", 2, 1, missing),
                            getModItem(EnderIO.ID, "itemMaterial", 1, 1, missing))
                    .outputChances(10000, 9000, 5000).fluidInputs(Materials.Rubber.getMolten(144L))
                    .duration(10 * SECONDS).eut(2).addTo(chemicalBathRecipes);
        }

        if (PamsHarvestCraft.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(GTModHandler.getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2L, 0))
                    .itemOutputs(CustomItemList.ArtificialLeather.get(2L))
                    .fluidInputs(Materials.PolyvinylChloride.getMolten(144L)).duration(15 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(chemicalBathRecipes);
        }
        if (LogisticsPipes.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, WILDCARD, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("chlorine", 1000)).duration(1 * MINUTES + 20 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 1, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyeblack", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 2, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyered", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 3, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyegreen", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 4, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyebrown", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 5, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyeblue", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 6, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyepurple", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 7, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyecyan", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 8, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyelightgray", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 9, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyegray", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 10, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyepink", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 11, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyelime", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 12, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyeyellow", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 13, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyelightblue", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 14, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyemagenta", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 15, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyeorange", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 0, missing))
                    .itemOutputs(getModItem(LogisticsPipes.ID, "item.remoteOrdererItem", 1, 16, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.chemical.dyewhite", 288))
                    .duration(1 * MINUTES + 20 * SECONDS).eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
        }
        if (OpenModularTurrets.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.WoodSealed, 1L))
                    .itemOutputs(getModItem(OpenModularTurrets.ID, "hardWallTierOne", 1, 0, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV / 2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.ElectricalSteel, 1L))
                    .itemOutputs(getModItem(OpenModularTurrets.ID, "hardWallTierTwo", 1, 0, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_LV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.DarkSteel, 1L))
                    .itemOutputs(getModItem(OpenModularTurrets.ID, "hardWallTierThree", 1, 0, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV / 2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.EnergeticAlloy, 1L))
                    .itemOutputs(getModItem(OpenModularTurrets.ID, "hardWallTierFour", 1, 0, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_MV).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.VibrantAlloy, 1L))
                    .itemOutputs(getModItem(OpenModularTurrets.ID, "hardWallTierFive", 1, 0, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("wet.concrete", 144)).duration(10 * SECONDS)
                    .eut(TierEU.RECIPE_HV / 2).addTo(chemicalBathRecipes);
        }
        if (StevesCarts2.isModLoaded()) {
            GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 34, missing))
                    .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 37, missing))
                    .fluidInputs(Materials.Redstone.getMolten(144L)).duration(10 * SECONDS).eut(2)
                    .addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 35, missing))
                    .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 38, missing))
                    .fluidInputs(Materials.Redstone.getMolten(576L)).duration(15 * SECONDS).eut(2)
                    .addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 24, missing))
                    .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 42, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 864)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder().itemInputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 24, missing))
                    .itemOutputs(getModItem(StevesCarts2.ID, "ModuleComponents", 1, 65, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 864)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
        }
        if (ProjectRedTransmission.isModLoaded()) {
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 16, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 15, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 144)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 16, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 14, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 144)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 16, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 13, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 144)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 16, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 12, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 16, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 11, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 144)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 16, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 10, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 144)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 16, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 9, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 144)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 16, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 8, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 144)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 16, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 7, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 144)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 16, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 6, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 144)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 16, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 5, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 144)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 16, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 4, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 144)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 16, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 3, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 144)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 16, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 2, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 144)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 16, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 1, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 144)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 17, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 33, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblack", 288)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 17, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 32, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 288)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 17, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 31, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 288)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 17, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 30, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 288)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 17, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 29, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 288)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 17, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 28, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 288)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 17, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 27, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 288)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 17, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 26, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 288)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 17, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 25, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 288)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 17, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 24, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 288)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 17, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 23, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 288)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 17, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 22, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 288)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 17, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 21, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 288)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 17, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 20, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 288)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 17, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 19, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 288)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
            GTValues.RA.stdBuilder()
                    .itemInputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 17, missing))
                    .itemOutputs(getModItem(ProjectRedTransmission.ID, "projectred.transmission.wire", 8, 18, missing))
                    .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 288)).duration(10 * SECONDS)
                    .eut(2).addTo(chemicalBathRecipes);
        }
    }
}
