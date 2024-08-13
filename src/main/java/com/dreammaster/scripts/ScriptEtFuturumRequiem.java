package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.EtFuturumRequiem;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;
import static net.minecraftforge.fluids.FluidRegistry.getFluidStack;

import java.util.Arrays;
import java.util.List;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class ScriptEtFuturumRequiem implements IScriptLoader {
    @Override
    public String getScriptName() {
        return "Et Futurum Requiem";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
            EtFuturumRequiem.ID,
            GTPlusPlus.ID
        );
    }

    @Override
    public void loadRecipes() {
        final ItemStack CRIMSON_STEM = getModItem(EtFuturumRequiem.ID, "crimson_stem", 1, 0, missing);
        final ItemStack CRIMSON_WOOD = getModItem(EtFuturumRequiem.ID, "crimson_stem", 1, 1, missing);
        final ItemStack STRIPPED_CRIMSON_STEM = getModItem(EtFuturumRequiem.ID, "crimson_stem", 1, 2, missing);
        final ItemStack STRIPPED_CRIMSON_WOOD = getModItem(EtFuturumRequiem.ID, "crimson_stem", 1, 3, missing);
        final ItemStack CRIMSON_WOOD_PLANKS = getModItem(EtFuturumRequiem.ID, "wood_planks", 1, 0, missing);
        final ItemStack CRIMSON_WOOD_SLAB = getModItem(EtFuturumRequiem.ID, "wood_slab", 1, 0, missing);

        final ItemStack WARPED_STEM = getModItem(EtFuturumRequiem.ID, "warped_stem", 1, 0, missing);
        final ItemStack WARPED_WOOD = getModItem(EtFuturumRequiem.ID, "warped_stem", 1, 1, missing);
        final ItemStack STRIPPED_WARPED_STEM = getModItem(EtFuturumRequiem.ID, "warped_stem", 1, 2, missing);
        final ItemStack STRIPPED_WARPED_WOOD = getModItem(EtFuturumRequiem.ID, "warped_stem", 1, 3, missing);
        final ItemStack WARPED_WOOD_PLANKS = getModItem(EtFuturumRequiem.ID, "wood_planks", 1, 1, missing);
        final ItemStack WARPED_WOOD_SLAB = getModItem(EtFuturumRequiem.ID, "wood_slab", 1, 1, missing);

        final ItemStack MANGROVE_LOG = getModItem(EtFuturumRequiem.ID, "mangrove_log", 1, 0, missing);
        final ItemStack MANGROVE_WOOD = getModItem(EtFuturumRequiem.ID, "mangrove_log", 1, 1, missing);
        final ItemStack STRIPPED_MANGROVE_LOG = getModItem(EtFuturumRequiem.ID, "mangrove_log", 1, 2, missing);
        final ItemStack STRIPPED_MANGROVE_WOOD = getModItem(EtFuturumRequiem.ID, "mangrove_log", 1, 3, missing);
        final ItemStack MANGROVE_WOOD_PLANKS = getModItem(EtFuturumRequiem.ID, "wood_planks", 1, 2, missing);
        final ItemStack MANGROVE_WOOD_SLAB = getModItem(EtFuturumRequiem.ID, "wood_slab", 1, 2, missing);

        final ItemStack CHERRY_LOG = getModItem(EtFuturumRequiem.ID, "cherry_log", 1, 0, missing);
        final ItemStack CHERRY_WOOD = getModItem(EtFuturumRequiem.ID, "cherry_log", 1, 1, missing);
        final ItemStack STRIPPED_CHERRY_LOG = getModItem(EtFuturumRequiem.ID, "cherry_log", 1, 2, missing);
        final ItemStack STRIPPED_CHERRY_WOOD = getModItem(EtFuturumRequiem.ID, "cherry_log", 1, 3, missing);
        final ItemStack CHERRY_WOOD_PLANKS = getModItem(EtFuturumRequiem.ID, "wood_planks", 1, 3, missing);
        final ItemStack CHERRY_WOOD_SLAB = getModItem(EtFuturumRequiem.ID, "wood_slab", 1, 3, missing);

        final ItemStack BAMBOO_BLOCK = getModItem(EtFuturumRequiem.ID, "bamboo_block", 1, 0, missing);
        final ItemStack BAMBOO_WOOD_PLANKS = getModItem(EtFuturumRequiem.ID, "wood_planks", 1, 4, missing);
        final ItemStack BAMBOO_WOOD_SLAB = getModItem(EtFuturumRequiem.ID, "wood_slab", 1, 4, missing);
        final ItemStack BAMBOO_MOSAIC = getModItem(EtFuturumRequiem.ID, "bamboo_mosaic", 1, 0, missing);
        final ItemStack BAMBOO_MOSAIC_SLAB = getModItem(EtFuturumRequiem.ID, "bamboo_mosaic_slab", 1, 0, missing);

        final ItemStack RED_SANDSTONE = getModItem(EtFuturumRequiem.ID, "red_sandstone", 1, 0, missing);
        final ItemStack RED_SANDSTONE_SLAB = getModItem(EtFuturumRequiem.ID, "red_sandstone_slab", 1, 0, missing);
        final ItemStack CUT_RED_SANDSTONE = getModItem(EtFuturumRequiem.ID, "red_sandstone", 1, 2, missing);
        final ItemStack CUT_RED_SANDSTONE_SLAB = getModItem(EtFuturumRequiem.ID, "red_sandstone_slab", 1, 1, missing);

        final ItemStack PURPUR_BLOCK = getModItem(EtFuturumRequiem.ID, "purpur_block", 1, 0, missing);
        final ItemStack PURPUR_SLAB = getModItem(EtFuturumRequiem.ID, "purpur_slab", 1, 0, missing);

        final ItemStack SMOOTH_STONE_SLAB = getModItem(EtFuturumRequiem.ID, "stone_slab", 1, 0, missing);
        final ItemStack MOSSY_COBBLESTONE_SLAB = getModItem(EtFuturumRequiem.ID, "stone_slab", 1, 1, missing);
        final ItemStack MOSSY_STONE_BRICK_SLAB = getModItem(EtFuturumRequiem.ID, "stone_slab", 1, 2, missing);

        final ItemStack SMOOTH_QUARTZ = getModItem(EtFuturumRequiem.ID, "smooth_quartz", 1, 0, missing);
        final ItemStack SMOOTH_QUARTZ_SLAB = getModItem(EtFuturumRequiem.ID, "smooth_quartz_slab", 1, 0, missing);

        final ItemStack RED_NETHERBRICK = getModItem(EtFuturumRequiem.ID, "red_netherbrick", 1, 0, missing);
        final ItemStack RED_NETHERBRICK_SLAB = getModItem(EtFuturumRequiem.ID, "red_netherbrick_slab", 1, 0, missing);

        final ItemStack END_STONE_BRICK = getModItem(EtFuturumRequiem.ID, "end_bricks", 1, 0, missing);
        final ItemStack END_STONE_BRICK_SLAB = getModItem(EtFuturumRequiem.ID, "end_brick_slab", 1, 0, missing);

        final ItemStack COBBLED_DEEPSLATE = getModItem(EtFuturumRequiem.ID, "cobbled_deepslate", 1, 0, missing);
        final ItemStack POLISHED_DEEPSLATE = getModItem(EtFuturumRequiem.ID, "polished_deepslate", 1, 0, missing);
        final ItemStack DEEPSLATE_BRICKS = getModItem(EtFuturumRequiem.ID, "deepslate_bricks", 1, 0, missing);
        final ItemStack DEEPSLATE_TILES = getModItem(EtFuturumRequiem.ID, "deepslate_bricks", 1, 2, missing);
        final ItemStack COBBLED_DEEPSLATE_SLAB = getModItem(EtFuturumRequiem.ID, "deepslate_slab", 1, 0, missing);
        final ItemStack POLISHED_DEEPSLATE_SLAB = getModItem(EtFuturumRequiem.ID, "deepslate_slab", 1, 1, missing);
        final ItemStack DEEPSLATE_BRICK_SLAB = getModItem(EtFuturumRequiem.ID, "deepslate_brick_slab", 1, 0, missing);
        final ItemStack DEEPSLATE_TILE_SLAB = getModItem(EtFuturumRequiem.ID, "deepslate_brick_slab", 1, 1, missing);

        final ItemStack TUFF = getModItem(EtFuturumRequiem.ID, "tuff", 1, 0, missing);
        final ItemStack POLISHED_TUFF = getModItem(EtFuturumRequiem.ID, "tuff", 1, 1, missing);
        final ItemStack TUFF_BRICKS = getModItem(EtFuturumRequiem.ID, "tuff", 1, 2, missing);
        final ItemStack TUFF_SLAB = getModItem(EtFuturumRequiem.ID, "tuff_slab", 1, 0, missing);
        final ItemStack POLISHED_TUFF_SLAB = getModItem(EtFuturumRequiem.ID, "tuff_slab", 1, 1, missing);
        final ItemStack TUFF_BRICK_SLAB = getModItem(EtFuturumRequiem.ID, "tuff_slab", 1, 2, missing);

        final ItemStack MUD_BRICKS = getModItem(EtFuturumRequiem.ID, "packed_mud", 1, 1, missing);
        final ItemStack MUD_BRICK_SLAB = getModItem(EtFuturumRequiem.ID, "mud_brick_slab", 1, 0, missing);

        final ItemStack CUT_COPPER = getModItem(EtFuturumRequiem.ID, "copper_block", 1, 4, missing);
        final ItemStack CUT_COPPER_SLAB = getModItem(EtFuturumRequiem.ID, "cut_copper_slab", 1, 0, missing);

        final ItemStack BLACKSTONE = getModItem(EtFuturumRequiem.ID, "blackstone", 1, 0, missing);
        final ItemStack POLISHED_BLACKSTONE  = getModItem(EtFuturumRequiem.ID, "blackstone", 1, 1, missing);
        final ItemStack POLISHED_BLACKSTONE_BRICKS  = getModItem(EtFuturumRequiem.ID, "blackstone", 1, 2, missing);
        final ItemStack BLACKSTONE_SLAB = getModItem(EtFuturumRequiem.ID, "blackstone_slab", 1, 0, missing);
        final ItemStack POLISHED_BLACKSTONE_SLAB = getModItem(EtFuturumRequiem.ID, "blackstone_slab", 1, 1, missing);
        final ItemStack POLISHED_BLACKSTONE_BRICK_SLAB = getModItem(EtFuturumRequiem.ID, "blackstone_slab", 1, 2, missing);

        addPlankRecipes(CRIMSON_WOOD_PLANKS, CRIMSON_STEM);
        addPlankRecipes(WARPED_WOOD_PLANKS, WARPED_STEM);
        addPlankRecipes(MANGROVE_WOOD_PLANKS, MANGROVE_LOG);
        addPlankRecipes(CHERRY_WOOD_PLANKS, CHERRY_LOG);
        addPlankRecipes(BAMBOO_WOOD_PLANKS, BAMBOO_BLOCK);

        addSlabRecipes(CRIMSON_WOOD_SLAB, CRIMSON_WOOD_PLANKS);
        addSlabRecipes(WARPED_WOOD_SLAB, WARPED_WOOD_PLANKS);
        addSlabRecipes(MANGROVE_WOOD_SLAB, MANGROVE_WOOD_PLANKS);
        addSlabRecipes(CHERRY_WOOD_SLAB, CHERRY_WOOD_PLANKS);
        addSlabRecipes(BAMBOO_WOOD_SLAB, BAMBOO_WOOD_PLANKS);
        addSlabRecipes(RED_SANDSTONE_SLAB, RED_SANDSTONE);
        addSlabRecipes(CUT_RED_SANDSTONE_SLAB, CUT_RED_SANDSTONE);
        addSlabRecipes(PURPUR_SLAB, PURPUR_BLOCK);
        addSlabRecipes(SMOOTH_STONE_SLAB, getModItem(Minecraft.ID, "stone", 1, 0, missing));
        addSlabRecipes(MOSSY_COBBLESTONE_SLAB, getModItem(Minecraft.ID, "mossy_cobblestone", 1, 0, missing));
        addSlabRecipes(MOSSY_STONE_BRICK_SLAB, getModItem(Minecraft.ID, "stonebrick", 1, 1, missing));
        addSlabRecipes(SMOOTH_QUARTZ_SLAB, SMOOTH_QUARTZ);
        addSlabRecipes(RED_NETHERBRICK_SLAB, RED_NETHERBRICK);
        addSlabRecipes(END_STONE_BRICK_SLAB, END_STONE_BRICK);
        addSlabRecipes(COBBLED_DEEPSLATE_SLAB, COBBLED_DEEPSLATE);
        addSlabRecipes(POLISHED_DEEPSLATE_SLAB, POLISHED_DEEPSLATE);
        addSlabRecipes(DEEPSLATE_BRICK_SLAB, DEEPSLATE_BRICKS);
        addSlabRecipes(DEEPSLATE_TILE_SLAB, DEEPSLATE_TILES);
        addSlabRecipes(TUFF_SLAB, TUFF);
        addSlabRecipes(POLISHED_TUFF_SLAB, POLISHED_TUFF);
        addSlabRecipes(TUFF_BRICK_SLAB, TUFF_BRICKS);
        addSlabRecipes(MUD_BRICK_SLAB, MUD_BRICKS);
        addSlabRecipes(CUT_COPPER_SLAB, CUT_COPPER);
        addSlabRecipes(BLACKSTONE_SLAB, BLACKSTONE);
        addSlabRecipes(POLISHED_BLACKSTONE_SLAB, POLISHED_BLACKSTONE);
        addSlabRecipes(POLISHED_BLACKSTONE_BRICK_SLAB, POLISHED_BLACKSTONE_BRICKS);
    }

    protected void addPlankRecipes(ItemStack result, ItemStack ingredient) {
        ItemStack outputShapeless = result.copy();
        outputShapeless.stackSize = 2;
        addShapelessRecipe(outputShapeless, ingredient);

        ItemStack outputSaw = result.copy();
        outputSaw.stackSize = 4;
        addShapedRecipe(outputSaw, ingredient, "craftingToolSaw", null, null);

        ItemStack outputCutterLubricant = result.copy();
        outputCutterLubricant.stackSize = 6;
        ItemStack sawdustCutterLubricant = getModItem(GregTech.ID, "gt.metaitem.01", 1, 1809);
        GT_Values.RA.stdBuilder().itemInputs(ingredient)
            .itemOutputs(outputCutterLubricant, sawdustCutterLubricant)
            .fluidInputs(getFluidStack("lubricant", 1))
            .duration(10 * SECONDS).eut(7)
            .addTo(cutterRecipes);

        ItemStack outputCutterWater = result.copy();
        outputCutterWater.stackSize = 4;
        ItemStack sawdustCutterWater = getModItem(GregTech.ID, "gt.metaitem.01", 2, 1809);
        GT_Values.RA.stdBuilder().itemInputs(ingredient)
                .itemOutputs(outputCutterWater, sawdustCutterWater)
                .fluidInputs(getFluidStack("ic2distilledwater", 3))
                .duration(20 * SECONDS).eut(7)
                .addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ingredient)
                .itemOutputs(outputCutterWater, sawdustCutterWater)
                .fluidInputs(Materials.Water.getFluid(5))
                .duration(20 * SECONDS).eut(7)
                .addTo(cutterRecipes);

    }

    protected void addSlabRecipes(ItemStack result, ItemStack ingredient) {
        ItemStack output = result.copy();
        output.stackSize = 2;
        addShapelessRecipe(output, "craftingToolSaw", null, ingredient, null);

        GT_Values.RA.stdBuilder().itemInputs(ingredient)
                .itemOutputs(output)
                .fluidInputs(getFluidStack("lubricant", 1))
                .duration(1 * SECONDS + 5 * TICKS).eut(7)
                .addTo(cutterRecipes);

        GT_Values.RA.stdBuilder().itemInputs(ingredient)
                .itemOutputs(output)
                .fluidInputs(getFluidStack("ic2distilledwater", 3))
                .duration(2 * SECONDS + 10 * TICKS).eut(7)
                .addTo(cutterRecipes);
        
        GT_Values.RA.stdBuilder().itemInputs(ingredient)
                .itemOutputs(output)
                .fluidInputs(Materials.Water.getFluid(4))
                .duration(2 * SECONDS + 10 * TICKS).eut(7)
                .addTo(cutterRecipes);
    }
};