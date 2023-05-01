package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.Mods;
import gregtech.api.util.GT_ModHandler;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptThaumcraft implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Thaumcraft";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Mods.Thaumcraft.ID,
                Mods.ThaumicBases.ID,
                Mods.TinkerConstruct.ID,
                Mods.RandomThings.ID,
                Mods.BiomesOPlenty.ID,
                Mods.PamsHarvestCraft.ID,
                Mods.ProjectRedIntegration.ID,
                Mods.Railcraft.ID,
                Mods.Backpack.ID,
                Mods.TwilightForest.ID,
                Mods.Natura.ID,
                Mods.BuildCraftFactory.ID,
                Mods.IguanaTweaksTinkerConstruct.ID,
                Mods.Forestry.ID,
                Mods.IndustrialCraft2.ID,
                Mods.GalacticraftCore.ID,
                Mods.ForbiddenMagic.ID,
                Mods.GalacticraftMars.ID,
                Mods.MalisisDoors.ID,
                Mods.ExtraUtilities.ID);
    }

    @Override
    public void loadRecipes() {

        basics();
        thaumaturgy();
        alchemy();
        artifice();
        golemancy();
        eldritch();
        aspectAdds();

    }

    private void basics() {
        // BASICS

        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockTable", 1, 14, missing));
        TCHelper.clearPages("PLANTS");
        TCHelper.addResearchPage("PLANTS", new ResearchPage("tc.research_page.PLANTS.1"));
        TCHelper.addResearchPage(
                "PLANTS",
                new ResearchPage(
                        TCHelper.findCraftingRecipe(getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing))));
        TCHelper.addResearchPage("PLANTS", new ResearchPage("tc.research_page.PLANTS.2"));
        TCHelper.addResearchPage(
                "PLANTS",
                new ResearchPage(
                        TCHelper.findCraftingRecipe(getModItem("Thaumcraft", "blockWoodenDevice", 1, 7, missing))));
        TCHelper.addResearchPage("PLANTS", new ResearchPage("tc.research_page.PLANTS.3"));
        TCHelper.addResearchPage("PLANTS", new ResearchPage("tc.research_page.PLANTS.4"));
        TCHelper.addResearchPage("PLANTS", new ResearchPage("tc.research_page.PLANTS.5"));
        TCHelper.addResearchPage("PLANTS", new ResearchPage("tc.research_page.PLANTS.6"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ASPECTS",
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "ItemShard", 1, 0, missing),
                'b',
                getModItem("Thaumcraft", "ItemShard", 1, 0, missing),
                'c',
                getModItem("Thaumcraft", "ItemShard", 1, 0, missing),
                'e',
                getModItem("Thaumcraft", "ItemShard", 1, 0, missing),
                'g',
                getModItem("Thaumcraft", "ItemShard", 1, 0, missing),
                'h',
                getModItem("Thaumcraft", "ItemShard", 1, 0, missing),
                'i',
                getModItem("Thaumcraft", "ItemShard", 1, 0, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ASPECTS",
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("ignis"), 10).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "ItemShard", 1, 1, missing),
                'b',
                getModItem("Thaumcraft", "ItemShard", 1, 1, missing),
                'c',
                getModItem("Thaumcraft", "ItemShard", 1, 1, missing),
                'e',
                getModItem("Thaumcraft", "ItemShard", 1, 1, missing),
                'g',
                getModItem("Thaumcraft", "ItemShard", 1, 1, missing),
                'h',
                getModItem("Thaumcraft", "ItemShard", 1, 1, missing),
                'i',
                getModItem("Thaumcraft", "ItemShard", 1, 1, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ASPECTS",
                getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("aqua"), 10)
                        .add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "ItemShard", 1, 2, missing),
                'b',
                getModItem("Thaumcraft", "ItemShard", 1, 2, missing),
                'c',
                getModItem("Thaumcraft", "ItemShard", 1, 2, missing),
                'e',
                getModItem("Thaumcraft", "ItemShard", 1, 2, missing),
                'g',
                getModItem("Thaumcraft", "ItemShard", 1, 2, missing),
                'h',
                getModItem("Thaumcraft", "ItemShard", 1, 2, missing),
                'i',
                getModItem("Thaumcraft", "ItemShard", 1, 2, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ASPECTS",
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "ItemShard", 1, 3, missing),
                'b',
                getModItem("Thaumcraft", "ItemShard", 1, 3, missing),
                'c',
                getModItem("Thaumcraft", "ItemShard", 1, 3, missing),
                'e',
                getModItem("Thaumcraft", "ItemShard", 1, 3, missing),
                'g',
                getModItem("Thaumcraft", "ItemShard", 1, 3, missing),
                'h',
                getModItem("Thaumcraft", "ItemShard", 1, 3, missing),
                'i',
                getModItem("Thaumcraft", "ItemShard", 1, 3, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ASPECTS",
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "ItemShard", 1, 4, missing),
                'b',
                getModItem("Thaumcraft", "ItemShard", 1, 4, missing),
                'c',
                getModItem("Thaumcraft", "ItemShard", 1, 4, missing),
                'e',
                getModItem("Thaumcraft", "ItemShard", 1, 4, missing),
                'g',
                getModItem("Thaumcraft", "ItemShard", 1, 4, missing),
                'h',
                getModItem("Thaumcraft", "ItemShard", 1, 4, missing),
                'i',
                getModItem("Thaumcraft", "ItemShard", 1, 4, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ASPECTS",
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "ItemShard", 1, 5, missing),
                'b',
                getModItem("Thaumcraft", "ItemShard", 1, 5, missing),
                'c',
                getModItem("Thaumcraft", "ItemShard", 1, 5, missing),
                'e',
                getModItem("Thaumcraft", "ItemShard", 1, 5, missing),
                'g',
                getModItem("Thaumcraft", "ItemShard", 1, 5, missing),
                'h',
                getModItem("Thaumcraft", "ItemShard", 1, 5, missing),
                'i',
                getModItem("Thaumcraft", "ItemShard", 1, 5, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ASPECTS",
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("ignis"), 10).add(Aspect.getAspect("aqua"), 10)
                        .add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "ItemShard", 1, 0, missing),
                'b',
                getModItem("Thaumcraft", "ItemShard", 1, 1, missing),
                'c',
                getModItem("Thaumcraft", "ItemShard", 1, 2, missing),
                'd',
                getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                'e',
                getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                'f',
                getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                'g',
                getModItem("Thaumcraft", "ItemShard", 1, 3, missing),
                'h',
                getModItem("Thaumcraft", "ItemShard", 1, 4, missing),
                'i',
                getModItem("Thaumcraft", "ItemShard", 1, 5, missing));
        TCHelper.clearPages("ORE");
        TCHelper.addResearchPage("ORE", new ResearchPage("tc.research_page.ORE.1"));
        TCHelper.addResearchPage("ORE", new ResearchPage("tc.research_page.ORE.2"));
        TCHelper.addResearchPage(
                "ORE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "blockCrystal", 1, 0, missing))));
        TCHelper.addResearchPage(
                "ORE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "blockCrystal", 1, 1, missing))));
        TCHelper.addResearchPage(
                "ORE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "blockCrystal", 1, 2, missing))));
        TCHelper.addResearchPage(
                "ORE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "blockCrystal", 1, 3, missing))));
        TCHelper.addResearchPage(
                "ORE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "blockCrystal", 1, 4, missing))));
        TCHelper.addResearchPage(
                "ORE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "blockCrystal", 1, 5, missing))));
        TCHelper.addResearchPage(
                "ORE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "blockCrystal", 1, 6, missing))));
        TCHelper.addResearchPage("ORE", new ResearchPage("tc.research_page.ORE.3"));
        TCHelper.addResearchPage("ORE", new ResearchPage("tc.research_page.ORE.4"));
        TCHelper.setResearchAspects(
                "RESEARCHER1",
                new AspectList().add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("sensus"), 6)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("lux"), 3));
        TCHelper.setResearchComplexity("RESEARCHER1", 1);
        TCHelper.setResearchAspects(
                "RESEARCHER2",
                new AspectList().add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("sensus"), 9)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("lux"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("RESEARCHER2", 2);
        TCHelper.setResearchAspects(
                "NODETAPPER1",
                new AspectList().add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("NODETAPPER1", 2);
        TCHelper.setResearchAspects(
                "NODETAPPER2",
                new AspectList().add(Aspect.getAspect("permutatio"), 12).add(Aspect.getAspect("auram"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("motus"), 6)
                        .add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("NODETAPPER2", 3);
        TCHelper.setResearchAspects(
                "NODEPRESERVE",
                new AspectList().add(Aspect.getAspect("perditio"), 9).add(Aspect.getAspect("cognitio"), 9)
                        .add(Aspect.getAspect("fabrico"), 6).add(Aspect.getAspect("instrumentum"), 3));
        TCHelper.setResearchComplexity("NODEPRESERVE", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DECONSTRUCTOR",
                getModItem("Thaumcraft", "blockTable", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                getModItem("Thaumcraft", "ItemThaumometer", 1, 0, missing),
                'c',
                "screwThaumium",
                'd',
                getModItem("Thaumcraft", "ItemPickThaumium", 1, 0, missing),
                'e',
                getModItem("Thaumcraft", "blockTable", 1, 0, missing),
                'f',
                getModItem("Thaumcraft", "ItemAxeThaumium", 1, 0, missing),
                'g',
                "plateThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "plateThaumium");
        TCHelper.setResearchAspects(
                "DECONSTRUCTOR",
                new AspectList().add(Aspect.getAspect("sensus"), 9).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("fames"), 3));
        TCHelper.setResearchComplexity("DECONSTRUCTOR", 2);
        TCHelper.setResearchAspects(
                "NODEJAR",
                new AspectList().add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("motus"), 12)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("permutatio"), 6)
                        .add(Aspect.getAspect("vitreus"), 3));
        TCHelper.setResearchComplexity("NODEJAR", 3);
        TCHelper.setResearchAspects(
                "RESEARCHDUPE",
                new AspectList().add(Aspect.getAspect("sensus"), 12).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("perditio"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("RESEARCHDUPE", 3);
        TCHelper.refreshResearchPages("DECONSTRUCTOR");
        new ResearchItem(
                "WARPWARNING",
                "BASICS",
                new AspectList(),
                1,
                1,
                1,
                getModItem("minecraft", "skull", 1, 1, missing)).registerResearchItem();
        TCHelper.addResearchSibling("WARP", "WARPWARNING");
        TCHelper.addResearchSibling("RESEARCH", "WARPWARNING");
        ResearchCategories.getResearch("WARPWARNING").setAutoUnlock();
        ResearchCategories.getResearch("WARPWARNING").setSpecial();
        TCHelper.addResearchPage("WARPWARNING", new ResearchPage("WARPTHEORY.research_page.WARPWARNING.1"));
        TCHelper.addResearchPage("WARPWARNING", new ResearchPage("WARPTHEORY.research_page.WARPWARNING.2"));
        TCHelper.addResearchPage("WARPWARNING", new ResearchPage("WARPTHEORY.research_page.WARPWARNING.3"));
        TCHelper.addResearchPage("WARPWARNING", new ResearchPage("WARPTHEORY.research_page.WARPWARNING.4"));
        TCHelper.addResearchPage("WARPWARNING", new ResearchPage("WARPTHEORY.research_page.WARPWARNING.5"));
        TCHelper.addResearchPage("WARPWARNING", new ResearchPage("WARPTHEORY.research_page.WARPWARNING.6"));

    }

    private void thaumaturgy() {
        // THAUMATURGY

        TCHelper.removeArcaneRecipe(getModItem("thaumicbases", "resource", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "WandCap", 1, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "WandCap", 1, 3, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "WandCap", 1, 5, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "WandCap", 1, 6, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "WandCap", 1, 8, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "WandCap", 1, 4, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "WandCap", 1, 2, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "WandCap", 1, 7, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "WandRod", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "WandRod", 1, 1, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "WandRod", 1, 3, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "WandRod", 1, 4, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "WandRod", 1, 5, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "WandRod", 1, 6, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "WandRod", 1, 7, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "WandRod", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "WandRod", 1, 50, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "WandRod", 1, 51, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "WandRod", 1, 52, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "WandRod", 1, 53, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "WandRod", 1, 54, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "WandRod", 1, 55, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "WandRod", 1, 56, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "WandRod", 1, 57, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "FocusFire", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "FocusExcavation", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "FocusFrost", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "FocusShock", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "FocusTrade", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "FocusPouch", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockStoneDevice", 1, 9, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "blockStoneDevice", 1, 10, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockStoneDevice", 1, 11, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockMetalDevice", 2, 14, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "blockStoneDevice", 1, 5, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "FocusWarding", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "FocusPortableHole", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "FocusHellbat", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemAmuletVis", 1, 1, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "blockStoneDevice", 1, 8, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockMetalDevice", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockStoneDevice", 1, 13, missing));
        TCHelper.clearPages("BASICTHAUMATURGY");
        TCHelper.addResearchPage("BASICTHAUMATURGY", new ResearchPage("tc.research_page.BASICTHAUMATURGY.1"));
        TCHelper.addResearchPage("BASICTHAUMATURGY", new ResearchPage("tc.research_page.BASICTHAUMATURGY.2"));
        TCHelper.addResearchPage(
                "BASICTHAUMATURGY",
                new ResearchPage(TCHelper.findCraftingRecipe(getModItem("Thaumcraft", "WandCap", 1, 0, missing))));
        TCHelper.addResearchPage(
                "BASICTHAUMATURGY",
                new ResearchPage(TCHelper.findCraftingRecipe(getModItem("Thaumcraft", "WandCasting", 1, 0, missing))));
        TCHelper.clearPages("CAP_copper");
        TCHelper.addResearchPage("CAP_copper", new ResearchPage("tc.research_page.CAP_copper.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_copper",
                getModItem("Thaumcraft", "WandCap", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                "screwSteel",
                'b',
                "foilCopper",
                'c',
                "screwSteel",
                'd',
                "foilCopper",
                'e',
                "ringCopper",
                'f',
                "foilCopper",
                'g',
                "screwSteel",
                'h',
                "foilCopper",
                'i',
                "screwSteel");
        TCHelper.addResearchPage(
                "CAP_copper",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "WandCap", 1, 3, missing))));
        TCHelper.setResearchAspects(
                "CAP_copper",
                new AspectList().add(Aspect.getAspect("instrumentum"), 3).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("permutatio"), 6));
        TCHelper.setResearchComplexity("CAP_copper", 1);
        TCHelper.addResearchPage("SCEPTRE", new ResearchPage("tc.research_page.RESEARCH.1"));
        TCHelper.clearPages("CAP_gold");
        TCHelper.addResearchPage("CAP_gold", new ResearchPage("tc.research_page.CAP_gold.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_gold",
                getModItem("Thaumcraft", "WandCap", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("aer"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "screwAluminium",
                'b',
                "foilGold",
                'c',
                "screwAluminium",
                'd',
                "foilGold",
                'e',
                "ringGold",
                'f',
                "foilGold",
                'g',
                "screwAluminium",
                'h',
                "foilGold",
                'i',
                "screwAluminium");
        TCHelper.addResearchPage(
                "CAP_gold",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "WandCap", 1, 1, missing))));
        TCHelper.setResearchAspects(
                "CAP_gold",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("lucrum"), 3));
        TCHelper.setResearchComplexity("CAP_gold", 2);
        TCHelper.clearPages("CAP_silver");
        TCHelper.addResearchPage("CAP_silver", new ResearchPage("tc.research_page.CAP_silver.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_silver",
                getModItem("Thaumcraft", "WandCap", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("ignis"), 25)
                        .add(Aspect.getAspect("aer"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "screwStainlessSteel",
                'b',
                "foilSilver",
                'c',
                "screwStainlessSteel",
                'd',
                "foilSilver",
                'e',
                "ringSilver",
                'f',
                "foilSilver",
                'g',
                "screwStainlessSteel",
                'h',
                "foilSilver",
                'i',
                "screwStainlessSteel");
        TCHelper.addResearchPage(
                "CAP_silver",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "WandCap", 1, 5, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CAP_silver",
                getModItem("Thaumcraft", "WandCap", 1, 4, missing),
                5,
                new AspectList().add(Aspect.getAspect("auram"), 18).add(Aspect.getAspect("potentia"), 30)
                        .add(Aspect.getAspect("praecantatio"), 18),
                getModItem("Thaumcraft", "WandCap", 1, 5, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2054, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2054, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2054, missing), });
        TCHelper.addResearchPage(
                "CAP_silver",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("Thaumcraft", "WandCap", 1, 4, missing))));
        TCHelper.clearPages("CAP_thaumium");
        TCHelper.addResearchPage("CAP_thaumium", new ResearchPage("tc.research_page.CAP_thaumium.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_thaumium",
                getModItem("Thaumcraft", "WandCap", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("aer"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                "screwKnightmetal",
                'b',
                "foilThaumium",
                'c',
                "screwKnightmetal",
                'd',
                "foilThaumium",
                'e',
                "ringThaumium",
                'f',
                "foilThaumium",
                'g',
                "screwKnightmetal",
                'h',
                "foilThaumium",
                'i',
                "screwKnightmetal");
        TCHelper.addResearchPage(
                "CAP_thaumium",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "WandCap", 1, 6, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CAP_thaumium",
                getModItem("Thaumcraft", "WandCap", 1, 2, missing),
                5,
                new AspectList().add(Aspect.getAspect("auram"), 25).add(Aspect.getAspect("potentia"), 40)
                        .add(Aspect.getAspect("praecantatio"), 25),
                getModItem("Thaumcraft", "WandCap", 1, 6, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2330, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2330, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2330, missing), });
        TCHelper.addResearchPage(
                "CAP_thaumium",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("Thaumcraft", "WandCap", 1, 2, missing))));
        TCHelper.setResearchAspects(
                "CAP_thaumium",
                new AspectList().add(Aspect.getAspect("instrumentum"), 6).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("CAP_thaumium", 3);
        TCHelper.clearPages("SCEPTRE");
        TCHelper.addResearchPage("SCEPTRE", new ResearchPage("tc.research_page.SCEPTRE.1"));
        TCHelper.setResearchAspects(
                "SCEPTRE",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("arbor"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("SCEPTRE", 3);
        TCHelper.clearPages("ROD_greatwood");
        TCHelper.addResearchPage("ROD_greatwood", new ResearchPage("tc.research_page.ROD_greatwood.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_greatwood",
                getModItem("Thaumcraft", "WandRod", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("aqua"), 20)
                        .add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'c',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                'e',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                'g',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing));
        TCHelper.addResearchPage(
                "ROD_greatwood",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "WandRod", 1, 0, missing))));
        TCHelper.setResearchAspects(
                "ROD_greatwood",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("ROD_greatwood", 2);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_reed",
                getModItem("Thaumcraft", "WandRod", 1, 5, missing),
                2,
                new AspectList().add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("motus"), 12)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("vitreus"), 6),
                getModItem("TConstruct", "trap.punji", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ROD_reed",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("herba"), 6)
                        .add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("ROD_reed", 2);
        TCHelper.addResearchPage(
                "SCEPTRE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(
                                        "Thaumcraft",
                                        "WandCasting",
                                        1,
                                        45,
                                        "{cap:\"thaumium\",rod:\"reed\",sceptre:1b}",
                                        missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_blaze",
                getModItem("Thaumcraft", "WandRod", 1, 6, missing),
                2,
                new AspectList().add(Aspect.getAspect("bestia"), 12).add(Aspect.getAspect("ignis"), 24)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("vitreus"), 6),
                getModItem("minecraft", "blaze_rod", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                        getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 1, missing), });
        TCHelper.setResearchAspects(
                "ROD_blaze",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("herba"), 6)
                        .add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("ROD_blaze", 2);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_obsidian",
                getModItem("Thaumcraft", "WandRod", 1, 1, missing),
                2,
                new AspectList().add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("tenebrae"), 12)
                        .add(Aspect.getAspect("terra"), 24).add(Aspect.getAspect("vitreus"), 6),
                getModItem("RandomThings", "ingredient", 1, 1, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing), });
        TCHelper.setResearchAspects(
                "ROD_obsidian",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("ROD_obsidian", 2);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_ice",
                getModItem("Thaumcraft", "WandRod", 1, 3, missing),
                2,
                new AspectList().add(Aspect.getAspect("aqua"), 24).add(Aspect.getAspect("gelum"), 12)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("vitreus"), 6),
                getModItem("BiomesOPlenty", "hardIce", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                        getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 2, missing), });
        TCHelper.setResearchAspects(
                "ROD_ice",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("aqua"), 6).add(Aspect.getAspect("gelum"), 6)
                        .add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("ROD_ice", 2);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_quartz",
                getModItem("Thaumcraft", "WandRod", 1, 4, missing),
                2,
                new AspectList().add(Aspect.getAspect("ordo"), 24).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("vitreus"), 6),
                getModItem("dreamcraft", "item.ChargedCertusQuartzRod", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                        getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 4, missing), });
        TCHelper.setResearchAspects(
                "ROD_quartz",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("ROD_quartz", 2);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_bone",
                getModItem("Thaumcraft", "WandRod", 1, 7, missing),
                3,
                new AspectList().add(Aspect.getAspect("exanimis"), 12).add(Aspect.getAspect("perditio"), 24)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("vitreus"), 6),
                getModItem("TConstruct", "toolRod", 1, 5, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                        getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 5, missing), });
        TCHelper.setResearchAspects(
                "ROD_bone",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("exanimis"), 6).add(Aspect.getAspect("perditio"), 6)
                        .add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("ROD_bone", 2);
        ThaumcraftApi.addWarpToResearch("ROD_bone", 1);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_silverwood",
                getModItem("Thaumcraft", "WandRod", 1, 2, missing),
                5,
                new AspectList().add(Aspect.getAspect("aer"), 48).add(Aspect.getAspect("aqua"), 48)
                        .add(Aspect.getAspect("ignis"), 48).add(Aspect.getAspect("ordo"), 48)
                        .add(Aspect.getAspect("perditio"), 48).add(Aspect.getAspect("praecantatio"), 48)
                        .add(Aspect.getAspect("terra"), 48),
                getModItem("Thaumcraft", "blockMagicalLog", 1, 1, missing),
                new ItemStack[] { getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing), });
        TCHelper.setResearchAspects(
                "ROD_silverwood",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("herba"), 6)
                        .add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("ROD_silverwood", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_greatwood_staff",
                getModItem("Thaumcraft", "WandRod", 1, 50, missing),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                'b',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                'c',
                getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                'd',
                getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                'e',
                getModItem("Thaumcraft", "WandRod", 1, 0, missing),
                'f',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'g',
                getModItem("Thaumcraft", "WandRod", 1, 0, missing),
                'h',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing));
        TCHelper.setResearchAspects(
                "ROD_greatwood_staff",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("arbor"), 9).add(Aspect.getAspect("ignis"), 6)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ROD_greatwood_staff", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_reed_staff",
                getModItem("Thaumcraft", "WandRod", 1, 55, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                'b',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                'c',
                getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                'd',
                getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                'e',
                getModItem("Thaumcraft", "WandRod", 1, 5, missing),
                'f',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'g',
                getModItem("Thaumcraft", "WandRod", 1, 5, missing),
                'h',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing));
        TCHelper.setResearchAspects(
                "ROD_reed_staff",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("herba"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ROD_reed_staff", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_blaze_staff",
                getModItem("Thaumcraft", "WandRod", 1, 56, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                'b',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                'c',
                getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                'd',
                getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                'e',
                getModItem("Thaumcraft", "WandRod", 1, 6, missing),
                'f',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'g',
                getModItem("Thaumcraft", "WandRod", 1, 6, missing),
                'h',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing));
        TCHelper.setResearchAspects(
                "ROD_blaze_staff",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("ignis"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ROD_blaze_staff", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_obsidian_staff",
                getModItem("Thaumcraft", "WandRod", 1, 51, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                'b',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                'c',
                getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                'd',
                getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                'e',
                getModItem("Thaumcraft", "WandRod", 1, 1, missing),
                'f',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'g',
                getModItem("Thaumcraft", "WandRod", 1, 1, missing),
                'h',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing));
        TCHelper.setResearchAspects(
                "ROD_obsidian_staff",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("ignis"), 6)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("ROD_obsidian_staff", 3);
        TCHelper.addResearchPage(
                "ROD_obsidian_staff",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(
                                        "Thaumcraft",
                                        "WandCasting",
                                        1,
                                        84,
                                        "{cap:\"thaumium\",rod:\"obsidian_staff\"}",
                                        missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_ice_staff",
                getModItem("Thaumcraft", "WandRod", 1, 53, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                'b',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                'c',
                getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                'd',
                getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                'e',
                getModItem("Thaumcraft", "WandRod", 1, 3, missing),
                'f',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'g',
                getModItem("Thaumcraft", "WandRod", 1, 3, missing),
                'h',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing));
        TCHelper.setResearchAspects(
                "ROD_ice_staff",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("gelum"), 9).add(Aspect.getAspect("aqua"), 6)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ROD_ice_staff", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_quartz_staff",
                getModItem("Thaumcraft", "WandRod", 1, 54, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                'b',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                'c',
                getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                'd',
                getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                'e',
                getModItem("Thaumcraft", "WandRod", 1, 4, missing),
                'f',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'g',
                getModItem("Thaumcraft", "WandRod", 1, 4, missing),
                'h',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing));
        TCHelper.setResearchAspects(
                "ROD_quartz_staff",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("vitreus"), 9).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ROD_quartz_staff", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_bone_staff",
                getModItem("Thaumcraft", "WandRod", 1, 57, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                'b',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                'c',
                getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                'd',
                getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                'e',
                getModItem("Thaumcraft", "WandRod", 1, 7, missing),
                'f',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'g',
                getModItem("Thaumcraft", "WandRod", 1, 7, missing),
                'h',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing));
        TCHelper.setResearchAspects(
                "ROD_bone_staff",
                new AspectList().add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("exanimis"), 9).add(Aspect.getAspect("perditio"), 6)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ROD_bone_staff", 3);
        ThaumcraftApi.addWarpToResearch("ROD_bone_staff", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_silverwood_staff",
                getModItem("Thaumcraft", "WandRod", 1, 52, missing),
                new AspectList().add(Aspect.getAspect("aer"), 125).add(Aspect.getAspect("terra"), 125)
                        .add(Aspect.getAspect("ignis"), 125).add(Aspect.getAspect("aqua"), 125)
                        .add(Aspect.getAspect("ordo"), 125).add(Aspect.getAspect("perditio"), 125),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                'b',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                'c',
                getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                'd',
                getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                'e',
                getModItem("Thaumcraft", "WandRod", 1, 2, missing),
                'f',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'g',
                getModItem("Thaumcraft", "WandRod", 1, 2, missing),
                'h',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing));
        TCHelper.setResearchAspects(
                "ROD_silverwood_staff",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("arbor"), 12).add(Aspect.getAspect("ordo"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ROD_silverwood_staff", 4);
        TCHelper.addResearchPage(
                "SCEPTRE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(
                                        "Thaumcraft",
                                        "WandCasting",
                                        1,
                                        216,
                                        "{cap:\"thaumium\",rod:\"silverwood_staff\",sceptre:1b}",
                                        missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUSFIRE",
                getModItem("Thaumcraft", "FocusFire", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("perditio"), 20)
                        .add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                'b',
                "gemQuartz",
                'c',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                'd',
                "gemQuartz",
                'e',
                "lensRuby",
                'f',
                "gemQuartz",
                'g',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                'h',
                "gemQuartz",
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing));
        TCHelper.setResearchAspects(
                "FOCUSFIRE",
                new AspectList().add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("FOCUSFIRE", 1);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUSEXCAVATION",
                getModItem("Thaumcraft", "FocusExcavation", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("perditio"), 20)
                        .add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'b',
                "gemQuartz",
                'c',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'd',
                "gemQuartz",
                'e',
                "lensEmerald",
                'f',
                "gemQuartz",
                'g',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'h',
                "gemQuartz",
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing));
        TCHelper.setResearchAspects(
                "FOCUSEXCAVATION",
                new AspectList().add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("perditio"), 6).add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("FOCUSEXCAVATION", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUSFROST",
                getModItem("Thaumcraft", "FocusFrost", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 30).add(Aspect.getAspect("perditio"), 20)
                        .add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                'b',
                "gemQuartz",
                'c',
                getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                'd',
                "gemQuartz",
                'e',
                "lensDiamond",
                'f',
                "gemQuartz",
                'g',
                getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                'h',
                "gemQuartz",
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 2, missing));
        TCHelper.setResearchAspects(
                "FOCUSFROST",
                new AspectList().add(Aspect.getAspect("aqua"), 9).add(Aspect.getAspect("gelum"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("FOCUSFROST", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUSSHOCK",
                getModItem("Thaumcraft", "FocusShock", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("perditio"), 20)
                        .add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                'b',
                "gemQuartz",
                'c',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                'd',
                "gemQuartz",
                'e',
                "lensGarnetYellow",
                'f',
                "gemQuartz",
                'g',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                'h',
                "gemQuartz",
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing));
        TCHelper.setResearchAspects(
                "FOCUSSHOCK",
                new AspectList().add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("FOCUSSHOCK", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUSTRADE",
                getModItem("Thaumcraft", "FocusTrade", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("ordo"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'b',
                "gemQuartz",
                'c',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'd',
                "gemQuartz",
                'e',
                getModItem("dreamcraft", "item.ReinforcedGlassLense", 1, 0, missing),
                'f',
                "gemQuartz",
                'g',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'h',
                "gemQuartz",
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing));
        TCHelper.setResearchAspects(
                "FOCUSTRADE",
                new AspectList().add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("FOCUSTRADE", 2);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FOCUSWARDING",
                getModItem("Thaumcraft", "FocusWarding", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("ordo"), 25)
                        .add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("tutamen"), 25)
                        .add(Aspect.getAspect("praecantatio"), 10),
                getModItem("gregtech", "gt.metaitem.01", 1, 24506, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("minecraft", "quartz", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("minecraft", "quartz", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 4, missing), });
        TCHelper.setResearchAspects(
                "FOCUSWARDING",
                new AspectList().add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("tutamen"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("FOCUSWARDING", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FOCUSPORTABLEHOLE",
                getModItem("Thaumcraft", "FocusPortableHole", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("alienis"), 40).add(Aspect.getAspect("iter"), 30)
                        .add(Aspect.getAspect("perditio"), 20).add(Aspect.getAspect("permutatio"), 10)
                        .add(Aspect.getAspect("praecantatio"), 5),
                getModItem("gregtech", "gt.metaitem.01", 1, 24532, missing),
                new ItemStack[] { getModItem("minecraft", "quartz", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("minecraft", "quartz", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing), });
        TCHelper.setResearchAspects(
                "FOCUSPORTABLEHOLE",
                new AspectList().add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("alienis"), 9).add(Aspect.getAspect("perditio"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("FOCUSPORTABLEHOLE", 3);
        ThaumcraftApi.addWarpToResearch("NODESTABILIZERADV", 1);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FOCUSHELLBAT",
                getModItem("Thaumcraft", "FocusHellbat", 1, 0, missing),
                7,
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("ignis"), 40)
                        .add(Aspect.getAspect("bestia"), 20).add(Aspect.getAspect("perditio"), 10)
                        .add(Aspect.getAspect("praecantatio"), 5),
                getModItem("gregtech", "gt.metaitem.01", 1, 24347, missing),
                new ItemStack[] { getModItem("minecraft", "quartz", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                        getModItem("minecraft", "quartz", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "FOCUSHELLBAT",
                new AspectList().add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("iter"), 9)
                        .add(Aspect.getAspect("ignis"), 9).add(Aspect.getAspect("bestia"), 6)
                        .add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("FOCUSHELLBAT", 3);
        ThaumcraftApi.addWarpToResearch("NODESTABILIZERADV", 2);
        ThaumcraftApi.addWarpToItem(getModItem("Thaumcraft", "FocusHellbat", 1, 0, missing), 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUSPOUCH",
                getModItem("Thaumcraft", "FocusPouch", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("perditio"), 20)
                        .add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "boltGold",
                'b',
                "ringGold",
                'c',
                "boltGold",
                'd',
                getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                'e',
                getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 2, missing),
                'f',
                getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                'g',
                getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                'h',
                getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                'i',
                getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing));
        TCHelper.setResearchAspects(
                "FOCUSPOUCH",
                new AspectList().add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("vacuos"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("pannus"), 3));
        TCHelper.setResearchComplexity("FOCUSPOUCH", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "NODESTABILIZER",
                getModItem("Thaumcraft", "blockStoneDevice", 1, 9, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 35).add(Aspect.getAspect("terra"), 35)
                        .add(Aspect.getAspect("ordo"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                "springGold",
                'c',
                "plateThaumium",
                'd',
                "blockQuartz",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                'f',
                "blockQuartz",
                'g',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'h',
                getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                'i',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing));
        TCHelper.setResearchAspects(
                "NODESTABILIZER",
                new AspectList().add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("ordo"), 3));
        TCHelper.setResearchComplexity("NODESTABILIZER", 2);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "NODESTABILIZERADV",
                getModItem("Thaumcraft", "blockStoneDevice", 1, 10, missing),
                10,
                new AspectList().add(Aspect.getAspect("auram"), 32).add(Aspect.getAspect("ordo"), 32)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("praecantatio"), 32),
                getModItem("Thaumcraft", "blockStoneDevice", 1, 9, missing),
                new ItemStack[] { getModItem("minecraft", "redstone_block", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                        getModItem("minecraft", "redstone_block", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                        getModItem("minecraft", "glowstone", 1, 0, missing),
                        getModItem("minecraft", "redstone_block", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                        getModItem("minecraft", "redstone_block", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                        getModItem("minecraft", "glowstone", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "NODESTABILIZERADV",
                new AspectList().add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("NODESTABILIZERADV", 3);
        ThaumcraftApi.addWarpToResearch("NODESTABILIZERADV", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VISPOWER",
                getModItem("Thaumcraft", "blockStoneDevice", 1, 11, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 32).add(Aspect.getAspect("aer"), 32)
                        .add(Aspect.getAspect("perditio"), 32).add(Aspect.getAspect("ordo"), 32),
                "abc",
                "def",
                "ghi",
                'a',
                "blockRedstone",
                'b',
                getModItem("ProjRed|Integration", "projectred.integration.gate", 1, 26, missing),
                'c',
                "blockRedstone",
                'd',
                "plateThaumium",
                'e',
                getModItem("Thaumcraft", "blockStoneDevice", 1, 9, missing),
                'f',
                "plateThaumium",
                'g',
                "blockRedstone",
                'h',
                getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                'i',
                "blockRedstone");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VISPOWER",
                getModItem("Thaumcraft", "blockMetalDevice", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 10).add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "screwSteel",
                'b',
                "lensDiamond",
                'c',
                "screwSteel",
                'd',
                "ringThaumium",
                'e',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'f',
                "ringThaumium",
                'g',
                "screwSteel",
                'h',
                "lensDiamond",
                'i',
                "screwSteel");
        TCHelper.setResearchAspects(
                "VISPOWER",
                new AspectList().add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("praecantatio"), 3).add(Aspect.getAspect("machina"), 6));
        TCHelper.setResearchComplexity("VISPOWER", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "WANDPED",
                getModItem("Thaumcraft", "blockStoneDevice", 1, 5, missing),
                2,
                new AspectList().add(Aspect.getAspect("auram"), 10).add(Aspect.getAspect("permutatio"), 15)
                        .add(Aspect.getAspect("praecantatio"), 20).add(Aspect.getAspect("ordo"), 5),
                getModItem("Thaumcraft", "blockStoneDevice", 1, 1, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29500, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29500, missing), });
        TCHelper.setResearchAspects(
                "WANDPED",
                new AspectList().add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("praecantatio"), 3).add(Aspect.getAspect("permutatio"), 6));
        TCHelper.setResearchComplexity("WANDPED", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "VISAMULET",
                getModItem("Thaumcraft", "ItemAmuletVis", 1, 1, missing),
                7,
                new AspectList().add(Aspect.getAspect("vacuos"), 48).add(Aspect.getAspect("auram"), 48)
                        .add(Aspect.getAspect("potentia"), 88).add(Aspect.getAspect("praecantatio"), 88)
                        .add(Aspect.getAspect("vitreus"), 24),
                getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30500, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30500, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing), });
        TCHelper.setResearchAspects(
                "VISAMULET",
                new AspectList().add(Aspect.getAspect("vacuos"), 15).add(Aspect.getAspect("auram"), 15)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("vitreus"), 6).add(Aspect.getAspect("tempus"), 3));
        TCHelper.setResearchComplexity("VISAMULET", 4);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "WANDPEDFOC",
                getModItem("Thaumcraft", "blockStoneDevice", 1, 8, missing),
                5,
                new AspectList().add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("permutatio"), 25)
                        .add(Aspect.getAspect("praecantatio"), 30).add(Aspect.getAspect("potentia"), 15)
                        .add(Aspect.getAspect("cognitio"), 15),
                getModItem("ProjRed|Integration", "projectred.integration.gate", 1, 26, missing),
                new ItemStack[] { getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 8, missing), });
        TCHelper.setResearchAspects(
                "WANDPEDFOC",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("auram"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("cognitio"), 6)
                        .add(Aspect.getAspect("lucrum"), 3));
        TCHelper.setResearchComplexity("WANDPEDFOC", 4);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VISCHARGERELAY",
                getModItem("Thaumcraft", "blockMetalDevice", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("ordo"), 20)
                        .add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                getModItem("Thaumcraft", "blockMetalDevice", 1, 14, missing),
                'c',
                "screwThaumium",
                'd',
                getModItem("Thaumcraft", "WandRod", 1, 2, missing),
                'e',
                "plateThaumium",
                'f',
                getModItem("Thaumcraft", "WandRod", 1, 2, missing),
                'g',
                getModItem("Thaumcraft", "WandRod", 1, 0, missing),
                'h',
                "craftingToolScrewdriver",
                'i',
                getModItem("Thaumcraft", "WandRod", 1, 0, missing));
        TCHelper.setResearchAspects(
                "VISCHARGERELAY",
                new AspectList().add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("aer"), 3));
        TCHelper.setResearchComplexity("VISCHARGERELAY", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCALMANIPULATION",
                getModItem("Thaumcraft", "blockStoneDevice", 1, 13, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("ordo"), 64)
                        .add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("terra"), 64)
                        .add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("perditio"), 64),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'b',
                getModItem("Thaumcraft", "blockCosmeticSlabStone", 1, 0, missing),
                'c',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'd',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                'f',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'g',
                "plateThaumium",
                'h',
                getModItem("Thaumcraft", "blockTable", 1, 0, missing),
                'i',
                "plateThaumium");
        TCHelper.setResearchAspects(
                "FOCALMANIPULATION",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("vitreus"), 9)
                        .add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("alienis"), 3)
                        .add(Aspect.getAspect("cognitio"), 5));
        TCHelper.setResearchComplexity("FOCALMANIPULATION", 4);
        TCHelper.setResearchAspects(
                "VAMPBAT",
                new AspectList().add(Aspect.getAspect("fames"), 15).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("victus"), 12).add(Aspect.getAspect("exanimis"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("ira"), 3)
                        .add(Aspect.getAspect("alienis"), 6));
        TCHelper.setResearchComplexity("VAMPBAT", 4);
        ThaumcraftApi.addWarpToResearch("VAMPBAT", 4);
        TCHelper.refreshResearchPages("CAP_copper");
        TCHelper.refreshResearchPages("CAP_gold");
        TCHelper.refreshResearchPages("CAP_silver");
        TCHelper.refreshResearchPages("CAP_thaumium");
        TCHelper.refreshResearchPages("ROD_silverwood");
        TCHelper.refreshResearchPages("ROD_greatwood_staff");
        TCHelper.refreshResearchPages("FOCUSFIRE");
        TCHelper.refreshResearchPages("FOCUSEXCAVATION");
        TCHelper.refreshResearchPages("FOCUSFROST");
        TCHelper.refreshResearchPages("FOCUSSHOCK");
        TCHelper.refreshResearchPages("FOCUSTRADE");
        TCHelper.refreshResearchPages("FOCUSWARDING");
        TCHelper.refreshResearchPages("FOCUSPORTABLEHOLE");
        TCHelper.refreshResearchPages("FOCUSHELLBAT");
        TCHelper.refreshResearchPages("FOCUSPOUCH");
        TCHelper.refreshResearchPages("NODESTABILIZER");
        TCHelper.refreshResearchPages("NODESTABILIZERADV");
        TCHelper.refreshResearchPages("VISPOWER");
        TCHelper.refreshResearchPages("WANDPED");
        TCHelper.refreshResearchPages("VISAMULET");
        TCHelper.refreshResearchPages("WANDPEDFOC");
        TCHelper.refreshResearchPages("VISCHARGERELAY");
        TCHelper.refreshResearchPages("FOCALMANIPULATION");
        TCHelper.refreshResearchPages("VAMPBAT");

    }

    private void alchemy() {
        // ALCHEMY

        GT_ModHandler.addShapelessCraftingRecipe(
                getModItem(Mods.Thaumcraft.ID, "ItemEssence", 1),
                new Object[] { new ItemStack(Items.glass_bottle), "roundAnyRubber" });

        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemResource", 1, 4, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemResource", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemResource", 1, 1, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemResource", 1, 2, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemResource", 1, 16, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemResource", 1, 17, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemResource", 1, 6, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemResource", 3, 3, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemResource", 2, 14, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemResource", 1, 7, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemResource", 1, 9, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemResource", 1, 6, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockStoneDevice", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemResource", 2, 8, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockMetalDevice", 1, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockMetalDevice", 1, 9, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockTube", 8, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockTube", 1, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockTube", 1, 3, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockTube", 1, 5, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockTube", 1, 6, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockTube", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockTube", 1, 4, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemResonator", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockTube", 1, 7, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockMetalDevice", 1, 12, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockJar", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockJar", 1, 3, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemBathSalts", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemSanitySoap", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockStoneDevice", 1, 12, missing));
        TCHelper.clearPages("PHIAL");
        TCHelper.addResearchPage("PHIAL", new ResearchPage("tc.research_page.PHIAL.1"));
        TCHelper.addResearchPage(
                "PHIAL",
                new ResearchPage(TCHelper.findCraftingRecipe(getModItem("Thaumcraft", "ItemEssence", 1, 0, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "TALLOW",
                getModItem("Thaumcraft", "ItemResource", 1, 4, missing),
                getModItem("gregtech", "gt.metaitem.01", 1, 2877, missing),
                new AspectList().add(Aspect.getAspect("praecantatio"), 2).add(Aspect.getAspect("corpus"), 4)
                        .add(Aspect.getAspect("mortuus"), 2));
        TCHelper.setResearchAspects(
                "TALLOW",
                new AspectList().add(Aspect.getAspect("corpus"), 6).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("TALLOW", 1);
        TCHelper.clearPages("TALLOW");
        TCHelper.addResearchPage("TALLOW", new ResearchPage("tc.research_page.TALLOW.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TALLOW",
                getModItem("Thaumcraft", "blockCandle", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 3).add(Aspect.getAspect("ordo"), 1)
                        .add(Aspect.getAspect("perditio"), 1).add(Aspect.getAspect("aer"), 3),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("minecraft", "string", 1, 0, missing),
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 4, missing),
                'h',
                getModItem("Thaumcraft", "ItemResource", 1, 4, missing));
        TCHelper.addResearchPage(
                "TALLOW",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("Thaumcraft", "ItemResource", 1, 4, missing))));
        TCHelper.addResearchPage(
                "TALLOW",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "blockCandle", 1, 0, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "NITOR",
                getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 4).add(Aspect.getAspect("lux"), 4)
                        .add(Aspect.getAspect("potentia"), 4));
        TCHelper.setResearchAspects(
                "NITOR",
                new AspectList().add(Aspect.getAspect("lux"), 6).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("NITOR", 1);
        ThaumcraftApi.addCrucibleRecipe(
                "ALUMENTUM",
                getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                getModItem("gregtech", "gt.metaitem.01", 1, 2535, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("perditio"), 3)
                        .add(Aspect.getAspect("potentia"), 6));
        ThaumcraftApi.addCrucibleRecipe(
                "ALUMENTUM",
                getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                getModItem("gregtech", "gt.metaitem.01", 1, 2536, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("perditio"), 3)
                        .add(Aspect.getAspect("potentia"), 6));
        ThaumcraftApi.addCrucibleRecipe(
                "ALUMENTUM",
                getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                getModItem("gregtech", "gt.metaitem.01", 1, 2538, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("perditio"), 3)
                        .add(Aspect.getAspect("potentia"), 6));
        TCHelper.setResearchAspects(
                "ALUMENTUM",
                new AspectList().add(Aspect.getAspect("ignis"), 3).add(Aspect.getAspect("praecantatio"), 3)
                        .add(Aspect.getAspect("perditio"), 6));
        TCHelper.setResearchComplexity("ALUMENTUM", 1);
        TCHelper.addResearchPage("ALUMENTUM", new ResearchPage("tc.research_page.ALUMENTUM.2"));
        TCHelper.setResearchAspects(
                "ALCHEMICALDUPLICATION",
                new AspectList().add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("ALCHEMICALDUPLICATION", 2);
        TCHelper.setResearchAspects(
                "ALCHEMICALMANUFACTURE",
                new AspectList().add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("ALCHEMICALMANUFACTURE", 2);
        TCHelper.setResearchAspects(
                "ENTROPICPROCESSING",
                new AspectList().add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("perditio"), 3));
        TCHelper.setResearchComplexity("ENTROPICPROCESSING", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DISTILESSENTIA",
                getModItem("Thaumcraft", "blockStoneDevice", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("aer"), 10)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'b',
                getModItem("Railcraft", "machine.beta", 1, 3, missing),
                'c',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'd',
                "plateThaumium",
                'e',
                "craftingIronFurnace",
                'f',
                "plateThaumium",
                'g',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'h',
                getModItem("Thaumcraft", "blockMetalDevice", 1, 0, missing),
                'i',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing));
        TCHelper.setResearchAspects(
                "DISTILESSENTIA",
                new AspectList().add(Aspect.getAspect("limus"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("ignis"), 3).add(Aspect.getAspect("aqua"), 9));
        TCHelper.setResearchComplexity("DISTILESSENTIA", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DISTILESSENTIA",
                getModItem("Thaumcraft", "ItemResource", 3, 8, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("aqua"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "springSmallGold",
                'b',
                "plateGold",
                'c',
                "springSmallGold",
                'd',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 7, missing),
                'e',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 7, missing),
                'f',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 7, missing),
                'g',
                "springSmallGold",
                'h',
                "plateGold",
                'i',
                "springSmallGold");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DISTILESSENTIA",
                getModItem("Thaumcraft", "blockMetalDevice", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 10)
                        .add(Aspect.getAspect("ignis"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                "pipeMediumSteel",
                'c',
                "plateThaumium",
                'd',
                getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                'e',
                getModItem("Railcraft", "machine.beta", 1, 3, missing),
                'f',
                getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                'g',
                "plateThaumium",
                'h',
                "pipeMediumSteel",
                'i',
                "plateThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DISTILESSENTIA",
                getModItem("Thaumcraft", "blockMetalDevice", 1, 9, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ignis"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockTube", 1, 0, missing),
                'b',
                getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                'c',
                getModItem("Thaumcraft", "blockTube", 1, 0, missing),
                'd',
                getModItem("Thaumcraft", "blockTube", 1, 1, missing),
                'e',
                "blockThaumium",
                'f',
                getModItem("Thaumcraft", "blockTube", 1, 1, missing),
                'g',
                getModItem("Thaumcraft", "blockTube", 1, 0, missing),
                'h',
                getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                'i',
                getModItem("Thaumcraft", "blockTube", 1, 0, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TUBES",
                getModItem("Thaumcraft", "blockTube", 4, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 8).add(Aspect.getAspect("aqua"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                "nuggetGold",
                'c',
                "screwThaumium",
                'd',
                getModItem("Thaumcraft", "ItemNugget", 1, 5, missing),
                'e',
                "pipeSmallSteel",
                'f',
                getModItem("Thaumcraft", "ItemNugget", 1, 5, missing),
                'g',
                "screwThaumium",
                'h',
                "nuggetGold",
                'i',
                "screwThaumium");
        TCHelper.setResearchAspects(
                "TUBES",
                new AspectList().add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("permutatio"), 6)
                        .add(Aspect.getAspect("aqua"), 9).add(Aspect.getAspect("ordo"), 3));
        TCHelper.setResearchComplexity("TUBES", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TUBES",
                getModItem("Thaumcraft", "blockTube", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 8).add(Aspect.getAspect("aqua"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                getModItem("minecraft", "lever", 1, 0, missing),
                'c',
                "screwThaumium",
                'd',
                "plateAnyRubber",
                'e',
                getModItem("Thaumcraft", "blockTube", 1, 0, missing),
                'f',
                "gearGtSmallThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TUBES",
                getModItem("Thaumcraft", "ItemResonator", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolScrewdriver",
                'b',
                "stickThaumium",
                'd',
                "screwThaumium",
                'e',
                getModItem("Thaumcraft", "ItemNugget", 1, 5, missing),
                'f',
                "stickThaumium",
                'g',
                "stickWood",
                'h',
                "screwThaumium",
                'i',
                "craftingToolFile");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TUBEFILTER",
                getModItem("Thaumcraft", "blockTube", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("aqua"), 16),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolScrewdriver",
                'b',
                getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                'c',
                "craftingToolFile",
                'd',
                "screwThaumium",
                'e',
                getModItem("Thaumcraft", "blockTube", 1, 0, missing),
                'f',
                "screwThaumium",
                'h',
                getModItem("Thaumcraft", "ItemResource", 1, 8, missing));
        TCHelper.setResearchAspects(
                "TUBEFILTER",
                new AspectList().add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("aqua"), 12).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("limus"), 3));
        TCHelper.setResearchComplexity("TUBEFILTER", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TUBEFILTER",
                getModItem("Thaumcraft", "blockTube", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("aqua"), 16),
                "abc",
                "def",
                "ghi",
                'd',
                "ringAnyRubber",
                'e',
                getModItem("Thaumcraft", "blockTube", 1, 0, missing),
                'f',
                "ringAnyRubber");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TUBEFILTER",
                getModItem("Thaumcraft", "blockTube", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("perditio"), 8)
                        .add(Aspect.getAspect("aqua"), 8),
                "abc",
                "def",
                "ghi",
                'd',
                "dyeBlue",
                'e',
                getModItem("Thaumcraft", "blockTube", 1, 0, missing),
                'f',
                "screwThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CENTRIFUGE",
                getModItem("Thaumcraft", "blockTube", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("perditio"), 16)
                        .add(Aspect.getAspect("aqua"), 16),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                getModItem("Thaumcraft", "blockTube", 1, 0, missing),
                'c',
                "screwThaumium",
                'd',
                getModItem("Thaumcraft", "blockMetalDevice", 1, 1, missing),
                'e',
                getModItem("Thaumcraft", "blockMetalDevice", 1, 9, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 32641, missing),
                'g',
                "screwThaumium",
                'h',
                getModItem("Thaumcraft", "blockTube", 1, 0, missing),
                'i',
                "screwThaumium");
        TCHelper.setResearchAspects(
                "CENTRIFUGE",
                new AspectList().add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("permutatio"), 12).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("machina"), 3));
        TCHelper.setResearchComplexity("CENTRIFUGE", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CENTRIFUGE",
                getModItem("Thaumcraft", "blockTube", 4, 4, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("aqua"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "ItemEssence", 1, 0, missing),
                'b',
                getModItem("Thaumcraft", "blockTube", 1, 1, missing),
                'c',
                getModItem("Thaumcraft", "ItemEssence", 1, 0, missing),
                'd',
                getModItem("Thaumcraft", "blockTube", 1, 0, missing),
                'e',
                "screwThaumium",
                'f',
                getModItem("Thaumcraft", "blockTube", 1, 0, missing),
                'g',
                getModItem("Thaumcraft", "ItemEssence", 1, 0, missing),
                'h',
                getModItem("Thaumcraft", "blockTube", 1, 5, missing),
                'i',
                getModItem("Thaumcraft", "ItemEssence", 1, 0, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ESSENTIACRYSTAL",
                getModItem("Thaumcraft", "blockTube", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("aqua"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                getModItem("minecraft", "dispenser", 1, 0, missing),
                'c',
                "plateThaumium",
                'd',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'e',
                getModItem("Thaumcraft", "blockMetalDevice", 1, 9, missing),
                'f',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'g',
                "screwThaumium",
                'h',
                getModItem("Thaumcraft", "blockTube", 1, 0, missing),
                'i',
                "screwThaumium");
        TCHelper.setResearchAspects(
                "ESSENTIACRYSTAL",
                new AspectList().add(Aspect.getAspect("aqua"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("permutatio"), 12).add(Aspect.getAspect("vitreus"), 6)
                        .add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ESSENTIACRYSTAL", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "THAUMATORIUM",
                getModItem("Thaumcraft", "blockMetalDevice", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 10).add(Aspect.getAspect("ordo"), 10)
                        .add(Aspect.getAspect("aqua"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                "gemFlawlessAmber",
                'c',
                "plateThaumium",
                'd',
                "gemFlawlessAmber",
                'e',
                getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                'f',
                "gemFlawlessAmber",
                'g',
                "plateThaumium",
                'h',
                "gemFlawlessAmber",
                'i',
                "plateThaumium");
        TCHelper.setResearchAspects(
                "THAUMATORIUM",
                new AspectList().add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("aqua"), 9)
                        .add(Aspect.getAspect("permutatio"), 12).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("THAUMATORIUM", 3);
        TCHelper.setResearchAspects(
                "TRANSIRON",
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("ordo"), 3)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("TRANSIRON", 1);
        TCHelper.setResearchAspects(
                "TRANSGOLD",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("TRANSGOLD", 2);
        TCHelper.setResearchAspects(
                "TRANSCOPPER",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("TRANSCOPPER", 2);
        TCHelper.setResearchAspects(
                "TRANSTIN",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("vitreus"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("TRANSTIN", 2);
        TCHelper.setResearchAspects(
                "TRANSLEAD",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("TRANSLEAD", 2);
        TCHelper.setResearchAspects(
                "TRANSSILVER",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("TRANSSILVER", 2);
        TCHelper.setResearchAspects(
                "PUREIRON",
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("vitreus"), 3));
        TCHelper.setResearchComplexity("PUREIRON", 1);
        TCHelper.setResearchAspects(
                "PUREGOLD",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("PUREGOLD", 2);
        TCHelper.setResearchAspects(
                "PURECOPPER",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("PURECOPPER", 2);
        TCHelper.setResearchAspects(
                "PURETIN",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("vitreus"), 9)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("PURETIN", 2);
        TCHelper.setResearchAspects(
                "PURELEAD",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("PURELEAD", 2);
        TCHelper.setResearchAspects(
                "PURESILVER",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("PURESILVER", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "JARLABEL",
                getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 2),
                "abc",
                "def",
                "ghi",
                'a',
                "paneGlassColorless",
                'b',
                "plateAnyRubber",
                'c',
                "paneGlassColorless",
                'd',
                "paneGlassColorless",
                'f',
                "paneGlassColorless",
                'g',
                "paneGlassColorless",
                'h',
                "paneGlassColorless",
                'i',
                "paneGlassColorless");
        TCHelper.clearPages("JARVOID");
        TCHelper.addResearchPage("JARVOID", new ResearchPage("tc.research_page.JARVOID.1"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "JARVOID",
                getModItem("Thaumcraft", "blockJar", 1, 3, missing),
                2,
                new AspectList().add(Aspect.getAspect("vacuos"), 7).add(Aspect.getAspect("praecantatio"), 7)
                        .add(Aspect.getAspect("perditio"), 7).add(Aspect.getAspect("aqua"), 7),
                getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 17804, missing),
                        getModItem("minecraft", "blaze_powder", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17533, missing),
                        getModItem("Thaumcraft", "ItemNugget", 1, 5, missing), });
        TCHelper.addResearchPage(
                "JARVOID",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("Thaumcraft", "blockJar", 1, 3, missing))));
        TCHelper.setResearchAspects(
                "JARVOID",
                new AspectList().add(Aspect.getAspect("vacuos"), 6).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6));
        TCHelper.setResearchComplexity("JARVOID", 1);
        ThaumcraftApi.addCrucibleRecipe(
                "BATHSALTS",
                getModItem("Thaumcraft", "ItemBathSalts", 2, 0, missing),
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("sano"), 10).add(Aspect.getAspect("cognitio"), 10)
                        .add(Aspect.getAspect("auram"), 10).add(Aspect.getAspect("ordo"), 10));
        TCHelper.setResearchAspects(
                "BATHSALTS",
                new AspectList().add(Aspect.getAspect("sano"), 9).add(Aspect.getAspect("cognitio"), 6)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("BATHSALTS", 2);
        ThaumcraftApi.addCrucibleRecipe(
                "SANESOAP",
                getModItem("Thaumcraft", "ItemSanitySoap", 2, 0, missing),
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 20).add(Aspect.getAspect("cognitio"), 20)
                        .add(Aspect.getAspect("sano"), 20).add(Aspect.getAspect("ordo"), 20));
        TCHelper.setResearchAspects(
                "SANESOAP",
                new AspectList().add(Aspect.getAspect("sano"), 12).add(Aspect.getAspect("alienis"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("SANESOAP", 3);
        TCHelper.clearPages("ARCANESPA");
        TCHelper.addResearchPage("ARCANESPA", new ResearchPage("tc.research_page.ARCANESPA.1"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ARCANESPA",
                getModItem("Thaumcraft", "blockStoneDevice", 1, 12, missing),
                4,
                new AspectList().add(Aspect.getAspect("ordo"), 24).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("sano"), 16).add(Aspect.getAspect("aqua"), 32)
                        .add(Aspect.getAspect("machina"), 8),
                getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                new ItemStack[] { getModItem("dreamcraft", "item.StainlessSteelBars", 1, 0, missing),
                        getModItem("minecraft", "quartz_block", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                        getModItem("Thaumcraft", "ItemBathSalts", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                        getModItem("minecraft", "quartz_block", 1, 0, missing), });
        TCHelper.addResearchPage(
                "ARCANESPA",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("Thaumcraft", "blockStoneDevice", 1, 12, missing))));
        TCHelper.setResearchAspects(
                "ARCANESPA",
                new AspectList().add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("aqua"), 9)
                        .add(Aspect.getAspect("machina"), 6).add(Aspect.getAspect("sano"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("ARCANESPA", 3);
        TCHelper.setResearchAspects(
                "LIQUIDDEATH",
                new AspectList().add(Aspect.getAspect("aqua"), 9).add(Aspect.getAspect("mortuus"), 9)
                        .add(Aspect.getAspect("perditio"), 6).add(Aspect.getAspect("venenum"), 6)
                        .add(Aspect.getAspect("tenebrae"), 3));
        TCHelper.setResearchComplexity("LIQUIDDEATH", 3);
        TCHelper.setResearchAspects(
                "ETHEREALBLOOM",
                new AspectList().add(Aspect.getAspect("vitium"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("sano"), 6).add(Aspect.getAspect("herba"), 6)
                        .add(Aspect.getAspect("lux"), 3).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ETHEREALBLOOM", 3);
        TCHelper.setResearchAspects(
                "BOTTLETAINT",
                new AspectList().add(Aspect.getAspect("vitium"), 12).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("aqua"), 12).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("venenum"), 6)
                        .add(Aspect.getAspect("strontio"), 3));
        TCHelper.setResearchComplexity("BOTTLETAINT", 3);
        ThaumcraftApi.addWarpToResearch("BOTTLETAINT", 5);
        ThaumcraftApi.addWarpToItem(getModItem("Thaumcraft", "ItemBottleTaint", 1, 0, missing), 1);
        ThaumcraftApi.addCrucibleRecipe(
                "THAUMIUM",
                getModItem("Thaumcraft", "ItemResource", 1, 2, missing),
                getModItem("minecraft", "iron_ingot", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("praecantatio"), 4));
        ThaumcraftApi.addCrucibleRecipe(
                "GT_CRYSTALLISATION",
                getModItem("Thaumcraft", "ItemResource", 1, 6, missing),
                "dustAmber",
                new AspectList().add(Aspect.getAspect("vitreus"), 4));
        TCHelper.refreshResearchPages("CRUCIBLE");
        TCHelper.refreshResearchPages("TALLOW");
        TCHelper.refreshResearchPages("NITOR");
        TCHelper.refreshResearchPages("ALUMENTUM");
        TCHelper.refreshResearchPages("THAUMIUM");
        TCHelper.refreshResearchPages("DISTILESSENTIA");
        TCHelper.refreshResearchPages("JARLABEL");
        TCHelper.refreshResearchPages("JARVOID");
        TCHelper.refreshResearchPages("ALCHEMICALDUPLICATION");
        TCHelper.refreshResearchPages("ALCHEMICALMANUFACTURE");
        TCHelper.refreshResearchPages("THAUMATORIUM");
        TCHelper.refreshResearchPages("ENTROPICPROCESSING");
        TCHelper.refreshResearchPages("BATHSALTS");
        TCHelper.refreshResearchPages("SANESOAP");
        TCHelper.refreshResearchPages("ARCANESPA");
        TCHelper.refreshResearchPages("TUBES");
        TCHelper.refreshResearchPages("TUBEFILTER");
        TCHelper.refreshResearchPages("CENTRIFUGE");
        TCHelper.refreshResearchPages("ESSENTIACRYSTAL");
        TCHelper.refreshResearchPages("TRANSIRON");
        TCHelper.refreshResearchPages("TRANSGOLD");
        TCHelper.refreshResearchPages("TRANSCOPPER");
        TCHelper.refreshResearchPages("TRANSTIN");
        TCHelper.refreshResearchPages("TRANSLEAD");
        TCHelper.refreshResearchPages("TRANSSILVER");
        TCHelper.refreshResearchPages("PUREIRON");
        TCHelper.refreshResearchPages("PUREGOLD");
        TCHelper.refreshResearchPages("PURECOPPER");
        TCHelper.refreshResearchPages("PURETIN");
        TCHelper.refreshResearchPages("PURELEAD");
        TCHelper.refreshResearchPages("PURESILVER");
        TCHelper.refreshResearchPages("LIQUIDDEATH");
    }

    private void artifice() {
        // ARTIFICE

        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemGoggles", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemResource", 1, 15, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemResource", 1, 10, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockCosmeticSolid", 3, 6, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockCosmeticSolid", 9, 6, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockCosmeticSolid", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockCosmeticSolid", 4, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockCosmeticSolid", 1, 3, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockCosmeticSolid", 4, 3, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockStoneDevice", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockStoneDevice", 2, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemResource", 1, 7, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemChestplateRobe", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemLeggingsRobe", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemBootsRobe", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockMetalDevice", 1, 7, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "blockMetalDevice", 1, 8, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "blockMetalDevice", 1, 13, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockLifter", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemArcaneDoor", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockWoodenDevice", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockCosmeticOpaque", 8, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ArcaneDoorKey", 2, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ArcaneDoorKey", 2, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockWoodenDevice", 1, 1, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemCompassStone", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockWoodenDevice", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockStoneDevice", 1, 14, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "BootsTraveller", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemAmuletRunic", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemAmuletRunic", 1, 1, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemRingRunic", 1, 1, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemRingRunic", 1, 2, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemRingRunic", 1, 3, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemGirdleRunic", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemGirdleRunic", 1, 1, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemGirdleRunic", 1, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockWoodenDevice", 1, 4, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "blockWoodenDevice", 1, 5, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemPickaxeElemental", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemAxeElemental", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemSwordElemental", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemShovelElemental", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemHoeElemental", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "HoverHarness", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemGirdleHover", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "blockMirror", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "HandMirror", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "blockMirror", 1, 6, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "blockJar", 1, 1, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemHelmetFortress", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemChestplateFortress", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemLeggingsFortress", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemBowBone", 1, 0, missing));
        TCHelper.clearPages("RESEARCH");
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.1"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.2"));
        TCHelper.addResearchPage(
                "RESEARCH",
                new ResearchPage(
                        TCHelper.findCraftingRecipe(getModItem("Thaumcraft", "ItemThaumometer", 1, 0, missing))));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.3"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.4"));
        TCHelper.addResearchPage(
                "RESEARCH",
                new ResearchPage(TCHelper.findCraftingRecipe(getModItem("Thaumcraft", "ItemInkwell", 1, 0, missing))));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.5"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.6"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.7"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.8"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.9"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.10"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.11"));
        TCHelper.addResearchPage("RESEARCH", new ResearchPage("tc.research_page.RESEARCH.12"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GOGGLES",
                getModItem("Thaumcraft", "ItemGoggles", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("ignis"), 30).add(Aspect.getAspect("aqua"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                'b',
                "screwGold",
                'c',
                getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                'd',
                "ringGold",
                'e',
                "craftingToolScrewdriver",
                'f',
                "ringGold",
                'g',
                getModItem("Thaumcraft", "ItemThaumometer", 1, 0, missing),
                'h',
                "stickGold",
                'i',
                getModItem("Thaumcraft", "ItemThaumometer", 1, 0, missing));
        TCHelper.setResearchAspects(
                "GOGGLES",
                new AspectList().add(Aspect.getAspect("auram"), 3).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("sensus"), 9).add(Aspect.getAspect("instrumentum"), 6));
        TCHelper.setResearchComplexity("GOGGLES", 2);
        TCHelper.clearPages("BASICARTIFACE");
        TCHelper.addResearchPage("BASICARTIFACE", new ResearchPage("tc.research_page.BASICARTIFACE.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BASICARTIFACE",
                getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                'b',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                'c',
                getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 28351, missing),
                'e',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 28351, missing),
                'g',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'h',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing));
        TCHelper.addResearchPage(
                "BASICARTIFACE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemResource", 1, 15, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BASICARTIFACE",
                getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 5).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "wireFineGold",
                'b',
                "wireFineGold",
                'c',
                "wireFineGold",
                'd',
                "wireFineGold",
                'e',
                "craftingToolScrewdriver",
                'f',
                "wireFineGold",
                'g',
                "screwGold",
                'h',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'i',
                "screwGold");
        TCHelper.addResearchPage(
                "BASICARTIFACE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BASICARTIFACE",
                getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("terra"), 10).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "screwGold",
                'b',
                "stickGold",
                'c',
                "screwGold",
                'd',
                "stickGold",
                'e',
                "craftingToolScrewdriver",
                'f',
                "stickGold",
                'g',
                "screwGold",
                'h',
                "stickGold",
                'i',
                "screwGold");
        TCHelper.addResearchPage(
                "BASICARTIFACE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 1, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BASICARTIFACE",
                getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("terra"), 10).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "screwGold",
                'b',
                "materialHardenedleather",
                'c',
                "screwGold",
                'd',
                "materialHardenedleather",
                'e',
                "craftingToolScrewdriver",
                'f',
                "materialHardenedleather",
                'g',
                "screwGold",
                'h',
                "ringGold",
                'i',
                "screwGold");
        TCHelper.addResearchPage(
                "BASICARTIFACE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 2, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BASICARTIFACE",
                getModItem("Thaumcraft", "ItemResource", 1, 10, missing),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("ignis"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                createItemStack("IC2", "itemFluidCell", 1, 0, "{Fluid:{FluidName:\"ender\",Amount:1000}}", missing),
                'b',
                "gemMercury",
                'c',
                createItemStack("IC2", "itemFluidCell", 1, 0, "{Fluid:{FluidName:\"ender\",Amount:1000}}", missing),
                'd',
                "gemMercury",
                'e',
                getModItem("minecraft", "glass_pane", 1, 0, missing),
                'f',
                "gemMercury",
                'g',
                createItemStack("IC2", "itemFluidCell", 1, 0, "{Fluid:{FluidName:\"ender\",Amount:1000}}", missing),
                'h',
                "gemMercury",
                'i',
                createItemStack("IC2", "itemFluidCell", 1, 0, "{Fluid:{FluidName:\"ender\",Amount:1000}}", missing));
        TCHelper.addResearchPage(
                "BASICARTIFACE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemResource", 1, 10, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARCANESTONE",
                getModItem("Thaumcraft", "blockCosmeticSolid", 8, 6, missing),
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("terra"), 8)
                        .add(Aspect.getAspect("ignis"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("ordo"), 8).add(Aspect.getAspect("perditio"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "stone",
                'b',
                "stone",
                'c',
                "stone",
                'd',
                "stone",
                'e',
                getModItem("Thaumcraft", "blockCrystal", 1, 32767, missing),
                'f',
                "stone",
                'g',
                "stone",
                'h',
                "stone",
                'i',
                "stone");
        TCHelper.clearPages("ARCANESTONE");
        TCHelper.addResearchPage("ARCANESTONE", new ResearchPage("tc.research_page.ARCANESTONE.1"));
        TCHelper.addResearchPage(
                "ARCANESTONE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing))));
        TCHelper.addResearchPage(
                "ARCANESTONE",
                new ResearchPage(
                        TCHelper.findCraftingRecipe(
                                getModItem("Thaumcraft", "blockStairsArcaneStone", 1, 0, missing))));
        TCHelper.addResearchPage(
                "ARCANESTONE",
                new ResearchPage(
                        TCHelper.findCraftingRecipe(
                                getModItem("Thaumcraft", "blockCosmeticSlabStone", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "INFUSION",
                getModItem("Thaumcraft", "blockStoneDevice", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("aer"), 40).add(Aspect.getAspect("terra"), 40)
                        .add(Aspect.getAspect("ignis"), 40).add(Aspect.getAspect("aqua"), 40)
                        .add(Aspect.getAspect("ordo"), 40).add(Aspect.getAspect("perditio"), 40),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'b',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'c',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'd',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'e',
                getModItem("minecraft", "ender_eye", 1, 0, missing),
                'f',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'g',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'h',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'i',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "INFUSION",
                getModItem("Thaumcraft", "blockStoneDevice", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'b',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'c',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'e',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'g',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'h',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'i',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing));
        TCHelper.setResearchAspects(
                "INFUSION",
                new AspectList().add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("machina"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("cognitio"), 6)
                        .add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("INFUSION", 2);
        TCHelper.clearPages("PAVETRAVEL");
        TCHelper.addResearchPage("PAVETRAVEL", new ResearchPage("tc.research_page.PAVETRAVEL.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "PAVETRAVEL",
                getModItem("Thaumcraft", "blockCosmeticSolid", 4, 2, missing),
                new AspectList().add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("terra"), 12),
                "abc",
                "def",
                "ghi",
                'a',
                "plateInfusedAir",
                'b',
                "plateInfusedEarth",
                'c',
                "plateInfusedAir",
                'd',
                "plateInfusedEarth",
                'e',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'f',
                "plateInfusedEarth",
                'g',
                "plateInfusedAir",
                'h',
                "plateInfusedEarth",
                'i',
                "plateInfusedAir");
        TCHelper.addResearchPage(
                "PAVETRAVEL",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "blockCosmeticSolid", 1, 2, missing))));
        TCHelper.setResearchAspects(
                "PAVETRAVEL",
                new AspectList().add(Aspect.getAspect("iter"), 9).add(Aspect.getAspect("volatus"), 6)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("PAVETRAVEL", 2);
        TCHelper.clearPages("PAVEWARD");
        TCHelper.addResearchPage("PAVEWARD", new ResearchPage("tc.research_page.PAVEWARD.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "PAVEWARD",
                getModItem("Thaumcraft", "blockCosmeticSolid", 4, 3, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 12).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("terra"), 12),
                "abc",
                "def",
                "ghi",
                'a',
                "plateInfusedOrder",
                'b',
                "plateInfusedFire",
                'c',
                "plateInfusedOrder",
                'd',
                "plateInfusedFire",
                'e',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'f',
                "plateInfusedFire",
                'g',
                "plateInfusedOrder",
                'h',
                "plateInfusedFire",
                'i',
                "plateInfusedOrder");
        TCHelper.addResearchPage(
                "PAVEWARD",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "blockCosmeticSolid", 1, 3, missing))));
        TCHelper.addResearchPage("PAVEWARD", new ResearchPage("tc.research_page.PAVEWARD.2"));
        TCHelper.setResearchAspects(
                "PAVEWARD",
                new AspectList().add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("bestia"), 9)
                        .add(Aspect.getAspect("vinculum"), 3).add(Aspect.getAspect("telum"), 6));
        TCHelper.setResearchComplexity("PAVEWARD", 2);
        TCHelper.clearPages("GRATE");
        TCHelper.addResearchPage("GRATE", new ResearchPage("tc.research_page.GRATE.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GRATE",
                getModItem("Thaumcraft", "blockMetalDevice", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "screwSteel",
                'b',
                getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                'c',
                "screwSteel",
                'd',
                "wireGt01RedAlloy",
                'e',
                getModItem("dreamcraft", "item.AluminiumBars", 1, 0, missing),
                'f',
                "craftingToolScrewdriver",
                'g',
                "screwSteel",
                'h',
                getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                'i',
                "screwSteel");
        TCHelper.addResearchPage(
                "GRATE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "blockMetalDevice", 1, 5, missing))));
        TCHelper.clearPages("ENCHFABRIC");
        TCHelper.addResearchPage("ENCHFABRIC", new ResearchPage("tc.research_page.ENCHFABRIC.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENCHFABRIC",
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("ignis"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("minecraft", "string", 1, 0, missing),
                'b',
                getModItem("minecraft", "string", 1, 0, missing),
                'c',
                getModItem("minecraft", "string", 1, 0, missing),
                'd',
                getModItem("harvestcraft", "wovencottonItem", 1, 0, missing),
                'e',
                getModItem("harvestcraft", "wovencottonItem", 1, 0, missing),
                'f',
                getModItem("harvestcraft", "wovencottonItem", 1, 0, missing),
                'g',
                getModItem("minecraft", "string", 1, 0, missing),
                'h',
                getModItem("minecraft", "string", 1, 0, missing),
                'i',
                getModItem("minecraft", "string", 1, 0, missing));
        TCHelper.setResearchAspects(
                "ENCHFABRIC",
                new AspectList().add(Aspect.getAspect("pannus"), 6).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("tutamen"), 3));
        TCHelper.setResearchComplexity("ENCHFABRIC", 1);
        TCHelper.addResearchPage(
                "ENCHFABRIC",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemResource", 1, 7, missing))));
        TCHelper.addResearchPage("ENCHFABRIC", new ResearchPage("tc.research_page.ENCHFABRIC.2"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENCHFABRIC",
                getModItem("Thaumcraft", "ItemChestplateRobe", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("ordo"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'b',
                "plateThaumium",
                'c',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'd',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'e',
                "plateThaumium",
                'f',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'g',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'h',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'i',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing));
        TCHelper.addResearchPage(
                "ENCHFABRIC",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemChestplateRobe", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENCHFABRIC",
                getModItem("Thaumcraft", "ItemLeggingsRobe", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("perditio"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'b',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'c',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'd',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'e',
                "plateThaumium",
                'f',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'g',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'h',
                "plateThaumium",
                'i',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing));
        TCHelper.addResearchPage(
                "ENCHFABRIC",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemLeggingsRobe", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENCHFABRIC",
                getModItem("Thaumcraft", "ItemBootsRobe", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("aqua"), 15),
                "abc",
                "def",
                "ghi",
                'd',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'e',
                "plateThaumium",
                'f',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'g',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'h',
                "plateThaumium",
                'i',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing));
        TCHelper.addResearchPage(
                "ENCHFABRIC",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemBootsRobe", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARCANELAMP",
                getModItem("Thaumcraft", "blockMetalDevice", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("perditio"), 5)
                        .add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("aqua"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "paneGlassColorless",
                'b',
                getModItem("minecraft", "daylight_detector", 1, 0, missing),
                'c',
                "paneGlassColorless",
                'd',
                "plateSteel",
                'e',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 0, missing),
                'f',
                "plateSteel",
                'g',
                "paneGlassColorless",
                'h',
                getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                'i',
                "paneGlassColorless");
        TCHelper.setResearchAspects(
                "ARCANELAMP",
                new AspectList().add(Aspect.getAspect("lux"), 6).add(Aspect.getAspect("tenebrae"), 3)
                        .add(Aspect.getAspect("sensus"), 6));
        TCHelper.setResearchComplexity("ARCANELAMP", 1);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "LAMPGROWTH",
                getModItem("Thaumcraft", "blockMetalDevice", 1, 8, missing),
                5,
                new AspectList().add(Aspect.getAspect("herba"), 20).add(Aspect.getAspect("lux"), 10)
                        .add(Aspect.getAspect("victus"), 20).add(Aspect.getAspect("messis"), 10),
                getModItem("Thaumcraft", "blockMetalDevice", 1, 7, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("minecraft", "dye", 1, 15, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("minecraft", "dye", 1, 15, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing), });
        TCHelper.setResearchAspects(
                "LAMPGROWTH",
                new AspectList().add(Aspect.getAspect("messis"), 9).add(Aspect.getAspect("lux"), 3)
                        .add(Aspect.getAspect("herba"), 6).add(Aspect.getAspect("victus"), 9));
        TCHelper.setResearchComplexity("LAMPGROWTH", 2);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "LAMPFERTILITY",
                getModItem("Thaumcraft", "blockMetalDevice", 1, 13, missing),
                5,
                new AspectList().add(Aspect.getAspect("bestia"), 20).add(Aspect.getAspect("lux"), 10)
                        .add(Aspect.getAspect("victus"), 20).add(Aspect.getAspect("sano"), 10),
                getModItem("Thaumcraft", "blockMetalDevice", 1, 7, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("minecraft", "wheat", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("minecraft", "golden_carrot", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 1, missing), });
        TCHelper.setResearchAspects(
                "LAMPFERTILITY",
                new AspectList().add(Aspect.getAspect("bestia"), 9).add(Aspect.getAspect("lux"), 3)
                        .add(Aspect.getAspect("victus"), 9).add(Aspect.getAspect("sano"), 6));
        TCHelper.setResearchComplexity("LAMPFERTILITY", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "LEVITATOR",
                getModItem("Thaumcraft", "blockLifter", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                'b',
                "plateInfusedAir",
                'c',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                'd',
                getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                'e',
                "rotorThaumium",
                'f',
                getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                'g',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                'h',
                "plateInfusedEarth",
                'i',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing));
        TCHelper.setResearchAspects(
                "LEVITATOR",
                new AspectList().add(Aspect.getAspect("aer"), 3).add(Aspect.getAspect("volatus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3).add(Aspect.getAspect("motus"), 6));
        TCHelper.setResearchComplexity("LEVITATOR", 1);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "WARDEDARCANA",
                getModItem("Thaumcraft", "ItemArcaneDoor", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                'b',
                getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                'c',
                "craftingToolScrewdriver",
                'd',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                'e',
                "ringThaumium",
                'f',
                "screwThaumium",
                'g',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                'h',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                'i',
                "craftingToolSaw");
        TCHelper.setResearchAspects(
                "WARDEDARCANA",
                new AspectList().add(Aspect.getAspect("tutamen"), 6).add(Aspect.getAspect("instrumentum"), 6)
                        .add(Aspect.getAspect("machina"), 6).add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("WARDEDARCANA", 1);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "WARDEDARCANA",
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                "craftingToolScrewdriver",
                'c',
                "screwThaumium",
                'd',
                getModItem("Thaumcraft", "blockCosmeticSlabWood", 1, 0, missing),
                'e',
                getModItem("minecraft", "heavy_weighted_pressure_plate", 1, 0, missing),
                'f',
                getModItem("Thaumcraft", "blockCosmeticSlabWood", 1, 0, missing),
                'g',
                "plateThaumium",
                'h',
                getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                'i',
                "plateThaumium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "WARDEDARCANA",
                getModItem("Thaumcraft", "blockCosmeticOpaque", 4, 2, missing),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("aqua"), 10)
                        .add(Aspect.getAspect("ignis"), 10).add(Aspect.getAspect("ordo"), 10)
                        .add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("terra"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "blockGlass",
                'b',
                "plateThaumium",
                'c',
                "blockGlass",
                'd',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                'e',
                getModItem("Thaumcraft", "FocusWarding", 1, 0, missing),
                'f',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                'g',
                "blockGlass",
                'h',
                "plateThaumium",
                'i',
                "blockGlass");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "WARDEDARCANA",
                getModItem("Thaumcraft", "ArcaneDoorKey", 2, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "stickIron",
                'b',
                "stickIron",
                'c',
                "ringIron",
                'd',
                "boltIron",
                'e',
                "boltIron",
                'f',
                "plateSteel",
                'g',
                "boltIron",
                'h',
                getModItem("Thaumcraft", "ItemResource", 1, 1, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "WARDEDARCANA",
                getModItem("Thaumcraft", "ArcaneDoorKey", 2, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "stickGold",
                'b',
                "stickGold",
                'c',
                "ringGold",
                'd',
                "boltGold",
                'e',
                "boltGold",
                'f',
                "craftingToolScrewdriver",
                'g',
                "boltGold",
                'h',
                "craftingToolHardHammer");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARCANEEAR",
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 32690, missing),
                'c',
                "plateThaumium",
                'd',
                "plateGold",
                'e',
                getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                'f',
                "plateGold",
                'g',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                'h',
                "wireGt01RedAlloy",
                'i',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing));
        TCHelper.setResearchAspects(
                "ARCANEEAR",
                new AspectList().add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("sensus"), 9)
                        .add(Aspect.getAspect("praecantatio"), 3).add(Aspect.getAspect("potentia"), 6));
        TCHelper.setResearchComplexity("ARCANEEAR", 2);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SINSTONE",
                getModItem("Thaumcraft", "ItemCompassStone", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("alienis"), 10).add(Aspect.getAspect("auram"), 10)
                        .add(Aspect.getAspect("sensus"), 10).add(Aspect.getAspect("tenebrae"), 10)
                        .add(Aspect.getAspect("ordo"), 10),
                getModItem("minecraft", "flint", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                        getModItem("Thaumcraft", "ItemShard", 1, 4, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 9, missing),
                        getModItem("Thaumcraft", "ItemShard", 1, 5, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemShard", 1, 6, missing), });
        TCHelper.setResearchAspects(
                "SINSTONE",
                new AspectList().add(Aspect.getAspect("auram"), 6).add(Aspect.getAspect("sensus"), 3)
                        .add(Aspect.getAspect("tenebrae"), 6).add(Aspect.getAspect("alienis"), 6));
        TCHelper.setResearchComplexity("SINSTONE", 2);
        ThaumcraftApi.addWarpToResearch("SINSTONE", 1);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BELLOWS",
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticSlabWood", 1, 0, missing),
                'b',
                "shardAir",
                'c',
                getModItem("Thaumcraft", "blockCosmeticSlabWood", 1, 0, missing),
                'd',
                getModItem("Backpack", "tannedLeather", 1, 0, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32640, missing),
                'f',
                getModItem("Backpack", "tannedLeather", 1, 0, missing),
                'g',
                getModItem("Thaumcraft", "blockCosmeticSlabWood", 1, 0, missing),
                'h',
                "shardAir",
                'i',
                getModItem("Thaumcraft", "blockCosmeticSlabWood", 1, 0, missing));
        TCHelper.setResearchAspects(
                "BELLOWS",
                new AspectList().add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("aer"), 12)
                        .add(Aspect.getAspect("praecantatio"), 3).add(Aspect.getAspect("machina"), 9));
        TCHelper.setResearchComplexity("BELLOWS", 2);
        TCHelper.clearPages("FLUXSCRUB");
        TCHelper.addResearchPage("FLUXSCRUB", new ResearchPage("tc.research_page.FLUXSCRUB.1"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FLUXSCRUB",
                getModItem("Thaumcraft", "blockStoneDevice", 1, 14, missing),
                4,
                new AspectList().add(Aspect.getAspect("aqua"), 25).add(Aspect.getAspect("aer"), 20)
                        .add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("vinculum"), 10)
                        .add(Aspect.getAspect("vitium"), 5),
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "blockTube", 1, 0, missing),
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                        getModItem("Thaumcraft", "blockTube", 1, 1, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing), });
        TCHelper.addResearchPage(
                "FLUXSCRUB",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("Thaumcraft", "blockStoneDevice", 1, 14, missing))));
        TCHelper.setResearchAspects(
                "FLUXSCRUB",
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("vinculum"), 6)
                        .add(Aspect.getAspect("vitium"), 3));
        TCHelper.setResearchComplexity("FLUXSCRUB", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "BOOTSTRAVELLER",
                getModItem("Thaumcraft", "BootsTraveller", 1, 0, missing),
                2,
                new AspectList().add(Aspect.getAspect("volatus"), 25).add(Aspect.getAspect("aer"), 25)
                        .add(Aspect.getAspect("iter"), 25).add(Aspect.getAspect("aqua"), 5),
                getModItem("minecraft", "leather_boots", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("minecraft", "feather", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("minecraft", "fish", 1, 32767, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing), });
        TCHelper.setResearchAspects(
                "BOOTSTRAVELLER",
                new AspectList().add(Aspect.getAspect("aqua"), 9).add(Aspect.getAspect("iter"), 15)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("volatus"), 12)
                        .add(Aspect.getAspect("aer"), 3));
        TCHelper.setResearchComplexity("BOOTSTRAVELLER", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNICARMOR",
                getModItem("Thaumcraft", "ItemRingRunic", 1, 1, missing),
                2,
                new AspectList().add(Aspect.getAspect("potentia"), 25).add(Aspect.getAspect("tutamen"), 25)
                        .add(Aspect.getAspect("praecantatio"), 25).add(Aspect.getAspect("alienis"), 5),
                getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 1, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29514, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("Thaumcraft", "ItemInkwell", 1, 0, missing),
                        getModItem("minecraft", "blaze_powder", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29514, missing), });
        TCHelper.setResearchAspects(
                "RUNICARMOR",
                new AspectList().add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("tutamen"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("RUNICARMOR", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNICCHARGED",
                getModItem("Thaumcraft", "ItemRingRunic", 1, 2, missing),
                6,
                new AspectList().add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("tutamen"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("aer"), 8),
                getModItem("Thaumcraft", "ItemRingRunic", 1, 1, missing),
                new ItemStack[] { getModItem("minecraft", "potion", 1, 8226, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                        getModItem("minecraft", "potion", 1, 8226, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 1, missing), });
        TCHelper.setResearchAspects(
                "RUNICCHARGED",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("tutamen"), 9).add(Aspect.getAspect("alienis"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("cognitio"), 6)
                        .add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("RUNICCHARGED", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNICHEALING",
                getModItem("Thaumcraft", "ItemRingRunic", 1, 3, missing),
                6,
                new AspectList().add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("sano"), 32).add(Aspect.getAspect("tutamen"), 32)
                        .add(Aspect.getAspect("aer"), 8),
                getModItem("Thaumcraft", "ItemRingRunic", 1, 1, missing),
                new ItemStack[] { getModItem("minecraft", "potion", 1, 8225, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                        getModItem("minecraft", "potion", 1, 8225, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 2, missing), });
        TCHelper.setResearchAspects(
                "RUNICHEALING",
                new AspectList().add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("sano"), 12).add(Aspect.getAspect("tutamen"), 9)
                        .add(Aspect.getAspect("alienis"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("RUNICHEALING", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNICARMOR",
                getModItem("Thaumcraft", "ItemAmuletRunic", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("potentia"), 40).add(Aspect.getAspect("tutamen"), 40)
                        .add(Aspect.getAspect("praecantatio"), 40).add(Aspect.getAspect("alienis"), 20),
                getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29514, missing),
                        getModItem("minecraft", "blaze_powder", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("Thaumcraft", "ItemInkwell", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("minecraft", "blaze_powder", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29514, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNICEMERGENCY",
                getModItem("Thaumcraft", "ItemAmuletRunic", 1, 1, missing),
                8,
                new AspectList().add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("terra"), 64)
                        .add(Aspect.getAspect("tutamen"), 64).add(Aspect.getAspect("vacuos"), 32)
                        .add(Aspect.getAspect("sano"), 8),
                getModItem("Thaumcraft", "ItemAmuletRunic", 1, 0, missing),
                new ItemStack[] { getModItem("minecraft", "potion", 1, 8233, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("minecraft", "potion", 1, 8233, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing), });
        TCHelper.setResearchAspects(
                "RUNICEMERGENCY",
                new AspectList().add(Aspect.getAspect("vacuos"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("tutamen"), 9)
                        .add(Aspect.getAspect("alienis"), 6).add(Aspect.getAspect("sano"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("RUNICEMERGENCY", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNICARMOR",
                getModItem("Thaumcraft", "ItemGirdleRunic", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("potentia"), 55).add(Aspect.getAspect("tutamen"), 55)
                        .add(Aspect.getAspect("praecantatio"), 55).add(Aspect.getAspect("alienis"), 35),
                getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 2, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29514, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("minecraft", "blaze_powder", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("Thaumcraft", "ItemInkwell", 1, 0, missing),
                        getModItem("minecraft", "blaze_powder", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("minecraft", "blaze_powder", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29514, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNICKINETIC",
                getModItem("Thaumcraft", "ItemGirdleRunic", 1, 1, missing),
                8,
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("praecantatio"), 64)
                        .add(Aspect.getAspect("tutamen"), 64).add(Aspect.getAspect("bestia"), 32)
                        .add(Aspect.getAspect("telum"), 8),
                getModItem("Thaumcraft", "ItemGirdleRunic", 1, 0, missing),
                new ItemStack[] { getModItem("minecraft", "potion", 1, 16428, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("minecraft", "potion", 1, 16428, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "RUNICKINETIC",
                new AspectList().add(Aspect.getAspect("aer"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("tutamen"), 12).add(Aspect.getAspect("telum"), 9)
                        .add(Aspect.getAspect("alienis"), 9).add(Aspect.getAspect("bestia"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("RUNICKINETIC", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ARCANEBORE",
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 5, missing),
                6,
                new AspectList().add(Aspect.getAspect("machina"), 64).add(Aspect.getAspect("motus"), 32)
                        .add(Aspect.getAspect("perditio"), 64).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("vacuos"), 32),
                getModItem("gregtech", "gt.metaitem.01", 1, 32641, missing),
                new ItemStack[] { getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 24500, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemShovelThaumium", 1, 0, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 24500, missing),
                        getModItem("Thaumcraft", "ItemPickThaumium", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ARCANEBORE",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("perfodio"), 12)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("motus"), 9)
                        .add(Aspect.getAspect("vacuos"), 3).add(Aspect.getAspect("cognitio"), 6));
        TCHelper.setResearchComplexity("ARCANEBORE", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARCANEBORE",
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("ordo"), 30)
                        .add(Aspect.getAspect("terra"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticSlabWood", 1, 0, missing),
                'b',
                "pipeSmallSteel",
                'c',
                getModItem("Thaumcraft", "blockCosmeticSlabWood", 1, 0, missing),
                'd',
                "plateSteel",
                'e',
                getModItem("minecraft", "dispenser", 1, 0, missing),
                'f',
                "plateSteel",
                'g',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                'h',
                "wireFineSteel",
                'i',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ELEMENTALPICK",
                getModItem("Thaumcraft", "ItemPickaxeElemental", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("perfodio"), 20)
                        .add(Aspect.getAspect("sensus"), 20).add(Aspect.getAspect("lucrum"), 20),
                getModItem("Thaumcraft", "ItemPickThaumium", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.02", 1, 29502, missing),
                        getModItem("Thaumcraft", "blockMagicalLog", 1, 1, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29500, missing),
                        getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 1, missing), });
        TCHelper.setResearchAspects(
                "ELEMENTALPICK",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("perfodio"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("ELEMENTALPICK", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ELEMENTALAXE",
                getModItem("Thaumcraft", "ItemAxeElemental", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("aqua"), 10).add(Aspect.getAspect("arbor"), 20)
                        .add(Aspect.getAspect("fabrico"), 20).add(Aspect.getAspect("motus"), 20),
                getModItem("Thaumcraft", "ItemAxeThaumium", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.02", 1, 29503, missing),
                        getModItem("Thaumcraft", "blockMagicalLog", 1, 1, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29500, missing),
                        getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 2, missing), });
        TCHelper.setResearchAspects(
                "ELEMENTALAXE",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("motus"), 12)
                        .add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("aqua"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("ELEMENTALAXE", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ELEMENTALSWORD",
                getModItem("Thaumcraft", "ItemSwordElemental", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("motus"), 20)
                        .add(Aspect.getAspect("potentia"), 20).add(Aspect.getAspect("telum"), 20),
                getModItem("Thaumcraft", "ItemSwordThaumium", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.02", 1, 29528, missing),
                        getModItem("Thaumcraft", "blockMagicalLog", 1, 1, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29500, missing),
                        getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ELEMENTALSWORD",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("telum"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("ELEMENTALSWORD", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ELEMENTALSHOVEL",
                getModItem("Thaumcraft", "ItemShovelElemental", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("fabrico"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("perfodio"), 10).add(Aspect.getAspect("praecantatio"), 20),
                getModItem("Thaumcraft", "ItemShovelThaumium", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.02", 1, 29501, missing),
                        getModItem("Thaumcraft", "blockMagicalLog", 1, 1, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29500, missing),
                        getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing), });
        TCHelper.setResearchAspects(
                "ELEMENTALSHOVEL",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("perfodio"), 9).add(Aspect.getAspect("fabrico"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("ELEMENTALSHOVEL", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ELEMENTALHOE",
                getModItem("Thaumcraft", "ItemHoeElemental", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("meto"), 10).add(Aspect.getAspect("herba"), 20)
                        .add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("messis"), 20),
                getModItem("Thaumcraft", "ItemHoeThaumium", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.02", 1, 29514, missing),
                        getModItem("Thaumcraft", "blockMagicalLog", 1, 1, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29500, missing),
                        getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 4, missing), });
        TCHelper.setResearchAspects(
                "ELEMENTALHOE",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("victus"), 12)
                        .add(Aspect.getAspect("meto"), 9).add(Aspect.getAspect("messis"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("ELEMENTALHOE", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "HOVERHARNESS",
                getModItem("Thaumcraft", "HoverHarness", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("iter"), 32).add(Aspect.getAspect("machina"), 64)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("volatus"), 32)
                        .add(Aspect.getAspect("tutamen"), 16),
                getModItem("minecraft", "leather_chestplate", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("ProjRed|Integration", "projectred.integration.gate", 1, 26, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing), });
        TCHelper.setResearchAspects(
                "HOVERHARNESS",
                new AspectList().add(Aspect.getAspect("volatus"), 15).add(Aspect.getAspect("machina"), 12)
                        .add(Aspect.getAspect("iter"), 9).add(Aspect.getAspect("aer"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("tutamen"), 3));
        TCHelper.setResearchComplexity("HOVERHARNESS", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "HOVERGIRDLE",
                getModItem("Thaumcraft", "ItemGirdleHover", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("iter"), 32)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("volatus"), 32)
                        .add(Aspect.getAspect("tutamen"), 16),
                getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 2, missing),
                new ItemStack[] { getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("minecraft", "feather", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17019, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("TwilightForest", "item.tfFeather", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "HOVERGIRDLE",
                new AspectList().add(Aspect.getAspect("volatus"), 15).add(Aspect.getAspect("motus"), 12)
                        .add(Aspect.getAspect("iter"), 9).add(Aspect.getAspect("aer"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("tutamen"), 3));
        TCHelper.setResearchComplexity("HOVERGIRDLE", 3);
        TCHelper.setResearchAspects(
                "RUNICARMOR",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("tutamen"), 9)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("RUNICARMOR", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "MIRROR",
                getModItem("Thaumcraft", "blockMirror", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("iter"), 32).add(Aspect.getAspect("permutatio"), 24)
                        .add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("alienis"), 8),
                getModItem("Thaumcraft", "ItemResource", 1, 10, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17367, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing), });
        TCHelper.setResearchAspects(
                "MIRROR",
                new AspectList().add(Aspect.getAspect("vitreus"), 15).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("MIRROR", 3);
        ThaumcraftApi.addWarpToResearch("MIRROR", 2);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "MIRRORHAND",
                getModItem("Thaumcraft", "HandMirror", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("instrumentum"), 64).add(Aspect.getAspect("iter"), 32)
                        .add(Aspect.getAspect("motus"), 24).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("potentia"), 8),
                getModItem("Thaumcraft", "blockMirror", 1, 0, missing),
                new ItemStack[] { getModItem("minecraft", "compass", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing),
                        getModItem("minecraft", "map", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing),
                        getModItem("Thaumcraft", "WandRod", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing), });
        TCHelper.setResearchAspects(
                "MIRRORHAND",
                new AspectList().add(Aspect.getAspect("iter"), 18).add(Aspect.getAspect("instrumentum"), 15)
                        .add(Aspect.getAspect("vitreus"), 12).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("MIRRORHAND", 3);
        ThaumcraftApi.addWarpToResearch("MIRRORHAND", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "MIRRORESSENTIA",
                getModItem("Thaumcraft", "blockMirror", 1, 6, missing),
                2,
                new AspectList().add(Aspect.getAspect("aqua"), 24).add(Aspect.getAspect("iter"), 32)
                        .add(Aspect.getAspect("permutatio"), 16).add(Aspect.getAspect("vitreus"), 8),
                getModItem("Thaumcraft", "ItemResource", 1, 10, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 17028, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17028, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17305, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing), });
        TCHelper.setResearchAspects(
                "MIRRORESSENTIA",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("vitreus"), 9).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("MIRRORESSENTIA", 3);
        ThaumcraftApi.addWarpToResearch("MIRRORESSENTIA", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "JARBRAIN",
                getModItem("Thaumcraft", "blockJar", 1, 1, missing),
                5,
                new AspectList().add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("exanimis"), 30)
                        .add(Aspect.getAspect("sensus"), 15).add(Aspect.getAspect("alienis"), 10),
                getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                        getModItem("minecraft", "poisonous_potato", 1, 0, missing),
                        getModItem("minecraft", "spider_eye", 1, 0, missing),
                        getModItem("minecraft", "water_bucket", 1, 0, missing),
                        getModItem("minecraft", "spider_eye", 1, 0, missing),
                        getModItem("minecraft", "poisonous_potato", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "JARBRAIN",
                new AspectList().add(Aspect.getAspect("lucrum"), 15).add(Aspect.getAspect("fames"), 12)
                        .add(Aspect.getAspect("exanimis"), 9).add(Aspect.getAspect("cognitio"), 9)
                        .add(Aspect.getAspect("alienis"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("JARBRAIN", 3);
        TCHelper.setResearchAspects(
                "INFUSIONENCHANTMENT",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("tutamen"), 12).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("telum"), 9).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("alienis"), 6));
        TCHelper.setResearchComplexity("INFUSIONENCHANTMENT", 4);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ARMORFORTRESS",
                getModItem("Thaumcraft", "ItemHelmetFortress", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("metallum"), 32).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("victus"), 16),
                getModItem("Thaumcraft", "ItemHelmetThaumium", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.02", 1, 29501, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing), });
        TCHelper.setResearchAspects(
                "ARMORFORTRESS",
                new AspectList().add(Aspect.getAspect("fabrico"), 15).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("tutamen"), 9).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("ARMORFORTRESS", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ARMORFORTRESS",
                getModItem("Thaumcraft", "ItemChestplateFortress", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("metallum"), 32).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("tutamen"), 40).add(Aspect.getAspect("cognitio"), 16),
                getModItem("Thaumcraft", "ItemChestplateThaumium", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ARMORFORTRESS",
                getModItem("Thaumcraft", "ItemLeggingsFortress", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("metallum"), 32).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("tutamen"), 24).add(Aspect.getAspect("terra"), 16),
                getModItem("Thaumcraft", "ItemLeggingsThaumium", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing), });
        TCHelper.setResearchAspects(
                "HELMGOGGLES",
                new AspectList().add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("sensus"), 12)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("fabrico"), 3));
        TCHelper.setResearchComplexity("HELMGOGGLES", 3);
        TCHelper.setResearchAspects(
                "MASKGRINNINGDEVIL",
                new AspectList().add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("sano"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("fabrico"), 3));
        TCHelper.setResearchComplexity("MASKGRINNINGDEVIL", 3);
        ThaumcraftApi.addWarpToResearch("MASKGRINNINGDEVIL", 1);
        TCHelper.setResearchAspects(
                "MASKANGRYGHOST",
                new AspectList().add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("perditio"), 12)
                        .add(Aspect.getAspect("mortuus"), 9).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("fabrico"), 3));
        TCHelper.setResearchComplexity("MASKANGRYGHOST", 3);
        ThaumcraftApi.addWarpToResearch("MASKANGRYGHOST", 1);
        TCHelper.setResearchAspects(
                "MASKSIPPINGFIEND",
                new AspectList().add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("exanimis"), 12)
                        .add(Aspect.getAspect("victus"), 9).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("MASKSIPPINGFIEND", 3);
        ThaumcraftApi.addWarpToResearch("MASKSIPPINGFIEND", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BONEBOW",
                getModItem("Thaumcraft", "ItemBowBone", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("perditio"), 32)
                        .add(Aspect.getAspect("terra"), 32),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Natura", "barleyFood", 1, 7, missing),
                'b',
                getModItem("minecraft", "bone", 1, 0, missing),
                'c',
                "screwThaumium",
                'd',
                getModItem("Natura", "barleyFood", 1, 7, missing),
                'e',
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                'f',
                getModItem("dreamcraft", "item.LichBone", 1, 0, missing),
                'g',
                getModItem("Natura", "barleyFood", 1, 7, missing),
                'h',
                getModItem("minecraft", "bone", 1, 0, missing),
                'i',
                "screwThaumium");
        TCHelper.setResearchAspects(
                "BONEBOW",
                new AspectList().add(Aspect.getAspect("telum"), 12).add(Aspect.getAspect("motus"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("exanimis"), 3));
        TCHelper.setResearchComplexity("BONEBOW", 2);
        TCHelper.refreshResearchPages("THAUMOMETER");
        TCHelper.refreshResearchPages("GOGGLES");
        TCHelper.refreshResearchPages("TABLE");
        TCHelper.refreshResearchPages("ARCANESTONE");
        TCHelper.refreshResearchPages("INFUSION");
        TCHelper.refreshResearchPages("ARCANELAMP");
        TCHelper.refreshResearchPages("LAMPGROWTH");
        TCHelper.refreshResearchPages("LAMPFERTILITY");
        TCHelper.refreshResearchPages("PAVETRAVEL");
        TCHelper.refreshResearchPages("PAVEWARD");
        TCHelper.refreshResearchPages("LEVITATOR");
        TCHelper.refreshResearchPages("WARDEDARCANA");
        TCHelper.refreshResearchPages("ARCANEEAR");
        TCHelper.refreshResearchPages("SINSTONE");
        TCHelper.refreshResearchPages("BELLOWS");
        TCHelper.refreshResearchPages("FLUXSCRUB");
        TCHelper.refreshResearchPages("BOOTSTRAVELLER");
        TCHelper.refreshResearchPages("RUNICARMOR");
        TCHelper.refreshResearchPages("RUNICKINETIC");
        TCHelper.refreshResearchPages("RUNICEMERGENCY");
        TCHelper.refreshResearchPages("RUNICCHARGED");
        TCHelper.refreshResearchPages("RUNICHEALING");
        TCHelper.refreshResearchPages("ARCANEBORE");
        TCHelper.refreshResearchPages("ELEMENTALPICK");
        TCHelper.refreshResearchPages("ELEMENTALAXE");
        TCHelper.refreshResearchPages("ELEMENTALSWORD");
        TCHelper.refreshResearchPages("ELEMENTALSHOVEL");
        TCHelper.refreshResearchPages("ELEMENTALHOE");
        TCHelper.refreshResearchPages("HOVERHARNESS");
        TCHelper.refreshResearchPages("HOVERGIRDLE");
        TCHelper.refreshResearchPages("RUNICARMOR");
        TCHelper.refreshResearchPages("MIRROR");
        TCHelper.refreshResearchPages("MIRRORHAND");
        TCHelper.refreshResearchPages("MIRRORESSENTIA");
        TCHelper.refreshResearchPages("JARBRAIN");
        TCHelper.refreshResearchPages("INFUSIONENCHANTMENT");
        TCHelper.refreshResearchPages("ARMORFORTRESS");
        TCHelper.refreshResearchPages("HELMGOGGLES");
        TCHelper.refreshResearchPages("MASKGRINNINGDEVIL");
        TCHelper.refreshResearchPages("MASKANGRYGHOST");
        TCHelper.refreshResearchPages("MASKSIPPINGFIEND");
        TCHelper.refreshResearchPages("BONEBOW");
    }

    private void golemancy() {
        // GOLEMANCY

        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockChestHungry", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "TrunkSpawner", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockCosmeticSolid", 1, 9, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemPlacer", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemPlacer", 1, 1, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemPlacer", 1, 2, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemPlacer", 1, 3, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemPlacer", 1, 4, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemPlacer", 1, 5, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemPlacer", 1, 6, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemPlacer", 1, 7, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 100, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 2, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 1, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 3, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 4, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 8, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 10, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 5, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 6, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 9, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 11, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 7, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemGolemUpgrade", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemGolemUpgrade", 1, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemGolemUpgrade", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemGolemUpgrade", 1, 3, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemGolemUpgrade", 1, 4, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemGolemUpgrade", 1, 5, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemGolemDecoration", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemGolemDecoration", 1, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemGolemDecoration", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemGolemDecoration", 1, 3, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemGolemDecoration", 1, 4, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemGolemDecoration", 1, 5, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemGolemDecoration", 1, 6, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemGolemDecoration", 1, 7, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "HUNGRYCHEST",
                getModItem("Thaumcraft", "blockChestHungry", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                getModItem("Thaumcraft", "blockMetalDevice", 1, 5, missing),
                'c',
                "screwThaumium",
                'd',
                getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                'e',
                "chestWood",
                'f',
                getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                'g',
                "screwThaumium",
                'h',
                "craftingToolScrewdriver",
                'i',
                "screwThaumium");
        TCHelper.setResearchAspects(
                "HUNGRYCHEST",
                new AspectList().add(Aspect.getAspect("fames"), 9).add(Aspect.getAspect("vacuos"), 6)
                        .add(Aspect.getAspect("iter"), 3));
        TCHelper.setResearchComplexity("HUNGRYCHEST", 1);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TRAVELTRUNK",
                getModItem("Thaumcraft", "TrunkSpawner", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("iter"), 16).add(Aspect.getAspect("motus"), 16)
                        .add(Aspect.getAspect("spiritus"), 16).add(Aspect.getAspect("vacuos"), 32),
                getModItem("Thaumcraft", "blockChestHungry", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 17306, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28306, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27306, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                        getModItem("Thaumcraft", "ItemGolemPlacer", 1, 1, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27306, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28306, missing), });
        TCHelper.setResearchAspects(
                "TRAVELTRUNK",
                new AspectList().add(Aspect.getAspect("spiritus"), 12).add(Aspect.getAspect("vacuos"), 12)
                        .add(Aspect.getAspect("arbor"), 9).add(Aspect.getAspect("iter"), 6)
                        .add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("TRAVELTRUNK", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GOLEMFETTER",
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 9, missing),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ordo"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'b',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'c',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'd',
                "plateThaumium",
                'e',
                "blockRedstone",
                'f',
                "plateThaumium",
                'g',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'h',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'i',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing));
        TCHelper.setResearchAspects(
                "GOLEMFETTER",
                new AspectList().add(Aspect.getAspect("vinculum"), 9).add(Aspect.getAspect("machina"), 9)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("GOLEMFETTER", 2);
        ThaumcraftApi.addCrucibleRecipe(
                "GOLEMSTRAW",
                getModItem("Thaumcraft", "ItemGolemPlacer", 1, 0, missing),
                getModItem("minecraft", "hay_block", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("humanus"), 10).add(Aspect.getAspect("motus"), 10)
                        .add(Aspect.getAspect("spiritus"), 10));
        TCHelper.setResearchAspects(
                "GOLEMSTRAW",
                new AspectList().add(Aspect.getAspect("messis"), 9).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("spiritus"), 9).add(Aspect.getAspect("motus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("GOLEMSTRAW", 2);
        ThaumcraftApi.addCrucibleRecipe(
                "GOLEMWOOD",
                getModItem("Thaumcraft", "ItemGolemPlacer", 1, 1, missing),
                getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("humanus"), 14).add(Aspect.getAspect("motus"), 14)
                        .add(Aspect.getAspect("spiritus"), 14));
        TCHelper.setResearchAspects(
                "GOLEMWOOD",
                new AspectList().add(Aspect.getAspect("arbor"), 12).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("spiritus"), 9).add(Aspect.getAspect("motus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("GOLEMWOOD", 3);
        TCHelper.clearPages("GOLEMTALLOW");
        TCHelper.addResearchPage("GOLEMTALLOW", new ResearchPage("tc.research_page.GOLEMTALLOW.1"));
        ThaumcraftApi.addCrucibleRecipe(
                "GOLEMTALLOW",
                getModItem("Thaumcraft", "ItemGolemPlacer", 1, 2, missing),
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("humanus"), 26).add(Aspect.getAspect("mortuus"), 26)
                        .add(Aspect.getAspect("spiritus"), 26));
        TCHelper.addResearchPage(
                "GOLEMTALLOW",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemPlacer", 1, 2, missing))));
        TCHelper.setResearchAspects(
                "GOLEMTALLOW",
                new AspectList().add(Aspect.getAspect("spiritus"), 12).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("corpus"), 15).add(Aspect.getAspect("motus"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6));
        TCHelper.setResearchComplexity("GOLEMTALLOW", 3);
        ThaumcraftApi.addCrucibleRecipe(
                "GOLEMCLAY",
                getModItem("Thaumcraft", "ItemGolemPlacer", 1, 3, missing),
                getModItem("minecraft", "clay", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("humanus"), 20).add(Aspect.getAspect("motus"), 20)
                        .add(Aspect.getAspect("spiritus"), 20));
        TCHelper.setResearchAspects(
                "GOLEMCLAY",
                new AspectList().add(Aspect.getAspect("spiritus"), 12).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("motus"), 12).add(Aspect.getAspect("terra"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("GOLEMCLAY", 3);
        TCHelper.clearPages("GOLEMFLESH");
        TCHelper.addResearchPage("GOLEMFLESH", new ResearchPage("tc.research_page.GOLEMFLESH.1"));
        ThaumcraftApi.addCrucibleRecipe(
                "GOLEMFLESH",
                getModItem("Thaumcraft", "ItemGolemPlacer", 1, 4, missing),
                getModItem("Thaumcraft", "blockTaint", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("humanus"), 20).add(Aspect.getAspect("motus"), 20)
                        .add(Aspect.getAspect("spiritus"), 20));
        TCHelper.addResearchPage(
                "GOLEMFLESH",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemPlacer", 1, 4, missing))));
        TCHelper.setResearchAspects(
                "GOLEMFLESH",
                new AspectList().add(Aspect.getAspect("corpus"), 12).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("spiritus"), 12).add(Aspect.getAspect("motus"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("mortuus"), 3));
        TCHelper.setResearchComplexity("GOLEMFLESH", 3);
        ThaumcraftApi.addCrucibleRecipe(
                "GOLEMSTONE",
                getModItem("Thaumcraft", "ItemGolemPlacer", 1, 5, missing),
                getModItem("ExtraUtilities", "cobblestone_compressed", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("humanus"), 26).add(Aspect.getAspect("mortuus"), 26)
                        .add(Aspect.getAspect("spiritus"), 26));
        TCHelper.setResearchAspects(
                "GOLEMSTONE",
                new AspectList().add(Aspect.getAspect("spiritus"), 12).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("motus"), 12).add(Aspect.getAspect("terra"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("perditio"), 3));
        TCHelper.setResearchComplexity("GOLEMSTONE", 3);
        ThaumcraftApi.addCrucibleRecipe(
                "GOLEMIRON",
                getModItem("Thaumcraft", "ItemGolemPlacer", 1, 6, missing),
                getModItem("minecraft", "iron_block", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("humanus"), 32).add(Aspect.getAspect("mortuus"), 32)
                        .add(Aspect.getAspect("spiritus"), 32));
        TCHelper.setResearchAspects(
                "GOLEMIRON",
                new AspectList().add(Aspect.getAspect("permutatio"), 12).add(Aspect.getAspect("spiritus"), 12)
                        .add(Aspect.getAspect("motus"), 12).add(Aspect.getAspect("metallum"), 9)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("humanus"), 3));
        TCHelper.setResearchComplexity("GOLEMIRON", 3);
        TCHelper.clearPages("GOLEMTHAUMIUM");
        TCHelper.addResearchPage("GOLEMTHAUMIUM", new ResearchPage("tc.research_page.GOLEMTHAUMIUM.1"));
        ThaumcraftApi.addCrucibleRecipe(
                "GOLEMTHAUMIUM",
                getModItem("Thaumcraft", "ItemGolemPlacer", 1, 7, missing),
                "blockThaumium",
                new AspectList().add(Aspect.getAspect("humanus"), 40).add(Aspect.getAspect("mortuus"), 40)
                        .add(Aspect.getAspect("spiritus"), 40));
        TCHelper.addResearchPage(
                "GOLEMTHAUMIUM",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem("Thaumcraft", "ItemGolemPlacer", 1, 7, missing))));
        TCHelper.setResearchAspects(
                "GOLEMTHAUMIUM",
                new AspectList().add(Aspect.getAspect("permutatio"), 12).add(Aspect.getAspect("spiritus"), 12)
                        .add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("motus"), 9)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("terra"), 9)
                        .add(Aspect.getAspect("humanus"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("GOLEMTHAUMIUM", 3);
        TCHelper.setResearchAspects(
                "ADVANCEDGOLEM",
                new AspectList().add(Aspect.getAspect("sensus"), 15).add(Aspect.getAspect("victus"), 15)
                        .add(Aspect.getAspect("cognitio"), 12).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ADVANCEDGOLEM", 4);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "COREGATHER",
                getModItem("Thaumcraft", "ItemGolemCore", 1, 100, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                "ingotBrickNether",
                'c',
                "plateThaumium",
                'd',
                "ingotBrick",
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                'f',
                "ingotBrick",
                'g',
                "plateNetherQuartz",
                'h',
                "ingotBrickNether",
                'i',
                "plateNetherQuartz");
        ThaumcraftApi.addCrucibleRecipe(
                "COREGATHER",
                getModItem("Thaumcraft", "ItemGolemCore", 1, 2, missing),
                getModItem("Thaumcraft", "ItemGolemCore", 1, 100, missing),
                new AspectList().add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("terra"), 10));
        ThaumcraftApi.addCrucibleRecipe(
                "COREEMPTY",
                getModItem("Thaumcraft", "ItemGolemCore", 1, 1, missing),
                getModItem("Thaumcraft", "ItemGolemCore", 1, 100, missing),
                new AspectList().add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("vacuos"), 10));
        TCHelper.setResearchAspects(
                "COREEMPTY",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("vacuos"), 9)
                        .add(Aspect.getAspect("permutatio"), 6).add(Aspect.getAspect("motus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("COREEMPTY", 2);
        ThaumcraftApi.addCrucibleRecipe(
                "COREFILL",
                getModItem("Thaumcraft", "ItemGolemCore", 1, 0, missing),
                getModItem("Thaumcraft", "ItemGolemCore", 1, 100, missing),
                new AspectList().add(Aspect.getAspect("fames"), 10).add(Aspect.getAspect("vacuos"), 10));
        TCHelper.setResearchAspects(
                "COREFILL",
                new AspectList().add(Aspect.getAspect("fames"), 9).add(Aspect.getAspect("vacuos"), 9)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("motus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("COREFILL", 2);
        TCHelper.clearPages("COREHARVEST");
        TCHelper.addResearchPage("COREHARVEST", new ResearchPage("tc.research_page.COREHARVEST.1"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "COREHARVEST",
                getModItem("Thaumcraft", "ItemGolemCore", 1, 3, missing),
                4,
                new AspectList().add(Aspect.getAspect("messis"), 10).add(Aspect.getAspect("meto"), 10)
                        .add(Aspect.getAspect("herba"), 20),
                getModItem("Thaumcraft", "ItemGolemCore", 1, 100, missing),
                new ItemStack[] { getModItem("minecraft", "nether_star", 1, 0, missing),
                        getModItem("minecraft", "wheat_seeds", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemHoeThaumium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing), });
        TCHelper.addResearchPage(
                "COREHARVEST",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 3, missing))));
        TCHelper.addResearchPage("COREHARVEST", new ResearchPage("tc.research_page.COREHARVEST.2"));
        TCHelper.setResearchAspects(
                "COREHARVEST",
                new AspectList().add(Aspect.getAspect("meto"), 12).add(Aspect.getAspect("messis"), 12)
                        .add(Aspect.getAspect("iter"), 9).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("COREHARVEST", 3);
        TCHelper.clearPages("COREGUARD");
        TCHelper.addResearchPage("COREGUARD", new ResearchPage("tc.research_page.COREGUARD.1"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "COREGUARD",
                getModItem("Thaumcraft", "ItemGolemCore", 1, 4, missing),
                4,
                new AspectList().add(Aspect.getAspect("telum"), 20).add(Aspect.getAspect("vinculum"), 20)
                        .add(Aspect.getAspect("tutamen"), 20),
                getModItem("Thaumcraft", "ItemGolemCore", 1, 100, missing),
                new ItemStack[] { getModItem("minecraft", "nether_star", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17804, missing),
                        getModItem("Thaumcraft", "ItemSwordThaumium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing), });
        TCHelper.addResearchPage(
                "COREGUARD",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 4, missing))));
        TCHelper.addResearchPage("COREGUARD", new ResearchPage("tc.research_page.COREGUARD.2"));
        TCHelper.setResearchAspects(
                "COREGUARD",
                new AspectList().add(Aspect.getAspect("sensus"), 12).add(Aspect.getAspect("telum"), 12)
                        .add(Aspect.getAspect("vinculum"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("COREGUARD", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "COREUSE",
                getModItem("Thaumcraft", "ItemGolemCore", 1, 8, missing),
                4,
                new AspectList().add(Aspect.getAspect("humanus"), 20).add(Aspect.getAspect("instrumentum"), 20)
                        .add(Aspect.getAspect("machina"), 20).add(Aspect.getAspect("lucrum"), 20),
                getModItem("Thaumcraft", "ItemGolemCore", 1, 1, missing),
                new ItemStack[] { getModItem("minecraft", "nether_star", 1, 0, missing),
                        getModItem("ProjRed|Integration", "projectred.integration.gate", 1, 26, missing),
                        getModItem("minecraft", "lever", 1, 0, missing),
                        getModItem("minecraft", "flint_and_steel", 1, 32767, missing),
                        getModItem("minecraft", "stone_pressure_plate", 1, 0, missing),
                        getModItem("minecraft", "shears", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "COREUSE",
                new AspectList().add(Aspect.getAspect("humanus"), 12).add(Aspect.getAspect("instrumentum"), 12)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("COREUSE", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CORESORTING",
                getModItem("Thaumcraft", "ItemGolemCore", 1, 10, missing),
                4,
                new AspectList().add(Aspect.getAspect("lucrum"), 20).add(Aspect.getAspect("fames"), 20)
                        .add(Aspect.getAspect("permutatio"), 20).add(Aspect.getAspect("vacuos"), 20),
                getModItem("Thaumcraft", "ItemGolemCore", 1, 100, missing),
                new ItemStack[] { getModItem("minecraft", "nether_star", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemGolemCore", 1, 1, missing),
                        getModItem("minecraft", "paper", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemGolemCore", 1, 0, missing),
                        getModItem("ProjRed|Integration", "projectred.integration.gate", 1, 26, missing), });
        TCHelper.setResearchAspects(
                "CORESORTING",
                new AspectList().add(Aspect.getAspect("fames"), 12).add(Aspect.getAspect("vacuos"), 12)
                        .add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("CORESORTING", 3);
        TCHelper.clearPages("CORELIQUID");
        TCHelper.addResearchPage("CORELIQUID", new ResearchPage("tc.research_page.CORELIQUID.1"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CORELIQUID",
                getModItem("Thaumcraft", "ItemGolemCore", 1, 5, missing),
                4,
                new AspectList().add(Aspect.getAspect("aqua"), 20).add(Aspect.getAspect("vacuos"), 20)
                        .add(Aspect.getAspect("metallum"), 20).add(Aspect.getAspect("iter"), 20),
                getModItem("Thaumcraft", "ItemGolemCore", 1, 0, missing),
                new ItemStack[] { getModItem("minecraft", "nether_star", 1, 0, missing),
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        getModItem("IguanaTweaksTConstruct", "clayBucketFired", 1, 0, missing),
                        getModItem("minecraft", "bucket", 1, 0, missing),
                        getModItem("Forestry", "canEmpty", 1, 0, missing),
                        getModItem("IC2", "itemFluidCell", 1, 0, missing), });
        TCHelper.addResearchPage(
                "CORELIQUID",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 5, missing))));
        TCHelper.addResearchPage("CORELIQUID", new ResearchPage("tc.research_page.CORELIQUID.2"));
        TCHelper.setResearchAspects(
                "CORELIQUID",
                new AspectList().add(Aspect.getAspect("iter"), 12).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("CORELIQUID", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "COREALCHEMY",
                getModItem("Thaumcraft", "ItemGolemCore", 1, 6, missing),
                7,
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("motus"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("permutatio"), 32),
                getModItem("Thaumcraft", "ItemGolemCore", 1, 5, missing),
                new ItemStack[] { getModItem("minecraft", "nether_star", 1, 0, missing),
                        getModItem("minecraft", "potion", 1, 0, missing),
                        getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemEssence", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                        getModItem("minecraft", "potion", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemEssence", 1, 0, missing),
                        getModItem("Thaumcraft", "blockJar", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "COREALCHEMY",
                new AspectList().add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("iter"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("COREALCHEMY", 3);
        TCHelper.clearPages("COREBUTCHER");
        TCHelper.addResearchPage("COREBUTCHER", new ResearchPage("tc.research_page.COREBUTCHER.1"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "COREBUTCHER",
                getModItem("Thaumcraft", "ItemGolemCore", 1, 9, missing),
                7,
                new AspectList().add(Aspect.getAspect("bestia"), 32).add(Aspect.getAspect("corpus"), 32)
                        .add(Aspect.getAspect("mortuus"), 32).add(Aspect.getAspect("telum"), 32),
                getModItem("Thaumcraft", "ItemGolemCore", 1, 3, missing),
                new ItemStack[] { getModItem("minecraft", "nether_star", 1, 0, missing),
                        getModItem("gregtech", "gt.metatool.01", 1, 36, missing),
                        getModItem("minecraft", "iron_sword", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                        getModItem("minecraft", "bow", 1, 0, missing),
                        getModItem("minecraft", "arrow", 1, 0, missing), });
        TCHelper.addResearchPage(
                "COREBUTCHER",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("Thaumcraft", "ItemGolemCore", 1, 9, missing))));
        TCHelper.setResearchAspects(
                "COREBUTCHER",
                new AspectList().add(Aspect.getAspect("meto"), 12).add(Aspect.getAspect("telum"), 12)
                        .add(Aspect.getAspect("bestia"), 9).add(Aspect.getAspect("sensus"), 12)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("COREBUTCHER", 3);
        ThaumcraftApi.addWarpToResearch("COREBUTCHER", 2);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "COREFISHING",
                getModItem("Thaumcraft", "ItemGolemCore", 1, 11, missing),
                7,
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("meto"), 20)
                        .add(Aspect.getAspect("bestia"), 32).add(Aspect.getAspect("fames"), 32),
                getModItem("Thaumcraft", "ItemGolemCore", 1, 3, missing),
                new ItemStack[] { getModItem("minecraft", "nether_star", 1, 0, missing),
                        getModItem("minecraft", "fish", 1, 0, missing), getModItem("minecraft", "fish", 1, 2, missing),
                        getModItem("minecraft", "fish", 1, 3, missing),
                        getModItem("minecraft", "fishing_rod", 1, 0, missing),
                        getModItem("gregtech", "gt.metatool.01", 1, 34, missing), });
        TCHelper.setResearchAspects(
                "COREFISHING",
                new AspectList().add(Aspect.getAspect("fames"), 12).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("bestia"), 12).add(Aspect.getAspect("meto"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("COREFISHING", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CORELUMBER",
                getModItem("Thaumcraft", "ItemGolemCore", 1, 7, missing),
                7,
                new AspectList().add(Aspect.getAspect("arbor"), 32).add(Aspect.getAspect("instrumentum"), 32)
                        .add(Aspect.getAspect("meto"), 20).add(Aspect.getAspect("potentia"), 32),
                getModItem("Thaumcraft", "ItemGolemCore", 1, 3, missing),
                new ItemStack[] { getModItem("minecraft", "nether_star", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemAxeThaumium", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemAxeElemental", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemAxeThaumium", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "CORELUMBER",
                new AspectList().add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("arbor"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("meto"), 12)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("CORELUMBER", 3);
        TCHelper.clearPages("GOLEMBELL");
        TCHelper.addResearchPage("GOLEMBELL", new ResearchPage("tc.research_page.GOLEMBELL.1"));
        TCHelper.addResearchPage("GOLEMBELL", new ResearchPage("tc.research_page.GOLEMBELL.2"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GOLEMBELL",
                createItemStack("Thaumcraft", "GolemBell", 1, 0, "{markers:[0:{side:1b}]}", missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("aer"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolScrewdriver",
                'b',
                "plateNetherQuartz",
                'c',
                "boltNetherQuartz",
                'd',
                "screwIron",
                'e',
                "plateNetherQuartz",
                'f',
                "plateNetherQuartz",
                'g',
                "stickWoodSealed",
                'h',
                "screwIron",
                'i',
                "craftingToolFile");
        TCHelper.addResearchPage(
                "GOLEMBELL",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack("Thaumcraft", "GolemBell", 1, 0, "{markers:[0:{side:1b}]}", missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "UPGRADEAIR",
                getModItem("Thaumcraft", "ItemGolemUpgrade", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "nuggetGold",
                'b',
                getModItem("Thaumcraft", "ItemNugget", 1, 5, missing),
                'c',
                "nuggetGold",
                'd',
                "nuggetThaumium",
                'e',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                'f',
                "nuggetThaumium",
                'g',
                "nuggetGold",
                'h',
                getModItem("Thaumcraft", "ItemNugget", 1, 5, missing),
                'i',
                "nuggetGold");
        TCHelper.setResearchAspects(
                "UPGRADEAIR",
                new AspectList().add(Aspect.getAspect("motus"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("UPGRADEAIR", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "UPGRADEEARTH",
                getModItem("Thaumcraft", "ItemGolemUpgrade", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "nuggetGold",
                'b',
                getModItem("Thaumcraft", "ItemNugget", 1, 5, missing),
                'c',
                "nuggetGold",
                'd',
                "nuggetThaumium",
                'e',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'f',
                "nuggetThaumium",
                'g',
                "nuggetGold",
                'h',
                getModItem("Thaumcraft", "ItemNugget", 1, 5, missing),
                'i',
                "nuggetGold");
        TCHelper.setResearchAspects(
                "UPGRADEEARTH",
                new AspectList().add(Aspect.getAspect("victus"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("UPGRADEEARTH", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "UPGRADEFIRE",
                getModItem("Thaumcraft", "ItemGolemUpgrade", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "nuggetGold",
                'b',
                getModItem("Thaumcraft", "ItemNugget", 1, 5, missing),
                'c',
                "nuggetGold",
                'd',
                "nuggetThaumium",
                'e',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                'f',
                "nuggetThaumium",
                'g',
                "nuggetGold",
                'h',
                getModItem("Thaumcraft", "ItemNugget", 1, 5, missing),
                'i',
                "nuggetGold");
        TCHelper.setResearchAspects(
                "UPGRADEFIRE",
                new AspectList().add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("ignis"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("UPGRADEFIRE", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "UPGRADEWATER",
                getModItem("Thaumcraft", "ItemGolemUpgrade", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "nuggetGold",
                'b',
                getModItem("Thaumcraft", "ItemNugget", 1, 5, missing),
                'c',
                "nuggetGold",
                'd',
                "nuggetThaumium",
                'e',
                getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                'f',
                "nuggetThaumium",
                'g',
                "nuggetGold",
                'h',
                getModItem("Thaumcraft", "ItemNugget", 1, 5, missing),
                'i',
                "nuggetGold");
        TCHelper.setResearchAspects(
                "UPGRADEWATER",
                new AspectList().add(Aspect.getAspect("sensus"), 9).add(Aspect.getAspect("aqua"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("UPGRADEWATER", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "UPGRADEORDER",
                getModItem("Thaumcraft", "ItemGolemUpgrade", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "nuggetGold",
                'b',
                getModItem("Thaumcraft", "ItemNugget", 1, 5, missing),
                'c',
                "nuggetGold",
                'd',
                "nuggetThaumium",
                'e',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'f',
                "nuggetThaumium",
                'g',
                "nuggetGold",
                'h',
                getModItem("Thaumcraft", "ItemNugget", 1, 5, missing),
                'i',
                "nuggetGold");
        TCHelper.setResearchAspects(
                "UPGRADEORDER",
                new AspectList().add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("ordo"), 9)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("UPGRADEORDER", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "UPGRADEENTROPY",
                getModItem("Thaumcraft", "ItemGolemUpgrade", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 15).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "nuggetGold",
                'b',
                getModItem("Thaumcraft", "ItemNugget", 1, 5, missing),
                'c',
                "nuggetGold",
                'd',
                "nuggetThaumium",
                'e',
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                'f',
                "nuggetThaumium",
                'g',
                "nuggetGold",
                'h',
                getModItem("Thaumcraft", "ItemNugget", 1, 5, missing),
                'i',
                "nuggetGold");
        TCHelper.setResearchAspects(
                "UPGRADEENTROPY",
                new AspectList().add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("UPGRADEENTROPY", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TINYHAT",
                getModItem("Thaumcraft", "ItemGolemDecoration", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                "blockWoolBlack",
                'd',
                "foilGold",
                'e',
                "foilGold",
                'f',
                "foilGold",
                'g',
                "blockWoolBlack",
                'h',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'i',
                "blockWoolBlack");
        TCHelper.setResearchAspects(
                "TINYHAT",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("pannus"), 9)
                        .add(Aspect.getAspect("victus"), 6).add(Aspect.getAspect("sano"), 3));
        TCHelper.setResearchComplexity("TINYHAT", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TINYGLASSES",
                getModItem("Thaumcraft", "ItemGolemDecoration", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "stickIron",
                'c',
                "stickIron",
                'd',
                "screwIron",
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'f',
                "screwIron",
                'g',
                "lensGlass",
                'h',
                "boltIron",
                'i',
                "lensGlass");
        TCHelper.setResearchAspects(
                "TINYGLASSES",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("pannus"), 6)
                        .add(Aspect.getAspect("sensus"), 6).add(Aspect.getAspect("ordo"), 3));
        TCHelper.setResearchComplexity("TINYGLASSES", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TINYBOWTIE",
                getModItem("Thaumcraft", "ItemGolemDecoration", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("aer"), 5)
                        .add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'd',
                "blockWoolBlack",
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'f',
                "blockWoolBlack",
                'g',
                "blockWoolBlack",
                'i',
                "blockWoolBlack");
        TCHelper.setResearchAspects(
                "TINYBOWTIE",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("pannus"), 9)
                        .add(Aspect.getAspect("iter"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("TINYBOWTIE", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TINYFEZ",
                getModItem("Thaumcraft", "ItemGolemDecoration", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "blockWoolRed",
                'b',
                "blockWoolRed",
                'c',
                getModItem("minecraft", "string", 1, 0, missing),
                'd',
                "blockWoolRed",
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                'f',
                getModItem("minecraft", "string", 1, 0, missing),
                'g',
                "blockWoolRed",
                'h',
                "blockWoolRed",
                'i',
                getModItem("minecraft", "string", 1, 0, missing));
        TCHelper.setResearchAspects(
                "TINYFEZ",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("pannus"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("sano"), 3));
        TCHelper.setResearchComplexity("TINYFEZ", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TINYDART",
                getModItem("Thaumcraft", "ItemGolemDecoration", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("minecraft", "arrow", 1, 0, missing),
                'b',
                "springSmallSteel",
                'c',
                getModItem("minecraft", "arrow", 1, 0, missing),
                'd',
                getModItem("minecraft", "arrow", 1, 0, missing),
                'e',
                getModItem("minecraft", "dropper", 1, 0, missing),
                'f',
                getModItem("minecraft", "arrow", 1, 0, missing),
                'g',
                getModItem("minecraft", "arrow", 1, 0, missing),
                'h',
                "springSmallSteel",
                'i',
                getModItem("minecraft", "arrow", 1, 0, missing));
        TCHelper.setResearchAspects(
                "TINYDART",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("volatus"), 9)
                        .add(Aspect.getAspect("telum"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("TINYDART", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TINYVISOR",
                getModItem("Thaumcraft", "ItemGolemDecoration", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 5).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                'b',
                getModItem("minecraft", "iron_helmet", 1, 0, missing),
                'c',
                getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                'd',
                "plateSteel",
                'e',
                "plateSteel",
                'f',
                "plateSteel");
        TCHelper.setResearchAspects(
                "TINYVISOR",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("sensus"), 9)
                        .add(Aspect.getAspect("tutamen"), 6).add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("TINYVISOR", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TINYARMOR",
                getModItem("Thaumcraft", "ItemGolemDecoration", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("terra"), 10),
                "abc",
                "def",
                "ghi",
                'd',
                "plateSteel",
                'e',
                getModItem("minecraft", "iron_chestplate", 1, 0, missing),
                'f',
                "plateSteel",
                'g',
                "plateSteel",
                'h',
                "plateSteel",
                'i',
                "plateSteel");
        TCHelper.setResearchAspects(
                "TINYARMOR",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("metallum"), 9)
                        .add(Aspect.getAspect("tutamen"), 6).add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("TINYARMOR", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TINYHAMMER",
                getModItem("Thaumcraft", "ItemGolemDecoration", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("terra"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "plateSteel",
                'b',
                "plateSteel",
                'c',
                "plateSteel",
                'd',
                "plateSteel",
                'e',
                "plateSteel",
                'f',
                "plateSteel",
                'h',
                "stickWood");
        TCHelper.setResearchAspects(
                "TINYHAMMER",
                new AspectList().add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("metallum"), 9)
                        .add(Aspect.getAspect("telum"), 6).add(Aspect.getAspect("vinculum"), 3));
        TCHelper.setResearchComplexity("TINYHAMMER", 2);
        TCHelper.refreshResearchPages("HUNGRYCHEST");
        TCHelper.refreshResearchPages("TRAVELTRUNK");
        TCHelper.refreshResearchPages("GOLEMFETTER");
        TCHelper.refreshResearchPages("GOLEMSTRAW");
        TCHelper.refreshResearchPages("GOLEMWOOD");
        TCHelper.refreshResearchPages("GOLEMTALLOW");
        TCHelper.refreshResearchPages("GOLEMCLAY");
        TCHelper.refreshResearchPages("GOLEMFLESH");
        TCHelper.refreshResearchPages("GOLEMSTONE");
        TCHelper.refreshResearchPages("GOLEMIRON");
        TCHelper.refreshResearchPages("GOLEMTHAUMIUM");
        TCHelper.refreshResearchPages("ADVANCEDGOLEM");
        TCHelper.refreshResearchPages("COREGATHER");
        TCHelper.refreshResearchPages("COREEMPTY");
        TCHelper.refreshResearchPages("COREFILL");
        TCHelper.refreshResearchPages("COREHARVEST");
        TCHelper.refreshResearchPages("COREGUARD");
        TCHelper.refreshResearchPages("COREUSE");
        TCHelper.refreshResearchPages("CORESORTING");
        TCHelper.refreshResearchPages("CORELIQUID");
        TCHelper.refreshResearchPages("COREALCHEMY");
        TCHelper.refreshResearchPages("COREBUTCHER");
        TCHelper.refreshResearchPages("COREFISHING");
        TCHelper.refreshResearchPages("CORELUMBER");
        TCHelper.refreshResearchPages("GOLEMBELL");
        TCHelper.refreshResearchPages("UPGRADEAIR");
        TCHelper.refreshResearchPages("UPGRADEEARTH");
        TCHelper.refreshResearchPages("UPGRADEFIRE");
        TCHelper.refreshResearchPages("UPGRADEWATER");
        TCHelper.refreshResearchPages("UPGRADEORDER");
        TCHelper.refreshResearchPages("UPGRADEENTROPY");
        TCHelper.refreshResearchPages("TINYHAT");
        TCHelper.refreshResearchPages("TINYGLASSES");
        TCHelper.refreshResearchPages("TINYBOWTIE");
        TCHelper.refreshResearchPages("TINYFEZ");
        TCHelper.refreshResearchPages("TINYDART");
        TCHelper.refreshResearchPages("TINYVISOR");
        TCHelper.refreshResearchPages("TINYARMOR");
        TCHelper.refreshResearchPages("TINYHAMMER");
    }

    private void eldritch() {
        // ELDRITCH

        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "WandRod", 1, 100, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "blockEssentiaReservoir", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "FocusPrimal", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemHelmetVoidFortress", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemChestplateVoidFortress", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemLeggingsVoidFortress", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemSanityChecker", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemEldritchObject", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("Thaumcraft", "ItemPrimalCrusher", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockMetalDevice", 4, 3, missing));
        TCHelper.clearPages("ELDRITCHMINOR");
        TCHelper.addResearchPage("ELDRITCHMINOR", new ResearchPage("tc.research_page.ELDRITCHMINOR.1"));
        ThaumcraftApi.addCrucibleRecipe(
                "ELDRITCHMINOR",
                getModItem("Thaumcraft", "ItemResource", 1, 17, missing),
                "listAllseed",
                new AspectList().add(Aspect.getAspect("alienis"), 8).add(Aspect.getAspect("tenebrae"), 8)
                        .add(Aspect.getAspect("vacuos"), 8));
        TCHelper.addResearchPage(
                "ELDRITCHMINOR",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem("Thaumcraft", "ItemResource", 1, 17, missing))));
        TCHelper.clearPages("VOIDMETAL");
        TCHelper.addResearchPage("VOIDMETAL", new ResearchPage("tc.research_page.VOIDMETAL.1"));
        ThaumcraftApi.addCrucibleRecipe(
                "VOIDMETAL",
                getModItem("Thaumcraft", "ItemResource", 1, 16, missing),
                getModItem("Thaumcraft", "ItemResource", 1, 17, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 16));
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem("Thaumcraft", "ItemResource", 1, 16, missing))));
        TCHelper.addResearchPage("VOIDMETAL", new ResearchPage("tc.research_page.VOIDMETAL.2"));
        TCHelper.setResearchAspects(
                "VOIDMETAL",
                new AspectList().add(Aspect.getAspect("vacuos"), 12).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("gelum"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("VOIDMETAL", 3);
        ThaumcraftApi.addWarpToResearch("VOIDMETAL", 1);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem("Thaumcraft", "ItemAxeVoid", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("terra"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                "ingotVoid",
                'c',
                "craftingToolHardHammer",
                'd',
                "plateVoid",
                'e',
                "stickWood",
                'g',
                "craftingToolFile",
                'h',
                "stickVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemAxeVoid", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem("Thaumcraft", "ItemSwordVoid", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("terra"), 15),
                "abc",
                "def",
                "ghi",
                'b',
                "plateVoid",
                'd',
                "craftingToolFile",
                'e',
                "plateVoid",
                'f',
                "craftingToolHardHammer",
                'h',
                "stickVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemSwordVoid", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem("Thaumcraft", "ItemPickVoid", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("terra"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                "ingotVoid",
                'c',
                "ingotVoid",
                'd',
                "craftingToolFile",
                'e',
                "stickWood",
                'f',
                "craftingToolHardHammer",
                'h',
                "stickVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemPickVoid", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem("Thaumcraft", "ItemShovelVoid", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("terra"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolFile",
                'b',
                "ingotVoid",
                'c',
                "craftingToolHardHammer",
                'e',
                "stickWood",
                'h',
                "stickVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemShovelVoid", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem("Thaumcraft", "ItemHoeVoid", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("terra"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                "ingotVoid",
                'c',
                "craftingToolHardHammer",
                'd',
                "craftingToolFile",
                'e',
                "stickWood",
                'h',
                "stickVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemHoeVoid", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem("Thaumcraft", "ItemHelmetVoid", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 40).add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                "plateVoid",
                'c',
                "plateVoid",
                'd',
                "plateVoid",
                'e',
                "craftingToolHardHammer",
                'f',
                "plateVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemHelmetVoid", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem("Thaumcraft", "ItemChestplateVoid", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 40).add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                "craftingToolHardHammer",
                'c',
                "plateVoid",
                'd',
                "plateVoid",
                'e',
                "plateVoid",
                'f',
                "plateVoid",
                'g',
                "plateVoid",
                'h',
                "plateVoid",
                'i',
                "plateVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemChestplateVoid", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem("Thaumcraft", "ItemLeggingsVoid", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 40).add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                "plateVoid",
                'c',
                "plateVoid",
                'd',
                "plateVoid",
                'e',
                "craftingToolHardHammer",
                'f',
                "plateVoid",
                'g',
                "plateVoid",
                'i',
                "plateVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemLeggingsVoid", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem("Thaumcraft", "ItemBootsVoid", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 40).add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'c',
                "plateVoid",
                'd',
                "plateVoid",
                'e',
                "craftingToolHardHammer",
                'f',
                "plateVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemBootsVoid", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem("thaumicbases", "voidFAS", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 40).add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'b',
                "plateVoid",
                'e',
                getModItem("minecraft", "flint_and_steel", 1, 0, missing),
                'h',
                "plateVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("thaumicbases", "voidFAS", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "VOIDMETAL",
                getModItem("thaumicbases", "voidShears", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 40).add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'b',
                "plateVoid",
                'd',
                "plateVoid",
                'e',
                getModItem("minecraft", "shears", 1, 0, missing),
                'f',
                "plateVoid",
                'h',
                "plateVoid");
        TCHelper.addResearchPage(
                "VOIDMETAL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("thaumicbases", "voidShears", 1, 0, missing))));
        TCHelper.clearPages("CAP_void");
        TCHelper.addResearchPage("CAP_void", new ResearchPage("tc.research_page.CAP_void.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_void",
                getModItem("Thaumcraft", "WandCap", 1, 8, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 40).add(Aspect.getAspect("ignis"), 40)
                        .add(Aspect.getAspect("aer"), 40).add(Aspect.getAspect("perditio"), 40),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTungstenSteel",
                'b',
                "foilVoid",
                'c',
                "screwTungstenSteel",
                'd',
                "foilVoid",
                'e',
                "ringVoid",
                'f',
                "foilVoid",
                'g',
                "screwTungstenSteel",
                'h',
                "foilVoid",
                'i',
                "screwTungstenSteel");
        TCHelper.addResearchPage(
                "CAP_void",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "WandCap", 1, 8, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CAP_void",
                getModItem("Thaumcraft", "WandCap", 1, 7, missing),
                8,
                new AspectList().add(Aspect.getAspect("alienis"), 32).add(Aspect.getAspect("auram"), 32)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("vacuos"), 32),
                getModItem("Thaumcraft", "WandCap", 1, 8, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 17, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 17, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 17, missing), });
        TCHelper.addResearchPage(
                "CAP_void",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("Thaumcraft", "WandCap", 1, 7, missing))));
        TCHelper.setResearchAspects(
                "CAP_void",
                new AspectList().add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("vacuos"), 12)
                        .add(Aspect.getAspect("alienis"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("instrumentum"), 6).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("tenebrae"), 3));
        TCHelper.setResearchComplexity("CAP_void", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ESSENTIARESERVOIR",
                getModItem("Thaumcraft", "blockEssentiaReservoir", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("aqua"), 16).add(Aspect.getAspect("permutatio"), 16)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("vacuos"), 16),
                getModItem("Thaumcraft", "blockTube", 1, 4, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("Thaumcraft", "blockJar", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ESSENTIARESERVOIR",
                new AspectList().add(Aspect.getAspect("aqua"), 12).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("vacuos"), 9)
                        .add(Aspect.getAspect("alienis"), 6).add(Aspect.getAspect("tenebrae"), 3));
        TCHelper.setResearchComplexity("ESSENTIARESERVOIR", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUSPRIMAL",
                getModItem("Thaumcraft", "FocusPrimal", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 75).add(Aspect.getAspect("terra"), 75)
                        .add(Aspect.getAspect("ignis"), 75).add(Aspect.getAspect("aer"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                "gemExquisiteDiamond",
                'b',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                'c',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                'd',
                getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                'f',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'g',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'h',
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                'i',
                "gemExquisiteDiamond");
        TCHelper.setResearchAspects(
                "FOCUSPRIMAL",
                new AspectList().add(Aspect.getAspect("aqua"), 12).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("terra"), 9)
                        .add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("FOCUSPRIMAL", 4);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_primal_staff",
                getModItem("Thaumcraft", "WandRod", 1, 100, missing),
                10,
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("aqua"), 64)
                        .add(Aspect.getAspect("terra"), 64).add(Aspect.getAspect("ignis"), 64)
                        .add(Aspect.getAspect("ordo"), 64).add(Aspect.getAspect("perditio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 128),
                getModItem("Thaumcraft", "WandRod", 1, 2, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("Thaumcraft", "WandRod", 1, 1, missing),
                        getModItem("Thaumcraft", "WandRod", 1, 3, missing),
                        getModItem("Thaumcraft", "WandRod", 1, 4, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("Thaumcraft", "WandRod", 1, 5, missing),
                        getModItem("Thaumcraft", "WandRod", 1, 6, missing),
                        getModItem("Thaumcraft", "WandRod", 1, 7, missing), });
        TCHelper.setResearchAspects(
                "ROD_primal_staff",
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("ordo"), 12).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("instrumentum"), 6)
                        .add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("ROD_primal_staff", 4);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ARMORVOIDFORTRESS",
                getModItem("Thaumcraft", "ItemHelmetVoidFortress", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("alienis"), 24).add(Aspect.getAspect("metallum"), 24)
                        .add(Aspect.getAspect("pannus"), 24).add(Aspect.getAspect("sensus"), 24)
                        .add(Aspect.getAspect("tutamen"), 24).add(Aspect.getAspect("vacuos"), 24)
                        .add(Aspect.getAspect("praecantatio"), 24),
                getModItem("Thaumcraft", "ItemHelmetVoid", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemGoggles", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing), });
        TCHelper.setResearchAspects(
                "ARMORVOIDFORTRESS",
                new AspectList().add(Aspect.getAspect("vacuos"), 15).add(Aspect.getAspect("tenebrae"), 15)
                        .add(Aspect.getAspect("tutamen"), 12).add(Aspect.getAspect("pannus"), 12)
                        .add(Aspect.getAspect("alienis"), 9).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("sensus"), 6).add(Aspect.getAspect("metallum"), 3));
        TCHelper.setResearchComplexity("ARMORVOIDFORTRESS", 4);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ARMORVOIDFORTRESS",
                getModItem("Thaumcraft", "ItemChestplateVoidFortress", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("alienis"), 32).add(Aspect.getAspect("metallum"), 32)
                        .add(Aspect.getAspect("pannus"), 32).add(Aspect.getAspect("sensus"), 32)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("vacuos"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32),
                getModItem("Thaumcraft", "ItemChestplateVoid", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemChestplateRobe", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ARMORVOIDFORTRESS",
                getModItem("Thaumcraft", "ItemLeggingsVoidFortress", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("alienis"), 28).add(Aspect.getAspect("metallum"), 28)
                        .add(Aspect.getAspect("pannus"), 28).add(Aspect.getAspect("sensus"), 28)
                        .add(Aspect.getAspect("tutamen"), 28).add(Aspect.getAspect("vacuos"), 28)
                        .add(Aspect.getAspect("praecantatio"), 28),
                getModItem("Thaumcraft", "ItemLeggingsVoid", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemLeggingsRobe", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("harvestcraft", "hardenedleatherItem", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 7, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SANITYCHECK",
                getModItem("Thaumcraft", "ItemSanityChecker", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("alienis"), 16).add(Aspect.getAspect("cognitio"), 32)
                        .add(Aspect.getAspect("sensus"), 24).add(Aspect.getAspect("sano"), 16),
                getModItem("Thaumcraft", "ItemThaumometer", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "blockMirror", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing),
                        getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing),
                        getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing), });
        TCHelper.setResearchAspects(
                "SANITYCHECK",
                new AspectList().add(Aspect.getAspect("sensus"), 12).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("sano"), 6).add(Aspect.getAspect("victus"), 3));
        TCHelper.setResearchComplexity("SANITYCHECK", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "OCULUS",
                getModItem("Thaumcraft", "ItemEldritchObject", 1, 0, missing),
                7,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("iter"), 32)
                        .add(Aspect.getAspect("tenebrae"), 32).add(Aspect.getAspect("vacuos"), 32),
                getModItem("StevesCarts", "ModuleComponents", 1, 45, missing),
                new ItemStack[] { getModItem("minecraft", "ender_eye", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 17, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 17, missing),
                        getModItem("minecraft", "ender_eye", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 17, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17086, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 17, missing), });
        TCHelper.setResearchAspects(
                "OCULUS",
                new AspectList().add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("iter"), 9)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("vitium"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("OCULUS", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "PRIMALCRUSHER",
                getModItem("Thaumcraft", "ItemPrimalCrusher", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("alienis"), 24).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("lucrum"), 24).add(Aspect.getAspect("perditio"), 24)
                        .add(Aspect.getAspect("perfodio"), 24).add(Aspect.getAspect("telum"), 24)
                        .add(Aspect.getAspect("vacuos"), 24),
                getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemEldritchObject", 1, 3, missing),
                        getModItem("Thaumcraft", "ItemPickVoid", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemShovelVoid", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("Thaumcraft", "ItemPickaxeElemental", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemShovelElemental", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "PRIMALCRUSHER",
                new AspectList().add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("alienis"), 12)
                        .add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("perditio"), 9).add(Aspect.getAspect("perfodio"), 9)
                        .add(Aspect.getAspect("telum"), 6).add(Aspect.getAspect("vacuos"), 3));
        TCHelper.setResearchComplexity("PRIMALCRUSHER", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ADVALCHEMYFURNACE",
                getModItem("Thaumcraft", "blockMetalDevice", 4, 3, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("terra"), 32)
                        .add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("ordo"), 32),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                getModItem("Thaumcraft", "blockMetalDevice", 1, 9, missing),
                'c',
                "plateVoid",
                'd',
                getModItem("Thaumcraft", "blockMetalDevice", 1, 9, missing),
                'e',
                getModItem("Thaumcraft", "ItemEldritchObject", 1, 3, missing),
                'f',
                getModItem("Thaumcraft", "blockMetalDevice", 1, 9, missing),
                'g',
                "plateVoid",
                'h',
                getModItem("Thaumcraft", "blockMetalDevice", 1, 9, missing),
                'i',
                "plateVoid");
        TCHelper.setResearchAspects(
                "ADVALCHEMYFURNACE",
                new AspectList().add(Aspect.getAspect("perditio"), 12).add(Aspect.getAspect("auram"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("ordo"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("ADVALCHEMYFURNACE", 3);
        TCHelper.refreshResearchPages("ELDRITCHMINOR");
        TCHelper.refreshResearchPages("VOIDMETAL");
        TCHelper.refreshResearchPages("CAP_void");
        TCHelper.refreshResearchPages("ESSENTIARESERVOIR");
        TCHelper.refreshResearchPages("FOCUSPRIMAL");
        TCHelper.refreshResearchPages("ROD_primal_staff");
        TCHelper.refreshResearchPages("ARMORVOIDFORTRESS");
        TCHelper.refreshResearchPages("SANITYCHECK");
        TCHelper.refreshResearchPages("OCULUS");
        TCHelper.refreshResearchPages("PRIMALCRUSHER");
        TCHelper.refreshResearchPages("ADVALCHEMYFURNACE");
        TCHelper.refreshResearchPages("ROD_silverwood");
        TCHelper.refreshResearchPages("ROD_greatwood_staff");
        TCHelper.refreshResearchPages("ROD_reed_staff");
        TCHelper.refreshResearchPages("ROD_blaze_staff");
        TCHelper.refreshResearchPages("ROD_obsidian_staff");
        TCHelper.refreshResearchPages("ROD_ice_staff");
        TCHelper.refreshResearchPages("ROD_quartz_staff");
        TCHelper.refreshResearchPages("ROD_bone_staff");
        TCHelper.refreshResearchPages("ROD_silverwood_staff");
        TCHelper.refreshResearchPages("SCEPTRE");
        TCHelper.refreshResearchPages("ROD_greatwood");
        TCHelper.refreshResearchPages("ROD_reed");
        TCHelper.refreshResearchPages("ROD_blaze");
        TCHelper.refreshResearchPages("ROD_obsidian");
        TCHelper.refreshResearchPages("ROD_ice");
        TCHelper.refreshResearchPages("ROD_quartz");
        TCHelper.refreshResearchPages("ROD_bone");
    }

    private void aspectAdds() {
        // ASPECT ADDS

        ThaumcraftApi.registerObjectTag(
                getModItem("BiomesOPlenty", "bones", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("corpus"), 1).add(Aspect.getAspect("exanimis"), 3)
                        .add(Aspect.getAspect("mortuus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("BiomesOPlenty", "bones", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("corpus"), 2).add(Aspect.getAspect("exanimis"), 6)
                        .add(Aspect.getAspect("mortuus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("BiomesOPlenty", "bones", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("corpus"), 3).add(Aspect.getAspect("exanimis"), 9)
                        .add(Aspect.getAspect("mortuus"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem("ForbiddenMagic", "WandCores", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("vitreus"), 16).add(Aspect.getAspect("infernus"), 8)
                        .add(Aspect.getAspect("tenebrae"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "tile.moonBlock", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 2).add(Aspect.getAspect("vacuos"), 2)
                        .add(Aspect.getAspect("tenebrae"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "tile.moonBlock", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 2).add(Aspect.getAspect("vacuos"), 3)
                        .add(Aspect.getAspect("tenebrae"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "tile.moonBlock", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 1).add(Aspect.getAspect("vacuos"), 1)
                        .add(Aspect.getAspect("tenebrae"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "tile.moonBlock", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 4).add(Aspect.getAspect("ira"), 1)
                        .add(Aspect.getAspect("superbia"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("dreamcraft", "item.MoonStoneDust", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 1).add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "tile.mars", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 1).add(Aspect.getAspect("perditio"), 1)
                        .add(Aspect.getAspect("ignis"), 1).add(Aspect.getAspect("terra"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "tile.mars", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 1).add(Aspect.getAspect("metallum"), 1)
                        .add(Aspect.getAspect("ignis"), 2).add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "tile.mars", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 2).add(Aspect.getAspect("metallum"), 2)
                        .add(Aspect.getAspect("ignis"), 2).add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "tile.mars", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 1).add(Aspect.getAspect("metallum"), 1)
                        .add(Aspect.getAspect("ira"), 2).add(Aspect.getAspect("superbia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "tile.mars", 1, 9, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 2).add(Aspect.getAspect("metallum"), 3)
                        .add(Aspect.getAspect("ignis"), 3).add(Aspect.getAspect("terra"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("dreamcraft", "item.MarsStoneDust", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 1).add(Aspect.getAspect("perditio"), 1)
                        .add(Aspect.getAspect("terra"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "tile.asteroidsBlock", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 1).add(Aspect.getAspect("tenebrae"), 1)
                        .add(Aspect.getAspect("vacuos"), 1).add(Aspect.getAspect("gelum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "tile.asteroidsBlock", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 2).add(Aspect.getAspect("tenebrae"), 2)
                        .add(Aspect.getAspect("vacuos"), 2).add(Aspect.getAspect("gelum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "tile.asteroidsBlock", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 3).add(Aspect.getAspect("tenebrae"), 3)
                        .add(Aspect.getAspect("vacuos"), 3).add(Aspect.getAspect("gelum"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("dreamcraft", "item.AsteroidsStoneDust", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 1).add(Aspect.getAspect("perditio"), 1)
                        .add(Aspect.getAspect("gelum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "tile.landingPad", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("ordo"), 5));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.basicItem", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("fabrico"), 2)
                        .add(Aspect.getAspect("permutatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.basicItem", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("fabrico"), 2)
                        .add(Aspect.getAspect("vitreus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.basicItem", 1, 8, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("volatus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.basicItem", 1, 9, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("ordo"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.basicItem", 1, 10, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.basicItem", 1, 11, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.meteoricIronIngot", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("magneto"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "item.null", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("vacuos"), 2)
                        .add(Aspect.getAspect("tenebrae"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("tutamen"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.basicItem", 1, 13, missing),
                new AspectList().add(Aspect.getAspect("fabrico"), 6).add(Aspect.getAspect("ordo"), 5)
                        .add(Aspect.getAspect("machina"), 4).add(Aspect.getAspect("instrumentum"), 3)
                        .add(Aspect.getAspect("metallum"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.basicItem", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("ordo"), 7)
                        .add(Aspect.getAspect("machina"), 6).add(Aspect.getAspect("instrumentum"), 5)
                        .add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("lux"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("dreamcraft", "item.WaferTier3", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("ordo"), 10)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("instrumentum"), 8)
                        .add(Aspect.getAspect("metallum"), 7).add(Aspect.getAspect("lux"), 6)
                        .add(Aspect.getAspect("alienis"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "tile.aluminumWire", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("volatus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "tile.oxygenPipe", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("gelum"), 1)
                        .add(Aspect.getAspect("vitreus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "tile.glowstoneTorch", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("potentia"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("lux"), 1).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "tile.arclamp", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("potentia"), 5).add(Aspect.getAspect("machina"), 2)
                        .add(Aspect.getAspect("lux"), 5).add(Aspect.getAspect("tenebrae"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.basicItem", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("potentia"), 2).add(Aspect.getAspect("electrum"), 2)
                        .add(Aspect.getAspect("tenebrae"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.canister", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("vitreus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.canister", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("permutatio"), 1)
                        .add(Aspect.getAspect("fabrico"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.steelPole", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("ordo"), 5));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.heavyPlating", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("ordo"), 2)
                        .add(Aspect.getAspect("volatus"), 2).add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "item.null", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 8).add(Aspect.getAspect("ordo"), 2)
                        .add(Aspect.getAspect("volatus"), 2).add(Aspect.getAspect("instrumentum"), 1)
                        .add(Aspect.getAspect("magneto"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "item.itemBasicAsteroids", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 10).add(Aspect.getAspect("ordo"), 2)
                        .add(Aspect.getAspect("volatus"), 2).add(Aspect.getAspect("instrumentum"), 1)
                        .add(Aspect.getAspect("magneto"), 2).add(Aspect.getAspect("vacuos"), 2)
                        .add(Aspect.getAspect("tenebrae"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.oxygenMask", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("tutamen"), 2).add(Aspect.getAspect("gelum"), 1)
                        .add(Aspect.getAspect("vitreus"), 1).add(Aspect.getAspect("metallum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.battery", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("electrum"), 6).add(Aspect.getAspect("metallum"), 2)
                        .add(Aspect.getAspect("vacuos"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.basicItem", 1, 15, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("vitreus"), 1)
                        .add(Aspect.getAspect("messis"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.basicItem", 1, 16, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("vitreus"), 1)
                        .add(Aspect.getAspect("messis"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.basicItem", 1, 17, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("vitreus"), 1)
                        .add(Aspect.getAspect("messis"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.basicItem", 1, 18, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("vitreus"), 1)
                        .add(Aspect.getAspect("messis"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.meteoricIronRaw", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("magneto"), 2).add(Aspect.getAspect("metallum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "item.thermalPadding", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 12).add(Aspect.getAspect("bestia"), 6)
                        .add(Aspect.getAspect("fabrico"), 3).add(Aspect.getAspect("aqua"), 2)
                        .add(Aspect.getAspect("ordo"), 2).add(Aspect.getAspect("perditio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "item.thermalPadding", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 18).add(Aspect.getAspect("bestia"), 9)
                        .add(Aspect.getAspect("fabrico"), 5).add(Aspect.getAspect("aqua"), 3)
                        .add(Aspect.getAspect("ordo"), 3).add(Aspect.getAspect("perditio"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "item.thermalPadding", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 15).add(Aspect.getAspect("bestia"), 7)
                        .add(Aspect.getAspect("fabrico"), 4).add(Aspect.getAspect("aqua"), 3)
                        .add(Aspect.getAspect("ordo"), 3).add(Aspect.getAspect("perditio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "item.thermalPadding", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 9).add(Aspect.getAspect("bestia"), 5)
                        .add(Aspect.getAspect("fabrico"), 2).add(Aspect.getAspect("aqua"), 1)
                        .add(Aspect.getAspect("ordo"), 1).add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "item.null", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("tenebrae"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "tile.hydrogenPipe", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("gelum"), 1)
                        .add(Aspect.getAspect("vitreus"), 1).add(Aspect.getAspect("permutatio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "item.bucketSludge", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("venenum"), 4).add(Aspect.getAspect("aqua"), 2)
                        .add(Aspect.getAspect("alienis"), 2).add(Aspect.getAspect("metallum"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.oilCanisterPartial", 1, 1001, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ordo"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "item.methaneCanisterPartial", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ordo"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "item.canisterPartialLOX", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ordo"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "item.canisterPartialLN2", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ordo"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftCore", "item.fuelCanisterPartial", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ordo"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "tile.creeperEgg", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 10).add(Aspect.getAspect("perditio"), 5));
        ThaumcraftApi.registerObjectTag(
                getModItem("GalacticraftMars", "tile.denseIce", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 5).add(Aspect.getAspect("gelum"), 5));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockMetal", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("ordo"), 5));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemPartCircuitAdv", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("ordo"), 7)
                        .add(Aspect.getAspect("machina"), 6).add(Aspect.getAspect("instrumentum"), 5)
                        .add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("lux"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemPartAlloy", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("vacuos"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemIngot", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("dreamcraft", "item.ReinforcedGlassPlate", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("gelum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("dreamcraft", "item.ReinforcedGlassPlate", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("gelum"), 1)
                        .add(Aspect.getAspect("vitreus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockAlloy", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ordo"), 3)
                        .add(Aspect.getAspect("terra"), 2).add(Aspect.getAspect("fabrico"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockMetal", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("permutatio"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockMetal", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("vitreus"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockMetal", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("instrumentum"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockMetal", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("ordo"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockMetal", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("venenum"), 2)
                        .add(Aspect.getAspect("potentia"), 2).add(Aspect.getAspect("radio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockGenerator", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 40).add(Aspect.getAspect("fabrico"), 30)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("tutamen"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockHeatGenerator", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 30).add(Aspect.getAspect("fabrico"), 18)
                        .add(Aspect.getAspect("ordo"), 8).add(Aspect.getAspect("permutatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockreactorvessel", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("fabrico"), 3)
                        .add(Aspect.getAspect("ordo"), 3).add(Aspect.getAspect("terra"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockReactorFluidPort", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("fabrico"), 3)
                        .add(Aspect.getAspect("iter"), 3).add(Aspect.getAspect("aqua"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockReactorAccessHatch", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("fabrico"), 3)
                        .add(Aspect.getAspect("iter"), 3).add(Aspect.getAspect("machina"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockReactorRedstonePort", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("fabrico"), 3)
                        .add(Aspect.getAspect("sensus"), 2).add(Aspect.getAspect("machina"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockElectric", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 11).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("motus"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockElectric", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 11).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("volatus"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockElectric", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("fabrico"), 5).add(Aspect.getAspect("machina"), 4)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ignis"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockElectric", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 7).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("tutamen"), 3).add(Aspect.getAspect("motus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockMachine", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 64).add(Aspect.getAspect("fabrico"), 64)
                        .add(Aspect.getAspect("ordo"), 64).add(Aspect.getAspect("instrumentum"), 50));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemPartCarbonPlate", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ignis"), 4)
                        .add(Aspect.getAspect("vitreus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockMachine", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 32).add(Aspect.getAspect("fabrico"), 8)
                        .add(Aspect.getAspect("vacuos"), 4).add(Aspect.getAspect("ignis"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemHarz", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("limus"), 2).add(Aspect.getAspect("motus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockMiningPipe", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockLuminatorDark", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("lux"), 4).add(Aspect.getAspect("ignis"), 2)
                        .add(Aspect.getAspect("tenebrae"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "blockITNT", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 4).add(Aspect.getAspect("perditio"), 8)
                        .add(Aspect.getAspect("potentia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemRecipePart", 1, 11, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 27));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemRecipePart", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("ordo"), 5));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemRecipePart", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 17).add(Aspect.getAspect("fabrico"), 3)
                        .add(Aspect.getAspect("instrumentum"), 2).add(Aspect.getAspect("magneto"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemRecipePart", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("machina"), 1).add(Aspect.getAspect("electrum"), 1)
                        .add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemRecipePart", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("sensus"), 1).add(Aspect.getAspect("fabrico"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemRecipePart", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("fabrico"), 2).add(Aspect.getAspect("metallum"), 1)
                        .add(Aspect.getAspect("sano"), 1).add(Aspect.getAspect("tenebrae"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemUran", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("vitreus"), 14).add(Aspect.getAspect("gelum"), 6)
                        .add(Aspect.getAspect("radio"), 3).add(Aspect.getAspect("permutatio"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemMOX", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("radio"), 3).add(Aspect.getAspect("metallum"), 3)
                        .add(Aspect.getAspect("permutatio"), 6).add(Aspect.getAspect("vitreus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemPlutonium", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("radio"), 3).add(Aspect.getAspect("metallum"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemPlutoniumSmall", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemDust2", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("lucrum"), 4).add(Aspect.getAspect("potentia"), 3)
                        .add(Aspect.getAspect("machina"), 2).add(Aspect.getAspect("vitreus"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemUran235", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 3).add(Aspect.getAspect("radio"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemContainmentbox", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("fabrico"), 3).add(Aspect.getAspect("instrumentum"), 3)
                        .add(Aspect.getAspect("ordo"), 3).add(Aspect.getAspect("metallum"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemRTGPellet", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("fabrico"), 6)
                        .add(Aspect.getAspect("radio"), 15));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemFuelRod", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("instrumentum"), 2).add(Aspect.getAspect("ordo"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemPartCarbonFibre", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("vitreus"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemPartCarbonMesh", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 2).add(Aspect.getAspect("ignis"), 2)
                        .add(Aspect.getAspect("vitreus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolbox", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("fabrico"), 3).add(Aspect.getAspect("metallum"), 3)
                        .add(Aspect.getAspect("instrumentum"), 2).add(Aspect.getAspect("ordo"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemShardIridium", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemPartIridium", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 8).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("machina"), 4).add(Aspect.getAspect("vitreus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolMEter", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("fabrico"), 15).add(Aspect.getAspect("instrumentum"), 6)
                        .add(Aspect.getAspect("cognitio"), 2).add(Aspect.getAspect("lux"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemScanner", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("fabrico"), 18).add(Aspect.getAspect("instrumentum"), 8)
                        .add(Aspect.getAspect("cognitio"), 4).add(Aspect.getAspect("lux"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemScannerAdv", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("fabrico"), 10).add(Aspect.getAspect("instrumentum"), 10)
                        .add(Aspect.getAspect("cognitio"), 6).add(Aspect.getAspect("lux"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "obscurator", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("instrumentum"), 6).add(Aspect.getAspect("lux"), 4)
                        .add(Aspect.getAspect("machina"), 4).add(Aspect.getAspect("tenebrae"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemFreq", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("instrumentum"), 4)
                        .add(Aspect.getAspect("sensus"), 4).add(Aspect.getAspect("electrum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemBatREDischarged", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 1).add(Aspect.getAspect("electrum"), 1)
                        .add(Aspect.getAspect("vacuos"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemBatCrystal", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("vitreus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemBatLamaCrystal", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("lucrum"), 8).add(Aspect.getAspect("potentia"), 11)
                        .add(Aspect.getAspect("sensus"), 5));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemAdvBat", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("electrum"), 2).add(Aspect.getAspect("metallum"), 2)
                        .add(Aspect.getAspect("vacuos"), 2).add(Aspect.getAspect("potentia"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemBatChargeRE", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 2).add(Aspect.getAspect("electrum"), 2)
                        .add(Aspect.getAspect("vacuos"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemBatChargeAdv", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("electrum"), 3).add(Aspect.getAspect("metallum"), 3)
                        .add(Aspect.getAspect("vacuos"), 3).add(Aspect.getAspect("potentia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemBatChargeCrystal", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("potentia"), 14)
                        .add(Aspect.getAspect("sensus"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemBatChargeLamaCrystal", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("potentia"), 16)
                        .add(Aspect.getAspect("sensus"), 7));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemGrinPowder", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("venenum"), 3).add(Aspect.getAspect("messis"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemFuelPlantBall", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemBiochaff", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemFertilizer", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 3).add(Aspect.getAspect("sano"), 2)
                        .add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemWeed", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemPartCoalBall", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("potentia"), 2).add(Aspect.getAspect("ignis"), 2)
                        .add(Aspect.getAspect("terra"), 1).add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemPartCoalBlock", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("potentia"), 4).add(Aspect.getAspect("ignis"), 4)
                        .add(Aspect.getAspect("terra"), 2).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemPartCoalBlock", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 2).add(Aspect.getAspect("terra"), 2)
                        .add(Aspect.getAspect("tenebrae"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemScrap", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("strontio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemScrapbox", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("strontio"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolPainterBlack", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolPainterCloud", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolPainterMagenta", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolPainterOrange", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolPainterWhite", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolPainterRed", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolPainterGreen", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolPainterBrown", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolPainterBlue", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolPainterLime", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolPainterYellow", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolPainterPink", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolPainterDarkGrey", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolPainterLightGrey", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolPainterCyan", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemToolPainterPurple", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ordo"), 4).add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "reactorVent", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("volatus"), 4).add(Aspect.getAspect("gelum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "reactorVentCore", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 20).add(Aspect.getAspect("fabrico"), 8)
                        .add(Aspect.getAspect("lucrum"), 4).add(Aspect.getAspect("gelum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "reactorVentGold", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 24).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("gelum"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "reactorVentDiamond", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 26).add(Aspect.getAspect("fabrico"), 14)
                        .add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("gelum"), 7));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "reactorHeatSwitch", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("permutatio"), 4).add(Aspect.getAspect("gelum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "reactorHeatSwitchCore", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 20).add(Aspect.getAspect("fabrico"), 8)
                        .add(Aspect.getAspect("permutatio"), 4).add(Aspect.getAspect("gelum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "reactorHeatSwitchSpread", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 24).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("gelum"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "reactorHeatSwitchDiamond", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 26).add(Aspect.getAspect("fabrico"), 14)
                        .add(Aspect.getAspect("permutatio"), 10).add(Aspect.getAspect("gelum"), 7));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemwoodrotor", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("tempestas"), 2).add(Aspect.getAspect("arbor"), 4)
                        .add(Aspect.getAspect("metallum"), 2).add(Aspect.getAspect("permutatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemironrotor", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("tempestas"), 4).add(Aspect.getAspect("metallum"), 4)
                        .add(Aspect.getAspect("instrumentum"), 2).add(Aspect.getAspect("permutatio"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemsteelrotor", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("tempestas"), 6).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("permutatio"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemwcarbonrotor", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("tempestas"), 8).add(Aspect.getAspect("metallum"), 8)
                        .add(Aspect.getAspect("instrumentum"), 6).add(Aspect.getAspect("permutatio"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "reactorReflector", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ignis"), 4)
                        .add(Aspect.getAspect("vitreus"), 2).add(Aspect.getAspect("fabrico"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "reactorReflectorThick", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 8).add(Aspect.getAspect("ignis"), 4)
                        .add(Aspect.getAspect("lucrum"), 4).add(Aspect.getAspect("fabrico"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "reactorCondensator", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 24).add(Aspect.getAspect("fabrico"), 16)
                        .add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("gelum"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "reactorCondensatorLap", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 24).add(Aspect.getAspect("fabrico"), 16)
                        .add(Aspect.getAspect("permutatio"), 16).add(Aspect.getAspect("gelum"), 16));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "upgradeModule", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("motus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "upgradeModule", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("electrum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "upgradeModule", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("lucrum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "upgradeModule", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("permutatio"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "upgradeModule", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("aqua"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "upgradeModule", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("cognitio"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "upgradeModule", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("ignis"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemBoat", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 8).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemBoat", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("fabrico"), 1).add(Aspect.getAspect("limus"), 1)
                        .add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemCoin", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemCropnalyzer", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("cognitio"), 8).add(Aspect.getAspect("lux"), 2)
                        .add(Aspect.getAspect("metallum"), 4).add(Aspect.getAspect("instrumentum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemHops", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemCofeeBeans", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("sensus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemDynamite", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("strontio"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemDynamiteSticky", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("limus"), 2)
                        .add(Aspect.getAspect("strontio"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemMugCoffee", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("sensus"), 2).add(Aspect.getAspect("tenebrae"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemMugCoffee", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("sensus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemRemote", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("instrumentum"), 4)
                        .add(Aspect.getAspect("sensus"), 4).add(Aspect.getAspect("perditio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemWeedEx", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("venenum"), 8).add(Aspect.getAspect("cognitio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemTerraWart", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("auram"), 8).add(Aspect.getAspect("praecantatio"), 4)
                        .add(Aspect.getAspect("victus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemCellEmpty", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("fabrico"), 2).add(Aspect.getAspect("metallum"), 2)
                        .add(Aspect.getAspect("vitreus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemTinCan", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("fabrico"), 1).add(Aspect.getAspect("metallum"), 1)
                        .add(Aspect.getAspect("vitreus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemTinCanFilled", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("fabrico"), 2).add(Aspect.getAspect("metallum"), 2)
                        .add(Aspect.getAspect("vitreus"), 2).add(Aspect.getAspect("victus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "itemCellHydrant", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 8).add(Aspect.getAspect("metallum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "reactorCoolantSimple", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("gelum"), 4).add(Aspect.getAspect("metallum"), 2)
                        .add(Aspect.getAspect("vitreus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "reactorCoolantTriple", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("gelum"), 8).add(Aspect.getAspect("metallum"), 4)
                        .add(Aspect.getAspect("vitreus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("IC2", "reactorCoolantSix", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("gelum"), 16).add(Aspect.getAspect("metallum"), 8)
                        .add(Aspect.getAspect("vitreus"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("malisisdoors", "trapdoor_acacia", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("malisisdoors", "trapdoor_birch", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("malisisdoors", "trapdoor_dark_oak", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("malisisdoors", "trapdoor_jungle", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("malisisdoors", "trapdoor_spruce", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("minecraft", "blaze_powder", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("praecantatio"), 4)
                        .add(Aspect.getAspect("instrumentum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("minecraft", "blaze_rod", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 10).add(Aspect.getAspect("praecantatio"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("minecraft", "paper", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("cognitio"), 4).add(Aspect.getAspect("aqua"), 2)
                        .add(Aspect.getAspect("arbor"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("minecraft", "book", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 1).add(Aspect.getAspect("cognitio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("minecraft", "enchanted_book", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 1).add(Aspect.getAspect("cognitio"), 1)
                        .add(Aspect.getAspect("metallum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("minecraft", "hopper", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("arbor"), 4)
                        .add(Aspect.getAspect("vacuos"), 3).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("permutatio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("minecraft", "furnace", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("perditio"), 6)
                        .add(Aspect.getAspect("ignis"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("minecraft", "stone_pressure_plate", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("minecraft", "redstone_torch", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("potentia"), 1).add(Aspect.getAspect("machina"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("Natura", "trapdoor.eucalyptus", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("Natura", "trapdoor.sakura", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("Natura", "trapdoor.ghostwood", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("Natura", "trapdoor.redwood", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("Natura", "trapdoor.bloodwood", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("Natura", "trapdoor.hopseed", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("Natura", "trapdoor.maple", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("Natura", "trapdoor.amaranth", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("Natura", "trapdoor.silverbell", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("Natura", "trapdoor.willow", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("Natura", "trapdoor.darkwood", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("Natura", "trapdoor.fusewood", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("motus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("Thaumcraft", "ItemResource", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("corpus"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("mortuus"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("Thaumcraft", "blockCandle", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("lux"), 5).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("pannus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFRoots", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFRoots", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("praecantatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.liveRoot", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("praecantatio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFFirefly", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("victus"), 1).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFCicada", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("victus"), 1).add(Aspect.getAspect("volatus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFPortal", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("tempus"), 4).add(Aspect.getAspect("praecantatio"), 4)
                        .add(Aspect.getAspect("iter"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFMazestone", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFMazestone", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFMazestone", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFMazestone", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFMazestone", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFMazestone", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFMazestone", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFMazestone", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFHedge", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFFireflyJar", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("vitreus"), 2).add(Aspect.getAspect("arbor"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFPlant", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("herba"), 2).add(Aspect.getAspect("victus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFPlant", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFPlant", 1, 8, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFPlant", 1, 9, missing),
                new AspectList().add(Aspect.getAspect("herba"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFPlant", 1, 10, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFPlant", 1, 11, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFPlant", 1, 13, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFPlant", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFFireJet", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 2).add(Aspect.getAspect("aer"), 2)
                        .add(Aspect.getAspect("machina"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFFireJet", 1, 8, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("motus"), 2)
                        .add(Aspect.getAspect("machina"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFNagastone", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFNagastone", 1, 13, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFSapling", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("arbor"), 2)
                        .add(Aspect.getAspect("tempus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFSapling", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("arbor"), 2)
                        .add(Aspect.getAspect("praecantatio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFSapling", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("arbor"), 2)
                        .add(Aspect.getAspect("perfodio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFSapling", 1, 9, missing),
                new AspectList().add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("arbor"), 2)
                        .add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFMoonworm", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("victus"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFMagicLogSpecial", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("tempus"), 2).add(Aspect.getAspect("herba"), 2)
                        .add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFMagicLogSpecial", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("aer"), 2).add(Aspect.getAspect("herba"), 2)
                        .add(Aspect.getAspect("invidia"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFMagicLogSpecial", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("perfodio"), 2).add(Aspect.getAspect("herba"), 2)
                        .add(Aspect.getAspect("lucrum"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFMagicLogSpecial", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("praecantatio"), 2)
                        .add(Aspect.getAspect("motus"), 2).add(Aspect.getAspect("herba"), 2)
                        .add(Aspect.getAspect("cognitio"), 1).add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFTowerDevice", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("potentia"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFTowerDevice", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("potentia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFTowerDevice", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("potentia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFTowerDevice", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 1)
                        .add(Aspect.getAspect("potentia"), 2).add(Aspect.getAspect("iter"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFTowerDevice", 1, 9, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 2)
                        .add(Aspect.getAspect("potentia"), 4).add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFTowerDevice", 1, 10, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 1).add(Aspect.getAspect("machina"), 2)
                        .add(Aspect.getAspect("potentia"), 4).add(Aspect.getAspect("vinculum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFShield", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("machina"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFTrophyPedestal", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 7).add(Aspect.getAspect("ordo"), 4)
                        .add(Aspect.getAspect("lucrum"), 4).add(Aspect.getAspect("instrumentum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFTrophyPedestal", 1, 15, missing),
                new AspectList().add(Aspect.getAspect("terra"), 7).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("instrumentum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFAuroraBrick", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFUnderBrick", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFUnderBrick", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFUnderBrick", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFThorns", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("fabrico"), 1)
                        .add(Aspect.getAspect("telum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFThorns", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("herba"), 3).add(Aspect.getAspect("fabrico"), 1)
                        .add(Aspect.getAspect("telum"), 1).add(Aspect.getAspect("aqua"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFBurntThorns", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 2).add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFThornRose", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFLeaves3", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFLeaves3", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFDeadrock", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("ignis"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFDeadrock", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("ignis"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TFDeadrock", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("ignis"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.DarkLeaves", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.AuroraPillar", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.AuroraSlab", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.AuroraDoubleSlab", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("sensus"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TrollSteinn", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("potentia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.WispyCloud", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 1).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("aqua"), 1).add(Aspect.getAspect("tempestas"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.FluffyCloud", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 1).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 1).add(Aspect.getAspect("tempestas"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.HugeStalk", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.GiantCobble", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("perditio"), 16));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.GiantLog", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 16));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.GiantLeaves", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 16));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.GiantObsidian", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 16)
                        .add(Aspect.getAspect("tenebrae"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.UberousSoil", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("aqua"), 4)
                        .add(Aspect.getAspect("herba"), 4).add(Aspect.getAspect("victus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.HugeGloomBlock", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("tenebrae"), 2)
                        .add(Aspect.getAspect("herba"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.KnightmetalBlock", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("lucrum"), 9));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.UnripeTrollBer", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("terra"), 1)
                        .add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.TrollBer", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("terra"), 1)
                        .add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.HugeLilyPad", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 8).add(Aspect.getAspect("aqua"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.HugeWaterLily", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 3));
        ThaumcraftApi.registerObjectTag(getModItem("TwilightForest", "tile.Slider", 1, 0, missing), new AspectList());
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.CastleBrick", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.CastleBrick", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("perditio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.CastleBrick", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("perditio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.CastleBrick", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("tenebrae"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.CastleMagic", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("praecantatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.CastleMagic", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("praecantatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.CastleMagic", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("praecantatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "tile.CastleMagic", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("terra"), 3).add(Aspect.getAspect("ignis"), 3)
                        .add(Aspect.getAspect("praecantatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.nagaScale", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 3).add(Aspect.getAspect("tutamen"), 2)
                        .add(Aspect.getAspect("bestia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.plateNaga", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 24).add(Aspect.getAspect("tutamen"), 16)
                        .add(Aspect.getAspect("bestia"), 16).add(Aspect.getAspect("superbia"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.legsNaga", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 21).add(Aspect.getAspect("tutamen"), 14)
                        .add(Aspect.getAspect("bestia"), 14).add(Aspect.getAspect("superbia"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.scepterTwilight", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 40).add(Aspect.getAspect("iter"), 35)
                        .add(Aspect.getAspect("praecantatio"), 25).add(Aspect.getAspect("mortuus"), 20)
                        .add(Aspect.getAspect("corpus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.scepterLifeDrain", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 40).add(Aspect.getAspect("victus"), 15)
                        .add(Aspect.getAspect("gula"), 20).add(Aspect.getAspect("praecantatio"), 25)
                        .add(Aspect.getAspect("mortuus"), 20).add(Aspect.getAspect("corpus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.scepterZombie", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 40).add(Aspect.getAspect("exanimis"), 35)
                        .add(Aspect.getAspect("praecantatio"), 25).add(Aspect.getAspect("mortuus"), 20)
                        .add(Aspect.getAspect("corpus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.scepterTwilight", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 40).add(Aspect.getAspect("iter"), 35)
                        .add(Aspect.getAspect("praecantatio"), 25).add(Aspect.getAspect("mortuus"), 20)
                        .add(Aspect.getAspect("corpus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.scepterLifeDrain", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 40).add(Aspect.getAspect("victus"), 15)
                        .add(Aspect.getAspect("gula"), 20).add(Aspect.getAspect("praecantatio"), 25)
                        .add(Aspect.getAspect("mortuus"), 20).add(Aspect.getAspect("corpus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.scepterZombie", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 40).add(Aspect.getAspect("exanimis"), 35)
                        .add(Aspect.getAspect("praecantatio"), 25).add(Aspect.getAspect("mortuus"), 20)
                        .add(Aspect.getAspect("corpus"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.tfFeather", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("volatus"), 2).add(Aspect.getAspect("aer"), 1)
                        .add(Aspect.getAspect("tenebrae"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.magicMapFocus", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("volatus"), 2).add(Aspect.getAspect("aer"), 1)
                        .add(Aspect.getAspect("tenebrae"), 1).add(Aspect.getAspect("lux"), 1)
                        .add(Aspect.getAspect("praecantatio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.venisonRaw", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("mortuus"), 3).add(Aspect.getAspect("victus"), 2)
                        .add(Aspect.getAspect("bestia"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.venisonCooked", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("mortuus"), 4).add(Aspect.getAspect("fames"), 3)
                        .add(Aspect.getAspect("fabrico"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.hydraChop", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("mortuus"), 9).add(Aspect.getAspect("victus"), 6)
                        .add(Aspect.getAspect("bestia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.fieryBlood", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("vacuos"), 1).add(Aspect.getAspect("victus"), 4)
                        .add(Aspect.getAspect("aqua"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.trophy", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("luxuria"), 1)
                        .add(Aspect.getAspect("superbia"), 2).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("ignis"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.trophy", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("luxuria"), 1)
                        .add(Aspect.getAspect("superbia"), 2).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("terra"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.trophy", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("luxuria"), 1)
                        .add(Aspect.getAspect("superbia"), 2).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("exanimis"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.trophy", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("luxuria"), 1)
                        .add(Aspect.getAspect("superbia"), 2).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("infernus"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.trophy", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("lucrum"), 10).add(Aspect.getAspect("luxuria"), 1)
                        .add(Aspect.getAspect("superbia"), 2).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("gelum"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.minotaurAxe", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 10).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("telum"), 8).add(Aspect.getAspect("instrumentum"), 8)
                        .add(Aspect.getAspect("superbia"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.transformPowder", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("mortuus"), 4).add(Aspect.getAspect("fames"), 3)
                        .add(Aspect.getAspect("fabrico"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.meefRaw", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("mortuus"), 3).add(Aspect.getAspect("victus"), 2)
                        .add(Aspect.getAspect("bestia"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.meefSteak", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("mortuus"), 4).add(Aspect.getAspect("fames"), 3)
                        .add(Aspect.getAspect("fabrico"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.meefStroganoff", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("mortuus"), 4).add(Aspect.getAspect("fames"), 4)
                        .add(Aspect.getAspect("fabrico"), 2).add(Aspect.getAspect("arbor"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.mazeWafer", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("messis"), 4).add(Aspect.getAspect("fames"), 3)
                        .add(Aspect.getAspect("fabrico"), 1).add(Aspect.getAspect("sano"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.oreMagnet", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("magneto"), 4)
                        .add(Aspect.getAspect("perfodio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.oreMagnet", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("magneto"), 4)
                        .add(Aspect.getAspect("perfodio"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.crumbleHorn", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 18).add(Aspect.getAspect("praecantatio"), 14)
                        .add(Aspect.getAspect("ordo"), 12).add(Aspect.getAspect("auram"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.crumbleHorn", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 18).add(Aspect.getAspect("praecantatio"), 14)
                        .add(Aspect.getAspect("ordo"), 12).add(Aspect.getAspect("auram"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.peacockFan", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 18).add(Aspect.getAspect("volatus"), 10)
                        .add(Aspect.getAspect("motus"), 10).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("arbor"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.peacockFan", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("aer"), 18).add(Aspect.getAspect("volatus"), 10)
                        .add(Aspect.getAspect("motus"), 10).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("arbor"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.moonwormQueen", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("victus"), 10).add(Aspect.getAspect("lux"), 10)
                        .add(Aspect.getAspect("motus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.moonwormQueen", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("victus"), 10).add(Aspect.getAspect("lux"), 10)
                        .add(Aspect.getAspect("motus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.charmOfLife1", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("sano"), 16).add(Aspect.getAspect("ordo"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8).add(Aspect.getAspect("victus"), 8)
                        .add(Aspect.getAspect("lucrum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.charmOfLife2", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("sano"), 64).add(Aspect.getAspect("ordo"), 64)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("victus"), 32)
                        .add(Aspect.getAspect("lucrum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.charmOfKeeping1", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("ordo"), 4)
                        .add(Aspect.getAspect("praecantatio"), 3).add(Aspect.getAspect("tutamen"), 3)
                        .add(Aspect.getAspect("lucrum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.charmOfKeeping2", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("instrumentum"), 16).add(Aspect.getAspect("ordo"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8).add(Aspect.getAspect("tutamen"), 8)
                        .add(Aspect.getAspect("lucrum"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.charmOfKeeping3", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("instrumentum"), 64).add(Aspect.getAspect("ordo"), 64)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("tutamen"), 32)
                        .add(Aspect.getAspect("lucrum"), 16));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.towerKey", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 2).add(Aspect.getAspect("lucrum"), 2)
                        .add(Aspect.getAspect("lux"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.borerEssence", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("praecantatio"), 2).add(Aspect.getAspect("lucrum"), 2)
                        .add(Aspect.getAspect("ordo"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.experiment115", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("messis"), 5).add(Aspect.getAspect("fames"), 4)
                        .add(Aspect.getAspect("fabrico"), 2).add(Aspect.getAspect("alienis"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.phantomHelm", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("tutamen"), 5).add(Aspect.getAspect("fabrico"), 3)
                        .add(Aspect.getAspect("metallum"), 7).add(Aspect.getAspect("spiritus"), 5)
                        .add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.phantomPlate", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("tutamen"), 8).add(Aspect.getAspect("fabrico"), 5)
                        .add(Aspect.getAspect("metallum"), 11).add(Aspect.getAspect("spiritus"), 8)
                        .add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.lampOfCinders", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("lucrum"), 16).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("fabrico"), 6).add(Aspect.getAspect("praecantatio"), 8)
                        .add(Aspect.getAspect("instrumentum"), 4).add(Aspect.getAspect("luxuria"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.fieryTears", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("vacuos"), 1).add(Aspect.getAspect("ira"), 4)
                        .add(Aspect.getAspect("exanimis"), 4).add(Aspect.getAspect("spiritus"), 4)
                        .add(Aspect.getAspect("praecantatio"), 2).add(Aspect.getAspect("aqua"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.alphaFur", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 6).add(Aspect.getAspect("gelum"), 3)
                        .add(Aspect.getAspect("bestia"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.arcticFur", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("gelum"), 1)
                        .add(Aspect.getAspect("bestia"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.iceBomb", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("gelum"), 8).add(Aspect.getAspect("motus"), 8)
                        .add(Aspect.getAspect("fabrico"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.arcticHelm", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("tutamen"), 3).add(Aspect.getAspect("fabrico"), 2)
                        .add(Aspect.getAspect("pannus"), 6).add(Aspect.getAspect("gelum"), 2)
                        .add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.arcticPlate", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("tutamen"), 7).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("pannus"), 14).add(Aspect.getAspect("gelum"), 4)
                        .add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.arcticLegs", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("tutamen"), 5).add(Aspect.getAspect("fabrico"), 3)
                        .add(Aspect.getAspect("pannus"), 10).add(Aspect.getAspect("gelum"), 3)
                        .add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.arcticBoots", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("tutamen"), 2).add(Aspect.getAspect("fabrico"), 2)
                        .add(Aspect.getAspect("pannus"), 4).add(Aspect.getAspect("gelum"), 2)
                        .add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.yetiHelm", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("tutamen"), 4).add(Aspect.getAspect("fabrico"), 2)
                        .add(Aspect.getAspect("pannus"), 12).add(Aspect.getAspect("gelum"), 4)
                        .add(Aspect.getAspect("instrumentum"), 1).add(Aspect.getAspect("praecantatio"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.yetiPlate", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("tutamen"), 8).add(Aspect.getAspect("fabrico"), 4)
                        .add(Aspect.getAspect("pannus"), 24).add(Aspect.getAspect("gelum"), 8)
                        .add(Aspect.getAspect("instrumentum"), 1).add(Aspect.getAspect("praecantatio"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.yetiLegs", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("tutamen"), 6).add(Aspect.getAspect("fabrico"), 3)
                        .add(Aspect.getAspect("pannus"), 18).add(Aspect.getAspect("gelum"), 6)
                        .add(Aspect.getAspect("instrumentum"), 1).add(Aspect.getAspect("praecantatio"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.yetiBoots", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("tutamen"), 3).add(Aspect.getAspect("fabrico"), 2)
                        .add(Aspect.getAspect("pannus"), 9).add(Aspect.getAspect("gelum"), 3)
                        .add(Aspect.getAspect("instrumentum"), 1).add(Aspect.getAspect("praecantatio"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.magicBeans", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 16).add(Aspect.getAspect("praecantatio"), 8)
                        .add(Aspect.getAspect("sensus"), 4));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.giantPick", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perfodio"), 32).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("arbor"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.giantSword", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("telum"), 32).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("arbor"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.enderBow", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("telum"), 3).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 2)
                        .add(Aspect.getAspect("alienis"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.iceBow", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("telum"), 3).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 2)
                        .add(Aspect.getAspect("gelum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.tripleBow", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("telum"), 6).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 2)
                        .add(Aspect.getAspect("arbor"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.seekerBow", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("telum"), 3).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 2)
                        .add(Aspect.getAspect("iter"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.iceSword", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("telum"), 4).add(Aspect.getAspect("lucrum"), 2)
                        .add(Aspect.getAspect("praecantatio"), 2).add(Aspect.getAspect("gelum"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.glassSword", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("telum"), 14).add(Aspect.getAspect("vitreus"), 20)
                        .add(Aspect.getAspect("lucrum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.giantPick", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("perfodio"), 32).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("arbor"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.giantSword", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("telum"), 32).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("arbor"), 8));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.enderBow", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("telum"), 3).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 2)
                        .add(Aspect.getAspect("alienis"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.iceBow", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("telum"), 3).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 2)
                        .add(Aspect.getAspect("gelum"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.tripleBow", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("telum"), 6).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 2)
                        .add(Aspect.getAspect("arbor"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.seekerBow", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("telum"), 3).add(Aspect.getAspect("volatus"), 1)
                        .add(Aspect.getAspect("pannus"), 2).add(Aspect.getAspect("bestia"), 2)
                        .add(Aspect.getAspect("iter"), 2));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.iceSword", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("telum"), 4).add(Aspect.getAspect("lucrum"), 2)
                        .add(Aspect.getAspect("praecantatio"), 2).add(Aspect.getAspect("gelum"), 6));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.glassSword", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("telum"), 14).add(Aspect.getAspect("vitreus"), 20)
                        .add(Aspect.getAspect("lucrum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.knightmetalRing", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("instrumentum"), 3).add(Aspect.getAspect("ordo"), 3)
                        .add(Aspect.getAspect("fabrico"), 3));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.chainBlock", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("telum"), 10).add(Aspect.getAspect("metallum"), 20)
                        .add(Aspect.getAspect("motus"), 4).add(Aspect.getAspect("lucrum"), 8)
                        .add(Aspect.getAspect("instrumentum"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem("TwilightForest", "item.chainBlock", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("telum"), 10).add(Aspect.getAspect("metallum"), 20)
                        .add(Aspect.getAspect("motus"), 4).add(Aspect.getAspect("lucrum"), 8)
                        .add(Aspect.getAspect("instrumentum"), 10));
        ThaumcraftApi.registerObjectTag(
                getModItem("Forestry", "grafter", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 2).add(Aspect.getAspect("arbor"), 1)
                        .add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("Forestry", "scoop", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 4).add(Aspect.getAspect("pannus"), 3)
                        .add(Aspect.getAspect("instrumentum"), 1));
        ThaumcraftApi.registerObjectTag(
                getModItem("thaumicbases", "tobaccoPowder", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("herba"), 1).add(Aspect.getAspect("humanus"), 1)
                        .add(Aspect.getAspect("perditio"), 1));

    }

}
