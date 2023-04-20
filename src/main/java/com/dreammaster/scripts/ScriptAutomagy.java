package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

import com.dreammaster.thaumcraft.TCHelper;
import gregtech.api.enums.Mods;

public class ScriptAutomagy implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Automagy";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.Thaumcraft.ID, "Automagy", Mods.Genetics.ID, Mods.AppliedEnergistics2.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack missing = new ItemStack(Blocks.dirt);
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "blockTorchInversion", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Automagy", "blockRedcrystal", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "blockRedcrystalAmp", 2, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "blockRedcrystalDense", 2, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "blockRedcrystalDim", 2, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "blockHourglassMagic", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "shardSliver", 4, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "shardSliver", 4, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "shardSliver", 4, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "shardSliver", 4, 3, missing));
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "shardSliver", 4, 4, missing));
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "shardSliver", 4, 5, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemShard", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemShard", 1, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemShard", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemShard", 1, 3, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemShard", 1, 4, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "ItemShard", 1, 5, missing));
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "blockTranslucent", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "blockTranslucent", 1, 1, missing));
        TCHelper.removeInfusionEnchantmentRecipe(61);
        TCHelper.removeInfusionEnchantmentRecipe(62);
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "blockRemoteComparator", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Automagy", "crystalEye", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "blockRedcrystalRes", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "blockRedcrystalMerc", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("Automagy", "focusCrafting", 1, 0, missing));
        TCHelper.clearPages("REDSTONETHEORY");
        TCHelper.addResearchPage("REDSTONETHEORY", new ResearchPage("Automagy.research_page.REDSTONETHEORY.1"));
        TCHelper.addResearchPage("REDSTONETHEORY", new ResearchPage("Automagy.research_page.REDSTONETHEORY.2"));
        TCHelper.addResearchPage("REDSTONETHEORY", new ResearchPage("Automagy.research_page.REDSTONETHEORY.3"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REDSTONETHEORY",
                getModItem("Automagy", "blockTorchInversion", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("Automagy", "shardSliver", 1, 4, missing),
                'd',
                getModItem("Automagy", "shardSliver", 1, 4, missing),
                'e',
                getModItem("minecraft", "redstone_torch", 1, 0, missing),
                'f',
                getModItem("Automagy", "shardSliver", 1, 4, missing),
                'h',
                getModItem("Automagy", "shardSliver", 1, 4, missing));
        TCHelper.addResearchPage(
                "REDSTONETHEORY",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("Automagy", "blockTorchInversion", 1, 0, missing))));
        TCHelper.addResearchPage("REDSTONETHEORY", new ResearchPage("Automagy.research_page.REDSTONETHEORY.4"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REDSTONETHEORY",
                getModItem("Automagy", "blockHourglass", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "ringGold",
                'b',
                getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing),
                'c',
                "screwGold",
                'd',
                getModItem("Genetics", "misc", 1, 8, missing),
                'e',
                "dustQuartzSand",
                'f',
                getModItem("Genetics", "misc", 1, 8, missing),
                'g',
                "screwGold",
                'h',
                getModItem("gregtech", "gt.metaitem.02", 1, 32470, missing),
                'i',
                "ringGold");
        TCHelper.addResearchPage(
                "REDSTONETHEORY",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Automagy", "blockHourglass", 1, 0, missing))));
        TCHelper.addResearchPage("REDSTONETHEORY", new ResearchPage("Automagy.research_page.REDSTONETHEORY.5"));
        TCHelper.setResearchAspects(
                "REDCRYSTAL",
                new AspectList().add(Aspect.getAspect("machina"), 2).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("vitreus"), 12));
        TCHelper.setResearchComplexity("REDCRYSTAL", 3);
        ThaumcraftApi.addCrucibleRecipe(
                "REDCRYSTAL",
                getModItem("Automagy", "blockRedcrystal", 9, 0, missing),
                getModItem("minecraft", "redstone_block", 1, 0, missing),
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
                getModItem("Automagy", "blockRedcrystalAmp", 2, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Automagy", "shardSliver", 1, 1, missing),
                'b',
                getModItem("Automagy", "shardSliver", 1, 1, missing),
                'c',
                getModItem("Automagy", "shardSliver", 1, 1, missing),
                'd',
                getModItem("Automagy", "shardSliver", 1, 1, missing),
                'e',
                getModItem("Automagy", "blockRedcrystal", 1, 0, missing),
                'f',
                getModItem("Automagy", "shardSliver", 1, 1, missing),
                'g',
                getModItem("Automagy", "shardSliver", 1, 1, missing),
                'h',
                getModItem("Automagy", "shardSliver", 1, 1, missing),
                'i',
                getModItem("Automagy", "shardSliver", 1, 1, missing));
        TCHelper.setResearchAspects(
                "REDCRYSTAL",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("machina"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("vitreus"), 6)
                        .add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("REDCRYSTAL", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REDCRYSTAL_AMP",
                getModItem("Automagy", "blockRedcrystalDense", 2, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Automagy", "blockRedcrystal", 1, 0, missing),
                'c',
                getModItem("Automagy", "blockRedcrystal", 1, 0, missing),
                'd',
                getModItem("Automagy", "shardSliver", 1, 3, missing),
                'e',
                "stickInfusedEarth",
                'f',
                getModItem("Automagy", "shardSliver", 1, 3, missing),
                'g',
                getModItem("Automagy", "blockRedcrystal", 1, 0, missing),
                'i',
                getModItem("Automagy", "blockRedcrystal", 1, 0, missing));
        TCHelper.setResearchAspects(
                "REDCRYSTAL",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("machina"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("vitreus"), 6)
                        .add(Aspect.getAspect("perditio"), 3));
        TCHelper.setResearchComplexity("REDCRYSTAL", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REDCRYSTAL_AMP",
                getModItem("Automagy", "blockRedcrystalDim", 2, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Automagy", "shardSliver", 1, 5, missing),
                'b',
                getModItem("Automagy", "shardSliver", 1, 5, missing),
                'c',
                getModItem("Automagy", "shardSliver", 1, 5, missing),
                'd',
                getModItem("Automagy", "shardSliver", 1, 5, missing),
                'e',
                getModItem("Automagy", "blockRedcrystal", 1, 0, missing),
                'f',
                getModItem("Automagy", "shardSliver", 1, 5, missing),
                'g',
                getModItem("Automagy", "shardSliver", 1, 5, missing),
                'h',
                getModItem("Automagy", "shardSliver", 1, 5, missing),
                'i',
                getModItem("Automagy", "shardSliver", 1, 5, missing));
        TCHelper.clearPages("SLIVERS");
        TCHelper.addResearchPage("SLIVERS", new ResearchPage("Automagy.research_page.SLIVERS.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem("Automagy", "shardSliver", 4, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("aer"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                "craftingToolHardHammer",
                'e',
                getModItem("Thaumcraft", "ItemShard", 1, 0, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Automagy", "shardSliver", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem("Automagy", "shardSliver", 4, 1, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("ignis"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                "craftingToolHardHammer",
                'e',
                getModItem("Thaumcraft", "ItemShard", 1, 1, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Automagy", "shardSliver", 1, 1, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem("Automagy", "shardSliver", 4, 2, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("aqua"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                "craftingToolHardHammer",
                'e',
                getModItem("Thaumcraft", "ItemShard", 1, 2, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Automagy", "shardSliver", 1, 2, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem("Automagy", "shardSliver", 4, 3, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                "craftingToolHardHammer",
                'e',
                getModItem("Thaumcraft", "ItemShard", 1, 3, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Automagy", "shardSliver", 1, 3, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem("Automagy", "shardSliver", 4, 4, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                "craftingToolHardHammer",
                'e',
                getModItem("Thaumcraft", "ItemShard", 1, 4, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Automagy", "shardSliver", 1, 4, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem("Automagy", "shardSliver", 4, 5, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                "craftingToolHardHammer",
                'e',
                getModItem("Thaumcraft", "ItemShard", 1, 5, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Automagy", "shardSliver", 1, 5, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem("Thaumcraft", "ItemShard", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("aer"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("Automagy", "shardSliver", 1, 0, missing),
                'd',
                getModItem("Automagy", "shardSliver", 1, 0, missing),
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'f',
                getModItem("Automagy", "shardSliver", 1, 0, missing),
                'h',
                getModItem("Automagy", "shardSliver", 1, 0, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemShard", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem("Thaumcraft", "ItemShard", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("ignis"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("Automagy", "shardSliver", 1, 1, missing),
                'd',
                getModItem("Automagy", "shardSliver", 1, 1, missing),
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'f',
                getModItem("Automagy", "shardSliver", 1, 1, missing),
                'h',
                getModItem("Automagy", "shardSliver", 1, 1, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemShard", 1, 1, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem("Thaumcraft", "ItemShard", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("aqua"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("Automagy", "shardSliver", 1, 2, missing),
                'd',
                getModItem("Automagy", "shardSliver", 1, 2, missing),
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'f',
                getModItem("Automagy", "shardSliver", 1, 2, missing),
                'h',
                getModItem("Automagy", "shardSliver", 1, 2, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemShard", 1, 2, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem("Thaumcraft", "ItemShard", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("Automagy", "shardSliver", 1, 3, missing),
                'd',
                getModItem("Automagy", "shardSliver", 1, 3, missing),
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'f',
                getModItem("Automagy", "shardSliver", 1, 3, missing),
                'h',
                getModItem("Automagy", "shardSliver", 1, 3, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemShard", 1, 3, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem("Thaumcraft", "ItemShard", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("Automagy", "shardSliver", 1, 4, missing),
                'd',
                getModItem("Automagy", "shardSliver", 1, 4, missing),
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'f',
                getModItem("Automagy", "shardSliver", 1, 4, missing),
                'h',
                getModItem("Automagy", "shardSliver", 1, 4, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemShard", 1, 4, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "SLIVERS",
                getModItem("Thaumcraft", "ItemShard", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("perditio"), 5),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("Automagy", "shardSliver", 1, 5, missing),
                'd',
                getModItem("Automagy", "shardSliver", 1, 5, missing),
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'f',
                getModItem("Automagy", "shardSliver", 1, 5, missing),
                'h',
                getModItem("Automagy", "shardSliver", 1, 5, missing));
        TCHelper.addResearchPage(
                "SLIVERS",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Thaumcraft", "ItemShard", 1, 5, missing))));
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
                getModItem("Automagy", "blockRemoteComparator", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("perditio"), 15),
                "abc",
                "def",
                "ghi",
                'b',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                'd',
                getModItem("Automagy", "blockRedcrystal", 1, 0, missing),
                'e',
                getModItem("Automagy", "blockRedcrystal", 1, 0, missing),
                'f',
                getModItem("Automagy", "blockRedcrystal", 1, 0, missing),
                'g',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'h',
                getModItem("ProjRed|Integration", "projectred.integration.gate", 1, 26, missing),
                'i',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing));
        ThaumcraftApi.addCrucibleRecipe(
                "REMOTECOMPARATOR",
                getModItem("Automagy", "crystalEye", 1, 0, missing),
                getModItem("minecraft", "spider_eye", 1, 0, missing),
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
                getModItem("Automagy", "blockRedcrystalRes", 2, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Automagy", "shardSliver", 1, 0, missing),
                'b',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 11, missing),
                'c',
                getModItem("Automagy", "shardSliver", 1, 0, missing),
                'd',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 11, missing),
                'e',
                getModItem("Automagy", "blockRedcrystal", 1, 0, missing),
                'f',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 11, missing),
                'g',
                getModItem("Automagy", "shardSliver", 1, 0, missing),
                'h',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 11, missing),
                'i',
                getModItem("Automagy", "shardSliver", 1, 0, missing));
        TCHelper.setResearchAspects(
                "REDCRYSTAL_MIRRORBOUND",
                new AspectList().add(Aspect.getAspect("iter"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("REDCRYSTAL_MIRRORBOUND", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "REDCRYSTAL_MIRRORBOUND",
                getModItem("Automagy", "blockRedcrystalMerc", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("aer"), 20)
                        .add(Aspect.getAspect("perditio"), 10).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("terra"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Automagy", "blockRedcrystal", 1, 0, missing),
                'b',
                getModItem("Automagy", "blockRedcrystalRes", 1, 0, missing),
                'c',
                getModItem("Automagy", "blockRedcrystal", 1, 0, missing),
                'd',
                getModItem("Thaumcraft", "ItemResource", 1, 10, missing),
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                'f',
                getModItem("Thaumcraft", "ItemResource", 1, 10, missing),
                'g',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'h',
                getModItem("Thaumcraft", "ItemResource", 1, 10, missing),
                'i',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing));
        TCHelper.setResearchAspects(
                "FOCUSCRAFTING",
                new AspectList().add(Aspect.getAspect("fabrico"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("instrumentum"), 9).add(Aspect.getAspect("terra"), 6));
        TCHelper.setResearchComplexity("FOCUSCRAFTING", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FOCUSCRAFTING",
                getModItem("Automagy", "focusCrafting", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("terra"), 40)
                        .add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("aer"), 20)
                        .add(Aspect.getAspect("aqua"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'b',
                getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                'c',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'd',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 11, missing),
                'e',
                getModItem("Thaumcraft", "blockTable", 1, 15, missing),
                'f',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 11, missing),
                'g',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                'h',
                getModItem("Thaumcraft", "ItemShard", 1, 6, missing),
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 3, missing));
        new ResearchItem(
                "InfusedGoldGTNH",
                "AUTOMAGY",
                new AspectList().add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("metallum"), 3),
                -5,
                -2,
                3,
                getModItem("gregtech", "gt.metaitem.01", 1, 11323, missing))
                        .setPages(new ResearchPage("tc.research_page.InfusedGoldGTNH.1"))
                        .setParents("INFUSION", "THAUMIUM").registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "InfusedGoldGTNH",
                getModItem("gregtech", "gt.metaitem.01", 1, 11323, missing),
                2,
                new AspectList().add(Aspect.getAspect("lucrum"), 16).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("ordo"), 8).add(Aspect.getAspect("praecantatio"), 4)
                        .add(Aspect.getAspect("aer"), 4),
                getModItem("minecraft", "gold_ingot", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 2330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 2330, missing), });
        TCHelper.addResearchPage(
                "InfusedGoldGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 11323, missing))));
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
                getModItem("Automagy", "blockHourglassMagic", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("perditio"), 15)
                        .add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("terra"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "screwInfusedGold",
                'b',
                getModItem("Automagy", "blockRedcrystal", 1, 0, missing),
                'c',
                "screwInfusedGold",
                'd',
                getModItem("Automagy", "shardSliver", 1, 0, missing),
                'e',
                getModItem("Automagy", "blockHourglass", 1, 0, missing),
                'f',
                getModItem("Automagy", "shardSliver", 1, 4, missing),
                'g',
                "plateInfusedGold",
                'h',
                getModItem("minecraft", "light_weighted_pressure_plate", 1, 0, missing),
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
                getModItem("Automagy", "blockTranslucent", 1, 0, missing),
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
                getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                'f',
                "plateAmber",
                'h',
                "plateAmber");
        TCHelper.addResearchPage(
                "NITORLIGHT",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("Automagy", "blockTranslucent", 1, 0, missing))));
        TCHelper.clearPages("ENCHANT_FISHING");
        TCHelper.addResearchPage("ENCHANT_FISHING", new ResearchPage("Automagy.research_page.ENCHANT_FISHING.1"));
        ThaumcraftApi.addInfusionEnchantmentRecipe(
                "ENCHANT_FISHING",
                Enchantment.enchantmentsList[61],
                3,
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("bestia"), 15)
                        .add(Aspect.getAspect("fames"), 10).add(Aspect.getAspect("meto"), 15)
                        .add(Aspect.getAspect("praecantatio"), 10),
                new ItemStack[] { getModItem("minecraft", "carrot_on_a_stick", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("minecraft", "sugar", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing), });
        ThaumcraftApi.addInfusionEnchantmentRecipe(
                "ENCHANT_FISHING",
                Enchantment.enchantmentsList[62],
                4,
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("bestia"), 15)
                        .add(Aspect.getAspect("meto"), 15).add(Aspect.getAspect("lucrum"), 10)
                        .add(Aspect.getAspect("praecantatio"), 10),
                new ItemStack[] { getModItem("minecraft", "golden_carrot", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("minecraft", "tripwire_hook", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing), });
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
