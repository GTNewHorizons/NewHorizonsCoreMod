package com.dreammaster.recipes;

import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.GalacticraftAmunRa;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.ProjectRedCore;
import static gregtech.api.enums.Mods.ProjectRedExploration;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.TinkerConstruct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.dreammaster.chisel.ChiselHelper;
import com.dreammaster.forestry.ForestryHelper;
import com.dreammaster.tinkersConstruct.TConstructHelper;
import com.github.bsideup.jabel.Desugar;
import com.ruling_0.materiallib.api.Material;
import com.ruling_0.materiallib.api.MaterialLibAPI;
import com.ruling_0.materiallib.api.Shape;

import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.enums.materials.Materials;
import gregtech.api.enums.materials.Shapes;
import gregtech.api.util.GTModHandler;

/// Swaps other mods' copies of material parts out of the crafting and smelting recipes, Tinkers' Construct casting,
/// Forestry centrifuge products and dungeon loot that hand them out, for the MaterialLib part GregTech serves under the
/// same ore-dictionary name, so the copies never enter play. Each entry names the exact foreign stack; the recipe or
/// loot entry around it keeps its inputs, amounts, experience and weights.
///
/// Foreign storage blocks are dropped instead of swapped: their crafting recipes and chisel variations are removed,
/// since GregTech already crafts MaterialLib's blocks from the same ingredients.
///
/// Every foreign stack is collected first, so the crafting list, the smelting list and each loot table are walked once.
public final class MaterialPartReplacements {

    private static final String[] LOOT_CHESTS = { ChestGenHooks.DUNGEON_CHEST, ChestGenHooks.BONUS_CHEST,
            ChestGenHooks.VILLAGE_BLACKSMITH, ChestGenHooks.STRONGHOLD_CROSSING, ChestGenHooks.STRONGHOLD_LIBRARY,
            ChestGenHooks.STRONGHOLD_CORRIDOR, ChestGenHooks.PYRAMID_JUNGLE_DISPENSER,
            ChestGenHooks.PYRAMID_JUNGLE_CHEST, ChestGenHooks.PYRAMID_DESERT_CHEST, ChestGenHooks.MINESHAFT_CORRIDOR };

    @Desugar
    private record ItemKey(Item item, int meta) {

        static ItemKey of(ItemStack stack) {
            return new ItemKey(stack.getItem(), stack.getItemDamage());
        }
    }

    private final Map<ItemKey, ItemStack> replacements = new HashMap<>();
    private final Set<ItemKey> removedOutputs = new HashSet<>();
    private ItemKey projectRedSilverIngot;

    private MaterialPartReplacements() {}

    public static void run() {
        MaterialPartReplacements replacements = new MaterialPartReplacements();
        replacements.collect();
        replacements.apply();
    }

