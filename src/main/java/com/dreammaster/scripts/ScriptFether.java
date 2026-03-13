package com.dreammaster.scripts;

import static com.dreammaster.oredict.OreDictHelper.removeOreDict;
import static gregtech.api.enums.Mods.Fether;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Collections;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTRecipeBuilder;

public class ScriptFether implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Fether";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList(Fether.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessRecipe(
                getModItem(Fether.ID, "nether_planks", 2, 0),
                getModItem(Fether.ID, "nether_log", 1, GTRecipeBuilder.WILDCARD));

        addShapedRecipe(
                getModItem(Fether.ID, "nether_planks", 4, 0),
                "craftingToolSaw",
                getModItem(Fether.ID, "nether_log", 1, GTRecipeBuilder.WILDCARD),
                null);

        addShapedRecipe(
                getModItem(Fether.ID, "nether_bed", 1, 0),
                getModItem(Fether.ID, "blood_leaf", 1, 0),
                getModItem(Fether.ID, "blood_leaf", 1, 0),
                getModItem(Fether.ID, "blood_leaf", 1, 0),
                getModItem(Fether.ID, "nether_planks", 1, 0),
                getModItem(Fether.ID, "nether_planks", 1, 0),
                getModItem(Fether.ID, "nether_planks", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                "craftingToolHardHammer",
                getModItem(Fether.ID, "quartz_ingot", 1, 0));

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_sword", 1, 0),
                null,
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                null,
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                "craftingToolFile",
                Items.stick,
                "craftingToolHardHammer");

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_shovel", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                "craftingToolFile",
                Items.stick,
                "craftingToolHardHammer",
                null,
                Items.stick,
                null);

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_pickaxe", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                "craftingToolFile",
                Items.stick,
                "craftingToolHardHammer",
                null,
                Items.stick,
                null);

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_axe", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                Items.stick,
                null,
                "craftingToolFile",
                Items.stick,
                null);

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_hoe", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                "craftingToolHardHammer",
                "craftingToolFile",
                Items.stick,
                null,
                null,
                Items.stick,
                null);

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_helmet", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                null,
                null,
                null);

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_chestplate", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0));

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_leggings", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                null,
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_boots", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                null,
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                null,
                null,
                null);

        addShapelessRecipe(
                getModItem(Fether.ID, "glow_flower_seeds", 1, 0),
                getModItem(Fether.ID, "glow_flower", 1, 0));

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone_slab, 1, 7))
                .itemOutputs(getModItem(Fether.ID, "quartz_ingot", 2, 0))
                .fluidInputs(Materials.Water.getFluid(5)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone_slab, 1, 7))
                .itemOutputs(getModItem(Fether.ID, "quartz_ingot", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone_slab, 1, 7))
                .itemOutputs(getModItem(Fether.ID, "quartz_ingot", 2, 0))
                .fluidInputs(Materials.Lubricant.getFluid(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone_slab, 1, 7))
                .itemOutputs(getModItem(Fether.ID, "quartz_ingot", 2, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(2 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(cutterRecipes);

        removeOreDict("listAllmeatraw", getModItem(Fether.ID, "flesh_root", 1));
    }
}
