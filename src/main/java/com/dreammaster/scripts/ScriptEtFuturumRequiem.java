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

        final ItemStack PURPUR_BLOCK = getModItem(EtFuturumRequiem.ID, "purpur_block", 1, 0, missing);
        final ItemStack PURPUR_SLAB = getModItem(EtFuturumRequiem.ID, "purpur_slab", 1, 0, missing);

        final ItemStack SMOOTH_STONE_SLAB = getModItem(EtFuturumRequiem.ID, "stone_slab", 1, 0, missing);
        final ItemStack MOSSY_COBBLESTONE_SLAB = getModItem(EtFuturumRequiem.ID, "stone_slab", 1, 1, missing);
        final ItemStack MOSSY_STONE_BRICK_SLAB = getModItem(EtFuturumRequiem.ID, "stone_slab", 1, 2, missing);

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

        ItemStack crimsonWoodSlab = CRIMSON_WOOD_SLAB.copy();
        crimsonWoodSlab.stackSize = 2;
        addShapelessRecipe(crimsonWoodSlab, "craftingToolSaw", null, CRIMSON_WOOD_PLANKS, null);

        ItemStack warpedWoodSlab = WARPED_WOOD_SLAB.copy();
        warpedWoodSlab.stackSize = 2;
        addShapelessRecipe(warpedWoodSlab, "craftingToolSaw", null, WARPED_WOOD_PLANKS, null);

        ItemStack mangroveWoodSlab = MANGROVE_WOOD_SLAB.copy();
        mangroveWoodSlab.stackSize = 2;
        addShapelessRecipe(mangroveWoodSlab, "craftingToolSaw", null, MANGROVE_WOOD_PLANKS, null);

        ItemStack cherryWoodSlab = CHERRY_WOOD_SLAB.copy();
        cherryWoodSlab.stackSize = 2;
        addShapelessRecipe(cherryWoodSlab, "craftingToolSaw", null, CHERRY_WOOD_PLANKS, null);

        ItemStack bambooWoodSlab = BAMBOO_WOOD_SLAB.copy();
        bambooWoodSlab.stackSize = 2;
        addShapelessRecipe(bambooWoodSlab, "craftingToolSaw", null, BAMBOO_WOOD_PLANKS, null);

        ItemStack redSandstoneSlab = RED_SANDSTONE_SLAB.copy();
        redSandstoneSlab.stackSize = 2;
        addShapelessRecipe(redSandstoneSlab, "craftingToolSaw", null, RED_SANDSTONE, null);

        ItemStack purpurSlab = PURPUR_SLAB.copy();
        purpurSlab.stackSize = 2;
        addShapelessRecipe(purpurSlab, "craftingToolSaw", null, PURPUR_BLOCK, null);

        ItemStack smoothStoneSlab = SMOOTH_STONE_SLAB.copy();
        smoothStoneSlab.stackSize = 2;
        addShapelessRecipe(smoothStoneSlab, "craftingToolSaw", null, "stone", null);

        ItemStack mossyCobblestoneSlab = MOSSY_COBBLESTONE_SLAB.copy();
        mossyCobblestoneSlab.stackSize = 2;
        addShapelessRecipe(mossyCobblestoneSlab, "craftingToolSaw", null, getModItem(Minecraft.ID, "mossy_cobblestone", 1, 0, missing), null);
        
        ItemStack mossyStoneBrickSlab = MOSSY_STONE_BRICK_SLAB.copy();
        mossyStoneBrickSlab.stackSize = 2;
        addShapelessRecipe(mossyStoneBrickSlab, "craftingToolSaw", null, getModItem(Minecraft.ID, "stonebrick", 1, 1, missing), null);
    }
};