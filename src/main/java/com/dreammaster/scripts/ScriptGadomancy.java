package com.dreammaster.scripts;

import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.Mods;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchPage;

public class ScriptGadomancy implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Gadomancy";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.Gadomancy.ID, Mods.Thaumcraft.ID, Mods.ThaumicTinkerer.ID);
    }

    @Override
    public void loadRecipes() {
        TCHelper.removeInfusionRecipe(getModItem("gadomancy", "itemSilverwoodGolemPlacer", 1, 8, missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(
                        "gadomancy",
                        "itemSilverwoodGolemPlacer",
                        1,
                        8,
                        "{gadomancy:{upgrades:{runicShield:1b}}}",
                        missing));
        TCHelper.removeInfusionRecipe(getModItem("gadomancy", "ItemGolemCoreBreak", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("gadomancy", "ItemGolemCoreBreak", 1, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem("Thaumcraft", "blockCosmeticSolid", 4, 11, missing));
        TCHelper.removeCrucibleRecipe(getModItem("Thaumcraft", "blockCosmeticSolid", 1, 15, missing));
        TCHelper.removeInfusionRecipe(getModItem("gadomancy", "BlockNodeManipulator", 1, 5, missing));
        TCHelper.removeInfusionRecipe(getModItem("gadomancy", "BlockStoneMachine", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("gadomancy", "BlockInfusionClaw", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("gadomancy", "BlockRemoteJar", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("gadomancy", "BlockArcaneDropper", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("gadomancy", "BlockStoneMachine", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("gadomancy", "BlockStoneMachine", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("gadomancy", "BlockStoneMachine", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("gadomancy", "BlockStoneMachine", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("gadomancy", "BlockStoneMachine", 1, 1, missing));
        TCHelper.removeInfusionRecipe(getModItem("gadomancy", "BlockStoneMachine", 1, 3, missing));
        TCHelper.removeArcaneRecipe(getModItem("gadomancy", "BlockStoneMachine", 1, 4, missing));
        TCHelper.removeArcaneRecipe(getModItem("gadomancy", "BlockAuraPylon", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("gadomancy", "BlockAuraPylon", 1, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem("gadomancy", "BlockKnowledgeBook", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("gadomancy", "BlockEssentiaCompressor", 3, 0, missing));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "GADOMANCY.GOLEMSILVERWOOD",
                getModItem("gadomancy", "itemSilverwoodGolemPlacer", 1, 8, missing),
                8,
                new AspectList().add(Aspect.getAspect("humanus"), 16).add(Aspect.getAspect("motus"), 16)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("sensus"), 16)
                        .add(Aspect.getAspect("cognitio"), 8).add(Aspect.getAspect("ordo"), 32),
                getModItem("Thaumcraft", "ItemGolemPlacer", 1, 1, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                        getModItem("Thaumcraft", "blockMagicalLog", 1, 1, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 9, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 9, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("Thaumcraft", "blockMagicalLog", 1, 1, missing), });
        TCHelper.setResearchAspects(
                "GADOMANCY.GOLEMSILVERWOOD",
                new AspectList().add(Aspect.getAspect("cognitio"), 21).add(Aspect.getAspect("motus"), 18)
                        .add(Aspect.getAspect("arbor"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("corpus"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.GOLEMSILVERWOOD", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "GADOMANCY.GOLEMCOREBREAK",
                getModItem("gadomancy", "ItemGolemCoreBreak", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("instrumentum"), 32).add(Aspect.getAspect("perditio"), 16)
                        .add(Aspect.getAspect("machina"), 24).add(Aspect.getAspect("praecantatio"), 8)
                        .add(Aspect.getAspect("perfodio"), 8),
                getModItem("Thaumcraft", "ItemGolemCore", 1, 3, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemPickaxeElemental", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                        getModItem("Thaumcraft", "ItemAxeElemental", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("Thaumcraft", "ItemShovelElemental", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 5, missing), });
        TCHelper.setResearchAspects(
                "GADOMANCY.GOLEMCOREBREAK",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("perditio"), 12)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("perfodio"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.GOLEMCOREBREAK", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "GADOMANCY.GOLEMCOREBODYGUARD",
                getModItem("gadomancy", "ItemGolemCoreBreak", 1, 1, missing),
                9,
                new AspectList().add(Aspect.getAspect("instrumentum"), 32).add(Aspect.getAspect("machina"), 24)
                        .add(Aspect.getAspect("telum"), 16).add(Aspect.getAspect("tutamen"), 24)
                        .add(Aspect.getAspect("ordo"), 8).add(Aspect.getAspect("auram"), 8),
                getModItem("Thaumcraft", "ItemGolemCore", 1, 4, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemSwordElemental", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemHelmetThaumium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32724, missing),
                        getModItem("Thaumcraft", "ItemChestplateThaumium", 1, 0, missing),
                        getModItem("Thaumcraft", "BootsTraveller", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemLeggingsThaumium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32724, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing), });
        TCHelper.setResearchAspects(
                "GADOMANCY.GOLEMCOREBODYGUARD",
                new AspectList().add(Aspect.getAspect("instrumentum"), 18).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("machina"), 12).add(Aspect.getAspect("telum"), 9)
                        .add(Aspect.getAspect("tutamen"), 6).add(Aspect.getAspect("auram"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.GOLEMCOREBODYGUARD", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.GOLEMRUNICSHIELD",
                new AspectList().add(Aspect.getAspect("auram"), 15).add(Aspect.getAspect("motus"), 12)
                        .add(Aspect.getAspect("tutamen"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("ordo"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.GOLEMRUNICSHIELD", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.ANCIENT_STONES",
                getModItem("Thaumcraft", "blockCosmeticSolid", 6, 11, missing),
                new AspectList().add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("perditio"), 12)
                        .add(Aspect.getAspect("ignis"), 6),
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
                getModItem("Thaumcraft", "blockEldritch", 1, 4, missing),
                'e',
                getModItem("Thaumcraft", "ItemEldritchObject", 1, 0, missing),
                'f',
                getModItem("Thaumcraft", "blockEldritch", 1, 4, missing),
                'g',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'h',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'i',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing));
        TCHelper.setResearchAspects(
                "GADOMANCY.ANCIENT_STONES",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("alienis"), 12)
                        .add(Aspect.getAspect("perditio"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.ANCIENT_STONES", 3);
        ThaumcraftApi.addCrucibleRecipe(
                "GADOMANCY.ANCIENT_STONES",
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 15, missing),
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 11, missing),
                new AspectList().add(Aspect.getAspect("permutatio"), 8).add(Aspect.getAspect("perditio"), 12)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("terra"), 8));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "GADOMANCY.NODE_MANIPULATOR",
                getModItem("gadomancy", "BlockNodeManipulator", 1, 5, missing),
                10,
                new AspectList().add(Aspect.getAspect("alienis"), 48).add(Aspect.getAspect("auram"), 64)
                        .add(Aspect.getAspect("machina"), 48).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("tenebrae"), 16).add(Aspect.getAspect("permutatio"), 24)
                        .add(Aspect.getAspect("motus"), 8),
                getModItem("Thaumcraft", "blockStoneDevice", 1, 5, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 22970, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 11, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 3, missing),
                        getModItem("Thaumcraft", "blockStoneDevice", 1, 10, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 3, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 11, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 1, missing), });
        ThaumcraftApi.addInfusionCraftingRecipe(
                "GADOMANCY.NODE_MANIPULATOR",
                getModItem("gadomancy", "BlockStoneMachine", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("alienis"), 24).add(Aspect.getAspect("machina"), 48)
                        .add(Aspect.getAspect("ordo"), 64).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("tenebrae"), 32).add(Aspect.getAspect("nebrisum"), 8)
                        .add(Aspect.getAspect("lucrum"), 16),
                getModItem("Thaumcraft", "blockStoneDevice", 1, 8, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28970, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 15, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28970, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing), });
        TCHelper.setResearchAspects(
                "GADOMANCY.NODE_MANIPULATOR",
                new AspectList().add(Aspect.getAspect("nebrisum"), 27).add(Aspect.getAspect("alienis"), 24)
                        .add(Aspect.getAspect("vacuos"), 21).add(Aspect.getAspect("praecantatio"), 18)
                        .add(Aspect.getAspect("auram"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("tenebrae"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.NODE_MANIPULATOR", 4);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "GADOMANCY.INFUSIONCLAW",
                getModItem("gadomancy", "BlockInfusionClaw", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("machina"), 48)
                        .add(Aspect.getAspect("ordo"), 48).add(Aspect.getAspect("tenebrae"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("motus"), 16)
                        .add(Aspect.getAspect("cognitio"), 8),
                getModItem("Thaumcraft", "blockStoneDevice", 1, 5, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemGolemCore", 1, 8, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23970, missing),
                        getModItem("Thaumcraft", "FocusPrimal", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23970, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                        getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23970, missing),
                        getModItem("Thaumcraft", "FocusPrimal", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 23970, missing),
                        getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing), });
        TCHelper.setResearchAspects(
                "GADOMANCY.INFUSIONCLAW",
                new AspectList().add(Aspect.getAspect("alienis"), 21).add(Aspect.getAspect("machina"), 18)
                        .add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("motus"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.INFUSIONCLAW", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.STICKYJAR",
                new AspectList().add(Aspect.getAspect("limus"), 12).add(Aspect.getAspect("terra"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.STICKYJAR", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.REMOTEJAR",
                getModItem("gadomancy", "BlockRemoteJar", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("aer"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'b',
                getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                'c',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'd',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                'e',
                getModItem("Thaumcraft", "blockMirror", 1, 6, missing),
                'f',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                'g',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                'h',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                'i',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing));
        TCHelper.setResearchAspects(
                "GADOMANCY.REMOTEJAR",
                new AspectList().add(Aspect.getAspect("machina"), 15).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("aqua"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.REMOTEJAR", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.ARCANEDROPPER",
                getModItem("gadomancy", "BlockArcaneDropper", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("aer"), 20)
                        .add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'b',
                getModItem("minecraft", "dropper", 1, 0, missing),
                'c',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'd',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 0, missing),
                'e',
                getModItem("Thaumcraft", "blockMetalDevice", 1, 9, missing),
                'f',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 0, missing),
                'g',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                'i',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing));
        TCHelper.setResearchAspects(
                "GADOMANCY.ARCANEDROPPER",
                new AspectList().add(Aspect.getAspect("machina"), 21).add(Aspect.getAspect("aer"), 18)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("sensus"), 9).add(Aspect.getAspect("motus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.ARCANEDROPPER", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.ARMORDISGUISE",
                new AspectList().add(Aspect.getAspect("limus"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("tutamen"), 9).add(Aspect.getAspect("cognitio"), 6)
                        .add(Aspect.getAspect("nebrisum"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.ARMORDISGUISE", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.REVEALER",
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("sensus"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.REVEALER", 3);
        TCHelper.clearPages("GADOMANCY.BLOCK_PROTECTOR");
        TCHelper.addResearchPage(
                "GADOMANCY.BLOCK_PROTECTOR",
                new ResearchPage("gadomancy.research_page.BLOCK_PROTECTOR.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.BLOCK_PROTECTOR",
                getModItem("gadomancy", "BlockStoneMachine", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("terra"), 150).add(Aspect.getAspect("ordo"), 150),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("minecraft", "potion", 1, 8264, missing),
                'b',
                getModItem("ThaumicTinkerer", "brightNitor", 1, 0, missing),
                'c',
                getModItem("minecraft", "potion", 1, 8264, missing),
                'd',
                getModItem("Thaumcraft", "blockTube", 1, 0, missing),
                'e',
                getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                'f',
                getModItem("Thaumcraft", "blockTube", 1, 0, missing),
                'g',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                'h',
                getModItem("Thaumcraft", "blockMetalDevice", 1, 0, missing),
                'i',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing));
        TCHelper.addResearchPage(
                "GADOMANCY.BLOCK_PROTECTOR",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("gadomancy", "BlockStoneMachine", 1, 2, missing))));
        TCHelper.addResearchPage(
                "GADOMANCY.BLOCK_PROTECTOR",
                new ResearchPage("gadomancy.research_page.BLOCK_PROTECTOR.3"));
        TCHelper.addResearchPage(
                "GADOMANCY.BLOCK_PROTECTOR",
                new ResearchPage("gadomancy.research_page.BLOCK_PROTECTOR.4"));
        TCHelper.setResearchAspects(
                "GADOMANCY.BLOCK_PROTECTOR",
                new AspectList().add(Aspect.getAspect("cognitio"), 21).add(Aspect.getAspect("bestia"), 18)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("lux"), 6)
                        .add(Aspect.getAspect("tutamen"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.BLOCK_PROTECTOR", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.E_PORTAL_CREATOR",
                getModItem("gadomancy", "BlockStoneMachine", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("ordo"), 30)
                        .add(Aspect.getAspect("terra"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 11, missing),
                'b',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 15, missing),
                'c',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 11, missing),
                'd',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'e',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 11, missing),
                'f',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'g',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 11, missing),
                'h',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 15, missing),
                'i',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 11, missing));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "GADOMANCY.E_PORTAL_CREATOR",
                getModItem("gadomancy", "BlockStoneMachine", 1, 3, missing),
                10,
                new AspectList().add(Aspect.getAspect("alienis"), 48).add(Aspect.getAspect("machina"), 48)
                        .add(Aspect.getAspect("permutatio"), 64).add(Aspect.getAspect("tenebrae"), 32)
                        .add(Aspect.getAspect("vacuos"), 32).add(Aspect.getAspect("auram"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8),
                getModItem("Thaumcraft", "blockStoneDevice", 1, 8, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemEldritchObject", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28970, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                        getModItem("Thaumcraft", "ItemEldritchObject", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 28970, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 5, missing), });
        TCHelper.setResearchAspects(
                "GADOMANCY.E_PORTAL_CREATOR",
                new AspectList().add(Aspect.getAspect("tenebrae"), 21).add(Aspect.getAspect("auram"), 18)
                        .add(Aspect.getAspect("iter"), 15).add(Aspect.getAspect("alienis"), 12)
                        .add(Aspect.getAspect("vacuos"), 9).add(Aspect.getAspect("machina"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.E_PORTAL_CREATOR", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.ETHEREAL_FAMILIAR",
                new AspectList().add(Aspect.getAspect("terra"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("ignis"), 12).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("ordo"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.ETHEREAL_FAMILIAR", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.AURA_CORE",
                new AspectList().add(Aspect.getAspect("tenebrae"), 27).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("auram"), 21).add(Aspect.getAspect("perditio"), 18)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("aer"), 9).add(Aspect.getAspect("ignis"), 6)
                        .add(Aspect.getAspect("terra"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.AURA_CORE", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.CLEAN_AURA_CORE",
                new AspectList().add(Aspect.getAspect("aqua"), 27).add(Aspect.getAspect("sano"), 24)
                        .add(Aspect.getAspect("praecantatio"), 21).add(Aspect.getAspect("auram"), 18)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("perditio"), 9).add(Aspect.getAspect("ordo"), 6)
                        .add(Aspect.getAspect("aer"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.CLEAN_AURA_CORE", 4);
        TCHelper.setResearchAspects(
                "GADOMANCY.FAMILIAR_POISON",
                new AspectList().add(Aspect.getAspect("venenum"), 15).add(Aspect.getAspect("telum"), 12)
                        .add(Aspect.getAspect("perditio"), 9).add(Aspect.getAspect("tenebrae"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.FAMILIAR_POISON", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.FAMILIAR_WEAKNESS",
                new AspectList().add(Aspect.getAspect("vinculum"), 15).add(Aspect.getAspect("vitium"), 12)
                        .add(Aspect.getAspect("telum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("tenebrae"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.FAMILIAR_WEAKNESS", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.FAMILIAR_SHOCK",
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("tempestas"), 12)
                        .add(Aspect.getAspect("telum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("tenebrae"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.FAMILIAR_SHOCK", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.FAMILIAR_FIRE",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("infernus"), 12)
                        .add(Aspect.getAspect("telum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("tenebrae"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.FAMILIAR_FIRE", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.FAMILIAR_DAMAGE",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("telum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("tenebrae"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.FAMILIAR_DAMAGE", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.FAMILIAR_RANGE",
                new AspectList().add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("telum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("tenebrae"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.FAMILIAR_RANGE", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.FAMILIAR_SPEED",
                new AspectList().add(Aspect.getAspect("motus"), 15).add(Aspect.getAspect("auram"), 12)
                        .add(Aspect.getAspect("telum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("tenebrae"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.FAMILIAR_SPEED", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.ARCANE_PACKAGER",
                getModItem("gadomancy", "BlockStoneMachine", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 100).add(Aspect.getAspect("perditio"), 100)
                        .add(Aspect.getAspect("aer"), 100),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 32642, missing),
                'c',
                getModItem("Thaumcraft", "blockWoodenDevice", 1, 6, missing),
                'd',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'e',
                getModItem("gadomancy", "ItemAuraCore", 1, 1, missing),
                'f',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'g',
                getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                'h',
                getModItem("Thaumcraft", "blockTable", 1, 15, missing),
                'i',
                getModItem("Thaumcraft", "blockJar", 1, 0, missing));
        TCHelper.setResearchAspects(
                "GADOMANCY.ARCANE_PACKAGER",
                new AspectList().add(Aspect.getAspect("machina"), 18).add(Aspect.getAspect("aer"), 15)
                        .add(Aspect.getAspect("vacuos"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("arbor"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.ARCANE_PACKAGER", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.AURA_PYLON",
                getModItem("gadomancy", "BlockAuraPylon", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 100).add(Aspect.getAspect("aqua"), 100)
                        .add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("ignis"), 100),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockTube", 1, 6, missing),
                'b',
                "stickIridium",
                'c',
                getModItem("Thaumcraft", "blockTube", 1, 6, missing),
                'd',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 1, missing),
                'e',
                getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                'f',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 1, missing),
                'g',
                getModItem("Thaumcraft", "blockTube", 1, 6, missing),
                'h',
                "stickIridium",
                'i',
                getModItem("Thaumcraft", "blockTube", 1, 6, missing));
        TCHelper.setResearchAspects(
                "GADOMANCY.AURA_PYLON",
                new AspectList().add(Aspect.getAspect("auram"), 18).add(Aspect.getAspect("ordo"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("machina"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("ignis"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.AURA_PYLON", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.AURA_PYLON",
                getModItem("gadomancy", "BlockAuraPylon", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 125).add(Aspect.getAspect("aer"), 125)
                        .add(Aspect.getAspect("ignis"), 125),
                "abc",
                "def",
                "ghi",
                'a',
                "screwOsmiridium",
                'b',
                getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                'c',
                "screwOsmiridium",
                'd',
                getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                'e',
                getModItem("gadomancy", "ItemAuraCore", 1, 2, missing),
                'f',
                getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                'g',
                "stickIridium",
                'h',
                getModItem("gadomancy", "BlockAuraPylon", 1, 0, missing),
                'i',
                "stickIridium");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.KNOWLEDGE_BOOK",
                getModItem("gadomancy", "BlockKnowledgeBook", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("ignis"), 50)
                        .add(Aspect.getAspect("perditio"), 35).add(Aspect.getAspect("aer"), 35),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "ItemInkwell", 1, 0, missing),
                'b',
                getModItem("Thaumcraft", "ItemThaumonomicon", 1, 0, missing),
                'c',
                getModItem("Thaumcraft", "ItemInkwell", 1, 0, missing),
                'd',
                getModItem("minecraft", "bookshelf", 1, 0, missing),
                'e',
                getModItem("gadomancy", "ItemAuraCore", 1, 5, missing),
                'f',
                getModItem("minecraft", "bookshelf", 1, 0, missing),
                'g',
                getModItem("Thaumcraft", "blockMetalDevice", 1, 12, missing),
                'h',
                getModItem("Thaumcraft", "ItemGoggles", 1, 0, missing),
                'i',
                getModItem("Thaumcraft", "blockMetalDevice", 1, 12, missing));
        TCHelper.setResearchAspects(
                "GADOMANCY.KNOWLEDGE_BOOK",
                new AspectList().add(Aspect.getAspect("cognitio"), 24).add(Aspect.getAspect("ordo"), 21)
                        .add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("machina"), 15)
                        .add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("motus"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("lucrum"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.KNOWLEDGE_BOOK", 3);
        ThaumcraftApi.addWarpToResearch("GADOMANCY.KNOWLEDGE_BOOK", 4);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "GADOMANCY.ESSENTIA_COMPRESSOR",
                getModItem("gadomancy", "BlockEssentiaCompressor", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 180).add(Aspect.getAspect("aqua"), 200)
                        .add(Aspect.getAspect("ignis"), 120).add(Aspect.getAspect("terra"), 100)
                        .add(Aspect.getAspect("perditio"), 140).add(Aspect.getAspect("ordo"), 160),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockTube", 1, 6, missing),
                'b',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'c',
                getModItem("Thaumcraft", "blockTube", 1, 6, missing),
                'd',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                'e',
                getModItem("gadomancy", "ItemElement", 1, 0, missing),
                'f',
                getModItem("Thaumcraft", "blockMagicalLog", 1, 0, missing),
                'g',
                getModItem("Thaumcraft", "blockTube", 1, 6, missing),
                'h',
                getModItem("gadomancy", "ItemAuraCore", 1, 3, missing),
                'i',
                getModItem("Thaumcraft", "blockTube", 1, 6, missing));
        TCHelper.setResearchAspects(
                "GADOMANCY.ESSENTIA_COMPRESSOR",
                new AspectList().add(Aspect.getAspect("vacuos"), 21).add(Aspect.getAspect("perditio"), 18)
                        .add(Aspect.getAspect("machina"), 15).add(Aspect.getAspect("aqua"), 18)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.ESSENTIA_COMPRESSOR", 3);
        TCHelper.setResearchAspects(
                "GADOMANCY.AURA_EFFECTS",
                new AspectList().add(Aspect.getAspect("cognitio"), 27).add(Aspect.getAspect("auram"), 24)
                        .add(Aspect.getAspect("praecantatio"), 21).add(Aspect.getAspect("ordo"), 18)
                        .add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("aer"), 12)
                        .add(Aspect.getAspect("aqua"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("perditio"), 3));
        TCHelper.setResearchComplexity("GADOMANCY.AURA_EFFECTS", 4);
        TCHelper.refreshResearchPages("GADOMANCY.GOLEMSILVERWOOD");
        TCHelper.refreshResearchPages("GADOMANCY.GOLEMCOREBREAK");
        TCHelper.refreshResearchPages("GADOMANCY.GOLEMCOREBODYGUARD");
        TCHelper.refreshResearchPages("GADOMANCY.GOLEMRUNICSHIELD");
        TCHelper.refreshResearchPages("GADOMANCY.ANCIENT_STONES");
        TCHelper.refreshResearchPages("GADOMANCY.NODE_MANIPULATOR");
        TCHelper.refreshResearchPages("GADOMANCY.INFUSIONCLAW");
        TCHelper.refreshResearchPages("GADOMANCY.REMOTEJAR");
        TCHelper.refreshResearchPages("GADOMANCY.ARCANEDROPPER");
        TCHelper.refreshResearchPages("GADOMANCY.BLOCK_PROTECTOR");
        TCHelper.refreshResearchPages("GADOMANCY.E_PORTAL_CREATOR");
        TCHelper.refreshResearchPages("GADOMANCY.ARCANE_PACKAGER");
        TCHelper.refreshResearchPages("GADOMANCY.AURA_PYLON");
        TCHelper.refreshResearchPages("GADOMANCY.KNOWLEDGE_BOOK");
        TCHelper.refreshResearchPages("GADOMANCY.ESSENTIA_COMPRESSOR");
        TCHelper.refreshResearchPages("GADOMANCY.STICKYJAR");
    }
}
