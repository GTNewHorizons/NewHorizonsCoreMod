package com.dreammaster.scripts;

import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.ElectroMagicTools;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicEnergistics;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidExtractionRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidSolidifierRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GTModHandler.getModItem;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.gthandler.CustomItemList;
import com.dreammaster.item.NHItemList;
import com.dreammaster.thaumcraft.TCHelper;

import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TierEU;
import gregtech.api.util.GTOreDictUnificator;
import gtPlusPlus.xmod.gregtech.api.enums.GregtechItemList;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class ScriptEMT implements IScriptLoader {

    @Override
    public String getScriptName() {
        return "EMT";
    }

    @Override
    public List<String> getDependencies() {
        return Arrays.asList(
                ElectroMagicTools.ID,
                Thaumcraft.ID,
                IndustrialCraft2.ID,
                ProjectRedIntegration.ID,
                AdvancedSolarPanel.ID,
                GalacticraftCore.ID,
                Avaritia.ID,
                ThaumicEnergistics.ID,
                TinkerConstruct.ID,
                Railcraft.ID);
    }

    @Override
    public void loadRecipes() {

        addShapelessRecipe(
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 36, missing),
                getModItem(TinkerConstruct.ID, "materials", 1, 36, missing));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "materials", 2, 36, missing),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8, missing));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 4L),
                        ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 10, missing)).duration(10 * SECONDS)
                .eut(16).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 12, 0, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 4, 10, missing))
                .itemOutputs(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 6912)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 12, 0, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 4, 10, missing))
                .itemOutputs(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 9, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 6912)).duration(30 * SECONDS).eut(30)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8, missing))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 288)).duration(5 * SECONDS).eut(16)
                .addTo(fluidSolidifierRecipes);
        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 10, missing))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 576)).duration(5 * SECONDS).eut(30)
                .addTo(fluidSolidifierRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8, missing))
                .fluidOutputs(FluidRegistry.getFluidStack("refinedglue", 288)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(fluidExtractionRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 4L),
                        ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 10, missing)).duration(5 * SECONDS).eut(30)
                .addTo(formingPressRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 10, missing))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 4L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

        TCHelper.removeArcaneRecipe(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 14, missing));
        TCHelper.removeArcaneRecipe(getModItem(ElectroMagicTools.ID, "ThaumiumWing", 1, 0, missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "NanosuitWing", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "QuantumWing", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeArcaneRecipe(
                createItemStack(ElectroMagicTools.ID, "Diamond Omnitool", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeArcaneRecipe(getModItem(ElectroMagicTools.ID, "Diamond Omnitool", 1, 0, missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "ThaumiumOmnitool", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "ThaumiumOmnitool", 1, 0, missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "ElectricBootsTraveller", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "NanoBootsTraveller", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "QuantumBootsTraveller", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "ThaumiumDrill", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "DrillRockbreaker", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "ThaumiumChainsaw", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "ChainsawStream", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTBaubles", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTBaubles", 1, 1, missing));
        TCHelper.removeArcaneRecipe(
                createItemStack(ElectroMagicTools.ID, "ElectricGogglesRevealing", 1, 164, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "itemArmorQuantumChestplate", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "NanosuitGogglesRevealing", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "QuantumGogglesRevealing", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "SolarHelmetRevealing", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeArcaneRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 3, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 4, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 5, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 6, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 7, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 8, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 9, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 10, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 11, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 12, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 13, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 14, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 15, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 1, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 2, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 3, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 4, missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "ElectricHoeGrowth", 1, 1560, "{charge:10.0d}", missing));
        TCHelper.removeArcaneRecipe(
                createItemStack(ElectroMagicTools.ID, "ElectricScribingTools", 1, 390, "{charge:10.0d}", missing));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "Mjolnir", 1, 0, missing));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "SuperchargedMjolnir", 1, 26, "{charge:10.0d}", missing));
        TCHelper.removeArcaneRecipe(ItemList.IC2_Uranium_235_Small.get(7));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing));
        TCHelper.removeInfusionRecipe(getModItem(Minecraft.ID, "coal", 16, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(Minecraft.ID, "glowstone", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(IndustrialCraft2.ID, "itemOreIridium", 2, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(Minecraft.ID, "gold_ingot", 2, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(Minecraft.ID, "diamond", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "ShieldFocus", 1, 0, missing));
        TCHelper.removeInfusionRecipe(ItemList.IC2_Uranium_238.get(2));
        TCHelper.removeArcaneRecipe(getModItem(ElectroMagicTools.ID, "ShieldBlock", 6, 0, missing));
        TCHelper.removeArcaneRecipe(getModItem(ElectroMagicTools.ID, "ChristmasFocus", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "EnergyBallFocus", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "ExplosionFocus", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "ChargingFocus", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "WandChargingFocus", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 5, missing));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 1, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 2, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 3, missing));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 4, missing));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 0, missing));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 1, missing));
        TCHelper.orphanResearch("Electric Magic Tools");
        TCHelper.removeResearch("Electric Magic Tools");
        new ResearchItem(
                "ElectricMagicTools",
                "EMT",
                new AspectList().add(Aspect.getAspect("terra"), 0),
                0,
                0,
                1,
                NHItemList.EMT.getIS()).setAutoUnlock().setSpecial()
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
                createItemStack(ElectroMagicTools.ID, "DiamondChainsaw", 1, 27, "{shearsMode:1b}", missing))
                        .setParents("ElectricMagicTools").setRound()
                        .setPages(new ResearchPage("tc.research_page.DiamondChainsaw")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DiamondChainsaw",
                createItemStack(ElectroMagicTools.ID, "DiamondChainsaw", 1, 27, "{shearsMode:1b}", missing),
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
                ItemList.Battery_RE_MV_Lithium.get(1L),
                'i',
                "craftingToolWrench");
        TCHelper.addResearchPage(
                "DiamondChainsaw",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                createItemStack(
                                        ElectroMagicTools.ID,
                                        "DiamondChainsaw",
                                        1,
                                        27,
                                        "{shearsMode:1b}",
                                        missing))));
        TCHelper.removeResearch("Thaumium Plate");
        new ResearchItem(
                "ThaumiumPlate",
                "EMT",
                new AspectList(),
                6,
                -6,
                1,
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 5, missing)).setAutoUnlock().setRound()
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
                getModItem(ElectroMagicTools.ID, "electricCloud", 1, 0, missing))
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
                getModItem(ElectroMagicTools.ID, "FeatherWing", 1, 0, missing)).setParents("ElectricMagicTools")
                        .setRound().setPages(new ResearchPage("tc.research_page.FeatherWings")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FeatherWings",
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("aer"), 5).add(Aspect.getAspect("terra"), 5)
                        .add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "feather", 1, 0, missing),
                'b',
                getModItem(Minecraft.ID, "feather", 1, 0, missing),
                'c',
                getModItem(Minecraft.ID, "feather", 1, 0, missing),
                'd',
                getModItem(Minecraft.ID, "feather", 1, 0, missing),
                'e',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 9, missing),
                'f',
                getModItem(Minecraft.ID, "feather", 1, 0, missing),
                'g',
                getModItem(Minecraft.ID, "feather", 1, 0, missing),
                'h',
                getModItem(Minecraft.ID, "feather", 1, 0, missing),
                'i',
                getModItem(Minecraft.ID, "feather", 1, 0, missing));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FeatherWings",
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 11, missing),
                new AspectList().add(Aspect.getAspect("aer"), 15).add(Aspect.getAspect("ordo"), 5),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.plateQuintuple, Materials.Paper, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.plateQuintuple, Materials.Paper, 1L),
                'd',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8, missing),
                'e',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8, missing));
        TCHelper.addResearchPage(
                "FeatherWings",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 11, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FeatherWings",
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("aer"), 10).add(Aspect.getAspect("ordo"), 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7, missing),
                'b',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8, missing),
                'c',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 11, missing),
                'd',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7, missing),
                'e',
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                'f',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 11, missing),
                'g',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7, missing),
                'h',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8, missing),
                'i',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 11, missing));
        TCHelper.addResearchPage(
                "FeatherWings",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FeatherWings",
                getModItem(ElectroMagicTools.ID, "FeatherWing", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("terra"), 24)
                        .add(Aspect.getAspect("ignis"), 24).add(Aspect.getAspect("aqua"), 24)
                        .add(Aspect.getAspect("ordo"), 24).add(Aspect.getAspect("perditio"), 24),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12, missing),
                'b',
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                'c',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12, missing),
                'd',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12, missing),
                'e',
                "plateAluminium",
                'f',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12, missing),
                'g',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12, missing),
                'h',
                getModItem(Minecraft.ID, "string", 1, 0, missing),
                'i',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12, missing));
        TCHelper.addResearchPage(
                "FeatherWings",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "FeatherWing", 1, 0, missing))));
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
                getModItem(ElectroMagicTools.ID, "ThaumiumWing", 1, 0, missing)).setParents("FeatherWings")
                        .setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.ThaumiumReinforcedWings")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "ThaumiumReinforcedWings",
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 13, missing),
                getModItem(Minecraft.ID, "feather", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("vitium"), 6).add(Aspect.getAspect("lucrum"), 4)
                        .add(Aspect.getAspect("fames"), 4));
        TCHelper.addResearchPage(
                "ThaumiumReinforcedWings",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 13, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ThaumiumReinforcedWings",
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("aer"), 48).add(Aspect.getAspect("terra"), 48)
                        .add(Aspect.getAspect("ignis"), 48).add(Aspect.getAspect("aqua"), 48)
                        .add(Aspect.getAspect("ordo"), 48).add(Aspect.getAspect("perditio"), 48),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 13, missing),
                'b',
                "plateThaumium",
                'c',
                "plateStainlessSteel",
                'd',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 13, missing),
                'e',
                "wireFineCobalt",
                'f',
                "plateStainlessSteel",
                'g',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 13, missing),
                'h',
                "plateThaumium",
                'i',
                "plateStainlessSteel");
        TCHelper.addResearchPage(
                "ThaumiumReinforcedWings",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 14, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ThaumiumReinforcedWings",
                getModItem(ElectroMagicTools.ID, "ThaumiumWing", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 48).add(Aspect.getAspect("terra"), 48)
                        .add(Aspect.getAspect("ignis"), 48).add(Aspect.getAspect("aqua"), 48)
                        .add(Aspect.getAspect("ordo"), 48).add(Aspect.getAspect("perditio"), 48),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 14, missing),
                'b',
                "wireFineCobalt",
                'c',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 14, missing),
                'd',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 14, missing),
                'e',
                "wireFineCobalt",
                'f',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 14, missing));
        TCHelper.addResearchPage(
                "ThaumiumReinforcedWings",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "ThaumiumWing", 1, 0, missing))));
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
                getModItem(ElectroMagicTools.ID, "NanosuitWing", 1, 0, missing)).setParents("ThaumiumReinforcedWings")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.NanosuitWings"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "NanosuitWings",
                getModItem(ElectroMagicTools.ID, "NanosuitWing", 1, 27, missing),
                5,
                new AspectList().add(Aspect.getAspect("aer"), 48).add(Aspect.getAspect("machina"), 48)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("volatus"), 32)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("vitium"), 8)
                        .add(Aspect.getAspect("terra"), 8),
                getModItem(ElectroMagicTools.ID, "ThaumiumWing", 1, 0, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemArmorNanoChestplate", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Titanium, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Titanium, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Titanium, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Titanium, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Titanium, 1L), });
        TCHelper.addResearchPage(
                "NanosuitWings",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "NanosuitWing", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "QuantumWing", 1, 0, missing)).setParents("NanosuitWings")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.QuantumWings"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "QuantumWings",
                getModItem(ElectroMagicTools.ID, "QuantumWing", 1, 27, missing),
                10,
                new AspectList().add(Aspect.getAspect("tutamen"), 64).add(Aspect.getAspect("aer"), 64)
                        .add(Aspect.getAspect("machina"), 64).add(Aspect.getAspect("potentia"), 48)
                        .add(Aspect.getAspect("volatus"), 48).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("vitium"), 16).add(Aspect.getAspect("terra"), 16),
                getModItem(ElectroMagicTools.ID, "NanosuitWing", 1, wildcard, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemArmorQuantumChestplate", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Osmium, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Osmium, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Osmium, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Osmium, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Osmium, 1L), });
        TCHelper.addResearchPage(
                "QuantumWings",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "QuantumWing", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "itemArmorQuantumChestplate", 1, 0, missing))
                        .setParents("QuantumWings").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.InfusedQuantumArmor")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "InfusedQuantumArmor",
                getModItem(ElectroMagicTools.ID, "itemArmorQuantumChestplate", 1, 27, missing),
                15,
                new AspectList().add(Aspect.getAspect("tutamen"), 72).add(Aspect.getAspect("aer"), 64)
                        .add(Aspect.getAspect("machina"), 64).add(Aspect.getAspect("potentia"), 48)
                        .add(Aspect.getAspect("volatus"), 48).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("vitium"), 16).add(Aspect.getAspect("terra"), 16)
                        .add(Aspect.getAspect("lucrum"), 8),
                getModItem(IndustrialCraft2.ID, "itemArmorQuantumChestplate", 1, wildcard, missing),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "ShieldBlock", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Naquadah, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Naquadah, 1L),
                        getModItem(ElectroMagicTools.ID, "ShieldBlock", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Naquadah, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireFine, Materials.Naquadah, 1L), });
        TCHelper.addResearchPage(
                "InfusedQuantumArmor",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "itemArmorQuantumChestplate", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "Omnitool", 1, 0, missing)).setParents("ElectricMagicTools").setRound()
                        .setPages(new ResearchPage("tc.research_page.IronOmnitool")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IronOmnitool",
                getModItem(ElectroMagicTools.ID, "Omnitool", 1, 27, missing),
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
                ItemList.Battery_RE_LV_Lithium.get(1L),
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
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "Omnitool", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "Diamond Omnitool", 1, 0, missing)).setParents("IronOmnitool")
                        .setParentsHidden("DiamondChainsaw").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.DiamondOmnitool")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "DiamondOmnitool",
                getModItem(ElectroMagicTools.ID, "Diamond Omnitool", 1, 27, missing),
                6,
                new AspectList().add(Aspect.getAspect("instrumentum"), 32).add(Aspect.getAspect("perfodio"), 24)
                        .add(Aspect.getAspect("potentia"), 24).add(Aspect.getAspect("metallum"), 16)
                        .add(Aspect.getAspect("telum"), 16).add(Aspect.getAspect("terra"), 8),
                createItemStack(
                        GregTech.ID,
                        "gt.metatool.01",
                        1,
                        102,
                        "{ench:[0:{lvl:2s,id:35s}],GT.ToolStats:{PrimaryMaterial:\"Thaumium\",SpecialData:-1L,MaxDamage:51200L,Tier:2L,MaxCharge:400000L,Voltage:128L,Electric:1b,SecondaryMaterial:\"Titanium\"},GT.ItemCharge:400000L}",
                        missing),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "DiamondChainsaw", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Thaumium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Thaumium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L), });
        TCHelper.addResearchPage(
                "DiamondOmnitool",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "Diamond Omnitool", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "ThaumiumOmnitool", 1, 0, missing)).setParents("DiamondOmnitool")
                        .setParentsHidden("ThaumiumChainsaw", "ThaumiumDrill").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.ThaumiumOmnitool")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ThaumiumOmnitool",
                getModItem(ElectroMagicTools.ID, "ThaumiumOmnitool", 1, 27, missing),
                8,
                new AspectList().add(Aspect.getAspect("instrumentum"), 48).add(Aspect.getAspect("perfodio"), 24)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("metallum"), 24)
                        .add(Aspect.getAspect("telum"), 16).add(Aspect.getAspect("terra"), 8)
                        .add(Aspect.getAspect("praecantatio"), 16),
                getModItem(ElectroMagicTools.ID, "ThaumiumChainsaw", 1, wildcard, missing),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "ThaumiumDrill", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1L),
                        ItemList.Circuit_Elite.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        ItemList.Circuit_Elite.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1L), });
        TCHelper.addResearchPage(
                "ThaumiumOmnitool",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "ThaumiumOmnitool", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "ElectricBootsTraveller", 1, 0, missing)).setParents("BOOTSTRAVELLER")
                        .setParentsHidden("ElectricMagicTools").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.ElectricBootsoftheTraveller"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ElectricBootsoftheTraveller",
                getModItem(ElectroMagicTools.ID, "ElectricBootsTraveller", 1, 27, missing),
                3,
                new AspectList().add(Aspect.getAspect("motus"), 32).add(Aspect.getAspect("potentia"), 16)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("praecantatio"), 8)
                        .add(Aspect.getAspect("volatus"), 8).add(Aspect.getAspect("iter"), 8),
                getModItem(Thaumcraft.ID, "BootsTraveller", 1, 0, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemStaticBoots", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L),
                        ItemList.Electric_Motor_MV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Copper, 1L),
                        getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Copper, 1L),
                        ItemList.Electric_Motor_MV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Diamond, 1L), });
        TCHelper.addResearchPage(
                "ElectricBootsoftheTraveller",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "ElectricBootsTraveller", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "NanoBootsTraveller", 1, 0, missing))
                        .setParents("ElectricBootsoftheTraveller").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.NanoBootsoftheTraveller")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "NanoBootsoftheTraveller",
                getModItem(ElectroMagicTools.ID, "NanoBootsTraveller", 1, 27, missing),
                6,
                new AspectList().add(Aspect.getAspect("motus"), 48).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("volatus"), 8).add(Aspect.getAspect("iter"), 16),
                getModItem(ElectroMagicTools.ID, "ElectricBootsTraveller", 1, wildcard, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        ItemList.Electric_Motor_HV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 1L),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 1L),
                        ItemList.Electric_Motor_HV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L), });
        TCHelper.addResearchPage(
                "NanoBootsoftheTraveller",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "NanoBootsTraveller", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "QuantumBootsTraveller", 1, 0, missing))
                        .setParents("NanoBootsoftheTraveller").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.QuantumBootsoftheTraveller"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "QuantumBootsoftheTraveller",
                getModItem(ElectroMagicTools.ID, "QuantumBootsTraveller", 1, 27, missing),
                9,
                new AspectList().add(Aspect.getAspect("motus"), 64).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("tutamen"), 48).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("volatus"), 16).add(Aspect.getAspect("iter"), 24)
                        .add(Aspect.getAspect("aer"), 8),
                getModItem(ElectroMagicTools.ID, "NanoBootsTraveller", 1, wildcard, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemArmorQuantumBoots", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        ItemList.Electric_Motor_EV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Titanium, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Titanium, 1L),
                        ItemList.Electric_Motor_EV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L), });
        TCHelper.addResearchPage(
                "QuantumBootsoftheTraveller",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "QuantumBootsTraveller", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "ThaumiumDrill", 1, 0, missing)).setParents("ElectricMagicTools")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.ThaumiumDrill"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ThaumiumDrill",
                getModItem(ElectroMagicTools.ID, "ThaumiumDrill", 1, 27, missing),
                7,
                new AspectList().add(Aspect.getAspect("instrumentum"), 32).add(Aspect.getAspect("perfodio"), 16)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("lucrum"), 24)
                        .add(Aspect.getAspect("praecantatio"), 8),
                createItemStack(
                        GregTech.ID,
                        "gt.metatool.01",
                        1,
                        102,
                        "{ench:[0:{lvl:2s,id:35s}],GT.ToolStats:{PrimaryMaterial:\"Thaumium\",SpecialData:-1L,MaxDamage:51200L,Tier:2L,MaxCharge:400000L,Voltage:128L,Electric:1b,SecondaryMaterial:\"Aluminium\"},GT.ItemCharge:400000L}",
                        missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        ItemList.Circuit_Elite.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        ItemList.Circuit_Elite.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1L), });
        TCHelper.addResearchPage(
                "ThaumiumDrill",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "ThaumiumDrill", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "DrillRockbreaker", 1, 0, missing)).setParents("ThaumiumDrill")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.DrilloftheRockbreaker"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "DrilloftheRockbreaker",
                getModItem(ElectroMagicTools.ID, "DrillRockbreaker", 1, 27, missing),
                10,
                new AspectList().add(Aspect.getAspect("instrumentum"), 48).add(Aspect.getAspect("perfodio"), 24)
                        .add(Aspect.getAspect("potentia"), 48).add(Aspect.getAspect("lucrum"), 32)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("ignis"), 8),
                getModItem(ElectroMagicTools.ID, "ThaumiumDrill", 1, wildcard, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemShovelElemental", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        ItemList.Circuit_Master.get(1L),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        getModItem(Thaumcraft.ID, "ItemPickaxeElemental", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        ItemList.Circuit_Master.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing), });
        TCHelper.addResearchPage(
                "DrilloftheRockbreaker",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "DrillRockbreaker", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "ThaumiumChainsaw", 1, 0, missing)).setParents("DiamondChainsaw")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.ThaumiumChainsaw"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ThaumiumChainsaw",
                getModItem(ElectroMagicTools.ID, "ThaumiumChainsaw", 1, 27, missing),
                7,
                new AspectList().add(Aspect.getAspect("instrumentum"), 32).add(Aspect.getAspect("telum"), 24)
                        .add(Aspect.getAspect("potentia"), 24).add(Aspect.getAspect("lucrum"), 16)
                        .add(Aspect.getAspect("praecantatio"), 8),
                getModItem(ElectroMagicTools.ID, "DiamondChainsaw", 1, wildcard, missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        ItemList.Circuit_Elite.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.screw, Materials.Titanium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        ItemList.Circuit_Elite.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.TungstenSteel, 1L), });
        TCHelper.addResearchPage(
                "ThaumiumChainsaw",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "ThaumiumChainsaw", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "ChainsawStream", 1, 0, missing)).setParents("ThaumiumChainsaw")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.ChainsawoftheStream"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ChainsawoftheStream",
                getModItem(ElectroMagicTools.ID, "ChainsawStream", 1, 27, missing),
                10,
                new AspectList().add(Aspect.getAspect("instrumentum"), 48).add(Aspect.getAspect("telum"), 32)
                        .add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("lucrum"), 24)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("aer"), 8),
                getModItem(ElectroMagicTools.ID, "ThaumiumChainsaw", 1, wildcard, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemAxeElemental", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        ItemList.Circuit_Master.get(1L),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        getModItem(Railcraft.ID, "tool.steel.shears", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        ItemList.Circuit_Master.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing), });
        TCHelper.addResearchPage(
                "ChainsawoftheStream",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "ChainsawStream", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "EMTBaubles", 1, 1, missing)).setParentsHidden("ElectricMagicTools")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.InventoryChargingRing"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "InventoryChargingRing",
                getModItem(ElectroMagicTools.ID, "EMTBaubles", 1, 1, missing),
                7,
                new AspectList().add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("vitreus"), 32)
                        .add(Aspect.getAspect("praecantatio"), 48).add(Aspect.getAspect("electrum"), 16)
                        .add(Aspect.getAspect("auram"), 8),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 1, missing),
                new ItemStack[] { ItemList.IC2_EnergyCrystal.get(1), ItemList.MagicEnergyAbsorber_LV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Silver, 4L),
                        ItemList.Generator_Steam_Turbine_LV.get(1),
                        getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemStaticBoots", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 2, missing),
                        getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Silver, 4L),
                        ItemList.Cover_SolarPanel_LV.get(1) });
        TCHelper.addResearchPage(
                "InventoryChargingRing",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTBaubles", 1, 1, missing))));
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
                getModItem(ElectroMagicTools.ID, "EMTBaubles", 1, 0, missing)).setParents("InventoryChargingRing")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.ArmorChargingRing"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ArmorChargingRing",
                getModItem(ElectroMagicTools.ID, "EMTBaubles", 1, 0, missing),
                8,
                new AspectList().add(Aspect.getAspect("potentia"), 64).add(Aspect.getAspect("tutamen"), 32)
                        .add(Aspect.getAspect("praecantatio"), 48).add(Aspect.getAspect("electrum"), 16)
                        .add(Aspect.getAspect("auram"), 8),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 1, missing),
                new ItemStack[] { ItemList.IC2_EnergyCrystal.get(1), ItemList.MagicEnergyAbsorber_LV.get(1),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.BlueAlloy, 4L),
                        ItemList.Generator_Steam_Turbine_LV.get(1),
                        getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemStaticBoots", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 2, missing),
                        getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.BlueAlloy, 4L),
                        ItemList.Cover_SolarPanel_LV.get(1) });
        TCHelper.addResearchPage(
                "ArmorChargingRing",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTBaubles", 1, 0, missing))));
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
                getModItem(ElectroMagicTools.ID, "ElectricGogglesRevealing", 1, 0, missing)).setParents("GOGGLES")
                        .setConcealed().setParentsHidden("ElectricMagicTools").setRound()
                        .setPages(new ResearchPage("tc.research_page.ElectricGogglesofRevealing"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ElectricGogglesofRevealing",
                getModItem(ElectroMagicTools.ID, "ElectricGogglesRevealing", 1, 165, missing),
                new AspectList().add(Aspect.getAspect("aer"), 45).add(Aspect.getAspect("ignis"), 45)
                        .add(Aspect.getAspect("terra"), 45).add(Aspect.getAspect("aqua"), 45)
                        .add(Aspect.getAspect("ordo"), 45).add(Aspect.getAspect("perditio"), 45),
                "abc",
                "def",
                "ghi",
                'a',
                "wireGt02AnyCopper",
                'b',
                getModItem(Minecraft.ID, "diamond_helmet", 1, 0, missing),
                'c',
                "wireGt02AnyCopper",
                'd',
                "circuitBasic",
                'e',
                getModItem(Thaumcraft.ID, "ItemGoggles", 1, 0, missing),
                'f',
                "circuitBasic",
                'g',
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 10, missing),
                'h',
                getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, wildcard, missing),
                'i',
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 10, missing));
        TCHelper.addResearchPage(
                "ElectricGogglesofRevealing",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(ElectroMagicTools.ID, "ElectricGogglesRevealing", 1, 165, missing))));
        new ResearchItem(
                "NanosuitGogglesofRevealing",
                "EMT",
                new AspectList().add(Aspect.getAspect("tutamen"), 18).add(Aspect.getAspect("potentia"), 15)
                        .add(Aspect.getAspect("sensus"), 12).add(Aspect.getAspect("praecantatio"), 9)
                        .add(Aspect.getAspect("auram"), 6).add(Aspect.getAspect("electrum"), 3),
                -4,
                -2,
                3,
                getModItem(ElectroMagicTools.ID, "NanosuitGogglesRevealing", 1, 0, missing))
                        .setParents("ElectricGogglesofRevealing").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.NanosuitGogglesofRevealing"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "NanosuitGogglesofRevealing",
                getModItem(ElectroMagicTools.ID, "NanosuitGogglesRevealing", 1, 27, missing),
                6,
                new AspectList().add(Aspect.getAspect("tutamen"), 32).add(Aspect.getAspect("potentia"), 32)
                        .add(Aspect.getAspect("sensus"), 24).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("auram"), 8).add(Aspect.getAspect("electrum"), 8),
                getModItem(ElectroMagicTools.ID, "ElectricGogglesRevealing", 1, wildcard, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemArmorNanoHelmet", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        ItemList.Sensor_HV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                        ItemList.Sensor_HV.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartCircuitAdv", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt04, Materials.Electrum, 1L), });
        TCHelper.addResearchPage(
                "NanosuitGogglesofRevealing",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "NanosuitGogglesRevealing", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "QuantumGogglesRevealing", 1, 0, missing))
                        .setParents("NanosuitGogglesofRevealing").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.QuantumGogglesofRevealing"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "QuantumGogglesofRevealing",
                getModItem(ElectroMagicTools.ID, "QuantumGogglesRevealing", 1, 27, missing),
                9,
                new AspectList().add(Aspect.getAspect("tutamen"), 64).add(Aspect.getAspect("potentia"), 48)
                        .add(Aspect.getAspect("sensus"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("auram"), 16).add(Aspect.getAspect("electrum"), 16)
                        .add(Aspect.getAspect("lucrum"), 8),
                getModItem(ElectroMagicTools.ID, "NanosuitGogglesRevealing", 1, wildcard, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemArmorQuantumHelmet", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Titanium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L), ItemList.Circuit_Elite.get(1L),
                        ItemList.Sensor_EV.get(1L), getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing), ItemList.Sensor_EV.get(1L),
                        ItemList.Circuit_Elite.get(1L), GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt08, Materials.Titanium, 1L), });
        TCHelper.addResearchPage(
                "QuantumGogglesofRevealing",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "QuantumGogglesRevealing", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "SolarHelmetRevealing", 1, 0, missing))
                        .setParents("QuantumGogglesofRevealing", "CompressedSolars").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.SolarHelmetofRevealing")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SolarHelmetofRevealing",
                getModItem(ElectroMagicTools.ID, "SolarHelmetRevealing", 1, 27, missing),
                12,
                new AspectList().add(Aspect.getAspect("tutamen"), 64).add(Aspect.getAspect("potentia"), 48)
                        .add(Aspect.getAspect("sensus"), 32).add(Aspect.getAspect("praecantatio"), 24)
                        .add(Aspect.getAspect("auram"), 16).add(Aspect.getAspect("electrum"), 16)
                        .add(Aspect.getAspect("lucrum"), 8).add(Aspect.getAspect("aer"), 16)
                        .add(Aspect.getAspect("lux"), 32),
                getModItem(ElectroMagicTools.ID, "QuantumGogglesRevealing", 1, wildcard, missing),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt12, Materials.Osmium, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1L), ItemList.Sensor_IV.get(1L),
                        CustomItemList.MysteriousCrystal.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing),
                        CustomItemList.MysteriousCrystal.get(1L), ItemList.Sensor_IV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Naquadah, 1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt12, Materials.Osmium, 1L), });
        TCHelper.addResearchPage(
                "SolarHelmetofRevealing",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "SolarHelmetRevealing", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setPages(new ResearchPage("tc.research_page.CompressedSolars")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CompressedSolars",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("terra"), 50).add(Aspect.getAspect("ignis"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing),
                'b',
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing),
                'c',
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing),
                'd',
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing),
                'e',
                CustomItemList.ReinforcedAluminiumIronPlate.get(1L),
                'f',
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing),
                'g',
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing),
                'h',
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing),
                'i',
                getModItem(IndustrialCraft2.ID, "blockGenerator", 1, 3, missing));
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CompressedSolars",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 100).add(Aspect.getAspect("aqua"), 100)
                        .add(Aspect.getAspect("terra"), 100).add(Aspect.getAspect("ignis"), 100)
                        .add(Aspect.getAspect("ordo"), 100).add(Aspect.getAspect("perditio"), 100),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing),
                'b',
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing),
                'c',
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing),
                'd',
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing),
                'e',
                CustomItemList.IrradiantReinforcedTitaniumPlate.get(1L),
                'f',
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing),
                'g',
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing),
                'h',
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing),
                'i',
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing));
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing),
                15,
                new AspectList().add(Aspect.getAspect("aer"), 150).add(Aspect.getAspect("aqua"), 150)
                        .add(Aspect.getAspect("terra"), 150).add(Aspect.getAspect("ignis"), 150)
                        .add(Aspect.getAspect("ordo"), 150).add(Aspect.getAspect("perditio"), 150),
                CustomItemList.IrradiantReinforcedTungstenSteelPlate.get(1L),
                new ItemStack[] { CustomItemList.IrradiantReinforcedTungstenSteelPlate.get(1L),
                        getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing),
                        CustomItemList.IrradiantReinforcedTungstenSteelPlate.get(1L),
                        getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing), });
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0, missing),
                20,
                new AspectList().add(Aspect.getAspect("aer"), 300).add(Aspect.getAspect("aqua"), 300)
                        .add(Aspect.getAspect("terra"), 300).add(Aspect.getAspect("ignis"), 300)
                        .add(Aspect.getAspect("ordo"), 300).add(Aspect.getAspect("perditio"), 300),
                CustomItemList.IrradiantReinforcedChromePlate.get(1L),
                new ItemStack[] { CustomItemList.IrradiantReinforcedChromePlate.get(1L),
                        getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing),
                        CustomItemList.IrradiantReinforcedChromePlate.get(1L),
                        getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing), });
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7, missing),
                20,
                new AspectList().add(Aspect.getAspect("aer"), 600).add(Aspect.getAspect("aqua"), 600)
                        .add(Aspect.getAspect("terra"), 600).add(Aspect.getAspect("ignis"), 600)
                        .add(Aspect.getAspect("ordo"), 600).add(Aspect.getAspect("perditio"), 600),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 8, missing),
                new ItemStack[] { getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 8, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0, missing),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 8, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0, missing), });
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14, missing),
                20,
                new AspectList().add(Aspect.getAspect("aer"), 1200).add(Aspect.getAspect("aqua"), 1200)
                        .add(Aspect.getAspect("terra"), 1200).add(Aspect.getAspect("ignis"), 1200)
                        .add(Aspect.getAspect("ordo"), 1200).add(Aspect.getAspect("perditio"), 1200),
                CustomItemList.IrradiantReinforcedNaquadriaPlate.get(1L),
                new ItemStack[] { CustomItemList.IrradiantReinforcedNaquadriaPlate.get(1L),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7, missing),
                        CustomItemList.IrradiantReinforcedNaquadriaPlate.get(1L),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7, missing), });
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5, missing),
                20,
                new AspectList().add(Aspect.getAspect("aer"), 2400).add(Aspect.getAspect("aqua"), 2400)
                        .add(Aspect.getAspect("terra"), 2400).add(Aspect.getAspect("ignis"), 2400)
                        .add(Aspect.getAspect("ordo"), 2400).add(Aspect.getAspect("perditio"), 2400),
                CustomItemList.IrradiantReinforcedNeutroniumPlate.get(1L),
                new ItemStack[] { CustomItemList.IrradiantReinforcedNeutroniumPlate.get(1L),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14, missing),
                        CustomItemList.IrradiantReinforcedNeutroniumPlate.get(1L),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14, missing), });
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 12, missing),
                20,
                new AspectList().add(Aspect.getAspect("aer"), 4800).add(Aspect.getAspect("aqua"), 4800)
                        .add(Aspect.getAspect("terra"), 4800).add(Aspect.getAspect("ignis"), 4800)
                        .add(Aspect.getAspect("ordo"), 4800).add(Aspect.getAspect("perditio"), 4800),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 13, missing),
                new ItemStack[] { getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 13, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5, missing),
                        getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 13, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5, missing),
                        getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5, missing), });
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 12, missing))));
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
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 3, missing)).setParents("CompressedSolars")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.WaterInfusedSolarPanels"))
                        .registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 3, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 32).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("lux"), 16));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 3, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 4, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 64).add(Aspect.getAspect("permutatio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("lux"), 32));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 4, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 5, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 128).add(Aspect.getAspect("permutatio"), 128)
                        .add(Aspect.getAspect("praecantatio"), 128).add(Aspect.getAspect("lux"), 64));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 5, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 5, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 256).add(Aspect.getAspect("permutatio"), 256)
                        .add(Aspect.getAspect("praecantatio"), 256).add(Aspect.getAspect("lux"), 128));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 5, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 12, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 512).add(Aspect.getAspect("permutatio"), 512)
                        .add(Aspect.getAspect("praecantatio"), 512).add(Aspect.getAspect("lux"), 256));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 12, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 3, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 1024).add(Aspect.getAspect("permutatio"), 1024)
                        .add(Aspect.getAspect("praecantatio"), 1024).add(Aspect.getAspect("lux"), 512));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 3, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 10, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 2048).add(Aspect.getAspect("permutatio"), 2048)
                        .add(Aspect.getAspect("praecantatio"), 2048).add(Aspect.getAspect("lux"), 1024));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 10, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars5", 1, 1, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("aqua"), 4096).add(Aspect.getAspect("permutatio"), 4096)
                        .add(Aspect.getAspect("praecantatio"), 4096).add(Aspect.getAspect("lux"), 2048));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars5", 1, 1, missing))));
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
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 6, missing)).setParents("CompressedSolars")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.EntropyInfusedSolarPanels"))
                        .registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 6, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 32).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("lux"), 16));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 6, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 7, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 64).add(Aspect.getAspect("permutatio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("lux"), 32));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 7, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 8, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 128).add(Aspect.getAspect("permutatio"), 128)
                        .add(Aspect.getAspect("praecantatio"), 128).add(Aspect.getAspect("lux"), 64));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 8, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 2, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 256).add(Aspect.getAspect("permutatio"), 256)
                        .add(Aspect.getAspect("praecantatio"), 256).add(Aspect.getAspect("lux"), 128));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 2, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 9, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 512).add(Aspect.getAspect("permutatio"), 512)
                        .add(Aspect.getAspect("praecantatio"), 512).add(Aspect.getAspect("lux"), 256));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 9, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 0, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 1024).add(Aspect.getAspect("permutatio"), 1024)
                        .add(Aspect.getAspect("praecantatio"), 1024).add(Aspect.getAspect("lux"), 512));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 0, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 7, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 2048).add(Aspect.getAspect("permutatio"), 2048)
                        .add(Aspect.getAspect("praecantatio"), 2048).add(Aspect.getAspect("lux"), 1024));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 7, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 14, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("perditio"), 4096).add(Aspect.getAspect("permutatio"), 4096)
                        .add(Aspect.getAspect("praecantatio"), 4096).add(Aspect.getAspect("lux"), 2048));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 14, missing))));
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
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 9, missing)).setParents("CompressedSolars")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.OrderInfusedSolarPanels"))
                        .registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 9, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 32).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("lux"), 16));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 9, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 10, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 64).add(Aspect.getAspect("permutatio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("lux"), 32));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 10, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 11, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 128).add(Aspect.getAspect("permutatio"), 128)
                        .add(Aspect.getAspect("praecantatio"), 128).add(Aspect.getAspect("lux"), 64));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 11, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 1, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 256).add(Aspect.getAspect("permutatio"), 256)
                        .add(Aspect.getAspect("praecantatio"), 256).add(Aspect.getAspect("lux"), 128));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 1, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 8, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 512).add(Aspect.getAspect("permutatio"), 512)
                        .add(Aspect.getAspect("praecantatio"), 512).add(Aspect.getAspect("lux"), 256));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 8, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 15, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 1024).add(Aspect.getAspect("permutatio"), 1024)
                        .add(Aspect.getAspect("praecantatio"), 1024).add(Aspect.getAspect("lux"), 512));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 15, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 6, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 2048).add(Aspect.getAspect("permutatio"), 2048)
                        .add(Aspect.getAspect("praecantatio"), 2048).add(Aspect.getAspect("lux"), 1024));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 6, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 13, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("ordo"), 4096).add(Aspect.getAspect("permutatio"), 4096)
                        .add(Aspect.getAspect("praecantatio"), 4096).add(Aspect.getAspect("lux"), 2048));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 13, missing))));
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
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 12, missing)).setParents("CompressedSolars")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.FireInfusedSolarPanels"))
                        .registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 12, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 32).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("lux"), 16));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 12, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 13, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("permutatio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("lux"), 32));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 13, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 14, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 128).add(Aspect.getAspect("permutatio"), 128)
                        .add(Aspect.getAspect("praecantatio"), 128).add(Aspect.getAspect("lux"), 64));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 14, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 6, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 256).add(Aspect.getAspect("permutatio"), 256)
                        .add(Aspect.getAspect("praecantatio"), 256).add(Aspect.getAspect("lux"), 128));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 6, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 13, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 512).add(Aspect.getAspect("permutatio"), 512)
                        .add(Aspect.getAspect("praecantatio"), 512).add(Aspect.getAspect("lux"), 256));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 13, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 4, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 1024).add(Aspect.getAspect("permutatio"), 1024)
                        .add(Aspect.getAspect("praecantatio"), 1024).add(Aspect.getAspect("lux"), 512));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 4, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 11, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 2048).add(Aspect.getAspect("permutatio"), 2048)
                        .add(Aspect.getAspect("praecantatio"), 2048).add(Aspect.getAspect("lux"), 1024));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 11, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars5", 1, 2, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 4096).add(Aspect.getAspect("permutatio"), 4096)
                        .add(Aspect.getAspect("praecantatio"), 4096).add(Aspect.getAspect("lux"), 2048));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars5", 1, 2, missing))));
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
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 15, missing)).setParents("CompressedSolars")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.AirInfusedSolarPanels"))
                        .registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 15, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("lux"), 16));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 15, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 0, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("aer"), 64).add(Aspect.getAspect("permutatio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("lux"), 32));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 0, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 1, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("aer"), 128).add(Aspect.getAspect("permutatio"), 128)
                        .add(Aspect.getAspect("praecantatio"), 128).add(Aspect.getAspect("lux"), 64));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 1, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 3, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 256).add(Aspect.getAspect("permutatio"), 256)
                        .add(Aspect.getAspect("praecantatio"), 256).add(Aspect.getAspect("lux"), 128));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 3, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 10, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("aer"), 512).add(Aspect.getAspect("permutatio"), 512)
                        .add(Aspect.getAspect("praecantatio"), 512).add(Aspect.getAspect("lux"), 256));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 10, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 1, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("aer"), 1024).add(Aspect.getAspect("permutatio"), 1024)
                        .add(Aspect.getAspect("praecantatio"), 1024).add(Aspect.getAspect("lux"), 512));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 1, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 8, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("aer"), 2048).add(Aspect.getAspect("permutatio"), 2048)
                        .add(Aspect.getAspect("praecantatio"), 2048).add(Aspect.getAspect("lux"), 1024));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 8, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 15, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("aer"), 4096).add(Aspect.getAspect("permutatio"), 4096)
                        .add(Aspect.getAspect("praecantatio"), 4096).add(Aspect.getAspect("lux"), 2048));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 15, missing))));
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
                getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 2, missing)).setParents("CompressedSolars")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.EarthInfusedSolarPanels"))
                        .registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 2, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("lux"), 16));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 2, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 3, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1, missing),
                new AspectList().add(Aspect.getAspect("terra"), 64).add(Aspect.getAspect("permutatio"), 64)
                        .add(Aspect.getAspect("praecantatio"), 64).add(Aspect.getAspect("lux"), 32));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 3, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 4, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2, missing),
                new AspectList().add(Aspect.getAspect("terra"), 128).add(Aspect.getAspect("permutatio"), 128)
                        .add(Aspect.getAspect("praecantatio"), 128).add(Aspect.getAspect("lux"), 64));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 4, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 4, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 256).add(Aspect.getAspect("permutatio"), 256)
                        .add(Aspect.getAspect("praecantatio"), 256).add(Aspect.getAspect("lux"), 128));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 4, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 11, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7, missing),
                new AspectList().add(Aspect.getAspect("terra"), 512).add(Aspect.getAspect("permutatio"), 512)
                        .add(Aspect.getAspect("praecantatio"), 512).add(Aspect.getAspect("lux"), 256));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 11, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 2, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14, missing),
                new AspectList().add(Aspect.getAspect("terra"), 1024).add(Aspect.getAspect("permutatio"), 1024)
                        .add(Aspect.getAspect("praecantatio"), 1024).add(Aspect.getAspect("lux"), 512));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 2, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 9, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5, missing),
                new AspectList().add(Aspect.getAspect("terra"), 2048).add(Aspect.getAspect("permutatio"), 2048)
                        .add(Aspect.getAspect("praecantatio"), 2048).add(Aspect.getAspect("lux"), 1024));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 9, missing))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars5", 1, 0, missing),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 12, missing),
                new AspectList().add(Aspect.getAspect("terra"), 4096).add(Aspect.getAspect("permutatio"), 4096)
                        .add(Aspect.getAspect("praecantatio"), 4096).add(Aspect.getAspect("lux"), 2048));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars5", 1, 0, missing))));
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
                getModItem(ElectroMagicTools.ID, "ElectricHoeGrowth", 1, 0, missing))
                        .setParents("ELEMENTALHOE", "ElectricMagicTools").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.ElectricHoeofGrowth")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ElectricHoeofGrowth",
                getModItem(ElectroMagicTools.ID, "ElectricHoeGrowth", 1, 1561, missing),
                8,
                new AspectList().add(Aspect.getAspect("potentia"), 32).add(Aspect.getAspect("messis"), 32)
                        .add(Aspect.getAspect("praecantatio"), 48).add(Aspect.getAspect("herba"), 16)
                        .add(Aspect.getAspect("electrum"), 8),
                getModItem(Thaumcraft.ID, "ItemHoeElemental", 1, 0, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemToolHoe", 1, wildcard, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        ItemList.Circuit_Master.get(1L),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0, missing),
                        ItemList.Circuit_Master.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing), });
        TCHelper.addResearchPage(
                "ElectricHoeofGrowth",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "ElectricHoeGrowth", 1, 1561, missing))));
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
                getModItem(ElectroMagicTools.ID, "ElectricScribingTools", 1, 0, missing))
                        .setParentsHidden("ElectricMagicTools").setParents("RESEARCH").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.ElectricScribingTools")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ElectricScribingTools",
                getModItem(ElectroMagicTools.ID, "ElectricScribingTools", 1, 400, missing),
                new AspectList().add(Aspect.getAspect("aer"), 20).add(Aspect.getAspect("ignis"), 20)
                        .add(Aspect.getAspect("aqua"), 20).add(Aspect.getAspect("ordo"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitAdvanced",
                'b',
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0, missing),
                'c',
                "circuitAdvanced",
                'd',
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0, missing),
                'e',
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                'f',
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0, missing),
                'g',
                "circuitAdvanced",
                'h',
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0, missing),
                'i',
                "circuitAdvanced");
        TCHelper.addResearchPage(
                "ElectricScribingTools",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(ElectroMagicTools.ID, "ElectricScribingTools", 1, 400, missing))));
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
                getModItem(ElectroMagicTools.ID, "Mjolnir", 1, 0, missing)).setParents("The Legend")
                        .setParentsHidden("ElectricMagicTools").registerResearchItem();
        TCHelper.addResearchPrereq("Mjolnirnew", "ELEMENTALSWORD", false);
        TCHelper.addResearchPrereq("Mjolnirnew", "FOCUSSHOCK", false);
        TCHelper.addResearchPrereq("Mjolnirnew", "NITOR", false);
        ResearchCategories.getResearch("Mjolnirnew").setConcealed();
        ResearchCategories.getResearch("Mjolnirnew").setRound();
        TCHelper.addResearchPage("Mjolnirnew", new ResearchPage("tc.research_page.Mjolnirnew"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "Mjolnirnew",
                getModItem(ElectroMagicTools.ID, "Mjolnir", 1, 0, missing),
                10,
                new AspectList().add(Aspect.getAspect("telum"), 48).add(Aspect.getAspect("tempestas"), 48)
                        .add(Aspect.getAspect("alienis"), 32).add(Aspect.getAspect("ira"), 24)
                        .add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("ignis"), 16),
                getModItem(ElectroMagicTools.ID, "TaintedMjolnir", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemSwordElemental", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 1),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 6, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 1),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                        getModItem(Thaumcraft.ID, "FocusShock", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 1),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Rubber, 1), });
        TCHelper.addResearchPage(
                "Mjolnirnew",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "Mjolnir", 1, 0, missing))));
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
                getModItem(ElectroMagicTools.ID, "SuperchargedMjolnir", 1, 0, missing))
                        .setParents("Mjolnirnew", "FOCUSHELLBAT", "ALUMENTUM").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.SuperchargedMjolnir")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "SuperchargedMjolnir",
                getModItem(ElectroMagicTools.ID, "SuperchargedMjolnir", 1, 27, missing),
                15,
                new AspectList().add(Aspect.getAspect("telum"), 64).add(Aspect.getAspect("potentia"), 64)
                        .add(Aspect.getAspect("alienis"), 48).add(Aspect.getAspect("ira"), 32)
                        .add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("ignis"), 24)
                        .add(Aspect.getAspect("bestia"), 16),
                getModItem(ElectroMagicTools.ID, "Mjolnir", 1, 0, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemNanoSaber", 1, wildcard, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing),
                        getModItem(Thaumcraft.ID, "FocusHellbat", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing), });
        TCHelper.addResearchPage(
                "SuperchargedMjolnir",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "SuperchargedMjolnir", 1, 27, missing))));
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
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 6, missing))
                        .setParents("FOCUSSHOCK", "NITOR", "ALUMENTUM").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.LightningSummoner")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "LightningSummoner",
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 6, missing),
                9,
                new AspectList().add(Aspect.getAspect("tempestas"), 16).add(Aspect.getAspect("aer"), 24)
                        .add(Aspect.getAspect("ignis"), 16).add(Aspect.getAspect("nebrisum"), 8)
                        .add(Aspect.getAspect("permutatio"), 8),
                getModItem(Thaumcraft.ID, "FocusShock", 1, 0, missing),
                new ItemStack[] { getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                        getModItem(Minecraft.ID, "skull", 1, 4, missing),
                        getModItem(Minecraft.ID, "tnt", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 0, missing),
                        getModItem(Minecraft.ID, "skull", 1, 4, missing),
                        getModItem(Minecraft.ID, "tnt", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                        getModItem(Minecraft.ID, "skull", 1, 4, missing),
                        getModItem(Minecraft.ID, "tnt", 1, 0, missing), });
        TCHelper.addResearchPage(
                "LightningSummoner",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 6, missing))));
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
                ItemList.IC2_Uranium_235_Small.get(1)).setParentsHidden("ElectricMagicTools").setParents("RESEARCH")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.TinyUranium"))
                        .registerResearchItem();
        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "TinyUranium",
                ItemList.IC2_Uranium_235_Small.get(7),
                new AspectList().add(Aspect.getAspect("aer"), 7).add(Aspect.getAspect("ignis"), 7)
                        .add(Aspect.getAspect("aqua"), 7).add(Aspect.getAspect("terra"), 7)
                        .add(Aspect.getAspect("ordo"), 7).add(Aspect.getAspect("perditio"), 7),
                ItemList.IC2_Uranium_238.get(1));
        TCHelper.addResearchPage(
                "TinyUranium",
                new ResearchPage(TCHelper.findArcaneRecipe(ItemList.IC2_Uranium_235_Small.get(1))));
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
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing)).setParentsHidden("ElectricMagicTools")
                        .setRound().setPages(new ResearchPage("tc.research_page.UUMatterInfusion"))
                        .registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "UUMatterInfusion",
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 3, missing),
                new AspectList().add(Aspect.getAspect("vitreus"), 16).add(Aspect.getAspect("gelum"), 8)
                        .add(Aspect.getAspect("praecantatio"), 8).add(Aspect.getAspect("permutatio"), 8));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem(Minecraft.ID, "coal", 16, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                getModItem(Minecraft.ID, "coal", 1, 1, missing),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Minecraft.ID, "coal", 1, 0, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem(Minecraft.ID, "glowstone", 1, 0, missing),
                3,
                new AspectList().add(Aspect.getAspect("aer"), 4).add(Aspect.getAspect("aqua"), 4)
                        .add(Aspect.getAspect("terra"), 4).add(Aspect.getAspect("ignis"), 4)
                        .add(Aspect.getAspect("perditio"), 4).add(Aspect.getAspect("ordo"), 8),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0, missing),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Minecraft.ID, "glowstone", 1, 0, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Iron, 32L),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Iron, 1L))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Copper, 32L),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Copper, 1L))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Tin, 32L),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 1L),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Tin, 1L))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Gold, 32L),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                getModItem(Minecraft.ID, "gold_ingot", 1, 0, missing),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Gold, 1L))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Uranium, 32L),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                ItemList.IC2_Uranium_238.get(1),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Uranium, 1L))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Silver, 32L),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Silver, 1L),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Silver, 1L))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Lead, 32L),
                6,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                GTOreDictUnificator.get(OrePrefixes.ingot, Materials.Lead, 1L),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Lead, 1L))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Redstone, 24L),
                9,
                new AspectList().add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("terra"), 24).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("perditio"), 12).add(Aspect.getAspect("ordo"), 24),
                getModItem(Minecraft.ID, "redstone", 1, 0, missing),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Redstone, 1L))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Lapis, 24L),
                9,
                new AspectList().add(Aspect.getAspect("aer"), 12).add(Aspect.getAspect("aqua"), 12)
                        .add(Aspect.getAspect("terra"), 24).add(Aspect.getAspect("ignis"), 12)
                        .add(Aspect.getAspect("perditio"), 12).add(Aspect.getAspect("ordo"), 24),
                getModItem(Minecraft.ID, "dye", 1, 4, missing),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Lapis, 1L))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem(Minecraft.ID, "gold_ingot", 2, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("aer"), 8).add(Aspect.getAspect("aqua"), 8)
                        .add(Aspect.getAspect("terra"), 16).add(Aspect.getAspect("ignis"), 8)
                        .add(Aspect.getAspect("perditio"), 8).add(Aspect.getAspect("ordo"), 16),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0, missing),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Minecraft.ID, "gold_ingot", 1, 0, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem(Minecraft.ID, "diamond", 1, 0, missing),
                12,
                new AspectList().add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("aqua"), 16)
                        .add(Aspect.getAspect("terra"), 32).add(Aspect.getAspect("ignis"), 16)
                        .add(Aspect.getAspect("perditio"), 16).add(Aspect.getAspect("ordo"), 32),
                getModItem(Minecraft.ID, "gold_ingot", 1, 0, missing),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Minecraft.ID, "diamond", 1, 0, missing))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                ItemList.IC2_Uranium_238.get(2),
                15,
                new AspectList().add(Aspect.getAspect("aer"), 24).add(Aspect.getAspect("aqua"), 24)
                        .add(Aspect.getAspect("terra"), 48).add(Aspect.getAspect("ignis"), 24)
                        .add(Aspect.getAspect("perditio"), 24).add(Aspect.getAspect("ordo"), 48),
                getModItem(Minecraft.ID, "diamond", 1, 0, missing),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(ItemList.IC2_Uranium_238.get(1))));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem(IndustrialCraft2.ID, "itemOreIridium", 2, 0, missing),
                18,
                new AspectList().add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("aqua"), 32)
                        .add(Aspect.getAspect("terra"), 64).add(Aspect.getAspect("ignis"), 32)
                        .add(Aspect.getAspect("perditio"), 32).add(Aspect.getAspect("ordo"), 64),
                ItemList.IC2_Uranium_238.get(1),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15, missing), });
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(IndustrialCraft2.ID, "itemOreIridium", 1, 0, missing))));
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
                getModItem(ElectroMagicTools.ID, "PortableNode", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setRound()
                        .setPages(
                                new ResearchPage("tc.research_page.PortableNode"),
                                new ResearchPage(
                                        TCHelper.findCrucibleRecipe(
                                                getModItem(ElectroMagicTools.ID, "PortableNode", 1, 0, missing))))
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
                getModItem(ElectroMagicTools.ID, "ShieldFocus", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("FOCUSPORTABLEHOLE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ShieldFocus")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ShieldFocus",
                getModItem(ElectroMagicTools.ID, "ShieldFocus", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("aer"), 32).add(Aspect.getAspect("tutamen"), 40)
                        .add(Aspect.getAspect("victus"), 16).add(Aspect.getAspect("vinculum"), 24)
                        .add(Aspect.getAspect("vitreus"), 16).add(Aspect.getAspect("praecantatio"), 8),
                getModItem(Thaumcraft.ID, "FocusPortableHole", 1, 0, missing),
                new ItemStack[] { GTOreDictUnificator.get(OrePrefixes.plate, Materials.ReinforceGlass, 1),
                        ItemList.Block_TungstenSteelReinforced.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Reinforced, 1L),
                        ItemList.Block_TungstenSteelReinforced.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.ReinforceGlass, 1),
                        ItemList.Block_TungstenSteelReinforced.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Reinforced, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                        ItemList.Block_TungstenSteelReinforced.get(1L), });
        TCHelper.addResearchPage(
                "ShieldFocus",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "ShieldFocus", 1, 0, missing))));
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
                getModItem(ElectroMagicTools.ID, "ShieldBlock", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("ShieldFocus").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ShieldBlock")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ShieldBlock",
                getModItem(ElectroMagicTools.ID, "ShieldBlock", 10, 0, missing),
                new AspectList().add(Aspect.getAspect("terra"), 20).add(Aspect.getAspect("ordo"), 20)
                        .add(Aspect.getAspect("perditio"), 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1, missing),
                'b',
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1, missing),
                'd',
                "plateReinforcedGlass",
                'e',
                ItemList.Block_IridiumTungstensteel.get(1L),
                'f',
                "plateReinforcedGlass",
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1, missing),
                'h',
                getModItem(IndustrialCraft2.ID, "itemPartAlloy", 1, 0, missing),
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1, missing));
        TCHelper.addResearchPage(
                "ShieldBlock",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "ShieldBlock", 1, 0, missing))));
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
                getModItem(ElectroMagicTools.ID, "ChristmasFocus", 1, 0, missing))
                        .setParentsHidden("ElectricMagicTools").setParents("FOCUSSHOCK").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.KristmasFocus")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "KristmasFocus",
                getModItem(ElectroMagicTools.ID, "ChristmasFocus", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 25).add(Aspect.getAspect("ordo"), 25)
                        .add(Aspect.getAspect("aqua"), 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "pumpkin", 1, 0, missing),
                'b',
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Snow, 1L),
                'c',
                getModItem(Minecraft.ID, "pumpkin", 1, 0, missing),
                'd',
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 1L),
                'e',
                getModItem(Thaumcraft.ID, "FocusFrost", 1, 0, missing),
                'f',
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 1L),
                'g',
                getModItem(Minecraft.ID, "pumpkin", 1, 0, missing),
                'h',
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Snow, 1L),
                'i',
                getModItem(Minecraft.ID, "pumpkin", 1, 0, missing));
        TCHelper.addResearchPage(
                "KristmasFocus",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "ChristmasFocus", 1, 0, missing))));
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
                getModItem(ElectroMagicTools.ID, "EnergyBallFocus", 1, 0, missing))
                        .setParentsHidden("ElectricMagicTools").setParents("FOCUSSHOCK").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.EnergyBallFocus")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "EnergyBallFocus",
                getModItem(ElectroMagicTools.ID, "EnergyBallFocus", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("potentia"), 24).add(Aspect.getAspect("praecantatio"), 30)
                        .add(Aspect.getAspect("victus"), 12).add(Aspect.getAspect("cognitio"), 6),
                getModItem(Thaumcraft.ID, "FocusShock", 1, 0, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 1, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Silver, 1L),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Silver, 1L),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Silver, 1L),
                        getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt02, Materials.Silver, 1L), });
        TCHelper.addResearchPage(
                "EnergyBallFocus",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "EnergyBallFocus", 1, 0, missing))));
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
                getModItem(ElectroMagicTools.ID, "ExplosionFocus", 1, 0, missing))
                        .setParentsHidden("ElectricMagicTools").setParents("FOCUSHELLBAT").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ExplosionFocus")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "ExplosionFocus",
                getModItem(ElectroMagicTools.ID, "ExplosionFocus", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("ignis"), 64).add(Aspect.getAspect("mortuus"), 24)
                        .add(Aspect.getAspect("motus"), 48).add(Aspect.getAspect("telum"), 32)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("potentia"), 10),
                getModItem(Thaumcraft.ID, "FocusHellbat", 1, 0, missing),
                new ItemStack[] { getModItem(IndustrialCraft2.ID, "itemToolMiningLaser", 1, wildcard, missing),
                        CustomItemList.ReinforcedGlassLense.get(1L),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 1, missing),
                        getModItem(Minecraft.ID, "firework_charge", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "PrimalArrow", 1, 1, missing), // Fire Arrow
                        getModItem(Minecraft.ID, "tnt", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "PrimalArrow", 1, 1, missing), // Fire Arrow
                        getModItem(Minecraft.ID, "firework_charge", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "ItemResource", 1, 0, missing),
                        CustomItemList.ReinforcedGlassLense.get(1L), });
        TCHelper.addResearchPage(
                "ExplosionFocus",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "ExplosionFocus", 1, 0, missing))));
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
                getModItem(ElectroMagicTools.ID, "ChargingFocus", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.WandFocusCharging"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "WandFocusCharging",
                getModItem(ElectroMagicTools.ID, "ChargingFocus", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("permutatio"), 48).add(Aspect.getAspect("potentia"), 24)
                        .add(Aspect.getAspect("machina"), 32).add(Aspect.getAspect("praecantatio"), 16)
                        .add(Aspect.getAspect("cognitio"), 8),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard, missing),
                new ItemStack[] { ItemList.Transformer_HV_MV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.rotor, Materials.Thaumium, 1L),
                        ItemList.Electric_Motor_MV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Thaumium, 1L),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.Silver, 1L),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Thaumium, 1L),
                        ItemList.Electric_Motor_MV.get(1L),
                        GTOreDictUnificator.get(OrePrefixes.rotor, Materials.Thaumium, 1L), });
        TCHelper.addResearchPage(
                "WandFocusCharging",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "ChargingFocus", 1, 0, missing))));
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
                getModItem(ElectroMagicTools.ID, "WandChargingFocus", 1, 0, missing))
                        .setParentsHidden("ElectricMagicTools").setParents("WandFocusCharging").registerResearchItem();
        TCHelper.addResearchPrereq("WandFocusWandCharging", "IndustrialWandChargingStation", true);
        ResearchCategories.getResearch("WandFocusWandCharging").setConcealed();
        TCHelper.addResearchPage("WandFocusWandCharging", new ResearchPage("tc.research_page.WandFocusWandCharging"));
        ThaumcraftApi.addInfusionCraftingRecipe(
                "WandFocusWandCharging",
                getModItem(ElectroMagicTools.ID, "WandChargingFocus", 1, 0, missing),
                15,
                new AspectList().add(Aspect.getAspect("potentia"), 48).add(Aspect.getAspect("fabrico"), 32)
                        .add(Aspect.getAspect("lucrum"), 64).add(Aspect.getAspect("permutatio"), 48)
                        .add(Aspect.getAspect("praecantatio"), 16).add(Aspect.getAspect("cognitio"), 8)
                        .add(Aspect.getAspect("auram"), 32),
                getModItem(ElectroMagicTools.ID, "ChargingFocus", 1, 0, missing),
                new ItemStack[] { getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.TungstenSteel, 1L),
                        getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard, missing),
                        GTOreDictUnificator.get(OrePrefixes.wireGt01, Materials.TungstenSteel, 1L),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Void, 1L),
                        GTOreDictUnificator.get(OrePrefixes.gearGtSmall, Materials.Void, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing), });
        TCHelper.addResearchPage(
                "WandFocusWandCharging",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "WandChargingFocus", 1, 0, missing))));
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
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0, missing))
                        .setParentsHidden("ElectricMagicTools").setParents("JARLABEL", "FOCUSTRADE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.PotentiaGenerator")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "PotentiaGenerator",
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0, missing),
                6,
                new AspectList().add(Aspect.getAspect("potentia"), 48).add(Aspect.getAspect("permutatio"), 32)
                        .add(Aspect.getAspect("machina"), 16).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("metallum"), 32),
                GregtechItemList.Generator_SemiFluid_LV.get(1),
                new ItemStack[] { getModItem(Thaumcraft.ID, "FocusTrade", 1, 0, missing), ItemList.Emitter_MV.get(1L),
                        getModItem(Minecraft.ID, "hopper", 1, 0, missing), ItemList.Electric_Motor_MV.get(1L),
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 7, missing),
                        ItemList.Transformer_HV_MV.get(1L), getModItem(Thaumcraft.ID, "blockJar", 1, 0, missing),
                        getModItem(IndustrialCraft2.ID, "blockMachine", 1, 12, missing),
                        getModItem(IndustrialCraft2.ID, "blockElectric", 1, 7, missing),
                        ItemList.Electric_Motor_MV.get(1L), getModItem(Minecraft.ID, "hopper", 1, 0, missing),
                        ItemList.Emitter_MV.get(1L), });
        TCHelper.addResearchPage(
                "PotentiaGenerator",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0, missing))));
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
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 1, missing))
                        .setParentsHidden("ElectricMagicTools").setParents("PotentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.IgnisGenerator")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "IgnisGenerator",
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 1, missing),
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("ignis"), 16).add(Aspect.getAspect("permutatio"), 8)
                        .add(Aspect.getAspect("praecantatio"), 8));
        TCHelper.addResearchPage(
                "IgnisGenerator",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(
                                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 1, missing))));
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
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 2, missing))
                        .setParentsHidden("ElectricMagicTools").setParents("PotentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.AuramGenerator")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "AuramGenerator",
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 2, missing),
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("auram"), 16).add(Aspect.getAspect("permutatio"), 8)
                        .add(Aspect.getAspect("praecantatio"), 8));
        TCHelper.addResearchPage(
                "AuramGenerator",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(
                                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 2, missing))));
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
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 3, missing))
                        .setParentsHidden("ElectricMagicTools").setParents("PotentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ArborGenerator")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "ArborGenerator",
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 3, missing),
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("arbor"), 16).add(Aspect.getAspect("permutatio"), 8)
                        .add(Aspect.getAspect("praecantatio"), 8));
        TCHelper.addResearchPage(
                "ArborGenerator",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(
                                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 3, missing))));
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
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 4, missing))
                        .setParentsHidden("ElectricMagicTools").setParents("PotentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.AerGenerator")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "AerGenerator",
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 4, missing),
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0, missing),
                new AspectList().add(Aspect.getAspect("aer"), 16).add(Aspect.getAspect("permutatio"), 8)
                        .add(Aspect.getAspect("praecantatio"), 8));
        TCHelper.addResearchPage(
                "AerGenerator",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(
                                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 4, missing))));
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
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 5, missing))
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
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 5, missing),
                10,
                new AspectList().add(Aspect.getAspect("permutatio"), 128).add(Aspect.getAspect("lucrum"), 256)
                        .add(Aspect.getAspect("praecantatio"), 32).add(Aspect.getAspect("nebrisum"), 16),
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0, missing),
                new ItemStack[] { getModItem(Minecraft.ID, "gold_block", 1, 0, missing),
                        getModItem(Minecraft.ID, "gold_block", 1, 0, missing),
                        getModItem(Minecraft.ID, "gold_block", 1, 0, missing),
                        getModItem(Minecraft.ID, "gold_block", 1, 0, missing),
                        getModItem(Minecraft.ID, "gold_block", 1, 0, missing),
                        getModItem(Minecraft.ID, "gold_block", 1, 0, missing),
                        getModItem(Minecraft.ID, "gold_block", 1, 0, missing),
                        getModItem(Minecraft.ID, "gold_block", 1, 0, missing),
                        getModItem(Minecraft.ID, "gold_block", 1, 0, missing),
                        getModItem(Minecraft.ID, "gold_block", 1, 0, missing),
                        getModItem(Minecraft.ID, "gold_block", 1, 0, missing),
                        getModItem(Minecraft.ID, "gold_block", 1, 0, missing), });
        TCHelper.addResearchPage(
                "LucrumGenerator",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 5, missing))));
        ThaumcraftApi.addWarpToResearch("LucrumGenerator", 5);
        new ResearchItem(
                "IndustrialWandChargingStation",
                "EMT",
                new AspectList().add(Aspect.getAspect("permutatio"), 15).add(Aspect.getAspect("potentia"), 12)
                        .add(Aspect.getAspect("fabrico"), 9).add(Aspect.getAspect("praecantatio"), 6)
                        .add(Aspect.getAspect("lucrum"), 3),
                -6,
                2,
                3,
                getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 0, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("PotentiaGenerator", "WANDPED", "JARLABEL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.IndustrialWandChargingStation"))
                        .registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "IndustrialWandChargingStation",
                getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 0, missing),
                9,
                new AspectList().add(Aspect.getAspect("permutatio"), 48).add(Aspect.getAspect("potentia"), 48)
                        .add(Aspect.getAspect("fabrico"), 48).add(Aspect.getAspect("praecantatio"), 32)
                        .add(Aspect.getAspect("lucrum"), 64).add(Aspect.getAspect("cognitio"), 16),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 5, missing),
                new ItemStack[] { ItemList.Machine_IV_Replicator.get(1L),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Diamond, 1L),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing),
                        getModItem(Thaumcraft.ID, "blockJar", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockCrystal", 1, 6, missing),
                        GTOreDictUnificator.get(OrePrefixes.gemExquisite, Materials.Diamond, 1L),
                        getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0, missing), });
        TCHelper.addResearchPage(
                "IndustrialWandChargingStation",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 0, missing))));
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
                getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 1, missing)).setParentsHidden("ElectricMagicTools")
                        .setParents("BELLOWS", "DISTILESSENTIA", "INFERNALFURNACE", "PotentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.EtheralProcessor")).registerResearchItem();
        ThaumcraftApi.addInfusionCraftingRecipe(
                "EtheralProcessor",
                getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 1, missing),
                9,
                new AspectList().add(Aspect.getAspect("machina"), 16).add(Aspect.getAspect("fabrico"), 16)
                        .add(Aspect.getAspect("potentia"), 24).add(Aspect.getAspect("praecantatio"), 28)
                        .add(Aspect.getAspect("cognitio"), 8),
                ItemList.Machine_MV_Macerator.get(1L),
                new ItemStack[] { ItemList.Machine_MV_E_Furnace.get(1L),
                        getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 0, missing),
                        getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 0, missing),
                        GTOreDictUnificator.get(OrePrefixes.plate, Materials.Thaumium, 1L),
                        getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9, missing), });
        TCHelper.addResearchPage(
                "EtheralProcessor",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 1, missing))));
        TCHelper.orphanResearch("ResearchCompleter");
        new ResearchItem(
                "ResearchCompleter",
                "EMT",
                new AspectList().add(Aspect.getAspect("cognitio"), 8).add(Aspect.getAspect("machina"), 5)
                        .add(Aspect.getAspect("permutatio"), 5).add(Aspect.getAspect("auram"), 4),
                -2,
                6,
                1,
                ItemList.ResearchCompleter.get(1)).setParents("WANDPED", "WARDEDARCANA").setRound()
                        .setPages(new ResearchPage("tc.research_page.ResearchCompleter")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ResearchCompleter",
                ItemList.Casing_Magical.get(1L),
                new AspectList().add(Aspect.getAspect("ignis"), 8).add(Aspect.getAspect("aer"), 8)
                        .add(Aspect.getAspect("ordo"), 8),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
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
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14, missing),
                'i',
                "plateThaumium");
        TCHelper.addResearchPage(
                "ResearchCompleter",
                new ResearchPage(TCHelper.findArcaneRecipe(ItemList.Casing_Magical.get(1L))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ResearchCompleter",
                ItemList.ResearchCompleter.get(1),
                new AspectList().add(Aspect.getAspect("aer"), 50).add(Aspect.getAspect("terra"), 50)
                        .add(Aspect.getAspect("ignis"), 50).add(Aspect.getAspect("aqua"), 50)
                        .add(Aspect.getAspect("ordo"), 50).add(Aspect.getAspect("perditio"), 50),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitGood",
                'b',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'c',
                "circuitGood",
                'd',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'e',
                ItemList.Casing_Magical.get(1L),
                'f',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2, missing),
                'g',
                "circuitGood",
                'h',
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 5, missing),
                'i',
                "circuitGood");
        TCHelper.addResearchPage(
                "ResearchCompleter",
                new ResearchPage(TCHelper.findArcaneRecipe(ItemList.ResearchCompleter.get(1))));
    }
}
