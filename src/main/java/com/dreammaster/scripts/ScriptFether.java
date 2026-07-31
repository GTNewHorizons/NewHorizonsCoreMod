package com.dreammaster.scripts;

import static com.dreammaster.oredict.OreDictHelper.removeOreDict;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Fether;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.extruderRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Collections;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.ruling_0.materiallib.api.MaterialLibAPI;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.TierEU;
import gregtech.api.enums.materials2.Materials2FluidShapes;
import gregtech.api.enums.materials2.Materials2Materials;
import gregtech.api.enums.materials2.Materials2Shapes;
import gregtech.api.material.MU;
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
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                "craftingToolFile",
                Items.stick,
                "craftingToolHardHammer");

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_shovel", 1, 0),
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                "craftingToolFile",
                Items.stick,
                "craftingToolHardHammer",
                null,
                Items.stick,
                null);

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_pickaxe", 1, 0),
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
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
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                Items.stick,
                null,
                "craftingToolFile",
                Items.stick,
                null);

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_hoe", 1, 0),
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
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
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                null,
                null,
                null);

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_chestplate", 1, 0),
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0));

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_leggings", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                null,
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)));

        addShapedRecipe(
                getModItem(Fether.ID, "quartz_boots", 1, 0),
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                null,
                getModItem(Fether.ID, "quartz_ingot", 1, 0),
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                "craftingToolHardHammer",
                MaterialLibAPI.getStack(Materials2Materials.NetherQuartz, Materials2Shapes.plate, (int) (1L)),
                null,
                null,
                null);

        addShapelessRecipe(
                getModItem(Fether.ID, "glow_flower_seeds", 1, 0),
                getModItem(Fether.ID, "glow_flower", 1, 0));

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone_slab, 1, 7))
                .itemOutputs(getModItem(Fether.ID, "quartz_ingot", 2, 0))
                .fluidInputs(MU.materialOf(Materials2Materials.Water).getFluid(5)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone_slab, 1, 7))
                .itemOutputs(getModItem(Fether.ID, "quartz_ingot", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone_slab, 1, 7))
                .itemOutputs(getModItem(Fether.ID, "quartz_ingot", 2, 0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.Lubricant,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1)))
                .duration(5 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(cutterRecipes);

        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.stone_slab, 1, 7))
                .itemOutputs(getModItem(Fether.ID, "quartz_ingot", 2, 0))
                .fluidInputs(
                        MaterialLibAPI.getFluidStack(
                                Materials2Materials.dimensionallyshiftedsuperfluid,
                                Materials2FluidShapes.fluidLiquid,
                                (int) (1)))
                .duration(2 * SECONDS).eut(TierEU.RECIPE_LV / 2).addTo(cutterRecipes);

        // Stripped Logs
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Fether.ID, "nether_log", 1, 0), ItemList.Shape_Extruder_Block.get(0L))
                .itemOutputs(getModItem(Fether.ID, "nether_log", 1, 2)).duration(6 * SECONDS).eut(80)
                .addTo(extruderRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Fether.ID, "nether_log", 1, 0), ItemList.Shape_Extruder_Block.get(0L))
                .itemOutputs(getModItem(Fether.ID, "nether_log", 1, 3)).duration(6 * SECONDS).eut(80)
                .addTo(extruderRecipes);

        removeOreDict("listAllmeatraw", getModItem(Fether.ID, "flesh_root", 1));
    }
}
