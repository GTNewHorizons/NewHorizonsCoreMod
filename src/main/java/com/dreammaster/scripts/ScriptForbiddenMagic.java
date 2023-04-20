package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

import com.dreammaster.thaumcraft.TCHelper;
import gregtech.api.enums.Mods;

public class ScriptForbiddenMagic implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Forbidden Magic";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.ForbiddenMagic.ID, Mods.Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack missing = new ItemStack(Blocks.dirt);

        // WANDS
        TCHelper.clearPages("CAP_manasteel");
        TCHelper.clearPages("CAP_terrasteel");
        TCHelper.clearPages("CAP_elementium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_vinteum",
                getModItem("ForbiddenMagic", "WandCaps", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 40).add(Aspect.getAspect("terra"), 40)
                        .add(Aspect.getAspect("ignis"), 40).add(Aspect.getAspect("aqua"), 40)
                        .add(Aspect.getAspect("ordo"), 40).add(Aspect.getAspect("perditio"), 40),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                "foilVinteum",
                'c',
                "screwTitanium",
                'd',
                "foilVinteum",
                'e',
                "ringVinteum",
                'f',
                "foilVinteum",
                'g',
                "screwTitanium",
                'h',
                "foilVinteum",
                'i',
                "screwTitanium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_witchwood_staff",
                getModItem("ForbiddenMagic", "WandCores", 1, 10, missing),
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
                getModItem("ForbiddenMagic", "WandCores", 1, 4, missing),
                'f',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'g',
                getModItem("ForbiddenMagic", "WandCores", 1, 4, missing),
                'h',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing));
        ThaumcraftApi.addCrucibleRecipe(
                "VINTEUM",
                getModItem("gregtech", "gt.metaitem.01", 1, 9529, missing),
                getModItem("gregtech", "gt.metaitem.01", 1, 9330, missing),
                new AspectList().add(Aspect.getAspect("permutatio"), 4).add(Aspect.getAspect("ordo"), 2)
                        .add(Aspect.getAspect("vitreus"), 2));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_witchwood",
                getModItem("ForbiddenMagic", "WandCores", 1, 4, missing),
                6,
                new AspectList().add(Aspect.getAspect("arbor"), 64).add(Aspect.getAspect("praecantatio"), 48)
                        .add(Aspect.getAspect("herba"), 32).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("vacuos"), 24),
                getModItem("witchery", "ingredient", 1, 82, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 8529, missing),
                        getModItem("witchery", "witchsapling", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 34, missing),
                        getModItem("witchery", "witchsapling", 1, 1, missing),
                        getModItem("witchery", "ingredient", 1, 36, missing),
                        getModItem("witchery", "witchsapling", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 8529, missing),
                        getModItem("witchery", "witchsapling", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 34, missing),
                        getModItem("witchery", "witchsapling", 1, 1, missing),
                        getModItem("witchery", "ingredient", 1, 36, missing),
                        getModItem("witchery", "witchsapling", 1, 2, missing), });
        new ResearchItem(
                "JOURNEY",
                "FORBIDDEN",
                new AspectList().add(Aspect.getAspect("iter"), 5).add(Aspect.getAspect("praecantatio"), 10)
                        .add(Aspect.getAspect("instrumentum"), 3),
                -3,
                1,
                3,
                getModItem("BiomesOPlenty", "food", 1, 7, missing))
                        .setPages(new ResearchPage("derp.research_page.JOURNEY")).setParents("SCHOOLS").setRound()
                        .setStub().setAutoUnlock().registerResearchItem();
        new ResearchItem(
                "ROD_livingwood",
                "FORBIDDEN",
                new AspectList().add(Aspect.getAspect("victus"), 5).add(Aspect.getAspect("praecantatio"), 10)
                        .add(Aspect.getAspect("herba"), 3).add(Aspect.getAspect("instrumentum"), 4)
                        .add(Aspect.getAspect("arbor"), 5),
                -1,
                3,
                3,
                getModItem("ForbiddenMagic", "WandCores", 1, 7, missing))
                        .setPages(new ResearchPage("derp.research_page.ROD_livingwood")).setConcealed()
                        .setParents("JOURNEY", "BLOODALTAR", "BALLOFMOSS", "ROD_greatwood").registerResearchItem();
        ThaumcraftApi.addWarpToResearch("ROD_livingwood", 2);
        TCHelper.orphanResearch("ROD_dreamwood");
        TCHelper.removeResearch("ROD_dreamwood");
        new ResearchItem(
                "ROD_dreamwood_v2",
                "FORBIDDEN",
                new AspectList().add(Aspect.getAspect("auram"), 5).add(Aspect.getAspect("praecantatio"), 10)
                        .add(Aspect.getAspect("herba"), 3).add(Aspect.getAspect("instrumentum"), 4)
                        .add(Aspect.getAspect("arbor"), 5),
                1,
                4,
                3,
                getModItem("ForbiddenMagic", "WandCores", 1, 11, missing)).setPages(
                        new ResearchPage("derp.research_page.ROD_dreamwood_v2"),
                        new ResearchPage(
                                TCHelper.findInfusionRecipe(getModItem("ForbiddenMagic", "WandCores", 1, 12, missing))))
                        .setConcealed().setParents("ROD_livingwood", "ROD_silverwood").registerResearchItem();
        TCHelper.orphanResearch("ROD_dreamwood_staff");
        TCHelper.removeResearch("ROD_dreamwood_staff");
        new ResearchItem(
                "ROD_dreamwood_staff_v2",
                "FORBIDDEN",
                new AspectList().add(Aspect.getAspect("auram"), 5).add(Aspect.getAspect("praecantatio"), 10)
                        .add(Aspect.getAspect("herba"), 3).add(Aspect.getAspect("instrumentum"), 4)
                        .add(Aspect.getAspect("arbor"), 5),
                3,
                4,
                3,
                getModItem("ForbiddenMagic", "WandCores", 1, 13, missing)).registerResearchItem();
        TCHelper.removeArcaneRecipe(getModItem("ForbiddenMagic", "WandCores", 1, 13, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_dreamwood_staff_v2",
                getModItem("ForbiddenMagic", "WandCores", 1, 13, missing),
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
                getModItem("ForbiddenMagic", "WandCores", 1, 11, missing),
                'f',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'g',
                getModItem("ForbiddenMagic", "WandCores", 1, 11, missing),
                'h',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing));
        TCHelper.addResearchPage(
                "ROD_dreamwood_staff_v2",
                new ResearchPage("derp.research_page.ROD_dreamwood_staff_v2"));
        TCHelper.addResearchPrereq("ROD_dreamwood_staff_v2", "ROD_dreamwood_v2", false);
        TCHelper.addResearchPage(
                "ROD_dreamwood_staff_v2",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("ForbiddenMagic", "WandCores", 1, 13, missing))));
        ResearchCategories.getResearch("ROD_dreamwood_staff_v2").setSpecial();
        ResearchCategories.getResearch("ROD_dreamwood_staff_v2").setConcealed();
        TCHelper.addResearchPrereq("ROD_dreamwood_staff_v2", "ROD_silverwood_staff", false);
        ThaumcraftApi.addWarpToResearch("ROD_dreamwood_staff_v2", 3);
        new ResearchItem(
                "CAP_manasteel",
                "FORBIDDEN",
                new AspectList().add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("praecantatio"), 10)
                        .add(Aspect.getAspect("lucrum"), 3).add(Aspect.getAspect("instrumentum"), 4)
                        .add(Aspect.getAspect("auram"), 5),
                1,
                2,
                3,
                getModItem("ForbiddenMagic", "WandCaps", 1, 3, missing)).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CAP_manasteel",
                getModItem("ForbiddenMagic", "WandCaps", 1, 4, missing),
                6,
                new AspectList().add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("praecantatio"), 48)
                        .add(Aspect.getAspect("electrum"), 32).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("machina"), 24),
                getModItem("Thaumcraft", "WandCap", 1, 4, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 2333, missing),
                        getModItem("Botania", "manaResource", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2333, missing),
                        getModItem("Botania", "manaResource", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2333, missing),
                        getModItem("Botania", "manaResource", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2333, missing),
                        getModItem("Botania", "manaResource", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2333, missing),
                        getModItem("Botania", "manaResource", 1, 0, missing), });
        TCHelper.addResearchPage("CAP_manasteel", new ResearchPage("derp.research_page.CAP_manasteel"));
        TCHelper.addResearchPage(
                "CAP_manasteel",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("ForbiddenMagic", "WandCaps", 1, 4, missing))));
        ResearchCategories.getResearch("CAP_manasteel").setConcealed();
        TCHelper.addResearchPrereq("CAP_manasteel", "ROD_livingwood", false);
        TCHelper.addResearchPrereq("CAP_manasteel", "CAP_silver", false);
        TCHelper.addResearchPrereq("CAP_manasteel", "THAUMIUM", false);
        ThaumcraftApi.addWarpToResearch("CAP_manasteel", 2);
        new ResearchItem(
                "CAP_terrasteel",
                "FORBIDDEN",
                new AspectList().add(Aspect.getAspect("terra"), 5).add(Aspect.getAspect("praecantatio"), 10)
                        .add(Aspect.getAspect("superbia"), 3).add(Aspect.getAspect("instrumentum"), 4)
                        .add(Aspect.getAspect("strontio"), 2).add(Aspect.getAspect("vitreus"), 5),
                3,
                2,
                3,
                getModItem("ForbiddenMagic", "WandCaps", 1, 2, missing)).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CAP_terrasteel",
                getModItem("ForbiddenMagic", "WandCaps", 1, 2, missing),
                6,
                new AspectList().add(Aspect.getAspect("praecantatio"), 256).add(Aspect.getAspect("ordo"), 64)
                        .add(Aspect.getAspect("metallum"), 64).add(Aspect.getAspect("superbia"), 20)
                        .add(Aspect.getAspect("strontio"), 10),
                getModItem("ForbiddenMagic", "WandCaps", 1, 3, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.02", 1, 30501, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17339, missing),
                        getModItem("Botania", "manaResource", 1, 4, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30501, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("Botania", "manaResource", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17339, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing), });
        TCHelper.addResearchPage("CAP_terrasteel", new ResearchPage("derp.research_page.CAP_terrasteel"));
        TCHelper.addResearchPage(
                "CAP_terrasteel",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("ForbiddenMagic", "WandCaps", 1, 2, missing))));
        ResearchCategories.getResearch("CAP_terrasteel").setConcealed();
        TCHelper.addResearchPrereq("CAP_terrasteel", "CAP_manasteel", false);
        TCHelper.addResearchPrereq("CAP_terrasteel", "TRANSEMERALD", true);
        ThaumcraftApi.addWarpToResearch("CAP_terrasteel", 4);
        new ResearchItem(
                "CAP_elementium",
                "FORBIDDEN",
                new AspectList().add(Aspect.getAspect("auram"), 5).add(Aspect.getAspect("praecantatio"), 10)
                        .add(Aspect.getAspect("victus"), 3).add(Aspect.getAspect("instrumentum"), 4)
                        .add(Aspect.getAspect("humanus"), 5),
                3,
                4,
                3,
                getModItem("ForbiddenMagic", "WandCaps", 1, 5, missing)).registerResearchItem();
        TCHelper.removeArcaneRecipe(getModItem("ForbiddenMagic", "WandCaps", 1, 6, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_elementium",
                getModItem("ForbiddenMagic", "WandCaps", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("terra"), 40).add(Aspect.getAspect("aqua"), 40)
                        .add(Aspect.getAspect("aer"), 40),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTungstenSteel",
                'b',
                "ingotElvenElementium",
                'c',
                "screwTungstenSteel",
                'd',
                "ingotElvenElementium",
                'e',
                "elvenPixieDust",
                'f',
                "ingotElvenElementium",
                'g',
                "screwTungstenSteel",
                'h',
                "ingotElvenElementium",
                'i',
                "screwTungstenSteel");
        TCHelper.addResearchPage("CAP_elementium", new ResearchPage("derp.research_page.CAP_elementium"));
        TCHelper.addResearchPrereq("CAP_elementium", "CAP_manasteel", false);
        TCHelper.addResearchPage(
                "CAP_elementium",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("ForbiddenMagic", "WandCaps", 1, 6, missing))));
        TCHelper.addResearchPage(
                "CAP_elementium",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("ForbiddenMagic", "WandCaps", 1, 5, missing))));
        ResearchCategories.getResearch("CAP_elementium").setConcealed();
        new ResearchItem(
                "VINTEUM",
                "FORBIDDEN",
                new AspectList().add(Aspect.getAspect("metallum"), 5).add(Aspect.getAspect("permutatio"), 10)
                        .add(Aspect.getAspect("praecantatio"), 3).add(Aspect.getAspect("lucrum"), 2),
                -4,
                2,
                3,
                getModItem("gregtech", "gt.metaitem.01", 1, 8529, missing))
                        .setPages(
                                new ResearchPage("derp.research_page.VINTEUM"),
                                new ResearchPage(
                                        TCHelper.findCrucibleRecipe(
                                                getModItem("gregtech", "gt.metaitem.01", 1, 9529, missing))))
                        .setConcealed().setParents("JOURNEY", "THAUMIUM", "GT_ADVANCEDMETALLURGY")
                        .registerResearchItem();
        ThaumcraftApi.addWarpToResearch("VINTEUM", 1);
        new ResearchItem(
                "CAP_vinteum",
                "FORBIDDEN",
                new AspectList().add(Aspect.getAspect("permutatio"), 5).add(Aspect.getAspect("praecantatio"), 10)
                        .add(Aspect.getAspect("lucrum"), 3).add(Aspect.getAspect("instrumentum"), 4)
                        .add(Aspect.getAspect("metallum"), 5),
                -5,
                3,
                3,
                getModItem("ForbiddenMagic", "WandCaps", 1, 1, missing)).setPages(
                        new ResearchPage("derp.research_page.CAP_vinteum"),
                        new ResearchPage(
                                TCHelper.findArcaneRecipe(getModItem("ForbiddenMagic", "WandCaps", 1, 1, missing))))
                        .setConcealed().setParents("VINTEUM", "CAP_thaumium").registerResearchItem();
        ThaumcraftApi.addWarpToResearch("CAP_vinteum", 3);
        new ResearchItem(
                "ROD_witchwood",
                "FORBIDDEN",
                new AspectList().add(Aspect.getAspect("victus"), 5).add(Aspect.getAspect("praecantatio"), 10)
                        .add(Aspect.getAspect("herba"), 3).add(Aspect.getAspect("instrumentum"), 4)
                        .add(Aspect.getAspect("arbor"), 5),
                -4,
                0,
                3,
                getModItem("ForbiddenMagic", "WandCores", 1, 4, missing)).setPages(
                        new ResearchPage("derp.research_page.ROD_witchwood"),
                        new ResearchPage(
                                TCHelper.findInfusionRecipe(getModItem("ForbiddenMagic", "WandCores", 1, 4, missing))))
                        .setConcealed().setParents("VINTEUM", "ANOINTINGPASTE", "OVEN").registerResearchItem();
        ThaumcraftApi.addWarpToResearch("ROD_witchwood", 2);
        new ResearchItem(
                "ROD_witchwood_staff",
                "FORBIDDEN",
                new AspectList().add(Aspect.getAspect("victus"), 5).add(Aspect.getAspect("praecantatio"), 10)
                        .add(Aspect.getAspect("herba"), 3).add(Aspect.getAspect("instrumentum"), 4)
                        .add(Aspect.getAspect("arbor"), 5),
                -2,
                0,
                3,
                getModItem("ForbiddenMagic", "WandCores", 1, 10, missing)).setPages(
                        new ResearchPage("derp.research_page.ROD_witchwood_staff"),
                        new ResearchPage(
                                TCHelper.findArcaneRecipe(getModItem("ForbiddenMagic", "WandCores", 1, 10, missing))))
                        .setSpecial().setConcealed().setParents("ROD_witchwood", "ROD_silverwood_staff")
                        .registerResearchItem();
        ThaumcraftApi.addWarpToResearch("ROD_witchwood_staff", 4);
        TCHelper.refreshResearchPages("CAP_manasteel");
        TCHelper.refreshResearchPages("CAP_terrasteel");
        TCHelper.refreshResearchPages("CAP_elementium");
        TCHelper.refreshResearchPages("ROD_livingwood");
        TCHelper.refreshResearchPages("ROD_dreamwood_v2");
        TCHelper.refreshResearchPages("ROD_dreamwood_staff_v2");
        TCHelper.refreshResearchPages("VINTEUM");
        TCHelper.refreshResearchPages("CAP_vinteum");
        TCHelper.refreshResearchPages("ROD_witchwood");
        TCHelper.refreshResearchPages("ROD_witchwood_staff");

        // END OF WANDS

        TCHelper.removeCrucibleRecipe(getModItem("ForbiddenMagic", "FMResource", 4, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("ForbiddenMagic", "Crystalwell", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem("ForbiddenMagic", "UmbralBush", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("ForbiddenMagic", "RingNutrition", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("ForbiddenMagic", "Bloodwell", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "BlinkFocus", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "ArcaneCakeItem", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "DiabolistFork", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "SkullAxe", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "BloodRapier", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "WrathCage", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem("ForbiddenMagic", "MobCrystal", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "MorphPickaxe", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "MorphAxe", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "MorphShovel", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "MorphSword", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "TaintShovel", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "TaintPickaxe", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem("ForbiddenMagic", "TaintSapling", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("ForbiddenMagic", "TaintBlock", 9, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "EldritchOrb", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("ForbiddenMagic", "Primewell", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "SubCollar", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "WandCores", 1, 1, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "WandCores", 1, 6, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "WandCores", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("ForbiddenMagic", "WandCores", 1, 9, missing));
        TCHelper.removeInfusionRecipe(getModItem("ForbiddenMagic", "WandCaps", 1, 0, missing));
        TCHelper.clearPages("RIDINGCROP");
        TCHelper.addResearchPage("RIDINGCROP", new ResearchPage("forbidden.research_page.RIDINGCROP.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RIDINGCROP",
                getModItem("ForbiddenMagic", "RidingCrop", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 5).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("aer"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("Backpack", "boundLeather", 1, 0, missing),
                'd',
                "screwIron",
                'e',
                "stickWood",
                'f',
                "screwIron",
                'g',
                "craftingToolScrewdriver",
                'h',
                "stickWood",
                'i',
                "craftingToolSoftHammer");
        TCHelper.addResearchPage(
                "RIDINGCROP",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("ForbiddenMagic", "RidingCrop", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CRYSTALWELL",
                getModItem("ForbiddenMagic", "Crystalwell", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 5).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'b',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'c',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'd',
                "dyeBlack",
                'e',
                getModItem("Thaumcraft", "ItemInkwell", 1, 32767, missing),
                'f',
                "dyeBlack",
                'g',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'h',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'i',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing));
        TCHelper.setResearchAspects(
                "CRYSTALWELL",
                new AspectList().add(Aspect.getAspect("cognitio"), 18).add(Aspect.getAspect("vitreus"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("sensus"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("CRYSTALWELL", 3);
        ThaumcraftApi.addCrucibleRecipe(
                "BLACKFLOWER",
                getModItem("ForbiddenMagic", "UmbralBush", 1, 0, missing),
                getModItem("minecraft", "double_plant", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("victus"), 10));
        TCHelper.setResearchAspects(
                "BLACKFLOWER",
                new AspectList().add(Aspect.getAspect("herba"), 12).add(Aspect.getAspect("tenebrae"), 9)
                        .add(Aspect.getAspect("sensus"), 6).add(Aspect.getAspect("victus"), 3));
        TCHelper.setResearchComplexity("BLACKFLOWER", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RINGFOOD",
                getModItem("ForbiddenMagic", "RingNutrition", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 35).add(Aspect.getAspect("aer"), 35)
                        .add(Aspect.getAspect("ignis"), 35).add(Aspect.getAspect("terra"), 35)
                        .add(Aspect.getAspect("perditio"), 35),
                "abc",
                "def",
                "ghi",
                'a',
                "screwInfusedWater",
                'b',
                "blockNetherStar",
                'c',
                "screwInfusedAir",
                'd',
                getModItem("ForbiddenMagic", "GluttonyShard", 1, 0, missing),
                'e',
                getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 1, missing),
                'f',
                getModItem("ForbiddenMagic", "GluttonyShard", 1, 0, missing),
                'g',
                "screwInfusedEarth",
                'h',
                getModItem("ForbiddenMagic", "GluttonyShard", 1, 0, missing),
                'i',
                "screwInfusedFire");
        TCHelper.setResearchAspects(
                "RINGFOOD",
                new AspectList().add(Aspect.getAspect("fames"), 15).add(Aspect.getAspect("victus"), 12)
                        .add(Aspect.getAspect("gula"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("RINGFOOD", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BLOODWELL",
                getModItem("ForbiddenMagic", "Bloodwell", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 25).add(Aspect.getAspect("aer"), 25)
                        .add(Aspect.getAspect("ignis"), 25).add(Aspect.getAspect("terra"), 25)
                        .add(Aspect.getAspect("perditio"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "screwInfusedWater",
                'b',
                getModItem("AWWayofTime", "bucketLife", 1, 0, missing),
                'c',
                "screwInfusedAir",
                'd',
                getModItem("Thaumcraft", "ItemEssence", 1, 0, missing),
                'e',
                getModItem("Thaumcraft", "ItemInkwell", 1, 0, missing),
                'f',
                getModItem("Thaumcraft", "ItemEssence", 1, 0, missing),
                'g',
                "screwInfusedEarth",
                'h',
                getModItem("AWWayofTime", "weakBloodOrb", 1, 0, missing),
                'i',
                "screwInfusedFire");
        TCHelper.setResearchAspects(
                "BLOODWELL",
                new AspectList().add(Aspect.getAspect("victus"), 15).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("sensus"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("BLOODWELL", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FOCUSBLINK",
                getModItem("ForbiddenMagic", "BlinkFocus", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("desidia"), 16).add(Aspect.getAspect("infernus"), 16)
                        .add(Aspect.getAspect("iter"), 32).add(Aspect.getAspect("perditio"), 32)
                        .add(Aspect.getAspect("alienis"), 8).add(Aspect.getAspect("praecantatio"), 8),
                getModItem("Thaumcraft", "FocusPortableHole", 1, 0, missing),
                new ItemStack[] { getModItem("witchery", "ingredient", 1, 92, missing),
                        getModItem("ThaumicTinkerer", "kamiResource", 1, 7, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32724, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32724, missing),
                        getModItem("witchery", "ingredient", 1, 92, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32724, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32724, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 5, missing),
                        getModItem("ThaumicTinkerer", "kamiResource", 1, 7, missing), });
        TCHelper.setResearchAspects(
                "FOCUSBLINK",
                new AspectList().add(Aspect.getAspect("desidia"), 21).add(Aspect.getAspect("iter"), 18)
                        .add(Aspect.getAspect("perditio"), 15).add(Aspect.getAspect("infernus"), 12)
                        .add(Aspect.getAspect("alienis"), 9).add(Aspect.getAspect("tenebrae"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("FOCUSBLINK", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ARCANECAKE",
                getModItem("ForbiddenMagic", "ArcaneCakeItem", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("fabrico"), 32).add(Aspect.getAspect("fames"), 32)
                        .add(Aspect.getAspect("gula"), 16).add(Aspect.getAspect("aqua"), 64)
                        .add(Aspect.getAspect("limus"), 16).add(Aspect.getAspect("praecantatio"), 8),
                getModItem("minecraft", "cake", 1, 0, missing),
                new ItemStack[] { getModItem("ForbiddenMagic", "StarBlock", 1, 0, missing),
                        getModItem("minecraft", "milk_bucket", 1, 0, missing),
                        getModItem("ForbiddenMagic", "GluttonyShard", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("ForbiddenMagic", "GluttonyShard", 1, 0, missing),
                        getModItem("minecraft", "egg", 1, 0, missing),
                        getModItem("ForbiddenMagic", "StarBlock", 1, 0, missing),
                        getModItem("minecraft", "egg", 1, 0, missing),
                        getModItem("ForbiddenMagic", "GluttonyShard", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("ForbiddenMagic", "GluttonyShard", 1, 0, missing),
                        getModItem("minecraft", "milk_bucket", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ARCANECAKE",
                new AspectList().add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("gula"), 15)
                        .add(Aspect.getAspect("fames"), 12).add(Aspect.getAspect("fabrico"), 9)
                        .add(Aspect.getAspect("limus"), 6).add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("ARCANECAKE", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FORK",
                getModItem("ForbiddenMagic", "DiabolistFork", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("telum"), 32).add(Aspect.getAspect("infernus"), 24)
                        .add(Aspect.getAspect("potentia"), 16).add(Aspect.getAspect("machina"), 8),
                getModItem("Thaumcraft", "ItemSwordThaumium", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 23977, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27541, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23977, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27541, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23977, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27541, missing),
                        getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 1, missing), });
        TCHelper.setResearchAspects(
                "FORK",
                new AspectList().add(Aspect.getAspect("tenebrae"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("infernus"), 12).add(Aspect.getAspect("machina"), 9)
                        .add(Aspect.getAspect("instrumentum"), 6).add(Aspect.getAspect("telum"), 3));
        TCHelper.setResearchComplexity("FORK", 3);
        ThaumcraftApi.addWarpToResearch("FORK", 2);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SKULLAXE",
                getModItem("ForbiddenMagic", "SkullAxe", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("infernus"), 32).add(Aspect.getAspect("ira"), 24)
                        .add(Aspect.getAspect("telum"), 24).add(Aspect.getAspect("potentia"), 16)
                        .add(Aspect.getAspect("mortuus"), 8),
                getModItem("Thaumcraft", "ItemAxeElemental", 1, 0, missing),
                new ItemStack[] { getModItem("ForbiddenMagic", "NetherShard", 1, 0, missing),
                        getModItem("minecraft", "skull", 1, 0, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 0, missing),
                        getModItem("minecraft", "skull", 1, 1, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30502, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 0, missing),
                        getModItem("minecraft", "skull", 1, 2, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 0, missing),
                        getModItem("minecraft", "skull", 1, 4, missing), });
        TCHelper.setResearchAspects(
                "SKULLAXE",
                new AspectList().add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("instrumentum"), 15)
                        .add(Aspect.getAspect("mortuus"), 12).add(Aspect.getAspect("ira"), 9)
                        .add(Aspect.getAspect("telum"), 6).add(Aspect.getAspect("infernus"), 3));
        TCHelper.setResearchComplexity("SKULLAXE", 3);
        ThaumcraftApi.addWarpToResearch("SKULLAXE", 2);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "BLOODRAPIER",
                getModItem("ForbiddenMagic", "BloodRapier", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("victus"), 24)
                        .add(Aspect.getAspect("telum"), 16).add(Aspect.getAspect("fames"), 32)
                        .add(Aspect.getAspect("gula"), 8),
                getModItem("Thaumcraft", "ItemSwordVoid", 1, 0, missing),
                new ItemStack[] { getModItem("minecraft", "feather", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 11, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 12, missing),
                        getModItem("ForbiddenMagic", "GluttonyShard", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30514, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 11, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 12, missing),
                        getModItem("ForbiddenMagic", "GluttonyShard", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "BLOODRAPIER",
                new AspectList().add(Aspect.getAspect("tenebrae"), 18).add(Aspect.getAspect("gula"), 15)
                        .add(Aspect.getAspect("victus"), 12).add(Aspect.getAspect("fames"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("telum"), 3));
        TCHelper.setResearchComplexity("BLOODRAPIER", 3);
        ThaumcraftApi.addWarpToResearch("BLOODRAPIER", 2);
        ThaumcraftApi.addCrucibleRecipe(
                "TRANSEMERALD",
                getModItem("ForbiddenMagic", "FMResource", 4, 0, missing),
                getModItem("ForbiddenMagic", "FMResource", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("lucrum"), 4).add(Aspect.getAspect("vitreus"), 4));
        TCHelper.setResearchAspects(
                "TRANSEMERALD",
                new AspectList().add(Aspect.getAspect("permutatio"), 15).add(Aspect.getAspect("vitreus"), 12)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("TRANSEMERALD", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "WRATHCAGE",
                getModItem("ForbiddenMagic", "WrathCage", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("ira"), 32).add(Aspect.getAspect("machina"), 32)
                        .add(Aspect.getAspect("bestia"), 64).add(Aspect.getAspect("metallum"), 48)
                        .add(Aspect.getAspect("alienis"), 16).add(Aspect.getAspect("exanimis"), 16)
                        .add(Aspect.getAspect("praecantatio"), 32),
                getModItem("EnderIO", "itemBrokenSpawner", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.blockmetal7", 1, 4, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 0, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 0, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 0, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 0, missing),
                        getModItem("ForbiddenMagic", "MobCrystal", 1, 0, missing),
                        getModItem("ForbiddenMagic", "MobCrystal", 1, 0, missing),
                        getModItem("ForbiddenMagic", "MobCrystal", 1, 0, missing),
                        getModItem("ForbiddenMagic", "MobCrystal", 1, 0, missing),
                        getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                        getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                        getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                        getModItem("Thaumcraft", "blockJar", 1, 0, missing), });
        ThaumcraftApi.addCrucibleRecipe(
                "WRATHCAGE",
                getModItem("ForbiddenMagic", "MobCrystal", 1, 0, missing),
                getModItem("IC2", "itemBatCrystal", 1, 32767, missing),
                new AspectList().add(Aspect.getAspect("cognitio"), 10).add(Aspect.getAspect("potentia"), 10)
                        .add(Aspect.getAspect("praecantatio"), 10).add(Aspect.getAspect("vitreus"), 10));
        TCHelper.setResearchAspects(
                "WRATHCAGE",
                new AspectList().add(Aspect.getAspect("ira"), 21).add(Aspect.getAspect("machina"), 18)
                        .add(Aspect.getAspect("bestia"), 15).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("exanimis"), 3));
        TCHelper.setResearchComplexity("WRATHCAGE", 3);
        ThaumcraftApi.addWarpToResearch("WRATHCAGE", 5);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "MORPHTOOLS",
                getModItem("ForbiddenMagic", "MorphPickaxe", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("invidia"), 16).add(Aspect.getAspect("instrumentum"), 16)
                        .add(Aspect.getAspect("permutatio"), 32).add(Aspect.getAspect("cognitio"), 8)
                        .add(Aspect.getAspect("praecantatio"), 48).add(Aspect.getAspect("potentia"), 8),
                getModItem("Thaumcraft", "ItemPickaxeElemental", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "WandRod", 1, 2, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30500, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30502, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "MORPHTOOLS",
                getModItem("ForbiddenMagic", "MorphAxe", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("invidia"), 16).add(Aspect.getAspect("instrumentum"), 16)
                        .add(Aspect.getAspect("permutatio"), 32).add(Aspect.getAspect("cognitio"), 8)
                        .add(Aspect.getAspect("praecantatio"), 48).add(Aspect.getAspect("potentia"), 8),
                getModItem("Thaumcraft", "ItemAxeElemental", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "WandRod", 1, 2, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30500, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30502, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "MORPHTOOLS",
                getModItem("ForbiddenMagic", "MorphShovel", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("invidia"), 16).add(Aspect.getAspect("instrumentum"), 16)
                        .add(Aspect.getAspect("permutatio"), 32).add(Aspect.getAspect("cognitio"), 8)
                        .add(Aspect.getAspect("praecantatio"), 48).add(Aspect.getAspect("potentia"), 8),
                getModItem("Thaumcraft", "ItemShovelElemental", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "WandRod", 1, 2, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30500, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30502, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "MORPHTOOLS",
                getModItem("ForbiddenMagic", "MorphSword", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("invidia"), 16).add(Aspect.getAspect("telum"), 16)
                        .add(Aspect.getAspect("permutatio"), 32).add(Aspect.getAspect("cognitio"), 8)
                        .add(Aspect.getAspect("praecantatio"), 48).add(Aspect.getAspect("potentia"), 8),
                getModItem("Thaumcraft", "ItemSwordElemental", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "WandRod", 1, 2, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30500, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30502, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 1, missing), });
        TCHelper.setResearchAspects(
                "MORPHTOOLS",
                new AspectList().add(Aspect.getAspect("invidia"), 18).add(Aspect.getAspect("instrumentum"), 15)
                        .add(Aspect.getAspect("permutatio"), 12).add(Aspect.getAspect("cognitio"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("MORPHTOOLS", 3);
        ThaumcraftApi.addWarpToResearch("MORPHTOOLS", 5);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TAINTSHOVEL",
                getModItem("ForbiddenMagic", "TaintShovel", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("perfodio"), 16).add(Aspect.getAspect("sano"), 16)
                        .add(Aspect.getAspect("vitreus"), 32).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("limus"), 8).add(Aspect.getAspect("instrumentum"), 8),
                getModItem("Thaumcraft", "ItemShovelElemental", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "WandRod", 1, 2, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30514, missing),
                        getModItem("TConstruct", "strangeFood", 1, 0, missing),
                        getModItem("TConstruct", "strangeFood", 1, 0, missing),
                        getModItem("minecraft", "slime_ball", 1, 0, missing),
                        getModItem("minecraft", "slime_ball", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30503, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 4, missing), });
        TCHelper.setResearchAspects(
                "TAINTSHOVEL",
                new AspectList().add(Aspect.getAspect("vitreus"), 21).add(Aspect.getAspect("vitium"), 18)
                        .add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("limus"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("venenum"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("TAINTSHOVEL", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TAINTPICK",
                getModItem("ForbiddenMagic", "TaintPickaxe", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("perfodio"), 16).add(Aspect.getAspect("instrumentum"), 8)
                        .add(Aspect.getAspect("vitium"), 16).add(Aspect.getAspect("perditio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("mortuus"), 8),
                getModItem("Thaumcraft", "ItemPickaxeElemental", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "WandRod", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30514, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 2, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 2, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30509, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 5, missing), });
        TCHelper.setResearchAspects(
                "TAINTPICK",
                new AspectList().add(Aspect.getAspect("vitium"), 18).add(Aspect.getAspect("perditio"), 15)
                        .add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("mortuus"), 6).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("TAINTPICK", 3);
        ThaumcraftApi.addCrucibleRecipe(
                "TAINTTREE",
                getModItem("ForbiddenMagic", "TaintSapling", 1, 0, missing),
                "treeSapling",
                new AspectList().add(Aspect.getAspect("venenum"), 8).add(Aspect.getAspect("vitium"), 20));
        TCHelper.setResearchAspects(
                "TAINTTREE",
                new AspectList().add(Aspect.getAspect("vitium"), 18).add(Aspect.getAspect("arbor"), 15)
                        .add(Aspect.getAspect("herba"), 12).add(Aspect.getAspect("venenum"), 9)
                        .add(Aspect.getAspect("mortuus"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("TAINTTREE", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TAINTSTONE",
                getModItem("ForbiddenMagic", "TaintBlock", 9, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("perditio"), 9),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("minecraft", "stone", 1, 0, missing),
                'b',
                getModItem("minecraft", "stone", 1, 0, missing),
                'c',
                getModItem("minecraft", "stone", 1, 0, missing),
                'd',
                getModItem("minecraft", "stone", 1, 0, missing),
                'e',
                getModItem("ForbiddenMagic", "NetherShard", 1, 2, missing),
                'f',
                getModItem("minecraft", "stone", 1, 0, missing),
                'g',
                getModItem("minecraft", "stone", 1, 0, missing),
                'h',
                getModItem("minecraft", "stone", 1, 0, missing),
                'i',
                getModItem("minecraft", "stone", 1, 0, missing));
        TCHelper.setResearchAspects(
                "TAINTSTONE",
                new AspectList().add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("vitium"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("ordo"), 3));
        TCHelper.setResearchComplexity("TAINTSTONE", 2);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ELDRITCHORB",
                getModItem("ForbiddenMagic", "EldritchOrb", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("alienis"), 48).add(Aspect.getAspect("tenebrae"), 32)
                        .add(Aspect.getAspect("vacuos"), 64).add(Aspect.getAspect("victus"), 64)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("vitreus"), 8),
                getModItem("BloodArsenal", "transparent_orb", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemEldritchObject", 1, 3, missing),
                        getModItem("Thaumcraft", "ItemEldritchObject", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32724, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32726, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32724, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "ItemEldritchObject", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ELDRITCHORB",
                new AspectList().add(Aspect.getAspect("vacuos"), 18).add(Aspect.getAspect("victus"), 15)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("vitreus"), 9)
                        .add(Aspect.getAspect("tenebrae"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("ELDRITCHORB", 3);
        ThaumcraftApi.addWarpToResearch("ELDRITCHORB", 6);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "PRIMEWELL",
                getModItem("ForbiddenMagic", "Primewell", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 100).add(Aspect.getAspect("ignis"), 100)
                        .add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("terra"), 100)
                        .add(Aspect.getAspect("ordo"), 100).add(Aspect.getAspect("perditio"), 100),
                "abc",
                "def",
                "ghi",
                'a',
                "screwInfusedAir",
                'b',
                getModItem("Thaumcraft", "ItemEldritchObject", 1, 3, missing),
                'c',
                "screwInfusedEarth",
                'd',
                "screwInfusedFire",
                'e',
                getModItem("Thaumcraft", "ItemInkwell", 1, 0, missing),
                'f',
                "screwInfusedOrder",
                'g',
                "screwInfusedWater",
                'h',
                "craftingToolScrewdriver",
                'i',
                "screwInfusedEntropy");
        TCHelper.setResearchAspects(
                "PRIMEWELL",
                new AspectList().add(Aspect.getAspect("alienis"), 18).add(Aspect.getAspect("cognitio"), 15)
                        .add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("vitreus"), 9)
                        .add(Aspect.getAspect("volatus"), 6).add(Aspect.getAspect("ordo"), 3));
        TCHelper.setResearchComplexity("PRIMEWELL", 3);
        ThaumcraftApi.addWarpToResearch("PRIMEWELL", 1);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SUBCOLLAR",
                getModItem("ForbiddenMagic", "SubCollar", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("vinculum"), 8).add(Aspect.getAspect("infernus"), 8)
                        .add(Aspect.getAspect("auram"), 16).add(Aspect.getAspect("corpus"), 16)
                        .add(Aspect.getAspect("luxuria"), 8).add(Aspect.getAspect("praecantatio"), 32),
                getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 2, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemAmuletVis", 1, 1, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 4, missing),
                        getModItem("minecraft", "lead", 1, 0, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 4, missing),
                        getModItem("minecraft", "lead", 1, 0, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 4, missing),
                        getModItem("minecraft", "lead", 1, 0, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 4, missing),
                        getModItem("minecraft", "lead", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "SUBCOLLAR",
                new AspectList().add(Aspect.getAspect("vinculum"), 18).add(Aspect.getAspect("auram"), 15)
                        .add(Aspect.getAspect("corpus"), 12).add(Aspect.getAspect("luxuria"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("SUBCOLLAR", 3);
        TCHelper.setResearchAspects(
                "HELLFIRE",
                new AspectList().add(Aspect.getAspect("infernus"), 18).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("iter"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("lux"), 3));
        TCHelper.setResearchComplexity("HELLFIRE", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_infernal",
                getModItem("ForbiddenMagic", "WandCores", 1, 1, missing),
                7,
                new AspectList().add(Aspect.getAspect("superbia"), 16).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("infernus"), 32).add(Aspect.getAspect("ignis"), 48)
                        .add(Aspect.getAspect("instrumentum"), 8),
                getModItem("Thaumcraft", "WandRod", 1, 6, missing),
                new ItemStack[] { getModItem("ForbiddenMagic", "NetherShard", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17379, missing),
                        getModItem("minecraft", "skull", 1, 1, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 3, missing),
                        getModItem("minecraft", "blaze_rod", 1, 0, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 3, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 3, missing),
                        getModItem("minecraft", "ghast_tear", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17379, missing), });
        TCHelper.setResearchAspects(
                "ROD_infernal",
                new AspectList().add(Aspect.getAspect("infernus"), 15).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("aqua"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("instrumentum"), 3));
        TCHelper.setResearchComplexity("ROD_infernal", 3);
        ThaumcraftApi.addWarpToResearch("ROD_infernal", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_blood",
                getModItem("ForbiddenMagic", "WandCores", 1, 6, missing),
                9,
                new AspectList().add(Aspect.getAspect("aqua"), 16).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("victus"), 24).add(Aspect.getAspect("exanimis"), 8)
                        .add(Aspect.getAspect("alienis"), 8),
                getModItem("AWWayofTime", "masterBloodOrb", 1, 0, missing),
                new ItemStack[] { getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "sanctus", 1, 0, missing),
                        getModItem("AWWayofTime", "magicales", 1, 0, missing),
                        getModItem("AWWayofTime", "incendium", 1, 0, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 0, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "terrae", 1, 0, missing),
                        getModItem("AWWayofTime", "tennebrae", 1, 0, missing),
                        getModItem("AWWayofTime", "aquasalus", 1, 0, missing),
                        getModItem("AWWayofTime", "crystallos", 1, 0, missing),
                        getModItem("AWWayofTime", "crepitous", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "ROD_blood",
                new AspectList().add(Aspect.getAspect("victus"), 15).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("telum"), 3));
        TCHelper.setResearchComplexity("ROD_blood", 3);
        ThaumcraftApi.addWarpToResearch("ROD_blood", 3);
        TCHelper.setResearchAspects(
                "CONSUMING",
                new AspectList().add(Aspect.getAspect("vacuos"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("perditio"), 12).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("gula"), 6));
        TCHelper.setResearchComplexity("CONSUMING", 3);
        TCHelper.setResearchAspects(
                "EDUCATIONAL",
                new AspectList().add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("telum"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("ignis"), 3));
        TCHelper.setResearchComplexity("EDUCATIONAL", 3);
        TCHelper.setResearchAspects(
                "GREEDY",
                new AspectList().add(Aspect.getAspect("lucrum"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("telum"), 12).add(Aspect.getAspect("infernus"), 9)
                        .add(Aspect.getAspect("luxuria"), 6).add(Aspect.getAspect("ignis"), 3));
        TCHelper.setResearchComplexity("GREEDY", 3);
        TCHelper.setResearchAspects(
                "CORRUPTING",
                new AspectList().add(Aspect.getAspect("infernus"), 18).add(Aspect.getAspect("vitreus"), 15)
                        .add(Aspect.getAspect("permutatio"), 12).add(Aspect.getAspect("spiritus"), 9)
                        .add(Aspect.getAspect("nebrisum"), 6).add(Aspect.getAspect("ignis"), 3));
        TCHelper.setResearchComplexity("CORRUPTING", 3);
        ThaumcraftApi.addWarpToResearch("CORRUPTING", 2);
        TCHelper.setResearchAspects(
                "WRATH",
                new AspectList().add(Aspect.getAspect("ira"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("telum"), 12).add(Aspect.getAspect("superbia"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("ignis"), 3));
        TCHelper.setResearchComplexity("WRATH", 3);
        ThaumcraftApi.addWarpToResearch("WRATH", 3);
        TCHelper.setResearchAspects(
                "VOIDTOUCHED",
                new AspectList().add(Aspect.getAspect("invidia"), 18).add(Aspect.getAspect("alienis"), 15)
                        .add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("fabrico"), 9)
                        .add(Aspect.getAspect("tenebrae"), 6).add(Aspect.getAspect("ignis"), 3));
        TCHelper.setResearchComplexity("VOIDTOUCHED", 3);
        ThaumcraftApi.addWarpToResearch("VOIDTOUCHED", 2);
        TCHelper.setResearchAspects(
                "IMPACT",
                new AspectList().add(Aspect.getAspect("perfodio"), 18).add(Aspect.getAspect("instrumentum"), 15)
                        .add(Aspect.getAspect("invidia"), 12).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("ignis"), 3));
        TCHelper.setResearchComplexity("IMPACT", 3);
        TCHelper.setResearchAspects(
                "CLUSTER",
                new AspectList().add(Aspect.getAspect("invidia"), 18).add(Aspect.getAspect("metallum"), 15)
                        .add(Aspect.getAspect("infernus"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("ignis"), 3));
        TCHelper.setResearchComplexity("CLUSTER", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_tainted",
                getModItem("ForbiddenMagic", "WandCores", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("vitium"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("perditio"), 48).add(Aspect.getAspect("venenum"), 24)
                        .add(Aspect.getAspect("alienis"), 8).add(Aspect.getAspect("tenebrae"), 32),
                getModItem("Thaumcraft", "WandRod", 1, 1, missing),
                new ItemStack[] { getModItem("ForbiddenMagic", "NetherShard", 1, 2, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 11, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 2, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 12, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 2, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 11, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 2, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 12, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 2, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 11, missing),
                        getModItem("ForbiddenMagic", "NetherShard", 1, 2, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 12, missing), });
        TCHelper.setResearchAspects(
                "ROD_tainted",
                new AspectList().add(Aspect.getAspect("vitium"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("venenum"), 6).add(Aspect.getAspect("tenebrae"), 3));
        TCHelper.setResearchComplexity("ROD_tainted", 3);
        ThaumcraftApi.addWarpToResearch("ROD_tainted", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_blood_staff",
                getModItem("ForbiddenMagic", "WandCores", 1, 9, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 40).add(Aspect.getAspect("ignis"), 40)
                        .add(Aspect.getAspect("aer"), 40).add(Aspect.getAspect("terra"), 40)
                        .add(Aspect.getAspect("perditio"), 40).add(Aspect.getAspect("ordo"), 40),
                "abc",
                "def",
                "ghi",
                'a',
                "screwInfusedOrder",
                'b',
                getModItem("ThaumicTinkerer", "kamiResource", 1, 6, missing),
                'c',
                getModItem("AWWayofTime", "demonBloodShard", 1, 0, missing),
                'd',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 29, missing),
                'e',
                getModItem("ForbiddenMagic", "WandCores", 1, 3, missing),
                'f',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 28, missing),
                'g',
                getModItem("ForbiddenMagic", "WandCores", 1, 3, missing),
                'h',
                getModItem("ThaumicTinkerer", "kamiResource", 1, 7, missing),
                'i',
                "screwInfusedEntropy");
        TCHelper.setResearchAspects(
                "ROD_blood_staff",
                new AspectList().add(Aspect.getAspect("victus"), 18).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("telum"), 12).add(Aspect.getAspect("terra"), 9)
                        .add(Aspect.getAspect("tenebrae"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("ROD_blood_staff", 3);
        ThaumcraftApi.addWarpToResearch("ROD_blood_staff", 4);
        TCHelper.clearPages("CAP_alchemical");
        TCHelper.addResearchPage("CAP_alchemical", new ResearchPage("forbidden.research_page.CAP_alchemical.1"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CAP_alchemical",
                getModItem("ForbiddenMagic", "WandCaps", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("victus"), 16).add(Aspect.getAspect("aqua"), 32)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("permutatio"), 8)
                        .add(Aspect.getAspect("metallum"), 8),
                getModItem("Thaumcraft", "WandCap", 1, 1, missing),
                new ItemStack[] { getModItem("AWWayofTime", "magicales", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2330, missing),
                        getModItem("AWWayofTime", "magicales", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2330, missing),
                        getModItem("AWWayofTime", "magicales", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2330, missing),
                        getModItem("AWWayofTime", "magicales", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2330, missing),
                        getModItem("AWWayofTime", "magicales", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2330, missing), });
        TCHelper.addResearchPage(
                "CAP_alchemical",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("ForbiddenMagic", "WandCaps", 1, 0, missing))));
        TCHelper.setResearchAspects(
                "CAP_alchemical",
                new AspectList().add(Aspect.getAspect("victus"), 15).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("CAP_alchemical", 3);
        ThaumcraftApi.addWarpToResearch("CAP_alchemical", 2);
        TCHelper.refreshResearchPages("RIDINGCROP");
        TCHelper.refreshResearchPages("CRYSTALWELL");
        TCHelper.refreshResearchPages("BLACKFLOWER");
        TCHelper.refreshResearchPages("RINGFOOD");
        TCHelper.refreshResearchPages("BLOODWELL");
        TCHelper.refreshResearchPages("FOCUSBLINK");
        TCHelper.refreshResearchPages("ARCANECAKE");
        TCHelper.refreshResearchPages("TRANSEMERALD");
        TCHelper.refreshResearchPages("FORK");
        TCHelper.refreshResearchPages("SKULLAXE");
        TCHelper.refreshResearchPages("BLOODRAPIER");
        TCHelper.refreshResearchPages("WRATHCAGE");
        TCHelper.refreshResearchPages("MORPHTOOLS");
        TCHelper.refreshResearchPages("TAINTSHOVEL");
        TCHelper.refreshResearchPages("TAINTPICK");
        TCHelper.refreshResearchPages("TAINTTREE");
        TCHelper.refreshResearchPages("TAINTSTONE");
        TCHelper.refreshResearchPages("ELDRITCHORB");
        TCHelper.refreshResearchPages("PRIMEWELL");
        TCHelper.refreshResearchPages("SUBCOLLAR");
        TCHelper.refreshResearchPages("ROD_infernal");
        TCHelper.refreshResearchPages("ROD_blood");
        TCHelper.refreshResearchPages("ROD_tainted");
        TCHelper.refreshResearchPages("ROD_blood_staff");
        TCHelper.refreshResearchPages("CAP_alchemical");
    }
}
