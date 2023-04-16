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

public class ScriptEMT implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "EMT";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(Mods.ElectroMagicTools.ID, Mods.Thaumcraft.ID);
    }

    @Override
    public void loadRecipes() {
        ItemStack missing = new ItemStack(Blocks.dirt);

        TCHelper.removeArcaneRecipe(getModItem("EMT", "EMTItems", 1, 14, missing));
        TCHelper.removeArcaneRecipe(getModItem("EMT", "ThaumiumWing", 1, 0, missing));
        TCHelper.removeInfusionRecipe(createItemStack("EMT", "NanosuitWing", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(createItemStack("EMT", "QuantumWing", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeArcaneRecipe(createItemStack("EMT", "Diamond Omnitool", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeArcaneRecipe(getModItem("EMT", "Diamond Omnitool", 1, 0, missing));
        TCHelper.removeInfusionRecipe(createItemStack("EMT", "ThaumiumOmnitool", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(getModItem("EMT", "ThaumiumOmnitool", 1, 0, missing));
        TCHelper.removeInfusionRecipe(
                createItemStack("EMT", "ElectricBootsTraveller", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(createItemStack("EMT", "NanoBootsTraveller", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(
                createItemStack("EMT", "QuantumBootsTraveller", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(createItemStack("EMT", "ThaumiumDrill", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(createItemStack("EMT", "DrillRockbreaker", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(createItemStack("EMT", "ThaumiumChainsaw", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(createItemStack("EMT", "ChainsawStream", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(getModItem("EMT", "EMTBaubles", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("EMT", "EMTBaubles", 1, 1, missing));
        TCHelper.removeArcaneRecipe(
                createItemStack("EMT", "ElectricGogglesRevealing", 1, 164, "{charge:10.0d}", missing));
        TCHelper.removeArcaneRecipe(
                createItemStack("EMT", "ElectricGogglesRevealing", 1, 164, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(
                createItemStack("EMT", "NanosuitGogglesRevealing", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(
                createItemStack("EMT", "QuantumGogglesRevealing", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(createItemStack("EMT", "SolarHelmetRevealing", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeArcaneRecipe(getModItem("EMT", "EMTSolars", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("EMT", "EMTSolars", 1, 1, missing));
        TCHelper.removeInfusionRecipe(getModItem("EMT", "EMTSolars", 1, 2, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 3, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 4, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 5, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 6, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 7, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 8, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 9, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 10, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 11, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 12, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 13, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 14, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 15, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars2", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars2", 1, 1, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars2", 1, 2, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars2", 1, 3, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTSolars2", 1, 4, missing));
        TCHelper.removeInfusionRecipe(createItemStack("EMT", "ElectricHoeGrowth", 1, 1560, "{charge:10.0d}", missing));
        TCHelper.removeArcaneRecipe(createItemStack("EMT", "ElectricScribingTools", 1, 390, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(getModItem("EMT", "Mjolnir", 1, 0, missing));
        TCHelper.removeInfusionRecipe(createItemStack("EMT", "SuperchargedMjolnir", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeArcaneRecipe(getModItem("IC2", "itemUran235small", 7, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EMTItems", 1, 15, missing));
        TCHelper.removeInfusionRecipe(getModItem("minecraft", "coal", 16, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("minecraft", "glowstone", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("IC2", "itemOreIridium", 2, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("minecraft", "gold_ingot", 2, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("minecraft", "diamond", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("EMT", "ShieldFocus", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("IC2", "itemUran238", 2, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("EMT", "ShieldBlock", 6, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem("EMT", "ChristmasFocus", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("EMT", "EnergyBallFocus", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("EMT", "ExplosionFocus", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("EMT", "ChargingFocus", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("EMT", "WandChargingFocus", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("EMT", "EssentiaGenerators", 1, 5, missing));
        TCHelper.removeInfusionRecipe(getModItem("EMT", "EssentiaGenerators", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EssentiaGenerators", 1, 1, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EssentiaGenerators", 1, 2, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EssentiaGenerators", 1, 3, missing));
        TCHelper.removeCrucibleRecipe(getModItem("EMT", "EssentiaGenerators", 1, 4, missing));
        TCHelper.removeInfusionRecipe(getModItem("EMT", "EMTMachines", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem("EMT", "EMTMachines", 1, 1, missing));
        TCHelper.orphanResearch("Electric Magic Tools");
        TCHelper.removeResearch("Electric Magic Tools");
        new ResearchItem(
                "ElectricMagicTools",
                "EMT",
                new AspectList().add(Aspect.getAspect("terra"), 0),
                0,
                0,
                1,
                getModItem("dreamcraft", "item.EMT", 1, 0, missing)).setAutoUnlock().setSpecial()
                        .setPages(new ResearchPage("tc.research_page.ElectricMagicTools")).registerResearchItem();
        TCHelper.removeResearch("Diamond Chainsaw");
        new ResearchItem(
                "DiamondChainsaw",
                "EMT",
                new AspectList().add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("ignis"), 9)
                        .add(Aspect.getAspect("metallum"), 6).add(Aspect.getAspect("terra"), 3),
                0,
                -2,
                2,
                createItemStack("EMT", "DiamondChainsaw", 1, 27, "{shearsMode:1b}", missing))
                        .setParents("ElectricMagicTools").setRound()
                        .setPages(new ResearchPage("tc.research_page.DiamondChainsaw")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DiamondChainsaw",
                createItemStack("EMT", "DiamondChainsaw", 1, 27, "{shearsMode:1b}", missing),
                new AspectList().add(Aspect.getAspect("aer"), 35).add(Aspect.getAspect("terra"), 35)
                        .add(Aspect.getAspect("ignis"), 35).add(Aspect.getAspect("aqua"), 35)
                        .add(Aspect.getAspect("ordo"), 35).add(Aspect.getAspect("perditio"), 35),
                "abc",
                "def",
                "ghi",
                'a',
                "screwTitanium",
                'b',
                "toolHeadChainsawThaumium",
                'c',
                "screwTitanium",
                'd',
                "plateDiamond",
                'e',
                "circuitAdvanced",
                'f',
                "plateDiamond",
                'g',
                "craftingToolHardHammer",
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 32528, missing),
                'i',
                "craftingToolWrench");
        TCHelper.addResearchPage(
                "DiamondChainsaw",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack("EMT", "DiamondChainsaw", 1, 27, "{shearsMode:1b}", missing))));
        TCHelper.removeResearch("Thaumium Plate");
        new ResearchItem(
                "ThaumiumPlate",
                "EMT",
                new AspectList(),
                6,
                -6,
                1,
                getModItem("EMT", "EMTItems", 1, 5, missing)).setAutoUnlock().setRound()
                        .setPages(new ResearchPage("tc.research_page.ThaumiumPlate")).registerResearchItem();
        TCHelper.orphanResearch("Electric Cloud");
        TCHelper.removeResearch("Electric Cloud");
        new ResearchItem(
                "ElectricCloud",
                "EMT",
                new AspectList(),
                5,
                -6,
                1,
                getModItem("EMT", "electricCloud", 1, 0, missing))
                        .setAutoUnlock().setRound()
                        .setPages(
                                new ResearchPage("tc.research_page.ElectricCloud1"),
                                new ResearchPage("tc.research_page.ElectricCloud2"))
                        .registerResearchItem();
        TCHelper.orphanResearch("Feather Wings");
        TCHelper.removeResearch("Feather Wings");
        new ResearchItem(
                "FeatherWings",
                "EMT",
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("volatus"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                0,
                2,
                3,
                getModItem("EMT", "FeatherWing", 1, 0, missing)).setParents("ElectricMagicTools").setRound()
                        .setPages(new ResearchPage("tc.research_page.FeatherWings")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FeatherWings",
                getModItem("EMT", "EMTItems", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("minecraft", "feather", 1, 0, missing),
                'b',
                getModItem("minecraft", "feather", 1, 0, missing),
                'c',
                getModItem("minecraft", "feather", 1, 0, missing),
                'd',
                getModItem("minecraft", "feather", 1, 0, missing),
                'e',
                getModItem("EMT", "EMTItems", 1, 9, missing),
                'f',
                getModItem("minecraft", "feather", 1, 0, missing),
                'g',
                getModItem("minecraft", "feather", 1, 0, missing),
                'h',
                getModItem("minecraft", "feather", 1, 0, missing),
                'i',
                getModItem("minecraft", "feather", 1, 0, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FeatherWings",
                getModItem("EMT", "EMTItems", 1, 11, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("gregtech", "gt.metaitem.01", 1, 21879, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 21879, missing),
                'd',
                getModItem("EMT", "EMTItems", 1, 8, missing),
                'e',
                getModItem("EMT", "EMTItems", 1, 8, missing));
        TCHelper.addResearchPage(
                "FeatherWings",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("EMT", "EMTItems", 1, 11, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FeatherWings",
                getModItem("EMT", "EMTItems", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("EMT", "EMTItems", 1, 7, missing),
                'b',
                getModItem("EMT", "EMTItems", 1, 8, missing),
                'c',
                getModItem("EMT", "EMTItems", 1, 11, missing),
                'd',
                getModItem("EMT", "EMTItems", 1, 7, missing),
                'e',
                getModItem("minecraft", "string", 1, 0, missing),
                'f',
                getModItem("EMT", "EMTItems", 1, 11, missing),
                'g',
                getModItem("EMT", "EMTItems", 1, 7, missing),
                'h',
                getModItem("EMT", "EMTItems", 1, 8, missing),
                'i',
                getModItem("EMT", "EMTItems", 1, 11, missing));
        TCHelper.addResearchPage(
                "FeatherWings",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("EMT", "EMTItems", 1, 12, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FeatherWings",
                getModItem("EMT", "FeatherWing", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("terra"), 24)
                        .add(Aspect.getAspect("ignis"), 24).add(Aspect.getAspect("aqua"), 24)
                        .add(Aspect.getAspect("ordo"), 24).add(Aspect.getAspect("perditio"), 24),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("EMT", "EMTItems", 1, 12, missing),
                'b',
                getModItem("minecraft", "string", 1, 0, missing),
                'c',
                getModItem("EMT", "EMTItems", 1, 12, missing),
                'd',
                getModItem("EMT", "EMTItems", 1, 12, missing),
                'e',
                "plateAluminium",
                'f',
                getModItem("EMT", "EMTItems", 1, 12, missing),
                'g',
                getModItem("EMT", "EMTItems", 1, 12, missing),
                'h',
                getModItem("minecraft", "string", 1, 0, missing),
                'i',
                getModItem("EMT", "EMTItems", 1, 12, missing));
        TCHelper.addResearchPage(
                "FeatherWings",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("EMT", "FeatherWing", 1, 0, missing))));
        TCHelper.orphanResearch("Thaumium Reinforced Wings");
        TCHelper.removeResearch("Thaumium Reinforced Wings");
        new ResearchItem(
                "ThaumiumReinforcedWings",
                "EMT",
                new AspectList().add(Aspect.getAspect("aer"), 21).add(Aspect.getAspect("potentia"), 18)
                        .add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("volatus"), 12)
                        .add(Aspect.getAspect("metallum"), 9).add(Aspect.getAspect("vitium"), 6)
                        .add(Aspect.getAspect("machina"), 3),
                0,
                4,
                3,
                getModItem("EMT", "ThaumiumWing", 1, 0, missing)).setParents("FeatherWings").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.ThaumiumReinforcedWings")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "ThaumiumReinforcedWings",
                getModItem("EMT", "EMTItems", 1, 13, missing),
                getModItem("minecraft", "feather", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("vitium"), 6).add(Aspect.getAspect("lucrum"), 4)
                        .add(Aspect.getAspect("fames"), 4));
        TCHelper.addResearchPage(
                "ThaumiumReinforcedWings",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTItems", 1, 13, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ThaumiumReinforcedWings",
                getModItem("EMT", "EMTItems", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("aer"), 48).add(Aspect.getAspect("terra"), 48)
                        .add(Aspect.getAspect("ignis"), 48).add(Aspect.getAspect("aqua"), 48)
                        .add(Aspect.getAspect("ordo"), 48).add(Aspect.getAspect("perditio"), 48),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("EMT", "EMTItems", 1, 13, missing),
                'b',
                "plateThaumium",
                'c',
                "plateStainlessSteel",
                'd',
                getModItem("EMT", "EMTItems", 1, 13, missing),
                'e',
                "wireFineCobalt",
                'f',
                "plateStainlessSteel",
                'g',
                getModItem("EMT", "EMTItems", 1, 13, missing),
                'h',
                "plateThaumium",
                'i',
                "plateStainlessSteel");
        TCHelper.addResearchPage(
                "ThaumiumReinforcedWings",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("EMT", "EMTItems", 1, 14, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ThaumiumReinforcedWings",
                getModItem("EMT", "ThaumiumWing", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 48).add(Aspect.getAspect("terra"), 48)
                        .add(Aspect.getAspect("ignis"), 48).add(Aspect.getAspect("aqua"), 48)
                        .add(Aspect.getAspect("ordo"), 48).add(Aspect.getAspect("perditio"), 48),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("EMT", "EMTItems", 1, 14, missing),
                'b',
                "wireFineCobalt",
                'c',
                getModItem("EMT", "EMTItems", 1, 14, missing),
                'd',
                getModItem("EMT", "EMTItems", 1, 14, missing),
                'e',
                "wireFineCobalt",
                'f',
                getModItem("EMT", "EMTItems", 1, 14, missing));
        TCHelper.addResearchPage(
                "ThaumiumReinforcedWings",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("EMT", "ThaumiumWing", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ThaumiumReinforcedWings", 1);
        TCHelper.orphanResearch("Nanosuit Wings");
        TCHelper.removeResearch("Nanosuit Wings");
        new ResearchItem(
                "NanosuitWings",
                "EMT",
                new AspectList().add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("potentia"), 21)
                        .add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("volatus"), 15)
                        .add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("vitium"), 9)
                        .add(Aspect.getAspect("machina"), 6).add(Aspect.getAspect("terra"), 3),
                0,
                6,
                3,
                getModItem("EMT", "NanosuitWing", 1, 0, missing)).setParents("ThaumiumReinforcedWings").setConcealed()
                        .setRound().setPages(new ResearchPage("tc.research_page.NanosuitWings")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "NanosuitWings",
                getModItem("EMT", "NanosuitWing", 1, 27, missing),
                5,
                new AspectList().add(Aspect.getAspect("aer"), 48).add(Aspect.getAspect("machina"), 48)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("volatus"), 32)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("vitium"), 8)
                        .add(Aspect.getAspect("terra"), 8),
                getModItem("EMT", "ThaumiumWing", 1, 0, missing),
                new ItemStack[] { getModItem("IC2", "itemArmorNanoChestplate", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19028, missing),
                        getModItem("IC2", "itemPartCarbonPlate", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19028, missing),
                        getModItem("IC2", "itemPartCarbonPlate", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19028, missing),
                        getModItem("IC2", "itemPartCarbonPlate", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19028, missing),
                        getModItem("IC2", "itemPartCarbonPlate", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19028, missing), });
        TCHelper.addResearchPage(
                "NanosuitWings",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "NanosuitWing", 1, 27, missing))));
        ThaumcraftApi.addWarpToResearch("NanosuitWings", 2);
        TCHelper.orphanResearch("Quantum Wings");
        TCHelper.removeResearch("Quantum Wings");
        new ResearchItem(
                "QuantumWings",
                "EMT",
                new AspectList().add(Aspect.getAspect("aer"), 27).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("praecantatio"), 21).add(Aspect.getAspect("volatus"), 18)
                        .add(Aspect.getAspect("metallum"), 15).add(Aspect.getAspect("vitium"), 12)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("terra"), 6)
                        .add(Aspect.getAspect("lucrum"), 3),
                0,
                8,
                3,
                getModItem("EMT", "QuantumWing", 1, 0, missing)).setParents("NanosuitWings").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.QuantumWings")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "QuantumWings",
                getModItem("EMT", "QuantumWing", 1, 27, missing),
                10,
                new AspectList().add(Aspect.getAspect("tutamen"), 64).add(Aspect.getAspect("aer"), 64)
                        .add(Aspect.getAspect("machina"), 64).add(Aspect.getAspect("potentia"), 48)
                        .add(Aspect.getAspect("volatus"), 48).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("vitium"), 16).add(Aspect.getAspect("terra"), 16),
                getModItem("EMT", "NanosuitWing", 1, 32767, missing),
                new ItemStack[] { getModItem("IC2", "itemArmorQuantumChestplate", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19083, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19083, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19083, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19083, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19083, missing), });
        TCHelper.addResearchPage(
                "QuantumWings",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "QuantumWing", 1, 27, missing))));
        ThaumcraftApi.addWarpToResearch("QuantumWings", 3);
        TCHelper.orphanResearch("Infused Quantum Armor");
        TCHelper.removeResearch("Infused Quantum Armor");
        new ResearchItem(
                "InfusedQuantumArmor",
                "EMT",
                new AspectList().add(Aspect.getAspect("aer"), 30).add(Aspect.getAspect("potentia"), 27)
                        .add(Aspect.getAspect("praecantatio"), 24).add(Aspect.getAspect("volatus"), 21)
                        .add(Aspect.getAspect("metallum"), 18).add(Aspect.getAspect("vitium"), 15)
                        .add(Aspect.getAspect("machina"), 12).add(Aspect.getAspect("terra"), 9)
                        .add(Aspect.getAspect("lucrum"), 6).add(Aspect.getAspect("superbia"), 3),
                0,
                10,
                3,
                getModItem("EMT", "itemArmorQuantumChestplate", 1, 0, missing)).setParents("QuantumWings")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.InfusedQuantumArmor"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "InfusedQuantumArmor",
                getModItem("EMT", "itemArmorQuantumChestplate", 1, 27, missing),
                15,
                new AspectList().add(Aspect.getAspect("tutamen"), 72).add(Aspect.getAspect("aer"), 64)
                        .add(Aspect.getAspect("machina"), 64).add(Aspect.getAspect("potentia"), 48)
                        .add(Aspect.getAspect("volatus"), 48).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("vitium"), 16).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("lucrum"), 8),
                getModItem("IC2", "itemArmorQuantumChestplate", 1, 32767, missing),
                new ItemStack[] { getModItem("EMT", "ShieldBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19324, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19324, missing),
                        getModItem("EMT", "ShieldBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19324, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19324, missing), });
        TCHelper.addResearchPage(
                "InfusedQuantumArmor",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("EMT", "itemArmorQuantumChestplate", 1, 27, missing))));
        ThaumcraftApi.addWarpToResearch("InfusedQuantumArmor", 4);
        TCHelper.orphanResearch("Iron Omnitool");
        TCHelper.removeResearch("Iron Omnitool");
        new ResearchItem(
                "IronOmnitool",
                "EMT",
                new AspectList().add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("instrumentum"), 9)
                        .add(Aspect.getAspect("perfodio"), 6).add(Aspect.getAspect("telum"), 3),
                -2,
                0,
                2,
                getModItem("EMT", "Omnitool", 1, 0, missing)).setParents("ElectricMagicTools").setRound()
                        .setPages(new ResearchPage("tc.research_page.IronOmnitool")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IronOmnitool",
                getModItem("EMT", "Omnitool", 1, 27, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("terra"), 15)
                        .add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("aqua"), 15)
                        .add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("perditio"), 15),
                "abc",
                "def",
                "ghi",
                'a',
                "screwStainlessSteel",
                'b',
                "toolHeadDrillThaumium",
                'c',
                "screwStainlessSteel",
                'd',
                "circuitBasic",
                'e',
                getModItem("gregtech", "gt.metaitem.01", 1, 32518, missing),
                'f',
                "circuitBasic",
                'g',
                "craftingToolHardHammer",
                'h',
                "toolHeadChainsawThaumium",
                'i',
                "craftingToolWrench");
        TCHelper.addResearchPage(
                "IronOmnitool",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("EMT", "Omnitool", 1, 27, missing))));
        TCHelper.orphanResearch("Diamond Omnitool");
        TCHelper.removeResearch("Diamond Omnitool");
        new ResearchItem(
                "DiamondOmnitool",
                "EMT",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("instrumentum"), 12)
                        .add(Aspect.getAspect("perfodio"), 9).add(Aspect.getAspect("telum"), 6)
                        .add(Aspect.getAspect("vitreus"), 3),
                -4,
                0,
                3,
                getModItem("EMT", "Diamond Omnitool", 1, 0, missing)).setParents("IronOmnitool")
                        .setParentsHidden("DiamondChainsaw").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.DiamondOmnitool")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "DiamondOmnitool",
                getModItem("EMT", "Diamond Omnitool", 1, 27, missing),
                6,
                new AspectList().add(Aspect.getAspect("instrumentum"), 32).add(Aspect.getAspect("perfodio"), 24)
                        .add(Aspect.getAspect("potentia"), 24).add(Aspect.getAspect("metallum"), 16)
                        .add(Aspect.getAspect("telum"), 16).add(Aspect.getAspect("terra"), 8),
                createItemStack(
                        "gregtech",
                        "gt.metatool.01",
                        1,
                        102,
                        "{ench:[0:{lvl:2s,id:35s}],GT.ToolStats:{PrimaryMaterial:\"Thaumium\",SpecialData:-1L,MaxDamage:51200L,Tier:2L,MaxCharge:400000L,Voltage:128L,Electric:1b,SecondaryMaterial:\"Titanium\"},GT.ItemCharge:400000L}",
                        missing),
                new ItemStack[] { getModItem("EMT", "DiamondChainsaw", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), });
        TCHelper.addResearchPage(
                "DiamondOmnitool",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "Diamond Omnitool", 1, 27, missing))));
        TCHelper.orphanResearch("Thaumium Omnitool");
        TCHelper.removeResearch("Thaumium Omnitool");
        new ResearchItem(
                "ThaumiumOmnitool",
                "EMT",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("instrumentum"), 12)
                        .add(Aspect.getAspect("perfodio"), 9).add(Aspect.getAspect("telum"), 6)
                        .add(Aspect.getAspect("vitreus"), 3),
                -6,
                0,
                3,
                getModItem("EMT", "ThaumiumOmnitool", 1, 0, missing)).setParents("DiamondOmnitool")
                        .setParentsHidden("ThaumiumChainsaw", "ThaumiumDrill").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.ThaumiumOmnitool")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ThaumiumOmnitool",
                getModItem("EMT", "ThaumiumOmnitool", 1, 27, missing),
                8,
                new AspectList().add(Aspect.getAspect("instrumentum"), 48).add(Aspect.getAspect("perfodio"), 24)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("metallum"), 24)
                        .add(Aspect.getAspect("telum"), 16).add(Aspect.getAspect("terra"), 8)
                        .add(Aspect.getAspect("praecantatio"), 16),
                getModItem("EMT", "ThaumiumChainsaw", 1, 32767, missing),
                new ItemStack[] { getModItem("EMT", "ThaumiumDrill", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17316, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32705, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27028, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27028, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32705, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17316, missing), });
        TCHelper.addResearchPage(
                "ThaumiumOmnitool",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "ThaumiumOmnitool", 1, 27, missing))));
        ThaumcraftApi.addWarpToResearch("ThaumiumOmnitool", 1);
        TCHelper.orphanResearch("Electric Boots of the Traveller");
        TCHelper.removeResearch("Electric Boots of the Traveller");
        new ResearchItem(
                "ElectricBootsoftheTraveller",
                "EMT",
                new AspectList().add(Aspect.getAspect("praecantatio"), 15).add(Aspect.getAspect("motus"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("tutamen"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                2,
                2,
                3,
                getModItem("EMT", "ElectricBootsTraveller", 1, 0, missing)).setParents("BOOTSTRAVELLER")
                        .setParentsHidden("ElectricMagicTools").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.ElectricBootsoftheTraveller"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ElectricBootsoftheTraveller",
                getModItem("EMT", "ElectricBootsTraveller", 1, 27, missing),
                3,
                new AspectList().add(Aspect.getAspect("motus"), 32).add(Aspect.getAspect("potentia"), 16)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("praecantatio"), 8)
                        .add(Aspect.getAspect("volatus"), 8).add(Aspect.getAspect("iter"), 8),
                getModItem("Thaumcraft", "BootsTraveller", 1, 0, missing),
                new ItemStack[] { getModItem("IC2", "itemStaticBoots", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1361, missing),
                        getModItem("IC2", "itemAdvBat", 1, 32767, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1361, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17500, missing), });
        TCHelper.addResearchPage(
                "ElectricBootsoftheTraveller",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("EMT", "ElectricBootsTraveller", 1, 27, missing))));
        TCHelper.orphanResearch("Nano Boots of the Traveller");
        TCHelper.removeResearch("Nano Boots of the Traveller");
        new ResearchItem(
                "NanoBootsoftheTraveller",
                "EMT",
                new AspectList().add(Aspect.getAspect("praecantatio"), 18).add(Aspect.getAspect("motus"), 15)
                        .add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("tutamen"), 9)
                        .add(Aspect.getAspect("terra"), 6).add(Aspect.getAspect("volatus"), 3),
                4,
                2,
                3,
                getModItem("EMT", "NanoBootsTraveller", 1, 0, missing)).setParents("ElectricBootsoftheTraveller")
                        .setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.NanoBootsoftheTraveller")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "NanoBootsoftheTraveller",
                getModItem("EMT", "NanoBootsTraveller", 1, 27, missing),
                6,
                new AspectList().add(Aspect.getAspect("motus"), 48).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("volatus"), 8).add(Aspect.getAspect("iter"), 16),
                getModItem("EMT", "ElectricBootsTraveller", 1, 32767, missing),
                new ItemStack[] { getModItem("IC2", "itemArmorNanoBoots", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1442, missing),
                        getModItem("IC2", "itemBatCrystal", 1, 32767, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1442, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32602, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing), });
        TCHelper.addResearchPage(
                "NanoBootsoftheTraveller",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "NanoBootsTraveller", 1, 27, missing))));
        ThaumcraftApi.addWarpToResearch("NanoBootsoftheTraveller", 1);
        TCHelper.orphanResearch("Quantum Boots of the Traveller");
        TCHelper.removeResearch("Quantum Boots of the Traveller");
        new ResearchItem(
                "QuantumBootsoftheTraveller",
                "EMT",
                new AspectList().add(Aspect.getAspect("praecantatio"), 21).add(Aspect.getAspect("motus"), 18)
                        .add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("tutamen"), 12)
                        .add(Aspect.getAspect("terra"), 9).add(Aspect.getAspect("volatus"), 6)
                        .add(Aspect.getAspect("auram"), 3),
                6,
                2,
                3,
                getModItem("EMT", "QuantumBootsTraveller", 1, 0, missing)).setParents("NanoBootsoftheTraveller")
                        .setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.QuantumBootsoftheTraveller"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "QuantumBootsoftheTraveller",
                getModItem("EMT", "QuantumBootsTraveller", 1, 27, missing),
                9,
                new AspectList().add(Aspect.getAspect("motus"), 64).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("tutamen"), 48).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("volatus"), 16).add(Aspect.getAspect("iter"), 24)
                        .add(Aspect.getAspect("aer"), 8),
                getModItem("EMT", "NanoBootsTraveller", 1, 32767, missing),
                new ItemStack[] { getModItem("IC2", "itemArmorQuantumBoots", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32603, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1563, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("IC2", "itemBatLamaCrystal", 1, 32767, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1563, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32603, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing), });
        TCHelper.addResearchPage(
                "QuantumBootsoftheTraveller",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("EMT", "QuantumBootsTraveller", 1, 27, missing))));
        ThaumcraftApi.addWarpToResearch("QuantumBootsoftheTraveller", 2);
        TCHelper.orphanResearch("Thaumium Drill");
        TCHelper.removeResearch("Thaumium Drill");
        new ResearchItem(
                "ThaumiumDrill",
                "EMT",
                new AspectList().add(Aspect.getAspect("instrumentum"), 18).add(Aspect.getAspect("perfodio"), 15)
                        .add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("ignis"), 3),
                2,
                0,
                3,
                getModItem("EMT", "ThaumiumDrill", 1, 0, missing)).setParents("ElectricMagicTools").setConcealed()
                        .setRound().setPages(new ResearchPage("tc.research_page.ThaumiumDrill")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ThaumiumDrill",
                getModItem("EMT", "ThaumiumDrill", 1, 27, missing),
                7,
                new AspectList().add(Aspect.getAspect("instrumentum"), 32).add(Aspect.getAspect("perfodio"), 16)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("lucrum"), 24)
                        .add(Aspect.getAspect("praecantatio"), 8),
                createItemStack(
                        "gregtech",
                        "gt.metatool.01",
                        1,
                        102,
                        "{ench:[0:{lvl:2s,id:35s}],GT.ToolStats:{PrimaryMaterial:\"Thaumium\",SpecialData:-1L,MaxDamage:51200L,Tier:2L,MaxCharge:400000L,Voltage:128L,Electric:1b,SecondaryMaterial:\"Titanium\"},GT.ItemCharge:400000L}",
                        missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 27028, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32705, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17316, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27028, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32705, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17316, missing), });
        TCHelper.addResearchPage(
                "ThaumiumDrill",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "ThaumiumDrill", 1, 27, missing))));
        ThaumcraftApi.addWarpToResearch("ThaumiumDrill", 1);
        TCHelper.orphanResearch("Drill of the Rockbreaker");
        TCHelper.removeResearch("Drill of the Rockbreaker");
        new ResearchItem(
                "DrilloftheRockbreaker",
                "EMT",
                new AspectList().add(Aspect.getAspect("instrumentum"), 21).add(Aspect.getAspect("perfodio"), 18)
                        .add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("ignis"), 6)
                        .add(Aspect.getAspect("terra"), 3),
                4,
                0,
                3,
                getModItem("EMT", "DrillRockbreaker", 1, 0, missing)).setParents("ThaumiumDrill").setConcealed()
                        .setRound().setPages(new ResearchPage("tc.research_page.DrilloftheRockbreaker"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "DrilloftheRockbreaker",
                getModItem("EMT", "DrillRockbreaker", 1, 27, missing),
                10,
                new AspectList().add(Aspect.getAspect("instrumentum"), 48).add(Aspect.getAspect("perfodio"), 24)
                        .add(Aspect.getAspect("potentia"), 48).add(Aspect.getAspect("lucrum"), 32)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("ignis"), 8),
                getModItem("EMT", "ThaumiumDrill", 1, 32767, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemShovelElemental", 1, 0, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32706, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("Thaumcraft", "ItemPickaxeElemental", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32706, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing), });
        TCHelper.addResearchPage(
                "DrilloftheRockbreaker",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "DrillRockbreaker", 1, 27, missing))));
        ThaumcraftApi.addWarpToResearch("DrilloftheRockbreaker", 2);
        TCHelper.orphanResearch("Thaumium Chainsaw");
        TCHelper.removeResearch("Thaumium Chainsaw");
        new ResearchItem(
                "ThaumiumChainsaw",
                "EMT",
                new AspectList().add(Aspect.getAspect("instrumentum"), 18).add(Aspect.getAspect("telum"), 15)
                        .add(Aspect.getAspect("potentia"), 12).add(Aspect.getAspect("lucrum"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("aer"), 3),
                0,
                -4,
                3,
                getModItem("EMT", "ThaumiumChainsaw", 1, 0, missing)).setParents("DiamondChainsaw").setConcealed()
                        .setRound().setPages(new ResearchPage("tc.research_page.ThaumiumChainsaw"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ThaumiumChainsaw",
                getModItem("EMT", "ThaumiumChainsaw", 1, 27, missing),
                7,
                new AspectList().add(Aspect.getAspect("instrumentum"), 32).add(Aspect.getAspect("telum"), 24)
                        .add(Aspect.getAspect("potentia"), 24).add(Aspect.getAspect("lucrum"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8),
                getModItem("EMT", "DiamondChainsaw", 1, 32767, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 27028, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32705, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17316, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 27028, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32705, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17316, missing), });
        TCHelper.addResearchPage(
                "ThaumiumChainsaw",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "ThaumiumChainsaw", 1, 27, missing))));
        ThaumcraftApi.addWarpToResearch("ThaumiumChainsaw", 1);
        TCHelper.orphanResearch("Chainsaw of the Stream");
        TCHelper.removeResearch("Chainsaw of the Stream");
        new ResearchItem(
                "ChainsawoftheStream",
                "EMT",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("arbor"), 3),
                0,
                -6,
                3,
                getModItem("EMT", "ChainsawStream", 1, 0, missing)).setParents("ThaumiumChainsaw").setConcealed()
                        .setRound().setPages(new ResearchPage("tc.research_page.ChainsawoftheStream"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ChainsawoftheStream",
                getModItem("EMT", "ChainsawStream", 1, 27, missing),
                10,
                new AspectList().add(Aspect.getAspect("instrumentum"), 48).add(Aspect.getAspect("telum"), 32)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("lucrum"), 24)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("aer"), 8),
                getModItem("EMT", "ThaumiumChainsaw", 1, 32767, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemAxeElemental", 1, 0, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32706, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("Railcraft", "tool.steel.shears", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32706, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing), });
        TCHelper.addResearchPage(
                "ChainsawoftheStream",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "ChainsawStream", 1, 27, missing))));
        ThaumcraftApi.addWarpToResearch("ChainsawoftheStream", 2);
        TCHelper.orphanResearch("Inventory Charging Ring");
        TCHelper.removeResearch("Inventory Charging Ring");
        new ResearchItem(
                "InventoryChargingRing",
                "EMT",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("vitreus"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("electrum"), 6)
                        .add(Aspect.getAspect("auram"), 3),
                0,
                -8,
                3,
                getModItem("EMT", "EMTBaubles", 1, 1, missing)).setParentsHidden("ElectricMagicTools").setConcealed()
                        .setRound().setPages(new ResearchPage("tc.research_page.InventoryChargingRing"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "InventoryChargingRing",
                getModItem("EMT", "EMTBaubles", 1, 1, missing),
                7,
                new AspectList().add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("vitreus"), 32)
                        .add(Aspect.getAspect("praecantatio"), 48).add(Aspect.getAspect("electrum"), 16)
                        .add(Aspect.getAspect("auram"), 8),
                getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 1, missing),
                new ItemStack[] { getModItem("IC2", "itemBatLamaCrystal", 1, 32767, missing),
                        getModItem("IC2", "blockGenerator", 1, 5, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1462, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1120, missing),
                        getModItem("IC2", "blockKineticGenerator", 1, 4, missing),
                        getModItem("IC2", "itemStaticBoots", 1, 0, missing),
                        getModItem("IC2", "blockKineticGenerator", 1, 0, missing),
                        getModItem("IC2", "blockHeatGenerator", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1462, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32751, missing), });
        TCHelper.addResearchPage(
                "InventoryChargingRing",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "EMTBaubles", 1, 1, missing))));
        ThaumcraftApi.addWarpToResearch("InventoryChargingRing", 2);
        TCHelper.orphanResearch("Armor Charging Ring");
        TCHelper.removeResearch("Armor Charging Ring");
        new ResearchItem(
                "ArmorChargingRing",
                "EMT",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("tutamen"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("electrum"), 6)
                        .add(Aspect.getAspect("auram"), 3),
                0,
                -10,
                3,
                getModItem("EMT", "EMTBaubles", 1, 0, missing)).setParents("InventoryChargingRing").setConcealed()
                        .setRound().setPages(new ResearchPage("tc.research_page.ArmorChargingRing"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ArmorChargingRing",
                getModItem("EMT", "EMTBaubles", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("tutamen"), 32)
                        .add(Aspect.getAspect("praecantatio"), 48).add(Aspect.getAspect("electrum"), 16)
                        .add(Aspect.getAspect("auram"), 8),
                getModItem("Thaumcraft", "ItemBaubleBlanks", 1, 1, missing),
                new ItemStack[] { getModItem("IC2", "itemBatLamaCrystal", 1, 32767, missing),
                        getModItem("IC2", "blockGenerator", 1, 5, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1482, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1120, missing),
                        getModItem("IC2", "blockKineticGenerator", 1, 4, missing),
                        getModItem("IC2", "itemStaticBoots", 1, 0, missing),
                        getModItem("IC2", "blockKineticGenerator", 1, 0, missing),
                        getModItem("IC2", "blockHeatGenerator", 1, 0, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1482, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32751, missing), });
        TCHelper.addResearchPage(
                "ArmorChargingRing",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "EMTBaubles", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ArmorChargingRing", 2);
        TCHelper.orphanResearch("Electric Goggles");
        TCHelper.removeResearch("Electric Goggles");
        TCHelper.orphanResearch("Nanosuit Goggles of Revealing");
        TCHelper.removeResearch("Nanosuit Goggles of Revealing");
        TCHelper.orphanResearch("Quantum Goggles of Revealing");
        TCHelper.removeResearch("Quantum Goggles of Revealing");
        new ResearchItem(
                "ElectricGogglesofRevealing",
                "EMT",
                new AspectList().add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("sensus"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("electrum"), 3),
                -6,
                -2,
                3,
                getModItem("EMT", "ElectricGogglesRevealing", 1, 0, missing)).setParents("GOGGLES").setConcealed()
                        .setParentsHidden("ElectricMagicTools").setRound()
                        .setPages(new ResearchPage("tc.research_page.ElectricGogglesofRevealing"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ElectricGogglesofRevealing",
                getModItem("EMT", "ElectricGogglesRevealing", 1, 165, missing),
                new AspectList().add(Aspect.getAspect("aer"), 45).add(Aspect.getAspect("ignis"), 45)
                        .add(Aspect.getAspect("terra"), 45).add(Aspect.getAspect("aqua"), 45)
                        .add(Aspect.getAspect("ordo"), 45).add(Aspect.getAspect("perditio"), 45),
                "abc",
                "def",
                "ghi",
                'a',
                "wireGt02AnyCopper",
                'b',
                getModItem("minecraft", "diamond_helmet", 1, 0, missing),
                'c',
                "wireGt02AnyCopper",
                'd',
                "circuitBasic",
                'e',
                getModItem("Thaumcraft", "ItemGoggles", 1, 0, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem("ProjRed|Integration", "projectred.integration.gate", 1, 10, missing),
                'h',
                getModItem("IC2", "itemAdvBat", 1, 32767, missing),
                'i',
                getModItem("ProjRed|Integration", "projectred.integration.gate", 1, 10, missing));
        TCHelper.addResearchPage(
                "ElectricGogglesofRevealing",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("EMT", "ElectricGogglesRevealing", 1, 165, missing))));
        new ResearchItem(
                "NanosuitGogglesofRevealing",
                "EMT",
                new AspectList().add(Aspect.getAspect("tutamen"), 18).add(Aspect.getAspect("potentia"), 15)
                        .add(Aspect.getAspect("sensus"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("auram"), 6).add(Aspect.getAspect("electrum"), 3),
                -4,
                -2,
                3,
                getModItem("EMT", "NanosuitGogglesRevealing", 1, 0, missing)).setParents("ElectricGogglesofRevealing")
                        .setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.NanosuitGogglesofRevealing"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "NanosuitGogglesofRevealing",
                getModItem("EMT", "NanosuitGogglesRevealing", 1, 27, missing),
                6,
                new AspectList().add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("sensus"), 24).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("auram"), 8).add(Aspect.getAspect("electrum"), 8),
                getModItem("EMT", "ElectricGogglesRevealing", 1, 32767, missing),
                new ItemStack[] { getModItem("IC2", "itemArmorNanoHelmet", 1, 32767, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1442, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("IC2", "itemBatCrystal", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32692, missing),
                        getModItem("IC2", "itemPartCircuitAdv", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1442, missing), });
        TCHelper.addResearchPage(
                "NanosuitGogglesofRevealing",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("EMT", "NanosuitGogglesRevealing", 1, 27, missing))));
        ThaumcraftApi.addWarpToResearch("NanosuitGogglesofRevealing", 1);
        new ResearchItem(
                "QuantumGogglesofRevealing",
                "EMT",
                new AspectList().add(Aspect.getAspect("tutamen"), 21).add(Aspect.getAspect("potentia"), 18)
                        .add(Aspect.getAspect("sensus"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("auram"), 9).add(Aspect.getAspect("lucrum"), 6)
                        .add(Aspect.getAspect("electrum"), 3),
                -2,
                -2,
                3,
                getModItem("EMT", "QuantumGogglesRevealing", 1, 0, missing)).setParents("NanosuitGogglesofRevealing")
                        .setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.QuantumGogglesofRevealing"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "QuantumGogglesofRevealing",
                getModItem("EMT", "QuantumGogglesRevealing", 1, 27, missing),
                9,
                new AspectList().add(Aspect.getAspect("tutamen"), 64).add(Aspect.getAspect("potentia"), 48)
                        .add(Aspect.getAspect("sensus"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("auram"), 16).add(Aspect.getAspect("electrum"), 16)
                        .add(Aspect.getAspect("lucrum"), 8),
                getModItem("EMT", "NanosuitGogglesRevealing", 1, 32767, missing),
                new ItemStack[] { getModItem("IC2", "itemArmorQuantumHelmet", 1, 32767, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1563, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32705, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32693, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("IC2", "itemBatLamaCrystal", 1, 32767, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32693, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32705, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1563, missing), });
        TCHelper.addResearchPage(
                "QuantumGogglesofRevealing",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("EMT", "QuantumGogglesRevealing", 1, 27, missing))));
        ThaumcraftApi.addWarpToResearch("QuantumGogglesofRevealing", 2);
        TCHelper.orphanResearch("Solar Helmet of Revealing");
        TCHelper.removeResearch("Solar Helmet of Revealing");
        new ResearchItem(
                "SolarHelmetofRevealing",
                "EMT",
                new AspectList().add(Aspect.getAspect("tutamen"), 30).add(Aspect.getAspect("potentia"), 27)
                        .add(Aspect.getAspect("sensus"), 24).add(Aspect.getAspect("praecantatio"), 21)
                        .add(Aspect.getAspect("auram"), 15).add(Aspect.getAspect("electrum"), 12)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("lux"), 3),
                -2,
                -4,
                3,
                getModItem("EMT", "SolarHelmetRevealing", 1, 0, missing))
                        .setParents("QuantumGogglesofRevealing", "CompressedSolars").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.SolarHelmetofRevealing")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SolarHelmetofRevealing",
                getModItem("EMT", "SolarHelmetRevealing", 1, 27, missing),
                12,
                new AspectList().add(Aspect.getAspect("tutamen"), 64).add(Aspect.getAspect("potentia"), 48)
                        .add(Aspect.getAspect("sensus"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("auram"), 16).add(Aspect.getAspect("electrum"), 16)
                        .add(Aspect.getAspect("lucrum"), 8).add(Aspect.getAspect("aer"), 16)
                        .add(Aspect.getAspect("lux"), 32),
                getModItem("EMT", "QuantumGogglesRevealing", 1, 32767, missing),
                new ItemStack[] { getModItem("EMT", "EMTSolars", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1624, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17324, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32694, missing),
                        getModItem("dreamcraft", "item.MysteriousCrystal", 1, 0, missing),
                        getModItem("IC2", "itemBatLamaCrystal", 1, 32767, missing),
                        getModItem("dreamcraft", "item.MysteriousCrystal", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32694, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17324, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1624, missing), });
        TCHelper.addResearchPage(
                "SolarHelmetofRevealing",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("EMT", "SolarHelmetRevealing", 1, 27, missing))));
        ThaumcraftApi.addWarpToResearch("SolarHelmetofRevealing", 3);
        TCHelper.orphanResearch("Compressed Solars");
        TCHelper.removeResearch("Compressed Solars");
        new ResearchItem(
                "CompressedSolars",
                "EMT",
                new AspectList().add(Aspect.getAspect("potentia"), 18).add(Aspect.getAspect("lux"), 15)
                        .add(Aspect.getAspect("metallum"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("ignis"), 6).add(Aspect.getAspect("aer"), 3),
                -6,
                -4,
                3,
                getModItem("EMT", "EMTSolars", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setPages(new ResearchPage("tc.research_page.CompressedSolars")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CompressedSolars",
                getModItem("EMT", "EMTSolars", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("terra"), 50).add(Aspect.getAspect("ignis"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("IC2", "blockGenerator", 1, 3, missing),
                'b',
                getModItem("IC2", "blockGenerator", 1, 3, missing),
                'c',
                getModItem("IC2", "blockGenerator", 1, 3, missing),
                'd',
                getModItem("IC2", "blockGenerator", 1, 3, missing),
                'e',
                getModItem("dreamcraft", "item.ReinforcedAluminiumIronPlate", 1, 0, missing),
                'f',
                getModItem("IC2", "blockGenerator", 1, 3, missing),
                'g',
                getModItem("IC2", "blockGenerator", 1, 3, missing),
                'h',
                getModItem("IC2", "blockGenerator", 1, 3, missing),
                'i',
                getModItem("IC2", "blockGenerator", 1, 3, missing));
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("EMT", "EMTSolars", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CompressedSolars",
                getModItem("EMT", "EMTSolars", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                        .add(Aspect.getAspect("terra"), 100).add(Aspect.getAspect("ignis"), 100)
                        .add(Aspect.getAspect("ordo"), 100).add(Aspect.getAspect("perditio"), 100),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("EMT", "EMTSolars", 1, 0, missing),
                'b',
                getModItem("EMT", "EMTSolars", 1, 0, missing),
                'c',
                getModItem("EMT", "EMTSolars", 1, 0, missing),
                'd',
                getModItem("EMT", "EMTSolars", 1, 0, missing),
                'e',
                getModItem("dreamcraft", "item.IrradiantReinforcedTitaniumPlate", 1, 0, missing),
                'f',
                getModItem("EMT", "EMTSolars", 1, 0, missing),
                'g',
                getModItem("EMT", "EMTSolars", 1, 0, missing),
                'h',
                getModItem("EMT", "EMTSolars", 1, 0, missing),
                'i',
                getModItem("EMT", "EMTSolars", 1, 0, missing));
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("EMT", "EMTSolars", 1, 1, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem("EMT", "EMTSolars", 1, 2, missing),
                15,
                new AspectList().add(Aspect.getAspect("aer"), 150).add(Aspect.getAspect("aqua"), 150)
                        .add(Aspect.getAspect("terra"), 150).add(Aspect.getAspect("ignis"), 150)
                        .add(Aspect.getAspect("ordo"), 150).add(Aspect.getAspect("perditio"), 150),
                getModItem("dreamcraft", "item.IrradiantReinforcedTungstenSteelPlate", 1, 0, missing),
                new ItemStack[] { getModItem("dreamcraft", "item.IrradiantReinforcedTungstenSteelPlate", 1, 0, missing),
                        getModItem("EMT", "EMTSolars", 1, 1, missing), getModItem("EMT", "EMTSolars", 1, 1, missing),
                        getModItem("EMT", "EMTSolars", 1, 1, missing), getModItem("EMT", "EMTSolars", 1, 1, missing),
                        getModItem("dreamcraft", "item.IrradiantReinforcedTungstenSteelPlate", 1, 0, missing),
                        getModItem("EMT", "EMTSolars", 1, 1, missing), getModItem("EMT", "EMTSolars", 1, 1, missing),
                        getModItem("EMT", "EMTSolars", 1, 1, missing),
                        getModItem("EMT", "EMTSolars", 1, 1, missing), });
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "EMTSolars", 1, 2, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem("EMT", "EMTSolars3", 1, 0, missing),
                20,
                new AspectList().add(Aspect.getAspect("aer"), 300).add(Aspect.getAspect("aqua"), 300)
                        .add(Aspect.getAspect("terra"), 300).add(Aspect.getAspect("ignis"), 300)
                        .add(Aspect.getAspect("ordo"), 300).add(Aspect.getAspect("perditio"), 300),
                getModItem("dreamcraft", "item.IrradiantReinforcedChromePlate", 1, 0, missing),
                new ItemStack[] { getModItem("dreamcraft", "item.IrradiantReinforcedChromePlate", 1, 0, missing),
                        getModItem("EMT", "EMTSolars", 1, 2, missing), getModItem("EMT", "EMTSolars", 1, 2, missing),
                        getModItem("EMT", "EMTSolars", 1, 2, missing), getModItem("EMT", "EMTSolars", 1, 2, missing),
                        getModItem("dreamcraft", "item.IrradiantReinforcedChromePlate", 1, 0, missing),
                        getModItem("EMT", "EMTSolars", 1, 2, missing), getModItem("EMT", "EMTSolars", 1, 2, missing),
                        getModItem("EMT", "EMTSolars", 1, 2, missing),
                        getModItem("EMT", "EMTSolars", 1, 2, missing), });
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "EMTSolars3", 1, 0, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem("EMT", "EMTSolars3", 1, 7, missing),
                20,
                new AspectList().add(Aspect.getAspect("aer"), 600).add(Aspect.getAspect("aqua"), 600)
                        .add(Aspect.getAspect("terra"), 600).add(Aspect.getAspect("ignis"), 600)
                        .add(Aspect.getAspect("ordo"), 600).add(Aspect.getAspect("perditio"), 600),
                getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 8, missing),
                new ItemStack[] { getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 8, missing),
                        getModItem("EMT", "EMTSolars3", 1, 0, missing), getModItem("EMT", "EMTSolars3", 1, 0, missing),
                        getModItem("EMT", "EMTSolars3", 1, 0, missing), getModItem("EMT", "EMTSolars3", 1, 0, missing),
                        getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 8, missing),
                        getModItem("EMT", "EMTSolars3", 1, 0, missing), getModItem("EMT", "EMTSolars3", 1, 0, missing),
                        getModItem("EMT", "EMTSolars3", 1, 0, missing),
                        getModItem("EMT", "EMTSolars3", 1, 0, missing), });
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "EMTSolars3", 1, 7, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem("EMT", "EMTSolars3", 1, 14, missing),
                20,
                new AspectList().add(Aspect.getAspect("aer"), 1200).add(Aspect.getAspect("aqua"), 1200)
                        .add(Aspect.getAspect("terra"), 1200).add(Aspect.getAspect("ignis"), 1200)
                        .add(Aspect.getAspect("ordo"), 1200).add(Aspect.getAspect("perditio"), 1200),
                getModItem("dreamcraft", "item.IrradiantReinforcedNaquadriaPlate", 1, 0, missing),
                new ItemStack[] { getModItem("dreamcraft", "item.IrradiantReinforcedNaquadriaPlate", 1, 0, missing),
                        getModItem("EMT", "EMTSolars3", 1, 7, missing), getModItem("EMT", "EMTSolars3", 1, 7, missing),
                        getModItem("EMT", "EMTSolars3", 1, 7, missing), getModItem("EMT", "EMTSolars3", 1, 7, missing),
                        getModItem("dreamcraft", "item.IrradiantReinforcedNaquadriaPlate", 1, 0, missing),
                        getModItem("EMT", "EMTSolars3", 1, 7, missing), getModItem("EMT", "EMTSolars3", 1, 7, missing),
                        getModItem("EMT", "EMTSolars3", 1, 7, missing),
                        getModItem("EMT", "EMTSolars3", 1, 7, missing), });
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "EMTSolars3", 1, 14, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem("EMT", "EMTSolars4", 1, 5, missing),
                20,
                new AspectList().add(Aspect.getAspect("aer"), 2400).add(Aspect.getAspect("aqua"), 2400)
                        .add(Aspect.getAspect("terra"), 2400).add(Aspect.getAspect("ignis"), 2400)
                        .add(Aspect.getAspect("ordo"), 2400).add(Aspect.getAspect("perditio"), 2400),
                getModItem("dreamcraft", "item.IrradiantReinforcedNeutroniumPlate", 1, 0, missing),
                new ItemStack[] { getModItem("dreamcraft", "item.IrradiantReinforcedNeutroniumPlate", 1, 0, missing),
                        getModItem("EMT", "EMTSolars3", 1, 14, missing),
                        getModItem("EMT", "EMTSolars3", 1, 14, missing),
                        getModItem("EMT", "EMTSolars3", 1, 14, missing),
                        getModItem("EMT", "EMTSolars3", 1, 14, missing),
                        getModItem("dreamcraft", "item.IrradiantReinforcedNeutroniumPlate", 1, 0, missing),
                        getModItem("EMT", "EMTSolars3", 1, 14, missing),
                        getModItem("EMT", "EMTSolars3", 1, 14, missing),
                        getModItem("EMT", "EMTSolars3", 1, 14, missing),
                        getModItem("EMT", "EMTSolars3", 1, 14, missing), });
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "EMTSolars4", 1, 5, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem("EMT", "EMTSolars4", 1, 12, missing),
                20,
                new AspectList().add(Aspect.getAspect("aer"), 4800).add(Aspect.getAspect("aqua"), 4800)
                        .add(Aspect.getAspect("terra"), 4800).add(Aspect.getAspect("ignis"), 4800)
                        .add(Aspect.getAspect("ordo"), 4800).add(Aspect.getAspect("perditio"), 4800),
                getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 13, missing),
                new ItemStack[] { getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 13, missing),
                        getModItem("EMT", "EMTSolars4", 1, 5, missing), getModItem("EMT", "EMTSolars4", 1, 5, missing),
                        getModItem("EMT", "EMTSolars4", 1, 5, missing), getModItem("EMT", "EMTSolars4", 1, 5, missing),
                        getModItem("AdvancedSolarPanel", "asp_crafting_items", 1, 13, missing),
                        getModItem("EMT", "EMTSolars4", 1, 5, missing), getModItem("EMT", "EMTSolars4", 1, 5, missing),
                        getModItem("EMT", "EMTSolars4", 1, 5, missing),
                        getModItem("EMT", "EMTSolars4", 1, 5, missing), });
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "EMTSolars4", 1, 12, missing))));
        TCHelper.orphanResearch("Water Infused Solar Panels");
        TCHelper.removeResearch("Water Infused Solar Panels");
        new ResearchItem(
                "WaterInfusedSolarPanels",
                "EMT",
                new AspectList().add(Aspect.getAspect("aqua"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("lux"), 6)
                        .add(Aspect.getAspect("lucrum"), 3),
                -7,
                -7,
                3,
                getModItem("EMT", "EMTSolars", 1, 3, missing)).setParents("CompressedSolars").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.WaterInfusedSolarPanels")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem("EMT", "EMTSolars", 1, 3, missing),
                getModItem("EMT", "EMTSolars", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("lux"), 16));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 3, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem("EMT", "EMTSolars", 1, 4, missing),
                getModItem("EMT", "EMTSolars", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("permutatio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("lux"), 32));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 4, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem("EMT", "EMTSolars", 1, 5, missing),
                getModItem("EMT", "EMTSolars", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 128).add(Aspect.getAspect("permutatio"), 128)
                        .add(Aspect.getAspect("praecantatio"), 128).add(Aspect.getAspect("lux"), 64));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 5, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem("EMT", "EMTSolars3", 1, 5, missing),
                getModItem("EMT", "EMTSolars3", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 256).add(Aspect.getAspect("permutatio"), 256)
                        .add(Aspect.getAspect("praecantatio"), 256).add(Aspect.getAspect("lux"), 128));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars3", 1, 5, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem("EMT", "EMTSolars3", 1, 12, missing),
                getModItem("EMT", "EMTSolars3", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 512).add(Aspect.getAspect("permutatio"), 512)
                        .add(Aspect.getAspect("praecantatio"), 512).add(Aspect.getAspect("lux"), 256));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars3", 1, 12, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem("EMT", "EMTSolars4", 1, 3, missing),
                getModItem("EMT", "EMTSolars3", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 1024).add(Aspect.getAspect("permutatio"), 1024)
                        .add(Aspect.getAspect("praecantatio"), 1024).add(Aspect.getAspect("lux"), 512));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars4", 1, 3, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem("EMT", "EMTSolars4", 1, 10, missing),
                getModItem("EMT", "EMTSolars4", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 2048).add(Aspect.getAspect("permutatio"), 2048)
                        .add(Aspect.getAspect("praecantatio"), 2048).add(Aspect.getAspect("lux"), 1024));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars4", 1, 10, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem("EMT", "EMTSolars5", 1, 1, missing),
                getModItem("EMT", "EMTSolars4", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 4096).add(Aspect.getAspect("permutatio"), 4096)
                        .add(Aspect.getAspect("praecantatio"), 4096).add(Aspect.getAspect("lux"), 2048));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars5", 1, 1, missing))));
        TCHelper.orphanResearch("Entropy Infused Solar Panels");
        TCHelper.removeResearch("Entropy Infused Solar Panels");
        new ResearchItem(
                "EntropyInfusedSolarPanels",
                "EMT",
                new AspectList().add(Aspect.getAspect("perditio"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("lux"), 6)
                        .add(Aspect.getAspect("lucrum"), 3),
                -8,
                -6,
                3,
                getModItem("EMT", "EMTSolars", 1, 6, missing)).setParents("CompressedSolars").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.EntropyInfusedSolarPanels"))
                        .registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem("EMT", "EMTSolars", 1, 6, missing),
                getModItem("EMT", "EMTSolars", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 32).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("lux"), 16));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 6, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem("EMT", "EMTSolars", 1, 7, missing),
                getModItem("EMT", "EMTSolars", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 64).add(Aspect.getAspect("permutatio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("lux"), 32));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 7, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem("EMT", "EMTSolars", 1, 8, missing),
                getModItem("EMT", "EMTSolars", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 128).add(Aspect.getAspect("permutatio"), 128)
                        .add(Aspect.getAspect("praecantatio"), 128).add(Aspect.getAspect("lux"), 64));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 8, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem("EMT", "EMTSolars3", 1, 2, missing),
                getModItem("EMT", "EMTSolars3", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 256).add(Aspect.getAspect("permutatio"), 256)
                        .add(Aspect.getAspect("praecantatio"), 256).add(Aspect.getAspect("lux"), 128));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars3", 1, 2, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem("EMT", "EMTSolars3", 1, 9, missing),
                getModItem("EMT", "EMTSolars3", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 512).add(Aspect.getAspect("permutatio"), 512)
                        .add(Aspect.getAspect("praecantatio"), 512).add(Aspect.getAspect("lux"), 256));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars3", 1, 9, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem("EMT", "EMTSolars4", 1, 0, missing),
                getModItem("EMT", "EMTSolars3", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 1024).add(Aspect.getAspect("permutatio"), 1024)
                        .add(Aspect.getAspect("praecantatio"), 1024).add(Aspect.getAspect("lux"), 512));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars4", 1, 0, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem("EMT", "EMTSolars4", 1, 7, missing),
                getModItem("EMT", "EMTSolars4", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 2048).add(Aspect.getAspect("permutatio"), 2048)
                        .add(Aspect.getAspect("praecantatio"), 2048).add(Aspect.getAspect("lux"), 1024));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars4", 1, 7, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem("EMT", "EMTSolars4", 1, 14, missing),
                getModItem("EMT", "EMTSolars4", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 4096).add(Aspect.getAspect("permutatio"), 4096)
                        .add(Aspect.getAspect("praecantatio"), 4096).add(Aspect.getAspect("lux"), 2048));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars4", 1, 14, missing))));
        TCHelper.orphanResearch("Order Infused Solar Panels");
        TCHelper.removeResearch("Order Infused Solar Panels");
        new ResearchItem(
                "OrderInfusedSolarPanels",
                "EMT",
                new AspectList().add(Aspect.getAspect("ordo"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("lux"), 6)
                        .add(Aspect.getAspect("lucrum"), 3),
                -6,
                -8,
                3,
                getModItem("EMT", "EMTSolars", 1, 9, missing)).setParents("CompressedSolars").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.OrderInfusedSolarPanels")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem("EMT", "EMTSolars", 1, 9, missing),
                getModItem("EMT", "EMTSolars", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("lux"), 16));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 9, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem("EMT", "EMTSolars", 1, 10, missing),
                getModItem("EMT", "EMTSolars", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 64).add(Aspect.getAspect("permutatio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("lux"), 32));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 10, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem("EMT", "EMTSolars", 1, 11, missing),
                getModItem("EMT", "EMTSolars", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 128).add(Aspect.getAspect("permutatio"), 128)
                        .add(Aspect.getAspect("praecantatio"), 128).add(Aspect.getAspect("lux"), 64));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 11, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem("EMT", "EMTSolars3", 1, 1, missing),
                getModItem("EMT", "EMTSolars3", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 256).add(Aspect.getAspect("permutatio"), 256)
                        .add(Aspect.getAspect("praecantatio"), 256).add(Aspect.getAspect("lux"), 128));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars3", 1, 1, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem("EMT", "EMTSolars3", 1, 8, missing),
                getModItem("EMT", "EMTSolars3", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 512).add(Aspect.getAspect("permutatio"), 512)
                        .add(Aspect.getAspect("praecantatio"), 512).add(Aspect.getAspect("lux"), 256));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars3", 1, 8, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem("EMT", "EMTSolars3", 1, 15, missing),
                getModItem("EMT", "EMTSolars3", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 1024).add(Aspect.getAspect("permutatio"), 1024)
                        .add(Aspect.getAspect("praecantatio"), 1024).add(Aspect.getAspect("lux"), 512));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars3", 1, 15, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem("EMT", "EMTSolars4", 1, 6, missing),
                getModItem("EMT", "EMTSolars4", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 2048).add(Aspect.getAspect("permutatio"), 2048)
                        .add(Aspect.getAspect("praecantatio"), 2048).add(Aspect.getAspect("lux"), 1024));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars4", 1, 6, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem("EMT", "EMTSolars4", 1, 13, missing),
                getModItem("EMT", "EMTSolars4", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 4096).add(Aspect.getAspect("permutatio"), 4096)
                        .add(Aspect.getAspect("praecantatio"), 4096).add(Aspect.getAspect("lux"), 2048));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars4", 1, 13, missing))));
        TCHelper.orphanResearch("Fire Infused Solar Panels");
        TCHelper.removeResearch("Fire Infused Solar Panels");
        new ResearchItem(
                "FireInfusedSolarPanels",
                "EMT",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("lux"), 6)
                        .add(Aspect.getAspect("lucrum"), 3),
                -5,
                -7,
                3,
                getModItem("EMT", "EMTSolars", 1, 12, missing)).setParents("CompressedSolars").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.FireInfusedSolarPanels")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem("EMT", "EMTSolars", 1, 12, missing),
                getModItem("EMT", "EMTSolars", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 32).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("lux"), 16));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 12, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem("EMT", "EMTSolars", 1, 13, missing),
                getModItem("EMT", "EMTSolars", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("permutatio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("lux"), 32));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 13, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem("EMT", "EMTSolars", 1, 14, missing),
                getModItem("EMT", "EMTSolars", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 128).add(Aspect.getAspect("permutatio"), 128)
                        .add(Aspect.getAspect("praecantatio"), 128).add(Aspect.getAspect("lux"), 64));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 14, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem("EMT", "EMTSolars3", 1, 6, missing),
                getModItem("EMT", "EMTSolars3", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 256).add(Aspect.getAspect("permutatio"), 256)
                        .add(Aspect.getAspect("praecantatio"), 256).add(Aspect.getAspect("lux"), 128));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars3", 1, 6, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem("EMT", "EMTSolars3", 1, 13, missing),
                getModItem("EMT", "EMTSolars3", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 512).add(Aspect.getAspect("permutatio"), 512)
                        .add(Aspect.getAspect("praecantatio"), 512).add(Aspect.getAspect("lux"), 256));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars3", 1, 13, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem("EMT", "EMTSolars4", 1, 4, missing),
                getModItem("EMT", "EMTSolars3", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 1024).add(Aspect.getAspect("permutatio"), 1024)
                        .add(Aspect.getAspect("praecantatio"), 1024).add(Aspect.getAspect("lux"), 512));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars4", 1, 4, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem("EMT", "EMTSolars4", 1, 11, missing),
                getModItem("EMT", "EMTSolars4", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 2048).add(Aspect.getAspect("permutatio"), 2048)
                        .add(Aspect.getAspect("praecantatio"), 2048).add(Aspect.getAspect("lux"), 1024));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars4", 1, 11, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem("EMT", "EMTSolars5", 1, 2, missing),
                getModItem("EMT", "EMTSolars4", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 4096).add(Aspect.getAspect("permutatio"), 4096)
                        .add(Aspect.getAspect("praecantatio"), 4096).add(Aspect.getAspect("lux"), 2048));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars5", 1, 2, missing))));
        TCHelper.orphanResearch("Air Infused Solar Panels");
        TCHelper.removeResearch("Air Infused Solar Panels");
        new ResearchItem(
                "AirInfusedSolarPanels",
                "EMT",
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("lux"), 6)
                        .add(Aspect.getAspect("lucrum"), 3),
                -4,
                -6,
                3,
                getModItem("EMT", "EMTSolars", 1, 15, missing)).setParents("CompressedSolars").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.AirInfusedSolarPanels")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem("EMT", "EMTSolars", 1, 15, missing),
                getModItem("EMT", "EMTSolars", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("lux"), 16));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars", 1, 15, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem("EMT", "EMTSolars2", 1, 0, missing),
                getModItem("EMT", "EMTSolars", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("permutatio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("lux"), 32));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars2", 1, 0, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem("EMT", "EMTSolars2", 1, 1, missing),
                getModItem("EMT", "EMTSolars", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("aer"), 128).add(Aspect.getAspect("permutatio"), 128)
                        .add(Aspect.getAspect("praecantatio"), 128).add(Aspect.getAspect("lux"), 64));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars2", 1, 1, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem("EMT", "EMTSolars3", 1, 3, missing),
                getModItem("EMT", "EMTSolars3", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 256).add(Aspect.getAspect("permutatio"), 256)
                        .add(Aspect.getAspect("praecantatio"), 256).add(Aspect.getAspect("lux"), 128));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars3", 1, 3, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem("EMT", "EMTSolars3", 1, 10, missing),
                getModItem("EMT", "EMTSolars3", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("aer"), 512).add(Aspect.getAspect("permutatio"), 512)
                        .add(Aspect.getAspect("praecantatio"), 512).add(Aspect.getAspect("lux"), 256));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars3", 1, 10, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem("EMT", "EMTSolars4", 1, 1, missing),
                getModItem("EMT", "EMTSolars3", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("aer"), 1024).add(Aspect.getAspect("permutatio"), 1024)
                        .add(Aspect.getAspect("praecantatio"), 1024).add(Aspect.getAspect("lux"), 512));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars4", 1, 1, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem("EMT", "EMTSolars4", 1, 8, missing),
                getModItem("EMT", "EMTSolars4", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("aer"), 2048).add(Aspect.getAspect("permutatio"), 2048)
                        .add(Aspect.getAspect("praecantatio"), 2048).add(Aspect.getAspect("lux"), 1024));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars4", 1, 8, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem("EMT", "EMTSolars4", 1, 15, missing),
                getModItem("EMT", "EMTSolars4", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("aer"), 4096).add(Aspect.getAspect("permutatio"), 4096)
                        .add(Aspect.getAspect("praecantatio"), 4096).add(Aspect.getAspect("lux"), 2048));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars4", 1, 15, missing))));
        TCHelper.orphanResearch("Earth Infused Solar Panels");
        TCHelper.removeResearch("Earth Infused Solar Panels");
        new ResearchItem(
                "EarthInfusedSolarPanels",
                "EMT",
                new AspectList().add(Aspect.getAspect("terra"), 15).add(Aspect.getAspect("praecantatio"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("lux"), 6)
                        .add(Aspect.getAspect("lucrum"), 3),
                -6,
                -7,
                3,
                getModItem("EMT", "EMTSolars2", 1, 2, missing)).setParents("CompressedSolars").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.EarthInfusedSolarPanels")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem("EMT", "EMTSolars2", 1, 2, missing),
                getModItem("EMT", "EMTSolars", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("lux"), 16));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars2", 1, 2, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem("EMT", "EMTSolars2", 1, 3, missing),
                getModItem("EMT", "EMTSolars", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("terra"), 64).add(Aspect.getAspect("permutatio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("lux"), 32));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars2", 1, 3, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem("EMT", "EMTSolars2", 1, 4, missing),
                getModItem("EMT", "EMTSolars", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("terra"), 128).add(Aspect.getAspect("permutatio"), 128)
                        .add(Aspect.getAspect("praecantatio"), 128).add(Aspect.getAspect("lux"), 64));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars2", 1, 4, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem("EMT", "EMTSolars3", 1, 4, missing),
                getModItem("EMT", "EMTSolars3", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 256).add(Aspect.getAspect("permutatio"), 256)
                        .add(Aspect.getAspect("praecantatio"), 256).add(Aspect.getAspect("lux"), 128));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars3", 1, 4, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem("EMT", "EMTSolars3", 1, 11, missing),
                getModItem("EMT", "EMTSolars3", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("terra"), 512).add(Aspect.getAspect("permutatio"), 512)
                        .add(Aspect.getAspect("praecantatio"), 512).add(Aspect.getAspect("lux"), 256));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars3", 1, 11, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem("EMT", "EMTSolars4", 1, 2, missing),
                getModItem("EMT", "EMTSolars3", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("terra"), 1024).add(Aspect.getAspect("permutatio"), 1024)
                        .add(Aspect.getAspect("praecantatio"), 1024).add(Aspect.getAspect("lux"), 512));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars4", 1, 2, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem("EMT", "EMTSolars4", 1, 9, missing),
                getModItem("EMT", "EMTSolars4", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2048).add(Aspect.getAspect("permutatio"), 2048)
                        .add(Aspect.getAspect("praecantatio"), 2048).add(Aspect.getAspect("lux"), 1024));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars4", 1, 9, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem("EMT", "EMTSolars5", 1, 0, missing),
                getModItem("EMT", "EMTSolars4", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("terra"), 4096).add(Aspect.getAspect("permutatio"), 4096)
                        .add(Aspect.getAspect("praecantatio"), 4096).add(Aspect.getAspect("lux"), 2048));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTSolars5", 1, 0, missing))));
        TCHelper.orphanResearch("Electric Hoe of Growth");
        TCHelper.removeResearch("Electric Hoe of Growth");
        new ResearchItem(
                "ElectricHoeofGrowth",
                "EMT",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("messis"), 12)
                        .add(Aspect.getAspect("praecantatio"), 9).add(Aspect.getAspect("herba"), 6)
                        .add(Aspect.getAspect("electrum"), 3),
                2,
                -2,
                3,
                getModItem("EMT", "ElectricHoeGrowth", 1, 0, missing)).setParents("ELEMENTALHOE", "ElectricMagicTools")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.ElectricHoeofGrowth"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ElectricHoeofGrowth",
                getModItem("EMT", "ElectricHoeGrowth", 1, 1561, missing),
                8,
                new AspectList().add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("messis"), 32)
                        .add(Aspect.getAspect("praecantatio"), 48).add(Aspect.getAspect("herba"), 16)
                        .add(Aspect.getAspect("electrum"), 8),
                getModItem("Thaumcraft", "ItemHoeElemental", 1, 0, missing),
                new ItemStack[] { getModItem("IC2", "itemToolHoe", 1, 32767, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32706, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("IC2", "itemBatLamaCrystal", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("IC2", "upgradeModule", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32706, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing), });
        TCHelper.addResearchPage(
                "ElectricHoeofGrowth",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("EMT", "ElectricHoeGrowth", 1, 1561, missing))));
        TCHelper.orphanResearch("Electric Scribing Tools");
        TCHelper.removeResearch("Electric Scribing Tools");
        new ResearchItem(
                "ElectricScribingTools",
                "EMT",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("tenebrae"), 12)
                        .add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("electrum"), 3),
                6,
                -4,
                3,
                getModItem("EMT", "ElectricScribingTools", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("RESEARCH").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.ElectricScribingTools")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ElectricScribingTools",
                getModItem("EMT", "ElectricScribingTools", 1, 400, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("aqua"), 20).add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitAdvanced",
                'b',
                getModItem("Thaumcraft", "ItemInkwell", 1, 0, missing),
                'c',
                "circuitAdvanced",
                'd',
                getModItem("Thaumcraft", "ItemInkwell", 1, 0, missing),
                'e',
                getModItem("IC2", "itemBatCrystal", 1, 32767, missing),
                'f',
                getModItem("Thaumcraft", "ItemInkwell", 1, 0, missing),
                'g',
                "circuitAdvanced",
                'h',
                getModItem("Thaumcraft", "ItemInkwell", 1, 0, missing),
                'i',
                "circuitAdvanced");
        TCHelper.addResearchPage(
                "ElectricScribingTools",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("EMT", "ElectricScribingTools", 1, 400, missing))));
        TCHelper.orphanResearch("Mjolnir");
        TCHelper.removeResearch("Mjolnir");
        new ResearchItem(
                "Mjolnirnew",
                "EMT",
                new AspectList().add(Aspect.getAspect("telum"), 18).add(Aspect.getAspect("tempestas"), 15)
                        .add(Aspect.getAspect("alienis"), 12).add(Aspect.getAspect("ira"), 9)
                        .add(Aspect.getAspect("aer"), 6).add(Aspect.getAspect("ignis"), 3),
                4,
                -5,
                3,
                getModItem("EMT", "Mjolnir", 1, 0, missing)).setParents("The Legend")
                        .setParentsHidden("ElectricMagicTools").registerResearchItem();
        TCHelper.addResearchPrereq("Mjolnirnew", "ELEMENTALSWORD", false);
        TCHelper.addResearchPrereq("Mjolnirnew", "FOCUSSHOCK", false);
        TCHelper.addResearchPrereq("Mjolnirnew", "NITOR", false);
        ResearchCategories.getResearch("Mjolnirnew").setConcealed();
        ResearchCategories.getResearch("Mjolnirnew").setRound();
        TCHelper.addResearchPage("Mjolnirnew", new ResearchPage("tc.research_page.Mjolnirnew"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "Mjolnirnew",
                getModItem("EMT", "Mjolnir", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("telum"), 48).add(Aspect.getAspect("tempestas"), 48)
                        .add(Aspect.getAspect("alienis"), 32).add(Aspect.getAspect("ira"), 24)
                        .add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("ignis"), 16),
                getModItem("EMT", "TaintedMjolnir", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemSwordElemental", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17880, missing),
                        getModItem("EMT", "EMTItems", 1, 6, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17880, missing),
                        getModItem("IC2", "itemBatCrystal", 1, 32767, missing),
                        getModItem("Thaumcraft", "FocusShock", 1, 0, missing),
                        getModItem("IC2", "itemBatCrystal", 1, 32767, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17880, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                        getModItem("EMT", "EMTItems", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17880, missing), });
        TCHelper.addResearchPage(
                "Mjolnirnew",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "Mjolnir", 1, 0, missing))));
        TCHelper.orphanResearch("Supercharged Mjolnir");
        TCHelper.removeResearch("Supercharged Mjolnir");
        new ResearchItem(
                "SuperchargedMjolnir",
                "EMT",
                new AspectList().add(Aspect.getAspect("telum"), 21).add(Aspect.getAspect("tempestas"), 18)
                        .add(Aspect.getAspect("alienis"), 15).add(Aspect.getAspect("bestia"), 12)
                        .add(Aspect.getAspect("ira"), 9).add(Aspect.getAspect("aer"), 6)
                        .add(Aspect.getAspect("ignis"), 3),
                3,
                -5,
                3,
                getModItem("EMT", "SuperchargedMjolnir", 1, 0, missing))
                        .setParents("Mjolnirnew", "FOCUSHELLBAT", "ALUMENTUM").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.SuperchargedMjolnir")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SuperchargedMjolnir",
                getModItem("EMT", "SuperchargedMjolnir", 1, 27, missing),
                15,
                new AspectList().add(Aspect.getAspect("telum"), 64).add(Aspect.getAspect("potentia"), 64)
                        .add(Aspect.getAspect("alienis"), 48).add(Aspect.getAspect("ira"), 32)
                        .add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("ignis"), 24)
                        .add(Aspect.getAspect("bestia"), 16),
                getModItem("EMT", "Mjolnir", 1, 0, missing),
                new ItemStack[] { getModItem("IC2", "itemNanoSaber", 1, 32767, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("IC2", "itemBatLamaCrystal", 1, 32767, missing),
                        getModItem("Thaumcraft", "FocusHellbat", 1, 0, missing),
                        getModItem("IC2", "itemBatLamaCrystal", 1, 32767, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SuperchargedMjolnir",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("EMT", "SuperchargedMjolnir", 1, 27, missing))));
        TCHelper.orphanResearch("Lightning Summoner");
        TCHelper.removeResearch("Lightning Summoner");
        new ResearchItem(
                "LightningSummoner",
                "EMT",
                new AspectList().add(Aspect.getAspect("tempestas"), 15).add(Aspect.getAspect("aer"), 12)
                        .add(Aspect.getAspect("ignis"), 9).add(Aspect.getAspect("nebrisum"), 6)
                        .add(Aspect.getAspect("permutatio"), 3),
                6,
                -5,
                3,
                getModItem("EMT", "EMTItems", 1, 6, missing)).setParents("FOCUSSHOCK", "NITOR", "ALUMENTUM")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.LightningSummoner"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "LightningSummoner",
                getModItem("EMT", "EMTItems", 1, 6, missing),
                9,
                new AspectList().add(Aspect.getAspect("tempestas"), 16).add(Aspect.getAspect("aer"), 24)
                        .add(Aspect.getAspect("ignis"), 16).add(Aspect.getAspect("nebrisum"), 8)
                        .add(Aspect.getAspect("permutatio"), 8),
                getModItem("Thaumcraft", "FocusShock", 1, 0, missing),
                new ItemStack[] { getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                        getModItem("minecraft", "skull", 1, 4, missing), getModItem("minecraft", "tnt", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                        getModItem("minecraft", "skull", 1, 4, missing), getModItem("minecraft", "tnt", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                        getModItem("minecraft", "skull", 1, 4, missing),
                        getModItem("minecraft", "tnt", 1, 0, missing), });
        TCHelper.addResearchPage(
                "LightningSummoner",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "EMTItems", 1, 6, missing))));
        TCHelper.orphanResearch("Tiny Uranium");
        TCHelper.removeResearch("Tiny Uranium");
        new ResearchItem(
                "TinyUranium",
                "EMT",
                new AspectList().add(Aspect.getAspect("permutatio"), 15).add(Aspect.getAspect("venenum"), 12)
                        .add(Aspect.getAspect("mortuus"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("metallum"), 3),
                5,
                -4,
                3,
                getModItem("IC2", "itemUran235small", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("RESEARCH").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.TinyUranium")).registerResearchItem();
        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "TinyUranium",
                getModItem("IC2", "itemUran235small", 7, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 7).add(Aspect.getAspect("ignis"), 7)
                        .add(Aspect.getAspect("aqua"), 7).add(Aspect.getAspect("terra"), 7)
                        .add(Aspect.getAspect("ordo"), 7).add(Aspect.getAspect("perditio"), 7),
                getModItem("IC2", "itemUran238", 1, 0, missing));
        TCHelper.addResearchPage(
                "TinyUranium",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("IC2", "itemUran235small", 1, 0, missing))));
        TCHelper.orphanResearch("UU-Matter Infusion");
        TCHelper.removeResearch("UU-Matter Infusion");
        new ResearchItem(
                "UUMatterInfusion",
                "EMT",
                new AspectList().add(Aspect.getAspect("fabrico"), 15).add(Aspect.getAspect("alienis"), 12)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("vitreus"), 3),
                5,
                -3,
                3,
                getModItem("EMT", "EMTItems", 1, 15, missing)).setParentsHidden("ElectricMagicTools").setRound()
                        .setPages(new ResearchPage("tc.research_page.UUMatterInfusion")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "UUMatterInfusion",
                getModItem("EMT", "EMTItems", 1, 15, missing),
                getModItem("IC2", "itemCellEmpty", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("vitreus"), 16).add(Aspect.getAspect("gelum"), 8)
                        .add(Aspect.getAspect("praecantatio"), 8).add(Aspect.getAspect("permutatio"), 8));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EMTItems", 1, 15, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem("minecraft", "coal", 16, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                getModItem("minecraft", "coal", 1, 1, missing),
                new ItemStack[] { getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("minecraft", "coal", 1, 0, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem("minecraft", "glowstone", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("aer"), 4).add(Aspect.getAspect("aqua"), 4)
                        .add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("ignis"), 4)
                        .add(Aspect.getAspect("perditio"), 4).add(Aspect.getAspect("ordo"), 8),
                getModItem("minecraft", "glowstone_dust", 1, 0, missing),
                new ItemStack[] { getModItem("EMT", "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("minecraft", "glowstone", 1, 0, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem("gregtech", "gt.metaitem.01", 32, 5032, missing),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                getModItem("minecraft", "iron_ingot", 1, 0, missing),
                new ItemStack[] { getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 5032, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem("gregtech", "gt.metaitem.01", 32, 5035, missing),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                getModItem("gregtech", "gt.metaitem.01", 1, 11035, missing),
                new ItemStack[] { getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 5035, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UU-MatterInfusion",
                getModItem("gregtech", "gt.metaitem.01", 32, 5057, missing),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                getModItem("gregtech", "gt.metaitem.01", 1, 11057, missing),
                new ItemStack[] { getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 5057, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem("gregtech", "gt.metaitem.01", 32, 5086, missing),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                getModItem("minecraft", "gold_ingot", 1, 0, missing),
                new ItemStack[] { getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 5086, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem("gregtech", "gt.metaitem.01", 32, 5098, missing),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                getModItem("IC2", "itemUran238", 1, 0, missing),
                new ItemStack[] { getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 5098, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem("gregtech", "gt.metaitem.01", 32, 5054, missing),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                getModItem("gregtech", "gt.metaitem.01", 1, 11054, missing),
                new ItemStack[] { getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 5054, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem("gregtech", "gt.metaitem.01", 32, 5089, missing),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                getModItem("gregtech", "gt.metaitem.01", 1, 11089, missing),
                new ItemStack[] { getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 5089, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem("gregtech", "gt.metaitem.01", 24, 5810, missing),
                9,
                new AspectList().add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("terra"), 24).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("perditio"), 12).add(Aspect.getAspect("ordo"), 24),
                getModItem("minecraft", "redstone", 1, 0, missing),
                new ItemStack[] { getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 5810, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem("gregtech", "gt.metaitem.01", 24, 5526, missing),
                9,
                new AspectList().add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("terra"), 24).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("perditio"), 12).add(Aspect.getAspect("ordo"), 24),
                getModItem("minecraft", "dye", 1, 4, missing),
                new ItemStack[] { getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("gregtech", "gt.metaitem.01", 1, 5526, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem("minecraft", "gold_ingot", 2, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                getModItem("minecraft", "iron_ingot", 1, 0, missing),
                new ItemStack[] { getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("minecraft", "gold_ingot", 1, 0, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem("minecraft", "diamond", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("aqua"), 16)
                        .add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("ignis"), 16)
                        .add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("ordo"), 32),
                getModItem("minecraft", "gold_ingot", 1, 0, missing),
                new ItemStack[] { getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("minecraft", "diamond", 1, 0, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem("IC2", "itemUran238", 2, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("aqua"), 24)
                        .add(Aspect.getAspect("terra"), 48).add(Aspect.getAspect("ignis"), 24)
                        .add(Aspect.getAspect("perditio"), 24).add(Aspect.getAspect("ordo"), 48),
                getModItem("minecraft", "diamond", 1, 0, missing),
                new ItemStack[] { getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("IC2", "itemUran238", 1, 0, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem("IC2", "itemOreIridium", 2, 0, missing),
                18,
                new AspectList().add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("aqua"), 32)
                        .add(Aspect.getAspect("terra"), 64).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("perditio"), 32).add(Aspect.getAspect("ordo"), 64),
                getModItem("IC2", "itemUran238", 1, 0, missing),
                new ItemStack[] { getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), getModItem("EMT", "EMTItems", 1, 15, missing),
                        getModItem("EMT", "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("IC2", "itemOreIridium", 1, 0, missing))));
        TCHelper.orphanResearch("Portable Node");
        TCHelper.removeResearch("Portable Node");
        new ResearchItem(
                "PortableNode",
                "EMT",
                new AspectList().add(Aspect.getAspect("auram"), 15).add(Aspect.getAspect("alienis"), 12)
                        .add(Aspect.getAspect("lucrum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("vitreus"), 3),
                6,
                -3,
                3,
                getModItem("EMT", "PortableNode", 1, 0, missing))
                        .setParentsHidden("ElectricMagicTools").setRound()
                        .setPages(
                                new ResearchPage("tc.research_page.PortableNode"),
                                new ResearchPage(
                                        TCHelper.findCrucibleRecipe(getModItem("EMT", "PortableNode", 1, 0, missing))))
                        .registerResearchItem();
        TCHelper.orphanResearch("Shield Focus");
        TCHelper.removeResearch("Shield Focus");
        new ResearchItem(
                "ShieldFocus",
                "EMT",
                new AspectList().add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("aer"), 12)
                        .add(Aspect.getAspect("vitreus"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("cognitio"), 3),
                2,
                4,
                3,
                getModItem("EMT", "ShieldFocus", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("FOCUSPORTABLEHOLE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ShieldFocus")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ShieldFocus",
                getModItem("EMT", "ShieldFocus", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("tutamen"), 40)
                        .add(Aspect.getAspect("victus"), 16).add(Aspect.getAspect("vinculum"), 24)
                        .add(Aspect.getAspect("vitreus"), 16).add(Aspect.getAspect("praecantatio"), 8),
                getModItem("Thaumcraft", "FocusPortableHole", 1, 0, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 17602, missing),
                        getModItem("gregtech", "gt.blockreinforced", 1, 3, missing),
                        getModItem("IC2", "itemPartAlloy", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17383, missing),
                        getModItem("gregtech", "gt.blockreinforced", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17602, missing),
                        getModItem("gregtech", "gt.blockreinforced", 1, 3, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17383, missing),
                        getModItem("IC2", "itemPartAlloy", 1, 0, missing),
                        getModItem("gregtech", "gt.blockreinforced", 1, 3, missing), });
        TCHelper.addResearchPage(
                "ShieldFocus",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "ShieldFocus", 1, 0, missing))));
        TCHelper.orphanResearch("Shield Block");
        TCHelper.removeResearch("Shield Block");
        new ResearchItem(
                "ShieldBlock",
                "EMT",
                new AspectList().add(Aspect.getAspect("tutamen"), 15).add(Aspect.getAspect("vinculum"), 12)
                        .add(Aspect.getAspect("cognitio"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("alienis"), 3),
                2,
                6,
                3,
                getModItem("EMT", "ShieldBlock", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("ShieldFocus").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ShieldBlock")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ShieldBlock",
                getModItem("EMT", "ShieldBlock", 10, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("ordo"), 20)
                        .add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing),
                'b',
                getModItem("IC2", "itemPartAlloy", 1, 0, missing),
                'c',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing),
                'd',
                "plateReinforcedGlass",
                'e',
                getModItem("gregtech", "gt.blockreinforced", 1, 1, missing),
                'f',
                "plateReinforcedGlass",
                'g',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing),
                'h',
                getModItem("IC2", "itemPartAlloy", 1, 0, missing),
                'i',
                getModItem("Thaumcraft", "blockCosmeticSolid", 1, 1, missing));
        TCHelper.addResearchPage(
                "ShieldBlock",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("EMT", "ShieldBlock", 1, 0, missing))));
        TCHelper.orphanResearch("Kris-tmas Focus");
        TCHelper.removeResearch("Kris-tmas Focus");
        new ResearchItem(
                "KristmasFocus",
                "EMT",
                new AspectList().add(Aspect.getAspect("gelum"), 15).add(Aspect.getAspect("bestia"), 12)
                        .add(Aspect.getAspect("victus"), 9).add(Aspect.getAspect("mortuus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                3,
                4,
                3,
                getModItem("EMT", "ChristmasFocus", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("FOCUSSHOCK").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.KristmasFocus")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "KristmasFocus",
                getModItem("EMT", "ChristmasFocus", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 25).add(Aspect.getAspect("ordo"), 25)
                        .add(Aspect.getAspect("aqua"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem("minecraft", "pumpkin", 1, 0, missing),
                'b',
                getModItem("gregtech", "gt.metaitem.01", 1, 2728, missing),
                'c',
                getModItem("minecraft", "pumpkin", 1, 0, missing),
                'd',
                getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing),
                'e',
                getModItem("Thaumcraft", "FocusFrost", 1, 0, missing),
                'f',
                getModItem("gregtech", "gt.metaitem.01", 1, 2702, missing),
                'g',
                getModItem("minecraft", "pumpkin", 1, 0, missing),
                'h',
                getModItem("gregtech", "gt.metaitem.01", 1, 2728, missing),
                'i',
                getModItem("minecraft", "pumpkin", 1, 0, missing));
        TCHelper.addResearchPage(
                "KristmasFocus",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("EMT", "ChristmasFocus", 1, 0, missing))));
        TCHelper.orphanResearch("Energy Ball Focus");
        TCHelper.removeResearch("Energy Ball Focus");
        new ResearchItem(
                "EnergyBallFocus",
                "EMT",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("praecantatio"), 18)
                        .add(Aspect.getAspect("victus"), 9).add(Aspect.getAspect("cognitio"), 3),
                4,
                4,
                3,
                getModItem("EMT", "EnergyBallFocus", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("FOCUSSHOCK").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.EnergyBallFocus")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "EnergyBallFocus",
                getModItem("EMT", "EnergyBallFocus", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("potentia"), 24).add(Aspect.getAspect("praecantatio"), 30)
                        .add(Aspect.getAspect("victus"), 12).add(Aspect.getAspect("cognitio"), 6),
                getModItem("Thaumcraft", "FocusShock", 1, 0, missing),
                new ItemStack[] { getModItem("IC2", "blockMachine2", 1, 1, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1461, missing),
                        getModItem("IC2", "itemBatCrystal", 1, 32767, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1461, missing),
                        getModItem("IC2", "itemBatCrystal", 1, 32767, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1461, missing),
                        getModItem("IC2", "itemBatCrystal", 1, 32767, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1461, missing), });
        TCHelper.addResearchPage(
                "EnergyBallFocus",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "EnergyBallFocus", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("EnergyBallFocus", 1);
        TCHelper.orphanResearch("Explosion Focus");
        TCHelper.removeResearch("Explosion Focus");
        new ResearchItem(
                "ExplosionFocus",
                "EMT",
                new AspectList().add(Aspect.getAspect("ignis"), 15).add(Aspect.getAspect("mortuus"), 12)
                        .add(Aspect.getAspect("telum"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("potentia"), 3),
                5,
                4,
                3,
                getModItem("EMT", "ExplosionFocus", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("FOCUSHELLBAT").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ExplosionFocus")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ExplosionFocus",
                getModItem("EMT", "ExplosionFocus", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("mortuus"), 24)
                        .add(Aspect.getAspect("motus"), 48).add(Aspect.getAspect("telum"), 32)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("potentia"), 10),
                getModItem("Thaumcraft", "FocusHellbat", 1, 0, missing),
                new ItemStack[] { getModItem("IC2", "itemToolMiningLaser", 1, 32767, missing),
                        getModItem("dreamcraft", "item.ReinforcedGlassLense", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 1, missing),
                        getModItem("minecraft", "firework_charge", 1, 0, missing),
                        createItemStack(
                                "gregtech",
                                "gt.metaitem.02",
                                1,
                                26541,
                                "{ench:[0:{lvl:3s,id:20s}],GT.HasBeenUpdated:1b}",
                                missing),
                        getModItem("minecraft", "tnt", 1, 0, missing),
                        createItemStack(
                                "gregtech",
                                "gt.metaitem.02",
                                1,
                                26541,
                                "{ench:[0:{lvl:3s,id:20s}],GT.HasBeenUpdated:1b}",
                                missing),
                        getModItem("minecraft", "firework_charge", 1, 0, missing),
                        getModItem("Thaumcraft", "ItemResource", 1, 0, missing),
                        getModItem("dreamcraft", "item.ReinforcedGlassLense", 1, 0, missing), });
        TCHelper.addResearchPage(
                "ExplosionFocus",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "ExplosionFocus", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("ExplosionFocus", 1);
        TCHelper.orphanResearch("Wand Focus: Charging");
        TCHelper.removeResearch("Wand Focus: Charging");
        new ResearchItem(
                "WandFocusCharging",
                "EMT",
                new AspectList().add(Aspect.getAspect("permutatio"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("cognitio"), 3),
                6,
                4,
                3,
                getModItem("EMT", "ChargingFocus", 1, 0, missing)).setParentsHidden("ElectricMagicTools").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.WandFocusCharging")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "WandFocusCharging",
                getModItem("EMT", "ChargingFocus", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("permutatio"), 48).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("machina"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("cognitio"), 8),
                getModItem("IC2", "itemBatCrystal", 1, 32767, missing),
                new ItemStack[] { getModItem("gregtech", "gt.blockmachines", 1, 22, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 21330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 20330, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1460, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 20330, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 21330, missing), });
        TCHelper.addResearchPage(
                "WandFocusCharging",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "ChargingFocus", 1, 0, missing))));
        TCHelper.orphanResearch("Wand Focus: Wand Charging");
        TCHelper.removeResearch("Wand Focus: Wand Charging");
        new ResearchItem(
                "WandFocusWandCharging",
                "EMT",
                new AspectList().add(Aspect.getAspect("potentia"), 18).add(Aspect.getAspect("fabrico"), 15)
                        .add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("praecantatio"), 6).add(Aspect.getAspect("cognitio"), 3),
                6,
                6,
                3,
                getModItem("EMT", "WandChargingFocus", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("WandFocusCharging").registerResearchItem();
        TCHelper.addResearchPrereq("WandFocusWandCharging", "IndustrialWandChargingStation", true);
        ResearchCategories.getResearch("WandFocusWandCharging").setConcealed();
        TCHelper.addResearchPage("WandFocusWandCharging", new ResearchPage("tc.research_page.WandFocusWandCharging"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "WandFocusWandCharging",
                getModItem("EMT", "WandChargingFocus", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("potentia"), 48).add(Aspect.getAspect("fabrico"), 32)
                        .add(Aspect.getAspect("lucrum"), 64).add(Aspect.getAspect("permutatio"), 48)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("cognitio"), 8)
                        .add(Aspect.getAspect("auram"), 32),
                getModItem("EMT", "ChargingFocus", 1, 0, missing),
                new ItemStack[] { getModItem("EMT", "EMTMachines", 1, 0, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 20970, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1660, missing),
                        getModItem("IC2", "itemBatLamaCrystal", 1, 32767, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1660, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17970, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 20970, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing), });
        TCHelper.addResearchPage(
                "WandFocusWandCharging",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "WandChargingFocus", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("WandFocusWandCharging", 2);
        TCHelper.orphanResearch("Industrial Wand Charging Station");
        TCHelper.removeResearch("Industrial Wand Charging Station");
        TCHelper.orphanResearch("Etheral Processor");
        TCHelper.removeResearch("Etheral Processor");
        TCHelper.orphanResearch("Potentia Generator");
        TCHelper.removeResearch("Potentia Generator");
        new ResearchItem(
                "PotentiaGenerator",
                "EMT",
                new AspectList().add(Aspect.getAspect("potentia"), 15).add(Aspect.getAspect("permutatio"), 12)
                        .add(Aspect.getAspect("machina"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("metallum"), 3),
                -4,
                2,
                3,
                getModItem("EMT", "EssentiaGenerators", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("JARLABEL", "FOCUSTRADE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.PotentiaGenerator")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "PotentiaGenerator",
                getModItem("EMT", "EssentiaGenerators", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("potentia"), 48).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("machina"), 16).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("metallum"), 32),
                getModItem("IC2", "blockGenerator", 1, 7, missing),
                new ItemStack[] { getModItem("Thaumcraft", "FocusTrade", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing),
                        getModItem("minecraft", "hopper", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        getModItem("IC2", "blockElectric", 1, 7, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 22, missing),
                        getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                        getModItem("IC2", "blockMachine", 1, 12, missing),
                        getModItem("IC2", "blockElectric", 1, 7, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32601, missing),
                        getModItem("minecraft", "hopper", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32681, missing), });
        TCHelper.addResearchPage(
                "PotentiaGenerator",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "EssentiaGenerators", 1, 0, missing))));
        TCHelper.orphanResearch("Ignis Generator");
        TCHelper.removeResearch("Ignis Generator");
        new ResearchItem(
                "IgnisGenerator",
                "EMT",
                new AspectList().add(Aspect.getAspect("ignis"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("aqua"), 6).add(Aspect.getAspect("praecantatio"), 3),
                -6,
                4,
                3,
                getModItem("EMT", "EssentiaGenerators", 1, 1, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("PotentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.IgnisGenerator")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "IgnisGenerator",
                getModItem("EMT", "EssentiaGenerators", 1, 1, missing),
                getModItem("EMT", "EssentiaGenerators", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 16).add(Aspect.getAspect("permutatio"), 8)
                        .add(Aspect.getAspect("praecantatio"), 8));
        TCHelper.addResearchPage(
                "IgnisGenerator",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EssentiaGenerators", 1, 1, missing))));
        TCHelper.orphanResearch("Auram Generator");
        TCHelper.removeResearch("Auram Generator");
        new ResearchItem(
                "AuramGenerator",
                "EMT",
                new AspectList().add(Aspect.getAspect("auram"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("aqua"), 6).add(Aspect.getAspect("praecantatio"), 3),
                -4,
                4,
                3,
                getModItem("EMT", "EssentiaGenerators", 1, 2, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("PotentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.AuramGenerator")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "AuramGenerator",
                getModItem("EMT", "EssentiaGenerators", 1, 2, missing),
                getModItem("EMT", "EssentiaGenerators", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("auram"), 16).add(Aspect.getAspect("permutatio"), 8)
                        .add(Aspect.getAspect("praecantatio"), 8));
        TCHelper.addResearchPage(
                "AuramGenerator",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EssentiaGenerators", 1, 2, missing))));
        TCHelper.orphanResearch("Arbor Generator");
        TCHelper.removeResearch("Arbor Generator");
        new ResearchItem(
                "ArborGenerator",
                "EMT",
                new AspectList().add(Aspect.getAspect("arbor"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("aqua"), 6).add(Aspect.getAspect("praecantatio"), 3),
                -2,
                4,
                3,
                getModItem("EMT", "EssentiaGenerators", 1, 3, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("PotentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ArborGenerator")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "ArborGenerator",
                getModItem("EMT", "EssentiaGenerators", 1, 3, missing),
                getModItem("EMT", "EssentiaGenerators", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 16).add(Aspect.getAspect("permutatio"), 8)
                        .add(Aspect.getAspect("praecantatio"), 8));
        TCHelper.addResearchPage(
                "ArborGenerator",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EssentiaGenerators", 1, 3, missing))));
        TCHelper.orphanResearch("Aer Generator");
        TCHelper.removeResearch("Aer Generator");
        new ResearchItem(
                "AerGenerator",
                "EMT",
                new AspectList().add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("aqua"), 6).add(Aspect.getAspect("praecantatio"), 3),
                -4,
                6,
                3,
                getModItem("EMT", "EssentiaGenerators", 1, 4, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("PotentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.AerGenerator")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "AerGenerator",
                getModItem("EMT", "EssentiaGenerators", 1, 4, missing),
                getModItem("EMT", "EssentiaGenerators", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("permutatio"), 8)
                        .add(Aspect.getAspect("praecantatio"), 8));
        TCHelper.addResearchPage(
                "AerGenerator",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem("EMT", "EssentiaGenerators", 1, 4, missing))));
        TCHelper.orphanResearch("Lucrum Generator");
        TCHelper.removeResearch("Lucrum Generator");
        new ResearchItem(
                "LucrumGenerator",
                "EMT",
                new AspectList().add(Aspect.getAspect("lucrum"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("aqua"), 6).add(Aspect.getAspect("praecantatio"), 3),
                -4,
                8,
                3,
                getModItem("EMT", "EssentiaGenerators", 1, 5, missing))
                        .setParentsHidden("ElectricMagicTools")
                        .setParents(
                                "PotentiaGenerator",
                                "AerGenerator",
                                "IgnisGenerator",
                                "AuramGenerator",
                                "ArborGenerator")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.LucrumGenerator"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "LucrumGenerator",
                getModItem("EMT", "EssentiaGenerators", 1, 5, missing),
                10,
                new AspectList().add(Aspect.getAspect("permutatio"), 128).add(Aspect.getAspect("lucrum"), 256)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("nebrisum"), 16),
                getModItem("EMT", "EssentiaGenerators", 1, 0, missing),
                new ItemStack[] { getModItem("minecraft", "gold_block", 1, 0, missing),
                        getModItem("minecraft", "gold_block", 1, 0, missing),
                        getModItem("minecraft", "gold_block", 1, 0, missing),
                        getModItem("minecraft", "gold_block", 1, 0, missing),
                        getModItem("minecraft", "gold_block", 1, 0, missing),
                        getModItem("minecraft", "gold_block", 1, 0, missing),
                        getModItem("minecraft", "gold_block", 1, 0, missing),
                        getModItem("minecraft", "gold_block", 1, 0, missing),
                        getModItem("minecraft", "gold_block", 1, 0, missing),
                        getModItem("minecraft", "gold_block", 1, 0, missing),
                        getModItem("minecraft", "gold_block", 1, 0, missing),
                        getModItem("minecraft", "gold_block", 1, 0, missing), });
        TCHelper.addResearchPage(
                "LucrumGenerator",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "EssentiaGenerators", 1, 5, missing))));
        ThaumcraftApi.addWarpToResearch("LucrumGenerator", 5);
        new ResearchItem(
                "EssentiaFiller",
                "EMT",
                new AspectList().add(Aspect.getAspect("iter"), 12).add(Aspect.getAspect("permutatio"), 9)
                        .add(Aspect.getAspect("aqua"), 6).add(Aspect.getAspect("praecantatio"), 3),
                -4,
                10,
                3,
                getModItem("EMT", "EMTMachines", 1, 2, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("LucrumGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.EssentiaFiller")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "EssentiaFiller",
                getModItem("EMT", "EMTMachines", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("aer"), 90).add(Aspect.getAspect("terra"), 90)
                        .add(Aspect.getAspect("ignis"), 90).add(Aspect.getAspect("aqua"), 90)
                        .add(Aspect.getAspect("ordo"), 90).add(Aspect.getAspect("perditio"), 90),
                "abc",
                "def",
                "ghi",
                'a',
                "plateIridium",
                'b',
                "pipeTinyNetherStar",
                'c',
                "plateIridium",
                'd',
                "pipeTinyNetherStar",
                'e',
                getModItem("GalacticraftCore", "tile.fuelLoader", 1, 0, missing),
                'f',
                "pipeTinyNetherStar",
                'g',
                "plateIridium",
                'h',
                "pipeTinyNetherStar",
                'i',
                "plateIridium");
        TCHelper.addResearchPage(
                "EssentiaFiller",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("EMT", "EMTMachines", 1, 2, missing))));
        new ResearchItem(
                "LargeEssentiaGenerator",
                "EMT",
                new AspectList().add(Aspect.getAspect("auram"), 32).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("aqua"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                -4,
                12,
                3,
                getModItem("gregtech", "gt.blockmachines", 1, 13000, missing))
                        .setParentsHidden("ElectricMagicTools")
                        .setParents(
                                "EssentiaFiller",
                                "LucrumGenerator",
                                "PotentiaGenerator",
                                "AerGenerator",
                                "IgnisGenerator",
                                "AuramGenerator",
                                "ArborGenerator")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.LargeEssentiaGenerator"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "LargeEssentiaGenerator",
                getModItem("gregtech", "gt.blockmachines", 1, 13000, missing),
                10,
                new AspectList().add(Aspect.getAspect("permutatio"), 1024).add(Aspect.getAspect("praecantatio"), 512)
                        .add(Aspect.getAspect("lucrum"), 256).add(Aspect.getAspect("radio"), 128)
                        .add(Aspect.getAspect("nebrisum"), 64).add(Aspect.getAspect("terminus"), 32),
                getModItem("IC2", "blockGenerator", 1, 5, missing),
                new ItemStack[] { getModItem("gregtech", "gt.blockmachines", 1, 1191, missing),
                        getModItem("EMT", "EssentiaGenerators", 1, 0, missing),
                        getModItem("EMT", "EssentiaGenerators", 1, 1, missing),
                        getModItem("EMT", "EssentiaGenerators", 1, 2, missing),
                        getModItem("gregtech", "gt.blockmachines", 1, 1191, missing),
                        getModItem("EMT", "EssentiaGenerators", 1, 3, missing),
                        getModItem("EMT", "EssentiaGenerators", 1, 4, missing),
                        getModItem("EMT", "EssentiaGenerators", 1, 5, missing), });
        TCHelper.addResearchPage(
                "LargeEssentiaGenerator",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem("gregtech", "gt.blockmachines", 1, 13000, missing))));
        ThaumcraftApi.addWarpToResearch("LargeEssentiaGenerator", 10);
        new ResearchItem(
                "EssentiaDiffusionCells",
                "EMT",
                new AspectList().add(Aspect.getAspect("auram"), 32).add(Aspect.getAspect("lucrum"), 12)
                        .add(Aspect.getAspect("permutatio"), 9).add(Aspect.getAspect("aqua"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                -2,
                14,
                3,
                getModItem("EMT", "EMT_GTBLOCK_CASEING", 1, 1, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("LargeEssentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.EssentiaDiffusionCells")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "EssentiaDiffusionCells",
                getModItem("EMT", "EMT_GTBLOCK_CASEING", 1, 1, missing),
                10,
                new AspectList().add(Aspect.getAspect("perditio"), 64).add(Aspect.getAspect("permutatio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("nebrisum"), 64)
                        .add(Aspect.getAspect("radio"), 64),
                getModItem("EMT", "EMT_GTBLOCK_CASEING", 1, 5, missing),
                new ItemStack[] { getModItem("Avaritia", "big_pearl", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19083, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19083, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19097, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19097, missing),
                        getModItem("thaumicenergistics", "material", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19097, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19097, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19101, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19101, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32684, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19101, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19101, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19097, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19097, missing),
                        getModItem("thaumicenergistics", "material", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19097, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19097, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19083, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 19083, missing), });
        TCHelper.addResearchPage(
                "EssentiaDiffusionCells",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "EMT_GTBLOCK_CASEING", 1, 1, missing))));
        ThaumcraftApi.addWarpToResearch("EssentiaDiffusionCells", 10);
        new ResearchItem(
                "MagicContainingCasings",
                "EMT",
                new AspectList().add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("nebrisum"), 12)
                        .add(Aspect.getAspect("ordo"), 9).add(Aspect.getAspect("tempus"), 6)
                        .add(Aspect.getAspect("praecantatio"), 3),
                -6,
                14,
                3,
                getModItem("EMT", "EMT_GTBLOCK_CASEING", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("LargeEssentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.MagicContainingCasings")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "MagicContainingCasings",
                getModItem("EMT", "EMT_GTBLOCK_CASEING", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("ordo"), 64).add(Aspect.getAspect("tempus"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("nebrisum"), 64)
                        .add(Aspect.getAspect("tutamen"), 512),
                getModItem("EMT", "EMT_GTBLOCK_CASEING", 1, 4, missing),
                new ItemStack[] { getModItem("gregtech", "gt.metaitem.01", 1, 32674, missing),
                        getModItem("EMT", "ShieldBlock", 1, 0, missing),
                        getModItem("EMT", "ShieldBlock", 1, 0, missing),
                        getModItem("EMT", "ShieldBlock", 1, 0, missing),
                        getModItem("EMT", "ShieldBlock", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 32674, missing),
                        getModItem("EMT", "ShieldBlock", 1, 0, missing),
                        getModItem("EMT", "ShieldBlock", 1, 0, missing),
                        getModItem("EMT", "ShieldBlock", 1, 0, missing),
                        getModItem("EMT", "ShieldBlock", 1, 0, missing), });
        TCHelper.addResearchPage(
                "MagicContainingCasings",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "EMT_GTBLOCK_CASEING", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("MagicContainingCasings", 10);
        new ResearchItem(
                "IndustrialWandChargingStation",
                "EMT",
                new AspectList().add(Aspect.getAspect("permutatio"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("lucrum"), 3),
                -6,
                2,
                3,
                getModItem("EMT", "EMTMachines", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("PotentiaGenerator", "WANDPED", "JARLABEL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.IndustrialWandChargingStation"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "IndustrialWandChargingStation",
                getModItem("EMT", "EMTMachines", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("permutatio"), 48).add(Aspect.getAspect("potentia"), 48)
                        .add(Aspect.getAspect("fabrico"), 48).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("lucrum"), 64).add(Aspect.getAspect("cognitio"), 16),
                getModItem("Thaumcraft", "blockStoneDevice", 1, 5, missing),
                new ItemStack[] { getModItem("gregtech", "gt.blockmachines", 1, 485, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30500, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("Thaumcraft", "blockJar", 1, 0, missing),
                        getModItem("Thaumcraft", "blockCrystal", 1, 6, missing),
                        getModItem("gregtech", "gt.metaitem.02", 1, 30500, missing),
                        getModItem("IC2", "itemPartIridium", 1, 0, missing), });
        TCHelper.addResearchPage(
                "IndustrialWandChargingStation",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "EMTMachines", 1, 0, missing))));
        ThaumcraftApi.addWarpToResearch("IndustrialWandChargingStation", 3);
        new ResearchItem(
                "EtheralProcessor",
                "EMT",
                new AspectList().add(Aspect.getAspect("machina"), 15).add(Aspect.getAspect("fabrico"), 12)
                        .add(Aspect.getAspect("potentia"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("cognitio"), 3),
                -2,
                2,
                3,
                getModItem("EMT", "EMTMachines", 1, 1, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("BELLOWS", "DISTILESSENTIA", "INFERNALFURNACE", "PotentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.EtheralProcessor")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "EtheralProcessor",
                getModItem("EMT", "EMTMachines", 1, 1, missing),
                9,
                new AspectList().add(Aspect.getAspect("machina"), 16).add(Aspect.getAspect("fabrico"), 16)
                        .add(Aspect.getAspect("potentia"), 24).add(Aspect.getAspect("praecantatio"), 28)
                        .add(Aspect.getAspect("cognitio"), 8),
                getModItem("gregtech", "gt.blockmachines", 1, 302, missing),
                new ItemStack[] { getModItem("gregtech", "gt.blockmachines", 1, 262, missing),
                        getModItem("Thaumcraft", "blockMetalDevice", 1, 9, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 1, 0, missing),
                        getModItem("Thaumcraft", "blockStoneDevice", 1, 0, missing),
                        getModItem("Thaumcraft", "blockWoodenDevice", 1, 0, missing),
                        getModItem("gregtech", "gt.metaitem.01", 1, 17330, missing),
                        getModItem("Thaumcraft", "blockMetalDevice", 1, 9, missing), });
        TCHelper.addResearchPage(
                "EtheralProcessor",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem("EMT", "EMTMachines", 1, 1, missing))));
        TCHelper.orphanResearch("ResearchCompleter");
        new ResearchItem(
                "ResearchCompleter",
                "EMT",
                new AspectList().add(Aspect.getAspect("cognitio"), 8).add(Aspect.getAspect("machina"), 5)
                        .add(Aspect.getAspect("permutatio"), 5).add(Aspect.getAspect("auram"), 4),
                -2,
                6,
                1,
                getModItem("gregtech", "gt.blockmachines", 1, 13001, missing)).setParents("WANDPED", "WARDEDARCANA")
                        .setRound().setPages(new ResearchPage("tc.research_page.ResearchCompleter"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ResearchCompleter",
                getModItem("gregtech", "gt.blockcasings8", 1, 8, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 8).add(Aspect.getAspect("aer"), 8)
                        .add(Aspect.getAspect("ordo"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'c',
                "plateThaumium",
                'd',
                "plateThaumium",
                'e',
                "frameGtThaumium",
                'f',
                "plateThaumium",
                'g',
                "plateThaumium",
                'h',
                getModItem("Thaumcraft", "ItemResource", 1, 14, missing),
                'i',
                "plateThaumium");
        TCHelper.addResearchPage(
                "ResearchCompleter",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem("gregtech", "gt.blockcasings8", 1, 8, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ResearchCompleter",
                getModItem("gregtech", "gt.blockmachines", 1, 13001, missing),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitGood",
                'b',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'c',
                "circuitGood",
                'd',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'e',
                getModItem("gregtech", "gt.blockcasings8", 1, 8, missing),
                'f',
                getModItem("Thaumcraft", "blockCosmeticOpaque", 1, 2, missing),
                'g',
                "circuitGood",
                'h',
                getModItem("Thaumcraft", "blockStoneDevice", 1, 5, missing),
                'i',
                "circuitGood");
        TCHelper.addResearchPage(
                "ResearchCompleter",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem("gregtech", "gt.blockmachines", 1, 13001, missing))));
    }
}
