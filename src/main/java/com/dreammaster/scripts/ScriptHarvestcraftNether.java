package com.dreammaster.scripts;

import static com.dreammaster.oredict.OreDictHelper.removeOreDict;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.PamsHarvestTheNether;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Collections;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;

public class ScriptHarvestcraftNether implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Harvestcraft Nether";
    }

    @Override
    public List<String> getDependencies() {
        return Collections.singletonList(PamsHarvestTheNether.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessRecipe(
                getModItem(PamsHarvestTheNether.ID, "netherPlanks", 2, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "netherLog", 1, 0, missing));
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "netherPlanks", 4, 0, missing),
                "craftingToolSaw",
                getModItem(PamsHarvestTheNether.ID, "netherLog", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "netherbedItem", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "bloodleafItem", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "bloodleafItem", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "bloodleafItem", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "netherPlanks", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "netherPlanks", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "netherPlanks", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                "craftingToolHardHammer",
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing));
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "Quartz Sword", 1, 0, missing),
                null,
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                null,
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 64, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                "craftingToolFile",
                getModItem(Minecraft.ID, "stick", 1, 0, missing),
                "craftingToolHardHammer");
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "Quartz Shovel", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 64, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                "craftingToolFile",
                getModItem(Minecraft.ID, "stick", 1, 0, missing),
                "craftingToolHardHammer",
                null,
                getModItem(Minecraft.ID, "stick", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "Quartz Pickaxe", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                "craftingToolFile",
                getModItem(Minecraft.ID, "stick", 1, 0, missing),
                "craftingToolHardHammer",
                null,
                getModItem(Minecraft.ID, "stick", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "Quartz Axe", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(Minecraft.ID, "stick", 1, 0, missing),
                null,
                "craftingToolFile",
                getModItem(Minecraft.ID, "stick", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "Quartz Hoe", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                "craftingToolHardHammer",
                "craftingToolFile",
                getModItem(Minecraft.ID, "stick", 1, 0, missing),
                null,
                null,
                getModItem(Minecraft.ID, "stick", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "quartzhelmItem", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                null,
                null,
                null);
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "quartzchestItem", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing));
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "quartzleggingsItem", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                null,
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L));
        addShapedRecipe(
                getModItem(PamsHarvestTheNether.ID, "quartzbootsItem", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                null,
                getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 1, 0, missing),
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                "craftingToolHardHammer",
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                null,
                null,
                null);
        addShapelessRecipe(
                getModItem(PamsHarvestTheNether.ID, "glowflowerseedItem", 1, 0, missing),
                getModItem(PamsHarvestTheNether.ID, "glowFlower", 1, 0, missing));

        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone_slab", 1, 7, missing))
                .itemOutputs(getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).duration(5 * SECONDS).eut(16)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone_slab", 1, 7, missing))
                .itemOutputs(getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(5 * SECONDS).eut(16)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "stone_slab", 1, 7, missing))
                .itemOutputs(getModItem(PamsHarvestTheNether.ID, "quartzingotItem", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(5 * SECONDS).eut(16)
                .addTo(cutterRecipes);

        removeOreDict("listAllmeatraw", getModItem(PamsHarvestTheNether.ID, "fleshrootItem", 1));
    }
}
