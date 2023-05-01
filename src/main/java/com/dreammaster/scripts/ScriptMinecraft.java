package com.dreammaster.scripts;

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
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.PamsHarvestTheNether;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBases;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.enums.Mods.Witchery;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sArcFurnaceRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sBlastRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCutterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sExtractorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sFluidExtractionRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMixerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sSlicerRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_ModHandler;

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
                getModItem(NewHorizonsCoreMod.ID, "item.UnfiredClayBrick", 1, 0, missing),
                getModItem(Minecraft.ID, "brick", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32561, missing),
                getModItem(Minecraft.ID, "bread", 1, 0, missing));
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 3, missing))
                .itemOutputs(getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 2, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "hay_block", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "wheat", 9, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestTheNether.ID, "glowFlower", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "clay_ball", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem(Minecraft.ID, "brick", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(2).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2807, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem(Minecraft.ID, "netherbrick", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(2).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BloodArsenal.ID, "glass_shard", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(5).eut(64).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "iron_ingot", 5, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldHelmet", 0, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "iron_helmet", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "iron_ingot", 8, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldChestplate", 0, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "iron_chestplate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "iron_ingot", 7, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldLeggings", 0, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "iron_leggings", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "iron_ingot", 4, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldBoots", 0, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "iron_boots", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "gold_ingot", 5, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldHelmet", 0, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "golden_helmet", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "gold_ingot", 8, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldChestplate", 0, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "golden_chestplate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "gold_ingot", 7, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldLeggings", 0, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "golden_leggings", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "gold_ingot", 4, 0, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.MoldBoots", 0, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "golden_boots", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "sand", 1, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 2, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("oxygen", 2)).noFluidOutputs().duration(20).eut(256)
                .addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "sand", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 2, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("oxygen", 2)).noFluidOutputs().duration(20).eut(256)
                .addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "barleyFood", 2, 3, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "string", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wheat", 9, 0, missing),
                        getModItem(Minecraft.ID, "string", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "hay_block", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "heatsand", 1, 0, missing),
                        getModItem(Natura.ID, "soil.tainted", 4, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "soul_sand", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).noFluidOutputs().duration(100).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(MagicBees.ID, "miscResources", 6, 4, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "skull", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.thaumium", 216)).noFluidOutputs().duration(200).eut(96)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(Minecraft.ID, "wool", 1, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "torch", 5, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("creosote", 500)).noFluidOutputs().duration(100).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2536, missing))
                .itemOutputs(getModItem(Minecraft.ID, "torch", 4, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2535, missing))
                .itemOutputs(getModItem(Minecraft.ID, "torch", 6, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2022, missing))
                .itemOutputs(getModItem(Minecraft.ID, "torch", 4, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2022, missing))
                .itemOutputs(getModItem(Minecraft.ID, "torch", 6, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17809, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_door", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17809, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_door", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 17032, missing),
                        getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "iron_door", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(400).eut(8)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 0, missing),
                        getModItem(Minecraft.ID, "stick", 4, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "trapdoor", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 0, missing),
                        getModItem(Minecraft.ID, "stick", 4, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "trapdoor", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "trapdoor", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "trapdoor", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 0, missing),
                        getModItem(BiomesOPlenty.ID, "bamboo", 4, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "trapdoor", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wooden_slab", 4, 0, missing),
                        getModItem(BiomesOPlenty.ID, "bamboo", 4, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "trapdoor", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "planks", 6, 32767, missing),
                        getModItem(Minecraft.ID, "book", 3, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bookshelf", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftAmunRa.ID, "tile.log1", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalacticraftAmunRa.ID, "tile.wood1", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "tree", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "redwood", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "willow", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "bloodwood", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "Rare Tree", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "Dark Tree", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 0, "{meta:0}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 1, "{meta:1}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 2, "{meta:2}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 3, "{meta:3}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 4, "{meta:4}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 5, "{meta:5}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 6, "{meta:6}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 7, "{meta:7}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 8, "{meta:8}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 9, "{meta:9}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 10, "{meta:10}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 11, "{meta:11}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 12, "{meta:12}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 13, "{meta:13}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 14, "{meta:14}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 15, "{meta:15}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 16, "{meta:16}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 17, "{meta:17}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 18, "{meta:18}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 19, "{meta:19}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 20, "{meta:20}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 21, "{meta:21}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 22, "{meta:22}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 23, "{meta:23}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 24, "{meta:24}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 25, "{meta:25}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 26, "{meta:26}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 27, "{meta:27}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 28, "{meta:28}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 29, "{meta:29}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 30, "{meta:30}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 31, "{meta:31}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 32, "{meta:32}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 33, "{meta:33}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 34, "{meta:34}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 35, "{meta:35}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 36, "{meta:36}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 37, "{meta:37}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 38, "{meta:38}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack(ExtraTrees.ID, "log", 1, 39, "{meta:39}", missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "pamMaple", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "pamPaperbark", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestCraft.ID, "pamCinnamon", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ThaumicBases.ID, "genLogs", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Witchery.ID, "witchlog", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockRainforestOakLog", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GTPlusPlus.ID, "blockPineLogLog", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GalaxySpace.ID, "barnardaClog", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TaintedMagic.ID, "BlockWarpwoodLog", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TwilightForest.ID, "tile.TFLog", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TwilightForest.ID, "tile.TFMagicLog", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(PamsHarvestTheNether.ID, "netherLog", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ForbiddenMagic.ID, "TaintLog", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "blockRubWood", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 32767, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 2, 0, missing),
                        getModItem(Minecraft.ID, "planks", 2, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "fence_gate", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, 32767, missing),
                        getModItem(Minecraft.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, 32767, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, 32767, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, 32767, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, 32767, missing),
                        getModItem(Forestry.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, 32767, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, 32767, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, 32767, missing),
                        getModItem(Natura.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, 32767, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log", 2, 32767, missing),
                        getModItem(Witchery.ID, "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, 32767, missing),
                        getModItem(Minecraft.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, 32767, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, 32767, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, 32767, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, 32767, missing),
                        getModItem(Forestry.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, 32767, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, 32767, missing),
                        getModItem(Natura.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, 32767, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "log2", 2, 32767, missing),
                        getModItem(Witchery.ID, "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, 32767, missing),
                        getModItem(Minecraft.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, 32767, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, 32767, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, 32767, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, 32767, missing),
                        getModItem(Forestry.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, 32767, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, 32767, missing),
                        getModItem(Natura.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, 32767, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs1", 2, 32767, missing),
                        getModItem(Witchery.ID, "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, 32767, missing),
                        getModItem(Minecraft.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, 32767, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, 32767, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, 32767, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, 32767, missing),
                        getModItem(Forestry.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, 32767, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, 32767, missing),
                        getModItem(Natura.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, 32767, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs2", 2, 32767, missing),
                        getModItem(Witchery.ID, "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, 32767, missing),
                        getModItem(Minecraft.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, 32767, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, 32767, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, 32767, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, 32767, missing),
                        getModItem(Forestry.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, 32767, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, 32767, missing),
                        getModItem(Natura.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, 32767, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs3", 2, 32767, missing),
                        getModItem(Witchery.ID, "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, 32767, missing),
                        getModItem(Minecraft.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, 32767, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, 32767, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, 32767, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, 32767, missing),
                        getModItem(Forestry.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, 32767, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, 32767, missing),
                        getModItem(Natura.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, 32767, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "logs4", 2, 32767, missing),
                        getModItem(Witchery.ID, "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, 32767, missing),
                        getModItem(Minecraft.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, 32767, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, 32767, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, 32767, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, 32767, missing),
                        getModItem(Forestry.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, 32767, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, 32767, missing),
                        getModItem(Natura.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, 32767, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(ExtraTrees.ID, "log", 2, 32767, missing),
                        getModItem(Witchery.ID, "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, 32767, missing),
                        getModItem(Minecraft.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, 32767, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, 32767, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, 32767, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, 32767, missing),
                        getModItem(Forestry.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, 32767, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, 32767, missing),
                        getModItem(Natura.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, 32767, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logs", 2, 32767, missing),
                        getModItem(Witchery.ID, "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, 32767, missing),
                        getModItem(Minecraft.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, 32767, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, 32767, missing),
                        getModItem(ExtraTrees.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, 32767, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, 32767, missing),
                        getModItem(Forestry.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, 32767, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, 32767, missing),
                        getModItem(Natura.ID, "planks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, 32767, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, 32767, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "logsFireproof", 2, 32767, missing),
                        getModItem(Witchery.ID, "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem(Minecraft.ID, "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone_button", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "lever", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(50).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(Minecraft.ID, "stone_button", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "lever", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(50).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "bamboo", 1, 0, missing),
                        getModItem(Minecraft.ID, "stone_button", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "lever", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(50).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(BiomesOPlenty.ID, "plants", 1, 8, missing),
                        getModItem(Minecraft.ID, "stone_button", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "lever", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(50).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27809, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "ladder", 2, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27032, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "ladder", 4, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27305, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "ladder", 8, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27019, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "ladder", 32, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "brick", 8, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "brick_block", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 500)).noFluidOutputs().duration(300).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32471, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32472, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32473, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32474, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32475, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32476, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32477, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32478, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32479, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32480, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32481, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32482, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32483, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32484, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32485, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32486, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32487, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32488, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32489, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32490, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32471, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32472, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32473, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32474, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32475, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32476, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32477, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32478, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32479, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32480, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32481, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32482, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32483, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32484, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32485, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32486, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32487, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32488, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32489, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 1, 32767, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32490, missing))
                .itemOutputs(getModItem(Minecraft.ID, "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 32470, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.02", 2, 32470, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone_slab", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(Minecraft.ID, "stone_pressure_plate", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone_slab", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Minecraft.ID, "stone_pressure_plate", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(Minecraft.ID, "planks", 2, 32767, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 1, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 2, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 3, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 4, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 6, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 7, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 8, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 9, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 10, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 11, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 12, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 13, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 14, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ExtraUtilities.ID, "colorWoodPlanks", 2, 15, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(GalacticraftAmunRa.ID, "tile.wood1", 2, 3, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(GalacticraftAmunRa.ID, "tile.wood1", 2, 2, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 6, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 2, 7, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(Natura.ID, "planks", 2, 32767, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(BiomesOPlenty.ID, "planks", 2, 32767, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(Forestry.ID, "planks", 2, 32767, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(Forestry.ID, "planksFireproof", 2, 32767, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 0, "{meta:0}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 1, "{meta:1}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 2, "{meta:2}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 3, "{meta:3}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 4, "{meta:4}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 5, "{meta:5}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 6, "{meta:6}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 7, "{meta:7}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 8, "{meta:8}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 9, "{meta:9}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 10, "{meta:10}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 11, "{meta:11}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 12, "{meta:12}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 13, "{meta:13}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 14, "{meta:14}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 15, "{meta:15}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 16, "{meta:16}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 17, "{meta:17}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 18, "{meta:18}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 19, "{meta:19}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 20, "{meta:20}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 21, "{meta:21}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 22, "{meta:22}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 23, "{meta:23}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 24, "{meta:24}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 25, "{meta:25}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 26, "{meta:26}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 27, "{meta:27}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 28, "{meta:28}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 29, "{meta:29}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 30, "{meta:30}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 31, "{meta:31}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 32, "{meta:32}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 33, "{meta:33}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        createItemStack(ExtraTrees.ID, "planks", 2, 34, "{meta:34}", missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 17809, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ThaumicBases.ID, "enderPlanks", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(Witchery.ID, "witchwood", 2, 32767, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(GalaxySpace.ID, "barnardaCplanks", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(TaintedMagic.ID, "BlockWarpwoodPlanks", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(TwilightForest.ID, "tile.TFTowerStone", 2, 32767, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(TwilightForest.ID, "tile.TFPlank", 2, 32767, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "carpet", 2, 32767, missing),
                        getModItem(PamsHarvestCraft.ID, "wovencottonItem", 2, 0, missing),
                        getModItem(ForbiddenMagic.ID, "TaintPlank", 2, 32767, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(IndustrialCraft2.ID, "itemPlates", 1, 3, missing),
                        getModItem(Minecraft.ID, "comparator", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "clock", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17086, missing),
                        getModItem(Minecraft.ID, "comparator", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 23086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "clock", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "leather", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 28032, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "saddle", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.ArtificialLeather", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 28032, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "saddle", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "GlassBlock", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "glass", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(120).specialValue(1000).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "glass_pane", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(120).specialValue(1000).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 0, missing))
                .itemOutputs(
                        getModItem(Minecraft.ID, "bone", 8, 0, missing),
                        getModItem(Minecraft.ID, "bone", 6, 0, missing),
                        getModItem(Minecraft.ID, "bone", 4, 0, missing))
                .outputChances(10000, 7500, 5000).fluidInputs(FluidRegistry.getFluidStack("hell_blood", 1000))
                .noFluidOutputs().duration(200).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 1, missing))
                .itemOutputs(
                        getModItem(Minecraft.ID, "coal_block", 2, 0, missing),
                        getModItem(Minecraft.ID, "coal_block", 1, 0, missing),
                        getModItem(Minecraft.ID, "coal_block", 1, 0, missing))
                .outputChances(10000, 7500, 5000).fluidInputs(FluidRegistry.getFluidStack("hell_blood", 1000))
                .noFluidOutputs().duration(200).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 4, missing))
                .itemOutputs(
                        getModItem(Minecraft.ID, "gunpowder", 4, 0, missing),
                        getModItem(Minecraft.ID, "gunpowder", 3, 0, missing),
                        getModItem(Minecraft.ID, "gunpowder", 2, 0, missing))
                .outputChances(10000, 7500, 5000).fluidInputs(FluidRegistry.getFluidStack("hell_blood", 1000))
                .noFluidOutputs().duration(200).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "enderman_head", 1, 0, missing))
                .itemOutputs(
                        getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing),
                        getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing),
                        getModItem(Minecraft.ID, "ender_pearl", 1, 0, missing))
                .outputChances(10000, 5000, 2500).fluidInputs(FluidRegistry.getFluidStack("hell_blood", 1000))
                .noFluidOutputs().duration(200).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 3, missing))
                .itemOutputs(getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0, missing)).outputChances(1000)
                .fluidInputs(FluidRegistry.getFluidStack("hell_blood", 1000)).noFluidOutputs().duration(200).eut(30)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "skull", 1, 2, missing))
                .itemOutputs(
                        getModItem(Minecraft.ID, "rotten_flesh", 4, 0, missing),
                        getModItem(Minecraft.ID, "leather", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 4, 2892, missing))
                .outputChances(10000, 3000, 5000).fluidInputs(FluidRegistry.getFluidStack("hell_blood", 1000))
                .noFluidOutputs().duration(200).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_button", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_button", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "wooden_button", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "stone_button", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "stone_button", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "stone_button", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "sand", 1, 32767, missing)).noItemOutputs()
                .noFluidInputs().fluidOutputs(FluidRegistry.getFluidStack("molten.glass", 144)).duration(10000).eut(200)
                .addTo(sFluidExtractionRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "obsidian", 1, 0, missing)).noItemOutputs()
                .noFluidInputs().fluidOutputs(FluidRegistry.getFluidStack("obsidian.molten", 288)).duration(10000)
                .eut(600).addTo(sFluidExtractionRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "sand", 4, 32767, missing),
                        getModItem(Minecraft.ID, "dirt", 1, 32767, missing),
                        getModItem(MagicBees.ID, "wax", 4, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "soul_sand", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).noFluidOutputs().duration(100).eut(16)
                .addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "blaze_powder", 3, 0, missing),
                        getModItem(Minecraft.ID, "gunpowder", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 3, 2535, missing))
                .itemOutputs(getModItem(Minecraft.ID, "fire_charge", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(30).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "melon_block", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 0, 32398, missing))
                .itemOutputs(getModItem(Minecraft.ID, "melon", 8, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(8).addTo(sSlicerRecipes);
        GT_ModHandler.setFuelValue(getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0, missing), (short) 75);

    }

    private void craftingRecipes() {
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "crafting_table", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "flint", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 1, 0, missing), "logWood", "logWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "chest", 1, 0, missing),
                new Object[] { "logWood", "plankWood", "logWood", "plankWood",
                        getModItem(Minecraft.ID, "flint", 1, 0, missing), "plankWood", "logWood", "plankWood",
                        "logWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "trapped_chest", 1, 0, missing),
                new Object[] { null, getModItem(Minecraft.ID, "tripwire_hook", 1, 0, missing), null, "screwAnyIron",
                        getModItem(Minecraft.ID, "chest", 1, 0, missing), "screwAnyIron", null,
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "furnace", 1, 0, missing),
                new Object[] { "cobblestone", "cobblestone", "cobblestone",
                        getModItem(Minecraft.ID, "flint", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 1, 0, missing), "cobblestone", "cobblestone",
                        "cobblestone" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "dispenser", 1, 0, missing),
                new Object[] { "cobblestone", "ringAnyIron", "cobblestone", "springIron",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "springIron", "gearGtSmallAnyIron",
                        "stickRedAlloy", "gearGtSmallAnyIron" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "dropper", 1, 0, missing),
                new Object[] { "cobblestone", "ringAnyIron", "cobblestone", "springSmallIron",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "springSmallIron", "gearGtSmallAnyIron",
                        "stickRedAlloy", "gearGtSmallAnyIron" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "piston", 1, 0, missing),
                new Object[] { getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "gearGtSmallAnyIron",
                        "fenceWood", "gearGtSmallAnyIron", "cobblestone", "plateRedAlloy", "cobblestone" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sticky_piston", 1, 0, missing),
                new Object[] { null, "craftingToolSoftHammer", null, null, "slimeball", null, null,
                        getModItem(Minecraft.ID, "piston", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "rail", 8, 0, missing),
                new Object[] { "screwAnyIron", null, "screwAnyIron",
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "craftingToolScrewdriver", null,
                        "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "detector_rail", 1, 0, missing),
                new Object[] { "screwAnyIron", getModItem(Railcraft.ID, "detector", 1, 1, missing), "screwAnyIron",
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "craftingToolScrewdriver",
                        "stickRedAlloy", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "activator_rail", 2, 0, missing),
                new Object[] { "screwAnyIron", getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing),
                        "screwAnyIron", getModItem(Railcraft.ID, "part.rail", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.railbed", 1, 0, missing),
                        getModItem(Railcraft.ID, "part.rail", 1, 0, missing), "craftingToolScrewdriver",
                        "stickRedAlloy", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "noteblock", 1, 0, missing),
                new Object[] { "plankWood", "plankWood", "plankWood",
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "gearWood",
                        getModItem(Minecraft.ID, "iron_bars", 1, 0, missing), "plankWood", "stickRedAlloy",
                        "plankWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "jukebox", 1, 0, missing),
                new Object[] { "logWood", getModItem(GregTech.ID, "gt.metaitem.01", 1, 26500, missing), "logWood",
                        getModItem(Minecraft.ID, "noteblock", 1, 0, missing), "record",
                        getModItem(Minecraft.ID, "noteblock", 1, 0, missing), "logWood", "gearAnyIron", "logWood" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "lit_pumpkin", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "pumpkin", 1, 0, missing),
                        getModItem(Minecraft.ID, "torch", 1, 0, missing), "craftingToolKnife" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "flint", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "trapdoor", 2, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing), "stickWood", "screwAnyIron",
                        "stickWood", getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "trapdoor", 3, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing), "stickWood", "screwSteel", "stickWood",
                        getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "wooden_slab", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stone_pressure_plate", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolHardHammer", "screwIron",
                        getModItem(Minecraft.ID, "stone_slab", 1, 0, missing), "springAnyIron",
                        getModItem(Minecraft.ID, "stone_slab", 1, 0, missing), "screwIron", "craftingToolScrewdriver",
                        "screwIron" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_pressure_plate", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing), "springAnyIron",
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing), "screwWood",
                        "craftingToolScrewdriver", "screwWood" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "glass_pane", 2, 0, missing),
                new Object[] { "craftingToolSaw", "glass" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 3, 0, missing),
                new Object[] { "gemCoal", null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 2, 0, missing),
                new Object[] { "gemCharcoal", null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 1, 0, missing),
                new Object[] { "gemLignite", null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 5, 0, missing),
                new Object[] { "fuelCoke", null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 5, 0, missing),
                new Object[] { "blockWool", getModItem(Railcraft.ID, "fluid.creosote.bucket", 1, 0, missing),
                        "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 4, 0, missing),
                new Object[] { getModItem(TwilightForest.ID, "item.torchberries", 1, 0, missing), null, "stickWood",
                        null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 3, 0, missing),
                new Object[] { "itemBeeswax", getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "torch", 2, 0, missing),
                new Object[] { getModItem(IndustrialCraft2.ID, "itemHarz", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood", null });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "lever", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Minecraft.ID, "stone_button", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stone_button", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_button", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Minecraft.ID, "wooden_pressure_plate", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing),
                new Object[] { "dustRedstone", null, getModItem(Minecraft.ID, "torch", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "ladder", 2, 0, missing),
                new Object[] { "stickWood", "craftingToolScrewdriver", "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "screwWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood", "craftingToolSoftHammer",
                        "stickWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "ladder", 4, 0, missing),
                new Object[] { "stickWood", "craftingToolScrewdriver", "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "screwAnyIron",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood", "craftingToolSoftHammer",
                        "stickWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "ladder", 8, 0, missing),
                new Object[] { "stickWood", "craftingToolScrewdriver", "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "screwSteel",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood", "craftingToolSoftHammer",
                        "stickWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Minecraft.ID, "planks", 1, 0, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 2, 0, missing),
                new Object[] { "screwAnyIron", "craftingToolScrewdriver", "screwAnyIron", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "stickWood", "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 2, 0, missing),
                new Object[] { null, null, null, "stickWood",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "stickWood",
                        "stickWood", getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        "stickWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 4, 0, missing),
                new Object[] { "screwAnyIron", "craftingToolScrewdriver", "screwAnyIron", "stickWood",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "stickWood",
                        "stickWood", getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        "stickWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence", 6, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "stickWood",
                        "stickWood", getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        "stickWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "flint", 1, 0, missing), null,
                        getModItem(Minecraft.ID, "flint", 1, 0, missing),
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing),
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 2, 0, missing),
                new Object[] { "screwAnyIron", "craftingToolScrewdriver", "screwAnyIron",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing),
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing),
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 2, 0, missing),
                new Object[] { null, null, null, getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        "stickWood", getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "stickWood",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 4, 0, missing),
                new Object[] { "screwAnyIron", "craftingToolScrewdriver", "screwAnyIron",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "stickWood",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "stickWood",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "fence_gate", 6, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "stickWood",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing),
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing), "stickWood",
                        getModItem(CarpentersBlocks.ID, "blockCarpentersBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "redstone_lamp", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "glass_pane", 1, 0, missing),
                        getModItem(Minecraft.ID, "glass_pane", 1, 0, missing),
                        getModItem(Minecraft.ID, "glass_pane", 1, 0, missing),
                        getModItem(Minecraft.ID, "glass_pane", 1, 0, missing),
                        getModItem(Minecraft.ID, "glowstone", 1, 0, missing),
                        getModItem(Minecraft.ID, "glass_pane", 1, 0, missing),
                        getModItem(Minecraft.ID, "glass_pane", 1, 0, missing), "stickRedAlloy",
                        getModItem(Minecraft.ID, "glass_pane", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "tripwire_hook", 1, 0, missing),
                new Object[] { "ringAnyIron", "stickWood", "ringAnyIron",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), null,
                        getModItem(Minecraft.ID, "string", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "anvil", 1, 0, missing),
                new Object[] { "blockIron", "blockIron", "blockIron", "screwAnyIron", "blockIron", "screwAnyIron",
                        "plateAnyIron", "blockIron", "plateAnyIron" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "daylight_detector", 1, 0, missing),
                new Object[] { getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing), "plateNetherQuartz",
                        "plateCertusQuartz", "plateNetherQuartz", "slabWood", "stickRedAlloy", "slabWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                new Object[] { "plateAnyIron", getModItem(Minecraft.ID, "chest", 1, 0, missing), "plateAnyIron",
                        "plateAnyIron", "gearAnyIron", "plateAnyIron", "craftingToolHardHammer", "plateAnyIron",
                        "craftingToolFile" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 0, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeWhite", "blockWool", "blockWool",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "wool", 1, 0, missing),
                new Object[] { "blockWool", "dyeWhite" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "string", 1, 0, missing), null,
                        getModItem(Minecraft.ID, "string", 1, 0, missing), null,
                        getModItem(Minecraft.ID, "string", 1, 0, missing), null,
                        getModItem(Minecraft.ID, "string", 1, 0, missing), null,
                        getModItem(Minecraft.ID, "string", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 1, 0, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing),
                        getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing),
                        getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing),
                        getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing),
                        getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing),
                        getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing),
                        getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing),
                        getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing),
                        getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 1, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeOrange", "blockWool",
                        "blockWool", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "wool", 1, 1, missing),
                new Object[] { "blockWool", "dyeOrange" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 2, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeMagenta", "blockWool",
                        "blockWool", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "wool", 1, 2, missing),
                new Object[] { "blockWool", "dyeMagenta" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 3, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeLightBlue", "blockWool",
                        "blockWool", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "wool", 1, 3, missing),
                new Object[] { "blockWool", "dyeLightBlue" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 4, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeYellow", "blockWool",
                        "blockWool", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "wool", 1, 4, missing),
                new Object[] { "blockWool", "dyeYellow" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 5, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeLime", "blockWool", "blockWool",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "wool", 1, 5, missing),
                new Object[] { "blockWool", "dyeLime" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 6, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyePink", "blockWool", "blockWool",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "wool", 1, 6, missing),
                new Object[] { "blockWool", "dyePink" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 7, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeGray", "blockWool", "blockWool",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "wool", 1, 7, missing),
                new Object[] { "blockWool", "dyeGray" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 8, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeLightGray", "blockWool",
                        "blockWool", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "wool", 1, 8, missing),
                new Object[] { "blockWool", "dyeLightGray" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 9, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeCyan", "blockWool", "blockWool",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "wool", 1, 9, missing),
                new Object[] { "blockWool", "dyeCyan" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 10, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyePurple", "blockWool",
                        "blockWool", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "wool", 1, 10, missing),
                new Object[] { "blockWool", "dyePurple" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 11, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeBlue", "blockWool", "blockWool",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "wool", 1, 11, missing),
                new Object[] { "blockWool", "dyeBlue" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 12, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeBrown", "blockWool", "blockWool",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "wool", 1, 12, missing),
                new Object[] { "blockWool", "dyeBrown" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 13, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeGreen", "blockWool", "blockWool",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "wool", 1, 13, missing),
                new Object[] { "blockWool", "dyeGreen" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 14, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeRed", "blockWool", "blockWool",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "wool", 1, 14, missing),
                new Object[] { "blockWool", "dyeRed" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wool", 7, 15, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeBlack", "blockWool", "blockWool",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "wool", 1, 15, missing),
                new Object[] { "blockWool", "dyeBlack" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 0, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeWhite", "glass", "glass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass", 1, 0, missing),
                new Object[] { "glass", "dyeWhite" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 1, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeOrange", "glass", "glass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass", 1, 1, missing),
                new Object[] { "glass", "dyeOrange" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 2, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeMagenta", "glass", "glass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass", 1, 2, missing),
                new Object[] { "glass", "dyeMagenta" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 3, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeLightBlue", "glass", "glass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass", 1, 3, missing),
                new Object[] { "glass", "dyeLightBlue" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 4, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeYellow", "glass", "glass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass", 1, 4, missing),
                new Object[] { "glass", "dyeYellow" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 5, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeLime", "glass", "glass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass", 1, 5, missing),
                new Object[] { "glass", "dyeLime" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 6, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyePink", "glass", "glass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass", 1, 6, missing),
                new Object[] { "glass", "dyePink" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 7, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeGray", "glass", "glass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass", 1, 7, missing),
                new Object[] { "glass", "dyeGray" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 8, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeLightGray", "glass", "glass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass", 1, 8, missing),
                new Object[] { "glass", "dyeLightGray" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 9, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeCyan", "glass", "glass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass", 1, 9, missing),
                new Object[] { "glass", "dyeCyan" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 10, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyePurple", "glass", "glass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass", 1, 10, missing),
                new Object[] { "glass", "dyePurple" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 11, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeBlue", "glass", "glass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass", 1, 11, missing),
                new Object[] { "glass", "dyeBlue" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 12, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeBrown", "glass", "glass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass", 1, 12, missing),
                new Object[] { "glass", "dyeBrown" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 13, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeGreen", "glass", "glass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass", 1, 13, missing),
                new Object[] { "glass", "dyeGreen" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 14, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeRed", "glass", "glass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass", 1, 14, missing),
                new Object[] { "glass", "dyeRed" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass", 7, 15, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeBlack", "glass", "glass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass", 1, 15, missing),
                new Object[] { "glass", "dyeBlack" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 0, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeWhite", "paneGlass", "paneGlass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 0, missing),
                new Object[] { "paneGlass", "dyeWhite" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 1, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeOrange", "paneGlass",
                        "paneGlass", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 1, missing),
                new Object[] { "paneGlass", "dyeOrange" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 2, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeMagenta", "paneGlass",
                        "paneGlass", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 2, missing),
                new Object[] { "paneGlass", "dyeMagenta" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 3, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeLightBlue", "paneGlass",
                        "paneGlass", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 3, missing),
                new Object[] { "paneGlass", "dyeLightBlue" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 4, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeYellow", "paneGlass",
                        "paneGlass", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 4, missing),
                new Object[] { "paneGlass", "dyeYellow" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 5, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeLime", "paneGlass", "paneGlass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 5, missing),
                new Object[] { "paneGlass", "dyeLime" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 6, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyePink", "paneGlass", "paneGlass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 6, missing),
                new Object[] { "paneGlass", "dyePink" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 7, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeGray", "paneGlass", "paneGlass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 7, missing),
                new Object[] { "paneGlass", "dyeGray" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 8, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeLightGray", "paneGlass",
                        "paneGlass", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 8, missing),
                new Object[] { "paneGlass", "dyeLightGray" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 9, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeCyan", "paneGlass", "paneGlass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 9, missing),
                new Object[] { "paneGlass", "dyeCyan" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 10, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyePurple", "paneGlass",
                        "paneGlass", getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 10, missing),
                new Object[] { "paneGlass", "dyePurple" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 11, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeBlue", "paneGlass", "paneGlass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 11, missing),
                new Object[] { "paneGlass", "dyeBlue" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 12, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeBrown", "paneGlass", "paneGlass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 12, missing),
                new Object[] { "paneGlass", "dyeBrown" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 13, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeGreen", "paneGlass", "paneGlass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 13, missing),
                new Object[] { "paneGlass", "dyeGreen" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 14, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeRed", "paneGlass", "paneGlass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 14, missing),
                new Object[] { "paneGlass", "dyeRed" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 7, 15, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeBlack", "paneGlass", "paneGlass",
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_glass_pane", 1, 15, missing),
                new Object[] { "paneGlass", "dyeBlack" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 0, missing),
                        getModItem(Minecraft.ID, "wool", 1, 0, missing), null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 0, missing),
                        getModItem(Minecraft.ID, "wool", 1, 0, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 1, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeOrange",
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 1, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeOrange" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 1, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 1, missing),
                        getModItem(Minecraft.ID, "wool", 1, 1, missing), null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 1, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 1, missing),
                        getModItem(Minecraft.ID, "wool", 1, 1, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 2, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeMagenta",
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 2, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeMagenta" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 2, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 2, missing),
                        getModItem(Minecraft.ID, "wool", 1, 2, missing), null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 2, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 2, missing),
                        getModItem(Minecraft.ID, "wool", 1, 2, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 3, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeLightBlue",
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 3, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeLightBlue" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 3, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 3, missing),
                        getModItem(Minecraft.ID, "wool", 1, 3, missing), null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 3, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 3, missing),
                        getModItem(Minecraft.ID, "wool", 1, 3, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 4, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeYellow",
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 4, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeYellow" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 4, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 4, missing),
                        getModItem(Minecraft.ID, "wool", 1, 4, missing), null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 4, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 4, missing),
                        getModItem(Minecraft.ID, "wool", 1, 4, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 5, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeLime",
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 5, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeLime" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 5, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 5, missing),
                        getModItem(Minecraft.ID, "wool", 1, 5, missing), null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 5, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 5, missing),
                        getModItem(Minecraft.ID, "wool", 1, 5, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 6, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyePink",
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 6, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyePink" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 6, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 6, missing),
                        getModItem(Minecraft.ID, "wool", 1, 6, missing), null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 6, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 6, missing),
                        getModItem(Minecraft.ID, "wool", 1, 6, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 7, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeGray",
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 7, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeGray" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 7, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 7, missing),
                        getModItem(Minecraft.ID, "wool", 1, 7, missing), null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 7, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 7, missing),
                        getModItem(Minecraft.ID, "wool", 1, 7, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 8, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeLightGray",
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 8, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeLightGray" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 8, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 8, missing),
                        getModItem(Minecraft.ID, "wool", 1, 8, missing), null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 8, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 8, missing),
                        getModItem(Minecraft.ID, "wool", 1, 8, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 9, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeCyan",
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 9, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeCyan" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 9, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 9, missing),
                        getModItem(Minecraft.ID, "wool", 1, 9, missing), null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 9, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 9, missing),
                        getModItem(Minecraft.ID, "wool", 1, 9, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 10, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyePurple",
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 10, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyePurple" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 10, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 10, missing),
                        getModItem(Minecraft.ID, "wool", 1, 10, missing), null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 10, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 10, missing),
                        getModItem(Minecraft.ID, "wool", 1, 10, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 11, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeBlue",
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 11, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeBlue" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 11, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 11, missing),
                        getModItem(Minecraft.ID, "wool", 1, 11, missing), null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 11, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 11, missing),
                        getModItem(Minecraft.ID, "wool", 1, 11, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 12, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeBrown",
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 12, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeBrown" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 12, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 12, missing),
                        getModItem(Minecraft.ID, "wool", 1, 12, missing), null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 12, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 12, missing),
                        getModItem(Minecraft.ID, "wool", 1, 12, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 13, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeGreen",
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 13, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeGreen" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 13, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 13, missing),
                        getModItem(Minecraft.ID, "wool", 1, 13, missing), null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 13, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 13, missing),
                        getModItem(Minecraft.ID, "wool", 1, 13, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 14, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeRed",
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 14, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeRed" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 14, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 14, missing),
                        getModItem(Minecraft.ID, "wool", 1, 14, missing), null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 14, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 14, missing),
                        getModItem(Minecraft.ID, "wool", 1, 14, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 7, 15, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeBlack",
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 15, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 0, missing), "dyeBlack" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 1, 15, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 15, missing),
                        getModItem(Minecraft.ID, "wool", 1, 15, missing), null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "carpet", 3, 15, missing),
                new Object[] { getModItem(Minecraft.ID, "wool", 1, 15, missing),
                        getModItem(Minecraft.ID, "wool", 1, 15, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeWhite",
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeWhite" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 1, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeOrange",
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 1, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeOrange" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 2, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeMagenta",
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 2, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeMagenta" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 3, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeLightBlue",
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 3, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeLightBlue" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 4, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeYellow",
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 4, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeYellow" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 5, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeLime",
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 5, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeLime" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 6, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyePink",
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 6, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyePink" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 7, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeGray",
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 7, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeGray" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 8, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeLightGray",
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 8, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeLightGray" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 9, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeCyan",
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 9, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeCyan" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 10, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyePurple",
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 10, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyePurple" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 11, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeBlue",
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 11, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeBlue" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 12, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeBrown",
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 12, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeBrown" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 13, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeGreen",
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 13, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeGreen" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 14, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeRed",
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 14, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeRed" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 7, 15, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeBlack",
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing),
                        getModItem(ExtraUtilities.ID, "paintbrush", 1, 0, missing),
                        getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stained_hardened_clay", 1, 15, missing),
                new Object[] { getModItem(Minecraft.ID, "hardened_clay", 1, 0, missing), "dyeBlack" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "sugar", 1, 0, missing),
                new Object[] { "craftingToolMortar", getModItem(Minecraft.ID, "reeds", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_sword", 1, 0, missing),
                new Object[] { null, getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing), null,
                        "craftingToolFile", getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        "craftingToolHardHammer", null, getModItem(Minecraft.ID, "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_shovel", 1, 0, missing),
                new Object[] { "craftingToolFile", getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        "craftingToolHardHammer", null, getModItem(Minecraft.ID, "stick", 1, 0, missing), null, null,
                        getModItem(Minecraft.ID, "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_pickaxe", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(Minecraft.ID, "diamond", 1, 0, missing),
                        getModItem(Minecraft.ID, "diamond", 1, 0, missing), "craftingToolFile",
                        getModItem(Minecraft.ID, "stick", 1, 0, missing), "craftingToolHardHammer", null,
                        getModItem(Minecraft.ID, "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_axe", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(Minecraft.ID, "diamond", 1, 0, missing), "craftingToolHardHammer",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(Minecraft.ID, "stick", 1, 0, missing), null, "craftingToolFile",
                        getModItem(Minecraft.ID, "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_hoe", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(Minecraft.ID, "diamond", 1, 0, missing), "craftingToolHardHammer",
                        "craftingToolFile", getModItem(Minecraft.ID, "stick", 1, 0, missing), null, null,
                        getModItem(Minecraft.ID, "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_helmet", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing), "craftingToolHardHammer",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing), null, null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_chestplate", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing), "craftingToolHardHammer",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_leggings", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing), "craftingToolHardHammer",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing), null,
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_boots", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing), null,
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing), "craftingToolHardHammer",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 17500, missing), null, null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "iron_horse_armor", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "iron_helmet", 1, 0, missing), "plateIron",
                        getModItem(Minecraft.ID, "iron_chestplate", 1, 0, missing), "plateIron",
                        getModItem(Minecraft.ID, "iron_leggings", 1, 0, missing), "screwIron",
                        getModItem(Minecraft.ID, "iron_leggings", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "golden_horse_armor", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "golden_helmet", 1, 0, missing), "plateGold",
                        getModItem(Minecraft.ID, "golden_chestplate", 1, 0, missing), "plateGold",
                        getModItem(Minecraft.ID, "golden_leggings", 1, 0, missing), "screwGold",
                        getModItem(Minecraft.ID, "golden_leggings", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "diamond_horse_armor", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "diamond_helmet", 1, 0, missing), "plateDiamond",
                        getModItem(Minecraft.ID, "diamond_chestplate", 1, 0, missing), "plateDiamond",
                        getModItem(Minecraft.ID, "diamond_leggings", 1, 0, missing), "screwDiamond",
                        getModItem(Minecraft.ID, "diamond_leggings", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "saddle", 1, 0, missing),
                new Object[] { "itemLeather", getModItem(Backpack.ID, "tannedLeather", 1, 0, missing), "itemLeather",
                        "itemLeather", getModItem(Minecraft.ID, "carpet", 1, 32767, missing), "itemLeather",
                        "ringAnyIron", getModItem(Minecraft.ID, "string", 1, 0, missing), "ringAnyIron" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "clock", 1, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 28086, missing), "plateGold",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 28086, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing),
                        getModItem(Minecraft.ID, "comparator", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 26086, missing), "craftingToolScrewdriver",
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 27086, missing), "craftingToolWrench" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "compass", 1, 0, missing),
                new Object[] { "screwIron", "paneGlass", "boltIron", "ringZinc", "plateIron", "ringZinc",
                        "boltRedAlloy", "craftingToolScrewdriver", "screwIron" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "clay", 2, 0, missing),
                new Object[] { "itemClay", "itemClay", "itemClay", "itemClay",
                        getModItem(Minecraft.ID, "water_bucket", 1, 0, missing), "itemClay", "itemClay", "itemClay",
                        "itemClay" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "clay", 2, 0, missing),
                new Object[] { "itemClay", "itemClay", "itemClay", "itemClay",
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing), "itemClay",
                        "itemClay", "itemClay", "itemClay" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "pumpkin_seeds", 2, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "pumpkin", 1, 0, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "pumpkin_seeds", 2, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "pumpkin", 1, 0, missing), "craftingToolSoftHammer",
                        getModItem(Minecraft.ID, "pumpkin", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "melon_seeds", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "melon", 1, 0, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "melon_seeds", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "melon", 1, 0, missing), "craftingToolSoftHammer",
                        getModItem(Minecraft.ID, "melon", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "melon", 6, 0, missing),
                new Object[] { "craftingToolKnife", getModItem(Minecraft.ID, "melon_block", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "gunpowder", 1, 0, missing),
                new Object[] { "dustSmallGunpowder", "dustSmallGunpowder", "dustSmallGunpowder",
                        "dustSmallGunpowder" });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32559, missing),
                new Object[] { getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2881, missing) });
        addShapelessCraftingRecipe(
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32559, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "freshwaterItem", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2881, missing),
                        getModItem(PamsHarvestCraft.ID, "freshwaterItem", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "chest_minecart", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem(Minecraft.ID, "chest", 1, 0, missing),
                        "craftingToolWrench", null, getModItem(Minecraft.ID, "minecart", 1, 0, missing), null, null,
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "furnace_minecart", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem(Minecraft.ID, "furnace", 1, 0, missing),
                        "craftingToolWrench", null, getModItem(Minecraft.ID, "minecart", 1, 0, missing), null, null,
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "hopper_minecart", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                        "craftingToolWrench", null, getModItem(Minecraft.ID, "minecart", 1, 0, missing), null, null,
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "map", 1, 0, missing),
                new Object[] { "paperEmpty", "paperEmpty", "paperEmpty", "paperEmpty",
                        getModItem(Minecraft.ID, "compass", 1, 0, missing), "paperEmpty", "paperEmpty", "paperEmpty",
                        "paperEmpty" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "dye", 3, 15, missing),
                new Object[] { getModItem(Minecraft.ID, "bone", 1, 0, missing), "craftingToolMortar" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "lead", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "slimeball",
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "pumpkin_pie", 1, 0, missing),
                new Object[] { "craftingToolRollingPin", getModItem(Minecraft.ID, "pumpkin", 1, 0, missing),
                        "dustSugar", getModItem(Minecraft.ID, "pumpkin", 1, 0, missing), "dustSugar", null, "dustSugar",
                        null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "comparator", 1, 0, missing),
                new Object[] { "screwIron", "craftingRedstoneTorch", "screwIron", "craftingRedstoneTorch",
                        "plateNetherQuartz", "craftingRedstoneTorch",
                        getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "comparator", 1, 0, missing),
                new Object[] { "screwIron", "craftingRedstoneTorch", "screwIron", "craftingRedstoneTorch",
                        "plateCertusQuartz", "craftingRedstoneTorch",
                        getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "comparator", 1, 0, missing),
                new Object[] { "screwIron", "craftingRedstoneTorch", "screwIron", "craftingRedstoneTorch",
                        "plateChargedCertusQuartz", "craftingRedstoneTorch",
                        getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "comparator", 1, 0, missing),
                new Object[] { "screwIron", "craftingRedstoneTorch", "screwIron", "craftingRedstoneTorch",
                        "plateQuartzite", "craftingRedstoneTorch",
                        getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "repeater", 1, 0, missing),
                new Object[] { "screwIron", null, "screwIron", "craftingRedstoneTorch", "craftingToolScrewdriver",
                        "craftingRedstoneTorch", getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing),
                        "stickRedAlloy", getModItem(Minecraft.ID, "stone_pressure_plate", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "item_frame", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "string", 1, 0, missing), "ringAnyIron",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood", "itemLeather", "stickWood",
                        "stickWood", "stickWood", "stickWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "bed", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "carpet", 1, 32767, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 32767, missing),
                        getModItem(Minecraft.ID, "carpet", 1, 32767, missing), "plankWood", "plankWood", "plankWood",
                        "fenceWood", "craftingToolSoftHammer", "fenceWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "fishing_rod", 1, 0, missing),
                new Object[] { null, null, "stickLongWood", null, "stickLongWood",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickLongWood", "craftingToolWireCutter",
                        "ringAnyIron" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "paper", 2, 0, missing),
                new Object[] { "dustWood", "dustWood", "dustWood", "dustWood",
                        getModItem(Minecraft.ID, "water_bucket", 1, 0, missing), "dustWood", "dustWood", "dustWood",
                        "dustWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "paper", 2, 0, missing),
                new Object[] { "dustWood", "dustWood", "dustWood", "dustWood",
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing), "dustWood",
                        "dustWood", "dustWood", "dustWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "barleyFood", 1, 3, missing),
                        getModItem(Natura.ID, "barleyFood", 1, 3, missing),
                        getModItem(Natura.ID, "barleyFood", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "flower_pot", 1, 0, missing),
                new Object[] { "craftingToolFile",
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketFired", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                new Object[] { "craftingToolSaw", "stone" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stone_slab", 1, 1, missing),
                new Object[] { "craftingToolSaw", "sandstone" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stone_slab", 1, 3, missing),
                new Object[] { "craftingToolSaw", "cobblestone" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stone_slab", 1, 4, missing),
                new Object[] { "craftingToolSaw", getModItem(Minecraft.ID, "brick_block", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stone_slab", 1, 5, missing),
                new Object[] { "craftingToolSaw", "stoneBricks" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stone_slab", 1, 6, missing),
                new Object[] { "craftingToolSaw", "stoneNetherBrick" });
        addShapelessCraftingRecipe(
                getModItem(Minecraft.ID, "stone_slab", 1, 7, missing),
                new Object[] { "craftingToolSaw", "blockQuartz" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "brick_block", 2, 0, missing),
                new Object[] { "ingotBrick", "ingotBrick", "ingotBrick", "ingotBrick",
                        getModItem(Minecraft.ID, "water_bucket", 1, 0, missing), "ingotBrick", "ingotBrick",
                        "ingotBrick", "ingotBrick" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "brick_block", 2, 0, missing),
                new Object[] { "ingotBrick", "ingotBrick", "ingotBrick", "ingotBrick",
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing), "ingotBrick",
                        "ingotBrick", "ingotBrick", "ingotBrick" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "nether_brick", 2, 0, missing),
                new Object[] { "ingotBrickNether", "ingotBrickNether", "ingotBrickNether", "ingotBrickNether",
                        getModItem(Minecraft.ID, "lava_bucket", 1, 0, missing), "ingotBrickNether", "ingotBrickNether",
                        "ingotBrickNether", "ingotBrickNether" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "nether_brick", 2, 0, missing),
                new Object[] { "ingotBrickNether", "ingotBrickNether", "ingotBrickNether", "ingotBrickNether",
                        getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketLava", 1, 0, missing), "ingotBrickNether",
                        "ingotBrickNether", "ingotBrickNether", "ingotBrickNether" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "planks", 1, 0, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing),
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "craftingToolSaw" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "planks", 1, 0, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "ringCopper", "screwCopper",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing),
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "craftingToolSaw" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "planks", 1, 0, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolSaw",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "ringAnyIron", "screwAnyIron",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing),
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "wooden_door", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "planks", 1, 0, missing),
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing), "craftingToolSaw",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "ringCopper", "screwCopper",
                        getModItem(Minecraft.ID, "planks", 1, 0, missing),
                        getModItem(Minecraft.ID, "planks", 1, 0, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "iron_door", 1, 0, missing),
                new Object[] { "plateAnyIron", getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                        "craftingToolHardHammer", "plateAnyIron", "ringSteel", "screwSteel", "plateAnyIron",
                        "plateAnyIron", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "iron_door", 1, 0, missing),
                new Object[] { "plateAnyIron", getModItem(NewHorizonsCoreMod.ID, "item.SteelBars", 1, 0, missing),
                        "craftingToolScrewdriver", "plateAnyIron", "ringSteel", "screwSteel", "plateAnyIron",
                        "plateAnyIron", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32471, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32471, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32471, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32471, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32471, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32471, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32472, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32472, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32472, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32472, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32472, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32472, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32473, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32473, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32473, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32473, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32473, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32473, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32474, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32474, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32474, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32474, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32474, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32474, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32475, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32475, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32475, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32475, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32475, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32475, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32476, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32476, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32476, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32476, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32476, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32476, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32477, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32477, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32477, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32477, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32477, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32477, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32478, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32478, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32478, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32478, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32478, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32478, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32479, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32479, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32479, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32479, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32479, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32479, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32480, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32480, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32480, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32480, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32480, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32480, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32481, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32481, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32481, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32481, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32481, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32481, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32482, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32482, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32482, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32482, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32482, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32482, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32483, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32483, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32483, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32483, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32483, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32483, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32484, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32484, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32484, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32484, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32484, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32484, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32485, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32485, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32485, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32485, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32485, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32485, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32486, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32486, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32486, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32486, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32486, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32486, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32487, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32487, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32487, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32487, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32487, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32487, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32488, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32488, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32488, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32488, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32488, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32488, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32489, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32489, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32489, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32489, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32489, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32489, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32490, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32490, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32490, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32490, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32490, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32490, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32491, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32491, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32491, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32491, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32491, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32491, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32492, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32492, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32492, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32492, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32492, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32492, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32493, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32493, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32493, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32493, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32493, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32493, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32494, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32494, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32494, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32494, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32494, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32494, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32495, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32495, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32495, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32495, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32495, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32495, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32496, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32496, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32496, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32496, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32496, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32496, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32497, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32497, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32497, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32497, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32497, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32497, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32498, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32498, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32498, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32498, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32498, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32498, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "sign", 3, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.02", 1, 32499, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32499, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32499, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32499, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32499, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32499, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "boat", 1, 0, missing),
                new Object[] { "plankWood", null, "plankWood", "plankWood", "craftingToolKnife", "plankWood",
                        "slabWood", "slabWood", "slabWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "painting", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "string", 1, 0, missing), "ringAnyIron",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "stickWood",
                        getModItem(Minecraft.ID, "carpet", 1, 32767, missing), "stickWood", "stickWood", "stickWood",
                        "stickWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "flint_and_steel", 1, 0, missing),
                new Object[] { null, "gearGtSmallSteel", null, null, getModItem(Minecraft.ID, "flint", 1, 0, missing),
                        null, null, "springSmallSteel", null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "shears", 1, 0, missing),
                new Object[] { "plateIron", "screwIron", "plateIron", "craftingToolHardHammer", "ringIron",
                        "craftingToolFile", "stickWood", "craftingToolScrewdriver", "stickWood" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "nether_star", 16, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metaitem.03", 1, 2506, missing), "craftingToolCrowbar" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "mossy_cobblestone", 1, 0, missing),
                new Object[] { getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(Minecraft.ID, "cobblestone", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "book", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "string", 1, 0, missing), "paperEmpty", "itemLeather",
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "paperEmpty",
                        getModItem(TinkerConstruct.ID, "buckets", 1, 25, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing), "paperEmpty", "itemLeather" });
        addShapedRecipe(
                getModItem(Minecraft.ID, "bookshelf", 1, 0, missing),
                new Object[] { "plateWood", "plateWood", "plateWood", getModItem(Minecraft.ID, "book", 1, 0, missing),
                        getModItem(Minecraft.ID, "book", 1, 0, missing),
                        getModItem(Minecraft.ID, "book", 1, 0, missing), "plateWood", "plateWood", "plateWood" });
        addShapedRecipe(
                getModItem(GregTech.ID, "gt.metaitem.01", 9, 9032, missing),
                new Object[] { "craftingToolSaw", "ingotIron", null, null, null, null, null, null, null });
        addShapedRecipe(
                getModItem(Minecraft.ID, "gold_nugget", 9, 0, missing),
                new Object[] { "craftingToolSaw", "ingotGold", null, null, null, null, null, null, null });
    }
}
