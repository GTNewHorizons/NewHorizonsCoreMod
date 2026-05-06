package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.Forestry;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.TaintedMagic;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.TinkersGregworks;

import java.util.Arrays;
import java.util.List;

import com.dreammaster.item.NHItemList;
import com.dreammaster.thaumcraft.TCHelper;

import fox.spiteful.forbidden.DarkAspects;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GTOreDictUnificator;
import magicbees.api.MagicBeesAPI;
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
                ForbiddenMagic.ID,
                Forestry.ID,
                IndustrialCraft2.ID,
                TaintedMagic.ID,
                Thaumcraft.ID,
                TinkersGregworks.ID);
    }

    @Override
    public void loadRecipes() {
        TCHelper.removeCrucibleRecipe(getModItem(TaintedMagic.ID, "BlockShadowOre", 1, 0));
        TCHelper.removeCrucibleRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3));
        TCHelper.removeCrucibleRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemMagicFunguar", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "BlockWarpwoodSapling", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemWarpedGoggles", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemFocusVisShard", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusMageMace", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 2, 5));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemCrystalDagger", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemHelmetCultistRobe", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemChestplateCultistRobe", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemLeggingsCultistRobe", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemBootsCultist", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemHelmetCultistPlate", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemChestplateCultistPlate", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(Thaumcraft.ID, "ItemLeggingsCultistPlate", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemHelmetCultistLeaderPlate", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemChestplateCultistLeaderPlate", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemLeggingsCultistLeaderPlate", 1, 0));
        TCHelper.removeCrucibleRecipe(getModItem(TaintedMagic.ID, "ItemVoidsentBlood", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(Thaumcraft.ID, "ItemSwordCrimson", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidmetalGoggles", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusTaint", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusTaintedBlast", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 6));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemThaumicDisassembler", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidwalkerBoots", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidwalkerSash", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidFortressHelmet", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidFortressChestplate", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidFortressLeggings", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemShadowFortressHelmet", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemShadowFortressChestplate", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemShadowFortressLeggings", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemKatana", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemKatana", 1, 1));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemKatana", 1, 2));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemWandRod", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemWandRod", 1, 1));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusMeteorology", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemPrimordialEdge", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemWandCap", 1, 1));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemWandCap", 1, 2));
        TCHelper.removeArcaneRecipe(getModItem(TaintedMagic.ID, "ItemWandCap", 1, 3));
        TCHelper.removeInfusionRecipe(getModItem(TaintedMagic.ID, "ItemWandCap", 1, 0));
        TCHelper.orphanResearch("SHADOWMETAL");
        TCHelper.removeResearch("SHADOWMETAL");
        new ResearchItem(
                "ShadowmetalGTNH",
                "TM",
                new AspectList().add(Aspect.METAL, 12).add(Aspect.MAGIC, 9).add(Aspect.DARKNESS, 6)
                        .add(Aspect.ENERGY, 3),
                0,
                1,
                2,
                getModItem(TaintedMagic.ID, "BlockShadowOre", 1, 0)).setParents("TAINTEDMAGIC").setConcealed()
                        .setPages(new ResearchPage("tm.text.SHADOWMETAL.1")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "ShadowmetalGTNH",
                getModItem(TaintedMagic.ID, "BlockShadowOre", 1, 0),
                getModItem(Minecraft.ID, "stone", 1, 0),
                new AspectList().add(Aspect.DARKNESS, 6).add(Aspect.MAGIC, 8).add(Aspect.METAL, 8).add(Aspect.VOID, 4));
        TCHelper.addResearchPage(
                "ShadowmetalGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(TaintedMagic.ID, "BlockShadowOre", 1, 0))));
        ThaumcraftApi.addWarpToResearch("ShadowmetalGTNH", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ShadowmetalGTNH",
                getModItem(TaintedMagic.ID, "ItemShadowmetalHoe", 1, 0),
                new AspectList().add(Aspect.ENTROPY, 45).add(Aspect.EARTH, 30),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemShadowmetalHoe", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ShadowmetalGTNH",
                getModItem(TaintedMagic.ID, "ItemShadowmetalPick", 1, 0),
                new AspectList().add(Aspect.ENTROPY, 45).add(Aspect.EARTH, 30),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemShadowmetalPick", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ShadowmetalGTNH",
                getModItem(TaintedMagic.ID, "ItemShadowmetalAxe", 1, 0),
                new AspectList().add(Aspect.ENTROPY, 45).add(Aspect.EARTH, 30),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemShadowmetalAxe", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ShadowmetalGTNH",
                getModItem(TaintedMagic.ID, "ItemShadowmetalSpade", 1, 0),
                new AspectList().add(Aspect.ENTROPY, 45).add(Aspect.EARTH, 30),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemShadowmetalSpade", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ShadowmetalGTNH",
                getModItem(TaintedMagic.ID, "ItemShadowmetalSword", 1, 0),
                new AspectList().add(Aspect.ENTROPY, 45).add(Aspect.EARTH, 30),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemShadowmetalSword", 1, 0))));
        TCHelper.orphanResearch("EVILSHARDS");
        TCHelper.removeResearch("EVILSHARDS");
        new ResearchItem(
                "EvilshardsGTNH",
                "TM",
                new AspectList().add(DarkAspects.NETHER, 15).add(Aspect.CRYSTAL, 12).add(Aspect.MAGIC, 9)
                        .add(Aspect.DARKNESS, 6).add(Aspect.ELDRITCH, 3),
                4,
                0,
                3,
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4)).setParents("TAINTEDMAGIC").setConcealed()
                        .setPages(new ResearchPage("tm.text.EVILSHARDS.1")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "EvilshardsGTNH",
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                new AspectList().add(Aspect.ELDRITCH, 8).add(Aspect.MAGIC, 8).add(Aspect.EXCHANGE, 8));
        TCHelper.addResearchPage(
                "EvilshardsGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3))));
        ThaumcraftApi.addCrucibleRecipe(
                "EvilshardsGTNH",
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4),
                getModItem(Thaumcraft.ID, "ItemShard", 1, 6),
                new AspectList().add(Aspect.TAINT, 8).add(Aspect.MAGIC, 8).add(Aspect.EXCHANGE, 8));
        TCHelper.addResearchPage(
                "EvilshardsGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4))));
        ThaumcraftApi.addWarpToResearch("EvilshardsGTNH", 2);
        TCHelper.orphanResearch("MAGICFUNGUAR");
        TCHelper.removeResearch("MAGICFUNGUAR");
        new ResearchItem(
                "MagicFunguarGTNH",
                "TM",
                new AspectList().add(DarkAspects.GLUTTONY, 15).add(Aspect.HUNGER, 12).add(Aspect.GREED, 9)
                        .add(Aspect.MAGIC, 6).add(Aspect.PLANT, 3),
                3,
                -2,
                3,
                getModItem(TaintedMagic.ID, "ItemMagicFunguar", 1, 0)).setParents("TAINTEDMAGIC").setConcealed()
                        .setPages(new ResearchPage("tm.text.MAGICFUNGUAR.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "MagicFunguarGTNH",
                getModItem(TaintedMagic.ID, "ItemMagicFunguar", 4, 0),
                new AspectList().add(Aspect.WATER, 10).add(Aspect.EARTH, 10).add(Aspect.ORDER, 10).add(Aspect.FIRE, 10)
                        .add(Aspect.AIR, 10).add(Aspect.ENTROPY, 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "brown_mushroom", 1, 0),
                'b',
                getModItem(Thaumcraft.ID, "ItemShard", 1, wildcard),
                'c',
                getModItem(Minecraft.ID, "red_mushroom", 1, 0),
                'd',
                getModItem(Thaumcraft.ID, "ItemShard", 1, wildcard),
                'e',
                getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 5),
                'f',
                getModItem(Thaumcraft.ID, "ItemShard", 1, wildcard),
                'g',
                getModItem(Minecraft.ID, "blaze_powder", 1, 0),
                'h',
                getModItem(Thaumcraft.ID, "ItemShard", 1, wildcard),
                'i',
                getModItem(Minecraft.ID, "blaze_powder", 1, 0));
        TCHelper.addResearchPage(
                "MagicFunguarGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemMagicFunguar", 1, 0))));
        ThaumcraftApi.addWarpToResearch("MagicFunguarGTNH", 1);
        TCHelper.orphanResearch("WARPTREE");
        TCHelper.removeResearch("WARPTREE");
        new ResearchItem(
                "WarpTreeGTNH",
                "TM",
                new AspectList().add(Aspect.ELDRITCH, 18).add(Aspect.DARKNESS, 15).add(Aspect.TAINT, 12)
                        .add(Aspect.TREE, 9).add(Aspect.MAGIC, 6).add(Aspect.PLANT, 3),
                6,
                -1,
                3,
                getModItem(TaintedMagic.ID, "BlockWarpwoodSapling", 1, 0)).setParentsHidden("ShadowmetalGTNH")
                        .setParents("EvilshardsGTNH").setConcealed().setPages(new ResearchPage("tm.text.WARPTREE.1"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "WarpTreeGTNH",
                getModItem(TaintedMagic.ID, "BlockWarpwoodSapling", 1, 0),
                4,
                new AspectList().add(Aspect.ELDRITCH, 16).add(Aspect.TREE, 16).add(Aspect.DARKNESS, 12)
                        .add(Aspect.TAINT, 8).add(Aspect.EXCHANGE, 8),
                getModItem(Thaumcraft.ID, "blockCustomPlant", 1, 0),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3));
        TCHelper.addResearchPage(
                "WarpTreeGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "BlockWarpwoodSapling", 1, 0))));
        TCHelper.addResearchPage(
                "WarpTreeGTNH",
                new ResearchPage(
                        TCHelper.findCraftingRecipe(getModItem(TaintedMagic.ID, "BlockWarpwoodPlanks", 1, 0))));
        ThaumcraftApi.addWarpToResearch("WarpTreeGTNH", 3);
        TCHelper.orphanResearch("WARPEDGOGGLES");
        TCHelper.removeResearch("WARPEDGOGGLES");
        new ResearchItem(
                "WarpedGogglesGTNH",
                "TM",
                new AspectList().add(Aspect.ARMOR, 15).add(Aspect.ELDRITCH, 12).add(Aspect.DARKNESS, 9)
                        .add(Aspect.SENSES, 6).add(Aspect.AIR, 3),
                2,
                3,
                3,
                getModItem(TaintedMagic.ID, "ItemWarpedGoggles", 1, 0)).setParents("ShadowmetalGTNH")
                        .setParentsHidden("EvilshardsGTNH").registerResearchItem();
        TCHelper.addResearchPrereq("WarpedGogglesGTNH", "GOGGLES", false);
        ResearchCategories.getResearch("WarpedGogglesGTNH").setConcealed();
        TCHelper.addResearchPage("WarpedGogglesGTNH", new ResearchPage("tm.text.WARPEDGOGGLES.1"));
        TCHelper.addInfusionCraftingRecipe(
                "WarpedGogglesGTNH",
                getModItem(TaintedMagic.ID, "ItemWarpedGoggles", 1, 0),
                5,
                new AspectList().add(Aspect.ELDRITCH, 40).add(Aspect.MAGIC, 32).add(Aspect.DARKNESS, 24)
                        .add(Aspect.ARMOR, 16).add(Aspect.SENSES, 8),
                getModItem(Thaumcraft.ID, "ItemGoggles", 1, 0),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3),
                OrePrefixes.plate.get(Materials.Shadow),
                OrePrefixes.ring.get(Materials.Shadow),
                OrePrefixes.lens.get(Materials.InfusedEntropy),
                OrePrefixes.screw.get(Materials.Shadow),
                OrePrefixes.bolt.get(Materials.Shadow),
                OrePrefixes.screw.get(Materials.Shadow),
                OrePrefixes.lens.get(Materials.InfusedEntropy),
                OrePrefixes.ring.get(Materials.Shadow),
                OrePrefixes.plate.get(Materials.Shadow));
        TCHelper.addResearchPage(
                "WarpedGogglesGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemWarpedGoggles", 1, 0))));
        ThaumcraftApi.addWarpToResearch("WarpedGogglesGTNH", 1);
        TCHelper.orphanResearch("FOCUSSHARD");
        TCHelper.removeResearch("FOCUSSHARD");
        new ResearchItem(
                "FocusShardGTNH",
                "TM",
                new AspectList().add(Aspect.MOTION, 18).add(Aspect.CRYSTAL, 15).add(Aspect.MAGIC, 12).add(Aspect.AIR, 9)
                        .add(Aspect.ENTROPY, 6).add(Aspect.ORDER, 3),
                3,
                1,
                3,
                getModItem(TaintedMagic.ID, "ItemFocusVisShard", 1, 0)).setParents("EvilshardsGTNH", "FOCUSFIRE")
                        .setConcealed().setPages(new ResearchPage("tm.text.FOCUSSHARD.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FocusShardGTNH",
                getModItem(TaintedMagic.ID, "ItemFocusVisShard", 1, 0),
                new AspectList().add(Aspect.ORDER, 50).add(Aspect.AIR, 50).add(Aspect.ENTROPY, 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3),
                'b',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3),
                'd',
                getModItem(Thaumcraft.ID, "ItemWispEssence", 1, wildcard),
                'e',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 3),
                'f',
                getModItem(Thaumcraft.ID, "ItemWispEssence", 1, wildcard),
                'g',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4),
                'h',
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                'i',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4));
        TCHelper.addResearchPage(
                "FocusShardGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemFocusVisShard", 1, 0))));
        ThaumcraftApi.addWarpToResearch("FocusShardGTNH", 1);
        TCHelper.orphanResearch("MACEFOCUS");
        TCHelper.removeResearch("MACEFOCUS");
        new ResearchItem(
                "MaceFocusGTNH",
                "TM",
                new AspectList().add(Aspect.ENTROPY, 18).add(Aspect.EARTH, 15).add(Aspect.MAGIC, 12)
                        .add(Aspect.WEAPON, 9).add(Aspect.METAL, 6).add(Aspect.MIND, 3),
                0,
                4,
                3,
                getModItem(TaintedMagic.ID, "ItemFocusMageMace", 1, 0)).setParentsHidden("TAINTEDMAGIC")
                        .setParents("ShadowmetalGTNH", "FOCUSFIRE").setConcealed()
                        .setPages(new ResearchPage("tm.text.MACEFOCUS.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "MaceFocusGTNH",
                getModItem(TaintedMagic.ID, "ItemFocusMageMace", 1, 0),
                9,
                new AspectList().add(Aspect.METAL, 16).add(Aspect.ENTROPY, 32).add(Aspect.MAGIC, 48)
                        .add(Aspect.WEAPON, 64).add(Aspect.MIND, 8),
                getModItem(TaintedMagic.ID, "ItemShadowmetalSword", 1, 0),
                OrePrefixes.block.get(Materials.Shadow),
                OrePrefixes.screw.get(Materials.Shadow),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                OrePrefixes.plate.get(Materials.NetherQuartz),
                OrePrefixes.stick.get(Materials.Shadow),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.stick.get(Materials.Shadow),
                OrePrefixes.plate.get(Materials.NetherQuartz),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                OrePrefixes.screw.get(Materials.Shadow));
        TCHelper.addResearchPage(
                "MaceFocusGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusMageMace", 1, 0))));
        ThaumcraftApi.addWarpToResearch("MaceFocusGTNH", 1);
        TCHelper.orphanResearch("SHADOWCLOTH");
        TCHelper.removeResearch("SHADOWCLOTH");
        new ResearchItem(
                "ShadowClothGTNH",
                "TM",
                new AspectList().add(Aspect.CLOTH, 15).add(Aspect.DARKNESS, 12).add(Aspect.MAGIC, 9).add(Aspect.AIR, 6)
                        .add(Aspect.ARMOR, 3),
                -1,
                2,
                3,
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1)).setParents("ShadowmetalGTNH", "ENCHFABRIC")
                        .setConcealed().setPages(new ResearchPage("tm.text.SHADOWCLOTH.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ShadowClothGTNH",
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                new AspectList().add(Aspect.AIR, 15).add(Aspect.FIRE, 15).add(Aspect.EARTH, 15).add(Aspect.WATER, 15)
                        .add(Aspect.ORDER, 15).add(Aspect.ENTROPY, 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'b',
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Shadow, 1L),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'd',
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Shadow, 1L),
                'e',
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Thaumium, 1L),
                'f',
                GTOreDictUnificator.get(OrePrefixes.foil, Materials.Shadow, 1L),
                'g',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'h',
                GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Shadow, 1L),
                'i',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7));
        TCHelper.addResearchPage(
                "ShadowClothGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1))));
        ThaumcraftApi.addWarpToResearch("ShadowClothGTNH", 2);
        TCHelper.orphanResearch("CREATIONSHARD");
        TCHelper.removeResearch("CREATIONSHARD");
        new ResearchItem(
                "CreationShardGTNH",
                "TM",
                new AspectList().add(Aspect.AIR, 21).add(Aspect.WATER, 21).add(Aspect.FIRE, 21).add(Aspect.EARTH, 21)
                        .add(Aspect.ORDER, 21).add(Aspect.ENTROPY, 21),
                8,
                -5,
                3,
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 5)).setParents("TMELDRITCHMAJOR", "PRIMPEARL")
                        .setConcealed().setPages(new ResearchPage("tm.text.CREATIONSHARD.1")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "CreationShardGTNH",
                NHItemList.VoidEssence.get(2),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 16),
                new AspectList().add(Aspect.ELDRITCH, 16).add(Aspect.VOID, 16).add(Aspect.DARKNESS, 16));
        TCHelper.addResearchPage(
                "CreationShardGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(NHItemList.VoidEssence.get(1))));
        TCHelper.addInfusionCraftingRecipe(
                "CreationShardGTNH",
                getModItem(TaintedMagic.ID, "ItemMaterial", 2, 5),
                12,
                new AspectList().add(Aspect.ELDRITCH, 64).add(Aspect.VOID, 64).add(Aspect.MAGIC, 64)
                        .add(Aspect.AURA, 64).add(Aspect.DARKNESS, 64),
                getModItem(Minecraft.ID, "nether_star", 1, 0),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                NHItemList.VoidEssence.get(1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 4),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                NHItemList.VoidEssence.get(1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6));
        TCHelper.addResearchPage(
                "CreationShardGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 5))));
        ThaumcraftApi.addWarpToResearch("CreationShardGTNH", 10);
        TCHelper.orphanResearch("ELDRITCHFOCUS");
        TCHelper.removeResearch("ELDRITCHFOCUS");
        new ResearchItem(
                "EldritchFocusGTNH",
                "TM",
                new AspectList().add(Aspect.ELDRITCH, 18).add(Aspect.ENTROPY, 15).add(Aspect.AIR, 12)
                        .add(Aspect.DARKNESS, 9).add(Aspect.ENERGY, 6).add(DarkAspects.WRATH, 3),
                8,
                -4,
                3,
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1, 0))
                        .setParentsHidden("ShadowmetalGTNH", "EvilshardsGTNH")
                        .setParents("CreationShardGTNH", "FOCUSPORTABLEHOLE").setConcealed()
                        .setPages(new ResearchPage("tm.text.ELDRITCHFOCUS.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "EldritchFocusGTNH",
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1, 0),
                9,
                new AspectList().add(Aspect.AIR, 84).add(Aspect.ELDRITCH, 72).add(Aspect.MAGIC, 64)
                        .add(Aspect.DARKNESS, 64).add(DarkAspects.WRATH, 32).add(Aspect.ENERGY, 16),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 5),
                getModItem(Thaumcraft.ID, "FocusPortableHole", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Shadow),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                OrePrefixes.plate.get(Materials.Void));
        TCHelper.addResearchPage(
                "EldritchFocusGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1, 0))));
        TCHelper.addResearchPage("EldritchFocusGTNH", new ResearchPage("tm.text.ELDRITCHFOCUS.2"));
        ThaumcraftApi.addWarpToResearch("EldritchFocusGTNH", 4);
        TCHelper.orphanResearch("CRYSTALDAGGER");
        TCHelper.removeResearch("CRYSTALDAGGER");
        new ResearchItem(
                "CrystalDaggerGTNH",
                "TM",
                new AspectList().add(Aspect.WEAPON, 18).add(Aspect.FIRE, 15).add(Aspect.HEAL, 12).add(Aspect.HUNGER, 9)
                        .add(DarkAspects.NETHER, 6).add(Aspect.GREED, 3),
                0,
                -3,
                3,
                getModItem(TaintedMagic.ID, "ItemCrystalDagger", 1, 0)).setParents("TAINTEDMAGIC")
                        .setParentsHidden("ShadowmetalGTNH").registerResearchItem();
        TCHelper.addResearchPrereq("CrystalDaggerGTNH", "ENCHFABRIC", false);
        TCHelper.addResearchPrereq("CrystalDaggerGTNH", "ESSENTIACRYSTAL", false);
        TCHelper.addResearchPrereq("CrystalDaggerGTNH", "VOIDMETAL", false);
        ResearchCategories.getResearch("CrystalDaggerGTNH").setConcealed();
        TCHelper.addResearchPage("CrystalDaggerGTNH", new ResearchPage("tm.text.CRYSTALDAGGER.1"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CrystalDaggerGTNH",
                getModItem(TaintedMagic.ID, "ItemCrystalDagger", 1, 0),
                new AspectList().add(Aspect.EARTH, 100).add(Aspect.FIRE, 100).add(Aspect.ENTROPY, 100)
                        .add(Aspect.ORDER, 50).add(Aspect.AIR, 50),
                "abc",
                "def",
                "ghi",
                'a',
                "screwThaumium",
                'b',
                "craftingToolWrench",
                'c',
                createItemStack(TinkersGregworks.ID, "tGregToolPartKnifeBlade", 1, 1622, "{material:\"Shadow\"}"),
                'e',
                getModItem(Thaumcraft.ID, "blockTube", 1, 7),
                'g',
                getModItem(Forestry.ID, "oakStick", 1, 0),
                'h',
                "craftingToolScrewdriver",
                'i',
                "screwThaumium");
        TCHelper.addResearchPage(
                "CrystalDaggerGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemCrystalDagger", 1, 0))));
        ThaumcraftApi.addWarpToResearch("CrystalDaggerGTNH", 3);
        TCHelper.orphanResearch("CRIMSONROBES");
        TCHelper.removeResearch("CRIMSONROBES");
        new ResearchItem(
                "CrimsonRobesGTNH",
                "TM",
                new AspectList().add(Aspect.CLOTH, 18).add(Aspect.EXCHANGE, 15).add(Aspect.ARMOR, 12)
                        .add(Aspect.ELDRITCH, 9).add(Aspect.DARKNESS, 6).add(Aspect.MAGIC, 3),
                -2,
                -5,
                3,
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2)).setParentsHidden("TAINTEDMAGIC")
                        .setParents("CrystalDaggerGTNH").registerResearchItem();
        TCHelper.addResearchPrereq("CrimsonRobesGTNH", "ShadowClothGTNH", true);
        TCHelper.addResearchPrereq("CrimsonRobesGTNH", "VOIDMETAL", false);
        ResearchCategories.getResearch("CrimsonRobesGTNH").setConcealed();
        TCHelper.addResearchPage("CrimsonRobesGTNH", new ResearchPage("tc.research_page.CrimsonRobesGTNH"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CrimsonRobesGTNH",
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                new AspectList().add(Aspect.EARTH, 25).add(Aspect.FIRE, 25).add(Aspect.ENTROPY, 25)
                        .add(Aspect.WATER, 25).add(Aspect.ORDER, 25).add(Aspect.AIR, 25),
                "abc",
                "def",
                "ghi",
                'a',
                "foilVoid",
                'b',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7),
                'c',
                "foilVoid",
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7),
                'e',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7),
                'g',
                "foilVoid",
                'h',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7),
                'i',
                "foilVoid");
        TCHelper.addResearchPage(
                "CrimsonRobesGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2))));
        ThaumcraftApi.addWarpToResearch("CrimsonRobesGTNH", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CrimsonRobesGTNH",
                getModItem(Thaumcraft.ID, "ItemHelmetCultistRobe", 1, 0),
                new AspectList().add(Aspect.EARTH, 30).add(Aspect.FIRE, 30).add(Aspect.ENTROPY, 30)
                        .add(Aspect.WATER, 30).add(Aspect.ORDER, 30).add(Aspect.AIR, 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'b',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'e',
                "plateVoid",
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'h',
                "plateVoid");
        TCHelper.addResearchPage(
                "CrimsonRobesGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemHelmetCultistRobe", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CrimsonRobesGTNH",
                getModItem(Thaumcraft.ID, "ItemChestplateCultistRobe", 1, 0),
                new AspectList().add(Aspect.EARTH, 30).add(Aspect.FIRE, 30).add(Aspect.ENTROPY, 30)
                        .add(Aspect.WATER, 30).add(Aspect.ORDER, 30).add(Aspect.AIR, 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'b',
                "plateVoid",
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'e',
                "plateVoid",
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'g',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'h',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'i',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2));
        TCHelper.addResearchPage(
                "CrimsonRobesGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemChestplateCultistRobe", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CrimsonRobesGTNH",
                getModItem(Thaumcraft.ID, "ItemLeggingsCultistRobe", 1, 0),
                new AspectList().add(Aspect.EARTH, 30).add(Aspect.FIRE, 30).add(Aspect.ENTROPY, 30)
                        .add(Aspect.WATER, 30).add(Aspect.ORDER, 30).add(Aspect.AIR, 30),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'b',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'e',
                "plateVoid",
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'g',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'h',
                "plateVoid",
                'i',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2));
        TCHelper.addResearchPage(
                "CrimsonRobesGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemLeggingsCultistRobe", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CrimsonRobesGTNH",
                getModItem(Thaumcraft.ID, "ItemBootsCultist", 1, 0),
                new AspectList().add(Aspect.EARTH, 30).add(Aspect.FIRE, 30).add(Aspect.ENTROPY, 30)
                        .add(Aspect.WATER, 30).add(Aspect.ORDER, 30).add(Aspect.AIR, 30),
                "abc",
                "def",
                "ghi",
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'e',
                "plateVoid",
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'g',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'h',
                "plateVoid",
                'i',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2));
        TCHelper.addResearchPage(
                "CrimsonRobesGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemBootsCultist", 1, 0))));
        TCHelper.addResearchPrereq("BLOODLUSTUPGRADE", "CrystalDaggerGTNH", false);
        ResearchCategories.getResearch("BLOODLUSTUPGRADE").setConcealed();
        TCHelper.setResearchAspects(
                "BLOODLUSTUPGRADE",
                new AspectList().add(Aspect.WATER, 15).add(Aspect.HEAL, 12).add(Aspect.WEAPON, 9).add(Aspect.MAGIC, 6)
                        .add(DarkAspects.WRATH, 3));
        TCHelper.setResearchComplexity("BLOODLUSTUPGRADE", 3);
        ThaumcraftApi.addWarpToResearch("BLOODLUSTUPGRADE", 2);
        TCHelper.orphanResearch("KNIGHTROBES");
        TCHelper.removeResearch("KNIGHTROBES");
        new ResearchItem(
                "KnightRobesGTNH",
                "TM",
                new AspectList().add(Aspect.CLOTH, 21).add(Aspect.EXCHANGE, 18).add(Aspect.ARMOR, 15)
                        .add(Aspect.ELDRITCH, 12).add(Aspect.DARKNESS, 9).add(Aspect.MAGIC, 6).add(Aspect.METAL, 3),
                -4,
                -4,
                3,
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8)).setParents("ELDRITCHMINOR", "CrimsonRobesGTNH")
                        .setConcealed().setPages(new ResearchPage("tm.text.KNIGHTROBES.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "KnightRobesGTNH",
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                6,
                new AspectList().add(Aspect.METAL, 32).add(Aspect.MAGIC, 32).add(Aspect.DARKNESS, 32)
                        .add(Aspect.ELDRITCH, 32).add(Aspect.ARMOR, 32).add(Aspect.FIRE, 32).add(Aspect.HUNGER, 32),
                OrePrefixes.plateQuadruple.get(Materials.Thaumium),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7),
                OrePrefixes.screw.get(Materials.FierySteel),
                OrePrefixes.foil.get(Materials.Ultimet),
                OrePrefixes.foil.get(Materials.Knightmetal),
                OrePrefixes.foil.get(Materials.AstralSilver),
                OrePrefixes.screw.get(Materials.FierySteel),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7),
                OrePrefixes.screw.get(Materials.FierySteel),
                OrePrefixes.foil.get(Materials.Ultimet),
                OrePrefixes.foil.get(Materials.Knightmetal),
                OrePrefixes.foil.get(Materials.AstralSilver),
                OrePrefixes.screw.get(Materials.FierySteel),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7));
        TCHelper.addResearchPage(
                "KnightRobesGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8))));
        ThaumcraftApi.addWarpToResearch("KnightRobesGTNH", 4);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "KnightRobesGTNH",
                getModItem(Thaumcraft.ID, "ItemHelmetCultistPlate", 1, 0),
                new AspectList().add(Aspect.EARTH, 50).add(Aspect.FIRE, 50).add(Aspect.ENTROPY, 50)
                        .add(Aspect.WATER, 50).add(Aspect.ORDER, 50).add(Aspect.AIR, 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'b',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'e',
                "plateShadow",
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'h',
                "plateShadow");
        TCHelper.addResearchPage(
                "KnightRobesGTNH",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemHelmetCultistPlate", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "KnightRobesGTNH",
                getModItem(Thaumcraft.ID, "ItemChestplateCultistPlate", 1, 0),
                new AspectList().add(Aspect.EARTH, 50).add(Aspect.FIRE, 50).add(Aspect.ENTROPY, 50)
                        .add(Aspect.WATER, 50).add(Aspect.ORDER, 50).add(Aspect.AIR, 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'b',
                "plateShadow",
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'e',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'g',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'h',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'i',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8));
        TCHelper.addResearchPage(
                "KnightRobesGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemChestplateCultistPlate", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "KnightRobesGTNH",
                getModItem(Thaumcraft.ID, "ItemLeggingsCultistPlate", 1, 0),
                new AspectList().add(Aspect.EARTH, 50).add(Aspect.FIRE, 50).add(Aspect.ENTROPY, 50)
                        .add(Aspect.WATER, 50).add(Aspect.ORDER, 50).add(Aspect.AIR, 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'b',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'e',
                "plateShadow",
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'g',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'h',
                "plateShadow",
                'i',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2));
        TCHelper.addResearchPage(
                "KnightRobesGTNH",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(Thaumcraft.ID, "ItemLeggingsCultistPlate", 1, 0))));
        TCHelper.orphanResearch("PRAETORARMOR");
        TCHelper.removeResearch("PRAETORARMOR");
        new ResearchItem(
                "PraetorarmorGTNH",
                "TM",
                new AspectList().add(Aspect.CLOTH, 24).add(Aspect.EXCHANGE, 21).add(Aspect.ARMOR, 18)
                        .add(Aspect.ELDRITCH, 15).add(Aspect.DARKNESS, 12).add(Aspect.MAGIC, 9).add(Aspect.METAL, 6)
                        .add(Aspect.ENERGY, 3),
                -6,
                -4,
                3,
                getModItem(Thaumcraft.ID, "ItemHelmetCultistLeaderPlate", 1, 0)).setParents("KnightRobesGTNH")
                        .setConcealed().setPages(new ResearchPage("tm.text.PRAETORARMOR.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "PraetorarmorGTNH",
                getModItem(Thaumcraft.ID, "ItemHelmetCultistLeaderPlate", 1, 0),
                6,
                new AspectList().add(Aspect.METAL, 64).add(Aspect.MAGIC, 64).add(Aspect.DARKNESS, 64)
                        .add(Aspect.ELDRITCH, 64).add(Aspect.ARMOR, 64),
                getModItem(Thaumcraft.ID, "ItemHelmetCultistPlate", 1, 0),
                OrePrefixes.plate.get(Materials.RoseGold),
                OrePrefixes.ring.get(Materials.Shadow),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                OrePrefixes.ring.get(Materials.Shadow),
                OrePrefixes.plate.get(Materials.RoseGold),
                OrePrefixes.ring.get(Materials.Shadow),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                OrePrefixes.ring.get(Materials.Shadow));
        TCHelper.addResearchPage(
                "PraetorarmorGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "ItemHelmetCultistLeaderPlate", 1, 0))));
        ThaumcraftApi.addWarpToResearch("PraetorarmorGTNH", 5);
        TCHelper.addInfusionCraftingRecipe(
                "PraetorarmorGTNH",
                getModItem(Thaumcraft.ID, "ItemChestplateCultistLeaderPlate", 1, 0),
                6,
                new AspectList().add(Aspect.METAL, 64).add(Aspect.MAGIC, 64).add(Aspect.DARKNESS, 64)
                        .add(Aspect.ELDRITCH, 64).add(Aspect.ARMOR, 64),
                getModItem(Thaumcraft.ID, "ItemChestplateCultistPlate", 1, 0),
                OrePrefixes.plate.get(Materials.RoseGold),
                OrePrefixes.ring.get(Materials.Shadow),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                OrePrefixes.ring.get(Materials.Shadow),
                OrePrefixes.plate.get(Materials.RoseGold),
                OrePrefixes.ring.get(Materials.Shadow),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                OrePrefixes.ring.get(Materials.Shadow));
        TCHelper.addResearchPage(
                "PraetorarmorGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(Thaumcraft.ID, "ItemChestplateCultistLeaderPlate", 1, 0))));
        TCHelper.addInfusionCraftingRecipe(
                "PraetorarmorGTNH",
                getModItem(Thaumcraft.ID, "ItemLeggingsCultistLeaderPlate", 1, 0),
                6,
                new AspectList().add(Aspect.METAL, 64).add(Aspect.MAGIC, 64).add(Aspect.DARKNESS, 64)
                        .add(Aspect.ELDRITCH, 64).add(Aspect.ARMOR, 64),
                getModItem(Thaumcraft.ID, "ItemLeggingsCultistPlate", 1, 0),
                OrePrefixes.plate.get(Materials.RoseGold),
                OrePrefixes.ring.get(Materials.Shadow),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                OrePrefixes.ring.get(Materials.Shadow),
                OrePrefixes.plate.get(Materials.RoseGold),
                OrePrefixes.ring.get(Materials.Shadow),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                OrePrefixes.ring.get(Materials.Shadow));
        TCHelper.addResearchPage(
                "PraetorarmorGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(Thaumcraft.ID, "ItemLeggingsCultistLeaderPlate", 1, 0))));
        TCHelper.orphanResearch("VOIDSENTBLOOD");
        TCHelper.removeResearch("VOIDSENTBLOOD");
        new ResearchItem(
                "VoidsentGTNH",
                "TM",
                new AspectList().add(Aspect.DARKNESS, 33).add(Aspect.ARMOR, 18).add(Aspect.VOID, 15).add(Aspect.AURA, 9)
                        .add(Aspect.MAGIC, 6).add(Aspect.ELDRITCH, 3),
                -7,
                -5,
                3,
                getModItem(TaintedMagic.ID, "ItemVoidsentBlood", 1, 0)).setParents("PraetorarmorGTNH").setConcealed()
                        .setPages(new ResearchPage("tm.text.VOIDSENTBLOOD.1")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "VoidsentGTNH",
                getModItem(TaintedMagic.ID, "ItemVoidsentBlood", 1, 0),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7),
                new AspectList().add(Aspect.AURA, 12).add(Aspect.DARKNESS, 12).add(Aspect.ARMOR, 12)
                        .add(Aspect.VOID, 16).add(Aspect.ELDRITCH, 16));
        TCHelper.addResearchPage(
                "VoidsentGTNH",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(TaintedMagic.ID, "ItemVoidsentBlood", 1, 0))));
        ThaumcraftApi.addWarpToResearch("VoidsentGTNH", 2);
        TCHelper.orphanResearch("CRIMSONBLADE");
        TCHelper.removeResearch("CRIMSONBLADE");
        new ResearchItem(
                "CrimsonBladeGTNH",
                "TM",
                new AspectList().add(Aspect.ENTROPY, 18).add(Aspect.WEAPON, 15).add(Aspect.VOID, 12)
                        .add(Aspect.DARKNESS, 9).add(Aspect.METAL, 6).add(Aspect.ENERGY, 3),
                -7,
                -3,
                3,
                getModItem(Thaumcraft.ID, "ItemSwordCrimson", 1, 0)).setParents("PraetorarmorGTNH").setConcealed()
                        .setPages(new ResearchPage("tm.text.CRIMSONBLADE.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "CrimsonBladeGTNH",
                getModItem(Thaumcraft.ID, "ItemSwordCrimson", 1, 0),
                9,
                new AspectList().add(Aspect.ELDRITCH, 16).add(Aspect.METAL, 24).add(Aspect.ENTROPY, 32)
                        .add(Aspect.WEAPON, 64).add(Aspect.VOID, 48).add(Aspect.DARKNESS, 32),
                getModItem(Thaumcraft.ID, "ItemSwordVoid", 1, 0),
                getModItem(TaintedMagic.ID, "ItemCrystalDagger", 1, 0),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7),
                OrePrefixes.plate.get(Materials.Shadow),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 7));
        TCHelper.addResearchPage(
                "CrimsonBladeGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Thaumcraft.ID, "ItemSwordCrimson", 1, 0))));
        ThaumcraftApi.addWarpToResearch("CrimsonBladeGTNH", 5);
        TCHelper.orphanResearch("VOIDGOGGLES");
        TCHelper.removeResearch("VOIDGOGGLES");
        new ResearchItem(
                "VoidgogglesGTNH",
                "TM",
                new AspectList().add(Aspect.SENSES, 21).add(Aspect.VOID, 18).add(Aspect.MAGIC, 15)
                        .add(Aspect.DARKNESS, 12).add(Aspect.CRYSTAL, 9).add(Aspect.ELDRITCH, 6).add(Aspect.METAL, 3),
                3,
                5,
                3,
                getModItem(TaintedMagic.ID, "ItemVoidmetalGoggles", 1, 0)).setParents("WarpedGogglesGTNH", "VOIDMETAL")
                        .setConcealed().setPages(new ResearchPage("tm.text.VOIDGOGGLES.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "VoidgogglesGTNH",
                getModItem(TaintedMagic.ID, "ItemVoidmetalGoggles", 1, 0),
                12,
                new AspectList().add(Aspect.SENSES, 32).add(Aspect.DARKNESS, 32).add(Aspect.ARMOR, 48)
                        .add(Aspect.VOID, 64).add(Aspect.CRYSTAL, 24).add(Aspect.ELDRITCH, 8).add(Aspect.METAL, 16),
                getModItem(TaintedMagic.ID, "ItemWarpedGoggles", 1, 0),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.ring.get(Materials.Void),
                OrePrefixes.lens.get(Materials.NetherStar),
                OrePrefixes.screw.get(Materials.Void),
                OrePrefixes.bolt.get(Materials.Void),
                OrePrefixes.screw.get(Materials.Void),
                OrePrefixes.lens.get(Materials.NetherStar),
                OrePrefixes.ring.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Void));
        TCHelper.addResearchPage(
                "VoidgogglesGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidmetalGoggles", 1, 0))));
        ThaumcraftApi.addWarpToResearch("VoidgogglesGTNH", 5);
        TCHelper.orphanResearch("TAINTFOCUS");
        TCHelper.removeResearch("TAINTFOCUS");
        new ResearchItem(
                "TaintFocusGTNH",
                "TM",
                new AspectList().add(Aspect.TAINT, 18).add(Aspect.WATER, 15).add(Aspect.SLIME, 12).add(Aspect.AIR, 9)
                        .add(Aspect.MAGIC, 6).add(Aspect.ENERGY, 3),
                5,
                2,
                3,
                getModItem(TaintedMagic.ID, "ItemFocusTaint", 1, 0))
                        .setParents("EvilshardsGTNH", "BOTTLETAINT", "TAINTSHOVEL").setConcealed()
                        .setPages(new ResearchPage("tm.text.TAINTFOCUS.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "TaintFocusGTNH",
                getModItem(TaintedMagic.ID, "ItemFocusTaint", 1, 0),
                9,
                new AspectList().add(Aspect.WATER, 72).add(Aspect.SLIME, 72).add(Aspect.MAGIC, 72).add(Aspect.TAINT, 72)
                        .add(Aspect.AIR, 64).add(Aspect.ENERGY, 32),
                getModItem(Thaumcraft.ID, "FocusPech", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 11),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 2),
                getModItem(Thaumcraft.ID, "ItemBottleTaint", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 12),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 11),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 12),
                getModItem(Thaumcraft.ID, "ItemBottleTaint", 1, 0),
                getModItem(ForbiddenMagic.ID, "NetherShard", 1, 2),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 11));
        TCHelper.addResearchPage(
                "TaintFocusGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusTaint", 1, 0))));
        ThaumcraftApi.addWarpToResearch("TaintFocusGTNH", 4);
        TCHelper.orphanResearch("FOCUSTAINTEDBLAST");
        TCHelper.removeResearch("FOCUSTAINTEDBLAST");
        new ResearchItem(
                "FocusTaintedBlastGTNH",
                "TM",
                new AspectList().add(Aspect.MAGIC, 21).add(Aspect.TAINT, 18).add(Aspect.MOTION, 18).add(Aspect.AIR, 12)
                        .add(Aspect.ENTROPY, 9).add(Aspect.WEAPON, 6),
                5,
                3,
                3,
                getModItem(TaintedMagic.ID, "ItemFocusTaintedBlast", 1, 0))
                        .setParents("TaintFocusGTNH", "FOCUSFIRE", "ELDRITCHMINOR", "FOCUSSHOCK").setConcealed()
                        .setPages(new ResearchPage("tm.text.FOCUSTAINTEDBLAST.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "FocusTaintedBlastGTNH",
                getModItem(TaintedMagic.ID, "ItemFocusTaintedBlast", 1, 0),
                12,
                new AspectList().add(Aspect.MOTION, 64).add(Aspect.MAGIC, 80).add(Aspect.WEAPON, 72)
                        .add(Aspect.TAINT, 84).add(Aspect.MIND, 32).add(Aspect.AIR, 48),
                getModItem(TaintedMagic.ID, "ItemFocusTaint", 1, 0),
                getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0),
                getModItem(Thaumcraft.ID, "ItemBottleTaint", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 11),
                getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(Thaumcraft.ID, "ItemBottleTaint", 1, 0),
                getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0),
                getModItem(Thaumcraft.ID, "ItemBottleTaint", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 15),
                getModItem(IndustrialCraft2.ID, "blockITNT", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 11),
                getModItem(Thaumcraft.ID, "ItemBottleTaint", 1, 0));
        TCHelper.addResearchPage(
                "FocusTaintedBlastGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusTaintedBlast", 1, 0))));
        ThaumcraftApi.addWarpToResearch("FocusTaintedBlastGTNH", 6);
        TCHelper.orphanResearch("THAUMICDISASSEMBLER");
        TCHelper.removeResearch("THAUMICDISASSEMBLER");
        new ResearchItem(
                "ThaumicdisassemblerGTNH",
                "TM",
                new AspectList().add(Aspect.WEAPON, 18).add(Aspect.METAL, 15).add(Aspect.TOOL, 12).add(Aspect.MAGIC, 9)
                        .add(Aspect.ELDRITCH, 6).add(Aspect.TAINT, 3),
                5,
                -6,
                3,
                getModItem(TaintedMagic.ID, "ItemThaumicDisassembler", 1, 0)).setParents("TMELDRITCHMAJOR", "VOIDMETAL")
                        .setConcealed().setPages(new ResearchPage("tm.text.THAUMICDISASSEMBLER.1"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ThaumicdisassemblerGTNH",
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 6),
                new AspectList().add(Aspect.ORDER, 75).add(Aspect.ENTROPY, 75).add(Aspect.EARTH, 50),
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
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemMaterial", 1, 6))));
        ThaumcraftApi.addWarpToResearch("ThaumicdisassemblerGTNH", 4);
        TCHelper.addResearchPage("ThaumicdisassemblerGTNH", new ResearchPage("tm.text.THAUMICDISASSEMBLER.2"));
        TCHelper.addInfusionCraftingRecipe(
                "ThaumicdisassemblerGTNH",
                getModItem(TaintedMagic.ID, "ItemThaumicDisassembler", 1, 0),
                10,
                new AspectList().add(Aspect.TOOL, 32).add(Aspect.METAL, 32).add(Aspect.WEAPON, 24).add(Aspect.VOID, 24)
                        .add(Aspect.MAGIC, 16).add(Aspect.ENERGY, 16),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 6),
                getModItem(Thaumcraft.ID, "ItemPickVoid", 1, 0),
                OrePrefixes.plate.get(Materials.Shadow),
                getModItem(Thaumcraft.ID, "ItemShovelVoid", 1, 0),
                OrePrefixes.plate.get(Materials.Shadow),
                getModItem(Thaumcraft.ID, "ItemSwordVoid", 1, 0),
                OrePrefixes.plate.get(Materials.Shadow),
                getModItem(Thaumcraft.ID, "ItemAxeVoid", 1, 0),
                OrePrefixes.plate.get(Materials.Shadow));
        TCHelper.addResearchPage(
                "ThaumicdisassemblerGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemThaumicDisassembler", 1, 0))));
        TCHelper.orphanResearch("VOIDWALKERBOOTS");
        TCHelper.removeResearch("VOIDWALKERBOOTS");
        new ResearchItem(
                "VoidWalkerBootsGTNH",
                "TM",
                new AspectList().add(Aspect.DARKNESS, 21).add(Aspect.ARMOR, 18).add(Aspect.ELDRITCH, 15)
                        .add(Aspect.MAGIC, 12).add(Aspect.TRAVEL, 9).add(Aspect.AIR, 6).add(Aspect.FLIGHT, 3),
                4,
                -8,
                3,
                getModItem(TaintedMagic.ID, "ItemVoidwalkerBoots", 1, 0))
                        .setParents("TMELDRITCHMAJOR", "BOOTSTRAVELLER")
                        .setParentsHidden("TAINTEDMAGIC", "ShadowmetalGTNH").setConcealed()
                        .setPages(new ResearchPage("tm.text.VOIDWALKERBOOTS.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "VoidWalkerBootsGTNH",
                getModItem(TaintedMagic.ID, "ItemVoidwalkerBoots", 1, 0),
                12,
                new AspectList().add(Aspect.ELDRITCH, 64).add(Aspect.TRAVEL, 84).add(Aspect.DARKNESS, 72)
                        .add(Aspect.ARMOR, 64).add(Aspect.VOID, 64).add(Aspect.MAGIC, 32),
                getModItem(Thaumcraft.ID, "BootsTraveller", 1, 0),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plateDouble.get(Materials.Polytetrafluoroethylene),
                OrePrefixes.plate.get(Materials.Shadow),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plate.get(Materials.Shadow),
                OrePrefixes.plateDouble.get(Materials.Polytetrafluoroethylene),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plate.get(Materials.Void));
        TCHelper.addResearchPage(
                "VoidWalkerBootsGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidwalkerBoots", 1, 0))));
        ThaumcraftApi.addWarpToResearch("VoidWalkerBootsGTNH", 4);
        TCHelper.orphanResearch("VOIDSASH");
        TCHelper.removeResearch("VOIDSASH");
        new ResearchItem(
                "VoidSashGTNH",
                "TM",
                new AspectList().add(Aspect.METAL, 24).add(Aspect.VOID, 21).add(Aspect.ARMOR, 18).add(Aspect.MAGIC, 15)
                        .add(Aspect.ELDRITCH, 12).add(Aspect.DARKNESS, 9).add(Aspect.TRAVEL, 6).add(Aspect.AIR, 3),
                3,
                -8,
                3,
                getModItem(TaintedMagic.ID, "ItemVoidwalkerSash", 1, 0)).setParents("VoidWalkerBootsGTNH", "RUNICARMOR")
                        .setParentsHidden("TAINTEDMAGIC", "ShadowmetalGTNH").registerResearchItem();
        TCHelper.addResearchPrereq("VoidSashGTNH", "VOIDMETAL", false);
        ResearchCategories.getResearch("VoidSashGTNH").setConcealed();
        TCHelper.addResearchPage("VoidSashGTNH", new ResearchPage("tm.text.VOIDSASH.1"));
        TCHelper.addInfusionCraftingRecipe(
                "VoidSashGTNH",
                getModItem(TaintedMagic.ID, "ItemVoidwalkerSash", 1, 0),
                12,
                new AspectList().add(Aspect.TRAVEL, 48).add(Aspect.MAGIC, 64).add(Aspect.ARMOR, 84).add(Aspect.VOID, 72)
                        .add(Aspect.FLIGHT, 32).add(Aspect.ELDRITCH, 24).add(Aspect.AIR, 16),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3),
                getModItem(Thaumcraft.ID, "ItemGirdleRunic", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Shadow),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plate.get(Materials.Shadow),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.gemExquisite.get(Materials.Tanzanite),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Shadow),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plate.get(Materials.Shadow),
                OrePrefixes.plate.get(Materials.Void));
        TCHelper.addResearchPage(
                "VoidSashGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidwalkerSash", 1, 0))));
        ThaumcraftApi.addWarpToResearch("VoidSashGTNH", 4);
        TCHelper.orphanResearch("VOIDFORTRESS");
        TCHelper.removeResearch("VOIDFORTRESS");
        new ResearchItem(
                "VoidFortressGTNH",
                "TM",
                new AspectList().add(Aspect.ARMOR, 21).add(Aspect.VOID, 18).add(Aspect.ELDRITCH, 15)
                        .add(Aspect.DARKNESS, 12).add(Aspect.LIFE, 9).add(Aspect.MIND, 6).add(Aspect.EARTH, 3),
                7,
                -8,
                3,
                getModItem(TaintedMagic.ID, "ItemVoidFortressHelmet", 1, 0))
                        .setParents("TMELDRITCHMAJOR", "VOIDMETAL", "ARMORFORTRESS").setParentsHidden("ShadowmetalGTNH")
                        .setConcealed().setPages(new ResearchPage("tm.text.VOIDFORTRESS.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "VoidFortressGTNH",
                getModItem(TaintedMagic.ID, "ItemVoidFortressHelmet", 1, 0),
                12,
                new AspectList().add(Aspect.ELDRITCH, 32).add(Aspect.METAL, 48).add(Aspect.MAGIC, 48)
                        .add(Aspect.ARMOR, 48).add(Aspect.VOID, 32).add(Aspect.DARKNESS, 16).add(Aspect.ENERGY, 16)
                        .add(Aspect.LIFE, 32),
                getModItem(Thaumcraft.ID, "ItemHelmetVoid", 1, 0),
                OrePrefixes.gemExquisite.get(Materials.Emerald),
                OrePrefixes.plate.get(Materials.RoseGold),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plateTriple.get(Materials.Polytetrafluoroethylene),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.RoseGold));
        TCHelper.addResearchPage(
                "VoidFortressGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidFortressHelmet", 1, 0))));
        ThaumcraftApi.addWarpToResearch("VoidFortressGTNH", 5);
        TCHelper.addInfusionCraftingRecipe(
                "VoidFortressGTNH",
                getModItem(TaintedMagic.ID, "ItemVoidFortressChestplate", 1, 0),
                12,
                new AspectList().add(Aspect.ELDRITCH, 32).add(Aspect.METAL, 64).add(Aspect.MAGIC, 64)
                        .add(Aspect.ARMOR, 64).add(Aspect.VOID, 32).add(Aspect.DARKNESS, 16).add(Aspect.ENERGY, 16)
                        .add(Aspect.MIND, 32),
                getModItem(Thaumcraft.ID, "ItemChestplateVoid", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plateTriple.get(Materials.Polytetrafluoroethylene),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plate.get(Materials.RoseGold),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plateTriple.get(Materials.Polytetrafluoroethylene),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Void));
        TCHelper.addResearchPage(
                "VoidFortressGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidFortressChestplate", 1, 0))));
        TCHelper.addInfusionCraftingRecipe(
                "VoidFortressGTNH",
                getModItem(TaintedMagic.ID, "ItemVoidFortressLeggings", 1, 0),
                12,
                new AspectList().add(Aspect.ELDRITCH, 32).add(Aspect.METAL, 32).add(Aspect.MAGIC, 32)
                        .add(Aspect.ARMOR, 32).add(Aspect.VOID, 32).add(Aspect.DARKNESS, 16).add(Aspect.ENERGY, 16)
                        .add(Aspect.EARTH, 32),
                getModItem(Thaumcraft.ID, "ItemLeggingsVoid", 1, 0),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 2),
                OrePrefixes.plate.get(Materials.RoseGold),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plateTriple.get(Materials.Polytetrafluoroethylene),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.RoseGold));
        TCHelper.addResearchPage(
                "VoidFortressGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemVoidFortressLeggings", 1, 0))));
        TCHelper.orphanResearch("SHADOWFORTRESSARMOR");
        TCHelper.removeResearch("SHADOWFORTRESSARMOR");
        new ResearchItem(
                "ShadowFortressArmorGTNH",
                "TM",
                new AspectList().add(Aspect.ARMOR, 24).add(Aspect.VOID, 21).add(Aspect.ELDRITCH, 18)
                        .add(Aspect.DARKNESS, 15).add(Aspect.LIFE, 12).add(Aspect.MIND, 9).add(Aspect.EARTH, 6)
                        .add(DarkAspects.PRIDE, 3),
                8,
                -9,
                3,
                getModItem(TaintedMagic.ID, "ItemShadowFortressHelmet", 1, 0)).setParents("VoidFortressGTNH")
                        .setParentsHidden("ShadowmetalGTNH").setConcealed()
                        .setPages(new ResearchPage("tm.text.SHADOWFORTRESSARMOR.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ShadowFortressArmorGTNH",
                getModItem(TaintedMagic.ID, "ItemShadowFortressHelmet", 1, 0),
                16,
                new AspectList().add(Aspect.ELDRITCH, 48).add(Aspect.METAL, 64).add(Aspect.MAGIC, 64)
                        .add(Aspect.ARMOR, 64).add(Aspect.VOID, 48).add(Aspect.DARKNESS, 32).add(Aspect.ENERGY, 32)
                        .add(Aspect.LIFE, 48),
                getModItem(TaintedMagic.ID, "ItemVoidFortressHelmet", 1, 0),
                OrePrefixes.gemExquisite.get(Materials.Emerald),
                OrePrefixes.plate.get(Materials.InfusedGold),
                OrePrefixes.block.get(Materials.Shadow),
                OrePrefixes.block.get(Materials.Shadow),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plateDense.get(Materials.Polybenzimidazole),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.block.get(Materials.Shadow),
                OrePrefixes.block.get(Materials.Shadow),
                OrePrefixes.plate.get(Materials.InfusedGold));
        TCHelper.addResearchPage(
                "ShadowFortressArmorGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemShadowFortressHelmet", 1, 0))));
        ThaumcraftApi.addWarpToResearch("ShadowFortressArmorGTNH", 10);
        TCHelper.addInfusionCraftingRecipe(
                "ShadowFortressArmorGTNH",
                getModItem(TaintedMagic.ID, "ItemShadowFortressChestplate", 1, 0),
                16,
                new AspectList().add(Aspect.ELDRITCH, 48).add(Aspect.METAL, 84).add(Aspect.MAGIC, 84)
                        .add(Aspect.ARMOR, 84).add(Aspect.VOID, 48).add(Aspect.DARKNESS, 32).add(Aspect.ENERGY, 32)
                        .add(Aspect.MIND, 48),
                getModItem(TaintedMagic.ID, "ItemVoidFortressChestplate", 1, 0),
                OrePrefixes.block.get(Materials.Shadow),
                OrePrefixes.block.get(Materials.Shadow),
                OrePrefixes.block.get(Materials.Shadow),
                OrePrefixes.block.get(Materials.Shadow),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plateDense.get(Materials.Polybenzimidazole),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plate.get(Materials.InfusedGold),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plateDense.get(Materials.Polybenzimidazole),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.block.get(Materials.Shadow),
                OrePrefixes.block.get(Materials.Shadow),
                OrePrefixes.block.get(Materials.Shadow));
        TCHelper.addResearchPage(
                "ShadowFortressArmorGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(TaintedMagic.ID, "ItemShadowFortressChestplate", 1, 0))));
        TCHelper.addInfusionCraftingRecipe(
                "ShadowFortressArmorGTNH",
                getModItem(TaintedMagic.ID, "ItemShadowFortressLeggings", 1, 0),
                16,
                new AspectList().add(Aspect.ELDRITCH, 48).add(Aspect.METAL, 48).add(Aspect.MAGIC, 48)
                        .add(Aspect.ARMOR, 48).add(Aspect.VOID, 32).add(Aspect.DARKNESS, 32).add(Aspect.ENERGY, 32)
                        .add(Aspect.EARTH, 48),
                getModItem(TaintedMagic.ID, "ItemVoidFortressLeggings", 1, 0),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 2),
                OrePrefixes.plate.get(Materials.InfusedGold),
                OrePrefixes.block.get(Materials.Shadow),
                OrePrefixes.block.get(Materials.Shadow),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.plateDense.get(Materials.Polybenzimidazole),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                OrePrefixes.block.get(Materials.Shadow),
                OrePrefixes.block.get(Materials.Shadow),
                OrePrefixes.plate.get(Materials.InfusedGold));
        TCHelper.addResearchPage(
                "ShadowFortressArmorGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemShadowFortressLeggings", 1, 0))));
        TCHelper.orphanResearch("THAUMIUMKATANA");
        TCHelper.removeResearch("THAUMIUMKATANA");
        new ResearchItem(
                "ThaumiumKatanaGTNH",
                "TM",
                new AspectList().add(Aspect.METAL, 18).add(Aspect.WEAPON, 15).add(Aspect.MAGIC, 12)
                        .add(Aspect.MOTION, 9).add(Aspect.ENERGY, 6).add(Aspect.DEATH, 3),
                7,
                1,
                3,
                getModItem(TaintedMagic.ID, "ItemKatana", 1, 0)).setParents("ARMORFORTRESS")
                        .setParentsHidden("ShadowmetalGTNH").setConcealed()
                        .setPages(new ResearchPage("tm.text.THAUMIUMKATANA.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ThaumiumKatanaGTNH",
                getModItem(TaintedMagic.ID, "ItemKatana", 1, 0),
                6,
                new AspectList().add(Aspect.METAL, 64).add(Aspect.MAGIC, 32).add(Aspect.WEAPON, 48)
                        .add(Aspect.DEATH, 24).add(Aspect.ENERGY, 16).add(Aspect.MOTION, 8),
                getModItem(Thaumcraft.ID, "ItemSwordThaumium", 1, 0),
                OrePrefixes.plate.get(Materials.Obsidian),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.gemFlawless.get(Materials.Emerald),
                OrePrefixes.plate.get(Materials.Steel),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Obsidian),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.plate.get(Materials.Gold),
                OrePrefixes.gemFlawless.get(Materials.Emerald),
                OrePrefixes.plate.get(Materials.Steel),
                OrePrefixes.plate.get(Materials.Thaumium));
        TCHelper.addResearchPage(
                "ThaumiumKatanaGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemKatana", 1, 0))));
        ThaumcraftApi.addWarpToResearch("ThaumiumKatanaGTNH", 3);
        TCHelper.orphanResearch("VOIDMETALKATANA");
        TCHelper.removeResearch("VOIDMETALKATANA");
        new ResearchItem(
                "VoidMetalKatanaGTNH",
                "TM",
                new AspectList().add(Aspect.METAL, 21).add(Aspect.WEAPON, 18).add(Aspect.VOID, 15).add(Aspect.MAGIC, 12)
                        .add(Aspect.MOTION, 9).add(Aspect.ENERGY, 6).add(Aspect.DEATH, 3),
                7,
                0,
                3,
                getModItem(TaintedMagic.ID, "ItemKatana", 1, 1)).setParents("ThaumiumKatanaGTNH")
                        .setParentsHidden("VOIDMETAL").setConcealed()
                        .setPages(new ResearchPage("tm.text.VOIDMETALKATANA.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "VoidMetalKatanaGTNH",
                getModItem(TaintedMagic.ID, "ItemKatana", 1, 1),
                9,
                new AspectList().add(Aspect.ELDRITCH, 48).add(Aspect.METAL, 72).add(Aspect.MAGIC, 48)
                        .add(Aspect.WEAPON, 64).add(Aspect.DEATH, 32).add(Aspect.ENERGY, 24).add(Aspect.MOTION, 16)
                        .add(Aspect.VOID, 32),
                getModItem(Thaumcraft.ID, "ItemSwordVoid", 1, 0),
                OrePrefixes.plate.get(Materials.Manyullyn),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.RoseGold),
                OrePrefixes.gemExquisite.get(Materials.Emerald),
                OrePrefixes.plate.get(Materials.Titanium),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Manyullyn),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.plate.get(Materials.RoseGold),
                OrePrefixes.gemExquisite.get(Materials.Emerald),
                OrePrefixes.plate.get(Materials.Titanium),
                OrePrefixes.plate.get(Materials.Void));
        TCHelper.addResearchPage(
                "VoidMetalKatanaGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemKatana", 1, 1))));
        ThaumcraftApi.addWarpToResearch("VoidMetalKatanaGTNH", 6);
        TCHelper.orphanResearch("SHADOWMETALKATANA");
        TCHelper.removeResearch("SHADOWMETALKATANA");
        new ResearchItem(
                "ShadowMetalKatanaGTNH",
                "TM",
                new AspectList().add(Aspect.DARKNESS, 24).add(Aspect.METAL, 21).add(Aspect.WEAPON, 18)
                        .add(Aspect.VOID, 15).add(Aspect.MAGIC, 12).add(Aspect.MOTION, 9).add(Aspect.ENERGY, 6)
                        .add(Aspect.DEATH, 3),
                8,
                -1,
                3,
                getModItem(TaintedMagic.ID, "ItemKatana", 1, 2)).setParents("VoidMetalKatanaGTNH")
                        .setParentsHidden("ShadowmetalGTNH").setConcealed()
                        .setPages(new ResearchPage("tm.text.SHADOWMETALKATANA.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ShadowMetalKatanaGTNH",
                getModItem(TaintedMagic.ID, "ItemKatana", 1, 2),
                12,
                new AspectList().add(Aspect.ELDRITCH, 64).add(Aspect.METAL, 84).add(Aspect.MAGIC, 64)
                        .add(Aspect.WEAPON, 72).add(Aspect.DEATH, 48).add(Aspect.ENERGY, 32).add(Aspect.MOTION, 24)
                        .add(Aspect.VOID, 48).add(Aspect.DARKNESS, 48),
                getModItem(TaintedMagic.ID, "ItemShadowmetalSword", 1, 0),
                OrePrefixes.plate.get(Materials.Shadow),
                OrePrefixes.plate.get(Materials.Shadow),
                OrePrefixes.plate.get(Materials.InfusedGold),
                OrePrefixes.gemExquisite.get(Materials.Emerald),
                OrePrefixes.plate.get(Materials.TungstenSteel),
                OrePrefixes.plate.get(Materials.Shadow),
                OrePrefixes.plate.get(Materials.Shadow),
                OrePrefixes.plate.get(Materials.Shadow),
                OrePrefixes.plate.get(Materials.InfusedGold),
                OrePrefixes.gemExquisite.get(Materials.Emerald),
                OrePrefixes.plate.get(Materials.TungstenSteel),
                OrePrefixes.plate.get(Materials.Shadow));
        TCHelper.addResearchPage(
                "ShadowMetalKatanaGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemKatana", 1, 2))));
        ThaumcraftApi.addWarpToResearch("ShadowMetalKatanaGTNH", 9);
        TCHelper.addResearchPrereq("INSCRIPTIONFIRE", "ThaumiumKatanaGTNH", false);
        ResearchCategories.getResearch("INSCRIPTIONFIRE").setConcealed();
        TCHelper.setResearchAspects(
                "INSCRIPTIONFIRE",
                new AspectList().add(Aspect.FIRE, 15).add(Aspect.METAL, 12).add(Aspect.LIGHT, 9).add(Aspect.MAGIC, 6)
                        .add(Aspect.ENERGY, 3));
        TCHelper.setResearchComplexity("INSCRIPTIONFIRE", 3);
        ThaumcraftApi.addWarpToResearch("INSCRIPTIONFIRE", 2);
        TCHelper.addResearchPrereq("INSCRIPTIONTAINT", "ThaumiumKatanaGTNH", false);
        ResearchCategories.getResearch("INSCRIPTIONTAINT").setConcealed();
        TCHelper.setResearchAspects(
                "INSCRIPTIONTAINT",
                new AspectList().add(Aspect.TAINT, 15).add(Aspect.METAL, 12).add(Aspect.FLESH, 9).add(Aspect.MAGIC, 6)
                        .add(Aspect.ENERGY, 3));
        TCHelper.setResearchComplexity("INSCRIPTIONTAINT", 3);
        ThaumcraftApi.addWarpToResearch("INSCRIPTIONTAINT", 3);
        TCHelper.addResearchPrereq("INSCRIPTIONUNDEAD", "ThaumiumKatanaGTNH", false);
        ResearchCategories.getResearch("INSCRIPTIONUNDEAD").setConcealed();
        TCHelper.setResearchAspects(
                "INSCRIPTIONUNDEAD",
                new AspectList().add(Aspect.HEAL, 15).add(Aspect.METAL, 12).add(Aspect.UNDEAD, 9).add(Aspect.MAGIC, 6)
                        .add(Aspect.ENERGY, 3));
        TCHelper.setResearchComplexity("INSCRIPTIONUNDEAD", 3);
        ThaumcraftApi.addWarpToResearch("INSCRIPTIONUNDEAD", 4);
        TCHelper.orphanResearch("ROD_warpwood");
        TCHelper.removeResearch("ROD_warpwood");
        new ResearchItem(
                "ROD_warpwood",
                "TM",
                new AspectList().add(Aspect.TREE, 18).add(Aspect.DARKNESS, 15).add(Aspect.ELDRITCH, 12)
                        .add(Aspect.MAGIC, 9).add(Aspect.TOOL, 6).add(Aspect.EARTH, 3),
                8,
                -2,
                3,
                getModItem(TaintedMagic.ID, "ItemWandRod", 1, 0)).setParentsHidden("ShadowmetalGTNH")
                        .setParents("WarpTreeGTNH", "VOIDMETAL", "VOIDMETAL", "PRIMPEARL", "ROD_primal_staff")
                        .setConcealed().setPages(new ResearchPage("tm.text.ROD_warpwood.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ROD_warpwood",
                getModItem(TaintedMagic.ID, "ItemWandRod", 1, 0),
                16,
                new AspectList().add(Aspect.ELDRITCH, 64).add(Aspect.TREE, 64).add(Aspect.MAGIC, 64)
                        .add(Aspect.DARKNESS, 48).add(Aspect.TOOL, 32).add(Aspect.EARTH, 24),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3),
                getModItem(TaintedMagic.ID, "BlockWarpwoodLog", 1, 0),
                OrePrefixes.ring.get(Materials.Tungsten),
                OrePrefixes.plateTriple.get(Materials.Shadow),
                OrePrefixes.plateDouble.get(Materials.Void),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3),
                OrePrefixes.plateDouble.get(Materials.Void),
                OrePrefixes.plateTriple.get(Materials.Shadow),
                OrePrefixes.ring.get(Materials.Tungsten),
                getModItem(Thaumcraft.ID, "ItemZombieBrain", 1, 0),
                OrePrefixes.ring.get(Materials.Tungsten),
                OrePrefixes.plateTriple.get(Materials.Shadow),
                OrePrefixes.plateDouble.get(Materials.Void),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3),
                OrePrefixes.plateDouble.get(Materials.Void),
                OrePrefixes.plateTriple.get(Materials.Shadow),
                OrePrefixes.ring.get(Materials.Tungsten));
        TCHelper.addResearchPage(
                "ROD_warpwood",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemWandRod", 1, 0))));
        ThaumcraftApi.addWarpToResearch("ROD_warpwood", 3);
        TCHelper.addResearchPage("ROD_warpwood", new ResearchPage("tm.text.ROD_warpwood.2"));
        TCHelper.orphanResearch("ROD_warpwood_staff");
        TCHelper.removeResearch("ROD_warpwood_staff");
        new ResearchItem(
                "ROD_warpwood_staff",
                "TM",
                new AspectList().add(Aspect.TREE, 18).add(Aspect.DARKNESS, 15).add(Aspect.ELDRITCH, 12)
                        .add(Aspect.MAGIC, 9).add(Aspect.ENERGY, 6).add(Aspect.TOOL, 3),
                9,
                -2,
                3,
                getModItem(TaintedMagic.ID, "ItemWandRod", 1, 1)).setParents("ROD_warpwood").setConcealed()
                        .setPages(new ResearchPage("tm.text.ROD_warpwood_staff.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ROD_warpwood_staff",
                getModItem(TaintedMagic.ID, "ItemWandRod", 1, 1),
                new AspectList().add(Aspect.WATER, 150).add(Aspect.EARTH, 150).add(Aspect.FIRE, 150)
                        .add(Aspect.AIR, 150).add(Aspect.ORDER, 150).add(Aspect.ENTROPY, 150),
                "abc",
                "def",
                "ghi",
                'a',
                "screwShadow",
                'b',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4),
                'c',
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3),
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3),
                'e',
                getModItem(TaintedMagic.ID, "ItemWandRod", 1, 0),
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3),
                'g',
                getModItem(TaintedMagic.ID, "ItemWandRod", 1, 0),
                'h',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 4),
                'i',
                "screwShadow");
        TCHelper.addResearchPage(
                "ROD_warpwood_staff",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemWandRod", 1, 1))));
        ThaumcraftApi.addWarpToResearch("ROD_warpwood_staff", 5);
        TCHelper.orphanResearch("FOCUSTIME");
        TCHelper.removeResearch("FOCUSTIME");
        new ResearchItem(
                "FocusTimeGTNH",
                "TM",
                new AspectList().add((Aspect) MagicBeesAPI.thaumcraftAspectTempus, 27).add(Aspect.MAGIC, 24)
                        .add(Aspect.WATER, 21).add(Aspect.FIRE, 18).add(Aspect.EARTH, 15).add(Aspect.ORDER, 12)
                        .add(Aspect.ENTROPY, 9).add(Aspect.AIR, 6).add(Aspect.EXCHANGE, 3),
                11,
                -8,
                3,
                getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0))
                        .setParents("CreationShardGTNH", "FOCUSPORTABLEHOLE", "FOCUSFIRE").setConcealed()
                        .setPages(new ResearchPage("tm.text.FOCUSTIME.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "FocusTimeGTNH",
                getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0),
                16,
                new AspectList().add(Aspect.ELDRITCH, 84).add(Aspect.LIGHT, 72).add(Aspect.DARKNESS, 64)
                        .add(Aspect.VOID, 48).add((Aspect) MagicBeesAPI.thaumcraftAspectTempus, 24)
                        .add(Aspect.MAGIC, 32).add(Aspect.EXCHANGE, 16),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 5),
                getModItem(Thaumcraft.ID, "FocusPortableHole", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                NHItemList.VoidEssence.get(1),
                getModItem(Minecraft.ID, "clock", 1, 0),
                NHItemList.VoidEssence.get(1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                NHItemList.VoidEssence.get(1),
                getModItem(Minecraft.ID, "clock", 1, 0),
                NHItemList.VoidEssence.get(1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0));
        TCHelper.addResearchPage(
                "FocusTimeGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusTime", 1, 0))));
        ThaumcraftApi.addWarpToResearch("FocusTimeGTNH", 10);
        TCHelper.orphanResearch("FOCUSWEATHER");
        TCHelper.removeResearch("FOCUSWEATHER");
        new ResearchItem(
                "FocusWeatherGTNH",
                "TM",
                new AspectList().add(Aspect.FLIGHT, 27).add(Aspect.MAGIC, 24).add(Aspect.WATER, 21).add(Aspect.FIRE, 18)
                        .add(Aspect.EARTH, 15).add(Aspect.ORDER, 12).add(Aspect.ENTROPY, 9).add(Aspect.AIR, 6)
                        .add(Aspect.WEATHER, 3),
                12,
                -7,
                3,
                getModItem(TaintedMagic.ID, "ItemFocusMeteorology", 1, 0))
                        .setParents("CreationShardGTNH", "FOCUSSHOCK", "FOCUSFROST").setConcealed()
                        .setPages(new ResearchPage("tm.text.FOCUSWEATHER.1")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "FocusWeatherGTNH",
                getModItem(TaintedMagic.ID, "ItemFocusMeteorology", 1, 0),
                16,
                new AspectList().add(Aspect.ELDRITCH, 84).add(Aspect.WATER, 72).add(Aspect.WEATHER, 64)
                        .add(Aspect.VOID, 48).add(Aspect.MAGIC, 32).add(Aspect.FLIGHT, 24).add(Aspect.ENTROPY, 16),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 5),
                getModItem(Thaumcraft.ID, "FocusShock", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                NHItemList.VoidEssence.get(1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                NHItemList.VoidEssence.get(1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                getModItem(Thaumcraft.ID, "FocusFrost", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                NHItemList.VoidEssence.get(1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                NHItemList.VoidEssence.get(1),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2));
        TCHelper.addResearchPage(
                "FocusWeatherGTNH",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemFocusMeteorology", 1, 0))));
        ThaumcraftApi.addWarpToResearch("FocusWeatherGTNH", 10);
        TCHelper.orphanResearch("PRIMALBLADE");
        TCHelper.removeResearch("PRIMALBLADE");
        new ResearchItem(
                "PrimalBladeGTNH",
                "TM",
                new AspectList().add(Aspect.MAGIC, 24).add(Aspect.ELDRITCH, 21).add(Aspect.WEAPON, 18)
                        .add(Aspect.DARKNESS, 15).add(Aspect.VOID, 12).add(Aspect.AURA, 9).add(Aspect.ENERGY, 6)
                        .add(Aspect.MIND, 3),
                11,
                -5,
                3,
                getModItem(TaintedMagic.ID, "ItemPrimordialEdge", 1, 0)).setParents("CreationShardGTNH")
                        .setParentsHidden("EvilshardsGTNH", "CrystalDaggerGTNH").registerResearchItem();
        TCHelper.addResearchPrereq("PrimalBladeGTNH", "VOIDMETAL", false);
        TCHelper.addResearchPrereq("PrimalBladeGTNH", "PRIMALCRUSHER", false);
        ResearchCategories.getResearch("PrimalBladeGTNH").setConcealed();
        TCHelper.addResearchPage("PrimalBladeGTNH", new ResearchPage("tm.text.PRIMALBLADE.1"));
        TCHelper.addInfusionCraftingRecipe(
                "PrimalBladeGTNH",
                getModItem(TaintedMagic.ID, "ItemPrimordialEdge", 1, 0),
                16,
                new AspectList().add(Aspect.ELDRITCH, 96).add(Aspect.METAL, 84).add(Aspect.WEAPON, 72)
                        .add(Aspect.DARKNESS, 64).add(Aspect.VOID, 48).add(Aspect.AURA, 32).add(Aspect.MIND, 24)
                        .add(Aspect.ENERGY, 16),
                getModItem(Thaumcraft.ID, "ItemSwordVoid", 1, 0),
                getModItem(Thaumcraft.ID, "ItemPrimalCrusher", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 5),
                OrePrefixes.plate.get(Materials.Shadow),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 1),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 3),
                OrePrefixes.plate.get(Materials.Shadow),
                NHItemList.VoidEssence.get(1),
                getModItem(TaintedMagic.ID, "ItemCrystalDagger", 1, 0),
                NHItemList.VoidEssence.get(1),
                OrePrefixes.plate.get(Materials.Shadow),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 2),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 0),
                OrePrefixes.plate.get(Materials.Shadow));
        TCHelper.addResearchPage(
                "PrimalBladeGTNH",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemPrimordialEdge", 1, 0))));
        ThaumcraftApi.addWarpToResearch("PrimalBladeGTNH", 10);
        TCHelper.orphanResearch("CAP_cloth");
        TCHelper.removeResearch("CAP_cloth");
        new ResearchItem(
                "CAP_cloth",
                "TM",
                new AspectList().add(Aspect.MAGIC, 12).add(Aspect.CLOTH, 9).add(Aspect.HEAL, 6).add(Aspect.ELDRITCH, 3),
                7,
                5,
                3,
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 1)).setParents("CAP_gold", "ENCHFABRIC").setConcealed()
                        .setPages(new ResearchPage("tm.text.CAP_cloth.1")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_cloth",
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 1),
                new AspectList().add(Aspect.EARTH, 25).add(Aspect.FIRE, 25).add(Aspect.ORDER, 25)
                        .add(Aspect.ENTROPY, 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'c',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'd',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'e',
                getModItem(Thaumcraft.ID, "WandCap", 1, 1),
                'f',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'g',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'h',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7),
                'i',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 7));
        TCHelper.addResearchPage(
                "CAP_cloth",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemWandCap", 1, 1))));
        ThaumcraftApi.addWarpToResearch("CAP_cloth", 1);
        TCHelper.orphanResearch("CAP_shadowcloth");
        TCHelper.removeResearch("CAP_shadowcloth");
        new ResearchItem(
                "CAP_shadowcloth",
                "TM",
                new AspectList().add(Aspect.MAGIC, 18).add(Aspect.CLOTH, 15).add(Aspect.DARKNESS, 12)
                        .add(Aspect.VOID, 9).add(Aspect.METAL, 6).add(Aspect.ELDRITCH, 3),
                -2,
                3,
                3,
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 3)).setParents("CAP_thaumium", "ShadowClothGTNH")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.CAP_shadowcloth"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_shadowcloth",
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 3),
                new AspectList().add(Aspect.EARTH, 50).add(Aspect.FIRE, 50).add(Aspect.ORDER, 50)
                        .add(Aspect.ENTROPY, 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                'b',
                "foilVibrantAlloy",
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                'd',
                "foilVibrantAlloy",
                'e',
                getModItem(Thaumcraft.ID, "WandCap", 1, 2),
                'f',
                "foilVibrantAlloy",
                'g',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1),
                'h',
                "foilVibrantAlloy",
                'i',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 1));
        TCHelper.addResearchPage(
                "CAP_shadowcloth",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemWandCap", 1, 3))));
        ThaumcraftApi.addWarpToResearch("CAP_shadowcloth", 2);
        TCHelper.orphanResearch("CAP_crimsoncloth");
        TCHelper.removeResearch("CAP_crimsoncloth");
        new ResearchItem(
                "CAP_crimsoncloth",
                "TM",
                new AspectList().add(Aspect.DARKNESS, 18).add(Aspect.MAGIC, 15).add(Aspect.CLOTH, 12)
                        .add(Aspect.HEAL, 9).add(Aspect.WATER, 6).add(Aspect.ELDRITCH, 3),
                -1,
                -6,
                3,
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 2)).setParentsHidden("CAP_cloth")
                        .setParents("CrimsonRobesGTNH").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.CAP_crimsoncloth")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CAP_crimsoncloth",
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 2),
                new AspectList().add(Aspect.AIR, 100).add(Aspect.FIRE, 100).add(Aspect.WATER, 100)
                        .add(Aspect.EARTH, 100).add(Aspect.ORDER, 100).add(Aspect.ENTROPY, 100),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'b',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'c',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'd',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'e',
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 3),
                'f',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'g',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2),
                'h',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 8),
                'i',
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 2));
        TCHelper.addResearchPage(
                "CAP_crimsoncloth",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(TaintedMagic.ID, "ItemWandCap", 1, 2))));
        ThaumcraftApi.addWarpToResearch("CAP_crimsoncloth", 4);
        TCHelper.orphanResearch("CAP_shadowmetal");
        TCHelper.removeResearch("CAP_shadowmetal");
        new ResearchItem(
                "CAP_shadowmetal",
                "TM",
                new AspectList().add(Aspect.METAL, 21).add(Aspect.DARKNESS, 18).add(Aspect.MAGIC, 15)
                        .add(Aspect.ELDRITCH, 12).add(Aspect.EARTH, 9).add(Aspect.GREED, 6).add(Aspect.MIND, 3),
                -4,
                4,
                3,
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 0)).setParents("CAP_shadowcloth", "CAP_void", "PRIMPEARL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.CAP_shadowmetal"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "CAP_shadowmetal",
                getModItem(TaintedMagic.ID, "ItemWandCap", 1, 0),
                12,
                new AspectList().add(Aspect.ELDRITCH, 96).add(Aspect.MAGIC, 96).add(Aspect.DARKNESS, 84)
                        .add(Aspect.METAL, 72).add(Aspect.VOID, 64).add(Aspect.MIND, 68).add(Aspect.GREED, 32)
                        .add(Aspect.HUNGER, 32),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 3),
                getModItem(Thaumcraft.ID, "WandCap", 1, 7),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3),
                OrePrefixes.plateQuadruple.get(Materials.Shadow),
                OrePrefixes.plateDense.get(Materials.Void),
                OrePrefixes.plateQuadruple.get(Materials.Shadow),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3),
                OrePrefixes.gemExquisite.get(Materials.Tanzanite),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3),
                OrePrefixes.plateQuadruple.get(Materials.Shadow),
                OrePrefixes.plateDense.get(Materials.Void),
                OrePrefixes.plateQuadruple.get(Materials.Shadow),
                getModItem(TaintedMagic.ID, "ItemMaterial", 1, 3));
        TCHelper.addResearchPage(
                "CAP_shadowmetal",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(TaintedMagic.ID, "ItemWandCap", 1, 0))));
        ThaumcraftApi.addWarpToResearch("CAP_shadowmetal", 8);
    }
}
