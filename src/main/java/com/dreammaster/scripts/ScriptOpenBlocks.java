package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.*;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_Utility;

public class ScriptOpenBlocks implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "OpenBlocks";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(OpenBlocks.ID, RandomThings.ID, ExtraUtilities.ID, Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack devNull = getModItem(OpenBlocks.ID, "devnull", 1);
        ItemStack voidDropFilter = getModItem(RandomThings.ID, "dropFilter", 1, 1);
        ItemStack trashCan = getModItem(ExtraUtilities.ID, "trashcan", 1);
        ItemStack circuit2 = GT_Utility.getIntegratedCircuit(2);

        FluidStack ender250 = FluidRegistry.getFluidStack("ender", 250);

        addShapelessCraftingRecipe(devNull, new Object[] { voidDropFilter });

        GT_Values.RA.addAssemblerRecipe(new ItemStack[] { trashCan, circuit2 }, ender250, devNull, 300, 30);

        addShapedRecipe(
                getModItem("OpenBlocks", "hangglider", 1, 0, missing),
                new Object[] { "screwSteel", "screwSteel", "screwSteel",
                        getModItem("OpenBlocks", "generic", 1, 0, missing), "plateSteel",
                        getModItem("OpenBlocks", "generic", 1, 0, missing), "craftingToolWrench", "screwSteel",
                        "craftingToolScrewdriver" });
        addShapedRecipe(
                getModItem("OpenBlocks", "generic", 1, 0, missing),
                new Object[] { "craftingToolHardHammer", "stickSteel", "itemLeather", "stickSteel",
                        getModItem("Backpack", "tannedLeather", 1, 0, missing), "itemLeather", "itemLeather",
                        "itemLeather", "itemLeather" });
        addShapedRecipe(
                getModItem("OpenBlocks", "autoanvil", 1, 0, missing),
                new Object[] { "blockStainlessSteel", "blockStainlessSteel", "blockStainlessSteel",
                        "screwStainlessSteel", getModItem("Railcraft", "anvil", 1, 0, missing), "screwStainlessSteel",
                        "plateRedAlloy", "blockRedstone", "plateRedAlloy" });
        addShapedRecipe(
                getModItem("OpenBlocks", "xpdrain", 1, 0, missing),
                new Object[] { "screwAnyIron", "stickAnyIron", "screwAnyIron", "stickAnyIron",
                        getModItem("minecraft", "iron_bars", 1, 0, missing), "stickAnyIron", "screwAnyIron",
                        "stickAnyIron", "screwAnyIron" });
        addShapedRecipe(
                getModItem("OpenBlocks", "path", 4, 0, missing),
                new Object[] { getModItem("minecraft", "stone_slab", 1, 3, missing), null,
                        getModItem("minecraft", "stone_slab", 1, 3, missing), null,
                        getModItem("minecraft", "stone_slab", 1, 3, missing), null,
                        getModItem("minecraft", "stone_slab", 1, 3, missing), null,
                        getModItem("minecraft", "stone_slab", 1, 3, missing) });
        addShapedRecipe(
                getModItem("OpenBlocks", "fan", 1, 0, missing),
                new Object[] { getModItem("minecraft", "iron_bars", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 21057, missing),
                        getModItem("minecraft", "iron_bars", 1, 0, missing), "screwSteel", "plateAnyIron", "screwSteel",
                        "plateAnyIron", getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing), "plateAnyIron" });
        addShapedRecipe(
                getModItem("OpenBlocks", "elevator", 1, 0, missing),
                new Object[] { "plateSteel", "plateEnderPearl", "plateSteel", "gearGtSmallSteel",
                        getModItem("gregtech", "gt.blockmachines", 1, 4115, missing), "gearGtSmallSteel", "plateSteel",
                        "plateSteel", "plateSteel" });
        addShapedRecipe(
                getModItem("OpenBlocks", "elevator_rotating", 1, 0, missing),
                new Object[] { null, "stickSteel", null, "gearGtSmallSteel",
                        getModItem("OpenBlocks", "elevator", 1, 0, missing), "gearGtSmallSteel",
                        "craftingToolScrewdriver", "stickSteel", "craftingToolFile" });
        addShapedRecipe(
                getModItem("OpenBlocks", "elevator_rotating", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", "stickSteel", "craftingToolFile", "gearGtSmallSteel",
                        getModItem("OpenBlocks", "elevator", 1, 0, missing), "gearGtSmallSteel", null, "stickSteel",
                        null });
        addShapedRecipe(
                getModItem("OpenBlocks", "vacuumhopper", 1, 0, missing),
                new Object[] { "plateObsidian", getModItem("minecraft", "hopper", 1, 0, missing), "plateObsidian",
                        getModItem("minecraft", "hopper", 1, 0, missing), "plateEnderPearl",
                        getModItem("minecraft", "hopper", 1, 0, missing), "plateObsidian",
                        getModItem("minecraft", "hopper", 1, 0, missing), "plateObsidian" });
        addShapedRecipe(
                getModItem("OpenBlocks", "sprinkler", 1, 0, missing),
                new Object[] { getModItem("dreamcraft", "item.AluminiumBars", 1, 0, missing), "stickGold",
                        getModItem("dreamcraft", "item.AluminiumBars", 1, 0, missing), "pipeSmallDarkSteel",
                        "rotorDarkSteel", "pipeSmallDarkSteel",
                        getModItem("dreamcraft", "item.AluminiumBars", 1, 0, missing), "stickGold",
                        getModItem("dreamcraft", "item.AluminiumBars", 1, 0, missing) });
        addShapedRecipe(
                getModItem("OpenBlocks", "guide", 1, 0, missing),
                new Object[] { "stoneObsidian", getModItem("IC2", "blockLuminatorDark", 1, 0, missing), "stoneObsidian",
                        getModItem("IC2", "blockLuminatorDark", 1, 0, missing), "lensDiamond",
                        getModItem("IC2", "blockLuminatorDark", 1, 0, missing), "stoneObsidian",
                        getModItem("IC2", "blockLuminatorDark", 1, 0, missing), "stoneObsidian" });
        addShapelessCraftingRecipe(
                getModItem("OpenBlocks", "blockPlacer", 1, 0, missing),
                new Object[] { getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem("OpenBlocks", "blockbreaker", 1, 0, missing),
                new Object[] { getModItem("ProjRed|Expansion", "projectred.expansion.machine2", 1, 0, missing) });
        addShapedRecipe(
                getModItem("OpenBlocks", "itemDropper", 1, 0, missing),
                new Object[] { "plateStone", "wireGt01RedAlloy", "plateStone", "gearGtSmallSteel",
                        getModItem("minecraft", "dropper", 1, 0, missing), "gearGtSmallSteel", "plateStone",
                        getModItem("minecraft", "hopper", 1, 0, missing), "plateStone" });
        addShapedRecipe(
                getModItem("OpenBlocks", "beartrap", 1, 0, missing),
                new Object[] { getModItem("dreamcraft", "item.SteelBars", 1, 0, missing), "craftingToolHardHammer",
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing), "screwSteel", "plateSteel",
                        "screwSteel", getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                        "craftingToolScrewdriver", getModItem("dreamcraft", "item.SteelBars", 1, 0, missing) });
        addShapedRecipe(
                getModItem("OpenBlocks", "cannon", 1, 0, missing),
                new Object[] { "craftingToolSaw", "pipeLargeSteel", "craftingToolHardHammer", "gearGtSmallWood",
                        "plateSteel", "gearGtSmallWood", getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        "wireGt01RedAlloy", getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing) });
        addShapedRecipe(
                getModItem("OpenBlocks", "village_highlighter", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "plateEmerald",
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "plateStone", "plateStone",
                        "plateStone" });
        addShapedRecipe(
                getModItem("OpenBlocks", "sky", 6, 0, missing),
                new Object[] { getModItem("TConstruct", "GlassPane", 1, 0, missing), "plateEnderEye",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "stoneEndstone",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), "plateEnderEye",
                        getModItem("TConstruct", "GlassPane", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("OpenBlocks", "sky", 1, 0, missing),
                new Object[] { getModItem("OpenBlocks", "sky", 1, 1, missing) });
        addShapedRecipe(
                getModItem("OpenBlocks", "projector", 1, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel", "craftingRedstoneTorch",
                        getModItem("OpenComputers", "hologram1", 1, 0, missing), "craftingRedstoneTorch",
                        "craftingRedstoneTorch", getModItem("minecraft", "stone_slab", 1, 0, missing),
                        "craftingRedstoneTorch" });
        addShapelessCraftingRecipe(
                getModItem("OpenBlocks", "canvas", 1, 0, missing),
                new Object[] { getModItem("BiblioCraft", "item.PaintingCanvas", 1, 0, missing) });
        addShapedRecipe(
                getModItem("OpenBlocks", "drawingtable", 1, 0, missing),
                new Object[] { getModItem("OpenBlocks", "generic", 1, 10, missing),
                        getModItem("OpenBlocks", "generic", 1, 11, missing),
                        getModItem("OpenBlocks", "generic", 1, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing),
                        getModItem("minecraft", "crafting_table", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17809, missing), "screwSteel",
                        "craftingToolScrewdriver", "screwSteel" });
        addShapedRecipe(
                getModItem("OpenBlocks", "xpshower", 1, 0, missing),
                new Object[] { "itemCasingAnyIron", "pipeSmallSteel", "itemCasingAnyIron", "itemCasingAnyIron",
                        "pipeSmallSteel", "itemCasingAnyIron", "pipeSmallSteel", "pipeSmallSteel", "pipeSmallSteel" });
        addShapelessCraftingRecipe(
                getModItem("OpenBlocks", "scaffolding", 1, 0, missing),
                new Object[] { getModItem("gregtech", "gt.blockmachines", 1, 4905, missing) });
        addShapedRecipe(
                getModItem("OpenBlocks", "generic", 1, 9, missing),
                new Object[] { getModItem("ProjectBlue", "miniatureLamp", 1, 14, missing), "plateEnderEye",
                        getModItem("ProjectBlue", "miniatureLamp", 1, 14, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "circuitBasic",
                        getModItem("gregtech", "gt.metaitem.01", 1, 32600, missing), "rotorAluminium", "plateEnderEye",
                        "rotorAluminium" });
        addShapedRecipe(
                getModItem("OpenBlocks", "slimalyzer", 1, 0, missing),
                new Object[] { "screwIron", "circuitBasic", "screwIron", "itemCasingAnyIron",
                        getModItem("TConstruct", "materials", 1, 1, missing), "itemCasingAnyIron",
                        "craftingToolScrewdriver", "circuitBasic", "craftingToolFile" });
        addShapelessCraftingRecipe(
                getModItem("OpenBlocks", "paintBrush", 1, 0, missing),
                new Object[] { getModItem("BuildCraft|Core", "paintbrush", 1, 0, missing) });
        addShapedRecipe(
                getModItem("OpenBlocks", "sonicglasses", 1, 0, missing),
                new Object[] { "wireGt01RedAlloy", getModItem("GalacticraftCore", "item.basicItem", 1, 19, missing),
                        "wireGt01RedAlloy", "circuitBasic", getModItem("minecraft", "iron_helmet", 1, 0, missing),
                        "circuitBasic", "screwAluminium", "craftingToolScrewdriver", "screwAluminium" });

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "string", 64, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 64, 22809, missing))
                .itemOutputs(getModItem("OpenBlocks", "ropeladder", 64, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "trapdoor", 1, 0, missing),
                        getModItem("minecraft", "ladder", 1, 0, missing))
                .itemOutputs(getModItem("OpenBlocks", "ladder", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("OpenBlocks", "sky", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("OpenBlocks", "sky", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(200).eut(16)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 581, missing),
                        getModItem("IC2", "itemCasing", 4, 4, missing))
                .itemOutputs(getModItem("OpenBlocks", "paintmixer", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 581, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 18032, missing))
                .itemOutputs(getModItem("OpenBlocks", "paintmixer", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 581, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 18304, missing))
                .itemOutputs(getModItem("OpenBlocks", "paintmixer", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.blockmachines", 1, 581, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 18307, missing))
                .itemOutputs(getModItem("OpenBlocks", "paintmixer", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "factory", 1, 0, missing),
                        getModItem("IC2", "itemCasing", 4, 4, missing))
                .itemOutputs(getModItem("OpenBlocks", "xpbottler", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "factory", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 18032, missing))
                .itemOutputs(getModItem("OpenBlocks", "xpbottler", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "factory", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 18304, missing))
                .itemOutputs(getModItem("OpenBlocks", "xpbottler", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Forestry", "factory", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 4, 18307, missing))
                .itemOutputs(getModItem("OpenBlocks", "xpbottler", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("TConstruct", "blankPattern", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17032, missing))
                .itemOutputs(getModItem("OpenBlocks", "generic", 1, 10, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "stick", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1865, missing))
                .itemOutputs(getModItem("OpenBlocks", "generic", 1, 11, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 144)).noFluidOutputs().duration(100).eut(8)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("OpenBlocks", "generic", 1, 11, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17533, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 0, "{Uses:10.0f}", missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("gregtech", "gt.metaitem.03", 1, 32106, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing))
                .itemOutputs(getModItem("OpenBlocks", "generic", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(300).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("OpenBlocks", "generic", 1, 6, missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing))
                .itemOutputs(getModItem("OpenBlocks", "generic", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(400).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("OpenBlocks", "generic", 1, 6, missing),
                        getModItem("OpenBlocks", "generic", 4, 7, missing))
                .itemOutputs(createItemStack("OpenBlocks", "emptyMap", 1, 0, "{Scale:0b}", missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("OpenBlocks", "emptyMap", 1, 0, "{Scale:0b}", missing),
                        getModItem("IC2", "itemPartCircuit", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "emptyMap", 1, 0, "{Scale:1b}", missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).noFluidOutputs().duration(600).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("OpenBlocks", "emptyMap", 1, 0, "{Scale:1b}", missing),
                        getModItem("IC2", "itemPartCircuit", 2, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "emptyMap", 1, 0, "{Scale:2b}", missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(800).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("OpenBlocks", "emptyMap", 1, 0, "{Scale:2b}", missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 32702, missing))
                .itemOutputs(createItemStack("OpenBlocks", "emptyMap", 1, 0, "{Scale:3b}", missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redalloy", 144)).noFluidOutputs().duration(1000)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        createItemStack("OpenBlocks", "emptyMap", 1, 0, "{Scale:3b}", missing),
                        getModItem("IC2", "itemPartCircuitAdv", 2, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "emptyMap", 1, 0, "{Scale:4b}", missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 144)).noFluidOutputs().duration(1200)
                .eut(30).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("OpenBlocks", "generic", 1, 9, missing),
                        getModItem("minecraft", "ender_eye", 1, 0, missing))
                .itemOutputs(getModItem("OpenBlocks", "cartographer", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).noFluidOutputs().duration(600).eut(120)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "clock", 1, 0, missing),
                        getModItem("IC2", "itemPartCircuit", 2, 0, missing))
                .itemOutputs(getModItem("OpenBlocks", "pedometer", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).noFluidOutputs().duration(200).eut(30)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("OpenBlocks", "guide", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 24533, missing))
                .itemOutputs(getModItem("OpenBlocks", "builder_guide", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).noFluidOutputs().duration(300).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator", 1, 15, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblack", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator", 1, 14, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator", 1, 13, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator", 1, 12, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator", 1, 11, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator", 1, 10, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 144)).noFluidOutputs()
                .duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator", 1, 9, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator", 1, 8, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 144)).noFluidOutputs()
                .duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator", 1, 7, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator", 1, 6, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator", 1, 5, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator", 1, 4, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 144)).noFluidOutputs()
                .duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator", 1, 3, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 144)).noFluidOutputs()
                .duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator", 1, 2, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 144)).noFluidOutputs()
                .duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator", 1, 1, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 144)).noFluidOutputs()
                .duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator_rotating", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator_rotating", 1, 15, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblack", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator_rotating", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator_rotating", 1, 14, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator_rotating", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator_rotating", 1, 13, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator_rotating", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator_rotating", 1, 12, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator_rotating", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator_rotating", 1, 11, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator_rotating", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator_rotating", 1, 10, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 144)).noFluidOutputs()
                .duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator_rotating", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator_rotating", 1, 9, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator_rotating", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator_rotating", 1, 8, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 144)).noFluidOutputs()
                .duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator_rotating", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator_rotating", 1, 7, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator_rotating", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator_rotating", 1, 6, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator_rotating", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator_rotating", 1, 5, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator_rotating", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator_rotating", 1, 4, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 144)).noFluidOutputs()
                .duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator_rotating", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator_rotating", 1, 3, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 144)).noFluidOutputs()
                .duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator_rotating", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator_rotating", 1, 2, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 144)).noFluidOutputs()
                .duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator_rotating", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator_rotating", 1, 1, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 144)).noFluidOutputs()
                .duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "elevator_rotating", 1, 32767, missing))
                .itemOutputs(getModItem("OpenBlocks", "elevator_rotating", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 144)).noFluidOutputs().duration(200)
                .eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 1, "{Uses:10.0f,Color:1973019}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblack", 144))
                .noFluidOutputs().duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 1, "{Uses:10.0f,Color:11743532}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 144))
                .noFluidOutputs().duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 1, "{Uses:10.0f,Color:3887386}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 144))
                .noFluidOutputs().duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 1, "{Uses:10.0f,Color:5320730}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 144))
                .noFluidOutputs().duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 1, "{Uses:10.0f,Color:2437522}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144))
                .noFluidOutputs().duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 1, "{Uses:10.0f,Color:8073150}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 144))
                .noFluidOutputs().duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 1, "{Uses:10.0f,Color:2651799}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 144))
                .noFluidOutputs().duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 1, "{Uses:10.0f,Color:11250603}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 144))
                .noFluidOutputs().duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 1, "{Uses:10.0f,Color:4408131}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 144))
                .noFluidOutputs().duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 1, "{Uses:10.0f,Color:14188952}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 144))
                .noFluidOutputs().duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 1, "{Uses:10.0f,Color:4312372}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 144))
                .noFluidOutputs().duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 1, "{Uses:10.0f,Color:14602026}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 144))
                .noFluidOutputs().duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 1, "{Uses:10.0f,Color:6719955}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 144))
                .noFluidOutputs().duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 1, "{Uses:10.0f,Color:12801229}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 144))
                .noFluidOutputs().duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 1, "{Uses:10.0f,Color:15435844}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 144))
                .noFluidOutputs().duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("OpenBlocks", "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack("OpenBlocks", "imaginary", 1, 1, "{Uses:10.0f,Color:15790320}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 144))
                .noFluidOutputs().duration(200).eut(20).addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("minecraft", "ender_eye", 1, 0, missing))
                .itemOutputs(getModItem("OpenBlocks", "goldenEye", 1, 100, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 144)).noFluidOutputs().duration(200).eut(20)
                .addTo(sChemicalBathRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "wool", 1, 0, missing),
                        getModItem("minecraft", "slime_ball", 1, 0, missing))
                .itemOutputs(getModItem("OpenBlocks", "sponge", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).noFluidOutputs().duration(200).eut(30)
                .addTo(sChemicalRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "clay_ball", 1, 0, missing),
                        getModItem("minecraft", "dye", 1, 3, missing))
                .itemOutputs(getModItem("OpenBlocks", "tastyClay", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("milk", 500)).noFluidOutputs().duration(100).eut(8)
                .addTo(sMixerRecipes);

        new ResearchItem(
                "GOLDENEGG",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("bestia"), 12)
                        .add(Aspect.getAspect("victus"), 9).add(Aspect.getAspect("humanus"), 6),
                -4,
                5,
                3,
                getModItem("OpenBlocks", "goldenegg", 1, 0, missing)).setParents("MB_DimensionalSingularity")
                        .setConcealed().setPages(new ResearchPage("OpenBlocks.research_page.GOLDENEGG"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "GOLDENEGG",
                getModItem("OpenBlocks", "goldenegg", 1, 0, missing),
                2,
                new AspectList().add(Aspect.getAspect("alienis"), 75).add(Aspect.getAspect("bestia"), 50)
                        .add(Aspect.getAspect("victus"), 50).add(Aspect.getAspect("humanus"), 25),
                getModItem("minecraft", "egg", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 22086, missing),
                        getModItem("minecraft", "skull", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 22086, missing),
                        getModItem("minecraft", "skull", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 22086, missing),
                        getModItem("minecraft", "skull", 1, 3, missing), });
        TCHelper.addResearchPage(
                "GOLDENEGG",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("OpenBlocks", "goldenegg", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("GOLDENEGG", 2);
    }
}
