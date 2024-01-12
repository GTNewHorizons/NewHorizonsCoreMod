package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Chisel;
import static gregtech.api.enums.Mods.EnderStorage;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.centrifugeRecipes;
import static gregtech.api.recipe.RecipeMaps.cutterRecipes;
import static gregtech.api.recipe.RecipeMaps.extractorRecipes;
import static gregtech.api.recipe.RecipeMaps.hammerRecipes;
import static gregtech.api.recipe.RecipeMaps.latheRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GT_ModHandler.getModItem;
import static gregtech.api.util.GT_RecipeBuilder.MINUTES;
import static gregtech.api.util.GT_RecipeBuilder.SECONDS;
import static gregtech.api.util.GT_RecipeBuilder.TICKS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.chisel.ChiselHelper;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;

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
                Chisel.ID,
                EnderStorage.ID,
                IronTanks.ID,
                Thaumcraft.ID,
                TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "altar_nexus", 1, 0, missing),
                "plateDiamond",
                "gemEnderEye",
                "plateDiamond",
                "gemEnderEye",
                "plateDiamond",
                "gemEnderEye",
                "plateDiamond",
                "gemEnderEye",
                "plateDiamond");
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "essence_altar", 1, 0, missing),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                "itemLeather",
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0, missing),
                getModItem(Minecraft.ID, "bookshelf", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "altar_nexus", 1, 0, missing),
                getModItem(Minecraft.ID, "bookshelf", 1, 0, missing),
                "plateDenseObsidian",
                "blockEnder",
                "plateDenseObsidian");
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "void_chest", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "plateEnderEye",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing),
                getModItem(EnderStorage.ID, "enderChest", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "plateEnderEye",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing));
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "biome_compass", 1, 0, missing),
                "screwHeeEndium",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "boltHeeEndium",
                "ringHeeEndium",
                "plateHeeEndium",
                "ringHeeEndium",
                "boltRedAlloy",
                "craftingToolScrewdriver",
                "screwHeeEndium");
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "obsidian_rod", 1, 0, missing),
                "craftingToolFile",
                null,
                null,
                null,
                getModItem(HardcoreEnderExpansion.ID, "obsidian_fragment", 1, 0, missing),
                null,
                null,
                null,
                getModItem(HardcoreEnderExpansion.ID, "obsidian_fragment", 1, 0, missing));
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "ravaged_brick_slab", 1, 0, missing),
                "craftingToolSaw",
                getModItem(HardcoreEnderExpansion.ID, "ravaged_brick", 1, wildcard, missing),
                null);
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "experience_table", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "lensEnderEye",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "plateThaumium",
                "bottleEmpty",
                "plateThaumium",
                "blockStainlessSteel",
                "blockHeeEndium",
                "blockStainlessSteel");
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "energy_extraction_table", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(IronTanks.ID, "ironTank", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "plateThaumium",
                getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                "plateThaumium",
                "blockStainlessSteel",
                "blockHeeEndium",
                "blockStainlessSteel");
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "accumulation_table", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(IronTanks.ID, "ironTank", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "plateThaumium",
                getModItem(HardcoreEnderExpansion.ID, "energy_wand_core", 1, 0, missing),
                "plateThaumium",
                "blockStainlessSteel",
                "blockHeeEndium",
                "blockStainlessSteel");
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "spectral_tear", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing),
                getModItem(Minecraft.ID, "ghast_tear", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing));
        addShapelessRecipe(
                getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "spectral_tear", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "silverfish_blood", 1, 0, missing),
                getModItem(Minecraft.ID, "spider_eye", 1, 0, missing),
                getModItem(Minecraft.ID, "bone", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "instability_orb", 1, 0, missing),
                getModItem(Minecraft.ID, "egg", 1, 0, missing),
                getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing),
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L));
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "energy_wand", 1, 0, missing),
                "craftingToolScrewdriver",
                "screwTitanium",
                getModItem(HardcoreEnderExpansion.ID, "energy_wand_core", 1, 0, missing),
                "screwTitanium",
                getModItem(HardcoreEnderExpansion.ID, "obsidian_rod", 1, 0, missing),
                "screwTitanium",
                getModItem(HardcoreEnderExpansion.ID, "obsidian_rod", 1, 0, missing),
                "screwTitanium",
                "craftingToolFile");
        addShapelessRecipe(
                getModItem(HardcoreEnderExpansion.ID, "spooky_leaves", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "dry_splinter", 1, 0, missing),
                getModItem(Minecraft.ID, "deadbush", 1, 0, missing),
                getModItem(Minecraft.ID, "sand", 1, 0, missing),
                getModItem(Minecraft.ID, "dye", 1, 15, missing),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L),
                GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Apatite, 1L));
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "charm_pouch", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "rune", 1, wildcard, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "rune", 1, wildcard, missing),
                getModItem(Thaumcraft.ID, "FocusPouch", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "rune", 1, wildcard, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "rune", 1, wildcard, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing));
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "dustEnderPearl",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "dustEnderPearl",
                getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                "dustEnderPearl",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "dustEnderPearl",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing));
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 256, missing),
                null,
                getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing),
                null,
                "dustNetherrack",
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 0, missing),
                "dustTinyNetherStar",
                null,
                getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 1, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "itemFlint",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "itemBlazePowder",
                getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                "dyeBlack",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "instability_orb", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing));
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 257, missing),
                null,
                getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing),
                null,
                "dustNetherrack",
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 1, missing),
                "dustTinyNetherStar",
                null,
                getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 2, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "food", 1, 1, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                ItemList.Bottle_Dark_Beer.get(1L),
                getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                "dustSugar",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "flowerRed",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing));
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 258, missing),
                null,
                getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing),
                null,
                "dustNetherrack",
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 2, missing),
                "dustTinyNetherStar",
                null,
                getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 3, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "dustLead",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(Minecraft.ID, "web", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                getModItem(Minecraft.ID, "web", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(Minecraft.ID, "fermented_spider_eye", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing));
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 259, missing),
                null,
                getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing),
                null,
                "dustNetherrack",
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 3, missing),
                "dustTinyNetherStar",
                null,
                getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 4, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "itemBlazePowder",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(Minecraft.ID, "poisonous_potato", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                getModItem(Minecraft.ID, "fermented_spider_eye", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(BiomesOPlenty.ID, "foliage", 1, 7, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing));
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 260, missing),
                null,
                getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing),
                null,
                "dustNetherrack",
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 4, missing),
                "dustTinyNetherStar",
                null,
                getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 5, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "dyeBlack",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "dustCoal",
                getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                "dustTinySunnarium",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "dyeBlack",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing));
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 261, missing),
                null,
                getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing),
                null,
                "dustNetherrack",
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 5, missing),
                "dustTinyNetherStar",
                null,
                getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 6, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "silverfish_blood", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "dustTinyUranium",
                getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                "dustTinyPlutonium",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "endoplasm", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing));
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 262, missing),
                null,
                getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing),
                null,
                "dustNetherrack",
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 6, missing),
                "dustTinyNetherStar",
                null,
                getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 7, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(Minecraft.ID, "slime_ball", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "instability_orb", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing));
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 263, missing),
                null,
                getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing),
                null,
                "dustNetherrack",
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 7, missing),
                "dustTinyNetherStar",
                null,
                getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 8, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "cropGarlic",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(TinkerConstruct.ID, "strangeFood", 1, 1, missing),
                getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "silverfish_blood", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "igneous_rock", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing));
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 264, missing),
                null,
                getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing),
                null,
                "dustNetherrack",
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 8, missing),
                "dustTinyNetherStar",
                null,
                getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 9, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "dustEnderEye",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "dustTinyGold",
                getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                "dustTinyGold",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "itemFlint",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing));
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 265, missing),
                null,
                getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing),
                null,
                "dustNetherrack",
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 9, missing),
                "dustTinyNetherStar",
                null,
                getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing),
                null);
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 4, 10, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "dustRedstone",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                "dustEmerald",
                getModItem(HardcoreEnderExpansion.ID, "living_matter", 1, 0, missing),
                "bookEmpty",
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "instability_orb", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing));
        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 266, missing),
                null,
                getModItem(HardcoreEnderExpansion.ID, "stardust", 1, 0, missing),
                null,
                "dustNetherrack",
                getModItem(HardcoreEnderExpansion.ID, "curse", 1, 10, missing),
                "dustTinyNetherStar",
                null,
                getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 1, 0, missing),
                null);

        GT_ModHandler.addSmeltingRecipe(
                getModItem(HardcoreEnderExpansion.ID, "sphalerite", 1, 0, missing),
                GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Zinc, 1L));
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "death_flower", 1, 0, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 4, 13, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "death_flower", 1, 15, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 4, 8, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "crossed_decoration", 1, 6, missing))
                .itemOutputs(getModItem(Minecraft.ID, "dye", 4, 14, missing)).duration(15 * SECONDS).eut(2)
                .addTo(extractorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "auricion", 8, 0, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "energy_wand_core", 1, 0, missing))
                .duration(30 * SECONDS).eut(480).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 8, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "endoplasm", 4, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 16, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "essence", 16, 0, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "blank_gem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1440)).duration(30 * SECONDS).eut(480)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(HardcoreEnderExpansion.ID, "blank_gem", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 16, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "endoplasm", 8, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 32, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "essence", 32, 0, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "spatial_dash_gem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 2880)).duration(1 * MINUTES).eut(1920)
                .addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(HardcoreEnderExpansion.ID, "spatial_dash_gem", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "arcane_shard", 32, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "endoplasm", 16, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 64, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "essence", 64, 0, missing),
                        GT_Utility.getIntegratedCircuit(1))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "transference_gem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 5760)).duration(1 * MINUTES + 30 * SECONDS)
                .eut(7068).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "golden_pickaxe", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "fire_shard", 8, 0, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "schorching_pickaxe", 1, 0, missing))
                .duration(15 * SECONDS).eut(480).addTo(assemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "end_powder", 4, 0, missing))
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.HeeEndium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.EnderEye, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.HeeEndium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dustTiny, Materials.EnderEye, 1L))
                .outputChances(9000, 8000, 7500, 5000).fluidOutputs(FluidRegistry.getFluidStack("ender", 100))
                .duration(10 * SECONDS).eut(TierEU.RECIPE_HV).addTo(centrifugeRecipes);
        GT_Values.RA.stdBuilder()
                .itemOutputs(
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HeeEndium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EnderEye, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Tungstate, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.HeeEndium, 1L),
                        GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.EnderEye, 1L))
                .outputChances(9000, 8000, 7500, 5000, 2500).fluidInputs(FluidRegistry.getFluidStack("endergoo", 1000))
                .fluidOutputs(FluidRegistry.getFluidStack("ender", 250)).duration(30 * SECONDS).eut(TierEU.RECIPE_HV)
                .addTo(centrifugeRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(HardcoreEnderExpansion.ID, "ravaged_brick", 1, wildcard, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "ravaged_brick_slab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lava", 144)).duration(15 * SECONDS).eut(120)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(HardcoreEnderExpansion.ID, "ravaged_brick", 1, wildcard, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "ravaged_brick_slab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2hotcoolant", 72)).duration(15 * SECONDS).eut(120)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(HardcoreEnderExpansion.ID, "ravaged_brick", 1, wildcard, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "ravaged_brick_slab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.blaze", 36)).duration(7 * SECONDS + 10 * TICKS)
                .eut(120).addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HeeEndium, 9L))
                .fluidInputs(FluidRegistry.getFluidStack("water", 500)).duration(3 * MINUTES).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HeeEndium, 9L))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 350)).duration(3 * MINUTES).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.plate, Materials.HeeEndium, 9L))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 150)).duration(1 * MINUTES + 30 * SECONDS).eut(30)
                .addTo(cutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "sphalerite", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Sphalerite, 2L)).duration(4)
                .eut(10).addTo(hammerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(getModItem(HardcoreEnderExpansion.ID, "instability_orb_ore", 1, 0, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "instability_orb", 6, 0, missing))
                .duration(2 * SECONDS + 10 * TICKS).eut(120).addTo(hammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "obsidian_fragment", 1, 0, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "obsidian_rod", 1, 0, missing)).duration(8 * SECONDS)
                .eut(120).addTo(latheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "end_powder_ore", 1, 0, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "end_powder", 8, 0, missing)).outputChances(10000)
                .duration(2 * SECONDS + 10 * TICKS).eut(480).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "igneous_rock_ore", 1, 0, missing))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "igneous_rock", 4, 0, missing)).outputChances(10000)
                .duration(2 * SECONDS + 10 * TICKS).eut(480).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "endium_block", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.HeeEndium, 9L)).outputChances(10000)
                .duration(2 * SECONDS + 10 * TICKS).eut(480).addTo(maceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem(HardcoreEnderExpansion.ID, "sphalerite", 1, 0, missing))
                .itemOutputs(GT_OreDictUnificator.get(OrePrefixes.crushed, Materials.Sphalerite, 4L))
                .outputChances(10000).duration(20 * SECONDS).eut(2).addTo(maceratorRecipes);

        addDecorativeBlocks();
    }

    private void addDecorativeBlocks() {
        // Overgrown endstone

        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "end_stone_terrain", 8, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "red_mushroom", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "end_stone", 16, 0, missing),
                        getModItem(Minecraft.ID, "red_mushroom", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(23))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "end_stone_terrain", 16, 0, missing))
                .duration(5 * SECONDS).eut(24).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "end_stone_terrain", 8, 1, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "end_stone", 16, 0, missing),
                        getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(23))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "end_stone_terrain", 16, 1, missing))
                .duration(5 * SECONDS).eut(24).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "end_stone_terrain", 8, 2, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "end_stone", 16, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(23))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "end_stone_terrain", 16, 2, missing))
                .duration(5 * SECONDS).eut(24).addTo(assemblerRecipes);

        // Laboratory

        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "laboratory_floor", 8, 0, missing),
                getModItem(Chisel.ID, "laboratoryblock", 1, 0, missing),
                getModItem(Chisel.ID, "laboratoryblock", 1, 0, missing),
                getModItem(Chisel.ID, "laboratoryblock", 1, 0, missing),
                getModItem(Chisel.ID, "laboratoryblock", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(Chisel.ID, "laboratoryblock", 1, 0, missing),
                getModItem(Chisel.ID, "laboratoryblock", 1, 0, missing),
                getModItem(Chisel.ID, "laboratoryblock", 1, 0, missing),
                getModItem(Chisel.ID, "laboratoryblock", 1, 0, missing));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "stone", 4, 0, missing),
                        getModItem(Minecraft.ID, "quartz", 1, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(11))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "laboratory_floor", 8, 0, missing))
                .duration(5 * SECONDS).eut(24).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "laboratory_obsidian", 8, 0, missing),
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "obsidian", 4, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "laboratory_obsidian", 8, 0, missing))
                .duration(5 * SECONDS).eut(24).addTo(assemblerRecipes);

        // Crafting recipe already exists.
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "glass", 4, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "laboratory_glass", 8, 0, missing))
                .duration(5 * SECONDS).eut(24).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "laboratory_stairs", 4, 0, missing),
                null,
                null,
                getModItem(HardcoreEnderExpansion.ID, "laboratory_floor", 1, 0, missing),
                null,
                getModItem(HardcoreEnderExpansion.ID, "laboratory_floor", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "laboratory_floor", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "laboratory_floor", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "laboratory_floor", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "laboratory_floor", 1, 0, missing));

        addShapelessRecipe(
                getModItem(HardcoreEnderExpansion.ID, "obsidian_end", 2, 0, missing),
                getModItem(Minecraft.ID, "obsidian", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing));

        for (int meta = 0; meta < 3; ++meta) {
            addShapedRecipe(
                    getModItem(HardcoreEnderExpansion.ID, "obsidian_special_glow", 1, meta, missing),
                    null,
                    getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                    null,
                    getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                    getModItem(HardcoreEnderExpansion.ID, "obsidian_special", 1, meta, missing),
                    getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                    null,
                    getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                    null);
        }

        // Ravaged brick

        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "ravaged_brick", 1, 0, missing),
                getModItem(Minecraft.ID, "brick_block", 1, 0, missing),
                getModItem(Minecraft.ID, "brick_block", 1, 0, missing),
                getModItem(Minecraft.ID, "brick_block", 1, 0, missing),
                getModItem(Minecraft.ID, "brick_block", 1, 0, missing),
                getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing),
                getModItem(Minecraft.ID, "brick_block", 1, 0, missing),
                getModItem(Minecraft.ID, "brick_block", 1, 0, missing),
                getModItem(Minecraft.ID, "brick_block", 1, 0, missing),
                getModItem(Minecraft.ID, "brick_block", 1, 0, missing));
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "brick_block", 4, 0, missing),
                        getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "ravaged_brick", 8, 0, missing))
                .duration(5 * SECONDS).eut(24).addTo(assemblerRecipes);

        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "ravaged_brick_glow", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "ravaged_brick", 1, 0, missing),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                null,
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                null);

        ChiselHelper.addGroup("HEERavagedBrick");
        for (int meta = 0; meta < 6; ++meta) {
            ChiselHelper.addVariationFromStack(
                    "HEERavagedBrick",
                    getModItem(HardcoreEnderExpansion.ID, "ravaged_brick", 1, meta, missing));
        }

        ChiselHelper.addVariationFromStack(
                "HEERavagedBrick",
                getModItem(HardcoreEnderExpansion.ID, "ravaged_brick_smooth", 1, 0, missing));

        // Peresgrit

        addShapedRecipe(
                getModItem(HardcoreEnderExpansion.ID, "persegrit", 8, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing),
                getModItem(Minecraft.ID, "end_stone", 1, 0, missing),
                getModItem(Minecraft.ID, "gravel", 1, 0, missing));

        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "end_stone", 2, 0, missing),
                        getModItem(Minecraft.ID, "gravel", 2, 0, missing),
                        getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0, missing),
                        GT_Utility.getIntegratedCircuit(24))
                .itemOutputs(getModItem(HardcoreEnderExpansion.ID, "persegrit", 8, 0, missing)).duration(5 * SECONDS)
                .eut(24).addTo(assemblerRecipes);

        ChiselHelper.addGroup("HEEPersegrit");
        for (int meta = 0; meta < 16; ++meta) {
            ChiselHelper.addVariationFromStack(
                    "HEEPersegrit",
                    getModItem(HardcoreEnderExpansion.ID, "persegrit", 1, meta, missing));
        }
    }
}
