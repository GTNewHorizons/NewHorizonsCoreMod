package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.BiomesOPlenty;
import static gregtech.api.enums.Mods.Botania;
import static gregtech.api.enums.Mods.EnderIO;
import static gregtech.api.enums.Mods.ExtraUtilities;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.Natura;
import static gregtech.api.enums.Mods.PamsHarvestCraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicExploration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptThaumicExploration implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Thaumic Exploration";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                BiomesOPlenty.ID,
                Botania.ID,
                EnderIO.ID,
                ExtraUtilities.ID,
                ForbiddenMagic.ID,
                Natura.ID,
                PamsHarvestCraft.ID,
                Thaumcraft.ID,
                ThaumicExploration.ID);
    }

    @Override
    public void loadRecipes() {
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "discountRing", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "discountRing", 1, 1));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "discountRing", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "discountRing", 1, 3));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "discountRing", 1, 4));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "discountRing", 1, 5));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 0));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 1));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 2));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 3));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 4));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 5));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 6));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 7));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 8));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 9));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 10));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 11));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 12));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 13));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 14));
        TCHelper.removeCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 15));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, 1));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, 2));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, 3));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, 4));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, 5));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, 6));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, 7));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, 8));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, 9));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, 10));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, 11));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, 12));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, 13));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, 14));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, 15));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 3, wildcard));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "replicator", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "trashJar", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "bootsMeteor", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "bootsComet", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "soulBrazier", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "everfullUrn", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "everburnUrn", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "sojournerCapUncharged", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "sojournerCap", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "mechanistCapUncharged", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "mechanistCap", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "stabilizerBelt", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "pureZombieBrain", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "pureZombieBrain", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "pureZombieBrain", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "pureZombieBrain", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "pureZombieBrain", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "talismanFood", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "charmNoTaint", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "charmNoTaint", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "crucibleSouls", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "transmutationCore", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "transmutationStaffCore", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "amberCore", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ThaumicExploration.ID, "amberStaffCore", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ThaumicExploration.ID, "necroStaffCore", 1, 0));
        TCHelper.removeCrucibleRecipe(
                getModItem(Minecraft.ID, "leather", 2, 0),
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0));
        TCHelper.removeCrucibleRecipe(
                getModItem(Minecraft.ID, "leather", 1, 0),
                getModItem(Minecraft.ID, "beef", 1, 0));
        TCHelper.removeCrucibleRecipe(
                getModItem(Minecraft.ID, "leather", 1, 0),
                getModItem(Minecraft.ID, "porkchop", 1, 0));
        TCHelper.orphanResearch("DISCOUNTRINGS");
        TCHelper.removeResearch("DISCOUNTRINGS");
        new ResearchItem(
                "DiacountringsGTNH",
                "TX",
                new AspectList().add(Aspect.getAspect("vitreus"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("alienis"), 3),
                1,
                3,
                2,
                getModItem(ThaumicExploration.ID, "discountRing", 1, 2)).setParents("TXBASICARTIFACE").setConcealed()
                        .setPages(new ResearchPage("te.text.DISCOUNTRINGS.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DiacountringsGTNH",
                getModItem(ThaumicExploration.ID, "discountRing", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "screwInfusedAir",
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'c',
                "screwInfusedAir",
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'e',
                "craftingToolScrewdriver",
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'g',
                "screwInfusedAir",
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'i',
                "screwInfusedAir");
        TCHelper.addResearchPage(
                "DiacountringsGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "discountRing", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DiacountringsGTNH",
                getModItem(ThaumicExploration.ID, "discountRing", 1, 1),
                new AspectList().add(Aspect.getAspect("terra"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "screwInfusedEarth",
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'c',
                "screwInfusedEarth",
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'e',
                "craftingToolScrewdriver",
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'g',
                "screwInfusedEarth",
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'i',
                "screwInfusedEarth");
        TCHelper.addResearchPage(
                "DiacountringsGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "discountRing", 1, 1))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DiacountringsGTNH",
                getModItem(ThaumicExploration.ID, "discountRing", 1, 2),
                new AspectList().add(Aspect.getAspect("ignis"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "screwInfusedFire",
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'c',
                "screwInfusedFire",
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'e',
                "craftingToolScrewdriver",
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'g',
                "screwInfusedFire",
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'i',
                "screwInfusedFire");
        TCHelper.addResearchPage(
                "DiacountringsGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "discountRing", 1, 2))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DiacountringsGTNH",
                getModItem(ThaumicExploration.ID, "discountRing", 1, 3),
                new AspectList().add(Aspect.getAspect("aqua"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "screwInfusedWater",
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'c',
                "screwInfusedWater",
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'e',
                "craftingToolScrewdriver",
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'g',
                "screwInfusedWater",
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'i',
                "screwInfusedWater");
        TCHelper.addResearchPage(
                "DiacountringsGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "discountRing", 1, 3))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DiacountringsGTNH",
                getModItem(ThaumicExploration.ID, "discountRing", 1, 4),
                new AspectList().add(Aspect.getAspect("ordo"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "screwInfusedOrder",
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'c',
                "screwInfusedOrder",
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'e',
                "craftingToolScrewdriver",
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'g',
                "screwInfusedOrder",
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'i',
                "screwInfusedOrder");
        TCHelper.addResearchPage(
                "DiacountringsGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "discountRing", 1, 4))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DiacountringsGTNH",
                getModItem(ThaumicExploration.ID, "discountRing", 1, 5),
                new AspectList().add(Aspect.getAspect("perditio"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "screwInfusedEntropy",
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                'c',
                "screwInfusedEntropy",
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                'e',
                "craftingToolScrewdriver",
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                'g',
                "screwInfusedEntropy",
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                'i',
                "screwInfusedEntropy");
        TCHelper.addResearchPage(
                "DiacountringsGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "discountRing", 1, 5))));
        TCHelper.orphanResearch("JARSEAL");
        TCHelper.removeResearch("JARSEAL");
        new ResearchItem(
                "JarsealGTNH",
                "TX",
                new AspectList().add(Aspect.getAspect("vinculum"), 18).add(Aspect.getAspect("alienis"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("iter"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("aqua"), 3),
                -7,
                -2,
                3,
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 1))
                        .setParents("TALLOW", "JARLABEL").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.JarsealGTNH.1"),
                                new ResearchPage("tc.research_page.JarsealGTNH.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 15),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "dyeWhite",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'c',
                "dyeWhite",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'e',
                "plateStone",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'g',
                "dyeWhite",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'i',
                "dyeWhite");
        ThaumcraftApi.addCrucibleRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 15),
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 15),
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("vinculum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "blankSeal", 1, 15))));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 15))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "dyeBlack",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'c',
                "dyeBlack",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'e',
                "plateStone",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'g',
                "dyeBlack",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'i',
                "dyeBlack");
        ThaumcraftApi.addCrucibleRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 0),
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 0),
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("vinculum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "blankSeal", 1, 0))));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 1),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "dyeRed",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'c',
                "dyeRed",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'e',
                "plateStone",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'g',
                "dyeRed",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'i',
                "dyeRed");
        ThaumcraftApi.addCrucibleRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 1),
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 1),
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("vinculum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "blankSeal", 1, 1))));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 1))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 2),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "dyeGreen",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'c',
                "dyeGreen",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'e',
                "plateStone",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'g',
                "dyeGreen",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'i',
                "dyeGreen");
        ThaumcraftApi.addCrucibleRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 2),
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 2),
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("vinculum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "blankSeal", 1, 2))));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 2))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 3),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "dyeBrown",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'c',
                "dyeBrown",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'e',
                "plateStone",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'g',
                "dyeBrown",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'i',
                "dyeBrown");
        ThaumcraftApi.addCrucibleRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 3),
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 3),
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("vinculum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "blankSeal", 1, 3))));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 3))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 4),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "dyeBlue",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'c',
                "dyeBlue",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'e',
                "plateStone",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'g',
                "dyeBlue",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'i',
                "dyeBlue");
        ThaumcraftApi.addCrucibleRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 4),
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 4),
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("vinculum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "blankSeal", 1, 4))));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 4))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 5),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "dyePurple",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'c',
                "dyePurple",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'e',
                "plateStone",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'g',
                "dyePurple",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'i',
                "dyePurple");
        ThaumcraftApi.addCrucibleRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 5),
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 5),
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("vinculum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "blankSeal", 1, 5))));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 5))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 6),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "dyeCyan",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'c',
                "dyeCyan",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'e',
                "plateStone",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'g',
                "dyeCyan",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'i',
                "dyeCyan");
        ThaumcraftApi.addCrucibleRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 6),
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 6),
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("vinculum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "blankSeal", 1, 6))));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 6))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 7),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "dyeLightGray",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'c',
                "dyeLightGray",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'e',
                "plateStone",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'g',
                "dyeLightGray",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'i',
                "dyeLightGray");
        ThaumcraftApi.addCrucibleRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 7),
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 7),
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("vinculum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "blankSeal", 1, 7))));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 7))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 8),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "dyeGray",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'c',
                "dyeGray",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'e',
                "plateStone",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'g',
                "dyeGray",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'i',
                "dyeGray");
        ThaumcraftApi.addCrucibleRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 8),
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 8),
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("vinculum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "blankSeal", 1, 8))));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 8))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 9),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "dyePink",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'c',
                "dyePink",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'e',
                "plateStone",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'g',
                "dyePink",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'i',
                "dyePink");
        ThaumcraftApi.addCrucibleRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 9),
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 9),
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("vinculum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "blankSeal", 1, 9))));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 9))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 10),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "dyeLime",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'c',
                "dyeLime",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'e',
                "plateStone",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'g',
                "dyeLime",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'i',
                "dyeLime");
        ThaumcraftApi.addCrucibleRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 10),
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 10),
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("vinculum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "blankSeal", 1, 10))));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 10))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 11),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "dyeYellow",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'c',
                "dyeYellow",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'e',
                "plateStone",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'g',
                "dyeYellow",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'i',
                "dyeYellow");
        ThaumcraftApi.addCrucibleRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 11),
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 11),
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("vinculum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "blankSeal", 1, 11))));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 11))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 12),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "dyeLightBlue",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'c',
                "dyeLightBlue",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'e',
                "plateStone",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'g',
                "dyeLightBlue",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'i',
                "dyeLightBlue");
        ThaumcraftApi.addCrucibleRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 12),
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 12),
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("vinculum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "blankSeal", 1, 12))));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 12))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 13),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "dyeMagenta",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'c',
                "dyeMagenta",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'e',
                "plateStone",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'g',
                "dyeMagenta",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'i',
                "dyeMagenta");
        ThaumcraftApi.addCrucibleRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 13),
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 13),
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("vinculum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "blankSeal", 1, 13))));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 13))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 14),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "dyeOrange",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'c',
                "dyeOrange",
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'e',
                "plateStone",
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'g',
                "dyeOrange",
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 4),
                'i',
                "dyeOrange");
        ThaumcraftApi.addCrucibleRecipe(
                "JarsealGTNH",
                getModItem(ThaumicExploration.ID, "jarSeal", 1, 14),
                getModItem(ThaumicExploration.ID, "blankSeal", 1, 14),
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("vinculum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "blankSeal", 1, 14))));
        TCHelper.addResearchPage(
                "JarsealGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ThaumicExploration.ID, "jarSeal", 1, 14))));
        TCHelper.orphanResearch("FLOATCANDLE");
        TCHelper.removeResearch("FLOATCANDLE");
        new ResearchItem(
                "FloatingcandleGTNH",
                "TX",
                new AspectList().add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("pannus"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("volatus"), 3),
                -7,
                -9,
                2,
                getModItem(ThaumicExploration.ID, "floatCandle", 1, 0)).setParents("TXTALLOW").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.FloatingcandleGTNH")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FloatingcandleGTNH",
                getModItem(ThaumicExploration.ID, "floatCandle", 3, 0),
                new AspectList().add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 0),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 0),
                'd',
                "plateInfusedAir",
                'e',
                "plateInfusedAir",
                'f',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "FloatingcandleGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FloatingcandleGTNH",
                getModItem(ThaumicExploration.ID, "floatCandle", 3, 1),
                new AspectList().add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 1),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 1),
                'd',
                "plateInfusedAir",
                'e',
                "plateInfusedAir",
                'f',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "FloatingcandleGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 1, 1))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FloatingcandleGTNH",
                getModItem(ThaumicExploration.ID, "floatCandle", 3, 2),
                new AspectList().add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 2),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 2),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 2),
                'd',
                "plateInfusedAir",
                'e',
                "plateInfusedAir",
                'f',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "FloatingcandleGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 1, 2))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FloatingcandleGTNH",
                getModItem(ThaumicExploration.ID, "floatCandle", 3, 3),
                new AspectList().add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 3),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 3),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 3),
                'd',
                "plateInfusedAir",
                'e',
                "plateInfusedAir",
                'f',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "FloatingcandleGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 1, 3))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FloatingcandleGTNH",
                getModItem(ThaumicExploration.ID, "floatCandle", 3, 4),
                new AspectList().add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 4),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 4),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 4),
                'd',
                "plateInfusedAir",
                'e',
                "plateInfusedAir",
                'f',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "FloatingcandleGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 1, 4))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FloatingcandleGTNH",
                getModItem(ThaumicExploration.ID, "floatCandle", 3, 5),
                new AspectList().add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 5),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 5),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 5),
                'd',
                "plateInfusedAir",
                'e',
                "plateInfusedAir",
                'f',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "FloatingcandleGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 1, 5))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FloatingcandleGTNH",
                getModItem(ThaumicExploration.ID, "floatCandle", 3, 6),
                new AspectList().add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 6),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 6),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 6),
                'd',
                "plateInfusedAir",
                'e',
                "plateInfusedAir",
                'f',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "FloatingcandleGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 1, 6))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FloatingcandleGTNH",
                getModItem(ThaumicExploration.ID, "floatCandle", 3, 7),
                new AspectList().add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 7),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 7),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 7),
                'd',
                "plateInfusedAir",
                'e',
                "plateInfusedAir",
                'f',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "FloatingcandleGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 1, 7))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FloatingcandleGTNH",
                getModItem(ThaumicExploration.ID, "floatCandle", 3, 8),
                new AspectList().add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 8),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 8),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 8),
                'd',
                "plateInfusedAir",
                'e',
                "plateInfusedAir",
                'f',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "FloatingcandleGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 1, 8))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FloatingcandleGTNH",
                getModItem(ThaumicExploration.ID, "floatCandle", 3, 9),
                new AspectList().add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 9),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 9),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 9),
                'd',
                "plateInfusedAir",
                'e',
                "plateInfusedAir",
                'f',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "FloatingcandleGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 1, 9))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FloatingcandleGTNH",
                getModItem(ThaumicExploration.ID, "floatCandle", 3, 10),
                new AspectList().add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 10),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 10),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 10),
                'd',
                "plateInfusedAir",
                'e',
                "plateInfusedAir",
                'f',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "FloatingcandleGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 1, 10))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FloatingcandleGTNH",
                getModItem(ThaumicExploration.ID, "floatCandle", 3, 11),
                new AspectList().add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 11),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 11),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 11),
                'd',
                "plateInfusedAir",
                'e',
                "plateInfusedAir",
                'f',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "FloatingcandleGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 1, 11))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FloatingcandleGTNH",
                getModItem(ThaumicExploration.ID, "floatCandle", 3, 12),
                new AspectList().add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 12),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 12),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 12),
                'd',
                "plateInfusedAir",
                'e',
                "plateInfusedAir",
                'f',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "FloatingcandleGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 1, 12))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FloatingcandleGTNH",
                getModItem(ThaumicExploration.ID, "floatCandle", 3, 13),
                new AspectList().add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 13),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 13),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 13),
                'd',
                "plateInfusedAir",
                'e',
                "plateInfusedAir",
                'f',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "FloatingcandleGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 1, 13))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FloatingcandleGTNH",
                getModItem(ThaumicExploration.ID, "floatCandle", 3, 14),
                new AspectList().add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 14),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 14),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 14),
                'd',
                "plateInfusedAir",
                'e',
                "plateInfusedAir",
                'f',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "FloatingcandleGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 1, 14))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FloatingcandleGTNH",
                getModItem(ThaumicExploration.ID, "floatCandle", 3, 15),
                new AspectList().add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 15),
                'b',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 15),
                'c',
                getModItem(Thaumcraft.ID, "blockCandle", 1, 15),
                'd',
                "plateInfusedAir",
                'e',
                "plateInfusedAir",
                'f',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "FloatingcandleGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "floatCandle", 1, 15))));
        TCHelper.orphanResearch("REPLICATOR");
        TCHelper.removeResearch("REPLICATOR");
        new ResearchItem(
                "ReplicatorGTNH",
                "TX",
                new AspectList().add(Aspect.getAspect("lucrum"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                4,
                -5,
                3,
                getModItem(ThaumicExploration.ID, "replicator", 1, 0))
                        .setParents("DISTILESSENTIA", "TXINFUSION", "TXDISTILESSENTIA", "THAUMIUM").setConcealed()
                        .setPages(new ResearchPage("te.text.REPLICATOR.1"), new ResearchPage("te.text.REPLICATOR.2"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ReplicatorGTNH",
                getModItem(ThaumicExploration.ID, "replicator", 1, 0),
                12,
                new AspectList().add(Aspect.getAspect("fabrico"), 64).add(Aspect.getAspect("instrumentum"), 48)
                        .add(Aspect.getAspect("machina"), 48).add(Aspect.getAspect("ordo"), 32)
                        .add(Aspect.getAspect("praecantatio"), 24).add(Aspect.getAspect("lucrum"), 16),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 2),
                getModItem(Thaumcraft.ID, "blockTable", 1, 15),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Amber),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Gold));
        TCHelper.addResearchPage(
                "ReplicatorGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicExploration.ID, "replicator", 1, 0))));
        ThaumcraftApi.addWarpToResearch("ReplicatorGTNH", 2);
        TCHelper.orphanResearch("TRASHJAR");
        TCHelper.removeResearch("TRASHJAR");
        new ResearchItem(
                "TrashjarGTNH",
                "TX",
                new AspectList().add(Aspect.getAspect("perditio"), 15).add(Aspect.getAspect("vacuos"), 12)
                        .add(Aspect.getAspect("fames"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                5,
                -9,
                3,
                getModItem(ThaumicExploration.ID, "trashJar", 1, 0))
                        .setParents("TXJARVOID", "TXINFUSION", "WARDEDARCANA", "HUNGRYCHEST").setConcealed()
                        .setPages(new ResearchPage("te.text.TRASHJAR.1"), new ResearchPage("te.text.TRASHJAR.2"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "TrashjarGTNH",
                getModItem(ThaumicExploration.ID, "trashJar", 1, 0),
                9,
                new AspectList().add(Aspect.getAspect("alienis"), 16).add(Aspect.getAspect("fames"), 14)
                        .add(Aspect.getAspect("perditio"), 24).add(Aspect.getAspect("vacuos"), 32)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("tenebrae"), 8),
                getModItem(Thaumcraft.ID, "blockJar", 1, 3),
                getModItem(Thaumcraft.ID, "blockChestHungry", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                getModItem(ExtraUtilities.ID, "trashcan", 1, 1),
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2));
        TCHelper.addResearchPage(
                "TrashjarGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicExploration.ID, "trashJar", 1, 0))));
        ThaumcraftApi.addWarpToResearch("TrashjarGTNH", 1);
        TCHelper.orphanResearch("METEORBOOTS");
        TCHelper.removeResearch("METEORBOOTS");
        new ResearchItem(
                "MeteorbootsGTNH",
                "TX",
                new AspectList().add(Aspect.getAspect("iter"), 15).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("volatus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                2,
                -1,
                3,
                getModItem(ThaumicExploration.ID, "bootsMeteor", 1, 0))
                        .setParents("TXBOOTSTRAVELLER", "FOCUSFIRE", "INFUSION").setConcealed()
                        .setPages(new ResearchPage("te.text.METEORBOOTS.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "MeteorbootsGTNH",
                getModItem(ThaumicExploration.ID, "bootsMeteor", 1, 0),
                6,
                new AspectList().add(Aspect.getAspect("ignis"), 32).add(Aspect.getAspect("iter"), 32)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("volatus"), 32)
                        .add(Aspect.getAspect("praecantatio"), 16),
                getModItem(Thaumcraft.ID, "BootsTraveller", 1, wildcard),
                getModItem(Thaumcraft.ID, "FocusFire", 1, 0),
                OrePrefixes.plate.get(Materials.Firestone),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                OrePrefixes.plate.get(Materials.Firestone),
                OrePrefixes.plate.get(Materials.Firestone),
                OrePrefixes.plate.get(Materials.Firestone),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                OrePrefixes.plate.get(Materials.Firestone));
        TCHelper.addResearchPage(
                "MeteorbootsGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicExploration.ID, "bootsMeteor", 1, 0))));
        TCHelper.orphanResearch("COMETBOOTS");
        TCHelper.removeResearch("COMETBOOTS");
        new ResearchItem(
                "CometsbootsGTNH",
                "TX",
                new AspectList().add(Aspect.getAspect("iter"), 15).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("gelum"), 9).add(Aspect.getAspect("motus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                5,
                -3,
                3,
                getModItem(ThaumicExploration.ID, "bootsComet", 1, 0))
                        .setParents("TXBOOTSTRAVELLER", "FOCUSFROST", "INFUSION").setConcealed()
                        .setPages(new ResearchPage("te.text.COMETBOOTS.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "CometsbootsGTNH",
                getModItem(ThaumicExploration.ID, "bootsComet", 1, 0),
                6,
                new AspectList().add(Aspect.getAspect("gelum"), 32).add(Aspect.getAspect("iter"), 32)
                        .add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("motus"), 32)
                        .add(Aspect.getAspect("praecantatio"), 16),
                getModItem(Thaumcraft.ID, "BootsTraveller", 1, wildcard),
                getModItem(Thaumcraft.ID, "FocusFrost", 1, 0),
                getModItem(BiomesOPlenty.ID, "hardIce", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                getModItem(BiomesOPlenty.ID, "hardIce", 1, 0),
                getModItem(BiomesOPlenty.ID, "hardIce", 1, 0),
                getModItem(BiomesOPlenty.ID, "hardIce", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                getModItem(BiomesOPlenty.ID, "hardIce", 1, 0));
        TCHelper.addResearchPage(
                "CometsbootsGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicExploration.ID, "bootsComet", 1, 0))));
        TCHelper.orphanResearch("SOULBRAZIER");
        TCHelper.removeResearch("SOULBRAZIER");
        new ResearchItem(
                "SoulbraizerGTNH",
                "TX",
                new AspectList().add(Aspect.getAspect("auram"), 15).add(Aspect.getAspect("alienis"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("mortuus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                -6,
                -10,
                3,
                getModItem(ThaumicExploration.ID, "soulBrazier", 1, 0))
                        .setParents("TXTALLOW", "ELDRITCHMINOR", "VOIDMETAL", "INFUSION", "SANESOAP").setConcealed()
                        .setPages(new ResearchPage("te.text.SOULBRAZIER.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SoulbraizerGTNH",
                getModItem(ThaumicExploration.ID, "soulBrazier", 1, 0),
                16,
                new AspectList().add(Aspect.getAspect("auram"), 64).add(Aspect.getAspect("mortuus"), 48)
                        .add(Aspect.getAspect("tenebrae"), 48).add(Aspect.getAspect("alienis"), 32)
                        .add(Aspect.getAspect("praecantatio"), 16),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                getModItem(Thaumcraft.ID, "ItemSanitySoap", 1, 0),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                OrePrefixes.ingot.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                OrePrefixes.ingot.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                OrePrefixes.ingot.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 7),
                getModItem(Thaumcraft.ID, "ItemSanitySoap", 1, 0));
        TCHelper.addResearchPage(
                "SoulbraizerGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicExploration.ID, "soulBrazier", 1, 0))));
        TCHelper.orphanResearch("URN");
        TCHelper.removeResearch("URN");
        new ResearchItem(
                "UrnGTNH",
                "TX",
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("vacuos"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("lucrum"), 3),
                3,
                -10,
                3,
                getModItem(ThaumicExploration.ID, "everfullUrn", 1, 0)).setParents("TXINFUSION", "ARCANEEAR")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.UrnGTNH")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "UrnGTNH",
                getModItem(ThaumicExploration.ID, "everfullUrn", 1, 0),
                9,
                new AspectList().add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("praecantatio"), 48)
                        .add(Aspect.getAspect("vacuos"), 32).add(Aspect.getAspect("alienis"), 32)
                        .add(Aspect.getAspect("lucrum"), 16),
                getModItem(Minecraft.ID, "flower_pot", 1, 0),
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                getModItem(Minecraft.ID, "netherbrick", 1, 0),
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                OrePrefixes.plate.get(Materials.Titanium),
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                getModItem(Minecraft.ID, "netherbrick", 1, 0),
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                getModItem(Minecraft.ID, "brick", 1, 0),
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                OrePrefixes.plate.get(Materials.Titanium),
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                getModItem(Minecraft.ID, "brick", 1, 0));
        TCHelper.addResearchPage(
                "UrnGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicExploration.ID, "everfullUrn", 1, 0))));
        TCHelper.orphanResearch("BURN");
        TCHelper.removeResearch("BURN");
        new ResearchItem(
                "BurnGTNH",
                "TX",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("vacuos"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("lucrum"), 3),
                4,
                -11,
                3,
                getModItem(ThaumicExploration.ID, "everburnUrn", 1, 0)).setParents("UrnGTNH").setConcealed()
                        .setPages(new ResearchPage("te.text.BURN.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "BurnGTNH",
                getModItem(ThaumicExploration.ID, "everburnUrn", 1, 0),
                9,
                new AspectList().add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("praecantatio"), 48)
                        .add(Aspect.getAspect("vacuos"), 32).add(Aspect.getAspect("alienis"), 32)
                        .add(Aspect.getAspect("lucrum"), 16),
                getModItem(Minecraft.ID, "flower_pot", 1, 0),
                getModItem(Minecraft.ID, "lava_bucket", 1, 0),
                getModItem(Minecraft.ID, "netherbrick", 1, 0),
                getModItem(Minecraft.ID, "lava_bucket", 1, 0),
                ItemList.Casing_Coil_TungstenSteel.get(1L),
                OrePrefixes.plate.get(Materials.Titanium),
                ItemList.Casing_Coil_TungstenSteel.get(1L),
                getModItem(Minecraft.ID, "lava_bucket", 1, 0),
                getModItem(Minecraft.ID, "netherbrick", 1, 0),
                getModItem(Minecraft.ID, "lava_bucket", 1, 0),
                getModItem(Minecraft.ID, "brick", 1, 0),
                getModItem(Minecraft.ID, "lava_bucket", 1, 0),
                ItemList.Casing_Coil_TungstenSteel.get(1L),
                OrePrefixes.plate.get(Materials.Titanium),
                ItemList.Casing_Coil_TungstenSteel.get(1L),
                getModItem(Minecraft.ID, "lava_bucket", 1, 0),
                getModItem(Minecraft.ID, "brick", 1, 0));
        TCHelper.addResearchPage(
                "BurnGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicExploration.ID, "everburnUrn", 1, 0))));
        TCHelper.orphanResearch("CAP_SOJOURNER");
        TCHelper.removeResearch("CAP_SOJOURNER");
        new ResearchItem(
                "CAP_SOJOURNER",
                "TX",
                new AspectList().add(Aspect.getAspect("auram"), 15).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("instrumentum"), 3),
                -5,
                -8,
                3,
                getModItem(ThaumicExploration.ID, "sojournerCapUncharged", 1, 0))
                        .setParents("TXCAP_thaumium", "WANDPED").setConcealed()
                        .setPages(new ResearchPage("te.text.CAP_SOJOURNER.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_SOJOURNER",
                getModItem(ThaumicExploration.ID, "sojournerCapUncharged", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 35).add(Aspect.getAspect("perditio"), 35)
                        .add(Aspect.getAspect("ordo"), 35).add(Aspect.getAspect("aqua"), 35),
                "abc",
                "def",
                "ghi",
                'a',
                "screwDiamond",
                'b',
                "plateLapis",
                'c',
                "screwDiamond",
                'd',
                "plateLapis",
                'e',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                'f',
                "plateLapis",
                'g',
                "screwDiamond",
                'h',
                "plateLapis",
                'i',
                "screwDiamond");
        TCHelper.addResearchPage(
                "CAP_SOJOURNER",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "sojournerCapUncharged", 1, 0))));
        TCHelper.addInfusionCraftingRecipe(
                "CAP_SOJOURNER",
                getModItem(ThaumicExploration.ID, "sojournerCap", 1, 0),
                6,
                new AspectList().add(Aspect.getAspect("auram"), 48).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("permutatio"), 24).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("ordo"), 16),
                getModItem(ThaumicExploration.ID, "sojournerCapUncharged", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.dust.get(Materials.Diamond),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.dust.get(Materials.Diamond),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                OrePrefixes.dust.get(Materials.Diamond));
        TCHelper.addResearchPage(
                "CAP_SOJOURNER",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicExploration.ID, "sojournerCap", 1, 0))));
        TCHelper.orphanResearch("CAP_MECHANIST");
        TCHelper.removeResearch("CAP_MECHANIST");
        new ResearchItem(
                "CAP_MECHANIST",
                "TX",
                new AspectList().add(Aspect.getAspect("auram"), 15).add(Aspect.getAspect("machina"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("instrumentum"), 3),
                -9,
                -6,
                3,
                getModItem(ThaumicExploration.ID, "mechanistCapUncharged", 1, 0))
                        .setParents("TXCAP_thaumium", "NODETAPPER2").setConcealed()
                        .setPages(new ResearchPage("te.text.CAP_MECHANIST.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_MECHANIST",
                getModItem(ThaumicExploration.ID, "mechanistCapUncharged", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 35).add(Aspect.getAspect("perditio"), 35)
                        .add(Aspect.getAspect("ordo"), 35).add(Aspect.getAspect("aqua"), 35),
                "abc",
                "def",
                "ghi",
                'a',
                "screwDiamond",
                'b',
                "plateRedstone",
                'c',
                "screwDiamond",
                'd',
                getModItem(Minecraft.ID, "repeater", 1, 0),
                'e',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                'f',
                getModItem(Minecraft.ID, "repeater", 1, 0),
                'g',
                "screwDiamond",
                'h',
                getModItem(Minecraft.ID, "piston", 1, 0),
                'i',
                "screwDiamond");
        TCHelper.addResearchPage(
                "CAP_MECHANIST",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "mechanistCapUncharged", 1, 0))));
        TCHelper.addInfusionCraftingRecipe(
                "CAP_MECHANIST",
                getModItem(ThaumicExploration.ID, "mechanistCap", 1, 0),
                6,
                new AspectList().add(Aspect.getAspect("auram"), 48).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("machina"), 24).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("ordo"), 16),
                getModItem(ThaumicExploration.ID, "mechanistCapUncharged", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Minecraft.ID, "redstone", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Minecraft.ID, "redstone", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Minecraft.ID, "redstone", 1, 0));
        TCHelper.addResearchPage(
                "CAP_MECHANIST",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicExploration.ID, "mechanistCap", 1, 0))));
        TCHelper.orphanResearch("STABILIZERBELT");
        TCHelper.removeResearch("STABILIZERBELT");
        new ResearchItem(
                "StabilizerbeltGTNH",
                "TX",
                new AspectList().add(Aspect.getAspect("ordo"), 18).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("iter"), 12).add(Aspect.getAspect("superbia"), 9)
                        .add(Aspect.getAspect("tutamen"), 6).add(Aspect.getAspect("praecantatio"), 3),
                1,
                -10,
                3,
                getModItem(ThaumicExploration.ID, "stabilizerBelt", 1, 0)).setParents("TXHOVERHARNESS", "TXINFUSION")
                        .setConcealed().setPages(new ResearchPage("te.text.STABILIZERBELT.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "StabilizerbeltGTNH",
                getModItem(ThaumicExploration.ID, "stabilizerBelt", 1, 0),
                4,
                new AspectList().add(Aspect.getAspect("ordo"), 48).add(Aspect.getAspect("terra"), 32)
                        .add(Aspect.getAspect("iter"), 12).add(Aspect.getAspect("superbia"), 24)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("praecantatio"), 16),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 2),
                ItemList.Electric_Piston_LV.get(1L),
                OrePrefixes.springSmall.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.springSmall.get(Materials.Thaumium),
                OrePrefixes.lens.get(Materials.Diamond),
                OrePrefixes.springSmall.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.springSmall.get(Materials.Thaumium));
        TCHelper.addResearchPage(
                "StabilizerbeltGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ThaumicExploration.ID, "stabilizerBelt", 1, 0))));
        TCHelper.setResearchAspects(
                "ENCHBINDING",
                new AspectList().add(Aspect.getAspect("vinculum"), 15).add(Aspect.getAspect("perditio"), 12)
                        .add(Aspect.getAspect("iter"), 9).add(Aspect.getAspect("superbia"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("ENCHBINDING", 3);
        ThaumcraftApi.addWarpToResearch("ENCHBINDING", 1);
        TCHelper.setResearchAspects(
                "ENCHNIGHTVISION",
                new AspectList().add(Aspect.getAspect("sensus"), 15).add(Aspect.getAspect("lux"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("ignis"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("ENCHNIGHTVISION", 3);
        ThaumcraftApi.addWarpToResearch("ENCHNIGHTVISION", 1);
        TCHelper.setResearchAspects(
                "ENCHDISARM",
                new AspectList().add(Aspect.getAspect("vinculum"), 15).add(Aspect.getAspect("limus"), 12)
                        .add(Aspect.getAspect("telum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("ENCHDISARM", 3);
        ThaumcraftApi.addWarpToResearch("ENCHDISARM", 1);
        TCHelper.orphanResearch("FLESHCURE");
        TCHelper.removeResearch("FLESHCURE");
        new ResearchItem(
                "FleshcureGTNH",
                "TX",
                new AspectList().add(Aspect.getAspect("pannus"), 15).add(Aspect.getAspect("tutamen"), 12)
                        .add(Aspect.getAspect("corpus"), 9).add(Aspect.getAspect("permutatio"), 6)
                        .add(Aspect.getAspect("alienis"), 3),
                -4,
                -10,
                2,
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0)).setParents("TXTALLOW").setConcealed()
                        .setPages(new ResearchPage("te.text.FLESHCURE.1")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "FleshcureGTNH",
                getModItem(Minecraft.ID, "leather", 1, 0),
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0),
                new AspectList().add(Aspect.getAspect("corpus"), 4).add(Aspect.getAspect("pannus"), 4)
                        .add(Aspect.getAspect("permutatio"), 4));
        TCHelper.addResearchPage(
                "FleshcureGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(Minecraft.ID, "leather", 1, 0))));
        TCHelper.orphanResearch("BRAINCURE");
        TCHelper.removeResearch("BRAINCURE");
        new ResearchItem(
                "BraincureGTNH",
                "TX",
                new AspectList().add(Aspect.getAspect("ordo"), 18).add(Aspect.getAspect("cognitio"), 15)
                        .add(Aspect.getAspect("humanus"), 12).add(Aspect.getAspect("exanimis"), 9)
                        .add(Aspect.getAspect("alienis"), 6).add(Aspect.getAspect("permutatio"), 3),
                -2,
                -8,
                3,
                getModItem(ThaumicExploration.ID, "pureZombieBrain", 1, 0))
                        .setParents("TXINFUSION", "JARBRAIN", "FleshcureGTNH").setConcealed()
                        .setPages(new ResearchPage("te.text.BRAINCURE.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "BraincureGTNH",
                getModItem(ThaumicExploration.ID, "pureZombieBrain", 1, 0),
                5,
                new AspectList().add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("sano"), 12)
                        .add(Aspect.getAspect("humanus"), 12).add(Aspect.getAspect("alienis"), 24)
                        .add(Aspect.getAspect("cognitio"), 16).add(Aspect.getAspect("praecantatio"), 8),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                getModItem(Minecraft.ID, "water_bucket", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Minecraft.ID, "potion", 1, 8264),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Minecraft.ID, "golden_apple", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14));
        TCHelper.addResearchPage(
                "BraincureGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ThaumicExploration.ID, "pureZombieBrain", 1, 0))));
        TCHelper.orphanResearch("TALISMANFOOD");
        TCHelper.removeResearch("TALISMANFOOD");
        new ResearchItem(
                "TalismanfoodtGTNH",
                "TX",
                new AspectList().add(Aspect.getAspect("fames"), 18).add(Aspect.getAspect("pannus"), 15)
                        .add(Aspect.getAspect("messis"), 12).add(Aspect.getAspect("sano"), 9)
                        .add(Aspect.getAspect("permutatio"), 6).add(Aspect.getAspect("ordo"), 3),
                -1,
                -11,
                3,
                getModItem(ThaumicExploration.ID, "talismanFood", 1, 0)).setParents("FleshcureGTNH", "TXINFUSION")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.TalismanfoodtGTNH"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "TalismanfoodtGTNH",
                getModItem(ThaumicExploration.ID, "talismanFood", 1, 0),
                6,
                new AspectList().add(Aspect.getAspect("fames"), 64).add(Aspect.getAspect("pannus"), 48)
                        .add(Aspect.getAspect("messis"), 24).add(Aspect.getAspect("sano"), 24)
                        .add(Aspect.getAspect("permutatio"), 32).add(Aspect.getAspect("ordo"), 16),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                OrePrefixes.gemExquisite.get(Materials.Ruby),
                getModItem(PamsHarvestCraft.ID, "heartybreakfastItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "rainbowcurryItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "supremepizzaItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "sausageinbreadItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "beefwellingtonItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "epicbaconItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "meatfeastpizzaItem", 1, 0),
                getModItem(PamsHarvestCraft.ID, "delightedmealItem", 1, 0));
        TCHelper.addResearchPage(
                "TalismanfoodtGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicExploration.ID, "talismanFood", 1, 0))));
        TCHelper.addResearchPrereq("THINKTANK", "BraincureGTNH", false);
        ThaumcraftApi.addWarpToResearch("THINKTANK", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TalismanfoodtGTNH",
                getModItem(ThaumicExploration.ID, "taintBerry", 1, 0),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("aqua"), 20)
                        .add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("perditio"), 25),
                "tft",
                "gbg",
                "ggg",
                't',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 12),
                'g',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 11),
                'b',
                getModItem(Natura.ID, "berry.nether", 1),
                'f',
                getModItem(ForbiddenMagic.ID, "TaintFruit", 1));
        TCHelper.orphanResearch("DREAMCATCHER");
        TCHelper.removeResearch("DREAMCATCHER");
        new ResearchItem(
                "DreamcatcherGTNH",
                "TX",
                new AspectList().add(Aspect.getAspect("vitium"), 15).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                -7,
                2,
                3,
                getModItem(ThaumicExploration.ID, "charmNoTaint", 1, 0)).setParents("TAINTBASICS").setConcealed()
                        .setPages(new ResearchPage("te.text.DREAMCATCHER.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DreamcatcherGTNH",
                getModItem(ThaumicExploration.ID, "charmNoTaint", 1, 0),
                new AspectList().add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("perditio"), 25)
                        .add(Aspect.getAspect("terra"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "WandRod", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 12),
                'c',
                getModItem(Thaumcraft.ID, "WandRod", 1, 0),
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 11),
                'e',
                getModItem(Minecraft.ID, "leather", 1, 0),
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 11),
                'g',
                getModItem(Minecraft.ID, "feather", 1, 0),
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 12),
                'i',
                getModItem(Minecraft.ID, "feather", 1, 0));
        TCHelper.addResearchPage(
                "DreamcatcherGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "charmNoTaint", 1, 0))));
        TCHelper.orphanResearch("CRUCSOULS");
        TCHelper.removeResearch("CRUCSOULS");
        new ResearchItem(
                "CrucsoulGTNH",
                "TX",
                new AspectList().add(Aspect.getAspect("spiritus"), 18).add(Aspect.getAspect("mortuus"), 15)
                        .add(Aspect.getAspect("fames"), 12).add(Aspect.getAspect("exanimis"), 9)
                        .add(Aspect.getAspect("telum"), 6).add(Aspect.getAspect("alienis"), 3),
                5,
                -7,
                3,
                getModItem(ThaumicExploration.ID, "crucibleSouls", 1, 0)).setParents("TXDISTILESSENTIA")
                        .setParentsHidden("BraincureGTNH").registerResearchItem();
        TCHelper.addResearchPrereq("CrucsoulGTNH", "TXINFUSION", false);
        ResearchCategories.getResearch("CrucsoulGTNH").setConcealed();
        TCHelper.addResearchPage("CrucsoulGTNH", new ResearchPage("te.text.CRUCSOULS.1"));
        TCHelper.addResearchPage("CrucsoulGTNH", new ResearchPage("te.text.CRUCSOULS.2"));
        TCHelper.addInfusionCraftingRecipe(
                "CrucsoulGTNH",
                getModItem(ThaumicExploration.ID, "crucibleSouls", 1, 0),
                8,
                new AspectList().add(Aspect.getAspect("exanimis"), 24).add(Aspect.getAspect("fames"), 48)
                        .add(Aspect.getAspect("spiritus"), 32).add(Aspect.getAspect("mortuus"), 64)
                        .add(Aspect.getAspect("telum"), 24).add(Aspect.getAspect("vinculum"), 16)
                        .add(Aspect.getAspect("alienis"), 8),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 0),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 0),
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0),
                getModItem(Minecraft.ID, "soul_sand", 1, 0),
                getModItem(Minecraft.ID, "slime_ball", 1, 0),
                getModItem(Minecraft.ID, "soul_sand", 1, 0),
                getModItem(Minecraft.ID, "ghast_tear", 1, 0),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 1),
                getModItem(Minecraft.ID, "blaze_rod", 1, 0),
                getModItem(Minecraft.ID, "soul_sand", 1, 0),
                getModItem(Minecraft.ID, "magma_cream", 1, 0),
                getModItem(Minecraft.ID, "soul_sand", 1, 0),
                getModItem(Minecraft.ID, "bone", 1, 0));
        TCHelper.addResearchPage(
                "CrucsoulGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ThaumicExploration.ID, "crucibleSouls", 1, 0))));
        ThaumcraftApi.addWarpToResearch("CrucsoulGTNH", 4);
        // SPAWNER

        TCHelper.addInfusionCraftingRecipe(
                "CrucsoulGTNH",
                getModItem(EnderIO.ID, "itemBrokenSpawner", 1, 0),
                8,
                new AspectList().add(Aspect.getAspect("exanimis"), 34).add(Aspect.getAspect("fames"), 18)
                        .add(Aspect.getAspect("spiritus"), 62).add(Aspect.getAspect("mortuus"), 64)
                        .add(Aspect.getAspect("telum"), 24).add(Aspect.getAspect("vinculum"), 46)
                        .add(Aspect.getAspect("alienis"), 28),
                getModItem(ThaumicExploration.ID, "crucibleSouls", 1, 0),
                getModItem(Botania.ID, "cocoon", 1, 0),
                getModItem(EnderIO.ID, "itemMaterial", 1, 9),
                getModItem(EnderIO.ID, "itemMaterial", 1, 17),
                OrePrefixes.frameGt.get(Materials.Shadow),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4),
                getModItem(EnderIO.ID, "itemMaterial", 1, 9),
                getModItem(Botania.ID, "cocoon", 1, 0),
                getModItem(EnderIO.ID, "itemMaterial", 1, 9),
                getModItem(EnderIO.ID, "itemMaterial", 1, 16),
                OrePrefixes.frameGt.get(Materials.Shadow),
                getModItem(EnderIO.ID, "itemFrankenSkull", 1, 4),
                getModItem(EnderIO.ID, "itemMaterial", 1, 9));
        TCHelper.addResearchPage(
                "CrucsoulGTNH",
                new ResearchPage(
                        Objects.requireNonNull(
                                TCHelper.findInfusionRecipe(getModItem(EnderIO.ID, "itemBrokenSpawner", 1, 0)))));

        TCHelper.addResearchPrereq("TENTACLERING", "BraincureGTNH", true);
        TCHelper.setResearchAspects(
                "TENTACLERING",
                new AspectList().add(Aspect.getAspect("vitium"), 15).add(Aspect.getAspect("telum"), 12)
                        .add(Aspect.getAspect("tutamen"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("TENTACLERING", 3);
        ThaumcraftApi.addWarpToResearch("TENTACLERING", 2);
        TCHelper.orphanResearch("ROD_TRANSMUTATION");
        TCHelper.removeResearch("ROD_TRANSMUTATION");
        new ResearchItem(
                "ROD_TRANSMUTATION",
                "TX",
                new AspectList().add(Aspect.getAspect("permutatio"), 15).add(Aspect.getAspect("instrumentum"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                -1,
                -1,
                3,
                getModItem(ThaumicExploration.ID, "transmutationCore", 1, 0))
                        .setParents("TXROD_greatwood", "TXBASICARTIFACE").setParentsHidden("TXINFUSION").setConcealed()
                        .setPages(new ResearchPage("te.text.ROD_TRANSMUTATION.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ROD_TRANSMUTATION",
                getModItem(ThaumicExploration.ID, "transmutationCore", 1, 0),
                8,
                new AspectList().add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("auram"), 24).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("arbor"), 8).add(Aspect.getAspect("alienis"), 8),
                getModItem(Thaumcraft.ID, "WandRod", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6));
        TCHelper.addResearchPage(
                "ROD_TRANSMUTATION",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ThaumicExploration.ID, "transmutationCore", 1, 0))));
        TCHelper.orphanResearch("ROD_TRANSMUTATION_staff");
        TCHelper.removeResearch("ROD_TRANSMUTATION_staff");
        new ResearchItem(
                "ROD_TRANSMUTATION_staff",
                "TX",
                new AspectList().add(Aspect.getAspect("permutatio"), 18).add(Aspect.getAspect("instrumentum"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("arbor"), 3),
                0,
                0,
                3,
                getModItem(ThaumicExploration.ID, "transmutationStaffCore", 1, 0))
                        .setParents("TXROD_greatwood_staff", "ROD_TRANSMUTATION", "TXBASICARTIFACE").setConcealed()
                        .setPages(new ResearchPage("te.text.ROD_TRANSMUTATION_staff.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_TRANSMUTATION_staff",
                getModItem(ThaumicExploration.ID, "transmutationStaffCore", 1, 0),
                new AspectList().add(Aspect.getAspect("ordo"), 85).add(Aspect.getAspect("perditio"), 85)
                        .add(Aspect.getAspect("terra"), 85).add(Aspect.getAspect("aqua"), 85)
                        .add(Aspect.getAspect("ignis"), 85).add(Aspect.getAspect("aer"), 85),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'e',
                getModItem(ThaumicExploration.ID, "transmutationCore", 1, 0),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'g',
                getModItem(ThaumicExploration.ID, "transmutationCore", 1, 0),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.addResearchPage(
                "ROD_TRANSMUTATION_staff",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "transmutationStaffCore", 1, 0))));
        TCHelper.orphanResearch("ROD_AMBER");
        TCHelper.removeResearch("ROD_AMBER");
        new ResearchItem(
                "ROD_AMBER",
                "TX",
                new AspectList().add(Aspect.getAspect("auram"), 15).add(Aspect.getAspect("instrumentum"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("vinculum"), 6)
                        .add(Aspect.getAspect("vitreus"), 3),
                -5,
                -1,
                3,
                getModItem(ThaumicExploration.ID, "amberCore", 1, 0)).setParents("TXROD_greatwood").setConcealed()
                        .setPages(new ResearchPage("te.text.ROD_AMBER.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ROD_AMBER",
                getModItem(ThaumicExploration.ID, "amberCore", 1, 0),
                8,
                new AspectList().add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("vinculum"), 32)
                        .add(Aspect.getAspect("auram"), 24).add(Aspect.getAspect("vitreus"), 16)
                        .add(Aspect.getAspect("arbor"), 8).add(Aspect.getAspect("alienis"), 8),
                OrePrefixes.stick.get(Materials.Amber),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 6));
        TCHelper.addResearchPage(
                "ROD_AMBER",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ThaumicExploration.ID, "amberCore", 1, 0))));
        TCHelper.orphanResearch("ROD_AMBER_staff");
        TCHelper.removeResearch("ROD_AMBER_staff");
        new ResearchItem(
                "ROD_AMBER_staff",
                "TX",
                new AspectList().add(Aspect.getAspect("vinculum"), 18).add(Aspect.getAspect("instrumentum"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("alienis"), 12)
                        .add(Aspect.getAspect("auram"), 6),
                -6,
                0,
                3,
                getModItem(ThaumicExploration.ID, "amberStaffCore", 1, 0)).setParents("TXROD_greatwood_staff")
                        .setParentsHidden("TXBASICARTIFACE").setConcealed()
                        .setPages(new ResearchPage("te.text.ROD_AMBER_staff.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_AMBER_staff",
                getModItem(ThaumicExploration.ID, "amberStaffCore", 1, 0),
                new AspectList().add(Aspect.getAspect("ordo"), 85).add(Aspect.getAspect("perditio"), 85)
                        .add(Aspect.getAspect("terra"), 85).add(Aspect.getAspect("aqua"), 85)
                        .add(Aspect.getAspect("ignis"), 85).add(Aspect.getAspect("aer"), 85),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                'd',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                'e',
                getModItem(ThaumicExploration.ID, "amberCore", 1, 0),
                'f',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                'g',
                getModItem(ThaumicExploration.ID, "amberCore", 1, 0),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5));
        TCHelper.addResearchPage(
                "ROD_AMBER_staff",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ThaumicExploration.ID, "amberStaffCore", 1, 0))));
        TCHelper.orphanResearch("ROD_NECROMANCER_staff");
        TCHelper.removeResearch("ROD_NECROMANCER_staff");
        new ResearchItem(
                "ROD_NECROMANCER_staff",
                "TX",
                new AspectList().add(Aspect.getAspect("mortuus"), 21).add(Aspect.getAspect("instrumentum"), 18)
                        .add(Aspect.getAspect("perditio"), 15).add(Aspect.getAspect("auram"), 12)
                        .add(Aspect.getAspect("spiritus"), 9).add(Aspect.getAspect("exanimis"), 6)
                        .add(Aspect.getAspect("cognitio"), 3),
                -3,
                1,
                3,
                getModItem(ThaumicExploration.ID, "necroStaffCore", 1, 0)).setParents("TXROD_greatwood_staff")
                        .setParentsHidden("BraincureGTNH").setConcealed()
                        .setPages(new ResearchPage("te.text.ROD_NECROMANCER_staff.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ROD_NECROMANCER_staff",
                getModItem(ThaumicExploration.ID, "necroStaffCore", 1, 0),
                12,
                new AspectList().add(Aspect.getAspect("mortuus"), 64).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("perditio"), 48).add(Aspect.getAspect("auram"), 32)
                        .add(Aspect.getAspect("spiritus"), 32).add(Aspect.getAspect("exanimis"), 16)
                        .add(Aspect.getAspect("cognitio"), 16),
                getModItem(Thaumcraft.ID, "WandRod", 1, 57),
                getModItem(Minecraft.ID, "skull", 1, 1),
                getModItem(ThaumicExploration.ID, "pureZombieBrain", 1, 0),
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0),
                getModItem(Minecraft.ID, "bone", 1, 0),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                getModItem(ThaumicExploration.ID, "pureZombieBrain", 1, 0),
                getModItem(Minecraft.ID, "rotten_flesh", 1, 0),
                getModItem(Minecraft.ID, "bone", 1, 0));
        TCHelper.addResearchPage(
                "ROD_NECROMANCER_staff",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ThaumicExploration.ID, "necroStaffCore", 1, 0))));
        ThaumcraftApi.addWarpToResearch("ROD_NECROMANCER_staff", 3);
        TCHelper.refreshResearchPages("ENCHBINDING");
        TCHelper.refreshResearchPages("ENCHNIGHTVISION");
        TCHelper.refreshResearchPages("ENCHDISARM");
    }
}
