package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
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
import static gregtech.api.util.GTRecipeBuilder.MINUTES;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeConstants.UniversalChemical;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.block.BlockList;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.dreammaster.item.NHItemList;
import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
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
                Backpack.ID,
                BiblioCraft.ID,
                BuildCraftCore.ID,
                ExtraUtilities.ID,
                Forestry.ID,
                GalacticraftCore.ID,
                IndustrialCraft2.ID,
                OpenBlocks.ID,
                OpenComputers.ID,
                ProjectBlue.ID,
                ProjectRedExpansion.ID,
                Railcraft.ID,
                RandomThings.ID,
                Thaumcraft.ID,
                TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack devNull = getModItem(OpenBlocks.ID, "devnull", 1);
        ItemStack voidDropFilter = getModItem(RandomThings.ID, "dropFilter", 1, 1);
        ItemStack trashCan = getModItem(ExtraUtilities.ID, "trashcan", 1);

        FluidStack ender250 = FluidRegistry.getFluidStack("ender", 250);

        addShapelessRecipe(devNull, voidDropFilter);

        GTValues.RA.stdBuilder().itemInputs(trashCan).itemOutputs(devNull).circuit(2).fluidInputs(ender250)
                .duration(15 * SECONDS).eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(OpenBlocks.ID, "hangglider", 1, 0),
                "screwSteel",
                "screwSteel",
                "screwSteel",
                getModItem(OpenBlocks.ID, "generic", 1, 0),
                "plateSteel",
                getModItem(OpenBlocks.ID, "generic", 1, 0),
                "craftingToolWrench",
                "screwSteel",
                "craftingToolScrewdriver");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "generic", 1, 0),
                "craftingToolHardHammer",
                "stickSteel",
                "itemLeather",
                "stickSteel",
                getModItem(Backpack.ID, "tannedLeather", 1, 0),
                "itemLeather",
                "itemLeather",
                "itemLeather",
                "itemLeather");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "autoanvil", 1, 0),
                "blockStainlessSteel",
                "blockStainlessSteel",
                "blockStainlessSteel",
                "screwStainlessSteel",
                getModItem(Railcraft.ID, "anvil", 1, 0),
                "screwStainlessSteel",
                "plateRedAlloy",
                "blockRedstone",
                "plateRedAlloy");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "xpdrain", 1, 0),
                "screwAnyIron",
                "stickAnyIron",
                "screwAnyIron",
                "stickAnyIron",
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "stickAnyIron",
                "screwAnyIron",
                "stickAnyIron",
                "screwAnyIron");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "path", 4, 0),
                getModItem(Minecraft.ID, "stone_slab", 1, 3),
                null,
                getModItem(Minecraft.ID, "stone_slab", 1, 3),
                null,
                getModItem(Minecraft.ID, "stone_slab", 1, 3),
                null,
                getModItem(Minecraft.ID, "stone_slab", 1, 3),
                null,
                getModItem(Minecraft.ID, "stone_slab", 1, 3));
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "fan", 1, 0),
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                ItemList.Rotor_LV.get(1L),
                getModItem(Minecraft.ID, "iron_bars", 1, 0),
                "screwSteel",
                "plateAnyIron",
                "screwSteel",
                "plateAnyIron",
                ItemList.Electric_Motor_MV.get(1L),
                "plateAnyIron");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "elevator", 1, 0),
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
                getModItem(OpenBlocks.ID, "elevator_rotating", 1, 0),
                null,
                "stickSteel",
                null,
                "gearGtSmallSteel",
                getModItem(OpenBlocks.ID, "elevator", 1, 0),
                "gearGtSmallSteel",
                "craftingToolScrewdriver",
                "stickSteel",
                "craftingToolFile");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "elevator_rotating", 1, 0),
                "craftingToolScrewdriver",
                "stickSteel",
                "craftingToolFile",
                "gearGtSmallSteel",
                getModItem(OpenBlocks.ID, "elevator", 1, 0),
                "gearGtSmallSteel",
                null,
                "stickSteel",
                null);
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "vacuumhopper", 1, 0),
                "plateObsidian",
                getModItem(Minecraft.ID, "hopper", 1, 0),
                "plateObsidian",
                getModItem(Minecraft.ID, "hopper", 1, 0),
                "plateEnderPearl",
                getModItem(Minecraft.ID, "hopper", 1, 0),
                "plateObsidian",
                getModItem(Minecraft.ID, "hopper", 1, 0),
                "plateObsidian");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "sprinkler", 1, 0),
                BlockList.AluminiumBars.get(),
                "stickGold",
                BlockList.AluminiumBars.get(),
                "pipeSmallDarkSteel",
                "rotorDarkSteel",
                "pipeSmallDarkSteel",
                BlockList.AluminiumBars.get(),
                "stickGold",
                BlockList.AluminiumBars.get());
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "guide", 1, 0),
                "stoneObsidian",
                getModItem(IndustrialCraft2.ID, "blockLuminatorDark", 1, 0),
                "stoneObsidian",
                getModItem(IndustrialCraft2.ID, "blockLuminatorDark", 1, 0),
                "lensDiamond",
                getModItem(IndustrialCraft2.ID, "blockLuminatorDark", 1, 0),
                "stoneObsidian",
                getModItem(IndustrialCraft2.ID, "blockLuminatorDark", 1, 0),
                "stoneObsidian");
        addShapelessRecipe(
                getModItem(OpenBlocks.ID, "blockPlacer", 1, 0),
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 2));
        addShapelessRecipe(
                getModItem(OpenBlocks.ID, "blockbreaker", 1, 0),
                getModItem(ProjectRedExpansion.ID, "projectred.expansion.machine2", 1, 0));
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "itemDropper", 1, 0),
                "plateStone",
                "wireGt01RedAlloy",
                "plateStone",
                "gearGtSmallSteel",
                getModItem(Minecraft.ID, "dropper", 1, 0),
                "gearGtSmallSteel",
                "plateStone",
                getModItem(Minecraft.ID, "hopper", 1, 0),
                "plateStone");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "beartrap", 1, 0),
                BlockList.SteelBars.get(),
                "craftingToolHardHammer",
                BlockList.SteelBars.get(),
                "screwSteel",
                "plateSteel",
                "screwSteel",
                BlockList.SteelBars.get(),
                "craftingToolScrewdriver",
                BlockList.SteelBars.get());
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "cannon", 1, 0),
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
                getModItem(OpenBlocks.ID, "village_highlighter", 1, 0),
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
                getModItem(OpenBlocks.ID, "sky", 6, 0),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "plateEnderEye",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "stoneEndstone",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0),
                "plateEnderEye",
                getModItem(TinkerConstruct.ID, "GlassPane", 1, 0));
        addShapelessRecipe(getModItem(OpenBlocks.ID, "sky", 1, 0), getModItem(OpenBlocks.ID, "sky", 1, 1));
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "projector", 1, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "craftingRedstoneTorch",
                getModItem(OpenComputers.ID, "hologram1", 1, 0),
                "craftingRedstoneTorch",
                "craftingRedstoneTorch",
                getModItem(Minecraft.ID, "stone_slab", 1, 0),
                "craftingRedstoneTorch");
        addShapelessRecipe(
                getModItem(OpenBlocks.ID, "canvas", 1, 0),
                getModItem(BiblioCraft.ID, "item.PaintingCanvas", 1, 0));
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "drawingtable", 1, 0),
                getModItem(OpenBlocks.ID, "generic", 1, 10),
                getModItem(OpenBlocks.ID, "generic", 1, 11),
                getModItem(OpenBlocks.ID, "generic", 1, 10),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                getModItem(Minecraft.ID, "crafting_table", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Wood, 1L),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "xpshower", 1, 0),
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
                getModItem(OpenBlocks.ID, "scaffolding", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Wood, 1L));
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "generic", 1, 9),
                getModItem(ProjectBlue.ID, "miniatureLamp", 1, 14),
                "plateEnderEye",
                getModItem(ProjectBlue.ID, "miniatureLamp", 1, 14),
                ItemList.Electric_Motor_LV.get(1L),
                "circuitBasic",
                ItemList.Electric_Motor_LV.get(1L),
                "rotorAluminium",
                "plateEnderEye",
                "rotorAluminium");
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "slimalyzer", 1, 0),
                "screwIron",
                "circuitBasic",
                "screwIron",
                "itemCasingAnyIron",
                getModItem(TinkerConstruct.ID, "materials", 1, 1),
                "itemCasingAnyIron",
                "craftingToolScrewdriver",
                "circuitBasic",
                "craftingToolFile");
        addShapelessRecipe(
                getModItem(OpenBlocks.ID, "paintBrush", 1, 0),
                getModItem(BuildCraftCore.ID, "paintbrush", 1, 0));
        addShapedRecipe(
                getModItem(OpenBlocks.ID, "sonicglasses", 1, 0),
                "wireGt01RedAlloy",
                getModItem(GalacticraftCore.ID, "item.basicItem", 1, 19),
                "wireGt01RedAlloy",
                "circuitBasic",
                getModItem(Minecraft.ID, "iron_helmet", 1, 0),
                "circuitBasic",
                "screwAluminium",
                "craftingToolScrewdriver",
                "screwAluminium");

        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "string", 64, 0),
                        GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Wood, 64L))
                .itemOutputs(getModItem(OpenBlocks.ID, "ropeladder", 64, 0)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "trapdoor", 1, 0), getModItem(Minecraft.ID, "ladder", 1, 0))
                .itemOutputs(getModItem(OpenBlocks.ID, "ladder", 1, 0)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "sky", 1, 0)).circuit(1)
                .itemOutputs(getModItem(OpenBlocks.ID, "sky", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(ItemList.Machine_LV_Mixer.get(1L), getModItem(IndustrialCraft2.ID, "itemCasing", 4, 4))
                .itemOutputs(getModItem(OpenBlocks.ID, "paintmixer", 1, 0)).duration(30 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Machine_LV_Mixer.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.WroughtIron, 4))
                .itemOutputs(getModItem(OpenBlocks.ID, "paintmixer", 1, 0)).duration(30 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Machine_LV_Mixer.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.PigIron, 4))
                .itemOutputs(getModItem(OpenBlocks.ID, "paintmixer", 1, 0)).duration(30 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "factory", 1, 0),
                        getModItem(IndustrialCraft2.ID, "itemCasing", 4, 4))
                .itemOutputs(getModItem(OpenBlocks.ID, "xpbottler", 1, 0)).duration(30 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "factory", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.WroughtIron, 4))
                .itemOutputs(getModItem(OpenBlocks.ID, "xpbottler", 1, 0)).duration(30 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Forestry.ID, "factory", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.itemCasing, Materials.PigIron, 4))
                .itemOutputs(getModItem(OpenBlocks.ID, "xpbottler", 1, 0)).duration(30 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(TinkerConstruct.ID, "blankPattern", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Iron, 1L))
                .itemOutputs(getModItem(OpenBlocks.ID, "generic", 1, 10)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stick", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.dustSmall, Materials.Graphite, 1L))
                .itemOutputs(getModItem(OpenBlocks.ID, "generic", 1, 11))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 144)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenBlocks.ID, "generic", 1, 11),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderEye, 1L))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 0, "{Uses:10.0f}")).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        ItemList.Circuit_Board_Plastic_Advanced.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1))
                .itemOutputs(getModItem(OpenBlocks.ID, "generic", 1, 6))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenBlocks.ID, "generic", 1, 6),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1))
                .itemOutputs(getModItem(OpenBlocks.ID, "generic", 1, 7))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(OpenBlocks.ID, "generic", 1, 6), getModItem(OpenBlocks.ID, "generic", 4, 7))
                .itemOutputs(createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:0b}")).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:0b}"),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 1))
                .itemOutputs(createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:1b}"))
                .fluidInputs(FluidRegistry.getFluidStack("molten.tin", 144)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:1b}"),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 2))
                .itemOutputs(createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:2b}"))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(40 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:2b}"),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.MV, 2))
                .itemOutputs(createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:3b}"))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redalloy", 144)).duration(50 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:3b}"),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.HV, 2))
                .itemOutputs(createItemStack(OpenBlocks.ID, "emptyMap", 1, 0, "{Scale:4b}"))
                .fluidInputs(FluidRegistry.getFluidStack("molten.glowstone", 144)).duration(1 * MINUTES)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(OpenBlocks.ID, "generic", 1, 9), getModItem(Minecraft.ID, "ender_eye", 1, 0))
                .itemOutputs(getModItem(OpenBlocks.ID, "cartographer", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ender", 1000)).duration(30 * SECONDS).eut(TierEU.RECIPE_MV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "clock", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.circuit, Materials.LV, 2))
                .itemOutputs(getModItem(OpenBlocks.ID, "pedometer", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 144)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenBlocks.ID, "guide", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.lens, Materials.EnderEye, 1L))
                .itemOutputs(getModItem(OpenBlocks.ID, "builder_guide", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.redstone", 288)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.frameGt, Materials.Aluminium, 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 4),
                        GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 0)).duration(10 * SECONDS).eut(TierEU.RECIPE_ULV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(OpenBlocks.ID, "elevator", 1, 0),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Steel, 1),
                        GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Steel, 1))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 15)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblack", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 14)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 13)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 12)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 11)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 10)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 9)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 8)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 7)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 6)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 5)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 4)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 3)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 2)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 1)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator", 1, 0)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 15)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblack", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 14)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 13)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 12)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 11)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 10)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 9)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 8)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 7)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 6)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 5)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 4)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 3)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 2)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 1)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 144)).duration(10 * SECONDS)
                .eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, wildcard))
                .itemOutputs(getModItem(OpenBlocks.ID, "elevator_rotating", 1, 0)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:1973019}"))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblack", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:11743532}"))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyered", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:3887386}"))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegreen", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:5320730}"))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyebrown", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:2437522}"))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeblue", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:8073150}"))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepurple", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:2651799}"))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyecyan", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:11250603}"))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightgray", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:4408131}"))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyegray", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:14188952}"))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyepink", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:4312372}"))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelime", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:14602026}"))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeyellow", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:6719955}"))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyelightblue", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:12801229}"))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyemagenta", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:15435844}"))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyeorange", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(OpenBlocks.ID, "imaginary", 1, 0))
                .itemOutputs(createItemStack(OpenBlocks.ID, "imaginary", 1, 1, "{Uses:10.0f,Color:15790320}"))
                .outputChances(10000).fluidInputs(FluidRegistry.getFluidStack("dye.watermixed.dyewhite", 144))
                .duration(10 * SECONDS).eut(20).addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "ender_eye", 1, 0))
                .itemOutputs(getModItem(OpenBlocks.ID, "goldenEye", 1, 100)).outputChances(10000)
                .fluidInputs(FluidRegistry.getFluidStack("molten.gold", 144)).duration(10 * SECONDS).eut(20)
                .addTo(chemicalBathRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "wool", 1, 0), getModItem(Minecraft.ID, "slime_ball", 1, 0))
                .itemOutputs(getModItem(OpenBlocks.ID, "sponge", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 1000)).duration(10 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(UniversalChemical);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "clay_ball", 1, 0), getModItem(Minecraft.ID, "dye", 1, 3))
                .itemOutputs(getModItem(OpenBlocks.ID, "tastyClay", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("milk", 500)).duration(5 * SECONDS).eut(TierEU.RECIPE_ULV)
                .addTo(mixerRecipes);

        new ResearchItem(
                "GOLDENEGG",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("bestia"), 12)
                        .add(Aspect.getAspect("victus"), 9).add(Aspect.getAspect("humanus"), 6),
                -4,
                5,
                3,
                getModItem(OpenBlocks.ID, "goldenegg", 1, 0)).setParents("MB_DimensionalSingularity").setConcealed()
                        .setPages(new ResearchPage("OpenBlocks.research_page.GOLDENEGG")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "GOLDENEGG",
                getModItem(OpenBlocks.ID, "goldenegg", 1, 0),
                2,
                new AspectList().add(Aspect.getAspect("alienis"), 75).add(Aspect.getAspect("bestia"), 50)
                        .add(Aspect.getAspect("victus"), 50).add(Aspect.getAspect("humanus"), 25),
                getModItem(Minecraft.ID, "egg", 1, 0),
                OrePrefixes.plateDense.get(Materials.Gold),
                getModItem(Minecraft.ID, "skull", 1, 3),
                OrePrefixes.plateDense.get(Materials.Gold),
                getModItem(Minecraft.ID, "skull", 1, 3),
                OrePrefixes.plateDense.get(Materials.Gold),
                getModItem(Minecraft.ID, "skull", 1, 3));
        TCHelper.addResearchPage(
                "GOLDENEGG",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(OpenBlocks.ID, "goldenegg", 1, 0))));
        ThaumcraftApi.addWarpToResearch("GOLDENEGG", 2);
    }
}
