package com.dreammaster.scripts;

import static com.dreammaster.scripts.IngredientFactory.createItemStack;
import static com.dreammaster.scripts.IngredientFactory.getModItem;
import static gregtech.api.enums.Materials.Diamond;
import static gregtech.api.enums.Materials.HV;
import static gregtech.api.enums.Materials.IV;
import static gregtech.api.enums.Materials.Thaumium;
import static gregtech.api.enums.Materials.Titanium;
import static gregtech.api.enums.Materials.TungstenSteel;
import static gregtech.api.enums.Mods.AdvancedSolarPanel;
import static gregtech.api.enums.Mods.Avaritia;
import static gregtech.api.enums.Mods.ElectroMagicTools;
import static gregtech.api.enums.Mods.ForbiddenMagic;
import static gregtech.api.enums.Mods.GalacticraftCore;
import static gregtech.api.enums.Mods.GregTech;
import static gregtech.api.enums.Mods.IndustrialCraft2;
import static gregtech.api.enums.Mods.Minecraft;
import static gregtech.api.enums.Mods.ProjectRedIntegration;
import static gregtech.api.enums.Mods.Railcraft;
import static gregtech.api.enums.Mods.Thaumcraft;
import static gregtech.api.enums.Mods.ThaumicEnergistics;
import static gregtech.api.enums.Mods.TinkerConstruct;
import static gregtech.api.enums.OrePrefixes.circuit;
import static gregtech.api.enums.OrePrefixes.plate;
import static gregtech.api.enums.OrePrefixes.screw;
import static gregtech.api.recipe.RecipeMaps.alloySmelterRecipes;
import static gregtech.api.recipe.RecipeMaps.assemblerRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidExtractionRecipes;
import static gregtech.api.recipe.RecipeMaps.fluidSolidifierRecipes;
import static gregtech.api.recipe.RecipeMaps.formingPressRecipes;
import static gregtech.api.recipe.RecipeMaps.maceratorRecipes;
import static gregtech.api.util.GTRecipeBuilder.SECONDS;

import java.util.Arrays;
import java.util.List;

import net.minecraftforge.fluids.FluidRegistry;

import com.dreammaster.item.NHItemList;
import com.dreammaster.thaumcraft.TCHelper;

