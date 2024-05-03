package com.dreammaster.scripts;

import static com.dreammaster.main.MainRegistry.Module_CustomFuels;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.IguanaTweaksTinkerConstruct;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.NewHorizonsCoreMod;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidCannerRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidExtractionRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidSolidifierRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

public class ScriptBiomesOPlenty implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Biomes o Plenty";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                BiomesOPlenty.ID,
                Forestry.ID,
                GTPlusPlus.ID,
                IguanaTweaksTinkerConstruct.ID,
                PamsHarvestCraft.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessRecipe(getModItem(BiomesOPlenty.ID, "jarEmpty", 1, 0, missing), "bottleEmpty");
        addShapelessRecipe(
                getModItem(Minecraft.ID, "glass_bottle", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "jarEmpty", 1, 0, missing));
        addShapelessRecipe(
                getModItem(BiomesOPlenty.ID, "mudball", 2, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(Minecraft.ID, "water_bucket", 1, 0, missing));
        addShapelessRecipe(
                getModItem(BiomesOPlenty.ID, "mudball", 2, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing),
                getModItem(IguanaTweaksTinkerConstruct.ID, "clayBucketWater", 1, 0, missing));
        addShapedRecipe(
                getModItem(BiomesOPlenty.ID, "dartBlower", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "plants", 1, 8, missing),
                "ringWood",
                getModItem(BiomesOPlenty.ID, "plants", 1, 8, missing),
                getModItem(BiomesOPlenty.ID, "plants", 1, 8, missing),
                null,
                getModItem(BiomesOPlenty.ID, "plants", 1, 8, missing),
                getModItem(BiomesOPlenty.ID, "plants", 1, 8, missing),
                "ringWood",
                getModItem(BiomesOPlenty.ID, "plants", 1, 8, missing));
        addShapedRecipe(
                getModItem(BiomesOPlenty.ID, "dart", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "plants", 1, 5, missing),
                null,
                null,
                getModItem(BiomesOPlenty.ID, "plants", 1, 8, missing),
                null,
                null,
                getModItem(Minecraft.ID, "feather", 1, 0, missing),
                null,
                null);
        addShapedRecipe(
                getModItem(BiomesOPlenty.ID, "scytheDiamond", 1, 0, missing),
                "gemDiamond",
                "plateDiamond",
                "craftingToolHardHammer",
                "stickWood",
                "craftingToolFile",
                "plateDiamond",
                "stickWood",
                null,
                null);
        addShapelessRecipe(
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 1L),
                getModItem(BiomesOPlenty.ID, "misc", 1, 1, missing),
                getModItem(BiomesOPlenty.ID, "misc", 1, 1, missing),
                getModItem(BiomesOPlenty.ID, "misc", 1, 1, missing),
                getModItem(BiomesOPlenty.ID, "misc", 1, 1, missing));
        addShapelessRecipe(
                getModItem(Minecraft.ID, "bucket", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "bopBucket", 1, 0, missing));
        addShapelessRecipe(
                getModItem(BiomesOPlenty.ID, "rocks", 1, 1, missing),
                getModItem(BiomesOPlenty.ID, "rocks", 1, 0, missing));
        addShapelessRecipe(
                getModItem(BiomesOPlenty.ID, "rocks", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "rocks", 1, 1, missing));
        addShapelessRecipe(
                getModItem(BiomesOPlenty.ID, "coral1", 1, 15, missing),
                getModItem(BiomesOPlenty.ID, "coral2", 1, 8, missing),
                "dustGlowstone");
        addShapelessRecipe(
                getModItem(BiomesOPlenty.ID, "coral1", 1, 15, missing),
                getModItem(GTPlusPlus.ID, "item.BasicAgrichemItem", 1, 1, missing),
                "dustGlowstone");
        addShapelessRecipe(
                getModItem(BiomesOPlenty.ID, "coral1", 1, 12, missing),
                getModItem(BiomesOPlenty.ID, "coral2", 1, 8, missing),
                "dustGlowstone",
                "dyePink");
        addShapelessRecipe(
                getModItem(BiomesOPlenty.ID, "coral1", 1, 13, missing),
                getModItem(BiomesOPlenty.ID, "coral2", 1, 8, missing),
                "dustGlowstone",
                "dyeOrange");
        addShapelessRecipe(
                getModItem(BiomesOPlenty.ID, "coral1", 1, 14, missing),
                getModItem(BiomesOPlenty.ID, "coral2", 1, 8, missing),
                "dustGlowstone",
                "dyeBlue");
        addShapelessRecipe(ItemList.Color_00.get(1L), getModItem(BiomesOPlenty.ID, "flowers", 1, 2, missing));
        addShapelessRecipe(ItemList.Color_15.get(1L), getModItem(BiomesOPlenty.ID, "flowers", 1, 9, missing));
        addShapelessRecipe(ItemList.Color_15.get(1L), getModItem(BiomesOPlenty.ID, "flowers2", 1, 1, missing));
        addShapelessRecipe(ItemList.Color_04.get(1L), getModItem(BiomesOPlenty.ID, "flowers2", 1, 5, missing));
        addShapelessRecipe(ItemList.Color_04.get(1L), getModItem(BiomesOPlenty.ID, "mushrooms", 1, 2, missing));
        addShapelessRecipe(ItemList.Color_02.get(1L), getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing));
        addShapelessRecipe(ItemList.Color_03.get(1L), getModItem(BiomesOPlenty.ID, "mushrooms", 1, 4, missing));
        addShapelessRecipe(ItemList.Color_03.get(1L), getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing));

        GT_ModHandler.addSmeltingRecipe(
                getModItem(BiomesOPlenty.ID, "driedDirt", 1, 0, missing),
                getModItem(Minecraft.ID, "dirt", 1, 0, missing));
        Module_CustomFuels.registerCustomFuelValue(getModItem(BiomesOPlenty.ID, "bamboo", 1, 0, missing), (short) 100);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Forestry.ID, "beeswax", 2, 0, missing), GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "misc", 1, 2, missing)).duration(6 * SECONDS).eut(20)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(Forestry.ID, "propolis", 2, 0, missing), GT_Utility.getIntegratedCircuit(2))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "hive", 1, 1, missing)).duration(20 * SECONDS).eut(40)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone", 1, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, 4L))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "rocks", 1, 0, missing)).duration(2 * SECONDS + 10 * TICKS)
                .eut(2).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "honeyBlock", 1, 0, missing))
                .itemOutputs(
                        getModItem(Forestry.ID, "honeyDrop", 7, 0, missing),
                        getModItem(Forestry.ID, "honeyDrop", 1, 0, missing),
                        getModItem(Forestry.ID, "honeyDrop", 1, 0, missing),
                        getModItem(Forestry.ID, "honeyDrop", 1, 0, missing))
                .outputChances(10000, 5000, 2500, 1200).duration(3 * MINUTES + 20 * SECONDS).eut(8)
                .addTo(centrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "misc", 1, 2, missing))
                .itemOutputs(getModItem(Forestry.ID, "beeswax", 1, 0, missing)).outputChances(10000)
                .duration(6 * SECONDS).eut(5).addTo(centrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "waxcombItem", 1, 0, missing))
                .itemOutputs(getModItem(Forestry.ID, "beeswax", 1, 0, missing)).outputChances(10000)
                .duration(6 * SECONDS).eut(5).addTo(centrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "food", 1, 9, missing))
                .itemOutputs(
                        getModItem(Forestry.ID, "beeswax", 1, 0, missing),
                        getModItem(Forestry.ID, "honeyDrop", 1, 0, missing))
                .outputChances(10000, 9000).duration(6 * SECONDS).eut(5).addTo(centrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(PamsHarvestCraft.ID, "honeycombItem", 1, 0, missing))
                .itemOutputs(
                        getModItem(Forestry.ID, "beeswax", 1, 0, missing),
                        getModItem(Forestry.ID, "honeyDrop", 1, 0, missing))
                .outputChances(10000, 9000).duration(6 * SECONDS).eut(5).addTo(centrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 6, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 2, missing))
                .itemOutputs(ItemList.Color_00.get(2L)).duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 4, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 12, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers2", 1, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 12, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 5, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 14, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers2", 1, 2, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 14, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 9, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers2", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 9, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 7, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 13, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 8, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 5, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers2", 1, 3, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 5, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 9, missing))
                .itemOutputs(ItemList.Color_15.get(2L)).duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers2", 1, 1, missing))
                .itemOutputs(ItemList.Color_15.get(2L)).duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers", 1, 15, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 7, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers2", 1, 4, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 11, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers2", 1, 5, missing))
                .itemOutputs(ItemList.Color_04.get(2L)).duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "mushrooms", 1, 2, missing))
                .itemOutputs(ItemList.Color_04.get(2L)).duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "flowers2", 1, 8, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 2, 1, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "moss", 1, 0, missing))
                .itemOutputs(ItemList.Color_02.get(2L)).duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "mushrooms", 1, 4, missing))
                .itemOutputs(ItemList.Color_03.get(2L)).duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "plants", 1, 7, missing))
                .itemOutputs(ItemList.Color_03.get(2L)).duration(15 * SECONDS).eut(2).addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "mud", 1, 0, missing))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "mudball", 4, 0, missing)).duration(5 * SECONDS).eut(8)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "jarFilled", 1, 1, missing))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "jarEmpty", 1, 0, missing)).outputChances(10000)
                .fluidOutputs(FluidRegistry.getFluidStack("poison", 1000)).duration(1 * SECONDS).eut(2)
                .addTo(fluidExtractionRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "honeyBlock", 1, 0, missing))
                .fluidOutputs(FluidRegistry.getFluidStack("for.honey", 1000)).duration(1 * MINUTES).eut(40)
                .addTo(fluidExtractionRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "misc", 1, 2, missing))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "food", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 100)).duration(1).eut(1)
                .addTo(fluidCannerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Block.get(0L))
                .itemOutputs(getModItem(BiomesOPlenty.ID, "honeyBlock", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("for.honey", 1000)).duration(20 * SECONDS).eut(40)
                .addTo(fluidSolidifierRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "bones", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 8, 15, missing)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "bones", 1, 1, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 12, 15, missing)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "bones", 1, 2, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 24, 15, missing)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "hardSand", 1, 0, missing))
                .itemOutputs(
                        getModItem(NewHorizonsCoreMod.ID, "item.SandDust", 2, 0, missing),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Flint, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.CassiteriteSand, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Phosphate, 1L))
                .outputChances(10000, 5000, 1000, 500).duration(10 * SECONDS).eut(8).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(BiomesOPlenty.ID, "hardDirt", 1, 0, missing))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Clay, 2L),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Quicklime, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Gypsum, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Calcite, 1L))
                .outputChances(10000, 7500, 2500, 2500).duration(10 * SECONDS).eut(8).addTo(maceratorRecipes);

    }
}
