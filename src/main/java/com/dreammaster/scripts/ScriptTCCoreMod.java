package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static gregtech.api.enums.Mods.Automagy;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.EnderStorage;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.ForgeMicroblocks;
import static gregtech.api.enums.Mods.HardcoreEnderExpansion;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.IronChests;
import static gregtech.api.enums.Mods.IronTanks;
import static gregtech.api.enums.Mods.MagicBees;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.OpenBlocks;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.ProjectRedIllumination;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TwilightForest;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.STACKS;
import static gregtech.api.util.GTRecipeConstants.DEFC_CASING_TIER;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.electrolyzerNonCellRecipes;
import static kubatech.loaders.DEFCRecipes.fusionCraftingRecipes;
import static thaumcraft.api.aspects.Aspect.getAspect;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.item.NHItemList;
import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.core.material.MaterialsElements;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptTCCoreMod implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Thaumcraft Core Mod";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Automagy.ID,
                Avaritia.ID,
                Backpack.ID,
                BiomesOPlenty.ID,
                DraconicEvolution.ID,
                EnderStorage.ID,
                EternalSingularity.ID,
                ExtraUtilities.ID,
                ForgeMicroblocks.ID,
                HardcoreEnderExpansion.ID,
                IndustrialCraft2.ID,
                IronChests.ID,
                IronTanks.ID,
                MagicBees.ID,
                OpenBlocks.ID,
                PamsHarvestCraft.ID,
                ProjectRedIllumination.ID,
                Thaumcraft.ID,
                ThaumicTinkerer.ID,
                TinkerConstruct.ID,
                TwilightForest.ID);
    }

    @Override
    public void loadRecipes() {
        new ResearchItem(
                "WITHERRING",
                "ARTIFICE",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("superbia"), 9).add(Aspect.getAspect("spiritus"), 6)
                        .add(Aspect.getAspect("infernus"), 3),
                3,
                2,
                3,
                NHItemList.WitherProtectionRing.get()).setParents("RUNICARMOR").setSiblings("RUNICARMOR").setConcealed()
                        .setPages(new ResearchPage("NewHorizons.research_page.WITHERRING")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "WITHERRING",
                NHItemList.WitherProtectionRing.get(),
                3,
                new AspectList().add(Aspect.getAspect("alienis"), 45).add(Aspect.getAspect("praecantatio"), 35)
                        .add(Aspect.getAspect("spiritus"), 30).add(Aspect.getAspect("superbia"), 25)
                        .add(Aspect.getAspect("infernus"), 15),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 1),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                getModItem(Minecraft.ID, "milk_bucket", 1, 0),
                getModItem(Minecraft.ID, "skull", 1, 1),
                getModItem(Minecraft.ID, "milk_bucket", 1, 0),
                getModItem(Minecraft.ID, "skull", 1, 1));
        TCHelper.addResearchPage(
                "WITHERRING",
                new ResearchPage(TCHelper.findInfusionRecipe(NHItemList.WitherProtectionRing.get())));
        ThaumcraftApi.addWarpToResearch("WITHERRING", 2);
        new ResearchItem(
                "EMINENCESTONE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("sensus"), 12)
                        .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("aer"), 6),
                0,
                4,
                3,
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 14)).setParents("INFUSION")
                        .setPages(new ResearchPage("ExtraUtilities.research_page.EMINENCESTONE"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "EMINENCESTONE",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 2, 14),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("ignis"), 50)
                        .add(Aspect.getAspect("terra"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                'b',
                getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 18),
                'c',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                'd',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1L),
                'e',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                'f',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.EnderPearl, 1L),
                'g',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                'h',
                getModItem(ProjectRedIllumination.ID, "projectred.illumination.lamp", 1, 26),
                'i',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L));
        TCHelper.addResearchPage(
                "EMINENCESTONE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 14))));
        new ResearchItem(
                "PORTALMILLENIUM",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("sensus"), 12)
                        .add(Aspect.getAspect("terra"), 9),
                2,
                6,
                3,
                getModItem(ExtraUtilities.ID, "dark_portal", 1, 2)).setParents("EMINENCESTONE", "OCULUS")
                        .setConcealed().setPages(new ResearchPage("ExtraUtilities.research_page.PORTALMILLENIUM"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "PORTALMILLENIUM",
                getModItem(ExtraUtilities.ID, "dark_portal", 1, 2),
                4,
                new AspectList().add(Aspect.getAspect("alienis"), 75).add(Aspect.getAspect("sensus"), 25)
                        .add(Aspect.getAspect("praecantatio"), 75).add(Aspect.getAspect("terra"), 25)
                        .add(Aspect.getAspect("vacuos"), 75),
                getModItem(Minecraft.ID, "clock", 1, 0),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 14),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 2),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 14),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 2),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 14),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 2),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 14),
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 2));
        TCHelper.addResearchPage(
                "PORTALMILLENIUM",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ExtraUtilities.ID, "dark_portal", 1, 2))));
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
                getModItem(ExtraUtilities.ID, "dark_portal", 1, 0)).setParents("PORTALMILLENIUM", "ICHOR")
                        .setConcealed().setPages(new ResearchPage("ExtraUtilities.research_page.PORTALDEEPDARK"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "PORTALDEEPDARK",
                getModItem(ExtraUtilities.ID, "dark_portal", 1, 0),
                32,
                new AspectList().add(Aspect.getAspect("vacuos"), 512).add(Aspect.getAspect("tempus"), 512)
                        .add(Aspect.getAspect("luxuria"), 512).add(Aspect.getAspect("alienis"), 512)
                        .add(Aspect.getAspect("terminus"), 512).add(Aspect.getAspect("gula"), 512)
                        .add(Aspect.getAspect("superbia"), 512),
                ItemList.Block_BedrockiumCompressed.get(1L),
                ItemList.Field_Generator_UIV.get(1L),
                getModItem(EternalSingularity.ID, "eternal_singularity", 1, 0),
                ItemList.Field_Generator_UIV.get(1L),
                getModItem(EternalSingularity.ID, "eternal_singularity", 1, 0),
                ItemList.Field_Generator_UIV.get(1L),
                getModItem(EternalSingularity.ID, "eternal_singularity", 1, 0),
                ItemList.Field_Generator_UIV.get(1L),
                getModItem(EternalSingularity.ID, "eternal_singularity", 1, 0));
        TCHelper.addResearchPage(
                "PORTALDEEPDARK",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ExtraUtilities.ID, "dark_portal", 1, 0))));
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
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8)).setParents("EMINENCESTONE")
                        .setConcealed().setPages(new ResearchPage("ExtraUtilities.research_page.MAGICALWOOD"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MAGICALWOOD",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 4, 8),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("terra"), 10).add(Aspect.getAspect("aqua"), 10)
                        .add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1),
                'b',
                getModItem(TwilightForest.ID, "item.carminite", 1, 0),
                'c',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                'd',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                'e',
                getModItem(Minecraft.ID, "bookshelf", 1, 0),
                'f',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                'g',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 0),
                'h',
                getModItem(TwilightForest.ID, "item.carminite", 1, 0),
                'i',
                getModItem(Thaumcraft.ID, "blockMagicalLog", 1, 1));
        TCHelper.addResearchPage(
                "MAGICALWOOD",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8))));
        new ResearchItem(
                "ANGELBLOCK",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("ignis"), 9).add(Aspect.getAspect("terra"), 6),
                -2,
                8,
                3,
                getModItem(ExtraUtilities.ID, "angelBlock", 1, 0)).setParents("MAGICALWOOD").setConcealed()
                        .setPages(new ResearchPage("ExtraUtilities.research_page.ANGELBLOCK")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ANGELBLOCK",
                getModItem(ExtraUtilities.ID, "angelBlock", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedAir, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.RoseGold, 1L),
                'c',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedAir, 1L),
                'd',
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7),
                'e',
                getModItem(Automagy.ID, "blockRunedObsidian", 1, 0),
                'f',
                getModItem(IndustrialCraft2.ID, "itemDensePlates", 1, 7),
                'g',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedAir, 1L),
                'h',
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.RoseGold, 1L),
                'i',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedAir, 1L));
        TCHelper.addResearchPage(
                "ANGELBLOCK",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ExtraUtilities.ID, "angelBlock", 1, 0))));
        new ResearchItem(
                "DEZILSMARSHMALLOW",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("superbia"), 9).add(Aspect.getAspect("sano"), 6)
                        .add(Aspect.getAspect("potentia"), 3),
                -2,
                2,
                3,
                getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0)).setParents("INFUSION")
                        .setSpecial().setPages(new ResearchPage("de.research_page.DEZILSMARSHMALLOW"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "DEZILSMARSHMALLOW",
                getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0),
                5,
                new AspectList().add(Aspect.getAspect("alienis"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("superbia"), 24).add(Aspect.getAspect("sano"), 28)
                        .add(Aspect.getAspect("iter"), 20).add(Aspect.getAspect("potentia"), 12),
                NHItemList.Marshmallow.get(),
                getModItem(PamsHarvestCraft.ID, "epicbaconItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "deluxechickencurryItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "meatfeastpizzaItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "beefwellingtonItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "sausageinbreadItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "heartybreakfastItem", 1, 0));
        TCHelper.addResearchPage(
                "DEZILSMARSHMALLOW",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0))));
        ThaumcraftApi.addWarpToResearch("DEZILSMARSHMALLOW", 8);
        new ResearchItem(
                "ENCHANTINGTABLE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("potentia"), 6),
                0,
                0,
                3,
                getModItem(Minecraft.ID, "enchanting_table", 1, 0)).setParents("NITOR", "ALUMENTUM")
                        .setPages(new ResearchPage("Minecraft.research_page.ENCHANTINGTABLE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENCHANTINGTABLE",
                getModItem(Minecraft.ID, "enchanting_table", 1, 0),
                new AspectList().add(getAspect("aer"), 45).add(getAspect("aqua"), 45)
                        .add(getAspect("terra"), 45).add(getAspect("ignis"), 45)
                        .add(getAspect("ordo"), 45).add(getAspect("perditio"), 45),
                "abc",
                "def",
                "ghi",
                'a',
                createItemStack(ForgeMicroblocks.ID, "microblock", 1, 516, "{mat:\"minecraft:diamond_block\"}"),
                'b',
                getModItem(Minecraft.ID, "carpet", 1, 14),
                'c',
                createItemStack(ForgeMicroblocks.ID, "microblock", 1, 516, "{mat:\"minecraft:diamond_block\"}"),
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                'e',
                getModItem(Minecraft.ID, "bookshelf", 1, 0),
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                'g',
                createItemStack(ForgeMicroblocks.ID, "microblock", 1, 516, "{mat:\"minecraft:diamond_block\"}"),
                'h',
                "plateDenseObsidian",
                'i',
                createItemStack(ForgeMicroblocks.ID, "microblock", 1, 516, "{mat:\"minecraft:diamond_block\"}"));
        TCHelper.addResearchPage(
                "ENCHANTINGTABLE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(Minecraft.ID, "enchanting_table", 1, 0))));
        new ResearchItem(
                "DISENCHANTINGTABLE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("alienis"), 21).add(Aspect.getAspect("perditio"), 18)
                        .add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("potentia"), 6),
                2,
                2,
                3,
                getModItem(DraconicEvolution.ID, "dissEnchanter", 1, 0)).setParents("ENCHANTINGTABLE")
                        .setConcealed().setPages(new ResearchPage("DraconicEvolution.research_page.DISENCHANTINGTABLE"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DISENCHANTINGTABLE",
                getModItem(DraconicEvolution.ID, "dissEnchanter", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("terra"), 75).add(Aspect.getAspect("ignis"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                "blockAmethyst",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'c',
                "blockAmethyst",
                'd',
                getModItem(Minecraft.ID, "enchanted_book", 1, 0),
                'e',
                getModItem(Minecraft.ID, "enchanting_table", 1, 0),
                'f',
                getModItem(Minecraft.ID, "enchanted_book", 1, 0),
                'g',
                "blockThaumium",
                'h',
                "plateDenseObsidian",
                'i',
                "blockThaumium");
        TCHelper.addResearchPage(
                "DISENCHANTINGTABLE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(DraconicEvolution.ID, "dissEnchanter", 1, 0))));
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
                getModItem(Minecraft.ID, "brewing_stand", 1, 0))
                        .setPages(
                                new ResearchPage("Minecraft.research_page.BREWINGSTAND.1"),
                                new ResearchPage("Minecraft.research_page.BREWINGSTAND.2"),
                                new ResearchPage("Minecraft.research_page.BREWINGSTAND.3"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BREWINGSTAND",
                getModItem(Minecraft.ID, "brewing_stand", 1, 0),
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
                getModItem(Minecraft.ID, "cauldron", 1, 0),
                'i',
                "screwAluminium");
        TCHelper.addResearchPage(
                "BREWINGSTAND",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Minecraft.ID, "brewing_stand", 1, 0))));
        new ResearchItem(
                "BEACON",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("fames"), 6),
                4,
                0,
                3,
                getModItem(Minecraft.ID, "beacon", 1, 0)).setParents("INFUSION")
                        .setPages(new ResearchPage("Minecraft.research_page.BEACON")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "BEACON",
                getModItem(Minecraft.ID, "beacon", 1, 0),
                6,
                new AspectList().add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("alienis"), 64)
                        .add(Aspect.getAspect("lux"), 64).add(Aspect.getAspect("ordo"), 64)
                        .add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("terra"), 64),
                getModItem(Minecraft.ID, "diamond_block", 1, 0),
                getModItem(Minecraft.ID, "glass", 1, 0),
                OrePrefixes.plate.get(Materials.Obsidian),
                OrePrefixes.lens.get(Materials.NetherStar),
                getModItem(Minecraft.ID, "glass", 1, 0),
                OrePrefixes.plate.get(Materials.Obsidian),
                OrePrefixes.lens.get(Materials.NetherStar),
                getModItem(Minecraft.ID, "glass", 1, 0),
                OrePrefixes.plate.get(Materials.Obsidian),
                OrePrefixes.lens.get(Materials.NetherStar),
                getModItem(Minecraft.ID, "glass", 1, 0),
                OrePrefixes.plate.get(Materials.Obsidian),
                OrePrefixes.lens.get(Materials.NetherStar));
        TCHelper.addResearchPage(
                "BEACON",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Minecraft.ID, "beacon", 1, 0))));
        ThaumcraftApi.addWarpToResearch("BEACON", 2);
        new ResearchItem(
                "DRAGONEGG",
                "MAGICBEES",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("victus"), 9).add(Aspect.getAspect("bestia"), 6),
                2,
                5,
                3,
                getModItem(Minecraft.ID, "dragon_egg", 1, 0)).setParents("MB_DimensionalSingularity")
                        .setSiblings("INFUSION").setConcealed()
                        .setPages(new ResearchPage("Minecraft.research_page.DRAGONEGG")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "DRAGONEGG",
                getModItem(Minecraft.ID, "dragon_egg", 1, 0),
                6,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("bestia"), 56)
                        .add(Aspect.getAspect("praecantatio"), 48).add(Aspect.getAspect("victus"), 48),
                getModItem(MagicBees.ID, "miscResources", 1, 7),
                getModItem(MagicBees.ID, "miscResources", 1, 6),
                getModItem(MagicBees.ID, "miscResources", 1, 6),
                getModItem(MagicBees.ID, "miscResources", 1, 6),
                getModItem(MagicBees.ID, "miscResources", 1, 6),
                getModItem(MagicBees.ID, "miscResources", 1, 6),
                getModItem(MagicBees.ID, "miscResources", 1, 6),
                getModItem(MagicBees.ID, "miscResources", 1, 6),
                getModItem(MagicBees.ID, "miscResources", 1, 6));
        TCHelper.addResearchPage(
                "DRAGONEGG",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Minecraft.ID, "dragon_egg", 1, 0))));
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
                getModItem(TinkerConstruct.ID, "materials", 1, 26)).setParents("ENCHANTINGTABLE")
                        .setConcealed().setRound().setPages(new ResearchPage("TConstruct.research_page.SILKYCRYSTAL"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SILKYCRYSTAL",
                getModItem(TinkerConstruct.ID, "materials", 1, 25),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("aqua"), 25)
                        .add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "string", 1, 0),
                'b',
                "foilGold",
                'c',
                getModItem(Minecraft.ID, "string", 1, 0),
                'd',
                "foilGold",
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'f',
                "foilGold",
                'g',
                getModItem(Minecraft.ID, "string", 1, 0),
                'h',
                "foilGold",
                'i',
                getModItem(Minecraft.ID, "string", 1, 0));
        TCHelper.addResearchPage(
                "SILKYCRYSTAL",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 25))));
        TCHelper.addInfusionCraftingRecipe(
                "SILKYCRYSTAL",
                getModItem(TinkerConstruct.ID, "materials", 1, 26),
                4,
                new AspectList().add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("ordo"), 35).add(Aspect.getAspect("praecantatio"), 35)
                        .add(Aspect.getAspect("vitreus"), 20),
                OrePrefixes.gemFlawless.get(Materials.Diamond),
                getModItem(TinkerConstruct.ID, "materials", 1, 25),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 25),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 3),
                getModItem(TinkerConstruct.ID, "materials", 1, 25),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 4));
        TCHelper.addResearchPage(
                "SILKYCRYSTAL",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 26))));
        new ResearchItem(
                "LAVACRYSTAL",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("vacuos"), 9).add(Aspect.getAspect("perditio"), 6),
                2,
                -2,
                3,
                getModItem(TinkerConstruct.ID, "materials", 1, 7)).setParents("ENCHANTINGTABLE").setConcealed()
                        .setRound().setPages(new ResearchPage("TConstruct.research_page.LAVACRYSTAL"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "LAVACRYSTAL",
                getModItem(TinkerConstruct.ID, "materials", 1, 7),
                3,
                new AspectList().add(Aspect.getAspect("ignis"), 25).add(Aspect.getAspect("perditio"), 25)
                        .add(Aspect.getAspect("vacuos"), 20).add(Aspect.getAspect("praecantatio"), 35),
                getModItem(Minecraft.ID, "fire_charge", 1, 0),
                getModItem(Minecraft.ID, "blaze_rod", 1, 0),
                getModItem(Minecraft.ID, "lava_bucket", 1, 0),
                getModItem(Minecraft.ID, "fire_charge", 1, 0),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 1),
                getModItem(Minecraft.ID, "blaze_rod", 1, 0),
                getModItem(Minecraft.ID, "lava_bucket", 1, 0),
                getModItem(Minecraft.ID, "fire_charge", 1, 0),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 1));
        TCHelper.addResearchPage(
                "LAVACRYSTAL",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 7))));
        new ResearchItem(
                "BALLOFMOSS",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("sano"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9),
                0,
                -4,
                3,
                getModItem(TinkerConstruct.ID, "materials", 1, 6)).setParents("SILKYCRYSTAL", "LAVACRYSTAL")
                        .setConcealed().setRound().setPages(new ResearchPage("TConstruct.research_page.BALLOFMOSS"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "BALLOFMOSS",
                getModItem(TinkerConstruct.ID, "materials", 1, 6),
                5,
                new AspectList().add(Aspect.getAspect("sano"), 30).add(Aspect.getAspect("terra"), 25)
                        .add(Aspect.getAspect("instrumentum"), 35),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                OrePrefixes.dust.get(Materials.InfusedEarth),
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 3),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                OrePrefixes.dust.get(Materials.InfusedEarth),
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 3),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0));
        TCHelper.addResearchPage(
                "BALLOFMOSS",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 6))));
        new ResearchItem(
                "NECROTICBONE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("exanimis"), 15).add(Aspect.getAspect("mortuus"), 12)
                        .add(Aspect.getAspect("spiritus"), 9).add(Aspect.getAspect("venenum"), 6),
                0,
                -2,
                3,
                getModItem(TinkerConstruct.ID, "materials", 1, 8))
                        .setParents("ENTROPICPROCESSING", "BALLOFMOSS", "SILKYCRYSTAL", "LAVACRYSTAL").setConcealed()
                        .setRound().setPages(new ResearchPage("TConstruct.research_page.NECROTICBONE"))
                        .registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "NECROTICBONE",
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                getModItem(Minecraft.ID, "bone", 1, 0),
                new AspectList().add(Aspect.getAspect("exanimis"), 20).add(Aspect.getAspect("mortuus"), 30)
                        .add(Aspect.getAspect("infernus"), 20).add(Aspect.getAspect("spiritus"), 20)
                        .add(Aspect.getAspect("venenum"), 20).add(Aspect.getAspect("corpus"), 5));
        TCHelper.addResearchPage(
                "NECROTICBONE",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 8))));
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
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 1))
                        .setParents("RUNICAUGMENTATION", "BALLOFMOSS").setConcealed().setRound()
                        .setPages(new ResearchPage("TConstruct.research_page.REDHEART.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "REDHEART",
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 1),
                3,
                new AspectList().add(Aspect.getAspect("exanimis"), 25).add(Aspect.getAspect("ignis"), 35)
                        .add(Aspect.getAspect("lucrum"), 35).add(Aspect.getAspect("sano"), 50)
                        .add(Aspect.getAspect("praecantatio"), 50),
                getModItem(Minecraft.ID, "golden_apple", 1, 0),
                getModItem(TinkerConstruct.ID, "jerky", 1, 6),
                getModItem(Minecraft.ID, "apple", 1, 0),
                getModItem(TinkerConstruct.ID, "jerky", 1, 7),
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                getModItem(TinkerConstruct.ID, "jerky", 1, 0),
                getModItem(TinkerConstruct.ID, "jerky", 1, 1),
                getModItem(TinkerConstruct.ID, "jerky", 1, 2),
                getModItem(TinkerConstruct.ID, "jerky", 1, 3),
                getModItem(TinkerConstruct.ID, "jerky", 1, 4),
                getModItem(TinkerConstruct.ID, "jerky", 1, 5));
        TCHelper.addResearchPage(
                "REDHEART",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TinkerConstruct.ID, "heartCanister", 1, 1))));
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
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 2)).setParents("REDHEART").setConcealed()
                        .setPages(new ResearchPage("TConstruct.research_page.REDHEARTCANISTER.1"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REDHEARTCANISTER",
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 2),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                'b',
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 0),
                'd',
                getModItem(Minecraft.ID, "golden_apple", 1, 0),
                'e',
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 1));
        TCHelper.addResearchPage(
                "REDHEARTCANISTER",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(TinkerConstruct.ID, "heartCanister", 1, 2))));
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
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 3)).setParents("REDHEART").setConcealed()
                        .setRound().setPages(new ResearchPage("TConstruct.research_page.YELLOWHEART.1"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "YELLOWHEART",
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 3),
                3,
                new AspectList().add(Aspect.getAspect("exanimis"), 50).add(Aspect.getAspect("ignis"), 75)
                        .add(Aspect.getAspect("lucrum"), 75).add(Aspect.getAspect("sano"), 100)
                        .add(Aspect.getAspect("praecantatio"), 100),
                getModItem(Minecraft.ID, "golden_apple", 1, 1),
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 1),
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 1),
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 1),
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 1),
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 1),
                getModItem(TinkerConstruct.ID, "materials", 1, 8));
        TCHelper.addResearchPage(
                "YELLOWHEART",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TinkerConstruct.ID, "heartCanister", 1, 3))));
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
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 4)).setParents("YELLOWHEART").setConcealed()
                        .setPages(new ResearchPage("TConstruct.research_page.YELLOWHEARTCANISTER.1"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "YELLOWHEARTCANISTER",
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 4),
                new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                        .add(Aspect.getAspect("ignis"), 100).add(Aspect.getAspect("terra"), 100)
                        .add(Aspect.getAspect("ordo"), 100).add(Aspect.getAspect("perditio"), 100),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                'b',
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 0),
                'c',
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                'd',
                getModItem(Minecraft.ID, "golden_apple", 1, 1),
                'e',
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 3),
                'f',
                getModItem(Minecraft.ID, "golden_apple", 1, 1));
        TCHelper.addResearchPage(
                "YELLOWHEARTCANISTER",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(TinkerConstruct.ID, "heartCanister", 1, 4))));
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
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 5)).setParents("YELLOWHEART").setConcealed()
                        .setRound().setPages(new ResearchPage("TConstruct.research_page.GREENHEART.1"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "GREENHEART",
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 5),
                3,
                new AspectList().add(Aspect.getAspect("exanimis"), 100).add(Aspect.getAspect("ignis"), 150)
                        .add(Aspect.getAspect("lucrum"), 150).add(Aspect.getAspect("sano"), 200)
                        .add(Aspect.getAspect("praecantatio"), 200),
                getModItem(TinkerConstruct.ID, "diamondApple", 1, 0),
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 3),
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 3),
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 3),
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 3),
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 3),
                getModItem(TinkerConstruct.ID, "materials", 1, 8));
        TCHelper.addResearchPage(
                "GREENHEART",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TinkerConstruct.ID, "heartCanister", 1, 5))));
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
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 6))
                        .setParents("GREENHEART").setConcealed()
                        .setPages(
                                new ResearchPage("TConstruct.research_page.GREENHEARTCANISTER.1"),
                                new ResearchPage("TConstruct.research_page.GREENHEARTCANISTER.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GREENHEARTCANISTER",
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 6),
                new AspectList().add(Aspect.getAspect("aer"), 200).add(Aspect.getAspect("aqua"), 200)
                        .add(Aspect.getAspect("ignis"), 200).add(Aspect.getAspect("terra"), 200)
                        .add(Aspect.getAspect("ordo"), 200).add(Aspect.getAspect("perditio"), 200),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                'b',
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 0),
                'c',
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                'd',
                getModItem(TinkerConstruct.ID, "diamondApple", 1, 0),
                'e',
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 5),
                'f',
                getModItem(TinkerConstruct.ID, "diamondApple", 1, 0),
                'g',
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                'h',
                getModItem(TinkerConstruct.ID, "diamondApple", 1, 0),
                'i',
                getModItem(TinkerConstruct.ID, "materials", 1, 8));
        TCHelper.addResearchPage(
                "GREENHEARTCANISTER",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(TinkerConstruct.ID, "heartCanister", 1, 6))));
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
                getModItem(EnderStorage.ID, "enderChest", 1, 0)).setParents("INFUSION").setConcealed()
                        .setPages(new ResearchPage("EnderStorage.research_page.ENDERCHEST")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENDERCHEST",
                getModItem(EnderStorage.ID, "enderChest", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                        .add(Aspect.getAspect("ignis"), 100).add(Aspect.getAspect("terra"), 100),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Enderium, 1L),
                'c',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 1L),
                'd',
                ItemList.Sensor_IV.get(1L),
                'e',
                getModItem(IronChests.ID, "BlockIronChest", 1, 6),
                'f',
                ItemList.Emitter_IV.get(1L),
                'g',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 1L),
                'h',
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Enderium, 1L),
                'i',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherStar, 1L));
        TCHelper.addResearchPage(
                "ENDERCHEST",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(EnderStorage.ID, "enderChest", 1, 0))));
        new ResearchItem(
                "ENDERTANK",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("electrum"), 15)
                        .add(Aspect.getAspect("machina"), 12).add(Aspect.getAspect("ignis"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("sensus"), 3),
                -4,
                2,
                3,
                getModItem(EnderStorage.ID, "enderChest", 1, 4096)).setParents("ENDERCHEST").setConcealed()
                        .setPages(new ResearchPage("EnderStorage.research_page.ENDERTANK")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENDERTANK",
                getModItem(EnderStorage.ID, "enderChest", 1, 4096),
                new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                        .add(Aspect.getAspect("ignis"), 100).add(Aspect.getAspect("terra"), 100)
                        .add(Aspect.getAspect("ordo"), 100),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Blaze, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Enderium, 1L),
                'c',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Blaze, 1L),
                'd',
                ItemList.Sensor_IV.get(1L),
                'e',
                getModItem(IronTanks.ID, "obsidianTank", 1, 0),
                'f',
                ItemList.Emitter_IV.get(1L),
                'g',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Blaze, 1L),
                'h',
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Enderium, 1L),
                'i',
                GTOreDictUnificator.get(OrePrefixes.stickLong, Materials.Blaze, 1L));
        TCHelper.addResearchPage(
                "ENDERTANK",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(EnderStorage.ID, "enderChest", 1, 4096))));
        new ResearchItem(
                "ENDERPOUCHE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("lucrum"), 15).add(Aspect.getAspect("vitreus"), 15)
                        .add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("electrum"), 9)
                        .add(Aspect.getAspect("machina"), 6).add(Aspect.getAspect("alienis"), 3),
                -4,
                4,
                3,
                getModItem(EnderStorage.ID, "enderPouch", 1, 0)).setParents("ENDERTANK").setConcealed()
                        .setPages(new ResearchPage("EnderStorage.research_page.ENDERPOUCHE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENDERPOUCHE",
                getModItem(EnderStorage.ID, "enderPouch", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                        .add(Aspect.getAspect("ignis"), 100).add(Aspect.getAspect("terra"), 100)
                        .add(Aspect.getAspect("ordo"), 100).add(Aspect.getAspect("perditio"), 100),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Diamond, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Enderium, 1L),
                'c',
                GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Diamond, 1L),
                'd',
                ItemList.Sensor_IV.get(1L),
                'e',
                getModItem(Backpack.ID, "backpack", 1, 200),
                'f',
                ItemList.Emitter_IV.get(1L),
                'g',
                GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Diamond, 1L),
                'h',
                GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Enderium, 1L),
                'i',
                GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Diamond, 1L));
        TCHelper.addResearchPage(
                "ENDERPOUCHE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(EnderStorage.ID, "enderPouch", 1, 0))));
        new ResearchItem(
                "AUTOENCHANTINGTABLE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("potentia"), 6),
                0,
                2,
                3,
                getModItem(OpenBlocks.ID, "autoenchantmenttable", 1, 0)).setParents("ENCHANTINGTABLE")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("OpenBlocks.research_page.AUTOENCHANTINGTABLE.1"),
                                new ResearchPage("OpenBlocks.research_page.AUTOENCHANTINGTABLE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "AUTOENCHANTINGTABLE",
                getModItem(OpenBlocks.ID, "autoenchantmenttable", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 1L),
                'b',
                getModItem(Minecraft.ID, "book", 1, 0),
                'c',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Lapis, 1L),
                'd',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Aluminium, 1L),
                'e',
                getModItem(Minecraft.ID, "enchanting_table", 1, 0),
                'f',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Aluminium, 1L),
                'g',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L),
                'h',
                getModItem(Minecraft.ID, "redstone_block", 1, 0),
                'i',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.RedAlloy, 1L));
        TCHelper.addResearchPage(
                "AUTOENCHANTINGTABLE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(OpenBlocks.ID, "autoenchantmenttable", 1, 0))));
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
                getModItem(OpenBlocks.ID, "luggage", 1, 0))
                        .setParents("ENDERCHEST").setConcealed()
                        .setPages(
                                new ResearchPage("OpenBlocks.research_page.LUGGAGE.1"),
                                new ResearchPage("OpenBlocks.research_page.LUGGAGE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "LUGGAGE",
                getModItem(OpenBlocks.ID, "luggage", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("perditio"), 75).add(Aspect.getAspect("ordo"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Aluminium, 1L),
                'b',
                getModItem(Thaumcraft.ID, "ItemGolemCore", 1, 0),
                'c',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Aluminium, 1L),
                'd',
                getModItem(Automagy.ID, "crystalBrain", 1, 3),
                'e',
                getModItem(Thaumcraft.ID, "blockChestHungry", 1, 0),
                'f',
                getModItem(Automagy.ID, "crystalBrain", 1, 3),
                'g',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Aluminium, 1L),
                'h',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 2),
                'i',
                GTOreDictUnificator.get(OrePrefixes.screw, Materials.Aluminium, 1L));
        TCHelper.addResearchPage(
                "LUGGAGE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(OpenBlocks.ID, "luggage", 1, 0))));
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
                getModItem(HardcoreEnderExpansion.ID, "ghost_amulet", 1, 1))
                        .setParents("ENCHANTINGTABLE", "BREWINGSTAND").setConcealed().setRound()
                        .setPages(new ResearchPage("Hee.research_page.GHOSTAMULET.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "GHOSTAMULET",
                getModItem(HardcoreEnderExpansion.ID, "ghost_amulet", 1, 1),
                9,
                new AspectList().add(Aspect.getAspect("auram"), 64).add(Aspect.getAspect("potentia"), 64)
                        .add(Aspect.getAspect("vitium"), 32).add(Aspect.getAspect("vitreus"), 48)
                        .add(Aspect.getAspect("spiritus"), 32).add(Aspect.getAspect("corpus"), 16)
                        .add(Aspect.getAspect("alienis"), 24).add(Aspect.getAspect("lucrum"), 8),
                getModItem(HardcoreEnderExpansion.ID, "ghost_amulet", 1, 0),
                OrePrefixes.ingot.get(Materials.Draconium),
                getModItem(HardcoreEnderExpansion.ID, "instability_orb", 1, 0),
                OrePrefixes.ring.get(Materials.Endium),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0),
                getModItem(HardcoreEnderExpansion.ID, "fire_shard", 1, 0),
                getModItem(HardcoreEnderExpansion.ID, "igneous_rock", 1, 0),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0),
                OrePrefixes.ingot.get(Materials.Draconium),
                getModItem(HardcoreEnderExpansion.ID, "instability_orb", 1, 0),
                OrePrefixes.ring.get(Materials.Endium),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0),
                getModItem(HardcoreEnderExpansion.ID, "igneous_rock", 1, 0),
                getModItem(HardcoreEnderExpansion.ID, "fire_shard", 1, 0),
                getModItem(HardcoreEnderExpansion.ID, "end_powder", 1, 0));
        TCHelper.addResearchPage(
                "GHOSTAMULET",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(HardcoreEnderExpansion.ID, "ghost_amulet", 1, 1))));
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
                getModItem(Avaritia.ID, "Skull_Sword", 1, 0)).setParents("INFUSION").setConcealed().setRound()
                        .setPages(new ResearchPage("Avaritia.research_page.SFSWORD.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SFSWORD",
                getModItem(Avaritia.ID, "Skull_Sword", 1, 0),
                15,
                new AspectList().add(Aspect.getAspect("auram"), 64).add(Aspect.getAspect("corpus"), 64)
                        .add(Aspect.getAspect("exanimis"), 64).add(Aspect.getAspect("metallum"), 64)
                        .add(Aspect.getAspect("mortuus"), 64),
                getModItem(TwilightForest.ID, "item.fierySword", 1, 0),
                getModItem(Minecraft.ID, "blaze_rod", 1, 0),
                getModItem(Minecraft.ID, "blaze_powder", 1, 0),
                getModItem(Avaritia.ID, "Resource", 1, 0),
                NHItemList.LichBone.get(),
                getModItem(Avaritia.ID, "Resource", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                OrePrefixes.ingot.get(Materials.Silver),
                getModItem(TinkerConstruct.ID, "materials", 1, 8),
                getModItem(Avaritia.ID, "Resource", 1, 0),
                NHItemList.LichBone.get(),
                getModItem(Avaritia.ID, "Resource", 1, 0),
                getModItem(Minecraft.ID, "blaze_powder", 1, 0));
        TCHelper.addResearchPage(
                "SFSWORD",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Avaritia.ID, "Skull_Sword", 1, 0))));
        ThaumcraftApi.addWarpToResearch("SFSWORD", 1);
        new ResearchItem(
                "MAGICOBSIDIAN",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("terra"), 8),
                2,
                4,
                2,
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0)).setParents("INFUSION").setConcealed()
                        .setPages(new ResearchPage("Thaum.research_page.MAGICOBSIDIAN")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MAGICOBSIDIAN",
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 4, 1),
                new AspectList().add(Aspect.getAspect("ignis"), 4).add(Aspect.getAspect("terra"), 4),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "obsidian", 1, 0),
                'b',
                getModItem(Minecraft.ID, "obsidian", 1, 0),
                'd',
                getModItem(Minecraft.ID, "obsidian", 1, 0),
                'e',
                getModItem(Minecraft.ID, "obsidian", 1, 0));
        TCHelper.addResearchPage(
                "MAGICOBSIDIAN",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1))));
        TCHelper.addInfusionCraftingRecipe(
                "MAGICOBSIDIAN",
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 4, 0),
                3,
                new AspectList().add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("tenebrae"), 16)
                        .add(Aspect.getAspect("terra"), 16),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1));
        TCHelper.addResearchPage(
                "MAGICOBSIDIAN",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0))));
        ThaumcraftApi.addWarpToResearch("MAGICOBSIDIAN", 1);

        new ResearchItem(
                "HELLISHMETAL",
                "NEWHORIZONS",
                new AspectList().add(Aspect.getAspect("infernus"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("fames"), 6).add(Aspect.getAspect("ignis"), 3),
                0,
                6,
                3,
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.HellishMetal, 1)).setConcealed().setRound()
                        .setPages(new ResearchPage("TConstruct.research_page.HELLISHMETAL.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "HELLISHMETAL",
                GTOreDictUnificator.get(OrePrefixes.block, Materials.HellishMetal, 1),
                1,
                new AspectList().add(Aspect.getAspect("ignis"), 8),
                MaterialsElements.getInstance().RHODIUM.getBlock(1),
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6),
                OrePrefixes.ingot.get(Materials.Thaumium),
                getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 6),
                OrePrefixes.ingot.get(Materials.Thaumium));
        TCHelper.addResearchPage(
                "HELLISHMETAL",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                GTOreDictUnificator.get(OrePrefixes.block, Materials.HellishMetal, 1))));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialsElements.getInstance().RHODIUM.getBlock(1),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 8, 6),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfusedFire, 8))
                .fluidInputs(Materials.Thaumium.getMolten(8 * 144))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.block, Materials.HellishMetal, 1))
                .duration(60 * SECONDS).eut(TierEU.RECIPE_ZPM).addTo(electrolyzerNonCellRecipes);

        GTValues.RA.stdBuilder()
                .itemInputs(
                        MaterialsElements.getInstance().RHODIUM.getDust(64),
                        getModItem(ThaumicTinkerer.ID, "kamiResource", 64, 6),
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.InfusedFire, 64))
                .fluidInputs(Materials.Thaumium.getMolten(STACKS))
                .fluidOutputs(Materials.HellishMetal.getMolten(4 * STACKS)).duration(10 * SECONDS).eut(TierEU.RECIPE_UV)
                .metadata(DEFC_CASING_TIER, 1).addTo(fusionCraftingRecipes);

    }
}
