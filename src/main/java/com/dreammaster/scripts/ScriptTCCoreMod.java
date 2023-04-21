package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

import com.dreammaster.thaumcraft.TCHelper;
import gregtech.api.enums.Mods;

public class ScriptTCCoreMod implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Thaumcraft Core Mod";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Mods.Thaumcraft.ID,
                Mods.MagicBees.ID,
                Mods.ExtraUtilities.ID,
                Mods.ProjectRedIllumination.ID,
                Mods.EternalSingularity.ID,
                Mods.TwilightForest.ID,
                Mods.IndustrialCraft2.ID,
                Mods.DraconicEvolution.ID,
                Mods.PamsHarvestCraft.ID,
                Mods.TinkerConstruct.ID,
                Mods.BiomesOPlenty.ID,
                Mods.EnderStorage.ID,
                Mods.IronChests.ID,
                Mods.OpenBlocks.ID,
                Mods.Backpack.ID,
                "Automagy",
                Mods.HardcoreEnderExpansion.ID,
                Mods.Avaritia.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack missing = new ItemStack(Blocks.dirt);

        new ResearchItem(
                "WITHERRING",
                "ARTIFICE",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("superbia"), 9).add(Aspect.getAspect("spiritus"), 6)
                        .add(Aspect.getAspect("infernus"), 3),
                3,
                2,
                3,
                getModItem("dreamcraft", "item.WitherProtectionRing", 1, 0, missing)).setParents("RUNICARMOR")
                        .setSiblings("RUNICARMOR").setConcealed()
                        .setPages(new ResearchPage("NewHorizons.research_page.WITHERRING")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "WITHERRING",
                getModItem("dreamcraft", "item.WitherProtectionRing", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("alienis"), 45).add(Aspect.getAspect("praecantatio"), 35)
                        .add(Aspect.getAspect("spiritus"), 30).add(Aspect.getAspect("superbia"), 25)
                        .add(Aspect.getAspect("infernus"), 15),
                getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 1, missing),
                new ItemStack[] { getModItem("minecraft", "nether_star", 1, 0, missing),
                        getModItem("minecraft", "milk_bucket", 1, 0, missing),
                        getModItem("minecraft", "skull", 1, 1, missing),
                        getModItem("minecraft", "milk_bucket", 1, 0, missing),
                        getModItem("minecraft", "skull", 1, 1, missing), });
        TCHelper.addResearchPage(
                "WITHERRING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem("dreamcraft", "item.WitherProtectionRing", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("WITHERRING", 2);
        new ResearchItem(
                "EMINENCESTONE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("sensus"), 12)
                        .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("aer"), 6),
                0,
                4,
                3,
                getModItem("ExtraUtilities", "decorativeBlock1", 1, 14, missing)).setParents("INFUSION")
                        .setPages(new ResearchPage("ExtraUtilities.research_page.EMINENCESTONE"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "EMINENCESTONE",
                getModItem("ExtraUtilities", "decorativeBlock1", 2, 14, missing),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("ignis"), 50)
                        .add(Aspect.getAspect("terra"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                'b',
                getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1, 18, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 17532, missing),
                'e',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 17532, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                'h',
                getModItem("ProjRed|Illumination", "projectred.illumination.lamp", 1, 26, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing));
        TCHelper.addResearchPage(
                "EMINENCESTONE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("ExtraUtilities", "decorativeBlock1", 1, 14, missing))));
        new ResearchItem(
                "PORTALMILLENIUM",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("sensus"), 12)
                        .add(Aspect.getAspect("terra"), 9),
                2,
                6,
                3,
                getModItem("ExtraUtilities", "dark_portal", 1, 2, missing)).setParents("EMINENCESTONE", "OCULUS")
                        .setConcealed().setPages(new ResearchPage("ExtraUtilities.research_page.PORTALMILLENIUM"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "PORTALMILLENIUM",
                getModItem("ExtraUtilities", "dark_portal", 1, 2, missing),
                4,
                new AspectList().add(Aspect.getAspect("alienis"), 75).add(Aspect.getAspect("sensus"), 25)
                        .add(Aspect.getAspect("praecantatio"), 75).add(Aspect.getAspect("terra"), 25)
                        .add(Aspect.getAspect("vacuos"), 75),
                getModItem("minecraft", "clock", 1, 0, missing),
                new ItemStack[] { getModItem("ExtraUtilities", "decorativeBlock1", 1, 14, missing),
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 2, missing),
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 14, missing),
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 2, missing),
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 14, missing),
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 2, missing),
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 14, missing),
                        getModItem("ExtraUtilities", "decorativeBlock1", 1, 2, missing), });
        TCHelper.addResearchPage(
                "PORTALMILLENIUM",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("ExtraUtilities", "dark_portal", 1, 2, missing))));
        ThaumcraftApi.addWarpToResearch("PORTALMILLENIUM", 2);
        new ResearchItem(
                "PORTALDEEPDARK",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("vacuos"), 27).add(Aspect.getAspect("tempus"), 24)
                        .add(Aspect.getAspect("luxuria"), 21).add(Aspect.getAspect("gula"), 12)
                        .add(Aspect.getAspect("superbia"), 9),
                2,
                8,
                3,
                getModItem("ExtraUtilities", "dark_portal", 1, 0, missing)).setParents("PORTALMILLENIUM", "ICHOR")
                        .setConcealed().setPages(new ResearchPage("ExtraUtilities.research_page.PORTALDEEPDARK"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "PORTALDEEPDARK",
                getModItem("ExtraUtilities", "dark_portal", 1, 0, missing),
                32,
                new AspectList().add(Aspect.getAspect("vacuos"), 512).add(Aspect.getAspect("tempus"), 512)
                        .add(Aspect.getAspect("luxuria"), 512).add(Aspect.getAspect("alienis"), 512)
                        .add(Aspect.getAspect("terminus"), 512).add(Aspect.getAspect("gula"), 512)
                        .add(Aspect.getAspect("superbia"), 512),
                getModItem("gregtech", "gt.blockreinforced", 1, 12, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 32046, missing),
                        getModItem("eternalsingularity", "eternal_singularity", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32046, missing),
                        getModItem("eternalsingularity", "eternal_singularity", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32046, missing),
                        getModItem("eternalsingularity", "eternal_singularity", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32046, missing),
                        getModItem("eternalsingularity", "eternal_singularity", 1, 0, missing), });
        TCHelper.addResearchPage(
                "PORTALDEEPDARK",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("ExtraUtilities", "dark_portal", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("PORTALDEEPDARK", 64);
        new ResearchItem(
                "MAGICALWOOD",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("arbor"), 9).add(Aspect.getAspect("cognitio"), 6)
                        .add(Aspect.getAspect("pannus"), 3),
                -2,
                6,
                3,
                getModItem("ExtraUtilities", "decorativeBlock1", 1, 8, missing)).setParents("EMINENCESTONE")
                        .setConcealed().setPages(new ResearchPage("ExtraUtilities.research_page.MAGICALWOOD"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MAGICALWOOD",
                getModItem("ExtraUtilities", "decorativeBlock1", 4, 8, missing),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("terra"), 10).add(Aspect.getAspect("aqua"), 10)
                        .add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 1, missing),
                'b',
                getModItem("TwilightForest", "item.carminite", 1, 0, missing),
                'c',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                'e',
                getModItem("minecraft", "bookshelf", 1, 0, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                'g',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                'h',
                getModItem("TwilightForest", "item.carminite", 1, 0, missing),
                'i',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 1, missing));
        TCHelper.addResearchPage(
                "MAGICALWOOD",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("ExtraUtilities", "decorativeBlock1", 1, 8, missing))));
        new ResearchItem(
                "ANGELBLOCK",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("ignis"), 9).add(Aspect.getAspect("terra"), 6),
                -2,
                8,
                3,
                getModItem("ExtraUtilities", "angelBlock", 1, 0, missing)).setParents("MAGICALWOOD").setConcealed()
                        .setPages(new ResearchPage("ExtraUtilities.research_page.ANGELBLOCK")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ANGELBLOCK",
                getModItem("ExtraUtilities", "angelBlock", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 17540, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 29351, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 17540, missing),
                'd',
                getModItem("IC2", "itemDensePlates", 1, 7, missing),
                'e',
                getModItem("Automagy", "blockRunedObsidian", 1, 0, missing),
                'f',
                getModItem("IC2", "itemDensePlates", 1, 7, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 17540, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 29351, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 17540, missing));
        TCHelper.addResearchPage(
                "ANGELBLOCK",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("ExtraUtilities", "angelBlock", 1, 0, missing))));
        new ResearchItem(
                "DEZILSMARSHMALLOW",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("superbia"), 9).add(Aspect.getAspect("sano"), 6)
                        .add(Aspect.getAspect("potentia"), 3),
                -2,
                2,
                3,
                getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0, missing)).setParents("INFUSION").setSpecial()
                        .setPages(new ResearchPage("de.research_page.DEZILSMARSHMALLOW")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "DEZILSMARSHMALLOW",
                getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("alienis"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("superbia"), 24).add(Aspect.getAspect("sano"), 28)
                        .add(Aspect.getAspect("iter"), 20).add(Aspect.getAspect("potentia"), 12),
                getModItem("dreamcraft", "item.Marshmallow", 1, 0, missing),
                new ItemStack[] { getModItem("harvestcraft", "epicbaconItem", 1, 0, missing),
                        getModItem("harvestcraft", "deluxechickencurryItem", 1, 0, missing),
                        getModItem("harvestcraft", "meatfeastpizzaItem", 1, 0, missing),
                        getModItem("harvestcraft", "beefwellingtonItem", 1, 0, missing),
                        getModItem("harvestcraft", "sausageinbreadItem", 1, 0, missing),
                        getModItem("harvestcraft", "heartybreakfastItem", 1, 0, missing), });
        TCHelper.addResearchPage(
                "DEZILSMARSHMALLOW",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem("DraconicEvolution", "dezilsMarshmallow", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("DEZILSMARSHMALLOW", 8);
        new ResearchItem(
                "ENCHANTINGTABLE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("potentia"), 6),
                0,
                0,
                3,
                getModItem("minecraft", "enchanting_table", 1, 0, missing)).setParents("NITOR", "ALUMENTUM")
                        .setPages(new ResearchPage("Minecraft.research_page.ENCHANTINGTABLE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENCHANTINGTABLE",
                getModItem("minecraft", "enchanting_table", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 45).add(Aspect.getAspect("aqua"), 45)
                        .add(Aspect.getAspect("terra"), 45).add(Aspect.getAspect("ignis"), 45)
                        .add(Aspect.getAspect("ordo"), 45).add(Aspect.getAspect("perditio"), 45),
                "abc",
                "def",
                "ghi",
                'a',
                createItemStack("ForgeMicroblock", "microblock", 1, 516, "{mat:\"minecraft:diamond_block\"}", missing),
                'b',
                getModItem("minecraft", "carpet", 1, 14, missing),
                'c',
                createItemStack("ForgeMicroblock", "microblock", 1, 516, "{mat:\"minecraft:diamond_block\"}", missing),
                'd',
                getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                'e',
                getModItem("minecraft", "bookshelf", 1, 0, missing),
                'f',
                getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                'g',
                createItemStack("ForgeMicroblock", "microblock", 1, 516, "{mat:\"minecraft:diamond_block\"}", missing),
                'h',
                "plateDenseObsidian",
                'i',
                createItemStack("ForgeMicroblock", "microblock", 1, 516, "{mat:\"minecraft:diamond_block\"}", missing));
        TCHelper.addResearchPage(
                "ENCHANTINGTABLE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("minecraft", "enchanting_table", 1, 0, missing))));
        new ResearchItem(
                "DISENCHANTINGTABLE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("alienis"), 21).add(Aspect.getAspect("perditio"), 18)
                        .add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("potentia"), 6),
                2,
                2,
                3,
                getModItem("DraconicEvolution", "dissEnchanter", 1, 0, missing)).setParents("ENCHANTINGTABLE")
                        .setConcealed().setPages(new ResearchPage("DraconicEvolution.research_page.DISENCHANTINGTABLE"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DISENCHANTINGTABLE",
                getModItem("DraconicEvolution", "dissEnchanter", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("terra"), 75).add(Aspect.getAspect("ignis"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                "blockAmethyst",
                'b',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'c',
                "blockAmethyst",
                'd',
                getModItem("minecraft", "enchanted_book", 1, 0, missing),
                'e',
                getModItem("minecraft", "enchanting_table", 1, 0, missing),
                'f',
                getModItem("minecraft", "enchanted_book", 1, 0, missing),
                'g',
                "blockThaumium",
                'h',
                "plateDenseObsidian",
                'i',
                "blockThaumium");
        TCHelper.addResearchPage(
                "DISENCHANTINGTABLE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("DraconicEvolution", "dissEnchanter", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("DISENCHANTINGTABLE", 3);
        new ResearchItem(
                "BREWINGSTAND",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 15)
                        .add(Aspect.getAspect("cognitio"), 12).add(Aspect.getAspect("perditio"), 12)
                        .add(Aspect.getAspect("ignis"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("aqua"), 3),
                2,
                0,
                3,
                getModItem("minecraft", "brewing_stand", 1, 0, missing))
                        .setPages(
                                new ResearchPage("brewingstand.research_page.BREWINGSTAND.1"),
                                new ResearchPage("brewingstand.research_page.BREWINGSTAND.2"),
                                new ResearchPage("Minecraft.research_page.BREWINGSTAND.3"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BREWINGSTAND",
                getModItem("minecraft", "brewing_stand", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("aqua"), 20)
                        .add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "ringAluminium",
                'b',
                "stickLongBlaze",
                'c',
                "ringAluminium",
                'd',
                "stickAluminium",
                'e',
                "stickLongBlaze",
                'f',
                "stickAluminium",
                'g',
                "screwAluminium",
                'h',
                getModItem("minecraft", "cauldron", 1, 0, missing),
                'i',
                "screwAluminium");
        TCHelper.addResearchPage(
                "BREWINGSTAND",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("minecraft", "brewing_stand", 1, 0, missing))));
        new ResearchItem(
                "BEACON",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("fames"), 6),
                4,
                0,
                3,
                getModItem("minecraft", "beacon", 1, 0, missing)).setParents("INFUSION")
                        .setPages(new ResearchPage("Minecraft.research_page.BEACON")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "BEACON",
                getModItem("minecraft", "beacon", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("alienis"), 64)
                        .add(Aspect.getAspect("lux"), 64).add(Aspect.getAspect("ordo"), 64)
                        .add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("terra"), 64),
                getModItem("minecraft", "diamond_block", 1, 0, missing),
                new ItemStack[] { getModItem("minecraft", "glass", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17804, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 24506, missing),
                        getModItem("minecraft", "glass", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17804, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 24506, missing),
                        getModItem("minecraft", "glass", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17804, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 24506, missing),
                        getModItem("minecraft", "glass", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17804, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 24506, missing), });
        TCHelper.addResearchPage(
                "BEACON",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("minecraft", "beacon", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("BEACON", 2);
        new ResearchItem(
                "DRAGONEGG",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("victus"), 9).add(Aspect.getAspect("bestia"), 6),
                2,
                5,
                3,
                getModItem("minecraft", "dragon_egg", 1, 0, missing)).setParents("MB_DimensionalSingularity")
                        .setSiblings("INFUSION").setConcealed()
                        .setPages(new ResearchPage("Minecraft.research_page.DRAGONEGG")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "DRAGONEGG",
                getModItem("minecraft", "dragon_egg", 1, 0, missing),
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
                        getModItem("MagicBees", "miscResources", 1, 6, missing), });
        TCHelper.addResearchPage(
                "DRAGONEGG",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("minecraft", "dragon_egg", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("DRAGONEGG", 5);
        new ResearchItem(
                "SILKYCRYSTAL",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("pannus"), 15).add(Aspect.getAspect("lucrum"), 2)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                -2,
                -2,
                3,
                getModItem("TConstruct", "materials", 1, 26, missing)).setParents("ENCHANTINGTABLE").setConcealed()
                        .setRound().setPages(new ResearchPage("TConstruct.research_page.SILKYCRYSTAL"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SILKYCRYSTAL",
                getModItem("TConstruct", "materials", 1, 25, missing),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("aqua"), 25)
                        .add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("minecraft", "string", 1, 0, missing),
                'b',
                "foilGold",
                'c',
                getModItem("minecraft", "string", 1, 0, missing),
                'd',
                "foilGold",
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'f',
                "foilGold",
                'g',
                getModItem("minecraft", "string", 1, 0, missing),
                'h',
                "foilGold",
                'i',
                getModItem("minecraft", "string", 1, 0, missing));
        TCHelper.addResearchPage(
                "SILKYCRYSTAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("TConstruct", "materials", 1, 25, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SILKYCRYSTAL",
                getModItem("TConstruct", "materials", 1, 26, missing),
                4,
                new AspectList().add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("ordo"), 35).add(Aspect.getAspect("praecantatio"), 35)
                        .add(Aspect.getAspect("vitreus"), 20),
                getModItem("gregtech", "gt.metaitem.02", 1, 29500, missing),
                new ItemStack[] { getModItem("TConstruct", "materials", 1, 25, missing),
                        getModItem("Thaumcraft", "ItemShard", 1, 0, missing),
                        getModItem("TConstruct", "materials", 1, 25, missing),
                        getModItem("Thaumcraft", "ItemShard", 1, 3, missing),
                        getModItem("TConstruct", "materials", 1, 25, missing),
                        getModItem("Thaumcraft", "ItemShard", 1, 4, missing), });
        TCHelper.addResearchPage(
                "SILKYCRYSTAL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("TConstruct", "materials", 1, 26, missing))));
        new ResearchItem(
                "LAVACRYSTAL",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("vacuos"), 9).add(Aspect.getAspect("perditio"), 6),
                2,
                -2,
                3,
                getModItem("TConstruct", "materials", 1, 7, missing)).setParents("ENCHANTINGTABLE").setConcealed()
                        .setRound().setPages(new ResearchPage("TConstruct.research_page.LAVACRYSTAL"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "LAVACRYSTAL",
                getModItem("TConstruct", "materials", 1, 7, missing),
                3,
                new AspectList().add(Aspect.getAspect("ignis"), 25).add(Aspect.getAspect("perditio"), 25)
                        .add(Aspect.getAspect("vacuos"), 20).add(Aspect.getAspect("praecantatio"), 35),
                getModItem("minecraft", "fire_charge", 1, 0, missing),
                new ItemStack[] { getModItem("minecraft", "blaze_rod", 1, 0, missing),
                        getModItem("minecraft", "lava_bucket", 1, 0, missing),
                        getModItem("minecraft", "fire_charge", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemShard", 1, 1, missing),
                        getModItem("minecraft", "blaze_rod", 1, 0, missing),
                        getModItem("minecraft", "lava_bucket", 1, 0, missing),
                        getModItem("minecraft", "fire_charge", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemShard", 1, 1, missing), });
        TCHelper.addResearchPage(
                "LAVACRYSTAL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("TConstruct", "materials", 1, 7, missing))));
        new ResearchItem(
                "BALLOFMOSS",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("sano"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9),
                0,
                -4,
                3,
                getModItem("TConstruct", "materials", 1, 6, missing)).setParents("SILKYCRYSTAL", "LAVACRYSTAL")
                        .setConcealed().setRound().setPages(new ResearchPage("TConstruct.research_page.BALLOFMOSS"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "BALLOFMOSS",
                getModItem("TConstruct", "materials", 1, 6, missing),
                5,
                new AspectList().add(Aspect.getAspect("sano"), 30).add(Aspect.getAspect("terra"), 25)
                        .add(Aspect.getAspect("instrumentum"), 35),
                getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 2542, missing),
                        getModItem("TwilightForest", "tile.TFPlant", 1, 3, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2542, missing),
                        getModItem("TwilightForest", "tile.TFPlant", 1, 3, missing),
                        getModItem("BiomesOPlenty", "moss", 1, 0, missing), });
        TCHelper.addResearchPage(
                "BALLOFMOSS",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("TConstruct", "materials", 1, 6, missing))));
        new ResearchItem(
                "NECROTICBONE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("exanimis"), 15).add(Aspect.getAspect("mortuus"), 12)
                        .add(Aspect.getAspect("spiritus"), 9).add(Aspect.getAspect("venenum"), 6),
                0,
                -2,
                3,
                getModItem("TConstruct", "materials", 1, 8, missing))
                        .setParents("ENTROPICPROCESSING", "BALLOFMOSS", "SILKYCRYSTAL", "LAVACRYSTAL").setConcealed()
                        .setRound().setPages(new ResearchPage("TConstruct.research_page.NECROTICBONE"))
                        .registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "NECROTICBONE",
                getModItem("TConstruct", "materials", 1, 8, missing),
                getModItem("minecraft", "bone", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("exanimis"), 20).add(Aspect.getAspect("mortuus"), 30)
                        .add(Aspect.getAspect("infernus"), 20).add(Aspect.getAspect("spiritus"), 20)
                        .add(Aspect.getAspect("venenum"), 20).add(Aspect.getAspect("corpus"), 5));
        TCHelper.addResearchPage(
                "NECROTICBONE",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("TConstruct", "materials", 1, 8, missing))));
        ThaumcraftApi.addWarpToResearch("NECROTICBONE", 2);
        new ResearchItem(
                "REDHEART",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("sano"), 9).add(Aspect.getAspect("mortuus"), 6)
                        .add(Aspect.getAspect("exanimis"), 3),
                0,
                -6,
                3,
                getModItem("TConstruct", "heartCanister", 1, 1, missing)).setParents("RUNICAUGMENTATION", "BALLOFMOSS")
                        .setConcealed().setRound().setPages(new ResearchPage("TConstruct.research_page.REDHEART.1"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "REDHEART",
                getModItem("TConstruct", "heartCanister", 1, 1, missing),
                3,
                new AspectList().add(Aspect.getAspect("exanimis"), 25).add(Aspect.getAspect("ignis"), 35)
                        .add(Aspect.getAspect("lucrum"), 35).add(Aspect.getAspect("sano"), 50)
                        .add(Aspect.getAspect("praecantatio"), 50),
                getModItem("minecraft", "golden_apple", 1, 0, missing),
                new ItemStack[] { getModItem("TConstruct", "jerky", 1, 6, missing),
                        getModItem("minecraft", "apple", 1, 0, missing),
                        getModItem("TConstruct", "jerky", 1, 7, missing),
                        getModItem("TConstruct", "materials", 1, 8, missing),
                        getModItem("TConstruct", "jerky", 1, 0, missing),
                        getModItem("TConstruct", "jerky", 1, 1, missing),
                        getModItem("TConstruct", "jerky", 1, 2, missing),
                        getModItem("TConstruct", "jerky", 1, 3, missing),
                        getModItem("TConstruct", "jerky", 1, 4, missing),
                        getModItem("TConstruct", "jerky", 1, 5, missing), });
        TCHelper.addResearchPage(
                "REDHEART",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("TConstruct", "heartCanister", 1, 1, missing))));
        ThaumcraftApi.addWarpToResearch("REDHEARTCANISTER", 1);
        new ResearchItem(
                "REDHEARTCANISTER",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("lucrum"), 15)
                        .add(Aspect.getAspect("sano"), 12).add(Aspect.getAspect("ignis"), 9)
                        .add(Aspect.getAspect("mortuus"), 6).add(Aspect.getAspect("exanimis"), 3),
                0,
                -8,
                3,
                getModItem("TConstruct", "heartCanister", 1, 2, missing)).setParents("REDHEART").setConcealed()
                        .setPages(new ResearchPage("TConstruct.research_page.REDHEARTCANISTER.1"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REDHEARTCANISTER",
                getModItem("TConstruct", "heartCanister", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("TConstruct", "materials", 1, 8, missing),
                'b',
                getModItem("TConstruct", "heartCanister", 1, 0, missing),
                'd',
                getModItem("minecraft", "golden_apple", 1, 0, missing),
                'e',
                getModItem("TConstruct", "heartCanister", 1, 1, missing));
        TCHelper.addResearchPage(
                "REDHEARTCANISTER",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("TConstruct", "heartCanister", 1, 2, missing))));
        ThaumcraftApi.addWarpToResearch("REDHEARTCANISTER", 2);
        new ResearchItem(
                "YELLOWHEART",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("mortuus"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("exanimis"), 9).add(Aspect.getAspect("sano"), 6)
                        .add(Aspect.getAspect("ignis"), 3),
                -2,
                -7,
                3,
                getModItem("TConstruct", "heartCanister", 1, 3, missing)).setParents("REDHEART").setConcealed()
                        .setRound().setPages(new ResearchPage("TConstruct.research_page.YELLOWHEART.1"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
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
                        getModItem("TConstruct", "materials", 1, 8, missing), });
        TCHelper.addResearchPage(
                "YELLOWHEART",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("TConstruct", "heartCanister", 1, 3, missing))));
        ThaumcraftApi.addWarpToResearch("YELLOWHEARTCANISTER", 2);
        new ResearchItem(
                "YELLOWHEARTCANISTER",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("lucrum"), 15)
                        .add(Aspect.getAspect("sano"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("mortuus"), 6).add(Aspect.getAspect("exanimis"), 3),
                -2,
                -9,
                3,
                getModItem("TConstruct", "heartCanister", 1, 4, missing)).setParents("YELLOWHEART").setConcealed()
                        .setPages(new ResearchPage("TConstruct.research_page.YELLOWHEARTCANISTER.1"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "YELLOWHEARTCANISTER",
                getModItem("TConstruct", "heartCanister", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                        .add(Aspect.getAspect("ignis"), 100).add(Aspect.getAspect("terra"), 100)
                        .add(Aspect.getAspect("ordo"), 100).add(Aspect.getAspect("perditio"), 100),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("TConstruct", "materials", 1, 8, missing),
                'b',
                getModItem("TConstruct", "heartCanister", 1, 0, missing),
                'c',
                getModItem("TConstruct", "materials", 1, 8, missing),
                'd',
                getModItem("minecraft", "golden_apple", 1, 1, missing),
                'e',
                getModItem("TConstruct", "heartCanister", 1, 3, missing),
                'f',
                getModItem("minecraft", "golden_apple", 1, 1, missing));
        TCHelper.addResearchPage(
                "YELLOWHEARTCANISTER",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("TConstruct", "heartCanister", 1, 4, missing))));
        ThaumcraftApi.addWarpToResearch("YELLOWHEARTCANISTER", 3);
        new ResearchItem(
                "GREENHEART",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("infernus"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("spiritus"), 9)
                        .add(Aspect.getAspect("fames"), 6).add(Aspect.getAspect("corpus"), 3),
                -4,
                -7,
                3,
                getModItem("TConstruct", "heartCanister", 1, 5, missing)).setParents("YELLOWHEART").setConcealed()
                        .setRound().setPages(new ResearchPage("TConstruct.research_page.GREENHEART.1"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "GREENHEART",
                getModItem("TConstruct", "heartCanister", 1, 5, missing),
                3,
                new AspectList().add(Aspect.getAspect("exanimis"), 100).add(Aspect.getAspect("ignis"), 150)
                        .add(Aspect.getAspect("lucrum"), 150).add(Aspect.getAspect("sano"), 200)
                        .add(Aspect.getAspect("praecantatio"), 200),
                getModItem("TConstruct", "diamondApple", 1, 0, missing),
                new ItemStack[] { getModItem("TConstruct", "heartCanister", 1, 3, missing),
                        getModItem("TConstruct", "materials", 1, 8, missing),
                        getModItem("TConstruct", "heartCanister", 1, 3, missing),
                        getModItem("TConstruct", "materials", 1, 8, missing),
                        getModItem("TConstruct", "heartCanister", 1, 3, missing),
                        getModItem("TConstruct", "materials", 1, 8, missing),
                        getModItem("TConstruct", "heartCanister", 1, 3, missing),
                        getModItem("TConstruct", "materials", 1, 8, missing),
                        getModItem("TConstruct", "heartCanister", 1, 3, missing),
                        getModItem("TConstruct", "materials", 1, 8, missing), });
        TCHelper.addResearchPage(
                "GREENHEART",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("TConstruct", "heartCanister", 1, 5, missing))));
        ThaumcraftApi.addWarpToResearch("GREENHEART", 3);
        new ResearchItem(
                "GREENHEARTCANISTER",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("infernus"), 15).add(Aspect.getAspect("metallum"), 15)
                        .add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("sano"), 12)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("spiritus"), 9)
                        .add(Aspect.getAspect("fames"), 6).add(Aspect.getAspect("corpus"), 3),
                -4,
                -9,
                3,
                getModItem("TConstruct", "heartCanister", 1, 6, missing))
                        .setParents("GREENHEART").setConcealed()
                        .setPages(
                                new ResearchPage("TConstruct.research_page.GREENHEARTCANISTER.1"),
                                new ResearchPage("TConstruct.research_page.GREENHEARTCANISTER.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GREENHEARTCANISTER",
                getModItem("TConstruct", "heartCanister", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("aer"), 200).add(Aspect.getAspect("aqua"), 200)
                        .add(Aspect.getAspect("ignis"), 200).add(Aspect.getAspect("terra"), 200)
                        .add(Aspect.getAspect("ordo"), 200).add(Aspect.getAspect("perditio"), 200),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("TConstruct", "materials", 1, 8, missing),
                'b',
                getModItem("TConstruct", "heartCanister", 1, 0, missing),
                'c',
                getModItem("TConstruct", "materials", 1, 8, missing),
                'd',
                getModItem("TConstruct", "diamondApple", 1, 0, missing),
                'e',
                getModItem("TConstruct", "heartCanister", 1, 5, missing),
                'f',
                getModItem("TConstruct", "diamondApple", 1, 0, missing),
                'g',
                getModItem("TConstruct", "materials", 1, 8, missing),
                'h',
                getModItem("TConstruct", "diamondApple", 1, 0, missing),
                'i',
                getModItem("TConstruct", "materials", 1, 8, missing));
        TCHelper.addResearchPage(
                "GREENHEARTCANISTER",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("TConstruct", "heartCanister", 1, 6, missing))));
        ThaumcraftApi.addWarpToResearch("GREENHEARTCANISTER", 4);
        new ResearchItem(
                "ENDERCHEST",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("electrum"), 15)
                        .add(Aspect.getAspect("machina"), 12).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("fabrico"), 3),
                -4,
                0,
                3,
                getModItem("EnderStorage", "enderChest", 1, 0, missing)).setParents("INFUSION").setConcealed()
                        .setPages(new ResearchPage("EnderStorage.research_page.ENDERCHEST")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENDERCHEST",
                getModItem("EnderStorage", "enderChest", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                        .add(Aspect.getAspect("ignis"), 100).add(Aspect.getAspect("terra"), 100),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 17506, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 22321, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 17506, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32694, missing),
                'e',
                getModItem("IronChest", "BlockIronChest", 1, 6, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32684, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 17506, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 22321, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 17506, missing));
        TCHelper.addResearchPage(
                "ENDERCHEST",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("EnderStorage", "enderChest", 1, 0, missing))));
        new ResearchItem(
                "ENDERTANK",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("electrum"), 15)
                        .add(Aspect.getAspect("machina"), 12).add(Aspect.getAspect("ignis"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("sensus"), 3),
                -4,
                2,
                3,
                getModItem("EnderStorage", "enderChest", 1, 4096, missing)).setParents("ENDERCHEST").setConcealed()
                        .setPages(new ResearchPage("EnderStorage.research_page.ENDERTANK")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENDERTANK",
                getModItem("EnderStorage", "enderChest", 1, 4096, missing),
                new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                        .add(Aspect.getAspect("ignis"), 100).add(Aspect.getAspect("terra"), 100)
                        .add(Aspect.getAspect("ordo"), 100),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.02", 1, 22801, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 22321, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.02", 1, 22801, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32694, missing),
                'e',
                getModItem("irontank", "obsidianTank", 1, 0, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32684, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.02", 1, 22801, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 22321, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.02", 1, 22801, missing));
        TCHelper.addResearchPage(
                "ENDERTANK",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("EnderStorage", "enderChest", 1, 4096, missing))));
        new ResearchItem(
                "ENDERPOUCHE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("lucrum"), 15).add(Aspect.getAspect("vitreus"), 15)
                        .add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("electrum"), 9)
                        .add(Aspect.getAspect("machina"), 6).add(Aspect.getAspect("alienis"), 3),
                -4,
                4,
                3,
                getModItem("EnderStorage", "enderPouch", 1, 0, missing)).setParents("ENDERTANK").setConcealed()
                        .setPages(new ResearchPage("EnderStorage.research_page.ENDERPOUCHE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENDERPOUCHE",
                getModItem("EnderStorage", "enderPouch", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                        .add(Aspect.getAspect("ignis"), 100).add(Aspect.getAspect("terra"), 100)
                        .add(Aspect.getAspect("ordo"), 100).add(Aspect.getAspect("perditio"), 100),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.02", 1, 30500, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 22321, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.02", 1, 30500, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 32694, missing),
                'e',
                getModItem("Backpack", "backpack", 1, 200, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32684, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.02", 1, 30500, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 22321, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.02", 1, 30500, missing));
        TCHelper.addResearchPage(
                "ENDERPOUCHE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("EnderStorage", "enderPouch", 1, 0, missing))));
        new ResearchItem(
                "AUTOENCHANTINGTABLE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("potentia"), 6),
                0,
                2,
                3,
                getModItem("OpenBlocks", "autoenchantmenttable", 1, 0, missing)).setParents("ENCHANTINGTABLE")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("OpenBlocks.research_page.AUTOENCHANTINGTABLE.1"),
                                new ResearchPage("OpenBlocks.research_page.AUTOENCHANTINGTABLE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "AUTOENCHANTINGTABLE",
                getModItem("OpenBlocks", "autoenchantmenttable", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                'b',
                getModItem("minecraft", "book", 1, 0, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 17526, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 27019, missing),
                'e',
                getModItem("minecraft", "enchanting_table", 1, 0, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 27019, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing),
                'h',
                getModItem("minecraft", "redstone_block", 1, 0, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 17308, missing));
        TCHelper.addResearchPage(
                "AUTOENCHANTINGTABLE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("OpenBlocks", "autoenchantmenttable", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("AUTOENCHANTINGTABLE", 1);
        new ResearchItem(
                "LUGGAGE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("sensus"), 15)
                        .add(Aspect.getAspect("iter"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("fabrico"), 6).add(Aspect.getAspect("lucrum"), 3),
                -2,
                0,
                3,
                getModItem("OpenBlocks", "luggage", 1, 0, missing))
                        .setParents("ENDERCHEST").setConcealed()
                        .setPages(
                                new ResearchPage("OpenBlocks.research_page.LUGGAGE.1"),
                                new ResearchPage("OpenBlocks.research_page.LUGGAGE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "LUGGAGE",
                getModItem("OpenBlocks", "luggage", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("perditio"), 75).add(Aspect.getAspect("ordo"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 27019, missing),
                'b',
                getModItem("Thaumcraft", "ItemGolemCore", 1, 0, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 27019, missing),
                'd',
                getModItem("Automagy", "crystalBrain", 1, 3, missing),
                'e',
                getModItem("Thaumcraft", "blockChestHungry", 1, 0, missing),
                'f',
                getModItem("Automagy", "crystalBrain", 1, 3, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 27019, missing),
                'h',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 2, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 27019, missing));
        TCHelper.addResearchPage(
                "LUGGAGE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("OpenBlocks", "luggage", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("LUGGAGE", 1);
        new ResearchItem(
                "GHOSTAMULET",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("potentia"), 21).add(Aspect.getAspect("auram"), 18)
                        .add(Aspect.getAspect("infernus"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("spiritus"), 9)
                        .add(Aspect.getAspect("alienis"), 6).add(Aspect.getAspect("corpus"), 3),
                4,
                2,
                3,
                getModItem("HardcoreEnderExpansion", "ghost_amulet", 1, 1, missing))
                        .setParents("ENCHANTINGTABLE", "BREWINGSTAND").setConcealed().setRound()
                        .setPages(new ResearchPage("Hee.research_page.GHOSTAMULET.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "GHOSTAMULET",
                getModItem("HardcoreEnderExpansion", "ghost_amulet", 1, 1, missing),
                9,
                new AspectList().add(Aspect.getAspect("auram"), 64).add(Aspect.getAspect("potentia"), 64)
                        .add(Aspect.getAspect("vitium"), 32).add(Aspect.getAspect("vitreus"), 48)
                        .add(Aspect.getAspect("spiritus"), 32).add(Aspect.getAspect("corpus"), 16)
                        .add(Aspect.getAspect("alienis"), 24).add(Aspect.getAspect("lucrum"), 8),
                getModItem("HardcoreEnderExpansion", "ghost_amulet", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 11975, missing),
                        getModItem("HardcoreEnderExpansion", "instability_orb", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28770, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "fire_shard", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "igneous_rock", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 11975, missing),
                        getModItem("HardcoreEnderExpansion", "instability_orb", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28770, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "igneous_rock", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "fire_shard", 1, 0, missing),
                        getModItem("HardcoreEnderExpansion", "end_powder", 1, 0, missing), });
        TCHelper.addResearchPage(
                "GHOSTAMULET",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem("HardcoreEnderExpansion", "ghost_amulet", 1, 1, missing))));
        ThaumcraftApi.addWarpToResearch("GHOSTAMULET", 3);
        new ResearchItem(
                "SFSWORD",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("auram"), 8).add(Aspect.getAspect("corpus"), 8)
                        .add(Aspect.getAspect("exanimis"), 8).add(Aspect.getAspect("metallum"), 8)
                        .add(Aspect.getAspect("mortuus"), 8),
                4,
                4,
                3,
                getModItem("Avaritia", "Skull_Sword", 1, 0, missing)).setParents("INFUSION").setConcealed().setRound()
                        .setPages(new ResearchPage("Avaritia.research_page.SFSWORD.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SFSWORD",
                getModItem("Avaritia", "Skull_Sword", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("auram"), 64).add(Aspect.getAspect("corpus"), 64)
                        .add(Aspect.getAspect("exanimis"), 64).add(Aspect.getAspect("metallum"), 64)
                        .add(Aspect.getAspect("mortuus"), 64),
                getModItem("TwilightForest", "item.fierySword", 1, 0, missing),
                new ItemStack[] { getModItem("minecraft", "blaze_rod", 1, 0, missing),
                        getModItem("minecraft", "blaze_powder", 1, 0, missing),
                        getModItem("Avaritia", "Resource", 1, 0, missing),
                        getModItem("dreamcraft", "item.LichBone", 1, 0, missing),
                        getModItem("Avaritia", "Resource", 1, 0, missing),
                        getModItem("TConstruct", "materials", 1, 8, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 11054, missing),
                        getModItem("TConstruct", "materials", 1, 8, missing),
                        getModItem("Avaritia", "Resource", 1, 0, missing),
                        getModItem("dreamcraft", "item.LichBone", 1, 0, missing),
                        getModItem("Avaritia", "Resource", 1, 0, missing),
                        getModItem("minecraft", "blaze_powder", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SFSWORD",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("Avaritia", "Skull_Sword", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SFSWORD", 1);
        new ResearchItem(
                "MAGICOBSIDIAN",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("terra"), 8),
                2,
                4,
                2,
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 0, missing)).setParents("INFUSION").setConcealed()
                        .setPages(new ResearchPage("Thaum.research_page.MAGICOBSIDIAN")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MAGICOBSIDIAN",
                getModItem("Thaumcraft", "blockCosmeticSolid", 4, 1, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 4).add(Aspect.getAspect("terra"), 4),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("minecraft", "obsidian", 1, 0, missing),
                'b',
                getModItem("minecraft", "obsidian", 1, 0, missing),
                'd',
                getModItem("minecraft", "obsidian", 1, 0, missing),
                'e',
                getModItem("minecraft", "obsidian", 1, 0, missing));
        TCHelper.addResearchPage(
                "MAGICOBSIDIAN",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "MAGICOBSIDIAN",
                getModItem("Thaumcraft", "blockCosmeticSolid", 4, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("tenebrae"), 16)
                        .add(Aspect.getAspect("terra"), 16),
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing),
                new ItemStack[] { getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing), });
        TCHelper.addResearchPage(
                "MAGICOBSIDIAN",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("Thaumcraft", "blockCosmeticSolid", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("MAGICOBSIDIAN", 1);
    }
}
