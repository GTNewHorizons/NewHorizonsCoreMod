package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.EtFuturumRequiem;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

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

        final ItemStack WARPED_STEM = getModItem(EtFuturumRequiem.ID, "warped_stem", 1, 0, missing);
        final ItemStack WARPED_WOOD = getModItem(EtFuturumRequiem.ID, "warped_stem", 1, 1, missing);
        final ItemStack STRIPPED_WARPED_STEM = getModItem(EtFuturumRequiem.ID, "warped_stem", 1, 2, missing);
        final ItemStack STRIPPED_WARPED_WOOD = getModItem(EtFuturumRequiem.ID, "warped_stem", 1, 3, missing);

        final ItemStack MANGROVE_LOG = getModItem(EtFuturumRequiem.ID, "mangrove_log", 1, 0, missing);
        final ItemStack MANGROVE_WOOD = getModItem(EtFuturumRequiem.ID, "mangrove_log", 1, 1, missing);
        final ItemStack STRIPPED_MANGROVE_LOG = getModItem(EtFuturumRequiem.ID, "mangrove_log", 1, 2, missing);
        final ItemStack STRIPPED_MANGROVE_WOOD = getModItem(EtFuturumRequiem.ID, "mangrove_log", 1, 3, missing);

        final ItemStack CHERRY_LOG = getModItem(EtFuturumRequiem.ID, "cherry_log", 1, 0, missing);
        final ItemStack CHERRY_WOOD = getModItem(EtFuturumRequiem.ID, "cherry_log", 1, 1, missing);
        final ItemStack STRIPPED_CHERRY_LOG = getModItem(EtFuturumRequiem.ID, "cherry_log", 1, 2, missing);
        final ItemStack STRIPPED_CHERRY_WOOD = getModItem(EtFuturumRequiem.ID, "cherry_log", 1, 3, missing);

        final ItemStack BAMBOO_BLOCK = getModItem(EtFuturumRequiem.ID, "bamboo_block", 1, 0, missing);

        final ItemStack CRIMSON_WOOD_PLANKS = getModItem(EtFuturumRequiem.ID, "wood_planks", 1, 0, missing);
        final ItemStack CRIMSON_WOOD_SLAB = getModItem(EtFuturumRequiem.ID, "wood_slab", 1, 0, missing);
    
        final ItemStack WARPED_WOOD_PLANKS = getModItem(EtFuturumRequiem.ID, "wood_planks", 1, 1, missing);
        final ItemStack WARPED_WOOD_SLAB = getModItem(EtFuturumRequiem.ID, "wood_slab", 1, 1, missing);

        final ItemStack MANGROVE_WOOD_PLANKS = getModItem(EtFuturumRequiem.ID, "wood_planks", 1, 2, missing);
        final ItemStack MANGROVE_WOOD_SLAB = getModItem(EtFuturumRequiem.ID, "wood_slab", 1, 2, missing);

        final ItemStack CHERRY_WOOD_PLANKS = getModItem(EtFuturumRequiem.ID, "wood_planks", 1, 3, missing);
        final ItemStack CHERRY_WOOD_SLAB = getModItem(EtFuturumRequiem.ID, "wood_slab", 1, 3, missing);

        final ItemStack BAMBOO_WOOD_PLANKS = getModItem(EtFuturumRequiem.ID, "wood_planks", 1, 4, missing);
        final ItemStack BAMBOO_WOOD_SLAB = getModItem(EtFuturumRequiem.ID, "wood_slab", 1, 4, missing);

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

        ItemStack crimsonWoodPlanks = CRIMSON_WOOD_PLANKS.copy();
        crimsonWoodPlanks.stackSize = 2;
        addShapelessRecipe(crimsonWoodPlanks, CRIMSON_STEM);

        ItemStack warpedWoodPlanks = WARPED_WOOD_PLANKS.copy();
        warpedWoodPlanks.stackSize = 2;
        addShapelessRecipe(warpedWoodPlanks, WARPED_STEM);

        ItemStack mangroveWoodPlanks = MANGROVE_WOOD_PLANKS.copy();
        mangroveWoodPlanks.stackSize = 2;
        addShapelessRecipe(mangroveWoodPlanks, MANGROVE_LOG);
        
        ItemStack cherryWoodPlanks = CHERRY_WOOD_PLANKS.copy();
        cherryWoodPlanks.stackSize = 2;
        addShapelessRecipe(cherryWoodPlanks, CHERRY_LOG);

        ItemStack bambooWoodPlanks = BAMBOO_WOOD_PLANKS.copy();
        bambooWoodPlanks.stackSize = 2;
        addShapelessRecipe(bambooWoodPlanks, BAMBOO_BLOCK);

        addSlabRecipe(CRIMSON_WOOD_SLAB, CRIMSON_WOOD_PLANKS);
        addSlabRecipe(WARPED_WOOD_SLAB, WARPED_WOOD_PLANKS);
        addSlabRecipe(MANGROVE_WOOD_SLAB, MANGROVE_WOOD_PLANKS);
        addSlabRecipe(CHERRY_WOOD_SLAB, CHERRY_WOOD_PLANKS);
        addSlabRecipe(BAMBOO_WOOD_SLAB, BAMBOO_WOOD_PLANKS);
        addSlabRecipe(RED_SANDSTONE_SLAB, RED_SANDSTONE);
        addSlabRecipe(CUT_RED_SANDSTONE_SLAB, CUT_RED_SANDSTONE);
        addSlabRecipe(PURPUR_SLAB, PURPUR_BLOCK);
        addSlabRecipe(SMOOTH_STONE_SLAB, "stone");
        addSlabRecipe(MOSSY_COBBLESTONE_SLAB, getModItem(Minecraft.ID, "mossy_cobblestone", 1, 0, missing));
        addSlabRecipe(MOSSY_STONE_BRICK_SLAB, getModItem(Minecraft.ID, "stonebrick", 1, 1, missing));
        addSlabRecipe(SMOOTH_QUARTZ_SLAB, SMOOTH_QUARTZ);
        addSlabRecipe(RED_NETHERBRICK_SLAB, RED_NETHERBRICK);
        addSlabRecipe(END_STONE_BRICK_SLAB, END_STONE_BRICK);
        addSlabRecipe(COBBLED_DEEPSLATE_SLAB, COBBLED_DEEPSLATE);
        addSlabRecipe(POLISHED_DEEPSLATE_SLAB, POLISHED_DEEPSLATE);
        addSlabRecipe(DEEPSLATE_BRICK_SLAB, DEEPSLATE_BRICKS);
        addSlabRecipe(DEEPSLATE_TILE_SLAB, DEEPSLATE_TILES);
        addSlabRecipe(TUFF_SLAB, TUFF);
        addSlabRecipe(POLISHED_TUFF_SLAB, POLISHED_TUFF);
        addSlabRecipe(TUFF_BRICK_SLAB, TUFF_BRICKS);
    }

    protected void addSlabRecipe(ItemStack result, Object ingredient) {
        ItemStack output = result.copy();
        output.stackSize = 2;
        addShapelessRecipe(output, "craftingToolSaw", null, ingredient, null);
    }
};