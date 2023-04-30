package com.dreammaster.scripts;

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
import gregtech.api.enums.Mods;
import gregtech.api.util.GT_ModHandler;

public class ScriptHardcoreEnderExpansion implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Hardcore Ender Expansion";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.HardcoreEnderExpansion.ID);
    }

    @Override
    public void loadRecipes() {
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "altar_nexus", 1, 0, missing),
                new Object[] { "plateDiamond", "gemEnderEye", "plateDiamond", "gemEnderEye", "plateDiamond",
                        "gemEnderEye", "plateDiamond", "gemEnderEye", "plateDiamond" });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "essence_altar", 1, 0, missing),
                new Object[] { getModItem("Thaumcraft", "ItemResource", 1, 1, missing), "itemLeather",
                        getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                        getModItem("minecraft", "bookshelf", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "altar_nexus", 1, 0, missing),
                        getModItem("minecraft", "bookshelf", 1, 0, missing), "plateDenseObsidian", "blockEnder",
                        "plateDenseObsidian" });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "void_chest", 1, 0, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "plateEnderEye",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "endium_block", 1, 0, missing),
                        getModItem("EnderStorage", "enderChest", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "endium_block", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "plateEnderEye",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "biome_compass", 1, 0, missing),
                new Object[] { "screwHeeEndium", getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        "boltHeeEndium", "ringHeeEndium", "plateHeeEndium", "ringHeeEndium", "boltRedAlloy",
                        "craftingToolScrewdriver", "screwHeeEndium" });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "obsidian_rod", 1, 0, missing),
                new Object[] { "craftingToolFile", null, null, null,
                        getModItem("HardcoreEnderExpansion", "obsidian_fragment", 1, 0, missing), null, null, null,
                        getModItem("HardcoreEnderExpansion", "obsidian_fragment", 1, 0, missing) });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "ravaged_brick_slab", 1, 0, missing),
                new Object[] { "craftingToolSaw",
                        getModItem("HardcoreEnderExpansion", "ravaged_brick", 1, 32767, missing), null });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "experience_table", 1, 0, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "lensEnderEye",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "plateThaumium",
                        "bottleEmpty", "plateThaumium", "blockStainlessSteel", "blockHeeEndium",
                        "blockStainlessSteel" });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "energy_extraction_table", 1, 0, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("irontank", "ironTank", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "plateThaumium",
                        getModItem("HardcoreEnderExpansion", "living_matter", 1, 0, missing), "plateThaumium",
                        "blockStainlessSteel", "blockHeeEndium", "blockStainlessSteel" });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "accumulation_table", 1, 0, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("irontank", "ironTank", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "plateThaumium",
                        getModItem("HardcoreEnderExpansion", "energy_wand_core", 1, 0, missing), "plateThaumium",
                        "blockStainlessSteel", "blockHeeEndium", "blockStainlessSteel" });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "spectral_tear", 1, 0, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "endoplasm", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "endoplasm", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "endoplasm", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "endoplasm", 1, 0, missing),
                        getModItem("minecraft", "ghast_tear", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "endoplasm", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "endoplasm", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "endoplasm", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "endoplasm", 1, 0, missing) });
        addShapelessCraftingRecipe(
                getModItem("HardcoreEnderExpansion", "living_matter", 1, 0, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "spectral_tear", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "silverfish_blood", 1, 0, missing),
                        getModItem("minecraft", "spider_eye", 1, 0, missing),
                        getModItem("minecraft", "bone", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "instability_orb", 1, 0, missing),
                        getModItem("minecraft", "egg", 1, 0, missing),
                        getModItem("minecraft", "blaze_powder", 1, 0, missing),
                        getModItem("minecraft", "rotten_flesh", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing) });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "energy_wand", 1, 0, missing),
                new Object[] { "craftingToolScrewdriver", "screwTitanium",
                        getModItem("HardcoreEnderExpansion", "energy_wand_core", 1, 0, missing), "screwTitanium",
                        getModItem("HardcoreEnderExpansion", "obsidian_rod", 1, 0, missing), "screwTitanium",
                        getModItem("HardcoreEnderExpansion", "obsidian_rod", 1, 0, missing), "screwTitanium",
                        "craftingToolFile" });
        addShapelessCraftingRecipe(
                getModItem("HardcoreEnderExpansion", "spooky_leaves", 1, 0, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "dry_splinter", 1, 0, missing),
                        getModItem("minecraft", "deadbush", 1, 0, missing),
                        getModItem("minecraft", "sand", 1, 0, missing), getModItem("minecraft", "dye", 1, 15, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2815, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2530, missing) });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "charm_pouch", 1, 0, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "rune", 1, 32767, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "rune", 1, 32767, missing),
                        getModItem("Thaumcraft", "FocusPouch", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "rune", 1, 32767, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "rune", 1, 32767, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 4, 0, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "dustEnderPearl",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "dustEnderPearl",
                        getModItem("HardcoreEnderExpansion", "living_matter", 1, 0, missing), "dustEnderPearl",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "dustEnderPearl",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 1, 256, missing),
                new Object[] { null, getModItem("HardcoreEnderExpansion", "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem("HardcoreEnderExpansion", "curse", 1, 0, missing),
                        "dustTinyNetherStar", null, getModItem("HardcoreEnderExpansion", "arcane_shard", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 4, 1, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "itemFlint",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "itemBlazePowder",
                        getModItem("HardcoreEnderExpansion", "living_matter", 1, 0, missing), "dyeBlack",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "instability_orb", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 1, 257, missing),
                new Object[] { null, getModItem("HardcoreEnderExpansion", "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem("HardcoreEnderExpansion", "curse", 1, 1, missing),
                        "dustTinyNetherStar", null, getModItem("HardcoreEnderExpansion", "arcane_shard", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 4, 2, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("BiomesOPlenty", "food", 1, 1, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 32113, missing),
                        getModItem("HardcoreEnderExpansion", "living_matter", 1, 0, missing), "dustSugar",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "flowerRed",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 1, 258, missing),
                new Object[] { null, getModItem("HardcoreEnderExpansion", "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem("HardcoreEnderExpansion", "curse", 1, 2, missing),
                        "dustTinyNetherStar", null, getModItem("HardcoreEnderExpansion", "arcane_shard", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 4, 3, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "dustLead",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("minecraft", "web", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "living_matter", 1, 0, missing),
                        getModItem("minecraft", "web", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("minecraft", "fermented_spider_eye", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 1, 259, missing),
                new Object[] { null, getModItem("HardcoreEnderExpansion", "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem("HardcoreEnderExpansion", "curse", 1, 3, missing),
                        "dustTinyNetherStar", null, getModItem("HardcoreEnderExpansion", "arcane_shard", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 4, 4, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "itemBlazePowder",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("minecraft", "poisonous_potato", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "living_matter", 1, 0, missing),
                        getModItem("minecraft", "fermented_spider_eye", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("BiomesOPlenty", "foliage", 1, 7, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 1, 260, missing),
                new Object[] { null, getModItem("HardcoreEnderExpansion", "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem("HardcoreEnderExpansion", "curse", 1, 4, missing),
                        "dustTinyNetherStar", null, getModItem("HardcoreEnderExpansion", "arcane_shard", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 4, 5, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "dyeBlack",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "dustCoal",
                        getModItem("HardcoreEnderExpansion", "living_matter", 1, 0, missing), "dustTinySunnarium",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "dyeBlack",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 1, 261, missing),
                new Object[] { null, getModItem("HardcoreEnderExpansion", "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem("HardcoreEnderExpansion", "curse", 1, 5, missing),
                        "dustTinyNetherStar", null, getModItem("HardcoreEnderExpansion", "arcane_shard", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 4, 6, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "silverfish_blood", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "dustTinyUranium",
                        getModItem("HardcoreEnderExpansion", "living_matter", 1, 0, missing), "dustTinyPlutonium",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "endoplasm", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 1, 262, missing),
                new Object[] { null, getModItem("HardcoreEnderExpansion", "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem("HardcoreEnderExpansion", "curse", 1, 6, missing),
                        "dustTinyNetherStar", null, getModItem("HardcoreEnderExpansion", "arcane_shard", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 4, 7, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "stardust", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("minecraft", "slime_ball", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "living_matter", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "instability_orb", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "stardust", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 1, 263, missing),
                new Object[] { null, getModItem("HardcoreEnderExpansion", "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem("HardcoreEnderExpansion", "curse", 1, 7, missing),
                        "dustTinyNetherStar", null, getModItem("HardcoreEnderExpansion", "arcane_shard", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 4, 8, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "cropGarlic",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("TConstruct", "strangeFood", 1, 1, missing),
                        getModItem("HardcoreEnderExpansion", "living_matter", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "silverfish_blood", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "igneous_rock", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 1, 264, missing),
                new Object[] { null, getModItem("HardcoreEnderExpansion", "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem("HardcoreEnderExpansion", "curse", 1, 8, missing),
                        "dustTinyNetherStar", null, getModItem("HardcoreEnderExpansion", "arcane_shard", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 4, 9, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "dustEnderEye",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "dustTinyGold",
                        getModItem("HardcoreEnderExpansion", "living_matter", 1, 0, missing), "dustTinyGold",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "itemFlint",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 1, 265, missing),
                new Object[] { null, getModItem("HardcoreEnderExpansion", "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem("HardcoreEnderExpansion", "curse", 1, 9, missing),
                        "dustTinyNetherStar", null, getModItem("HardcoreEnderExpansion", "arcane_shard", 1, 0, missing),
                        null });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 4, 10, missing),
                new Object[] { getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "dustRedstone",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), "dustEmerald",
                        getModItem("HardcoreEnderExpansion", "living_matter", 1, 0, missing), "bookEmpty",
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "instability_orb", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing) });
        addShapedRecipe(
                getModItem("HardcoreEnderExpansion", "curse", 1, 266, missing),
                new Object[] { null, getModItem("HardcoreEnderExpansion", "stardust", 1, 0, missing), null,
                        "dustNetherrack", getModItem("HardcoreEnderExpansion", "curse", 1, 10, missing),
                        "dustTinyNetherStar", null, getModItem("HardcoreEnderExpansion", "arcane_shard", 1, 0, missing),
                        null });

        GT_ModHandler.addSmeltingRecipe(
                getModItem("HardcoreEnderExpansion", "sphalerite", 1, 0, missing),
                getModItem("gregtech", "gt.metaitem.01", 1, 11036, missing));
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "endium_ingot", 9, 0, missing))
                .itemOutputs(getModItem("HardcoreEnderExpansion", "endium_block", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "dry_splinter", 9, 0, missing))
                .itemOutputs(getModItem("HardcoreEnderExpansion", "spooky_log", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(2).addTo(sCompressorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "death_flower", 1, 0, missing))
                .itemOutputs(getModItem("minecraft", "dye", 4, 13, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "death_flower", 1, 15, missing))
                .itemOutputs(getModItem("minecraft", "dye", 4, 8, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "crossed_decoration", 1, 6, missing))
                .itemOutputs(getModItem("minecraft", "dye", 4, 14, missing)).noFluidInputs().noFluidOutputs()
                .duration(300).eut(2).addTo(sExtractorRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("HardcoreEnderExpansion", "endium_block", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "auricion", 8, 0, missing))
                .itemOutputs(getModItem("HardcoreEnderExpansion", "energy_wand_core", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(600).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("HardcoreEnderExpansion", "endium_block", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "arcane_shard", 8, 0, missing),
                        getModItem("HardcoreEnderExpansion", "endoplasm", 4, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 16, 0, missing),
                        getModItem("HardcoreEnderExpansion", "essence", 16, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("HardcoreEnderExpansion", "blank_gem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 1440)).noFluidOutputs().duration(600).eut(480)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("HardcoreEnderExpansion", "blank_gem", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "arcane_shard", 16, 0, missing),
                        getModItem("HardcoreEnderExpansion", "endoplasm", 8, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 32, 0, missing),
                        getModItem("HardcoreEnderExpansion", "essence", 32, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("HardcoreEnderExpansion", "spatial_dash_gem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 2880)).noFluidOutputs().duration(1200).eut(1920)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("HardcoreEnderExpansion", "spatial_dash_gem", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "arcane_shard", 32, 0, missing),
                        getModItem("HardcoreEnderExpansion", "endoplasm", 16, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 64, 0, missing),
                        getModItem("HardcoreEnderExpansion", "essence", 64, 0, missing),
                        getModItem("gregtech", "gt.integrated_circuit", 0, 1, missing))
                .itemOutputs(getModItem("HardcoreEnderExpansion", "transference_gem", 1, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("endergoo", 5760)).noFluidOutputs().duration(1800).eut(7068)
                .addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder()
                .itemInputs(
                        getModItem("minecraft", "golden_pickaxe", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "fire_shard", 8, 0, missing))
                .itemOutputs(getModItem("HardcoreEnderExpansion", "schorching_pickaxe", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(300).eut(480).addTo(sAssemblerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "end_powder", 4, 0, missing))
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 1770, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 533, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1770, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 533, missing))
                .outputChances(9000, 8000, 7500, 5000).fluidInputs(FluidRegistry.getFluidStack("ender", 100))
                .noFluidOutputs().duration(200).eut(480).addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().noItemInputs()
                .itemOutputs(
                        getModItem("gregtech", "gt.metaitem.01", 1, 2770, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2533, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1841, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1770, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 1533, missing))
                .outputChances(9000, 8000, 7500, 5000, 2500).fluidInputs(FluidRegistry.getFluidStack("ender", 250))
                .fluidOutputs(FluidRegistry.getFluidStack("endergoo", 1000)).duration(600).eut(480)
                .addTo(sCentrifugeRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "ravaged_brick", 1, 32767, missing))
                .itemOutputs(getModItem("HardcoreEnderExpansion", "ravaged_brick_slab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lava", 144)).noFluidOutputs().duration(300).eut(120)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "ravaged_brick", 1, 32767, missing))
                .itemOutputs(getModItem("HardcoreEnderExpansion", "ravaged_brick_slab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2hotcoolant", 72)).noFluidOutputs().duration(300).eut(120)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "ravaged_brick", 1, 32767, missing))
                .itemOutputs(getModItem("HardcoreEnderExpansion", "ravaged_brick_slab", 2, 0, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.blaze", 36)).noFluidOutputs().duration(150).eut(120)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "endium_block", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 9, 17770, missing))
                .fluidInputs(FluidRegistry.getFluidStack("water", 500)).noFluidOutputs().duration(3600).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "endium_block", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 9, 17770, missing))
                .fluidInputs(FluidRegistry.getFluidStack("ic2distilledwater", 350)).noFluidOutputs().duration(3600)
                .eut(30).addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "endium_block", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 9, 17770, missing))
                .fluidInputs(FluidRegistry.getFluidStack("lubricant", 150)).noFluidOutputs().duration(1800).eut(30)
                .addTo(sCutterRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "sphalerite", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 2, 5839, missing)).noFluidInputs()
                .noFluidOutputs().duration(4).eut(10).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "instability_orb_ore", 1, 0, missing))
                .itemOutputs(getModItem("HardcoreEnderExpansion", "instability_orb", 6, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(50).eut(120).addTo(sHammerRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "obsidian_fragment", 1, 0, missing))
                .itemOutputs(getModItem("HardcoreEnderExpansion", "obsidian_rod", 1, 0, missing)).noFluidInputs()
                .noFluidOutputs().duration(160).eut(120).addTo(sLatheRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "end_powder_ore", 1, 0, missing))
                .itemOutputs(getModItem("HardcoreEnderExpansion", "end_powder", 8, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(50).eut(480).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "igneous_rock_ore", 1, 0, missing))
                .itemOutputs(getModItem("HardcoreEnderExpansion", "igneous_rock", 4, 0, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(50).eut(480).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "endium_block", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 9, 2770, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(50).eut(480).addTo(sMaceratorRecipes);
        GT_Values.RA.stdBuilder().itemInputs(getModItem("HardcoreEnderExpansion", "sphalerite", 1, 0, missing))
                .itemOutputs(getModItem("gregtech", "gt.metaitem.01", 4, 5839, missing)).outputChances(10000)
                .noFluidInputs().noFluidOutputs().duration(400).eut(2).addTo(sMaceratorRecipes);

    }
}
