package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.Automagy;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.Backpack;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.DraconicEvolution;
import static gregtech.api.enums.Mods.ElectroMagicTools;
import static gregtech.api.enums.Mods.EnderStorage;
import static gregtech.api.enums.Mods.EternalSingularity;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.ForbiddenMagic;
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
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicBoots;
import static gregtech.api.enums.Mods.ThaumicTinkerer;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.Mods.TwilightForest;
import static gregtech.api.enums.Mods.WitchingGadgets;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;
import static gregtech.api.util.GTRecipeBuilder.STACKS;
import static gregtech.api.util.GTRecipeConstants.DEFC_CASING_TIER;
import static gtPlusPlus.api.recipe.GTPPRecipeMaps.electrolyzerNonCellRecipes;
import static kubatech.loaders.DEFCRecipes.fusionCraftingRecipes;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.item.NHItemList;
import com.dreammaster.thaumcraft.TCHelper;

import fox.spiteful.avaritia.compat.thaumcraft.Lucrum;
import fox.spiteful.forbidden.DarkAspects;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TCAspects;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTModHandler;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.core.material.MaterialsElements;
import magicbees.api.MagicBeesAPI;
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
                ForbiddenMagic.ID,
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
                new AspectList().add(Aspect.ELDRITCH, 15).add(Aspect.MAGIC, 12).add(DarkAspects.PRIDE, 9)
                        .add(Aspect.SOUL, 6).add(DarkAspects.NETHER, 3),
                3,
                2,
                3,
                NHItemList.WitherProtectionRing.get()).setParents("RUNICARMOR").setSiblings("RUNICARMOR").setConcealed()
                        .setPages(new ResearchPage("NewHorizons.research_page.WITHERRING")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "WITHERRING",
                NHItemList.WitherProtectionRing.get(),
                3,
                new AspectList().add(Aspect.ELDRITCH, 45).add(Aspect.MAGIC, 35).add(Aspect.SOUL, 30)
                        .add(DarkAspects.PRIDE, 25).add(DarkAspects.NETHER, 15),
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
                new AspectList().add(Aspect.ELDRITCH, 15).add(Aspect.SENSES, 12).add(Aspect.EARTH, 9)
                        .add(Aspect.AIR, 6),
                0,
                4,
                3,
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 14)).setParents("INFUSION")
                        .setPages(new ResearchPage("ExtraUtilities.research_page.EMINENCESTONE"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "EMINENCESTONE",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 2, 14),
                new AspectList().add(Aspect.AIR, 50).add(Aspect.FIRE, 50).add(Aspect.EARTH, 50).add(Aspect.WATER, 50)
                        .add(Aspect.ORDER, 50).add(Aspect.ENTROPY, 50),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 14))));
        new ResearchItem(
                "PORTALMILLENIUM",
                "NEWHORIZONS",
                new AspectList().add(Aspect.ELDRITCH, 15).add(Aspect.SENSES, 12).add(Aspect.EARTH, 9),
                2,
                6,
                3,
                getModItem(ExtraUtilities.ID, "dark_portal", 1, 2)).setParents("EMINENCESTONE", "OCULUS").setConcealed()
                        .setPages(new ResearchPage("ExtraUtilities.research_page.PORTALMILLENIUM"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "PORTALMILLENIUM",
                getModItem(ExtraUtilities.ID, "dark_portal", 1, 2),
                4,
                new AspectList().add(Aspect.ELDRITCH, 75).add(Aspect.SENSES, 25).add(Aspect.MAGIC, 75)
                        .add(Aspect.EARTH, 25).add(Aspect.VOID, 75),
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
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ExtraUtilities.ID, "dark_portal", 1, 2))));
        ThaumcraftApi.addWarpToResearch("PORTALMILLENIUM", 2);
        new ResearchItem(
                "PORTALDEEPDARK",
                "NEWHORIZONS",
                new AspectList().add(Aspect.VOID, 27).add((Aspect) MagicBeesAPI.thaumcraftAspectTempus, 24)
                        .add(DarkAspects.LUST, 21).add(DarkAspects.GLUTTONY, 12).add(DarkAspects.PRIDE, 9),
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
                new AspectList().add(Aspect.VOID, 512).add((Aspect) MagicBeesAPI.thaumcraftAspectTempus, 512)
                        .add(DarkAspects.LUST, 512).add(Aspect.ELDRITCH, 512).add(Lucrum.ULTRA_DEATH, 512)
                        .add(DarkAspects.GLUTTONY, 512).add(DarkAspects.PRIDE, 512),
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
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ExtraUtilities.ID, "dark_portal", 1, 0))));
        ThaumcraftApi.addWarpToResearch("PORTALDEEPDARK", 64);
        new ResearchItem(
                "MAGICALWOOD",
                "NEWHORIZONS",
                new AspectList().add(Aspect.MAGIC, 15).add(Aspect.GREED, 12).add(Aspect.TREE, 9).add(Aspect.MIND, 6)
                        .add(Aspect.CLOTH, 3),
                -2,
                6,
                3,
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8)).setParents("EMINENCESTONE").setConcealed()
                        .setPages(new ResearchPage("ExtraUtilities.research_page.MAGICALWOOD")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MAGICALWOOD",
                getModItem(ExtraUtilities.ID, "decorativeBlock1", 4, 8),
                new AspectList().add(Aspect.AIR, 10).add(Aspect.FIRE, 10).add(Aspect.EARTH, 10).add(Aspect.WATER, 10)
                        .add(Aspect.ORDER, 10).add(Aspect.ENTROPY, 10),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ExtraUtilities.ID, "decorativeBlock1", 1, 8))));
        new ResearchItem(
                "ANGELBLOCK",
                "NEWHORIZONS",
                new AspectList().add(Aspect.AIR, 15).add(Aspect.GREED, 12).add(Aspect.FIRE, 9).add(Aspect.EARTH, 6),
                -2,
                8,
                3,
                getModItem(ExtraUtilities.ID, "angelBlock", 1, 0)).setParents("MAGICALWOOD").setConcealed()
                        .setPages(new ResearchPage("ExtraUtilities.research_page.ANGELBLOCK")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ANGELBLOCK",
                getModItem(ExtraUtilities.ID, "angelBlock", 1, 0),
                new AspectList().add(Aspect.AIR, 50),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ExtraUtilities.ID, "angelBlock", 1, 0))));
        new ResearchItem(
                "DEZILSMARSHMALLOW",
                "NEWHORIZONS",
                new AspectList().add(Aspect.ELDRITCH, 15).add(Aspect.MAGIC, 12).add(DarkAspects.PRIDE, 9)
                        .add(Aspect.HEAL, 6).add(Aspect.ENERGY, 3),
                -2,
                2,
                3,
                getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0)).setParents("INFUSION").setSpecial()
                        .setPages(new ResearchPage("de.research_page.DEZILSMARSHMALLOW")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "DEZILSMARSHMALLOW",
                getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0),
                5,
                new AspectList().add(Aspect.ELDRITCH, 32).add(Aspect.MAGIC, 16).add(DarkAspects.PRIDE, 24)
                        .add(Aspect.HEAL, 28).add(Aspect.TRAVEL, 20).add(Aspect.ENERGY, 12),
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
                        TCHelper.findInfusionRecipe(getModItem(DraconicEvolution.ID, "dezilsMarshmallow", 1, 0))));
        ThaumcraftApi.addWarpToResearch("DEZILSMARSHMALLOW", 8);
        new ResearchItem(
                "ENCHANTINGTABLE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.MAGIC, 15).add(Aspect.CRAFT, 12).add(Aspect.MIND, 9).add(Aspect.ENERGY, 6),
                0,
                0,
                3,
                getModItem(Minecraft.ID, "enchanting_table", 1, 0)).setParents("NITOR", "ALUMENTUM")
                        .setPages(new ResearchPage("Minecraft.research_page.ENCHANTINGTABLE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENCHANTINGTABLE",
                getModItem(Minecraft.ID, "enchanting_table", 1, 0),
                new AspectList().add(Aspect.AIR, 45).add(Aspect.WATER, 45).add(Aspect.EARTH, 45).add(Aspect.FIRE, 45)
                        .add(Aspect.ORDER, 45).add(Aspect.ENTROPY, 45),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Minecraft.ID, "enchanting_table", 1, 0))));
        new ResearchItem(
                "DISENCHANTINGTABLE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.ELDRITCH, 21).add(Aspect.ENTROPY, 18).add(Aspect.MAGIC, 15)
                        .add(Aspect.CRAFT, 12).add(Aspect.MIND, 9).add(Aspect.ENERGY, 6),
                2,
                2,
                3,
                getModItem(DraconicEvolution.ID, "dissEnchanter", 1, 0))
                        .setParents("ENCHANTINGTABLE").setConcealed()
                        .setPages(
                                new ResearchPage("DraconicEvolution.research_page.DISENCHANTINGTABLE"),
                                new ResearchPage("DraconicEvolution.research_page.DISENCHANTINGTABLE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DISENCHANTINGTABLE",
                getModItem(DraconicEvolution.ID, "dissEnchanter", 1, 0),
                new AspectList().add(Aspect.AIR, 75).add(Aspect.WATER, 75).add(Aspect.EARTH, 75).add(Aspect.FIRE, 75)
                        .add(Aspect.ORDER, 75).add(Aspect.ENTROPY, 75),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(DraconicEvolution.ID, "dissEnchanter", 1, 0))));
        ThaumcraftApi.addWarpToResearch("DISENCHANTINGTABLE", 3);
        new ResearchItem(
                "BREWINGSTAND",
                "NEWHORIZONS",
                new AspectList().add(Aspect.MAGIC, 15).add(Aspect.CRAFT, 15).add(Aspect.MIND, 12)
                        .add(Aspect.ENTROPY, 12).add(Aspect.FIRE, 9).add(Aspect.EARTH, 6).add(Aspect.WATER, 3),
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
                new AspectList().add(Aspect.AIR, 20).add(Aspect.WATER, 20).add(Aspect.EARTH, 20).add(Aspect.FIRE, 20)
                        .add(Aspect.ORDER, 20).add(Aspect.ENTROPY, 20),
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
                new AspectList().add(Aspect.ELDRITCH, 15).add(Aspect.MAGIC, 12).add(Aspect.AURA, 9)
                        .add(Aspect.HUNGER, 6),
                4,
                0,
                3,
                getModItem(Minecraft.ID, "beacon", 1, 0)).setParents("INFUSION")
                        .setPages(new ResearchPage("Minecraft.research_page.BEACON")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "BEACON",
                getModItem(Minecraft.ID, "beacon", 1, 0),
                6,
                new AspectList().add(Aspect.MAGIC, 64).add(Aspect.ELDRITCH, 64).add(Aspect.LIGHT, 64)
                        .add(Aspect.ORDER, 64).add(Aspect.FIRE, 64).add(Aspect.EARTH, 64),
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
                new AspectList().add(Aspect.ELDRITCH, 15).add(Aspect.MAGIC, 12).add(Aspect.LIFE, 9)
                        .add(Aspect.BEAST, 6),
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
                new AspectList().add(Aspect.ELDRITCH, 64).add(Aspect.BEAST, 56).add(Aspect.MAGIC, 48)
                        .add(Aspect.LIFE, 48),
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
                new AspectList().add(Aspect.CLOTH, 15).add(Aspect.GREED, 2).add(Aspect.TOOL, 9).add(Aspect.AIR, 6)
                        .add(Aspect.MAGIC, 3),
                -2,
                -2,
                3,
                getModItem(TinkerConstruct.ID, "materials", 1, 26)).setParents("ENCHANTINGTABLE").setConcealed()
                        .setRound().setPages(new ResearchPage("TConstruct.research_page.SILKYCRYSTAL"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SILKYCRYSTAL",
                getModItem(TinkerConstruct.ID, "materials", 1, 25),
                new AspectList().add(Aspect.AIR, 30).add(Aspect.WATER, 25).add(Aspect.FIRE, 15).add(Aspect.EARTH, 15)
                        .add(Aspect.ORDER, 10).add(Aspect.ENTROPY, 10),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 25))));
        TCHelper.addInfusionCraftingRecipe(
                "SILKYCRYSTAL",
                getModItem(TinkerConstruct.ID, "materials", 1, 26),
                4,
                new AspectList().add(Aspect.FIRE, 20).add(Aspect.EARTH, 20).add(Aspect.ORDER, 35).add(Aspect.MAGIC, 35)
                        .add(Aspect.CRYSTAL, 20),
                OrePrefixes.gemFlawless.get(Materials.Diamond),
                getModItem(TinkerConstruct.ID, "materials", 1, 25),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 0),
                getModItem(TinkerConstruct.ID, "materials", 1, 25),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 3),
                getModItem(TinkerConstruct.ID, "materials", 1, 25),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 4));
        TCHelper.addResearchPage(
                "SILKYCRYSTAL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 26))));
        new ResearchItem(
                "LAVACRYSTAL",
                "NEWHORIZONS",
                new AspectList().add(Aspect.FIRE, 15).add(Aspect.MAGIC, 12).add(Aspect.VOID, 9).add(Aspect.ENTROPY, 6),
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
                new AspectList().add(Aspect.FIRE, 25).add(Aspect.ENTROPY, 25).add(Aspect.VOID, 20)
                        .add(Aspect.MAGIC, 35),
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
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 7))));
        new ResearchItem(
                "BALLOFMOSS",
                "NEWHORIZONS",
                new AspectList().add(Aspect.HEAL, 15).add(Aspect.EARTH, 12).add(Aspect.TOOL, 9),
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
                new AspectList().add(Aspect.HEAL, 30).add(Aspect.EARTH, 25).add(Aspect.TOOL, 35),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                OrePrefixes.dust.get(Materials.InfusedEarth),
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 3),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0),
                OrePrefixes.dust.get(Materials.InfusedEarth),
                getModItem(TwilightForest.ID, "tile.TFPlant", 1, 3),
                getModItem(BiomesOPlenty.ID, "moss", 1, 0));
        TCHelper.addResearchPage(
                "BALLOFMOSS",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 6))));
        new ResearchItem(
                "NECROTICBONE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.UNDEAD, 15).add(Aspect.DEATH, 12).add(Aspect.SOUL, 9).add(Aspect.POISON, 6),
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
                new AspectList().add(Aspect.UNDEAD, 20).add(Aspect.DEATH, 30).add(DarkAspects.NETHER, 20)
                        .add(Aspect.SOUL, 20).add(Aspect.POISON, 20).add(Aspect.FLESH, 5));
        TCHelper.addResearchPage(
                "NECROTICBONE",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(TinkerConstruct.ID, "materials", 1, 8))));
        ThaumcraftApi.addWarpToResearch("NECROTICBONE", 2);
        new ResearchItem(
                "REDHEART",
                "NEWHORIZONS",
                new AspectList().add(Aspect.FIRE, 15).add(Aspect.MAGIC, 12).add(Aspect.HEAL, 9).add(Aspect.DEATH, 6)
                        .add(Aspect.UNDEAD, 3),
                0,
                -6,
                3,
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 1)).setParents("RUNICAUGMENTATION", "BALLOFMOSS")
                        .setConcealed().setRound().setPages(new ResearchPage("TConstruct.research_page.REDHEART.1"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "REDHEART",
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 1),
                3,
                new AspectList().add(Aspect.UNDEAD, 25).add(Aspect.FIRE, 35).add(Aspect.GREED, 35).add(Aspect.HEAL, 50)
                        .add(Aspect.MAGIC, 50),
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
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TinkerConstruct.ID, "heartCanister", 1, 1))));
        ThaumcraftApi.addWarpToResearch("REDHEARTCANISTER", 1);
        new ResearchItem(
                "REDHEARTCANISTER",
                "NEWHORIZONS",
                new AspectList().add(Aspect.METAL, 15).add(Aspect.GREED, 15).add(Aspect.HEAL, 12).add(Aspect.FIRE, 9)
                        .add(Aspect.DEATH, 6).add(Aspect.UNDEAD, 3),
                0,
                -8,
                3,
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 2)).setParents("REDHEART").setConcealed()
                        .setPages(new ResearchPage("TConstruct.research_page.REDHEARTCANISTER.1"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REDHEARTCANISTER",
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 2),
                new AspectList().add(Aspect.AIR, 50).add(Aspect.WATER, 50).add(Aspect.FIRE, 50).add(Aspect.EARTH, 50)
                        .add(Aspect.ORDER, 50).add(Aspect.ENTROPY, 50),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TinkerConstruct.ID, "heartCanister", 1, 2))));
        ThaumcraftApi.addWarpToResearch("REDHEARTCANISTER", 2);
        new ResearchItem(
                "YELLOWHEART",
                "NEWHORIZONS",
                new AspectList().add(Aspect.DEATH, 15).add(Aspect.MAGIC, 12).add(Aspect.UNDEAD, 9).add(Aspect.HEAL, 6)
                        .add(Aspect.FIRE, 3),
                -2,
                -7,
                3,
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 3)).setParents("REDHEART").setConcealed().setRound()
                        .setPages(new ResearchPage("TConstruct.research_page.YELLOWHEART.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "YELLOWHEART",
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 3),
                3,
                new AspectList().add(Aspect.UNDEAD, 50).add(Aspect.FIRE, 75).add(Aspect.GREED, 75).add(Aspect.HEAL, 100)
                        .add(Aspect.MAGIC, 100),
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
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TinkerConstruct.ID, "heartCanister", 1, 3))));
        ThaumcraftApi.addWarpToResearch("YELLOWHEARTCANISTER", 2);
        new ResearchItem(
                "YELLOWHEARTCANISTER",
                "NEWHORIZONS",
                new AspectList().add(Aspect.METAL, 15).add(Aspect.GREED, 15).add(Aspect.HEAL, 12).add(Aspect.MAGIC, 9)
                        .add(Aspect.DEATH, 6).add(Aspect.UNDEAD, 3),
                -2,
                -9,
                3,
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 4)).setParents("YELLOWHEART").setConcealed()
                        .setPages(new ResearchPage("TConstruct.research_page.YELLOWHEARTCANISTER.1"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "YELLOWHEARTCANISTER",
                getModItem(TinkerConstruct.ID, "heartCanister", 1, 4),
                new AspectList().add(Aspect.AIR, 100).add(Aspect.WATER, 100).add(Aspect.FIRE, 100)
                        .add(Aspect.EARTH, 100).add(Aspect.ORDER, 100).add(Aspect.ENTROPY, 100),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TinkerConstruct.ID, "heartCanister", 1, 4))));
        ThaumcraftApi.addWarpToResearch("YELLOWHEARTCANISTER", 3);
        new ResearchItem(
                "GREENHEART",
                "NEWHORIZONS",
                new AspectList().add(DarkAspects.NETHER, 15).add(Aspect.GREED, 12).add(Aspect.MAGIC, 12)
                        .add(Aspect.SOUL, 9).add(Aspect.HUNGER, 6).add(Aspect.FLESH, 3),
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
                new AspectList().add(Aspect.UNDEAD, 100).add(Aspect.FIRE, 150).add(Aspect.GREED, 150)
                        .add(Aspect.HEAL, 200).add(Aspect.MAGIC, 200),
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
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TinkerConstruct.ID, "heartCanister", 1, 5))));
        ThaumcraftApi.addWarpToResearch("GREENHEART", 3);
        new ResearchItem(
                "GREENHEARTCANISTER",
                "NEWHORIZONS",
                new AspectList().add(DarkAspects.NETHER, 15).add(Aspect.METAL, 15).add(Aspect.GREED, 12)
                        .add(Aspect.HEAL, 12).add(Aspect.MAGIC, 12).add(Aspect.SOUL, 9).add(Aspect.HUNGER, 6)
                        .add(Aspect.FLESH, 3),
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
                new AspectList().add(Aspect.AIR, 200).add(Aspect.WATER, 200).add(Aspect.FIRE, 200)
                        .add(Aspect.EARTH, 200).add(Aspect.ORDER, 200).add(Aspect.ENTROPY, 200),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TinkerConstruct.ID, "heartCanister", 1, 6))));
        ThaumcraftApi.addWarpToResearch("GREENHEARTCANISTER", 4);
        new ResearchItem(
                "ENDERCHEST",
                "NEWHORIZONS",
                new AspectList().add(Aspect.METAL, 15).add(TCAspects.ELECTRUM.getAspect(), 15).add(Aspect.MECHANISM, 12)
                        .add(Aspect.ELDRITCH, 9).add(Aspect.GREED, 6).add(Aspect.CRAFT, 3),
                -4,
                0,
                3,
                getModItem(EnderStorage.ID, "enderChest", 1, 0)).setParents("INFUSION").setConcealed()
                        .setPages(new ResearchPage("EnderStorage.research_page.ENDERCHEST")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENDERCHEST",
                getModItem(EnderStorage.ID, "enderChest", 1, 0),
                new AspectList().add(Aspect.AIR, 100).add(Aspect.WATER, 100).add(Aspect.FIRE, 100)
                        .add(Aspect.EARTH, 100),
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
                new AspectList().add(Aspect.METAL, 15).add(TCAspects.ELECTRUM.getAspect(), 15).add(Aspect.MECHANISM, 12)
                        .add(Aspect.FIRE, 9).add(Aspect.GREED, 6).add(Aspect.SENSES, 3),
                -4,
                2,
                3,
                getModItem(EnderStorage.ID, "enderChest", 1, 4096)).setParents("ENDERCHEST").setConcealed()
                        .setPages(new ResearchPage("EnderStorage.research_page.ENDERTANK")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENDERTANK",
                getModItem(EnderStorage.ID, "enderChest", 1, 4096),
                new AspectList().add(Aspect.AIR, 100).add(Aspect.WATER, 100).add(Aspect.FIRE, 100)
                        .add(Aspect.EARTH, 100).add(Aspect.ORDER, 100),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(EnderStorage.ID, "enderChest", 1, 4096))));
        new ResearchItem(
                "ENDERPOUCHE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.GREED, 15).add(Aspect.CRYSTAL, 15).add(Aspect.METAL, 12)
                        .add(TCAspects.ELECTRUM.getAspect(), 9).add(Aspect.MECHANISM, 6).add(Aspect.ELDRITCH, 3),
                -4,
                4,
                3,
                getModItem(EnderStorage.ID, "enderPouch", 1, 0)).setParents("ENDERTANK").setConcealed()
                        .setPages(new ResearchPage("EnderStorage.research_page.ENDERPOUCHE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENDERPOUCHE",
                getModItem(EnderStorage.ID, "enderPouch", 1, 0),
                new AspectList().add(Aspect.AIR, 100).add(Aspect.WATER, 100).add(Aspect.FIRE, 100)
                        .add(Aspect.EARTH, 100).add(Aspect.ORDER, 100).add(Aspect.ENTROPY, 100),
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
                new AspectList().add(Aspect.MAGIC, 15).add(Aspect.CRAFT, 12).add(Aspect.MIND, 9).add(Aspect.ENERGY, 6),
                0,
                2,
                3,
                getModItem(OpenBlocks.ID, "autoenchantmenttable", 1, 0))
                        .setParents("ENCHANTINGTABLE").setConcealed()
                        .setPages(
                                new ResearchPage("OpenBlocks.research_page.AUTOENCHANTINGTABLE.1"),
                                new ResearchPage("OpenBlocks.research_page.AUTOENCHANTINGTABLE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "AUTOENCHANTINGTABLE",
                getModItem(OpenBlocks.ID, "autoenchantmenttable", 1, 0),
                new AspectList().add(Aspect.AIR, 75).add(Aspect.WATER, 75).add(Aspect.FIRE, 75).add(Aspect.ENTROPY, 75),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(OpenBlocks.ID, "autoenchantmenttable", 1, 0))));
        ThaumcraftApi.addWarpToResearch("AUTOENCHANTINGTABLE", 1);
        new ResearchItem(
                "LUGGAGE",
                "NEWHORIZONS",
                new AspectList().add(Aspect.ELDRITCH, 15).add(Aspect.SENSES, 15).add(Aspect.TRAVEL, 12)
                        .add(Aspect.MAGIC, 9).add(Aspect.CRAFT, 6).add(Aspect.GREED, 3),
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
                new AspectList().add(Aspect.AIR, 75).add(Aspect.WATER, 75).add(Aspect.FIRE, 75).add(Aspect.EARTH, 75)
                        .add(Aspect.ENTROPY, 75).add(Aspect.ORDER, 75),
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
                new AspectList().add(Aspect.ENERGY, 21).add(Aspect.AURA, 18).add(DarkAspects.NETHER, 15)
                        .add(Aspect.GREED, 12).add(Aspect.MAGIC, 12).add(Aspect.SOUL, 9).add(Aspect.ELDRITCH, 6)
                        .add(Aspect.FLESH, 3),
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
                new AspectList().add(Aspect.AURA, 64).add(Aspect.ENERGY, 64).add(Aspect.TAINT, 32)
                        .add(Aspect.CRYSTAL, 48).add(Aspect.SOUL, 32).add(Aspect.FLESH, 16).add(Aspect.ELDRITCH, 24)
                        .add(Aspect.GREED, 8),
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
                        TCHelper.findInfusionRecipe(getModItem(HardcoreEnderExpansion.ID, "ghost_amulet", 1, 1))));
        ThaumcraftApi.addWarpToResearch("GHOSTAMULET", 3);
        new ResearchItem(
                "SFSWORD",
                "NEWHORIZONS",
                new AspectList().add(Aspect.AURA, 8).add(Aspect.FLESH, 8).add(Aspect.UNDEAD, 8).add(Aspect.METAL, 8)
                        .add(Aspect.DEATH, 8),
                4,
                4,
                3,
                getModItem(Avaritia.ID, "Skull_Sword", 1, 0)).setParents("INFUSION").setConcealed().setRound()
                        .setPages(new ResearchPage("Avaritia.research_page.SFSWORD.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SFSWORD",
                getModItem(Avaritia.ID, "Skull_Sword", 1, 0),
                15,
                new AspectList().add(Aspect.AURA, 64).add(Aspect.FLESH, 64).add(Aspect.UNDEAD, 64).add(Aspect.METAL, 64)
                        .add(Aspect.DEATH, 64),
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
                new AspectList().add(Aspect.ENTROPY, 8).add(Aspect.EARTH, 8),
                2,
                4,
                2,
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0)).setParents("INFUSION").setConcealed()
                        .setPages(new ResearchPage("Thaum.research_page.MAGICOBSIDIAN")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MAGICOBSIDIAN",
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 4, 1),
                new AspectList().add(Aspect.FIRE, 4).add(Aspect.EARTH, 4),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1))));
        TCHelper.addInfusionCraftingRecipe(
                "MAGICOBSIDIAN",
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 4, 0),
                3,
                new AspectList().add(Aspect.ENTROPY, 16).add(Aspect.DARKNESS, 16).add(Aspect.EARTH, 16),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1));
        TCHelper.addResearchPage(
                "MAGICOBSIDIAN",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 0))));
        ThaumcraftApi.addWarpToResearch("MAGICOBSIDIAN", 1);

        new ResearchItem(
                "HELLISHMETAL",
                "NEWHORIZONS",
                new AspectList().add(DarkAspects.NETHER, 15).add(Aspect.GREED, 12).add(Aspect.HUNGER, 6)
                        .add(Aspect.FIRE, 3),
                0,
                6,
                3,
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.HellishMetal, 1)).setConcealed().setRound()
                        .setPages(new ResearchPage("TConstruct.research_page.HELLISHMETAL.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "HELLISHMETAL",
                GTOreDictUnificator.get(OrePrefixes.block, Materials.HellishMetal, 1),
                1,
                new AspectList().add(Aspect.FIRE, 8),
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

        // Mechanical Armor augments

        new ResearchItem(
                "MECHANICALARMOR_GOGGLES",
                "NEWHORIZONS",
                new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 12).add(Aspect.SENSES, 6),
                -6,
                2,
                2,
                ItemList.Augment_GogglesOfRevealing.get(1)).setParents("GOGGLES")
                        .setPages(new ResearchPage("NewHorizons.research_page.MECHANICALARMOR_GOGGLES"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MECHANICALARMOR_GOGGLES",
                ItemList.Augment_GogglesOfRevealing.get(1),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("ignis"), 30).add(Aspect.getAspect("aqua"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "gGg",
                "PRP",
                "gPg",
                'g',
                GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.StainlessSteel, 1),
                'P',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1),
                'G',
                GTModHandler.getModItem(Thaumcraft.ID, "ItemGoggles", 1, 0),
                'R',
                ItemList.Armor_Chip_T1.get(1));
        TCHelper.addResearchPage(
                "MECHANICALARMOR_GOGGLES",
                new ResearchPage(TCHelper.findArcaneRecipe(ItemList.Augment_GogglesOfRevealing.get(1))));

        new ResearchItem(
                "MECHANICALARMOR_MILK",
                "NEWHORIZONS",
                new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 12).add(Aspect.HEAL, 6),
                -8,
                0,
                2,
                ItemList.Augment_MilkInfusion.get(1)).setParents("MECHANICALARMOR_GOGGLES", "CLEANSING_TALISMAN")
                        .setPages(new ResearchPage("NewHorizons.research_page.MECHANICALARMOR_MILK"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CLEANSING_TALISMAN",
                ItemList.Augment_MilkInfusion.get(1),
                new AspectList().add(Aspect.getAspect("terra"), 150).add(Aspect.getAspect("aqua"), 150)
                        .add(Aspect.getAspect("ordo"), 150),
                "MTM",
                "VRV",
                "MVM",
                'M',
                ItemList.Electric_Motor_IV.get(4),
                'V',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1),
                'T',
                GTModHandler.getModItem(ThaumicTinkerer.ID, "cleansingTalisman", 1, 0),
                'R',
                ItemList.Armor_Chip_T2.get(1));
        TCHelper.addResearchPage(
                "MECHANICALARMOR_MILK",
                new ResearchPage(TCHelper.findArcaneRecipe(ItemList.Augment_MilkInfusion.get(1))));

        new ResearchItem(
                "MECHANICALARMOR_APPRENTICE_STRIDERS",
                "NEWHORIZONS",
                new AspectList().add(Aspect.ARMOR, 24).add(Aspect.MAGIC, 12).add(Aspect.CRAFT, 8),
                -8,
                4,
                2,
                ItemList.Augment_ApprenticeStriders.get(1))
                        .setParents(
                                "MECHANICALARMOR_GOGGLES",
                                "SPINNINGWHEEL",
                                "SPELL_CLOTH",
                                "NanoBootsoftheTraveller")
                        .setPages(
                                new ResearchPage("NewHorizons.research_page.MECHANICALARMOR_APPRENTICE_STRIDERS.1"),
                                new ResearchPage("NewHorizons.research_page.MECHANICALARMOR_APPRENTICE_STRIDERS.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MECHANICALARMOR_APPRENTICE_STRIDERS",
                ItemList.Augment_ApprenticeStriders.get(1),
                new AspectList().add(Aspect.getAspect("terra"), 100).add(Aspect.getAspect("aqua"), 100)
                        .add(Aspect.getAspect("ordo"), 100).add(Aspect.getAspect("aer"), 100)
                        .add(Aspect.getAspect("fire"), 100).add(Aspect.getAspect("perditio"), 100),
                "FAC",
                "MTM",
                "CAF",
                'F',
                GTModHandler.getModItem(WitchingGadgets.ID, "item.WG_Material", 1, 3),
                'A',
                ItemList.Armor_Chip_T1.get(1),
                'C',
                GTModHandler.getModItem(ThaumicTinkerer.ID, "spellCloth", 1),
                'M',
                ItemList.Electric_Motor_HV.get(1),
                'T',
                GTModHandler.getModItem(ElectroMagicTools.ID, "NanoBootsTraveller", 1));

        ThaumcraftApi.addArcaneCraftingRecipe(
                "MECHANICALARMOR_APPRENTICE_STRIDERS",
                GTModHandler.getModItem(ElectroMagicTools.ID, "NanoBootsTraveller"),
                new AspectList().add(Aspect.getAspect("perditio"), 100),
                "   ",
                " T ",
                "   ",
                'T',
                ItemList.Augment_ApprenticeStriders.get(1));

        TCHelper.addResearchPage(
                "MECHANICALARMOR_APPRENTICE_STRIDERS",
                new ResearchPage(TCHelper.findArcaneRecipe(ItemList.Augment_ApprenticeStriders.get(1))));

        TCHelper.addResearchPage(
                "MECHANICALARMOR_APPRENTICE_STRIDERS",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                GTModHandler.getModItem(ElectroMagicTools.ID, "NanoBootsTraveller"))));

        new ResearchItem(
                "MECHANICALARMOR_ARCHMAGE_STRIDERS",
                "NEWHORIZONS",
                new AspectList().add(Aspect.ARMOR, 32).add(Aspect.MAGIC, 16).add(Aspect.CRAFT, 8),
                -8,
                6,
                2,
                ItemList.Augment_ArchmageStriders.get(1))
                        .setParents(
                                "MECHANICALARMOR_APPRENTICE_STRIDERS",
                                "OCULUS",
                                "ADVANCEDROBES",
                                "QuantumBootsoftheTraveller")
                        .setPages(new ResearchPage("NewHorizons.research_page.MECHANICALARMOR_ARCHMAGE_STRIDERS"))
                        .registerResearchItem();
        ThaumcraftApi.addWarpToResearch("MECHANICALARMOR_ARCHMAGE_STRIDERS", 3);

        TCHelper.addInfusionCraftingRecipe(
                "MECHANICALARMOR_ARCHMAGE_STRIDERS",
                ItemList.Augment_ArchmageStriders.get(1),
                9,
                new AspectList().add(Aspect.MOTION, 64).add(Aspect.ARMOR, 48).add(Aspect.MAGIC, 48).add(Aspect.AIR, 32)
                        .add(Aspect.CRAFT, 32).add(Aspect.ENERGY, 32),

                GTModHandler.getModItem(ElectroMagicTools.ID, "QuantumBootsTraveller", 1),
                GTModHandler.getModItem(Thaumcraft.ID, "ItemEldritchObject", 1),
                GTModHandler.getModItem(WitchingGadgets.ID, "item.WG_Material", 1, 5),
                GTModHandler.getModItem(ThaumicTinkerer.ID, "spellCloth", 1),
                GTModHandler.getModItem(WitchingGadgets.ID, "item.WG_Material", 1, 3),
                ItemList.Armor_Chip_T2.get(1),
                GTModHandler.getModItem(WitchingGadgets.ID, "item.WG_Material", 1, 3),
                GTModHandler.getModItem(ThaumicTinkerer.ID, "spellCloth", 1),
                GTModHandler.getModItem(WitchingGadgets.ID, "item.WG_Material", 1, 5)

        );

        ThaumcraftApi.addArcaneCraftingRecipe(
                "MECHANICALARMOR_ARCHMAGE_STRIDERS",
                GTModHandler.getModItem(ElectroMagicTools.ID, "QuantumBootsTraveller"),
                new AspectList().add(Aspect.getAspect("perditio"), 150),
                "   ",
                " T ",
                "   ",
                'T',
                ItemList.Augment_ArchmageStriders.get(1));

        TCHelper.addResearchPage(
                "MECHANICALARMOR_ARCHMAGE_STRIDERS",
                new ResearchPage(TCHelper.findInfusionRecipe(ItemList.Augment_ArchmageStriders.get(1))));

        TCHelper.addResearchPage(
                "MECHANICALARMOR_ARCHMAGE_STRIDERS",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                GTModHandler.getModItem(ElectroMagicTools.ID, "QuantumBootsTraveller"))));

        new ResearchItem(
                "MECHANICALARMOR_ELDRITCH_STRIDERS",
                "NEWHORIZONS",
                new AspectList().add(Aspect.ELDRITCH, 48).add(Aspect.ARMOR, 32).add(Aspect.MAGIC, 16)
                        .add(Aspect.CRAFT, 12).add(Aspect.AIR, 6),
                -8,
                8,
                3,
                ItemList.Augment_EldritchStriders.get(1))
                        .setParents(
                                "MECHANICALARMOR_ARCHMAGE_STRIDERS",
                                "ShadowClothGTNH",
                                "ICHOR_CLOTH",
                                "KnightRobesGTNH",
                                "TB_EMT_Tainted_Compat")
                        .setPages(
                                new ResearchPage("NewHorizons.research_page.MECHANICALARMOR_ELDRITCH_STRIDERS.1"),
                                new ResearchPage("NewHorizons.research_page.MECHANICALARMOR_ELDRITCH_STRIDERS.2"))
                        .registerResearchItem();
        ThaumcraftApi.addWarpToResearch("MECHANICALARMOR_ELDRITCH_STRIDERS", 10);

        TCHelper.addInfusionCraftingRecipe(
                "MECHANICALARMOR_ELDRITCH_STRIDERS",
                ItemList.Augment_EldritchStriders.get(1),
                12,
                new AspectList().add(Aspect.ELDRITCH, 128).add(Aspect.TAINT, 64).add(Aspect.SOUL, 64)
                        .add(Aspect.MAGIC, 48).add(Aspect.ARMOR, 48).add(Aspect.CRAFT, 32).add(Aspect.CRAFT, 32)
                        .add(Aspect.ENERGY, 32),

                GTModHandler.getModItem(ThaumicBoots.ID, "item.ItemQuantumVoid", 1),
                GTModHandler.getModItem(ThaumicTinkerer.ID, "kamiResource", 1, 1),
                GTModHandler.getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                GTModHandler.getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                GTModHandler.getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                ItemList.Armor_Chip_T3.get(1),
                GTModHandler.getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                GTModHandler.getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                GTModHandler.getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1)

        );

        ThaumcraftApi.addArcaneCraftingRecipe(
                "MECHANICALARMOR_ELDRITCH_STRIDERS",
                GTModHandler.getModItem(ThaumicBoots.ID, "item.ItemQuantumVoid"),
                new AspectList().add(Aspect.getAspect("perditio"), 250),
                "   ",
                " T ",
                "   ",
                'T',
                ItemList.Augment_EldritchStriders.get(1));

        TCHelper.addResearchPage(
                "MECHANICALARMOR_ELDRITCH_STRIDERS",
                new ResearchPage(TCHelper.findInfusionRecipe(ItemList.Augment_EldritchStriders.get(1))));

        TCHelper.addResearchPage(
                "MECHANICALARMOR_ELDRITCH_STRIDERS",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(GTModHandler.getModItem(ThaumicBoots.ID, "item.ItemQuantumVoid"))));
    }
}
