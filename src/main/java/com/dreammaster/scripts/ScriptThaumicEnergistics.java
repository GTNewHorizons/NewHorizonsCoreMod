package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.*;
import static gregtech.api.util.GT_ModHandler.getModItem;

import java.util.Arrays;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchPage;

import com.dreammaster.thaumcraft.TCHelper;
import gregtech.api.enums.ItemList;

public class ScriptThaumicEnergistics implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "ThaumicEnergistics";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                TaintedMagic.ID,
                Gadomancy.ID,
                ThaumicEnergistics.ID,
                EternalSingularity.ID,
                AppliedEnergistics2.ID,
                "ae2stuff",
                TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {
        // Creates ItemStack for CEC craft input
        ItemStack[] CECInfusionItems = { ItemList.Field_Generator_UIV.get(1),
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1),
                getModItem(Gadomancy.ID, "BlockNodeManipulator", 1, 5),
                getModItem(Gadomancy.ID, "BlockEssentiaCompressor", 1), ItemList.Field_Generator_UIV.get(1),
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1),
                getModItem(Gadomancy.ID, "BlockNodeManipulator", 1, 5),
                getModItem(Gadomancy.ID, "BlockEssentiaCompressor", 1), ItemList.Field_Generator_UIV.get(1),
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1),
                getModItem(Gadomancy.ID, "BlockNodeManipulator", 1, 5),
                getModItem(Gadomancy.ID, "BlockEssentiaCompressor", 1), ItemList.Field_Generator_UIV.get(1),
                getModItem(TaintedMagic.ID, "ItemFocusEldritch", 1),
                getModItem(Gadomancy.ID, "BlockNodeManipulator", 1, 5),
                getModItem(Gadomancy.ID, "BlockEssentiaCompressor", 1) };

        // ItemStacks for in/out
        ItemStack SingularityDrive = getModItem(EternalSingularity.ID, "eternal_singularity", 1);
        ItemStack CEC = getModItem(ThaumicEnergistics.ID, "storage.essentia", 1, 4);

        ThaumcraftApi.addInfusionCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                CEC,
                10,
                new AspectList().add(Aspect.AIR, 2000).add(Aspect.FIRE, 2000).add(Aspect.ORDER, 2000)
                        .add(Aspect.ENTROPY, 2000).add(Aspect.EARTH, 2000).add(Aspect.WATER, 2000),
                SingularityDrive,
                CECInfusionItems);

        ItemStack missing = new ItemStack(Blocks.dirt);

        TCHelper.removeInfusionRecipe(
                getModItem("thaumicenergistics", "thaumicenergistics.block.essentia.provider", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "material", 1, 2, missing));
        TCHelper.removeArcaneRecipe(
                getModItem("thaumicenergistics", "thaumicenergistics.block.gear.box", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "part.base", 1, 5, missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "material", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "material", 1, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "part.base", 1, 4, missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "part.base", 4, 1, missing));
        TCHelper.removeArcaneRecipe(
                getModItem("thaumicenergistics", "thaumicenergistics.block.essentia.vibration.chamber", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "part.base", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "part.base", 1, 3, missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "part.base", 1, 2, missing));
        TCHelper.removeArcaneRecipe(
                getModItem("thaumicenergistics", "thaumicenergistics.block.distillation.encoder", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "focus.aewrench", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "golem.wifi.backpack", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "storage.component", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "storage.component", 1, 1, missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "storage.component", 1, 2, missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "storage.component", 1, 3, missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "part.base", 1, 6, missing));
        TCHelper.removeCrucibleRecipe(
                getModItem("thaumicenergistics", "thaumicenergistics.block.golem.gear.box", 1, 0, missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(
                        "thaumicenergistics",
                        "thaumicenergistics.block.arcane.assembler",
                        1,
                        0,
                        "{stored_vis:[0:{amount:1500,key:\"aer\"},1:{amount:1500,key:\"aqua\"},2:{amount:1500,key:\"ignis\"},3:{amount:1500,key:\"ordo\"},4:{amount:1500,key:\"perditio\"},5:{amount:1500,key:\"terra\"}]}",
                        missing));
        TCHelper.removeArcaneRecipe(getModItem("thaumicenergistics", "knowledge.core", 1, 0, missing));
        TCHelper.removeArcaneRecipe(
                getModItem("thaumicenergistics", "thaumicenergistics.block.knowledge.inscriber", 1, 0, missing));
        TCHelper.removeInfusionRecipe(
                getModItem("thaumicenergistics", "thaumicenergistics.block.infusion.provider", 1, 0, missing));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "thaumicenergistics.TEESSPROV",
                getModItem("thaumicenergistics", "thaumicenergistics.block.essentia.provider", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("machina"), 64).add(Aspect.getAspect("praecantatio"), 48)
                        .add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("permutatio"), 24)
                        .add(Aspect.getAspect("aqua"), 16).add(Aspect.getAspect("cognitio"), 8)
                        .add(Aspect.getAspect("lucrum"), 4),
                getModItem("appliedenergistics2", "tile.BlockInterface", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "blockTube", 1, 3, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("thaumicenergistics", "material", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("Thaumcraft", "blockTube", 1, 3, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("thaumicenergistics", "material", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 2, missing), });
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEESSPROV",
                new AspectList().add(Aspect.getAspect("sensus"), 21).add(Aspect.getAspect("praecantatio"), 18)
                        .add(Aspect.getAspect("lucrum"), 15).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("machina"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEESSPROV", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEIRONGEARBOX",
                getModItem("thaumicenergistics", "material", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("terra"), 10).add(Aspect.getAspect("ignis"), 5)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                "stickIron",
                'b',
                "plateIron",
                'c',
                "stickIron",
                'd',
                "plateIron",
                'e',
                "gearWood",
                'f',
                "plateIron",
                'g',
                "stickIron",
                'h',
                "plateIron",
                'i',
                "stickIron");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEIRONGEARBOX",
                getModItem("thaumicenergistics", "thaumicenergistics.block.gear.box", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ignis"), 15)
                        .add(Aspect.getAspect("ordo"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'b',
                "gearIron",
                'c',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'd',
                "gearIron",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                'f',
                "gearIron",
                'g',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing),
                'h',
                "gearIron",
                'i',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 6, missing));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEIRONGEARBOX",
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("metallum"), 15)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("permutatio"), 6));
        TCHelper.setResearchComplexity("thaumicenergistics.TEIRONGEARBOX", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEARCANETERM",
                getModItem("thaumicenergistics", "part.base", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 25).add(Aspect.getAspect("ignis"), 25)
                        .add(Aspect.getAspect("aer"), 25).add(Aspect.getAspect("terra"), 25)
                        .add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("perditio"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 17542, missing),
                'b',
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 360, missing),
                'c',
                getModItem("gregtech", "gt.metaitem.01", 1, 17542, missing),
                'd',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                'e',
                getModItem("Thaumcraft", "blockTable", 1, 15, missing),
                'f',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 23, missing),
                'g',
                getModItem("gregtech", "gt.metaitem.01", 1, 17542, missing),
                'h',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                'i',
                getModItem("gregtech", "gt.metaitem.01", 1, 17542, missing));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEARCANETERM",
                new AspectList().add(Aspect.getAspect("instrumentum"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("machina"), 6)
                        .add(Aspect.getAspect("vacuos"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEARCANETERM", 3);
        TCHelper.setResearchAspects(
                "thaumicenergistics.TECERTUSDUPE",
                new AspectList().add(Aspect.getAspect("vitreus"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TECERTUSDUPE", 2);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TECORES",
                getModItem("thaumicenergistics", "material", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 20).add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                'b',
                "gemAmber",
                'c',
                getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                'd',
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                'e',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 44, missing),
                'f',
                getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                'g',
                getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                'h',
                "gemAmber",
                'i',
                getModItem("Thaumcraft", "ItemResource", 1, 3, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TECORES",
                getModItem("thaumicenergistics", "material", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 20).add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                'b',
                "gemAmber",
                'c',
                getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                'd',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'e',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 43, missing),
                'f',
                getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                'g',
                getModItem("Thaumcraft", "ItemResource", 1, 3, missing),
                'h',
                "gemAmber",
                'i',
                getModItem("Thaumcraft", "ItemResource", 1, 3, missing));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TECORES",
                new AspectList().add(Aspect.getAspect("cognitio"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("machina"), 6).add(Aspect.getAspect("limus"), 9)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TECORES", 3);
        TCHelper.clearPages("thaumicenergistics.TEESSTERM");
        TCHelper.addResearchPage(
                "thaumicenergistics.TEESSTERM",
                new ResearchPage("thaumicenergistics.research_page.TEESSTERM.1"));
        TCHelper.addResearchPage(
                "thaumicenergistics.TEESSTERM",
                new ResearchPage("thaumicenergistics.research_page.TEESSTERM.2"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEESSTERM",
                getModItem("thaumicenergistics", "part.base", 1, 4, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 25).add(Aspect.getAspect("ordo"), 25)
                        .add(Aspect.getAspect("ignis"), 25).add(Aspect.getAspect("terra"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 23, missing),
                'b',
                getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                'c',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                'd',
                getModItem("thaumicenergistics", "material", 1, 0, missing),
                'e',
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 380, missing),
                'f',
                getModItem("thaumicenergistics", "material", 1, 1, missing),
                'g',
                "plateInfusedWater",
                'h',
                getModItem("Thaumcraft", "ItemResource", 1, 8, missing),
                'i',
                "plateInfusedWater");
        TCHelper.addResearchPage(
                "thaumicenergistics.TEESSTERM",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("thaumicenergistics", "part.base", 1, 4, missing))));
        TCHelper.addResearchPage(
                "thaumicenergistics.TEESSTERM",
                new ResearchPage("thaumicenergistics.research_page.TEESSTERM.3"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEESSTERM",
                getModItem("thaumicenergistics", "part.base", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("ignis"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'b',
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 280, missing),
                'c',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'e',
                getModItem("Thaumcraft", "ItemResource", 1, 3, missing));
        TCHelper.addResearchPage(
                "thaumicenergistics.TEESSTERM",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("thaumicenergistics", "part.base", 1, 1, missing))));
        TCHelper.addResearchPage(
                "thaumicenergistics.TEESSTERM",
                new ResearchPage("thaumicenergistics.research_page.TEESSTERM.4"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEESSTERM",
                getModItem("thaumicenergistics", "part.base", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("ordo"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolScrewdriver",
                'b',
                "itemIlluminatedPanel",
                'c',
                "craftingToolHardHammer",
                'd',
                "screwInfusedWater",
                'e',
                getModItem("thaumicenergistics", "part.base", 1, 1, missing),
                'f',
                "screwInfusedWater",
                'g',
                "plateInfusedOrder",
                'h',
                "plateInfusedOrder",
                'i',
                "plateInfusedOrder");
        TCHelper.addResearchPage(
                "thaumicenergistics.TEESSTERM",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("thaumicenergistics", "part.base", 1, 7, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEESSTERM",
                getModItem("thaumicenergistics", "part.base", 1, 8, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolScrewdriver",
                'b',
                getModItem("thaumicenergistics", "part.base", 1, 7, missing),
                'c',
                "craftingToolHardHammer",
                'd',
                "screwInfusedFire",
                'e',
                getModItem("thaumicenergistics", "material", 1, 0, missing),
                'f',
                "screwInfusedFire",
                'g',
                "plateInfusedOrder",
                'h',
                getModItem("thaumicenergistics", "material", 1, 1, missing),
                'i',
                "plateInfusedOrder");
        TCHelper.addResearchPage(
                "thaumicenergistics.TEESSTERM",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("thaumicenergistics", "part.base", 1, 8, missing))));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEESSTERM",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("sensus"), 9).add(Aspect.getAspect("potentia"), 6)
                        .add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEESSTERM", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEESSVIBCMBR",
                getModItem("thaumicenergistics", "thaumicenergistics.block.essentia.vibration.chamber", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 35).add(Aspect.getAspect("ordo"), 35)
                        .add(Aspect.getAspect("perditio"), 35).add(Aspect.getAspect("aqua"), 35),
                "abc",
                "def",
                "ghi",
                'a',
                "plateInfusedOrder",
                'b',
                getModItem("thaumicenergistics", "part.base", 1, 4, missing),
                'c',
                "plateInfusedOrder",
                'd',
                getModItem("thaumicenergistics", "material", 1, 0, missing),
                'e',
                getModItem("appliedenergistics2", "tile.BlockVibrationChamber", 1, 0, missing),
                'f',
                getModItem("thaumicenergistics", "material", 1, 0, missing),
                'g',
                "plateInfusedEntropy",
                'h',
                getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                'i',
                "plateInfusedEntropy");
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEESSVIBCMBR",
                new AspectList().add(Aspect.getAspect("vitreus"), 18).add(Aspect.getAspect("machina"), 15)
                        .add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("motus"), 6).add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEESSVIBCMBR", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEIO",
                getModItem("thaumicenergistics", "part.base", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("terra"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'b',
                getModItem("thaumicenergistics", "material", 1, 0, missing),
                'c',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'd',
                "plateInfusedOrder",
                'e',
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 240, missing),
                'f',
                "plateInfusedOrder",
                'g',
                getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                'h',
                getModItem("Thaumcraft", "blockTube", 1, 3, missing),
                'i',
                getModItem("Thaumcraft", "blockJar", 1, 0, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEIO",
                getModItem("thaumicenergistics", "part.base", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("terra"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                'b',
                getModItem("Thaumcraft", "blockTube", 1, 3, missing),
                'c',
                getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                'd',
                "plateInfusedOrder",
                'e',
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 260, missing),
                'f',
                "plateInfusedOrder",
                'g',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'h',
                getModItem("thaumicenergistics", "material", 1, 1, missing),
                'i',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEIO",
                getModItem("thaumicenergistics", "part.base", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("aqua"), 20)
                        .add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("terra"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                'b',
                "plateInfusedWater",
                'c',
                getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                'd',
                getModItem("thaumicenergistics", "material", 1, 0, missing),
                'e',
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 220, missing),
                'f',
                getModItem("thaumicenergistics", "material", 1, 1, missing),
                'g',
                getModItem("Thaumcraft", "blockTube", 1, 3, missing),
                'h',
                "plateInfusedWater",
                'i',
                getModItem("Thaumcraft", "blockTube", 1, 3, missing));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEIO",
                new AspectList().add(Aspect.getAspect("motus"), 18).add(Aspect.getAspect("machina"), 15)
                        .add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("vitreus"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEIO", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEDISTILLATIONPATTERNENCODER",
                getModItem("thaumicenergistics", "thaumicenergistics.block.distillation.encoder", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("perditio"), 25)
                        .add(Aspect.getAspect("ignis"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                "plateInfusedFire",
                'b',
                getModItem("Thaumcraft", "ItemThaumometer", 1, 0, missing),
                'c',
                "plateInfusedFire",
                'd',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                'e',
                getModItem("ae2stuff", "Encoder", 1, 0, missing),
                'f',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                'g',
                "plateInfusedOrder",
                'h',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 24, missing),
                'i',
                "plateInfusedOrder");
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEDISTILLATIONPATTERNENCODER",
                new AspectList().add(Aspect.getAspect("ordo"), 21).add(Aspect.getAspect("fabrico"), 18)
                        .add(Aspect.getAspect("permutatio"), 15).add(Aspect.getAspect("perditio"), 12)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("cognitio"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEDISTILLATIONPATTERNENCODER", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEFOCUSWRENCH",
                getModItem("thaumicenergistics", "focus.aewrench", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("aer"), 25)
                        .add(Aspect.getAspect("ignis"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                'b',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 10, missing),
                'c',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                'd',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 11, missing),
                'e',
                getModItem("appliedenergistics2", "item.ToolCertusQuartzWrench", 1, 0, missing),
                'f',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 11, missing),
                'g',
                getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                'h',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 10, missing),
                'i',
                getModItem("Thaumcraft", "blockCrystal", 1, 0, missing));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEFOCUSWRENCH",
                new AspectList().add(Aspect.getAspect("ignis"), 18).add(Aspect.getAspect("aer"), 15)
                        .add(Aspect.getAspect("machina"), 12).add(Aspect.getAspect("instrumentum"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("metallum"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEFOCUSWRENCH", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEGOLEMWIFIBACKPACK",
                getModItem("thaumicenergistics", "golem.wifi.backpack", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("aer"), 30)
                        .add(Aspect.getAspect("ignis"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 440, missing),
                'c',
                "plateThaumium",
                'd',
                getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                'e',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 41, missing),
                'f',
                getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                'g',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 9, missing),
                'h',
                getModItem("appliedenergistics2", "tile.BlockCharger", 1, 0, missing),
                'i',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 9, missing));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEGOLEMWIFIBACKPACK",
                new AspectList().add(Aspect.getAspect("vacuos"), 21).add(Aspect.getAspect("potentia"), 18)
                        .add(Aspect.getAspect("auram"), 15).add(Aspect.getAspect("cognitio"), 12)
                        .add(Aspect.getAspect("tutamen"), 9).add(Aspect.getAspect("motus"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEGOLEMWIFIBACKPACK", 3);
        TCHelper.clearPages("thaumicenergistics.TESTORAGE");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage("thaumicenergistics.research_page.TESTORAGE.1"));
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage("thaumicenergistics.research_page.TESTORAGE.2"));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem("thaumicenergistics", "storage.component", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("ignis"), 10)
                        .add(Aspect.getAspect("aqua"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitPrimitive",
                'b',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'c',
                "circuitPrimitive",
                'd',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'e',
                getModItem("dreamcraft", "item.EngineeringProcessorEssentiaPulsatingCore", 1, 0, missing),
                'f',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'g',
                "circuitPrimitive",
                'h',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'i',
                "circuitPrimitive");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem("thaumicenergistics", "storage.component", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem("thaumicenergistics", "storage.component", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("aqua"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitBasic",
                'b',
                getModItem("thaumicenergistics", "storage.component", 1, 0, missing),
                'c',
                "circuitBasic",
                'd',
                getModItem("thaumicenergistics", "storage.component", 1, 0, missing),
                'e',
                getModItem("dreamcraft", "item.EngineeringProcessorEssentiaPulsatingCore", 1, 0, missing),
                'f',
                getModItem("thaumicenergistics", "storage.component", 1, 0, missing),
                'g',
                "circuitBasic",
                'h',
                getModItem("thaumicenergistics", "storage.component", 1, 0, missing),
                'i',
                "circuitBasic");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem("thaumicenergistics", "storage.component", 1, 1, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem("thaumicenergistics", "storage.component", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 30).add(Aspect.getAspect("ignis"), 30)
                        .add(Aspect.getAspect("aqua"), 30),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitGood",
                'b',
                getModItem("thaumicenergistics", "storage.component", 1, 1, missing),
                'c',
                "circuitGood",
                'd',
                getModItem("thaumicenergistics", "storage.component", 1, 1, missing),
                'e',
                getModItem("dreamcraft", "item.EngineeringProcessorEssentiaPulsatingCore", 1, 0, missing),
                'f',
                getModItem("thaumicenergistics", "storage.component", 1, 1, missing),
                'g',
                "circuitGood",
                'h',
                getModItem("thaumicenergistics", "storage.component", 1, 1, missing),
                'i',
                "circuitGood");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem("thaumicenergistics", "storage.component", 1, 2, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem("thaumicenergistics", "storage.component", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 40).add(Aspect.getAspect("ignis"), 40)
                        .add(Aspect.getAspect("aqua"), 40),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitAdvanced",
                'b',
                getModItem("thaumicenergistics", "storage.component", 1, 2, missing),
                'c',
                "circuitAdvanced",
                'd',
                getModItem("thaumicenergistics", "storage.component", 1, 2, missing),
                'e',
                getModItem("dreamcraft", "item.EngineeringProcessorEssentiaPulsatingCore", 1, 0, missing),
                'f',
                getModItem("thaumicenergistics", "storage.component", 1, 2, missing),
                'g',
                "circuitAdvanced",
                'h',
                getModItem("thaumicenergistics", "storage.component", 1, 2, missing),
                'i',
                "circuitAdvanced");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem("thaumicenergistics", "storage.component", 1, 3, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem("thaumicenergistics", "storage.casing", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("aqua"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'b',
                "plateInfusedFire",
                'c',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'd',
                "plateInfusedEarth",
                'e',
                getModItem("TConstruct", "GlassPane", 1, 0, missing),
                'f',
                "plateInfusedEarth",
                'g',
                "plateThaumium",
                'h',
                "plateThaumium",
                'i',
                "plateThaumium");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("thaumicenergistics", "storage.casing", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem("thaumicenergistics", "storage.essentia", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("aqua"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'b',
                "plateInfusedFire",
                'c',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'd',
                "plateInfusedEarth",
                'e',
                getModItem("thaumicenergistics", "storage.component", 1, 0, missing),
                'f',
                "plateInfusedEarth",
                'g',
                "plateThaumium",
                'h',
                "plateThaumium",
                'i',
                "plateThaumium");
        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem("thaumicenergistics", "storage.essentia", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 5).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("aqua"), 5),
                getModItem("thaumicenergistics", "storage.casing", 1, 0, missing),
                getModItem("thaumicenergistics", "storage.component", 1, 0, missing));
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem("thaumicenergistics", "storage.essentia", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem("thaumicenergistics", "storage.essentia", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("terra"), 25)
                        .add(Aspect.getAspect("aqua"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'b',
                "plateInfusedFire",
                'c',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'd',
                "plateInfusedEarth",
                'e',
                getModItem("thaumicenergistics", "storage.component", 1, 1, missing),
                'f',
                "plateInfusedEarth",
                'g',
                "plateThaumium",
                'h',
                "plateThaumium",
                'i',
                "plateThaumium");
        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem("thaumicenergistics", "storage.essentia", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("aqua"), 15),
                getModItem("thaumicenergistics", "storage.casing", 1, 0, missing),
                getModItem("thaumicenergistics", "storage.component", 1, 1, missing));
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem("thaumicenergistics", "storage.essentia", 1, 1, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem("thaumicenergistics", "storage.essentia", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 35).add(Aspect.getAspect("terra"), 35)
                        .add(Aspect.getAspect("aqua"), 35),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'b',
                "plateInfusedFire",
                'c',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'd',
                "plateInfusedEarth",
                'e',
                getModItem("thaumicenergistics", "storage.component", 1, 2, missing),
                'f',
                "plateInfusedEarth",
                'g',
                "plateThaumium",
                'h',
                "plateThaumium",
                'i',
                "plateThaumium");
        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem("thaumicenergistics", "storage.essentia", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 25).add(Aspect.getAspect("terra"), 25)
                        .add(Aspect.getAspect("aqua"), 25),
                getModItem("thaumicenergistics", "storage.casing", 1, 0, missing),
                getModItem("thaumicenergistics", "storage.component", 1, 2, missing));
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem("thaumicenergistics", "storage.essentia", 1, 2, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem("thaumicenergistics", "storage.essentia", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 45).add(Aspect.getAspect("terra"), 45)
                        .add(Aspect.getAspect("aqua"), 45),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'b',
                "plateInfusedFire",
                'c',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'd',
                "plateInfusedEarth",
                'e',
                getModItem("thaumicenergistics", "storage.component", 1, 3, missing),
                'f',
                "plateInfusedEarth",
                'g',
                "plateThaumium",
                'h',
                "plateThaumium",
                'i',
                "plateThaumium");
        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem("thaumicenergistics", "storage.essentia", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 35).add(Aspect.getAspect("terra"), 35)
                        .add(Aspect.getAspect("aqua"), 35),
                getModItem("thaumicenergistics", "storage.casing", 1, 0, missing),
                getModItem("thaumicenergistics", "storage.component", 1, 3, missing));
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem("thaumicenergistics", "storage.essentia", 1, 3, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TESTORAGE",
                getModItem("thaumicenergistics", "thaumicenergistics.block.essentia.cell.workbench", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("ignis"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "craftingToolScrewdriver",
                'b',
                getModItem("thaumicenergistics", "storage.component", 1, 0, missing),
                'c',
                "craftingToolWrench",
                'd',
                "screwInfusedEarth",
                'e',
                getModItem("appliedenergistics2", "tile.BlockCellWorkbench", 1, 0, missing),
                'f',
                "screwInfusedEarth",
                'g',
                "plateInfusedOrder",
                'h',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 22, missing),
                'i',
                "plateInfusedOrder");
        TCHelper.addResearchPage(
                "thaumicenergistics.TESTORAGE",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(
                                        "thaumicenergistics",
                                        "thaumicenergistics.block.essentia.cell.workbench",
                                        1,
                                        0,
                                        missing))));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TESTORAGE",
                new AspectList().add(Aspect.getAspect("vacuos"), 21).add(Aspect.getAspect("potentia"), 18)
                        .add(Aspect.getAspect("vitreus"), 15).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("aqua"), 6)
                        .add(Aspect.getAspect("motus"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TESTORAGE", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEVISINT",
                getModItem("thaumicenergistics", "part.base", 1, 6, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("aqua"), 20)
                        .add(Aspect.getAspect("perditio"), 20).add(Aspect.getAspect("aer"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'b',
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 440, missing),
                'c',
                getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                'd',
                "screwInfusedEarth",
                'e',
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 460, missing),
                'f',
                "screwInfusedEarth",
                'g',
                "plateInfusedOrder",
                'h',
                "plateInfusedOrder",
                'i',
                "plateInfusedOrder");
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEVISINT",
                new AspectList().add(Aspect.getAspect("vacuos"), 21).add(Aspect.getAspect("potentia"), 18)
                        .add(Aspect.getAspect("auram"), 15).add(Aspect.getAspect("metallum"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("machina"), 6)
                        .add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEVISINT", 3);
        ThaumcraftApi.addCrucibleRecipe(
                "thaumicenergistics.TETHAUMGBOX",
                getModItem("thaumicenergistics", "thaumicenergistics.block.golem.gear.box", 1, 0, missing),
                getModItem("thaumicenergistics", "thaumicenergistics.block.gear.box", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("metallum"), 32).add(Aspect.getAspect("praecantatio"), 32));
        TCHelper.setResearchAspects(
                "thaumicenergistics.TETHAUMGBOX",
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("machina"), 12)
                        .add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("permutatio"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TETHAUMGBOX", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "thaumicenergistics.TEARCANEASSEMBLER",
                getModItem("thaumicenergistics", "thaumicenergistics.block.arcane.assembler", 1, 0, missing),
                16,
                new AspectList().add(Aspect.getAspect("auram"), 16).add(Aspect.getAspect("fabrico"), 64)
                        .add(Aspect.getAspect("metallum"), 8).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("lucrum"), 16).add(Aspect.getAspect("praecantatio"), 48)
                        .add(Aspect.getAspect("vitreus"), 16),
                getModItem("appliedenergistics2", "tile.BlockMolecularAssembler", 1, 0, missing),
                new ItemStack[] { createItemStack(
                        "Thaumcraft",
                        "WandCasting",
                        1,
                        32767,
                        "{aqua:15000,ignis:15000,terra:15000,cap:\"thaumium\",rod:\"silverwood\",ordo:15000,sceptre:1b,perditio:15000,aer:15000}",
                        missing), getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 1, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 2, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 3, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 4, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 5, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing), });
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEARCANEASSEMBLER",
                new AspectList().add(Aspect.getAspect("lucrum"), 24).add(Aspect.getAspect("fabrico"), 21)
                        .add(Aspect.getAspect("machina"), 18).add(Aspect.getAspect("cognitio"), 15)
                        .add(Aspect.getAspect("permutatio"), 12).add(Aspect.getAspect("auram"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("aqua"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEARCANEASSEMBLER", 3);
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEKNOWLEDGEINSCRIBER",
                getModItem("thaumicenergistics", "knowledge.core", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 10).add(Aspect.getAspect("terra"), 10)
                        .add(Aspect.getAspect("aqua"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                "plateInfusedOrder",
                'b',
                "plateInfusedWater",
                'c',
                "plateInfusedOrder",
                'd',
                getModItem("Thaumcraft", "ItemResource", 1, 9, missing),
                'e',
                getModItem("Thaumcraft", "ItemZombieBrain", 1, 0, missing),
                'f',
                getModItem("Thaumcraft", "ItemResource", 1, 9, missing),
                'g',
                "plateInfusedOrder",
                'h',
                getModItem("appliedenergistics2", "item.ItemMultiMaterial", 1, 23, missing),
                'i',
                "plateInfusedOrder");
        ThaumcraftApi.addArcaneCraftingRecipe(
                "thaumicenergistics.TEKNOWLEDGEINSCRIBER",
                getModItem("thaumicenergistics", "thaumicenergistics.block.knowledge.inscriber", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 20).add(Aspect.getAspect("terra"), 20)
                        .add(Aspect.getAspect("ignis"), 20).add(Aspect.getAspect("aqua"), 20)
                        .add(Aspect.getAspect("perditio"), 20).add(Aspect.getAspect("aer"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                getModItem("appliedenergistics2", "item.ItemMultiPart", 1, 400, missing),
                'c',
                "plateThaumium",
                'd',
                "plateInfusedEntropy",
                'e',
                getModItem("thaumicenergistics", "knowledge.core", 1, 0, missing),
                'f',
                "plateInfusedEntropy",
                'g',
                "plateThaumium",
                'h',
                getModItem("Thaumcraft", "ItemThaumonomicon", 1, 0, missing),
                'i',
                "plateThaumium");
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEKNOWLEDGEINSCRIBER",
                new AspectList().add(Aspect.getAspect("cognitio"), 18).add(Aspect.getAspect("machina"), 15)
                        .add(Aspect.getAspect("fabrico"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("alienis"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEKNOWLEDGEINSCRIBER", 3);
        ThaumcraftApi.addInfusionCraftingRecipe(
                "thaumicenergistics.TEINFPROV",
                getModItem("thaumicenergistics", "thaumicenergistics.block.infusion.provider", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("machina"), 64).add(Aspect.getAspect("ordo"), 48)
                        .add(Aspect.getAspect("permutatio"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("alienis"), 24).add(Aspect.getAspect("spiritus"), 8),
                getModItem("thaumicenergistics", "thaumicenergistics.block.essentia.provider", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "blockMirror", 1, 6, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing),
                        getModItem("thaumicenergistics", "part.base", 1, 0, missing),
                        getModItem("thaumicenergistics", "material", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("Thaumcraft", "blockMirror", 1, 6, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                        getModItem("thaumicenergistics", "material", 1, 1, missing),
                        getModItem("thaumicenergistics", "part.base", 1, 3, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 0, missing), });
        TCHelper.setResearchAspects(
                "thaumicenergistics.TEINFPROV",
                new AspectList().add(Aspect.getAspect("permutatio"), 21).add(Aspect.getAspect("motus"), 18)
                        .add(Aspect.getAspect("sensus"), 15).add(Aspect.getAspect("machina"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("alienis"), 6)
                        .add(Aspect.getAspect("spiritus"), 3));
        TCHelper.setResearchComplexity("thaumicenergistics.TEINFPROV", 3);
        TCHelper.refreshResearchPages("thaumicenergistics.TEESSPROV");
        TCHelper.refreshResearchPages("thaumicenergistics.TEIRONGEARBOX");
        TCHelper.refreshResearchPages("thaumicenergistics.TEARCANETERM");
        TCHelper.refreshResearchPages("thaumicenergistics.TECERTUSDUPE");
        TCHelper.refreshResearchPages("thaumicenergistics.TECORES");
        TCHelper.refreshResearchPages("thaumicenergistics.TEESSTERM");
        TCHelper.refreshResearchPages("thaumicenergistics.TEESSVIBCMBR");
        TCHelper.refreshResearchPages("thaumicenergistics.TEIO");
        TCHelper.refreshResearchPages("thaumicenergistics.TEDISTILLATIONPATTERNENCODER");
        TCHelper.refreshResearchPages("thaumicenergistics.TEFOCUSWRENCH");
        TCHelper.refreshResearchPages("thaumicenergistics.TEGOLEMWIFIBACKPACK");
        TCHelper.refreshResearchPages("thaumicenergistics.TESTORAGE");
        TCHelper.refreshResearchPages("thaumicenergistics.TEVISINT");
        TCHelper.refreshResearchPages("thaumicenergistics.TETHAUMGBOX");
        TCHelper.refreshResearchPages("thaumicenergistics.TEARCANEASSEMBLER");
        TCHelper.refreshResearchPages("thaumicenergistics.TEKNOWLEDGEINSCRIBER");
        TCHelper.refreshResearchPages("thaumicenergistics.TEINFPROV");
    }
}
