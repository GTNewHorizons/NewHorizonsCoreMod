package com.dreammaster.scripts;

import static com.dreammaster.oredict.OreDictHelper.removeOreDict;
import static gregtech.api.enums.Mods.Fether;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
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
        final ItemStack netherPlanks = getModItem(Fether.ID, "nether_planks", 1, 0, missing);
        final ItemStack netherLog = getModItem(Fether.ID, "nether_log", 1, 0, missing);
        final ItemStack bloodLeaf = getModItem(Fether.ID, "blood_leaf", 1, 0, missing);
        final ItemStack quartzIngot = getModItem(Fether.ID, "quartz_ingot", 1, 0, missing);
        final ItemStack netherQuartzPlate = GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L);

        netherPlanks.stackSize = 2;
        addShapelessRecipe(netherPlanks, netherLog);

        netherPlanks.stackSize = 4;
        addShapedRecipe(netherPlanks, "craftingToolSaw", netherLog, null);

        netherPlanks.stackSize = 1;
        addShapedRecipe(
                getModItem(Fether.ID, "nether_bed", 1, 0, missing),
                bloodLeaf,
                bloodLeaf,
                bloodLeaf,
                netherPlanks,
                netherPlanks,
                netherPlanks,
                quartzIngot,
                "craftingToolHardHammer",
                quartzIngot);

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_sword", 1, 0, missing),
                null,
                quartzIngot,
                null,
                netherQuartzPlate,
                (quartzIngot.stackSize = 64),
                netherQuartzPlate,
                "craftingToolFile",
                Items.stick,
                "craftingToolHardHammer");

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_shovel", 1, 0, missing),
                netherQuartzPlate,
                getModItem(Fether.ID, "quartz_ingot", 64, 0, missing),
                netherQuartzPlate,
                "craftingToolFile",
                Items.stick,
                "craftingToolHardHammer",
                null,
                Items.stick,
                null);

        quartzIngot.stackSize = 1;
        addShapedRecipe(
                getModItem(Fether.ID, "quartz_pickaxe", 1, 0, missing),
                netherQuartzPlate,
                quartzIngot,
                quartzIngot,
                "craftingToolFile",
                Items.stick,
                "craftingToolHardHammer",
                null,
                Items.stick,
                null);

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_axe", 1, 0, missing),
                netherQuartzPlate,
                quartzIngot,
                "craftingToolHardHammer",
                netherQuartzPlate,
                Items.stick,
                null,
                "craftingToolFile",
                Items.stick,
                null);

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_hoe", 1, 0, missing),
                netherQuartzPlate,
                quartzIngot,
                "craftingToolHardHammer",
                "craftingToolFile",
                Items.stick,
                null,
                null,
                Items.stick,
                null);

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_helmet", 1, 0, missing),
                quartzIngot,
                quartzIngot,
                quartzIngot,
                netherQuartzPlate,
                "craftingToolHardHammer",
                netherQuartzPlate,
                null,
                null,
                null);

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_chestplate", 1, 0, missing),
                netherQuartzPlate,
                "craftingToolHardHammer",
                netherQuartzPlate,
                netherQuartzPlate,
                netherQuartzPlate,
                netherQuartzPlate,
                quartzIngot,
                quartzIngot,
                quartzIngot);

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_leggings", 1, 0, missing),
                quartzIngot,
                quartzIngot,
                quartzIngot,
                netherQuartzPlate,
                "craftingToolHardHammer",
                netherQuartzPlate,
                netherQuartzPlate,
                null,
                netherQuartzPlate);

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_boots", 1, 0, missing),
                quartzIngot,
                null,
                quartzIngot,
                netherQuartzPlate,
                "craftingToolHardHammer",
                netherQuartzPlate,
                null,
                null,
                null);

        addShapelessRecipe(
                getModItem(Fether.ID, "glow_flower_seeds", 1, 0, missing),
                getModItem(Fether.ID, "glow_flower", 1, 0, missing));

        quartzIngot.stackSize = 2;
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone_slab, 1, 7)).itemOutputs(quartzIngot)
                .fluidInputs(Materials.Water.getFluid(5)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone_slab, 1, 7)).itemOutputs(quartzIngot)
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone_slab, 1, 7)).itemOutputs(quartzIngot)
                .fluidInputs(Materials.Lubricant.getFluid(1)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2)
                .addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone_slab, 1, 7)).itemOutputs(quartzIngot)
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(2 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(cutterRecipes);

        removeOreDict("listAllmeatraw", getModItem(Fether.ID, "flesh_root", 1));
    }
}
