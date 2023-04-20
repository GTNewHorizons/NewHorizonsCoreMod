package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

import com.dreammaster.thaumcraft.TCHelper;
import gregtech.api.enums.Mods;

public class ScriptWitchery implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Witchery";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.Witchery.ID, Mods.Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {

        ItemStack missing = new ItemStack(Blocks.dirt);

        ResearchCategories.registerCategory(
                "WITCHERY",
                new ResourceLocation("dreamcraft:textures/thaumcraft/icon/icon_Witchery.png"),
                new ResourceLocation("dreamcraft:textures/thaumcraft/tab/tab_Witchery.png"));
        new ResearchItem(
                "ANOINTINGPASTE",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("aqua"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6),
                0,
                -4,
                2,
                getModItem("witchery", "ingredient", 1, 153, missing))
                        .setPages(new ResearchPage("Witchery.research_page.ANOINTINGPASTE.1")).registerResearchItem();
        new ResearchItem(
                "OVEN",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("machina"), 6),
                -2,
                2,
                3,
                getModItem("witchery", "witchesovenidle", 1, 0, missing))
                        .setPages(
                                new ResearchPage("Witchery.research_page.OVEN.1"),
                                new ResearchPage("Witchery.research_page.OVEN.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "OVEN",
                getModItem("witchery", "witchesovenidle", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "plateSteel",
                'b',
                "plateThaumium",
                'c',
                "plateSteel",
                'd',
                getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                'e',
                getModItem("Thaumcraft", "blockMetalDevice", 1, 0, missing),
                'f',
                getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                'g',
                getModItem("IC2", "blockFenceIron", 1, 0, missing),
                'h',
                getModItem("IC2", "blockMachine", 1, 1, missing),
                'i',
                getModItem("IC2", "blockFenceIron", 1, 0, missing));
        TCHelper.addResearchPage(
                "OVEN",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("witchery", "witchesovenidle", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("OVEN", 1);
        new ResearchItem(
                "ATTUNEDSTONE",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("vitreus"), 12)
                        .add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("praecantatio"), 6),
                2,
                0,
                3,
                getModItem("witchery", "ingredient", 1, 10, missing)).setParents("OVEN")
                        .setPages(new ResearchPage("Witchery.research_page.ATTUNEDSTONE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ATTUNEDSTONE",
                getModItem("witchery", "ingredient", 1, 10, missing),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("ordo"), 30),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("witchery", "ingredient", 1, 34, missing),
                'e',
                getModItem("minecraft", "diamond", 1, 0, missing),
                'h',
                getModItem("minecraft", "lava_bucket", 1, 0, missing));
        TCHelper.addResearchPage(
                "ATTUNEDSTONE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("witchery", "ingredient", 1, 10, missing))));
        new ResearchItem(
                "QUARTZSPHERE",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("vitreus"), 15).add(Aspect.getAspect("instrumentum"), 12)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                2,
                -2,
                3,
                getModItem("witchery", "ingredient", 1, 92, missing)).setParents("ATTUNEDSTONE")
                        .setPages(new ResearchPage("Witchery.research_page.QUARTZSPHERE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "QUARTZSPHERE",
                getModItem("witchery", "ingredient", 1, 92, missing),
                new AspectList().add(Aspect.getAspect("aer"), 25).add(Aspect.getAspect("ignis"), 25)
                        .add(Aspect.getAspect("terra"), 25).add(Aspect.getAspect("ordo"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "plateNetherQuartz",
                'b',
                "plateQuartzite",
                'c',
                "plateNetherQuartz",
                'd',
                "plateCertusQuartz",
                'e',
                "lensGlass",
                'f',
                "plateCertusQuartz",
                'g',
                "plateNetherQuartz",
                'h',
                "plateQuartzite",
                'i',
                "plateNetherQuartz");
        TCHelper.addResearchPage(
                "QUARTZSPHERE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("witchery", "ingredient", 1, 92, missing))));
        new ResearchItem(
                "CANDELABRA",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("lux"), 12)
                        .add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("ignis"), 6),
                0,
                -2,
                3,
                getModItem("witchery", "ingredient", 1, 0, missing)).setParents("ALTAR", "TALLOW", "ATTUNEDSTONE")
                        .setConcealed().setPages(new ResearchPage("Witchery.research_page.CANDELABRA"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CANDELABRA",
                getModItem("witchery", "ingredient", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 5).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCandle", 1, 0, missing),
                'b',
                getModItem("Thaumcraft", "blockCandle", 1, 0, missing),
                'c',
                getModItem("Thaumcraft", "blockCandle", 1, 0, missing),
                'd',
                "stickIron",
                'e',
                getModItem("witchery", "ingredient", 1, 10, missing),
                'f',
                "stickIron",
                'g',
                "plateIron",
                'h',
                "stickThaumium",
                'i',
                "plateIron");
        TCHelper.addResearchPage(
                "CANDELABRA",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("witchery", "ingredient", 1, 0, missing))));
        new ResearchItem(
                "KETTLE",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("ignis"), 6),
                4,
                0,
                3,
                getModItem("witchery", "kettle", 1, 0, missing))
                        .setParents("ATTUNEDSTONE").setConcealed()
                        .setPages(
                                new ResearchPage("Witchery.research_page.KETTLE.1"),
                                new ResearchPage("Witchery.research_page.KETTLE.2"),
                                new ResearchPage("Witchery.research_page.KETTLE.3"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "KETTLE",
                getModItem("witchery", "kettle", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 40).add(Aspect.getAspect("ignis"), 40)
                        .add(Aspect.getAspect("aqua"), 40).add(Aspect.getAspect("perditio"), 40),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolScrewdriver",
                'b',
                getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                'c',
                "craftingToolHardHammer",
                'd',
                "plateSteel",
                'e',
                getModItem("witchery", "ingredient", 1, 10, missing),
                'f',
                "plateSteel",
                'g',
                "screwThaumium",
                'h',
                getModItem("minecraft", "cauldron", 1, 0, missing),
                'i',
                "screwThaumium");
        TCHelper.addResearchPage(
                "KETTLE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("witchery", "kettle", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("KETTLE", 2);
        new ResearchItem(
                "SPINNINGWHEELW",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("arbor"), 18).add(Aspect.getAspect("motus"), 15)
                        .add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("instrumentum"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("praecantatio"), 3),
                6,
                0,
                3,
                getModItem("witchery", "spinningwheel", 1, 0, missing)).setParents("KETTLE").setConcealed()
                        .setPages(new ResearchPage("Witchery.research_page.SPINNINGWHEELW")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SPINNINGWHEELW",
                getModItem("witchery", "spinningwheel", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 60).add(Aspect.getAspect("ignis"), 60)
                        .add(Aspect.getAspect("ordo"), 60).add(Aspect.getAspect("perditio"), 60),
                "abc",
                "def",
                "ghi",
                'a',
                "stickStainlessSteel",
                'b',
                getModItem("witchery", "ingredient", 1, 10, missing),
                'c',
                "screwStainlessSteel",
                'd',
                getModItem("minecraft", "item_frame", 1, 0, missing),
                'e',
                getModItem("minecraft", "item_frame", 1, 0, missing),
                'f',
                getModItem("minecraft", "item_frame", 1, 0, missing),
                'g',
                "stickStainlessSteel",
                'h',
                "craftingToolScrewdriver",
                'i',
                "stickStainlessSteel");
        TCHelper.addResearchPage(
                "SPINNINGWHEELW",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("witchery", "spinningwheel", 1, 0, missing))));
        new ResearchItem(
                "RUBYSLIPPERS",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("auram"), 21).add(Aspect.getAspect("aer"), 18)
                        .add(Aspect.getAspect("fames"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("vitreus"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                6,
                -2,
                3,
                getModItem("witchery", "rubyslippers", 1, 0, missing)).setParents("BLOODALTAR", "SPINNINGWHEELW")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("Witchery.research_page.RUBYSLIPPERS.1"),
                                new ResearchPage("Witchery.research_page.RUBYSLIPPERS.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUBYSLIPPERS",
                getModItem("witchery", "rubyslippers", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("auram"), 64).add(Aspect.getAspect("aer"), 64)
                        .add(Aspect.getAspect("lucrum"), 32).add(Aspect.getAspect("potentia"), 16)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("fames"), 32),
                getModItem("witchery", "seepingshoes", 1, 0, missing),
                new ItemStack[] { getModItem("witchery", "ingredient", 1, 80, missing),
                        getModItem("dreamcraft", "item.ManyullynCrystal", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 34, missing),
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                        getModItem("dreamcraft", "item.ManyullynCrystal", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 80, missing),
                        getModItem("dreamcraft", "item.ManyullynCrystal", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 34, missing),
                        getModItem("dreamcraft", "item.ManyullynCrystal", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RUBYSLIPPERS",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("witchery", "rubyslippers", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("RUBYSLIPPERS", 5);
        new ResearchItem(
                "DISTILLERY",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("motus"), 15)
                        .add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("instrumentum"), 9)
                        .add(Aspect.getAspect("aqua"), 6).add(Aspect.getAspect("praecantatio"), 3),
                8,
                0,
                3,
                getModItem("witchery", "distilleryidle", 1, 0, missing)).setParents("SPINNINGWHEELW").setConcealed()
                        .setPages(new ResearchPage("Witchery.research_page.DISTILLERY")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DISTILLERY",
                getModItem("witchery", "distilleryidle", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 80).add(Aspect.getAspect("ignis"), 80)
                        .add(Aspect.getAspect("ordo"), 80).add(Aspect.getAspect("perditio"), 80)
                        .add(Aspect.getAspect("aqua"), 80),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("witchery", "ingredient", 1, 27, missing),
                'b',
                getModItem("witchery", "ingredient", 1, 10, missing),
                'c',
                getModItem("witchery", "ingredient", 1, 27, missing),
                'd',
                "pipeSmallStainlessSteel",
                'e',
                getModItem("witchery", "cauldron", 1, 0, missing),
                'f',
                "pipeSmallStainlessSteel",
                'g',
                "plateDenseThaumium",
                'h',
                "craftingIronFurnace",
                'i',
                "plateDenseThaumium");
        TCHelper.addResearchPage(
                "DISTILLERY",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("witchery", "distilleryidle", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("DISTILLERY", 3);
        new ResearchItem(
                "RITUALCHALK",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("sensus"), 18).add(Aspect.getAspect("motus"), 15)
                        .add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("iter"), 6).add(Aspect.getAspect("praecantatio"), 3),
                8,
                -2,
                3,
                getModItem("witchery", "chalkritual", 1, 0, missing))
                        .setParents("DISTILLERY").setConcealed()
                        .setPages(
                                new ResearchPage("Witchery.research_page.RITUALCHALK.1"),
                                new ResearchPage("Witchery.research_page.RITUALCHALK.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RITUALCHALK",
                getModItem("witchery", "chalkritual", 2, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("ignis"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("witchery", "ingredient", 1, 18, missing),
                'b',
                getModItem("witchery", "ingredient", 1, 37, missing),
                'c',
                getModItem("witchery", "ingredient", 1, 18, missing),
                'd',
                getModItem("witchery", "ingredient", 1, 18, missing),
                'e',
                getModItem("witchery", "ingredient", 1, 17, missing),
                'f',
                getModItem("witchery", "ingredient", 1, 18, missing),
                'g',
                getModItem("witchery", "ingredient", 1, 18, missing),
                'h',
                getModItem("witchery", "ingredient", 1, 17, missing),
                'i',
                getModItem("witchery", "ingredient", 1, 18, missing));
        TCHelper.addResearchPage(
                "RITUALCHALK",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("witchery", "chalkritual", 1, 0, missing))));
        new ResearchItem(
                "CIRCLETALISMAN",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("lucrum"), 18).add(Aspect.getAspect("motus"), 15)
                        .add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("praecantatio"), 3),
                10,
                -2,
                3,
                getModItem("witchery", "circletalisman", 1, 0, missing))
                        .setParents("RITUALCHALK").setConcealed()
                        .setPages(
                                new ResearchPage("Witchery.research_page.CIRCLETALISMAN.1"),
                                new ResearchPage("Witchery.research_page.CIRCLETALISMAN.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CIRCLETALISMAN",
                getModItem("witchery", "circletalisman", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("ignis"), 50),
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
                "gemExquisiteDiamond",
                'f',
                "stickGold",
                'g',
                "screwGold",
                'h',
                "stickGold",
                'i',
                "screwGold");
        TCHelper.addResearchPage(
                "CIRCLETALISMAN",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("witchery", "circletalisman", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("CIRCLETALISMAN", 1);
        new ResearchItem(
                "ALTAR",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("arbor"), 9).add(Aspect.getAspect("terra"), 6),
                -2,
                0,
                3,
                getModItem("witchery", "altar", 1, 0, missing))
                        .setParents("OVEN", "ARCANESTONE").setConcealed()
                        .setPages(
                                new ResearchPage("Witchery.research_page.ALTAR.1"),
                                new ResearchPage("Witchery.research_page.ALTAR.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALTAR",
                getModItem("witchery", "altar", 2, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("witchery", "ingredient", 1, 32, missing),
                'b',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'c',
                getModItem("witchery", "ingredient", 1, 31, missing),
                'd',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'e',
                getModItem("witchery", "witchlog", 1, 0, missing),
                'f',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'g',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'h',
                getModItem("witchery", "witchlog", 1, 0, missing),
                'i',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing));
        TCHelper.addResearchPage(
                "ALTAR",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("witchery", "altar", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ALTAR", 2);
        new ResearchItem(
                "CHALICE",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("terra"), 6),
                0,
                0,
                3,
                getModItem("witchery", "ingredient", 1, 1, missing)).setParents("ALTAR", "ATTUNEDSTONE").setConcealed()
                        .setPages(new ResearchPage("Witchery.research_page.CHALICE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CHALICE",
                getModItem("witchery", "ingredient", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "foilGold",
                'b',
                getModItem("witchery", "ingredient", 1, 10, missing),
                'c',
                "foilGold",
                'd',
                "plateGold",
                'e',
                "plateGold",
                'f',
                "plateGold",
                'g',
                "foilThaumium",
                'h',
                "ingotGold",
                'i',
                "foilThaumium");
        TCHelper.addResearchPage(
                "CHALICE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("witchery", "ingredient", 1, 1, missing))));
        new ResearchItem(
                "ARTHANA",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("mortuus"), 6),
                -4,
                -2,
                3,
                getModItem("witchery", "arthana", 1, 0, missing))
                        .setParents("ALTAR").setConcealed()
                        .setPages(
                                new ResearchPage("Witchery.research_page.ARTHANA.1"),
                                new ResearchPage("Witchery.research_page.ARTHANA.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARTHANA",
                getModItem("witchery", "arthana", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("perditio"), 15)
                        .add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("TConstruct", "handGuard", 1, 16, missing),
                'b',
                "craftingToolScrewdriver",
                'c',
                getModItem("TConstruct", "knifeBlade", 1, 202, missing),
                'd',
                "screwThaumium",
                'e',
                "gemEmerald",
                'f',
                "craftingToolHardHammer",
                'g',
                getModItem("TConstruct", "toolRod", 1, 6, missing),
                'h',
                "screwThaumium",
                'i',
                getModItem("TConstruct", "handGuard", 1, 16, missing));
        TCHelper.addResearchPage(
                "ARTHANA",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("witchery", "arthana", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ARTHANA", 2);
        new ResearchItem(
                "WARMBLOOD",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("fames"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("aqua"), 9).add(Aspect.getAspect("exanimis"), 6),
                -2,
                -2,
                3,
                getModItem("witchery", "ingredient", 1, 163, missing)).setParents("ALTAR").setConcealed()
                        .setPages(new ResearchPage("Witchery.research_page.WARMBLOOD")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "WARMBLOOD",
                getModItem("witchery", "ingredient", 1, 163, missing),
                getModItem("TConstruct", "jerky", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("exanimis"), 4).add(Aspect.getAspect("fames"), 4)
                        .add(Aspect.getAspect("lucrum"), 4));
        TCHelper.addResearchPage(
                "WARMBLOOD",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("witchery", "ingredient", 1, 163, missing))));
        ThaumcraftApi.addWarpToResearch("WARMBLOOD", 3);
        new ResearchItem(
                "FUMEFUNNEL",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("lux"), 9).add(Aspect.getAspect("sensus"), 6),
                0,
                2,
                3,
                getModItem("witchery", "fumefunnel", 1, 0, missing)).setParents("OVEN").setConcealed()
                        .setPages(new ResearchPage("Witchery.research_page.FUMEFUNNEL")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FUMEFUNNEL",
                getModItem("witchery", "fumefunnel", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("terra"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                'c',
                "plateThaumium",
                'd',
                "plateGlowstone",
                'e',
                "bucketLava",
                'f',
                "plateGlowstone",
                'g',
                "blockSteel",
                'h',
                getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                'i',
                "blockSteel");
        TCHelper.addResearchPage(
                "FUMEFUNNEL",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("witchery", "fumefunnel", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("FUMEFUNNEL", 1);
        new ResearchItem(
                "FUMEFILTER",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("vitreus"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("praecantatio"), 3),
                2,
                2,
                3,
                getModItem("witchery", "ingredient", 1, 73, missing))
                        .setParents("DISTILESSENTIA", "FUMEFUNNEL", "ATTUNEDSTONE").setConcealed()
                        .setPages(new ResearchPage("Witchery.research_page.FUMEFILTER")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FUMEFILTER",
                getModItem("witchery", "ingredient", 1, 73, missing),
                new AspectList().add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("ordo"), 16)
                        .add(Aspect.getAspect("terra"), 16),
                "abc",
                "def",
                "ghi",
                'a',
                "paneGlass",
                'b',
                "paneGlass",
                'c',
                "paneGlass",
                'd',
                "plateThaumium",
                'e',
                getModItem("witchery", "ingredient", 1, 10, missing),
                'f',
                "plateThaumium",
                'g',
                "paneGlass",
                'h',
                "paneGlass",
                'i',
                "paneGlass");
        TCHelper.addResearchPage(
                "FUMEFILTER",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("witchery", "ingredient", 1, 73, missing))));
        new ResearchItem(
                "FILTEREDFUMEFUNNEL",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("vitreus"), 12)
                        .add(Aspect.getAspect("lux"), 9).add(Aspect.getAspect("praecantatio"), 6),
                2,
                4,
                3,
                getModItem("witchery", "filteredfumefunnel", 1, 0, missing)).setParents("FUMEFILTER").setConcealed()
                        .setPages(new ResearchPage("Witchery.research_page.FILTEREDFUMEFUNNEL")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FILTEREDFUMEFUNNEL",
                getModItem("witchery", "filteredfumefunnel", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("metallum"), 32).add(Aspect.getAspect("vitreus"), 8)
                        .add(Aspect.getAspect("praecantatio"), 24).add(Aspect.getAspect("lux"), 16),
                getModItem("witchery", "fumefunnel", 1, 0, missing),
                new ItemStack[] { getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 73, missing),
                        getModItem("dreamcraft", "item.SteelBars", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 8, missing), });
        TCHelper.addResearchPage(
                "FILTEREDFUMEFUNNEL",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("witchery", "filteredfumefunnel", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("FILTEREDFUMEFUNNEL", 2);
        new ResearchItem(
                "WAYSTONE",
                "WITCHERY",
                new AspectList().add(Aspect.getAspect("motus"), 15).add(Aspect.getAspect("iter"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("praecantatio"), 6),
                8,
                -4,
                3,
                getModItem("witchery", "ingredient", 1, 12, missing)).setParents("RITUALCHALK").setConcealed()
                        .setPages(new ResearchPage("Witchery.research_page.WAYSTONE")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "WAYSTONE",
                getModItem("witchery", "ingredient", 1, 12, missing),
                5,
                new AspectList().add(Aspect.getAspect("motus"), 48).add(Aspect.getAspect("iter"), 64)
                        .add(Aspect.getAspect("praecantatio"), 24).add(Aspect.getAspect("tenebrae"), 32)
                        .add(Aspect.getAspect("aer"), 64),
                getModItem("minecraft", "flint", 1, 0, missing),
                new ItemStack[] { getModItem("witchery", "chalkritual", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 7, missing),
                        getModItem("witchery", "chalkotherwhere", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 7, missing),
                        getModItem("witchery", "chalkritual", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 7, missing),
                        getModItem("witchery", "chalkotherwhere", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 7, missing), });
        TCHelper.addResearchPage(
                "WAYSTONE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("witchery", "ingredient", 1, 12, missing))));
        ThaumcraftApi.addWarpToResearch("WAYSTONE", 5);
    }
}
