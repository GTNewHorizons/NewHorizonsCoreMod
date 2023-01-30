package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptExtraUtilities implements IScriptLoader {

    @Override
    public void initScriptData() {
        scriptName.setLength(0);
        scriptName.append("ExtraUtilities");
        dependencies.clear();
        dependencies.addAll(Arrays.asList("ExtraUtilities", "Thaumcraft", "ProjRed|Illumination"));
    }

    @Override
    public void loadRecipes() {
        ItemStack missing = new ItemStack(Blocks.dirt);

        // --- Carved Imminence Stone
        {
            ShapedArcaneRecipe recipe = ThaumcraftApi.addArcaneCraftingRecipe(
                    "EMINENCESTONE",
                    getModItem("ExtraUtilities", "decorativeBlock1", 2, 14, missing),
                    new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("ignis"), 50)
                            .add(Aspect.getAspect("terra"), 50).add(Aspect.getAspect("aqua"), 50)
                            .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                    "ABA",
                    "CDC",
                    "AEA",
                    'A',
                    getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                    'B',
                    getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1, 18, missing),
                    'C',
                    getModItem("gregtech", "gt.metaitem.01", 1, 17532, missing),
                    'D',
                    getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                    'E',
                    getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1, 26, missing));
            ResearchItem research = new ResearchItem(
                    "EMINENCESTONE",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("sensus"), 12)
                            .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("aer"), 6),
                    0,
                    4,
                    12,
                    getModItem("ExtraUtilities", "decorativeBlock1", 1, 14, missing))
                            .setPages(
                                    new ResearchPage("ExtraUtilities.research_page.EMINENCESTONE"),
                                    new ResearchPage(recipe))
                            .setParents("INFUSION");
            ResearchCategories.addResearch(research);
        }
        // --- Portal to the Last Millennium
        {
            InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe(
                    "PORTALMILLENIUM",
                    getModItem("ExtraUtilities", "dark_portal", 1, 2, missing),
                    4,
                    new AspectList().add(Aspect.getAspect("alienis"), 75).add(Aspect.getAspect("sensus"), 25)
                            .add(Aspect.getAspect("praecantatio"), 75).add(Aspect.getAspect("terra"), 25)
                            .add(Aspect.getAspect("vacuos"), 75),
                    getModItem("minecraft", "clock", 1, missing),
                    new ItemStack[] { getModItem("ExtraUtilities", "decorativeBlock1", 1, 14, missing),
                            getModItem("ExtraUtilities", "decorativeBlock1", 1, 2, missing),
                            getModItem("ExtraUtilities", "decorativeBlock1", 1, 14, missing),
                            getModItem("ExtraUtilities", "decorativeBlock1", 1, 2, missing),
                            getModItem("ExtraUtilities", "decorativeBlock1", 1, 14, missing),
                            getModItem("ExtraUtilities", "decorativeBlock1", 1, 2, missing),
                            getModItem("ExtraUtilities", "decorativeBlock1", 1, 14, missing),
                            getModItem("ExtraUtilities", "decorativeBlock1", 1, 2, missing) });
            ResearchItem research = new ResearchItem(
                    "PORTALMILLENIUM",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("sensus"), 12)
                            .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("ignis"), 6),
                    2,
                    6,
                    4,
                    getModItem("ExtraUtilities", "dark_portal", 1, 2, missing))
                            .setPages(
                                    new ResearchPage("ExtraUtilities.research_page.PORTALMILLENIUM"),
                                    new ResearchPage(recipe))
                            .setParents("EMINENCESTONE", "OCULUS").setConcealed();
            ThaumcraftApi.addWarpToResearch("PORTALMILLENIUM", 2);
            ResearchCategories.addResearch(research);
        }
        // --- Portal to the Deep Dark
        {
            InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe(
                    "PORTALDEEPDARK",
                    getModItem("ExtraUtilities", "dark_portal", 1, missing),
                    32,
                    new AspectList().add(Aspect.getAspect("vacuos"), 512).add(Aspect.getAspect("tempus"), 512)
                            .add(Aspect.getAspect("luxuria"), 512).add(Aspect.getAspect("alienis"), 512)
                            .add(Aspect.getAspect("terminus"), 512).add(Aspect.getAspect("gula"), 512)
                            .add(Aspect.getAspect("superbia"), 512),
                    getModItem("gregtech", "gt.blockreinforced", 1, 12, missing),
                    new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 32046, missing),
                            getModItem("eternalsingularity", "eternal_singularity", 1, missing),
                            getModItem("gregtech", "gt.metaitem.01", 1, 32046, missing),
                            getModItem("eternalsingularity", "eternal_singularity", 1, missing),
                            getModItem("gregtech", "gt.metaitem.01", 1, 32046, missing),
                            getModItem("eternalsingularity", "eternal_singularity", 1, missing),
                            getModItem("gregtech", "gt.metaitem.01", 1, 32046, missing),
                            getModItem("eternalsingularity", "eternal_singularity", 1, missing) });
            ResearchItem research = new ResearchItem(
                    "PORTALDEEPDARK",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("vacuos"), 27).add(Aspect.getAspect("tempus"), 24)
                            .add(Aspect.getAspect("luxuria"), 21).add(Aspect.getAspect("alienis"), 18)
                            .add(Aspect.getAspect("gula"), 12).add(Aspect.getAspect("superbia"), 9),
                    2,
                    8,
                    4,
                    getModItem("ExtraUtilities", "dark_portal", 1, missing))
                            .setPages(
                                    new ResearchPage("ExtraUtilities.research_page.PORTALDEEPDARK"),
                                    new ResearchPage(recipe))
                            .setParents("PORTALMILLENIUM", "ICHOR").setConcealed();
            ThaumcraftApi.addWarpToResearch("PORTALDEEPDARK", 64);
            ResearchCategories.addResearch(research);
        }
        // --- Magical Wood
        {
            ShapedArcaneRecipe recipe = ThaumcraftApi.addArcaneCraftingRecipe(
                    "MAGICALWOOD",
                    getModItem("ExtraUtilities", "decorativeBlock1", 4, 8, missing),
                    new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("ignis"), 10)
                            .add(Aspect.getAspect("terra"), 10).add(Aspect.getAspect("aqua"), 10)
                            .add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("perditio"), 10),
                    "ABC",
                    "DED",
                    "CBA",
                    'A',
                    getModItem("ExtraUtilities", "decorativeBlock1", 4, 8, missing),
                    'B',
                    getModItem("Thaumcraft", "blockMagicalLog", 1, 1, missing),
                    'C',
                    getModItem("Thaumcraft", "blockMagicalLog", 1, missing),
                    'D',
                    getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                    'E',
                    getModItem("minecraft", "bookshelf", 1, missing));
            ResearchItem research = new ResearchItem(
                    "MAGICALWOOD",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("lucrum"), 12)
                            .add(Aspect.getAspect("arbor"), 9).add(Aspect.getAspect("cognitio"), 6)
                            .add(Aspect.getAspect("pannus"), 3),
                    -2,
                    6,
                    4,
                    getModItem("ExtraUtilities", "decorativeBlock1", 1, 8, missing))
                            .setPages(
                                    new ResearchPage("ExtraUtilities.research_page.MAGICALWOOD"),
                                    new ResearchPage(recipe))
                            .setParents("EMINENCESTONE").setConcealed();
            ResearchCategories.addResearch(research);
        }
        // --- Angel Block
        {
            ShapedArcaneRecipe recipe = ThaumcraftApi.addArcaneCraftingRecipe(
                    "ANGELBLOCK",
                    getModItem("ExtraUtilities", "angelBlock", 1, missing),
                    new AspectList().add(Aspect.getAspect("aer"), 50),
                    "ABA",
                    "CDC",
                    "ABA",
                    'A',
                    getModItem("gregtech", "gt.metaitem.01", 1, 17540, missing),
                    'B',
                    getModItem("gregtech", "gt.metaitem.01", 1, 29351, missing),
                    'C',
                    getModItem("IC2", "itemDensePlates", 1, 7, missing),
                    'D',
                    getModItem("Automagy", "blockRunedObsidian", 1, missing));
            ResearchItem research = new ResearchItem(
                    "ANGELBLOCK",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("lucrum"), 12)
                            .add(Aspect.getAspect("ignis"), 9).add(Aspect.getAspect("terra"), 6),
                    -2,
                    8,
                    4,
                    getModItem("ExtraUtilities", "angelBlock", 1, missing))
                            .setPages(
                                    new ResearchPage("ExtraUtilities.research_page.ANGELBLOCK"),
                                    new ResearchPage(recipe))
                            .setParents("MAGICALWOOD").setConcealed();
            ResearchCategories.addResearch(research);
        }
        // --- Dezlis Marshmallow
        {
            InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe(
                    "DEZILSMARSHMALLOW",
                    getModItem("DraconicEvolution", "dezilsMarshmallow", 1, missing),
                    5,
                    new AspectList().add(Aspect.getAspect("alienis"), 32).add(Aspect.getAspect("praecantatio"), 16)
                            .add(Aspect.getAspect("superbia"), 24).add(Aspect.getAspect("sano"), 28)
                            .add(Aspect.getAspect("iter"), 20).add(Aspect.getAspect("potentia"), 12),
                    getModItem("dreamcraft", "item.Marshmallow", 1, missing),
                    new ItemStack[] { getModItem("harvestcraft", "epicbaconItem", 1, missing),
                            getModItem("harvestcraft", "deluxechickencurryItem", 1, missing),
                            getModItem("harvestcraft", "meatfeastpizzaItem", 1, missing),
                            getModItem("harvestcraft", "beefwellingtonItem", 1, missing),
                            getModItem("harvestcraft", "sausageinbreadItem", 1, missing),
                            getModItem("harvestcraft", "heartybreakfastItem", 1, missing) });
            ResearchItem research = new ResearchItem(
                    "DEZILSMARSHMALLOW",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                            .add(Aspect.getAspect("superbia"), 9).add(Aspect.getAspect("sano"), 6)
                            .add(Aspect.getAspect("potentia"), 3),
                    -2,
                    2,
                    4,
                    getModItem("DraconicEvolution", "dezilsMarshmallow", 1, missing))
                            .setPages(new ResearchPage("de.research_page.DEZILSMARSHMALLOW"), new ResearchPage(recipe))
                            .setParents("INFUSION").setSpecial();
            ThaumcraftApi.addWarpToResearch("DEZILSMARSHMALLOW", 8);
            ResearchCategories.addResearch(research);
        }
        // --- Enchanting Table
        {
            ShapedArcaneRecipe recipe = ThaumcraftApi.addArcaneCraftingRecipe(
                    "ENCHANTINGTABLE",
                    getModItem("minecraft", "enchanting_table", 1, missing),
                    new AspectList().add(Aspect.getAspect("aer"), 45).add(Aspect.getAspect("aqua"), 45)
                            .add(Aspect.getAspect("terra"), 45).add(Aspect.getAspect("ignis"), 45)
                            .add(Aspect.getAspect("ordo"), 45).add(Aspect.getAspect("perditio"), 45),
                    "ABA",
                    "CDE",
                    "AFA",
                    'A',
                    getModItem("ForgeMicroblock", "microblock", 1, 516, missing),
                    'B',
                    getModItem("minecraft", "carpet", 1, 14, missing),
                    'C',
                    getModItem("Thaumcraft", "ItemResource", 1, missing),
                    'D',
                    getModItem("minecraft", "bookshelf", 1, missing),
                    'E',
                    getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                    'F',
                    getModItem("ore", "plateDenseObsidian", 1, missing));
            ResearchItem research = new ResearchItem(
                    "ENCHANTINGTABLE",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                            .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("potentia"), 6),
                    0,
                    0,
                    4,
                    getModItem("minecraft", "enchanting_table", 1, missing))
                            .setPages(
                                    new ResearchPage("Minecraft.research_page.ENCHANTINGTABLE"),
                                    new ResearchPage(recipe))
                            .setParents("NITOR", "ALUMENTUM");
            ResearchCategories.addResearch(research);
        }
        // --- Disenchanting Table
        {
            ShapedArcaneRecipe recipe = ThaumcraftApi.addArcaneCraftingRecipe(
                    "DISENCHANTINGTABLE",
                    getModItem("DraconicEvolution", "dissEnchanter", 1, missing),
                    new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("aqua"), 75)
                            .add(Aspect.getAspect("terra"), 75).add(Aspect.getAspect("ignis"), 75)
                            .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                    "ABA",
                    "CDC",
                    "EFE",
                    'A',
                    getModItem("ore", "blockAmethyst", 1, missing),
                    'B',
                    getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                    'C',
                    getModItem("minecraft", "enchanted_book", 1, missing),
                    'D',
                    getModItem("minecraft", "enchanting_table", 1, missing),
                    'E',
                    getModItem("ore", "blockThaumium", 1, missing),
                    'F',
                    getModItem("ore", "plateDenseObsidian", 1, missing));
            ResearchItem research = new ResearchItem(
                    "DISENCHANTINGTABLE",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("alienis"), 21).add(Aspect.getAspect("perditio"), 18)
                            .add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                            .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("potentia"), 6),
                    2,
                    2,
                    4,
                    getModItem("DraconicEvolution", "dissEnchanter", 1, missing))
                            .setPages(
                                    new ResearchPage("DraconicEvolution.research_page.DISENCHANTINGTABLE"),
                                    new ResearchPage(recipe))
                            .setParents("ENCHANTINGTABLE").setConcealed();
            ThaumcraftApi.addWarpToResearch("DISENCHANTINGTABLE", 3);
            ResearchCategories.addResearch(research);
        }
        // --- Brewing Stand
        {
            ShapedArcaneRecipe recipe = ThaumcraftApi.addArcaneCraftingRecipe(
                    "BREWINGSTAND",
                    getModItem("minecraft", "brewing_stand", 1, missing),
                    new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("aqua"), 20)
                            .add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("ignis"), 20)
                            .add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 20),
                    "ABA",
                    "CBC",
                    "DED",
                    'A',
                    getModItem("ore", "ringAluminium", 1, missing),
                    'B',
                    getModItem("ore", "stickLongBlaze", 1, missing),
                    'C',
                    getModItem("ore", "stickAluminium", 1, missing),
                    'D',
                    getModItem("ore", "screwAluminium", 1, missing),
                    'E',
                    getModItem("minecraft", "cauldron", 1, missing));
            ResearchItem research = new ResearchItem(
                    "BREWINGSTAND",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 15)
                            .add(Aspect.getAspect("cognitio"), 12).add(Aspect.getAspect("perditio"), 12)
                            .add(Aspect.getAspect("ignis"), 9).add(Aspect.getAspect("terra"), 6)
                            .add(Aspect.getAspect("aqua"), 3),
                    2,
                    0,
                    4,
                    getModItem("minecraft", "brewing_stand", 1, missing)).setPages(
                            new ResearchPage("brewingstand.research_page.BREWINGSTAND.1"),
                            new ResearchPage("brewingstand.research_page.BREWINGSTAND.2"),
                            new ResearchPage("Minecraft.research_page.BREWINGSTAND.3"),
                            new ResearchPage(recipe));
            ResearchCategories.addResearch(research);
        }
        // --- Beacon Infusion
        {
            InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe(
                    "BEACON",
                    getModItem("minecraft", "beacon", 1, missing),
                    6,
                    new AspectList().add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("alienis"), 64)
                            .add(Aspect.getAspect("lux"), 64).add(Aspect.getAspect("ordo"), 64)
                            .add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("terra"), 64),
                    getModItem("minecraft", "diamond_block", 1, missing),
                    new ItemStack[] { getModItem("minecraft", "glass", 1, missing),
                            getModItem("gregtech", "gt.metaitem.01", 1, 17804, missing),
                            getModItem("gregtech", "gt.metaitem.01", 1, 24506, missing),
                            getModItem("minecraft", "glass", 1, missing),
                            getModItem("gregtech", "gt.metaitem.01", 1, 17804, missing),
                            getModItem("gregtech", "gt.metaitem.01", 1, 24506, missing),
                            getModItem("minecraft", "glass", 1, missing),
                            getModItem("gregtech", "gt.metaitem.01", 1, 17804, missing),
                            getModItem("gregtech", "gt.metaitem.01", 1, 24506, missing),
                            getModItem("minecraft", "glass", 1, missing),
                            getModItem("gregtech", "gt.metaitem.01", 1, 17804, missing),
                            getModItem("gregtech", "gt.metaitem.01", 1, 24506, missing) });
            ResearchItem research = new ResearchItem(
                    "BEACON",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                            .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("fames"), 6),
                    4,
                    0,
                    4,
                    getModItem("minecraft", "beacon", 1, missing))
                            .setPages(new ResearchPage("Minecraft.research_page.BEACON"), new ResearchPage(recipe))
                            .setParents("INFUSION");
            ThaumcraftApi.addWarpToResearch("BEACON", 2);
            ResearchCategories.addResearch(research);
        }
        // --- Dragon Egg
        {
            InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe(
                    "DRAGONEGG",
                    getModItem("minecraft", "dragon_egg", 1, missing),
                    6,
                    new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("bestia"), 56)
                            .add(Aspect.getAspect("praecantatio"), 48).add(Aspect.getAspect("victus"), 48),
                    getModItem("MagicBees", "miscResources", 1, 7, missing),
                    new ItemStack[] { getModItem("MagicBees", "miscResources", 1, 6, missing),
                            getModItem("MagicBees", "miscResources", 1, 6, missing),
                            getModItem("MagicBees", "miscResources", 1, 6, missing),
                            getModItem("MagicBees", "miscResources", 1, 6, missing),
                            getModItem("MagicBees", "miscResources", 1, 6, missing),
                            getModItem("MagicBees", "miscResources", 1, 6, missing),
                            getModItem("MagicBees", "miscResources", 1, 6, missing),
                            getModItem("MagicBees", "miscResources", 1, 6, missing) });
            ResearchItem research = new ResearchItem(
                    "DRAGONEGG",
                    "MAGICBEES",
                    new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                            .add(Aspect.getAspect("victus"), 9).add(Aspect.getAspect("bestia"), 6),
                    2,
                    5,
                    4,
                    getModItem("minecraft", "dragon_egg", 1, missing))
                            .setPages(new ResearchPage("Minecraft.research_page.DRAGONEGG"), new ResearchPage(recipe))
                            .setParents("MB_DimensionalSingularity").setSiblings("INFUSION").setConcealed();
            ThaumcraftApi.addWarpToResearch("DRAGONEGG", 5);
            ResearchCategories.addResearch(research);
        }
        // --- Silky Cloth and Jewel
        {
            InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe(
                    "SILKYCRYSTAL",
                    getModItem("TConstruct", "materials", 1, 26, missing),
                    4,
                    new AspectList().add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("terra"), 20)
                            .add(Aspect.getAspect("ordo"), 35).add(Aspect.getAspect("praecantatio"), 35)
                            .add(Aspect.getAspect("vitreus"), 20),
                    getModItem("gregtech", "gt.metaitem.02", 1, 29500, missing),
                    new ItemStack[] { getModItem("TConstruct", "materials", 1, 25, missing),
                            getModItem("Thaumcraft", "ItemShard", 1, missing),
                            getModItem("TConstruct", "materials", 1, 25, missing),
                            getModItem("Thaumcraft", "ItemShard", 1, 3, missing),
                            getModItem("TConstruct", "materials", 1, 25, missing),
                            getModItem("Thaumcraft", "ItemShard", 1, 4, missing) });
            ResearchItem research = new ResearchItem(
                    "SILKYCRYSTAL",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("pannus"), 15).add(Aspect.getAspect("lucrum"), 2)
                            .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("aer"), 6)
                            .add(Aspect.getAspect("praecantatio"), 3),
                    -2,
                    -2,
                    4,
                    getModItem("TConstruct", "materials", 1, 26, missing))
                            .setPages(
                                    new ResearchPage("TConstruct.research_page.SILKYCRYSTAL"),
                                    new ResearchPage(recipe))
                            .setParents("ENCHANTINGTABLE").setConcealed().setRound();
            ResearchCategories.addResearch(research);
        }
        // --- Lava Crystal
        {
            InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe(
                    "LAVACRYSTAL",
                    getModItem("TConstruct", "materials", 1, 7, missing),
                    3,
                    new AspectList().add(Aspect.getAspect("ignis"), 25).add(Aspect.getAspect("perditio"), 25)
                            .add(Aspect.getAspect("vacuos"), 20).add(Aspect.getAspect("praecantatio"), 35),
                    getModItem("minecraft", "fire_charge", 1, missing),
                    new ItemStack[] { getModItem("minecraft", "blaze_rod", 1, missing),
                            getModItem("minecraft", "lava_bucket", 1, missing),
                            getModItem("minecraft", "fire_charge", 1, missing),
                            getModItem("Thaumcraft", "ItemShard", 1, 1, missing),
                            getModItem("minecraft", "blaze_rod", 1, missing),
                            getModItem("minecraft", "lava_bucket", 1, missing),
                            getModItem("minecraft", "fire_charge", 1, missing),
                            getModItem("Thaumcraft", "ItemShard", 1, 1, missing) });
            ResearchItem research = new ResearchItem(
                    "LAVACRYSTAL",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                            .add(Aspect.getAspect("vacuos"), 9).add(Aspect.getAspect("perditio"), 6),
                    2,
                    -2,
                    4,
                    getModItem("TConstruct", "materials", 1, 7, missing))
                            .setPages(
                                    new ResearchPage("TConstruct.research_page.LAVACRYSTAL"),
                                    new ResearchPage(recipe))
                            .setParents("ENCHANTINGTABLE").setConcealed().setRound();
            ResearchCategories.addResearch(research);
        }
        // --- Ball of Moss
        {
            InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe(
                    "BALLOFMOSS",
                    getModItem("TConstruct", "materials", 1, 6, missing),
                    5,
                    new AspectList().add(Aspect.getAspect("sano"), 30).add(Aspect.getAspect("terra"), 25)
                            .add(Aspect.getAspect("instrumentum"), 35),
                    getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                    new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 2542, missing),
                            getModItem("TwilightForest", "tile.TFPlant", 1, 3, missing),
                            getModItem("BiomesOPlenty", "moss", 1, missing),
                            getModItem("gregtech", "gt.metaitem.01", 1, 2542, missing),
                            getModItem("TwilightForest", "tile.TFPlant", 1, 3, missing),
                            getModItem("BiomesOPlenty", "moss", 1, missing) });
            ResearchItem research = new ResearchItem(
                    "BALLOFMOSS",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("sano"), 15).add(Aspect.getAspect("terra"), 12)
                            .add(Aspect.getAspect("instrumentum"), 9),
                    0,
                    -4,
                    4,
                    getModItem("TConstruct", "materials", 1, 6, missing))
                            .setPages(new ResearchPage("TConstruct.research_page.BALLOFMOSS"), new ResearchPage(recipe))
                            .setParents("SILKYCRYSTAL", "LAVACRYSTAL").setConcealed().setRound();
            ResearchCategories.addResearch(research);
        }
        // --- Necrotic Bone
        {
            CrucibleRecipe recipe = ThaumcraftApi.addCrucibleRecipe(
                    "NECROTICBONE",
                    getModItem("TConstruct", "materials", 1, 8, missing),
                    getModItem("minecraft", "bone", 1, missing),
                    new AspectList().add(Aspect.getAspect("exanimis"), 20).add(Aspect.getAspect("mortuus"), 30)
                            .add(Aspect.getAspect("infernus"), 20).add(Aspect.getAspect("spiritus"), 20)
                            .add(Aspect.getAspect("venenum"), 20).add(Aspect.getAspect("corpus"), 5));
            ResearchItem research = new ResearchItem(
                    "NECROTICBONE",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("exanimis"), 15).add(Aspect.getAspect("mortuus"), 12)
                            .add(Aspect.getAspect("spiritus"), 9).add(Aspect.getAspect("venenum"), 6),
                    0,
                    -2,
                    4,
                    getModItem("TConstruct", "materials", 1, 8, missing))
                            .setPages(
                                    new ResearchPage("TConstruct.research_page.NECROTICBONE"),
                                    new ResearchPage(recipe))
                            .setParents("ENTROPICPROCESSING", "BALLOFMOSS", "SILKYCRYSTAL", "LAVACRYSTAL")
                            .setConcealed().setRound();
            ThaumcraftApi.addWarpToResearch("NECROTICBONE", 2);
            ResearchCategories.addResearch(research);
        }
        // --- Red Heart
        {
            InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe(
                    "REDHEART",
                    getModItem("TConstruct", "heartCanister", 1, 1, missing),
                    3,
                    new AspectList().add(Aspect.getAspect("exanimis"), 25).add(Aspect.getAspect("ignis"), 35)
                            .add(Aspect.getAspect("lucrum"), 35).add(Aspect.getAspect("sano"), 50)
                            .add(Aspect.getAspect("praecantatio"), 50),
                    getModItem("minecraft", "golden_apple", 1, missing),
                    new ItemStack[] { getModItem("TConstruct", "jerky", 1, 6, missing),
                            getModItem("minecraft", "apple", 1, missing),
                            getModItem("TConstruct", "jerky", 1, 7, missing),
                            getModItem("TConstruct", "materials", 1, 8, missing),
                            getModItem("TConstruct", "jerky", 1, missing),
                            getModItem("TConstruct", "jerky", 1, 1, missing),
                            getModItem("TConstruct", "jerky", 1, 2, missing),
                            getModItem("TConstruct", "jerky", 1, 3, missing),
                            getModItem("TConstruct", "jerky", 1, 4, missing),
                            getModItem("TConstruct", "jerky", 1, 5, missing) });
            ResearchItem research = new ResearchItem(
                    "REDHEART",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                            .add(Aspect.getAspect("sano"), 9).add(Aspect.getAspect("mortuus"), 6)
                            .add(Aspect.getAspect("exanimis"), 3),
                    0,
                    -6,
                    4,
                    getModItem("TConstruct", "heartCanister", 1, 1, missing))
                            .setPages(new ResearchPage("TConstruct.research_page.REDHEART.1"), new ResearchPage(recipe))
                            .setParents("RUNICAUGMENTATION", "BALLOFMOSS").setConcealed().setRound();
            ThaumcraftApi.addWarpToResearch("REDHEART", 1);
            ResearchCategories.addResearch(research);
        }
        // --- Red Heart Canister
        {
            ShapedArcaneRecipe recipe = ThaumcraftApi.addArcaneCraftingRecipe(
                    "REDHEARTCANISTER",
                    getModItem("TConstruct", "heartCanister", 1, 2, missing),
                    new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("aqua"), 50)
                            .add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("terra"), 50)
                            .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                    "ABC",
                    "DEC",
                    "CCC",
                    'A',
                    getModItem("TConstruct", "materials", 1, 8, missing),
                    'B',
                    getModItem("TConstruct", "heartCanister", 1, missing),
                    'C',
                    null,
                    'D',
                    getModItem("minecraft", "golden_apple", 1, missing),
                    'E',
                    getModItem("TConstruct", "heartCanister", 1, 1, missing));
            ResearchItem research = new ResearchItem(
                    "REDHEARTCANISTER",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("lucrum"), 15)
                            .add(Aspect.getAspect("sano"), 12).add(Aspect.getAspect("ignis"), 9)
                            .add(Aspect.getAspect("mortuus"), 6).add(Aspect.getAspect("exanimis"), 3),
                    0,
                    -8,
                    4,
                    getModItem("TConstruct", "heartCanister", 1, 2, missing))
                            .setPages(
                                    new ResearchPage("TConstruct.research_page.REDHEARTCANISTER.1"),
                                    new ResearchPage(recipe))
                            .setParents("REDHEART").setConcealed();
            ThaumcraftApi.addWarpToResearch("REDHEARTCANISTER", 2);
            ResearchCategories.addResearch(research);
        }
        // --- Yellow Heart
        {
            InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe(
                    "YELLOWHEART",
                    getModItem("TConstruct", "heartCanister", 1, 3, missing),
                    3,
                    new AspectList().add(Aspect.getAspect("exanimis"), 50).add(Aspect.getAspect("ignis"), 75)
                            .add(Aspect.getAspect("lucrum"), 75).add(Aspect.getAspect("sano"), 100)
                            .add(Aspect.getAspect("praecantatio"), 100),
                    getModItem("minecraft", "golden_apple", 1, 1, missing),
                    new ItemStack[] { getModItem("TConstruct", "heartCanister", 1, 1, missing),
                            getModItem("TConstruct", "materials", 1, 8, missing),
                            getModItem("TConstruct", "heartCanister", 1, 1, missing),
                            getModItem("TConstruct", "materials", 1, 8, missing),
                            getModItem("TConstruct", "heartCanister", 1, 1, missing),
                            getModItem("TConstruct", "materials", 1, 8, missing),
                            getModItem("TConstruct", "heartCanister", 1, 1, missing),
                            getModItem("TConstruct", "materials", 1, 8, missing),
                            getModItem("TConstruct", "heartCanister", 1, 1, missing),
                            getModItem("TConstruct", "materials", 1, 8, missing) });
            ResearchItem research = new ResearchItem(
                    "YELLOWHEART",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("mortuus"), 15).add(Aspect.getAspect("praecantatio"), 12)
                            .add(Aspect.getAspect("exanimis"), 9).add(Aspect.getAspect("sano"), 6)
                            .add(Aspect.getAspect("ignis"), 3),
                    -2,
                    -7,
                    4,
                    getModItem("TConstruct", "heartCanister", 1, 3, missing))
                            .setPages(
                                    new ResearchPage("TConstruct.research_page.YELLOWHEART.1"),
                                    new ResearchPage(recipe))
                            .setParents("REDHEART").setConcealed().setRound();
            ThaumcraftApi.addWarpToResearch("YELLOWHEART", 2);
            ResearchCategories.addResearch(research);
        }
        // --- Yellow Heart Canister
        {
            ShapedArcaneRecipe recipe = ThaumcraftApi.addArcaneCraftingRecipe(
                    "YELLOWHEARTCANISTER",
                    getModItem("TConstruct", "heartCanister", 1, 4, missing),
                    new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                            .add(Aspect.getAspect("ignis"), 100).add(Aspect.getAspect("terra"), 100)
                            .add(Aspect.getAspect("ordo"), 100).add(Aspect.getAspect("perditio"), 100),
                    "ABA",
                    "CDC",
                    "EEE",
                    'A',
                    getModItem("TConstruct", "materials", 1, 8, missing),
                    'B',
                    getModItem("TConstruct", "heartCanister", 1, missing),
                    'C',
                    getModItem("minecraft", "golden_apple", 1, 1, missing),
                    'D',
                    getModItem("TConstruct", "heartCanister", 1, 3, missing),
                    'E',
                    null);
            ResearchItem research = new ResearchItem(
                    "YELLOWHEARTCANISTER",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("lucrum"), 15)
                            .add(Aspect.getAspect("sano"), 12).add(Aspect.getAspect("praecantatio"), 9)
                            .add(Aspect.getAspect("mortuus"), 6).add(Aspect.getAspect("exanimis"), 3),
                    -2,
                    -9,
                    4,
                    getModItem("TConstruct", "heartCanister", 1, 4, missing))
                            .setPages(
                                    new ResearchPage("TConstruct.research_page.YELLOWHEARTCANISTER.1"),
                                    new ResearchPage(recipe))
                            .setParents("YELLOWHEART").setConcealed();
            ThaumcraftApi.addWarpToResearch("YELLOWHEARTCANISTER", 3);
            ResearchCategories.addResearch(research);
        }
        // --- Green Heart
        {
            InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe(
                    "GREENHEART",
                    getModItem("TConstruct", "heartCanister", 1, 5, missing),
                    3,
                    new AspectList().add(Aspect.getAspect("exanimis"), 100).add(Aspect.getAspect("ignis"), 150)
                            .add(Aspect.getAspect("lucrum"), 150).add(Aspect.getAspect("sano"), 200)
                            .add(Aspect.getAspect("praecantatio"), 200),
                    getModItem("TConstruct", "diamondApple", 1, missing),
                    new ItemStack[] { getModItem("TConstruct", "heartCanister", 1, 3, missing),
                            getModItem("TConstruct", "materials", 1, 8, missing),
                            getModItem("TConstruct", "heartCanister", 1, 3, missing),
                            getModItem("TConstruct", "materials", 1, 8, missing),
                            getModItem("TConstruct", "heartCanister", 1, 3, missing),
                            getModItem("TConstruct", "materials", 1, 8, missing),
                            getModItem("TConstruct", "heartCanister", 1, 3, missing),
                            getModItem("TConstruct", "materials", 1, 8, missing),
                            getModItem("TConstruct", "heartCanister", 1, 3, missing),
                            getModItem("TConstruct", "materials", 1, 8, missing) });
            ResearchItem research = new ResearchItem(
                    "GREENHEART",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("infernus"), 15).add(Aspect.getAspect("lucrum"), 12)
                            .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("spiritus"), 9)
                            .add(Aspect.getAspect("fames"), 6).add(Aspect.getAspect("corpus"), 3),
                    -4,
                    -7,
                    4,
                    getModItem("TConstruct", "heartCanister", 1, 5, missing))
                            .setPages(
                                    new ResearchPage("TConstruct.research_page.GREENHEART.1"),
                                    new ResearchPage(recipe))
                            .setParents("YELLOWHEART").setConcealed().setRound();
            ThaumcraftApi.addWarpToResearch("GREENHEART", 3);
            ResearchCategories.addResearch(research);
        }
        // --- Green Heart Canister
        {
            ShapedArcaneRecipe recipe = ThaumcraftApi.addArcaneCraftingRecipe(
                    "GREENHEARTCANISTER",
                    getModItem("TConstruct", "heartCanister", 1, 6, missing),
                    new AspectList().add(Aspect.getAspect("aer"), 200).add(Aspect.getAspect("aqua"), 200)
                            .add(Aspect.getAspect("ignis"), 200).add(Aspect.getAspect("terra"), 200)
                            .add(Aspect.getAspect("ordo"), 200).add(Aspect.getAspect("perditio"), 200),
                    "ABA",
                    "CDC",
                    "ACA",
                    'A',
                    getModItem("TConstruct", "materials", 1, 8, missing),
                    'B',
                    getModItem("TConstruct", "heartCanister", 1, missing),
                    'C',
                    getModItem("TConstruct", "diamondApple", 1, missing),
                    'D',
                    getModItem("TConstruct", "heartCanister", 1, 5, missing));
            ResearchItem research = new ResearchItem(
                    "GREENHEARTCANISTER",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("infernus"), 15).add(Aspect.getAspect("metallum"), 15)
                            .add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("sano"), 12)
                            .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("spiritus"), 9)
                            .add(Aspect.getAspect("fames"), 6).add(Aspect.getAspect("corpus"), 3),
                    -4,
                    -9,
                    4,
                    getModItem("TConstruct", "heartCanister", 1, 6, missing))
                            .setPages(
                                    new ResearchPage("TConstruct.research_page.GREENHEARTCANISTER.1"),
                                    new ResearchPage("TConstruct.research_page.GREENHEARTCANISTER.2"),
                                    new ResearchPage(recipe))
                            .setParents("GREENHEART").setConcealed();
            ThaumcraftApi.addWarpToResearch("GREENHEARTCANISTER", 4);
            ResearchCategories.addResearch(research);
        }
        // --- Ender Chest Arcane
        {
            ShapedArcaneRecipe recipe = ThaumcraftApi.addArcaneCraftingRecipe(
                    "ENDERCHEST",
                    getModItem("EnderStorage", "enderChest", 1, missing),
                    new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                            .add(Aspect.getAspect("ignis"), 100).add(Aspect.getAspect("terra"), 100),
                    "ABA",
                    "CDE",
                    "ABA",
                    'A',
                    getModItem("gregtech", "gt.metaitem.01", 1, 17506, missing),
                    'B',
                    getModItem("gregtech", "gt.metaitem.01", 1, 22321, missing),
                    'C',
                    getModItem("gregtech", "gt.metaitem.01", 1, 32694, missing),
                    'D',
                    getModItem("IronChest", "BlockIronChest", 1, 6, missing),
                    'E',
                    getModItem("gregtech", "gt.metaitem.01", 1, 32684, missing));
            ResearchItem research = new ResearchItem(
                    "ENDERCHEST",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("electrum"), 15)
                            .add(Aspect.getAspect("machina"), 12).add(Aspect.getAspect("alienis"), 9)
                            .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("fabrico"), 3),
                    -4,
                    0,
                    4,
                    getModItem("EnderStorage", "enderChest", 1, missing))
                            .setPages(
                                    new ResearchPage("EnderStorage.research_page.ENDERCHEST"),
                                    new ResearchPage(recipe))
                            .setParents("INFUSION").setConcealed();
            ResearchCategories.addResearch(research);
        }
        // --- Ender Tank Arcane
        {
            ShapedArcaneRecipe recipe = ThaumcraftApi.addArcaneCraftingRecipe(
                    "ENDERTANK",
                    getModItem("EnderStorage", "enderChest", 1, 4096, missing),
                    new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                            .add(Aspect.getAspect("ignis"), 100).add(Aspect.getAspect("terra"), 100)
                            .add(Aspect.getAspect("ordo"), 100),
                    "ABA",
                    "CDE",
                    "ABA",
                    'A',
                    getModItem("gregtech", "gt.metaitem.02", 1, 22801, missing),
                    'B',
                    getModItem("gregtech", "gt.metaitem.01", 1, 22321, missing),
                    'C',
                    getModItem("gregtech", "gt.metaitem.01", 1, 32694, missing),
                    'D',
                    getModItem("irontank", "obsidianTank", 1, missing),
                    'E',
                    getModItem("gregtech", "gt.metaitem.01", 1, 32684, missing));
            ResearchItem research = new ResearchItem(
                    "ENDERTANK",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("electrum"), 15)
                            .add(Aspect.getAspect("machina"), 12).add(Aspect.getAspect("ignis"), 9)
                            .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("sensus"), 3),
                    -4,
                    2,
                    4,
                    getModItem("EnderStorage", "enderChest", 1, 4096, missing))
                            .setPages(
                                    new ResearchPage("EnderStorage.research_page.ENDERTANK"),
                                    new ResearchPage(recipe))
                            .setParents("ENDERCHEST").setConcealed();
            ResearchCategories.addResearch(research);
        }
        // --- Ender Pouch Arcane
        {
            ShapedArcaneRecipe recipe = ThaumcraftApi.addArcaneCraftingRecipe(
                    "ENDERPOUCHE",
                    getModItem("EnderStorage", "enderPouch", 1, missing),
                    new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                            .add(Aspect.getAspect("ignis"), 100).add(Aspect.getAspect("terra"), 100)
                            .add(Aspect.getAspect("ordo"), 100).add(Aspect.getAspect("perditio"), 100),
                    "ABA",
                    "CDE",
                    "ABA",
                    'A',
                    getModItem("gregtech", "gt.metaitem.02", 1, 30500, missing),
                    'B',
                    getModItem("gregtech", "gt.metaitem.01", 1, 22321, missing),
                    'C',
                    getModItem("gregtech", "gt.metaitem.01", 1, 32694, missing),
                    'D',
                    getModItem("Backpack", "backpack", 1, 200, missing),
                    'E',
                    getModItem("gregtech", "gt.metaitem.01", 1, 32684, missing));
            ResearchItem research = new ResearchItem(
                    "ENDERPOUCHE",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("lucrum"), 15).add(Aspect.getAspect("vitreus"), 15)
                            .add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("electrum"), 9)
                            .add(Aspect.getAspect("machina"), 6).add(Aspect.getAspect("alienis"), 3),
                    -4,
                    4,
                    4,
                    getModItem("EnderStorage", "enderPouch", 1, missing))
                            .setPages(
                                    new ResearchPage("EnderStorage.research_page.ENDERPOUCHE"),
                                    new ResearchPage(recipe))
                            .setParents("ENDERTANK").setConcealed();
            ResearchCategories.addResearch(research);
        }
        // --- Auto Enchanting Table
        {
            ShapedArcaneRecipe recipe = ThaumcraftApi.addArcaneCraftingRecipe(
                    "AUTOENCHANTINGTABLE",
                    getModItem("OpenBlocks", "autoenchantmenttable", 1, missing),
                    new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("aqua"), 75)
                            .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("terra"), 75)
                            .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                    "ABA",
                    "CDC",
                    "EFE",
                    'A',
                    getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                    'B',
                    getModItem("minecraft", "book", 1, missing),
                    'C',
                    getModItem("gregtech", "gt.metaitem.01", 1, 27019, missing),
                    'D',
                    getModItem("minecraft", "enchanting_table", 1, missing),
                    'E',
                    getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing),
                    'F',
                    getModItem("minecraft", "redstone_block", 1, missing));
            ResearchItem research = new ResearchItem(
                    "AUTOENCHANTINGTABLE",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                            .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("potentia"), 6),
                    0,
                    2,
                    4,
                    getModItem("OpenBlocks", "autoenchantmenttable", 1, missing))
                            .setPages(
                                    new ResearchPage("OpenBlocks.research_page.AUTOENCHANTINGTABLE.1"),
                                    new ResearchPage("OpenBlocks.research_page.AUTOENCHANTINGTABLE.2"),
                                    new ResearchPage(recipe))
                            .setParents("ENCHANTINGTABLE").setConcealed();
            ThaumcraftApi.addWarpToResearch("AUTOENCHANTINGTABLE", 1);
            ResearchCategories.addResearch(research);
        }
        // --- Luggage
        {
            ShapedArcaneRecipe recipe = ThaumcraftApi.addArcaneCraftingRecipe(
                    "LUGGAGE",
                    getModItem("OpenBlocks", "luggage", 1, missing),
                    new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("aqua"), 75)
                            .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("terra"), 75)
                            .add(Aspect.getAspect("perditio"), 75).add(Aspect.getAspect("ordo"), 75),
                    "ABA",
                    "CDC",
                    "AEA",
                    'A',
                    getModItem("gregtech", "gt.metaitem.01", 1, 27019, missing),
                    'B',
                    getModItem("Thaumcraft", "ItemGolemCore", 1, missing),
                    'C',
                    getModItem("Automagy", "crystalBrain", 1, 3, missing),
                    'D',
                    getModItem("Thaumcraft", "blockChestHungry", 1, missing),
                    'E',
                    getModItem("Thaumcraft", "blockCosmeticSolid", 1, 2, missing));
            ResearchItem research = new ResearchItem(
                    "LUGGAGE",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("sensus"), 15)
                            .add(Aspect.getAspect("iter"), 12).add(Aspect.getAspect("praecantatio"), 9)
                            .add(Aspect.getAspect("fabrico"), 6).add(Aspect.getAspect("lucrum"), 3),
                    -2,
                    0,
                    4,
                    getModItem("OpenBlocks", "luggage", 1, missing))
                            .setPages(
                                    new ResearchPage("OpenBlocks.research_page.LUGGAGE.1"),
                                    new ResearchPage("OpenBlocks.research_page.LUGGAGE.2"),
                                    new ResearchPage(recipe))
                            .setParents("ENDERCHEST").setConcealed();
            ThaumcraftApi.addWarpToResearch("LUGGAGE", 1);
            ResearchCategories.addResearch(research);
        }
        // --- Ghost Amulet HEE
        {
            InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe(
                    "GHOSTAMULET",
                    getModItem("HardcoreEnderExpansion", "ghost_amulet", 1, 1, missing),
                    9,
                    new AspectList().add(Aspect.getAspect("auram"), 64).add(Aspect.getAspect("potentia"), 64)
                            .add(Aspect.getAspect("vitium"), 32).add(Aspect.getAspect("vitreus"), 48)
                            .add(Aspect.getAspect("spiritus"), 32).add(Aspect.getAspect("corpus"), 16)
                            .add(Aspect.getAspect("alienis"), 24).add(Aspect.getAspect("lucrum"), 8),
                    getModItem("HardcoreEnderExpansion", "ghost_amulet", 1, missing),
                    new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 11975, missing),
                            getModItem("HardcoreEnderExpansion", "instability_orb", 1, missing),
                            getModItem("gregtech", "gt.metaitem.01", 1, 28770, missing),
                            getModItem("HardcoreEnderExpansion", "end_powder", 1, missing),
                            getModItem("HardcoreEnderExpansion", "fire_shard", 1, missing),
                            getModItem("HardcoreEnderExpansion", "igneous_rock", 1, missing),
                            getModItem("HardcoreEnderExpansion", "end_powder", 1, missing),
                            getModItem("gregtech", "gt.metaitem.01", 1, 11975, missing),
                            getModItem("HardcoreEnderExpansion", "instability_orb", 1, missing),
                            getModItem("gregtech", "gt.metaitem.01", 1, 28770, missing),
                            getModItem("HardcoreEnderExpansion", "end_powder", 1, missing),
                            getModItem("HardcoreEnderExpansion", "igneous_rock", 1, missing),
                            getModItem("HardcoreEnderExpansion", "fire_shard", 1, missing),
                            getModItem("HardcoreEnderExpansion", "end_powder", 1, missing) });
            ResearchItem research = new ResearchItem(
                    "GHOSTAMULET",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("potentia"), 21).add(Aspect.getAspect("auram"), 18)
                            .add(Aspect.getAspect("infernus"), 15).add(Aspect.getAspect("lucrum"), 12)
                            .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("spiritus"), 9)
                            .add(Aspect.getAspect("alienis"), 6).add(Aspect.getAspect("corpus"), 3),
                    4,
                    2,
                    4,
                    getModItem("HardcoreEnderExpansion", "ghost_amulet", 1, 1, missing))
                            .setPages(new ResearchPage("Hee.research_page.GHOSTAMULET.1"), new ResearchPage(recipe))
                            .setParents("ENCHANTINGTABLE", "BREWINGSTAND").setConcealed().setRound();
            ThaumcraftApi.addWarpToResearch("GHOSTAMULET", 3);
            ResearchCategories.addResearch(research);
        }
        // --- Skullfire Sword
        {
            InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe(
                    "SFSWORD",
                    getModItem("Avaritia", "Skull_Sword", 1, missing),
                    15,
                    new AspectList().add(Aspect.getAspect("auram"), 64).add(Aspect.getAspect("corpus"), 64)
                            .add(Aspect.getAspect("exanimis"), 64).add(Aspect.getAspect("metallum"), 64)
                            .add(Aspect.getAspect("mortuus"), 64),
                    getModItem("TwilightForest", "item.fierySword", 1, missing),
                    new ItemStack[] { getModItem("minecraft", "blaze_rod", 1, missing),
                            getModItem("minecraft", "blaze_powder", 1, missing),
                            getModItem("Avaritia", "Resource", 1, 0, missing),
                            getModItem("dreamcraft", "item.LichBone", 1, missing),
                            getModItem("Avaritia", "Resource", 1, 0, missing),
                            getModItem("TConstruct", "materials", 1, 8, missing),
                            getModItem("gregtech", "gt.metaitem.01", 1, 11054, missing),
                            getModItem("TConstruct", "materials", 1, 8, missing),
                            getModItem("Avaritia", "Resource", 1, 0, missing),
                            getModItem("dreamcraft", "item.LichBone", 1, missing),
                            getModItem("Avaritia", "Resource", 1, 0, missing),
                            getModItem("minecraft", "blaze_powder", 1, missing) });
            ResearchItem research = new ResearchItem(
                    "SFSWORD",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("auram"), 8).add(Aspect.getAspect("corpus"), 8)
                            .add(Aspect.getAspect("exanimis"), 8).add(Aspect.getAspect("metallum"), 8)
                            .add(Aspect.getAspect("mortuus"), 8),
                    4,
                    4,
                    4,
                    getModItem("Avaritia", "Skull_Sword", 1, missing))
                            .setPages(new ResearchPage("Avaritia.research_page.SFSWORD.1"), new ResearchPage(recipe))
                            .setParents("INFUSION").setConcealed().setRound();
            ThaumcraftApi.addWarpToResearch("SFSWORD", 1);
            ResearchCategories.addResearch(research);
        }
        // --- Obsidian Tile and Totem
        {
            InfusionRecipe recipe = ThaumcraftApi.addInfusionCraftingRecipe(
                    "MAGICOBSIDIAN",
                    getModItem("Thaumcraft", "blockCosmeticSolid", 4, 0, missing),
                    3,
                    new AspectList().add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("tenebrae"), 16)
                            .add(Aspect.getAspect("terra"), 16),
                    getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing),
                    new ItemStack[] { getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing),
                            getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing),
                            getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing) });
            ResearchItem research = new ResearchItem(
                    "MAGICOBSIDIAN",
                    "NEWHORIZONS",
                    new AspectList().add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("terra"), 8),
                    2,
                    4,
                    2,
                    getModItem("Thaumcraft", "blockCosmeticSolid", 1, 0, missing))
                            .setPages(new ResearchPage("Thaum.research_page.MAGICOBSIDIAN"), new ResearchPage(recipe))
                            .setParents("INFUSION").setConcealed().setRound();
            ThaumcraftApi.addWarpToResearch("MAGICOBSIDIAN", 1);
            ResearchCategories.addResearch(research);
        }
    }
}
