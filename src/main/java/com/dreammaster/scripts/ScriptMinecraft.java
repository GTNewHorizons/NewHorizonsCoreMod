package com.dreammaster.scripts;

import static com.dreammaster.main.MainRegistry.Module_CustomFuels;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.BloodArsenal;
import static gregtech.api.enums.Mods.CarpentersBlocks;
import static gregtech.api.enums.Mods.ExtraTrees;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.GalaxySpace;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IguanaTweaksTinkerConstruct;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.MagicBees;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.PamsHarvestTheNether;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.arcFurnaceRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.blastFurnaceRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidExtractionRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.recipe.RecipeMaps.slicerRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;
import static net.minecraftforge.fluids.FluidRegistry.getFluidStack;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.gthandler.CustomItemList;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ScriptMinecraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Minecraft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                GalacticraftAmunRa.ID,
                TinkerConstruct.ID,
                BloodArsenal.ID,
                Natura.ID,
                MagicBees.ID,
                Backpack.ID,
                BiomesOPlenty.ID,
                CarpentersBlocks.ID,
                ExtraTrees.ID,
                ExtraUtilities.ID,
                ForbiddenMagic.ID,
                Forestry.ID,
                GTPlusPlus.ID,
                GalaxySpace.ID,
                HardcoreEnderExpansion.ID,
                IguanaTweaksTinkerConstruct.ID,
                IndustrialCraft2.ID,
                PamsHarvestCraft.ID,
                PamsHarvestTheNether.ID,
                Railcraft.ID,
                TaintedMagic.ID,
                Thaumcraft.ID,
                ThaumicBases.ID,
                TwilightForest.ID,
                Witchery.ID);
    }

    @Override
    public void loadRecipes() {
        craftingRecipes();

        GT_ModHandler.addSmeltingRecipe(
                CustomItemList.UnfiredClayBrick.get(1L),
                getModItem(Minecraft.ID, "brick", 1, 0, missing));
        GT_ModHandler
                .addSmeltingRecipe(ItemList.Food_Raw_Bread.get(1L), getModItem(Minecraft.ID, "bread", 1, 0, missing));
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 3, missing))
                .itemOutputs(getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 2, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "hay_block", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "wheat", 9, 0, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestTheNether.ID, "glowFlower", 2, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Glowstone, 1L)).duration(15 * SECONDS)
                .eut(2).addTo(extractorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "clay_ball", 1, 0, missing), ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "brick", 1, 0, missing)).duration(10 * SECONDS).eut(2)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Netherrack, 1L),
                        ItemList.Shape_Mold_Ingot.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "netherbrick", 1, 0, missing)).duration(10 * SECONDS).eut(2)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodArsenal.ID, "glass_shard", 2, 0, missing),
                        ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0, missing)).duration(5).eut(64)
                .addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 5L),
                        CustomItemList.MoldHelmet.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "iron_helmet", 1, 0, missing)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 8L),
                        CustomItemList.MoldChestplate.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "iron_chestplate", 1, 0, missing)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 7L),
                        CustomItemList.MoldLeggings.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "iron_leggings", 1, 0, missing)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 4L),
                        CustomItemList.MoldBoots.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "iron_boots", 1, 0, missing)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Gold, 5L),
                        CustomItemList.MoldHelmet.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "golden_helmet", 1, 0, missing)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Gold, 8L),
                        CustomItemList.MoldChestplate.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "golden_chestplate", 1, 0, missing)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Gold, 7L),
                        CustomItemList.MoldLeggings.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "golden_leggings", 1, 0, missing)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Gold, 4L),
                        CustomItemList.MoldBoots.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "golden_boots", 1, 0, missing)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(alloySmelterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "sand", 1, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 2, 0, missing)).outputChances(10000)
                .fluidInputs(Materials.Oxygen.getGas(2)).duration(1 * SECONDS).eut(256).addTo(arcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "sand", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 2, 0, missing)).outputChances(10000)
                .fluidInputs(Materials.Oxygen.getGas(2)).duration(1 * SECONDS).eut(256).addTo(arcFurnaceRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "barleyFood", 2, 3, missing), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "string", 1, 0, missing)).duration(10 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wheat", 9, 0, missing),
                        getModItem(Minecraft.ID, "string", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "hay_block", 1, 0, missing)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "heatsand", 1, 0, missing),
                        getModItem(Natura.ID, "soil.tainted", 4, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "soul_sand", 1, 0, missing))
                .fluidInputs(Materials.Water.getFluid(1000)).duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 6, 4, missing),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(getModItem(Minecraft.ID, "skull", 1, 1, missing))
                .fluidInputs(Materials.Thaumium.getMolten(216)).duration(10 * SECONDS).eut(96).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        getModItem(Minecraft.ID, "wool", 1, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "torch", 5, 0, missing))
                .fluidInputs(getFluidStack("creosote", 500)).duration(5 * SECONDS).eut(4).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Charcoal, 1L))
                .itemOutputs(getModItem(Minecraft.ID, "torch", 4, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 1L))
                .itemOutputs(getModItem(Minecraft.ID, "torch", 6, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L))
                .itemOutputs(getModItem(Minecraft.ID, "torch", 4, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 4L),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_door", 1, 0, missing))
                .fluidInputs(Materials.Iron.getMolten(16)).duration(20 * SECONDS).eut(4).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 4L),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_door", 1, 0, missing))
                .fluidInputs(Materials.Copper.getMolten(16)).duration(20 * SECONDS).eut(4).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 4L),
                        CustomItemList.SteelBars.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "iron_door", 1, 0, missing))
                .fluidInputs(Materials.Steel.getMolten(16)).duration(20 * SECONDS).eut(8).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Minecraft.ID, "trapdoor", 4, 0, missing))
                .fluidInputs(Materials.Iron.getMolten(16)).duration(30 * SECONDS).eut(4).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Minecraft.ID, "trapdoor", 6, 0, missing))
                .fluidInputs(Materials.Steel.getMolten(16)).duration(30 * SECONDS).eut(4).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "planks", 6, wildcard, missing),
                        getModItem(Minecraft.ID, "book", 3, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bookshelf", 1, 0, missing)).duration(15 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftAmunRa.ID, "tile.log1", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftAmunRa.ID, "tile.wood1", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "tree", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "redwood", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "willow", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "bloodwood", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "Rare Tree", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "Dark Tree", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 0, "{meta:0}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 1, "{meta:1}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 2, "{meta:2}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 3, "{meta:3}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 4, "{meta:4}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 5, "{meta:5}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 6, "{meta:6}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 7, "{meta:7}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 8, "{meta:8}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 9, "{meta:9}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 10, "{meta:10}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 11, "{meta:11}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 12, "{meta:12}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 13, "{meta:13}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 14, "{meta:14}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 15, "{meta:15}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 16, "{meta:16}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 17, "{meta:17}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 18, "{meta:18}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 19, "{meta:19}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 20, "{meta:20}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 21, "{meta:21}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 22, "{meta:22}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 23, "{meta:23}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 24, "{meta:24}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 25, "{meta:25}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 26, "{meta:26}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 27, "{meta:27}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 28, "{meta:28}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 29, "{meta:29}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 30, "{meta:30}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 31, "{meta:31}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 32, "{meta:32}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 33, "{meta:33}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 34, "{meta:34}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 35, "{meta:35}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 36, "{meta:36}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 37, "{meta:37}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 38, "{meta:38}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 39, "{meta:39}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "pamMaple", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "pamPaperbark", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "pamCinnamon", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ThaumicBases.ID, "genLogs", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Witchery.ID, "witchlog", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockRainforestOakLog", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockPineLogLog", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalaxySpace.ID, "barnardaClog", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TaintedMagic.ID, "BlockWarpwoodLog", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TwilightForest.ID, "tile.TFLog", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TwilightForest.ID, "tile.TFMagicLog", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestTheNether.ID, "netherLog", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ForbiddenMagic.ID, "TaintLog", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockRubWood", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockMagicalLog", 1, wildcard, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).duration(10 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        getModItem(Minecraft.ID, "planks", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "fence_gate", 1, 0, missing)).duration(15 * SECONDS).eut(8)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, wildcard, missing),
                        getModItem(Minecraft.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, wildcard, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, wildcard, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, wildcard, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, wildcard, missing),
                        getModItem(Natura.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, wildcard, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, wildcard, missing),
                        getModItem(Witchery.ID, "witchwood", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, wildcard, missing),
                        getModItem(Minecraft.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, wildcard, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, wildcard, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, wildcard, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, wildcard, missing),
                        getModItem(Natura.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, wildcard, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, wildcard, missing),
                        getModItem(Witchery.ID, "witchwood", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, wildcard, missing),
                        getModItem(Minecraft.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, wildcard, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, wildcard, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, wildcard, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, wildcard, missing),
                        getModItem(Natura.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, wildcard, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, wildcard, missing),
                        getModItem(Witchery.ID, "witchwood", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, wildcard, missing),
                        getModItem(Minecraft.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, wildcard, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, wildcard, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, wildcard, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, wildcard, missing),
                        getModItem(Natura.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, wildcard, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, wildcard, missing),
                        getModItem(Witchery.ID, "witchwood", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, wildcard, missing),
                        getModItem(Minecraft.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, wildcard, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, wildcard, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, wildcard, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, wildcard, missing),
                        getModItem(Natura.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, wildcard, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, wildcard, missing),
                        getModItem(Witchery.ID, "witchwood", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, wildcard, missing),
                        getModItem(Minecraft.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, wildcard, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, wildcard, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, wildcard, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, wildcard, missing),
                        getModItem(Natura.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, wildcard, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, wildcard, missing),
                        getModItem(Witchery.ID, "witchwood", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, wildcard, missing),
                        getModItem(Minecraft.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, wildcard, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, wildcard, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, wildcard, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, wildcard, missing),
                        getModItem(Natura.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, wildcard, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, wildcard, missing),
                        getModItem(Witchery.ID, "witchwood", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, wildcard, missing),
                        getModItem(Minecraft.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, wildcard, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, wildcard, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, wildcard, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, wildcard, missing),
                        getModItem(Natura.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, wildcard, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, wildcard, missing),
                        getModItem(Witchery.ID, "witchwood", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, wildcard, missing),
                        getModItem(Minecraft.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, wildcard, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, wildcard, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, wildcard, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, wildcard, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, wildcard, missing),
                        getModItem(Natura.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, wildcard, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, wildcard, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, wildcard, missing),
                        getModItem(Witchery.ID, "witchwood", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockRainforestOakLog", 2, 0, missing),
                        getModItem(Minecraft.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockRainforestOakLog", 2, 0, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockRainforestOakLog", 2, 0, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockRainforestOakLog", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockRainforestOakLog", 2, 0, missing),
                        getModItem(Forestry.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockRainforestOakLog", 2, 0, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockRainforestOakLog", 2, 0, missing),
                        getModItem(Natura.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockRainforestOakLog", 2, 0, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockRainforestOakLog", 2, 0, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockRainforestOakLog", 2, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockRainforestOakLog", 2, 0, missing),
                        getModItem(Witchery.ID, "witchwood", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockPineLogLog", 2, 0, missing),
                        getModItem(Minecraft.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockPineLogLog", 2, 0, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockPineLogLog", 2, 0, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockPineLogLog", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockPineLogLog", 2, 0, missing),
                        getModItem(Forestry.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockPineLogLog", 2, 0, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockPineLogLog", 2, 0, missing),
                        getModItem(Natura.ID, "planks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockPineLogLog", 2, 0, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockPineLogLog", 2, 0, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockPineLogLog", 2, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockPineLogLog", 2, 0, missing),
                        getModItem(Witchery.ID, "witchwood", 2, wildcard, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        getModItem(Minecraft.ID, "stone_button", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "lever", 1, 0, missing)).duration(2 * SECONDS + 10 * TICKS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "plants", 1, 8, missing),
                        getModItem(Minecraft.ID, "stone_button", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "lever", 1, 0, missing)).duration(2 * SECONDS + 10 * TICKS)
                .eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Wood, 1L),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(getModItem(Minecraft.ID, "ladder", 2, 0, missing)).duration(5 * SECONDS).eut(8)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(getModItem(Minecraft.ID, "ladder", 4, 0, missing)).duration(5 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(getModItem(Minecraft.ID, "ladder", 8, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Aluminium, 1L),
                        GT_Utility.getIntegratedCircuit(6))
                .itemOutputs(getModItem(Minecraft.ID, "ladder", 32, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "brick", 8, 0, missing), GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "brick_block", 2, 0, missing))
                .fluidInputs(Materials.Water.getFluid(500)).duration(15 * SECONDS).eut(16).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), ItemList.Plank_Oak.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Spruce.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Birch.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Jungle.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Acacia.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_DarkOak.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Larch.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Teak.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Acacia_Green.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Lime.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Chestnut.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Wenge.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Baobab.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Sequoia.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Kapok.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Ebony.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Mahagony.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Balsa.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Willow.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Walnut.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                        ItemList.Plank_Greenheart.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_Oak.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_Spruce.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_Birch.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_Jungle.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_Acacia.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_DarkOak.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_Larch.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_Teak.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, wildcard, missing),
                        ItemList.Plank_Acacia_Green.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_Lime.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, wildcard, missing),
                        ItemList.Plank_Chestnut.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_Wenge.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_Baobab.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_Sequoia.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_Kapok.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_Ebony.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, wildcard, missing),
                        ItemList.Plank_Mahagony.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_Balsa.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_Willow.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 1, wildcard, missing), ItemList.Plank_Walnut.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, wildcard, missing),
                        ItemList.Plank_Greenheart.get(1L))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).duration(5 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        ItemList.Plank_Oak.get(2L),
                        GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 2, 0, missing)).duration(5 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(ItemList.Plank_Oak.get(2L), getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 2, 0, missing)).duration(5 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone_slab", 2, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Minecraft.ID, "stone_pressure_plate", 2, 0, missing)).duration(5 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone_slab", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Minecraft.ID, "stone_pressure_plate", 2, 0, missing)).duration(5 * SECONDS)
                .eut(8).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(Minecraft.ID, "planks", 2, wildcard, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 0, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 1, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 2, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 3, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 4, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 5, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 6, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 7, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 8, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 9, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 10, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 11, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 12, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 13, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 14, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 15, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(GalacticraftAmunRa.ID, "tile.wood1", 2, 3, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(GalacticraftAmunRa.ID, "tile.wood1", 2, 2, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(Natura.ID, "planks", 2, wildcard, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, wildcard, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(Forestry.ID, "planks", 2, wildcard, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, wildcard, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 0, "{meta:0}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 1, "{meta:1}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 2, "{meta:2}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 3, "{meta:3}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 4, "{meta:4}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 5, "{meta:5}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 6, "{meta:6}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 7, "{meta:7}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 8, "{meta:8}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 9, "{meta:9}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 10, "{meta:10}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 11, "{meta:11}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 12, "{meta:12}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 13, "{meta:13}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 14, "{meta:14}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 15, "{meta:15}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 16, "{meta:16}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 17, "{meta:17}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 18, "{meta:18}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 19, "{meta:19}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 20, "{meta:20}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 21, "{meta:21}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 22, "{meta:22}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 23, "{meta:23}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 24, "{meta:24}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 25, "{meta:25}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 26, "{meta:26}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 27, "{meta:27}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 28, "{meta:28}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 29, "{meta:29}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 30, "{meta:30}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 31, "{meta:31}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 32, "{meta:32}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 33, "{meta:33}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 34, "{meta:34}", missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ThaumicBases.ID, "enderPlanks", 2, 0, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(Witchery.ID, "witchwood", 2, wildcard, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(GalaxySpace.ID, "barnardaCplanks", 2, 0, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(TaintedMagic.ID, "BlockWarpwoodPlanks", 2, 0, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, 0, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(TwilightForest.ID, "tile.TFTowerStone", 2, wildcard, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(TwilightForest.ID, "tile.TFPlanks", 2, wildcard, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, wildcard, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ForbiddenMagic.ID, "TaintPlank", 2, wildcard, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                        getModItem(Minecraft.ID, "comparator", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Gold, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Gold, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 1L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "clock", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "leather", 4, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "saddle", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        CustomItemList.ArtificialLeather.get(4L),
                        GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Iron, 2L),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "saddle", 1, 0, missing)).duration(5 * SECONDS).eut(24)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).specialValue(1000).addTo(blastFurnaceRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(Minecraft.ID, "glass_pane", 1, 0, missing)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_MV).specialValue(1000).addTo(blastFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_button", 2, 0, missing))
                .fluidInputs(Materials.Water.getFluid(4)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_button", 2, 0, missing))
                .fluidInputs(getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_button", 2, 0, missing))
                .fluidInputs(getFluidStack("lubricant", 1)).duration(1 * SECONDS + 5 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "stone_button", 2, 0, missing))
                .fluidInputs(Materials.Water.getFluid(4)).duration(2 * SECONDS + 10 * TICKS).eut(8)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "stone_button", 2, 0, missing))
                .fluidInputs(getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS).eut(8)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "stone_button", 2, 0, missing))
                .fluidInputs(getFluidStack("lubricant", 1)).duration(1 * SECONDS + 5 * TICKS).eut(8)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "sand", 1, wildcard, missing))
                .fluidOutputs(Materials.Glass.getMolten(144)).duration(10 * SECONDS).eut(48)
                .addTo(fluidExtractionRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "sand", 4, wildcard, missing),
                        getModItem(Minecraft.ID, "dirt", 1, wildcard, missing),
                        getModItem(MagicBees.ID, "wax", 4, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "soul_sand", 4, 0, missing))
                .fluidInputs(Materials.Water.getFluid(1000)).duration(5 * SECONDS).eut(16).addTo(mixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "blaze_powder", 3, 0, missing),
                        getModItem(Minecraft.ID, "gunpowder", 3, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Coal, 3L))
                .itemOutputs(getModItem(Minecraft.ID, "fire_charge", 1, 0, missing)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(mixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "melon_block", 1, 0, missing), ItemList.Shape_Slicer_Flat.get(0L))
                .itemOutputs(getModItem(Minecraft.ID, "melon", 8, 0, missing)).duration(5 * SECONDS).eut(8)
                .addTo(slicerRecipes);
        Module_CustomFuels
                .registerCustomFuelValue(getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0, missing), (short) 75);

    }

    private void craftingRecipes() {
        addShapelessRecipe(
                getModItem(Minecraft.ID, "crafting_table", 1, 0, missing),
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                "logWood",
                "logWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                "logWood",
                "plankWood",
                "logWood",
                "plankWood",
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                "plankWood",
                "logWood",
                "plankWood",
                "logWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "trapped_chest", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "tripwire_hook", 1, 0, missing),
                null,
                "screwAnyIron",
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                "screwAnyIron",
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "furnace", 1, 0, missing),
                "cobblestone",
                "cobblestone",
                "cobblestone",
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                "cobblestone",
                "cobblestone",
                "cobblestone");
        addShapedRecipe(
                getModItem(Minecraft.ID, "dispenser", 1, 0, missing),
                "cobblestone",
                "ringAnyIron",
                "cobblestone",
                "springIron",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "springIron",
                "gearGtSmallAnyIron",
                "stickRedAlloy",
                "gearGtSmallAnyIron");
        addShapedRecipe(
                getModItem(Minecraft.ID, "dropper", 1, 0, missing),
                "cobblestone",
                "ringAnyIron",
                "cobblestone",
                "springSmallIron",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "springSmallIron",
                "gearGtSmallAnyIron",
                "stickRedAlloy",
                "gearGtSmallAnyIron");
        addShapedRecipe(
                getModItem(Minecraft.ID, "piston", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "gearGtSmallAnyIron",
                "fenceWood",
                "gearGtSmallAnyIron",
                "cobblestone",
                "plateRedAlloy",
                "cobblestone");
        addShapedRecipe(
                getModItem(Minecraft.ID, "sticky_piston", 1, 0, missing),
                null,
                "craftingToolSoftHammer",
                null,
                null,
                "slimeball",
                null,
                null,
                getModItem(Minecraft.ID, "piston", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "rail", 8, 0, missing),
                "screwAnyIron",
                null,
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "craftingToolScrewdriver",
                null,
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Minecraft.ID, "detector_rail", 1, 0, missing),
                "screwAnyIron",
                getModItem(Railcraft.ID, "detector", 1, 1, missing),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "craftingToolScrewdriver",
                "stickRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Minecraft.ID, "activator_rail", 2, 0, missing),
                "screwAnyIron",
                getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing),
                "screwAnyIron",
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                "craftingToolScrewdriver",
                "stickRedAlloy",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Minecraft.ID, "noteblock", 1, 0, missing),
                "plankWood",
                "plankWood",
                "plankWood",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "gearWood",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "plankWood",
                "stickRedAlloy",
                "plankWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "jukebox", 1, 0, missing),
                "logWood",
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Diamond, 1L),
                "logWood",
                getModItem(Minecraft.ID, "noteblock", 1, 0, missing),
                "record",
                getModItem(Minecraft.ID, "noteblock", 1, 0, missing),
                "logWood",
                "gearAnyIron",
                "logWood");
        addShapelessRecipe(
                getModItem(Minecraft.ID, "lit_pumpkin", 1, 0, missing),
                getModItem(Minecraft.ID, "pumpkin", 1, 0, missing),
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                "craftingToolKnife");
        addShapedRecipe(
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "trapdoor", 2, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing),
                "stickWood",
                "screwAnyIron",
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "trapdoor", 3, 0, missing),
                getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing),
                "stickWood",
                "screwSteel",
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "stone_pressure_plate", 2, 0, missing),
                "screwIron",
                "craftingToolHardHammer",
                "screwIron",
                getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                "springAnyIron",
                getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_pressure_plate", 2, 0, missing),
                "screwWood",
                "craftingToolHardHammer",
                "screwWood",
                ItemList.Plank_Oak.get(1L),
                "springAnyIron",
                ItemList.Plank_Oak.get(1L),
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood");
        addShapelessRecipe(getModItem(Minecraft.ID, "glass_pane", 2, 0, missing), "craftingToolSaw", "glass");
        addShapedRecipe(getModItem(Minecraft.ID, "torch", 3, 0, missing), "gemCoal", null, "stickWood", null);
        addShapedRecipe(getModItem(Minecraft.ID, "torch", 2, 0, missing), "gemCharcoal", null, "stickWood", null);
        addShapedRecipe(getModItem(Minecraft.ID, "torch", 1, 0, missing), "gemLignite", null, "stickWood", null);
        addShapedRecipe(getModItem(Minecraft.ID, "torch", 5, 0, missing), "fuelCoke", null, "stickWood", null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 5, 0, missing),
                "blockWool",
                getModItem(Railcraft.ID, "fluid.creosote.bucket", 1, 0, missing),
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 4, 0, missing),
                getModItem(TwilightForest.ID, "item.torchberries", 1, 0, missing),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 3, 0, missing),
                "itemBeeswax",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 2, 0, missing),
                getModItem(IndustrialCraft2.ID, "itemHarz", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "stickWood",
                null);
        addShapelessRecipe(
                getModItem(Minecraft.ID, "lever", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "stone_button", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "stone_button", 2, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_button", 2, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing),
                "dustRedstone",
                null,
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "ladder", 2, 0, missing),
                "stickWood",
                "craftingToolScrewdriver",
                "stickWood",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "screwWood",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "stickWood",
                "craftingToolSoftHammer",
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "ladder", 4, 0, missing),
                "stickWood",
                "craftingToolScrewdriver",
                "stickWood",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "screwAnyIron",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "stickWood",
                "craftingToolSoftHammer",
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "ladder", 8, 0, missing),
                "stickWood",
                "craftingToolScrewdriver",
                "stickWood",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "screwSteel",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "stickWood",
                "craftingToolSoftHammer",
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "stickWood",
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "stickWood",
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 2, 0, missing),
                "screwAnyIron",
                "craftingToolScrewdriver",
                "screwAnyIron",
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "stickWood",
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 4, 0, missing),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "stickWood",
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 2, 0, missing),
                null,
                null,
                null,
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "stickWood",
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 4, 0, missing),
                "screwAnyIron",
                "craftingToolScrewdriver",
                "screwAnyIron",
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "stickWood",
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 6, 0, missing),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "stickWood",
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 1, 0, missing),
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 2, 0, missing),
                "screwAnyIron",
                "craftingToolScrewdriver",
                "screwAnyIron",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 4, 0, missing),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "planks", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 2, 0, missing),
                null,
                null,
                null,
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 4, 0, missing),
                "screwAnyIron",
                "craftingToolScrewdriver",
                "screwAnyIron",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 6, 0, missing),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                "stickWood",
                getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "redstone_lamp", 1, 0, missing),
                getModItem(Minecraft.ID, "glass_pane", 1, 0, missing),
                getModItem(Minecraft.ID, "glass_pane", 1, 0, missing),
                getModItem(Minecraft.ID, "glass_pane", 1, 0, missing),
                getModItem(Minecraft.ID, "glass_pane", 1, 0, missing),
                getModItem(Minecraft.ID, "glowstone", 1, 0, missing),
                getModItem(Minecraft.ID, "glass_pane", 1, 0, missing),
                getModItem(Minecraft.ID, "glass_pane", 1, 0, missing),
                "stickRedAlloy",
                getModItem(Minecraft.ID, "glass_pane", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "tripwire_hook", 1, 0, missing),
                "ringAnyIron",
                "stickWood",
                "ringAnyIron",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "anvil", 1, 0, missing),
                "blockIron",
                "blockIron",
                "blockIron",
                "screwAnyIron",
                "blockIron",
                "screwAnyIron",
                "plateAnyIron",
                "blockIron",
                "plateAnyIron");
        addShapedRecipe(
                getModItem(Minecraft.ID, "daylight_detector", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "plateNetherQuartz",
                "plateCertusQuartz",
                "plateNetherQuartz",
                "slabWood",
                "stickRedAlloy",
                "slabWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                "plateAnyIron",
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                "plateAnyIron",
                "plateAnyIron",
                "gearAnyIron",
                "plateAnyIron",
                "craftingToolHardHammer",
                "plateAnyIron",
                "craftingToolFile");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 0, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeWhite",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 0, missing), "blockWool", "dyeWhite");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "string", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing),
                getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 1, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeOrange",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 1, missing), "blockWool", "dyeOrange");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 2, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeMagenta",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 2, missing), "blockWool", "dyeMagenta");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 3, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeLightBlue",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 3, missing), "blockWool", "dyeLightBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 4, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeYellow",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 4, missing), "blockWool", "dyeYellow");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 5, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeLime",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 5, missing), "blockWool", "dyeLime");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 6, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyePink",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 6, missing), "blockWool", "dyePink");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 7, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeGray",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 7, missing), "blockWool", "dyeGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 8, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeLightGray",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 8, missing), "blockWool", "dyeLightGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 9, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeCyan",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 9, missing), "blockWool", "dyeCyan");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 10, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyePurple",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 10, missing), "blockWool", "dyePurple");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 11, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeBlue",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 11, missing), "blockWool", "dyeBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 12, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeBrown",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 12, missing), "blockWool", "dyeBrown");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 13, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeGreen",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 13, missing), "blockWool", "dyeGreen");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 14, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeRed",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 14, missing), "blockWool", "dyeRed");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 15, missing),
                "blockWool",
                "blockWool",
                "blockWool",
                "blockWool",
                "dyeBlack",
                "blockWool",
                "blockWool",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "blockWool");
        addShapelessRecipe(getModItem(Minecraft.ID, "wool", 1, 15, missing), "blockWool", "dyeBlack");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 0, missing),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeWhite",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 0, missing), "glass", "dyeWhite");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 1, missing),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeOrange",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 1, missing), "glass", "dyeOrange");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 2, missing),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeMagenta",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 2, missing), "glass", "dyeMagenta");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 3, missing),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeLightBlue",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 3, missing), "glass", "dyeLightBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 4, missing),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeYellow",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 4, missing), "glass", "dyeYellow");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 5, missing),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeLime",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 5, missing), "glass", "dyeLime");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 6, missing),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyePink",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 6, missing), "glass", "dyePink");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 7, missing),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeGray",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 7, missing), "glass", "dyeGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 8, missing),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeLightGray",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 8, missing), "glass", "dyeLightGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 9, missing),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeCyan",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 9, missing), "glass", "dyeCyan");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 10, missing),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyePurple",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 10, missing), "glass", "dyePurple");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 11, missing),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeBlue",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 11, missing), "glass", "dyeBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 12, missing),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeBrown",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 12, missing), "glass", "dyeBrown");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 13, missing),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeGreen",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 13, missing), "glass", "dyeGreen");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 14, missing),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeRed",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 14, missing), "glass", "dyeRed");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 15, missing),
                "glass",
                "glass",
                "glass",
                "glass",
                "dyeBlack",
                "glass",
                "glass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "glass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass", 1, 15, missing), "glass", "dyeBlack");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 0, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeWhite",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 0, missing), "paneGlass", "dyeWhite");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 1, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeOrange",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 1, missing), "paneGlass", "dyeOrange");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 2, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeMagenta",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 2, missing), "paneGlass", "dyeMagenta");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 3, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeLightBlue",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 3, missing), "paneGlass", "dyeLightBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 4, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeYellow",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 4, missing), "paneGlass", "dyeYellow");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 5, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeLime",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 5, missing), "paneGlass", "dyeLime");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 6, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyePink",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 6, missing), "paneGlass", "dyePink");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 7, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeGray",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 7, missing), "paneGlass", "dyeGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 8, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeLightGray",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 8, missing), "paneGlass", "dyeLightGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 9, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeCyan",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 9, missing), "paneGlass", "dyeCyan");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 10, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyePurple",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 10, missing), "paneGlass", "dyePurple");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 11, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeBlue",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 11, missing), "paneGlass", "dyeBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 12, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeBrown",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 12, missing), "paneGlass", "dyeBrown");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 13, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeGreen",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 13, missing), "paneGlass", "dyeGreen");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 14, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeRed",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 14, missing), "paneGlass", "dyeRed");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 15, missing),
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "paneGlass",
                "dyeBlack",
                "paneGlass",
                "paneGlass",
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                "paneGlass");
        addShapelessRecipe(getModItem(Minecraft.ID, "stained_glass_pane", 1, 15, missing), "paneGlass", "dyeBlack");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "wool", 1, 0, missing),
                getModItem(Minecraft.ID, "wool", 1, 0, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 0, missing),
                getModItem(Minecraft.ID, "wool", 1, 0, missing),
                getModItem(Minecraft.ID, "wool", 1, 0, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 1, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeOrange",
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 1, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeOrange");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 1, missing),
                getModItem(Minecraft.ID, "wool", 1, 1, missing),
                getModItem(Minecraft.ID, "wool", 1, 1, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 1, missing),
                getModItem(Minecraft.ID, "wool", 1, 1, missing),
                getModItem(Minecraft.ID, "wool", 1, 1, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 2, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeMagenta",
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 2, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeMagenta");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 2, missing),
                getModItem(Minecraft.ID, "wool", 1, 2, missing),
                getModItem(Minecraft.ID, "wool", 1, 2, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 2, missing),
                getModItem(Minecraft.ID, "wool", 1, 2, missing),
                getModItem(Minecraft.ID, "wool", 1, 2, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 3, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeLightBlue",
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 3, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeLightBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 3, missing),
                getModItem(Minecraft.ID, "wool", 1, 3, missing),
                getModItem(Minecraft.ID, "wool", 1, 3, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 3, missing),
                getModItem(Minecraft.ID, "wool", 1, 3, missing),
                getModItem(Minecraft.ID, "wool", 1, 3, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 4, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeYellow",
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 4, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeYellow");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 4, missing),
                getModItem(Minecraft.ID, "wool", 1, 4, missing),
                getModItem(Minecraft.ID, "wool", 1, 4, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 4, missing),
                getModItem(Minecraft.ID, "wool", 1, 4, missing),
                getModItem(Minecraft.ID, "wool", 1, 4, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 5, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeLime",
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 5, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeLime");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 5, missing),
                getModItem(Minecraft.ID, "wool", 1, 5, missing),
                getModItem(Minecraft.ID, "wool", 1, 5, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 5, missing),
                getModItem(Minecraft.ID, "wool", 1, 5, missing),
                getModItem(Minecraft.ID, "wool", 1, 5, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 6, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyePink",
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 6, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyePink");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 6, missing),
                getModItem(Minecraft.ID, "wool", 1, 6, missing),
                getModItem(Minecraft.ID, "wool", 1, 6, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 6, missing),
                getModItem(Minecraft.ID, "wool", 1, 6, missing),
                getModItem(Minecraft.ID, "wool", 1, 6, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 7, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeGray",
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 7, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 7, missing),
                getModItem(Minecraft.ID, "wool", 1, 7, missing),
                getModItem(Minecraft.ID, "wool", 1, 7, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 7, missing),
                getModItem(Minecraft.ID, "wool", 1, 7, missing),
                getModItem(Minecraft.ID, "wool", 1, 7, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 8, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeLightGray",
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 8, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeLightGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 8, missing),
                getModItem(Minecraft.ID, "wool", 1, 8, missing),
                getModItem(Minecraft.ID, "wool", 1, 8, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 8, missing),
                getModItem(Minecraft.ID, "wool", 1, 8, missing),
                getModItem(Minecraft.ID, "wool", 1, 8, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 9, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeCyan",
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 9, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeCyan");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 9, missing),
                getModItem(Minecraft.ID, "wool", 1, 9, missing),
                getModItem(Minecraft.ID, "wool", 1, 9, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 9, missing),
                getModItem(Minecraft.ID, "wool", 1, 9, missing),
                getModItem(Minecraft.ID, "wool", 1, 9, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 10, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyePurple",
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 10, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyePurple");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 10, missing),
                getModItem(Minecraft.ID, "wool", 1, 10, missing),
                getModItem(Minecraft.ID, "wool", 1, 10, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 10, missing),
                getModItem(Minecraft.ID, "wool", 1, 10, missing),
                getModItem(Minecraft.ID, "wool", 1, 10, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 11, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeBlue",
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 11, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 11, missing),
                getModItem(Minecraft.ID, "wool", 1, 11, missing),
                getModItem(Minecraft.ID, "wool", 1, 11, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 11, missing),
                getModItem(Minecraft.ID, "wool", 1, 11, missing),
                getModItem(Minecraft.ID, "wool", 1, 11, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 12, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeBrown",
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 12, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeBrown");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 12, missing),
                getModItem(Minecraft.ID, "wool", 1, 12, missing),
                getModItem(Minecraft.ID, "wool", 1, 12, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 12, missing),
                getModItem(Minecraft.ID, "wool", 1, 12, missing),
                getModItem(Minecraft.ID, "wool", 1, 12, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 13, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeGreen",
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 13, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeGreen");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 13, missing),
                getModItem(Minecraft.ID, "wool", 1, 13, missing),
                getModItem(Minecraft.ID, "wool", 1, 13, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 13, missing),
                getModItem(Minecraft.ID, "wool", 1, 13, missing),
                getModItem(Minecraft.ID, "wool", 1, 13, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 14, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeRed",
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 14, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeRed");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 14, missing),
                getModItem(Minecraft.ID, "wool", 1, 14, missing),
                getModItem(Minecraft.ID, "wool", 1, 14, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 14, missing),
                getModItem(Minecraft.ID, "wool", 1, 14, missing),
                getModItem(Minecraft.ID, "wool", 1, 14, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 15, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeBlack",
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 15, missing),
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                "dyeBlack");
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 15, missing),
                getModItem(Minecraft.ID, "wool", 1, 15, missing),
                getModItem(Minecraft.ID, "wool", 1, 15, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 15, missing),
                getModItem(Minecraft.ID, "wool", 1, 15, missing),
                getModItem(Minecraft.ID, "wool", 1, 15, missing),
                "craftingToolSaw",
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeWhite",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeWhite");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 1, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeOrange",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 1, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeOrange");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 2, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeMagenta",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 2, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeMagenta");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 3, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeLightBlue",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 3, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeLightBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 4, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeYellow",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 4, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeYellow");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 5, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeLime",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 5, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeLime");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 6, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyePink",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 6, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyePink");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 7, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeGray",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 7, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 8, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeLightGray",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 8, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeLightGray");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 9, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeCyan",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 9, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeCyan");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 10, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyePurple",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 10, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyePurple");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 11, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeBlue",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 11, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeBlue");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 12, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeBrown",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 12, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeBrown");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 13, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeGreen",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 13, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeGreen");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 14, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeRed",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 14, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeRed");
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 15, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeBlack",
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 15, missing),
                getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                "dyeBlack");
        addShapelessRecipe(
                getModItem(Minecraft.ID, "sugar", 1, 0, missing),
                "craftingToolMortar",
                getModItem(Minecraft.ID, "reeds", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_sword", 1, 0, missing),
                null,
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                null,
                "craftingToolFile",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                null,
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_shovel", 1, 0, missing),
                "craftingToolFile",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                null,
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null,
                null,
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_pickaxe", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                getModItem(Minecraft.ID, "diamond", 1, 0, missing),
                getModItem(Minecraft.ID, "diamond", 1, 0, missing),
                "craftingToolFile",
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                "craftingToolHardHammer",
                null,
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_axe", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                getModItem(Minecraft.ID, "diamond", 1, 0, missing),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null,
                "craftingToolFile",
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_hoe", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                getModItem(Minecraft.ID, "diamond", 1, 0, missing),
                "craftingToolHardHammer",
                "craftingToolFile",
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null,
                null,
                GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L),
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_helmet", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_chestplate", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L));
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_leggings", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                null,
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L));
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_boots", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                null,
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                "craftingToolHardHammer",
                GT_OreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "iron_horse_armor", 1, 0, missing),
                "craftingToolHardHammer",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "iron_helmet", 1, 0, missing),
                "plateIron",
                getModItem(Minecraft.ID, "iron_chestplate", 1, 0, missing),
                "plateIron",
                getModItem(Minecraft.ID, "iron_leggings", 1, 0, missing),
                "screwIron",
                getModItem(Minecraft.ID, "iron_leggings", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "golden_horse_armor", 1, 0, missing),
                "craftingToolHardHammer",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "golden_helmet", 1, 0, missing),
                "plateGold",
                getModItem(Minecraft.ID, "golden_chestplate", 1, 0, missing),
                "plateGold",
                getModItem(Minecraft.ID, "golden_leggings", 1, 0, missing),
                "screwGold",
                getModItem(Minecraft.ID, "golden_leggings", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_horse_armor", 1, 0, missing),
                "craftingToolHardHammer",
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "diamond_helmet", 1, 0, missing),
                "plateDiamond",
                getModItem(Minecraft.ID, "diamond_chestplate", 1, 0, missing),
                "plateDiamond",
                getModItem(Minecraft.ID, "diamond_leggings", 1, 0, missing),
                "screwDiamond",
                getModItem(Minecraft.ID, "diamond_leggings", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "saddle", 1, 0, missing),
                "itemLeather",
                getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                "itemLeather",
                "itemLeather",
                getModItem(Minecraft.ID, "carpet", 1, wildcard, missing),
                "itemLeather",
                "ringAnyIron",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "ringAnyIron");
        addShapedRecipe(
                getModItem(Minecraft.ID, "clock", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Gold, 1L),
                "plateGold",
                GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Gold, 1L),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 1L),
                getModItem(Minecraft.ID, "comparator", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.bolt, Materials.Gold, 1L),
                "craftingToolScrewdriver",
                GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Gold, 1L),
                "craftingToolWrench");
        addShapedRecipe(
                getModItem(Minecraft.ID, "compass", 1, 0, missing),
                "screwIron",
                "paneGlass",
                "boltIron",
                "ringZinc",
                "plateIron",
                "ringZinc",
                "boltRedAlloy",
                "craftingToolScrewdriver",
                "screwIron");
        addShapedRecipe(
                getModItem(Minecraft.ID, "clay", 2, 0, missing),
                "itemClay",
                "itemClay",
                "itemClay",
                "itemClay",
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                "itemClay",
                "itemClay",
                "itemClay",
                "itemClay");
        addShapedRecipe(
                getModItem(Minecraft.ID, "clay", 2, 0, missing),
                "itemClay",
                "itemClay",
                "itemClay",
                "itemClay",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                "itemClay",
                "itemClay",
                "itemClay",
                "itemClay");
        addShapedRecipe(
                getModItem(Minecraft.ID, "pumpkin_seeds", 2, 0, missing),
                getModItem(Minecraft.ID, "pumpkin", 1, 0, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Minecraft.ID, "pumpkin_seeds", 2, 0, missing),
                getModItem(Minecraft.ID, "pumpkin", 1, 0, missing),
                "craftingToolSoftHammer",
                getModItem(Minecraft.ID, "pumpkin", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "melon_seeds", 1, 0, missing),
                getModItem(Minecraft.ID, "melon", 1, 0, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Minecraft.ID, "melon_seeds", 1, 0, missing),
                getModItem(Minecraft.ID, "melon", 1, 0, missing),
                "craftingToolSoftHammer",
                getModItem(Minecraft.ID, "melon", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "melon", 6, 0, missing),
                "craftingToolKnife",
                getModItem(Minecraft.ID, "melon_block", 1, 0, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "gunpowder", 1, 0, missing),
                "dustSmallGunpowder",
                "dustSmallGunpowder",
                "dustSmallGunpowder",
                "dustSmallGunpowder");
        addShapelessRecipe(
                ItemList.Food_Dough.get(1L),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L));
        addShapelessRecipe(
                ItemList.Food_Dough.get(1L),
                getModItem(PamsHarvestCraft.ID, "freshwaterItem", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Wheat, 1L),
                getModItem(PamsHarvestCraft.ID, "freshwaterItem", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "chest_minecart", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                "craftingToolWrench",
                null,
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "furnace_minecart", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(Minecraft.ID, "furnace", 1, 0, missing),
                "craftingToolWrench",
                null,
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "hopper_minecart", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                "craftingToolWrench",
                null,
                getModItem(Minecraft.ID, "minecart", 1, 0, missing),
                null,
                null,
                "craftingToolScrewdriver",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "map", 1, 0, missing),
                "paperEmpty",
                "paperEmpty",
                "paperEmpty",
                "paperEmpty",
                getModItem(Minecraft.ID, "compass", 1, 0, missing),
                "paperEmpty",
                "paperEmpty",
                "paperEmpty",
                "paperEmpty");
        addShapelessRecipe(
                getModItem(Minecraft.ID, "dye", 3, 15, missing),
                getModItem(Minecraft.ID, "bone", 1, 0, missing),
                "craftingToolMortar");
        addShapedRecipe(
                getModItem(Minecraft.ID, "lead", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "slimeball",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "pumpkin_pie", 1, 0, missing),
                "craftingToolRollingPin",
                getModItem(Minecraft.ID, "pumpkin", 1, 0, missing),
                "dustSugar",
                getModItem(Minecraft.ID, "pumpkin", 1, 0, missing),
                "dustSugar",
                null,
                "dustSugar",
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "comparator", 1, 0, missing),
                "screwIron",
                "craftingRedstoneTorch",
                "screwIron",
                "craftingRedstoneTorch",
                "plateNetherQuartz",
                "craftingRedstoneTorch",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "comparator", 1, 0, missing),
                "screwIron",
                "craftingRedstoneTorch",
                "screwIron",
                "craftingRedstoneTorch",
                "plateCertusQuartz",
                "craftingRedstoneTorch",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "comparator", 1, 0, missing),
                "screwIron",
                "craftingRedstoneTorch",
                "screwIron",
                "craftingRedstoneTorch",
                "plateChargedCertusQuartz",
                "craftingRedstoneTorch",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "comparator", 1, 0, missing),
                "screwIron",
                "craftingRedstoneTorch",
                "screwIron",
                "craftingRedstoneTorch",
                "plateQuartzite",
                "craftingRedstoneTorch",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                "screwIron",
                null,
                "screwIron",
                "craftingRedstoneTorch",
                "craftingToolScrewdriver",
                "craftingRedstoneTorch",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing),
                "stickRedAlloy",
                getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "item_frame", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "ringAnyIron",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "stickWood",
                "itemLeather",
                "stickWood",
                "stickWood",
                "stickWood",
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "bed", 1, 0, missing),
                getModItem(Minecraft.ID, "carpet", 1, wildcard, missing),
                getModItem(Minecraft.ID, "carpet", 1, wildcard, missing),
                getModItem(Minecraft.ID, "carpet", 1, wildcard, missing),
                "plankWood",
                "plankWood",
                "plankWood",
                "fenceWood",
                "craftingToolSoftHammer",
                "fenceWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "fishing_rod", 1, 0, missing),
                null,
                null,
                "stickLongWood",
                null,
                "stickLongWood",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "stickLongWood",
                "craftingToolWireCutter",
                "ringAnyIron");
        addShapedRecipe(
                getModItem(Minecraft.ID, "paper", 2, 0, missing),
                "dustWood",
                "dustWood",
                "dustWood",
                "dustWood",
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                "dustWood",
                "dustWood",
                "dustWood",
                "dustWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "paper", 2, 0, missing),
                "dustWood",
                "dustWood",
                "dustWood",
                "dustWood",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                "dustWood",
                "dustWood",
                "dustWood",
                "dustWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                getModItem(Natura.ID, "barleyFood", 1, 3, missing),
                getModItem(Natura.ID, "barleyFood", 1, 3, missing),
                getModItem(Natura.ID, "barleyFood", 1, 3, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "flower_pot", 1, 0, missing),
                "craftingToolFile",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketFired", 1, 0, missing));
        addShapelessRecipe(getModItem(Minecraft.ID, "stone_slab", 1, 0, missing), "craftingToolSaw", "stone");
        addShapelessRecipe(getModItem(Minecraft.ID, "stone_slab", 1, 1, missing), "craftingToolSaw", "sandstone");
        addShapelessRecipe(getModItem(Minecraft.ID, "stone_slab", 1, 3, missing), "craftingToolSaw", "cobblestone");
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stone_slab", 1, 4, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "brick_block", 1, 0, missing));
        addShapelessRecipe(getModItem(Minecraft.ID, "stone_slab", 1, 5, missing), "craftingToolSaw", "stoneBricks");
        addShapelessRecipe(
                getModItem(Minecraft.ID, "stone_slab", 1, 6, missing),
                "craftingToolSaw",
                "stoneNetherBrick");
        addShapelessRecipe(getModItem(Minecraft.ID, "stone_slab", 1, 7, missing), "craftingToolSaw", "blockQuartz");
        addShapedRecipe(
                getModItem(Minecraft.ID, "brick_block", 2, 0, missing),
                "ingotBrick",
                "ingotBrick",
                "ingotBrick",
                "ingotBrick",
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing),
                "ingotBrick",
                "ingotBrick",
                "ingotBrick",
                "ingotBrick");
        addShapedRecipe(
                getModItem(Minecraft.ID, "brick_block", 2, 0, missing),
                "ingotBrick",
                "ingotBrick",
                "ingotBrick",
                "ingotBrick",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                "ingotBrick",
                "ingotBrick",
                "ingotBrick",
                "ingotBrick");
        addShapedRecipe(
                getModItem(Minecraft.ID, "nether_brick", 2, 0, missing),
                "ingotBrickNether",
                "ingotBrickNether",
                "ingotBrickNether",
                "ingotBrickNether",
                getModItem(Minecraft.ID, "lava_bucket", 1, 0, missing),
                "ingotBrickNether",
                "ingotBrickNether",
                "ingotBrickNether",
                "ingotBrickNether");
        addShapedRecipe(
                getModItem(Minecraft.ID, "nether_brick", 2, 0, missing),
                "ingotBrickNether",
                "ingotBrickNether",
                "ingotBrickNether",
                "ingotBrickNether",
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketLava", 1, 0, missing),
                "ingotBrickNether",
                "ingotBrickNether",
                "ingotBrickNether",
                "ingotBrickNether");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "ringAnyIron",
                "screwAnyIron",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "craftingToolSaw");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                "craftingToolScrewdriver",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "ringCopper",
                "screwCopper",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "craftingToolSaw");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "ringAnyIron",
                "screwAnyIron",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                "craftingToolSaw",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "ringCopper",
                "screwCopper",
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                getModItem(Minecraft.ID, "planks", 1, 0, missing),
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(Minecraft.ID, "iron_door", 1, 0, missing),
                "plateAnyIron",
                CustomItemList.SteelBars.get(1L),
                "craftingToolHardHammer",
                "plateAnyIron",
                "ringSteel",
                "screwSteel",
                "plateAnyIron",
                "plateAnyIron",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(Minecraft.ID, "iron_door", 1, 0, missing),
                "plateAnyIron",
                CustomItemList.SteelBars.get(1L),
                "craftingToolScrewdriver",
                "plateAnyIron",
                "ringSteel",
                "screwSteel",
                "plateAnyIron",
                "plateAnyIron",
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Oak.get(1L),
                ItemList.Plank_Oak.get(1L),
                ItemList.Plank_Oak.get(1L),
                ItemList.Plank_Oak.get(1L),
                ItemList.Plank_Oak.get(1L),
                ItemList.Plank_Oak.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Spruce.get(1L),
                ItemList.Plank_Spruce.get(1L),
                ItemList.Plank_Spruce.get(1L),
                ItemList.Plank_Spruce.get(1L),
                ItemList.Plank_Spruce.get(1L),
                ItemList.Plank_Spruce.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Birch.get(1L),
                ItemList.Plank_Birch.get(1L),
                ItemList.Plank_Birch.get(1L),
                ItemList.Plank_Birch.get(1L),
                ItemList.Plank_Birch.get(1L),
                ItemList.Plank_Birch.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Jungle.get(1L),
                ItemList.Plank_Jungle.get(1L),
                ItemList.Plank_Jungle.get(1L),
                ItemList.Plank_Jungle.get(1L),
                ItemList.Plank_Jungle.get(1L),
                ItemList.Plank_Jungle.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Acacia.get(1L),
                ItemList.Plank_Acacia.get(1L),
                ItemList.Plank_Acacia.get(1L),
                ItemList.Plank_Acacia.get(1L),
                ItemList.Plank_Acacia.get(1L),
                ItemList.Plank_Acacia.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_DarkOak.get(1L),
                ItemList.Plank_DarkOak.get(1L),
                ItemList.Plank_DarkOak.get(1L),
                ItemList.Plank_DarkOak.get(1L),
                ItemList.Plank_DarkOak.get(1L),
                ItemList.Plank_DarkOak.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Larch.get(1L),
                ItemList.Plank_Larch.get(1L),
                ItemList.Plank_Larch.get(1L),
                ItemList.Plank_Larch.get(1L),
                ItemList.Plank_Larch.get(1L),
                ItemList.Plank_Larch.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Teak.get(1L),
                ItemList.Plank_Teak.get(1L),
                ItemList.Plank_Teak.get(1L),
                ItemList.Plank_Teak.get(1L),
                ItemList.Plank_Teak.get(1L),
                ItemList.Plank_Teak.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Acacia_Green.get(1L),
                ItemList.Plank_Acacia_Green.get(1L),
                ItemList.Plank_Acacia_Green.get(1L),
                ItemList.Plank_Acacia_Green.get(1L),
                ItemList.Plank_Acacia_Green.get(1L),
                ItemList.Plank_Acacia_Green.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Lime.get(1L),
                ItemList.Plank_Lime.get(1L),
                ItemList.Plank_Lime.get(1L),
                ItemList.Plank_Lime.get(1L),
                ItemList.Plank_Lime.get(1L),
                ItemList.Plank_Lime.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Chestnut.get(1L),
                ItemList.Plank_Chestnut.get(1L),
                ItemList.Plank_Chestnut.get(1L),
                ItemList.Plank_Chestnut.get(1L),
                ItemList.Plank_Chestnut.get(1L),
                ItemList.Plank_Chestnut.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Wenge.get(1L),
                ItemList.Plank_Wenge.get(1L),
                ItemList.Plank_Wenge.get(1L),
                ItemList.Plank_Wenge.get(1L),
                ItemList.Plank_Wenge.get(1L),
                ItemList.Plank_Wenge.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Baobab.get(1L),
                ItemList.Plank_Baobab.get(1L),
                ItemList.Plank_Baobab.get(1L),
                ItemList.Plank_Baobab.get(1L),
                ItemList.Plank_Baobab.get(1L),
                ItemList.Plank_Baobab.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Sequoia.get(1L),
                ItemList.Plank_Sequoia.get(1L),
                ItemList.Plank_Sequoia.get(1L),
                ItemList.Plank_Sequoia.get(1L),
                ItemList.Plank_Sequoia.get(1L),
                ItemList.Plank_Sequoia.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Kapok.get(1L),
                ItemList.Plank_Kapok.get(1L),
                ItemList.Plank_Kapok.get(1L),
                ItemList.Plank_Kapok.get(1L),
                ItemList.Plank_Kapok.get(1L),
                ItemList.Plank_Kapok.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Ebony.get(1L),
                ItemList.Plank_Ebony.get(1L),
                ItemList.Plank_Ebony.get(1L),
                ItemList.Plank_Ebony.get(1L),
                ItemList.Plank_Ebony.get(1L),
                ItemList.Plank_Ebony.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Mahagony.get(1L),
                ItemList.Plank_Mahagony.get(1L),
                ItemList.Plank_Mahagony.get(1L),
                ItemList.Plank_Mahagony.get(1L),
                ItemList.Plank_Mahagony.get(1L),
                ItemList.Plank_Mahagony.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Balsa.get(1L),
                ItemList.Plank_Balsa.get(1L),
                ItemList.Plank_Balsa.get(1L),
                ItemList.Plank_Balsa.get(1L),
                ItemList.Plank_Balsa.get(1L),
                ItemList.Plank_Balsa.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Willow.get(1L),
                ItemList.Plank_Willow.get(1L),
                ItemList.Plank_Willow.get(1L),
                ItemList.Plank_Willow.get(1L),
                ItemList.Plank_Willow.get(1L),
                ItemList.Plank_Willow.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Walnut.get(1L),
                ItemList.Plank_Walnut.get(1L),
                ItemList.Plank_Walnut.get(1L),
                ItemList.Plank_Walnut.get(1L),
                ItemList.Plank_Walnut.get(1L),
                ItemList.Plank_Walnut.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Greenheart.get(1L),
                ItemList.Plank_Greenheart.get(1L),
                ItemList.Plank_Greenheart.get(1L),
                ItemList.Plank_Greenheart.get(1L),
                ItemList.Plank_Greenheart.get(1L),
                ItemList.Plank_Greenheart.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Cherry.get(1L),
                ItemList.Plank_Cherry.get(1L),
                ItemList.Plank_Cherry.get(1L),
                ItemList.Plank_Cherry.get(1L),
                ItemList.Plank_Cherry.get(1L),
                ItemList.Plank_Cherry.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Mahoe.get(1L),
                ItemList.Plank_Mahoe.get(1L),
                ItemList.Plank_Mahoe.get(1L),
                ItemList.Plank_Mahoe.get(1L),
                ItemList.Plank_Mahoe.get(1L),
                ItemList.Plank_Mahoe.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Poplar.get(1L),
                ItemList.Plank_Poplar.get(1L),
                ItemList.Plank_Poplar.get(1L),
                ItemList.Plank_Poplar.get(1L),
                ItemList.Plank_Poplar.get(1L),
                ItemList.Plank_Poplar.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Palm.get(1L),
                ItemList.Plank_Palm.get(1L),
                ItemList.Plank_Palm.get(1L),
                ItemList.Plank_Palm.get(1L),
                ItemList.Plank_Palm.get(1L),
                ItemList.Plank_Palm.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Papaya.get(1L),
                ItemList.Plank_Papaya.get(1L),
                ItemList.Plank_Papaya.get(1L),
                ItemList.Plank_Papaya.get(1L),
                ItemList.Plank_Papaya.get(1L),
                ItemList.Plank_Papaya.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Pine.get(1L),
                ItemList.Plank_Pine.get(1L),
                ItemList.Plank_Pine.get(1L),
                ItemList.Plank_Pine.get(1L),
                ItemList.Plank_Pine.get(1L),
                ItemList.Plank_Pine.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Plum.get(1L),
                ItemList.Plank_Plum.get(1L),
                ItemList.Plank_Plum.get(1L),
                ItemList.Plank_Plum.get(1L),
                ItemList.Plank_Plum.get(1L),
                ItemList.Plank_Plum.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Maple.get(1L),
                ItemList.Plank_Maple.get(1L),
                ItemList.Plank_Maple.get(1L),
                ItemList.Plank_Maple.get(1L),
                ItemList.Plank_Maple.get(1L),
                ItemList.Plank_Maple.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                ItemList.Plank_Citrus.get(1L),
                ItemList.Plank_Citrus.get(1L),
                ItemList.Plank_Citrus.get(1L),
                ItemList.Plank_Citrus.get(1L),
                ItemList.Plank_Citrus.get(1L),
                ItemList.Plank_Citrus.get(1L),
                null,
                "stickWood",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "boat", 1, 0, missing),
                "plankWood",
                null,
                "plankWood",
                "plankWood",
                "craftingToolKnife",
                "plankWood",
                "slabWood",
                "slabWood",
                "slabWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "painting", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "ringAnyIron",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "stickWood",
                getModItem(Minecraft.ID, "carpet", 1, wildcard, missing),
                "stickWood",
                "stickWood",
                "stickWood",
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "flint_and_steel", 1, 0, missing),
                null,
                "gearGtSmallSteel",
                null,
                null,
                getModItem(Minecraft.ID, "flint", 1, 0, missing),
                null,
                null,
                "springSmallSteel",
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "shears", 1, 0, missing),
                "plateIron",
                "screwIron",
                "plateIron",
                "craftingToolHardHammer",
                "ringIron",
                "craftingToolFile",
                "stickWood",
                "craftingToolScrewdriver",
                "stickWood");
        addShapedRecipe(
                getModItem(Minecraft.ID, "nether_star", 16, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.crateGtGem, Materials.NetherStar, 1L),
                "craftingToolCrowbar");
        addShapedRecipe(
                getModItem(Minecraft.ID, "mossy_cobblestone", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(Minecraft.ID, "cobblestone", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing));
        addShapedRecipe(
                getModItem(Minecraft.ID, "book", 1, 0, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "paperEmpty",
                "itemLeather",
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "paperEmpty",
                getModItem(TinkerConstruct.ID, "buckets", 1, 25, missing),
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                "paperEmpty",
                "itemLeather");
        addShapedRecipe(
                getModItem(Minecraft.ID, "bookshelf", 1, 0, missing),
                "plateWood",
                "plateWood",
                "plateWood",
                getModItem(Minecraft.ID, "book", 1, 0, missing),
                getModItem(Minecraft.ID, "book", 1, 0, missing),
                getModItem(Minecraft.ID, "book", 1, 0, missing),
                "plateWood",
                "plateWood",
                "plateWood");
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 9, 9032, missing),
                "craftingToolSaw",
                "ingotIron",
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(Minecraft.ID, "gold_nugget", 9, 0, missing),
                "craftingToolSaw",
                "ingotGold",
                null,
                null,
                null,
                null,
                null,
                null,
                null);
    }
}
