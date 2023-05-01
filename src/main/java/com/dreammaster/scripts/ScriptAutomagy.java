package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AppliedEnergistics2;
import static gregtech.api.enums.Mods.Automagy;
import static gregtech.api.enums.Mods.Genetics;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;

import com.dreammaster.thaumcraft.TCHelper;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptAutomagy implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Automagy";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Thaumcraft.ID, Automagy.ID, Genetics.ID, AppliedEnergistics2.ID, ProjectRedIntegration.ID);
    }

    @Override
    public void loadRecipes() {
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "blockTorchInversion", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(Automagy.ID, "blockRedcrystal", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "blockRedcrystalAmp", 2, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "blockRedcrystalDense", 2, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "blockRedcrystalDim", 2, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "blockHourglassMagic", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "shardSliver", 4, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "shardSliver", 4, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "shardSliver", 4, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "shardSliver", 4, 3, missing));
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "shardSliver", 4, 4, missing));
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "shardSliver", 4, 5, missing));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemShard", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemShard", 1, 4, missing));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemShard", 1, 5, missing));
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "blockTranslucent", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "blockTranslucent", 1, 1, missing));
        TCHelper.removeInfusionEnchantmentRecipe(61);
        TCHelper.removeInfusionEnchantmentRecipe(62);
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "blockRemoteComparator", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(Automagy.ID, "crystalEye", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "blockRedcrystalRes", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "blockRedcrystalMerc", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Automagy.ID, "focusCrafting", 1, 0, missing));
        TCHelper.clearPages("REDSTONETHEORY");
        TCHelper.addResearchPage("REDSTONETHEORY", new ResearchPage("Automagy.research_page.REDSTONETHEORY.1"));
        TCHelper.addResearchPage("REDSTONETHEORY", new ResearchPage("Automagy.research_page.REDSTONETHEORY.2"));
        TCHelper.addResearchPage("REDSTONETHEORY", new ResearchPage("Automagy.research_page.REDSTONETHEORY.3"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REDSTONETHEORY",
                getModItem(Automagy.ID, "blockTorchInversion", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Automagy.ID, "shardSliver", 1, 4, missing),
                'd',
                getModItem(Automagy.ID, "shardSliver", 1, 4, missing),
                'e',
                getModItem(Minecraft.ID, "redstone_torch", 1, 0, missing),
                'f',
                getModItem(Automagy.ID, "shardSliver", 1, 4, missing),
                'h',
                getModItem(Automagy.ID, "shardSliver", 1, 4, missing));
        TCHelper.addResearchPage(
                "REDSTONETHEORY",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(Automagy.ID, "blockTorchInversion", 1, 0, missing))));
        TCHelper.addResearchPage("REDSTONETHEORY", new ResearchPage("Automagy.research_page.REDSTONETHEORY.4"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REDSTONETHEORY",
                getModItem(Automagy.ID, "blockHourglass", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "ringGold",
                'b',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing),
                'c',
                "screwGold",
                'd',
                getModItem(Genetics.ID, "misc", 1, 8, missing),
                'e',
                "dustQuartzSand",
                'f',
                getModItem(Genetics.ID, "misc", 1, 8, missing),
                'g',
                "screwGold",
                'h',
                getModItem(GregTech.ID, "gt.metaitem.02", 1, 32470, missing),
                'i',
                "ringGold");
        TCHelper.addResearchPage(
                "REDSTONETHEORY",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Automagy.ID, "blockHourglass", 1, 0, missing))));
        TCHelper.addResearchPage("REDSTONETHEORY", new ResearchPage("Automagy.research_page.REDSTONETHEORY.5"));
        TCHelper.setResearchAspects(
                "REDCRYSTAL",
                new AspectList().add(Aspect.getAspect("machina"), 2).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("vitreus"), 12));
        TCHelper.setResearchComplexity("REDCRYSTAL", 3);
        ThaumcraftApi.addCrucibleRecipe(
                "REDCRYSTAL",
                getModItem(Automagy.ID, "blockRedcrystal", 9, 0, missing),
                getModItem(Minecraft.ID, "redstone_block", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("machina"), 3).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("vitreus"), 18));
        TCHelper.setResearchAspects(
                "REDCRYSTAL",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("machina"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("vitreus"), 6)
                        .add(Aspect.getAspect("ignis"), 3));
        TCHelper.setResearchComplexity("REDCRYSTAL", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REDCRYSTAL_AMP",
                getModItem(Automagy.ID, "blockRedcrystalAmp", 2, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Automagy.ID, "shardSliver", 1, 1, missing),
                'b',
                getModItem(Automagy.ID, "shardSliver", 1, 1, missing),
                'c',
                getModItem(Automagy.ID, "shardSliver", 1, 1, missing),
                'd',
                getModItem(Automagy.ID, "shardSliver", 1, 1, missing),
                'e',
                getModItem(Automagy.ID, "blockRedcrystal", 1, 0, missing),
                'f',
                getModItem(Automagy.ID, "shardSliver", 1, 1, missing),
                'g',
                getModItem(Automagy.ID, "shardSliver", 1, 1, missing),
                'h',
                getModItem(Automagy.ID, "shardSliver", 1, 1, missing),
                'i',
                getModItem(Automagy.ID, "shardSliver", 1, 1, missing));
        TCHelper.setResearchAspects(
                "REDCRYSTAL",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("machina"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("vitreus"), 6)
                        .add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("REDCRYSTAL", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REDCRYSTAL_AMP",
                getModItem(Automagy.ID, "blockRedcrystalDense", 2, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Automagy.ID, "blockRedcrystal", 1, 0, missing),
                'c',
                getModItem(Automagy.ID, "blockRedcrystal", 1, 0, missing),
                'd',
                getModItem(Automagy.ID, "shardSliver", 1, 3, missing),
                'e',
                "stickInfusedEarth",
                'f',
                getModItem(Automagy.ID, "shardSliver", 1, 3, missing),
                'g',
                getModItem(Automagy.ID, "blockRedcrystal", 1, 0, missing),
                'i',
                getModItem(Automagy.ID, "blockRedcrystal", 1, 0, missing));
        TCHelper.setResearchAspects(
                "REDCRYSTAL",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("machina"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("vitreus"), 6)
                        .add(Aspect.getAspect("perditio"), 3));
        TCHelper.setResearchComplexity("REDCRYSTAL", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REDCRYSTAL_AMP",
                getModItem(Automagy.ID, "blockRedcrystalDim", 2, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Automagy.ID, "shardSliver", 1, 5, missing),
                'b',
                getModItem(Automagy.ID, "shardSliver", 1, 5, missing),
                'c',
                getModItem(Automagy.ID, "shardSliver", 1, 5, missing),
                'd',
                getModItem(Automagy.ID, "shardSliver", 1, 5, missing),
                'e',
                getModItem(Automagy.ID, "blockRedcrystal", 1, 0, missing),
                'f',
                getModItem(Automagy.ID, "shardSliver", 1, 5, missing),
                'g',
                getModItem(Automagy.ID, "shardSliver", 1, 5, missing),
                'h',
                getModItem(Automagy.ID, "shardSliver", 1, 5, missing),
                'i',
                getModItem(Automagy.ID, "shardSliver", 1, 5, missing));
        TCHelper.clearPages("SLIVERS");
        TCHelper.addResearchPage("SLIVERS", new ResearchPage("Automagy.research_page.SLIVERS.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem(Automagy.ID, "shardSliver", 4, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("aer"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                "craftingToolHardHammer",
                'e',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 0, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Automagy.ID, "shardSliver", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem(Automagy.ID, "shardSliver", 4, 1, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("ignis"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                "craftingToolHardHammer",
                'e',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Automagy.ID, "shardSliver", 1, 1, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem(Automagy.ID, "shardSliver", 4, 2, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("aqua"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                "craftingToolHardHammer",
                'e',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Automagy.ID, "shardSliver", 1, 2, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem(Automagy.ID, "shardSliver", 4, 3, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                "craftingToolHardHammer",
                'e',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Automagy.ID, "shardSliver", 1, 3, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem(Automagy.ID, "shardSliver", 4, 4, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                "craftingToolHardHammer",
                'e',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 4, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Automagy.ID, "shardSliver", 1, 4, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem(Automagy.ID, "shardSliver", 4, 5, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                "craftingToolHardHammer",
                'e',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 5, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Automagy.ID, "shardSliver", 1, 5, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem(Thaumcraft.ID, "ItemShard", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("aer"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Automagy.ID, "shardSliver", 1, 0, missing),
                'd',
                getModItem(Automagy.ID, "shardSliver", 1, 0, missing),
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'f',
                getModItem(Automagy.ID, "shardSliver", 1, 0, missing),
                'h',
                getModItem(Automagy.ID, "shardSliver", 1, 0, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemShard", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("ignis"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Automagy.ID, "shardSliver", 1, 1, missing),
                'd',
                getModItem(Automagy.ID, "shardSliver", 1, 1, missing),
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'f',
                getModItem(Automagy.ID, "shardSliver", 1, 1, missing),
                'h',
                getModItem(Automagy.ID, "shardSliver", 1, 1, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemShard", 1, 1, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("aqua"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Automagy.ID, "shardSliver", 1, 2, missing),
                'd',
                getModItem(Automagy.ID, "shardSliver", 1, 2, missing),
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'f',
                getModItem(Automagy.ID, "shardSliver", 1, 2, missing),
                'h',
                getModItem(Automagy.ID, "shardSliver", 1, 2, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemShard", 1, 2, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Automagy.ID, "shardSliver", 1, 3, missing),
                'd',
                getModItem(Automagy.ID, "shardSliver", 1, 3, missing),
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'f',
                getModItem(Automagy.ID, "shardSliver", 1, 3, missing),
                'h',
                getModItem(Automagy.ID, "shardSliver", 1, 3, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemShard", 1, 3, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem(Thaumcraft.ID, "ItemShard", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Automagy.ID, "shardSliver", 1, 4, missing),
                'd',
                getModItem(Automagy.ID, "shardSliver", 1, 4, missing),
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'f',
                getModItem(Automagy.ID, "shardSliver", 1, 4, missing),
                'h',
                getModItem(Automagy.ID, "shardSliver", 1, 4, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemShard", 1, 4, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem(Thaumcraft.ID, "ItemShard", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Automagy.ID, "shardSliver", 1, 5, missing),
                'd',
                getModItem(Automagy.ID, "shardSliver", 1, 5, missing),
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'f',
                getModItem(Automagy.ID, "shardSliver", 1, 5, missing),
                'h',
                getModItem(Automagy.ID, "shardSliver", 1, 5, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemShard", 1, 5, missing))));
        TCHelper.orphanResearch("SLIVERS_TRAVEL");
        TCHelper.removeResearch("SLIVERS_TRAVEL");
        TCHelper.orphanResearch("SLIVERS_WARDING");
        TCHelper.removeResearch("SLIVERS_WARDING");
        TCHelper.setResearchAspects(
                "REMOTECOMPARATOR",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("machina"), 12)
                        .add(Aspect.getAspect("sensus"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("REMOTECOMPARATOR", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REMOTECOMPARATOR",
                getModItem(Automagy.ID, "blockRemoteComparator", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("perditio"), 15),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing),
                'd',
                getModItem(Automagy.ID, "blockRedcrystal", 1, 0, missing),
                'e',
                getModItem(Automagy.ID, "blockRedcrystal", 1, 0, missing),
                'f',
                getModItem(Automagy.ID, "blockRedcrystal", 1, 0, missing),
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing),
                'h',
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 26, missing),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing));
        ThaumcraftApi.addCrucibleRecipe(
                "REMOTECOMPARATOR",
                getModItem(Automagy.ID, "crystalEye", 1, 0, missing),
                getModItem(Minecraft.ID, "spider_eye", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("vitreus"), 15).add(Aspect.getAspect("sensus"), 10)
                        .add(Aspect.getAspect("praecantatio"), 5));
        TCHelper.setResearchAspects(
                "REDCRYSTAL_RES",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("machina"), 12)
                        .add(Aspect.getAspect("vitreus"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("REDCRYSTAL_RES", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REDCRYSTAL_RES",
                getModItem(Automagy.ID, "blockRedcrystalRes", 2, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Automagy.ID, "shardSliver", 1, 0, missing),
                'b',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 11, missing),
                'c',
                getModItem(Automagy.ID, "shardSliver", 1, 0, missing),
                'd',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 11, missing),
                'e',
                getModItem(Automagy.ID, "blockRedcrystal", 1, 0, missing),
                'f',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 11, missing),
                'g',
                getModItem(Automagy.ID, "shardSliver", 1, 0, missing),
                'h',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 11, missing),
                'i',
                getModItem(Automagy.ID, "shardSliver", 1, 0, missing));
        TCHelper.setResearchAspects(
                "REDCRYSTAL_MIRRORBOUND",
                new AspectList().add(Aspect.getAspect("iter"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("REDCRYSTAL_MIRRORBOUND", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REDCRYSTAL_MIRRORBOUND",
                getModItem(Automagy.ID, "blockRedcrystalMerc", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("aer"), 20)
                        .add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("terra"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Automagy.ID, "blockRedcrystal", 1, 0, missing),
                'b',
                getModItem(Automagy.ID, "blockRedcrystalRes", 1, 0, missing),
                'c',
                getModItem(Automagy.ID, "blockRedcrystal", 1, 0, missing),
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 10, missing),
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing),
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 10, missing),
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing),
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 10, missing),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 6, missing));
        TCHelper.setResearchAspects(
                "FOCUSCRAFTING",
                new AspectList().add(Aspect.getAspect("fabrico"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("terra"), 6));
        TCHelper.setResearchComplexity("FOCUSCRAFTING", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUSCRAFTING",
                getModItem(Automagy.ID, "focusCrafting", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("terra"), 40)
                        .add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("aer"), 20)
                        .add(Aspect.getAspect("aqua"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing),
                'b',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6, missing),
                'c',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing),
                'd',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 11, missing),
                'e',
                getModItem(Thaumcraft.ID, "blockTable", 1, 15, missing),
                'f',
                getModItem(AppliedEnergistics2.ID, "item.ItemMultiMaterial", 1, 11, missing),
                'g',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing),
                'h',
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6, missing),
                'i',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing));
        new ResearchItem(
                "InfusedGoldGTNH",
                "AUTOMAGY",
                new AspectList().add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("metallum"), 3),
                -5,
                -2,
                3,
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11323, missing))
                        .setPages(new ResearchPage("tc.research_page.InfusedGoldGTNH.1"))
                        .setParents("INFUSION", "THAUMIUM").registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "InfusedGoldGTNH",
                getModItem(GregTech.ID, "gt.metaitem.01", 1, 11323, missing),
                2,
                new AspectList().add(Aspect.getAspect("lucrum"), 16).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("ordo"), 8).add(Aspect.getAspect("praecantatio"), 4)
                        .add(Aspect.getAspect("aer"), 4),
                getModItem(Minecraft.ID, "gold_ingot", 1, 0, missing),
                new ItemStack[] { getModItem(GregTech.ID, "gt.metaitem.01", 1, 2330, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2330, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2330, missing),
                        getModItem(GregTech.ID, "gt.metaitem.01", 1, 2330, missing), });
        TCHelper.addResearchPage(
                "InfusedGoldGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(GregTech.ID, "gt.metaitem.01", 1, 11323, missing))));
        TCHelper.clearPrereq("MAGICHOURGLASS");
        TCHelper.addResearchPrereq("MAGICHOURGLASS", "INFUSION", false);
        TCHelper.addResearchPrereq("MAGICHOURGLASS", "InfusedGoldGTNH", false);
        TCHelper.addResearchPrereq("MAGICHOURGLASS", "REDCRYSTAL", false);
        TCHelper.setResearchAspects(
                "MAGICHOURGLASS",
                new AspectList().add(Aspect.getAspect("machina"), 15).add(Aspect.getAspect("motus"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("MAGICHOURGLASS", 4);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MAGICHOURGLASS",
                getModItem(Automagy.ID, "blockHourglassMagic", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 15)
                        .add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "screwInfusedGold",
                'b',
                getModItem(Automagy.ID, "blockRedcrystal", 1, 0, missing),
                'c',
                "screwInfusedGold",
                'd',
                getModItem(Automagy.ID, "shardSliver", 1, 0, missing),
                'e',
                getModItem(Automagy.ID, "blockHourglass", 1, 0, missing),
                'f',
                getModItem(Automagy.ID, "shardSliver", 1, 4, missing),
                'g',
                "plateInfusedGold",
                'h',
                getModItem(Minecraft.ID, "light_weighted_pressure_plate", 1, 0, missing),
                'i',
                "plateInfusedGold");
        TCHelper.clearPages("NITORLIGHT");
        TCHelper.addResearchPage("NITORLIGHT", new ResearchPage("Automagy.research_page.REDSTONETHEORY.1"));
        TCHelper.setResearchAspects(
                "NITORLIGHT",
                new AspectList().add(Aspect.getAspect("lux"), 12).add(Aspect.getAspect("ignis"), 9)
                        .add(Aspect.getAspect("aer"), 6));
        TCHelper.setResearchComplexity("NITORLIGHT", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "NITORLIGHT",
                getModItem(Automagy.ID, "blockTranslucent", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 10).add(Aspect.getAspect("aqua"), 5)
                        .add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                "plateAmber",
                'd',
                "plateAmber",
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                'f',
                "plateAmber",
                'h',
                "plateAmber");
        TCHelper.addResearchPage(
                "NITORLIGHT",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(Automagy.ID, "blockTranslucent", 1, 0, missing))));
        TCHelper.clearPages("ENCHANT_FISHING");
        TCHelper.addResearchPage("ENCHANT_FISHING", new ResearchPage("Automagy.research_page.ENCHANT_FISHING.1"));
        ThaumcraftApi.addInfusionEnchantmentRecipe(
                "ENCHANT_FISHING",
                Enchantment.enchantmentsList[61],
                3,
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("bestia"), 15)
                        .add(Aspect.getAspect("fames"), 10).add(Aspect.getAspect("meto"), 15)
                        .add(Aspect.getAspect("praecantatio"), 10),
                new ItemStack[] { getModItem(Minecraft.ID, "carrot_on_a_stick", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(Minecraft.ID, "sugar", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing), });
        ThaumcraftApi.addInfusionEnchantmentRecipe(
                "ENCHANT_FISHING",
                Enchantment.enchantmentsList[62],
                4,
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("bestia"), 15)
                        .add(Aspect.getAspect("meto"), 15).add(Aspect.getAspect("lucrum"), 10)
                        .add(Aspect.getAspect("praecantatio"), 10),
                new ItemStack[] { getModItem(Minecraft.ID, "golden_carrot", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                        getModItem(Minecraft.ID, "tripwire_hook", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing), });
        TCHelper.addResearchPage("ENCHANT_FISHING", new ResearchPage(TCHelper.findInfusionEnchantRecipe(61)));
        TCHelper.addResearchPage("ENCHANT_FISHING", new ResearchPage(TCHelper.findInfusionEnchantRecipe(62)));
        TCHelper.refreshResearchPages("REDSTONETHEORY");
        TCHelper.refreshResearchPages("REDCRYSTAL");
        TCHelper.refreshResearchPages("REDCRYSTAL_AMP");
        TCHelper.refreshResearchPages("REDCRYSTAL_DENSE");
        TCHelper.refreshResearchPages("REDCRYSTAL_DIM");
        TCHelper.refreshResearchPages("MAGICHOURGLASS");
        TCHelper.refreshResearchPages("SLIVERS");
        TCHelper.refreshResearchPages("NITORLIGHT");
        TCHelper.refreshResearchPages("ENCHANT_FISHING");
        TCHelper.refreshResearchPages("REMOTECOMPARATOR");
        TCHelper.refreshResearchPages("REDCRYSTAL_RES");
        TCHelper.refreshResearchPages("REDCRYSTAL_MIRRORBOUND");
        TCHelper.refreshResearchPages("FOCUSCRAFTING");
    }
}