    private void collect() {
        replace(EnderIO.ID, "itemMaterial", 11, Materials.EndSteel, Shapes.nugget);

        replace(IndustrialCraft2.ID, "itemDust", 2, Materials.Coal, Shapes.dust);
        replace(IndustrialCraft2.ID, "itemDust", 3, Materials.Copper, Shapes.dust);
        replace(IndustrialCraft2.ID, "itemDust", 4, Materials.Gold, Shapes.dust);
        replace(IndustrialCraft2.ID, "itemDust", 5, Materials.Iron, Shapes.dust);
        replace(IndustrialCraft2.ID, "itemDust", 6, Materials.Silver, Shapes.dust);
        replace(IndustrialCraft2.ID, "itemDust", 7, Materials.Tin, Shapes.dust);
        replace(IndustrialCraft2.ID, "itemDust", 10, Materials.Lead, Shapes.dust);
        replace(IndustrialCraft2.ID, "itemDust", 11, Materials.Obsidian, Shapes.dust);
        replace(IndustrialCraft2.ID, "itemDust", 13, Materials.Sulfur, Shapes.dust);
        replace(IndustrialCraft2.ID, "itemCrushedOre", 4, Materials.Uranium, Shapes.crushed);
        replace(IndustrialCraft2.ID, "itemIngot", 0, Materials.Copper, Shapes.ingot);
        replace(IndustrialCraft2.ID, "itemIngot", 1, Materials.Tin, Shapes.ingot);
        replace(IndustrialCraft2.ID, "itemIngot", 2, Materials.Bronze, Shapes.ingot);
        replace(IndustrialCraft2.ID, "itemIngot", 5, Materials.Lead, Shapes.ingot);
        replace(IndustrialCraft2.ID, "itemIngot", 6, Materials.Silver, Shapes.ingot);
        replace(IndustrialCraft2.ID, "itemRubber", 0, Materials.Rubber, Shapes.ingot);

        replace(PamsHarvestCraft.ID, "cocoapowderItem", 0, Materials.Cocoa, Shapes.dust);
        replace(PamsHarvestCraft.ID, "flourItem", 0, Materials.Wheat, Shapes.dust);

        replace(ProjectRedCore.ID, "projectred.core.part", 10, Materials.RedAlloy, Shapes.ingot);
        replaceProjectRedSilverIngot();

        replace(TaintedMagic.ID, "ItemMaterial", 0, Materials.Shadow, Shapes.ingot);

        replace(TinkerConstruct.ID, "materials", 3, Materials.Cobalt, Shapes.ingot);
        replace(TinkerConstruct.ID, "materials", 15, Materials.Alumite, Shapes.ingot);
        replace(TinkerConstruct.ID, "materials", 18, Materials.Obsidian, Shapes.ingot);
        replace(TinkerConstruct.ID, "materials", 27, Materials.Obsidian, Shapes.nugget);
        replace(TinkerConstruct.ID, "materials", 28, Materials.Cobalt, Shapes.nugget);
        replace(TinkerConstruct.ID, "materials", 31, Materials.Bronze, Shapes.nugget);
        replace(TinkerConstruct.ID, "materials", 32, Materials.Alumite, Shapes.nugget);
        replace(TinkerConstruct.ID, "materials", 33, Materials.Steel, Shapes.nugget);
        replace(TinkerConstruct.ID, "materials", 34, Materials.PigIron, Shapes.ingot);
        replace(TinkerConstruct.ID, "materials", 35, Materials.PigIron, Shapes.nugget);

        for (int meta = 0; meta <= 5; meta++) {
            removeBlock(IndustrialCraft2.ID, "blockMetal", meta);
        }
        for (int meta : new int[] { 3, 7, 9, 13, 15 }) {
            removeBlock(BiomesOPlenty.ID, "gemOre", meta);
        }
        removeBlock(Botania.ID, "blazeBlock", 0);
        for (int meta = 1; meta <= 3; meta++) {
            removeBlock(Forestry.ID, "resourceStorage", meta);
        }
        removeBlock(GalacticraftAmunRa.ID, "tile.baseBlockRock", 11);
        for (int meta = 9; meta <= 11; meta++) {
            removeBlock(GalacticraftCore.ID, "tile.gcBlockCore", meta);
        }
        for (int meta : new int[] { 5, 6, 8, 9, 10 }) {
            removeBlock(ProjectRedExploration.ID, "projectred.exploration.stone", meta);
        }
        for (int meta : new int[] { 2, 9, 10, 11 }) {
            removeBlock(Railcraft.ID, "cube", meta);
        }
        for (int meta : new int[] { 0, 3, 4, 5, 6, 9 }) {
            removeBlock(TinkerConstruct.ID, "MetalBlock", meta);
        }
    }

    private void replace(String modId, String itemName, int meta, Material material, Shape shape) {
        ItemStack foreign = GTModHandler.getModItem(modId, itemName, 1, meta);
        if (foreign == null) return;
        ItemStack part = MaterialLibAPI.getStack(material, shape, 1);
        replacements.put(ItemKey.of(foreign), part);
        if (TinkerConstruct.isModLoaded()) TConstructHelper.replaceCastingOutputs(foreign, part);
        if (Forestry.isModLoaded()) ForestryHelper.replaceCentrifugeProducts(foreign, part);
    }

    private void removeBlock(String modId, String blockName, int meta) {
        ItemStack foreign = GTModHandler.getModItem(modId, blockName, 1, meta);
        if (foreign == null) return;
        removedOutputs.add(ItemKey.of(foreign));
        if (Chisel.isModLoaded()) ChiselHelper.removeVariationAndOreMember(foreign);
    }

    /// ProjectRed's storage-block recipe builds a fresh output on every call rather than holding one stack, so it is
    /// removed and added again as an ore recipe, while its smelting and loot outputs are swapped like any other part.
    private void replaceProjectRedSilverIngot() {
        ItemStack foreign = GTModHandler.getModItem(ProjectRedCore.ID, "projectred.core.part", 1, 54);
        if (foreign == null) return;
        projectRedSilverIngot = ItemKey.of(foreign);
        replacements.put(projectRedSilverIngot, MaterialLibAPI.getStack(Materials.Silver, Shapes.ingot, 1));
    }

