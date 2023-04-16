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

public class ScriptBloodMagic implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Blood Magic";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.BloodMagic.ID, Mods.BloodArsenal.ID, Mods.Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack missing = new ItemStack(Blocks.dirt);

        TCHelper.removeInfusionRecipe(getModItem("BloodArsenal", "wand_caps", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("BloodArsenal", "wand_cores", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("BloodArsenal", "wand_cores", 1, 1, missing));
        ResearchCategories.registerCategory(
                "BLOODMAGIC",
                new ResourceLocation("dreamcraft:textures/thaumcraft/icon/icon_BloodMagic.png"),
                new ResourceLocation("dreamcraft:textures/thaumcraft/tab/tab_BloodMagic.png"));
        new ResearchItem(
                "BLOODALTAR",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("fames"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                0,
                0,
                3,
                getModItem("AWWayofTime", "Altar", 1, 0, missing))
                        .setPages(
                                new ResearchPage("tc.research_page.BLOODALTAR.1"),
                                new ResearchPage("tc.research_page.BLOODALTAR.2"),
                                new ResearchPage("tc.research_page.BLOODALTAR.3"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BLOODALTAR",
                getModItem("AWWayofTime", "Altar", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("aqua"), 20)
                        .add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'b',
                getModItem("witchery", "ingredient", 1, 10, missing),
                'c',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'd',
                getModItem("ExtraUtilities", "cobblestone_compressed", 1, 1, missing),
                'e',
                getModItem("Thaumcraft", "blockMetalDevice", 1, 0, missing),
                'f',
                getModItem("ExtraUtilities", "cobblestone_compressed", 1, 1, missing),
                'g',
                getModItem("EnderIO", "itemMaterial", 1, 5, missing),
                'h',
                getModItem("Thaumcraft", "blockStoneDevice", 1, 0, missing),
                'i',
                getModItem("EnderIO", "itemMaterial", 1, 5, missing));
        TCHelper.addResearchPage(
                "BLOODALTAR",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "Altar", 1, 0, missing))));
        TCHelper.addResearchPage("BLOODALTAR", new ResearchPage("tc.research_page.BLOODALTAR.4"));
        ThaumcraftApi.addWarpToResearch("BLOODALTAR", 2);
        new ResearchItem(
                "LIFEINFUSER",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("victus"), 18).add(Aspect.getAspect("alienis"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("fames"), 6).add(Aspect.getAspect("terra"), 3),
                -2,
                2,
                3,
                getModItem("BloodArsenal", "life_infuser", 1, 0, missing))
                        .setParents("BLOODALTAR", "INFUSION")
                        .setPages(
                                new ResearchPage("tc.research_page.LIFEINFUSER.1"),
                                new ResearchPage("tc.research_page.LIFEINFUSER.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "LIFEINFUSER",
                getModItem("BloodArsenal", "life_infuser", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("victus"), 32).add(Aspect.getAspect("alienis"), 32)
                        .add(Aspect.getAspect("praecantatio"), 24).add(Aspect.getAspect("auram"), 16)
                        .add(Aspect.getAspect("fames"), 8).add(Aspect.getAspect("terra"), 8),
                getModItem("AWWayofTime", "Altar", 1, 0, missing),
                new ItemStack[] { getModItem("minecraft", "nether_star", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 22977, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 22977, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                        getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 22977, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 22977, missing), });
        TCHelper.addResearchPage(
                "LIFEINFUSER",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("BloodArsenal", "life_infuser", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("LIFEINFUSER", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "LIFEINFUSER",
                getModItem("BloodArsenal", "lp_materializer", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("aqua"), 50).add(Aspect.getAspect("ordo"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'b',
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                'c',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'd',
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                'e',
                getModItem("minecraft", "nether_star", 1, 0, missing),
                'f',
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                'g',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'h',
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                'i',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing));
        TCHelper.addResearchPage(
                "LIFEINFUSER",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("BloodArsenal", "lp_materializer", 1, 0, missing))));
        new ResearchItem(
                "SOULCOMPACTER",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("spiritus"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("vacuos"), 6).add(Aspect.getAspect("cognitio"), 3),
                0,
                -6,
                3,
                getModItem("BloodArsenal", "compacter", 1, 0, missing)).setParents("MASTERRITUALSTONE")
                        .setPages(new ResearchPage("tc.research_page.SOULCOMPACTER")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SOULCOMPACTER",
                getModItem("BloodArsenal", "compacter", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 75).add(Aspect.getAspect("ignis"), 75)
                        .add(Aspect.getAspect("terra"), 75).add(Aspect.getAspect("aqua"), 75)
                        .add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                'b',
                getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                'c',
                getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                'd',
                getModItem("BloodArsenal", "blood_infused_diamond_bound", 1, 0, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32644, missing),
                'f',
                getModItem("BloodArsenal", "blood_infused_diamond_bound", 1, 0, missing),
                'g',
                getModItem("BloodArsenal", "blood_infused_iron_block", 1, 0, missing),
                'h',
                getModItem("AWWayofTime", "masterStone", 1, 0, missing),
                'i',
                getModItem("BloodArsenal", "blood_infused_iron_block", 1, 0, missing));
        TCHelper.addResearchPage(
                "SOULCOMPACTER",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("BloodArsenal", "compacter", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SOULCOMPACTER", 3);
        new ResearchItem(
                "SACRIFICIALKNIFE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("telum"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("fames"), 6)
                        .add(Aspect.getAspect("fabrico"), 3),
                2,
                -2,
                3,
                getModItem("AWWayofTime", "sacrificialKnife", 1, 0, missing))
                        .setParents("BLOODALTAR")
                        .setPages(
                                new ResearchPage("tc.research_page.SACRIFICIALKNIFE.1"),
                                new ResearchPage("tc.research_page.SACRIFICIALKNIFE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SACRIFICIALKNIFE",
                getModItem("AWWayofTime", "sacrificialKnife", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "screwSteel",
                'b',
                getModItem("TConstruct", "strangeFood", 1, 1, missing),
                'c',
                "craftingToolScrewdriver",
                'd',
                "plateAluminium",
                'e',
                getModItem("battlegear2", "dagger.diamond", 1, 0, missing),
                'f',
                getModItem("TConstruct", "strangeFood", 1, 1, missing),
                'g',
                "stickSteel",
                'h',
                "plateAluminium",
                'i',
                "screwSteel");
        TCHelper.addResearchPage(
                "SACRIFICIALKNIFE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "sacrificialKnife", 1, 0, missing))));
        new ResearchItem(
                "ALCHEMICCHEMSTRYSET",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("fabrico"), 15).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("victus"), 3),
                4,
                -4,
                3,
                getModItem("AWWayofTime", "blockWritingTable", 1, 0, missing))
                        .setParents("INFUSION", "SACRIFICIALKNIFE").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.ALCHEMICCHEMSTRYSET.1"),
                                new ResearchPage("tc.research_page.ALCHEMICCHEMSTRYSET.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ALCHEMICCHEMSTRYSET",
                getModItem("AWWayofTime", "blockWritingTable", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("fabrico"), 24).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("victus"), 12)
                        .add(Aspect.getAspect("ignis"), 12),
                getModItem("minecraft", "brewing_stand", 1, 0, missing),
                new ItemStack[] {
                        createItemStack(
                                "IC2",
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"lifeessence\",Amount:1000}}",
                                missing),
                        getModItem("AWWayofTime", "blankSlate", 1, 0, missing),
                        createItemStack(
                                "IC2",
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"lifeessence\",Amount:1000}}",
                                missing),
                        getModItem("AWWayofTime", "blankSlate", 1, 0, missing),
                        createItemStack(
                                "IC2",
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"lifeessence\",Amount:1000}}",
                                missing),
                        getModItem("AWWayofTime", "blankSlate", 1, 0, missing),
                        createItemStack(
                                "IC2",
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"lifeessence\",Amount:1000}}",
                                missing),
                        getModItem("AWWayofTime", "blankSlate", 1, 0, missing),
                        createItemStack(
                                "IC2",
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"lifeessence\",Amount:1000}}",
                                missing),
                        getModItem("AWWayofTime", "blankSlate", 1, 0, missing),
                        createItemStack(
                                "IC2",
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"lifeessence\",Amount:1000}}",
                                missing),
                        getModItem("AWWayofTime", "blankSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "ALCHEMICCHEMSTRYSET",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "blockWritingTable", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ALCHEMICCHEMSTRYSET", 3);
        new ResearchItem(
                "AMORPHICCATALYST",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aqua"), 18).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("aer"), 9)
                        .add(Aspect.getAspect("ordo"), 6).add(Aspect.getAspect("perditio"), 3),
                6,
                -4,
                3,
                getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing))
                        .setParents("INFUSION", "ALCHEMICCHEMSTRYSET").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.AMORPHICCATALYST")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "AMORPHICCATALYST",
                getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("aqua"), 16).add(Aspect.getAspect("ignis"), 16)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("aer"), 16)
                        .add(Aspect.getAspect("ordo"), 16).add(Aspect.getAspect("perditio"), 16),
                getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                new ItemStack[] { getModItem("AWWayofTime", "simpleCatalyst", 1, 0, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("AWWayofTime", "terrae", 1, 0, missing),
                        getModItem("AWWayofTime", "crystallos", 1, 0, missing),
                        getModItem("AWWayofTime", "sanctus", 1, 0, missing),
                        getModItem("AWWayofTime", "magicales", 1, 0, missing),
                        getModItem("AWWayofTime", "crepitous", 1, 0, missing),
                        getModItem("AWWayofTime", "incendium", 1, 0, missing),
                        getModItem("AWWayofTime", "aquasalus", 1, 0, missing),
                        getModItem("AWWayofTime", "tennebrae", 1, 0, missing), });
        TCHelper.addResearchPage(
                "AMORPHICCATALYST",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("AMORPHICCATALYST", 2);
        new ResearchItem(
                "BIDIAMONDBLOCK",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aqua"), 18).add(Aspect.getAspect("ignis"), 24)
                        .add(Aspect.getAspect("victus"), 12).add(Aspect.getAspect("ira"), 6)
                        .add(Aspect.getAspect("perditio"), 3),
                8,
                -4,
                3,
                getModItem("BloodArsenal", "blood_infused_diamond_block", 1, 0, missing))
                        .setParents("INFUSION", "AMORPHICCATALYST").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.BIDIAMONDBLOCK")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "BIDIAMONDBLOCK",
                getModItem("BloodArsenal", "blood_infused_diamond_block", 1, 0, missing),
                7,
                new AspectList().add(Aspect.getAspect("ira"), 32).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("victus"), 24).add(Aspect.getAspect("ignis"), 48)
                        .add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("perditio"), 16),
                getModItem("minecraft", "diamond_block", 1, 0, missing),
                new ItemStack[] { getModItem("BloodArsenal", "blood_infused_diamond_bound", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_diamond_bound", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_diamond_bound", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_diamond_bound", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_diamond_bound", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_diamond_bound", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_diamond_bound", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_diamond_bound", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_diamond_bound", 1, 0, missing), });
        TCHelper.addResearchPage(
                "BIDIAMONDBLOCK",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem("BloodArsenal", "blood_infused_diamond_block", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("BIDIAMONDBLOCK", 3);
        new ResearchItem(
                "DIVINATIONSIGIL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("metallum"), 3),
                0,
                2,
                3,
                getModItem("AWWayofTime", "divinationSigil", 1, 0, missing))
                        .setParents("INFUSION", "NITOR", "BLOODALTAR").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.DIVINATIONSIGIL.1"),
                                new ResearchPage("tc.research_page.DIVINATIONSIGIL.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "DIVINATIONSIGIL",
                getModItem("AWWayofTime", "divinationSigil", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("vitreus"), 24).add(Aspect.getAspect("terra"), 18)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("instrumentum"), 6)
                        .add(Aspect.getAspect("metallum"), 4),
                getModItem("AWWayofTime", "blankSlate", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), });
        TCHelper.addResearchPage(
                "DIVINATIONSIGIL",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "divinationSigil", 1, 0, missing))));
        new ResearchItem(
                "SPEEDRUNE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("motus"), 15).add(Aspect.getAspect("volatus"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("fames"), 3),
                -2,
                0,
                3,
                getModItem("AWWayofTime", "speedRune", 1, 0, missing)).setParents("INFUSION", "BLOODALTAR")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.SPEEDRUNE.1"),
                                new ResearchPage("tc.research_page.SPEEDRUNE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SPEEDRUNE",
                getModItem("AWWayofTime", "speedRune", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("motus"), 24).add(Aspect.getAspect("volatus"), 24)
                        .add(Aspect.getAspect("potentia"), 18).add(Aspect.getAspect("aer"), 12)
                        .add(Aspect.getAspect("fames"), 4),
                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 0, missing),
                new ItemStack[] { getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SPEEDRUNE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "speedRune", 1, 0, missing))));
        new ResearchItem(
                "IMPERFECTRITUALSTONE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("tenebrae"), 3),
                -2,
                -2,
                3,
                getModItem("AWWayofTime", "imperfectRitualStone", 1, 0, missing))
                        .setParents("BLOODALTAR")
                        .setPages(
                                new ResearchPage("tc.research_page.IMPERFECTRITUALSTONE.1"),
                                new ResearchPage("tc.research_page.IMPERFECTRITUALSTONE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMPERFECTRITUALSTONE",
                getModItem("AWWayofTime", "imperfectRitualStone", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 1).add(Aspect.getAspect("ignis"), 6)
                        .add(Aspect.getAspect("terra"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("minecraft", "obsidian", 1, 0, missing),
                'b',
                getModItem("AWWayofTime", "blankSlate", 1, 0, missing),
                'c',
                getModItem("minecraft", "obsidian", 1, 0, missing),
                'd',
                getModItem("AWWayofTime", "blankSlate", 1, 0, missing),
                'e',
                getModItem("BloodArsenal", "blood_stone", 1, 0, missing),
                'f',
                getModItem("AWWayofTime", "blankSlate", 1, 0, missing),
                'g',
                getModItem("minecraft", "obsidian", 1, 0, missing),
                'h',
                getModItem("AWWayofTime", "blankSlate", 1, 0, missing),
                'i',
                getModItem("minecraft", "obsidian", 1, 0, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMPERFECTRITUALSTONE",
                getModItem("AWWayofTime", "imperfectRitualStone", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 2).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("terra"), 16),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("minecraft", "obsidian", 1, 0, missing),
                'd',
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                'e',
                getModItem("Railcraft", "brick.bloodstained", 1, 2, missing),
                'f',
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                'h',
                getModItem("minecraft", "obsidian", 1, 0, missing));
        TCHelper.addResearchPage(
                "IMPERFECTRITUALSTONE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "imperfectRitualStone", 1, 0, missing))));
        new ResearchItem(
                "RITUALSTONE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("aer"), 3),
                -2,
                -4,
                3,
                getModItem("AWWayofTime", "ritualStone", 1, 0, missing)).setParents("INFUSION", "IMPERFECTRITUALSTONE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.RITUALSTONE"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RITUALSTONE",
                getModItem("AWWayofTime", "ritualStone", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("ignis"), 9)
                        .add(Aspect.getAspect("tenebrae"), 6).add(Aspect.getAspect("praecantatio"), 3)
                        .add(Aspect.getAspect("aer"), 2),
                getModItem("AWWayofTime", "imperfectRitualStone", 1, 0, missing),
                new ItemStack[] { getModItem("AWWayofTime", "terrae", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing),
                        getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "terrae", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing),
                        getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing), });
        ThaumcraftApi.addArcaneCraftingRecipe(
                "RITUALSTONE",
                getModItem("AWWayofTime", "ritualStone", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 3).add(Aspect.getAspect("ignis"), 18)
                        .add(Aspect.getAspect("terra"), 24),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("minecraft", "obsidian", 1, 0, missing),
                'b',
                getModItem("AWWayofTime", "terrae", 1, 0, missing),
                'c',
                getModItem("minecraft", "obsidian", 1, 0, missing),
                'd',
                getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                'e',
                getModItem("AWWayofTime", "imperfectRitualStone", 1, 0, missing),
                'f',
                getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                'g',
                getModItem("minecraft", "obsidian", 1, 0, missing),
                'h',
                getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                'i',
                getModItem("minecraft", "obsidian", 1, 0, missing));
        TCHelper.addResearchPage(
                "RITUALSTONE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "ritualStone", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("RITUALSTONE", 1);
        new ResearchItem(
                "SPELLTABLE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("terra"), 18).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("tenebrae"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("infernus"), 3),
                -4,
                -4,
                3,
                getModItem("AWWayofTime", "blockHomHeart", 1, 0, missing)).setParents("INFUSION", "RITUALSTONE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SPELLTABLE"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SPELLTABLE",
                getModItem("AWWayofTime", "blockHomHeart", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 40).add(Aspect.getAspect("ignis"), 40)
                        .add(Aspect.getAspect("terra"), 40).add(Aspect.getAspect("aqua"), 40)
                        .add(Aspect.getAspect("ordo"), 40).add(Aspect.getAspect("perditio"), 40),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("AWWayofTime", "largeBloodStoneBrick", 1, 0, missing),
                'b',
                getModItem("AWWayofTime", "largeBloodStoneBrick", 1, 0, missing),
                'c',
                getModItem("AWWayofTime", "largeBloodStoneBrick", 1, 0, missing),
                'd',
                getModItem("BloodArsenal", "blood_stone", 1, 1, missing),
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                'f',
                getModItem("BloodArsenal", "blood_stone", 1, 1, missing),
                'g',
                getModItem("BloodArsenal", "blood_stone", 1, 1, missing),
                'h',
                getModItem("BloodArsenal", "blood_stone", 1, 1, missing),
                'i',
                getModItem("BloodArsenal", "blood_stone", 1, 1, missing));
        TCHelper.addResearchPage(
                "SPELLTABLE",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "blockHomHeart", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SPELLTABLE", 4);
        new ResearchItem(
                "MASTERRITUALSTONE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("terra"), 18).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("tenebrae"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("aer"), 6),
                -2,
                -6,
                3,
                getModItem("AWWayofTime", "masterStone", 1, 0, missing)).setParents("INFUSION", "RITUALSTONE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.MASTERRITUALSTONE"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "MASTERRITUALSTONE",
                getModItem("AWWayofTime", "masterStone", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("terra"), 36).add(Aspect.getAspect("ignis"), 24)
                        .add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("cognitio"), 8),
                getModItem("AWWayofTime", "ritualStone", 1, 0, missing),
                new ItemStack[] { getModItem("AWWayofTime", "terrae", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 1, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 1, missing),
                        getModItem("AWWayofTime", "terrae", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 1, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 1, missing), });
        TCHelper.addResearchPage(
                "MASTERRITUALSTONE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "masterStone", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("MASTERRITUALSTONE", 2);
        new ResearchItem(
                "WATERSIGIL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("metallum"), 3),
                0,
                4,
                3,
                getModItem("AWWayofTime", "waterSigil", 1, 0, missing)).setParents("INFUSION", "DIVINATIONSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.WATERSIGIL"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "WATERSIGIL",
                getModItem("AWWayofTime", "waterSigil", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("aqua"), 40).add(Aspect.getAspect("terra"), 32)
                        .add(Aspect.getAspect("praecantatio"), 24).add(Aspect.getAspect("instrumentum"), 16)
                        .add(Aspect.getAspect("metallum"), 8),
                getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                new ItemStack[] { getModItem("witchery", "divinerwater", 1, 0, missing),
                        getModItem("IC2", "itemCellEmpty", 1, 1, missing),
                        getModItem("AWWayofTime", "aquasalus", 1, 0, missing),
                        getModItem("AWWayofTime", "aquasalus", 1, 0, missing),
                        getModItem("IC2", "itemCellEmpty", 1, 1, missing),
                        getModItem("IC2", "itemCellEmpty", 1, 1, missing),
                        getModItem("AWWayofTime", "aquasalus", 1, 0, missing),
                        getModItem("AWWayofTime", "aquasalus", 1, 0, missing),
                        getModItem("IC2", "itemCellEmpty", 1, 1, missing), });
        TCHelper.addResearchPage(
                "WATERSIGIL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "waterSigil", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("WATERSIGIL", 2);
        new ResearchItem(
                "LAVASIGIL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("metallum"), 3),
                0,
                8,
                3,
                getModItem("AWWayofTime", "lavaSigil", 1, 0, missing)).setParents("INFUSION", "SIGILOFTHEBLOODLAMP")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.LAVASIGIL")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "LAVASIGIL",
                getModItem("AWWayofTime", "lavaSigil", 1, 0, missing),
                7,
                new AspectList().add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("terra"), 40)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("metallum"), 16),
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                new ItemStack[] { getModItem("witchery", "divinerlava", 1, 0, missing),
                        getModItem("IC2", "itemCellEmpty", 1, 2, missing),
                        getModItem("AWWayofTime", "incendium", 1, 0, missing),
                        getModItem("AWWayofTime", "incendium", 1, 0, missing),
                        getModItem("IC2", "itemCellEmpty", 1, 2, missing),
                        getModItem("AWWayofTime", "lavaCrystal", 1, 0, missing),
                        getModItem("IC2", "itemCellEmpty", 1, 2, missing),
                        getModItem("AWWayofTime", "incendium", 1, 0, missing),
                        getModItem("AWWayofTime", "incendium", 1, 0, missing),
                        getModItem("IC2", "itemCellEmpty", 1, 2, missing), });
        TCHelper.addResearchPage(
                "LAVASIGIL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "lavaSigil", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("LAVASIGIL", 4);
        new ResearchItem(
                "EMPTYCORE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                0,
                -2,
                3,
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 1, missing)).setParents("INFUSION", "BLOODALTAR")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.EMPTYCORE")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "EMPTYCORE",
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 17351, missing),
                'c',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 17306, missing),
                'e',
                getModItem("AWWayofTime", "simpleCatalyst", 1, 0, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 17306, missing),
                'g',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 17351, missing),
                'i',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing));
        TCHelper.addResearchPage(
                "EMPTYCORE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 1, missing))));
        new ResearchItem(
                "BMLAVACRYSTAL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("infernus"), 12)
                        .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("aer"), 3),
                0,
                -4,
                3,
                getModItem("AWWayofTime", "lavaCrystal", 1, 0, missing))
                        .setParents("INFUSION", "EMPTYCORE", "LAVACRYSTAL", "WARDEDARCANA").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.BMLAVACRYSTAL")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "BMLAVACRYSTAL",
                getModItem("AWWayofTime", "lavaCrystal", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("ignis"), 24).add(Aspect.getAspect("terra"), 18)
                        .add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("infernus"), 6)
                        .add(Aspect.getAspect("aer"), 6),
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 1, missing),
                new ItemStack[] { getModItem("TConstruct", "materials", 1, 7, missing),
                        getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29500, missing),
                        getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing), });
        TCHelper.addResearchPage(
                "BMLAVACRYSTAL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "lavaCrystal", 1, 0, missing))));
        new ResearchItem(
                "RUNESACRIFICE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("fames"), 15).add(Aspect.getAspect("infernus"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                -4,
                0,
                3,
                getModItem("AWWayofTime", "runeOfSacrifice", 1, 0, missing)).setParents("INFUSION", "SPEEDRUNE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.RUNESACRIFICE"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNESACRIFICE",
                getModItem("AWWayofTime", "runeOfSacrifice", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("fames"), 24).add(Aspect.getAspect("infernus"), 24)
                        .add(Aspect.getAspect("potentia"), 18).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("terra"), 4),
                getModItem("BloodArsenal", "blood_stone", 1, 1, missing),
                new ItemStack[] { getModItem("AWWayofTime", "tennebrae", 1, 0, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "incendium", 1, 0, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "tennebrae", 1, 0, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "incendium", 1, 0, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RUNESACRIFICE",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "runeOfSacrifice", 1, 0, missing))));
        new ResearchItem(
                "RUNESELFSACRIFICE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("fames"), 15).add(Aspect.getAspect("infernus"), 12)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                -4,
                2,
                3,
                getModItem("AWWayofTime", "runeOfSelfSacrifice", 1, 0, missing)).setParents("INFUSION", "SPEEDRUNE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.RUNESELFSACRIFICE"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNESELFSACRIFICE",
                getModItem("AWWayofTime", "runeOfSelfSacrifice", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("fames"), 24).add(Aspect.getAspect("infernus"), 24)
                        .add(Aspect.getAspect("lucrum"), 18).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("terra"), 4),
                getModItem("BloodArsenal", "blood_stone", 1, 1, missing),
                new ItemStack[] { getModItem("AWWayofTime", "tennebrae", 1, 0, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "sanctus", 1, 0, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "tennebrae", 1, 0, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "sanctus", 1, 0, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RUNESELFSACRIFICE",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "runeOfSelfSacrifice", 1, 0, missing))));
        new ResearchItem(
                "AIRSIGIL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("volatus"), 21).add(Aspect.getAspect("aer"), 18)
                        .add(Aspect.getAspect("motus"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("iter"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("cognitio"), 3),
                0,
                10,
                3,
                getModItem("AWWayofTime", "airSigil", 1, 0, missing)).setParents("INFUSION", "LAVASIGIL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.AIRSIGIL")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "AIRSIGIL",
                getModItem("AWWayofTime", "airSigil", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("volatus"), 64).add(Aspect.getAspect("aer"), 48)
                        .add(Aspect.getAspect("motus"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("iter"), 18).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("cognitio"), 6),
                getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                new ItemStack[] { getModItem("minecraft", "ghast_tear", 1, 0, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 30004, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 30004, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("minecraft", "ghast_tear", 1, 0, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 30004, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 30004, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing), });
        TCHelper.addResearchPage(
                "AIRSIGIL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "airSigil", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("AIRSIGIL", 6);
        new ResearchItem(
                "FASTERMINING",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("perfodio"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("motus"), 3),
                -2,
                4,
                3,
                getModItem("AWWayofTime", "sigilOfTheFastMiner", 1, 0, missing))
                        .setParents("INFUSION", "DIVINATIONSIGIL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.FASTERMINING")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FASTERMINING",
                getModItem("AWWayofTime", "sigilOfTheFastMiner", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("instrumentum"), 36).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("perfodio"), 12)
                        .add(Aspect.getAspect("motus"), 8),
                getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                        getModItem("Thaumcraft", "ItemPickThaumium", 1, 0, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                        getModItem("Thaumcraft", "ItemShovelThaumium", 1, 0, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                        getModItem("Thaumcraft", "ItemAxeThaumium", 1, 0, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing), });
        TCHelper.addResearchPage(
                "FASTERMINING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "sigilOfTheFastMiner", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("FASTERMINING", 2);
        new ResearchItem(
                "GREENGROW",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("herba"), 9).add(Aspect.getAspect("arbor"), 6)
                        .add(Aspect.getAspect("victus"), 3),
                2,
                4,
                3,
                getModItem("AWWayofTime", "growthSigil", 1, 0, missing)).setParents("INFUSION", "DIVINATIONSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.GREENGROW")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "GREENGROW",
                getModItem("AWWayofTime", "growthSigil", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("instrumentum"), 36).add(Aspect.getAspect("terra"), 24)
                        .add(Aspect.getAspect("herba"), 18).add(Aspect.getAspect("arbor"), 12)
                        .add(Aspect.getAspect("victus"), 8),
                getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                new ItemStack[] { getModItem("witchery", "witchsapling", 1, 0, missing),
                        getModItem("AWWayofTime", "terrae", 1, 0, missing),
                        getModItem("witchery", "witchsapling", 1, 1, missing),
                        getModItem("AWWayofTime", "terrae", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCustomPlant", 1, 1, missing),
                        getModItem("AWWayofTime", "terrae", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCustomPlant", 1, 0, missing),
                        getModItem("AWWayofTime", "terrae", 1, 0, missing),
                        getModItem("TConstruct", "slime.sapling", 1, 0, missing),
                        getModItem("AWWayofTime", "terrae", 1, 0, missing), });
        TCHelper.addResearchPage(
                "GREENGROW",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "growthSigil", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("GREENGROW", 2);
        new ResearchItem(
                "VOIDSIGIL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vacuos"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("metallum"), 3),
                -2,
                6,
                3,
                getModItem("AWWayofTime", "voidSigil", 1, 0, missing)).setParents("INFUSION", "WATERSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.VOIDSIGIL")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "VOIDSIGIL",
                getModItem("AWWayofTime", "voidSigil", 1, 0, missing),
                7,
                new AspectList().add(Aspect.getAspect("vacuos"), 64).add(Aspect.getAspect("terra"), 40)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("auram"), 24)
                        .add(Aspect.getAspect("metallum"), 16),
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                new ItemStack[] { getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("minecraft", "bucket", 1, 0, missing),
                        getModItem("AWWayofTime", "tennebrae", 1, 0, missing),
                        getModItem("minecraft", "bucket", 1, 0, missing),
                        getModItem("AWWayofTime", "tennebrae", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                        getModItem("AWWayofTime", "tennebrae", 1, 0, missing),
                        getModItem("minecraft", "bucket", 1, 0, missing),
                        getModItem("AWWayofTime", "tennebrae", 1, 0, missing),
                        getModItem("minecraft", "bucket", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing), });
        TCHelper.addResearchPage(
                "VOIDSIGIL",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "voidSigil", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("VOIDSIGIL", 4);
        new ResearchItem(
                "SIGILOFSWIMMING",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aer"), 21).add(Aspect.getAspect("aqua"), 18)
                        .add(Aspect.getAspect("vacuos"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("metallum"), 3),
                -4,
                8,
                3,
                getModItem("BloodArsenal", "sigil_of_swimming", 1, 0, missing)).setParents("INFUSION", "VOIDSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFSWIMMING"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFSWIMMING",
                getModItem("BloodArsenal", "sigil_of_swimming", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("aqua"), 64)
                        .add(Aspect.getAspect("vacuos"), 64).add(Aspect.getAspect("terra"), 48)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("auram"), 24)
                        .add(Aspect.getAspect("metallum"), 16),
                getModItem("AWWayofTime", "voidSigil", 1, 0, missing),
                new ItemStack[] { getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 30711, missing),
                        createItemStack(
                                "IC2",
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"liquidoxygen\",Amount:1000}}",
                                missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 30711, missing),
                        createItemStack(
                                "IC2",
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"liquidoxygen\",Amount:1000}}",
                                missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        createItemStack(
                                "IC2",
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"liquidoxygen\",Amount:1000}}",
                                missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 30711, missing),
                        createItemStack(
                                "IC2",
                                "itemFluidCell",
                                1,
                                0,
                                "{Fluid:{FluidName:\"liquidoxygen\",Amount:1000}}",
                                missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 30711, missing), });
        TCHelper.addResearchPage(
                "SIGILOFSWIMMING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("BloodArsenal", "sigil_of_swimming", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SIGILOFSWIMMING", 6);
        new ResearchItem(
                "BLOODLETTERSPACK",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("telum"), 15).add(Aspect.getAspect("sano"), 12)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("tutamen"), 6)
                        .add(Aspect.getAspect("pannus"), 3),
                2,
                -4,
                3,
                getModItem("AWWayofTime", "itemBloodPack", 1, 0, missing))
                        .setParents("SACRIFICIALKNIFE").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.BLOODLETTERSPACK.1"),
                                new ResearchPage("tc.research_page.BLOODLETTERSPACK.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BLOODLETTERSPACK",
                getModItem("AWWayofTime", "itemBloodPack", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("aqua"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                'b',
                getModItem("AWWayofTime", "sacrificialKnife", 1, 0, missing),
                'c',
                getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                'd',
                getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                'e',
                getModItem("Thaumcraft", "ItemChestplateThaumium", 1, 0, missing),
                'f',
                getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                'g',
                getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                'h',
                getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                'i',
                getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing));
        TCHelper.addResearchPage(
                "BLOODLETTERSPACK",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "itemBloodPack", 1, 0, missing))));
        new ResearchItem(
                "IMBUEARMOR",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("sano"), 15).add(Aspect.getAspect("tutamen"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("metallum"), 6)
                        .add(Aspect.getAspect("potentia"), 3),
                4,
                -6,
                3,
                createItemStack("BloodArsenal", "life_imbued_chestplate", 1, 0, "{LPStored:0}", missing))
                        .setParents("BLOODLETTERSPACK").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.IMBUEARMOR")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMBUEARMOR",
                createItemStack("BloodArsenal", "life_imbued_helmet", 1, 0, "{LPStored:0}", missing),
                new AspectList().add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'b',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'c',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'd',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'e',
                getModItem("Thaumcraft", "ItemHelmetThaumium", 1, 0, missing),
                'f',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'h',
                "craftingToolHardHammer");
        TCHelper.addResearchPage(
                "IMBUEARMOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack("BloodArsenal", "life_imbued_helmet", 1, 0, "{LPStored:0}", missing))));
        ThaumcraftApi.addWarpToResearch("IMBUEARMOR", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMBUEARMOR",
                createItemStack("BloodArsenal", "life_imbued_chestplate", 1, 0, "{LPStored:0}", missing),
                new AspectList().add(Aspect.getAspect("terra"), 60).add(Aspect.getAspect("ignis"), 60)
                        .add(Aspect.getAspect("ordo"), 60).add(Aspect.getAspect("perditio"), 60),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'b',
                getModItem("Thaumcraft", "ItemChestplateThaumium", 1, 0, missing),
                'c',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'd',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'e',
                "craftingToolHardHammer",
                'f',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'g',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'h',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'i',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing));
        TCHelper.addResearchPage(
                "IMBUEARMOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(
                                        "BloodArsenal",
                                        "life_imbued_chestplate",
                                        1,
                                        0,
                                        "{LPStored:0}",
                                        missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMBUEARMOR",
                createItemStack("BloodArsenal", "life_imbued_leggings", 1, 0, "{LPStored:0}", missing),
                new AspectList().add(Aspect.getAspect("terra"), 45).add(Aspect.getAspect("ignis"), 45)
                        .add(Aspect.getAspect("ordo"), 45).add(Aspect.getAspect("perditio"), 45),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'b',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'c',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'd',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'e',
                getModItem("Thaumcraft", "ItemLeggingsThaumium", 1, 0, missing),
                'f',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'g',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'h',
                "craftingToolHardHammer",
                'i',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing));
        TCHelper.addResearchPage(
                "IMBUEARMOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(
                                        "BloodArsenal",
                                        "life_imbued_leggings",
                                        1,
                                        0,
                                        "{LPStored:0}",
                                        missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IMBUEARMOR",
                createItemStack("BloodArsenal", "life_imbued_boots", 1, 0, "{LPStored:0}", missing),
                new AspectList().add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'd',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'e',
                getModItem("Thaumcraft", "ItemBootsThaumium", 1, 0, missing),
                'f',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'g',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing),
                'h',
                "craftingToolHardHammer",
                'i',
                getModItem("TConstruct", "heavyPlate", 1, 251, missing));
        TCHelper.addResearchPage(
                "IMBUEARMOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack("BloodArsenal", "life_imbued_boots", 1, 0, "{LPStored:0}", missing))));
        new ResearchItem(
                "WEAKORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                2,
                0,
                2,
                getModItem("dreamcraft", "item.WeakOrb", 1, 0, missing))
                        .setParents("BLOODALTAR").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.WEAKORB.1"),
                                new ResearchPage("tc.research_page.WEAKORB.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "WEAKORB",
                getModItem("dreamcraft", "item.WeakOrb", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("aqua"), 20)
                        .add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("perditio"), 20).add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'b',
                "gemDiamond",
                'd',
                getModItem("AWWayofTime", "blankSlate", 1, 0, missing),
                'e',
                getModItem("dreamcraft", "item.RawOrbTier1", 1, 0, missing),
                'f',
                getModItem("AWWayofTime", "blankSlate", 1, 0, missing),
                'h',
                "gemDiamond");
        TCHelper.addResearchPage(
                "WEAKORB",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("dreamcraft", "item.WeakOrb", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("WEAKORB", 1);
        new ResearchItem(
                "APPRENTICEORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("cognitio"), 3),
                4,
                0,
                3,
                getModItem("dreamcraft", "item.ApprenticeOrb", 1, 0, missing))
                        .setParents("WEAKORB").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.APPRENTICEORB.1"),
                                new ResearchPage("tc.research_page.APPRENTICEORB.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "APPRENTICEORB",
                getModItem("dreamcraft", "item.ApprenticeOrb", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 40).add(Aspect.getAspect("aqua"), 40)
                        .add(Aspect.getAspect("ignis"), 40).add(Aspect.getAspect("terra"), 40)
                        .add(Aspect.getAspect("perditio"), 40).add(Aspect.getAspect("ordo"), 40),
                "abc",
                "def",
                "ghi",
                'b',
                "gemFlawlessEmerald",
                'd',
                getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                'e',
                getModItem("dreamcraft", "item.RawOrbTier2", 1, 0, missing),
                'f',
                getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                'h',
                "gemFlawlessEmerald");
        TCHelper.addResearchPage(
                "APPRENTICEORB",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("dreamcraft", "item.ApprenticeOrb", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("APPRENTICEORB", 2);
        new ResearchItem(
                "MAGICANORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("cognitio"), 6)
                        .add(Aspect.getAspect("sano"), 3),
                6,
                0,
                3,
                getModItem("dreamcraft", "item.MagicianOrb", 1, 0, missing))
                        .setParents("APPRENTICEORB").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.MAGICANORB.1"),
                                new ResearchPage("tc.research_page.MAGICANORB.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MAGICANORB",
                getModItem("dreamcraft", "item.MagicianOrb", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 60).add(Aspect.getAspect("aqua"), 60)
                        .add(Aspect.getAspect("ignis"), 60).add(Aspect.getAspect("terra"), 60)
                        .add(Aspect.getAspect("perditio"), 60).add(Aspect.getAspect("ordo"), 60),
                "abc",
                "def",
                "ghi",
                'b',
                "blockGold",
                'd',
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                'e',
                getModItem("dreamcraft", "item.RawOrbTier3", 1, 0, missing),
                'f',
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                'h',
                "blockGold");
        TCHelper.addResearchPage(
                "MAGICANORB",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("dreamcraft", "item.MagicianOrb", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("MAGICANORB", 3);
        new ResearchItem(
                "MASTERORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 18).add(Aspect.getAspect("potentia"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("cognitio"), 9)
                        .add(Aspect.getAspect("sano"), 6).add(Aspect.getAspect("aqua"), 3),
                8,
                0,
                3,
                getModItem("dreamcraft", "item.MasterOrb", 1, 0, missing)).setParents("MAGICANORB").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.MASTERORB")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MASTERORB",
                getModItem("dreamcraft", "item.MasterOrb", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 80).add(Aspect.getAspect("aqua"), 80)
                        .add(Aspect.getAspect("ignis"), 80).add(Aspect.getAspect("terra"), 80)
                        .add(Aspect.getAspect("perditio"), 80).add(Aspect.getAspect("ordo"), 80),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                'd',
                getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                'e',
                getModItem("dreamcraft", "item.RawOrbTier4", 1, 0, missing),
                'f',
                getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                'h',
                getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing));
        TCHelper.addResearchPage(
                "MASTERORB",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("dreamcraft", "item.MasterOrb", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("MASTERORB", 4);
        new ResearchItem(
                "ARCHMAGEORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 21).add(Aspect.getAspect("potentia"), 18)
                        .add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("sano"), 9).add(Aspect.getAspect("aqua"), 6)
                        .add(Aspect.getAspect("infernus"), 3),
                10,
                0,
                3,
                getModItem("dreamcraft", "item.ArchmageOrb", 1, 0, missing))
                        .setParents("MASTERORB").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.ARCHMAGEORB.1"),
                                new ResearchPage("tc.research_page.ARCHMAGEORB.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARCHMAGEORB",
                getModItem("dreamcraft", "item.ArchmageOrb", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                        .add(Aspect.getAspect("ignis"), 100).add(Aspect.getAspect("terra"), 100)
                        .add(Aspect.getAspect("perditio"), 100).add(Aspect.getAspect("ordo"), 100),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("AWWayofTime", "demonBloodShard", 1, 0, missing),
                'd',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 27, missing),
                'e',
                getModItem("dreamcraft", "item.RawOrbTier5", 1, 0, missing),
                'f',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 27, missing),
                'h',
                getModItem("AWWayofTime", "demonBloodShard", 1, 0, missing));
        TCHelper.addResearchPage(
                "ARCHMAGEORB",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("dreamcraft", "item.ArchmageOrb", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ARCHMAGEORB", 5);
        new ResearchItem(
                "TRANSCENDENTORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 24).add(Aspect.getAspect("potentia"), 21)
                        .add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("cognitio"), 15)
                        .add(Aspect.getAspect("sano"), 12).add(Aspect.getAspect("aqua"), 9)
                        .add(Aspect.getAspect("infernus"), 6).add(Aspect.getAspect("electrum"), 3),
                12,
                0,
                3,
                getModItem("dreamcraft", "item.TranscendentOrb", 1, 0, missing)).setParents("ARCHMAGEORB")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.TRANSCENDENTORB.1"),
                                new ResearchPage("tc.research_page.TRANSCENDENTORB.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TRANSCENDENTORB",
                getModItem("dreamcraft", "item.TranscendentOrb", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 150).add(Aspect.getAspect("aqua"), 150)
                        .add(Aspect.getAspect("ignis"), 150).add(Aspect.getAspect("terra"), 150)
                        .add(Aspect.getAspect("perditio"), 150).add(Aspect.getAspect("ordo"), 150),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("AWWayofTime", "blockCrystal", 1, 0, missing),
                'd',
                getModItem("BloodArsenal", "sigil_of_lightning", 1, 0, missing),
                'e',
                getModItem("dreamcraft", "item.RawOrbTier6", 1, 0, missing),
                'f',
                getModItem("BloodArsenal", "sigil_of_lightning", 1, 0, missing),
                'h',
                getModItem("AWWayofTime", "blockCrystal", 1, 0, missing));
        TCHelper.addResearchPage(
                "TRANSCENDENTORB",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("dreamcraft", "item.TranscendentOrb", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("TRANSCENDENTORB", 6);
        new ResearchItem(
                "TRANSPARENTORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 27).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("praecantatio"), 21).add(Aspect.getAspect("cognitio"), 18)
                        .add(Aspect.getAspect("sano"), 15).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("infernus"), 9).add(Aspect.getAspect("electrum"), 6)
                        .add(Aspect.getAspect("alienis"), 3),
                14,
                0,
                3,
                getModItem("BloodArsenal", "transparent_orb", 1, 0, missing)).setParents("TRANSCENDENTORB")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.TRANSPARENTORB"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "TRANSPARENTORB",
                getModItem("BloodArsenal", "transparent_orb", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 175).add(Aspect.getAspect("aqua"), 175)
                        .add(Aspect.getAspect("ignis"), 175).add(Aspect.getAspect("terra"), 175)
                        .add(Aspect.getAspect("perditio"), 175).add(Aspect.getAspect("ordo"), 175),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("BloodArsenal", "blood_stained_glass", 1, 0, missing),
                'b',
                getModItem("BloodArsenal", "blood_lamp", 1, 0, missing),
                'c',
                getModItem("BloodArsenal", "blood_stained_glass", 1, 0, missing),
                'd',
                getModItem("BloodArsenal", "blood_stained_glass", 1, 0, missing),
                'e',
                getModItem("AWWayofTime", "transcendentBloodOrb", 1, 0, missing),
                'f',
                getModItem("BloodArsenal", "blood_stained_glass", 1, 0, missing),
                'g',
                getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                'h',
                getModItem("AWWayofTime", "divinationSigil", 1, 0, missing),
                'i',
                getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing));
        TCHelper.addResearchPage(
                "TRANSPARENTORB",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("BloodArsenal", "transparent_orb", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("TRANSPARENTORB", 7);
        new ResearchItem(
                "EMPTYSOCKET",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("tutamen"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("tenebrae"), 6)
                        .add(Aspect.getAspect("sano"), 3),
                2,
                -6,
                3,
                getModItem("AWWayofTime", "emptySocket", 1, 0, missing)).setParents("BLOODLETTERSPACK").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.EMPTYSOCKET")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "EMPTYSOCKET",
                getModItem("AWWayofTime", "emptySocket", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("perditio"), 50).add(Aspect.getAspect("ordo"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                'b',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 25, missing),
                'c',
                getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                'd',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 25, missing),
                'e',
                getModItem("dreamcraft", "tile.DiamondFrameBox", 1, 0, missing),
                'f',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 25, missing),
                'g',
                getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                'h',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 25, missing),
                'i',
                getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing));
        TCHelper.addResearchPage(
                "EMPTYSOCKET",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "emptySocket", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("EMPTYSOCKET", 2);
        new ResearchItem(
                "SOULARMORFORGE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("tutamen"), 18).add(Aspect.getAspect("metallum"), 15)
                        .add(Aspect.getAspect("praecantatio"), 21).add(Aspect.getAspect("tenebrae"), 6)
                        .add(Aspect.getAspect("exanimis"), 3),
                2,
                -8,
                3,
                getModItem("AWWayofTime", "armourForge", 1, 0, missing)).setParents("INFUSION", "EMPTYSOCKET")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.SOULARMORFORGE.1"),
                                new ResearchPage("tc.research_page.SOULARMORFORGE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SOULARMORFORGE",
                getModItem("AWWayofTime", "armourForge", 1, 0, missing),
                7,
                new AspectList().add(Aspect.getAspect("tutamen"), 64).add(Aspect.getAspect("metallum"), 40)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("auram"), 24)
                        .add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("exanimis"), 8),
                getModItem("TConstruct", "ToolForgeBlock", 1, 6, missing),
                new ItemStack[] { getModItem("AWWayofTime", "bloodSocket", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 3, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 2, missing),
                        getModItem("AWWayofTime", "bloodSocket", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 2, missing),
                        getModItem("AWWayofTime", "magicales", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodSocket", 1, 0, missing),
                        getModItem("AWWayofTime", "magicales", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 2, missing),
                        getModItem("AWWayofTime", "bloodSocket", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 2, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 3, missing), });
        TCHelper.addResearchPage(
                "SOULARMORFORGE",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "armourForge", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SOULARMORFORGE", 4);
        new ResearchItem(
                "RUNEOFARGUMENTEDCAPACITY",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aqua"), 18).add(Aspect.getAspect("fames"), 15)
                        .add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("vacuos"), 3),
                -6,
                0,
                3,
                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 1, missing))
                        .setParents("INFUSION", "RUNESACRIFICE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.RUNEOFARGUMENTEDCAPACITY")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNEOFARGUMENTEDCAPACITY",
                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 1, missing),
                7,
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("lucrum"), 24)
                        .add(Aspect.getAspect("fames"), 18).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("vacuos"), 4),
                getModItem("BloodArsenal", "blood_stone", 1, 1, missing),
                new ItemStack[] { getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("BuildCraft|Factory", "tankBlock", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RUNEOFARGUMENTEDCAPACITY",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 1, missing))));
        new ResearchItem(
                "RUNEOFDISLOCATION",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aqua"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("cognitio"), 3),
                -6,
                2,
                3,
                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 2, missing))
                        .setParents("INFUSION", "RUNESACRIFICE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.RUNEOFDISLOCATION")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNEOFDISLOCATION",
                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 2, missing),
                7,
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("motus"), 18).add(Aspect.getAspect("tempus"), 12)
                        .add(Aspect.getAspect("terra"), 8).add(Aspect.getAspect("cognitio"), 4),
                getModItem("BloodArsenal", "blood_stone", 1, 1, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 32613, missing),
                        getModItem("AWWayofTime", "aquasalus", 1, 0, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "aquasalus", 1, 0, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32613, missing),
                        getModItem("AWWayofTime", "aquasalus", 1, 0, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "aquasalus", 1, 0, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RUNEOFDISLOCATION",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 2, missing))));
        new ResearchItem(
                "SIGILOFELEMENTALAFFINITY",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("volatus"), 27).add(Aspect.getAspect("ignis"), 24)
                        .add(Aspect.getAspect("aqua"), 21).add(Aspect.getAspect("aer"), 18)
                        .add(Aspect.getAspect("motus"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("iter"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("cognitio"), 3),
                0,
                12,
                3,
                getModItem("AWWayofTime", "sigilOfElementalAffinity", 1, 0, missing)).setParents("INFUSION", "AIRSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFELEMENTALAFFINITY"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFELEMENTALAFFINITY",
                getModItem("AWWayofTime", "sigilOfElementalAffinity", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("volatus"), 64).add(Aspect.getAspect("aer"), 48)
                        .add(Aspect.getAspect("aqua"), 48).add(Aspect.getAspect("ignis"), 48)
                        .add(Aspect.getAspect("motus"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("iter"), 18).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("cognitio"), 6),
                getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                new ItemStack[] { getModItem("AWWayofTime", "earthScribeTool", 1, 0, missing),
                        getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                        getModItem("AWWayofTime", "lavaSigil", 1, 0, missing),
                        getModItem("AWWayofTime", "fireScribeTool", 1, 0, missing),
                        getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                        getModItem("AWWayofTime", "waterSigil", 1, 0, missing),
                        getModItem("AWWayofTime", "waterScribeTool", 1, 0, missing),
                        getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                        getModItem("AWWayofTime", "airSigil", 1, 0, missing),
                        getModItem("AWWayofTime", "airScribeTool", 1, 0, missing),
                        getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFELEMENTALAFFINITY",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem("AWWayofTime", "sigilOfElementalAffinity", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SIGILOFELEMENTALAFFINITY", 8);
        new ResearchItem(
                "SIGILOFLIGHTNING",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("tempestas"), 24).add(Aspect.getAspect("aer"), 21)
                        .add(Aspect.getAspect("aqua"), 18).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("tenebrae"), 9)
                        .add(Aspect.getAspect("ira"), 6).add(Aspect.getAspect("electrum"), 3),
                2,
                14,
                3,
                getModItem("BloodArsenal", "sigil_of_lightning", 1, 0, missing))
                        .setParents("INFUSION", "SIGILOFELEMENTALAFFINITY").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.SIGILOFLIGHTNING.1"),
                                new ResearchPage("tc.research_page.SIGILOFLIGHTNING.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFLIGHTNING",
                getModItem("BloodArsenal", "sigil_of_lightning", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("tempestas"), 32).add(Aspect.getAspect("aer"), 72)
                        .add(Aspect.getAspect("aqua"), 72).add(Aspect.getAspect("terra"), 64)
                        .add(Aspect.getAspect("potentia"), 48).add(Aspect.getAspect("tenebrae"), 8)
                        .add(Aspect.getAspect("ira"), 8).add(Aspect.getAspect("electrum"), 16),
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 27, missing),
                new ItemStack[] { getModItem("AWWayofTime", "airSigil", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 3, missing),
                        getModItem("BloodArsenal", "blood_infused_iron_block", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_diamond_block", 1, 0, missing),
                        getModItem("AWWayofTime", "waterSigil", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 3, missing),
                        getModItem("BloodArsenal", "blood_infused_iron_block", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_diamond_block", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFLIGHTNING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("BloodArsenal", "sigil_of_lightning", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SIGILOFLIGHTNING", 12);
        new ResearchItem(
                "SIGILOFHOLDING",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("lucrum"), 18).add(Aspect.getAspect("cognitio"), 15)
                        .add(Aspect.getAspect("gula"), 12).add(Aspect.getAspect("superbia"), 9)
                        .add(Aspect.getAspect("limus"), 6).add(Aspect.getAspect("praecantatio"), 3),
                4,
                6,
                3,
                getModItem("AWWayofTime", "sigilOfHolding", 1, 0, missing)).setParents("INFUSION", "SIGILOFMAGNETISM")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFHOLDING"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFHOLDING",
                getModItem("AWWayofTime", "sigilOfHolding", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("lucrum"), 32).add(Aspect.getAspect("cognitio"), 24)
                        .add(Aspect.getAspect("gula"), 16).add(Aspect.getAspect("superbia"), 16)
                        .add(Aspect.getAspect("limus"), 16).add(Aspect.getAspect("praecantatio"), 8),
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                new ItemStack[] { getModItem("IronChest", "BlockIronChest", 1, 0, missing),
                        getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "magicales", 1, 0, missing),
                        getModItem("AWWayofTime", "crepitous", 1, 0, missing),
                        getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "crepitous", 1, 0, missing),
                        getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "magicales", 1, 0, missing),
                        getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFHOLDING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "sigilOfHolding", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SIGILOFHOLDING", 2);
        new ResearchItem(
                "SIGILOFAUGMENTETHOLDING",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vacuos"), 21).add(Aspect.getAspect("lucrum"), 18)
                        .add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("gula"), 12)
                        .add(Aspect.getAspect("superbia"), 9).add(Aspect.getAspect("limus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                4,
                8,
                3,
                getModItem("BloodArsenal", "sigil_of_augmented_holding", 1, 0, missing))
                        .setParents("INFUSION", "SIGILOFHOLDING").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SIGILOFAUGMENTETHOLDING")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFAUGMENTETHOLDING",
                getModItem("BloodArsenal", "sigil_of_augmented_holding", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("vacuos"), 48).add(Aspect.getAspect("lucrum"), 32)
                        .add(Aspect.getAspect("cognitio"), 24).add(Aspect.getAspect("gula"), 16)
                        .add(Aspect.getAspect("superbia"), 16).add(Aspect.getAspect("limus"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8),
                getModItem("AWWayofTime", "sigilOfHolding", 1, 0, missing),
                new ItemStack[] { getModItem("IronChest", "BlockIronChest", 1, 2, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("minecraft", "ghast_tear", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17977, missing),
                        getModItem("minecraft", "blaze_rod", 1, 0, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("minecraft", "ghast_tear", 1, 0, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("minecraft", "blaze_rod", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17977, missing),
                        getModItem("minecraft", "ghast_tear", 1, 0, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFAUGMENTETHOLDING",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem("BloodArsenal", "sigil_of_augmented_holding", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SIGILOFAUGMENTETHOLDING", 4);
        new ResearchItem(
                "SIGILOFPHANTOMBRIDGE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("terra"), 18).add(Aspect.getAspect("alienis"), 15)
                        .add(Aspect.getAspect("iter"), 12).add(Aspect.getAspect("vitreus"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("praecantatio"), 3),
                -4,
                6,
                3,
                getModItem("AWWayofTime", "sigilOfTheBridge", 1, 0, missing)).setParents("INFUSION", "VOIDSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFPHANTOMBRIDGE"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFPHANTOMBRIDGE",
                getModItem("AWWayofTime", "sigilOfTheBridge", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("terra"), 48).add(Aspect.getAspect("alienis"), 32)
                        .add(Aspect.getAspect("iter"), 24).add(Aspect.getAspect("vitreus"), 16)
                        .add(Aspect.getAspect("potentia"), 8).add(Aspect.getAspect("praecantatio"), 8),
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                new ItemStack[] { getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 1, missing),
                        getModItem("EnderIO", "blockIngotStorage", 1, 7, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 1, missing),
                        getModItem("EnderIO", "blockIngotStorage", 1, 7, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 1, missing),
                        getModItem("EnderIO", "blockIngotStorage", 1, 7, missing),
                        getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 1, missing),
                        getModItem("EnderIO", "blockIngotStorage", 1, 7, missing), });
        TCHelper.addResearchPage(
                "SIGILOFPHANTOMBRIDGE",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "sigilOfTheBridge", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SIGILOFPHANTOMBRIDGE", 4);
        new ResearchItem(
                "SIGILOFMAGNETISM",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("magneto"), 21).add(Aspect.getAspect("potentia"), 18)
                        .add(Aspect.getAspect("electrum"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("auram"), 6).add(Aspect.getAspect("cognitio"), 3),
                2,
                6,
                3,
                getModItem("AWWayofTime", "sigilOfMagnetism", 1, 0, missing)).setParents("INFUSION", "WATERSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFMAGNETISM"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFMAGNETISM",
                getModItem("AWWayofTime", "sigilOfMagnetism", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("magneto"), 24)
                        .add(Aspect.getAspect("electrum"), 24).add(Aspect.getAspect("auram"), 16)
                        .add(Aspect.getAspect("cognitio"), 12).add(Aspect.getAspect("praecantatio"), 6),
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.blockmetal5", 1, 1, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmetal5", 1, 1, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmetal5", 1, 1, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmetal5", 1, 1, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFMAGNETISM",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "sigilOfMagnetism", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SIGILOFMAGNETISM", 2);
        new ResearchItem(
                "SIGILOFTHEBLOODLAMP",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("lux"), 18).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("potentia"), 9)
                        .add(Aspect.getAspect("sensus"), 6).add(Aspect.getAspect("praecantatio"), 3),
                0,
                6,
                3,
                getModItem("AWWayofTime", "itemBloodLightSigil", 1, 0, missing)).setParents("INFUSION", "WATERSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFTHEBLOODLAMP"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFTHEBLOODLAMP",
                getModItem("AWWayofTime", "itemBloodLightSigil", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("lux"), 48).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("sensus"), 16).add(Aspect.getAspect("praecantatio"), 8),
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                new ItemStack[] { getModItem("ThaumicTinkerer", "brightNitor", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 6, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 2, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 6, missing),
                        getModItem("ThaumicTinkerer", "brightNitor", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 6, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 2, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 6, missing), });
        TCHelper.addResearchPage(
                "SIGILOFTHEBLOODLAMP",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "itemBloodLightSigil", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SIGILOFTHEBLOODLAMP", 3);
        new ResearchItem(
                "SIGILOFSIGHT",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("sensus"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("vitreus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                2,
                2,
                3,
                getModItem("AWWayofTime", "seerSigil", 1, 0, missing)).setParents("INFUSION", "DIVINATIONSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFSIGHT"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFSIGHT",
                getModItem("AWWayofTime", "seerSigil", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("ordo"), 24).add(Aspect.getAspect("sensus"), 18)
                        .add(Aspect.getAspect("cognitio"), 12).add(Aspect.getAspect("vitreus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 4),
                getModItem("AWWayofTime", "divinationSigil", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("AWWayofTime", "crystallos", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing),
                        getModItem("AWWayofTime", "crystallos", 1, 0, missing),
                        getModItem("TConstruct", "GlassPane", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFSIGHT",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "seerSigil", 1, 0, missing))));
        new ResearchItem(
                "RITUALDIVINER",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aer"), 18).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("aqua"), 9)
                        .add(Aspect.getAspect("perditio"), 6).add(Aspect.getAspect("ordo"), 3),
                -2,
                -8,
                3,
                getModItem("AWWayofTime", "itemRitualDiviner", 1, 0, missing))
                        .setParents("INFUSION", "MASTERRITUALSTONE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.RITUALDIVINER.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RITUALDIVINER",
                getModItem("AWWayofTime", "itemRitualDiviner", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("aqua"), 32)
                        .add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("ordo"), 16),
                getModItem("AWWayofTime", "seerSigil", 1, 0, missing),
                new ItemStack[] { getModItem("witchery", "chalkritual", 1, 0, missing),
                        getModItem("AWWayofTime", "waterScribeTool", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29500, missing),
                        getModItem("AWWayofTime", "fireScribeTool", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29501, missing),
                        getModItem("AWWayofTime", "earthScribeTool", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29500, missing),
                        getModItem("AWWayofTime", "airScribeTool", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 29501, missing), });
        TCHelper.addResearchPage(
                "RITUALDIVINER",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "itemRitualDiviner", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("RITUALDIVINER", 3);
        TCHelper.addResearchPage("RITUALDIVINER", new ResearchPage("tc.research_page.RITUALDIVINER.2"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RITUALDIVINER",
                getModItem("AWWayofTime", "itemRitualDiviner", 1, 1, missing),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 48).add(Aspect.getAspect("ignis"), 48)
                        .add(Aspect.getAspect("terra"), 48).add(Aspect.getAspect("aqua"), 48)
                        .add(Aspect.getAspect("perditio"), 24).add(Aspect.getAspect("ordo"), 24),
                getModItem("AWWayofTime", "itemRitualDiviner", 1, 0, missing),
                new ItemStack[] { getModItem("AWWayofTime", "duskScribeTool", 1, 0, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "duskScribeTool", 1, 0, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "duskScribeTool", 1, 0, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "duskScribeTool", 1, 0, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RITUALDIVINER",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "itemRitualDiviner", 1, 1, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RITUALDIVINER",
                getModItem("AWWayofTime", "itemRitualDiviner", 1, 2, missing),
                9,
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("ignis"), 64)
                        .add(Aspect.getAspect("terra"), 64).add(Aspect.getAspect("aqua"), 64)
                        .add(Aspect.getAspect("perditio"), 32).add(Aspect.getAspect("ordo"), 32),
                getModItem("AWWayofTime", "itemRitualDiviner", 1, 1, missing),
                new ItemStack[] { getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 27, missing),
                        getModItem("AWWayofTime", "dawnScribeTool", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 27, missing),
                        getModItem("AWWayofTime", "dawnScribeTool", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 27, missing),
                        getModItem("AWWayofTime", "dawnScribeTool", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 27, missing),
                        getModItem("AWWayofTime", "dawnScribeTool", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RITUALDIVINER",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "itemRitualDiviner", 1, 2, missing))));
        new ResearchItem(
                "RUNEOFTHEORB",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("victus"), 12)
                        .add(Aspect.getAspect("motus"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                -6,
                -2,
                3,
                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 3, missing))
                        .setParents("INFUSION", "RUNESACRIFICE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.RUNEOFTHEORB")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNEOFTHEORB",
                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 3, missing),
                6,
                new AspectList().add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("victus"), 24)
                        .add(Aspect.getAspect("motus"), 16).add(Aspect.getAspect("lucrum"), 8)
                        .add(Aspect.getAspect("praecantatio"), 4),
                getModItem("BloodArsenal", "blood_stone", 1, 3, missing),
                new ItemStack[] { getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 3, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 1, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 1, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 3, missing), });
        TCHelper.addResearchPage(
                "RUNEOFTHEORB",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 3, missing))));
        new ResearchItem(
                "RUNEOFSUPERIORCAPACITY",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("potentia"), 18).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("cognitio"), 12).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("alienis"), 3),
                -8,
                -2,
                3,
                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 4, missing))
                        .setParents("INFUSION", "RUNEOFARGUMENTEDCAPACITY").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.RUNEOFSUPERIORCAPACITY.1"),
                                new ResearchPage("tc.research_page.RUNEOFSUPERIORCAPACITY.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNEOFSUPERIORCAPACITY",
                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 4, missing),
                8,
                new AspectList().add(Aspect.getAspect("potentia"), 48).add(Aspect.getAspect("aqua"), 32)
                        .add(Aspect.getAspect("cognitio"), 24).add(Aspect.getAspect("lucrum"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8).add(Aspect.getAspect("alienis"), 4),
                getModItem("BloodArsenal", "blood_stone", 1, 3, missing),
                new ItemStack[] { getModItem("irontank", "diamondTank", 1, 0, missing),
                        getModItem("AWWayofTime", "magicales", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 3, missing),
                        getModItem("AWWayofTime", "magicales", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 24, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("irontank", "diamondTank", 1, 0, missing),
                        getModItem("AWWayofTime", "magicales", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 3, missing),
                        getModItem("AWWayofTime", "magicales", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 24, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RUNEOFSUPERIORCAPACITY",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 4, missing))));
        new ResearchItem(
                "RUNEOFACCELERATION",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("potentia"), 21).add(Aspect.getAspect("tempus"), 18)
                        .add(Aspect.getAspect("cognitio"), 15).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("motus"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                -8,
                0,
                3,
                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 5, missing))
                        .setParents("INFUSION", "RUNEOFARGUMENTEDCAPACITY", "RUNEOFDISLOCATION").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.RUNEOFACCELERATION")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RUNEOFACCELERATION",
                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 5, missing),
                10,
                new AspectList().add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("aqua"), 48)
                        .add(Aspect.getAspect("motus"), 32).add(Aspect.getAspect("cognitio"), 24)
                        .add(Aspect.getAspect("tempus"), 16).add(Aspect.getAspect("praecantatio"), 8)
                        .add(Aspect.getAspect("terra"), 4),
                getModItem("BloodArsenal", "blood_stone", 1, 4, missing),
                new ItemStack[] { getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 2, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 24, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 27, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32614, missing),
                        getModItem("AWWayofTime", "speedRune", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 24, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 27, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem("BloodArsenal", "blood_stone", 1, 4, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32614, missing), });
        TCHelper.addResearchPage(
                "RUNEOFACCELERATION",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 5, missing))));
        new ResearchItem(
                "ARCANEPEDESTALANDPLINTH",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("terra"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                -4,
                -6,
                3,
                getModItem("AWWayofTime", "blockPedestal", 1, 0, missing)).setParents("INFUSION", "MASTERRITUALSTONE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.ARCANEPEDESTALANDPLINTH.1"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARCANEPEDESTALANDPLINTH",
                getModItem("AWWayofTime", "blockPedestal", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 0, missing),
                'b',
                getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                'c',
                getModItem("AWWayofTime", "AlchemicalWizardrybloodRune", 1, 0, missing),
                'd',
                getModItem("AWWayofTime", "largeBloodStoneBrick", 1, 0, missing),
                'e',
                getModItem("Thaumcraft", "blockStoneDevice", 1, 1, missing),
                'f',
                getModItem("AWWayofTime", "largeBloodStoneBrick", 1, 0, missing),
                'g',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'h',
                getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                'i',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing));
        TCHelper.addResearchPage(
                "ARCANEPEDESTALANDPLINTH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "blockPedestal", 1, 0, missing))));
        TCHelper.addResearchPage(
                "ARCANEPEDESTALANDPLINTH",
                new ResearchPage("tc.research_page.ARCANEPEDESTALANDPLINTH.2"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ARCANEPEDESTALANDPLINTH",
                getModItem("AWWayofTime", "blockPlinth", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("metallum"), 64).add(Aspect.getAspect("ignis"), 48)
                        .add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("tenebrae"), 24)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("alienis"), 8),
                getModItem("AWWayofTime", "blockPedestal", 1, 0, missing),
                new ItemStack[] { getModItem("BloodArsenal", "blood_infused_iron_block", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 130, missing),
                        getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_iron_block", 1, 0, missing),
                        getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 130, missing),
                        getModItem("BloodArsenal", "blood_infused_iron_block", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 130, missing),
                        getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_iron_block", 1, 0, missing),
                        getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                        getModItem("witchery", "ingredient", 1, 130, missing), });
        TCHelper.addResearchPage(
                "ARCANEPEDESTALANDPLINTH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "blockPlinth", 1, 0, missing))));
        TCHelper.addResearchPage(
                "ARCANEPEDESTALANDPLINTH",
                new ResearchPage("tc.research_page.ARCANEPEDESTALANDPLINTH.3"));
        TCHelper.addResearchPage(
                "ARCANEPEDESTALANDPLINTH",
                new ResearchPage("tc.research_page.ARCANEPEDESTALANDPLINTH.4"));
        ThaumcraftApi.addWarpToResearch("ARCANEPEDESTALANDPLINTH", 2);
        new ResearchItem(
                "ALCHEMICCALCINATOR",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("vitreus"), 15)
                        .add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("perditio"), 9)
                        .add(Aspect.getAspect("aqua"), 6).add(Aspect.getAspect("ignis"), 3),
                -4,
                -8,
                3,
                getModItem("AWWayofTime", "blockAlchemicCalcinator", 1, 0, missing))
                        .setParents("ARCANEPEDESTALANDPLINTH").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ALCHEMICCALCINATOR")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALCHEMICCALCINATOR",
                getModItem("AWWayofTime", "blockAlchemicCalcinator", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("terra"), 50).add(Aspect.getAspect("aer"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 15, missing),
                'b',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'c',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 15, missing),
                'd',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'e',
                getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 4, missing),
                'f',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'g',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing),
                'h',
                getModItem("witchery", "cauldron", 1, 0, missing),
                'i',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 7, missing));
        TCHelper.addResearchPage(
                "ALCHEMICCALCINATOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem("AWWayofTime", "blockAlchemicCalcinator", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ALCHEMICCALCINATOR", 3);
        new ResearchItem(
                "ALCHEMICTOOLS",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("aer"), 3),
                -4,
                -12,
                3,
                getModItem("AWWayofTime", "itemAttunedCrystal", 1, 0, missing)).setParents("ALCHEMICCALCINATOR")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.ALCHEMICTOOLS.1"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALCHEMICTOOLS",
                getModItem("AWWayofTime", "itemAttunedCrystal", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing),
                'b',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 0, missing),
                'e',
                getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 4, missing),
                'f',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 0, missing),
                'g',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 0, missing),
                'i',
                getModItem("AWWayofTime", "reinforcedSlate", 1, 0, missing));
        TCHelper.addResearchPage(
                "ALCHEMICTOOLS",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "itemAttunedCrystal", 1, 0, missing))));
        TCHelper.addResearchPage("ALCHEMICTOOLS", new ResearchPage("tc.research_page.ALCHEMICTOOLS.2"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALCHEMICTOOLS",
                getModItem("AWWayofTime", "itemDestinationClearer", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aer"), 15)
                        .add(Aspect.getAspect("perditio"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 0, missing),
                'b',
                getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 3, missing),
                'c',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 0, missing),
                'd',
                getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 3, missing),
                'f',
                getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 3, missing),
                'g',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 0, missing),
                'h',
                getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 3, missing),
                'i',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 0, missing));
        TCHelper.addResearchPage(
                "ALCHEMICTOOLS",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "itemDestinationClearer", 1, 0, missing))));
        TCHelper.addResearchPage("ALCHEMICTOOLS", new ResearchPage("tc.research_page.ALCHEMICTOOLS.3"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALCHEMICTOOLS",
                getModItem("AWWayofTime", "itemTankSegmenter", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aer"), 15)
                        .add(Aspect.getAspect("ignis"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("witchery", "chalkheart", 1, 0, missing),
                'b',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 0, missing),
                'c',
                getModItem("AWWayofTime", "mundanePowerCatalyst", 1, 0, missing),
                'e',
                getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 4, missing),
                'f',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 0, missing),
                'g',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 0, missing),
                'i',
                getModItem("witchery", "chalkheart", 1, 0, missing));
        TCHelper.addResearchPage(
                "ALCHEMICTOOLS",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "itemTankSegmenter", 1, 0, missing))));
        new ResearchItem(
                "BELLJAR",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 18).add(Aspect.getAspect("aer"), 15)
                        .add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("ordo"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("arbor"), 3),
                -6,
                -12,
                3,
                getModItem("AWWayofTime", "blockCrystalBelljar", 1, 0, missing)).setParents("ALCHEMICCALCINATOR")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.BELLJAR")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "BELLJAR",
                getModItem("AWWayofTime", "blockCrystalBelljar", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'b',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'c',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'd',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'e',
                getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 4, missing),
                'f',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'g',
                getModItem("minecraft", "wooden_pressure_plate", 1, 0, missing),
                'h',
                getModItem("minecraft", "light_weighted_pressure_plate", 1, 0, missing),
                'i',
                getModItem("minecraft", "wooden_pressure_plate", 1, 0, missing));
        TCHelper.addResearchPage(
                "BELLJAR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "blockCrystalBelljar", 1, 0, missing))));
        new ResearchItem(
                "ALCHEMYRELAY",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("bestia"), 15)
                        .add(Aspect.getAspect("pannus"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("alienis"), 6).add(Aspect.getAspect("potentia"), 3),
                -2,
                -12,
                3,
                getModItem("AWWayofTime", "blockReagentConduit", 1, 0, missing)).setParents("ALCHEMICCALCINATOR")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.ALCHEMYRELAY"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ALCHEMYRELAY",
                getModItem("AWWayofTime", "blockReagentConduit", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 25).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("ignis"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                'b',
                getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                'c',
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                'd',
                getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                'e',
                getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 4, missing),
                'f',
                getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                'g',
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                'h',
                getModItem("BloodArsenal", "blood_burned_string", 1, 0, missing),
                'i',
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing));
        TCHelper.addResearchPage(
                "ALCHEMYRELAY",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "blockReagentConduit", 1, 0, missing))));
        new ResearchItem(
                "CRYSTALCLUSTER",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("victus"), 21).add(Aspect.getAspect("spiritus"), 18)
                        .add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("tenebrae"), 6)
                        .add(Aspect.getAspect("cognitio"), 3),
                -10,
                0,
                3,
                getModItem("AWWayofTime", "blockCrystal", 1, 0, missing)).setParents("INFUSION", "RUNEOFACCELERATION")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.CRYSTALCLUSTER"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CRYSTALCLUSTER",
                getModItem("AWWayofTime", "blockCrystal", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("potentia"), 72).add(Aspect.getAspect("victus"), 64)
                        .add(Aspect.getAspect("spiritus"), 64).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("tenebrae"), 32).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("cognitio"), 16),
                getModItem("BloodArsenal", "blood_stone", 1, 4, missing),
                new ItemStack[] { getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 28, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 29, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 28, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 29, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 28, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 29, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 28, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 29, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 28, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 29, missing), });
        TCHelper.addResearchPage(
                "CRYSTALCLUSTER",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "blockCrystal", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("CRYSTALCLUSTER", 5);
        new ResearchItem(
                "ICHORIUMBLOCK",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("victus"), 21).add(Aspect.getAspect("fames"), 18)
                        .add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("infernus"), 12)
                        .add(Aspect.getAspect("alienis"), 9).add(Aspect.getAspect("superbia"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                -10,
                2,
                3,
                getModItem("gregtech", "gt.blockmetal8", 1, 13, missing)).setParents("INFUSION", "CRYSTALCLUSTER")
                        .setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.ICHORIUMBLOCK.1"),
                                new ResearchPage("tc.research_page.ICHORIUMBLOCK.2"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ICHORIUMBLOCK",
                getModItem("gregtech", "gt.blockmetal8", 1, 13, missing),
                12,
                new AspectList().add(Aspect.getAspect("victus"), 64).add(Aspect.getAspect("fames"), 48)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("infernus"), 24)
                        .add(Aspect.getAspect("alienis"), 16).add(Aspect.getAspect("superbia"), 16)
                        .add(Aspect.getAspect("terra"), 8),
                getModItem("dreamcraft", "tile.Mytryl", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 11978, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 28, missing),
                        getModItem("ThaumicTinkerer", "kamiResource", 1, 0, missing),
                        getModItem("AWWayofTime", "standardBindingAgent", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 11978, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 29, missing),
                        getModItem("ThaumicTinkerer", "kamiResource", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 4, missing), });
        TCHelper.addResearchPage(
                "ICHORIUMBLOCK",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("gregtech", "gt.blockmetal8", 1, 13, missing))));
        ThaumcraftApi.addWarpToResearch("ICHORIUMBLOCK", 3);
        new ResearchItem(
                "GLYPHSTONE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("terra"), 21).add(Aspect.getAspect("superbia"), 18)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("alienis"), 3),
                2,
                -10,
                3,
                getModItem("AWWayofTime", "blockStabilityGlyph", 1, 0, missing))
                        .setParents("INFUSION", "SOULARMORFORGE").setConcealed()
                        .setPages(
                                new ResearchPage("tc.research_page.GLYPHSTONE.1"),
                                new ResearchPage("tc.research_page.GLYPHSTONE.2"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GLYPHSTONE",
                getModItem("AWWayofTime", "blockStabilityGlyph", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("aqua"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("AWWayofTime", "crepitous", 1, 0, missing),
                'b',
                getModItem("AWWayofTime", "magicales", 1, 0, missing),
                'c',
                getModItem("AWWayofTime", "crepitous", 1, 0, missing),
                'd',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 17, missing),
                'e',
                getModItem("BloodArsenal", "blood_stone", 1, 4, missing),
                'f',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 17, missing),
                'g',
                getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 1, missing),
                'h',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 30, missing),
                'i',
                getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 1, missing));
        TCHelper.addResearchPage(
                "GLYPHSTONE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "blockStabilityGlyph", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("GLYPHSTONE", 3);
        TCHelper.addResearchPage("GLYPHSTONE", new ResearchPage("tc.research_page.GLYPHSTONE.2"));
        TCHelper.addResearchPage("GLYPHSTONE", new ResearchPage("tc.research_page.GLYPHSTONE.3"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GLYPHSTONE",
                getModItem("AWWayofTime", "blockEnchantmentGlyph", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("aqua"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 0, missing),
                'b',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 28, missing),
                'c',
                getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 0, missing),
                'd',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 17, missing),
                'e',
                getModItem("BloodArsenal", "blood_stone", 1, 4, missing),
                'f',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 17, missing),
                'g',
                getModItem("AWWayofTime", "magicales", 1, 0, missing),
                'h',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 30, missing),
                'i',
                getModItem("AWWayofTime", "magicales", 1, 0, missing));
        TCHelper.addResearchPage(
                "GLYPHSTONE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "blockEnchantmentGlyph", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GLYPHSTONE",
                getModItem("AWWayofTime", "blockEnchantmentGlyph", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("terra"), 30)
                        .add(Aspect.getAspect("aqua"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("perditio"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 6, missing),
                'b',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 29, missing),
                'c',
                getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 6, missing),
                'd',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 17, missing),
                'e',
                getModItem("BloodArsenal", "blood_stone", 1, 4, missing),
                'f',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 17, missing),
                'g',
                getModItem("AWWayofTime", "magicales", 1, 0, missing),
                'h',
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 30, missing),
                'i',
                getModItem("AWWayofTime", "magicales", 1, 0, missing));
        TCHelper.addResearchPage(
                "GLYPHSTONE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "blockEnchantmentGlyph", 1, 1, missing))));
        new ResearchItem(
                "KEYOFBINDING",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vitreus"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                4,
                -2,
                3,
                getModItem("AWWayofTime", "itemKeyOfDiablo", 1, 0, missing)).setParents("SACRIFICIALKNIFE")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.KEYOFBINDING"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "KEYOFBINDING",
                getModItem("AWWayofTime", "itemKeyOfDiablo", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("ignis"), 15),
                "abc",
                "def",
                "ghi",
                'b',
                "plateRoseGold",
                'c',
                "gemFlawlessDiamond",
                'd',
                getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                'e',
                getModItem("Thaumcraft", "ArcaneDoorKey", 1, 1, missing),
                'f',
                getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                'g',
                "gemFlawlessDiamond",
                'h',
                "plateRoseGold");
        TCHelper.addResearchPage(
                "KEYOFBINDING",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "itemKeyOfDiablo", 1, 0, missing))));
        new ResearchItem(
                "ARMORINHIBITOR",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("spiritus"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                4,
                -8,
                3,
                getModItem("AWWayofTime", "armourInhibitor", 1, 0, missing)).setParents("SOULARMORFORGE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ARMORINHIBITOR")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ARMORINHIBITOR",
                getModItem("AWWayofTime", "armourInhibitor", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("aer"), 30)
                        .add(Aspect.getAspect("aqua"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing),
                'b',
                "plateRoseGold",
                'd',
                "plateRoseGold",
                'e',
                getModItem("AWWayofTime", "imbuedSlate", 1, 0, missing),
                'f',
                "plateRoseGold",
                'h',
                "plateRoseGold",
                'i',
                getModItem("AWWayofTime", "weakBloodShard", 1, 0, missing));
        TCHelper.addResearchPage(
                "ARMORINHIBITOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "armourInhibitor", 1, 0, missing))));
        new ResearchItem(
                "SIGILOFHASTE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("iter"), 21).add(Aspect.getAspect("motus"), 18)
                        .add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("cognitio"), 3),
                -2,
                12,
                3,
                getModItem("AWWayofTime", "sigilOfHaste", 1, 0, missing)).setParents("INFUSION", "AIRSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFHASTE"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFHASTE",
                getModItem("AWWayofTime", "sigilOfHaste", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("iter"), 64).add(Aspect.getAspect("motus"), 32)
                        .add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("alienis"), 8)
                        .add(Aspect.getAspect("cognitio"), 8),
                getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                new ItemStack[] { getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem("minecraft", "cookie", 1, 0, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("minecraft", "sugar", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem("minecraft", "sugar", 1, 0, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("minecraft", "cookie", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFHASTE",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "sigilOfHaste", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SIGILOFHASTE", 3);
        new ResearchItem(
                "SIGILOFWHIRLWIND",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("tutamen"), 21)
                        .add(Aspect.getAspect("potentia"), 18).add(Aspect.getAspect("victus"), 15)
                        .add(Aspect.getAspect("sano"), 12).add(Aspect.getAspect("cognitio"), 9)
                        .add(Aspect.getAspect("superbia"), 6).add(Aspect.getAspect("nebrisum"), 3),
                2,
                12,
                3,
                getModItem("AWWayofTime", "sigilOfWind", 1, 0, missing)).setParents("INFUSION", "AIRSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFWHIRLWIND"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFWHIRLWIND",
                getModItem("AWWayofTime", "sigilOfWind", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("aer"), 72).add(Aspect.getAspect("tutamen"), 48)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("victus"), 32)
                        .add(Aspect.getAspect("sano"), 16).add(Aspect.getAspect("cognitio"), 16)
                        .add(Aspect.getAspect("superbia"), 8).add(Aspect.getAspect("nebrisum"), 8),
                getModItem("AWWayofTime", "airSigil", 1, 0, missing),
                new ItemStack[] { getModItem("TwilightForest", "item.tfFeather", 1, 0, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("EMT", "EMTItems", 1, 7, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("minecraft", "ghast_tear", 1, 0, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("TwilightForest", "item.tfFeather", 1, 0, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing),
                        getModItem("EMT", "EMTItems", 1, 7, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("minecraft", "ghast_tear", 1, 0, missing),
                        getModItem("AWWayofTime", "aether", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFWHIRLWIND",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "sigilOfWind", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SIGILOFWHIRLWIND", 4);
        new ResearchItem(
                "SIGILOFSUPRESSION",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vacuos"), 21).add(Aspect.getAspect("auram"), 18)
                        .add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("motus"), 3),
                -2,
                8,
                3,
                getModItem("AWWayofTime", "sigilOfSupression", 1, 0, missing)).setParents("INFUSION", "VOIDSIGIL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.SIGILOFSUPRESSION"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFSUPRESSION",
                getModItem("AWWayofTime", "sigilOfSupression", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("vacuos"), 72).add(Aspect.getAspect("auram"), 16)
                        .add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("metallum"), 8)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("terra"), 32)
                        .add(Aspect.getAspect("motus"), 16),
                getModItem("AWWayofTime", "voidSigil", 1, 0, missing),
                new ItemStack[] { getModItem("AWWayofTime", "blockTeleposer", 1, 0, missing),
                        getModItem("minecraft", "bucket", 1, 0, missing),
                        getModItem("AWWayofTime", "tennebrae", 1, 0, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("minecraft", "bucket", 1, 0, missing),
                        getModItem("AWWayofTime", "tennebrae", 1, 0, missing),
                        getModItem("minecraft", "bucket", 1, 0, missing),
                        getModItem("AWWayofTime", "tennebrae", 1, 0, missing),
                        getModItem("minecraft", "bucket", 1, 0, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("AWWayofTime", "tennebrae", 1, 0, missing),
                        getModItem("minecraft", "bucket", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFSUPRESSION",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "sigilOfSupression", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SIGILOFSUPRESSION", 5);
        new ResearchItem(
                "SIGILOFENDERSEVERANCE",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("alienis"), 21).add(Aspect.getAspect("cognitio"), 18)
                        .add(Aspect.getAspect("humanus"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("vinculum"), 9).add(Aspect.getAspect("limus"), 6)
                        .add(Aspect.getAspect("nebrisum"), 3),
                0,
                14,
                3,
                getModItem("AWWayofTime", "sigilOfEnderSeverance", 1, 0, missing))
                        .setParents("INFUSION", "SIGILOFELEMENTALAFFINITY", "OCULUS").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SIGILOFENDERSEVERANCE")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFENDERSEVERANCE",
                getModItem("AWWayofTime", "sigilOfEnderSeverance", 1, 0, missing),
                17,
                new AspectList().add(Aspect.getAspect("alienis"), 16).add(Aspect.getAspect("cognitio"), 72)
                        .add(Aspect.getAspect("humanus"), 16).add(Aspect.getAspect("potentia"), 64)
                        .add(Aspect.getAspect("vinculum"), 48).add(Aspect.getAspect("limus"), 32)
                        .add(Aspect.getAspect("nebrisum"), 8),
                getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 27, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemEldritchObject", 1, 0, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("StevesCarts", "ModuleComponents", 1, 45, missing),
                        getModItem("TConstruct", "slime.gel", 1, 2, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32724, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 7, missing),
                        getModItem("TConstruct", "slime.gel", 1, 2, missing),
                        getModItem("StevesCarts", "ModuleComponents", 1, 45, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFENDERSEVERANCE",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem("AWWayofTime", "sigilOfEnderSeverance", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SIGILOFENDERSEVERANCE", 6);
        new ResearchItem(
                "ENDERSIGIL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("vacuos"), 24).add(Aspect.getAspect("alienis"), 21)
                        .add(Aspect.getAspect("cognitio"), 18).add(Aspect.getAspect("humanus"), 15)
                        .add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("vinculum"), 9)
                        .add(Aspect.getAspect("limus"), 6).add(Aspect.getAspect("nebrisum"), 3),
                -2,
                16,
                3,
                getModItem("BloodArsenal", "sigil_of_ender", 1, 0, missing))
                        .setParents("INFUSION", "SIGILOFENDERSEVERANCE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ENDERSIGIL")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ENDERSIGIL",
                getModItem("BloodArsenal", "sigil_of_ender", 1, 0, missing),
                20,
                new AspectList().add(Aspect.getAspect("vacuos"), 16).add(Aspect.getAspect("alienis"), 16)
                        .add(Aspect.getAspect("cognitio"), 72).add(Aspect.getAspect("humanus"), 16)
                        .add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("vinculum"), 48)
                        .add(Aspect.getAspect("limus"), 32).add(Aspect.getAspect("nebrisum"), 8),
                getModItem("AWWayofTime", "sigilOfEnderSeverance", 1, 0, missing),
                new ItemStack[] { getModItem("EnderStorage", "enderChest", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32726, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17770, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32724, missing),
                        getModItem("minecraft", "ender_eye", 1, 0, missing),
                        getModItem("minecraft", "ender_eye", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32724, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17770, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32726, missing), });
        TCHelper.addResearchPage(
                "ENDERSIGIL",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("BloodArsenal", "sigil_of_ender", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ENDERSIGIL", 8);
        new ResearchItem(
                "SIGILOFDIVINITY",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("tutamen"), 24).add(Aspect.getAspect("aer"), 21)
                        .add(Aspect.getAspect("ignis"), 18).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("terra"), 12).add(Aspect.getAspect("ordo"), 9)
                        .add(Aspect.getAspect("perditio"), 6).add(Aspect.getAspect("sano"), 3),
                2,
                16,
                3,
                getModItem("BloodArsenal", "sigil_of_divinity", 1, 0, missing))
                        .setParents("INFUSION", "SIGILOFENDERSEVERANCE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SIGILOFDIVINITY")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFDIVINITY",
                getModItem("BloodArsenal", "sigil_of_divinity", 1, 0, missing),
                25,
                new AspectList().add(Aspect.getAspect("tutamen"), 64).add(Aspect.getAspect("aer"), 72)
                        .add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("aqua"), 48)
                        .add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("ordo"), 32)
                        .add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("sano"), 8),
                getModItem("AWWayofTime", "sigilOfElementalAffinity", 1, 0, missing),
                new ItemStack[] { getModItem("BloodArsenal", "blood_stone", 1, 4, missing),
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_diamond_block", 1, 0, missing),
                        getModItem("TConstruct", "diamondApple", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_glowstone", 1, 0, missing),
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32726, missing),
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_glowstone", 1, 0, missing),
                        getModItem("TConstruct", "diamondApple", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_diamond_block", 1, 0, missing),
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SIGILOFDIVINITY",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("BloodArsenal", "sigil_of_divinity", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SIGILOFDIVINITY", 10);
        new ResearchItem(
                "HARVESTGODDESSSIGIL",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("herba"), 21).add(Aspect.getAspect("arbor"), 18)
                        .add(Aspect.getAspect("meto"), 15).add(Aspect.getAspect("messis"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("alienis"), 3),
                0,
                16,
                3,
                getModItem("AWWayofTime", "itemHarvestSigil", 1, 0, missing))
                        .setParents("INFUSION", "SIGILOFENDERSEVERANCE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.HARVESTGODDESSSIGIL")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "HARVESTGODDESSSIGIL",
                getModItem("AWWayofTime", "itemHarvestSigil", 1, 0, missing),
                20,
                new AspectList().add(Aspect.getAspect("herba"), 72).add(Aspect.getAspect("arbor"), 64)
                        .add(Aspect.getAspect("meto"), 8).add(Aspect.getAspect("messis"), 16)
                        .add(Aspect.getAspect("cognitio"), 24).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("alienis"), 16),
                getModItem("AWWayofTime", "growthSigil", 1, 0, missing),
                new ItemStack[] { getModItem("BloodArsenal", "bound_sickle", 1, 0, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 2, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 27, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 2, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 8, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseItems", 1, 27, missing),
                        getModItem("AWWayofTime", "bloodMagicBaseAlchemyItems", 1, 2, missing), });
        TCHelper.addResearchPage(
                "HARVESTGODDESSSIGIL",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "itemHarvestSigil", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("HARVESTGODDESSSIGIL", 7);
        new ResearchItem(
                "SIGILOFCOMPRESSION",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("superbia"), 3),
                2,
                8,
                3,
                getModItem("AWWayofTime", "itemCompressionSigil", 1, 0, missing))
                        .setParents("INFUSION", "SIGILOFMAGNETISM").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.SIGILOFCOMPRESSION")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SIGILOFCOMPRESSION",
                getModItem("AWWayofTime", "itemCompressionSigil", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("metallum"), 32).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("machina"), 16).add(Aspect.getAspect("lucrum"), 16)
                        .add(Aspect.getAspect("superbia"), 8),
                getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                new ItemStack[] { getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32644, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32604, missing),
                        getModItem("AWWayofTime", "demonicSlate", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32604, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32744, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32644, missing), });
        TCHelper.addResearchPage(
                "SIGILOFCOMPRESSION",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("AWWayofTime", "itemCompressionSigil", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("SIGILOFCOMPRESSION", 2);
        new ResearchItem(
                "ENERGYBAZOOKAI",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("potentia"), 21).add(Aspect.getAspect("instrumentum"), 18)
                        .add(Aspect.getAspect("telum"), 15).add(Aspect.getAspect("superbia"), 12)
                        .add(Aspect.getAspect("fames"), 9).add(Aspect.getAspect("nebrisum"), 6)
                        .add(Aspect.getAspect("ira"), 3),
                -12,
                0,
                3,
                getModItem("AWWayofTime", "energyBazooka", 1, 0, missing))
                        .setParents("CRYSTALCLUSTER", "ICHOR_SWORD_GEM", "PRIMALCRUSHER").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ENERGYBAZOOKAI")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ENERGYBAZOOKAI",
                getModItem("AWWayofTime", "energyBazooka", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 150).add(Aspect.getAspect("ignis"), 150)
                        .add(Aspect.getAspect("terra"), 150).add(Aspect.getAspect("aer"), 150)
                        .add(Aspect.getAspect("perditio"), 150).add(Aspect.getAspect("ordo"), 150),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 11978, missing),
                'b',
                getModItem("Thaumcraft", "ItemEldritchObject", 1, 3, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 11978, missing),
                'd',
                getModItem("BloodArsenal", "blood_infused_diamond_block", 1, 0, missing),
                'e',
                getModItem("AWWayofTime", "energyBlasterThirdTier", 1, 0, missing),
                'f',
                getModItem("BloodArsenal", "blood_infused_diamond_block", 1, 0, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 11978, missing),
                'h',
                getModItem("AWWayofTime", "demonicTelepositionFocus", 1, 0, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 11978, missing));
        TCHelper.addResearchPage(
                "ENERGYBAZOOKAI",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("AWWayofTime", "energyBazooka", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ENERGYBAZOOKAI", 5);
        new ResearchItem(
                "ENERGYBAZOOKAII",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("potentia"), 24).add(Aspect.getAspect("instrumentum"), 21)
                        .add(Aspect.getAspect("telum"), 18).add(Aspect.getAspect("infernus"), 15)
                        .add(Aspect.getAspect("superbia"), 12).add(Aspect.getAspect("fames"), 9)
                        .add(Aspect.getAspect("nebrisum"), 6).add(Aspect.getAspect("ira"), 3),
                -14,
                0,
                3,
                getModItem("AWWayofTime", "energyBazookaSecondTier", 1, 0, missing))
                        .setParents("INFUSION", "ENERGYBAZOOKAI").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ENERGYBAZOOKAII")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ENERGYBAZOOKAII",
                getModItem("AWWayofTime", "energyBazookaSecondTier", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("potentia"), 96).add(Aspect.getAspect("instrumentum"), 72)
                        .add(Aspect.getAspect("telum"), 64).add(Aspect.getAspect("infernus"), 64)
                        .add(Aspect.getAspect("superbia"), 32).add(Aspect.getAspect("fames"), 32)
                        .add(Aspect.getAspect("nebrisum"), 16).add(Aspect.getAspect("ira"), 8),
                getModItem("AWWayofTime", "energyBazooka", 1, 0, missing),
                new ItemStack[] { getModItem("DraconicEvolution", "draconium", 1, 2, missing),
                        getModItem("DraconicEvolution", "draconicCore", 1, 0, missing),
                        getModItem("AWWayofTime", "dawnScribeTool", 1, 0, missing),
                        getModItem("DraconicEvolution", "wyvernCore", 1, 0, missing),
                        getModItem("AWWayofTime", "duskScribeTool", 1, 0, missing),
                        getModItem("DraconicEvolution", "draconium", 1, 2, missing),
                        getModItem("AWWayofTime", "duskScribeTool", 1, 0, missing),
                        getModItem("DraconicEvolution", "draconicCore", 1, 0, missing),
                        getModItem("AWWayofTime", "dawnScribeTool", 1, 0, missing),
                        getModItem("DraconicEvolution", "wyvernCore", 1, 0, missing), });
        TCHelper.addResearchPage(
                "ENERGYBAZOOKAII",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem("AWWayofTime", "energyBazookaSecondTier", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ENERGYBAZOOKAII", 10);
        new ResearchItem(
                "ENERGYBAZOOKAIII",
                "BLOODMAGIC",
                new AspectList().add(Aspect.getAspect("potentia"), 27).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("telum"), 21).add(Aspect.getAspect("terminus"), 18)
                        .add(Aspect.getAspect("infernus"), 15).add(Aspect.getAspect("superbia"), 12)
                        .add(Aspect.getAspect("fames"), 9).add(Aspect.getAspect("nebrisum"), 6)
                        .add(Aspect.getAspect("ira"), 3),
                -16,
                0,
                3,
                getModItem("AWWayofTime", "energyBazookaThirdTier", 1, 0, missing))
                        .setParents("INFUSION", "ENERGYBAZOOKAII").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ENERGYBAZOOKAIII")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ENERGYBAZOOKAIII",
                getModItem("AWWayofTime", "energyBazookaThirdTier", 1, 0, missing),
                20,
                new AspectList().add(Aspect.getAspect("potentia"), 128).add(Aspect.getAspect("instrumentum"), 96)
                        .add(Aspect.getAspect("telum"), 72).add(Aspect.getAspect("terminus"), 64)
                        .add(Aspect.getAspect("infernus"), 72).add(Aspect.getAspect("superbia"), 48)
                        .add(Aspect.getAspect("fames"), 32).add(Aspect.getAspect("nebrisum"), 16)
                        .add(Aspect.getAspect("ira"), 8),
                getModItem("AWWayofTime", "energyBazookaSecondTier", 1, 0, missing),
                new ItemStack[] { getModItem("Avaritia", "big_pearl", 1, 0, missing),
                        getModItem("Avaritia", "Resource", 1, 6, missing),
                        getModItem("DraconicEvolution", "awakenedCore", 1, 0, missing),
                        getModItem("Avaritia", "Resource_Block", 1, 0, missing),
                        getModItem("Avaritia", "Resource", 1, 6, missing),
                        getModItem("Avaritia", "Resource", 1, 6, missing),
                        getModItem("Avaritia", "Resource_Block", 1, 0, missing),
                        getModItem("DraconicEvolution", "chaoticCore", 1, 0, missing),
                        getModItem("Avaritia", "Resource", 1, 6, missing), });
        TCHelper.addResearchPage(
                "ENERGYBAZOOKAIII",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem("AWWayofTime", "energyBazookaThirdTier", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ENERGYBAZOOKAIII", 20);
        TCHelper.clearPages("CAP_blood_iron");
        TCHelper.addResearchPage("CAP_blood_iron", new ResearchPage("blood_arsenal.research_page.CAP_blood_iron.1"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CAP_blood_iron",
                getModItem("BloodArsenal", "wand_caps", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("victus"), 24).add(Aspect.getAspect("metallum"), 16)
                        .add(Aspect.getAspect("ignis"), 8),
                getModItem("ForbiddenMagic", "WandCaps", 1, 0, missing),
                new ItemStack[] { getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17977, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28977, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17977, missing),
                        getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17977, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28977, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17977, missing),
                        getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing), });
        TCHelper.addResearchPage(
                "CAP_blood_iron",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("BloodArsenal", "wand_caps", 1, 0, missing))));
        TCHelper.setResearchAspects(
                "CAP_blood_iron",
                new AspectList().add(Aspect.getAspect("victus"), 18).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("tenebrae"), 12)
                        .add(Aspect.getAspect("metallum"), 6));
        TCHelper.setResearchComplexity("CAP_blood_iron", 3);
        ThaumcraftApi.addWarpToResearch("CAP_blood_iron", 3);
        TCHelper.clearPages("ROD_blood_wood");
        TCHelper.addResearchPage("ROD_blood_wood", new ResearchPage("blood_arsenal.research_page.ROD_blood_wood.1"));
        TCHelper.addResearchPage("ROD_blood_wood", new ResearchPage("blood_arsenal.research_page.ROD_blood_wood.2"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_blood_wood",
                getModItem("BloodArsenal", "wand_cores", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("instrumentum"), 24)
                        .add(Aspect.getAspect("victus"), 32).add(Aspect.getAspect("arbor"), 16)
                        .add(Aspect.getAspect("potentia"), 8),
                getModItem("ForbiddenMagic", "WandCores", 1, 3, missing),
                new ItemStack[] { getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing), });
        TCHelper.addResearchPage(
                "ROD_blood_wood",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("BloodArsenal", "wand_cores", 1, 0, missing))));
        TCHelper.setResearchAspects(
                "ROD_blood_wood",
                new AspectList().add(Aspect.getAspect("victus"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("aqua"), 12).add(Aspect.getAspect("tenebrae"), 9)
                        .add(Aspect.getAspect("instrumentum"), 6).add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("ROD_blood_wood", 3);
        ThaumcraftApi.addWarpToResearch("ROD_blood_wood", 5);
        TCHelper.orphanResearch("ROD_blood_wood_staff");
        TCHelper.removeResearch("ROD_blood_wood_staff");
        new ResearchItem(
                "RODBLOODWOODSTAFF",
                "FORBIDDEN",
                new AspectList().add(Aspect.getAspect("victus"), 18).add(Aspect.getAspect("instrumentum"), 15)
                        .add(Aspect.getAspect("aqua"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("tenebrae"), 3),
                7,
                -5,
                3,
                getModItem("BloodArsenal", "wand_cores", 1, 1, missing)).setParents("ROD_blood_staff", "ROD_blood_wood")
                        .setConcealed().setSpecial()
                        .setPages(new ResearchPage("blood_arsenal.research_page.ROD_blood_wood_staff.1"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "RODBLOODWOODSTAFF",
                getModItem("BloodArsenal", "wand_cores", 1, 1, missing),
                12,
                new AspectList().add(Aspect.getAspect("victus"), 64).add(Aspect.getAspect("aqua"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("instrumentum"), 48)
                        .add(Aspect.getAspect("metallum"), 16).add(Aspect.getAspect("ignis"), 16)
                        .add(Aspect.getAspect("infernus"), 8).add(Aspect.getAspect("arbor"), 32),
                getModItem("ForbiddenMagic", "WandCores", 1, 9, missing),
                new ItemStack[] { getModItem("BloodArsenal", "wand_cores", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        getModItem("BloodArsenal", "wand_cores", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_wood", 1, 0, missing),
                        getModItem("BloodArsenal", "amorphic_catalyst", 1, 0, missing),
                        getModItem("BloodArsenal", "blood_infused_glowstone_dust", 1, 0, missing), });
        TCHelper.addResearchPage(
                "RODBLOODWOODSTAFF",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("BloodArsenal", "wand_cores", 1, 1, missing))));
        ThaumcraftApi.addWarpToResearch("RODBLOODWOODSTAFF", 7);
        TCHelper.refreshResearchPages("CAP_blood_iron");
        TCHelper.refreshResearchPages("ROD_blood_wood");
    }
}
