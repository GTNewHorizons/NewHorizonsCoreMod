package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAlloySmelterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCutterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sExtractorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;

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
        return Arrays.asList(Mods.Natura.ID, PamsHarvestCraft.ID);
    }

    @Override
    public void loadRecipes() {
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "barleyFood", 1, 3, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "cottonItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "cottonItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "barley.seed", 1, 1, missing),
                new Object[] { getModItem(Natura.ID, "barleyFood", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Minecraft.ID, "leather", 1, 0, missing),
                new Object[] { getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Natura.ID, "barleyFood", 1, 6, missing),
                        getModItem(Natura.ID, "barleyFood", 1, 6, missing),
                        getModItem(Natura.ID, "barleyFood", 1, 6, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing),
                        getModItem(Minecraft.ID, "string", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 4, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing),
                        getModItem(Natura.ID, "tree", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 2, 0, missing),
                new Object[] { getModItem(Natura.ID, "tree", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 0, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 0, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem(Natura.ID, "planks", 1, 0, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 0, missing), null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 0, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem(Natura.ID, "tree", 1, 0, missing),
                        getModItem(Natura.ID, "tree", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab1", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "planks", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.eucalyptus", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing), getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.eucalyptus", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing), getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.eucalyptus", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing), getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.eucalyptus", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem(Natura.ID, "plankSlab1", 1, 0, missing), "springAnyIron",
                        getModItem(Natura.ID, "plankSlab1", 1, 0, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing), "itemFlint",
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.eucalyptus", 2, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing), "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.eucalyptus", 3, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing), "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 0, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "button.eucalyptus", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "pressureplate.eucalyptus", 1, 0, missing),
                        null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 4, 1, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing),
                        getModItem(Natura.ID, "tree", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 2, 1, missing),
                new Object[] { getModItem(Natura.ID, "tree", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 1, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 1, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem(Natura.ID, "planks", 1, 1, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 1, missing), null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 1, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem(Natura.ID, "tree", 1, 1, missing),
                        getModItem(Natura.ID, "tree", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 1, missing),
                new Object[] { getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 1, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 1, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab1", 2, 1, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "planks", 1, 1, missing), null });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.sakura", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing), getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.sakura", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing), getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.sakura", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing), getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "stair.sakura", 4, 0, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 1, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 1, missing), getModItem(Natura.ID, "planks", 1, 1, missing),
                        null, getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.sakura", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem(Natura.ID, "plankSlab1", 1, 1, missing), "springAnyIron",
                        getModItem(Natura.ID, "plankSlab1", 1, 1, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.sakura", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing), "itemFlint",
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.sakura", 2, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing), "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.sakura", 3, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing), "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 1, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "button.sakura", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "pressureplate.sakura", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.emptybowl", 1, 2, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 2, missing), "craftingToolKnife" });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 4, 2, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing),
                        getModItem(Natura.ID, "tree", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 2, 2, missing),
                new Object[] { getModItem(Natura.ID, "tree", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 2, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 2, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem(Natura.ID, "planks", 1, 2, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 2, missing), null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 2, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem(Natura.ID, "tree", 1, 2, missing),
                        getModItem(Natura.ID, "tree", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 2, missing),
                new Object[] { getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 2, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 2, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab1", 2, 2, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "planks", 1, 2, missing), null });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.ghostwood", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing), getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.ghostwood", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing), getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.ghostwood", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing), getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "stair.ghostwood", 4, 0, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 2, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 2, missing), getModItem(Natura.ID, "planks", 1, 2, missing),
                        null, getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.ghostwood", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem(Natura.ID, "plankSlab1", 1, 2, missing), "springAnyIron",
                        getModItem(Natura.ID, "plankSlab1", 1, 2, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing), "itemFlint",
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 2, missing), "stickWood",
                        getModItem(Natura.ID, "plankSlab1", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.ghostwood", 2, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing), "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.ghostwood", 3, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing), "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 2, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "button.ghostwood", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "pressureplate.ghostwood", 1, 0, missing),
                        null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 4, 3, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing),
                        getModItem(Natura.ID, "redwood", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 2, 3, missing),
                new Object[] { getModItem(Natura.ID, "redwood", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 3, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 3, missing),
                        getModItem(Natura.ID, "planks", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 3, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem(Natura.ID, "planks", 1, 3, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 3, missing), null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 3, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem(Natura.ID, "redwood", 1, 1, missing),
                        getModItem(Natura.ID, "redwood", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 3, missing),
                new Object[] { getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "planks", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "planks", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "planks", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 3, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "planks", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "planks", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 3, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "planks", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "planks", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab1", 2, 3, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "planks", 1, 3, missing), null });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.redwood", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Natura.ID, "planks", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "planks", 1, 3, missing), getModItem(Natura.ID, "planks", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "planks", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.redwood", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "planks", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "planks", 1, 3, missing), getModItem(Natura.ID, "planks", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "planks", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.redwood", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "planks", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "planks", 1, 3, missing), getModItem(Natura.ID, "planks", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "planks", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "stair.redwood", 4, 0, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 3, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 3, missing), getModItem(Natura.ID, "planks", 1, 3, missing),
                        null, getModItem(Natura.ID, "planks", 1, 3, missing),
                        getModItem(Natura.ID, "planks", 1, 3, missing),
                        getModItem(Natura.ID, "planks", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.redwood", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem(Natura.ID, "plankSlab1", 1, 3, missing), "springAnyIron",
                        getModItem(Natura.ID, "plankSlab1", 1, 3, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.redwood", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing), "itemFlint",
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.redwood", 2, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing), "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.redwood", 3, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing), "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 3, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "button.redwood", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "pressureplate.redwood", 1, 0, missing),
                        null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 4, 4, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing),
                        getModItem(Natura.ID, "bloodwood", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 2, 4, missing),
                new Object[] { getModItem(Natura.ID, "bloodwood", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 4, 4, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing),
                        getModItem(Natura.ID, "bloodwood", 1, 15, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 2, 4, missing),
                new Object[] { getModItem(Natura.ID, "bloodwood", 1, 15, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 4, 4, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing),
                        getModItem(Natura.ID, "bloodwood", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 4, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 4, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem(Natura.ID, "planks", 1, 4, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 4, missing), null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 4, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem(Natura.ID, "bloodwood", 1, 0, missing),
                        getModItem(Natura.ID, "bloodwood", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 4, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem(Natura.ID, "bloodwood", 1, 15, missing),
                        getModItem(Natura.ID, "bloodwood", 1, 15, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 4, missing),
                new Object[] { getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 4, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 4, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab1", 2, 4, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "planks", 1, 4, missing), null });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.bloodwood", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing), getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.bloodwood", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing), getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.bloodwood", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing), getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "stair.bloodwood", 4, 0, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 4, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 4, missing), getModItem(Natura.ID, "planks", 1, 4, missing),
                        null, getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.bloodwood", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem(Natura.ID, "plankSlab1", 1, 4, missing), "springAnyIron",
                        getModItem(Natura.ID, "plankSlab1", 1, 4, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing), "itemFlint",
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.bloodwood", 2, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing), "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.bloodwood", 3, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing), "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 4, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "button.bloodwood", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "pressureplate.bloodwood", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.emptybowl", 1, 4, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 4, missing), "craftingToolKnife" });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 4, 5, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing),
                        getModItem(Natura.ID, "tree", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 2, 5, missing),
                new Object[] { getModItem(Natura.ID, "tree", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 5, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 5, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem(Natura.ID, "planks", 1, 5, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 5, missing), null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 5, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem(Natura.ID, "tree", 1, 3, missing),
                        getModItem(Natura.ID, "tree", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 5, missing),
                new Object[] { getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 5, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 5, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab1", 2, 5, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "planks", 1, 5, missing), null });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.hopseed", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing), getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.hopseed", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing), getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.hopseed", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing), getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "stair.hopseed", 4, 0, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 5, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 5, missing), getModItem(Natura.ID, "planks", 1, 5, missing),
                        null, getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.hopseed", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem(Natura.ID, "plankSlab1", 1, 5, missing), "springAnyIron",
                        getModItem(Natura.ID, "plankSlab1", 1, 5, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.hopseed", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing), "itemFlint",
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 5, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.hopseed", 2, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing), "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 5, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.hopseed", 3, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing), "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 5, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 5, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "button.hopseed", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "pressureplate.hopseed", 1, 0, missing),
                        null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 4, 6, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing),
                        getModItem(Natura.ID, "Rare Tree", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 2, 6, missing),
                new Object[] { getModItem(Natura.ID, "Rare Tree", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 6, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 6, missing),
                        getModItem(Natura.ID, "planks", 1, 6, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 6, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem(Natura.ID, "planks", 1, 6, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 6, missing), null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 6, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem(Natura.ID, "Rare Tree", 1, 0, missing),
                        getModItem(Natura.ID, "Rare Tree", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 6, missing),
                new Object[] { getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "planks", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "planks", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "planks", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 6, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "planks", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "planks", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 6, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "planks", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "planks", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab1", 2, 6, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "planks", 1, 6, missing), null });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.maple", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Natura.ID, "planks", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "planks", 1, 6, missing), getModItem(Natura.ID, "planks", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "planks", 1, 6, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.maple", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "planks", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "planks", 1, 6, missing), getModItem(Natura.ID, "planks", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "planks", 1, 6, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.maple", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "planks", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "planks", 1, 6, missing), getModItem(Natura.ID, "planks", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "planks", 1, 6, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "stair.maple", 4, 0, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 6, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 6, missing), getModItem(Natura.ID, "planks", 1, 6, missing),
                        null, getModItem(Natura.ID, "planks", 1, 6, missing),
                        getModItem(Natura.ID, "planks", 1, 6, missing),
                        getModItem(Natura.ID, "planks", 1, 6, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.maple", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem(Natura.ID, "plankSlab1", 1, 6, missing), "springAnyIron",
                        getModItem(Natura.ID, "plankSlab1", 1, 6, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.maple", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing), "itemFlint",
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 6, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.maple", 2, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing), "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 6, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.maple", 3, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing), "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 6, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 6, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "button.maple", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "pressureplate.maple", 1, 0, missing), null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 4, 7, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing),
                        getModItem(Natura.ID, "Rare Tree", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 2, 7, missing),
                new Object[] { getModItem(Natura.ID, "Rare Tree", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 7, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 7, missing),
                        getModItem(Natura.ID, "planks", 1, 7, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 7, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem(Natura.ID, "planks", 1, 7, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 7, missing), null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 7, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem(Natura.ID, "Rare Tree", 1, 1, missing),
                        getModItem(Natura.ID, "Rare Tree", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 7, missing),
                new Object[] { getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "planks", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "planks", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "planks", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 7, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "planks", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "planks", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 7, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "planks", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "planks", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab1", 2, 7, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "planks", 1, 7, missing), null });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.silverbell", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Natura.ID, "planks", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "planks", 1, 7, missing), getModItem(Natura.ID, "planks", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "planks", 1, 7, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.silverbell", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "planks", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "planks", 1, 7, missing), getModItem(Natura.ID, "planks", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "planks", 1, 7, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.silverbell", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "planks", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "planks", 1, 7, missing), getModItem(Natura.ID, "planks", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "planks", 1, 7, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "stair.silverbell", 4, 0, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 7, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 7, missing), getModItem(Natura.ID, "planks", 1, 7, missing),
                        null, getModItem(Natura.ID, "planks", 1, 7, missing),
                        getModItem(Natura.ID, "planks", 1, 7, missing),
                        getModItem(Natura.ID, "planks", 1, 7, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.silverbell", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem(Natura.ID, "plankSlab1", 1, 7, missing), "springAnyIron",
                        getModItem(Natura.ID, "plankSlab1", 1, 7, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.silverbell", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing), "itemFlint",
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 7, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.silverbell", 2, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing), "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 7, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.silverbell", 3, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab1", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing), "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 7, missing),
                        getModItem(Natura.ID, "plankSlab1", 1, 7, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "button.silverbell", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "pressureplate.silverbell", 1, 0, missing),
                        null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 4, 8, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing),
                        getModItem(Natura.ID, "Rare Tree", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 2, 8, missing),
                new Object[] { getModItem(Natura.ID, "Rare Tree", 1, 2, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 8, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 8, missing),
                        getModItem(Natura.ID, "planks", 1, 8, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 8, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem(Natura.ID, "planks", 1, 8, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 8, missing), null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 8, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem(Natura.ID, "Rare Tree", 1, 2, missing),
                        getModItem(Natura.ID, "Rare Tree", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 8, missing),
                new Object[] { getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "planks", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "planks", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "planks", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 8, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "planks", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "planks", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 8, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "planks", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "planks", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab2", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "planks", 1, 8, missing), null });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.amaranth", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Natura.ID, "planks", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "planks", 1, 8, missing), getModItem(Natura.ID, "planks", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "planks", 1, 8, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.amaranth", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "planks", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "planks", 1, 8, missing), getModItem(Natura.ID, "planks", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "planks", 1, 8, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.amaranth", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "planks", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "planks", 1, 8, missing), getModItem(Natura.ID, "planks", 1, 8, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "planks", 1, 8, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "stair.amaranth", 4, 0, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 8, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 8, missing), getModItem(Natura.ID, "planks", 1, 8, missing),
                        null, getModItem(Natura.ID, "planks", 1, 8, missing),
                        getModItem(Natura.ID, "planks", 1, 8, missing),
                        getModItem(Natura.ID, "planks", 1, 8, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.amaranth", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem(Natura.ID, "plankSlab2", 1, 0, missing), "springAnyIron",
                        getModItem(Natura.ID, "plankSlab2", 1, 0, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.amaranth", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab2", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing), "itemFlint",
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.amaranth", 2, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab2", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing), "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.amaranth", 3, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab2", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing), "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 8, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "button.amaranth", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "pressureplate.amaranth", 1, 0, missing),
                        null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 4, 9, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing),
                        getModItem(Natura.ID, "Rare Tree", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 2, 9, missing),
                new Object[] { getModItem(Natura.ID, "Rare Tree", 1, 3, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 9, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 9, missing),
                        getModItem(Natura.ID, "planks", 1, 9, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 9, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem(Natura.ID, "planks", 1, 9, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 9, missing), null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 9, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem(Natura.ID, "Rare Tree", 1, 3, missing),
                        getModItem(Natura.ID, "Rare Tree", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 9, missing),
                new Object[] { getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "planks", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "planks", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "planks", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 9, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "planks", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "planks", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 9, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "planks", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "planks", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab2", 2, 1, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "planks", 1, 9, missing), null });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.tiger", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Natura.ID, "planks", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "planks", 1, 9, missing), getModItem(Natura.ID, "planks", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "planks", 1, 9, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.tiger", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "planks", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "planks", 1, 9, missing), getModItem(Natura.ID, "planks", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "planks", 1, 9, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.tiger", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "planks", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "planks", 1, 9, missing), getModItem(Natura.ID, "planks", 1, 9, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "planks", 1, 9, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "stair.tiger", 4, 0, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 9, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 9, missing), getModItem(Natura.ID, "planks", 1, 9, missing),
                        null, getModItem(Natura.ID, "planks", 1, 9, missing),
                        getModItem(Natura.ID, "planks", 1, 9, missing),
                        getModItem(Natura.ID, "planks", 1, 9, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.tiger", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem(Natura.ID, "plankSlab2", 1, 1, missing), "springAnyIron",
                        getModItem(Natura.ID, "plankSlab2", 1, 1, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.tiger", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab2", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing), "itemFlint",
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.tiger", 2, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab2", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing), "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.tiger", 3, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab2", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing), "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 9, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "button.tiger", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "pressureplate.tiger", 1, 0, missing), null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 4, 10, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing),
                        getModItem(Natura.ID, "willow", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 2, 10, missing),
                new Object[] { getModItem(Natura.ID, "willow", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 10, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 10, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem(Natura.ID, "planks", 1, 10, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 10, missing), null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 10, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem(Natura.ID, "willow", 1, 0, missing),
                        getModItem(Natura.ID, "willow", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 10, missing),
                new Object[] { getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 10, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 10, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab2", 2, 2, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "planks", 1, 10, missing), null });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.willow", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.willow", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.willow", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "stair.willow", 4, 0, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 10, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing), null,
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing),
                        getModItem(Natura.ID, "planks", 1, 10, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.willow", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem(Natura.ID, "plankSlab2", 1, 2, missing), "springAnyIron",
                        getModItem(Natura.ID, "plankSlab2", 1, 2, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.willow", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab2", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing), "itemFlint",
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.willow", 2, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab2", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing), "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.willow", 3, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab2", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing), "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 10, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "button.willow", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "pressureplate.willow", 1, 0, missing), null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 4, 11, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing),
                        getModItem(Natura.ID, "Dark Tree", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 2, 11, missing),
                new Object[] { getModItem(Natura.ID, "Dark Tree", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 11, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 11, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem(Natura.ID, "planks", 1, 11, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 11, missing), null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 11, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem(Natura.ID, "Dark Tree", 1, 0, missing),
                        getModItem(Natura.ID, "Dark Tree", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 11, missing),
                new Object[] { getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 11, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 11, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab2", 2, 3, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "planks", 1, 11, missing), null });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.darkwood", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.darkwood", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.darkwood", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "stair.darkwood", 4, 0, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 11, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing), null,
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing),
                        getModItem(Natura.ID, "planks", 1, 11, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.darkwood", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem(Natura.ID, "plankSlab2", 1, 3, missing), "springAnyIron",
                        getModItem(Natura.ID, "plankSlab2", 1, 3, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.darkwood", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab2", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing), "itemFlint",
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.darkwood", 2, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab2", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing), "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.darkwood", 3, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab2", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing), "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 11, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 3, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "button.darkwood", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "pressureplate.darkwood", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.emptybowl", 1, 11, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 11, missing), "craftingToolKnife" });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 4, 12, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing),
                        getModItem(Natura.ID, "Dark Tree", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "planks", 2, 12, missing),
                new Object[] { getModItem(Natura.ID, "Dark Tree", 1, 1, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 12, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 12, missing),
                new Object[] { getModItem(GregTech.ID, "gt.metatool.01", 1, 10, missing), null, null, null,
                        getModItem(Natura.ID, "planks", 1, 12, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 12, missing), null });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 12, missing),
                new Object[] { "itemFlint", "itemFlint", getModItem(Natura.ID, "Dark Tree", 1, 1, missing),
                        getModItem(Natura.ID, "Dark Tree", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 12, missing),
                new Object[] { getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 12, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 12, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab2", 2, 4, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "planks", 1, 12, missing), null });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.fusewood", 1, 0, missing),
                new Object[] { "itemFlint", null, "itemFlint", getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.fusewood", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolScrewdriver", "screwIron",
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.fusewood", 4, 0, missing),
                new Object[] { "screwSteel", "craftingToolScrewdriver", "screwSteel",
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "stair.fusewood", 4, 0, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 12, missing), null, null,
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing), null,
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing),
                        getModItem(Natura.ID, "planks", 1, 12, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.fusewood", 2, 0, missing),
                new Object[] { "screwWood", "craftingToolHardHammer", "screwWood",
                        getModItem(Natura.ID, "plankSlab2", 1, 4, missing), "springAnyIron",
                        getModItem(Natura.ID, "plankSlab2", 1, 4, missing), "screwWood", "craftingToolScrewdriver",
                        "screwWood" });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.fusewood", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab2", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing), "itemFlint",
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.fusewood", 2, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab2", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing), "screwIron",
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.fusewood", 3, 0, missing),
                new Object[] { getModItem(Natura.ID, "plankSlab2", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing), "screwSteel",
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 1, 12, missing),
                        getModItem(Natura.ID, "plankSlab2", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "button.fusewood", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "pressureplate.fusewood", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem(Natura.ID, "natura.emptybowl", 1, 12, missing),
                new Object[] { getModItem(Natura.ID, "planks", 1, 12, missing), "craftingToolKnife" });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "raspberryjuiceItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "juicerItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "raspberryItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "blueberryjuiceItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "juicerItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "blueberryItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(PamsHarvestCraft.ID, "blackberryjuiceItem", 1, 0, missing),
                new Object[] { getModItem(PamsHarvestCraft.ID, "juicerItem", 1, 0, missing),
                        getModItem(PamsHarvestCraft.ID, "blackberryItem", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "barley.seed", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "barleyFood", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "NetherFurnace", 1, 0, missing),
                new Object[] { "stoneNetherBrick", "stoneNetherBrick", "stoneNetherBrick", "itemFlint", "itemFlint",
                        "itemFlint", "stoneNetherBrick", "stoneNetherBrick", "stoneNetherBrick" });
        addShapedRecipe(
                getModItem(Natura.ID, "Obelisk", 1, 0, missing),
                new Object[] { getModItem(Natura.ID, "tree", 1, 2, missing),
                        getModItem(Natura.ID, "tree", 1, 2, missing), getModItem(Natura.ID, "tree", 1, 2, missing),
                        getModItem(Natura.ID, "tree", 1, 2, missing), "gemEnderPearl",
                        getModItem(Natura.ID, "tree", 1, 2, missing), getModItem(Natura.ID, "tree", 1, 2, missing),
                        getModItem(Natura.ID, "tree", 1, 2, missing), getModItem(Natura.ID, "tree", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "NetherPressurePlate", 2, 0, missing),
                new Object[] { "screwIron", "craftingToolHardHammer", "screwIron",
                        getModItem(Minecraft.ID, "netherrack", 1, 0, missing), "springAnyIron",
                        getModItem(Minecraft.ID, "netherrack", 1, 0, missing), "screwIron", "craftingToolScrewdriver",
                        "screwIron" });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "NetherButton", 2, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "NetherPressurePlate", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(Natura.ID, "NetherLever", 1, 0, missing),
                new Object[] { "stickWood", getModItem(Natura.ID, "NetherButton", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem(Natura.ID, "trapdoor.redwood", 1, 0, missing),
                        getModItem(Natura.ID, "redwood", 1, 1, missing), "screwCopper", "ringCopper",
                        getModItem(Natura.ID, "redwood", 1, 1, missing), "craftingToolSaw",
                        getModItem(Natura.ID, "redwood", 1, 1, missing),
                        getModItem(Natura.ID, "redwood", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", getModItem(Natura.ID, "trapdoor.redwood", 1, 0, missing),
                        getModItem(Natura.ID, "redwood", 1, 1, missing), "screwIron", "ringIron",
                        getModItem(Natura.ID, "redwood", 1, 1, missing), "craftingToolSaw",
                        getModItem(Natura.ID, "redwood", 1, 1, missing),
                        getModItem(Natura.ID, "redwood", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "trapdoor.redwood", 1, 0, missing),
                        getModItem(Natura.ID, "redwood", 1, 1, missing), "screwCopper", "ringCopper",
                        getModItem(Natura.ID, "redwood", 1, 1, missing), "craftingToolScrewdriver",
                        getModItem(Natura.ID, "redwood", 1, 1, missing),
                        getModItem(Natura.ID, "redwood", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 0, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "trapdoor.redwood", 1, 0, missing),
                        getModItem(Natura.ID, "redwood", 1, 1, missing), "screwIron", "ringIron",
                        getModItem(Natura.ID, "redwood", 1, 1, missing), "craftingToolScrewdriver",
                        getModItem(Natura.ID, "redwood", 1, 1, missing),
                        getModItem(Natura.ID, "redwood", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 1, missing),
                new Object[] { "craftingToolScrewdriver", getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing), "screwCopper", "ringCopper",
                        getModItem(Natura.ID, "planks", 1, 0, missing), "craftingToolSaw",
                        getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 1, missing),
                new Object[] { "craftingToolScrewdriver", getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing), "screwIron", "ringIron",
                        getModItem(Natura.ID, "planks", 1, 0, missing), "craftingToolSaw",
                        getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 1, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing), "screwCopper", "ringCopper",
                        getModItem(Natura.ID, "planks", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 1, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing), "screwIron", "ringIron",
                        getModItem(Natura.ID, "planks", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Natura.ID, "planks", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 2, missing),
                new Object[] { "craftingToolScrewdriver", getModItem(Natura.ID, "trapdoor.hopseed", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing), "screwCopper", "ringCopper",
                        getModItem(Natura.ID, "planks", 1, 5, missing), "craftingToolSaw",
                        getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 2, missing),
                new Object[] { "craftingToolScrewdriver", getModItem(Natura.ID, "trapdoor.hopseed", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing), "screwIron", "ringIron",
                        getModItem(Natura.ID, "planks", 1, 5, missing), "craftingToolSaw",
                        getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 2, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "trapdoor.hopseed", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing), "screwCopper", "ringCopper",
                        getModItem(Natura.ID, "planks", 1, 5, missing), "craftingToolScrewdriver",
                        getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 2, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "trapdoor.hopseed", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing), "screwIron", "ringIron",
                        getModItem(Natura.ID, "planks", 1, 5, missing), "craftingToolScrewdriver",
                        getModItem(Natura.ID, "planks", 1, 5, missing),
                        getModItem(Natura.ID, "planks", 1, 5, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 3, missing),
                new Object[] { "craftingToolScrewdriver", getModItem(Natura.ID, "trapdoor.sakura", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing), "screwCopper", "ringCopper",
                        getModItem(Natura.ID, "planks", 1, 1, missing), "craftingToolSaw",
                        getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 3, missing),
                new Object[] { "craftingToolScrewdriver", getModItem(Natura.ID, "trapdoor.sakura", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing), "screwIron", "ringIron",
                        getModItem(Natura.ID, "planks", 1, 1, missing), "craftingToolSaw",
                        getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 3, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "trapdoor.sakura", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing), "screwCopper", "ringCopper",
                        getModItem(Natura.ID, "planks", 1, 1, missing), "craftingToolScrewdriver",
                        getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 3, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "trapdoor.sakura", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing), "screwIron", "ringIron",
                        getModItem(Natura.ID, "planks", 1, 1, missing), "craftingToolScrewdriver",
                        getModItem(Natura.ID, "planks", 1, 1, missing),
                        getModItem(Natura.ID, "planks", 1, 1, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 4, missing),
                new Object[] { "craftingToolScrewdriver", getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing), "screwCopper", "ringCopper",
                        getModItem(Natura.ID, "planks", 1, 2, missing), "craftingToolSaw",
                        getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 4, missing),
                new Object[] { "craftingToolScrewdriver", getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing), "screwIron", "ringIron",
                        getModItem(Natura.ID, "planks", 1, 2, missing), "craftingToolSaw",
                        getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 4, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing), "screwCopper", "ringCopper",
                        getModItem(Natura.ID, "planks", 1, 2, missing), "craftingToolScrewdriver",
                        getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 4, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing), "screwIron", "ringIron",
                        getModItem(Natura.ID, "planks", 1, 2, missing), "craftingToolScrewdriver",
                        getModItem(Natura.ID, "planks", 1, 2, missing),
                        getModItem(Natura.ID, "planks", 1, 2, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 5, missing),
                new Object[] { "craftingToolScrewdriver", getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing), "screwCopper", "ringCopper",
                        getModItem(Natura.ID, "planks", 1, 4, missing), "craftingToolSaw",
                        getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 5, missing),
                new Object[] { "craftingToolScrewdriver", getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing), "screwIron", "ringIron",
                        getModItem(Natura.ID, "planks", 1, 4, missing), "craftingToolSaw",
                        getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 5, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing), "screwCopper", "ringCopper",
                        getModItem(Natura.ID, "planks", 1, 4, missing), "craftingToolScrewdriver",
                        getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 5, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing), "screwIron", "ringIron",
                        getModItem(Natura.ID, "planks", 1, 4, missing), "craftingToolScrewdriver",
                        getModItem(Natura.ID, "planks", 1, 4, missing),
                        getModItem(Natura.ID, "planks", 1, 4, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 6, missing),
                new Object[] { "craftingToolScrewdriver", getModItem(Natura.ID, "trapdoor.redwood", 1, 0, missing),
                        getModItem(Natura.ID, "redwood", 1, 0, missing), "screwCopper", "ringCopper",
                        getModItem(Natura.ID, "redwood", 1, 0, missing), "craftingToolSaw",
                        getModItem(Natura.ID, "redwood", 1, 0, missing),
                        getModItem(Natura.ID, "redwood", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 6, missing),
                new Object[] { "craftingToolScrewdriver", getModItem(Natura.ID, "trapdoor.redwood", 1, 0, missing),
                        getModItem(Natura.ID, "redwood", 1, 0, missing), "screwIron", "ringIron",
                        getModItem(Natura.ID, "redwood", 1, 0, missing), "craftingToolSaw",
                        getModItem(Natura.ID, "redwood", 1, 0, missing),
                        getModItem(Natura.ID, "redwood", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 6, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "trapdoor.redwood", 1, 0, missing),
                        getModItem(Natura.ID, "redwood", 1, 0, missing), "screwCopper", "ringCopper",
                        getModItem(Natura.ID, "redwood", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Natura.ID, "redwood", 1, 0, missing),
                        getModItem(Natura.ID, "redwood", 1, 0, missing) });
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 6, missing),
                new Object[] { "craftingToolSaw", getModItem(Natura.ID, "trapdoor.redwood", 1, 0, missing),
                        getModItem(Natura.ID, "redwood", 1, 0, missing), "screwIron", "ringIron",
                        getModItem(Natura.ID, "redwood", 1, 0, missing), "craftingToolScrewdriver",
                        getModItem(Natura.ID, "redwood", 1, 0, missing),
                        getModItem(Natura.ID, "redwood", 1, 0, missing) });

        ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 0, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 1, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 2, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 3, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 4, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 5, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 6, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 7, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 8, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 9, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 10, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 11, missing));
        ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 12, missing));

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass", 1, 0, missing),
                        getModItem(Minecraft.ID, "soul_sand", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "NetherGlass", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass", 1, 0, missing),
                        getModItem(Natura.ID, "heatsand", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "NetherGlass", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(16).addTo(sAlloySmelterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "flint_and_steel", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "natura.flintandblaze", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.blaze", 432)).noFluidOutputs().duration(200).eut(64)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 6, 0, missing),
                        getModItem(Minecraft.ID, "book", 3, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 6, 1, missing),
                        getModItem(Minecraft.ID, "book", 3, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 6, 2, missing),
                        getModItem(Minecraft.ID, "book", 3, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 6, 3, missing),
                        getModItem(Minecraft.ID, "book", 3, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 6, 4, missing),
                        getModItem(Minecraft.ID, "book", 3, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 6, 5, missing),
                        getModItem(Minecraft.ID, "book", 3, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 6, 6, missing),
                        getModItem(Minecraft.ID, "book", 3, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 6, 7, missing),
                        getModItem(Minecraft.ID, "book", 3, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 7, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 6, 8, missing),
                        getModItem(Minecraft.ID, "book", 3, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 8, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 6, 9, missing),
                        getModItem(Minecraft.ID, "book", 3, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 9, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 6, 10, missing),
                        getModItem(Minecraft.ID, "book", 3, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 10, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 6, 11, missing),
                        getModItem(Minecraft.ID, "book", 3, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 6, 12, missing),
                        getModItem(Minecraft.ID, "book", 3, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 12, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "tree", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.workbench", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "tree", 1, 1, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.workbench", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "tree", 1, 2, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.workbench", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "redwood", 1, 1, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.workbench", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "bloodwood", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.workbench", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "bloodwood", 1, 15, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.workbench", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "tree", 1, 3, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.workbench", 1, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "Rare Tree", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.workbench", 1, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "Rare Tree", 1, 1, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.workbench", 1, 7, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "Rare Tree", 1, 2, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.workbench", 1, 8, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "Rare Tree", 1, 3, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.workbench", 1, 9, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "willow", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.workbench", 1, 10, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "Dark Tree", 1, 0, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.workbench", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "Dark Tree", 1, 1, missing),
                        getModItem(Minecraft.ID, "flint", 2, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.workbench", 1, 12, missing)).noFluidInputs().noFluidOutputs()
                .duration(200).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.fence", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 1, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.fence", 1, 1, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 2, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.fence", 1, 2, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 3, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.fence", 1, 3, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 4, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.fence", 1, 4, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 5, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.fence", 1, 5, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 6, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.fence", 1, 6, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 7, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.fence", 1, 7, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 8, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.fence", 1, 8, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 9, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.fence", 1, 9, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 10, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.fence", 1, 10, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 11, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.fence", 1, 11, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 12, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "Natura.fence", 1, 12, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(4).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 2, 0, missing),
                        getModItem(Natura.ID, "planks", 2, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.eucalyptus", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 2, 1, missing),
                        getModItem(Natura.ID, "planks", 2, 1, missing))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.sakura", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 2, 2, missing),
                        getModItem(Natura.ID, "planks", 2, 2, missing))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.ghostwood", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 2, 3, missing),
                        getModItem(Natura.ID, "planks", 2, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.redwood", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 2, 4, missing),
                        getModItem(Natura.ID, "planks", 2, 4, missing))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.bloodwood", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 2, 5, missing),
                        getModItem(Natura.ID, "planks", 2, 5, missing))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.hopseed", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 2, 6, missing),
                        getModItem(Natura.ID, "planks", 2, 6, missing))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.maple", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 2, 7, missing),
                        getModItem(Natura.ID, "planks", 2, 7, missing))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.silverbell", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 2, 8, missing),
                        getModItem(Natura.ID, "planks", 2, 8, missing))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.amaranth", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 2, 9, missing),
                        getModItem(Natura.ID, "planks", 2, 9, missing))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.tiger", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 2, 10, missing),
                        getModItem(Natura.ID, "planks", 2, 10, missing))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.willow", 1, 0, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 2, 11, missing),
                        getModItem(Natura.ID, "planks", 2, 11, missing))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.darkwood", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 2, 12, missing),
                        getModItem(Natura.ID, "planks", 2, 12, missing))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.fusewood", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.eucalyptus", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.eucalyptus", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 1, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.sakura", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 1, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.sakura", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 2, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.ghostwood", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 2, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.ghostwood", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.redwood", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.redwood", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.bloodwood", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.bloodwood", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 5, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.hopseed", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 5, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 5, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.hopseed", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 6, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.maple", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 6, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 6, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.maple", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 7, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.silverbell", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 7, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 7, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.silverbell", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 8, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.amaranth", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 0, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 8, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.amaranth", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 9, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.tiger", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 1, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 9, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.tiger", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 10, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.willow", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 2, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 10, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.willow", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 11, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.darkwood", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 3, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 11, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.darkwood", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 12, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.fusewood", 4, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 4, missing),
                        getModItem(Natura.ID, "natura.stick", 4, 12, missing))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.fusewood", 6, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).noFluidOutputs().duration(600).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "redwood", 4, 1, missing),
                        getModItem(Natura.ID, "trapdoor.redwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "redwood", 4, 1, missing),
                        getModItem(Natura.ID, "trapdoor.redwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 4, 0, missing),
                        getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 4, 0, missing),
                        getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 4, 5, missing),
                        getModItem(Natura.ID, "trapdoor.hopseed", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 4, 5, missing),
                        getModItem(Natura.ID, "trapdoor.hopseed", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 4, 1, missing),
                        getModItem(Natura.ID, "trapdoor.sakura", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 4, 1, missing),
                        getModItem(Natura.ID, "trapdoor.sakura", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 4, 2, missing),
                        getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 4, 2, missing),
                        getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 4, 4, missing),
                        getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "planks", 4, 4, missing),
                        getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "redwood", 4, 0, missing),
                        getModItem(Natura.ID, "trapdoor.redwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "redwood", 4, 0, missing),
                        getModItem(Natura.ID, "trapdoor.redwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).noFluidOutputs().duration(400).eut(4)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 2, missing),
                        getModItem(Natura.ID, "barleyFood", 3, 7, missing))
                .itemOutputs(getModItem(Natura.ID, "natura.bow.ghostwood", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 4, missing),
                        getModItem(Natura.ID, "barleyFood", 3, 7, missing))
                .itemOutputs(getModItem(Natura.ID, "natura.bow.bloodwood", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 11, missing),
                        getModItem(Natura.ID, "barleyFood", 3, 7, missing))
                .itemOutputs(getModItem(Natura.ID, "natura.bow.darkwood", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "natura.stick", 3, 12, missing),
                        getModItem(Natura.ID, "barleyFood", 3, 7, missing))
                .itemOutputs(getModItem(Natura.ID, "natura.bow.fusewood", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(400).eut(16).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.eucalyptus", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.eucalyptus", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.sakura", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.sakura", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.ghostwood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.ghostwood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.redwood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.redwood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.bloodwood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.bloodwood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.hopseed", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.hopseed", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.maple", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.maple", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.silverbell", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.silverbell", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.amaranth", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.amaranth", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.tiger", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.tiger", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.willow", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.willow", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.darkwood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.darkwood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.fusewood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.fusewood", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "netherrack", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24032, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 9, missing))
                .itemOutputs(getModItem(Natura.ID, "NetherPressurePlate", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "netherrack", 2, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 24304, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 9, missing))
                .itemOutputs(getModItem(Natura.ID, "NetherPressurePlate", 2, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(100).eut(8).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.eucalyptus", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.eucalyptus", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.eucalyptus", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.eucalyptus", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.eucalyptus", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.eucalyptus", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.sakura", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.sakura", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.sakura", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.sakura", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.sakura", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.sakura", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.ghostwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.ghostwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.ghostwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.ghostwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.ghostwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.ghostwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.redwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.redwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.redwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.redwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.redwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.redwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.bloodwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.bloodwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.bloodwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.bloodwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.bloodwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.bloodwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.hopseed", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.hopseed", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.hopseed", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.hopseed", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.hopseed", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.hopseed", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.maple", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.maple", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.maple", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.maple", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.maple", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.maple", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.silverbell", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.silverbell", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.silverbell", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.silverbell", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.silverbell", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.silverbell", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.amaranth", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.amaranth", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.amaranth", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.amaranth", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.amaranth", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.amaranth", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.tiger", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.tiger", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.tiger", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.tiger", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.tiger", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.tiger", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.willow", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.willow", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.willow", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.willow", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.willow", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.willow", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.darkwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.darkwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.darkwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.darkwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.darkwood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.darkwood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.fusewood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.fusewood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.fusewood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.fusewood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.fusewood", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "button.fusewood", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "tree", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "tree", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "tree", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 6, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "tree", 1, 1, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "tree", 1, 1, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "tree", 1, 1, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 6, 1, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(8)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "tree", 1, 2, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "tree", 1, 2, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "tree", 1, 2, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 6, 2, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "redwood", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "redwood", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "redwood", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 6, 3, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "bloodwood", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "bloodwood", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "bloodwood", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 6, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "bloodwood", 1, 15, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "bloodwood", 1, 15, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "bloodwood", 1, 15, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 6, 4, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "tree", 1, 3, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "tree", 1, 3, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "tree", 1, 3, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 6, 5, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Rare Tree", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Rare Tree", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Rare Tree", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 6, 6, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Rare Tree", 1, 1, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Rare Tree", 1, 1, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Rare Tree", 1, 1, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 6, 7, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Rare Tree", 1, 2, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Rare Tree", 1, 2, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Rare Tree", 1, 2, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 6, 8, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Rare Tree", 1, 3, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Rare Tree", 1, 3, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Rare Tree", 1, 3, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 6, 9, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "willow", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 10, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "willow", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 10, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "willow", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 6, 10, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Dark Tree", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 11, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Dark Tree", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 11, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Dark Tree", 1, 0, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 6, 11, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Dark Tree", 1, 1, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 12, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Dark Tree", 1, 1, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 12, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 2, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(400).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Dark Tree", 1, 1, missing))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 6, 12, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(200).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 0, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 1, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 1, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 1, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 2, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 2, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 2, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 3, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 4, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 4, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 4, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 5, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 5, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 5, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 5, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 6, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 6, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 6, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 6, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 7, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 7, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 7, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab1", 2, 7, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 8, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab2", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 8, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab2", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 8, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab2", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 9, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab2", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 9, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab2", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 9, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab2", 2, 1, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 10, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab2", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 10, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab2", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 10, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab2", 2, 2, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 11, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab2", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 11, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab2", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 11, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab2", 2, 3, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 12, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab2", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 12, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab2", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).noFluidOutputs().duration(50).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "planks", 1, 12, missing))
                .itemOutputs(getModItem(Natura.ID, "plankSlab2", 2, 4, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).noFluidOutputs().duration(25).eut(4)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "tree", 1, 32767, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 2809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .outputChances(10000, 8000).noFluidInputs().noFluidOutputs().duration(400).eut(2)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "redwood", 1, 32767, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 2809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .outputChances(10000, 8000).noFluidInputs().noFluidOutputs().duration(400).eut(2)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "bloodwood", 1, 32767, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 2809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .outputChances(10000, 8000).noFluidInputs().noFluidOutputs().duration(400).eut(2)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Rare Tree", 1, 32767, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 2809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .outputChances(10000, 8000).noFluidInputs().noFluidOutputs().duration(400).eut(2)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "willow", 1, 32767, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 2809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .outputChances(10000, 8000).noFluidInputs().noFluidOutputs().duration(400).eut(2)
                .addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Dark Tree", 1, 32767, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 6, 2809, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2809, missing))
                .outputChances(10000, 8000).noFluidInputs().noFluidOutputs().duration(400).eut(2)
                .addTo(sMaceratorRecipes);
        GT_ModHandler.setFuelValue(getModItem(Natura.ID, "NetherPressurePlate", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem(Natura.ID, "pressureplate.eucalyptus", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem(Natura.ID, "pressureplate.sakura", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem(Natura.ID, "pressureplate.ghostwood", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem(Natura.ID, "pressureplate.redwood", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem(Natura.ID, "pressureplate.bloodwood", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem(Natura.ID, "pressureplate.hopseed", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem(Natura.ID, "pressureplate.maple", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem(Natura.ID, "pressureplate.amaranth", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem(Natura.ID, "pressureplate.silverbell", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem(Natura.ID, "pressureplate.tiger", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem(Natura.ID, "pressureplate.willow", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem(Natura.ID, "pressureplate.darkwood", 1, 0, missing), (short) 75);
        GT_ModHandler.setFuelValue(getModItem(Natura.ID, "pressureplate.fusewood", 1, 0, missing), (short) 75);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Bluebells", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.02", 2, 32418, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sExtractorRecipes);

    }
}
