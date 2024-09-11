package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiblioCraft;
import static gregtech.api.enums.Mods.BuildCraftCore;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.OpenComputers;
import static gregtech.api.enums.Mods.ProjectBlue;
import static gregtech.api.enums.Mods.ProjectRedExpansion;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.RandomThings;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.chemicalBathRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.UniversalChemical;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptOpenBlocks implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "OpenBlocks";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                OpenBlocks.ID,
                RandomThings.ID,
                ExtraUtilities.ID,
                Thaumcraft.ID,
                ProjectBlue.ID,
                ProjectRedExpansion.ID,
                Backpack.ID,
                BiblioCraft.ID,
                BuildCraftCore.ID,
                Forestry.ID,
                GalacticraftCore.ID,
                IndustrialCraft2.ID,
                OpenComputers.ID,
                Railcraft.ID,
                TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack devNull = getModItem(OpenBlocks.ID, "devnull", 1);
        ItemStack voidDropFilter = getModItem(RandomThings.ID, "dropFilter", 1, 1);
        ItemStack trashCan = getModItem(ExtraUtilities.ID, "trashcan", 1);
        ItemStack circuit2 = GTUtility.getIntegratedCircuit(2);

        FluidStack ender250 = FluidRegistry.getFluidStack("ender", 250);

        addShapelessRecipe(devNull, voidDropFilter);

        GTValues.RA.stdBuilder().itemInputs(trashCan, circuit2).itemOutputs(devNull).fluidInputs(ender250)
                .duration(15 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(OpenBlocks.ID, "hangglider", 1, 0, missing),
                "screwSteel",
                "screwSteel",
                "screwSteel",
                getModItem(OpenBlocks.ID, "generic", 1, 0, missing),
                "plateSteel",
                getModItem(OpenBlocks.ID, "generic", 1, 0, missing),
                "craftingToolWrench",
                "screwSteel",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "generic", 1, 0, missing),
                "craftingToolHardHammer",
                "stickSteel",
                "itemLeather",
                "stickSteel",
                getModItem(Backpack.ID, "tannedLeather", 1, 0, missing),
                "itemLeather",
                "itemLeather",
                "itemLeather",
                "itemLeather");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "autoanvil", 1, 0, missing),
                "blockStainlessSteel",
                "blockStainlessSteel",
                "blockStainlessSteel",
                "screwStainlessSteel",
                getModItem(Railcraft.ID, "anvil", 1, 0, missing),
                "screwStainlessSteel",
                "plateRedAlloy",
                "blockRedstone",
                "plateRedAlloy");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "xpdrain", 1, 0, missing),
                "screwAnyIron",
                "stickAnyIron",
                "screwAnyIron",
                "stickAnyIron",
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "stickAnyIron",
                "screwAnyIron",
                "stickAnyIron",
                "screwAnyIron");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "path", 4, 0, missing),
                getModItem(Minecraft.ID, "stone_slab", 1, 3, missing),
                null,
                getModItem(Minecraft.ID, "stone_slab", 1, 3, missing),
                null,
                getModItem(Minecraft.ID, "stone_slab", 1, 3, missing),
                null,
                getModItem(Minecraft.ID, "stone_slab", 1, 3, missing),
                null,
                getModItem(Minecraft.ID, "stone_slab", 1, 3, missing));
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "fan", 1, 0, missing),
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                ItemList.Rotor_LV.get(1L),
                getModItem(Minecraft.ID, "iron_bars", 1, 0, missing),
                "screwSteel",
                "plateAnyIron",
                "screwSteel",
                "plateAnyIron",
                ItemList.Electric_Motor_MV.get(1L),
                "plateAnyIron");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "elevator", 1, 0, missing),
                "plateSteel",
                "plateEnderPearl",
                "plateSteel",
                "gearGtSmallSteel",
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 1L),
                "gearGtSmallSteel",
                "plateSteel",
                "plateSteel",
                "plateSteel");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "elevator_rotating", 1, 0, missing),
                null,
                "stickSteel",
                null,
                "gearGtSmallSteel",
                getModItem(OpenBlocks.ID, "elevator", 1, 0, missing),
                "gearGtSmallSteel",
                "craftingToolScrewdriver",
                "stickSteel",
                "craftingToolFile");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "elevator_rotating", 1, 0, missing),
                "craftingToolScrewdriver",
                "stickSteel",
                "craftingToolFile",
                "gearGtSmallSteel",
                getModItem(OpenBlocks.ID, "elevator", 1, 0, missing),
                "gearGtSmallSteel",
                null,
                "stickSteel",
                null);
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "vacuumhopper", 1, 0, missing),
                "plateObsidian",
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                "plateObsidian",
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                "plateEnderPearl",
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                "plateObsidian",
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                "plateObsidian");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "sprinkler", 1, 0, missing),
                CustomItemList.AluminiumBars.get(1L),
                "stickGold",
                CustomItemList.AluminiumBars.get(1L),
                "pipeSmallDarkSteel",
                "rotorDarkSteel",
                "pipeSmallDarkSteel",
                CustomItemList.AluminiumBars.get(1L),
                "stickGold",
                CustomItemList.AluminiumBars.get(1L));
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "guide", 1, 0, missing),
                "stoneObsidian",
                getModItem(IndustrialCraft2.ID, "blockLuminatorDark", 1, 0, missing),
                "stoneObsidian",
                getModItem(IndustrialCraft2.ID, "blockLuminatorDark", 1, 0, missing),
                "lensDiamond",
                getModItem(IndustrialCraft2.ID, "blockLuminatorDark", 1, 0, missing),
                "stoneObsidian",
                getModItem(IndustrialCraft2.ID, "blockLuminatorDark", 1, 0, missing),
                "stoneObsidian");
        addShapelessRecipe(
                getModItem(OpenBlocks.ID, "blockPlacer", 1, 0, missing),
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 2, missing));
        addShapelessRecipe(
                getModItem(OpenBlocks.ID, "blockbreaker", 1, 0, missing),
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 0, missing));
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "itemDropper", 1, 0, missing),
                "plateStone",
                "wireGt01RedAlloy",
                "plateStone",
                "gearGtSmallSteel",
                getModItem(Minecraft.ID, "dropper", 1, 0, missing),
                "gearGtSmallSteel",
                "plateStone",
                getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                "plateStone");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "beartrap", 1, 0, missing),
                CustomItemList.SteelBars.get(1L),
                "craftingToolHardHammer",
                CustomItemList.SteelBars.get(1L),
                "screwSteel",
                "plateSteel",
                "screwSteel",
                CustomItemList.SteelBars.get(1L),
                "craftingToolScrewdriver",
                CustomItemList.SteelBars.get(1L));
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "cannon", 1, 0, missing),
                "craftingToolSaw",
                "pipeLargeSteel",
                "craftingToolHardHammer",
                "gearGtSmallWood",
                "plateSteel",
                "gearGtSmallWood",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "wireGt01RedAlloy",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "village_highlighter", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "plateEmerald",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "plateStone",
                "plateStone",
                "plateStone");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "sky", 6, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "plateEnderEye",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "stoneEndstone",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing),
                "plateEnderEye",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0, missing));
        addShapelessRecipe(
                getModItem(OpenBlocks.ID, "sky", 1, 0, missing),
                getModItem(OpenBlocks.ID, "sky", 1, 1, missing));
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "projector", 1, 0, missing),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "craftingRedstoneTorch",
                getModItem(OpenComputers.ID, "hologram1", 1, 0, missing),
                "craftingRedstoneTorch",
                "craftingRedstoneTorch",
                getModItem(Minecraft.ID, "stone_slab", 1, 0, missing),
                "craftingRedstoneTorch");
        addShapelessRecipe(
                getModItem(OpenBlocks.ID, "canvas", 1, 0, missing),
                getModItem(BiblioCraft.ID, "item.PaintingCanvas", 1, 0, missing));
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "drawingtable", 1, 0, missing),
                getModItem(OpenBlocks.ID, "generic", 1, 10, missing),
                getModItem(OpenBlocks.ID, "generic", 1, 11, missing),
                getModItem(OpenBlocks.ID, "generic", 1, 10, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                getModItem(Minecraft.ID, "crafting_table", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "xpshower", 1, 0, missing),
                "itemCasingAnyIron",
                "pipeSmallSteel",
                "itemCasingAnyIron",
                "itemCasingAnyIron",
                "pipeSmallSteel",
                "itemCasingAnyIron",
                "pipeSmallSteel",
                "pipeSmallSteel",
                "pipeSmallSteel");
        addShapelessRecipe(
                getModItem(OpenBlocks.ID, "scaffolding", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "generic", 1, 9, missing),
                getModItem(ProjectBlue.ID, "miniatureLamp", 1, 14, missing),
                "plateEnderEye",
                getModItem(ProjectBlue.ID, "miniatureLamp", 1, 14, missing),
                ItemList.Electric_Motor_LV.get(1L),
                "circuitBasic",
                ItemList.Electric_Motor_LV.get(1L),
                "rotorAluminium",
                "plateEnderEye",
                "rotorAluminium");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "slimalyzer", 1, 0, missing),
                "screwIron",
                "circuitBasic",
                "screwIron",
                "itemCasingAnyIron",
                getModItem(TinkerConstruct.ID, "materials", 1, 1, missing),
                "itemCasingAnyIron",
                "craftingToolScrewdriver",
                "circuitBasic",
                "craftingToolFile");
        addShapelessRecipe(
                getModItem(OpenBlocks.ID, "paintBrush", 1, 0, missing),
                getModItem(BuildCraftCore.ID, "paintbrush", 1, 0, missing));
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "sonicglasses", 1, 0, missing),
                "wireGt01RedAlloy",
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 19, missing),
                "wireGt01RedAlloy",
                "circuitBasic",
                getModItem(Minecraft.ID, "iron_helmet", 1, 0, missing),
                "circuitBasic",
                "screwAluminium",
                "craftingToolScrewdriver",
                "screwAluminium");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "string", 64, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Wood, 64L))
                .itemOutputs(getModItem(OpenBlocks.ID, "ropeladder", 64, 0, missing)).duration(30 * SECONDS).eut(8)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "trapdoor", 1, 0, missing),
                        getModItem(Minecraft.ID, "ladder", 1, 0, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "ladder", 1, 0, missing)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(OpenBlocks.ID, "sky", 1, 0, missing), GTUtility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(OpenBlocks.ID, "sky", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(10 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Machine_LV_Mixer.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 4, 4, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "paintmixer", 1, 0, missing)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Machine_LV_Mixer.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.WroughtIron, 4))
                .itemOutputs(getModItem(OpenBlocks.ID, "paintmixer", 1, 0, missing)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Machine_LV_Mixer.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.PigIron, 4))
                .itemOutputs(getModItem(OpenBlocks.ID, "paintmixer", 1, 0, missing)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "factory", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 4, 4, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "xpbottler", 1, 0, missing)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "factory", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.WroughtIron, 4))
                .itemOutputs(getModItem(OpenBlocks.ID, "xpbottler", 1, 0, missing)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "factory", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.PigIron, 4))
                .itemOutputs(getModItem(OpenBlocks.ID, "xpbottler", 1, 0, missing)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L))
                .itemOutputs(getModItem(OpenBlocks.ID, "generic", 1, 10, missing)).duration(10 * SECONDS).eut(16)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Graphite, 1L))
                .itemOutputs(getModItem(OpenBlocks.ID, "generic", 1, 11, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 144)).duration(5 * SECONDS).eut(8)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenBlocks.ID, "generic", 1, 11, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 0, "{Uses:10.0f}", missing))
                .duration(5 * SECONDS).eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1))
                .itemOutputs(getModItem(OpenBlocks.ID, "generic", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(15 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenBlocks.ID, "generic", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1))
                .itemOutputs(getModItem(OpenBlocks.ID, "generic", 1, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(20 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenBlocks.ID, "generic", 1, 6, missing),
                        getModItem(OpenBlocks.ID, "generic", 4, 7, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:0b}", missing))
                .duration(30 * SECONDS).eut(30).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:0b}", missing),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1))
                .itemOutputs(createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:1b}", missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:1b}", missing),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 2))
                .itemOutputs(createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:2b}", missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(40 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:2b}", missing),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 2))
                .itemOutputs(createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:3b}", missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redalloy", 144)).duration(50 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:3b}", missing),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 2))
                .itemOutputs(createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:4b}", missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 144)).duration(1 * MINUTES).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenBlocks.ID, "generic", 1, 9, missing),
                        getModItem(Minecraft.ID, "ender_eye", 1, 0, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "cartographer", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).duration(30 * SECONDS).eut(120)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "clock", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 2))
                .itemOutputs(getModItem(OpenBlocks.ID, "pedometer", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(10 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenBlocks.ID, "guide", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1L))
                .itemOutputs(getModItem(OpenBlocks.ID, "builder_guide", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(15 * SECONDS).eut(64)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4),
                        GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 0, missing)).duration(10 * SECONDS).eut(8)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenBlocks.ID, "elevator", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 1),
                        GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 0, missing)).duration(10 * SECONDS)
                .eut(16).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 15, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblack", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 14, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 13, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 12, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 11, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 10, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 9, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 8, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 7, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 6, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 5, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 4, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 3, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 2, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 1, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 15, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblack", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 14, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 13, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 12, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 11, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 10, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 9, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 8, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 7, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 6, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 5, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 4, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 3, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 2, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 1, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 0, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:1973019}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblack", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:11743532}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:3887386}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:5320730}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:2437522}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:8073150}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:2651799}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:11250603}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:4408131}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:14188952}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:4312372}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:14602026}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:6719955}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:12801229}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:15435844}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0, missing))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:15790320}", missing))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "ender_eye", 1, 0, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "goldenEye", 1, 100, missing)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "wool", 1, 0, missing),
                        getModItem(Minecraft.ID, "slime_ball", 1, 0, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "sponge", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).duration(10 * SECONDS).eut(30)
                .addTo(UniversalChemical);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "clay_ball", 1, 0, missing),
                        getModItem(Minecraft.ID, "dye", 1, 3, missing))
                .itemOutputs(getModItem(OpenBlocks.ID, "tastyClay", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("milk", 500)).duration(5 * SECONDS).eut(8).addTo(mixerRecipes);

        new ResearchItem(
                "GOLDENEGG",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("bestia"), 12)
                        .add(Aspect.getAspect("victus"), 9).add(Aspect.getAspect("humanus"), 6),
                -4,
                5,
                3,
                getModItem(OpenBlocks.ID, "goldenegg", 1, 0, missing)).setParents("MB_DimensionalSingularity")
                        .setConcealed().setPages(new ResearchPage("OpenBlocks.research_page.GOLDENEGG"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "GOLDENEGG",
                getModItem(OpenBlocks.ID, "goldenegg", 1, 0, missing),
                2,
                new AspectList().add(Aspect.getAspect("alienis"), 75).add(Aspect.getAspect("bestia"), 50)
                        .add(Aspect.getAspect("victus"), 50).add(Aspect.getAspect("humanus"), 25),
                getModItem(Minecraft.ID, "egg", 1, 0, missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Gold, 1L),
                        getModItem(Minecraft.ID, "skull", 1, 3, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Gold, 1L),
                        getModItem(Minecraft.ID, "skull", 1, 3, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Gold, 1L),
                        getModItem(Minecraft.ID, "skull", 1, 3, missing), });
        TCHelper.addResearchPage(
                "GOLDENEGG",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(OpenBlocks.ID, "goldenegg", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("GOLDENEGG", 2);
    }
}