    private void apply() {
        replaceCraftingOutputs();
        replaceSmeltingOutputs();
        replaceLoot();
    }

    private void replaceCraftingOutputs() {
        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
        boolean projectRedSilverRemoved = false;
        for (Iterator<IRecipe> iterator = recipes.listIterator(); iterator.hasNext();) {
            ItemStack output = iterator.next().getRecipeOutput();
            if (output == null || output.getItem() == null) continue;
            ItemKey key = ItemKey.of(output);
            if (removedOutputs.contains(key)) {
                iterator.remove();
            } else if (key.equals(projectRedSilverIngot)) {
                iterator.remove();
                projectRedSilverRemoved = true;
            }
        }
        if (projectRedSilverRemoved) {
            GameRegistry.addRecipe(
                    new ShapelessOreRecipe(MaterialLibAPI.getStack(Materials.Silver, Shapes.ingot, 9), "blockSilver"));
        }
        for (int i = 0; i < recipes.size(); i++) {
            IRecipe recipe = recipes.get(i);
            ItemStack output = recipe.getRecipeOutput();
            if (output == null || output.getItem() == null) continue;
            ItemStack part = replacements.get(ItemKey.of(output));
            if (part == null) continue;
            ItemStack replacement = withSize(part, output.stackSize);
            if (recipe instanceof ShapelessOreRecipe shapeless && recipe.getClass() == ShapelessOreRecipe.class) {
                recipes.set(i, new ShapelessOreRecipe(replacement, oreRecipeInputs(shapeless.getInput())));
            } else if (recipe instanceof ShapelessRecipes shapeless && recipe.getClass() == ShapelessRecipes.class) {
                recipes.set(i, new ShapelessRecipes(replacement, new ArrayList<>(shapeless.recipeItems)));
            } else {
                throw new IllegalStateException(
                        "No replacement for " + recipe.getClass().getName() + " outputting " + output);
            }
        }
    }

    /// A [ShapelessOreRecipe]'s inputs back in constructor form: an ore-dictionary list becomes its name again.
    private static Object[] oreRecipeInputs(List<Object> inputs) {
        Object[] recipe = new Object[inputs.size()];
        for (int i = 0; i < recipe.length; i++) {
            Object input = inputs.get(i);
            recipe[i] = input instanceof List<?>list ? oreNameOf(list) : input;
        }
        return recipe;
    }

    private static String oreNameOf(List<?> ores) {
        for (String name : OreDictionary.getOreNames()) {
            if (OreDictionary.getOres(name) == ores) return name;
        }
        throw new IllegalStateException("Recipe ingredient list matches no ore-dictionary name: " + ores);
    }

    @SuppressWarnings("unchecked")
    private void replaceSmeltingOutputs() {
        FurnaceRecipes smelting = FurnaceRecipes.smelting();
        List<ItemStack[]> replaced = new ArrayList<>();
        List<Float> experience = new ArrayList<>();
        Iterator<Map.Entry<ItemStack, ItemStack>> entries = smelting.getSmeltingList().entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<ItemStack, ItemStack> entry = entries.next();
            ItemStack part = replacementFor(entry.getValue());
            if (part == null) continue;
            replaced.add(new ItemStack[] { entry.getKey(), withSize(part, entry.getValue().stackSize) });
            experience.add(smelting.func_151398_b(entry.getValue()));
            entries.remove();
        }
        for (int i = 0; i < replaced.size(); i++) {
            smelting.func_151394_a(replaced.get(i)[0], replaced.get(i)[1], experience.get(i));
        }
    }

    private void replaceLoot() {
        Random random = new Random();
        for (String chest : LOOT_CHESTS) {
            for (WeightedRandomChestContent content : ChestGenHooks.getInfo(chest).getItems(random)) {
                ItemStack part = replacementFor(content.theItemId);
                if (part == null) continue;
                ChestGenHooks.removeItem(chest, content.theItemId);
                ChestGenHooks.addItem(
                        chest,
                        new WeightedRandomChestContent(
                                withSize(part, content.theItemId.stackSize),
                                content.theMinimumChanceToGenerateItem,
                                content.theMaximumChanceToGenerateItem,
                                content.itemWeight));
            }
        }
    }

    private ItemStack replacementFor(ItemStack stack) {
        return stack == null || stack.getItem() == null ? null : replacements.get(ItemKey.of(stack));
    }

    private static ItemStack withSize(ItemStack stack, int size) {
        ItemStack copy = stack.copy();
        copy.stackSize = size;
        return copy;
    }
}
