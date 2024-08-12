package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.EtFuturumRequiem;
import static gregtech.api.enums.Mods.GTPlusPlus;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

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

        final ItemStack CRIMSON_WOOD_PLANKS = getModItem(EtFuturumRequiem.ID, "wood_planks", 1, 0, missing);
        final ItemStack CRIMSON_WOOD_SLAB = GetModItem(EtFuturumRequiem.ID, "wood_slab", 1, 0, missing);
    
        final ItemStack WARPED_WOOD_PLANKS = getModItem(EtFuturumRequiem.ID, "wood_planks", 1, 1, missing);
        final ItemStack WARPED_WOOD_SLAB = getModItem(EtFuturumRequiem.ID, "wood_slab", 1, 1, missing);

        final ItemStack MANGROVE_WOOD_PLANKS = getModItem(EtFuturumRequiem.ID, "wood_planks", 1, 2, missing);
        final ItemStack MANGROVE_WOOD_SLAB = getModItem(EtFuturumRequiem.ID, "wood_slab", 1, 2, missing);

        final ItemStack CHERRY_WOOD_PLANKS = getModItem(EtFuturumRequiem.ID, "wood_planks", 1, 3, missing);
        final ItemStack BAMBOO_WOOD_PLANKS = getModItem(EtFuturumRequiem.ID, "wood_planks", 1, 4, missing);

        final ItemStack SMOOTH_STONE_SLAB = getModItem(EtFuturumRequiem.ID, "stone_slab", 1, 0, missing);

        ItemStack crimsonWoodPlanks = new ItemStack(CRIMSON_WOOD_PLANKS);
        crimsonWoodPlanks.stackSize = 2;
        addShapelessRecipe(crimsonWoodPlanks, CRIMSON_LOG);

        ItemStack warpedWoodPlanks = new ItemStack(WARPED_WOOD_PLANKS);
        warpedWoodPlanks.stackSize = 2;
        addShapelessRecipe(warpedWoodPlanks, WARPED_LOG);

        ItemStack mangroveWoodPlanks = new ItemStack(MANGROVE_WOOD_PLANKS);
        mangroveWoodPlanks.stackSize = 2;
        addShapelessRecipe(mangroveWoodPlanks, MANGROVE_LOG);
        
        ItemStack cherryWoodPlanks = new ItemStack(CHERRY_WOOD_PLANKS);
        cherryWoodPlanks.stackSize = 2;
        addShapelessRecipe(cherryWoodPlanks, CHERRY_LOG);

        ItemStack crimsonWoodSlab = new ItemStack(CRIMSON_WOOD_SLAB);
        crimsonWoodSlab.stackSize = 2;
        addShapelessRecipe(crimsonWoodSlab, "craftingToolSaw", null, CRIMSON_WOOD_PLANKS, null);

        ItemStack warpedWoodSlab = new ItemStack(WARPED_WOOD_SLAB);
        warpedWoodSlab.stackSize = 2;
        addShapelessRecipe(warpedWoodSlab, "craftingToolSaw", null, WARPED_WOOD_PLANKS, null);

        ItemStack mangroveWoodSlab = new ItemStack(MANGROVE_WOOD_SLAB);
        mangroveWoodSlab.stackSize = 2;
        addShapelessRecipe(mangroveWoodSlab, "craftingToolSaw", null, MANGROVE_WOOD_PLANKS, null);

        ItemStack cherryWoodSlab = new ItemStack(CHERRY_WOOD_SLAB);
        cherryWoodSlab.stackSize = 2;
        addShapelessRecipe(cherryWoodSlab, "craftingToolSaw", null, CHERRY_WOOD_PLANKS, null);

        ItemStack smoothStoneSlab = new ItemStack(SMOOTH_STONE_SLAB);
        smoothStoneSlab.stackSize = 2;
        addShapelessRecipe(getModItem(smoothStoneSlab, "craftingToolSaw", null, "stone", null);
    }
};