import fox.spiteful.forbidden.DarkAspects;
import gregtech.api.enums.GTValues;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.TCAspects;
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
                AdvancedSolarPanel.ID,
                Avaritia.ID,
                ElectroMagicTools.ID,
                ForbiddenMagic.ID,
                GalacticraftCore.ID,
                IndustrialCraft2.ID,
                ProjectRedIntegration.ID,
                Railcraft.ID,
                Thaumcraft.ID,
                ThaumicEnergistics.ID,
                TinkerConstruct.ID);
    }

    @Override
    public void loadRecipes() {

        addShapelessRecipe(
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8),
                getModItem(TinkerConstruct.ID, "materials", 1, 36),
                getModItem(TinkerConstruct.ID, "materials", 1, 36));
        addShapelessRecipe(
                getModItem(TinkerConstruct.ID, "materials", 2, 36),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8));

        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 4L),
                        ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 10)).duration(10 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(alloySmelterRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 12, 0),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 4, 10))
                .itemOutputs(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 9))
                .fluidInputs(FluidRegistry.getFluidStack("glue", 6912)).duration(30 * SECONDS).eut(TierEU.RECIPE_LV)
                .addTo(assemblerRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        getModItem(Minecraft.ID, "paper", 12, 0),
                        getModItem(ElectroMagicTools.ID, "EMTItems", 4, 10))
                .itemOutputs(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 9))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 6912)).duration(30 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(assemblerRecipes);
        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8))
                .fluidInputs(FluidRegistry.getFluidStack("refinedglue", 288)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(fluidSolidifierRecipes);
        GTValues.RA.stdBuilder().itemInputs(ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 10))
                .fluidInputs(FluidRegistry.getFluidStack("molten.rubber", 576)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(fluidSolidifierRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8))
                .fluidOutputs(FluidRegistry.getFluidStack("refinedglue", 288)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV / 2).addTo(fluidExtractionRecipes);
        GTValues.RA.stdBuilder()
                .itemInputs(
                        GTOreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 4L),
                        ItemList.Shape_Mold_Ball.get(0L))
                .itemOutputs(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 10)).duration(5 * SECONDS)
                .eut(TierEU.RECIPE_LV).addTo(formingPressRecipes);
        GTValues.RA.stdBuilder().itemInputs(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 10))
                .itemOutputs(GTOreDictUnificator.get(OrePrefixes.dust, Materials.Rubber, 4L)).outputChances(10000)
                .duration(15 * SECONDS).eut(2).addTo(maceratorRecipes);

        TCHelper.removeArcaneRecipe(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 14));
        TCHelper.removeArcaneRecipe(getModItem(ElectroMagicTools.ID, "ThaumiumWing", 1, 0));
        TCHelper.removeInfusionRecipe(createItemStack(ElectroMagicTools.ID, "NanosuitWing", 1, 26, "{charge:10.0d}"));
        TCHelper.removeInfusionRecipe(createItemStack(ElectroMagicTools.ID, "QuantumWing", 1, 26, "{charge:10.0d}"));
        TCHelper.removeArcaneRecipe(createItemStack(ElectroMagicTools.ID, "Diamond Omnitool", 1, 26, "{charge:10.0d}"));
        TCHelper.removeArcaneRecipe(getModItem(ElectroMagicTools.ID, "Diamond Omnitool", 1, 0));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "ThaumiumOmnitool", 1, 26, "{charge:10.0d}"));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "ThaumiumOmnitool", 1, 0));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "ElectricBootsTraveller", 1, 26, "{charge:10.0d}"));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "NanoBootsTraveller", 1, 26, "{charge:10.0d}"));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "QuantumBootsTraveller", 1, 26, "{charge:10.0d}"));
        TCHelper.removeInfusionRecipe(createItemStack(ElectroMagicTools.ID, "ThaumiumDrill", 1, 26, "{charge:10.0d}"));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "DrillRockbreaker", 1, 26, "{charge:10.0d}"));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "ThaumiumChainsaw", 1, 26, "{charge:10.0d}"));
        TCHelper.removeInfusionRecipe(createItemStack(ElectroMagicTools.ID, "ChainsawStream", 1, 26, "{charge:10.0d}"));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTBaubles", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTBaubles", 1, 1));
        TCHelper.removeArcaneRecipe(
                createItemStack(ElectroMagicTools.ID, "ElectricGogglesRevealing", 1, 164, "{charge:10.0d}"));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "itemArmorQuantumChestplate", 1, 26, "{charge:10.0d}"));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "NanosuitGogglesRevealing", 1, 26, "{charge:10.0d}"));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "QuantumGogglesRevealing", 1, 26, "{charge:10.0d}"));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "SolarHelmetRevealing", 1, 26, "{charge:10.0d}"));
        TCHelper.removeArcaneRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0));
        TCHelper.removeArcaneRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 3));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 4));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 5));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 6));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 7));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 8));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 9));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 10));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 11));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 12));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 13));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 14));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 15));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 0));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 1));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 2));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 3));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 4));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "ElectricHoeGrowth", 1, 1560, "{charge:10.0d}"));
        TCHelper.removeArcaneRecipe(
                createItemStack(ElectroMagicTools.ID, "ElectricScribingTools", 1, 390, "{charge:10.0d}"));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "Mjolnir", 1, 0));
        TCHelper.removeInfusionRecipe(
                createItemStack(ElectroMagicTools.ID, "SuperchargedMjolnir", 1, 26, "{charge:10.0d}"));
        TCHelper.removeArcaneRecipe(ItemList.IC2_Uranium_235_Small.get(7));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15));
        TCHelper.removeInfusionRecipe(getModItem(Minecraft.ID, "coal", 16, 0));
        TCHelper.removeInfusionRecipe(getModItem(Minecraft.ID, "glowstone", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(IndustrialCraft2.ID, "itemOreIridium", 2, 0));
        TCHelper.removeInfusionRecipe(getModItem(Minecraft.ID, "gold_ingot", 2, 0));
        TCHelper.removeInfusionRecipe(getModItem(Minecraft.ID, "diamond", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "ShieldFocus", 1, 0));
        TCHelper.removeInfusionRecipe(ItemList.IC2_Uranium_238.get(2));
        TCHelper.removeArcaneRecipe(getModItem(ElectroMagicTools.ID, "ShieldBlock", 6, 0));
        TCHelper.removeArcaneRecipe(getModItem(ElectroMagicTools.ID, "ChristmasFocus", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "EnergyBallFocus", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "ExplosionFocus", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "ChargingFocus", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "WandChargingFocus", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 5));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 1));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 2));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 3));
        TCHelper.removeCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 4));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 0));
        TCHelper.removeInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 1));
        TCHelper.orphanResearch("Electric Magic Tools");
        TCHelper.removeResearch("Electric Magic Tools");
        new ResearchItem(
                "ElectricMagicTools",
                "EMT",
                new AspectList().add(Aspect.EARTH, 0),
                0,
                0,
                1,
                NHItemList.EMT.get()).setAutoUnlock().setSpecial()
                        .setPages(new ResearchPage("tc.research_page.ElectricMagicTools")).registerResearchItem();
        TCHelper.removeResearch("Diamond Chainsaw");
        new ResearchItem(
                "DiamondChainsaw",
                "EMT",
                new AspectList().add(Aspect.GREED, 12).add(Aspect.FIRE, 9).add(Aspect.METAL, 6).add(Aspect.EARTH, 3),
                0,
                -2,
                2,
                getModItem(ElectroMagicTools.ID, "DiamondChainsaw", 1, 27)).setParents("ElectricMagicTools").setRound()
                        .setPages(new ResearchPage("tc.research_page.DiamondChainsaw")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "DiamondChainsaw",
                getModItem(ElectroMagicTools.ID, "DiamondChainsaw", 1, 27),
                new AspectList().add(Aspect.AIR, 35).add(Aspect.EARTH, 35).add(Aspect.FIRE, 35).add(Aspect.WATER, 35)
                        .add(Aspect.ORDER, 35).add(Aspect.ENTROPY, 35),
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
                        TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "DiamondChainsaw", 1, 27))));
        TCHelper.removeResearch("Thaumium Plate");
        new ResearchItem(
                "ThaumiumPlate",
                "EMT",
                new AspectList(),
                6,
                -6,
                1,
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 5)).setAutoUnlock().setRound()
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
                getModItem(ElectroMagicTools.ID, "electricCloud", 1, 0))
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
                new AspectList().add(Aspect.AIR, 15).add(Aspect.ENERGY, 12).add(Aspect.MAGIC, 9).add(Aspect.FLIGHT, 6)
                        .add(Aspect.EARTH, 3),
                0,
                2,
                3,
                getModItem(ElectroMagicTools.ID, "FeatherWing", 1, 0)).setParents("ElectricMagicTools").setRound()
                        .setPages(new ResearchPage("tc.research_page.FeatherWings")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FeatherWings",
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7),
                new AspectList().add(Aspect.AIR, 5).add(Aspect.EARTH, 5).add(Aspect.ORDER, 5),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "feather", 1, 0),
                'b',
                getModItem(Minecraft.ID, "feather", 1, 0),
                'c',
                getModItem(Minecraft.ID, "feather", 1, 0),
                'd',
                getModItem(Minecraft.ID, "feather", 1, 0),
                'e',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 9),
                'f',
                getModItem(Minecraft.ID, "feather", 1, 0),
                'g',
                getModItem(Minecraft.ID, "feather", 1, 0),
                'h',
                getModItem(Minecraft.ID, "feather", 1, 0),
                'i',
                getModItem(Minecraft.ID, "feather", 1, 0));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FeatherWings",
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 11),
                new AspectList().add(Aspect.AIR, 15).add(Aspect.ORDER, 5),
                "abc",
                "def",
                "ghi",
                'a',
                GTOreDictUnificator.get(OrePrefixes.plateQuintuple, Materials.Paper, 1L),
                'b',
                GTOreDictUnificator.get(OrePrefixes.plateQuintuple, Materials.Paper, 1L),
                'd',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8),
                'e',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8));
        TCHelper.addResearchPage(
                "FeatherWings",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 11))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FeatherWings",
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12),
                new AspectList().add(Aspect.AIR, 10).add(Aspect.ORDER, 10),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7),
                'b',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8),
                'c',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 11),
                'd',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7),
                'e',
                getModItem(Minecraft.ID, "string", 1, 0),
                'f',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 11),
                'g',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 7),
                'h',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 8),
                'i',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 11));
        TCHelper.addResearchPage(
                "FeatherWings",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "FeatherWings",
                getModItem(ElectroMagicTools.ID, "FeatherWing", 1, 0),
                new AspectList().add(Aspect.AIR, 24).add(Aspect.EARTH, 24).add(Aspect.FIRE, 24).add(Aspect.WATER, 24)
                        .add(Aspect.ORDER, 24).add(Aspect.ENTROPY, 24),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12),
                'b',
                getModItem(Minecraft.ID, "string", 1, 0),
                'c',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12),
                'd',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12),
                'e',
                "plateAluminium",
                'f',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12),
                'g',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12),
                'h',
                getModItem(Minecraft.ID, "string", 1, 0),
                'i',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 12));
        TCHelper.addResearchPage(
                "FeatherWings",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "FeatherWing", 1, 0))));
        TCHelper.orphanResearch("Thaumium Reinforced Wings");
        TCHelper.removeResearch("Thaumium Reinforced Wings");
        new ResearchItem(
                "ThaumiumReinforcedWings",
                "EMT",
                new AspectList().add(Aspect.AIR, 21).add(Aspect.ENERGY, 18).add(Aspect.MAGIC, 15).add(Aspect.FLIGHT, 12)
                        .add(Aspect.METAL, 9).add(Aspect.TAINT, 6).add(Aspect.MECHANISM, 3),
                0,
                4,
                3,
                getModItem(ElectroMagicTools.ID, "ThaumiumWing", 1, 0)).setParents("FeatherWings").setConcealed()
                        .setRound().setPages(new ResearchPage("tc.research_page.ThaumiumReinforcedWings"))
                        .registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "ThaumiumReinforcedWings",
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 13),
                getModItem(Minecraft.ID, "feather", 1, 0),
                new AspectList().add(Aspect.TAINT, 6).add(Aspect.GREED, 4).add(Aspect.HUNGER, 4));
        TCHelper.addResearchPage(
                "ThaumiumReinforcedWings",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 13))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ThaumiumReinforcedWings",
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 14),
                new AspectList().add(Aspect.AIR, 48).add(Aspect.EARTH, 48).add(Aspect.FIRE, 48).add(Aspect.WATER, 48)
                        .add(Aspect.ORDER, 48).add(Aspect.ENTROPY, 48),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 13),
                'b',
                "plateThaumium",
                'c',
                "plateStainlessSteel",
                'd',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 13),
                'e',
                "wireFineCobalt",
                'f',
                "plateStainlessSteel",
                'g',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 13),
                'h',
                "plateThaumium",
                'i',
                "plateStainlessSteel");
        TCHelper.addResearchPage(
                "ThaumiumReinforcedWings",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 14))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ThaumiumReinforcedWings",
                getModItem(ElectroMagicTools.ID, "ThaumiumWing", 1, 0),
                new AspectList().add(Aspect.AIR, 48).add(Aspect.EARTH, 48).add(Aspect.FIRE, 48).add(Aspect.WATER, 48)
                        .add(Aspect.ORDER, 48).add(Aspect.ENTROPY, 48),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 14),
                'b',
                "wireFineCobalt",
                'c',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 14),
                'd',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 14),
                'e',
                "wireFineCobalt",
                'f',
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 14));
        TCHelper.addResearchPage(
                "ThaumiumReinforcedWings",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "ThaumiumWing", 1, 0))));
        ThaumcraftApi.addWarpToResearch("ThaumiumReinforcedWings", 1);
        TCHelper.orphanResearch("Nanosuit Wings");
        TCHelper.removeResearch("Nanosuit Wings");
        new ResearchItem(
                "NanosuitWings",
                "EMT",
                new AspectList().add(Aspect.AIR, 24).add(Aspect.ENERGY, 21).add(Aspect.MAGIC, 18).add(Aspect.FLIGHT, 15)
                        .add(Aspect.METAL, 12).add(Aspect.TAINT, 9).add(Aspect.MECHANISM, 6).add(Aspect.EARTH, 3),
                0,
                6,
                3,
                getModItem(ElectroMagicTools.ID, "NanosuitWing", 1, 0)).setParents("ThaumiumReinforcedWings")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.NanosuitWings"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "NanosuitWings",
                getModItem(ElectroMagicTools.ID, "NanosuitWing", 1, 27),
                5,
                new AspectList().add(Aspect.AIR, 48).add(Aspect.MECHANISM, 48).add(Aspect.ENERGY, 32)
                        .add(Aspect.FLIGHT, 32).add(Aspect.MAGIC, 16).add(Aspect.TAINT, 8).add(Aspect.EARTH, 8),
                getModItem(ElectroMagicTools.ID, "ThaumiumWing", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemArmorNanoChestplate", 1, wildcard),
                OrePrefixes.wireFine.get(Materials.Titanium),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0),
                OrePrefixes.wireFine.get(Materials.Titanium),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0),
                OrePrefixes.wireFine.get(Materials.Titanium),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0),
                OrePrefixes.wireFine.get(Materials.Titanium),
                getModItem(IndustrialCraft2.ID, "itemPartCarbonPlate", 1, 0),
                OrePrefixes.wireFine.get(Materials.Titanium));
        TCHelper.addResearchPage(
                "NanosuitWings",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "NanosuitWing", 1, 27))));
        ThaumcraftApi.addWarpToResearch("NanosuitWings", 2);
        TCHelper.orphanResearch("Quantum Wings");
        TCHelper.removeResearch("Quantum Wings");
        new ResearchItem(
                "QuantumWings",
                "EMT",
                new AspectList().add(Aspect.AIR, 27).add(Aspect.ENERGY, 24).add(Aspect.MAGIC, 21).add(Aspect.FLIGHT, 18)
                        .add(Aspect.METAL, 15).add(Aspect.TAINT, 12).add(Aspect.MECHANISM, 9).add(Aspect.EARTH, 6)
                        .add(Aspect.GREED, 3),
                0,
                8,
                3,
                getModItem(ElectroMagicTools.ID, "QuantumWing", 1, 0)).setParents("NanosuitWings").setConcealed()
                        .setRound().setPages(new ResearchPage("tc.research_page.QuantumWings")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "QuantumWings",
                getModItem(ElectroMagicTools.ID, "QuantumWing", 1, 27),
                10,
                new AspectList().add(Aspect.ARMOR, 64).add(Aspect.AIR, 64).add(Aspect.MECHANISM, 64)
                        .add(Aspect.ENERGY, 48).add(Aspect.FLIGHT, 48).add(Aspect.MAGIC, 32).add(Aspect.TAINT, 16)
                        .add(Aspect.EARTH, 16),
                getModItem(ElectroMagicTools.ID, "NanosuitWing", 1, wildcard),
                getModItem(IndustrialCraft2.ID, "itemArmorQuantumChestplate", 1, wildcard),
                OrePrefixes.wireFine.get(Materials.Osmium),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                OrePrefixes.wireFine.get(Materials.Osmium),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                OrePrefixes.wireFine.get(Materials.Osmium),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                OrePrefixes.wireFine.get(Materials.Osmium),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                OrePrefixes.wireFine.get(Materials.Osmium));
        TCHelper.addResearchPage(
                "QuantumWings",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "QuantumWing", 1, 27))));
        ThaumcraftApi.addWarpToResearch("QuantumWings", 3);
        TCHelper.orphanResearch("Infused Quantum Armor");
        TCHelper.removeResearch("Infused Quantum Armor");
        new ResearchItem(
                "InfusedQuantumArmor",
                "EMT",
                new AspectList().add(Aspect.AIR, 30).add(Aspect.ENERGY, 27).add(Aspect.MAGIC, 24).add(Aspect.FLIGHT, 21)
                        .add(Aspect.METAL, 18).add(Aspect.TAINT, 15).add(Aspect.MECHANISM, 12).add(Aspect.EARTH, 9)
                        .add(Aspect.GREED, 6).add(DarkAspects.PRIDE, 3),
                0,
                10,
                3,
                getModItem(ElectroMagicTools.ID, "itemArmorQuantumChestplate", 1, 0)).setParents("QuantumWings")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.InfusedQuantumArmor"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "InfusedQuantumArmor",
                getModItem(ElectroMagicTools.ID, "itemArmorQuantumChestplate", 1, 27),
                15,
                new AspectList().add(Aspect.ARMOR, 72).add(Aspect.AIR, 64).add(Aspect.MECHANISM, 64)
                        .add(Aspect.ENERGY, 48).add(Aspect.FLIGHT, 48).add(Aspect.MAGIC, 32).add(Aspect.TAINT, 16)
                        .add(Aspect.EARTH, 16).add(Aspect.GREED, 8),
                getModItem(IndustrialCraft2.ID, "itemArmorQuantumChestplate", 1, wildcard),
                getModItem(ElectroMagicTools.ID, "ShieldBlock", 1, 0),
                OrePrefixes.wireFine.get(Materials.Naquadah),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                OrePrefixes.wireFine.get(Materials.Naquadah),
                getModItem(ElectroMagicTools.ID, "ShieldBlock", 1, 0),
                OrePrefixes.wireFine.get(Materials.Naquadah),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                OrePrefixes.wireFine.get(Materials.Naquadah));
        TCHelper.addResearchPage(
                "InfusedQuantumArmor",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "itemArmorQuantumChestplate", 1, 27))));
        ThaumcraftApi.addWarpToResearch("InfusedQuantumArmor", 4);
        TCHelper.orphanResearch("Iron Omnitool");
        TCHelper.removeResearch("Iron Omnitool");
        new ResearchItem(
                "IronOmnitool",
                "EMT",
                new AspectList().add(Aspect.ENERGY, 12).add(Aspect.TOOL, 9).add(Aspect.MINE, 6).add(Aspect.WEAPON, 3),
                -2,
                0,
                2,
                getModItem(ElectroMagicTools.ID, "Omnitool", 1, 0)).setParents("ElectricMagicTools").setRound()
                        .setPages(new ResearchPage("tc.research_page.IronOmnitool")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "IronOmnitool",
                getModItem(ElectroMagicTools.ID, "Omnitool", 1, 27),
                new AspectList().add(Aspect.AIR, 15).add(Aspect.EARTH, 15).add(Aspect.FIRE, 15).add(Aspect.WATER, 15)
                        .add(Aspect.ORDER, 15).add(Aspect.ENTROPY, 15),
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
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "Omnitool", 1, 27))));
        TCHelper.orphanResearch("Diamond Omnitool");
        TCHelper.removeResearch("Diamond Omnitool");
        new ResearchItem(
                "DiamondOmnitool",
                "EMT",
                new AspectList().add(Aspect.ENERGY, 15).add(Aspect.TOOL, 12).add(Aspect.MINE, 9).add(Aspect.WEAPON, 6)
                        .add(Aspect.CRYSTAL, 3),
                -4,
                0,
                3,
                getModItem(ElectroMagicTools.ID, "Diamond Omnitool", 1, 0)).setParents("IronOmnitool")
                        .setParentsHidden("DiamondChainsaw").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.DiamondOmnitool")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "DiamondOmnitool",
                getModItem(ElectroMagicTools.ID, "Diamond Omnitool", 1, 27),
                6,
                new AspectList().add(Aspect.TOOL, 32).add(Aspect.MINE, 24).add(Aspect.ENERGY, 24).add(Aspect.METAL, 16)
                        .add(Aspect.WEAPON, 16).add(Aspect.EARTH, 8),
                createItemStack(
                        GregTech.ID,
                        "gt.metatool.01",
                        1,
                        102,
                        "{ench:[0:{lvl:2s,id:35s}],GT.ToolStats:{PrimaryMaterial:\"Thaumium\",SpecialData:-1L,MaxDamage:51200L,Tier:2L,MaxCharge:400000L,Voltage:128L,Electric:1b,Mode:0b,SecondaryMaterial:\"Titanium\"},GT.ItemCharge:400000L}"),
                getModItem(ElectroMagicTools.ID, "DiamondChainsaw", 1, wildcard),
                plate.get(Diamond),
                circuit.get(HV),
                plate.get(Diamond),
                screw.get(Thaumium),
                plate.get(Diamond),
                screw.get(Thaumium),
                plate.get(Diamond),
                circuit.get(HV),
                plate.get(Diamond));
        TCHelper.addResearchPage(
                "DiamondOmnitool",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "Diamond Omnitool", 1, 27))));
        TCHelper.orphanResearch("Thaumium Omnitool");
        TCHelper.removeResearch("Thaumium Omnitool");
        new ResearchItem(
                "ThaumiumOmnitool",
                "EMT",
                new AspectList().add(Aspect.ENERGY, 15).add(Aspect.TOOL, 12).add(Aspect.MINE, 9).add(Aspect.WEAPON, 6)
                        .add(Aspect.CRYSTAL, 3),
                -6,
                0,
                3,
                getModItem(ElectroMagicTools.ID, "ThaumiumOmnitool", 1, 0)).setParents("DiamondOmnitool")
                        .setParentsHidden("ThaumiumChainsaw", "ThaumiumDrill").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.ThaumiumOmnitool")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ThaumiumOmnitool",
                getModItem(ElectroMagicTools.ID, "ThaumiumOmnitool", 1, 27),
                8,
                new AspectList().add(Aspect.TOOL, 48).add(Aspect.MINE, 24).add(Aspect.ENERGY, 32).add(Aspect.METAL, 24)
                        .add(Aspect.WEAPON, 16).add(Aspect.EARTH, 8).add(Aspect.MAGIC, 16),
                getModItem(ElectroMagicTools.ID, "ThaumiumChainsaw", 1, wildcard),
                getModItem(ElectroMagicTools.ID, "ThaumiumDrill", 1, wildcard),
                OrePrefixes.plate.get(Materials.TungstenSteel),
                OrePrefixes.circuit.get(Materials.IV),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.screw.get(Materials.Titanium),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.screw.get(Materials.Titanium),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.circuit.get(Materials.IV),
                OrePrefixes.plate.get(Materials.TungstenSteel));
        TCHelper.addResearchPage(
                "ThaumiumOmnitool",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "ThaumiumOmnitool", 1, 27))));
        ThaumcraftApi.addWarpToResearch("ThaumiumOmnitool", 1);
        TCHelper.orphanResearch("Electric Boots of the Traveller");
        TCHelper.removeResearch("Electric Boots of the Traveller");
        new ResearchItem(
                "ElectricBootsoftheTraveller",
                "EMT",
                new AspectList().add(Aspect.MAGIC, 15).add(Aspect.MOTION, 12).add(Aspect.ENERGY, 9).add(Aspect.ARMOR, 6)
                        .add(Aspect.EARTH, 3),
                2,
                2,
                3,
                getModItem(ElectroMagicTools.ID, "ElectricBootsTraveller", 1, 0)).setParents("BOOTSTRAVELLER")
                        .setParentsHidden("ElectricMagicTools").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.ElectricBootsoftheTraveller"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ElectricBootsoftheTraveller",
                getModItem(ElectroMagicTools.ID, "ElectricBootsTraveller", 1, 27),
                3,
                new AspectList().add(Aspect.MOTION, 32).add(Aspect.ENERGY, 16).add(Aspect.ARMOR, 32)
                        .add(Aspect.MAGIC, 8).add(Aspect.FLIGHT, 8).add(Aspect.TRAVEL, 8),
                getModItem(Thaumcraft.ID, "BootsTraveller", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemStaticBoots", 1, 0),
                OrePrefixes.plate.get(Materials.Diamond),
                ItemList.Electric_Motor_MV.get(1L),
                OrePrefixes.wireGt02.get(Materials.Copper),
                getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, wildcard),
                OrePrefixes.wireGt02.get(Materials.Copper),
                ItemList.Electric_Motor_MV.get(1L),
                OrePrefixes.plate.get(Materials.Diamond));
        TCHelper.addResearchPage(
                "ElectricBootsoftheTraveller",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "ElectricBootsTraveller", 1, 27))));
        TCHelper.orphanResearch("Nano Boots of the Traveller");
        TCHelper.removeResearch("Nano Boots of the Traveller");
        new ResearchItem(
                "NanoBootsoftheTraveller",
                "EMT",
                new AspectList().add(Aspect.MAGIC, 18).add(Aspect.MOTION, 15).add(Aspect.ENERGY, 12)
                        .add(Aspect.ARMOR, 9).add(Aspect.EARTH, 6).add(Aspect.FLIGHT, 3),
                4,
                2,
                3,
                getModItem(ElectroMagicTools.ID, "NanoBootsTraveller", 1, 0)).setParents("ElectricBootsoftheTraveller")
                        .setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.NanoBootsoftheTraveller")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "NanoBootsoftheTraveller",
                getModItem(ElectroMagicTools.ID, "NanoBootsTraveller", 1, 27),
                6,
                new AspectList().add(Aspect.MOTION, 48).add(Aspect.ENERGY, 24).add(Aspect.ARMOR, 32)
                        .add(Aspect.MAGIC, 16).add(Aspect.FLIGHT, 8).add(Aspect.TRAVEL, 16),
                getModItem(ElectroMagicTools.ID, "ElectricBootsTraveller", 1, wildcard),
                getModItem(IndustrialCraft2.ID, "itemArmorNanoBoots", 1, wildcard),
                OrePrefixes.plate.get(Materials.Thaumium),
                ItemList.Electric_Motor_HV.get(1L),
                OrePrefixes.wireGt04.get(Materials.Electrum),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                OrePrefixes.wireGt04.get(Materials.Electrum),
                ItemList.Electric_Motor_HV.get(1L),
                OrePrefixes.plate.get(Materials.Thaumium));
        TCHelper.addResearchPage(
                "NanoBootsoftheTraveller",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "NanoBootsTraveller", 1, 27))));
        ThaumcraftApi.addWarpToResearch("NanoBootsoftheTraveller", 1);
        TCHelper.orphanResearch("Quantum Boots of the Traveller");
        TCHelper.removeResearch("Quantum Boots of the Traveller");
        new ResearchItem(
                "QuantumBootsoftheTraveller",
                "EMT",
                new AspectList().add(Aspect.MAGIC, 21).add(Aspect.MOTION, 18).add(Aspect.ENERGY, 15)
                        .add(Aspect.ARMOR, 12).add(Aspect.EARTH, 9).add(Aspect.FLIGHT, 6).add(Aspect.AURA, 3),
                6,
                2,
                3,
                getModItem(ElectroMagicTools.ID, "QuantumBootsTraveller", 1, 0)).setParents("NanoBootsoftheTraveller")
                        .setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.QuantumBootsoftheTraveller"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "QuantumBootsoftheTraveller",
                getModItem(ElectroMagicTools.ID, "QuantumBootsTraveller", 1, 27),
                9,
                new AspectList().add(Aspect.MOTION, 64).add(Aspect.ENERGY, 32).add(Aspect.ARMOR, 48)
                        .add(Aspect.MAGIC, 24).add(Aspect.FLIGHT, 16).add(Aspect.TRAVEL, 24).add(Aspect.AIR, 8),
                getModItem(ElectroMagicTools.ID, "NanoBootsTraveller", 1, wildcard),
                getModItem(IndustrialCraft2.ID, "itemArmorQuantumBoots", 1, wildcard),
                OrePrefixes.plate.get(Materials.Void),
                ItemList.Electric_Motor_EV.get(1L),
                OrePrefixes.wireGt08.get(Materials.Titanium),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                OrePrefixes.wireGt08.get(Materials.Titanium),
                ItemList.Electric_Motor_EV.get(1L),
                OrePrefixes.plate.get(Materials.Void));
        TCHelper.addResearchPage(
                "QuantumBootsoftheTraveller",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "QuantumBootsTraveller", 1, 27))));
        ThaumcraftApi.addWarpToResearch("QuantumBootsoftheTraveller", 2);
        TCHelper.orphanResearch("Thaumium Drill");
        TCHelper.removeResearch("Thaumium Drill");
        new ResearchItem(
                "ThaumiumDrill",
                "EMT",
                new AspectList().add(Aspect.TOOL, 18).add(Aspect.MINE, 15).add(Aspect.ENERGY, 12).add(Aspect.GREED, 9)
                        .add(Aspect.MAGIC, 6).add(Aspect.FIRE, 3),
                2,
                0,
                3,
                getModItem(ElectroMagicTools.ID, "ThaumiumDrill", 1, 0)).setParents("ElectricMagicTools").setConcealed()
                        .setRound().setPages(new ResearchPage("tc.research_page.ThaumiumDrill")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ThaumiumDrill",
                getModItem(ElectroMagicTools.ID, "ThaumiumDrill", 1, 27),
                7,
                new AspectList().add(Aspect.TOOL, 32).add(Aspect.MINE, 16).add(Aspect.ENERGY, 32).add(Aspect.GREED, 24)
                        .add(Aspect.MAGIC, 8),
                createItemStack(
                        GregTech.ID,
                        "gt.metatool.01",
                        1,
                        102,
                        "{ench:[0:{lvl:2s,id:35s}],GT.ToolStats:{PrimaryMaterial:\"Thaumium\",SpecialData:-1L,MaxDamage:51200L,Tier:2L,MaxCharge:400000L,Voltage:128L,Electric:1b,Mode:0b,SecondaryMaterial:\"Aluminium\"},GT.ItemCharge:400000L}"),
                screw.get(Titanium),
                plate.get(Thaumium),
                circuit.get(IV),
                plate.get(TungstenSteel),
                screw.get(Titanium),
                plate.get(Thaumium),
                circuit.get(IV),
                plate.get(TungstenSteel));
        TCHelper.addResearchPage(
                "ThaumiumDrill",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "ThaumiumDrill", 1, 27))));
        ThaumcraftApi.addWarpToResearch("ThaumiumDrill", 1);
        TCHelper.orphanResearch("Drill of the Rockbreaker");
        TCHelper.removeResearch("Drill of the Rockbreaker");
        new ResearchItem(
                "DrilloftheRockbreaker",
                "EMT",
                new AspectList().add(Aspect.TOOL, 21).add(Aspect.MINE, 18).add(Aspect.ENERGY, 15).add(Aspect.GREED, 12)
                        .add(Aspect.MAGIC, 9).add(Aspect.FIRE, 6).add(Aspect.EARTH, 3),
                4,
                0,
                3,
                getModItem(ElectroMagicTools.ID, "DrillRockbreaker", 1, 0)).setParents("ThaumiumDrill").setConcealed()
                        .setRound().setPages(new ResearchPage("tc.research_page.DrilloftheRockbreaker"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "DrilloftheRockbreaker",
                getModItem(ElectroMagicTools.ID, "DrillRockbreaker", 1, 27),
                10,
                new AspectList().add(Aspect.TOOL, 48).add(Aspect.MINE, 24).add(Aspect.ENERGY, 48).add(Aspect.GREED, 32)
                        .add(Aspect.MAGIC, 16).add(Aspect.FIRE, 8),
                getModItem(ElectroMagicTools.ID, "ThaumiumDrill", 1, wildcard),
                getModItem(Thaumcraft.ID, "ItemShovelElemental", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                OrePrefixes.circuit.get(Materials.LuV),
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Thaumcraft.ID, "ItemPickaxeElemental", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0),
                OrePrefixes.circuit.get(Materials.LuV),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0));
        TCHelper.addResearchPage(
                "DrilloftheRockbreaker",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "DrillRockbreaker", 1, 27))));
        ThaumcraftApi.addWarpToResearch("DrilloftheRockbreaker", 2);
        TCHelper.orphanResearch("Thaumium Chainsaw");
        TCHelper.removeResearch("Thaumium Chainsaw");
        new ResearchItem(
                "ThaumiumChainsaw",
                "EMT",
                new AspectList().add(Aspect.TOOL, 18).add(Aspect.WEAPON, 15).add(Aspect.ENERGY, 12).add(Aspect.GREED, 9)
                        .add(Aspect.MAGIC, 6).add(Aspect.AIR, 3),
                0,
                -4,
                3,
                getModItem(ElectroMagicTools.ID, "ThaumiumChainsaw", 1, 0)).setParents("DiamondChainsaw").setConcealed()
                        .setRound().setPages(new ResearchPage("tc.research_page.ThaumiumChainsaw"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ThaumiumChainsaw",
                getModItem(ElectroMagicTools.ID, "ThaumiumChainsaw", 1, 27),
                7,
                new AspectList().add(Aspect.TOOL, 32).add(Aspect.WEAPON, 24).add(Aspect.ENERGY, 24)
                        .add(Aspect.GREED, 16).add(Aspect.MAGIC, 8),
                getModItem(ElectroMagicTools.ID, "DiamondChainsaw", 1, wildcard),
                OrePrefixes.screw.get(Materials.Titanium),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.circuit.get(Materials.IV),
                OrePrefixes.plate.get(Materials.TungstenSteel),
                OrePrefixes.screw.get(Materials.Titanium),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.circuit.get(Materials.IV),
                OrePrefixes.plate.get(Materials.TungstenSteel));
        TCHelper.addResearchPage(
                "ThaumiumChainsaw",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "ThaumiumChainsaw", 1, 27))));
        ThaumcraftApi.addWarpToResearch("ThaumiumChainsaw", 1);
        TCHelper.orphanResearch("Chainsaw of the Stream");
        TCHelper.removeResearch("Chainsaw of the Stream");
        new ResearchItem(
                "ChainsawoftheStream",
                "EMT",
                new AspectList().add(Aspect.ENERGY, 15).add(Aspect.GREED, 12).add(Aspect.MAGIC, 9).add(Aspect.AIR, 6)
                        .add(Aspect.TREE, 3),
                0,
                -6,
                3,
                getModItem(ElectroMagicTools.ID, "ChainsawStream", 1, 0)).setParents("ThaumiumChainsaw").setConcealed()
                        .setRound().setPages(new ResearchPage("tc.research_page.ChainsawoftheStream"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ChainsawoftheStream",
                getModItem(ElectroMagicTools.ID, "ChainsawStream", 1, 27),
                10,
                new AspectList().add(Aspect.TOOL, 48).add(Aspect.WEAPON, 32).add(Aspect.ENERGY, 32)
                        .add(Aspect.GREED, 24).add(Aspect.MAGIC, 16).add(Aspect.AIR, 8),
                getModItem(ElectroMagicTools.ID, "ThaumiumChainsaw", 1, wildcard),
                getModItem(Thaumcraft.ID, "ItemAxeElemental", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                OrePrefixes.circuit.get(Materials.LuV),
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(Railcraft.ID, "tool.steel.shears", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0),
                OrePrefixes.circuit.get(Materials.LuV),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0));
        TCHelper.addResearchPage(
                "ChainsawoftheStream",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "ChainsawStream", 1, 27))));
        ThaumcraftApi.addWarpToResearch("ChainsawoftheStream", 2);
        TCHelper.orphanResearch("Inventory Charging Ring");
        TCHelper.removeResearch("Inventory Charging Ring");
        new ResearchItem(
                "InventoryChargingRing",
                "EMT",
                new AspectList().add(Aspect.ENERGY, 15).add(Aspect.CRYSTAL, 12).add(Aspect.MAGIC, 9)
                        .add(TCAspects.ELECTRUM.getAspect(), 6).add(Aspect.AURA, 3),
                0,
                -8,
                3,
                getModItem(ElectroMagicTools.ID, "EMTBaubles", 1, 1)).setParentsHidden("ElectricMagicTools")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.InventoryChargingRing"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "InventoryChargingRing",
                getModItem(ElectroMagicTools.ID, "EMTBaubles", 1, 1),
                7,
                new AspectList().add(Aspect.ENERGY, 64).add(Aspect.CRYSTAL, 32).add(Aspect.MAGIC, 48)
                        .add(TCAspects.ELECTRUM.getAspect(), 16).add(Aspect.AURA, 8),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 1),
                ItemList.IC2_EnergyCrystal.get(1),
                ItemList.MagicEnergyAbsorber_LV.get(1),
                OrePrefixes.wireGt04.get(Materials.Silver),
                ItemList.Generator_Steam_Turbine_LV.get(1),
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 1),
                getModItem(IndustrialCraft2.ID, "itemStaticBoots", 1, 0),
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 2),
                getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 0),
                OrePrefixes.wireGt04.get(Materials.Silver),
                ItemList.Cover_SolarPanel_LV.get(1));
        TCHelper.addResearchPage(
                "InventoryChargingRing",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTBaubles", 1, 1))));
        ThaumcraftApi.addWarpToResearch("InventoryChargingRing", 2);
        TCHelper.orphanResearch("Armor Charging Ring");
        TCHelper.removeResearch("Armor Charging Ring");
        new ResearchItem(
                "ArmorChargingRing",
                "EMT",
                new AspectList().add(Aspect.ENERGY, 15).add(Aspect.ARMOR, 12).add(Aspect.MAGIC, 9)
                        .add(TCAspects.ELECTRUM.getAspect(), 6).add(Aspect.AURA, 3),
                0,
                -10,
                3,
                getModItem(ElectroMagicTools.ID, "EMTBaubles", 1, 0)).setParents("InventoryChargingRing").setConcealed()
                        .setRound().setPages(new ResearchPage("tc.research_page.ArmorChargingRing"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ArmorChargingRing",
                getModItem(ElectroMagicTools.ID, "EMTBaubles", 1, 0),
                8,
                new AspectList().add(Aspect.ENERGY, 64).add(Aspect.ARMOR, 32).add(Aspect.MAGIC, 48)
                        .add(TCAspects.ELECTRUM.getAspect(), 16).add(Aspect.AURA, 8),
                getModItem(Thaumcraft.ID, "ItemBaubleBlanks", 1, 1),
                ItemList.IC2_EnergyCrystal.get(1),
                ItemList.MagicEnergyAbsorber_LV.get(1),
                OrePrefixes.wireGt04.get(Materials.BlueAlloy),
                ItemList.Generator_Steam_Turbine_LV.get(1),
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 1),
                getModItem(IndustrialCraft2.ID, "itemStaticBoots", 1, 0),
                getModItem(IndustrialCraft2.ID, "blockKineticGenerator", 1, 2),
                getModItem(IndustrialCraft2.ID, "blockHeatGenerator", 1, 0),
                OrePrefixes.wireGt04.get(Materials.BlueAlloy),
                ItemList.Cover_SolarPanel_LV.get(1));
        TCHelper.addResearchPage(
                "ArmorChargingRing",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTBaubles", 1, 0))));
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
                new AspectList().add(Aspect.ARMOR, 15).add(Aspect.ENERGY, 12).add(Aspect.SENSES, 9).add(Aspect.MAGIC, 6)
                        .add(TCAspects.ELECTRUM.getAspect(), 3),
                -6,
                -2,
                3,
                getModItem(ElectroMagicTools.ID, "ElectricGogglesRevealing", 1, 0)).setParents("GOGGLES").setConcealed()
                        .setParentsHidden("ElectricMagicTools").setRound()
                        .setPages(new ResearchPage("tc.research_page.ElectricGogglesofRevealing"))
                        .registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ElectricGogglesofRevealing",
                getModItem(ElectroMagicTools.ID, "ElectricGogglesRevealing", 1, 165),
                new AspectList().add(Aspect.AIR, 45).add(Aspect.FIRE, 45).add(Aspect.EARTH, 45).add(Aspect.WATER, 45)
                        .add(Aspect.ORDER, 45).add(Aspect.ENTROPY, 45),
                "abc",
                "def",
                "ghi",
                'a',
                "wireGt02AnyCopper",
                'b',
                getModItem(Minecraft.ID, "diamond_helmet", 1, 0),
                'c',
                "wireGt02AnyCopper",
                'd',
                "circuitBasic",
                'e',
                getModItem(Thaumcraft.ID, "ItemGoggles", 1, 0),
                'f',
                "circuitBasic",
                'g',
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 10),
                'h',
                getModItem(IndustrialCraft2.ID, "itemAdvBat", 1, wildcard),
                'i',
                getModItem(ProjectRedIntegration.ID, "projectred.integration.gate", 1, 10));
        TCHelper.addResearchPage(
                "ElectricGogglesofRevealing",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(
                                getModItem(ElectroMagicTools.ID, "ElectricGogglesRevealing", 1, 165))));
        new ResearchItem(
                "NanosuitGogglesofRevealing",
                "EMT",
                new AspectList().add(Aspect.ARMOR, 18).add(Aspect.ENERGY, 15).add(Aspect.SENSES, 12)
                        .add(Aspect.MAGIC, 9).add(Aspect.AURA, 6).add(TCAspects.ELECTRUM.getAspect(), 3),
                -4,
                -2,
                3,
                getModItem(ElectroMagicTools.ID, "NanosuitGogglesRevealing", 1, 0))
                        .setParents("ElectricGogglesofRevealing").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.NanosuitGogglesofRevealing"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "NanosuitGogglesofRevealing",
                getModItem(ElectroMagicTools.ID, "NanosuitGogglesRevealing", 1, 27),
                6,
                new AspectList().add(Aspect.ARMOR, 32).add(Aspect.ENERGY, 32).add(Aspect.SENSES, 24)
                        .add(Aspect.MAGIC, 16).add(Aspect.AURA, 8).add(TCAspects.ELECTRUM.getAspect(), 8),
                getModItem(ElectroMagicTools.ID, "ElectricGogglesRevealing", 1, wildcard),
                getModItem(IndustrialCraft2.ID, "itemArmorNanoHelmet", 1, wildcard),
                OrePrefixes.wireGt04.get(Materials.Electrum),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.circuit.get(Materials.HV),
                ItemList.Sensor_HV.get(1L),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                ItemList.Sensor_HV.get(1L),
                OrePrefixes.circuit.get(Materials.HV),
                OrePrefixes.plate.get(Materials.Thaumium),
                OrePrefixes.wireGt04.get(Materials.Electrum));
        TCHelper.addResearchPage(
                "NanosuitGogglesofRevealing",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "NanosuitGogglesRevealing", 1, 27))));
        ThaumcraftApi.addWarpToResearch("NanosuitGogglesofRevealing", 1);
        new ResearchItem(
                "QuantumGogglesofRevealing",
                "EMT",
                new AspectList().add(Aspect.ARMOR, 21).add(Aspect.ENERGY, 18).add(Aspect.SENSES, 15)
                        .add(Aspect.MAGIC, 12).add(Aspect.AURA, 9).add(Aspect.GREED, 6)
                        .add(TCAspects.ELECTRUM.getAspect(), 3),
                -2,
                -2,
                3,
                getModItem(ElectroMagicTools.ID, "QuantumGogglesRevealing", 1, 0))
                        .setParents("NanosuitGogglesofRevealing").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.QuantumGogglesofRevealing"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "QuantumGogglesofRevealing",
                getModItem(ElectroMagicTools.ID, "QuantumGogglesRevealing", 1, 27),
                9,
                new AspectList().add(Aspect.ARMOR, 64).add(Aspect.ENERGY, 48).add(Aspect.SENSES, 32)
                        .add(Aspect.MAGIC, 24).add(Aspect.AURA, 16).add(TCAspects.ELECTRUM.getAspect(), 16)
                        .add(Aspect.GREED, 8),
                getModItem(ElectroMagicTools.ID, "NanosuitGogglesRevealing", 1, wildcard),
                getModItem(IndustrialCraft2.ID, "itemArmorQuantumHelmet", 1, wildcard),
                OrePrefixes.wireGt08.get(Materials.Titanium),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.circuit.get(Materials.IV),
                ItemList.Sensor_EV.get(1L),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                ItemList.Sensor_EV.get(1L),
                OrePrefixes.circuit.get(Materials.IV),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.wireGt08.get(Materials.Titanium));
        TCHelper.addResearchPage(
                "QuantumGogglesofRevealing",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                getModItem(ElectroMagicTools.ID, "QuantumGogglesRevealing", 1, 27))));
        ThaumcraftApi.addWarpToResearch("QuantumGogglesofRevealing", 2);
        TCHelper.orphanResearch("Solar Helmet of Revealing");
        TCHelper.removeResearch("Solar Helmet of Revealing");
        new ResearchItem(
                "SolarHelmetofRevealing",
                "EMT",
                new AspectList().add(Aspect.ARMOR, 30).add(Aspect.ENERGY, 27).add(Aspect.SENSES, 24)
                        .add(Aspect.MAGIC, 21).add(Aspect.AURA, 15).add(TCAspects.ELECTRUM.getAspect(), 12)
                        .add(Aspect.GREED, 9).add(Aspect.AIR, 6).add(Aspect.LIGHT, 3),
                -2,
                -4,
                3,
                getModItem(ElectroMagicTools.ID, "SolarHelmetRevealing", 1, 0))
                        .setParents("QuantumGogglesofRevealing", "CompressedSolars").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.SolarHelmetofRevealing")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SolarHelmetofRevealing",
                getModItem(ElectroMagicTools.ID, "SolarHelmetRevealing", 1, 27),
                12,
                new AspectList().add(Aspect.ARMOR, 64).add(Aspect.ENERGY, 48).add(Aspect.SENSES, 32)
                        .add(Aspect.MAGIC, 24).add(Aspect.AURA, 16).add(TCAspects.ELECTRUM.getAspect(), 16)
                        .add(Aspect.GREED, 8).add(Aspect.AIR, 16).add(Aspect.LIGHT, 32),
                getModItem(ElectroMagicTools.ID, "QuantumGogglesRevealing", 1, wildcard),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1),
                OrePrefixes.wireGt12.get(Materials.Osmium),
                OrePrefixes.plate.get(Materials.Naquadah),
                ItemList.Sensor_IV.get(1L),
                NHItemList.MysteriousCrystal.get(),
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard),
                NHItemList.MysteriousCrystal.get(),
                ItemList.Sensor_IV.get(1L),
                OrePrefixes.plate.get(Materials.Naquadah),
                OrePrefixes.wireGt12.get(Materials.Osmium));
        TCHelper.addResearchPage(
                "SolarHelmetofRevealing",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "SolarHelmetRevealing", 1, 27))));
        ThaumcraftApi.addWarpToResearch("SolarHelmetofRevealing", 3);
        TCHelper.orphanResearch("Compressed Solars");
        TCHelper.removeResearch("Compressed Solars");
        new ResearchItem(
                "CompressedSolars",
                "EMT",
                new AspectList().add(Aspect.ENERGY, 18).add(Aspect.LIGHT, 15).add(Aspect.METAL, 12).add(Aspect.MAGIC, 9)
                        .add(Aspect.FIRE, 6).add(Aspect.AIR, 3),
                -6,
                -4,
                3,
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0)).setParentsHidden("ElectricMagicTools")
                        .setPages(new ResearchPage("tc.research_page.CompressedSolars")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CompressedSolars",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0),
                new AspectList().add(Aspect.AIR, 50).add(Aspect.WATER, 50).add(Aspect.EARTH, 50).add(Aspect.FIRE, 50)
                        .add(Aspect.ORDER, 50).add(Aspect.ENTROPY, 50),
                "abc",
                "def",
                "ghi",
                'a',
                ItemList.Machine_ULV_SolarPanel.get(1L),
                'b',
                ItemList.Machine_ULV_SolarPanel.get(1L),
                'c',
                ItemList.Machine_ULV_SolarPanel.get(1L),
                'd',
                ItemList.Machine_ULV_SolarPanel.get(1L),
                'e',
                NHItemList.ReinforcedAluminiumIronPlate.get(),
                'f',
                ItemList.Machine_ULV_SolarPanel.get(1L),
                'g',
                ItemList.Machine_ULV_SolarPanel.get(1L),
                'h',
                ItemList.Machine_ULV_SolarPanel.get(1L),
                'i',
                ItemList.Machine_ULV_SolarPanel.get(1L));
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "CompressedSolars",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1),
                new AspectList().add(Aspect.AIR, 100).add(Aspect.WATER, 100).add(Aspect.EARTH, 100)
                        .add(Aspect.FIRE, 100).add(Aspect.ORDER, 100).add(Aspect.ENTROPY, 100),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0),
                'b',
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0),
                'c',
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0),
                'd',
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0),
                'e',
                NHItemList.IrradiantReinforcedTitaniumPlate.get(),
                'f',
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0),
                'g',
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0),
                'h',
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0),
                'i',
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0));
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1))));
        TCHelper.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2),
                15,
                new AspectList().add(Aspect.AIR, 150).add(Aspect.WATER, 150).add(Aspect.EARTH, 150)
                        .add(Aspect.FIRE, 150).add(Aspect.ORDER, 150).add(Aspect.ENTROPY, 150),
                NHItemList.IrradiantReinforcedTungstenSteelPlate.get(),
                NHItemList.IrradiantReinforcedTungstenSteelPlate.get(),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1),
                NHItemList.IrradiantReinforcedTungstenSteelPlate.get(),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1));
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2))));
        TCHelper.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0),
                20,
                new AspectList().add(Aspect.AIR, 300).add(Aspect.WATER, 300).add(Aspect.EARTH, 300)
                        .add(Aspect.FIRE, 300).add(Aspect.ORDER, 300).add(Aspect.ENTROPY, 300),
                NHItemList.IrradiantReinforcedChromePlate.get(),
                NHItemList.IrradiantReinforcedChromePlate.get(),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2),
                NHItemList.IrradiantReinforcedChromePlate.get(),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2));
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0))));
        TCHelper.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7),
                20,
                new AspectList().add(Aspect.AIR, 600).add(Aspect.WATER, 600).add(Aspect.EARTH, 600)
                        .add(Aspect.FIRE, 600).add(Aspect.ORDER, 600).add(Aspect.ENTROPY, 600),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 8),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 8),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 8),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0));
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7))));
        TCHelper.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14),
                20,
                new AspectList().add(Aspect.AIR, 1200).add(Aspect.WATER, 1200).add(Aspect.EARTH, 1200)
                        .add(Aspect.FIRE, 1200).add(Aspect.ORDER, 1200).add(Aspect.ENTROPY, 1200),
                NHItemList.IrradiantReinforcedNaquadriaPlate.get(),
                NHItemList.IrradiantReinforcedNaquadriaPlate.get(),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7),
                NHItemList.IrradiantReinforcedNaquadriaPlate.get(),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7));
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14))));
        TCHelper.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5),
                20,
                new AspectList().add(Aspect.AIR, 2400).add(Aspect.WATER, 2400).add(Aspect.EARTH, 2400)
                        .add(Aspect.FIRE, 2400).add(Aspect.ORDER, 2400).add(Aspect.ENTROPY, 2400),
                NHItemList.IrradiantReinforcedNeutroniumPlate.get(),
                NHItemList.IrradiantReinforcedNeutroniumPlate.get(),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14),
                NHItemList.IrradiantReinforcedNeutroniumPlate.get(),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14));
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5))));
        TCHelper.addInfusionCraftingRecipe(
                "CompressedSolars",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 12),
                20,
                new AspectList().add(Aspect.AIR, 4800).add(Aspect.WATER, 4800).add(Aspect.EARTH, 4800)
                        .add(Aspect.FIRE, 4800).add(Aspect.ORDER, 4800).add(Aspect.ENTROPY, 4800),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 13),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 13),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5),
                getModItem(AdvancedSolarPanel.ID, "asp_crafting_items", 1, 13),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5));
        TCHelper.addResearchPage(
                "CompressedSolars",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 12))));
        TCHelper.orphanResearch("Water Infused Solar Panels");
        TCHelper.removeResearch("Water Infused Solar Panels");
        new ResearchItem(
                "WaterInfusedSolarPanels",
                "EMT",
                new AspectList().add(Aspect.WATER, 15).add(Aspect.MAGIC, 12).add(Aspect.ENERGY, 9).add(Aspect.LIGHT, 6)
                        .add(Aspect.GREED, 3),
                -7,
                -7,
                3,
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 3)).setParents("CompressedSolars").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.WaterInfusedSolarPanels")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 3),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0),
                new AspectList().add(Aspect.WATER, 32).add(Aspect.EXCHANGE, 32).add(Aspect.MAGIC, 32)
                        .add(Aspect.LIGHT, 16));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 3))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 4),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1),
                new AspectList().add(Aspect.WATER, 64).add(Aspect.EXCHANGE, 64).add(Aspect.MAGIC, 64)
                        .add(Aspect.LIGHT, 32));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 4))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 5),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2),
                new AspectList().add(Aspect.WATER, 128).add(Aspect.EXCHANGE, 128).add(Aspect.MAGIC, 128)
                        .add(Aspect.LIGHT, 64));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 5))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 5),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0),
                new AspectList().add(Aspect.WATER, 256).add(Aspect.EXCHANGE, 256).add(Aspect.MAGIC, 256)
                        .add(Aspect.LIGHT, 128));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 5))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 12),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7),
                new AspectList().add(Aspect.WATER, 512).add(Aspect.EXCHANGE, 512).add(Aspect.MAGIC, 512)
                        .add(Aspect.LIGHT, 256));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 12))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 3),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14),
                new AspectList().add(Aspect.WATER, 1024).add(Aspect.EXCHANGE, 1024).add(Aspect.MAGIC, 1024)
                        .add(Aspect.LIGHT, 512));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 3))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 10),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5),
                new AspectList().add(Aspect.WATER, 2048).add(Aspect.EXCHANGE, 2048).add(Aspect.MAGIC, 2048)
                        .add(Aspect.LIGHT, 1024));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 10))));
        ThaumcraftApi.addCrucibleRecipe(
                "WaterInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars5", 1, 1),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 12),
                new AspectList().add(Aspect.WATER, 4096).add(Aspect.EXCHANGE, 4096).add(Aspect.MAGIC, 4096)
                        .add(Aspect.LIGHT, 2048));
        TCHelper.addResearchPage(
                "WaterInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars5", 1, 1))));
        TCHelper.orphanResearch("Entropy Infused Solar Panels");
        TCHelper.removeResearch("Entropy Infused Solar Panels");
        new ResearchItem(
                "EntropyInfusedSolarPanels",
                "EMT",
                new AspectList().add(Aspect.ENTROPY, 15).add(Aspect.MAGIC, 12).add(Aspect.ENERGY, 9)
                        .add(Aspect.LIGHT, 6).add(Aspect.GREED, 3),
                -8,
                -6,
                3,
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 6)).setParents("CompressedSolars").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.EntropyInfusedSolarPanels"))
                        .registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 6),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0),
                new AspectList().add(Aspect.ENTROPY, 32).add(Aspect.EXCHANGE, 32).add(Aspect.MAGIC, 32)
                        .add(Aspect.LIGHT, 16));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 6))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 7),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1),
                new AspectList().add(Aspect.ENTROPY, 64).add(Aspect.EXCHANGE, 64).add(Aspect.MAGIC, 64)
                        .add(Aspect.LIGHT, 32));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 7))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 8),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2),
                new AspectList().add(Aspect.ENTROPY, 128).add(Aspect.EXCHANGE, 128).add(Aspect.MAGIC, 128)
                        .add(Aspect.LIGHT, 64));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 8))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 2),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0),
                new AspectList().add(Aspect.ENTROPY, 256).add(Aspect.EXCHANGE, 256).add(Aspect.MAGIC, 256)
                        .add(Aspect.LIGHT, 128));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 2))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 9),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7),
                new AspectList().add(Aspect.ENTROPY, 512).add(Aspect.EXCHANGE, 512).add(Aspect.MAGIC, 512)
                        .add(Aspect.LIGHT, 256));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 9))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14),
                new AspectList().add(Aspect.ENTROPY, 1024).add(Aspect.EXCHANGE, 1024).add(Aspect.MAGIC, 1024)
                        .add(Aspect.LIGHT, 512));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 0))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 7),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5),
                new AspectList().add(Aspect.ENTROPY, 2048).add(Aspect.EXCHANGE, 2048).add(Aspect.MAGIC, 2048)
                        .add(Aspect.LIGHT, 1024));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 7))));
        ThaumcraftApi.addCrucibleRecipe(
                "EntropyInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 14),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 12),
                new AspectList().add(Aspect.ENTROPY, 4096).add(Aspect.EXCHANGE, 4096).add(Aspect.MAGIC, 4096)
                        .add(Aspect.LIGHT, 2048));
        TCHelper.addResearchPage(
                "EntropyInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 14))));
        TCHelper.orphanResearch("Order Infused Solar Panels");
        TCHelper.removeResearch("Order Infused Solar Panels");
        new ResearchItem(
                "OrderInfusedSolarPanels",
                "EMT",
                new AspectList().add(Aspect.ORDER, 15).add(Aspect.MAGIC, 12).add(Aspect.ENERGY, 9).add(Aspect.LIGHT, 6)
                        .add(Aspect.GREED, 3),
                -6,
                -8,
                3,
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 9)).setParents("CompressedSolars").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.OrderInfusedSolarPanels")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 9),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0),
                new AspectList().add(Aspect.ORDER, 32).add(Aspect.EXCHANGE, 32).add(Aspect.MAGIC, 32)
                        .add(Aspect.LIGHT, 16));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 9))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 10),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1),
                new AspectList().add(Aspect.ORDER, 64).add(Aspect.EXCHANGE, 64).add(Aspect.MAGIC, 64)
                        .add(Aspect.LIGHT, 32));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 10))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 11),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2),
                new AspectList().add(Aspect.ORDER, 128).add(Aspect.EXCHANGE, 128).add(Aspect.MAGIC, 128)
                        .add(Aspect.LIGHT, 64));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 11))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 1),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0),
                new AspectList().add(Aspect.ORDER, 256).add(Aspect.EXCHANGE, 256).add(Aspect.MAGIC, 256)
                        .add(Aspect.LIGHT, 128));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 1))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 8),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7),
                new AspectList().add(Aspect.ORDER, 512).add(Aspect.EXCHANGE, 512).add(Aspect.MAGIC, 512)
                        .add(Aspect.LIGHT, 256));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 8))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14),
                new AspectList().add(Aspect.ORDER, 1024).add(Aspect.EXCHANGE, 1024).add(Aspect.MAGIC, 1024)
                        .add(Aspect.LIGHT, 512));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 15))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 6),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5),
                new AspectList().add(Aspect.ORDER, 2048).add(Aspect.EXCHANGE, 2048).add(Aspect.MAGIC, 2048)
                        .add(Aspect.LIGHT, 1024));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 6))));
        ThaumcraftApi.addCrucibleRecipe(
                "OrderInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 13),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 12),
                new AspectList().add(Aspect.ORDER, 4096).add(Aspect.EXCHANGE, 4096).add(Aspect.MAGIC, 4096)
                        .add(Aspect.LIGHT, 2048));
        TCHelper.addResearchPage(
                "OrderInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 13))));
        TCHelper.orphanResearch("Fire Infused Solar Panels");
        TCHelper.removeResearch("Fire Infused Solar Panels");
        new ResearchItem(
                "FireInfusedSolarPanels",
                "EMT",
                new AspectList().add(Aspect.FIRE, 15).add(Aspect.MAGIC, 12).add(Aspect.ENERGY, 9).add(Aspect.LIGHT, 6)
                        .add(Aspect.GREED, 3),
                -5,
                -7,
                3,
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 12)).setParents("CompressedSolars").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.FireInfusedSolarPanels")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 12),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0),
                new AspectList().add(Aspect.FIRE, 32).add(Aspect.EXCHANGE, 32).add(Aspect.MAGIC, 32)
                        .add(Aspect.LIGHT, 16));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 12))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 13),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1),
                new AspectList().add(Aspect.FIRE, 64).add(Aspect.EXCHANGE, 64).add(Aspect.MAGIC, 64)
                        .add(Aspect.LIGHT, 32));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 13))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 14),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2),
                new AspectList().add(Aspect.FIRE, 128).add(Aspect.EXCHANGE, 128).add(Aspect.MAGIC, 128)
                        .add(Aspect.LIGHT, 64));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 14))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 6),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0),
                new AspectList().add(Aspect.FIRE, 256).add(Aspect.EXCHANGE, 256).add(Aspect.MAGIC, 256)
                        .add(Aspect.LIGHT, 128));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 6))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 13),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7),
                new AspectList().add(Aspect.FIRE, 512).add(Aspect.EXCHANGE, 512).add(Aspect.MAGIC, 512)
                        .add(Aspect.LIGHT, 256));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 13))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 4),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14),
                new AspectList().add(Aspect.FIRE, 1024).add(Aspect.EXCHANGE, 1024).add(Aspect.MAGIC, 1024)
                        .add(Aspect.LIGHT, 512));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 4))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 11),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5),
                new AspectList().add(Aspect.FIRE, 2048).add(Aspect.EXCHANGE, 2048).add(Aspect.MAGIC, 2048)
                        .add(Aspect.LIGHT, 1024));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 11))));
        ThaumcraftApi.addCrucibleRecipe(
                "FireInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars5", 1, 2),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 12),
                new AspectList().add(Aspect.FIRE, 4096).add(Aspect.EXCHANGE, 4096).add(Aspect.MAGIC, 4096)
                        .add(Aspect.LIGHT, 2048));
        TCHelper.addResearchPage(
                "FireInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars5", 1, 2))));
        TCHelper.orphanResearch("Air Infused Solar Panels");
        TCHelper.removeResearch("Air Infused Solar Panels");
        new ResearchItem(
                "AirInfusedSolarPanels",
                "EMT",
                new AspectList().add(Aspect.AIR, 15).add(Aspect.MAGIC, 12).add(Aspect.ENERGY, 9).add(Aspect.LIGHT, 6)
                        .add(Aspect.GREED, 3),
                -4,
                -6,
                3,
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 15)).setParents("CompressedSolars").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.AirInfusedSolarPanels")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0),
                new AspectList().add(Aspect.AIR, 32).add(Aspect.EXCHANGE, 32).add(Aspect.MAGIC, 32)
                        .add(Aspect.LIGHT, 16));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 15))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1),
                new AspectList().add(Aspect.AIR, 64).add(Aspect.EXCHANGE, 64).add(Aspect.MAGIC, 64)
                        .add(Aspect.LIGHT, 32));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 0))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 1),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2),
                new AspectList().add(Aspect.AIR, 128).add(Aspect.EXCHANGE, 128).add(Aspect.MAGIC, 128)
                        .add(Aspect.LIGHT, 64));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 1))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 3),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0),
                new AspectList().add(Aspect.AIR, 256).add(Aspect.EXCHANGE, 256).add(Aspect.MAGIC, 256)
                        .add(Aspect.LIGHT, 128));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 3))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 10),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7),
                new AspectList().add(Aspect.AIR, 512).add(Aspect.EXCHANGE, 512).add(Aspect.MAGIC, 512)
                        .add(Aspect.LIGHT, 256));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 10))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 1),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14),
                new AspectList().add(Aspect.AIR, 1024).add(Aspect.EXCHANGE, 1024).add(Aspect.MAGIC, 1024)
                        .add(Aspect.LIGHT, 512));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 1))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 8),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5),
                new AspectList().add(Aspect.AIR, 2048).add(Aspect.EXCHANGE, 2048).add(Aspect.MAGIC, 2048)
                        .add(Aspect.LIGHT, 1024));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 8))));
        ThaumcraftApi.addCrucibleRecipe(
                "AirInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 12),
                new AspectList().add(Aspect.AIR, 4096).add(Aspect.EXCHANGE, 4096).add(Aspect.MAGIC, 4096)
                        .add(Aspect.LIGHT, 2048));
        TCHelper.addResearchPage(
                "AirInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 15))));
        TCHelper.orphanResearch("Earth Infused Solar Panels");
        TCHelper.removeResearch("Earth Infused Solar Panels");
        new ResearchItem(
                "EarthInfusedSolarPanels",
                "EMT",
                new AspectList().add(Aspect.EARTH, 15).add(Aspect.MAGIC, 12).add(Aspect.ENERGY, 9).add(Aspect.LIGHT, 6)
                        .add(Aspect.GREED, 3),
                -6,
                -7,
                3,
                getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 2)).setParents("CompressedSolars").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.EarthInfusedSolarPanels")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 2),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 0),
                new AspectList().add(Aspect.EARTH, 32).add(Aspect.EXCHANGE, 32).add(Aspect.MAGIC, 32)
                        .add(Aspect.LIGHT, 16));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 2))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 3),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 1),
                new AspectList().add(Aspect.EARTH, 64).add(Aspect.EXCHANGE, 64).add(Aspect.MAGIC, 64)
                        .add(Aspect.LIGHT, 32));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 3))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 4),
                getModItem(ElectroMagicTools.ID, "EMTSolars", 1, 2),
                new AspectList().add(Aspect.EARTH, 128).add(Aspect.EXCHANGE, 128).add(Aspect.MAGIC, 128)
                        .add(Aspect.LIGHT, 64));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars2", 1, 4))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 4),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 0),
                new AspectList().add(Aspect.EARTH, 256).add(Aspect.EXCHANGE, 256).add(Aspect.MAGIC, 256)
                        .add(Aspect.LIGHT, 128));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 4))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 11),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 7),
                new AspectList().add(Aspect.EARTH, 512).add(Aspect.EXCHANGE, 512).add(Aspect.MAGIC, 512)
                        .add(Aspect.LIGHT, 256));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 11))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 2),
                getModItem(ElectroMagicTools.ID, "EMTSolars3", 1, 14),
                new AspectList().add(Aspect.EARTH, 1024).add(Aspect.EXCHANGE, 1024).add(Aspect.MAGIC, 1024)
                        .add(Aspect.LIGHT, 512));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 2))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 9),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 5),
                new AspectList().add(Aspect.EARTH, 2048).add(Aspect.EXCHANGE, 2048).add(Aspect.MAGIC, 2048)
                        .add(Aspect.LIGHT, 1024));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 9))));
        ThaumcraftApi.addCrucibleRecipe(
                "EarthInfusedSolarPanels",
                getModItem(ElectroMagicTools.ID, "EMTSolars5", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTSolars4", 1, 12),
                new AspectList().add(Aspect.EARTH, 4096).add(Aspect.EXCHANGE, 4096).add(Aspect.MAGIC, 4096)
                        .add(Aspect.LIGHT, 2048));
        TCHelper.addResearchPage(
                "EarthInfusedSolarPanels",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTSolars5", 1, 0))));
        TCHelper.orphanResearch("Electric Hoe of Growth");
        TCHelper.removeResearch("Electric Hoe of Growth");
        new ResearchItem(
                "ElectricHoeofGrowth",
                "EMT",
                new AspectList().add(Aspect.ENERGY, 15).add(Aspect.CROP, 12).add(Aspect.MAGIC, 9).add(Aspect.PLANT, 6)
                        .add(TCAspects.ELECTRUM.getAspect(), 3),
                2,
                -2,
                3,
                getModItem(ElectroMagicTools.ID, "ElectricHoeGrowth", 1, 0))
                        .setParents("ELEMENTALHOE", "ElectricMagicTools").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.ElectricHoeofGrowth")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ElectricHoeofGrowth",
                getModItem(ElectroMagicTools.ID, "ElectricHoeGrowth", 1, 1561),
                8,
                new AspectList().add(Aspect.ENERGY, 32).add(Aspect.CROP, 32).add(Aspect.MAGIC, 48).add(Aspect.PLANT, 16)
                        .add(TCAspects.ELECTRUM.getAspect(), 8),
                getModItem(Thaumcraft.ID, "ItemHoeElemental", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemToolHoe", 1, wildcard),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                OrePrefixes.circuit.get(Materials.LuV),
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard),
                OrePrefixes.plate.get(Materials.Void),
                getModItem(IndustrialCraft2.ID, "upgradeModule", 1, 0),
                OrePrefixes.circuit.get(Materials.LuV),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0));
        TCHelper.addResearchPage(
                "ElectricHoeofGrowth",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "ElectricHoeGrowth", 1, 1561))));
        TCHelper.orphanResearch("Electric Scribing Tools");
        TCHelper.removeResearch("Electric Scribing Tools");
        new ResearchItem(
                "ElectricScribingTools",
                "EMT",
                new AspectList().add(Aspect.ENERGY, 15).add(Aspect.DARKNESS, 12).add(Aspect.CRAFT, 9)
                        .add(Aspect.MAGIC, 6).add(TCAspects.ELECTRUM.getAspect(), 3),
                6,
                -4,
                3,
                getModItem(ElectroMagicTools.ID, "ElectricScribingTools", 1, 0)).setParentsHidden("ElectricMagicTools")
                        .setParents("RESEARCH").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.ElectricScribingTools")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ElectricScribingTools",
                getModItem(ElectroMagicTools.ID, "ElectricScribingTools", 1, 400),
                new AspectList().add(Aspect.AIR, 20).add(Aspect.FIRE, 20).add(Aspect.WATER, 20).add(Aspect.ORDER, 20),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitAdvanced",
                'b',
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0),
                'c',
                "circuitAdvanced",
                'd',
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0),
                'e',
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                'f',
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0),
                'g',
                "circuitAdvanced",
                'h',
                getModItem(Thaumcraft.ID, "ItemInkwell", 1, 0),
                'i',
                "circuitAdvanced");
        TCHelper.addResearchPage(
                "ElectricScribingTools",
                new ResearchPage(
                        TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "ElectricScribingTools", 1, 400))));
        TCHelper.orphanResearch("Mjolnir");
        TCHelper.removeResearch("Mjolnir");
        new ResearchItem(
                "Mjolnirnew",
                "EMT",
                new AspectList().add(Aspect.WEAPON, 18).add(Aspect.WEATHER, 15).add(Aspect.ELDRITCH, 12)
                        .add(DarkAspects.WRATH, 9).add(Aspect.AIR, 6).add(Aspect.FIRE, 3),
                4,
                -5,
                3,
                getModItem(ElectroMagicTools.ID, "Mjolnir", 1, 0)).setParents("The Legend")
                        .setParentsHidden("ElectricMagicTools").registerResearchItem();
        TCHelper.addResearchPrereq("Mjolnirnew", "ELEMENTALSWORD", false);
        TCHelper.addResearchPrereq("Mjolnirnew", "FOCUSSHOCK", false);
        TCHelper.addResearchPrereq("Mjolnirnew", "NITOR", false);
        ResearchCategories.getResearch("Mjolnirnew").setConcealed();
        ResearchCategories.getResearch("Mjolnirnew").setRound();
        TCHelper.addResearchPage("Mjolnirnew", new ResearchPage("tc.research_page.Mjolnirnew"));
        TCHelper.addInfusionCraftingRecipe(
                "Mjolnirnew",
                getModItem(ElectroMagicTools.ID, "Mjolnir", 1, 0),
                10,
                new AspectList().add(Aspect.WEAPON, 48).add(Aspect.WEATHER, 48).add(Aspect.ELDRITCH, 32)
                        .add(DarkAspects.WRATH, 24).add(Aspect.AIR, 16).add(Aspect.FIRE, 16),
                getModItem(ElectroMagicTools.ID, "TaintedMjolnir", 1, 0),
                getModItem(Thaumcraft.ID, "ItemSwordElemental", 1, 0),
                OrePrefixes.plate.get(Materials.Rubber),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 6),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                OrePrefixes.plate.get(Materials.Rubber),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                getModItem(Thaumcraft.ID, "FocusShock", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                OrePrefixes.plate.get(Materials.Rubber),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 6),
                OrePrefixes.plate.get(Materials.Rubber));
        TCHelper.addResearchPage(
                "Mjolnirnew",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "Mjolnir", 1, 0))));
        TCHelper.orphanResearch("Supercharged Mjolnir");
        TCHelper.removeResearch("Supercharged Mjolnir");
        new ResearchItem(
                "SuperchargedMjolnir",
                "EMT",
                new AspectList().add(Aspect.WEAPON, 21).add(Aspect.WEATHER, 18).add(Aspect.ELDRITCH, 15)
                        .add(Aspect.BEAST, 12).add(DarkAspects.WRATH, 9).add(Aspect.AIR, 6).add(Aspect.FIRE, 3),
                3,
                -5,
                3,
                getModItem(ElectroMagicTools.ID, "SuperchargedMjolnir", 1, 0))
                        .setParents("Mjolnirnew", "FOCUSHELLBAT", "ALUMENTUM").setConcealed().setRound()
                        .setPages(new ResearchPage("tc.research_page.SuperchargedMjolnir")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "SuperchargedMjolnir",
                getModItem(ElectroMagicTools.ID, "SuperchargedMjolnir", 1, 27),
                15,
                new AspectList().add(Aspect.WEAPON, 64).add(Aspect.ENERGY, 64).add(Aspect.ELDRITCH, 48)
                        .add(DarkAspects.WRATH, 32).add(Aspect.AIR, 24).add(Aspect.FIRE, 24).add(Aspect.BEAST, 16),
                getModItem(ElectroMagicTools.ID, "Mjolnir", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemNanoSaber", 1, wildcard),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard),
                getModItem(Thaumcraft.ID, "FocusHellbat", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0));
        TCHelper.addResearchPage(
                "SuperchargedMjolnir",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "SuperchargedMjolnir", 1, 27))));
        TCHelper.orphanResearch("Lightning Summoner");
        TCHelper.removeResearch("Lightning Summoner");
        new ResearchItem(
                "LightningSummoner",
                "EMT",
                new AspectList().add(Aspect.WEATHER, 15).add(Aspect.AIR, 12).add(Aspect.FIRE, 9)
                        .add(TCAspects.NEBRISUM.getAspect(), 6).add(Aspect.EXCHANGE, 3),
                6,
                -5,
                3,
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 6)).setParents("FOCUSSHOCK", "NITOR", "ALUMENTUM")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.LightningSummoner"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "LightningSummoner",
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 6),
                9,
                new AspectList().add(Aspect.WEATHER, 16).add(Aspect.AIR, 24).add(Aspect.FIRE, 16)
                        .add(TCAspects.NEBRISUM.getAspect(), 8).add(Aspect.EXCHANGE, 8),
                getModItem(Thaumcraft.ID, "FocusShock", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                getModItem(Minecraft.ID, "skull", 1, 4),
                getModItem(Minecraft.ID, "tnt", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                getModItem(Minecraft.ID, "skull", 1, 4),
                getModItem(Minecraft.ID, "tnt", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                getModItem(Minecraft.ID, "skull", 1, 4),
                getModItem(Minecraft.ID, "tnt", 1, 0));
        TCHelper.addResearchPage(
                "LightningSummoner",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 6))));
        TCHelper.orphanResearch("Tiny Uranium");
        TCHelper.removeResearch("Tiny Uranium");
        new ResearchItem(
                "TinyUranium",
                "EMT",
                new AspectList().add(Aspect.EXCHANGE, 15).add(Aspect.POISON, 12).add(Aspect.DEATH, 9)
                        .add(Aspect.MAGIC, 6).add(Aspect.METAL, 3),
                5,
                -4,
                3,
                ItemList.IC2_Uranium_235_Small.get(1)).setParentsHidden("ElectricMagicTools").setParents("RESEARCH")
                        .setConcealed().setRound().setPages(new ResearchPage("tc.research_page.TinyUranium"))
                        .registerResearchItem();
        ThaumcraftApi.addShapelessArcaneCraftingRecipe(
                "TinyUranium",
                ItemList.IC2_Uranium_235_Small.get(7),
                new AspectList().add(Aspect.AIR, 7).add(Aspect.FIRE, 7).add(Aspect.WATER, 7).add(Aspect.EARTH, 7)
                        .add(Aspect.ORDER, 7).add(Aspect.ENTROPY, 7),
                ItemList.IC2_Uranium_238.get(1));
        TCHelper.addResearchPage(
                "TinyUranium",
                new ResearchPage(TCHelper.findArcaneRecipe(ItemList.IC2_Uranium_235_Small.get(1))));
        TCHelper.orphanResearch("UU-Matter Infusion");
        TCHelper.removeResearch("UU-Matter Infusion");
        new ResearchItem(
                "UUMatterInfusion",
                "EMT",
                new AspectList().add(Aspect.CRAFT, 15).add(Aspect.ELDRITCH, 12).add(Aspect.EXCHANGE, 9)
                        .add(Aspect.MAGIC, 6).add(Aspect.CRYSTAL, 3),
                5,
                -3,
                3,
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15)).setParentsHidden("ElectricMagicTools").setRound()
                        .setPages(new ResearchPage("tc.research_page.UUMatterInfusion")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "UUMatterInfusion",
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(IndustrialCraft2.ID, "itemCellEmpty", 1, 3),
                new AspectList().add(Aspect.CRYSTAL, 16).add(Aspect.COLD, 8).add(Aspect.MAGIC, 8)
                        .add(Aspect.EXCHANGE, 8));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15))));
        TCHelper.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem(Minecraft.ID, "coal", 16, 0),
                6,
                new AspectList().add(Aspect.AIR, 8).add(Aspect.WATER, 8).add(Aspect.EARTH, 16).add(Aspect.FIRE, 8)
                        .add(Aspect.ENTROPY, 8).add(Aspect.ORDER, 16),
                getModItem(Minecraft.ID, "coal", 1, 1),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Minecraft.ID, "coal", 1, 0))));
        TCHelper.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem(Minecraft.ID, "glowstone", 1, 0),
                3,
                new AspectList().add(Aspect.AIR, 4).add(Aspect.WATER, 4).add(Aspect.EARTH, 4).add(Aspect.FIRE, 4)
                        .add(Aspect.ENTROPY, 4).add(Aspect.ORDER, 8),
                getModItem(Minecraft.ID, "glowstone_dust", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Minecraft.ID, "glowstone", 1, 0))));
        TCHelper.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Iron, 32L),
                6,
                new AspectList().add(Aspect.AIR, 8).add(Aspect.WATER, 8).add(Aspect.EARTH, 16).add(Aspect.FIRE, 8)
                        .add(Aspect.ENTROPY, 8).add(Aspect.ORDER, 16),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Iron, 1L))));
        TCHelper.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Copper, 32L),
                6,
                new AspectList().add(Aspect.AIR, 8).add(Aspect.WATER, 8).add(Aspect.EARTH, 16).add(Aspect.FIRE, 8)
                        .add(Aspect.ENTROPY, 8).add(Aspect.ORDER, 16),
                OrePrefixes.ingot.get(Materials.Copper),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Copper, 1L))));
        TCHelper.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Tin, 32L),
                6,
                new AspectList().add(Aspect.AIR, 8).add(Aspect.WATER, 8).add(Aspect.EARTH, 16).add(Aspect.FIRE, 8)
                        .add(Aspect.ENTROPY, 8).add(Aspect.ORDER, 16),
                OrePrefixes.ingot.get(Materials.Tin),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Tin, 1L))));
        TCHelper.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Gold, 32L),
                6,
                new AspectList().add(Aspect.AIR, 8).add(Aspect.WATER, 8).add(Aspect.EARTH, 16).add(Aspect.FIRE, 8)
                        .add(Aspect.ENTROPY, 8).add(Aspect.ORDER, 16),
                getModItem(Minecraft.ID, "gold_ingot", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Gold, 1L))));
        TCHelper.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Uranium, 32L),
                6,
                new AspectList().add(Aspect.AIR, 8).add(Aspect.WATER, 8).add(Aspect.EARTH, 16).add(Aspect.FIRE, 8)
                        .add(Aspect.ENTROPY, 8).add(Aspect.ORDER, 16),
                ItemList.IC2_Uranium_238.get(1),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Uranium, 1L))));
        TCHelper.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Silver, 32L),
                6,
                new AspectList().add(Aspect.AIR, 8).add(Aspect.WATER, 8).add(Aspect.EARTH, 16).add(Aspect.FIRE, 8)
                        .add(Aspect.ENTROPY, 8).add(Aspect.ORDER, 16),
                OrePrefixes.ingot.get(Materials.Silver),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Silver, 1L))));
        TCHelper.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Lead, 32L),
                6,
                new AspectList().add(Aspect.AIR, 8).add(Aspect.WATER, 8).add(Aspect.EARTH, 16).add(Aspect.FIRE, 8)
                        .add(Aspect.ENTROPY, 8).add(Aspect.ORDER, 16),
                OrePrefixes.ingot.get(Materials.Lead),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Lead, 1L))));
        TCHelper.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Redstone, 24L),
                9,
                new AspectList().add(Aspect.AIR, 12).add(Aspect.WATER, 12).add(Aspect.EARTH, 24).add(Aspect.FIRE, 12)
                        .add(Aspect.ENTROPY, 12).add(Aspect.ORDER, 24),
                getModItem(Minecraft.ID, "redstone", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Redstone, 1L))));
        TCHelper.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Lapis, 24L),
                9,
                new AspectList().add(Aspect.AIR, 12).add(Aspect.WATER, 12).add(Aspect.EARTH, 24).add(Aspect.FIRE, 12)
                        .add(Aspect.ENTROPY, 12).add(Aspect.ORDER, 24),
                getModItem(Minecraft.ID, "dye", 1, 4),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(
                                GTOreDictUnificator.get(OrePrefixes.crushed, Materials.Lapis, 1L))));
        TCHelper.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem(Minecraft.ID, "gold_ingot", 2, 0),
                9,
                new AspectList().add(Aspect.AIR, 8).add(Aspect.WATER, 8).add(Aspect.EARTH, 16).add(Aspect.FIRE, 8)
                        .add(Aspect.ENTROPY, 8).add(Aspect.ORDER, 16),
                getModItem(Minecraft.ID, "iron_ingot", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Minecraft.ID, "gold_ingot", 1, 0))));
        TCHelper.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem(Minecraft.ID, "diamond", 1, 0),
                12,
                new AspectList().add(Aspect.AIR, 16).add(Aspect.WATER, 16).add(Aspect.EARTH, 32).add(Aspect.FIRE, 16)
                        .add(Aspect.ENTROPY, 16).add(Aspect.ORDER, 32),
                getModItem(Minecraft.ID, "gold_ingot", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(Minecraft.ID, "diamond", 1, 0))));
        TCHelper.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                ItemList.IC2_Uranium_238.get(2),
                15,
                new AspectList().add(Aspect.AIR, 24).add(Aspect.WATER, 24).add(Aspect.EARTH, 48).add(Aspect.FIRE, 24)
                        .add(Aspect.ENTROPY, 24).add(Aspect.ORDER, 48),
                getModItem(Minecraft.ID, "diamond", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(ItemList.IC2_Uranium_238.get(1))));
        TCHelper.addInfusionCraftingRecipe(
                "UUMatterInfusion",
                getModItem(IndustrialCraft2.ID, "itemOreIridium", 2, 0),
                18,
                new AspectList().add(Aspect.AIR, 32).add(Aspect.WATER, 32).add(Aspect.EARTH, 64).add(Aspect.FIRE, 32)
                        .add(Aspect.ENTROPY, 32).add(Aspect.ORDER, 64),
                ItemList.IC2_Uranium_238.get(1),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15),
                getModItem(ElectroMagicTools.ID, "EMTItems", 1, 15));
        TCHelper.addResearchPage(
                "UUMatterInfusion",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(IndustrialCraft2.ID, "itemOreIridium", 1, 0))));
        TCHelper.orphanResearch("Portable Node");
        TCHelper.removeResearch("Portable Node");
        new ResearchItem(
                "PortableNode",
                "EMT",
                new AspectList().add(Aspect.AURA, 15).add(Aspect.ELDRITCH, 12).add(Aspect.GREED, 9).add(Aspect.MAGIC, 6)
                        .add(Aspect.CRYSTAL, 3),
                6,
                -3,
                3,
                getModItem(ElectroMagicTools.ID, "PortableNode", 1, 0)).setParentsHidden("ElectricMagicTools")
                        .setRound()
                        .setPages(
                                new ResearchPage("tc.research_page.PortableNode"),
                                new ResearchPage(
                                        TCHelper.findCrucibleRecipe(
                                                getModItem(ElectroMagicTools.ID, "PortableNode", 1, 0))))
                        .registerResearchItem();
        TCHelper.orphanResearch("Shield Focus");
        TCHelper.removeResearch("Shield Focus");
        new ResearchItem(
                "ShieldFocus",
                "EMT",
                new AspectList().add(Aspect.ARMOR, 15).add(Aspect.AIR, 12).add(Aspect.CRYSTAL, 9).add(Aspect.MAGIC, 6)
                        .add(Aspect.MIND, 3),
                2,
                4,
                3,
                getModItem(ElectroMagicTools.ID, "ShieldFocus", 1, 0)).setParentsHidden("ElectricMagicTools")
                        .setParents("FOCUSPORTABLEHOLE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ShieldFocus")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ShieldFocus",
                getModItem(ElectroMagicTools.ID, "ShieldFocus", 1, 0),
                9,
                new AspectList().add(Aspect.AIR, 32).add(Aspect.ARMOR, 40).add(Aspect.LIFE, 16).add(Aspect.TRAP, 24)
                        .add(Aspect.CRYSTAL, 16).add(Aspect.MAGIC, 8),
                getModItem(Thaumcraft.ID, "FocusPortableHole", 1, 0),
                OrePrefixes.plate.get(Materials.ReinforcedGlass),
                ItemList.Block_TungstenSteelReinforced.get(1L),
                "plateAlloyAdvanced",
                OrePrefixes.plate.get(Materials.Reinforced),
                ItemList.Block_TungstenSteelReinforced.get(1L),
                OrePrefixes.plate.get(Materials.ReinforcedGlass),
                ItemList.Block_TungstenSteelReinforced.get(1L),
                OrePrefixes.plate.get(Materials.Reinforced),
                "plateAlloyAdvanced",
                ItemList.Block_TungstenSteelReinforced.get(1L));
        TCHelper.addResearchPage(
                "ShieldFocus",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "ShieldFocus", 1, 0))));
        TCHelper.orphanResearch("Shield Block");
        TCHelper.removeResearch("Shield Block");
        new ResearchItem(
                "ShieldBlock",
                "EMT",
                new AspectList().add(Aspect.ARMOR, 15).add(Aspect.TRAP, 12).add(Aspect.MIND, 9).add(Aspect.MAGIC, 6)
                        .add(Aspect.ELDRITCH, 3),
                2,
                6,
                3,
                getModItem(ElectroMagicTools.ID, "ShieldBlock", 1, 0)).setParentsHidden("ElectricMagicTools")
                        .setParents("ShieldFocus").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ShieldBlock")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ShieldBlock",
                getModItem(ElectroMagicTools.ID, "ShieldBlock", 10, 0),
                new AspectList().add(Aspect.EARTH, 20).add(Aspect.ORDER, 20).add(Aspect.ENTROPY, 20),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1),
                'b',
                "plateAlloyAdvanced",
                'c',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1),
                'd',
                "plateReinforcedGlass",
                'e',
                ItemList.Block_IridiumTungstensteel.get(1L),
                'f',
                "plateReinforcedGlass",
                'g',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1),
                'h',
                "plateAlloyAdvanced",
                'i',
                getModItem(Thaumcraft.ID, "blockCosmeticSolid", 1, 1));
        TCHelper.addResearchPage(
                "ShieldBlock",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "ShieldBlock", 1, 0))));
        TCHelper.orphanResearch("Kris-tmas Focus");
        TCHelper.removeResearch("Kris-tmas Focus");
        new ResearchItem(
                "KristmasFocus",
                "EMT",
                new AspectList().add(Aspect.COLD, 15).add(Aspect.BEAST, 12).add(Aspect.LIFE, 9).add(Aspect.DEATH, 6)
                        .add(Aspect.MAGIC, 3),
                3,
                4,
                3,
                getModItem(ElectroMagicTools.ID, "ChristmasFocus", 1, 0)).setParentsHidden("ElectricMagicTools")
                        .setParents("FOCUSSHOCK").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.KristmasFocus")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "KristmasFocus",
                getModItem(ElectroMagicTools.ID, "ChristmasFocus", 1, 0),
                new AspectList().add(Aspect.AIR, 25).add(Aspect.ORDER, 25).add(Aspect.WATER, 25),
                "abc",
                "def",
                "ghi",
                'a',
                getModItem(Minecraft.ID, "pumpkin", 1, 0),
                'b',
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Snow, 1L),
                'c',
                getModItem(Minecraft.ID, "pumpkin", 1, 0),
                'd',
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 1L),
                'e',
                getModItem(Thaumcraft.ID, "FocusFrost", 1, 0),
                'f',
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Ice, 1L),
                'g',
                getModItem(Minecraft.ID, "pumpkin", 1, 0),
                'h',
                GTOreDictUnificator.get(OrePrefixes.dust, Materials.Snow, 1L),
                'i',
                getModItem(Minecraft.ID, "pumpkin", 1, 0));
        TCHelper.addResearchPage(
                "KristmasFocus",
                new ResearchPage(TCHelper.findArcaneRecipe(getModItem(ElectroMagicTools.ID, "ChristmasFocus", 1, 0))));
        TCHelper.orphanResearch("Energy Ball Focus");
        TCHelper.removeResearch("Energy Ball Focus");
        new ResearchItem(
                "EnergyBallFocus",
                "EMT",
                new AspectList().add(Aspect.ENERGY, 15).add(Aspect.MAGIC, 18).add(Aspect.LIFE, 9).add(Aspect.MIND, 3),
                4,
                4,
                3,
                getModItem(ElectroMagicTools.ID, "EnergyBallFocus", 1, 0)).setParentsHidden("ElectricMagicTools")
                        .setParents("FOCUSSHOCK").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.EnergyBallFocus")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "EnergyBallFocus",
                getModItem(ElectroMagicTools.ID, "EnergyBallFocus", 1, 0),
                6,
                new AspectList().add(Aspect.ENERGY, 24).add(Aspect.MAGIC, 30).add(Aspect.LIFE, 12).add(Aspect.MIND, 6),
                getModItem(Thaumcraft.ID, "FocusShock", 1, 0),
                getModItem(IndustrialCraft2.ID, "blockMachine2", 1, 1),
                OrePrefixes.wireGt02.get(Materials.Silver),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                OrePrefixes.wireGt02.get(Materials.Silver),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                OrePrefixes.wireGt02.get(Materials.Silver),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                OrePrefixes.wireGt02.get(Materials.Silver));
        TCHelper.addResearchPage(
                "EnergyBallFocus",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EnergyBallFocus", 1, 0))));
        ThaumcraftApi.addWarpToResearch("EnergyBallFocus", 1);
        TCHelper.orphanResearch("Explosion Focus");
        TCHelper.removeResearch("Explosion Focus");
        new ResearchItem(
                "ExplosionFocus",
                "EMT",
                new AspectList().add(Aspect.FIRE, 15).add(Aspect.DEATH, 12).add(Aspect.WEAPON, 9).add(Aspect.MAGIC, 6)
                        .add(Aspect.ENERGY, 3),
                5,
                4,
                3,
                getModItem(ElectroMagicTools.ID, "ExplosionFocus", 1, 0)).setParentsHidden("ElectricMagicTools")
                        .setParents("FOCUSHELLBAT").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ExplosionFocus")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "ExplosionFocus",
                getModItem(ElectroMagicTools.ID, "ExplosionFocus", 1, 0),
                9,
                new AspectList().add(Aspect.FIRE, 64).add(Aspect.DEATH, 24).add(Aspect.MOTION, 48)
                        .add(Aspect.WEAPON, 32).add(Aspect.MAGIC, 16).add(Aspect.ENERGY, 10),
                getModItem(Thaumcraft.ID, "FocusHellbat", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemToolMiningLaser", 1, wildcard),
                NHItemList.ReinforcedGlassLense.get(),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 1),
                getModItem(Minecraft.ID, "firework_charge", 1, 0),
                getModItem(Thaumcraft.ID, "PrimalArrow", 1, 1), // Fire Arrow
                getModItem(Minecraft.ID, "tnt", 1, 0),
                getModItem(Thaumcraft.ID, "PrimalArrow", 1, 1), // Fire Arrow
                getModItem(Minecraft.ID, "firework_charge", 1, 0),
                getModItem(Thaumcraft.ID, "ItemResource", 1, 0),
                NHItemList.ReinforcedGlassLense.get());
        TCHelper.addResearchPage(
                "ExplosionFocus",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "ExplosionFocus", 1, 0))));
        ThaumcraftApi.addWarpToResearch("ExplosionFocus", 1);
        TCHelper.orphanResearch("Wand Focus: Charging");
        TCHelper.removeResearch("Wand Focus: Charging");
        new ResearchItem(
                "WandFocusCharging",
                "EMT",
                new AspectList().add(Aspect.EXCHANGE, 15).add(Aspect.ENERGY, 12).add(Aspect.MECHANISM, 9)
                        .add(Aspect.MAGIC, 6).add(Aspect.MIND, 3),
                6,
                4,
                3,
                getModItem(ElectroMagicTools.ID, "ChargingFocus", 1, 0)).setParentsHidden("ElectricMagicTools")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.WandFocusCharging"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "WandFocusCharging",
                getModItem(ElectroMagicTools.ID, "ChargingFocus", 1, 0),
                9,
                new AspectList().add(Aspect.EXCHANGE, 48).add(Aspect.ENERGY, 24).add(Aspect.MECHANISM, 32)
                        .add(Aspect.MAGIC, 16).add(Aspect.MIND, 8),
                getModItem(IndustrialCraft2.ID, "itemBatCrystal", 1, wildcard),
                ItemList.Transformer_HV_MV.get(1L),
                OrePrefixes.rotor.get(Materials.Thaumium),
                ItemList.Electric_Motor_MV.get(1L),
                OrePrefixes.gearGtSmall.get(Materials.Thaumium),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                OrePrefixes.wireGt01.get(Materials.Silver),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                OrePrefixes.gearGtSmall.get(Materials.Thaumium),
                ItemList.Electric_Motor_MV.get(1L),
                OrePrefixes.rotor.get(Materials.Thaumium));
        TCHelper.addResearchPage(
                "WandFocusCharging",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "ChargingFocus", 1, 0))));
        TCHelper.orphanResearch("Wand Focus: Wand Charging");
        TCHelper.removeResearch("Wand Focus: Wand Charging");
        new ResearchItem(
                "WandFocusWandCharging",
                "EMT",
                new AspectList().add(Aspect.ENERGY, 18).add(Aspect.CRAFT, 15).add(Aspect.GREED, 12)
                        .add(Aspect.EXCHANGE, 9).add(Aspect.MAGIC, 6).add(Aspect.MIND, 3),
                6,
                6,
                3,
                getModItem(ElectroMagicTools.ID, "WandChargingFocus", 1, 0)).setParentsHidden("ElectricMagicTools")
                        .setParents("WandFocusCharging").registerResearchItem();
        TCHelper.addResearchPrereq("WandFocusWandCharging", "IndustrialWandChargingStation", true);
        ResearchCategories.getResearch("WandFocusWandCharging").setConcealed();
        TCHelper.addResearchPage("WandFocusWandCharging", new ResearchPage("tc.research_page.WandFocusWandCharging"));
        TCHelper.addInfusionCraftingRecipe(
                "WandFocusWandCharging",
                getModItem(ElectroMagicTools.ID, "WandChargingFocus", 1, 0),
                15,
                new AspectList().add(Aspect.ENERGY, 48).add(Aspect.CRAFT, 32).add(Aspect.GREED, 64)
                        .add(Aspect.EXCHANGE, 48).add(Aspect.MAGIC, 16).add(Aspect.MIND, 8).add(Aspect.AURA, 32),
                getModItem(ElectroMagicTools.ID, "ChargingFocus", 1, 0),
                getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 0),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                OrePrefixes.gearGtSmall.get(Materials.Void),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.wireGt01.get(Materials.TungstenSteel),
                getModItem(IndustrialCraft2.ID, "itemBatLamaCrystal", 1, wildcard),
                OrePrefixes.wireGt01.get(Materials.TungstenSteel),
                OrePrefixes.plate.get(Materials.Void),
                OrePrefixes.gearGtSmall.get(Materials.Void),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0));
        TCHelper.addResearchPage(
                "WandFocusWandCharging",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "WandChargingFocus", 1, 0))));
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
                new AspectList().add(Aspect.ENERGY, 15).add(Aspect.EXCHANGE, 12).add(Aspect.MECHANISM, 9)
                        .add(Aspect.MAGIC, 6).add(Aspect.METAL, 3),
                -4,
                2,
                3,
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0)).setParentsHidden("ElectricMagicTools")
                        .setParents("JARLABEL", "FOCUSTRADE").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.PotentiaGenerator")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "PotentiaGenerator",
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0),
                6,
                new AspectList().add(Aspect.ENERGY, 48).add(Aspect.EXCHANGE, 32).add(Aspect.MECHANISM, 16)
                        .add(Aspect.MAGIC, 32).add(Aspect.METAL, 32),
                GregtechItemList.Generator_SemiFluid_LV.get(1),
                getModItem(Thaumcraft.ID, "FocusTrade", 1, 0),
                ItemList.Emitter_MV.get(1L),
                getModItem(Minecraft.ID, "hopper", 1, 0),
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 7),
                ItemList.Transformer_HV_MV.get(1L),
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                getModItem(IndustrialCraft2.ID, "blockMachine", 1, 12),
                getModItem(IndustrialCraft2.ID, "blockElectric", 1, 7),
                ItemList.Electric_Motor_MV.get(1L),
                getModItem(Minecraft.ID, "hopper", 1, 0),
                ItemList.Emitter_MV.get(1L));
        TCHelper.addResearchPage(
                "PotentiaGenerator",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0))));
        TCHelper.orphanResearch("Ignis Generator");
        TCHelper.removeResearch("Ignis Generator");
        new ResearchItem(
                "IgnisGenerator",
                "EMT",
                new AspectList().add(Aspect.FIRE, 12).add(Aspect.EXCHANGE, 9).add(Aspect.WATER, 6).add(Aspect.MAGIC, 3),
                -6,
                4,
                3,
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 1)).setParentsHidden("ElectricMagicTools")
                        .setParents("PotentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.IgnisGenerator")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "IgnisGenerator",
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 1),
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0),
                new AspectList().add(Aspect.FIRE, 16).add(Aspect.EXCHANGE, 8).add(Aspect.MAGIC, 8));
        TCHelper.addResearchPage(
                "IgnisGenerator",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 1))));
        TCHelper.orphanResearch("Auram Generator");
        TCHelper.removeResearch("Auram Generator");
        new ResearchItem(
                "AuramGenerator",
                "EMT",
                new AspectList().add(Aspect.AURA, 12).add(Aspect.EXCHANGE, 9).add(Aspect.WATER, 6).add(Aspect.MAGIC, 3),
                -4,
                4,
                3,
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 2)).setParentsHidden("ElectricMagicTools")
                        .setParents("PotentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.AuramGenerator")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "AuramGenerator",
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 2),
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0),
                new AspectList().add(Aspect.AURA, 16).add(Aspect.EXCHANGE, 8).add(Aspect.MAGIC, 8));
        TCHelper.addResearchPage(
                "AuramGenerator",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 2))));
        TCHelper.orphanResearch("Arbor Generator");
        TCHelper.removeResearch("Arbor Generator");
        new ResearchItem(
                "ArborGenerator",
                "EMT",
                new AspectList().add(Aspect.TREE, 12).add(Aspect.EXCHANGE, 9).add(Aspect.WATER, 6).add(Aspect.MAGIC, 3),
                -2,
                4,
                3,
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 3)).setParentsHidden("ElectricMagicTools")
                        .setParents("PotentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.ArborGenerator")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "ArborGenerator",
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 3),
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0),
                new AspectList().add(Aspect.TREE, 16).add(Aspect.EXCHANGE, 8).add(Aspect.MAGIC, 8));
        TCHelper.addResearchPage(
                "ArborGenerator",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 3))));
        TCHelper.orphanResearch("Aer Generator");
        TCHelper.removeResearch("Aer Generator");
        new ResearchItem(
                "AerGenerator",
                "EMT",
                new AspectList().add(Aspect.AIR, 12).add(Aspect.EXCHANGE, 9).add(Aspect.WATER, 6).add(Aspect.MAGIC, 3),
                -4,
                6,
                3,
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 4)).setParentsHidden("ElectricMagicTools")
                        .setParents("PotentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.AerGenerator")).registerResearchItem();
        ThaumcraftApi.addCrucibleRecipe(
                "AerGenerator",
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 4),
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0),
                new AspectList().add(Aspect.AIR, 16).add(Aspect.EXCHANGE, 8).add(Aspect.MAGIC, 8));
        TCHelper.addResearchPage(
                "AerGenerator",
                new ResearchPage(
                        TCHelper.findCrucibleRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 4))));
        TCHelper.orphanResearch("Lucrum Generator");
        TCHelper.removeResearch("Lucrum Generator");
        new ResearchItem(
                "LucrumGenerator",
                "EMT",
                new AspectList().add(Aspect.GREED, 12).add(Aspect.EXCHANGE, 9).add(Aspect.WATER, 6)
                        .add(Aspect.MAGIC, 3),
                -4,
                8,
                3,
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 5))
                        .setParentsHidden("ElectricMagicTools")
                        .setParents(
                                "PotentiaGenerator",
                                "AerGenerator",
                                "IgnisGenerator",
                                "AuramGenerator",
                                "ArborGenerator")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.LucrumGenerator"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "LucrumGenerator",
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 5),
                10,
                new AspectList().add(Aspect.EXCHANGE, 128).add(Aspect.GREED, 256).add(Aspect.MAGIC, 32)
                        .add(TCAspects.NEBRISUM.getAspect(), 16),
                getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 0),
                getModItem(Minecraft.ID, "gold_block", 1, 0),
                getModItem(Minecraft.ID, "gold_block", 1, 0),
                getModItem(Minecraft.ID, "gold_block", 1, 0),
                getModItem(Minecraft.ID, "gold_block", 1, 0),
                getModItem(Minecraft.ID, "gold_block", 1, 0),
                getModItem(Minecraft.ID, "gold_block", 1, 0),
                getModItem(Minecraft.ID, "gold_block", 1, 0),
                getModItem(Minecraft.ID, "gold_block", 1, 0),
                getModItem(Minecraft.ID, "gold_block", 1, 0),
                getModItem(Minecraft.ID, "gold_block", 1, 0),
                getModItem(Minecraft.ID, "gold_block", 1, 0),
                getModItem(Minecraft.ID, "gold_block", 1, 0));
        TCHelper.addResearchPage(
                "LucrumGenerator",
                new ResearchPage(
                        TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EssentiaGenerators", 1, 5))));
        ThaumcraftApi.addWarpToResearch("LucrumGenerator", 5);
        new ResearchItem(
                "IndustrialWandChargingStation",
                "EMT",
                new AspectList().add(Aspect.EXCHANGE, 15).add(Aspect.ENERGY, 12).add(Aspect.CRAFT, 9)
                        .add(Aspect.MAGIC, 6).add(Aspect.GREED, 3),
                -6,
                2,
                3,
                getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 0)).setParentsHidden("ElectricMagicTools")
                        .setParents("PotentiaGenerator", "WANDPED", "JARLABEL").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.IndustrialWandChargingStation"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "IndustrialWandChargingStation",
                getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 0),
                9,
                new AspectList().add(Aspect.EXCHANGE, 48).add(Aspect.ENERGY, 48).add(Aspect.CRAFT, 48)
                        .add(Aspect.MAGIC, 32).add(Aspect.GREED, 64).add(Aspect.MIND, 16),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 5),
                ItemList.Machine_IV_Replicator.get(1L),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0),
                OrePrefixes.gemExquisite.get(Materials.Diamond),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                getModItem(Thaumcraft.ID, "blockJar", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                OrePrefixes.gemExquisite.get(Materials.Diamond),
                getModItem(IndustrialCraft2.ID, "itemPartIridium", 1, 0));
        TCHelper.addResearchPage(
                "IndustrialWandChargingStation",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 0))));
        ThaumcraftApi.addWarpToResearch("IndustrialWandChargingStation", 3);
        new ResearchItem(
                "EtheralProcessor",
                "EMT",
                new AspectList().add(Aspect.MECHANISM, 15).add(Aspect.CRAFT, 12).add(Aspect.ENERGY, 9)
                        .add(Aspect.MAGIC, 6).add(Aspect.MIND, 3),
                -2,
                2,
                3,
                getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 1)).setParentsHidden("ElectricMagicTools")
                        .setParents("BELLOWS", "DISTILESSENTIA", "INFERNALFURNACE", "PotentiaGenerator").setConcealed()
                        .setPages(new ResearchPage("tc.research_page.EtheralProcessor")).registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "EtheralProcessor",
                getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 1),
                9,
                new AspectList().add(Aspect.MECHANISM, 16).add(Aspect.CRAFT, 16).add(Aspect.ENERGY, 24)
                        .add(Aspect.MAGIC, 28).add(Aspect.MIND, 8),
                ItemList.Machine_MV_Macerator.get(1L),
                ItemList.Machine_MV_E_Furnace.get(1L),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9),
                OrePrefixes.plate.get(Materials.Thaumium),
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 0),
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 0),
                getModItem(Thaumcraft.ID, "blockWoodenDevice", 1, 0),
                OrePrefixes.plate.get(Materials.Thaumium),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 9));
        TCHelper.addResearchPage(
                "EtheralProcessor",
                new ResearchPage(TCHelper.findInfusionRecipe(getModItem(ElectroMagicTools.ID, "EMTMachines", 1, 1))));
        TCHelper.orphanResearch("ResearchCompleter");
        new ResearchItem(
                "ResearchCompleter",
                "EMT",
                new AspectList().add(Aspect.MIND, 8).add(Aspect.MECHANISM, 5).add(Aspect.EXCHANGE, 5)
                        .add(Aspect.AURA, 4),
                -2,
                6,
                1,
                ItemList.ResearchCompleter.get(1)).setParents("WANDPED", "WARDEDARCANA").setRound()
                        .setPages(new ResearchPage("tc.research_page.ResearchCompleter")).registerResearchItem();
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ResearchCompleter",
                ItemList.Casing_Magical.get(1L),
                new AspectList().add(Aspect.FIRE, 8).add(Aspect.AIR, 8).add(Aspect.ORDER, 8),
                "abc",
                "def",
                "ghi",
                'a',
                "plateThaumium",
                'b',
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
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
                getModItem(Thaumcraft.ID, "ItemResource", 1, 14),
                'i',
                "plateThaumium");
        TCHelper.addResearchPage(
                "ResearchCompleter",
                new ResearchPage(TCHelper.findArcaneRecipe(ItemList.Casing_Magical.get(1L))));
        ThaumcraftApi.addArcaneCraftingRecipe(
                "ResearchCompleter",
                ItemList.ResearchCompleter.get(1),
                new AspectList().add(Aspect.AIR, 50).add(Aspect.EARTH, 50).add(Aspect.FIRE, 50).add(Aspect.WATER, 50)
                        .add(Aspect.ORDER, 50).add(Aspect.ENTROPY, 50),
                "abc",
                "def",
                "ghi",
                'a',
                "circuitGood",
                'b',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'c',
                "circuitGood",
                'd',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'e',
                ItemList.Casing_Magical.get(1L),
                'f',
                getModItem(Thaumcraft.ID, "blockCosmeticOpaque", 1, 2),
                'g',
                "circuitGood",
                'h',
                getModItem(Thaumcraft.ID, "blockStoneDevice", 1, 5),
                'i',
                "circuitGood");
        TCHelper.addResearchPage(
                "ResearchCompleter",
                new ResearchPage(TCHelper.findArcaneRecipe(ItemList.ResearchCompleter.get(1))));
        TCHelper.orphanResearch("MagicalMaintenanceHatch");
        new ResearchItem(
                "MagicalMaintenanceHatch",
                "EMT",
                new AspectList().add(Aspect.MAGIC, 12).add(Aspect.MECHANISM, 8).add(Aspect.ELDRITCH, 6)
                        .add(TCAspects.AEQUALITAS.getAspect(), 6).add(TCAspects.NEBRISUM.getAspect(), 4),
                7,
                6,
                3,
                ItemList.MagicalMaintenanceHatch.get(1)).setParents("Wand Focus: Maintenance", "OCULUS", "VOIDMETAL")
                        .setConcealed().setPages(new ResearchPage("tc.research_page.MagicalMaintenanceHatch"))
                        .registerResearchItem();
        TCHelper.addInfusionCraftingRecipe(
                "MagicalMaintenanceHatch",
                ItemList.MagicalMaintenanceHatch.get(1),
                25,
                new AspectList().add(Aspect.AURA, 128).add(Aspect.MAGIC, 64).add(Aspect.MECHANISM, 48)
                        .add(Aspect.ELDRITCH, 32).add(TCAspects.AEQUALITAS.getAspect(), 32)
                        .add(TCAspects.NEBRISUM.getAspect(), 16),
                ItemList.Hatch_Maintenance.get(1L),
                getModItem(Thaumcraft.ID, "blockMetalDevice", 1, 2),
                getModItem(ElectroMagicTools.ID, "MaintenanceFocus", 1, 0),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                OrePrefixes.plateDouble.get(Materials.Void),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0),
                OrePrefixes.plateDouble.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                OrePrefixes.plateDouble.get(Materials.HSSG),
                ItemList.Cover_NeedsMaintainance.get(1),
                OrePrefixes.plateDouble.get(Materials.HSSG),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                OrePrefixes.plateDouble.get(Materials.Void),
                getModItem(Thaumcraft.ID, "ItemEldritchObject", 1, 0),
                OrePrefixes.plateDouble.get(Materials.Void),
                getModItem(Thaumcraft.ID, "blockCrystal", 1, 6),
                ItemList.Sensor_EV.get(1));
        TCHelper.addResearchPage(
                "MagicalMaintenanceHatch",
                new ResearchPage(TCHelper.findInfusionRecipe(ItemList.MagicalMaintenanceHatch.get(1))));
        ThaumcraftApi.addWarpToResearch("MagicalMaintenanceHatch", 3);
    }
}
