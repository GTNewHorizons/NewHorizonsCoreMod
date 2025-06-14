package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkersGregworks;
import static gregtech.api.util.GTModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;

import com.dreammaster.item.NHItemList;
import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.Materials;
import gregtech.api.enums.Mods;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptTaintedMagic implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "Tainted Magic";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                Mods.TaintedMagic.ID,
                Mods.Thaumcraft.ID,
                ForbiddenMagic.ID,
                Forestry.ID,
                IndustrialCraft2.ID,
                TinkersGregworks.ID);
    }

    @Override
    public void loadRecipes() {
        TCHelper.removeCrucibleRecipe(getModItem(TaintedMagic.ID, "BlockShadowOre", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing));
        TCHelper.removeCrucibleRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4, missing));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemMagicFunguar", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "BlockWarpwoodSapling", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemWarpedGoggles", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemFocusVisShard", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusMageMace", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 2, 5, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemCrystalDagger", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemHelmetCultistRobe", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemChestplateCultistRobe", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemLeggingsCultistRobe", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemBootsCultist", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemHelmetCultistPlate", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemChestplateCultistPlate", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemLeggingsCultistPlate", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemHelmetCultistLeaderPlate", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemChestplateCultistLeaderPlate", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemLeggingsCultistLeaderPlate", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(TaintedMagic.ID, "ItemVoidsentBlood", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemSwordCrimson", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidmetalGoggles", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusTaint", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusTaintedBlast", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 6, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemThaumicDisassembler", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidwalkerBoots", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidwalkerSash", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidFortressHelmet", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidFortressChestplate", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidFortressLeggings", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemShadowFortressHelmet", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemShadowFortressChestplate", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemShadowFortressLeggings", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemKatana", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemKatana", 1, 1, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemKatana", 1, 2, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemWandRod", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemWandRod", 1, 1, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusMeteorology", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemPrimordialEdge", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemWandCap", 1, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemWandCap", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemWandCap", 1, 3, missing));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemWandCap", 1, 0, missing));
        TCHelper.orphanResearch("SHADOWMETAL");
        TCHelper.removeResearch("SHADOWMETAL");
        new ResearchItem(
                "ShadowmetalGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("tenebrae"), 6).add(Aspect.getAspect("potentia"), 3),
                0,
                1,
                2,
                getModItem(TaintedMagic.ID, "BlockShadowOre", 1, 0, missing)).setParents("TAINTEDMAGIC").setConcealed()
                        .setPages(new ResearchPage("tm.text.SHADOWMETAL.1")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "ShadowmetalGTNH",
                getModItem(TaintedMagic.ID, "BlockShadowOre", 1, 0, missing),
                getModItem(Minecraft.ID, "stone", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("tenebrae"), 6).add(Aspect.getAspect("praecantatio"), 8)
                        .add(Aspect.getAspect("metallum"), 8).add(Aspect.getAspect("vacuos"), 4));
        TCHelper.addResearchPage(
                "ShadowmetalGTNH",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(TaintedMagic.ID, "BlockShadowOre", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ShadowmetalGTNH", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ShadowmetalGTNH",
                getModItem(TaintedMagic.ID, "ItemShadowmetalHoe", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 45).add(Aspect.getAspect("terra"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Shadow, 1L),
                'c',
                "craftingToolHardHammer",
                'd',
                "craftingToolFile",
                'e',
                "stickWood",
                'h',
                "stickWood");
        TCHelper.addResearchPage(
                "ShadowmetalGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemShadowmetalHoe", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ShadowmetalGTNH",
                getModItem(TaintedMagic.ID, "ItemShadowmetalPick", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 45).add(Aspect.getAspect("terra"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Shadow, 1L),
                'c',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Shadow, 1L),
                'd',
                "craftingToolFile",
                'e',
                "stickWood",
                'f',
                "craftingToolHardHammer",
                'h',
                "stickWood");
        TCHelper.addResearchPage(
                "ShadowmetalGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemShadowmetalPick", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ShadowmetalGTNH",
                getModItem(TaintedMagic.ID, "ItemShadowmetalAxe", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 45).add(Aspect.getAspect("terra"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Shadow, 1L),
                'c',
                "craftingToolHardHammer",
                'd',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                'e',
                "stickWood",
                'g',
                "craftingToolFile",
                'h',
                "stickWood");
        TCHelper.addResearchPage(
                "ShadowmetalGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemShadowmetalAxe", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ShadowmetalGTNH",
                getModItem(TaintedMagic.ID, "ItemShadowmetalSpade", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 45).add(Aspect.getAspect("terra"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolFile",
                'b',
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Shadow, 1L),
                'c',
                "craftingToolHardHammer",
                'e',
                "stickWood",
                'h',
                "stickWood");
        TCHelper.addResearchPage(
                "ShadowmetalGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemShadowmetalSpade", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ShadowmetalGTNH",
                getModItem(TaintedMagic.ID, "ItemShadowmetalSword", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 45).add(Aspect.getAspect("terra"), 30),
                "abc",
                "def",
                "ghi",
                'b',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                'd',
                "craftingToolFile",
                'e',
                GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                'f',
                "craftingToolHardHammer",
                'h',
                "stickWood");
        TCHelper.addResearchPage(
                "ShadowmetalGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemShadowmetalSword", 1, 0, missing))));
        TCHelper.orphanResearch("EVILSHARDS");
        TCHelper.removeResearch("EVILSHARDS");
        new ResearchItem(
                "EvilshardsGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("infernus"), 15).add(Aspect.getAspect("vitreus"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("tenebrae"), 6)
                        .add(Aspect.getAspect("alienis"), 3),
                4,
                0,
                3,
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4, missing)).setParents("TAINTEDMAGIC").setConcealed()
                        .setPages(new ResearchPage("tm.text.EVILSHARDS.1")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "EvilshardsGTNH",
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 8).add(Aspect.getAspect("praecantatio"), 8)
                        .add(Aspect.getAspect("permutatio"), 8));
        TCHelper.addResearchPage(
                "EvilshardsGTNH",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EvilshardsGTNH",
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4, missing),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("vitium"), 8).add(Aspect.getAspect("praecantatio"), 8)
                        .add(Aspect.getAspect("permutatio"), 8));
        TCHelper.addResearchPage(
                "EvilshardsGTNH",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4, missing))));
        ThaumcraftApi.addWarpToResearch("EvilshardsGTNH", 2);
        TCHelper.orphanResearch("MAGICFUNGUAR");
        TCHelper.removeResearch("MAGICFUNGUAR");
        new ResearchItem(
                "MagicFunguarGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("gula"), 15).add(Aspect.getAspect("fames"), 12)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("herba"), 3),
                3,
                -2,
                3,
                getModItem(TaintedMagic.ID, "ItemMagicFunguar", 1, 0, missing)).setParents("TAINTEDMAGIC")
                        .setConcealed().setPages(new ResearchPage("tm.text.MAGICFUNGUAR.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MagicFunguarGTNH",
                getModItem(TaintedMagic.ID, "ItemMagicFunguar", 4, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 10).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("perditio"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "brown_mushroom", 1, 0, missing),
                'b',
                getModItem(Thaumcraft.ID, "ItemShard", 1, wildcard, missing),
                'c',
                getModItem(Minecraft.ID, "red_mushroom", 1, 0, missing),
                'd',
                getModItem(Thaumcraft.ID, "ItemShard", 1, wildcard, missing),
                'e',
                getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 5, missing),
                'f',
                getModItem(Thaumcraft.ID, "ItemShard", 1, wildcard, missing),
                'g',
                getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing),
                'h',
                getModItem(Thaumcraft.ID, "ItemShard", 1, wildcard, missing),
                'i',
                getModItem(Minecraft.ID, "blaze_powder", 1, 0, missing));
        TCHelper.addResearchPage(
                "MagicFunguarGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemMagicFunguar", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("MagicFunguarGTNH", 1);
        TCHelper.orphanResearch("WARPTREE");
        TCHelper.removeResearch("WARPTREE");
        new ResearchItem(
                "WarpTreeGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("alienis"), 18).add(Aspect.getAspect("tenebrae"), 15)
                        .add(Aspect.getAspect("vitium"), 12).add(Aspect.getAspect("arbor"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("herba"), 3),
                6,
                -1,
                3,
                getModItem(TaintedMagic.ID, "BlockWarpwoodSapling", 1, 0, missing)).setParentsHidden("ShadowmetalGTNH")
                        .setParents("EvilshardsGTNH").setConcealed().setPages(new ResearchPage("tm.text.WARPTREE.1"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "WarpTreeGTNH",
                getModItem(TaintedMagic.ID, "BlockWarpwoodSapling", 1, 0, missing),
                4,
                new AspectList().add(Aspect.getAspect("alienis"), 16).add(Aspect.getAspect("arbor"), 16)
                        .add(Aspect.getAspect("tenebrae"), 12).add(Aspect.getAspect("vitium"), 8)
                        .add(Aspect.getAspect("permutatio"), 8),
                getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing), });
        TCHelper.addResearchPage(
                "WarpTreeGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(TaintedMagic.ID, "BlockWarpwoodSapling", 1, 0, missing))));
        TCHelper.addResearchPage(
                "WarpTreeGTNH",
                new ResearchPage(
                        TCHelper.findCraftingRecipe(
                                getModItem(TaintedMagic.ID, "BlockWarpwoodPlanks", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("WarpTreeGTNH", 3);
        TCHelper.orphanResearch("WARPEDGOGGLES");
        TCHelper.removeResearch("WARPEDGOGGLES");
        new ResearchItem(
                "WarpedGogglesGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("alienis"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("sensus"), 6)
                        .add(Aspect.getAspect("aer"), 3),
                2,
                3,
                3,
                getModItem(TaintedMagic.ID, "ItemWarpedGoggles", 1, 0, missing)).setParents("ShadowmetalGTNH")
                        .setParentsHidden("EvilshardsGTNH").registerResearchItem();
        TCHelper.addResearchPrereq("WarpedGogglesGTNH", "GOGGLES", false);
        ResearchCategories.getResearch("WarpedGogglesGTNH").setConcealed();
        TCHelper.addResearchPage("WarpedGogglesGTNH", new ResearchPage("tm.text.WARPEDGOGGLES.1"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "WarpedGogglesGTNH",
                getModItem(TaintedMagic.ID, "ItemWarpedGoggles", 1, 0, missing),
                5,
                new AspectList().add(Aspect.getAspect("alienis"), 40).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("tenebrae"), 24).add(Aspect.getAspect("tutamen"), 16)
                        .add(Aspect.getAspect("sensus"), 8),
                getModItem(Thaumcraft.ID, "ItemGoggles", 1, 0, missing),
                new ItemStack[] { getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.lens, Materials.InfusedEntropy, 1L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.lens, Materials.InfusedEntropy, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L), });
        TCHelper.addResearchPage(
                "WarpedGogglesGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemWarpedGoggles", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("WarpedGogglesGTNH", 1);
        TCHelper.orphanResearch("FOCUSSHARD");
        TCHelper.removeResearch("FOCUSSHARD");
        new ResearchItem(
                "FocusShardGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("motus"), 18).add(Aspect.getAspect("vitreus"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("aer"), 9)
                        .add(Aspect.getAspect("perditio"), 6).add(Aspect.getAspect("ordo"), 3),
                3,
                1,
                3,
                getModItem(TaintedMagic.ID, "ItemFocusVisShard", 1, 0, missing))
                        .setParents("EvilshardsGTNH", "FOCUSFIRE").setConcealed()
                        .setPages(new ResearchPage("tm.text.FOCUSSHARD.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FocusShardGTNH",
                getModItem(TaintedMagic.ID, "ItemFocusVisShard", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("aer"), 50)
                        .add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing),
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing),
                'd',
                getModItem(Thaumcraft.ID, "ItemWispEssence", 1, wildcard, missing),
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3, missing),
                'f',
                getModItem(Thaumcraft.ID, "ItemWispEssence", 1, wildcard, missing),
                'g',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4, missing),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing),
                'i',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4, missing));
        TCHelper.addResearchPage(
                "FocusShardGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemFocusVisShard", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("FocusShardGTNH", 1);
        TCHelper.orphanResearch("MACEFOCUS");
        TCHelper.removeResearch("MACEFOCUS");
        new ResearchItem(
                "MaceFocusGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("perditio"), 18).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("telum"), 9)
                        .add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("cognitio"), 3),
                0,
                4,
                3,
                getModItem(TaintedMagic.ID, "ItemFocusMageMace", 1, 0, missing)).setParentsHidden("TAINTEDMAGIC")
                        .setParents("ShadowmetalGTNH", "FOCUSFIRE").setConcealed()
                        .setPages(new ResearchPage("tm.text.MACEFOCUS.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "MaceFocusGTNH",
                getModItem(TaintedMagic.ID, "ItemFocusMageMace", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("metallum"), 16).add(Aspect.getAspect("perditio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 48).add(Aspect.getAspect("telum"), 64)
                        .add(Aspect.getAspect("cognitio"), 8),
                getModItem(TaintedMagic.ID, "ItemShadowmetalSword", 1, 0, missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.block, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Shadow, 1L),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 5, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.stick, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.NetherQuartz, 1L),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 5, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Shadow, 1L), });
        TCHelper.addResearchPage(
                "MaceFocusGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusMageMace", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("MaceFocusGTNH", 1);
        TCHelper.orphanResearch("SHADOWCLOTH");
        TCHelper.removeResearch("SHADOWCLOTH");
        new ResearchItem(
                "ShadowClothGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("pannus"), 15).add(Aspect.getAspect("tenebrae"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("tutamen"), 3),
                -1,
                2,
                3,
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing)).setParents("ShadowmetalGTNH", "ENCHFABRIC")
                        .setConcealed().setPages(new ResearchPage("tm.text.SHADOWCLOTH.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ShadowClothGTNH",
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                'b',
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Shadow, 1L),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                'd',
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Shadow, 1L),
                'e',
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Thaumium, 1L),
                'f',
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Shadow, 1L),
                'g',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                'h',
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Shadow, 1L),
                'i',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing));
        TCHelper.addResearchPage(
                "ShadowClothGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing))));
        ThaumcraftApi.addWarpToResearch("ShadowClothGTNH", 2);
        TCHelper.orphanResearch("CREATIONSHARD");
        TCHelper.removeResearch("CREATIONSHARD");
        new ResearchItem(
                "CreationShardGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("aer"), 21).add(Aspect.getAspect("aqua"), 21)
                        .add(Aspect.getAspect("ignis"), 21).add(Aspect.getAspect("terra"), 21)
                        .add(Aspect.getAspect("ordo"), 21).add(Aspect.getAspect("perditio"), 21),
                8,
                -5,
                3,
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 5, missing)).setParents("TMELDRITCHMAJOR", "PRIMPEARL")
                        .setConcealed().setPages(new ResearchPage("tm.text.CREATIONSHARD.1")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "CreationShardGTNH",
                NHItemList.VoidEssence.getIS(2),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 16, missing),
                new AspectList().add(Aspect.getAspect("alienis"), 16).add(Aspect.getAspect("vacuos"), 16)
                        .add(Aspect.getAspect("tenebrae"), 16));
        TCHelper.addResearchPage(
                "CreationShardGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(NHItemList.VoidEssence.getIS(1))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CreationShardGTNH",
                getModItem(TaintedMagic.ID, "ItemMaterial", 2, 5, missing),
                12,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("vacuos"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("auram"), 64)
                        .add(Aspect.getAspect("tenebrae"), 64),
                getModItem(Minecraft.ID, "nether_star", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 1, missing), NHItemList.VoidEssence.getIS(1),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 4, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 5, missing), NHItemList.VoidEssence.getIS(1),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing), });
        TCHelper.addResearchPage(
                "CreationShardGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 5, missing))));
        ThaumcraftApi.addWarpToResearch("CreationShardGTNH", 10);
        TCHelper.orphanResearch("ELDRITCHFOCUS");
        TCHelper.removeResearch("ELDRITCHFOCUS");
        new ResearchItem(
                "EldritchFocusGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("alienis"), 18).add(Aspect.getAspect("perditio"), 15)
                        .add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("tenebrae"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("ira"), 3),
                8,
                -4,
                3,
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1, 0, missing))
                        .setParentsHidden("ShadowmetalGTNH", "EvilshardsGTNH")
                        .setParents("CreationShardGTNH", "FOCUSPORTABLEHOLE").setConcealed()
                        .setPages(new ResearchPage("tm.text.ELDRITCHFOCUS.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "EldritchFocusGTNH",
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("aer"), 84).add(Aspect.getAspect("alienis"), 72)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("tenebrae"), 64)
                        .add(Aspect.getAspect("ira"), 32).add(Aspect.getAspect("potentia"), 16),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 5, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "FocusPortableHole", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 15, missing),
                        getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 15, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 15, missing),
                        getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 15, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L), });
        TCHelper.addResearchPage(
                "EldritchFocusGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1, 0, missing))));
        TCHelper.addResearchPage("EldritchFocusGTNH", new ResearchPage("tm.text.ELDRITCHFOCUS.2"));
        ThaumcraftApi.addWarpToResearch("EldritchFocusGTNH", 4);
        TCHelper.orphanResearch("CRYSTALDAGGER");
        TCHelper.removeResearch("CRYSTALDAGGER");
        new ResearchItem(
                "CrystalDaggerGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("telum"), 18).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("sano"), 12).add(Aspect.getAspect("fames"), 9)
                        .add(Aspect.getAspect("infernus"), 6).add(Aspect.getAspect("lucrum"), 3),
                0,
                -3,
                3,
                getModItem(TaintedMagic.ID, "ItemCrystalDagger", 1, 0, missing)).setParents("TAINTEDMAGIC")
                        .setParentsHidden("ShadowmetalGTNH").registerResearchItem();
        TCHelper.addResearchPrereq("CrystalDaggerGTNH", "ENCHFABRIC", false);
        TCHelper.addResearchPrereq("CrystalDaggerGTNH", "ESSENTIACRYSTAL", false);
        TCHelper.addResearchPrereq("CrystalDaggerGTNH", "VOIDMETAL", false);
        ResearchCategories.getResearch("CrystalDaggerGTNH").setConcealed();
        TCHelper.addResearchPage("CrystalDaggerGTNH", new ResearchPage("tm.text.CRYSTALDAGGER.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CrystalDaggerGTNH",
                getModItem(TaintedMagic.ID, "ItemCrystalDagger", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 100).add(Aspect.getAspect("ignis"), 100)
                        .add(Aspect.getAspect("perditio"), 100).add(Aspect.getAspect("ordo"), 50)
                        .add(Aspect.getAspect("aer"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                "craftingToolWrench",
                'c',
                createItemStack(
                        TinkersGregworks.ID,
                        "tGregToolPartKnifeBlade",
                        1,
                        1622,
                        "{material:\"Shadow\"}",
                        missing),
                'e',
                getModItem(Thaumcraft.ID, "blockTube", 1, 7, missing),
                'g',
                getModItem(Forestry.ID, "oakStick", 1, 0, missing),
                'h',
                "craftingToolScrewdriver",
                'i',
                "screwThaumium");
        TCHelper.addResearchPage(
                "CrystalDaggerGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemCrystalDagger", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("CrystalDaggerGTNH", 3);
        TCHelper.orphanResearch("CRIMSONROBES");
        TCHelper.removeResearch("CRIMSONROBES");
        new ResearchItem(
                "CrimsonRobesGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("pannus"), 18).add(Aspect.getAspect("permutatio"), 15)
                        .add(Aspect.getAspect("tutamen"), 12).add(Aspect.getAspect("alienis"), 9)
                        .add(Aspect.getAspect("tenebrae"), 6).add(Aspect.getAspect("praecantatio"), 3),
                -2,
                -5,
                3,
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing)).setParentsHidden("TAINTEDMAGIC")
                        .setParents("CrystalDaggerGTNH").registerResearchItem();
        TCHelper.addResearchPrereq("CrimsonRobesGTNH", "ShadowClothGTNH", true);
        TCHelper.addResearchPrereq("CrimsonRobesGTNH", "VOIDMETAL", false);
        ResearchCategories.getResearch("CrimsonRobesGTNH").setConcealed();
        TCHelper.addResearchPage("CrimsonRobesGTNH", new ResearchPage("tc.research_page.CrimsonRobesGTNH"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CrimsonRobesGTNH",
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("terra"), 25).add(Aspect.getAspect("ignis"), 25)
                        .add(Aspect.getAspect("perditio"), 25).add(Aspect.getAspect("aqua"), 25)
                        .add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("aer"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "foilVoid",
                'b',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7, missing),
                'c',
                "foilVoid",
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7, missing),
                'e',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7, missing),
                'g',
                "foilVoid",
                'h',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7, missing),
                'i',
                "foilVoid");
        TCHelper.addResearchPage(
                "CrimsonRobesGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing))));
        ThaumcraftApi.addWarpToResearch("CrimsonRobesGTNH", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CrimsonRobesGTNH",
                getModItem(Thaumcraft.ID, "ItemHelmetCultistRobe", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("aqua"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("aer"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'b',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'e',
                "plateVoid",
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'h',
                "plateVoid");
        TCHelper.addResearchPage(
                "CrimsonRobesGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemHelmetCultistRobe", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CrimsonRobesGTNH",
                getModItem(Thaumcraft.ID, "ItemChestplateCultistRobe", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("aqua"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("aer"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'b',
                "plateVoid",
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'e',
                "plateVoid",
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'g',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'h',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'i',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing));
        TCHelper.addResearchPage(
                "CrimsonRobesGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(Thaumcraft.ID, "ItemChestplateCultistRobe", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CrimsonRobesGTNH",
                getModItem(Thaumcraft.ID, "ItemLeggingsCultistRobe", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("aqua"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("aer"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'b',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'e',
                "plateVoid",
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'g',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'h',
                "plateVoid",
                'i',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing));
        TCHelper.addResearchPage(
                "CrimsonRobesGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(Thaumcraft.ID, "ItemLeggingsCultistRobe", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CrimsonRobesGTNH",
                getModItem(Thaumcraft.ID, "ItemBootsCultist", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("perditio"), 30).add(Aspect.getAspect("aqua"), 30)
                        .add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("aer"), 30),
                "abc",
                "def",
                "ghi",
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'e',
                "plateVoid",
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'g',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'h',
                "plateVoid",
                'i',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing));
        TCHelper.addResearchPage(
                "CrimsonRobesGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemBootsCultist", 1, 0, missing))));
        TCHelper.addResearchPrereq("BLOODLUSTUPGRADE", "CrystalDaggerGTNH", false);
        ResearchCategories.getResearch("BLOODLUSTUPGRADE").setConcealed();
        TCHelper.setResearchAspects(
                "BLOODLUSTUPGRADE",
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("sano"), 12)
                        .add(Aspect.getAspect("telum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("ira"), 3));
        TCHelper.setResearchComplexity("BLOODLUSTUPGRADE", 3);
        ThaumcraftApi.addWarpToResearch("BLOODLUSTUPGRADE", 2);
        TCHelper.orphanResearch("KNIGHTROBES");
        TCHelper.removeResearch("KNIGHTROBES");
        new ResearchItem(
                "KnightRobesGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("pannus"), 21).add(Aspect.getAspect("permutatio"), 18)
                        .add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("alienis"), 12)
                        .add(Aspect.getAspect("tenebrae"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("metallum"), 3),
                -4,
                -4,
                3,
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing))
                        .setParents("ELDRITCHMINOR", "CrimsonRobesGTNH").setConcealed()
                        .setPages(new ResearchPage("tm.text.KNIGHTROBES.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "KnightRobesGTNH",
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                6,
                new AspectList().add(Aspect.getAspect("metallum"), 32).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("tenebrae"), 32).add(Aspect.getAspect("alienis"), 32)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("fames"), 32),
                GTOreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Thaumium, 1L),
                new ItemStack[] { getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.FierySteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Ultimet, 1L),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Knightmetal, 1L),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.AstralSilver, 1L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.FierySteel, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7, missing),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.FierySteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Ultimet, 1L),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.Knightmetal, 1L),
                        GTOreDictUnificator.get(OrePrefixes.foil, Materials.AstralSilver, 1L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.FierySteel, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7, missing), });
        TCHelper.addResearchPage(
                "KnightRobesGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing))));
        ThaumcraftApi.addWarpToResearch("KnightRobesGTNH", 4);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "KnightRobesGTNH",
                getModItem(Thaumcraft.ID, "ItemHelmetCultistPlate", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 50).add(Aspect.getAspect("ignis"), 50)
                        .add(Aspect.getAspect("perditio"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("aer"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'b',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'e',
                "plateShadow",
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'h',
                "plateShadow");
        TCHelper.addResearchPage(
                "KnightRobesGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemHelmetCultistPlate", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "KnightRobesGTNH",
                getModItem(Thaumcraft.ID, "ItemChestplateCultistPlate", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 50).add(Aspect.getAspect("ignis"), 50)
                        .add(Aspect.getAspect("perditio"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("aer"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'b',
                "plateShadow",
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'e',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'g',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'h',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'i',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing));
        TCHelper.addResearchPage(
                "KnightRobesGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(Thaumcraft.ID, "ItemChestplateCultistPlate", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "KnightRobesGTNH",
                getModItem(Thaumcraft.ID, "ItemLeggingsCultistPlate", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 50).add(Aspect.getAspect("ignis"), 50)
                        .add(Aspect.getAspect("perditio"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("aer"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'b',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'e',
                "plateShadow",
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'g',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'h',
                "plateShadow",
                'i',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing));
        TCHelper.addResearchPage(
                "KnightRobesGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(Thaumcraft.ID, "ItemLeggingsCultistPlate", 1, 0, missing))));
        TCHelper.orphanResearch("PRAETORARMOR");
        TCHelper.removeResearch("PRAETORARMOR");
        new ResearchItem(
                "PraetorarmorGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("pannus"), 24).add(Aspect.getAspect("permutatio"), 21)
                        .add(Aspect.getAspect("tutamen"), 18).add(Aspect.getAspect("alienis"), 15)
                        .add(Aspect.getAspect("tenebrae"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("potentia"), 3),
                -6,
                -4,
                3,
                getModItem(Thaumcraft.ID, "ItemHelmetCultistLeaderPlate", 1, 0, missing)).setParents("KnightRobesGTNH")
                        .setConcealed().setPages(new ResearchPage("tm.text.PRAETORARMOR.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "PraetorarmorGTNH",
                getModItem(Thaumcraft.ID, "ItemHelmetCultistLeaderPlate", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("metallum"), 64).add(Aspect.getAspect("praecantatio"), 64)
                        .add(Aspect.getAspect("tenebrae"), 64).add(Aspect.getAspect("alienis"), 64)
                        .add(Aspect.getAspect("tutamen"), 64),
                getModItem(Thaumcraft.ID, "ItemHelmetCultistPlate", 1, 0, missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 1L), });
        TCHelper.addResearchPage(
                "PraetorarmorGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(Thaumcraft.ID, "ItemHelmetCultistLeaderPlate", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("PraetorarmorGTNH", 5);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "PraetorarmorGTNH",
                getModItem(Thaumcraft.ID, "ItemChestplateCultistLeaderPlate", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("metallum"), 64).add(Aspect.getAspect("praecantatio"), 64)
                        .add(Aspect.getAspect("tenebrae"), 64).add(Aspect.getAspect("alienis"), 64)
                        .add(Aspect.getAspect("tutamen"), 64),
                getModItem(Thaumcraft.ID, "ItemChestplateCultistPlate", 1, 0, missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 1L), });
        TCHelper.addResearchPage(
                "PraetorarmorGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(Thaumcraft.ID, "ItemChestplateCultistLeaderPlate", 1, 0, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "PraetorarmorGTNH",
                getModItem(Thaumcraft.ID, "ItemLeggingsCultistLeaderPlate", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("metallum"), 64).add(Aspect.getAspect("praecantatio"), 64)
                        .add(Aspect.getAspect("tenebrae"), 64).add(Aspect.getAspect("alienis"), 64)
                        .add(Aspect.getAspect("tutamen"), 64),
                getModItem(Thaumcraft.ID, "ItemLeggingsCultistPlate", 1, 0, missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Shadow, 1L), });
        TCHelper.addResearchPage(
                "PraetorarmorGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(Thaumcraft.ID, "ItemLeggingsCultistLeaderPlate", 1, 0, missing))));
        TCHelper.orphanResearch("VOIDSENTBLOOD");
        TCHelper.removeResearch("VOIDSENTBLOOD");
        new ResearchItem(
                "VoidsentGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("tenebrae"), 33).add(Aspect.getAspect("tutamen"), 18)
                        .add(Aspect.getAspect("vacuos"), 15).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("alienis"), 3),
                -7,
                -5,
                3,
                getModItem(TaintedMagic.ID, "ItemVoidsentBlood", 1, 0, missing)).setParents("PraetorarmorGTNH")
                        .setConcealed().setPages(new ResearchPage("tm.text.VOIDSENTBLOOD.1")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "VoidsentGTNH",
                getModItem(TaintedMagic.ID, "ItemVoidsentBlood", 1, 0, missing),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("tenebrae"), 12)
                        .add(Aspect.getAspect("tutamen"), 12).add(Aspect.getAspect("vacuos"), 16)
                        .add(Aspect.getAspect("alienis"), 16));
        TCHelper.addResearchPage(
                "VoidsentGTNH",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(TaintedMagic.ID, "ItemVoidsentBlood", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("VoidsentGTNH", 2);
        TCHelper.orphanResearch("CRIMSONBLADE");
        TCHelper.removeResearch("CRIMSONBLADE");
        new ResearchItem(
                "CrimsonBladeGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("perditio"), 18).add(Aspect.getAspect("telum"), 15)
                        .add(Aspect.getAspect("vacuos"), 12).add(Aspect.getAspect("tenebrae"), 9)
                        .add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("potentia"), 3),
                -7,
                -3,
                3,
                getModItem(Thaumcraft.ID, "ItemSwordCrimson", 1, 0, missing)).setParents("PraetorarmorGTNH")
                        .setConcealed().setPages(new ResearchPage("tm.text.CRIMSONBLADE.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CrimsonBladeGTNH",
                getModItem(Thaumcraft.ID, "ItemSwordCrimson", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("alienis"), 16).add(Aspect.getAspect("metallum"), 24)
                        .add(Aspect.getAspect("perditio"), 32).add(Aspect.getAspect("telum"), 64)
                        .add(Aspect.getAspect("vacuos"), 48).add(Aspect.getAspect("tenebrae"), 32),
                getModItem(Thaumcraft.ID, "ItemSwordVoid", 1, 0, missing),
                new ItemStack[] { getModItem(TaintedMagic.ID, "ItemCrystalDagger", 1, 0, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7, missing), });
        TCHelper.addResearchPage(
                "CrimsonBladeGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "ItemSwordCrimson", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("CrimsonBladeGTNH", 5);
        TCHelper.orphanResearch("VOIDGOGGLES");
        TCHelper.removeResearch("VOIDGOGGLES");
        new ResearchItem(
                "VoidgogglesGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("sensus"), 21).add(Aspect.getAspect("vacuos"), 18)
                        .add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("tenebrae"), 12)
                        .add(Aspect.getAspect("vitreus"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("metallum"), 3),
                3,
                5,
                3,
                getModItem(TaintedMagic.ID, "ItemVoidmetalGoggles", 1, 0, missing))
                        .setParents("WarpedGogglesGTNH", "VOIDMETAL").setConcealed()
                        .setPages(new ResearchPage("tm.text.VOIDGOGGLES.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "VoidgogglesGTNH",
                getModItem(TaintedMagic.ID, "ItemVoidmetalGoggles", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("sensus"), 32).add(Aspect.getAspect("tenebrae"), 32)
                        .add(Aspect.getAspect("tutamen"), 48).add(Aspect.getAspect("vacuos"), 64)
                        .add(Aspect.getAspect("vitreus"), 24).add(Aspect.getAspect("alienis"), 8)
                        .add(Aspect.getAspect("metallum"), 16),
                getModItem(TaintedMagic.ID, "ItemWarpedGoggles", 1, 0, missing),
                new ItemStack[] { getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.lens, Materials.NetherStar, 1L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.bolt, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.lens, Materials.NetherStar, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L), });
        TCHelper.addResearchPage(
                "VoidgogglesGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(TaintedMagic.ID, "ItemVoidmetalGoggles", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("VoidgogglesGTNH", 5);
        TCHelper.orphanResearch("TAINTFOCUS");
        TCHelper.removeResearch("TAINTFOCUS");
        new ResearchItem(
                "TaintFocusGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("vitium"), 18).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("limus"), 12).add(Aspect.getAspect("aer"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("potentia"), 3),
                5,
                2,
                3,
                getModItem(TaintedMagic.ID, "ItemFocusTaint", 1, 0, missing))
                        .setParents("EvilshardsGTNH", "BOTTLETAINT", "TAINTSHOVEL").setConcealed()
                        .setPages(new ResearchPage("tm.text.TAINTFOCUS.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "TaintFocusGTNH",
                getModItem(TaintedMagic.ID, "ItemFocusTaint", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("aqua"), 72).add(Aspect.getAspect("limus"), 72)
                        .add(Aspect.getAspect("praecantatio"), 72).add(Aspect.getAspect("vitium"), 72)
                        .add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("potentia"), 32),
                getModItem(Thaumcraft.ID, "FocusPech", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemResource", 1, 11, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4, missing),
                        getModItem(ForbiddenMagic.ID, "NetherShard", 1, 2, missing),
                        getModItem(Thaumcraft.ID, "ItemBottleTaint", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 12, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 11, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 12, missing),
                        getModItem(Thaumcraft.ID, "ItemBottleTaint", 1, 0, missing),
                        getModItem(ForbiddenMagic.ID, "NetherShard", 1, 2, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 11, missing), });
        TCHelper.addResearchPage(
                "TaintFocusGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusTaint", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("TaintFocusGTNH", 4);
        TCHelper.orphanResearch("FOCUSTAINTEDBLAST");
        TCHelper.removeResearch("FOCUSTAINTEDBLAST");
        new ResearchItem(
                "FocusTaintedBlastGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("praecantatio"), 21).add(Aspect.getAspect("vitium"), 18)
                        .add(Aspect.getAspect("motus"), 18).add(Aspect.getAspect("aer"), 12)
                        .add(Aspect.getAspect("perditio"), 9).add(Aspect.getAspect("telum"), 6),
                5,
                3,
                3,
                getModItem(TaintedMagic.ID, "ItemFocusTaintedBlast", 1, 0, missing))
                        .setParents("TaintFocusGTNH", "FOCUSFIRE", "ELDRITCHMINOR", "FOCUSSHOCK").setConcealed()
                        .setPages(new ResearchPage("tm.text.FOCUSTAINTEDBLAST.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FocusTaintedBlastGTNH",
                getModItem(TaintedMagic.ID, "ItemFocusTaintedBlast", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("motus"), 64).add(Aspect.getAspect("praecantatio"), 80)
                        .add(Aspect.getAspect("telum"), 72).add(Aspect.getAspect("vitium"), 84)
                        .add(Aspect.getAspect("cognitio"), 32).add(Aspect.getAspect("aer"), 48),
                getModItem(TaintedMagic.ID, "ItemFocusTaint", 1, 0, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemBottleTaint", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 11, missing),
                        getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 15, missing),
                        getModItem(Thaumcraft.ID, "ItemBottleTaint", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemBottleTaint", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 15, missing),
                        getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 11, missing),
                        getModItem(Thaumcraft.ID, "ItemBottleTaint", 1, 0, missing), });
        TCHelper.addResearchPage(
                "FocusTaintedBlastGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(TaintedMagic.ID, "ItemFocusTaintedBlast", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("FocusTaintedBlastGTNH", 6);
        TCHelper.orphanResearch("THAUMICDISASSEMBLER");
        TCHelper.removeResearch("THAUMICDISASSEMBLER");
        new ResearchItem(
                "ThaumicdisassemblerGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("telum"), 18).add(Aspect.getAspect("metallum"), 15)
                        .add(Aspect.getAspect("instrumentum"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("alienis"), 6).add(Aspect.getAspect("vitium"), 3),
                5,
                -6,
                3,
                getModItem(TaintedMagic.ID, "ItemThaumicDisassembler", 1, 0, missing))
                        .setParents("TMELDRITCHMAJOR", "VOIDMETAL").setConcealed()
                        .setPages(new ResearchPage("tm.text.THAUMICDISASSEMBLER.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ThaumicdisassemblerGTNH",
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 75).add(Aspect.getAspect("perditio"), 75)
                        .add(Aspect.getAspect("terra"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                "plateVoid",
                'b',
                "plateThaumium",
                'c',
                "plateVoid",
                'd',
                "plateShadow",
                'e',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing),
                'f',
                "plateShadow",
                'g',
                "plateVoid",
                'h',
                "plateThaumium",
                'i',
                "plateVoid");
        TCHelper.addResearchPage(
                "ThaumicdisassemblerGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 6, missing))));
        ThaumcraftApi.addWarpToResearch("ThaumicdisassemblerGTNH", 4);
        TCHelper.addResearchPage("ThaumicdisassemblerGTNH", new ResearchPage("tm.text.THAUMICDISASSEMBLER.2"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ThaumicdisassemblerGTNH",
                getModItem(TaintedMagic.ID, "ItemThaumicDisassembler", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("instrumentum"), 32).add(Aspect.getAspect("metallum"), 32)
                        .add(Aspect.getAspect("telum"), 24).add(Aspect.getAspect("vacuos"), 24)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("potentia"), 16),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 6, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemPickVoid", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        getModItem(Thaumcraft.ID, "ItemShovelVoid", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        getModItem(Thaumcraft.ID, "ItemSwordVoid", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        getModItem(Thaumcraft.ID, "ItemAxeVoid", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L), });
        TCHelper.addResearchPage(
                "ThaumicdisassemblerGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(TaintedMagic.ID, "ItemThaumicDisassembler", 1, 0, missing))));
        TCHelper.orphanResearch("VOIDWALKERBOOTS");
        TCHelper.removeResearch("VOIDWALKERBOOTS");
        new ResearchItem(
                "VoidWalkerBootsGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("tenebrae"), 21).add(Aspect.getAspect("tutamen"), 18)
                        .add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("iter"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("volatus"), 3),
                4,
                -8,
                3,
                getModItem(TaintedMagic.ID, "ItemVoidwalkerBoots", 1, 0, missing))
                        .setParents("TMELDRITCHMAJOR", "BOOTSTRAVELLER")
                        .setParentsHidden("TAINTEDMAGIC", "ShadowmetalGTNH").setConcealed()
                        .setPages(new ResearchPage("tm.text.VOIDWALKERBOOTS.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "VoidWalkerBootsGTNH",
                getModItem(TaintedMagic.ID, "ItemVoidwalkerBoots", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("iter"), 84)
                        .add(Aspect.getAspect("tenebrae"), 72).add(Aspect.getAspect("tutamen"), 64)
                        .add(Aspect.getAspect("vacuos"), 64).add(Aspect.getAspect("praecantatio"), 32),
                getModItem(Thaumcraft.ID, "BootsTraveller", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Polytetrafluoroethylene, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Polytetrafluoroethylene, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L), });
        TCHelper.addResearchPage(
                "VoidWalkerBootsGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(TaintedMagic.ID, "ItemVoidwalkerBoots", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("VoidWalkerBootsGTNH", 4);
        TCHelper.orphanResearch("VOIDSASH");
        TCHelper.removeResearch("VOIDSASH");
        new ResearchItem(
                "VoidSashGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("metallum"), 24).add(Aspect.getAspect("vacuos"), 21)
                        .add(Aspect.getAspect("tutamen"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("tenebrae"), 9)
                        .add(Aspect.getAspect("iter"), 6).add(Aspect.getAspect("aer"), 3),
                3,
                -8,
                3,
                getModItem(TaintedMagic.ID, "ItemVoidwalkerSash", 1, 0, missing))
                        .setParents("VoidWalkerBootsGTNH", "RUNICARMOR")
                        .setParentsHidden("TAINTEDMAGIC", "ShadowmetalGTNH").registerResearchItem();
        TCHelper.addResearchPrereq("VoidSashGTNH", "VOIDMETAL", false);
        ResearchCategories.getResearch("VoidSashGTNH").setConcealed();
        TCHelper.addResearchPage("VoidSashGTNH", new ResearchPage("tm.text.VOIDSASH.1"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "VoidSashGTNH",
                getModItem(TaintedMagic.ID, "ItemVoidwalkerSash", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("iter"), 48).add(Aspect.getAspect("praecantatio"), 64)
                        .add(Aspect.getAspect("tutamen"), 84).add(Aspect.getAspect("vacuos"), 72)
                        .add(Aspect.getAspect("volatus"), 32).add(Aspect.getAspect("alienis"), 24)
                        .add(Aspect.getAspect("aer"), 16),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemGirdleRunic", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Tanzanite, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L), });
        TCHelper.addResearchPage(
                "VoidSashGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidwalkerSash", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("VoidSashGTNH", 4);
        TCHelper.orphanResearch("VOIDFORTRESS");
        TCHelper.removeResearch("VOIDFORTRESS");
        new ResearchItem(
                "VoidFortressGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("tutamen"), 21).add(Aspect.getAspect("vacuos"), 18)
                        .add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("tenebrae"), 12)
                        .add(Aspect.getAspect("victus"), 9).add(Aspect.getAspect("cognitio"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                7,
                -8,
                3,
                getModItem(TaintedMagic.ID, "ItemVoidFortressHelmet", 1, 0, missing))
                        .setParents("TMELDRITCHMAJOR", "VOIDMETAL", "ARMORFORTRESS").setParentsHidden("ShadowmetalGTNH")
                        .setConcealed().setPages(new ResearchPage("tm.text.VOIDFORTRESS.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "VoidFortressGTNH",
                getModItem(TaintedMagic.ID, "ItemVoidFortressHelmet", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("alienis"), 32).add(Aspect.getAspect("metallum"), 48)
                        .add(Aspect.getAspect("praecantatio"), 48).add(Aspect.getAspect("tutamen"), 48)
                        .add(Aspect.getAspect("vacuos"), 32).add(Aspect.getAspect("tenebrae"), 16)
                        .add(Aspect.getAspect("potentia"), 16).add(Aspect.getAspect("victus"), 32),
                getModItem(Thaumcraft.ID, "ItemHelmetVoid", 1, 0, missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Emerald, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Polytetrafluoroethylene, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L), });
        TCHelper.addResearchPage(
                "VoidFortressGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(TaintedMagic.ID, "ItemVoidFortressHelmet", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("VoidFortressGTNH", 5);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "VoidFortressGTNH",
                getModItem(TaintedMagic.ID, "ItemVoidFortressChestplate", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("alienis"), 32).add(Aspect.getAspect("metallum"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("tutamen"), 64)
                        .add(Aspect.getAspect("vacuos"), 32).add(Aspect.getAspect("tenebrae"), 16)
                        .add(Aspect.getAspect("potentia"), 16).add(Aspect.getAspect("cognitio"), 32),
                getModItem(Thaumcraft.ID, "ItemChestplateVoid", 1, 0, missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Polytetrafluoroethylene, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Polytetrafluoroethylene, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L), });
        TCHelper.addResearchPage(
                "VoidFortressGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(TaintedMagic.ID, "ItemVoidFortressChestplate", 1, 0, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "VoidFortressGTNH",
                getModItem(TaintedMagic.ID, "ItemVoidFortressLeggings", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("alienis"), 32).add(Aspect.getAspect("metallum"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("tutamen"), 32)
                        .add(Aspect.getAspect("vacuos"), 32).add(Aspect.getAspect("tenebrae"), 16)
                        .add(Aspect.getAspect("potentia"), 16).add(Aspect.getAspect("terra"), 32),
                getModItem(Thaumcraft.ID, "ItemLeggingsVoid", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 2, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Polytetrafluoroethylene, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L), });
        TCHelper.addResearchPage(
                "VoidFortressGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(TaintedMagic.ID, "ItemVoidFortressLeggings", 1, 0, missing))));
        TCHelper.orphanResearch("SHADOWFORTRESSARMOR");
        TCHelper.removeResearch("SHADOWFORTRESSARMOR");
        new ResearchItem(
                "ShadowFortressArmorGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("tutamen"), 24).add(Aspect.getAspect("vacuos"), 21)
                        .add(Aspect.getAspect("alienis"), 18).add(Aspect.getAspect("tenebrae"), 15)
                        .add(Aspect.getAspect("victus"), 12).add(Aspect.getAspect("cognitio"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("superbia"), 3),
                8,
                -9,
                3,
                getModItem(TaintedMagic.ID, "ItemShadowFortressHelmet", 1, 0, missing)).setParents("VoidFortressGTNH")
                        .setParentsHidden("ShadowmetalGTNH").setConcealed()
                        .setPages(new ResearchPage("tm.text.SHADOWFORTRESSARMOR.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ShadowFortressArmorGTNH",
                getModItem(TaintedMagic.ID, "ItemShadowFortressHelmet", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("alienis"), 48).add(Aspect.getAspect("metallum"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("tutamen"), 64)
                        .add(Aspect.getAspect("vacuos"), 48).add(Aspect.getAspect("tenebrae"), 32)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("victus"), 48),
                getModItem(TaintedMagic.ID, "ItemVoidFortressHelmet", 1, 0, missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Emerald, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Shadow, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Polybenzimidazole, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L), });
        TCHelper.addResearchPage(
                "ShadowFortressArmorGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(TaintedMagic.ID, "ItemShadowFortressHelmet", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ShadowFortressArmorGTNH", 10);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ShadowFortressArmorGTNH",
                getModItem(TaintedMagic.ID, "ItemShadowFortressChestplate", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("alienis"), 48).add(Aspect.getAspect("metallum"), 84)
                        .add(Aspect.getAspect("praecantatio"), 84).add(Aspect.getAspect("tutamen"), 84)
                        .add(Aspect.getAspect("vacuos"), 48).add(Aspect.getAspect("tenebrae"), 32)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("cognitio"), 48),
                getModItem(TaintedMagic.ID, "ItemVoidFortressChestplate", 1, 0, missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.block, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Shadow, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Polybenzimidazole, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Polybenzimidazole, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Shadow, 1L), });
        TCHelper.addResearchPage(
                "ShadowFortressArmorGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(TaintedMagic.ID, "ItemShadowFortressChestplate", 1, 0, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ShadowFortressArmorGTNH",
                getModItem(TaintedMagic.ID, "ItemShadowFortressLeggings", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("alienis"), 48).add(Aspect.getAspect("metallum"), 48)
                        .add(Aspect.getAspect("praecantatio"), 48).add(Aspect.getAspect("tutamen"), 48)
                        .add(Aspect.getAspect("vacuos"), 32).add(Aspect.getAspect("tenebrae"), 32)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("terra"), 48),
                getModItem(TaintedMagic.ID, "ItemVoidFortressLeggings", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 2, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Shadow, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Polybenzimidazole, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.block, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L), });
        TCHelper.addResearchPage(
                "ShadowFortressArmorGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(TaintedMagic.ID, "ItemShadowFortressLeggings", 1, 0, missing))));
        TCHelper.orphanResearch("THAUMIUMKATANA");
        TCHelper.removeResearch("THAUMIUMKATANA");
        new ResearchItem(
                "ThaumiumKatanaGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("telum"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("motus"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("mortuus"), 3),
                7,
                1,
                3,
                getModItem(TaintedMagic.ID, "ItemKatana", 1, 0, missing)).setParents("ARMORFORTRESS")
                        .setParentsHidden("ShadowmetalGTNH").setConcealed()
                        .setPages(new ResearchPage("tm.text.THAUMIUMKATANA.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ThaumiumKatanaGTNH",
                getModItem(TaintedMagic.ID, "ItemKatana", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("metallum"), 64).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("telum"), 48).add(Aspect.getAspect("mortuus"), 24)
                        .add(Aspect.getAspect("potentia"), 16).add(Aspect.getAspect("motus"), 8),
                getModItem(Thaumcraft.ID, "ItemSwordThaumium", 1, 0, missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.gemFlawless, Materials.Emerald, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Obsidian, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Gold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.gemFlawless, Materials.Emerald, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Steel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L), });
        TCHelper.addResearchPage(
                "ThaumiumKatanaGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemKatana", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ThaumiumKatanaGTNH", 3);
        TCHelper.orphanResearch("VOIDMETALKATANA");
        TCHelper.removeResearch("VOIDMETALKATANA");
        new ResearchItem(
                "VoidMetalKatanaGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("metallum"), 21).add(Aspect.getAspect("telum"), 18)
                        .add(Aspect.getAspect("vacuos"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("motus"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("mortuus"), 3),
                7,
                0,
                3,
                getModItem(TaintedMagic.ID, "ItemKatana", 1, 1, missing)).setParents("ThaumiumKatanaGTNH")
                        .setParentsHidden("VOIDMETAL").setConcealed()
                        .setPages(new ResearchPage("tm.text.VOIDMETALKATANA.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "VoidMetalKatanaGTNH",
                getModItem(TaintedMagic.ID, "ItemKatana", 1, 1, missing),
                9,
                new AspectList().add(Aspect.getAspect("alienis"), 48).add(Aspect.getAspect("metallum"), 72)
                        .add(Aspect.getAspect("praecantatio"), 48).add(Aspect.getAspect("telum"), 64)
                        .add(Aspect.getAspect("mortuus"), 32).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("motus"), 16).add(Aspect.getAspect("vacuos"), 32),
                getModItem(Thaumcraft.ID, "ItemSwordVoid", 1, 0, missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Emerald, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Manyullyn, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.RoseGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Emerald, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Titanium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L), });
        TCHelper.addResearchPage(
                "VoidMetalKatanaGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemKatana", 1, 1, missing))));
        ThaumcraftApi.addWarpToResearch("VoidMetalKatanaGTNH", 6);
        TCHelper.orphanResearch("SHADOWMETALKATANA");
        TCHelper.removeResearch("SHADOWMETALKATANA");
        new ResearchItem(
                "ShadowMetalKatanaGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("tenebrae"), 24).add(Aspect.getAspect("metallum"), 21)
                        .add(Aspect.getAspect("telum"), 18).add(Aspect.getAspect("vacuos"), 15)
                        .add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("motus"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("mortuus"), 3),
                8,
                -1,
                3,
                getModItem(TaintedMagic.ID, "ItemKatana", 1, 2, missing)).setParents("VoidMetalKatanaGTNH")
                        .setParentsHidden("ShadowmetalGTNH").setConcealed()
                        .setPages(new ResearchPage("tm.text.SHADOWMETALKATANA.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ShadowMetalKatanaGTNH",
                getModItem(TaintedMagic.ID, "ItemKatana", 1, 2, missing),
                12,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("metallum"), 84)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("telum"), 72)
                        .add(Aspect.getAspect("mortuus"), 48).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("motus"), 24).add(Aspect.getAspect("vacuos"), 48)
                        .add(Aspect.getAspect("tenebrae"), 48),
                getModItem(TaintedMagic.ID, "ItemShadowmetalSword", 1, 0, missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Emerald, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.InfusedGold, 1L),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Emerald, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L), });
        TCHelper.addResearchPage(
                "ShadowMetalKatanaGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemKatana", 1, 2, missing))));
        ThaumcraftApi.addWarpToResearch("ShadowMetalKatanaGTNH", 9);
        TCHelper.addResearchPrereq("INSCRIPTIONFIRE", "ThaumiumKatanaGTNH", false);
        ResearchCategories.getResearch("INSCRIPTIONFIRE").setConcealed();
        TCHelper.setResearchAspects(
                "INSCRIPTIONFIRE",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("lux"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("INSCRIPTIONFIRE", 3);
        ThaumcraftApi.addWarpToResearch("INSCRIPTIONFIRE", 2);
        TCHelper.addResearchPrereq("INSCRIPTIONTAINT", "ThaumiumKatanaGTNH", false);
        ResearchCategories.getResearch("INSCRIPTIONTAINT").setConcealed();
        TCHelper.setResearchAspects(
                "INSCRIPTIONTAINT",
                new AspectList().add(Aspect.getAspect("vitium"), 15).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("corpus"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("INSCRIPTIONTAINT", 3);
        ThaumcraftApi.addWarpToResearch("INSCRIPTIONTAINT", 3);
        TCHelper.addResearchPrereq("INSCRIPTIONUNDEAD", "ThaumiumKatanaGTNH", false);
        ResearchCategories.getResearch("INSCRIPTIONUNDEAD").setConcealed();
        TCHelper.setResearchAspects(
                "INSCRIPTIONUNDEAD",
                new AspectList().add(Aspect.getAspect("sano"), 15).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("exanimis"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("potentia"), 3));
        TCHelper.setResearchComplexity("INSCRIPTIONUNDEAD", 3);
        ThaumcraftApi.addWarpToResearch("INSCRIPTIONUNDEAD", 4);
        TCHelper.orphanResearch("ROD_warpwood");
        TCHelper.removeResearch("ROD_warpwood");
        new ResearchItem(
                "ROD_warpwood",
                "TM",
                new AspectList().add(Aspect.getAspect("arbor"), 18).add(Aspect.getAspect("tenebrae"), 15)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("instrumentum"), 6).add(Aspect.getAspect("terra"), 3),
                8,
                -2,
                3,
                getModItem(TaintedMagic.ID, "ItemWandRod", 1, 0, missing)).setParentsHidden("ShadowmetalGTNH")
                        .setParents("WarpTreeGTNH", "VOIDMETAL", "VOIDMETAL", "PRIMPEARL", "ROD_primal_staff")
                        .setConcealed().setPages(new ResearchPage("tm.text.ROD_warpwood.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ROD_warpwood",
                getModItem(TaintedMagic.ID, "ItemWandRod", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("alienis"), 64).add(Aspect.getAspect("arbor"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("tenebrae"), 48)
                        .add(Aspect.getAspect("instrumentum"), 32).add(Aspect.getAspect("terra"), 24),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3, missing),
                new ItemStack[] { getModItem(TaintedMagic.ID, "BlockWarpwoodLog", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Tungsten, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Void, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Tungsten, 1L),
                        getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Tungsten, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Void, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateDouble, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateTriple, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.ring, Materials.Tungsten, 1L), });
        TCHelper.addResearchPage(
                "ROD_warpwood",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemWandRod", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ROD_warpwood", 3);
        TCHelper.addResearchPage("ROD_warpwood", new ResearchPage("tm.text.ROD_warpwood.2"));
        TCHelper.orphanResearch("ROD_warpwood_staff");
        TCHelper.removeResearch("ROD_warpwood_staff");
        new ResearchItem(
                "ROD_warpwood_staff",
                "TM",
                new AspectList().add(Aspect.getAspect("arbor"), 18).add(Aspect.getAspect("tenebrae"), 15)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("instrumentum"), 3),
                9,
                -2,
                3,
                getModItem(TaintedMagic.ID, "ItemWandRod", 1, 1, missing)).setParents("ROD_warpwood").setConcealed()
                        .setPages(new ResearchPage("tm.text.ROD_warpwood_staff.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_warpwood_staff",
                getModItem(TaintedMagic.ID, "ItemWandRod", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 150).add(Aspect.getAspect("terra"), 150)
                        .add(Aspect.getAspect("ignis"), 150).add(Aspect.getAspect("aer"), 150)
                        .add(Aspect.getAspect("ordo"), 150).add(Aspect.getAspect("perditio"), 150),
                "abc",
                "def",
                "ghi",
                'a',
                "screwShadow",
                'b',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4, missing),
                'c',
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3, missing),
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing),
                'e',
                getModItem(TaintedMagic.ID, "ItemWandRod", 1, 0, missing),
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing),
                'g',
                getModItem(TaintedMagic.ID, "ItemWandRod", 1, 0, missing),
                'h',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4, missing),
                'i',
                "screwShadow");
        TCHelper.addResearchPage(
                "ROD_warpwood_staff",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemWandRod", 1, 1, missing))));
        ThaumcraftApi.addWarpToResearch("ROD_warpwood_staff", 5);
        TCHelper.orphanResearch("FOCUSTIME");
        TCHelper.removeResearch("FOCUSTIME");
        new ResearchItem(
                "FocusTimeGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("tempus"), 27).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("aqua"), 21).add(Aspect.getAspect("ignis"), 18)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("perditio"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("permutatio"), 3),
                11,
                -8,
                3,
                getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0, missing))
                        .setParents("CreationShardGTNH", "FOCUSPORTABLEHOLE", "FOCUSFIRE").setConcealed()
                        .setPages(new ResearchPage("tm.text.FOCUSTIME.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FocusTimeGTNH",
                getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("alienis"), 84).add(Aspect.getAspect("lux"), 72)
                        .add(Aspect.getAspect("tenebrae"), 64).add(Aspect.getAspect("vacuos"), 48)
                        .add(Aspect.getAspect("tempus"), 24).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("permutatio"), 16),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 5, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "FocusPortableHole", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing), NHItemList.VoidEssence.getIS(1),
                        getModItem(Minecraft.ID, "clock", 1, 0, missing), NHItemList.VoidEssence.getIS(1),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing), NHItemList.VoidEssence.getIS(1),
                        getModItem(Minecraft.ID, "clock", 1, 0, missing), NHItemList.VoidEssence.getIS(1),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing), });
        TCHelper.addResearchPage(
                "FocusTimeGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("FocusTimeGTNH", 10);
        TCHelper.orphanResearch("FOCUSWEATHER");
        TCHelper.removeResearch("FOCUSWEATHER");
        new ResearchItem(
                "FocusWeatherGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("volatus"), 27).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("aqua"), 21).add(Aspect.getAspect("ignis"), 18)
                        .add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("ordo"), 12)
                        .add(Aspect.getAspect("perditio"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("tempestas"), 3),
                12,
                -7,
                3,
                getModItem(TaintedMagic.ID, "ItemFocusMeteorology", 1, 0, missing))
                        .setParents("CreationShardGTNH", "FOCUSSHOCK", "FOCUSFROST").setConcealed()
                        .setPages(new ResearchPage("tm.text.FOCUSWEATHER.1")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "FocusWeatherGTNH",
                getModItem(TaintedMagic.ID, "ItemFocusMeteorology", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("alienis"), 84).add(Aspect.getAspect("aqua"), 72)
                        .add(Aspect.getAspect("tempestas"), 64).add(Aspect.getAspect("vacuos"), 48)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("volatus"), 24)
                        .add(Aspect.getAspect("perditio"), 16),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 5, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "FocusShock", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing), NHItemList.VoidEssence.getIS(1),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing), NHItemList.VoidEssence.getIS(1),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing),
                        getModItem(Thaumcraft.ID, "FocusFrost", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing), NHItemList.VoidEssence.getIS(1),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing), NHItemList.VoidEssence.getIS(1),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing), });
        TCHelper.addResearchPage(
                "FocusWeatherGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(TaintedMagic.ID, "ItemFocusMeteorology", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("FocusWeatherGTNH", 10);
        TCHelper.orphanResearch("PRIMALBLADE");
        TCHelper.removeResearch("PRIMALBLADE");
        new ResearchItem(
                "PrimalBladeGTNH",
                "TM",
                new AspectList().add(Aspect.getAspect("praecantatio"), 24).add(Aspect.getAspect("alienis"), 21)
                        .add(Aspect.getAspect("telum"), 18).add(Aspect.getAspect("tenebrae"), 15)
                        .add(Aspect.getAspect("vacuos"), 12).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("potentia"), 6).add(Aspect.getAspect("cognitio"), 3),
                11,
                -5,
                3,
                getModItem(TaintedMagic.ID, "ItemPrimordialEdge", 1, 0, missing)).setParents("CreationShardGTNH")
                        .setParentsHidden("EvilshardsGTNH", "CrystalDaggerGTNH").registerResearchItem();
        TCHelper.addResearchPrereq("PrimalBladeGTNH", "VOIDMETAL", false);
        TCHelper.addResearchPrereq("PrimalBladeGTNH", "PRIMALCRUSHER", false);
        ResearchCategories.getResearch("PrimalBladeGTNH").setConcealed();
        TCHelper.addResearchPage("PrimalBladeGTNH", new ResearchPage("tm.text.PRIMALBLADE.1"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "PrimalBladeGTNH",
                getModItem(TaintedMagic.ID, "ItemPrimordialEdge", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("alienis"), 96).add(Aspect.getAspect("metallum"), 84)
                        .add(Aspect.getAspect("telum"), 72).add(Aspect.getAspect("tenebrae"), 64)
                        .add(Aspect.getAspect("vacuos"), 48).add(Aspect.getAspect("auram"), 32)
                        .add(Aspect.getAspect("cognitio"), 24).add(Aspect.getAspect("potentia"), 16),
                getModItem(Thaumcraft.ID, "ItemSwordVoid", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemPrimalCrusher", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 5, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 3, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        NHItemList.VoidEssence.getIS(1),
                        getModItem(TaintedMagic.ID, "ItemCrystalDagger", 1, 0, missing),
                        NHItemList.VoidEssence.getIS(1),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 2, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Shadow, 1L), });
        TCHelper.addResearchPage(
                "PrimalBladeGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemPrimordialEdge", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("PrimalBladeGTNH", 10);
        TCHelper.orphanResearch("CAP_cloth");
        TCHelper.removeResearch("CAP_cloth");
        new ResearchItem(
                "CAP_cloth",
                "TM",
                new AspectList().add(Aspect.getAspect("praecantatio"), 12).add(Aspect.getAspect("pannus"), 9)
                        .add(Aspect.getAspect("sano"), 6).add(Aspect.getAspect("alienis"), 3),
                7,
                5,
                3,
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 1, missing)).setParents("CAP_gold", "ENCHFABRIC")
                        .setConcealed().setPages(new ResearchPage("tm.text.CAP_cloth.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_cloth",
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("terra"), 25).add(Aspect.getAspect("ignis"), 25)
                        .add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("perditio"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                'e',
                getModItem(Thaumcraft.ID, "WandCap", 1, 1, missing),
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                'g',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing),
                'i',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7, missing));
        TCHelper.addResearchPage(
                "CAP_cloth",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemWandCap", 1, 1, missing))));
        ThaumcraftApi.addWarpToResearch("CAP_cloth", 1);
        TCHelper.orphanResearch("CAP_shadowcloth");
        TCHelper.removeResearch("CAP_shadowcloth");
        new ResearchItem(
                "CAP_shadowcloth",
                "TM",
                new AspectList().add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("pannus"), 15)
                        .add(Aspect.getAspect("tenebrae"), 12).add(Aspect.getAspect("vacuos"), 9)
                        .add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("alienis"), 3),
                -2,
                3,
                3,
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 3, missing)).setParents("CAP_thaumium", "ShadowClothGTNH")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.CAP_shadowcloth"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_shadowcloth",
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("terra"), 50).add(Aspect.getAspect("ignis"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                'b',
                "foilVibrantAlloy",
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                'd',
                "foilVibrantAlloy",
                'e',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2, missing),
                'f',
                "foilVibrantAlloy",
                'g',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing),
                'h',
                "foilVibrantAlloy",
                'i',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1, missing));
        TCHelper.addResearchPage(
                "CAP_shadowcloth",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemWandCap", 1, 3, missing))));
        ThaumcraftApi.addWarpToResearch("CAP_shadowcloth", 2);
        TCHelper.orphanResearch("CAP_crimsoncloth");
        TCHelper.removeResearch("CAP_crimsoncloth");
        new ResearchItem(
                "CAP_crimsoncloth",
                "TM",
                new AspectList().add(Aspect.getAspect("tenebrae"), 18).add(Aspect.getAspect("praecantatio"), 15)
                        .add(Aspect.getAspect("pannus"), 12).add(Aspect.getAspect("sano"), 9)
                        .add(Aspect.getAspect("aqua"), 6).add(Aspect.getAspect("alienis"), 3),
                -1,
                -6,
                3,
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 2, missing)).setParentsHidden("CAP_cloth")
                        .setParents("CrimsonRobesGTNH").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.CAP_crimsoncloth")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_crimsoncloth",
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("ignis"), 100)
                        .add(Aspect.getAspect("aqua"), 100).add(Aspect.getAspect("terra"), 100)
                        .add(Aspect.getAspect("ordo"), 100).add(Aspect.getAspect("perditio"), 100),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'b',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'e',
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 3, missing),
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'g',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing),
                'h',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8, missing),
                'i',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2, missing));
        TCHelper.addResearchPage(
                "CAP_crimsoncloth",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemWandCap", 1, 2, missing))));
        ThaumcraftApi.addWarpToResearch("CAP_crimsoncloth", 4);
        TCHelper.orphanResearch("CAP_shadowmetal");
        TCHelper.removeResearch("CAP_shadowmetal");
        new ResearchItem(
                "CAP_shadowmetal",
                "TM",
                new AspectList().add(Aspect.getAspect("metallum"), 21).add(Aspect.getAspect("tenebrae"), 18)
                        .add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("alienis"), 12)
                        .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("cognitio"), 3),
                -4,
                4,
                3,
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 0, missing))
                        .setParents("CAP_shadowcloth", "CAP_void", "PRIMPEARL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.CAP_shadowmetal")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CAP_shadowmetal",
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("alienis"), 96).add(Aspect.getAspect("praecantatio"), 96)
                        .add(Aspect.getAspect("tenebrae"), 84).add(Aspect.getAspect("metallum"), 72)
                        .add(Aspect.getAspect("vacuos"), 64).add(Aspect.getAspect("cognitio"), 68)
                        .add(Aspect.getAspect("lucrum"), 32).add(Aspect.getAspect("fames"), 32),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "WandCap", 1, 7, missing),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Shadow, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Tanzanite, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing),
                        GTOreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Shadow, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateDense, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plateQuadruple, Materials.Shadow, 1L),
                        getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3, missing), });
        TCHelper.addResearchPage(
                "CAP_shadowmetal",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemWandCap", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("CAP_shadowmetal", 8);
    }
}
