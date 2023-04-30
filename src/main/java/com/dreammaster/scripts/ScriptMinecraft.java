package com.dreammaster.scripts;

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
import gregtech.api.enums.Mods;
import gregtech.api.util.GT_ModHandler;

public class ScriptMinecraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Minecraft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.TinkerConstruct.ID, Mods.BloodArsenal.ID, Mods.Natura.ID, Mods.MagicBees.ID);
    }

    @Override
    public void loadRecipes() {
        craftingRecipes();

        GT_ModHandler.addSmeltingRecipe(
                getModItem("dreamcraft", "item.UnfiredClayBrick", 1, 0, missing),
                getModItem("minecraft", "brick", 1, 0, missing));
        GT_ModHandler.addSmeltingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32561, missing),
                getModItem("minecraft", "bread", 1, 0, missing));
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Thaumcraft", "blockCustomPlant", 1, 3, missing))
                .itemOutputs(getModItem("minecraft", "blaze_powder", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Thaumcraft", "blockCustomPlant", 1, 2, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemResource", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "hay_block", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "wheat", 9, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("harvestthenether", "glowFlower", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "glowstone_dust", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "clay_ball", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem("minecraft", "brick", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(2).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 2807, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32306, missing))
                .itemOutputs(getModItem("minecraft", "netherbrick", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(2).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BloodArsenal", "glass_shard", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32308, missing))
                .itemOutputs(getModItem("minecraft", "glass", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(5).eut(64).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "iron_ingot", 5, 0, missing),
                        getModItem("dreamcraft", "item.MoldHelmet", 0, 0, missing))
                .itemOutputs(getModItem("minecraft", "iron_helmet", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "iron_ingot", 8, 0, missing),
                        getModItem("dreamcraft", "item.MoldChestplate", 0, 0, missing))
                .itemOutputs(getModItem("minecraft", "iron_chestplate", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "iron_ingot", 7, 0, missing),
                        getModItem("dreamcraft", "item.MoldLeggings", 0, 0, missing))
                .itemOutputs(getModItem("minecraft", "iron_leggings", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "iron_ingot", 4, 0, missing),
                        getModItem("dreamcraft", "item.MoldBoots", 0, 0, missing))
                .itemOutputs(getModItem("minecraft", "iron_boots", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "gold_ingot", 5, 0, missing),
                        getModItem("dreamcraft", "item.MoldHelmet", 0, 0, missing))
                .itemOutputs(getModItem("minecraft", "golden_helmet", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "gold_ingot", 8, 0, missing),
                        getModItem("dreamcraft", "item.MoldChestplate", 0, 0, missing))
                .itemOutputs(getModItem("minecraft", "golden_chestplate", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "gold_ingot", 7, 0, missing),
                        getModItem("dreamcraft", "item.MoldLeggings", 0, 0, missing))
                .itemOutputs(getModItem("minecraft", "golden_leggings", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "gold_ingot", 4, 0, missing),
                        getModItem("dreamcraft", "item.MoldBoots", 0, 0, missing))
                .itemOutputs(getModItem("minecraft", "golden_boots", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "sand", 1, 1, missing))
                .itemOutputs(getModItem("minecraft", "glass", 2, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("oxygen", 2)).noFluidOutputs().duration(20).eut(256)
                .addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "sand", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "glass", 2, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("oxygen", 2)).noFluidOutputs().duration(20).eut(256)
                .addTo(sArcFurnaceRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "barleyFood", 2, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "string", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "wheat", 9, 0, missing),
                        getModItem("minecraft", "string", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "hay_block", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "heatsand", 1, 0, missing),
                        getModItem("Natura", "soil.tainted", 4, 0, missing))
                .itemOutputs(getModItem("minecraft", "soul_sand", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).noFluidOutputs().duration(100).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("MagicBees", "miscResources", 6, 4, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem("minecraft", "skull", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.thaumium", 216)).noFluidOutputs().duration(200).eut(96)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("minecraft", "wool", 1, 32767, missing))
                .itemOutputs(getModItem("minecraft", "torch", 5, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("creosote", 500)).noFluidOutputs().duration(100).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2536, missing))
                .itemOutputs(getModItem("minecraft", "torch", 4, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2535, missing))
                .itemOutputs(getModItem("minecraft", "torch", 6, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2022, missing))
                .itemOutputs(getModItem("minecraft", "torch", 4, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2022, missing))
                .itemOutputs(getModItem("minecraft", "torch", 6, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 17809, missing),
                        getModItem("minecraft", "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "wooden_door", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 17809, missing),
                        getModItem("minecraft", "trapdoor", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "wooden_door", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 4, 17032, missing),
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "iron_door", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(400).eut(8)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "wooden_slab", 4, 0, missing),
                        getModItem("minecraft", "stick", 4, 0, missing))
                .itemOutputs(getModItem("minecraft", "trapdoor", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "wooden_slab", 4, 0, missing),
                        getModItem("minecraft", "stick", 4, 0, missing))
                .itemOutputs(getModItem("minecraft", "trapdoor", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "wooden_slab", 4, 0, missing),
                        getModItem("Natura", "natura.stick", 4, 32767, missing))
                .itemOutputs(getModItem("minecraft", "trapdoor", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "wooden_slab", 4, 0, missing),
                        getModItem("Natura", "natura.stick", 4, 32767, missing))
                .itemOutputs(getModItem("minecraft", "trapdoor", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "wooden_slab", 4, 0, missing),
                        getModItem("BiomesOPlenty", "bamboo", 4, 0, missing))
                .itemOutputs(getModItem("minecraft", "trapdoor", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "wooden_slab", 4, 0, missing),
                        getModItem("BiomesOPlenty", "bamboo", 4, 0, missing))
                .itemOutputs(getModItem("minecraft", "trapdoor", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "planks", 6, 32767, missing),
                        getModItem("minecraft", "book", 3, 0, missing))
                .itemOutputs(getModItem("minecraft", "bookshelf", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log2", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftAmunRa", "tile.log1", 1, 0, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalacticraftAmunRa", "tile.wood1", 1, 0, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Thaumcraft", "blockMagicalLog", 1, 1, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "tree", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "redwood", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "willow", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "bloodwood", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "Rare Tree", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "Dark Tree", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs1", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs2", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs3", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs4", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logs", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logsFireproof", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 0, "{meta:0}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 1, "{meta:1}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 2, "{meta:2}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 3, "{meta:3}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 4, "{meta:4}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 5, "{meta:5}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 6, "{meta:6}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 7, "{meta:7}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 8, "{meta:8}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 9, "{meta:9}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 10, "{meta:10}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 11, "{meta:11}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 12, "{meta:12}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 13, "{meta:13}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 14, "{meta:14}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 15, "{meta:15}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 16, "{meta:16}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 17, "{meta:17}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 18, "{meta:18}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 19, "{meta:19}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 20, "{meta:20}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 21, "{meta:21}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 22, "{meta:22}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 23, "{meta:23}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 24, "{meta:24}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 25, "{meta:25}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 26, "{meta:26}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 27, "{meta:27}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 28, "{meta:28}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 29, "{meta:29}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 30, "{meta:30}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 31, "{meta:31}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 32, "{meta:32}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 33, "{meta:33}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 34, "{meta:34}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 35, "{meta:35}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 36, "{meta:36}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 37, "{meta:37}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 38, "{meta:38}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("ExtraTrees", "log", 1, 39, "{meta:39}", missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "pamMaple", 1, 0, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "pamPaperbark", 1, 0, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestcraft", "pamCinnamon", 1, 0, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("thaumicbases", "genLogs", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("witchery", "witchlog", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("miscutils", "blockRainforestOakLog", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("miscutils", "blockPineLogLog", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("GalaxySpace", "barnardaClog", 1, 0, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TaintedMagic", "BlockWarpwoodLog", 1, 0, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TwilightForest", "tile.TFLog", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TwilightForest", "tile.TFMagicLog", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("harvestthenether", "netherLog", 1, 0, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ForbiddenMagic", "TaintLog", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "blockRubWood", 1, 0, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Thaumcraft", "blockMagicalLog", 1, 32767, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "crafting_table", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 2, 0, missing),
                        getModItem("minecraft", "planks", 2, 0, missing))
                .itemOutputs(getModItem("minecraft", "fence_gate", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log", 2, 32767, missing),
                        getModItem("minecraft", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log", 2, 32767, missing),
                        getModItem("ExtraTrees", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log", 2, 32767, missing),
                        getModItem("BiomesOPlenty", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log", 2, 32767, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log", 2, 32767, missing),
                        getModItem("Forestry", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log", 2, 32767, missing),
                        getModItem("Forestry", "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log", 2, 32767, missing),
                        getModItem("Forestry", "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log", 2, 32767, missing),
                        getModItem("Natura", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log", 2, 32767, missing),
                        getModItem("harvestthenether", "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log", 2, 32767, missing),
                        getModItem("witchery", "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log2", 2, 32767, missing),
                        getModItem("minecraft", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log2", 2, 32767, missing),
                        getModItem("BiomesOPlenty", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log2", 2, 32767, missing),
                        getModItem("ExtraTrees", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log2", 2, 32767, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log2", 2, 32767, missing),
                        getModItem("Forestry", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log2", 2, 32767, missing),
                        getModItem("Forestry", "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log2", 2, 32767, missing),
                        getModItem("Natura", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log2", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log2", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log2", 2, 32767, missing),
                        getModItem("harvestthenether", "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "log2", 2, 32767, missing),
                        getModItem("witchery", "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs1", 2, 32767, missing),
                        getModItem("minecraft", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs1", 2, 32767, missing),
                        getModItem("BiomesOPlenty", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs1", 2, 32767, missing),
                        getModItem("ExtraTrees", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs1", 2, 32767, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs1", 2, 32767, missing),
                        getModItem("Forestry", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs1", 2, 32767, missing),
                        getModItem("Forestry", "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs1", 2, 32767, missing),
                        getModItem("Natura", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs1", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs1", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs1", 2, 32767, missing),
                        getModItem("harvestthenether", "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs1", 2, 32767, missing),
                        getModItem("witchery", "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs2", 2, 32767, missing),
                        getModItem("minecraft", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs2", 2, 32767, missing),
                        getModItem("BiomesOPlenty", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs2", 2, 32767, missing),
                        getModItem("ExtraTrees", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs2", 2, 32767, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs2", 2, 32767, missing),
                        getModItem("Forestry", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs2", 2, 32767, missing),
                        getModItem("Forestry", "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs2", 2, 32767, missing),
                        getModItem("Natura", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs2", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs2", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs2", 2, 32767, missing),
                        getModItem("harvestthenether", "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs2", 2, 32767, missing),
                        getModItem("witchery", "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs3", 2, 32767, missing),
                        getModItem("minecraft", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs3", 2, 32767, missing),
                        getModItem("BiomesOPlenty", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs3", 2, 32767, missing),
                        getModItem("ExtraTrees", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs3", 2, 32767, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs3", 2, 32767, missing),
                        getModItem("Forestry", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs3", 2, 32767, missing),
                        getModItem("Forestry", "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs3", 2, 32767, missing),
                        getModItem("Natura", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs3", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs3", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs3", 2, 32767, missing),
                        getModItem("harvestthenether", "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs3", 2, 32767, missing),
                        getModItem("witchery", "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs4", 2, 32767, missing),
                        getModItem("minecraft", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs4", 2, 32767, missing),
                        getModItem("BiomesOPlenty", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs4", 2, 32767, missing),
                        getModItem("ExtraTrees", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs4", 2, 32767, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs4", 2, 32767, missing),
                        getModItem("Forestry", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs4", 2, 32767, missing),
                        getModItem("Forestry", "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs4", 2, 32767, missing),
                        getModItem("Natura", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs4", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs4", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs4", 2, 32767, missing),
                        getModItem("harvestthenether", "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "logs4", 2, 32767, missing),
                        getModItem("witchery", "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "log", 2, 32767, missing),
                        getModItem("minecraft", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "log", 2, 32767, missing),
                        getModItem("BiomesOPlenty", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "log", 2, 32767, missing),
                        getModItem("ExtraTrees", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "log", 2, 32767, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "log", 2, 32767, missing),
                        getModItem("Forestry", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "log", 2, 32767, missing),
                        getModItem("Forestry", "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "log", 2, 32767, missing),
                        getModItem("Natura", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "log", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "log", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "log", 2, 32767, missing),
                        getModItem("harvestthenether", "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("ExtraTrees", "log", 2, 32767, missing),
                        getModItem("witchery", "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logs", 2, 32767, missing),
                        getModItem("minecraft", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logs", 2, 32767, missing),
                        getModItem("BiomesOPlenty", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logs", 2, 32767, missing),
                        getModItem("ExtraTrees", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logs", 2, 32767, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logs", 2, 32767, missing),
                        getModItem("Forestry", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logs", 2, 32767, missing),
                        getModItem("Forestry", "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logs", 2, 32767, missing),
                        getModItem("Natura", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logs", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logs", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logs", 2, 32767, missing),
                        getModItem("harvestthenether", "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logs", 2, 32767, missing),
                        getModItem("witchery", "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logsFireproof", 2, 32767, missing),
                        getModItem("minecraft", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logsFireproof", 2, 32767, missing),
                        getModItem("BiomesOPlenty", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logsFireproof", 2, 32767, missing),
                        getModItem("ExtraTrees", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logsFireproof", 2, 32767, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logsFireproof", 2, 32767, missing),
                        getModItem("Forestry", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logsFireproof", 2, 32767, missing),
                        getModItem("Forestry", "planksFireproof", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logsFireproof", 2, 32767, missing),
                        getModItem("Natura", "planks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logsFireproof", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 6, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logsFireproof", 2, 32767, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 7, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logsFireproof", 2, 32767, missing),
                        getModItem("harvestthenether", "netherPlanks", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "logsFireproof", 2, 32767, missing),
                        getModItem("witchery", "witchwood", 2, 32767, missing))
                .itemOutputs(getModItem("minecraft", "chest", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("minecraft", "stone_button", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "lever", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(50).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("minecraft", "stone_button", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "lever", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(50).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "bamboo", 1, 0, missing),
                        getModItem("minecraft", "stone_button", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "lever", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(50).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("BiomesOPlenty", "plants", 1, 8, missing),
                        getModItem("minecraft", "stone_button", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "lever", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(50).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27809, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem("minecraft", "ladder", 2, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem("minecraft", "ladder", 4, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27305, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem("minecraft", "ladder", 8, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27019, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 6, missing))
                .itemOutputs(getModItem("minecraft", "ladder", 32, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "brick", 8, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "brick_block", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 500)).noFluidOutputs().duration(300).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32471, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32472, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32473, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32474, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32475, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32476, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32477, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32478, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32479, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32480, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32481, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32482, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32483, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32484, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32485, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32486, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32487, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32488, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32489, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32490, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32471, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32472, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32473, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32474, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32475, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32476, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32477, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32478, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32479, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32480, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32481, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32482, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32483, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32484, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32485, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32486, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32487, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32488, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32489, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32490, missing))
                .itemOutputs(getModItem("minecraft", "sign", 3, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.02", 2, 32470, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("minecraft", "wooden_pressure_plate", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.02", 2, 32470, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem("minecraft", "wooden_pressure_plate", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stone_slab", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("minecraft", "stone_pressure_plate", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stone_slab", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem("minecraft", "stone_pressure_plate", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("minecraft", "planks", 2, 32767, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 1, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 2, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 4, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 5, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 7, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 8, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 9, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 10, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 11, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 12, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 13, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 14, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ExtraUtilities", "colorWoodPlanks", 2, 15, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("GalacticraftAmunRa", "tile.wood1", 2, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("GalacticraftAmunRa", "tile.wood1", 2, 2, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 2, 7, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("Natura", "planks", 2, 32767, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("BiomesOPlenty", "planks", 2, 32767, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("Forestry", "planks", 2, 32767, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("Forestry", "planksFireproof", 2, 32767, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 0, "{meta:0}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 1, "{meta:1}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 2, "{meta:2}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 3, "{meta:3}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 4, "{meta:4}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 5, "{meta:5}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 6, "{meta:6}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 7, "{meta:7}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 8, "{meta:8}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 9, "{meta:9}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 10, "{meta:10}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 11, "{meta:11}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 12, "{meta:12}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 13, "{meta:13}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 14, "{meta:14}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 15, "{meta:15}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 16, "{meta:16}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 17, "{meta:17}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 18, "{meta:18}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 19, "{meta:19}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 20, "{meta:20}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 21, "{meta:21}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 22, "{meta:22}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 23, "{meta:23}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 24, "{meta:24}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 25, "{meta:25}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 26, "{meta:26}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 27, "{meta:27}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 28, "{meta:28}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 29, "{meta:29}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 30, "{meta:30}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 31, "{meta:31}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 32, "{meta:32}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 33, "{meta:33}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        createItemStack("ExtraTrees", "planks", 2, 34, "{meta:34}", missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 17809, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("thaumicbases", "enderPlanks", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("witchery", "witchwood", 2, 32767, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("GalaxySpace", "barnardaCplanks", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("TaintedMagic", "BlockWarpwoodPlanks", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("harvestthenether", "netherPlanks", 2, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("TwilightForest", "tile.TFTowerStone", 2, 32767, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("TwilightForest", "tile.TFPlank", 2, 32767, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "carpet", 2, 32767, missing),
                        getModItem("harvestcraft", "wovencottonItem", 2, 0, missing),
                        getModItem("ForbiddenMagic", "TaintPlank", 2, 32767, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "bed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("IC2", "itemPlates", 1, 3, missing),
                        getModItem("minecraft", "comparator", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "clock", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("minecraft", "comparator", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "clock", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "leather", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 28032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "saddle", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("dreamcraft", "item.ArtificialLeather", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 28032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "saddle", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(24).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "GlassBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "glass", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(120).specialValue(1000).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("minecraft", "glass_pane", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(120).specialValue(1000).addTo(sBlastRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "skull", 1, 0, missing))
                .itemOutputs(
                        getModItem("minecraft", "bone", 8, 0, missing),
                        getModItem("minecraft", "bone", 6, 0, missing),
                        getModItem("minecraft", "bone", 4, 0, missing))
                .outputChances(10000, 7500, 5000).fluidInputs(FluidRegistry.getFluidStack("hell_blood", 1000))
                .noFluidOutputs().duration(200).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "skull", 1, 1, missing))
                .itemOutputs(
                        getModItem("minecraft", "coal_block", 2, 0, missing),
                        getModItem("minecraft", "coal_block", 1, 0, missing),
                        getModItem("minecraft", "coal_block", 1, 0, missing))
                .outputChances(10000, 7500, 5000).fluidInputs(FluidRegistry.getFluidStack("hell_blood", 1000))
                .noFluidOutputs().duration(200).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "skull", 1, 4, missing))
                .itemOutputs(
                        getModItem("minecraft", "gunpowder", 4, 0, missing),
                        getModItem("minecraft", "gunpowder", 3, 0, missing),
                        getModItem("minecraft", "gunpowder", 2, 0, missing))
                .outputChances(10000, 7500, 5000).fluidInputs(FluidRegistry.getFluidStack("hell_blood", 1000))
                .noFluidOutputs().duration(200).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "enderman_head", 1, 0, missing))
                .itemOutputs(
                        getModItem("minecraft", "ender_pearl", 1, 0, missing),
                        getModItem("minecraft", "ender_pearl", 1, 0, missing),
                        getModItem("minecraft", "ender_pearl", 1, 0, missing))
                .outputChances(10000, 5000, 2500).fluidInputs(FluidRegistry.getFluidStack("hell_blood", 1000))
                .noFluidOutputs().duration(200).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "skull", 1, 3, missing))
                .itemOutputs(getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing)).outputChances(1000)
                .fluidInputs(FluidRegistry.getFluidStack("hell_blood", 1000)).noFluidOutputs().duration(200).eut(30)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "skull", 1, 2, missing))
                .itemOutputs(
                        getModItem("minecraft", "rotten_flesh", 4, 0, missing),
                        getModItem("minecraft", "leather", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 4, 2892, missing))
                .outputChances(10000, 3000, 5000).fluidInputs(FluidRegistry.getFluidStack("hell_blood", 1000))
                .noFluidOutputs().duration(200).eut(30).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "wooden_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "wooden_button", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "wooden_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "wooden_button", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "wooden_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "wooden_button", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "stone_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "stone_button", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "stone_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "stone_button", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "stone_pressure_plate", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "stone_button", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "sand", 1, 32767, missing)).noItemOutputs()
                .noFluidInputs().fluidOutputs(FluidRegistry.getFluidStack("molten.glass", 144)).duration(10000).eut(200)
                .addTo(sFluidExtractionRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "obsidian", 1, 0, missing)).noItemOutputs()
                .noFluidInputs().fluidOutputs(FluidRegistry.getFluidStack("obsidian.molten", 288)).duration(10000)
                .eut(600).addTo(sFluidExtractionRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "sand", 4, 32767, missing),
                        getModItem("minecraft", "dirt", 1, 32767, missing),
                        getModItem("MagicBees", "wax", 4, 1, missing))
                .itemOutputs(getModItem("minecraft", "soul_sand", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).noFluidOutputs().duration(100).eut(16)
                .addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "blaze_powder", 3, 0, missing),
                        getModItem("minecraft", "gunpowder", 3, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 3, 2535, missing))
                .itemOutputs(getModItem("minecraft", "fire_charge", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(400).eut(30).addTo(sMixerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "melon_block", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 0, 32398, missing))
                .itemOutputs(getModItem("minecraft", "melon", 8, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(100).eut(8).addTo(sSlicerRecipes);
        GT_ModHandler.setFuelValue(getModItem("minecraft", "wooden_pressure_plate", 1, 0, missing), (short) 75);

    }

    private void craftingRecipes() {
        addShapelessCraftingRecipe(
                getModItem("minecraft", "crafting_table", 1, 0, missing),
                new Object[] { getModItem("minecraft", "flint", 1, 0, missing),
                        getModItem("minecraft", "flint", 1, 0, missing), "logWood", "logWood" });
        addShapedRecipe(
                getModItem("minecraft", "chest", 1, 0, missing),
                new Object[] { "logWood", "plankWood", "logWood", "plankWood",
                        getModItem("minecraft", "flint", 1, 0, missing), "plankWood", "logWood", "plankWood",
                        "logWood" });
        addShapedRecipe(
                getModItem("minecraft", "trapped_chest", 1, 0, missing),
                new Object[] { null, getModItem("minecraft", "tripwire_hook", 1, 0, missing), null, "screwAnyIron",
                        getModItem("minecraft", "chest", 1, 0, missing), "screwAnyIron", null,
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("minecraft", "furnace", 1, 0, missing),
                new Object[] { "cobblestone", "cobblestone", "cobblestone",
                        getModItem("minecraft", "flint", 1, 0, missing),
                        getModItem("minecraft", "flint", 1, 0, missing),
                        getModItem("minecraft", "flint", 1, 0, missing), "cobblestone", "cobblestone", "cobblestone" });
        addShapedRecipe(
                getModItem("minecraft", "dispenser", 1, 0, missing),
                new Object[] { "cobblestone", "ringAnyIron", "cobblestone", "springIron",
                        getModItem("minecraft", "string", 1, 0, missing), "springIron", "gearGtSmallAnyIron",
                        "stickRedAlloy", "gearGtSmallAnyIron" });
        addShapedRecipe(
                getModItem("minecraft", "dropper", 1, 0, missing),
                new Object[] { "cobblestone", "ringAnyIron", "cobblestone", "springSmallIron",
                        getModItem("minecraft", "string", 1, 0, missing), "springSmallIron", "gearGtSmallAnyIron",
                        "stickRedAlloy", "gearGtSmallAnyIron" });
        addShapedRecipe(
                getModItem("minecraft", "piston", 1, 0, missing),
                new Object[] { getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "gearGtSmallAnyIron",
                        "fenceWood", "gearGtSmallAnyIron", "cobblestone", "plateRedAlloy", "cobblestone" });
        addShapedRecipe(
                getModItem("minecraft", "sticky_piston", 1, 0, missing),
                new Object[] { null, "craftingToolSoftHammer", null, null, "slimeball", null, null,
                        getModItem("minecraft", "piston", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("minecraft", "rail", 8, 0, missing),
                new Object[] { "screwAnyIron", null, "screwAnyIron",
                        getModItem("Railcraft", "part.rail", 1, 0, missing),
                        getModItem("Railcraft", "part.railbed", 1, 0, missing),
                        getModItem("Railcraft", "part.rail", 1, 0, missing), "craftingToolScrewdriver", null,
                        "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("minecraft", "detector_rail", 1, 0, missing),
                new Object[] { "screwAnyIron", getModItem("Railcraft", "detector", 1, 1, missing), "screwAnyIron",
                        getModItem("Railcraft", "part.rail", 1, 0, missing),
                        getModItem("Railcraft", "part.railbed", 1, 0, missing),
                        getModItem("Railcraft", "part.rail", 1, 0, missing), "craftingToolScrewdriver", "stickRedAlloy",
                        "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("minecraft", "activator_rail", 2, 0, missing),
                new Object[] { "screwAnyIron", getModItem("minecraft", "redstone_torch", 1, 0, missing), "screwAnyIron",
                        getModItem("Railcraft", "part.rail", 1, 0, missing),
                        getModItem("Railcraft", "part.railbed", 1, 0, missing),
                        getModItem("Railcraft", "part.rail", 1, 0, missing), "craftingToolScrewdriver", "stickRedAlloy",
                        "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("minecraft", "noteblock", 1, 0, missing),
                new Object[] { "plankWood", "plankWood", "plankWood",
                        getModItem("minecraft", "iron_bars", 1, 0, missing), "gearWood",
                        getModItem("minecraft", "iron_bars", 1, 0, missing), "plankWood", "stickRedAlloy",
                        "plankWood" });
        addShapedRecipe(
                getModItem("minecraft", "jukebox", 1, 0, missing),
                new Object[] { "logWood", getModItem("gregtech", "gt.metaitem.01", 1, 26500, missing), "logWood",
                        getModItem("minecraft", "noteblock", 1, 0, missing), "record",
                        getModItem("minecraft", "noteblock", 1, 0, missing), "logWood", "gearAnyIron", "logWood" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "lit_pumpkin", 1, 0, missing),
                new Object[] { getModItem("minecraft", "pumpkin", 1, 0, missing),
                        getModItem("minecraft", "torch", 1, 0, missing), "craftingToolKnife" });
        addShapedRecipe(
                getModItem("minecraft", "trapdoor", 1, 0, missing),
                new Object[] { getModItem("minecraft", "wooden_slab", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "wooden_slab", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "flint", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "wooden_slab", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "wooden_slab", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "trapdoor", 2, 0, missing),
                new Object[] { getModItem("minecraft", "wooden_slab", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "wooden_slab", 1, 0, missing), "stickWood", "screwAnyIron", "stickWood",
                        getModItem("minecraft", "wooden_slab", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "wooden_slab", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "trapdoor", 3, 0, missing),
                new Object[] { getModItem("minecraft", "wooden_slab", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "wooden_slab", 1, 0, missing), "stickWood", "screwSteel", "stickWood",
                        getModItem("minecraft", "wooden_slab", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "wooden_slab", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "stone_pressure_plate", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolHardHammer", "screwIron",
                        getModItem("minecraft", "stone_slab", 1, 0, missing), "springAnyIron",
                        getModItem("minecraft", "stone_slab", 1, 0, missing), "screwIron", "craftingToolScrewdriver",
                        "screwIron" });
        addShapedRecipe(
                getModItem("minecraft", "wooden_pressure_plate", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing), "springAnyIron",
                        getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing), "screwWood",
                        "craftingToolScrewdriver", "screwWood" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "glass_pane", 2, 0, missing),
                new Object[] { "craftingToolSaw", "glass" });
        addShapedRecipe(
                getModItem("minecraft", "torch", 3, 0, missing),
                new Object[] { "gemCoal", null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "torch", 2, 0, missing),
                new Object[] { "gemCharcoal", null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "torch", 1, 0, missing),
                new Object[] { "gemLignite", null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "torch", 5, 0, missing),
                new Object[] { "fuelCoke", null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "torch", 5, 0, missing),
                new Object[] { "blockWool", getModItem("Railcraft", "fluid.creosote.bucket", 1, 0, missing),
                        "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "torch", 4, 0, missing),
                new Object[] { getModItem("TwilightForest", "item.torchberries", 1, 0, missing), null, "stickWood",
                        null });
        addShapedRecipe(
                getModItem("minecraft", "torch", 3, 0, missing),
                new Object[] { "itemBeeswax", getModItem("minecraft", "string", 1, 0, missing), "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "torch", 2, 0, missing),
                new Object[] { getModItem("IC2", "itemHarz", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood", null });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "lever", 1, 0, missing),
                new Object[] { "stickWood", getModItem("minecraft", "stone_button", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "stone_button", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("minecraft", "stone_pressure_plate", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "wooden_button", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("minecraft", "wooden_pressure_plate", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "redstone_torch", 1, 0, missing),
                new Object[] { "dustRedstone", null, getModItem("minecraft", "torch", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("minecraft", "ladder", 2, 0, missing),
                new Object[] { "stickWood", "craftingToolScrewdriver", "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "screwWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood", "craftingToolSoftHammer",
                        "stickWood" });
        addShapedRecipe(
                getModItem("minecraft", "ladder", 4, 0, missing),
                new Object[] { "stickWood", "craftingToolScrewdriver", "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "screwAnyIron",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood", "craftingToolSoftHammer",
                        "stickWood" });
        addShapedRecipe(
                getModItem("minecraft", "ladder", 8, 0, missing),
                new Object[] { "stickWood", "craftingToolScrewdriver", "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), "screwSteel",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood", "craftingToolSoftHammer",
                        "stickWood" });
        addShapedRecipe(
                getModItem("minecraft", "fence", 1, 0, missing),
                new Object[] { "stickWood", getModItem("minecraft", "planks", 1, 0, missing), "stickWood", "stickWood",
                        getModItem("minecraft", "planks", 1, 0, missing), "stickWood", "stickWood",
                        getModItem("minecraft", "planks", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("minecraft", "fence", 2, 0, missing),
                new Object[] { "screwAnyIron", "craftingToolScrewdriver", "screwAnyIron", "stickWood",
                        getModItem("minecraft", "planks", 1, 0, missing), "stickWood", "stickWood",
                        getModItem("minecraft", "planks", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("minecraft", "fence", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("minecraft", "planks", 1, 0, missing), "stickWood", "stickWood",
                        getModItem("minecraft", "planks", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("minecraft", "fence", 2, 0, missing),
                new Object[] { null, null, null, "stickWood",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "stickWood", "stickWood",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("minecraft", "fence", 4, 0, missing),
                new Object[] { "screwAnyIron", "craftingToolScrewdriver", "screwAnyIron", "stickWood",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "stickWood", "stickWood",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("minecraft", "fence", 6, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "stickWood",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "stickWood", "stickWood",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "stickWood" });
        addShapedRecipe(
                getModItem("minecraft", "fence_gate", 1, 0, missing),
                new Object[] { getModItem("minecraft", "flint", 1, 0, missing), null,
                        getModItem("minecraft", "flint", 1, 0, missing),
                        getModItem("minecraft", "planks", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "planks", 1, 0, missing),
                        getModItem("minecraft", "planks", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "fence_gate", 2, 0, missing),
                new Object[] { "screwAnyIron", "craftingToolScrewdriver", "screwAnyIron",
                        getModItem("minecraft", "planks", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "planks", 1, 0, missing),
                        getModItem("minecraft", "planks", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "fence_gate", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("minecraft", "planks", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "planks", 1, 0, missing),
                        getModItem("minecraft", "planks", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "fence_gate", 2, 0, missing),
                new Object[] { null, null, null, getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        "stickWood", getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "stickWood",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "fence_gate", 4, 0, missing),
                new Object[] { "screwAnyIron", "craftingToolScrewdriver", "screwAnyIron",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "stickWood",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "stickWood",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "fence_gate", 6, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "stickWood",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing),
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing), "stickWood",
                        getModItem("CarpentersBlocks", "blockCarpentersBlock", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "redstone_lamp", 1, 0, missing),
                new Object[] { getModItem("minecraft", "glass_pane", 1, 0, missing),
                        getModItem("minecraft", "glass_pane", 1, 0, missing),
                        getModItem("minecraft", "glass_pane", 1, 0, missing),
                        getModItem("minecraft", "glass_pane", 1, 0, missing),
                        getModItem("minecraft", "glowstone", 1, 0, missing),
                        getModItem("minecraft", "glass_pane", 1, 0, missing),
                        getModItem("minecraft", "glass_pane", 1, 0, missing), "stickRedAlloy",
                        getModItem("minecraft", "glass_pane", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "tripwire_hook", 1, 0, missing),
                new Object[] { "ringAnyIron", "stickWood", "ringAnyIron",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "string", 1, 0, missing), null,
                        getModItem("minecraft", "string", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("minecraft", "anvil", 1, 0, missing),
                new Object[] { "blockIron", "blockIron", "blockIron", "screwAnyIron", "blockIron", "screwAnyIron",
                        "plateAnyIron", "blockIron", "plateAnyIron" });
        addShapedRecipe(
                getModItem("minecraft", "daylight_detector", 1, 0, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "plateNetherQuartz", "plateCertusQuartz",
                        "plateNetherQuartz", "slabWood", "stickRedAlloy", "slabWood" });
        addShapedRecipe(
                getModItem("minecraft", "hopper", 1, 0, missing),
                new Object[] { "plateAnyIron", getModItem("minecraft", "chest", 1, 0, missing), "plateAnyIron",
                        "plateAnyIron", "gearAnyIron", "plateAnyIron", "craftingToolHardHammer", "plateAnyIron",
                        "craftingToolFile" });
        addShapedRecipe(
                getModItem("minecraft", "wool", 7, 0, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeWhite", "blockWool", "blockWool",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "wool", 1, 0, missing),
                new Object[] { "blockWool", "dyeWhite" });
        addShapedRecipe(
                getModItem("minecraft", "wool", 1, 0, missing),
                new Object[] { getModItem("minecraft", "string", 1, 0, missing), null,
                        getModItem("minecraft", "string", 1, 0, missing), null,
                        getModItem("minecraft", "string", 1, 0, missing), null,
                        getModItem("minecraft", "string", 1, 0, missing), null,
                        getModItem("minecraft", "string", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "wool", 1, 0, missing),
                new Object[] { getModItem("BiomesOPlenty", "plants", 1, 7, missing),
                        getModItem("BiomesOPlenty", "plants", 1, 7, missing),
                        getModItem("BiomesOPlenty", "plants", 1, 7, missing),
                        getModItem("BiomesOPlenty", "plants", 1, 7, missing),
                        getModItem("BiomesOPlenty", "plants", 1, 7, missing),
                        getModItem("BiomesOPlenty", "plants", 1, 7, missing),
                        getModItem("BiomesOPlenty", "plants", 1, 7, missing),
                        getModItem("BiomesOPlenty", "plants", 1, 7, missing),
                        getModItem("BiomesOPlenty", "plants", 1, 7, missing) });
        addShapedRecipe(
                getModItem("minecraft", "wool", 7, 1, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeOrange", "blockWool",
                        "blockWool", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "wool", 1, 1, missing),
                new Object[] { "blockWool", "dyeOrange" });
        addShapedRecipe(
                getModItem("minecraft", "wool", 7, 2, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeMagenta", "blockWool",
                        "blockWool", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "wool", 1, 2, missing),
                new Object[] { "blockWool", "dyeMagenta" });
        addShapedRecipe(
                getModItem("minecraft", "wool", 7, 3, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeLightBlue", "blockWool",
                        "blockWool", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "wool", 1, 3, missing),
                new Object[] { "blockWool", "dyeLightBlue" });
        addShapedRecipe(
                getModItem("minecraft", "wool", 7, 4, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeYellow", "blockWool",
                        "blockWool", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "wool", 1, 4, missing),
                new Object[] { "blockWool", "dyeYellow" });
        addShapedRecipe(
                getModItem("minecraft", "wool", 7, 5, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeLime", "blockWool", "blockWool",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "wool", 1, 5, missing),
                new Object[] { "blockWool", "dyeLime" });
        addShapedRecipe(
                getModItem("minecraft", "wool", 7, 6, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyePink", "blockWool", "blockWool",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "wool", 1, 6, missing),
                new Object[] { "blockWool", "dyePink" });
        addShapedRecipe(
                getModItem("minecraft", "wool", 7, 7, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeGray", "blockWool", "blockWool",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "wool", 1, 7, missing),
                new Object[] { "blockWool", "dyeGray" });
        addShapedRecipe(
                getModItem("minecraft", "wool", 7, 8, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeLightGray", "blockWool",
                        "blockWool", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "wool", 1, 8, missing),
                new Object[] { "blockWool", "dyeLightGray" });
        addShapedRecipe(
                getModItem("minecraft", "wool", 7, 9, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeCyan", "blockWool", "blockWool",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "wool", 1, 9, missing),
                new Object[] { "blockWool", "dyeCyan" });
        addShapedRecipe(
                getModItem("minecraft", "wool", 7, 10, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyePurple", "blockWool",
                        "blockWool", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "wool", 1, 10, missing),
                new Object[] { "blockWool", "dyePurple" });
        addShapedRecipe(
                getModItem("minecraft", "wool", 7, 11, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeBlue", "blockWool", "blockWool",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "wool", 1, 11, missing),
                new Object[] { "blockWool", "dyeBlue" });
        addShapedRecipe(
                getModItem("minecraft", "wool", 7, 12, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeBrown", "blockWool", "blockWool",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "wool", 1, 12, missing),
                new Object[] { "blockWool", "dyeBrown" });
        addShapedRecipe(
                getModItem("minecraft", "wool", 7, 13, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeGreen", "blockWool", "blockWool",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "wool", 1, 13, missing),
                new Object[] { "blockWool", "dyeGreen" });
        addShapedRecipe(
                getModItem("minecraft", "wool", 7, 14, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeRed", "blockWool", "blockWool",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "wool", 1, 14, missing),
                new Object[] { "blockWool", "dyeRed" });
        addShapedRecipe(
                getModItem("minecraft", "wool", 7, 15, missing),
                new Object[] { "blockWool", "blockWool", "blockWool", "blockWool", "dyeBlack", "blockWool", "blockWool",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "blockWool" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "wool", 1, 15, missing),
                new Object[] { "blockWool", "dyeBlack" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass", 7, 0, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeWhite", "glass", "glass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass", 1, 0, missing),
                new Object[] { "glass", "dyeWhite" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass", 7, 1, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeOrange", "glass", "glass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass", 1, 1, missing),
                new Object[] { "glass", "dyeOrange" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass", 7, 2, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeMagenta", "glass", "glass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass", 1, 2, missing),
                new Object[] { "glass", "dyeMagenta" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass", 7, 3, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeLightBlue", "glass", "glass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass", 1, 3, missing),
                new Object[] { "glass", "dyeLightBlue" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass", 7, 4, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeYellow", "glass", "glass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass", 1, 4, missing),
                new Object[] { "glass", "dyeYellow" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass", 7, 5, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeLime", "glass", "glass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass", 1, 5, missing),
                new Object[] { "glass", "dyeLime" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass", 7, 6, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyePink", "glass", "glass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass", 1, 6, missing),
                new Object[] { "glass", "dyePink" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass", 7, 7, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeGray", "glass", "glass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass", 1, 7, missing),
                new Object[] { "glass", "dyeGray" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass", 7, 8, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeLightGray", "glass", "glass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass", 1, 8, missing),
                new Object[] { "glass", "dyeLightGray" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass", 7, 9, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeCyan", "glass", "glass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass", 1, 9, missing),
                new Object[] { "glass", "dyeCyan" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass", 7, 10, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyePurple", "glass", "glass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass", 1, 10, missing),
                new Object[] { "glass", "dyePurple" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass", 7, 11, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeBlue", "glass", "glass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass", 1, 11, missing),
                new Object[] { "glass", "dyeBlue" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass", 7, 12, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeBrown", "glass", "glass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass", 1, 12, missing),
                new Object[] { "glass", "dyeBrown" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass", 7, 13, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeGreen", "glass", "glass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass", 1, 13, missing),
                new Object[] { "glass", "dyeGreen" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass", 7, 14, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeRed", "glass", "glass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass", 1, 14, missing),
                new Object[] { "glass", "dyeRed" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass", 7, 15, missing),
                new Object[] { "glass", "glass", "glass", "glass", "dyeBlack", "glass", "glass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "glass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass", 1, 15, missing),
                new Object[] { "glass", "dyeBlack" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass_pane", 7, 0, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeWhite", "paneGlass", "paneGlass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass_pane", 1, 0, missing),
                new Object[] { "paneGlass", "dyeWhite" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass_pane", 7, 1, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeOrange", "paneGlass",
                        "paneGlass", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass_pane", 1, 1, missing),
                new Object[] { "paneGlass", "dyeOrange" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass_pane", 7, 2, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeMagenta", "paneGlass",
                        "paneGlass", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass_pane", 1, 2, missing),
                new Object[] { "paneGlass", "dyeMagenta" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass_pane", 7, 3, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeLightBlue", "paneGlass",
                        "paneGlass", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass_pane", 1, 3, missing),
                new Object[] { "paneGlass", "dyeLightBlue" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass_pane", 7, 4, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeYellow", "paneGlass",
                        "paneGlass", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass_pane", 1, 4, missing),
                new Object[] { "paneGlass", "dyeYellow" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass_pane", 7, 5, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeLime", "paneGlass", "paneGlass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass_pane", 1, 5, missing),
                new Object[] { "paneGlass", "dyeLime" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass_pane", 7, 6, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyePink", "paneGlass", "paneGlass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass_pane", 1, 6, missing),
                new Object[] { "paneGlass", "dyePink" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass_pane", 7, 7, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeGray", "paneGlass", "paneGlass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass_pane", 1, 7, missing),
                new Object[] { "paneGlass", "dyeGray" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass_pane", 7, 8, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeLightGray", "paneGlass",
                        "paneGlass", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass_pane", 1, 8, missing),
                new Object[] { "paneGlass", "dyeLightGray" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass_pane", 7, 9, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeCyan", "paneGlass", "paneGlass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass_pane", 1, 9, missing),
                new Object[] { "paneGlass", "dyeCyan" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass_pane", 7, 10, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyePurple", "paneGlass",
                        "paneGlass", getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass_pane", 1, 10, missing),
                new Object[] { "paneGlass", "dyePurple" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass_pane", 7, 11, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeBlue", "paneGlass", "paneGlass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass_pane", 1, 11, missing),
                new Object[] { "paneGlass", "dyeBlue" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass_pane", 7, 12, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeBrown", "paneGlass", "paneGlass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass_pane", 1, 12, missing),
                new Object[] { "paneGlass", "dyeBrown" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass_pane", 7, 13, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeGreen", "paneGlass", "paneGlass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass_pane", 1, 13, missing),
                new Object[] { "paneGlass", "dyeGreen" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass_pane", 7, 14, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeRed", "paneGlass", "paneGlass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass_pane", 1, 14, missing),
                new Object[] { "paneGlass", "dyeRed" });
        addShapedRecipe(
                getModItem("minecraft", "stained_glass_pane", 7, 15, missing),
                new Object[] { "paneGlass", "paneGlass", "paneGlass", "paneGlass", "dyeBlack", "paneGlass", "paneGlass",
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing), "paneGlass" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_glass_pane", 1, 15, missing),
                new Object[] { "paneGlass", "dyeBlack" });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 1, 0, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 0, missing),
                        getModItem("minecraft", "wool", 1, 0, missing), null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 3, 0, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 0, missing),
                        getModItem("minecraft", "wool", 1, 0, missing), "craftingToolSaw", null, null, null, null, null,
                        null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 7, 1, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing), "dyeOrange",
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "carpet", 1, 1, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing), "dyeOrange" });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 1, 1, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 1, missing),
                        getModItem("minecraft", "wool", 1, 1, missing), null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 3, 1, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 1, missing),
                        getModItem("minecraft", "wool", 1, 1, missing), "craftingToolSaw", null, null, null, null, null,
                        null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 7, 2, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing), "dyeMagenta",
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "carpet", 1, 2, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing), "dyeMagenta" });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 1, 2, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 2, missing),
                        getModItem("minecraft", "wool", 1, 2, missing), null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 3, 2, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 2, missing),
                        getModItem("minecraft", "wool", 1, 2, missing), "craftingToolSaw", null, null, null, null, null,
                        null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 7, 3, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing), "dyeLightBlue",
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "carpet", 1, 3, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing), "dyeLightBlue" });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 1, 3, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 3, missing),
                        getModItem("minecraft", "wool", 1, 3, missing), null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 3, 3, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 3, missing),
                        getModItem("minecraft", "wool", 1, 3, missing), "craftingToolSaw", null, null, null, null, null,
                        null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 7, 4, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing), "dyeYellow",
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "carpet", 1, 4, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing), "dyeYellow" });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 1, 4, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 4, missing),
                        getModItem("minecraft", "wool", 1, 4, missing), null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 3, 4, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 4, missing),
                        getModItem("minecraft", "wool", 1, 4, missing), "craftingToolSaw", null, null, null, null, null,
                        null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 7, 5, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing), "dyeLime",
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "carpet", 1, 5, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing), "dyeLime" });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 1, 5, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 5, missing),
                        getModItem("minecraft", "wool", 1, 5, missing), null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 3, 5, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 5, missing),
                        getModItem("minecraft", "wool", 1, 5, missing), "craftingToolSaw", null, null, null, null, null,
                        null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 7, 6, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing), "dyePink",
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "carpet", 1, 6, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing), "dyePink" });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 1, 6, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 6, missing),
                        getModItem("minecraft", "wool", 1, 6, missing), null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 3, 6, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 6, missing),
                        getModItem("minecraft", "wool", 1, 6, missing), "craftingToolSaw", null, null, null, null, null,
                        null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 7, 7, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing), "dyeGray",
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "carpet", 1, 7, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing), "dyeGray" });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 1, 7, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 7, missing),
                        getModItem("minecraft", "wool", 1, 7, missing), null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 3, 7, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 7, missing),
                        getModItem("minecraft", "wool", 1, 7, missing), "craftingToolSaw", null, null, null, null, null,
                        null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 7, 8, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing), "dyeLightGray",
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "carpet", 1, 8, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing), "dyeLightGray" });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 1, 8, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 8, missing),
                        getModItem("minecraft", "wool", 1, 8, missing), null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 3, 8, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 8, missing),
                        getModItem("minecraft", "wool", 1, 8, missing), "craftingToolSaw", null, null, null, null, null,
                        null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 7, 9, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing), "dyeCyan",
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "carpet", 1, 9, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing), "dyeCyan" });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 1, 9, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 9, missing),
                        getModItem("minecraft", "wool", 1, 9, missing), null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 3, 9, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 9, missing),
                        getModItem("minecraft", "wool", 1, 9, missing), "craftingToolSaw", null, null, null, null, null,
                        null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 7, 10, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing), "dyePurple",
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "carpet", 1, 10, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing), "dyePurple" });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 1, 10, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 10, missing),
                        getModItem("minecraft", "wool", 1, 10, missing), null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 3, 10, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 10, missing),
                        getModItem("minecraft", "wool", 1, 10, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 7, 11, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing), "dyeBlue",
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "carpet", 1, 11, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing), "dyeBlue" });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 1, 11, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 11, missing),
                        getModItem("minecraft", "wool", 1, 11, missing), null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 3, 11, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 11, missing),
                        getModItem("minecraft", "wool", 1, 11, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 7, 12, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing), "dyeBrown",
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "carpet", 1, 12, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing), "dyeBrown" });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 1, 12, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 12, missing),
                        getModItem("minecraft", "wool", 1, 12, missing), null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 3, 12, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 12, missing),
                        getModItem("minecraft", "wool", 1, 12, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 7, 13, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing), "dyeGreen",
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "carpet", 1, 13, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing), "dyeGreen" });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 1, 13, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 13, missing),
                        getModItem("minecraft", "wool", 1, 13, missing), null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 3, 13, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 13, missing),
                        getModItem("minecraft", "wool", 1, 13, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 7, 14, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing), "dyeRed",
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "carpet", 1, 14, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing), "dyeRed" });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 1, 14, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 14, missing),
                        getModItem("minecraft", "wool", 1, 14, missing), null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 3, 14, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 14, missing),
                        getModItem("minecraft", "wool", 1, 14, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 7, 15, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing), "dyeBlack",
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "carpet", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "carpet", 1, 15, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 0, missing), "dyeBlack" });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 1, 15, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 15, missing),
                        getModItem("minecraft", "wool", 1, 15, missing), null, null });
        addShapedRecipe(
                getModItem("minecraft", "carpet", 3, 15, missing),
                new Object[] { getModItem("minecraft", "wool", 1, 15, missing),
                        getModItem("minecraft", "wool", 1, 15, missing), "craftingToolSaw", null, null, null, null,
                        null, null });
        addShapedRecipe(
                getModItem("minecraft", "stained_hardened_clay", 7, 0, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeWhite",
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_hardened_clay", 1, 0, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeWhite" });
        addShapedRecipe(
                getModItem("minecraft", "stained_hardened_clay", 7, 1, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeOrange",
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_hardened_clay", 1, 1, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeOrange" });
        addShapedRecipe(
                getModItem("minecraft", "stained_hardened_clay", 7, 2, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeMagenta",
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_hardened_clay", 1, 2, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeMagenta" });
        addShapedRecipe(
                getModItem("minecraft", "stained_hardened_clay", 7, 3, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeLightBlue",
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_hardened_clay", 1, 3, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeLightBlue" });
        addShapedRecipe(
                getModItem("minecraft", "stained_hardened_clay", 7, 4, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeYellow",
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_hardened_clay", 1, 4, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeYellow" });
        addShapedRecipe(
                getModItem("minecraft", "stained_hardened_clay", 7, 5, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeLime",
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_hardened_clay", 1, 5, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeLime" });
        addShapedRecipe(
                getModItem("minecraft", "stained_hardened_clay", 7, 6, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyePink",
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_hardened_clay", 1, 6, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyePink" });
        addShapedRecipe(
                getModItem("minecraft", "stained_hardened_clay", 7, 7, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeGray",
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_hardened_clay", 1, 7, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeGray" });
        addShapedRecipe(
                getModItem("minecraft", "stained_hardened_clay", 7, 8, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeLightGray",
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_hardened_clay", 1, 8, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeLightGray" });
        addShapedRecipe(
                getModItem("minecraft", "stained_hardened_clay", 7, 9, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeCyan",
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_hardened_clay", 1, 9, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeCyan" });
        addShapedRecipe(
                getModItem("minecraft", "stained_hardened_clay", 7, 10, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyePurple",
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_hardened_clay", 1, 10, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyePurple" });
        addShapedRecipe(
                getModItem("minecraft", "stained_hardened_clay", 7, 11, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeBlue",
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_hardened_clay", 1, 11, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeBlue" });
        addShapedRecipe(
                getModItem("minecraft", "stained_hardened_clay", 7, 12, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeBrown",
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_hardened_clay", 1, 12, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeBrown" });
        addShapedRecipe(
                getModItem("minecraft", "stained_hardened_clay", 7, 13, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeGreen",
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_hardened_clay", 1, 13, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeGreen" });
        addShapedRecipe(
                getModItem("minecraft", "stained_hardened_clay", 7, 14, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeRed",
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_hardened_clay", 1, 14, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeRed" });
        addShapedRecipe(
                getModItem("minecraft", "stained_hardened_clay", 7, 15, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeBlack",
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing),
                        getModItem("ExtraUtilities", "paintbrush", 1, 0, missing),
                        getModItem("minecraft", "hardened_clay", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stained_hardened_clay", 1, 15, missing),
                new Object[] { getModItem("minecraft", "hardened_clay", 1, 0, missing), "dyeBlack" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "sugar", 1, 0, missing),
                new Object[] { "craftingToolMortar", getModItem("minecraft", "reeds", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "diamond_sword", 1, 0, missing),
                new Object[] { null, getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), null,
                        "craftingToolFile", getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        "craftingToolHardHammer", null, getModItem("minecraft", "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("minecraft", "diamond_shovel", 1, 0, missing),
                new Object[] { "craftingToolFile", getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        "craftingToolHardHammer", null, getModItem("minecraft", "stick", 1, 0, missing), null, null,
                        getModItem("minecraft", "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("minecraft", "diamond_pickaxe", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("minecraft", "diamond", 1, 0, missing),
                        getModItem("minecraft", "diamond", 1, 0, missing), "craftingToolFile",
                        getModItem("minecraft", "stick", 1, 0, missing), "craftingToolHardHammer", null,
                        getModItem("minecraft", "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("minecraft", "diamond_axe", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("minecraft", "diamond", 1, 0, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("minecraft", "stick", 1, 0, missing), null, "craftingToolFile",
                        getModItem("minecraft", "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("minecraft", "diamond_hoe", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("minecraft", "diamond", 1, 0, missing), "craftingToolHardHammer", "craftingToolFile",
                        getModItem("minecraft", "stick", 1, 0, missing), null, null,
                        getModItem("minecraft", "stick", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("minecraft", "diamond_helmet", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), null, null, null });
        addShapedRecipe(
                getModItem("minecraft", "diamond_chestplate", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing) });
        addShapedRecipe(
                getModItem("minecraft", "diamond_leggings", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing) });
        addShapedRecipe(
                getModItem("minecraft", "diamond_boots", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), null,
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), "craftingToolHardHammer",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), null, null, null });
        addShapedRecipe(
                getModItem("minecraft", "iron_horse_armor", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "craftingToolScrewdriver",
                        getModItem("minecraft", "iron_helmet", 1, 0, missing), "plateIron",
                        getModItem("minecraft", "iron_chestplate", 1, 0, missing), "plateIron",
                        getModItem("minecraft", "iron_leggings", 1, 0, missing), "screwIron",
                        getModItem("minecraft", "iron_leggings", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "golden_horse_armor", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "craftingToolScrewdriver",
                        getModItem("minecraft", "golden_helmet", 1, 0, missing), "plateGold",
                        getModItem("minecraft", "golden_chestplate", 1, 0, missing), "plateGold",
                        getModItem("minecraft", "golden_leggings", 1, 0, missing), "screwGold",
                        getModItem("minecraft", "golden_leggings", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "diamond_horse_armor", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "craftingToolScrewdriver",
                        getModItem("minecraft", "diamond_helmet", 1, 0, missing), "plateDiamond",
                        getModItem("minecraft", "diamond_chestplate", 1, 0, missing), "plateDiamond",
                        getModItem("minecraft", "diamond_leggings", 1, 0, missing), "screwDiamond",
                        getModItem("minecraft", "diamond_leggings", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "saddle", 1, 0, missing),
                new Object[] { "itemLeather", getModItem("Backpack", "tannedLeather", 1, 0, missing), "itemLeather",
                        "itemLeather", getModItem("minecraft", "carpet", 1, 32767, missing), "itemLeather",
                        "ringAnyIron", getModItem("minecraft", "string", 1, 0, missing), "ringAnyIron" });
        addShapedRecipe(
                getModItem("minecraft", "clock", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 28086, missing), "plateGold",
                        getModItem("gregtech", "gt.metaitem.01", 1, 28086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing),
                        getModItem("minecraft", "comparator", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 26086, missing), "craftingToolScrewdriver",
                        getModItem("gregtech", "gt.metaitem.01", 1, 27086, missing), "craftingToolWrench" });
        addShapedRecipe(
                getModItem("minecraft", "compass", 1, 0, missing),
                new Object[] { "screwIron", "paneGlass", "boltIron", "ringZinc", "plateIron", "ringZinc",
                        "boltRedAlloy", "craftingToolScrewdriver", "screwIron" });
        addShapedRecipe(
                getModItem("minecraft", "clay", 2, 0, missing),
                new Object[] { "itemClay", "itemClay", "itemClay", "itemClay",
                        getModItem("minecraft", "water_bucket", 1, 0, missing), "itemClay", "itemClay", "itemClay",
                        "itemClay" });
        addShapedRecipe(
                getModItem("minecraft", "clay", 2, 0, missing),
                new Object[] { "itemClay", "itemClay", "itemClay", "itemClay",
                        getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1, 0, missing), "itemClay", "itemClay",
                        "itemClay", "itemClay" });
        addShapedRecipe(
                getModItem("minecraft", "pumpkin_seeds", 2, 0, missing),
                new Object[] { getModItem("minecraft", "pumpkin", 1, 0, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("minecraft", "pumpkin_seeds", 2, 0, missing),
                new Object[] { getModItem("minecraft", "pumpkin", 1, 0, missing), "craftingToolSoftHammer",
                        getModItem("minecraft", "pumpkin", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "melon_seeds", 1, 0, missing),
                new Object[] { getModItem("minecraft", "melon", 1, 0, missing), "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("minecraft", "melon_seeds", 1, 0, missing),
                new Object[] { getModItem("minecraft", "melon", 1, 0, missing), "craftingToolSoftHammer",
                        getModItem("minecraft", "melon", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "melon", 6, 0, missing),
                new Object[] { "craftingToolKnife", getModItem("minecraft", "melon_block", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "gunpowder", 1, 0, missing),
                new Object[] { "dustSmallGunpowder", "dustSmallGunpowder", "dustSmallGunpowder",
                        "dustSmallGunpowder" });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32559, missing),
                new Object[] { getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2881, missing) });
        addShapelessCraftingRecipe(
                getModItem("gregtech", "gt.metaitem.02", 1, 32559, missing),
                new Object[] { getModItem("harvestcraft", "freshwaterItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2881, missing),
                        getModItem("harvestcraft", "freshwaterItem", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "chest_minecart", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem("minecraft", "chest", 1, 0, missing),
                        "craftingToolWrench", null, getModItem("minecraft", "minecart", 1, 0, missing), null, null,
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("minecraft", "furnace_minecart", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem("minecraft", "furnace", 1, 0, missing),
                        "craftingToolWrench", null, getModItem("minecraft", "minecart", 1, 0, missing), null, null,
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("minecraft", "hopper_minecart", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", getModItem("minecraft", "hopper", 1, 0, missing),
                        "craftingToolWrench", null, getModItem("minecraft", "minecart", 1, 0, missing), null, null,
                        "craftingToolScrewdriver", null });
        addShapedRecipe(
                getModItem("minecraft", "map", 1, 0, missing),
                new Object[] { "paperEmpty", "paperEmpty", "paperEmpty", "paperEmpty",
                        getModItem("minecraft", "compass", 1, 0, missing), "paperEmpty", "paperEmpty", "paperEmpty",
                        "paperEmpty" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "dye", 3, 15, missing),
                new Object[] { getModItem("minecraft", "bone", 1, 0, missing), "craftingToolMortar" });
        addShapedRecipe(
                getModItem("minecraft", "lead", 1, 0, missing),
                new Object[] { getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing), "slimeball",
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "pumpkin_pie", 1, 0, missing),
                new Object[] { "craftingToolRollingPin", getModItem("minecraft", "pumpkin", 1, 0, missing), "dustSugar",
                        getModItem("minecraft", "pumpkin", 1, 0, missing), "dustSugar", null, "dustSugar", null,
                        null });
        addShapedRecipe(
                getModItem("minecraft", "comparator", 1, 0, missing),
                new Object[] { "screwIron", "craftingRedstoneTorch", "screwIron", "craftingRedstoneTorch",
                        "plateNetherQuartz", "craftingRedstoneTorch",
                        getModItem("minecraft", "stone_pressure_plate", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem("minecraft", "stone_pressure_plate", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "comparator", 1, 0, missing),
                new Object[] { "screwIron", "craftingRedstoneTorch", "screwIron", "craftingRedstoneTorch",
                        "plateCertusQuartz", "craftingRedstoneTorch",
                        getModItem("minecraft", "stone_pressure_plate", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem("minecraft", "stone_pressure_plate", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "comparator", 1, 0, missing),
                new Object[] { "screwIron", "craftingRedstoneTorch", "screwIron", "craftingRedstoneTorch",
                        "plateChargedCertusQuartz", "craftingRedstoneTorch",
                        getModItem("minecraft", "stone_pressure_plate", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem("minecraft", "stone_pressure_plate", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "comparator", 1, 0, missing),
                new Object[] { "screwIron", "craftingRedstoneTorch", "screwIron", "craftingRedstoneTorch",
                        "plateQuartzite", "craftingRedstoneTorch",
                        getModItem("minecraft", "stone_pressure_plate", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem("minecraft", "stone_pressure_plate", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "repeater", 1, 0, missing),
                new Object[] { "screwIron", null, "screwIron", "craftingRedstoneTorch", "craftingToolScrewdriver",
                        "craftingRedstoneTorch", getModItem("minecraft", "stone_pressure_plate", 1, 0, missing),
                        "stickRedAlloy", getModItem("minecraft", "stone_pressure_plate", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "item_frame", 1, 0, missing),
                new Object[] { getModItem("minecraft", "string", 1, 0, missing), "ringAnyIron",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood", "itemLeather", "stickWood",
                        "stickWood", "stickWood", "stickWood" });
        addShapedRecipe(
                getModItem("minecraft", "bed", 1, 0, missing),
                new Object[] { getModItem("minecraft", "carpet", 1, 32767, missing),
                        getModItem("minecraft", "carpet", 1, 32767, missing),
                        getModItem("minecraft", "carpet", 1, 32767, missing), "plankWood", "plankWood", "plankWood",
                        "fenceWood", "craftingToolSoftHammer", "fenceWood" });
        addShapedRecipe(
                getModItem("minecraft", "fishing_rod", 1, 0, missing),
                new Object[] { null, null, "stickLongWood", null, "stickLongWood",
                        getModItem("minecraft", "string", 1, 0, missing), "stickLongWood", "craftingToolWireCutter",
                        "ringAnyIron" });
        addShapedRecipe(
                getModItem("minecraft", "paper", 2, 0, missing),
                new Object[] { "dustWood", "dustWood", "dustWood", "dustWood",
                        getModItem("minecraft", "water_bucket", 1, 0, missing), "dustWood", "dustWood", "dustWood",
                        "dustWood" });
        addShapedRecipe(
                getModItem("minecraft", "paper", 2, 0, missing),
                new Object[] { "dustWood", "dustWood", "dustWood", "dustWood",
                        getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1, 0, missing), "dustWood", "dustWood",
                        "dustWood", "dustWood" });
        addShapedRecipe(
                getModItem("minecraft", "string", 1, 0, missing),
                new Object[] { getModItem("Natura", "barleyFood", 1, 3, missing),
                        getModItem("Natura", "barleyFood", 1, 3, missing),
                        getModItem("Natura", "barleyFood", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "flower_pot", 1, 0, missing),
                new Object[] { "craftingToolFile",
                        getModItem("IguanaTweaksTConstruct", "clayBucketFired", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stone_slab", 1, 0, missing),
                new Object[] { "craftingToolSaw", "stone" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stone_slab", 1, 1, missing),
                new Object[] { "craftingToolSaw", "sandstone" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stone_slab", 1, 3, missing),
                new Object[] { "craftingToolSaw", "cobblestone" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stone_slab", 1, 4, missing),
                new Object[] { "craftingToolSaw", getModItem("minecraft", "brick_block", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stone_slab", 1, 5, missing),
                new Object[] { "craftingToolSaw", "stoneBricks" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stone_slab", 1, 6, missing),
                new Object[] { "craftingToolSaw", "stoneNetherBrick" });
        addShapelessCraftingRecipe(
                getModItem("minecraft", "stone_slab", 1, 7, missing),
                new Object[] { "craftingToolSaw", "blockQuartz" });
        addShapedRecipe(
                getModItem("minecraft", "brick_block", 2, 0, missing),
                new Object[] { "ingotBrick", "ingotBrick", "ingotBrick", "ingotBrick",
                        getModItem("minecraft", "water_bucket", 1, 0, missing), "ingotBrick", "ingotBrick",
                        "ingotBrick", "ingotBrick" });
        addShapedRecipe(
                getModItem("minecraft", "brick_block", 2, 0, missing),
                new Object[] { "ingotBrick", "ingotBrick", "ingotBrick", "ingotBrick",
                        getModItem("IguanaTweaksTConstruct", "clayBucketWater", 1, 0, missing), "ingotBrick",
                        "ingotBrick", "ingotBrick", "ingotBrick" });
        addShapedRecipe(
                getModItem("minecraft", "nether_brick", 2, 0, missing),
                new Object[] { "ingotBrickNether", "ingotBrickNether", "ingotBrickNether", "ingotBrickNether",
                        getModItem("minecraft", "lava_bucket", 1, 0, missing), "ingotBrickNether", "ingotBrickNether",
                        "ingotBrickNether", "ingotBrickNether" });
        addShapedRecipe(
                getModItem("minecraft", "nether_brick", 2, 0, missing),
                new Object[] { "ingotBrickNether", "ingotBrickNether", "ingotBrickNether", "ingotBrickNether",
                        getModItem("IguanaTweaksTConstruct", "clayBucketLava", 1, 0, missing), "ingotBrickNether",
                        "ingotBrickNether", "ingotBrickNether", "ingotBrickNether" });
        addShapedRecipe(
                getModItem("minecraft", "wooden_door", 1, 0, missing),
                new Object[] { getModItem("minecraft", "planks", 1, 0, missing),
                        getModItem("minecraft", "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem("minecraft", "planks", 1, 0, missing), "ringAnyIron", "screwAnyIron",
                        getModItem("minecraft", "planks", 1, 0, missing),
                        getModItem("minecraft", "planks", 1, 0, missing), "craftingToolSaw" });
        addShapedRecipe(
                getModItem("minecraft", "wooden_door", 1, 0, missing),
                new Object[] { getModItem("minecraft", "planks", 1, 0, missing),
                        getModItem("minecraft", "trapdoor", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem("minecraft", "planks", 1, 0, missing), "ringCopper", "screwCopper",
                        getModItem("minecraft", "planks", 1, 0, missing),
                        getModItem("minecraft", "planks", 1, 0, missing), "craftingToolSaw" });
        addShapedRecipe(
                getModItem("minecraft", "wooden_door", 1, 0, missing),
                new Object[] { getModItem("minecraft", "planks", 1, 0, missing),
                        getModItem("minecraft", "trapdoor", 1, 0, missing), "craftingToolSaw",
                        getModItem("minecraft", "planks", 1, 0, missing), "ringAnyIron", "screwAnyIron",
                        getModItem("minecraft", "planks", 1, 0, missing),
                        getModItem("minecraft", "planks", 1, 0, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("minecraft", "wooden_door", 1, 0, missing),
                new Object[] { getModItem("minecraft", "planks", 1, 0, missing),
                        getModItem("minecraft", "trapdoor", 1, 0, missing), "craftingToolSaw",
                        getModItem("minecraft", "planks", 1, 0, missing), "ringCopper", "screwCopper",
                        getModItem("minecraft", "planks", 1, 0, missing),
                        getModItem("minecraft", "planks", 1, 0, missing), "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("minecraft", "iron_door", 1, 0, missing),
                new Object[] { "plateAnyIron", getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                        "craftingToolHardHammer", "plateAnyIron", "ringSteel", "screwSteel", "plateAnyIron",
                        "plateAnyIron", "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("minecraft", "iron_door", 1, 0, missing),
                new Object[] { "plateAnyIron", getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                        "craftingToolScrewdriver", "plateAnyIron", "ringSteel", "screwSteel", "plateAnyIron",
                        "plateAnyIron", "craftingToolHardHammer" });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32471, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32471, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32471, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32471, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32471, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32471, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32472, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32472, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32472, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32472, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32472, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32472, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32473, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32473, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32473, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32473, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32473, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32473, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32474, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32474, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32474, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32474, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32474, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32474, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32475, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32475, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32475, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32475, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32475, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32475, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32476, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32476, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32476, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32476, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32476, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32476, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32477, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32477, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32477, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32477, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32477, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32477, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32478, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32478, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32478, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32478, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32478, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32478, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32479, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32479, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32479, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32479, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32479, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32479, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32480, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32480, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32480, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32480, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32480, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32480, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32481, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32481, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32481, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32481, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32481, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32481, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32482, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32482, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32482, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32482, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32482, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32482, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32483, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32483, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32483, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32483, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32483, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32483, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32484, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32484, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32484, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32484, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32484, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32484, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32485, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32485, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32485, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32485, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32485, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32485, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32486, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32486, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32486, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32486, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32486, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32486, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32487, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32487, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32487, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32487, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32487, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32487, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32488, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32488, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32488, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32488, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32488, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32488, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32489, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32489, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32489, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32489, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32489, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32489, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32490, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32490, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32490, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32490, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32490, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32490, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32491, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32491, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32491, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32491, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32491, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32491, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32492, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32492, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32492, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32492, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32492, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32492, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32493, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32493, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32493, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32493, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32493, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32493, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32494, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32494, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32494, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32494, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32494, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32494, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32495, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32495, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32495, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32495, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32495, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32495, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32496, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32496, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32496, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32496, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32496, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32496, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32497, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32497, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32497, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32497, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32497, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32497, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32498, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32498, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32498, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32498, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32498, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32498, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "sign", 3, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.02", 1, 32499, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32499, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32499, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32499, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32499, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32499, missing), null, "stickWood", null });
        addShapedRecipe(
                getModItem("minecraft", "boat", 1, 0, missing),
                new Object[] { "plankWood", null, "plankWood", "plankWood", "craftingToolKnife", "plankWood",
                        "slabWood", "slabWood", "slabWood" });
        addShapedRecipe(
                getModItem("minecraft", "painting", 1, 0, missing),
                new Object[] { getModItem("minecraft", "string", 1, 0, missing), "ringAnyIron",
                        getModItem("minecraft", "string", 1, 0, missing), "stickWood",
                        getModItem("minecraft", "carpet", 1, 32767, missing), "stickWood", "stickWood", "stickWood",
                        "stickWood" });
        addShapedRecipe(
                getModItem("minecraft", "flint_and_steel", 1, 0, missing),
                new Object[] { null, "gearGtSmallSteel", null, null, getModItem("minecraft", "flint", 1, 0, missing),
                        null, null, "springSmallSteel", null });
        addShapedRecipe(
                getModItem("minecraft", "shears", 1, 0, missing),
                new Object[] { "plateIron", "screwIron", "plateIron", "craftingToolHardHammer", "ringIron",
                        "craftingToolFile", "stickWood", "craftingToolScrewdriver", "stickWood" });
        addShapedRecipe(
                getModItem("minecraft", "nether_star", 16, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.03", 1, 2506, missing), "craftingToolCrowbar" });
        addShapedRecipe(
                getModItem("minecraft", "mossy_cobblestone", 1, 0, missing),
                new Object[] { getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("minecraft", "cobblestone", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing) });
        addShapedRecipe(
                getModItem("minecraft", "book", 1, 0, missing),
                new Object[] { getModItem("minecraft", "string", 1, 0, missing), "paperEmpty", "itemLeather",
                        getModItem("minecraft", "string", 1, 0, missing), "paperEmpty",
                        getModItem("TConstruct", "buckets", 1, 25, missing),
                        getModItem("minecraft", "string", 1, 0, missing), "paperEmpty", "itemLeather" });
        addShapedRecipe(
                getModItem("minecraft", "bookshelf", 1, 0, missing),
                new Object[] { "plateWood", "plateWood", "plateWood", getModItem("minecraft", "book", 1, 0, missing),
                        getModItem("minecraft", "book", 1, 0, missing), getModItem("minecraft", "book", 1, 0, missing),
                        "plateWood", "plateWood", "plateWood" });
        addShapedRecipe(
                getModItem("gregtech", "gt.metaitem.01", 9, 9032, missing),
                new Object[] { "craftingToolSaw", "ingotIron", null, null, null, null, null, null, null });
        addShapedRecipe(
                getModItem("minecraft", "gold_nugget", 9, 0, missing),
                new Object[] { "craftingToolSaw", "ingotGold", null, null, null, null, null, null, null });
    }
}
