package com.dreammaster.scripts;

import static com.dreammaster.main.MainRegistry.Module_CustomFuels;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.recipe.RecipeMaps.mixerRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.chisel.ChiselHelper;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;

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
        addShapelessRecipe(
                getModItem(Natura.ID, "barleyFood", 1, 3),
                getModItem(PamsHarvestCraft.ID, "cottonItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "cottonItem", 1, 0));
        addShapelessRecipe(getModItem(Natura.ID, "barley.seed", 1, 1), getModItem(Natura.ID, "barleyFood", 1, 3));
        addShapedRecipe(
                getModItem(Minecraft.ID, "leather", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Natura.ID, "barleyFood", 1, 6),
                getModItem(Natura.ID, "barleyFood", 1, 6),
                getModItem(Natura.ID, "barleyFood", 1, 6),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0),
                getModItem(Minecraft.ID, "string", 1, 0));
        addShapelessRecipe(
                getModItem(Natura.ID, "planks", 4, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "tree", 1, 0));
        addShapelessRecipe(getModItem(Natura.ID, "planks", 2, 0), getModItem(Natura.ID, "tree", 1, 0));
        addShapelessRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 0),
                getModItem(Natura.ID, "planks", 1, 0),
                getModItem(Natura.ID, "planks", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 0),
                "craftingToolSaw",
                null,
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 0),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 0),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 0),
                "itemFlint",
                "itemFlint",
                getModItem(Natura.ID, "tree", 1, 0),
                getModItem(Natura.ID, "tree", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 0),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 0),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 0),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 0),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 0),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 0),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 0),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab1", 2, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 0),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.eucalyptus", 1, 0),
                "itemFlint",
                null,
                "itemFlint",
                getModItem(Natura.ID, "planks", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 0),
                getModItem(Natura.ID, "planks", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.eucalyptus", 2, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                getModItem(Natura.ID, "planks", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 0),
                getModItem(Natura.ID, "planks", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.eucalyptus", 4, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(Natura.ID, "planks", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 0),
                getModItem(Natura.ID, "planks", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.eucalyptus", 2, 0),
                "screwWood",
                "craftingToolHardHammer",
                "screwWood",
                getModItem(Natura.ID, "plankSlab1", 1, 0),
                "springAnyIron",
                getModItem(Natura.ID, "plankSlab1", 1, 0),
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood");
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 0),
                "stickWood",
                "itemFlint",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.eucalyptus", 2, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 0),
                "stickWood",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.eucalyptus", 3, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 0),
                "stickWood",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "button.eucalyptus", 2, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "pressureplate.eucalyptus", 1, 0),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "planks", 4, 1),
                "craftingToolSaw",
                getModItem(Natura.ID, "tree", 1, 1));
        addShapelessRecipe(getModItem(Natura.ID, "planks", 2, 1), getModItem(Natura.ID, "tree", 1, 1));
        addShapelessRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 1),
                getModItem(Natura.ID, "planks", 1, 1),
                getModItem(Natura.ID, "planks", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 1),
                "craftingToolSaw",
                null,
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 1),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 1),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 1),
                "itemFlint",
                "itemFlint",
                getModItem(Natura.ID, "tree", 1, 1),
                getModItem(Natura.ID, "tree", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 1),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 1),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 1),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 1),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 1),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 1),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 1),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 1),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 1),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab1", 2, 1),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 1),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.sakura", 1, 0),
                "itemFlint",
                null,
                "itemFlint",
                getModItem(Natura.ID, "planks", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 1),
                getModItem(Natura.ID, "planks", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.sakura", 2, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                getModItem(Natura.ID, "planks", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 1),
                getModItem(Natura.ID, "planks", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.sakura", 4, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(Natura.ID, "planks", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 1),
                getModItem(Natura.ID, "planks", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "stair.sakura", 4, 0),
                getModItem(Natura.ID, "planks", 1, 1),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 1),
                getModItem(Natura.ID, "planks", 1, 1),
                null,
                getModItem(Natura.ID, "planks", 1, 1),
                getModItem(Natura.ID, "planks", 1, 1),
                getModItem(Natura.ID, "planks", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.sakura", 2, 0),
                "screwWood",
                "craftingToolHardHammer",
                "screwWood",
                getModItem(Natura.ID, "plankSlab1", 1, 1),
                "springAnyIron",
                getModItem(Natura.ID, "plankSlab1", 1, 1),
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood");
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.sakura", 1, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 1),
                "stickWood",
                "itemFlint",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.sakura", 2, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 1),
                "stickWood",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.sakura", 3, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 1),
                "stickWood",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "button.sakura", 2, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "pressureplate.sakura", 1, 0),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "natura.emptybowl", 1, 2),
                getModItem(Natura.ID, "planks", 1, 2),
                "craftingToolKnife");
        addShapelessRecipe(
                getModItem(Natura.ID, "planks", 4, 2),
                "craftingToolSaw",
                getModItem(Natura.ID, "tree", 1, 2));
        addShapelessRecipe(getModItem(Natura.ID, "planks", 2, 2), getModItem(Natura.ID, "tree", 1, 2));
        addShapelessRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 2),
                getModItem(Natura.ID, "planks", 1, 2),
                getModItem(Natura.ID, "planks", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 2),
                "craftingToolSaw",
                null,
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 2),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 2),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 2),
                "itemFlint",
                "itemFlint",
                getModItem(Natura.ID, "tree", 1, 2),
                getModItem(Natura.ID, "tree", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 2),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 2),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 2),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 2),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 2),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 2),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 2),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 2),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 2),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab1", 2, 2),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 2),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.ghostwood", 1, 0),
                "itemFlint",
                null,
                "itemFlint",
                getModItem(Natura.ID, "planks", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 2),
                getModItem(Natura.ID, "planks", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.ghostwood", 2, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                getModItem(Natura.ID, "planks", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 2),
                getModItem(Natura.ID, "planks", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.ghostwood", 4, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(Natura.ID, "planks", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 2),
                getModItem(Natura.ID, "planks", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "stair.ghostwood", 4, 0),
                getModItem(Natura.ID, "planks", 1, 2),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 2),
                getModItem(Natura.ID, "planks", 1, 2),
                null,
                getModItem(Natura.ID, "planks", 1, 2),
                getModItem(Natura.ID, "planks", 1, 2),
                getModItem(Natura.ID, "planks", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.ghostwood", 2, 0),
                "screwWood",
                "craftingToolHardHammer",
                "screwWood",
                getModItem(Natura.ID, "plankSlab1", 1, 2),
                "springAnyIron",
                getModItem(Natura.ID, "plankSlab1", 1, 2),
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood");
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 2),
                "stickWood",
                "itemFlint",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.ghostwood", 2, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 2),
                "stickWood",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.ghostwood", 3, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 2),
                "stickWood",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "button.ghostwood", 2, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "pressureplate.ghostwood", 1, 0),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "planks", 4, 3),
                "craftingToolSaw",
                getModItem(Natura.ID, "redwood", 1, 1));
        addShapelessRecipe(getModItem(Natura.ID, "planks", 2, 3), getModItem(Natura.ID, "redwood", 1, 1));
        addShapelessRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 3),
                getModItem(Natura.ID, "planks", 1, 3),
                getModItem(Natura.ID, "planks", 1, 3));
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 3),
                "craftingToolSaw",
                null,
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 3),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 3),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 3),
                "itemFlint",
                "itemFlint",
                getModItem(Natura.ID, "redwood", 1, 1),
                getModItem(Natura.ID, "redwood", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 3),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 3),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 3),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 3),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 3),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 3),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 3),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 3),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 3),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab1", 2, 3),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 3),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.redwood", 1, 0),
                "itemFlint",
                null,
                "itemFlint",
                getModItem(Natura.ID, "planks", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 3),
                getModItem(Natura.ID, "planks", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 3));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.redwood", 2, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                getModItem(Natura.ID, "planks", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 3),
                getModItem(Natura.ID, "planks", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 3));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.redwood", 4, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(Natura.ID, "planks", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 3),
                getModItem(Natura.ID, "planks", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 3));
        addShapedRecipe(
                getModItem(Natura.ID, "stair.redwood", 4, 0),
                getModItem(Natura.ID, "planks", 1, 3),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 3),
                getModItem(Natura.ID, "planks", 1, 3),
                null,
                getModItem(Natura.ID, "planks", 1, 3),
                getModItem(Natura.ID, "planks", 1, 3),
                getModItem(Natura.ID, "planks", 1, 3));
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.redwood", 2, 0),
                "screwWood",
                "craftingToolHardHammer",
                "screwWood",
                getModItem(Natura.ID, "plankSlab1", 1, 3),
                "springAnyIron",
                getModItem(Natura.ID, "plankSlab1", 1, 3),
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood");
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.redwood", 1, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 3),
                "stickWood",
                "itemFlint",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 3));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.redwood", 2, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 3),
                "stickWood",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 3));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.redwood", 3, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 3),
                "stickWood",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 3));
        addShapedRecipe(
                getModItem(Natura.ID, "button.redwood", 2, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "pressureplate.redwood", 1, 0),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "planks", 4, 4),
                "craftingToolSaw",
                getModItem(Natura.ID, "bloodwood", 1, 0));
        addShapelessRecipe(getModItem(Natura.ID, "planks", 2, 4), getModItem(Natura.ID, "bloodwood", 1, 0));
        addShapelessRecipe(
                getModItem(Natura.ID, "planks", 4, 4),
                "craftingToolSaw",
                getModItem(Natura.ID, "bloodwood", 1, 15));
        addShapelessRecipe(getModItem(Natura.ID, "planks", 2, 4), getModItem(Natura.ID, "bloodwood", 1, 15));
        addShapelessRecipe(
                getModItem(Natura.ID, "planks", 4, 4),
                "craftingToolSaw",
                getModItem(Natura.ID, "bloodwood", 1, 1));
        addShapelessRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 4),
                getModItem(Natura.ID, "planks", 1, 4),
                getModItem(Natura.ID, "planks", 1, 4));
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 4),
                "craftingToolSaw",
                null,
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 4),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 4),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 4),
                "itemFlint",
                "itemFlint",
                getModItem(Natura.ID, "bloodwood", 1, 0),
                getModItem(Natura.ID, "bloodwood", 1, 0));
        addShapelessRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 4),
                "itemFlint",
                "itemFlint",
                getModItem(Natura.ID, "bloodwood", 1, 15),
                getModItem(Natura.ID, "bloodwood", 1, 15));
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 4),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 4),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 4),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 4),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 4),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 4),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 4),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 4),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 4),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab1", 2, 4),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 4),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.bloodwood", 1, 0),
                "itemFlint",
                null,
                "itemFlint",
                getModItem(Natura.ID, "planks", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 4),
                getModItem(Natura.ID, "planks", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 4));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.bloodwood", 2, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                getModItem(Natura.ID, "planks", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 4),
                getModItem(Natura.ID, "planks", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 4));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.bloodwood", 4, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(Natura.ID, "planks", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 4),
                getModItem(Natura.ID, "planks", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 4));
        addShapedRecipe(
                getModItem(Natura.ID, "stair.bloodwood", 4, 0),
                getModItem(Natura.ID, "planks", 1, 4),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 4),
                getModItem(Natura.ID, "planks", 1, 4),
                null,
                getModItem(Natura.ID, "planks", 1, 4),
                getModItem(Natura.ID, "planks", 1, 4),
                getModItem(Natura.ID, "planks", 1, 4));
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.bloodwood", 2, 0),
                "screwWood",
                "craftingToolHardHammer",
                "screwWood",
                getModItem(Natura.ID, "plankSlab1", 1, 4),
                "springAnyIron",
                getModItem(Natura.ID, "plankSlab1", 1, 4),
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood");
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 4),
                "stickWood",
                "itemFlint",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 4));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.bloodwood", 2, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 4),
                "stickWood",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 4));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.bloodwood", 3, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 4),
                "stickWood",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 4));
        addShapedRecipe(
                getModItem(Natura.ID, "button.bloodwood", 2, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "pressureplate.bloodwood", 1, 0),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "natura.emptybowl", 1, 4),
                getModItem(Natura.ID, "planks", 1, 4),
                "craftingToolKnife");
        addShapelessRecipe(
                getModItem(Natura.ID, "planks", 4, 5),
                "craftingToolSaw",
                getModItem(Natura.ID, "tree", 1, 3));
        addShapelessRecipe(getModItem(Natura.ID, "planks", 2, 5), getModItem(Natura.ID, "tree", 1, 3));
        addShapelessRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 5),
                getModItem(Natura.ID, "planks", 1, 5),
                getModItem(Natura.ID, "planks", 1, 5));
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 5),
                "craftingToolSaw",
                null,
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 5),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 5),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 5),
                "itemFlint",
                "itemFlint",
                getModItem(Natura.ID, "tree", 1, 3),
                getModItem(Natura.ID, "tree", 1, 3));
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 5),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 5),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 5),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 5),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 5),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 5),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 5),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 5),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 5),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 5),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab1", 2, 5),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 5),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.hopseed", 1, 0),
                "itemFlint",
                null,
                "itemFlint",
                getModItem(Natura.ID, "planks", 1, 5),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 5),
                getModItem(Natura.ID, "planks", 1, 5),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 5));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.hopseed", 2, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                getModItem(Natura.ID, "planks", 1, 5),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 5),
                getModItem(Natura.ID, "planks", 1, 5),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 5));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.hopseed", 4, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(Natura.ID, "planks", 1, 5),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 5),
                getModItem(Natura.ID, "planks", 1, 5),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 5));
        addShapedRecipe(
                getModItem(Natura.ID, "stair.hopseed", 4, 0),
                getModItem(Natura.ID, "planks", 1, 5),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 5),
                getModItem(Natura.ID, "planks", 1, 5),
                null,
                getModItem(Natura.ID, "planks", 1, 5),
                getModItem(Natura.ID, "planks", 1, 5),
                getModItem(Natura.ID, "planks", 1, 5));
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.hopseed", 2, 0),
                "screwWood",
                "craftingToolHardHammer",
                "screwWood",
                getModItem(Natura.ID, "plankSlab1", 1, 5),
                "springAnyIron",
                getModItem(Natura.ID, "plankSlab1", 1, 5),
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood");
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.hopseed", 1, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 5),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 5),
                "stickWood",
                "itemFlint",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 5),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 5));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.hopseed", 2, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 5),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 5),
                "stickWood",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 5),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 5));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.hopseed", 3, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 5),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 5),
                "stickWood",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 5),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 5));
        addShapedRecipe(
                getModItem(Natura.ID, "button.hopseed", 2, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "pressureplate.hopseed", 1, 0),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "planks", 4, 6),
                "craftingToolSaw",
                getModItem(Natura.ID, "Rare Tree", 1, 0));
        addShapelessRecipe(getModItem(Natura.ID, "planks", 2, 6), getModItem(Natura.ID, "Rare Tree", 1, 0));
        addShapelessRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 6),
                getModItem(Natura.ID, "planks", 1, 6),
                getModItem(Natura.ID, "planks", 1, 6));
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 6),
                "craftingToolSaw",
                null,
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 6),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 6),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 6),
                "itemFlint",
                "itemFlint",
                getModItem(Natura.ID, "Rare Tree", 1, 0),
                getModItem(Natura.ID, "Rare Tree", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 6),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 6),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 6),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 6),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 6),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 6),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 6),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 6),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 6),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 6),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab1", 2, 6),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 6),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.maple", 1, 0),
                "itemFlint",
                null,
                "itemFlint",
                getModItem(Natura.ID, "planks", 1, 6),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 6),
                getModItem(Natura.ID, "planks", 1, 6),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 6));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.maple", 2, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                getModItem(Natura.ID, "planks", 1, 6),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 6),
                getModItem(Natura.ID, "planks", 1, 6),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 6));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.maple", 4, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(Natura.ID, "planks", 1, 6),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 6),
                getModItem(Natura.ID, "planks", 1, 6),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 6));
        addShapedRecipe(
                getModItem(Natura.ID, "stair.maple", 4, 0),
                getModItem(Natura.ID, "planks", 1, 6),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 6),
                getModItem(Natura.ID, "planks", 1, 6),
                null,
                getModItem(Natura.ID, "planks", 1, 6),
                getModItem(Natura.ID, "planks", 1, 6),
                getModItem(Natura.ID, "planks", 1, 6));
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.maple", 2, 0),
                "screwWood",
                "craftingToolHardHammer",
                "screwWood",
                getModItem(Natura.ID, "plankSlab1", 1, 6),
                "springAnyIron",
                getModItem(Natura.ID, "plankSlab1", 1, 6),
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood");
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.maple", 1, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 6),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 6),
                "stickWood",
                "itemFlint",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 6),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 6));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.maple", 2, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 6),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 6),
                "stickWood",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 6),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 6));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.maple", 3, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 6),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 6),
                "stickWood",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 6),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 6));
        addShapedRecipe(
                getModItem(Natura.ID, "button.maple", 2, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "pressureplate.maple", 1, 0),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "planks", 4, 7),
                "craftingToolSaw",
                getModItem(Natura.ID, "Rare Tree", 1, 1));
        addShapelessRecipe(getModItem(Natura.ID, "planks", 2, 7), getModItem(Natura.ID, "Rare Tree", 1, 1));
        addShapelessRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 7),
                getModItem(Natura.ID, "planks", 1, 7),
                getModItem(Natura.ID, "planks", 1, 7));
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 7),
                "craftingToolSaw",
                null,
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 7),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 7),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 7),
                "itemFlint",
                "itemFlint",
                getModItem(Natura.ID, "Rare Tree", 1, 1),
                getModItem(Natura.ID, "Rare Tree", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 7),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 7),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 7),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 7),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 7),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 7),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 7),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 7),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 7),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 7),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab1", 2, 7),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 7),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.silverbell", 1, 0),
                "itemFlint",
                null,
                "itemFlint",
                getModItem(Natura.ID, "planks", 1, 7),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 7),
                getModItem(Natura.ID, "planks", 1, 7),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 7));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.silverbell", 2, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                getModItem(Natura.ID, "planks", 1, 7),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 7),
                getModItem(Natura.ID, "planks", 1, 7),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 7));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.silverbell", 4, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(Natura.ID, "planks", 1, 7),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 7),
                getModItem(Natura.ID, "planks", 1, 7),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 7));
        addShapedRecipe(
                getModItem(Natura.ID, "stair.silverbell", 4, 0),
                getModItem(Natura.ID, "planks", 1, 7),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 7),
                getModItem(Natura.ID, "planks", 1, 7),
                null,
                getModItem(Natura.ID, "planks", 1, 7),
                getModItem(Natura.ID, "planks", 1, 7),
                getModItem(Natura.ID, "planks", 1, 7));
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.silverbell", 2, 0),
                "screwWood",
                "craftingToolHardHammer",
                "screwWood",
                getModItem(Natura.ID, "plankSlab1", 1, 7),
                "springAnyIron",
                getModItem(Natura.ID, "plankSlab1", 1, 7),
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood");
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.silverbell", 1, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 7),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 7),
                "stickWood",
                "itemFlint",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 7),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 7));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.silverbell", 2, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 7),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 7),
                "stickWood",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 7),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 7));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.silverbell", 3, 0),
                getModItem(Natura.ID, "plankSlab1", 1, 7),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 7),
                "stickWood",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 7),
                "stickWood",
                getModItem(Natura.ID, "plankSlab1", 1, 7));
        addShapedRecipe(
                getModItem(Natura.ID, "button.silverbell", 2, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "pressureplate.silverbell", 1, 0),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "planks", 4, 8),
                "craftingToolSaw",
                getModItem(Natura.ID, "Rare Tree", 1, 2));
        addShapelessRecipe(getModItem(Natura.ID, "planks", 2, 8), getModItem(Natura.ID, "Rare Tree", 1, 2));
        addShapelessRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 8),
                getModItem(Natura.ID, "planks", 1, 8),
                getModItem(Natura.ID, "planks", 1, 8));
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 8),
                "craftingToolSaw",
                null,
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 8),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 8),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 8),
                "itemFlint",
                "itemFlint",
                getModItem(Natura.ID, "Rare Tree", 1, 2),
                getModItem(Natura.ID, "Rare Tree", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 8),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 8),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 8),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 8),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 8),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 8),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 8),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 8),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 8),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 8),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab2", 2, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 8),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.amaranth", 1, 0),
                "itemFlint",
                null,
                "itemFlint",
                getModItem(Natura.ID, "planks", 1, 8),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 8),
                getModItem(Natura.ID, "planks", 1, 8),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 8));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.amaranth", 2, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                getModItem(Natura.ID, "planks", 1, 8),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 8),
                getModItem(Natura.ID, "planks", 1, 8),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 8));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.amaranth", 4, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(Natura.ID, "planks", 1, 8),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 8),
                getModItem(Natura.ID, "planks", 1, 8),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 8));
        addShapedRecipe(
                getModItem(Natura.ID, "stair.amaranth", 4, 0),
                getModItem(Natura.ID, "planks", 1, 8),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 8),
                getModItem(Natura.ID, "planks", 1, 8),
                null,
                getModItem(Natura.ID, "planks", 1, 8),
                getModItem(Natura.ID, "planks", 1, 8),
                getModItem(Natura.ID, "planks", 1, 8));
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.amaranth", 2, 0),
                "screwWood",
                "craftingToolHardHammer",
                "screwWood",
                getModItem(Natura.ID, "plankSlab2", 1, 0),
                "springAnyIron",
                getModItem(Natura.ID, "plankSlab2", 1, 0),
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood");
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.amaranth", 1, 0),
                getModItem(Natura.ID, "plankSlab2", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 0),
                "stickWood",
                "itemFlint",
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.amaranth", 2, 0),
                getModItem(Natura.ID, "plankSlab2", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 0),
                "stickWood",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.amaranth", 3, 0),
                getModItem(Natura.ID, "plankSlab2", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 0),
                "stickWood",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "button.amaranth", 2, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "pressureplate.amaranth", 1, 0),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "planks", 4, 9),
                "craftingToolSaw",
                getModItem(Natura.ID, "Rare Tree", 1, 3));
        addShapelessRecipe(getModItem(Natura.ID, "planks", 2, 9), getModItem(Natura.ID, "Rare Tree", 1, 3));
        addShapelessRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 9),
                getModItem(Natura.ID, "planks", 1, 9),
                getModItem(Natura.ID, "planks", 1, 9));
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 9),
                "craftingToolSaw",
                null,
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 9),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 9),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 9),
                "itemFlint",
                "itemFlint",
                getModItem(Natura.ID, "Rare Tree", 1, 3),
                getModItem(Natura.ID, "Rare Tree", 1, 3));
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 9),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 9),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 9),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 9),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 9),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 9),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 9),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 9),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 9),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 9),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab2", 2, 1),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 9),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.tiger", 1, 0),
                "itemFlint",
                null,
                "itemFlint",
                getModItem(Natura.ID, "planks", 1, 9),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 9),
                getModItem(Natura.ID, "planks", 1, 9),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 9));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.tiger", 2, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                getModItem(Natura.ID, "planks", 1, 9),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 9),
                getModItem(Natura.ID, "planks", 1, 9),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 9));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.tiger", 4, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(Natura.ID, "planks", 1, 9),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 9),
                getModItem(Natura.ID, "planks", 1, 9),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 9));
        addShapedRecipe(
                getModItem(Natura.ID, "stair.tiger", 4, 0),
                getModItem(Natura.ID, "planks", 1, 9),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 9),
                getModItem(Natura.ID, "planks", 1, 9),
                null,
                getModItem(Natura.ID, "planks", 1, 9),
                getModItem(Natura.ID, "planks", 1, 9),
                getModItem(Natura.ID, "planks", 1, 9));
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.tiger", 2, 0),
                "screwWood",
                "craftingToolHardHammer",
                "screwWood",
                getModItem(Natura.ID, "plankSlab2", 1, 1),
                "springAnyIron",
                getModItem(Natura.ID, "plankSlab2", 1, 1),
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood");
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.tiger", 1, 0),
                getModItem(Natura.ID, "plankSlab2", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 1),
                "stickWood",
                "itemFlint",
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.tiger", 2, 0),
                getModItem(Natura.ID, "plankSlab2", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 1),
                "stickWood",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.tiger", 3, 0),
                getModItem(Natura.ID, "plankSlab2", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 1),
                "stickWood",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 1),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "button.tiger", 2, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "pressureplate.tiger", 1, 0),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "planks", 4, 10),
                "craftingToolSaw",
                getModItem(Natura.ID, "willow", 1, 0));
        addShapelessRecipe(getModItem(Natura.ID, "planks", 2, 10), getModItem(Natura.ID, "willow", 1, 0));
        addShapelessRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 10),
                getModItem(Natura.ID, "planks", 1, 10),
                getModItem(Natura.ID, "planks", 1, 10));
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 10),
                "craftingToolSaw",
                null,
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 10),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 10),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 10),
                "itemFlint",
                "itemFlint",
                getModItem(Natura.ID, "willow", 1, 0),
                getModItem(Natura.ID, "willow", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 10),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 10),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 10),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 10),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 10),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 10),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 10),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 10),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 10),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 10),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab2", 2, 2),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 10),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.willow", 1, 0),
                "itemFlint",
                null,
                "itemFlint",
                getModItem(Natura.ID, "planks", 1, 10),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 10),
                getModItem(Natura.ID, "planks", 1, 10),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 10));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.willow", 2, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                getModItem(Natura.ID, "planks", 1, 10),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 10),
                getModItem(Natura.ID, "planks", 1, 10),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 10));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.willow", 4, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(Natura.ID, "planks", 1, 10),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 10),
                getModItem(Natura.ID, "planks", 1, 10),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 10));
        addShapedRecipe(
                getModItem(Natura.ID, "stair.willow", 4, 0),
                getModItem(Natura.ID, "planks", 1, 10),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 10),
                getModItem(Natura.ID, "planks", 1, 10),
                null,
                getModItem(Natura.ID, "planks", 1, 10),
                getModItem(Natura.ID, "planks", 1, 10),
                getModItem(Natura.ID, "planks", 1, 10));
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.willow", 2, 0),
                "screwWood",
                "craftingToolHardHammer",
                "screwWood",
                getModItem(Natura.ID, "plankSlab2", 1, 2),
                "springAnyIron",
                getModItem(Natura.ID, "plankSlab2", 1, 2),
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood");
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.willow", 1, 0),
                getModItem(Natura.ID, "plankSlab2", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 2),
                "stickWood",
                "itemFlint",
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.willow", 2, 0),
                getModItem(Natura.ID, "plankSlab2", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 2),
                "stickWood",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.willow", 3, 0),
                getModItem(Natura.ID, "plankSlab2", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 2),
                "stickWood",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 2),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "button.willow", 2, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "pressureplate.willow", 1, 0),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "planks", 4, 11),
                "craftingToolSaw",
                getModItem(Natura.ID, "Dark Tree", 1, 0));
        addShapelessRecipe(getModItem(Natura.ID, "planks", 2, 11), getModItem(Natura.ID, "Dark Tree", 1, 0));
        addShapelessRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 11),
                getModItem(Natura.ID, "planks", 1, 11),
                getModItem(Natura.ID, "planks", 1, 11));
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 11),
                "craftingToolSaw",
                null,
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 11),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 11),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 11),
                "itemFlint",
                "itemFlint",
                getModItem(Natura.ID, "Dark Tree", 1, 0),
                getModItem(Natura.ID, "Dark Tree", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 11),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 11),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 11),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 11),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 11),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 11),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 11),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 11),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 11),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 11),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab2", 2, 3),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 11),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.darkwood", 1, 0),
                "itemFlint",
                null,
                "itemFlint",
                getModItem(Natura.ID, "planks", 1, 11),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 11),
                getModItem(Natura.ID, "planks", 1, 11),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 11));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.darkwood", 2, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                getModItem(Natura.ID, "planks", 1, 11),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 11),
                getModItem(Natura.ID, "planks", 1, 11),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 11));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.darkwood", 4, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(Natura.ID, "planks", 1, 11),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 11),
                getModItem(Natura.ID, "planks", 1, 11),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 11));
        addShapedRecipe(
                getModItem(Natura.ID, "stair.darkwood", 4, 0),
                getModItem(Natura.ID, "planks", 1, 11),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 11),
                getModItem(Natura.ID, "planks", 1, 11),
                null,
                getModItem(Natura.ID, "planks", 1, 11),
                getModItem(Natura.ID, "planks", 1, 11),
                getModItem(Natura.ID, "planks", 1, 11));
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.darkwood", 2, 0),
                "screwWood",
                "craftingToolHardHammer",
                "screwWood",
                getModItem(Natura.ID, "plankSlab2", 1, 3),
                "springAnyIron",
                getModItem(Natura.ID, "plankSlab2", 1, 3),
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood");
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.darkwood", 1, 0),
                getModItem(Natura.ID, "plankSlab2", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 3),
                "stickWood",
                "itemFlint",
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 3));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.darkwood", 2, 0),
                getModItem(Natura.ID, "plankSlab2", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 3),
                "stickWood",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 3));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.darkwood", 3, 0),
                getModItem(Natura.ID, "plankSlab2", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 3),
                "stickWood",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 3),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 3));
        addShapedRecipe(
                getModItem(Natura.ID, "button.darkwood", 2, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "pressureplate.darkwood", 1, 0),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "natura.emptybowl", 1, 11),
                getModItem(Natura.ID, "planks", 1, 11),
                "craftingToolKnife");
        addShapelessRecipe(
                getModItem(Natura.ID, "planks", 4, 12),
                "craftingToolSaw",
                getModItem(Natura.ID, "Dark Tree", 1, 1));
        addShapelessRecipe(getModItem(Natura.ID, "planks", 2, 12), getModItem(Natura.ID, "Dark Tree", 1, 1));
        addShapelessRecipe(
                getModItem(Natura.ID, "natura.stick", 2, 12),
                getModItem(Natura.ID, "planks", 1, 12),
                getModItem(Natura.ID, "planks", 1, 12));
        addShapedRecipe(
                getModItem(Natura.ID, "natura.stick", 4, 12),
                "craftingToolSaw",
                null,
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 12),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 12),
                null);
        addShapelessRecipe(
                getModItem(Natura.ID, "Natura.workbench", 1, 12),
                "itemFlint",
                "itemFlint",
                getModItem(Natura.ID, "Dark Tree", 1, 1),
                getModItem(Natura.ID, "Dark Tree", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 1, 12),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 12),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 12),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 12),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 2, 12),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 12),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 12),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "Natura.fence", 4, 12),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 12),
                "stickWood",
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 12),
                "stickWood");
        addShapedRecipe(
                getModItem(Natura.ID, "plankSlab2", 2, 4),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 12),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.fusewood", 1, 0),
                "itemFlint",
                null,
                "itemFlint",
                getModItem(Natura.ID, "planks", 1, 12),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 12),
                getModItem(Natura.ID, "planks", 1, 12),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 12));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.fusewood", 2, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron",
                getModItem(Natura.ID, "planks", 1, 12),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 12),
                getModItem(Natura.ID, "planks", 1, 12),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 12));
        addShapedRecipe(
                getModItem(Natura.ID, "fenceGate.fusewood", 4, 0),
                "screwSteel",
                "craftingToolScrewdriver",
                "screwSteel",
                getModItem(Natura.ID, "planks", 1, 12),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 12),
                getModItem(Natura.ID, "planks", 1, 12),
                "stickWood",
                getModItem(Natura.ID, "planks", 1, 12));
        addShapedRecipe(
                getModItem(Natura.ID, "stair.fusewood", 4, 0),
                getModItem(Natura.ID, "planks", 1, 12),
                null,
                null,
                getModItem(Natura.ID, "planks", 1, 12),
                getModItem(Natura.ID, "planks", 1, 12),
                null,
                getModItem(Natura.ID, "planks", 1, 12),
                getModItem(Natura.ID, "planks", 1, 12),
                getModItem(Natura.ID, "planks", 1, 12));
        addShapedRecipe(
                getModItem(Natura.ID, "pressureplate.fusewood", 2, 0),
                "screwWood",
                "craftingToolHardHammer",
                "screwWood",
                getModItem(Natura.ID, "plankSlab2", 1, 4),
                "springAnyIron",
                getModItem(Natura.ID, "plankSlab2", 1, 4),
                "screwWood",
                "craftingToolScrewdriver",
                "screwWood");
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.fusewood", 1, 0),
                getModItem(Natura.ID, "plankSlab2", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 4),
                "stickWood",
                "itemFlint",
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 4));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.fusewood", 2, 0),
                getModItem(Natura.ID, "plankSlab2", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 4),
                "stickWood",
                "screwIron",
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 4));
        addShapedRecipe(
                getModItem(Natura.ID, "trapdoor.fusewood", 3, 0),
                getModItem(Natura.ID, "plankSlab2", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 4),
                "stickWood",
                "screwSteel",
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 4),
                "stickWood",
                getModItem(Natura.ID, "plankSlab2", 1, 4));
        addShapedRecipe(
                getModItem(Natura.ID, "button.fusewood", 2, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "pressureplate.fusewood", 1, 0),
                null);
        addShapedRecipe(
                getModItem(Natura.ID, "natura.emptybowl", 1, 12),
                getModItem(Natura.ID, "planks", 1, 12),
                "craftingToolKnife");
        addShapelessRecipe(
                getModItem(PamsHarvestCraft.ID, "raspberryjuiceItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "juicerItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "raspberryItem", 1, 0));
        addShapelessRecipe(
                getModItem(PamsHarvestCraft.ID, "blueberryjuiceItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "juicerItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "blueberryItem", 1, 0));
        addShapelessRecipe(
                getModItem(PamsHarvestCraft.ID, "blackberryjuiceItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "juicerItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "blackberryItem", 1, 0));
        addShapelessRecipe(getModItem(Natura.ID, "barley.seed", 1, 0), getModItem(Natura.ID, "barleyFood", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "NetherFurnace", 1, 0),
                "stoneNetherBrick",
                "stoneNetherBrick",
                "stoneNetherBrick",
                "itemFlint",
                "itemFlint",
                "itemFlint",
                "stoneNetherBrick",
                "stoneNetherBrick",
                "stoneNetherBrick");
        addShapedRecipe(
                getModItem(Natura.ID, "Obelisk", 1, 0),
                getModItem(Natura.ID, "tree", 1, 2),
                getModItem(Natura.ID, "tree", 1, 2),
                getModItem(Natura.ID, "tree", 1, 2),
                getModItem(Natura.ID, "tree", 1, 2),
                "gemEnderPearl",
                getModItem(Natura.ID, "tree", 1, 2),
                getModItem(Natura.ID, "tree", 1, 2),
                getModItem(Natura.ID, "tree", 1, 2),
                getModItem(Natura.ID, "tree", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "NetherPressurePlate", 2, 0),
                "screwIron",
                "craftingToolHardHammer",
                "screwIron",
                getModItem(Minecraft.ID, "netherrack", 1, 0),
                "springAnyIron",
                getModItem(Minecraft.ID, "netherrack", 1, 0),
                "screwIron",
                "craftingToolScrewdriver",
                "screwIron");
        addShapelessRecipe(
                getModItem(Natura.ID, "NetherButton", 2, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "NetherPressurePlate", 1, 0));
        addShapelessRecipe(
                getModItem(Natura.ID, "NetherLever", 1, 0),
                "stickWood",
                getModItem(Natura.ID, "NetherButton", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "trapdoor.redwood", 1, 0),
                getModItem(Natura.ID, "redwood", 1, 1),
                "screwCopper",
                "ringCopper",
                getModItem(Natura.ID, "redwood", 1, 1),
                "craftingToolSaw",
                getModItem(Natura.ID, "redwood", 1, 1),
                getModItem(Natura.ID, "redwood", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "trapdoor.redwood", 1, 0),
                getModItem(Natura.ID, "redwood", 1, 1),
                "screwIron",
                "ringIron",
                getModItem(Natura.ID, "redwood", 1, 1),
                "craftingToolSaw",
                getModItem(Natura.ID, "redwood", 1, 1),
                getModItem(Natura.ID, "redwood", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "trapdoor.redwood", 1, 0),
                getModItem(Natura.ID, "redwood", 1, 1),
                "screwCopper",
                "ringCopper",
                getModItem(Natura.ID, "redwood", 1, 1),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "redwood", 1, 1),
                getModItem(Natura.ID, "redwood", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "trapdoor.redwood", 1, 0),
                getModItem(Natura.ID, "redwood", 1, 1),
                "screwIron",
                "ringIron",
                getModItem(Natura.ID, "redwood", 1, 1),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "redwood", 1, 1),
                getModItem(Natura.ID, "redwood", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 1),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0),
                getModItem(Natura.ID, "planks", 1, 0),
                "screwCopper",
                "ringCopper",
                getModItem(Natura.ID, "planks", 1, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 0),
                getModItem(Natura.ID, "planks", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 1),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0),
                getModItem(Natura.ID, "planks", 1, 0),
                "screwIron",
                "ringIron",
                getModItem(Natura.ID, "planks", 1, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 0),
                getModItem(Natura.ID, "planks", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 1),
                "craftingToolSaw",
                getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0),
                getModItem(Natura.ID, "planks", 1, 0),
                "screwCopper",
                "ringCopper",
                getModItem(Natura.ID, "planks", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "planks", 1, 0),
                getModItem(Natura.ID, "planks", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 1),
                "craftingToolSaw",
                getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0),
                getModItem(Natura.ID, "planks", 1, 0),
                "screwIron",
                "ringIron",
                getModItem(Natura.ID, "planks", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "planks", 1, 0),
                getModItem(Natura.ID, "planks", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 2),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "trapdoor.hopseed", 1, 0),
                getModItem(Natura.ID, "planks", 1, 5),
                "screwCopper",
                "ringCopper",
                getModItem(Natura.ID, "planks", 1, 5),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 5),
                getModItem(Natura.ID, "planks", 1, 5));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 2),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "trapdoor.hopseed", 1, 0),
                getModItem(Natura.ID, "planks", 1, 5),
                "screwIron",
                "ringIron",
                getModItem(Natura.ID, "planks", 1, 5),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 5),
                getModItem(Natura.ID, "planks", 1, 5));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 2),
                "craftingToolSaw",
                getModItem(Natura.ID, "trapdoor.hopseed", 1, 0),
                getModItem(Natura.ID, "planks", 1, 5),
                "screwCopper",
                "ringCopper",
                getModItem(Natura.ID, "planks", 1, 5),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "planks", 1, 5),
                getModItem(Natura.ID, "planks", 1, 5));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 2),
                "craftingToolSaw",
                getModItem(Natura.ID, "trapdoor.hopseed", 1, 0),
                getModItem(Natura.ID, "planks", 1, 5),
                "screwIron",
                "ringIron",
                getModItem(Natura.ID, "planks", 1, 5),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "planks", 1, 5),
                getModItem(Natura.ID, "planks", 1, 5));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 3),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "trapdoor.sakura", 1, 0),
                getModItem(Natura.ID, "planks", 1, 1),
                "screwCopper",
                "ringCopper",
                getModItem(Natura.ID, "planks", 1, 1),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 1),
                getModItem(Natura.ID, "planks", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 3),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "trapdoor.sakura", 1, 0),
                getModItem(Natura.ID, "planks", 1, 1),
                "screwIron",
                "ringIron",
                getModItem(Natura.ID, "planks", 1, 1),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 1),
                getModItem(Natura.ID, "planks", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 3),
                "craftingToolSaw",
                getModItem(Natura.ID, "trapdoor.sakura", 1, 0),
                getModItem(Natura.ID, "planks", 1, 1),
                "screwCopper",
                "ringCopper",
                getModItem(Natura.ID, "planks", 1, 1),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "planks", 1, 1),
                getModItem(Natura.ID, "planks", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 3),
                "craftingToolSaw",
                getModItem(Natura.ID, "trapdoor.sakura", 1, 0),
                getModItem(Natura.ID, "planks", 1, 1),
                "screwIron",
                "ringIron",
                getModItem(Natura.ID, "planks", 1, 1),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "planks", 1, 1),
                getModItem(Natura.ID, "planks", 1, 1));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 4),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0),
                getModItem(Natura.ID, "planks", 1, 2),
                "screwCopper",
                "ringCopper",
                getModItem(Natura.ID, "planks", 1, 2),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 2),
                getModItem(Natura.ID, "planks", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 4),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0),
                getModItem(Natura.ID, "planks", 1, 2),
                "screwIron",
                "ringIron",
                getModItem(Natura.ID, "planks", 1, 2),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 2),
                getModItem(Natura.ID, "planks", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 4),
                "craftingToolSaw",
                getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0),
                getModItem(Natura.ID, "planks", 1, 2),
                "screwCopper",
                "ringCopper",
                getModItem(Natura.ID, "planks", 1, 2),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "planks", 1, 2),
                getModItem(Natura.ID, "planks", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 4),
                "craftingToolSaw",
                getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0),
                getModItem(Natura.ID, "planks", 1, 2),
                "screwIron",
                "ringIron",
                getModItem(Natura.ID, "planks", 1, 2),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "planks", 1, 2),
                getModItem(Natura.ID, "planks", 1, 2));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 5),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0),
                getModItem(Natura.ID, "planks", 1, 4),
                "screwCopper",
                "ringCopper",
                getModItem(Natura.ID, "planks", 1, 4),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 4),
                getModItem(Natura.ID, "planks", 1, 4));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 5),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0),
                getModItem(Natura.ID, "planks", 1, 4),
                "screwIron",
                "ringIron",
                getModItem(Natura.ID, "planks", 1, 4),
                "craftingToolSaw",
                getModItem(Natura.ID, "planks", 1, 4),
                getModItem(Natura.ID, "planks", 1, 4));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 5),
                "craftingToolSaw",
                getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0),
                getModItem(Natura.ID, "planks", 1, 4),
                "screwCopper",
                "ringCopper",
                getModItem(Natura.ID, "planks", 1, 4),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "planks", 1, 4),
                getModItem(Natura.ID, "planks", 1, 4));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 5),
                "craftingToolSaw",
                getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0),
                getModItem(Natura.ID, "planks", 1, 4),
                "screwIron",
                "ringIron",
                getModItem(Natura.ID, "planks", 1, 4),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "planks", 1, 4),
                getModItem(Natura.ID, "planks", 1, 4));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 6),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "trapdoor.redwood", 1, 0),
                getModItem(Natura.ID, "redwood", 1, 0),
                "screwCopper",
                "ringCopper",
                getModItem(Natura.ID, "redwood", 1, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "redwood", 1, 0),
                getModItem(Natura.ID, "redwood", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 6),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "trapdoor.redwood", 1, 0),
                getModItem(Natura.ID, "redwood", 1, 0),
                "screwIron",
                "ringIron",
                getModItem(Natura.ID, "redwood", 1, 0),
                "craftingToolSaw",
                getModItem(Natura.ID, "redwood", 1, 0),
                getModItem(Natura.ID, "redwood", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 6),
                "craftingToolSaw",
                getModItem(Natura.ID, "trapdoor.redwood", 1, 0),
                getModItem(Natura.ID, "redwood", 1, 0),
                "screwCopper",
                "ringCopper",
                getModItem(Natura.ID, "redwood", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "redwood", 1, 0),
                getModItem(Natura.ID, "redwood", 1, 0));
        addShapedRecipe(
                getModItem(Natura.ID, "redwoodDoorItem", 1, 6),
                "craftingToolSaw",
                getModItem(Natura.ID, "trapdoor.redwood", 1, 0),
                getModItem(Natura.ID, "redwood", 1, 0),
                "screwIron",
                "ringIron",
                getModItem(Natura.ID, "redwood", 1, 0),
                "craftingToolScrewdriver",
                getModItem(Natura.ID, "redwood", 1, 0),
                getModItem(Natura.ID, "redwood", 1, 0));
        addShapedRecipe(
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1),
                getModItem(Natura.ID, "Cloud", 1, 3),
                getModItem(Natura.ID, "Cloud", 1, 3),
                null,
                getModItem(Natura.ID, "Cloud", 1, 3),
                getModItem(Natura.ID, "Cloud", 1, 3),
                null,
                null,
                null,
                null);

        if (Chisel.isModLoaded()) {
            ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 0));
            ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 1));
            ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 2));
            ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 3));
            ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 4));
            ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 5));
            ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 6));
            ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 7));
            ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 8));
            ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 9));
            ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 10));
            ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 11));
            ChiselHelper.addVariationFromStack("bookshelf", getModItem(Natura.ID, "Natura.bookshelf", 1, 12));
        }

        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "glass", 1, 0), getModItem(Minecraft.ID, "soul_sand", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "NetherGlass", 1, 0)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Minecraft.ID, "glass", 1, 0), getModItem(Natura.ID, "heatsand", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "NetherGlass", 1, 1)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "flint_and_steel", 1, 0)).circuit(3)
                .itemOutputs(getModItem(Natura.ID, "natura.flintandblaze", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.blaze", 432)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_MV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 6, 0), getModItem(Minecraft.ID, "book", 3, 0))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 6, 1), getModItem(Minecraft.ID, "book", 3, 0))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 1)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 6, 2), getModItem(Minecraft.ID, "book", 3, 0))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 2)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 6, 3), getModItem(Minecraft.ID, "book", 3, 0))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 3)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 6, 4), getModItem(Minecraft.ID, "book", 3, 0))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 4)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 6, 5), getModItem(Minecraft.ID, "book", 3, 0))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 5)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 6, 6), getModItem(Minecraft.ID, "book", 3, 0))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 6)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 6, 7), getModItem(Minecraft.ID, "book", 3, 0))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 7)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 6, 8), getModItem(Minecraft.ID, "book", 3, 0))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 8)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 6, 9), getModItem(Minecraft.ID, "book", 3, 0))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 9)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 6, 10), getModItem(Minecraft.ID, "book", 3, 0))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 10)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 6, 11), getModItem(Minecraft.ID, "book", 3, 0))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 11)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 6, 12), getModItem(Minecraft.ID, "book", 3, 0))
                .itemOutputs(getModItem(Natura.ID, "Natura.bookshelf", 1, 12)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        getModItem(Natura.ID, "planks", 2, 0))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.eucalyptus", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        getModItem(Natura.ID, "planks", 2, 1))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.sakura", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        getModItem(Natura.ID, "planks", 2, 2))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.ghostwood", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        getModItem(Natura.ID, "planks", 2, 3))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.redwood", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        getModItem(Natura.ID, "planks", 2, 4))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.bloodwood", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        getModItem(Natura.ID, "planks", 2, 5))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.hopseed", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        getModItem(Natura.ID, "planks", 2, 6))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.maple", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        getModItem(Natura.ID, "planks", 2, 7))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.silverbell", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        getModItem(Natura.ID, "planks", 2, 8))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.amaranth", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        getModItem(Natura.ID, "planks", 2, 9))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.tiger", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        getModItem(Natura.ID, "planks", 2, 10))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.willow", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        getModItem(Natura.ID, "planks", 2, 11))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.darkwood", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L),
                        getModItem(Natura.ID, "planks", 2, 12))
                .itemOutputs(getModItem(Natura.ID, "fenceGate.fusewood", 1, 0)).duration(15 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 0),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.eucalyptus", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 0),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.eucalyptus", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 1),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.sakura", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 1),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.sakura", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 2),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.ghostwood", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 2),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.ghostwood", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 3),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.redwood", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 3),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.redwood", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 4),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.bloodwood", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 4),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.bloodwood", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 5),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.hopseed", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 5),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.hopseed", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 6),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.maple", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 6),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.maple", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 7),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.silverbell", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 4, 7),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.silverbell", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 0),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.amaranth", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 0),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.amaranth", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 1),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.tiger", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 1),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.tiger", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 2),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.willow", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 2),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.willow", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 3),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.darkwood", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 3),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.darkwood", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 4),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.fusewood", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 4, 4),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 4L))
                .itemOutputs(getModItem(Natura.ID, "trapdoor.fusewood", 6, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.steel", 16)).duration(30 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "redwood", 4, 1), getModItem(Natura.ID, "trapdoor.redwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "redwood", 4, 1), getModItem(Natura.ID, "trapdoor.redwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 0))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 4, 0), getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 4, 0), getModItem(Natura.ID, "trapdoor.eucalyptus", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 1))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 4, 5), getModItem(Natura.ID, "trapdoor.hopseed", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 4, 5), getModItem(Natura.ID, "trapdoor.hopseed", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 2))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 4, 1), getModItem(Natura.ID, "trapdoor.sakura", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 3))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 4, 1), getModItem(Natura.ID, "trapdoor.sakura", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 3))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 4, 2), getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 4))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 4, 2), getModItem(Natura.ID, "trapdoor.ghostwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 4))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 4, 4), getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 5))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "planks", 4, 4), getModItem(Natura.ID, "trapdoor.bloodwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 5))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "redwood", 4, 0), getModItem(Natura.ID, "trapdoor.redwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 6))
                .fluidInputs(FluidRegistry.getFluidStack("molten.iron", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "redwood", 4, 0), getModItem(Natura.ID, "trapdoor.redwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "redwoodDoorItem", 1, 6))
                .fluidInputs(FluidRegistry.getFluidStack("molten.copper", 16)).duration(20 * SECONDS).eut(4)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 3, 2), getModItem(Natura.ID, "barleyFood", 3, 7))
                .itemOutputs(getModItem(Natura.ID, "natura.bow.ghostwood", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 3, 4), getModItem(Natura.ID, "barleyFood", 3, 7))
                .itemOutputs(getModItem(Natura.ID, "natura.bow.bloodwood", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 3, 11), getModItem(Natura.ID, "barleyFood", 3, 7))
                .itemOutputs(getModItem(Natura.ID, "natura.bow.darkwood", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(getModItem(Natura.ID, "natura.stick", 3, 12), getModItem(Natura.ID, "barleyFood", 3, 7))
                .itemOutputs(getModItem(Natura.ID, "natura.bow.fusewood", 1, 0)).duration(20 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.eucalyptus", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.eucalyptus", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 1),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.sakura", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 1),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.sakura", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 2),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.ghostwood", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 2),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.ghostwood", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 3),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.redwood", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 3),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.redwood", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 4),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.bloodwood", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 4),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.bloodwood", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 5),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.hopseed", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 5),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.hopseed", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 6),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.maple", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 6),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.maple", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 7),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.silverbell", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab1", 2, 7),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.silverbell", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.amaranth", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.amaranth", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 1),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.tiger", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 1),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.tiger", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 2),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.willow", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 2),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.willow", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 3),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.darkwood", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 3),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.darkwood", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 4),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.fusewood", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "plankSlab2", 2, 4),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .itemOutputs(getModItem(Natura.ID, "pressureplate.fusewood", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "netherrack", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.Iron, 1L))
                .circuit(9).itemOutputs(getModItem(Natura.ID, "NetherPressurePlate", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "netherrack", 2, 0),
                        GTOreDictUnificator.get(OrePrefixes.spring, Materials.WroughtIron, 1))
                .circuit(9).itemOutputs(getModItem(Natura.ID, "NetherPressurePlate", 2, 0)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_ULV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.eucalyptus", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.eucalyptus", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.eucalyptus", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.eucalyptus", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS)
                .eut(4).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.eucalyptus", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.eucalyptus", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(1 * SECONDS + 5 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.eucalyptus", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.eucalyptus", 2, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.sakura", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.sakura", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.sakura", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.sakura", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS)
                .eut(4).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.sakura", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.sakura", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(1 * SECONDS + 5 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.sakura", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.sakura", 2, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.ghostwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.ghostwood", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.ghostwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.ghostwood", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS)
                .eut(4).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.ghostwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.ghostwood", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(1 * SECONDS + 5 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.ghostwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.ghostwood", 2, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.redwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.redwood", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.redwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.redwood", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS)
                .eut(4).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.redwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.redwood", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(1 * SECONDS + 5 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.redwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.redwood", 2, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.bloodwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.bloodwood", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.bloodwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.bloodwood", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS)
                .eut(4).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.bloodwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.bloodwood", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(1 * SECONDS + 5 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.bloodwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.bloodwood", 2, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.hopseed", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.hopseed", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.hopseed", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.hopseed", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS)
                .eut(4).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.hopseed", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.hopseed", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(1 * SECONDS + 5 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.hopseed", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.hopseed", 2, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.maple", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.maple", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.maple", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.maple", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS)
                .eut(4).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.maple", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.maple", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(1 * SECONDS + 5 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.maple", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.maple", 2, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.silverbell", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.silverbell", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.silverbell", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.silverbell", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS)
                .eut(4).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.silverbell", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.silverbell", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(1 * SECONDS + 5 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.silverbell", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.silverbell", 2, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.amaranth", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.amaranth", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.amaranth", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.amaranth", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS)
                .eut(4).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.amaranth", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.amaranth", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(1 * SECONDS + 5 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.amaranth", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.amaranth", 2, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.tiger", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.tiger", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.tiger", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.tiger", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS)
                .eut(4).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.tiger", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.tiger", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(1 * SECONDS + 5 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.tiger", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.tiger", 2, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.willow", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.willow", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.willow", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.willow", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS)
                .eut(4).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.willow", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.willow", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(1 * SECONDS + 5 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.willow", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.willow", 2, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.darkwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.darkwood", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.darkwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.darkwood", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS)
                .eut(4).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.darkwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.darkwood", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(1 * SECONDS + 5 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.darkwood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.darkwood", 2, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.fusewood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.fusewood", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("water", 4)).duration(2 * SECONDS + 10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.fusewood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.fusewood", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(2 * SECONDS + 10 * TICKS)
                .eut(4).addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.fusewood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.fusewood", 2, 0))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(1 * SECONDS + 5 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "pressureplate.fusewood", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "button.fusewood", 2, 0))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(10 * TICKS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "redwood", 1, 0))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 3),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 2L))
                .fluidInputs(FluidRegistry.getFluidStack("water", 5)).duration(20 * SECONDS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "redwood", 1, 0))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 4, 3),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 2L))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 3)).duration(20 * SECONDS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "redwood", 1, 0))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 6, 3),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 1)).duration(10 * SECONDS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "redwood", 1, 0))
                .itemOutputs(
                        getModItem(Natura.ID, "planks", 6, 3),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L))
                .fluidInputs(Materials.DimensionallyShiftedSuperfluid.getFluid(1)).duration(4 * SECONDS).eut(4)
                .addTo(cutterRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "bloodwood", 1, wildcard))
                .itemOutputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 6L),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Wood, 1L))
                .outputChances(10000, 8000).duration(20 * SECONDS).eut(2).addTo(maceratorRecipes);
        GTValues.RA.stdBuilder().itemInputs(new ItemStack(Blocks.snow, 4)).circuit(4)
                .itemOutputs(getModItem(Natura.ID, "Cloud", 4, 0))
                .fluidInputs(FluidRegistry.getFluidStack("cloud_seed", 1000)).duration(20 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Cloud", 4, 0)).circuit(4)
                .itemOutputs(getModItem(Natura.ID, "Cloud", 4, 1))
                .fluidInputs(FluidRegistry.getFluidStack("cloud_seed_concentrated", 1000)).duration(20 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Natura.ID, "Cloud", 4, 1),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L))
                .circuit(4).itemOutputs(getModItem(Natura.ID, "Cloud", 4, 2)).duration(20 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Cloud", 4, 1)).circuit(4)
                .itemOutputs(getModItem(Natura.ID, "Cloud", 4, 3))
                .fluidInputs(FluidRegistry.getFluidStack("sulfurdioxide", 4000)).duration(20 * TICKS)
                .eut(TierEU.RECIPE_LV / 2).addTo(mixerRecipes);

        GTValues.RA.stdBuilder().itemInputs(getModItem(Minecraft.ID, "cactus", 1, 0))
                .itemOutputs(getModItem(Natura.ID, "waterdrop", 2, 0)).duration(5 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(extractorRecipes);

        Module_CustomFuels.registerCustomFuelValue(getModItem(Natura.ID, "NetherPressurePlate", 1, 0), (short) 75);
        Module_CustomFuels.registerCustomFuelValue(getModItem(Natura.ID, "pressureplate.eucalyptus", 1, 0), (short) 75);
        Module_CustomFuels.registerCustomFuelValue(getModItem(Natura.ID, "pressureplate.sakura", 1, 0), (short) 75);
        Module_CustomFuels.registerCustomFuelValue(getModItem(Natura.ID, "pressureplate.ghostwood", 1, 0), (short) 75);
        Module_CustomFuels.registerCustomFuelValue(getModItem(Natura.ID, "pressureplate.redwood", 1, 0), (short) 75);
        Module_CustomFuels.registerCustomFuelValue(getModItem(Natura.ID, "pressureplate.bloodwood", 1, 0), (short) 75);
        Module_CustomFuels.registerCustomFuelValue(getModItem(Natura.ID, "pressureplate.hopseed", 1, 0), (short) 75);
        Module_CustomFuels.registerCustomFuelValue(getModItem(Natura.ID, "pressureplate.maple", 1, 0), (short) 75);
        Module_CustomFuels.registerCustomFuelValue(getModItem(Natura.ID, "pressureplate.amaranth", 1, 0), (short) 75);
        Module_CustomFuels.registerCustomFuelValue(getModItem(Natura.ID, "pressureplate.silverbell", 1, 0), (short) 75);
        Module_CustomFuels.registerCustomFuelValue(getModItem(Natura.ID, "pressureplate.tiger", 1, 0), (short) 75);
        Module_CustomFuels.registerCustomFuelValue(getModItem(Natura.ID, "pressureplate.willow", 1, 0), (short) 75);
        Module_CustomFuels.registerCustomFuelValue(getModItem(Natura.ID, "pressureplate.darkwood", 1, 0), (short) 75);
        Module_CustomFuels.registerCustomFuelValue(getModItem(Natura.ID, "pressureplate.fusewood", 1, 0), (short) 75);
        GTValues.RA.stdBuilder().itemInputs(getModItem(Natura.ID, "Bluebells", 1, 0))
                .itemOutputs(ItemList.Color_04.get(2L)).duration(15 * SECONDS).eut(2).addTo(extractorRecipes);

    }
}
