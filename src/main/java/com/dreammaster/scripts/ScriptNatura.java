package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.*;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.chisel.ChiselHelper;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Mods;
import gregtech.api.util.GT_ModHandler;

public class ScriptNatura implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Natura";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.Natura.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessCraftingRecipe(
                getModItem("Natura", "barleyFood", 1, 3, missing),
                new Object[] { getModItem("harvestcraft", "cottonItem", 1, 0, missing),
                        getModItem("harvestcraft", "cottonItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "barley.seed", 1, 1, missing),
                new Object[] { getModItem("Natura", "barleyFood", 1, 3, missing) });
        addShapedRecipe(
                getModItem("minecraft", "leather", 1, 0, missing),
                new Object[] { getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("Natura", "barleyFood", 1, 6, missing),
                        getModItem("Natura", "barleyFood", 1, 6, missing),
                        getModItem("Natura", "barleyFood", 1, 6, missing),
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing),
                        getModItem("minecraft", "string", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 4, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing),
                        getModItem("Natura", "tree", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 2, 0, missing),
                new Object[] { getModItem("Natura", "tree", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "natura.stick", 2, 0, missing),
                new Object[] { getModItem("Natura", "planks", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "natura.stick", 4, 0, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem("Natura", "planks", 1, 0, missing), null, null,
                        getModItem("Natura", "planks", 1, 0, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "Natura.workbench", 1, 0, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem("Natura", "tree", 1, 0, missing),
                        getModItem("Natura", "tree", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 1, 0, missing),
                new Object[] { getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "plankSlab1", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "planks", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.eucalyptus", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem("Natura", "planks", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing), getModItem("Natura", "planks", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.eucalyptus", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "planks", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing), getModItem("Natura", "planks", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.eucalyptus", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "planks", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing), getModItem("Natura", "planks", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "pressureplate.eucalyptus", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem("Natura", "plankSlab1", 1, 0, missing), "springAnyIron",
                        getModItem("Natura", "plankSlab1", 1, 0, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.eucalyptus", 1, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "plankSlab1", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing), "itemFlint",
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "plankSlab1", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "plankSlab1", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.eucalyptus", 2, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "plankSlab1", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing), "screwIron",
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "plankSlab1", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "plankSlab1", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.eucalyptus", 3, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "plankSlab1", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing), "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "plankSlab1", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 0, missing),
                        getModItem("Natura", "plankSlab1", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "button.eucalyptus", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "pressureplate.eucalyptus", 1, 0, missing),
                        null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 4, 1, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing),
                        getModItem("Natura", "tree", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 2, 1, missing),
                new Object[] { getModItem("Natura", "tree", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "natura.stick", 2, 1, missing),
                new Object[] { getModItem("Natura", "planks", 1, 1, missing),
                        getModItem("Natura", "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "natura.stick", 4, 1, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem("Natura", "planks", 1, 1, missing), null, null,
                        getModItem("Natura", "planks", 1, 1, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "Natura.workbench", 1, 1, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem("Natura", "tree", 1, 1, missing),
                        getModItem("Natura", "tree", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 1, 1, missing),
                new Object[] { getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "planks", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "planks", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "planks", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 2, 1, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "planks", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "planks", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 4, 1, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "planks", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "planks", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "plankSlab1", 2, 1, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "planks", 1, 1, missing), null });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.sakura", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem("Natura", "planks", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "planks", 1, 1, missing), getModItem("Natura", "planks", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.sakura", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "planks", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "planks", 1, 1, missing), getModItem("Natura", "planks", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.sakura", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "planks", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "planks", 1, 1, missing), getModItem("Natura", "planks", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "stair.sakura", 4, 0, missing),
                new Object[] { getModItem("Natura", "planks", 1, 1, missing), null, null,
                        getModItem("Natura", "planks", 1, 1, missing), getModItem("Natura", "planks", 1, 1, missing),
                        null, getModItem("Natura", "planks", 1, 1, missing),
                        getModItem("Natura", "planks", 1, 1, missing), getModItem("Natura", "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "pressureplate.sakura", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem("Natura", "plankSlab1", 1, 1, missing), "springAnyIron",
                        getModItem("Natura", "plankSlab1", 1, 1, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.sakura", 1, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "plankSlab1", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing), "itemFlint",
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "plankSlab1", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "plankSlab1", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.sakura", 2, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "plankSlab1", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing), "screwIron",
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "plankSlab1", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "plankSlab1", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.sakura", 3, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "plankSlab1", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing), "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "plankSlab1", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 1, missing),
                        getModItem("Natura", "plankSlab1", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "button.sakura", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "pressureplate.sakura", 1, 0, missing), null });
        addShapedRecipe(
                getModItem("Natura", "natura.emptybowl", 1, 2, missing),
                new Object[] { getModItem("Natura", "planks", 1, 2, missing), "craftingToolKnife" });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 4, 2, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing),
                        getModItem("Natura", "tree", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 2, 2, missing),
                new Object[] { getModItem("Natura", "tree", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "natura.stick", 2, 2, missing),
                new Object[] { getModItem("Natura", "planks", 1, 2, missing),
                        getModItem("Natura", "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "natura.stick", 4, 2, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem("Natura", "planks", 1, 2, missing), null, null,
                        getModItem("Natura", "planks", 1, 2, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "Natura.workbench", 1, 2, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem("Natura", "tree", 1, 2, missing),
                        getModItem("Natura", "tree", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 1, 2, missing),
                new Object[] { getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "planks", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "planks", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "planks", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 2, 2, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "planks", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "planks", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 4, 2, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "planks", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "planks", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "plankSlab1", 2, 2, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "planks", 1, 2, missing), null });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.ghostwood", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem("Natura", "planks", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "planks", 1, 2, missing), getModItem("Natura", "planks", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.ghostwood", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "planks", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "planks", 1, 2, missing), getModItem("Natura", "planks", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.ghostwood", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "planks", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "planks", 1, 2, missing), getModItem("Natura", "planks", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "stair.ghostwood", 4, 0, missing),
                new Object[] { getModItem("Natura", "planks", 1, 2, missing), null, null,
                        getModItem("Natura", "planks", 1, 2, missing), getModItem("Natura", "planks", 1, 2, missing),
                        null, getModItem("Natura", "planks", 1, 2, missing),
                        getModItem("Natura", "planks", 1, 2, missing), getModItem("Natura", "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "pressureplate.ghostwood", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem("Natura", "plankSlab1", 1, 2, missing), "springAnyIron",
                        getModItem("Natura", "plankSlab1", 1, 2, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.ghostwood", 1, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "plankSlab1", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing), "itemFlint",
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "plankSlab1", 1, 2, missing), "stickWood",
                        getModItem("Natura", "plankSlab1", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.ghostwood", 2, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "plankSlab1", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing), "screwIron",
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "plankSlab1", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "plankSlab1", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.ghostwood", 3, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "plankSlab1", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing), "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "plankSlab1", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 2, missing),
                        getModItem("Natura", "plankSlab1", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "button.ghostwood", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "pressureplate.ghostwood", 1, 0, missing),
                        null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 4, 3, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing),
                        getModItem("Natura", "redwood", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 2, 3, missing),
                new Object[] { getModItem("Natura", "redwood", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "natura.stick", 2, 3, missing),
                new Object[] { getModItem("Natura", "planks", 1, 3, missing),
                        getModItem("Natura", "planks", 1, 3, missing) });
        addShapedRecipe(
                getModItem("Natura", "natura.stick", 4, 3, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem("Natura", "planks", 1, 3, missing), null, null,
                        getModItem("Natura", "planks", 1, 3, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "Natura.workbench", 1, 3, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem("Natura", "redwood", 1, 1, missing),
                        getModItem("Natura", "redwood", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 1, 3, missing),
                new Object[] { getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "planks", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "planks", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "planks", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 2, 3, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "planks", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "planks", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 4, 3, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "planks", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "planks", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing) });
        addShapedRecipe(
                getModItem("Natura", "plankSlab1", 2, 3, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "planks", 1, 3, missing), null });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.redwood", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem("Natura", "planks", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "planks", 1, 3, missing), getModItem("Natura", "planks", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "planks", 1, 3, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.redwood", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "planks", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "planks", 1, 3, missing), getModItem("Natura", "planks", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "planks", 1, 3, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.redwood", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "planks", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "planks", 1, 3, missing), getModItem("Natura", "planks", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "planks", 1, 3, missing) });
        addShapedRecipe(
                getModItem("Natura", "stair.redwood", 4, 0, missing),
                new Object[] { getModItem("Natura", "planks", 1, 3, missing), null, null,
                        getModItem("Natura", "planks", 1, 3, missing), getModItem("Natura", "planks", 1, 3, missing),
                        null, getModItem("Natura", "planks", 1, 3, missing),
                        getModItem("Natura", "planks", 1, 3, missing), getModItem("Natura", "planks", 1, 3, missing) });
        addShapedRecipe(
                getModItem("Natura", "pressureplate.redwood", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem("Natura", "plankSlab1", 1, 3, missing), "springAnyIron",
                        getModItem("Natura", "plankSlab1", 1, 3, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.redwood", 1, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "plankSlab1", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing), "itemFlint",
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "plankSlab1", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "plankSlab1", 1, 3, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.redwood", 2, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "plankSlab1", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing), "screwIron",
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "plankSlab1", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "plankSlab1", 1, 3, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.redwood", 3, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "plankSlab1", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing), "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "plankSlab1", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 3, missing),
                        getModItem("Natura", "plankSlab1", 1, 3, missing) });
        addShapedRecipe(
                getModItem("Natura", "button.redwood", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "pressureplate.redwood", 1, 0, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 4, 4, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing),
                        getModItem("Natura", "bloodwood", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 2, 4, missing),
                new Object[] { getModItem("Natura", "bloodwood", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 4, 4, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing),
                        getModItem("Natura", "bloodwood", 1, 15, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 2, 4, missing),
                new Object[] { getModItem("Natura", "bloodwood", 1, 15, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 4, 4, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing),
                        getModItem("Natura", "bloodwood", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "natura.stick", 2, 4, missing),
                new Object[] { getModItem("Natura", "planks", 1, 4, missing),
                        getModItem("Natura", "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "natura.stick", 4, 4, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem("Natura", "planks", 1, 4, missing), null, null,
                        getModItem("Natura", "planks", 1, 4, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "Natura.workbench", 1, 4, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem("Natura", "bloodwood", 1, 0, missing),
                        getModItem("Natura", "bloodwood", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "Natura.workbench", 1, 4, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem("Natura", "bloodwood", 1, 15, missing),
                        getModItem("Natura", "bloodwood", 1, 15, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 1, 4, missing),
                new Object[] { getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "planks", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "planks", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "planks", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 2, 4, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "planks", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "planks", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 4, 4, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "planks", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "planks", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "plankSlab1", 2, 4, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "planks", 1, 4, missing), null });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.bloodwood", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem("Natura", "planks", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "planks", 1, 4, missing), getModItem("Natura", "planks", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.bloodwood", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "planks", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "planks", 1, 4, missing), getModItem("Natura", "planks", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.bloodwood", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "planks", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "planks", 1, 4, missing), getModItem("Natura", "planks", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "stair.bloodwood", 4, 0, missing),
                new Object[] { getModItem("Natura", "planks", 1, 4, missing), null, null,
                        getModItem("Natura", "planks", 1, 4, missing), getModItem("Natura", "planks", 1, 4, missing),
                        null, getModItem("Natura", "planks", 1, 4, missing),
                        getModItem("Natura", "planks", 1, 4, missing), getModItem("Natura", "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "pressureplate.bloodwood", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem("Natura", "plankSlab1", 1, 4, missing), "springAnyIron",
                        getModItem("Natura", "plankSlab1", 1, 4, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.bloodwood", 1, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "plankSlab1", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing), "itemFlint",
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "plankSlab1", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "plankSlab1", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.bloodwood", 2, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "plankSlab1", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing), "screwIron",
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "plankSlab1", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "plankSlab1", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.bloodwood", 3, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "plankSlab1", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing), "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "plankSlab1", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 4, missing),
                        getModItem("Natura", "plankSlab1", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "button.bloodwood", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "pressureplate.bloodwood", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem("Natura", "natura.emptybowl", 1, 4, missing),
                new Object[] { getModItem("Natura", "planks", 1, 4, missing), "craftingToolKnife" });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 4, 5, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing),
                        getModItem("Natura", "tree", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 2, 5, missing),
                new Object[] { getModItem("Natura", "tree", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "natura.stick", 2, 5, missing),
                new Object[] { getModItem("Natura", "planks", 1, 5, missing),
                        getModItem("Natura", "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem("Natura", "natura.stick", 4, 5, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem("Natura", "planks", 1, 5, missing), null, null,
                        getModItem("Natura", "planks", 1, 5, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "Natura.workbench", 1, 5, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem("Natura", "tree", 1, 3, missing),
                        getModItem("Natura", "tree", 1, 3, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 1, 5, missing),
                new Object[] { getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "planks", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "planks", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "planks", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 2, 5, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "planks", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "planks", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 4, 5, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "planks", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "planks", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing) });
        addShapedRecipe(
                getModItem("Natura", "plankSlab1", 2, 5, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "planks", 1, 5, missing), null });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.hopseed", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem("Natura", "planks", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "planks", 1, 5, missing), getModItem("Natura", "planks", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.hopseed", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "planks", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "planks", 1, 5, missing), getModItem("Natura", "planks", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.hopseed", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "planks", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "planks", 1, 5, missing), getModItem("Natura", "planks", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem("Natura", "stair.hopseed", 4, 0, missing),
                new Object[] { getModItem("Natura", "planks", 1, 5, missing), null, null,
                        getModItem("Natura", "planks", 1, 5, missing), getModItem("Natura", "planks", 1, 5, missing),
                        null, getModItem("Natura", "planks", 1, 5, missing),
                        getModItem("Natura", "planks", 1, 5, missing), getModItem("Natura", "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem("Natura", "pressureplate.hopseed", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem("Natura", "plankSlab1", 1, 5, missing), "springAnyIron",
                        getModItem("Natura", "plankSlab1", 1, 5, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.hopseed", 1, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "plankSlab1", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing), "itemFlint",
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "plankSlab1", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "plankSlab1", 1, 5, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.hopseed", 2, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "plankSlab1", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing), "screwIron",
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "plankSlab1", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "plankSlab1", 1, 5, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.hopseed", 3, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "plankSlab1", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing), "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "plankSlab1", 1, 5, missing),
                        getModItem("Natura", "natura.stick", 1, 5, missing),
                        getModItem("Natura", "plankSlab1", 1, 5, missing) });
        addShapedRecipe(
                getModItem("Natura", "button.hopseed", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "pressureplate.hopseed", 1, 0, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 4, 6, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing),
                        getModItem("Natura", "Rare Tree", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 2, 6, missing),
                new Object[] { getModItem("Natura", "Rare Tree", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "natura.stick", 2, 6, missing),
                new Object[] { getModItem("Natura", "planks", 1, 6, missing),
                        getModItem("Natura", "planks", 1, 6, missing) });
        addShapedRecipe(
                getModItem("Natura", "natura.stick", 4, 6, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem("Natura", "planks", 1, 6, missing), null, null,
                        getModItem("Natura", "planks", 1, 6, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "Natura.workbench", 1, 6, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem("Natura", "Rare Tree", 1, 0, missing),
                        getModItem("Natura", "Rare Tree", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 1, 6, missing),
                new Object[] { getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "planks", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "planks", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "planks", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 2, 6, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "planks", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "planks", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 4, 6, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "planks", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "planks", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing) });
        addShapedRecipe(
                getModItem("Natura", "plankSlab1", 2, 6, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "planks", 1, 6, missing), null });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.maple", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem("Natura", "planks", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "planks", 1, 6, missing), getModItem("Natura", "planks", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "planks", 1, 6, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.maple", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "planks", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "planks", 1, 6, missing), getModItem("Natura", "planks", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "planks", 1, 6, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.maple", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "planks", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "planks", 1, 6, missing), getModItem("Natura", "planks", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "planks", 1, 6, missing) });
        addShapedRecipe(
                getModItem("Natura", "stair.maple", 4, 0, missing),
                new Object[] { getModItem("Natura", "planks", 1, 6, missing), null, null,
                        getModItem("Natura", "planks", 1, 6, missing), getModItem("Natura", "planks", 1, 6, missing),
                        null, getModItem("Natura", "planks", 1, 6, missing),
                        getModItem("Natura", "planks", 1, 6, missing), getModItem("Natura", "planks", 1, 6, missing) });
        addShapedRecipe(
                getModItem("Natura", "pressureplate.maple", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem("Natura", "plankSlab1", 1, 6, missing), "springAnyIron",
                        getModItem("Natura", "plankSlab1", 1, 6, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.maple", 1, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "plankSlab1", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing), "itemFlint",
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "plankSlab1", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "plankSlab1", 1, 6, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.maple", 2, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "plankSlab1", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing), "screwIron",
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "plankSlab1", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "plankSlab1", 1, 6, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.maple", 3, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "plankSlab1", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing), "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "plankSlab1", 1, 6, missing),
                        getModItem("Natura", "natura.stick", 1, 6, missing),
                        getModItem("Natura", "plankSlab1", 1, 6, missing) });
        addShapedRecipe(
                getModItem("Natura", "button.maple", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "pressureplate.maple", 1, 0, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 4, 7, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing),
                        getModItem("Natura", "Rare Tree", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 2, 7, missing),
                new Object[] { getModItem("Natura", "Rare Tree", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "natura.stick", 2, 7, missing),
                new Object[] { getModItem("Natura", "planks", 1, 7, missing),
                        getModItem("Natura", "planks", 1, 7, missing) });
        addShapedRecipe(
                getModItem("Natura", "natura.stick", 4, 7, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem("Natura", "planks", 1, 7, missing), null, null,
                        getModItem("Natura", "planks", 1, 7, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "Natura.workbench", 1, 7, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem("Natura", "Rare Tree", 1, 1, missing),
                        getModItem("Natura", "Rare Tree", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 1, 7, missing),
                new Object[] { getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "planks", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "planks", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "planks", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 2, 7, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "planks", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "planks", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 4, 7, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "planks", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "planks", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing) });
        addShapedRecipe(
                getModItem("Natura", "plankSlab1", 2, 7, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "planks", 1, 7, missing), null });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.silverbell", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem("Natura", "planks", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "planks", 1, 7, missing), getModItem("Natura", "planks", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "planks", 1, 7, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.silverbell", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "planks", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "planks", 1, 7, missing), getModItem("Natura", "planks", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "planks", 1, 7, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.silverbell", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "planks", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "planks", 1, 7, missing), getModItem("Natura", "planks", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "planks", 1, 7, missing) });
        addShapedRecipe(
                getModItem("Natura", "stair.silverbell", 4, 0, missing),
                new Object[] { getModItem("Natura", "planks", 1, 7, missing), null, null,
                        getModItem("Natura", "planks", 1, 7, missing), getModItem("Natura", "planks", 1, 7, missing),
                        null, getModItem("Natura", "planks", 1, 7, missing),
                        getModItem("Natura", "planks", 1, 7, missing), getModItem("Natura", "planks", 1, 7, missing) });
        addShapedRecipe(
                getModItem("Natura", "pressureplate.silverbell", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem("Natura", "plankSlab1", 1, 7, missing), "springAnyIron",
                        getModItem("Natura", "plankSlab1", 1, 7, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.silverbell", 1, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "plankSlab1", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing), "itemFlint",
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "plankSlab1", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "plankSlab1", 1, 7, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.silverbell", 2, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "plankSlab1", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing), "screwIron",
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "plankSlab1", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "plankSlab1", 1, 7, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.silverbell", 3, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab1", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "plankSlab1", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing), "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "plankSlab1", 1, 7, missing),
                        getModItem("Natura", "natura.stick", 1, 7, missing),
                        getModItem("Natura", "plankSlab1", 1, 7, missing) });
        addShapedRecipe(
                getModItem("Natura", "button.silverbell", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "pressureplate.silverbell", 1, 0, missing),
                        null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 4, 8, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing),
                        getModItem("Natura", "Rare Tree", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 2, 8, missing),
                new Object[] { getModItem("Natura", "Rare Tree", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "natura.stick", 2, 8, missing),
                new Object[] { getModItem("Natura", "planks", 1, 8, missing),
                        getModItem("Natura", "planks", 1, 8, missing) });
        addShapedRecipe(
                getModItem("Natura", "natura.stick", 4, 8, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem("Natura", "planks", 1, 8, missing), null, null,
                        getModItem("Natura", "planks", 1, 8, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "Natura.workbench", 1, 8, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem("Natura", "Rare Tree", 1, 2, missing),
                        getModItem("Natura", "Rare Tree", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 1, 8, missing),
                new Object[] { getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "planks", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "planks", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "planks", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 2, 8, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "planks", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "planks", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 4, 8, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "planks", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "planks", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing) });
        addShapedRecipe(
                getModItem("Natura", "plankSlab2", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "planks", 1, 8, missing), null });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.amaranth", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem("Natura", "planks", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "planks", 1, 8, missing), getModItem("Natura", "planks", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "planks", 1, 8, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.amaranth", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "planks", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "planks", 1, 8, missing), getModItem("Natura", "planks", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "planks", 1, 8, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.amaranth", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "planks", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "planks", 1, 8, missing), getModItem("Natura", "planks", 1, 8, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "planks", 1, 8, missing) });
        addShapedRecipe(
                getModItem("Natura", "stair.amaranth", 4, 0, missing),
                new Object[] { getModItem("Natura", "planks", 1, 8, missing), null, null,
                        getModItem("Natura", "planks", 1, 8, missing), getModItem("Natura", "planks", 1, 8, missing),
                        null, getModItem("Natura", "planks", 1, 8, missing),
                        getModItem("Natura", "planks", 1, 8, missing), getModItem("Natura", "planks", 1, 8, missing) });
        addShapedRecipe(
                getModItem("Natura", "pressureplate.amaranth", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem("Natura", "plankSlab2", 1, 0, missing), "springAnyIron",
                        getModItem("Natura", "plankSlab2", 1, 0, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.amaranth", 1, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab2", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "plankSlab2", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing), "itemFlint",
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "plankSlab2", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "plankSlab2", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.amaranth", 2, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab2", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "plankSlab2", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing), "screwIron",
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "plankSlab2", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "plankSlab2", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.amaranth", 3, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab2", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "plankSlab2", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing), "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "plankSlab2", 1, 0, missing),
                        getModItem("Natura", "natura.stick", 1, 8, missing),
                        getModItem("Natura", "plankSlab2", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "button.amaranth", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "pressureplate.amaranth", 1, 0, missing),
                        null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 4, 9, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing),
                        getModItem("Natura", "Rare Tree", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 2, 9, missing),
                new Object[] { getModItem("Natura", "Rare Tree", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "natura.stick", 2, 9, missing),
                new Object[] { getModItem("Natura", "planks", 1, 9, missing),
                        getModItem("Natura", "planks", 1, 9, missing) });
        addShapedRecipe(
                getModItem("Natura", "natura.stick", 4, 9, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem("Natura", "planks", 1, 9, missing), null, null,
                        getModItem("Natura", "planks", 1, 9, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "Natura.workbench", 1, 9, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem("Natura", "Rare Tree", 1, 3, missing),
                        getModItem("Natura", "Rare Tree", 1, 3, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 1, 9, missing),
                new Object[] { getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "planks", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "planks", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "planks", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 2, 9, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "planks", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "planks", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 4, 9, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "planks", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "planks", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing) });
        addShapedRecipe(
                getModItem("Natura", "plankSlab2", 2, 1, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "planks", 1, 9, missing), null });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.tiger", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem("Natura", "planks", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "planks", 1, 9, missing), getModItem("Natura", "planks", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "planks", 1, 9, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.tiger", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "planks", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "planks", 1, 9, missing), getModItem("Natura", "planks", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "planks", 1, 9, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.tiger", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "planks", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "planks", 1, 9, missing), getModItem("Natura", "planks", 1, 9, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "planks", 1, 9, missing) });
        addShapedRecipe(
                getModItem("Natura", "stair.tiger", 4, 0, missing),
                new Object[] { getModItem("Natura", "planks", 1, 9, missing), null, null,
                        getModItem("Natura", "planks", 1, 9, missing), getModItem("Natura", "planks", 1, 9, missing),
                        null, getModItem("Natura", "planks", 1, 9, missing),
                        getModItem("Natura", "planks", 1, 9, missing), getModItem("Natura", "planks", 1, 9, missing) });
        addShapedRecipe(
                getModItem("Natura", "pressureplate.tiger", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem("Natura", "plankSlab2", 1, 1, missing), "springAnyIron",
                        getModItem("Natura", "plankSlab2", 1, 1, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.tiger", 1, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab2", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "plankSlab2", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing), "itemFlint",
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "plankSlab2", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "plankSlab2", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.tiger", 2, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab2", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "plankSlab2", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing), "screwIron",
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "plankSlab2", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "plankSlab2", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.tiger", 3, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab2", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "plankSlab2", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing), "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "plankSlab2", 1, 1, missing),
                        getModItem("Natura", "natura.stick", 1, 9, missing),
                        getModItem("Natura", "plankSlab2", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "button.tiger", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "pressureplate.tiger", 1, 0, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 4, 10, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing),
                        getModItem("Natura", "willow", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 2, 10, missing),
                new Object[] { getModItem("Natura", "willow", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "natura.stick", 2, 10, missing),
                new Object[] { getModItem("Natura", "planks", 1, 10, missing),
                        getModItem("Natura", "planks", 1, 10, missing) });
        addShapedRecipe(
                getModItem("Natura", "natura.stick", 4, 10, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem("Natura", "planks", 1, 10, missing), null, null,
                        getModItem("Natura", "planks", 1, 10, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "Natura.workbench", 1, 10, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem("Natura", "willow", 1, 0, missing),
                        getModItem("Natura", "willow", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 1, 10, missing),
                new Object[] { getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "planks", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "planks", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "planks", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 2, 10, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "planks", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "planks", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 4, 10, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "planks", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "planks", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing) });
        addShapedRecipe(
                getModItem("Natura", "plankSlab2", 2, 2, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "planks", 1, 10, missing), null });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.willow", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem("Natura", "planks", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "planks", 1, 10, missing), getModItem("Natura", "planks", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "planks", 1, 10, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.willow", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "planks", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "planks", 1, 10, missing), getModItem("Natura", "planks", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "planks", 1, 10, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.willow", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "planks", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "planks", 1, 10, missing), getModItem("Natura", "planks", 1, 10, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "planks", 1, 10, missing) });
        addShapedRecipe(
                getModItem("Natura", "stair.willow", 4, 0, missing),
                new Object[] { getModItem("Natura", "planks", 1, 10, missing), null, null,
                        getModItem("Natura", "planks", 1, 10, missing), getModItem("Natura", "planks", 1, 10, missing),
                        null, getModItem("Natura", "planks", 1, 10, missing),
                        getModItem("Natura", "planks", 1, 10, missing),
                        getModItem("Natura", "planks", 1, 10, missing) });
        addShapedRecipe(
                getModItem("Natura", "pressureplate.willow", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem("Natura", "plankSlab2", 1, 2, missing), "springAnyIron",
                        getModItem("Natura", "plankSlab2", 1, 2, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.willow", 1, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab2", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "plankSlab2", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing), "itemFlint",
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "plankSlab2", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "plankSlab2", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.willow", 2, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab2", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "plankSlab2", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing), "screwIron",
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "plankSlab2", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "plankSlab2", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.willow", 3, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab2", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "plankSlab2", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing), "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "plankSlab2", 1, 2, missing),
                        getModItem("Natura", "natura.stick", 1, 10, missing),
                        getModItem("Natura", "plankSlab2", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "button.willow", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "pressureplate.willow", 1, 0, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 4, 11, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing),
                        getModItem("Natura", "Dark Tree", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 2, 11, missing),
                new Object[] { getModItem("Natura", "Dark Tree", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "natura.stick", 2, 11, missing),
                new Object[] { getModItem("Natura", "planks", 1, 11, missing),
                        getModItem("Natura", "planks", 1, 11, missing) });
        addShapedRecipe(
                getModItem("Natura", "natura.stick", 4, 11, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem("Natura", "planks", 1, 11, missing), null, null,
                        getModItem("Natura", "planks", 1, 11, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "Natura.workbench", 1, 11, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem("Natura", "Dark Tree", 1, 0, missing),
                        getModItem("Natura", "Dark Tree", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 1, 11, missing),
                new Object[] { getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "planks", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "planks", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "planks", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 2, 11, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "planks", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "planks", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 4, 11, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "planks", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "planks", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing) });
        addShapedRecipe(
                getModItem("Natura", "plankSlab2", 2, 3, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "planks", 1, 11, missing), null });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.darkwood", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem("Natura", "planks", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "planks", 1, 11, missing), getModItem("Natura", "planks", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "planks", 1, 11, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.darkwood", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "planks", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "planks", 1, 11, missing), getModItem("Natura", "planks", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "planks", 1, 11, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.darkwood", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "planks", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "planks", 1, 11, missing), getModItem("Natura", "planks", 1, 11, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "planks", 1, 11, missing) });
        addShapedRecipe(
                getModItem("Natura", "stair.darkwood", 4, 0, missing),
                new Object[] { getModItem("Natura", "planks", 1, 11, missing), null, null,
                        getModItem("Natura", "planks", 1, 11, missing), getModItem("Natura", "planks", 1, 11, missing),
                        null, getModItem("Natura", "planks", 1, 11, missing),
                        getModItem("Natura", "planks", 1, 11, missing),
                        getModItem("Natura", "planks", 1, 11, missing) });
        addShapedRecipe(
                getModItem("Natura", "pressureplate.darkwood", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem("Natura", "plankSlab2", 1, 3, missing), "springAnyIron",
                        getModItem("Natura", "plankSlab2", 1, 3, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.darkwood", 1, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab2", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "plankSlab2", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing), "itemFlint",
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "plankSlab2", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "plankSlab2", 1, 3, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.darkwood", 2, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab2", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "plankSlab2", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing), "screwIron",
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "plankSlab2", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "plankSlab2", 1, 3, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.darkwood", 3, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab2", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "plankSlab2", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing), "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "plankSlab2", 1, 3, missing),
                        getModItem("Natura", "natura.stick", 1, 11, missing),
                        getModItem("Natura", "plankSlab2", 1, 3, missing) });
        addShapedRecipe(
                getModItem("Natura", "button.darkwood", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "pressureplate.darkwood", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem("Natura", "natura.emptybowl", 1, 11, missing),
                new Object[] { getModItem("Natura", "planks", 1, 11, missing), "craftingToolKnife" });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 4, 12, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing),
                        getModItem("Natura", "Dark Tree", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "planks", 2, 12, missing),
                new Object[] { getModItem("Natura", "Dark Tree", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "natura.stick", 2, 12, missing),
                new Object[] { getModItem("Natura", "planks", 1, 12, missing),
                        getModItem("Natura", "planks", 1, 12, missing) });
        addShapedRecipe(
                getModItem("Natura", "natura.stick", 4, 12, missing),
                new Object[] { getModItem("gregtech", "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem("Natura", "planks", 1, 12, missing), null, null,
                        getModItem("Natura", "planks", 1, 12, missing), null });
        addShapelessCraftingRecipe(
                getModItem("Natura", "Natura.workbench", 1, 12, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem("Natura", "Dark Tree", 1, 1, missing),
                        getModItem("Natura", "Dark Tree", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 1, 12, missing),
                new Object[] { getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "planks", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "planks", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "planks", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 2, 12, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "planks", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "planks", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing) });
        addShapedRecipe(
                getModItem("Natura", "Natura.fence", 4, 12, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "planks", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "planks", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing) });
        addShapedRecipe(
                getModItem("Natura", "plankSlab2", 2, 4, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "planks", 1, 12, missing), null });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.fusewood", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem("Natura", "planks", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "planks", 1, 12, missing), getModItem("Natura", "planks", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "planks", 1, 12, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.fusewood", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem("Natura", "planks", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "planks", 1, 12, missing), getModItem("Natura", "planks", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "planks", 1, 12, missing) });
        addShapedRecipe(
                getModItem("Natura", "fenceGate.fusewood", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem("Natura", "planks", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "planks", 1, 12, missing), getModItem("Natura", "planks", 1, 12, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "planks", 1, 12, missing) });
        addShapedRecipe(
                getModItem("Natura", "stair.fusewood", 4, 0, missing),
                new Object[] { getModItem("Natura", "planks", 1, 12, missing), null, null,
                        getModItem("Natura", "planks", 1, 12, missing), getModItem("Natura", "planks", 1, 12, missing),
                        null, getModItem("Natura", "planks", 1, 12, missing),
                        getModItem("Natura", "planks", 1, 12, missing),
                        getModItem("Natura", "planks", 1, 12, missing) });
        addShapedRecipe(
                getModItem("Natura", "pressureplate.fusewood", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem("Natura", "plankSlab2", 1, 4, missing), "springAnyIron",
                        getModItem("Natura", "plankSlab2", 1, 4, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.fusewood", 1, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab2", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "plankSlab2", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing), "itemFlint",
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "plankSlab2", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "plankSlab2", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.fusewood", 2, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab2", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "plankSlab2", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing), "screwIron",
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "plankSlab2", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "plankSlab2", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "trapdoor.fusewood", 3, 0, missing),
                new Object[] { getModItem("Natura", "plankSlab2", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "plankSlab2", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing), "screwSteel",
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "plankSlab2", 1, 4, missing),
                        getModItem("Natura", "natura.stick", 1, 12, missing),
                        getModItem("Natura", "plankSlab2", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "button.fusewood", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "pressureplate.fusewood", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem("Natura", "natura.emptybowl", 1, 12, missing),
                new Object[] { getModItem("Natura", "planks", 1, 12, missing), "craftingToolKnife" });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "raspberryjuiceItem", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "juicerItem", 1, 0, missing),
                        getModItem("harvestcraft", "raspberryItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "blueberryjuiceItem", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "juicerItem", 1, 0, missing),
                        getModItem("harvestcraft", "blueberryItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("harvestcraft", "blackberryjuiceItem", 1, 0, missing),
                new Object[] { getModItem("harvestcraft", "juicerItem", 1, 0, missing),
                        getModItem("harvestcraft", "blackberryItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "barley.seed", 1, 0, missing),
                new Object[] { getModItem("Natura", "barleyFood", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "NetherFurnace", 1, 0, missing),
                new Object[] { "stoneNetherBrick", "stoneNetherBrick", "stoneNetherBrick", "itemFlint", "itemFlint",
                        "itemFlint", "stoneNetherBrick", "stoneNetherBrick", "stoneNetherBrick" });
        addShapedRecipe(
                getModItem("Natura", "Obelisk", 1, 0, missing),
                new Object[] { getModItem("Natura", "tree", 1, 2, missing), getModItem("Natura", "tree", 1, 2, missing),
                        getModItem("Natura", "tree", 1, 2, missing), getModItem("Natura", "tree", 1, 2, missing),
                        "gemEnderPearl", getModItem("Natura", "tree", 1, 2, missing),
                        getModItem("Natura", "tree", 1, 2, missing), getModItem("Natura", "tree", 1, 2, missing),
                        getModItem("Natura", "tree", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "NetherPressurePlate", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolHardHammer", "screwIron",
                        getModItem("minecraft", "netherrack", 1, 0, missing), "springAnyIron",
                        getModItem("minecraft", "netherrack", 1, 0, missing), "screwIron", "craftingToolScrewdriver",
                        "screwIron" });
        addShapelessCraftingRecipe(
                getModItem("Natura", "NetherButton", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "NetherPressurePlate", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("Natura", "NetherLever", 1, 0, missing),
                new Object[] { "stickWood", getModItem("Natura", "NetherButton", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("Natura", "trapdoor.redwood", 1, 0, missing),
                        getModItem("Natura", "redwood", 1, 1, missing), "screwCopper", "ringCopper",
                        getModItem("Natura", "redwood", 1, 1, missing), "craftingToolSaw",
                        getModItem("Natura", "redwood", 1, 1, missing),
                        getModItem("Natura", "redwood", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("Natura", "trapdoor.redwood", 1, 0, missing),
                        getModItem("Natura", "redwood", 1, 1, missing), "screwIron", "ringIron",
                        getModItem("Natura", "redwood", 1, 1, missing), "craftingToolSaw",
                        getModItem("Natura", "redwood", 1, 1, missing),
                        getModItem("Natura", "redwood", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "trapdoor.redwood", 1, 0, missing),
                        getModItem("Natura", "redwood", 1, 1, missing), "screwCopper", "ringCopper",
                        getModItem("Natura", "redwood", 1, 1, missing), "craftingToolScrewdriver",
                        getModItem("Natura", "redwood", 1, 1, missing),
                        getModItem("Natura", "redwood", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 0, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "trapdoor.redwood", 1, 0, missing),
                        getModItem("Natura", "redwood", 1, 1, missing), "screwIron", "ringIron",
                        getModItem("Natura", "redwood", 1, 1, missing), "craftingToolScrewdriver",
                        getModItem("Natura", "redwood", 1, 1, missing),
                        getModItem("Natura", "redwood", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 1, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("Natura", "trapdoor.eucalyptus", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing), "screwCopper", "ringCopper",
                        getModItem("Natura", "planks", 1, 0, missing), "craftingToolSaw",
                        getModItem("Natura", "planks", 1, 0, missing), getModItem("Natura", "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 1, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("Natura", "trapdoor.eucalyptus", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing), "screwIron", "ringIron",
                        getModItem("Natura", "planks", 1, 0, missing), "craftingToolSaw",
                        getModItem("Natura", "planks", 1, 0, missing), getModItem("Natura", "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 1, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "trapdoor.eucalyptus", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing), "screwCopper", "ringCopper",
                        getModItem("Natura", "planks", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem("Natura", "planks", 1, 0, missing), getModItem("Natura", "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 1, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "trapdoor.eucalyptus", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 0, missing), "screwIron", "ringIron",
                        getModItem("Natura", "planks", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem("Natura", "planks", 1, 0, missing), getModItem("Natura", "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 2, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("Natura", "trapdoor.hopseed", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 5, missing), "screwCopper", "ringCopper",
                        getModItem("Natura", "planks", 1, 5, missing), "craftingToolSaw",
                        getModItem("Natura", "planks", 1, 5, missing), getModItem("Natura", "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 2, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("Natura", "trapdoor.hopseed", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 5, missing), "screwIron", "ringIron",
                        getModItem("Natura", "planks", 1, 5, missing), "craftingToolSaw",
                        getModItem("Natura", "planks", 1, 5, missing), getModItem("Natura", "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 2, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "trapdoor.hopseed", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 5, missing), "screwCopper", "ringCopper",
                        getModItem("Natura", "planks", 1, 5, missing), "craftingToolScrewdriver",
                        getModItem("Natura", "planks", 1, 5, missing), getModItem("Natura", "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 2, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "trapdoor.hopseed", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 5, missing), "screwIron", "ringIron",
                        getModItem("Natura", "planks", 1, 5, missing), "craftingToolScrewdriver",
                        getModItem("Natura", "planks", 1, 5, missing), getModItem("Natura", "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 3, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("Natura", "trapdoor.sakura", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 1, missing), "screwCopper", "ringCopper",
                        getModItem("Natura", "planks", 1, 1, missing), "craftingToolSaw",
                        getModItem("Natura", "planks", 1, 1, missing), getModItem("Natura", "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 3, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("Natura", "trapdoor.sakura", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 1, missing), "screwIron", "ringIron",
                        getModItem("Natura", "planks", 1, 1, missing), "craftingToolSaw",
                        getModItem("Natura", "planks", 1, 1, missing), getModItem("Natura", "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 3, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "trapdoor.sakura", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 1, missing), "screwCopper", "ringCopper",
                        getModItem("Natura", "planks", 1, 1, missing), "craftingToolScrewdriver",
                        getModItem("Natura", "planks", 1, 1, missing), getModItem("Natura", "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 3, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "trapdoor.sakura", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 1, missing), "screwIron", "ringIron",
                        getModItem("Natura", "planks", 1, 1, missing), "craftingToolScrewdriver",
                        getModItem("Natura", "planks", 1, 1, missing), getModItem("Natura", "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 4, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("Natura", "trapdoor.ghostwood", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 2, missing), "screwCopper", "ringCopper",
                        getModItem("Natura", "planks", 1, 2, missing), "craftingToolSaw",
                        getModItem("Natura", "planks", 1, 2, missing), getModItem("Natura", "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 4, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("Natura", "trapdoor.ghostwood", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 2, missing), "screwIron", "ringIron",
                        getModItem("Natura", "planks", 1, 2, missing), "craftingToolSaw",
                        getModItem("Natura", "planks", 1, 2, missing), getModItem("Natura", "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 4, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "trapdoor.ghostwood", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 2, missing), "screwCopper", "ringCopper",
                        getModItem("Natura", "planks", 1, 2, missing), "craftingToolScrewdriver",
                        getModItem("Natura", "planks", 1, 2, missing), getModItem("Natura", "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 4, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "trapdoor.ghostwood", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 2, missing), "screwIron", "ringIron",
                        getModItem("Natura", "planks", 1, 2, missing), "craftingToolScrewdriver",
                        getModItem("Natura", "planks", 1, 2, missing), getModItem("Natura", "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 5, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("Natura", "trapdoor.bloodwood", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 4, missing), "screwCopper", "ringCopper",
                        getModItem("Natura", "planks", 1, 4, missing), "craftingToolSaw",
                        getModItem("Natura", "planks", 1, 4, missing), getModItem("Natura", "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 5, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("Natura", "trapdoor.bloodwood", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 4, missing), "screwIron", "ringIron",
                        getModItem("Natura", "planks", 1, 4, missing), "craftingToolSaw",
                        getModItem("Natura", "planks", 1, 4, missing), getModItem("Natura", "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 5, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "trapdoor.bloodwood", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 4, missing), "screwCopper", "ringCopper",
                        getModItem("Natura", "planks", 1, 4, missing), "craftingToolScrewdriver",
                        getModItem("Natura", "planks", 1, 4, missing), getModItem("Natura", "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 5, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "trapdoor.bloodwood", 1, 0, missing),
                        getModItem("Natura", "planks", 1, 4, missing), "screwIron", "ringIron",
                        getModItem("Natura", "planks", 1, 4, missing), "craftingToolScrewdriver",
                        getModItem("Natura", "planks", 1, 4, missing), getModItem("Natura", "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 6, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("Natura", "trapdoor.redwood", 1, 0, missing),
                        getModItem("Natura", "redwood", 1, 0, missing), "screwCopper", "ringCopper",
                        getModItem("Natura", "redwood", 1, 0, missing), "craftingToolSaw",
                        getModItem("Natura", "redwood", 1, 0, missing),
                        getModItem("Natura", "redwood", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 6, missing),
                new Object[] { "craftingToolScrewdriver", getModItem("Natura", "trapdoor.redwood", 1, 0, missing),
                        getModItem("Natura", "redwood", 1, 0, missing), "screwIron", "ringIron",
                        getModItem("Natura", "redwood", 1, 0, missing), "craftingToolSaw",
                        getModItem("Natura", "redwood", 1, 0, missing),
                        getModItem("Natura", "redwood", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 6, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "trapdoor.redwood", 1, 0, missing),
                        getModItem("Natura", "redwood", 1, 0, missing), "screwCopper", "ringCopper",
                        getModItem("Natura", "redwood", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem("Natura", "redwood", 1, 0, missing),
                        getModItem("Natura", "redwood", 1, 0, missing) });
        addShapedRecipe(
                getModItem("Natura", "redwoodDoorItem", 1, 6, missing),
                new Object[] { "craftingToolSaw", getModItem("Natura", "trapdoor.redwood", 1, 0, missing),
                        getModItem("Natura", "redwood", 1, 0, missing), "screwIron", "ringIron",
                        getModItem("Natura", "redwood", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem("Natura", "redwood", 1, 0, missing),
                        getModItem("Natura", "redwood", 1, 0, missing) });

        ChiselHelper.addVariationFromStack("bookshelf", getModItem("Natura", "Natura.bookshelf", 1, 0, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem("Natura", "Natura.bookshelf", 1, 1, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem("Natura", "Natura.bookshelf", 1, 2, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem("Natura", "Natura.bookshelf", 1, 3, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem("Natura", "Natura.bookshelf", 1, 4, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem("Natura", "Natura.bookshelf", 1, 5, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem("Natura", "Natura.bookshelf", 1, 6, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem("Natura", "Natura.bookshelf", 1, 7, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem("Natura", "Natura.bookshelf", 1, 8, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem("Natura", "Natura.bookshelf", 1, 9, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem("Natura", "Natura.bookshelf", 1, 10, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem("Natura", "Natura.bookshelf", 1, 11, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem("Natura", "Natura.bookshelf", 1, 12, missing));

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glass", 1, 0, missing),
                        getModItem("minecraft", "soul_sand", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "NetherGlass", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "glass", 1, 0, missing),
                        getModItem("Natura", "heatsand", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "NetherGlass", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "flint_and_steel", 1, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("Natura", "natura.flintandblaze", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.blaze", 432)).noFluidOutputs().duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 6, 0, missing),
                        getModItem("minecraft", "book", 3, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.bookshelf", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 6, 1, missing),
                        getModItem("minecraft", "book", 3, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.bookshelf", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 6, 2, missing),
                        getModItem("minecraft", "book", 3, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.bookshelf", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 6, 3, missing),
                        getModItem("minecraft", "book", 3, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.bookshelf", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 6, 4, missing),
                        getModItem("minecraft", "book", 3, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.bookshelf", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 6, 5, missing),
                        getModItem("minecraft", "book", 3, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.bookshelf", 1, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 6, 6, missing),
                        getModItem("minecraft", "book", 3, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.bookshelf", 1, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 6, 7, missing),
                        getModItem("minecraft", "book", 3, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.bookshelf", 1, 7, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 6, 8, missing),
                        getModItem("minecraft", "book", 3, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.bookshelf", 1, 8, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 6, 9, missing),
                        getModItem("minecraft", "book", 3, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.bookshelf", 1, 9, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 6, 10, missing),
                        getModItem("minecraft", "book", 3, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.bookshelf", 1, 10, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 6, 11, missing),
                        getModItem("minecraft", "book", 3, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.bookshelf", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 6, 12, missing),
                        getModItem("minecraft", "book", 3, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.bookshelf", 1, 12, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "tree", 1, 0, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.workbench", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "tree", 1, 1, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.workbench", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "tree", 1, 2, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.workbench", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "redwood", 1, 1, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.workbench", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "bloodwood", 1, 0, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.workbench", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "bloodwood", 1, 15, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.workbench", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "tree", 1, 3, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.workbench", 1, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "Rare Tree", 1, 0, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.workbench", 1, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "Rare Tree", 1, 1, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.workbench", 1, 7, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "Rare Tree", 1, 2, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.workbench", 1, 8, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "Rare Tree", 1, 3, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.workbench", 1, 9, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "willow", 1, 0, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.workbench", 1, 10, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "Dark Tree", 1, 0, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.workbench", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "Dark Tree", 1, 1, missing),
                        getModItem("minecraft", "flint", 2, 0, missing))
                .itemOutputs(getModItem("Natura", "Natura.workbench", 1, 12, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("Natura", "Natura.fence", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 1, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("Natura", "Natura.fence", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 2, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("Natura", "Natura.fence", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 3, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("Natura", "Natura.fence", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 4, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("Natura", "Natura.fence", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 5, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("Natura", "Natura.fence", 1, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 6, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("Natura", "Natura.fence", 1, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 7, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("Natura", "Natura.fence", 1, 7, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 8, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("Natura", "Natura.fence", 1, 8, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 9, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("Natura", "Natura.fence", 1, 9, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 10, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("Natura", "Natura.fence", 1, 10, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 11, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("Natura", "Natura.fence", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 12, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem("Natura", "Natura.fence", 1, 12, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 2, 0, missing),
                        getModItem("Natura", "planks", 2, 0, missing))
                .itemOutputs(getModItem("Natura", "fenceGate.eucalyptus", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 2, 1, missing),
                        getModItem("Natura", "planks", 2, 1, missing))
                .itemOutputs(getModItem("Natura", "fenceGate.sakura", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 2, 2, missing),
                        getModItem("Natura", "planks", 2, 2, missing))
                .itemOutputs(getModItem("Natura", "fenceGate.ghostwood", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 2, 3, missing),
                        getModItem("Natura", "planks", 2, 3, missing))
                .itemOutputs(getModItem("Natura", "fenceGate.redwood", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 2, 4, missing),
                        getModItem("Natura", "planks", 2, 4, missing))
                .itemOutputs(getModItem("Natura", "fenceGate.bloodwood", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 2, 5, missing),
                        getModItem("Natura", "planks", 2, 5, missing))
                .itemOutputs(getModItem("Natura", "fenceGate.hopseed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 2, 6, missing),
                        getModItem("Natura", "planks", 2, 6, missing))
                .itemOutputs(getModItem("Natura", "fenceGate.maple", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 2, 7, missing),
                        getModItem("Natura", "planks", 2, 7, missing))
                .itemOutputs(getModItem("Natura", "fenceGate.silverbell", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 2, 8, missing),
                        getModItem("Natura", "planks", 2, 8, missing))
                .itemOutputs(getModItem("Natura", "fenceGate.amaranth", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 2, 9, missing),
                        getModItem("Natura", "planks", 2, 9, missing))
                .itemOutputs(getModItem("Natura", "fenceGate.tiger", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 2, 10, missing),
                        getModItem("Natura", "planks", 2, 10, missing))
                .itemOutputs(getModItem("Natura", "fenceGate.willow", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 2, 11, missing),
                        getModItem("Natura", "planks", 2, 11, missing))
                .itemOutputs(getModItem("Natura", "fenceGate.darkwood", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 2, 12, missing),
                        getModItem("Natura", "planks", 2, 12, missing))
                .itemOutputs(getModItem("Natura", "fenceGate.fusewood", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 4, 0, missing),
                        getModItem("Natura", "natura.stick", 4, 0, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.eucalyptus", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 4, 0, missing),
                        getModItem("Natura", "natura.stick", 4, 0, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.eucalyptus", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 4, 1, missing),
                        getModItem("Natura", "natura.stick", 4, 1, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.sakura", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 4, 1, missing),
                        getModItem("Natura", "natura.stick", 4, 1, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.sakura", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 4, 2, missing),
                        getModItem("Natura", "natura.stick", 4, 2, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.ghostwood", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 4, 2, missing),
                        getModItem("Natura", "natura.stick", 4, 2, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.ghostwood", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 4, 3, missing),
                        getModItem("Natura", "natura.stick", 4, 3, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.redwood", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 4, 3, missing),
                        getModItem("Natura", "natura.stick", 4, 3, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.redwood", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 4, 4, missing),
                        getModItem("Natura", "natura.stick", 4, 0, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.bloodwood", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 4, 4, missing),
                        getModItem("Natura", "natura.stick", 4, 0, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.bloodwood", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 4, 5, missing),
                        getModItem("Natura", "natura.stick", 4, 5, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.hopseed", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 4, 5, missing),
                        getModItem("Natura", "natura.stick", 4, 5, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.hopseed", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 4, 6, missing),
                        getModItem("Natura", "natura.stick", 4, 6, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.maple", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 4, 6, missing),
                        getModItem("Natura", "natura.stick", 4, 6, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.maple", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 4, 7, missing),
                        getModItem("Natura", "natura.stick", 4, 7, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.silverbell", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 4, 7, missing),
                        getModItem("Natura", "natura.stick", 4, 7, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.silverbell", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 4, 0, missing),
                        getModItem("Natura", "natura.stick", 4, 8, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.amaranth", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 4, 0, missing),
                        getModItem("Natura", "natura.stick", 4, 8, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.amaranth", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 4, 1, missing),
                        getModItem("Natura", "natura.stick", 4, 9, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.tiger", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 4, 1, missing),
                        getModItem("Natura", "natura.stick", 4, 9, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.tiger", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 4, 2, missing),
                        getModItem("Natura", "natura.stick", 4, 10, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.willow", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 4, 2, missing),
                        getModItem("Natura", "natura.stick", 4, 10, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.willow", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 4, 3, missing),
                        getModItem("Natura", "natura.stick", 4, 11, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.darkwood", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 4, 3, missing),
                        getModItem("Natura", "natura.stick", 4, 11, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.darkwood", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 4, 4, missing),
                        getModItem("Natura", "natura.stick", 4, 12, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.fusewood", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 4, 4, missing),
                        getModItem("Natura", "natura.stick", 4, 12, missing))
                .itemOutputs(getModItem("Natura", "trapdoor.fusewood", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "redwood", 4, 1, missing),
                        getModItem("Natura", "trapdoor.redwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "redwoodDoorItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "redwood", 4, 1, missing),
                        getModItem("Natura", "trapdoor.redwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "redwoodDoorItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 4, 0, missing),
                        getModItem("Natura", "trapdoor.eucalyptus", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "redwoodDoorItem", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 4, 0, missing),
                        getModItem("Natura", "trapdoor.eucalyptus", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "redwoodDoorItem", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 4, 5, missing),
                        getModItem("Natura", "trapdoor.hopseed", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "redwoodDoorItem", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 4, 5, missing),
                        getModItem("Natura", "trapdoor.hopseed", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "redwoodDoorItem", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 4, 1, missing),
                        getModItem("Natura", "trapdoor.sakura", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "redwoodDoorItem", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 4, 1, missing),
                        getModItem("Natura", "trapdoor.sakura", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "redwoodDoorItem", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 4, 2, missing),
                        getModItem("Natura", "trapdoor.ghostwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "redwoodDoorItem", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 4, 2, missing),
                        getModItem("Natura", "trapdoor.ghostwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "redwoodDoorItem", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 4, 4, missing),
                        getModItem("Natura", "trapdoor.bloodwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "redwoodDoorItem", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "planks", 4, 4, missing),
                        getModItem("Natura", "trapdoor.bloodwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "redwoodDoorItem", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "redwood", 4, 0, missing),
                        getModItem("Natura", "trapdoor.redwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "redwoodDoorItem", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "redwood", 4, 0, missing),
                        getModItem("Natura", "trapdoor.redwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "redwoodDoorItem", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 2, missing),
                        getModItem("Natura", "barleyFood", 3, 7, missing))
                .itemOutputs(getModItem("Natura", "natura.bow.ghostwood", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 4, missing),
                        getModItem("Natura", "barleyFood", 3, 7, missing))
                .itemOutputs(getModItem("Natura", "natura.bow.bloodwood", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 11, missing),
                        getModItem("Natura", "barleyFood", 3, 7, missing))
                .itemOutputs(getModItem("Natura", "natura.bow.darkwood", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "natura.stick", 3, 12, missing),
                        getModItem("Natura", "barleyFood", 3, 7, missing))
                .itemOutputs(getModItem("Natura", "natura.bow.fusewood", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.eucalyptus", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.eucalyptus", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 2, 1, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.sakura", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 2, 1, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.sakura", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 2, 2, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.ghostwood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 2, 2, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.ghostwood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 2, 3, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.redwood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 2, 3, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.redwood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 2, 4, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.bloodwood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 2, 4, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.bloodwood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 2, 5, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.hopseed", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 2, 5, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.hopseed", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 2, 6, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.maple", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 2, 6, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.maple", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 2, 7, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.silverbell", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab1", 2, 7, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.silverbell", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.amaranth", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.amaranth", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 2, 1, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.tiger", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 2, 1, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.tiger", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 2, 2, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.willow", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 2, 2, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.willow", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 2, 3, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.darkwood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 2, 3, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.darkwood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 2, 4, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.fusewood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("Natura", "plankSlab2", 2, 4, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem("Natura", "pressureplate.fusewood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "netherrack", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24032, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 9, missing))
                .itemOutputs(getModItem("Natura", "NetherPressurePlate", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "netherrack", 2, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 24304, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 9, missing))
                .itemOutputs(getModItem("Natura", "NetherPressurePlate", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.eucalyptus", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.eucalyptus", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.eucalyptus", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.eucalyptus", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.eucalyptus", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.eucalyptus", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.sakura", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.sakura", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.sakura", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.sakura", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.sakura", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.sakura", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.ghostwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.ghostwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.ghostwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.ghostwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.ghostwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.ghostwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.redwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.redwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.redwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.redwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.redwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.redwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.bloodwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.bloodwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.bloodwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.bloodwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.bloodwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.bloodwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.hopseed", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.hopseed", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.hopseed", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.hopseed", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.hopseed", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.hopseed", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.maple", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.maple", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.maple", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.maple", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.maple", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.maple", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.silverbell", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.silverbell", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.silverbell", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.silverbell", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.silverbell", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.silverbell", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.amaranth", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.amaranth", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.amaranth", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.amaranth", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.amaranth", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.amaranth", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.tiger", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.tiger", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.tiger", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.tiger", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.tiger", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.tiger", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.willow", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.willow", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.willow", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.willow", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.willow", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.willow", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.darkwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.darkwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.darkwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.darkwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.darkwood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.darkwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.fusewood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.fusewood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.fusewood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.fusewood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "pressureplate.fusewood", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "button.fusewood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "tree", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "tree", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "tree", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 6, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "tree", 1, 1, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "tree", 1, 1, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "tree", 1, 1, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 6, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "tree", 1, 2, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "tree", 1, 2, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "tree", 1, 2, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 6, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "redwood", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "redwood", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "redwood", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 6, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "bloodwood", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "bloodwood", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "bloodwood", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 6, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "bloodwood", 1, 15, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "bloodwood", 1, 15, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "bloodwood", 1, 15, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 6, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "tree", 1, 3, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "tree", 1, 3, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "tree", 1, 3, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 6, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Rare Tree", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Rare Tree", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Rare Tree", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 6, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Rare Tree", 1, 1, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Rare Tree", 1, 1, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Rare Tree", 1, 1, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 6, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Rare Tree", 1, 2, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Rare Tree", 1, 2, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Rare Tree", 1, 2, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 6, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Rare Tree", 1, 3, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Rare Tree", 1, 3, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Rare Tree", 1, 3, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 6, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "willow", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "willow", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "willow", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 6, 10, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Dark Tree", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 11, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Dark Tree", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 11, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Dark Tree", 1, 0, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 6, 11, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Dark Tree", 1, 1, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 12, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Dark Tree", 1, 1, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 4, 12, missing),
                        getModItem("gregtech", "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Dark Tree", 1, 1, missing))
                .itemOutputs(
                        getModItem("Natura", "planks", 6, 12, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 0, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 1, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 1, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 1, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 2, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 2, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 2, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 3, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 3, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 3, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 4, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 4, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 4, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 5, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 5, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 5, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 6, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 6, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 6, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 7, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 7, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 7, missing))
                .itemOutputs(getModItem("Natura", "plankSlab1", 2, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 8, missing))
                .itemOutputs(getModItem("Natura", "plankSlab2", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 8, missing))
                .itemOutputs(getModItem("Natura", "plankSlab2", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 8, missing))
                .itemOutputs(getModItem("Natura", "plankSlab2", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 9, missing))
                .itemOutputs(getModItem("Natura", "plankSlab2", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 9, missing))
                .itemOutputs(getModItem("Natura", "plankSlab2", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 9, missing))
                .itemOutputs(getModItem("Natura", "plankSlab2", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 10, missing))
                .itemOutputs(getModItem("Natura", "plankSlab2", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 10, missing))
                .itemOutputs(getModItem("Natura", "plankSlab2", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 10, missing))
                .itemOutputs(getModItem("Natura", "plankSlab2", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 11, missing))
                .itemOutputs(getModItem("Natura", "plankSlab2", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 11, missing))
                .itemOutputs(getModItem("Natura", "plankSlab2", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 11, missing))
                .itemOutputs(getModItem("Natura", "plankSlab2", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 12, missing))
                .itemOutputs(getModItem("Natura", "plankSlab2", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 12, missing))
                .itemOutputs(getModItem("Natura", "plankSlab2", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "planks", 1, 12, missing))
                .itemOutputs(getModItem("Natura", "plankSlab2", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "tree", 1, 32767, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 2809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .outputChances(10000, 8000).noFluidInputs().noFluidOutputs().duration(400).eut(2)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "redwood", 1, 32767, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 2809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .outputChances(10000, 8000).noFluidInputs().noFluidOutputs().duration(400).eut(2)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "bloodwood", 1, 32767, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 2809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .outputChances(10000, 8000).noFluidInputs().noFluidOutputs().duration(400).eut(2)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Rare Tree", 1, 32767, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 2809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .outputChances(10000, 8000).noFluidInputs().noFluidOutputs().duration(400).eut(2)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "willow", 1, 32767, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 2809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .outputChances(10000, 8000).noFluidInputs().noFluidOutputs().duration(400).eut(2)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Dark Tree", 1, 32767, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 6, 2809, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2809, missing))
                .outputChances(10000, 8000).noFluidInputs().noFluidOutputs().duration(400).eut(2)
                .addTo(sMaceratorRecipes);
        GT_ModHandler.setFuelValue(getModItem("Natura", "NetherPressurePlate", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem("Natura", "pressureplate.eucalyptus", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem("Natura", "pressureplate.sakura", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem("Natura", "pressureplate.ghostwood", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem("Natura", "pressureplate.redwood", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem("Natura", "pressureplate.bloodwood", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem("Natura", "pressureplate.hopseed", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem("Natura", "pressureplate.maple", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem("Natura", "pressureplate.amaranth", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem("Natura", "pressureplate.silverbell", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem("Natura", "pressureplate.tiger", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem("Natura", "pressureplate.willow", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem("Natura", "pressureplate.darkwood", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem("Natura", "pressureplate.fusewood", 1, 0, missing), (short) 75);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("Natura", "Bluebells", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.02", 2, 32418, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);

    }
}
