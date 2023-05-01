package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.EnderStorage;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.util.GT_ModHandler.addShapelessCraftingRecipe;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sAssemblerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCompressorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sCutterRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sExtractorRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sHammerRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sLatheRecipes;
import static gregtech.api.util.GT_Recipe.GT_Recipe_Map.sMaceratorRecipes;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import gregtech.api.enums.GT_Values;
import gregtech.api.util.GT_ModHandler;

public class ScriptHardcoreEnderExpansion implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Hardcore Ender Expansion";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                HardcoreEnderExpansion.ID,
                BiomesOPlenty.ID,
                EnderStorage.ID,
                IronTanks.ID,
                Thaumcraft.ID,
                TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "altar_nexus", 1, 0, missing),
                new Object[] { "plateDiamond", "gemEnderEye", "plateDiamond", "gemEnderEye", "plateDiamond",
                        "gemEnderEye", "plateDiamond", "gemEnderEye", "plateDiamond" });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "essence_altar", 1, 0, missing),
                new Object[] { getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing), "itemLeather",
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 0, missing),
                        getModItem(Minecraft.ID, "bookshelf", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "altar_nexus", 1, 0, missing),
                        getModItem(Minecraft.ID, "bookshelf", 1, 0, missing), "plateDenseObsidian", "blockEnder",
                        "plateDenseObsidian" });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "void_chest", 1, 0, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "plateEnderEye",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing),
                        getModItem(EnderStorage.ID, "enderChest", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "plateEnderEye",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "biome_compass", 1, 0, missing),
                new Object[] { "screwHeeEndium", getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        "boltHeeEndium", "ringHeeEndium", "plateHeeEndium", "ringHeeEndium", "boltRedAlloy",
                        "craftingToolScrewdriver", "screwHeeEndium" });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "obsidian_rod", 1, 0, missing),
                new Object[] { "craftingToolFile", null, null, null,
                        getModItem(HardcoreEnderExpansion.ID, "obsidian_fragment", 1, 0, missing), null, null, null,
                        getModItem(HardcoreEnderExpansion.ID, "obsidian_fragment", 1, 0, missing) });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "ravaged_brick_slab", 1, 0, missing),
                new Object[] { "craftingToolSaw",
                        getModItem(HardcoreEnderExpansion.ID, "ravaged_brick", 1, 32767, missing), null });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "experience_table", 1, 0, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "lensEnderEye",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "plateThaumium",
                        "bottleEmpty", "plateThaumium", "blockStainlessSteel", "blockHeeEndium",
                        "blockStainlessSteel" });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "energy_extraction_table", 1, 0, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(IronTanks.ID, "ironTank", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "plateThaumium",
                        getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing), "plateThaumium",
                        "blockStainlessSteel", "blockHeeEndium", "blockStainlessSteel" });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "accumulation_table", 1, 0, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(IronTanks.ID, "ironTank", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "plateThaumium",
                        getModItem(HardcoreEnderExpansion.ID, "energy_wand_core", 1, 0, missing), "plateThaumium",
                        "blockStainlessSteel", "blockHeeEndium", "blockStainlessSteel" });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "spectral_tear", 1, 0, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing),
                        getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "spectral_tear", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "silverfish_blood", 1, 0, missing),
                        getModItem(Minecraft.ID, "spider_eye", 1, 0, missing),
                        getModItem(Minecraft.ID, "bone", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "instability_orb", 1, 0, missing),
                        getModItem(Minecraft.ID, "egg", 1, 0, missing),
                        getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing),
                        getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing) });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "energy_wand", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", "screwTitanium",
                        getModItem(HardcoreEnderExpansion.ID, "energy_wand_core", 1, 0, missing), "screwTitanium",
                        getModItem(HardcoreEnderExpansion.ID, "obsidian_rod", 1, 0, missing), "screwTitanium",
                        getModItem(HardcoreEnderExpansion.ID, "obsidian_rod", 1, 0, missing), "screwTitanium",
                        "craftingToolFile" });
        addShapelessCraftingRecipe(
                getModItem(HardcoreEnderExpansion.ID, "spooky_leaves", 1, 0, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "dry_splinter", 1, 0, missing),
                        getModItem(Minecraft.ID, "deadbush", 1, 0, missing),
                        getModItem(Minecraft.ID, "sand", 1, 0, missing),
                        getModItem(Minecraft.ID, "dye", 1, 15, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2815, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2530, missing) });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "charm_pouch", 1, 0, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "rune", 1, 32767, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "rune", 1, 32767, missing),
                        getModItem(Thaumcraft.ID, "FocusPouch", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "rune", 1, 32767, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "rune", 1, 32767, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 0, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "dustEnderPearl",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "dustEnderPearl",
                        getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing), "dustEnderPearl",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "dustEnderPearl",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 256, missing),
                new Object[] { null, getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem(HardcoreEnderExpansion.ID, "curse", 1, 0, missing),
                        "dustTinyNetherStar", null,
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 1, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "itemFlint",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "itemBlazePowder",
                        getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing), "dyeBlack",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "instability_orb", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 257, missing),
                new Object[] { null, getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem(HardcoreEnderExpansion.ID, "curse", 1, 1, missing),
                        "dustTinyNetherStar", null,
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 2, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "food", 1, 1, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(GregTech.ID, "gt.metaitem.02", 1, 32113, missing),
                        getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing), "dustSugar",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "flowerRed",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 258, missing),
                new Object[] { null, getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem(HardcoreEnderExpansion.ID, "curse", 1, 2, missing),
                        "dustTinyNetherStar", null,
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 3, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "dustLead",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(Minecraft.ID, "web", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                        getModItem(Minecraft.ID, "web", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(Minecraft.ID, "fermented_spider_eye", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 259, missing),
                new Object[] { null, getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem(HardcoreEnderExpansion.ID, "curse", 1, 3, missing),
                        "dustTinyNetherStar", null,
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 4, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "itemBlazePowder",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(Minecraft.ID, "poisonous_potato", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                        getModItem(Minecraft.ID, "fermented_spider_eye", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(BiomesOPlenty.ID, "foliage", 1, 7, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 260, missing),
                new Object[] { null, getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem(HardcoreEnderExpansion.ID, "curse", 1, 4, missing),
                        "dustTinyNetherStar", null,
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 5, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "dyeBlack",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "dustCoal",
                        getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing), "dustTinySunnarium",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "dyeBlack",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 261, missing),
                new Object[] { null, getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem(HardcoreEnderExpansion.ID, "curse", 1, 5, missing),
                        "dustTinyNetherStar", null,
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 6, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "silverfish_blood", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "dustTinyUranium",
                        getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing), "dustTinyPlutonium",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 262, missing),
                new Object[] { null, getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem(HardcoreEnderExpansion.ID, "curse", 1, 6, missing),
                        "dustTinyNetherStar", null,
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 7, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "instability_orb", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 263, missing),
                new Object[] { null, getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem(HardcoreEnderExpansion.ID, "curse", 1, 7, missing),
                        "dustTinyNetherStar", null,
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 8, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "cropGarlic",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                        getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "silverfish_blood", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "igneous_rock", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 264, missing),
                new Object[] { null, getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem(HardcoreEnderExpansion.ID, "curse", 1, 8, missing),
                        "dustTinyNetherStar", null,
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 9, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "dustEnderEye",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "dustTinyGold",
                        getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing), "dustTinyGold",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "itemFlint",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 265, missing),
                new Object[] { null, getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem(HardcoreEnderExpansion.ID, "curse", 1, 9, missing),
                        "dustTinyNetherStar", null,
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing), null });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 10, missing),
                new Object[] { getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "dustRedstone",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing), "dustEmerald",
                        getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing), "bookEmpty",
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "instability_orb", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 266, missing),
                new Object[] { null, getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem(HardcoreEnderExpansion.ID, "curse", 1, 10, missing),
                        "dustTinyNetherStar", null,
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing), null });

        GT_ModHandler.addSmeltingRecipe(
                getModItem(HardcoreEnderExpansion.ID, "sphalerite", 1, 0, missing),
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11036, missing));
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "endium_ingot", 9, 0, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "dry_splinter", 9, 0, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "spooky_log", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "death_flower", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 4, 13, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "death_flower", 1, 15, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 4, 8, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "crossed_decoration", 1, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 4, 14, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "auricion", 8, 0, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "energy_wand_core", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 8, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "endoplasm", 4, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 16, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "essence", 16, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "blank_gem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1440)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(HardcoreEnderExpansion.ID, "blank_gem", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 16, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "endoplasm", 8, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 32, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "essence", 32, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "spatial_dash_gem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 2880)).noFluidOutputs().duration(1200).eut(1920)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(HardcoreEnderExpansion.ID, "spatial_dash_gem", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 32, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "endoplasm", 16, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 64, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "essence", 64, 0, missing),
                        getModItem(GregTech.ID, "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "transference_gem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 5760)).noFluidOutputs().duration(1800).eut(7068)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "golden_pickaxe", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "fire_shard", 8, 0, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "schorching_pickaxe", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "end_powder", 4, 0, missing))
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1770, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 533, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1770, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 533, missing))
                .outputChances(9000, 8000, 7500, 5000).fluidInputs(FluidRegistry.getFluidStack("ender", 100))
                .noFluidOutputs().duration(200).eut(480).addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().noItemInputs()
                .itemOutputs(
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2770, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2533, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1841, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1770, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 1533, missing))
                .outputChances(9000, 8000, 7500, 5000, 2500).fluidInputs(FluidRegistry.getFluidStack("ender", 250))
                .fluidOutputs(FluidRegistry.getFluidStack("endergoo", 1000)).duration(600).eut(480)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "ravaged_brick", 1, 32767, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "ravaged_brick_slab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lava", 144)).noFluidOutputs().duration(300).eut(120)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "ravaged_brick", 1, 32767, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "ravaged_brick_slab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2hotcoolant", 72)).noFluidOutputs().duration(300).eut(120)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "ravaged_brick", 1, 32767, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "ravaged_brick_slab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.blaze", 36)).noFluidOutputs().duration(150).eut(120)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 9, 17770, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 500)).noFluidOutputs().duration(3600).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 9, 17770, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 350)).noFluidOutputs().duration(3600)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 9, 17770, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 150)).noFluidOutputs().duration(1800).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "sphalerite", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 2, 5839, missing)).noFluidInputs()
                .noFluidOutputs().duration(4).eut(10).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(HardcoreEnderExpansion.ID, "instability_orb_ore", 1, 0, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "instability_orb", 6, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(120).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "obsidian_fragment", 1, 0, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "obsidian_rod", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(160).eut(120).addTo(sLatheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "end_powder_ore", 1, 0, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "end_powder", 8, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(50).eut(480).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "igneous_rock_ore", 1, 0, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "igneous_rock", 4, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(50).eut(480).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 9, 2770, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(50).eut(480).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "sphalerite", 1, 0, missing))
                .itemOutputs(getModItem(GregTech.ID, "gt.metaitem.01", 4, 5839, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(400).eut(2).addTo(sMaceratorRecipes);

    }
}
